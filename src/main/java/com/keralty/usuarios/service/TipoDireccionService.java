package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.TipoDireccionOid;
import com.keralty.usuarios.persistence.TipoDireccion;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/TipoDireccionApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface TipoDireccionService {

    /*
     * Returns an instance of TipoDireccion by ID
     *
     * @param tipoDireccionCodigo Identification field tipoDireccionCodigo
     *
     * @return Instance of TipoDireccion
     */
    @GET
    @Path("/{tipoDireccionCodigo}")
    TipoDireccion getById(@PathParam("tipoDireccionCodigo") Long tipoDireccionCodigo);
    
    /*
     * Returns an instance of TipoDireccion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoDireccion
     */
    @GET
    @Path("/getByOID")
    TipoDireccion getByOID(@RequestBody TipoDireccionOid oid);
    
    /*
     * Returns an instance of TipoDireccion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoDireccion
     */
    @GET
    @Path("/getByOIDWithHV")
    TipoDireccion getByOIDWithHV(@RequestBody TipoDireccionOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
