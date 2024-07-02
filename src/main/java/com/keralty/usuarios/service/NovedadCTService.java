package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.NovedadCT;
import com.keralty.usuarios.persistence.oid.NovedadCTOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/NovedadCTApi")
@RegisterRestClient(configKey="novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4novedades}")
public interface NovedadCTService {

    /*
     * Returns an instance of NovedadCT by ID
     *
     * @param novedadCTidNovedadCT Identification field novedadCTidNovedadCT
     *
     * @return Instance of NovedadCT
     */
    @GET
    @Path("/{novedadCTidNovedadCT}")
    NovedadCT getById(@PathParam("novedadCTidNovedadCT") Long novedadCTidNovedadCT);
    
    /*
     * Returns an instance of NovedadCT by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadCT
     */
    @GET
    @Path("/getByOID")
    NovedadCT getByOID(@RequestBody NovedadCTOid oid);
    
    /*
     * Returns an instance of NovedadCT by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadCT
     */
    @GET
    @Path("/getByOIDWithHV")
    NovedadCT getByOIDWithHV(@RequestBody NovedadCTOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
