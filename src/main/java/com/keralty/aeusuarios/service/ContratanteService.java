package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Contratante;
import com.keralty.aeusuarios.persistence.oid.ContratanteOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/ContratanteApi")
@RegisterRestClient(configKey="ae-personas-afiliados-contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aepersonasafiliadoscontratantes}")
public interface ContratanteService {

    /*
     * Returns an instance of Contratante by ID
     *
     * @param aESOLICITUDESIDSOLICITUD Identification field aESOLICITUDESIDSOLICITUD
     *
     * @return Instance of Contratante
     */
    @GET
    @Path("/{aESOLICITUDESIDSOLICITUD}")
    Contratante getById(@PathParam("aESOLICITUDESIDSOLICITUD") Long aESOLICITUDESIDSOLICITUD);
    
    /*
     * Returns an instance of Contratante by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Contratante
     */
    @GET
    @Path("/getByOID")
    Contratante getByOID(@RequestBody ContratanteOid oid);
    
    /*
     * Returns an instance of Contratante by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Contratante
     */
    @GET
    @Path("/getByOIDWithHV")
    Contratante getByOIDWithHV(@RequestBody ContratanteOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
