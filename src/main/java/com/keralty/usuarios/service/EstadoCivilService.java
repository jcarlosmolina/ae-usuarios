package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.EstadoCivil;
import com.keralty.usuarios.persistence.oid.EstadoCivilOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/EstadoCivilApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
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
