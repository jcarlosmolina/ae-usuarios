package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.TitularOid;
import com.keralty.usuarios.persistence.Titular;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/TitularApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
public interface TitularService {

    /*
     * Returns an instance of Titular by ID
     *
     * @param aESOLICITUDESIDSOLICITUD Identification field aESOLICITUDESIDSOLICITUD
     *
     * @return Instance of Titular
     */
    @GET
    @Path("/{aESOLICITUDESIDSOLICITUD}")
    Titular getById(@PathParam("aESOLICITUDESIDSOLICITUD") Long aESOLICITUDESIDSOLICITUD);
    
    /*
     * Returns an instance of Titular by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Titular
     */
    @GET
    @Path("/getByOID")
    Titular getByOID(@RequestBody TitularOid oid);
    
    /*
     * Returns an instance of Titular by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Titular
     */
    @GET
    @Path("/getByOIDWithHV")
    Titular getByOIDWithHV(@RequestBody TitularOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
