package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.ReportesDominioOid;
import com.keralty.aeusuarios.persistence.ReportesDominio;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/ReportesDominioApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface ReportesDominioService {

    /*
     * Returns an instance of ReportesDominio by ID
     *
     * @param dominioNumero Identification field dominioNumero
     *
     * @param plantillaReporteidPlantillaReporte Identification field plantillaReporteidPlantillaReporte
     *
     * @return Instance of ReportesDominio
     */
    @GET
    @Path("/{dominioNumero}/{plantillaReporteidPlantillaReporte}")
    ReportesDominio getById(@PathParam("dominioNumero") Long dominioNumero, @PathParam("plantillaReporteidPlantillaReporte") Long plantillaReporteidPlantillaReporte);
    
    /*
     * Returns an instance of ReportesDominio by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ReportesDominio
     */
    @GET
    @Path("/getByOID")
    ReportesDominio getByOID(@RequestBody ReportesDominioOid oid);
    
    /*
     * Returns an instance of ReportesDominio by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ReportesDominio
     */
    @GET
    @Path("/getByOIDWithHV")
    ReportesDominio getByOIDWithHV(@RequestBody ReportesDominioOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
