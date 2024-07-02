package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.EstadoBeneficiario;
import com.keralty.usuarios.persistence.oid.EstadoBeneficiarioOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/EstadoBeneficiarioApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface EstadoBeneficiarioService {

    /*
     * Returns an instance of EstadoBeneficiario by ID
     *
     * @param estadoBeneficiarioCodigo Identification field estadoBeneficiarioCodigo
     *
     * @return Instance of EstadoBeneficiario
     */
    @GET
    @Path("/{estadoBeneficiarioCodigo}")
    EstadoBeneficiario getById(@PathParam("estadoBeneficiarioCodigo") Long estadoBeneficiarioCodigo);
    
    /*
     * Returns an instance of EstadoBeneficiario by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoBeneficiario
     */
    @GET
    @Path("/getByOID")
    EstadoBeneficiario getByOID(@RequestBody EstadoBeneficiarioOid oid);
    
    /*
     * Returns an instance of EstadoBeneficiario by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoBeneficiario
     */
    @GET
    @Path("/getByOIDWithHV")
    EstadoBeneficiario getByOIDWithHV(@RequestBody EstadoBeneficiarioOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
