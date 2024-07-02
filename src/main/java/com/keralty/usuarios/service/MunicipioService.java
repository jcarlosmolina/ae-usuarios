package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Municipio;
import com.keralty.usuarios.persistence.oid.MunicipioOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/MunicipioApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
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
