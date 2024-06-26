package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.EstadoContrato;
import com.keralty.aeusuarios.persistence.oid.EstadoContratoOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/EstadoContratoApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface EstadoContratoService {

    /*
     * Returns an instance of EstadoContrato by ID
     *
     * @param estadoContratoCodigo Identification field estadoContratoCodigo
     *
     * @return Instance of EstadoContrato
     */
    @GET
    @Path("/{estadoContratoCodigo}")
    EstadoContrato getById(@PathParam("estadoContratoCodigo") Long estadoContratoCodigo);
    
    /*
     * Returns an instance of EstadoContrato by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoContrato
     */
    @GET
    @Path("/getByOID")
    EstadoContrato getByOID(@RequestBody EstadoContratoOid oid);
    
    /*
     * Returns an instance of EstadoContrato by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoContrato
     */
    @GET
    @Path("/getByOIDWithHV")
    EstadoContrato getByOIDWithHV(@RequestBody EstadoContratoOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
