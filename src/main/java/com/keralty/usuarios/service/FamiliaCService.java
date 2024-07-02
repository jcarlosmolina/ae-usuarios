package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.FamiliaC;
import com.keralty.usuarios.persistence.oid.FamiliaCOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/FamiliaCApi")
@RegisterRestClient(configKey="solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4solicitudes}")
public interface FamiliaCService {

    /*
     * Returns an instance of FamiliaC by ID
     *
     * @param contratoCContratoCID Identification field contratoCContratoCID
     *
     * @param familiaCID Identification field familiaCID
     *
     * @return Instance of FamiliaC
     */
    @GET
    @Path("/{contratoCContratoCID}/{familiaCID}")
    FamiliaC getById(@PathParam("contratoCContratoCID") Long contratoCContratoCID, @PathParam("familiaCID") Long familiaCID);
    
    /*
     * Returns an instance of FamiliaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaC
     */
    @GET
    @Path("/getByOID")
    FamiliaC getByOID(@RequestBody FamiliaCOid oid);
    
    /*
     * Returns an instance of FamiliaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaC
     */
    @GET
    @Path("/getByOIDWithHV")
    FamiliaC getByOIDWithHV(@RequestBody FamiliaCOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
