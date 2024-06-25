package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.CausaExclusion;
import com.keralty.aeusuarios.persistence.oid.CausaExclusionOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/CausaExclusionApi")
@RegisterRestClient(configKey="ae-novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aenovedades}")
public interface CausaExclusionService {

    /*
     * Returns an instance of CausaExclusion by ID
     *
     * @param causaExclusionidCausaExclusion Identification field causaExclusionidCausaExclusion
     *
     * @return Instance of CausaExclusion
     */
    @GET
    @Path("/{causaExclusionidCausaExclusion}")
    CausaExclusion getById(@PathParam("causaExclusionidCausaExclusion") Long causaExclusionidCausaExclusion);
    
    /*
     * Returns an instance of CausaExclusion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CausaExclusion
     */
    @GET
    @Path("/getByOID")
    CausaExclusion getByOID(@RequestBody CausaExclusionOid oid);
    
    /*
     * Returns an instance of CausaExclusion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CausaExclusion
     */
    @GET
    @Path("/getByOIDWithHV")
    CausaExclusion getByOIDWithHV(@RequestBody CausaExclusionOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
