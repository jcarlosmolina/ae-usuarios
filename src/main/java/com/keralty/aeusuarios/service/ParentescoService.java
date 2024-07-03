package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.ParentescoOid;
import com.keralty.aeusuarios.persistence.Parentesco;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/ParentescoApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface ParentescoService {

    /*
     * Returns an instance of Parentesco by ID
     *
     * @param parentescoCodigo Identification field parentescoCodigo
     *
     * @return Instance of Parentesco
     */
    @GET
    @Path("/{parentescoCodigo}")
    Parentesco getById(@PathParam("parentescoCodigo") Long parentescoCodigo);
    
    /*
     * Returns an instance of Parentesco by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Parentesco
     */
    @GET
    @Path("/getByOID")
    Parentesco getByOID(@RequestBody ParentescoOid oid);
    
    /*
     * Returns an instance of Parentesco by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Parentesco
     */
    @GET
    @Path("/getByOIDWithHV")
    Parentesco getByOIDWithHV(@RequestBody ParentescoOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
