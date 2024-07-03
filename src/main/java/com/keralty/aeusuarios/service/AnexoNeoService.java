package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.AnexoNeo;
import com.keralty.aeusuarios.persistence.oid.AnexoNeoOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/AnexoNeoApi")
@RegisterRestClient(configKey="ae-personas-afiliados-contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aepersonasafiliadoscontratantes}")
public interface AnexoNeoService {

    /*
     * Returns an instance of AnexoNeo by ID
     *
     * @param anexoNeoIdentificador Identification field anexoNeoIdentificador
     *
     * @return Instance of AnexoNeo
     */
    @GET
    @Path("/{anexoNeoIdentificador}")
    AnexoNeo getById(@PathParam("anexoNeoIdentificador") Long anexoNeoIdentificador);
    
    /*
     * Returns an instance of AnexoNeo by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoNeo
     */
    @GET
    @Path("/getByOID")
    AnexoNeo getByOID(@RequestBody AnexoNeoOid oid);
    
    /*
     * Returns an instance of AnexoNeo by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoNeo
     */
    @GET
    @Path("/getByOIDWithHV")
    AnexoNeo getByOIDWithHV(@RequestBody AnexoNeoOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
