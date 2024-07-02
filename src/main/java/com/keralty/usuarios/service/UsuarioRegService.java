package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.UsuarioRegOid;
import com.keralty.usuarios.persistence.UsuarioReg;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/UsuarioRegApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
public interface UsuarioRegService {

    /*
     * Returns an instance of UsuarioReg by ID
     *
     * @param aESOLICITUDESIDSOLICITUD Identification field aESOLICITUDESIDSOLICITUD
     *
     * @param usuarioRegIdentificador Identification field usuarioRegIdentificador
     *
     * @return Instance of UsuarioReg
     */
    @GET
    @Path("/{aESOLICITUDESIDSOLICITUD}/{usuarioRegIdentificador}")
    UsuarioReg getById(@PathParam("aESOLICITUDESIDSOLICITUD") Long aESOLICITUDESIDSOLICITUD, @PathParam("usuarioRegIdentificador") Long usuarioRegIdentificador);
    
    /*
     * Returns an instance of UsuarioReg by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioReg
     */
    @GET
    @Path("/getByOID")
    UsuarioReg getByOID(@RequestBody UsuarioRegOid oid);
    
    /*
     * Returns an instance of UsuarioReg by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioReg
     */
    @GET
    @Path("/getByOIDWithHV")
    UsuarioReg getByOIDWithHV(@RequestBody UsuarioRegOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
