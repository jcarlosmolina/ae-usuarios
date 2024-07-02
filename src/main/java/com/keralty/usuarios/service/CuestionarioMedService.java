package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.CuestionarioMed;
import com.keralty.usuarios.persistence.oid.CuestionarioMedOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/CuestionarioMedApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface CuestionarioMedService {

    /*
     * Returns an instance of CuestionarioMed by ID
     *
     * @param cuestionarioMedNumero Identification field cuestionarioMedNumero
     *
     * @return Instance of CuestionarioMed
     */
    @GET
    @Path("/{cuestionarioMedNumero}")
    CuestionarioMed getById(@PathParam("cuestionarioMedNumero") Long cuestionarioMedNumero);
    
    /*
     * Returns an instance of CuestionarioMed by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CuestionarioMed
     */
    @GET
    @Path("/getByOID")
    CuestionarioMed getByOID(@RequestBody CuestionarioMedOid oid);
    
    /*
     * Returns an instance of CuestionarioMed by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CuestionarioMed
     */
    @GET
    @Path("/getByOIDWithHV")
    CuestionarioMed getByOIDWithHV(@RequestBody CuestionarioMedOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
