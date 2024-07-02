package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.ParentescoDomOid;
import com.keralty.usuarios.persistence.ParentescoDom;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/ParentescoDomApi")
@RegisterRestClient(configKey="configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4configuraciones}")
public interface ParentescoDomService {

    /*
     * Returns an instance of ParentescoDom by ID
     *
     * @param dominioNumero Identification field dominioNumero
     *
     * @param parentescoDomIdentificador Identification field parentescoDomIdentificador
     *
     * @return Instance of ParentescoDom
     */
    @GET
    @Path("/{dominioNumero}/{parentescoDomIdentificador}")
    ParentescoDom getById(@PathParam("dominioNumero") Long dominioNumero, @PathParam("parentescoDomIdentificador") Long parentescoDomIdentificador);
    
    /*
     * Returns an instance of ParentescoDom by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ParentescoDom
     */
    @GET
    @Path("/getByOID")
    ParentescoDom getByOID(@RequestBody ParentescoDomOid oid);
    
    /*
     * Returns an instance of ParentescoDom by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ParentescoDom
     */
    @GET
    @Path("/getByOIDWithHV")
    ParentescoDom getByOIDWithHV(@RequestBody ParentescoDomOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
