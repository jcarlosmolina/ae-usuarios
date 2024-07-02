package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PlantillaReporteOid;
import com.keralty.usuarios.persistence.PlantillaReporte;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PlantillaReporteApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface PlantillaReporteService {

    /*
     * Returns an instance of PlantillaReporte by ID
     *
     * @param plantillaReporteidPlantillaReporte Identification field plantillaReporteidPlantillaReporte
     *
     * @return Instance of PlantillaReporte
     */
    @GET
    @Path("/{plantillaReporteidPlantillaReporte}")
    PlantillaReporte getById(@PathParam("plantillaReporteidPlantillaReporte") Long plantillaReporteidPlantillaReporte);
    
    /*
     * Returns an instance of PlantillaReporte by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PlantillaReporte
     */
    @GET
    @Path("/getByOID")
    PlantillaReporte getByOID(@RequestBody PlantillaReporteOid oid);
    
    /*
     * Returns an instance of PlantillaReporte by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PlantillaReporte
     */
    @GET
    @Path("/getByOIDWithHV")
    PlantillaReporte getByOIDWithHV(@RequestBody PlantillaReporteOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
