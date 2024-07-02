package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PersonaCOid;
import com.keralty.usuarios.persistence.PersonaC;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PersonaCApi")
@RegisterRestClient(configKey="solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4solicitudes}")
public interface PersonaCService {

    /*
     * Returns an instance of PersonaC by ID
     *
     * @param personaCID Identification field personaCID
     *
     * @return Instance of PersonaC
     */
    @GET
    @Path("/{personaCID}")
    PersonaC getById(@PathParam("personaCID") Long personaCID);
    
    /*
     * Returns an instance of PersonaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PersonaC
     */
    @GET
    @Path("/getByOID")
    PersonaC getByOID(@RequestBody PersonaCOid oid);
    
    /*
     * Returns an instance of PersonaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PersonaC
     */
    @GET
    @Path("/getByOIDWithHV")
    PersonaC getByOIDWithHV(@RequestBody PersonaCOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
