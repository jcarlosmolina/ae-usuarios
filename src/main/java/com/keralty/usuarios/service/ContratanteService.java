package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Contratante;
import com.keralty.usuarios.persistence.oid.ContratanteOid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/ContratanteApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
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
