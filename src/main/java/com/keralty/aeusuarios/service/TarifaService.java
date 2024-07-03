package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.TarifaOid;
import com.keralty.aeusuarios.persistence.Tarifa;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/TarifaApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface TarifaService {

    /*
     * Returns an instance of Tarifa by ID
     *
     * @param tarifaId Identification field tarifaId
     *
     * @return Instance of Tarifa
     */
    @GET
    @Path("/{tarifaId}")
    Tarifa getById(@PathParam("tarifaId") Long tarifaId);
    
    /*
     * Returns an instance of Tarifa by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Tarifa
     */
    @GET
    @Path("/getByOID")
    Tarifa getByOID(@RequestBody TarifaOid oid);
    
    /*
     * Returns an instance of Tarifa by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Tarifa
     */
    @GET
    @Path("/getByOIDWithHV")
    Tarifa getByOIDWithHV(@RequestBody TarifaOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
