package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.EstadoPersona;
import com.keralty.aeusuarios.persistence.oid.EstadoPersonaOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/EstadoPersonaApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface EstadoPersonaService {

    /*
     * Returns an instance of EstadoPersona by ID
     *
     * @param estadoPersonaCodigo Identification field estadoPersonaCodigo
     *
     * @return Instance of EstadoPersona
     */
    @GET
    @Path("/{estadoPersonaCodigo}")
    EstadoPersona getById(@PathParam("estadoPersonaCodigo") Long estadoPersonaCodigo);
    
    /*
     * Returns an instance of EstadoPersona by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoPersona
     */
    @GET
    @Path("/getByOID")
    EstadoPersona getByOID(@RequestBody EstadoPersonaOid oid);
    
    /*
     * Returns an instance of EstadoPersona by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoPersona
     */
    @GET
    @Path("/getByOIDWithHV")
    EstadoPersona getByOIDWithHV(@RequestBody EstadoPersonaOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
