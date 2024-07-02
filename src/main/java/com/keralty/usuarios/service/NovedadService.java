package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Novedad;
import com.keralty.usuarios.persistence.oid.NovedadOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/NovedadApi")
@RegisterRestClient(configKey="novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4novedades}")
public interface NovedadService {

    /*
     * Returns an instance of Novedad by ID
     *
     * @param novedadidNovedad Identification field novedadidNovedad
     *
     * @return Instance of Novedad
     */
    @GET
    @Path("/{novedadidNovedad}")
    Novedad getById(@PathParam("novedadidNovedad") Long novedadidNovedad);
    
    /*
     * Returns an instance of Novedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Novedad
     */
    @GET
    @Path("/getByOID")
    Novedad getByOID(@RequestBody NovedadOid oid);
    
    /*
     * Returns an instance of Novedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Novedad
     */
    @GET
    @Path("/getByOIDWithHV")
    Novedad getByOIDWithHV(@RequestBody NovedadOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
