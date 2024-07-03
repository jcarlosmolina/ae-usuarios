package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.CuestionarioP;
import com.keralty.aeusuarios.persistence.oid.CuestionarioPOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/CuestionarioPApi")
@RegisterRestClient(configKey="ae-personas-afiliados-contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aepersonasafiliadoscontratantes}")
public interface CuestionarioPService {

    /*
     * Returns an instance of CuestionarioP by ID
     *
     * @param cuestionarioPNumero Identification field cuestionarioPNumero
     *
     * @return Instance of CuestionarioP
     */
    @GET
    @Path("/{cuestionarioPNumero}")
    CuestionarioP getById(@PathParam("cuestionarioPNumero") Long cuestionarioPNumero);
    
    /*
     * Returns an instance of CuestionarioP by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CuestionarioP
     */
    @GET
    @Path("/getByOID")
    CuestionarioP getByOID(@RequestBody CuestionarioPOid oid);
    
    /*
     * Returns an instance of CuestionarioP by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CuestionarioP
     */
    @GET
    @Path("/getByOIDWithHV")
    CuestionarioP getByOIDWithHV(@RequestBody CuestionarioPOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
