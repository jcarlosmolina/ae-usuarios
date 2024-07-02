package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PaisOid;
import com.keralty.usuarios.persistence.Pais;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PaisApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface PaisService {

    /*
     * Returns an instance of Pais by ID
     *
     * @param paisCodigo Identification field paisCodigo
     *
     * @return Instance of Pais
     */
    @GET
    @Path("/{paisCodigo}")
    Pais getById(@PathParam("paisCodigo") String paisCodigo);
    
    /*
     * Returns an instance of Pais by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pais
     */
    @GET
    @Path("/getByOID")
    Pais getByOID(@RequestBody PaisOid oid);
    
    /*
     * Returns an instance of Pais by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Pais
     */
    @GET
    @Path("/getByOIDWithHV")
    Pais getByOIDWithHV(@RequestBody PaisOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
