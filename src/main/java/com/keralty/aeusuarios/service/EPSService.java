package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.EPS;
import com.keralty.aeusuarios.persistence.oid.EPSOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/EPSApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface EPSService {

    /*
     * Returns an instance of EPS by ID
     *
     * @param ePSCodigo Identification field ePSCodigo
     *
     * @return Instance of EPS
     */
    @GET
    @Path("/{ePSCodigo}")
    EPS getById(@PathParam("ePSCodigo") Long ePSCodigo);
    
    /*
     * Returns an instance of EPS by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EPS
     */
    @GET
    @Path("/getByOID")
    EPS getByOID(@RequestBody EPSOid oid);
    
    /*
     * Returns an instance of EPS by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EPS
     */
    @GET
    @Path("/getByOIDWithHV")
    EPS getByOIDWithHV(@RequestBody EPSOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
