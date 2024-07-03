package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.UsuarioOid;
import com.keralty.aeusuarios.persistence.Usuario;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/UsuarioApi")
@RegisterRestClient(configKey="ae-personas-afiliados-contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aepersonasafiliadoscontratantes}")
public interface UsuarioService {

    /*
     * Returns an instance of Usuario by ID
     *
     * @param aESOLICITUDESIDSOLICITUD Identification field aESOLICITUDESIDSOLICITUD
     *
     * @param usuarioIdentificador Identification field usuarioIdentificador
     *
     * @return Instance of Usuario
     */
    @GET
    @Path("/{aESOLICITUDESIDSOLICITUD}/{usuarioIdentificador}")
    Usuario getById(@PathParam("aESOLICITUDESIDSOLICITUD") Long aESOLICITUDESIDSOLICITUD, @PathParam("usuarioIdentificador") Long usuarioIdentificador);
    
    /*
     * Returns an instance of Usuario by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Usuario
     */
    @GET
    @Path("/getByOID")
    Usuario getByOID(@RequestBody UsuarioOid oid);
    
    /*
     * Returns an instance of Usuario by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Usuario
     */
    @GET
    @Path("/getByOIDWithHV")
    Usuario getByOIDWithHV(@RequestBody UsuarioOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
