package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.DocumentoG;
import com.keralty.usuarios.persistence.oid.DocumentoGOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/DocumentoGApi")
@RegisterRestClient(configKey="solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4solicitudes}")
public interface DocumentoGService {

    /*
     * Returns an instance of DocumentoG by ID
     *
     * @param documentoGIdentificador Identification field documentoGIdentificador
     *
     * @return Instance of DocumentoG
     */
    @GET
    @Path("/{documentoGIdentificador}")
    DocumentoG getById(@PathParam("documentoGIdentificador") Long documentoGIdentificador);
    
    /*
     * Returns an instance of DocumentoG by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DocumentoG
     */
    @GET
    @Path("/getByOID")
    DocumentoG getByOID(@RequestBody DocumentoGOid oid);
    
    /*
     * Returns an instance of DocumentoG by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of DocumentoG
     */
    @GET
    @Path("/getByOIDWithHV")
    DocumentoG getByOIDWithHV(@RequestBody DocumentoGOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
