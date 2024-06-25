package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.PersonaOid;
import com.keralty.aeusuarios.persistence.Persona;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PersonaApi")
@RegisterRestClient(configKey="ae-personas-afiliados-contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aepersonasafiliadoscontratantes}")
public interface PersonaService {

    /*
     * Returns an instance of Persona by ID
     *
     * @param personaIdentificador Identification field personaIdentificador
     *
     * @return Instance of Persona
     */
    @GET
    @Path("/{personaIdentificador}")
    Persona getById(@PathParam("personaIdentificador") Long personaIdentificador);
    
    /*
     * Returns an instance of Persona by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Persona
     */
    @GET
    @Path("/getByOID")
    Persona getByOID(@RequestBody PersonaOid oid);
    
    /*
     * Returns an instance of Persona by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Persona
     */
    @GET
    @Path("/getByOIDWithHV")
    Persona getByOIDWithHV(@RequestBody PersonaOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
