package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.EstadoCivil;
import com.keralty.aeusuarios.persistence.oid.EstadoCivilOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/EstadoCivilApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface EstadoCivilService {

    /*
     * Returns an instance of EstadoCivil by ID
     *
     * @param estadoCivilCodigo Identification field estadoCivilCodigo
     *
     * @return Instance of EstadoCivil
     */
    @GET
    @Path("/{estadoCivilCodigo}")
    EstadoCivil getById(@PathParam("estadoCivilCodigo") Long estadoCivilCodigo);
    
    /*
     * Returns an instance of EstadoCivil by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoCivil
     */
    @GET
    @Path("/getByOID")
    EstadoCivil getByOID(@RequestBody EstadoCivilOid oid);
    
    /*
     * Returns an instance of EstadoCivil by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoCivil
     */
    @GET
    @Path("/getByOIDWithHV")
    EstadoCivil getByOIDWithHV(@RequestBody EstadoCivilOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
