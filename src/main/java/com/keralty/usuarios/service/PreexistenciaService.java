package com.keralty.usuarios.service;

import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.PreexistenciaOid;
import com.keralty.usuarios.persistence.Preexistencia;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/PreexistenciaApi")
@RegisterRestClient(configKey="personas_afiliados_contratantes")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.usuarios.utils.TokenUtilities.getToken4personas_afiliados_contratantes}")
public interface PreexistenciaService {

    /*
     * Returns an instance of Preexistencia by ID
     *
     * @param aESOLICITUDESIDSOLICITUD Identification field aESOLICITUDESIDSOLICITUD
     *
     * @param usuarioUsuarioIdentificador Identification field usuarioUsuarioIdentificador
     *
     * @param preexistenciaIdentificador Identification field preexistenciaIdentificador
     *
     * @return Instance of Preexistencia
     */
    @GET
    @Path("/{aESOLICITUDESIDSOLICITUD}/{usuarioUsuarioIdentificador}/{preexistenciaIdentificador}")
    Preexistencia getById(@PathParam("aESOLICITUDESIDSOLICITUD") Long aESOLICITUDESIDSOLICITUD, @PathParam("usuarioUsuarioIdentificador") Long usuarioUsuarioIdentificador, @PathParam("preexistenciaIdentificador") Long preexistenciaIdentificador);
    
    /*
     * Returns an instance of Preexistencia by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Preexistencia
     */
    @GET
    @Path("/getByOID")
    Preexistencia getByOID(@RequestBody PreexistenciaOid oid);
    
    /*
     * Returns an instance of Preexistencia by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Preexistencia
     */
    @GET
    @Path("/getByOIDWithHV")
    Preexistencia getByOIDWithHV(@RequestBody PreexistenciaOid oid);

    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath);
}
