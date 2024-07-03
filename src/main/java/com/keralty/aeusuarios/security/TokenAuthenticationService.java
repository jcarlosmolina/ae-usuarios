package com.keralty.aeusuarios.security;

import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
 
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.viewmodel.UserInfoViewModel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Objects;
import java.util.Optional;

import com.keralty.aeusuarios.utils.Utilities;
import com.keralty.aeusuarios.viewmodel.LoginRequest;

@ApplicationScoped
public class TokenAuthenticationService implements UserAuthenticationService {

    @Inject
    TokenService tokens;

    @Inject
    UserCrudService users;

    @Inject
    UserFunctions userFunctions;

    @Override
    public Optional<String> login(String username, String password) {
        Optional<User> user = users.findByUsername(username);
        if (user.isPresent()) {
            return user.filter(u -> Objects.equals(Utilities.encrypt(password), u.getPassword()))
                    .map(u -> tokens.issue(u));
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> login(LoginRequest loginRequest){
    	Optional<User> user = loginRequest.getFacetname() == null || loginRequest.getFacetname().isEmpty()
    						? users.findByUsername(loginRequest.getUsername()) 
    						: users.findByFacetAndUsername(loginRequest.getFacetname(), loginRequest.getUsername());
        if (user.isPresent()) {
            return user.filter(u -> Objects.equals(Utilities.encrypt(loginRequest.getPassword()), u.getPassword()))
                    .map(u -> tokens.issue(u));
        }
    	return Optional.empty();
    }

    @Override
    public UserInfoViewModel loginAzure(LoginRequest loginRequest){
    	
    	// Recibimos el token de Entra Id
    	// Extraemos la informacion del token
    	
    	UserInfoViewModel userInfo = new UserInfoViewModel();
    	// Si no ha llegado la informacion del token Entra ID
    	if (loginRequest.getUsername() == null || loginRequest.getUsername() == "") {
    		userInfo.setErrorCode("001");
    		return userInfo; 
    	}
    	
    	// Validamos el token recibido
    	if (!TokenAuthenticationService.validateIDToken(loginRequest.getUsername())) {
    		userInfo.setErrorCode("010");
    		return userInfo;
    	}
    	
    	String[] trozos = loginRequest.getUsername().split("\\.");
    	
    	// Si no tiene las 3 partes ...
    	if (trozos.length != 3) {
    		userInfo.setErrorCode("020");
    		return userInfo;
    	}
    	
    	Base64.Decoder decoder = Base64.getUrlDecoder();

    	// String header = new String(decoder.decode(trozos[0]));
    	String payload = new String(decoder.decode(trozos[1]));
    	// String signature = new String(decoder.decode(trozos[2]));
    	
    	
    	JsonObject payloadJson = new Gson().fromJson(payload, JsonObject.class);
		if (payloadJson == null) {
    		userInfo.setErrorCode("030");
			return userInfo;
		}
    	
		JsonArray roles = payloadJson.getAsJsonArray("roles");
    	if (roles == null || roles.size() == 0) {
    		userInfo.setErrorCode("040");
    		return userInfo;
    	}
    	
        boolean esSuperAdmin = false;
        boolean esAdmin = false;
        String role = "";
        for(JsonElement rol : roles) {
        	String rolString = rol.getAsString();
            if (rolString.equals("SUPERADMINISTRADOR")){
            	esSuperAdmin= true;
            	break;
            }
            if (rolString.equals("ADMIN")){
            	esAdmin= true;
            }                    	
         }
        if (esSuperAdmin)
        	role = "SUPERADMIN";
        else if (esAdmin)
        	role = "ADMIN";
        else
        	role = roles.get(0).getAsString();
    
        // En el claims "prefered_username" encontraremos el valor a utiilzar para localizar al usuario en AE. 
        // Lo que era en la anterior versión el campo "UsuarioLDAP"
        
        String usuarioLDAP = payloadJson.get("preferred_username") == null ? null : payloadJson.get("preferred_username").getAsString();
        if (usuarioLDAP == null) {
    		userInfo.setErrorCode("050");
    		return userInfo;
        }
        // Pasamos a mayusculas
        usuarioLDAP = usuarioLDAP.toUpperCase();
        
        String agentJsonOid = "";
        String agentId = "";
        String agentRole = "";
        
        // Si NO es asesor, verificamos o creamos al usuario 
        if (!"ASESOR COMERCIAL".equalsIgnoreCase(role) && !"JEFEASESORES".equalsIgnoreCase(role)) {
            String primerNombre = "COMPLETAR";
            String segundoNombre = null;
            String primerApellido = "COMPLETAR";
            String segundoApellido = null;
            String email = "COMPLETAR";

            // Obtenemos nombre y correo electrónico de los claims
            String nombre = payloadJson.get("name") == null ? null : payloadJson.get("name").getAsString();
            if (nombre != null) {
    	        String[] partesNombre = nombre.split("\\s+");
    	        primerNombre = (partesNombre[0]).toUpperCase();
    	        segundoNombre = (partesNombre.length > 1 ? (partesNombre[1]).toUpperCase() : null);
    	        primerApellido = (partesNombre.length > 2 ? (partesNombre[2]).toUpperCase() : null);
    	        segundoApellido = (partesNombre.length > 3 ? (partesNombre[3]).toUpperCase() : null);
            }
            // Correo electrónico
            email = payloadJson.get("username") == null ? null : payloadJson.get("username").getAsString();
            
            // Llamamos al servicio global que verifica o añade al usuario
            //globalServices.tGVERIFICARUSUARIO(serCtx, role, userName, primerNombre, segundoNombre, primerApellido, segundoApellido, email);

        	Funcionario funcionario = userFunctions.fugetFuncionarioPorLDAPFun(usuarioLDAP);
        	if (funcionario == null || funcionario.isNull()) {
        		userInfo.setErrorCode("060");
        		return userInfo;
        	}
        	// Comprobamos que NO es un asesor
        	if (funcionario.getRol() == null || funcionario.getRol().isNull() || 
        		"ASESOR COMERCIAL".equalsIgnoreCase(funcionario.getRol().getRolNombre()) || 
        		"JEFEASESORES".equalsIgnoreCase(funcionario.getRol().getRolNombre())) {
        		userInfo.setErrorCode("070");
        		return userInfo;
        	}
        	agentJsonOid = funcionario.getOid().toJson();
        	agentId = funcionario.getFuncionarioId().toString();
        	agentRole = funcionario.getRol().getRolNombre();
        } else {
        	
        	// Los asesores comerciales deben existir, porque se sincroniza. 
        	// Si no figura en la BBDD como asesor no le permitimos el asesor
        	Asesor asesor = userFunctions.fugetAsesorFun(usuarioLDAP);
        	if (asesor == null || asesor.isNull()) {
        		userInfo.setErrorCode("080");
        		return userInfo;
        	}
        	// Comprobamos si realmente tenga ese rol
        	if ((asesor.getRol() == null || asesor.getRol().isNull()) || 
        		(!"ASESOR COMERCIAL".equalsIgnoreCase(asesor.getRol().getRolNombre()) && !"JEFEASESORES".equalsIgnoreCase(asesor.getRol().getRolNombre()))) {
        		userInfo.setErrorCode("090");
        		return userInfo;
        	}
        	agentJsonOid = asesor.getOid().toJson();
        	agentId = asesor.getFuncionarioId().toString();
        	agentRole = asesor.getRol().getRolNombre();
        }
        
        
        // userInfo.setEmail("[funcionarioId=" + "1" + "]");

    	Optional<User> user = users.findByFacetAndUsername("Funcionario", agentId);

   	
    	// Obtenemos el token y lo devolvemos
    	if (user.isPresent()) {
    		Optional<String> token =  user.map(u -> tokens.issue(u));
    		if (!token.isPresent()) {
        		userInfo.setErrorCode("100");
    			return userInfo;
    		}
    		userInfo.setToken(token.get());
    	} else {
    		userInfo.setErrorCode("110");
    		return userInfo;
    	}

        userInfo.setOidJson(agentJsonOid);
    	userInfo.setRoles(agentRole);
    	
    	userInfo.setHasRegistered(true);

    	return userInfo;
    }
    
    
    public static boolean validateIDToken(String idToken) {
        DecodedJWT jwt = JWT.decode(idToken);
 
        try {
            JwkProvider provider = new UrlJwkProvider(
                new URL("https://login.microsoftonline.com/common/discovery/v2.0/keys"));
            Jwk jwk = provider.get(jwt.getKeyId());
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
             
            //Invalid token will throw SignatureVerificationException
            algorithm.verify(jwt);
 
            //Validate expiry (not shown here)
            //...
 
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (JwkException e) {
            throw new RuntimeException(e);
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
 
            return false;
        }
    }

    @Override
    public void logout(User user) {
        // No additional logic
    }

}
