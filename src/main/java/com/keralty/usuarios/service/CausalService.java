package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Causal;
import com.keralty.usuarios.persistence.oid.CausalOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/CausalApi")
@RegisterRestClient(configKey="novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4novedades}")
public interface CausalService {

    /*
     * Returns an instance of Causal by ID
     *
     * @param causalidCausal Identification field causalidCausal
     *
     * @return Instance of Causal
     */
    @GET
    @Path("/{causalidCausal}")
    Causal getById(@PathParam("causalidCausal") Long causalidCausal);
    
    /*
     * Returns an instance of Causal by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Causal
     */
    @GET
    @Path("/getByOID")
    Causal getByOID(@RequestBody CausalOid oid);
    
    /*
     * Returns an instance of Causal by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Causal
     */
    @GET
    @Path("/getByOIDWithHV")
    Causal getByOIDWithHV(@RequestBody CausalOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
