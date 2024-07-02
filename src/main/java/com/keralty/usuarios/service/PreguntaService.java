package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PreguntaOid;
import com.keralty.usuarios.persistence.Pregunta;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PreguntaApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface PreguntaService {

    /*
     * Returns an instance of Pregunta by ID
     *
     * @param preguntaNumero Identification field preguntaNumero
     *
     * @return Instance of Pregunta
     */
    @GET
    @Path("/{preguntaNumero}")
    Pregunta getById(@PathParam("preguntaNumero") Long preguntaNumero);
    
    /*
     * Returns an instance of Pregunta by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pregunta
     */
    @GET
    @Path("/getByOID")
    Pregunta getByOID(@RequestBody PreguntaOid oid);
    
    /*
     * Returns an instance of Pregunta by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pregunta
     */
    @GET
    @Path("/getByOIDWithHV")
    Pregunta getByOIDWithHV(@RequestBody PreguntaOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
