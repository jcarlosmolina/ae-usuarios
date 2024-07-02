package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.AnexoMat;
import com.keralty.usuarios.persistence.oid.AnexoMatOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/AnexoMatApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
public interface AnexoMatService {

    /*
     * Returns an instance of AnexoMat by ID
     *
     * @param anexoMatIdentificador Identification field anexoMatIdentificador
     *
     * @return Instance of AnexoMat
     */
    @GET
    @Path("/{anexoMatIdentificador}")
    AnexoMat getById(@PathParam("anexoMatIdentificador") Long anexoMatIdentificador);
    
    /*
     * Returns an instance of AnexoMat by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoMat
     */
    @GET
    @Path("/getByOID")
    AnexoMat getByOID(@RequestBody AnexoMatOid oid);
    
    /*
     * Returns an instance of AnexoMat by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoMat
     */
    @GET
    @Path("/getByOIDWithHV")
    AnexoMat getByOIDWithHV(@RequestBody AnexoMatOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
