package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.TipoNovedadOid;
import com.keralty.aeusuarios.persistence.TipoNovedad;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/TipoNovedadApi")
@RegisterRestClient(configKey="ae-novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aenovedades}")
public interface TipoNovedadService {

    /*
     * Returns an instance of TipoNovedad by ID
     *
     * @param tipoNovedadTipo Identification field tipoNovedadTipo
     *
     * @return Instance of TipoNovedad
     */
    @GET
    @Path("/{tipoNovedadTipo}")
    TipoNovedad getById(@PathParam("tipoNovedadTipo") Long tipoNovedadTipo);
    
    /*
     * Returns an instance of TipoNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoNovedad
     */
    @GET
    @Path("/getByOID")
    TipoNovedad getByOID(@RequestBody TipoNovedadOid oid);
    
    /*
     * Returns an instance of TipoNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoNovedad
     */
    @GET
    @Path("/getByOIDWithHV")
    TipoNovedad getByOIDWithHV(@RequestBody TipoNovedadOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
