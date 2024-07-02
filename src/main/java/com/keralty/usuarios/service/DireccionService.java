package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Direccion;
import com.keralty.usuarios.persistence.oid.DireccionOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/DireccionApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
public interface DireccionService {

    /*
     * Returns an instance of Direccion by ID
     *
     * @param direccionIdentificador Identification field direccionIdentificador
     *
     * @return Instance of Direccion
     */
    @GET
    @Path("/{direccionIdentificador}")
    Direccion getById(@PathParam("direccionIdentificador") Long direccionIdentificador);
    
    /*
     * Returns an instance of Direccion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Direccion
     */
    @GET
    @Path("/getByOID")
    Direccion getByOID(@RequestBody DireccionOid oid);
    
    /*
     * Returns an instance of Direccion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Direccion
     */
    @GET
    @Path("/getByOIDWithHV")
    Direccion getByOIDWithHV(@RequestBody DireccionOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
