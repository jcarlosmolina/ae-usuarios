package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PlantillaEmailOid;
import com.keralty.usuarios.persistence.PlantillaEmail;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PlantillaEmailApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
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
