package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.PlantillaEmailOid;
import com.keralty.aeusuarios.persistence.PlantillaEmail;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PlantillaEmailApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface PlantillaEmailService {

    /*
     * Returns an instance of PlantillaEmail by ID
     *
     * @param plantillaEmailIdPlantilla Identification field plantillaEmailIdPlantilla
     *
     * @return Instance of PlantillaEmail
     */
    @GET
    @Path("/{plantillaEmailIdPlantilla}")
    PlantillaEmail getById(@PathParam("plantillaEmailIdPlantilla") Long plantillaEmailIdPlantilla);
    
    /*
     * Returns an instance of PlantillaEmail by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PlantillaEmail
     */
    @GET
    @Path("/getByOID")
    PlantillaEmail getByOID(@RequestBody PlantillaEmailOid oid);
    
    /*
     * Returns an instance of PlantillaEmail by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PlantillaEmail
     */
    @GET
    @Path("/getByOIDWithHV")
    PlantillaEmail getByOIDWithHV(@RequestBody PlantillaEmailOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
