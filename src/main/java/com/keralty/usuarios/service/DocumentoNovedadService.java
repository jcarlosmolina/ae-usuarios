package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.DocumentoNovedad;
import com.keralty.usuarios.persistence.oid.DocumentoNovedadOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/DocumentoNovedadApi")
@RegisterRestClient(configKey="novedades")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4novedades}")
public interface DocumentoNovedadService {

    /*
     * Returns an instance of DocumentoNovedad by ID
     *
     * @param documentoNovedadIdDocumento Identification field documentoNovedadIdDocumento
     *
     * @return Instance of DocumentoNovedad
     */
    @GET
    @Path("/{documentoNovedadIdDocumento}")
    DocumentoNovedad getById(@PathParam("documentoNovedadIdDocumento") Long documentoNovedadIdDocumento);
    
    /*
     * Returns an instance of DocumentoNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DocumentoNovedad
     */
    @GET
    @Path("/getByOID")
    DocumentoNovedad getByOID(@RequestBody DocumentoNovedadOid oid);
    
    /*
     * Returns an instance of DocumentoNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DocumentoNovedad
     */
    @GET
    @Path("/getByOIDWithHV")
    DocumentoNovedad getByOIDWithHV(@RequestBody DocumentoNovedadOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
