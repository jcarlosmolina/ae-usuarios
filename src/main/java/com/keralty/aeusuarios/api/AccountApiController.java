package com.keralty.aeusuarios.api;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import com.keralty.aeusuarios.security.UserAuthenticationService;
import com.keralty.aeusuarios.security.User;
import com.keralty.aeusuarios.viewmodel.LoginRequest;
import com.keralty.aeusuarios.viewmodel.UserInfoViewModel;
import io.quarkus.security.UnauthorizedException;

@Path("/")
@RequestScoped
public class AccountApiController {

    @Inject
    UserAuthenticationService authenticationService;

    @Inject
    JsonWebToken jwt; 

    @POST
    @Path("/Token")
    @Produces(MediaType.TEXT_PLAIN)
    public RestResponse<String> login(LoginRequest loginRequest) {
        Optional<String> token = authenticationService.login(loginRequest);
        if (token.isPresent()) {
            return ResponseBuilder.ok("\"" + token.get() + "\"", MediaType.TEXT_PLAIN_TYPE).build();
        } else {
            throw new UnauthorizedException();
        }
    }

    @POST
    @Path("/api/Account/Logout")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public boolean logout(User user) {
        authenticationService.logout(user);
        return true;
    }

    @POST
    @Path("/api/Account/UserInfo")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public UserInfoViewModel getUserInfo(@Context SecurityContext sec) {
        UserInfoViewModel userInfo = new UserInfoViewModel();
        Principal principal = sec.getUserPrincipal();
        if (principal != null){
            String userRoles = jwt.getGroups().stream().collect(Collectors.joining(","));
            userInfo = new UserInfoViewModel(principal.getName(), userRoles);
            userInfo.setGridPreferences(new ArrayList<>());
        }
        return userInfo;
    }
    
    @POST
    @Path("/api/Account/AnonymousUserInfo")
    public UserInfoViewModel getAnonymousUserInfo() {
        return new UserInfoViewModel("", "");
    }
}
