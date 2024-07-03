package com.keralty.aeusuarios.api.gestor;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Gestor;
import com.keralty.aeusuarios.persistence.oid.GestorOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.service.GestorService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.gestor.piu.PIUGestoresRequest;
import com.keralty.aeusuarios.viewmodel.gestor.piu.PIUGestoresResponse;
import com.keralty.aeusuarios.viewmodel.gestor.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/GestorApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class GestorApi {

    @Inject
    GestorService service;

    @Inject
    public GestorApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<Gestor> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public Gestor getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @GET
    @Path(value="/getByOid")
    public Gestor getByOid(GestorOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public Gestor getByOIDWithHV(GestorOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetGestorDynamic")
    public InstanceResponseViewModel getGestorDynamic(QueryRequest request) {
        GestorOid oid = new GestorOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getGestorDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getGestorPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/changePassword")
    public ServiceResponse gestorChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_Gestores")
    public PIUGestoresResponse piuPIUGestores(PIUGestoresRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUGestoresResponse response;
        try
        {
            response = new PIUGestoresResponse(service.piuPIUGestores(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUGestores(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUGestoresResponse();
            response.setException(e);
        }
        return response;
    }


    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    public AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        return service.buildRelatedInstance(relatedInstanceJsonOid, relatedInstancePath);
    }
}
