package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.ProteccionDatosOid;
import com.keralty.usuarios.persistence.ProteccionDatos;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/ProteccionDatosApi")
@RegisterRestClient(configKey="solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4solicitudes}")
public interface ProteccionDatosService {

    /*
     * Returns an instance of ProteccionDatos by ID
     *
     * @param proteccionDatosIdentificador Identification field proteccionDatosIdentificador
     *
     * @return Instance of ProteccionDatos
     */
    @GET
    @Path("/{proteccionDatosIdentificador}")
    ProteccionDatos getById(@PathParam("proteccionDatosIdentificador") Long proteccionDatosIdentificador);
    
    /*
     * Returns an instance of ProteccionDatos by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatos
     */
    @GET
    @Path("/getByOID")
    ProteccionDatos getByOID(@RequestBody ProteccionDatosOid oid);
    
    /*
     * Returns an instance of ProteccionDatos by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ProteccionDatos
     */
    @GET
    @Path("/getByOIDWithHV")
    ProteccionDatos getByOIDWithHV(@RequestBody ProteccionDatosOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
