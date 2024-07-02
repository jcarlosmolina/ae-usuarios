package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.GrupoAsociado;
import com.keralty.usuarios.persistence.oid.GrupoAsociadoOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/GrupoAsociadoApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface GrupoAsociadoService {

    /*
     * Returns an instance of GrupoAsociado by ID
     *
     * @param grupoAsociadoCodigo Identification field grupoAsociadoCodigo
     *
     * @return Instance of GrupoAsociado
     */
    @GET
    @Path("/{grupoAsociadoCodigo}")
    GrupoAsociado getById(@PathParam("grupoAsociadoCodigo") Long grupoAsociadoCodigo);
    
    /*
     * Returns an instance of GrupoAsociado by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of GrupoAsociado
     */
    @GET
    @Path("/getByOID")
    GrupoAsociado getByOID(@RequestBody GrupoAsociadoOid oid);
    
    /*
     * Returns an instance of GrupoAsociado by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of GrupoAsociado
     */
    @GET
    @Path("/getByOIDWithHV")
    GrupoAsociado getByOIDWithHV(@RequestBody GrupoAsociadoOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
