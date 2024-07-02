package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.DetalleTarifa;
import com.keralty.usuarios.persistence.oid.DetalleTarifaOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/DetalleTarifaApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface DetalleTarifaService {

    /*
     * Returns an instance of DetalleTarifa by ID
     *
     * @param detalleTarifaidDetalleTarifa Identification field detalleTarifaidDetalleTarifa
     *
     * @return Instance of DetalleTarifa
     */
    @GET
    @Path("/{detalleTarifaidDetalleTarifa}")
    DetalleTarifa getById(@PathParam("detalleTarifaidDetalleTarifa") Long detalleTarifaidDetalleTarifa);
    
    /*
     * Returns an instance of DetalleTarifa by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DetalleTarifa
     */
    @GET
    @Path("/getByOID")
    DetalleTarifa getByOID(@RequestBody DetalleTarifaOid oid);
    
    /*
     * Returns an instance of DetalleTarifa by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DetalleTarifa
     */
    @GET
    @Path("/getByOIDWithHV")
    DetalleTarifa getByOIDWithHV(@RequestBody DetalleTarifaOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
