package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Municipio;
import com.keralty.aeusuarios.persistence.oid.MunicipioOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/MunicipioApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface MunicipioService {

    /*
     * Returns an instance of Municipio by ID
     *
     * @param municipioCodigo Identification field municipioCodigo
     *
     * @return Instance of Municipio
     */
    @GET
    @Path("/{municipioCodigo}")
    Municipio getById(@PathParam("municipioCodigo") Long municipioCodigo);
    
    /*
     * Returns an instance of Municipio by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Municipio
     */
    @GET
    @Path("/getByOID")
    Municipio getByOID(@RequestBody MunicipioOid oid);
    
    /*
     * Returns an instance of Municipio by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Municipio
     */
    @GET
    @Path("/getByOIDWithHV")
    Municipio getByOIDWithHV(@RequestBody MunicipioOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
