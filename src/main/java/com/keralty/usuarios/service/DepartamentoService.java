package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Departamento;
import com.keralty.usuarios.persistence.oid.DepartamentoOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/DepartamentoApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface DepartamentoService {

    /*
     * Returns an instance of Departamento by ID
     *
     * @param departamentoCodigo Identification field departamentoCodigo
     *
     * @return Instance of Departamento
     */
    @GET
    @Path("/{departamentoCodigo}")
    Departamento getById(@PathParam("departamentoCodigo") Long departamentoCodigo);
    
    /*
     * Returns an instance of Departamento by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Departamento
     */
    @GET
    @Path("/getByOID")
    Departamento getByOID(@RequestBody DepartamentoOid oid);
    
    /*
     * Returns an instance of Departamento by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Departamento
     */
    @GET
    @Path("/getByOIDWithHV")
    Departamento getByOIDWithHV(@RequestBody DepartamentoOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
