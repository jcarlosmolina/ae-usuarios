package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.BeneficiarioC;
import com.keralty.aeusuarios.persistence.oid.BeneficiarioCOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/BeneficiarioCApi")
@RegisterRestClient(configKey="ae-solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aesolicitudes}")
public interface BeneficiarioCService {

    /*
     * Returns an instance of BeneficiarioC by ID
     *
     * @param contratoCContratoCID Identification field contratoCContratoCID
     *
     * @param beneficiarioCID Identification field beneficiarioCID
     *
     * @return Instance of BeneficiarioC
     */
    @GET
    @Path("/{contratoCContratoCID}/{beneficiarioCID}")
    BeneficiarioC getById(@PathParam("contratoCContratoCID") Long contratoCContratoCID, @PathParam("beneficiarioCID") Long beneficiarioCID);
    
    /*
     * Returns an instance of BeneficiarioC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of BeneficiarioC
     */
    @GET
    @Path("/getByOID")
    BeneficiarioC getByOID(@RequestBody BeneficiarioCOid oid);
    
    /*
     * Returns an instance of BeneficiarioC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of BeneficiarioC
     */
    @GET
    @Path("/getByOIDWithHV")
    BeneficiarioC getByOIDWithHV(@RequestBody BeneficiarioCOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
