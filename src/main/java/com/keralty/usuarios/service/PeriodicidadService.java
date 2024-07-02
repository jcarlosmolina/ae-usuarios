package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PeriodicidadOid;
import com.keralty.usuarios.persistence.Periodicidad;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PeriodicidadApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface PeriodicidadService {

    /*
     * Returns an instance of Periodicidad by ID
     *
     * @param periodicidadCodigo Identification field periodicidadCodigo
     *
     * @return Instance of Periodicidad
     */
    @GET
    @Path("/{periodicidadCodigo}")
    Periodicidad getById(@PathParam("periodicidadCodigo") Long periodicidadCodigo);
    
    /*
     * Returns an instance of Periodicidad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Periodicidad
     */
    @GET
    @Path("/getByOID")
    Periodicidad getByOID(@RequestBody PeriodicidadOid oid);
    
    /*
     * Returns an instance of Periodicidad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Periodicidad
     */
    @GET
    @Path("/getByOIDWithHV")
    Periodicidad getByOIDWithHV(@RequestBody PeriodicidadOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
