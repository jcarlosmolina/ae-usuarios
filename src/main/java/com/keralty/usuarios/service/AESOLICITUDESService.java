package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.AESOLICITUDES;
import com.keralty.usuarios.persistence.oid.AESOLICITUDESOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/AE_SOLICITUDESApi")
@RegisterRestClient(configKey="solicitudes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4solicitudes}")
public interface AESOLICITUDESService {

    /*
     * Returns an instance of AESOLICITUDES by ID
     *
     * @param aESOLICITUDESIDSOLICITUD Identification field aESOLICITUDESIDSOLICITUD
     *
     * @return Instance of AESOLICITUDES
     */
    @GET
    @Path("/{aESOLICITUDESIDSOLICITUD}")
    AESOLICITUDES getById(@PathParam("aESOLICITUDESIDSOLICITUD") Long aESOLICITUDESIDSOLICITUD);
    
    /*
     * Returns an instance of AESOLICITUDES by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AESOLICITUDES
     */
    @GET
    @Path("/getByOID")
    AESOLICITUDES getByOID(@RequestBody AESOLICITUDESOid oid);
    
    /*
     * Returns an instance of AESOLICITUDES by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AESOLICITUDES
     */
    @GET
    @Path("/getByOIDWithHV")
    AESOLICITUDES getByOIDWithHV(@RequestBody AESOLICITUDESOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
