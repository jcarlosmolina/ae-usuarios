package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.FamiliaNovedad;
import com.keralty.usuarios.persistence.oid.FamiliaNovedadOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/FamiliaNovedadApi")
@RegisterRestClient(configKey="novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4novedades}")
public interface FamiliaNovedadService {

    /*
     * Returns an instance of FamiliaNovedad by ID
     *
     * @param familiaNovedadidFamiliaNovedad Identification field familiaNovedadidFamiliaNovedad
     *
     * @return Instance of FamiliaNovedad
     */
    @GET
    @Path("/{familiaNovedadidFamiliaNovedad}")
    FamiliaNovedad getById(@PathParam("familiaNovedadidFamiliaNovedad") Long familiaNovedadidFamiliaNovedad);
    
    /*
     * Returns an instance of FamiliaNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaNovedad
     */
    @GET
    @Path("/getByOID")
    FamiliaNovedad getByOID(@RequestBody FamiliaNovedadOid oid);
    
    /*
     * Returns an instance of FamiliaNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaNovedad
     */
    @GET
    @Path("/getByOIDWithHV")
    FamiliaNovedad getByOIDWithHV(@RequestBody FamiliaNovedadOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
