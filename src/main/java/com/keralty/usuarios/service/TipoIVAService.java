package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.TipoIVAOid;
import com.keralty.usuarios.persistence.TipoIVA;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/TipoIVAApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface TipoIVAService {

    /*
     * Returns an instance of TipoIVA by ID
     *
     * @param tipoIVACodigo Identification field tipoIVACodigo
     *
     * @return Instance of TipoIVA
     */
    @GET
    @Path("/{tipoIVACodigo}")
    TipoIVA getById(@PathParam("tipoIVACodigo") Long tipoIVACodigo);
    
    /*
     * Returns an instance of TipoIVA by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoIVA
     */
    @GET
    @Path("/getByOID")
    TipoIVA getByOID(@RequestBody TipoIVAOid oid);
    
    /*
     * Returns an instance of TipoIVA by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoIVA
     */
    @GET
    @Path("/getByOIDWithHV")
    TipoIVA getByOIDWithHV(@RequestBody TipoIVAOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
