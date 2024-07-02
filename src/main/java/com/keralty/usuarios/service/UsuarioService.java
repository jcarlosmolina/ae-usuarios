package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.UsuarioOid;
import com.keralty.usuarios.persistence.Usuario;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/UsuarioApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
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
