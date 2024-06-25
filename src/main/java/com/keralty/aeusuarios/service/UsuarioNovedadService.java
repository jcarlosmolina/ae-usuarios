package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.UsuarioNovedadOid;
import com.keralty.aeusuarios.persistence.UsuarioNovedad;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/UsuarioNovedadApi")
@RegisterRestClient(configKey="ae-novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aenovedades}")
public interface UsuarioNovedadService {

    /*
     * Returns an instance of UsuarioNovedad by ID
     *
     * @param usuarioNovedadidUsuarioNovedad Identification field usuarioNovedadidUsuarioNovedad
     *
     * @return Instance of UsuarioNovedad
     */
    @GET
    @Path("/{usuarioNovedadidUsuarioNovedad}")
    UsuarioNovedad getById(@PathParam("usuarioNovedadidUsuarioNovedad") Long usuarioNovedadidUsuarioNovedad);
    
    /*
     * Returns an instance of UsuarioNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioNovedad
     */
    @GET
    @Path("/getByOID")
    UsuarioNovedad getByOID(@RequestBody UsuarioNovedadOid oid);
    
    /*
     * Returns an instance of UsuarioNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioNovedad
     */
    @GET
    @Path("/getByOIDWithHV")
    UsuarioNovedad getByOIDWithHV(@RequestBody UsuarioNovedadOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
