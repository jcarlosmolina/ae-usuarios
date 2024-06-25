package com.keralty.aeusuarios.api.afiliaciones;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.service.AfiliacionesService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliacionesMPlanes;
import com.keralty.aeusuarios.viewmodel.afiliaciones.piu.PIUAfiliacionesRequest;
import com.keralty.aeusuarios.viewmodel.afiliaciones.piu.PIUAfiliacionesResponse;
import com.keralty.aeusuarios.viewmodel.afiliaciones.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.afiliaciones.siu.DelPlanRequest;
import com.keralty.aeusuarios.viewmodel.afiliaciones.siu.InsPlanRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadViewModel;
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

@Path("/api/AfiliacionesApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class AfiliacionesApi {

    @Inject
    AfiliacionesService service;

    @Inject
    public AfiliacionesApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<Afiliaciones> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public Afiliaciones getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @POST
    @Path(value = "/GetPreload")
    public List<PreloadViewModel> getAfiliacionesPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    public Afiliaciones getByOid(AfiliacionesOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public Afiliaciones getByOIDWithHV(AfiliacionesOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAfiliacionesDynamic")
    public InstanceResponseViewModel getAfiliacionesDynamic(QueryRequest request) {
        AfiliacionesOid oid = new AfiliacionesOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAfiliacionesDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    public PreloadResponseViewModel getAfiliacionesWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getAfiliacionesPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/InsPlan")
    public ServiceResponse afiliacionesInsPlan(InsPlanRequest request) {
        return service.insPlan(request);
    }
    

    @POST
    @Path(value = "/DelPlan")
    public ServiceResponse afiliacionesDelPlan(DelPlanRequest request) {
        return service.delPlan(request);
    }
    

    @POST
    @Path(value = "/changePassword")
    public ServiceResponse afiliacionesChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    

    @POST
    @Path(value = "/IIU_AfiliacionesMPlanes")
    public DSAfiliacionesMPlanes iiuIIUAfiliacionesMPlanes(AfiliacionesOid oid) {
        return service.iIUAfiliacionesMPlanes(oid);
    }

    @POST
    @Path(value = "/PIU_Afiliaciones")
    public PIUAfiliacionesResponse piuPIUAfiliaciones(PIUAfiliacionesRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAfiliacionesResponse response;
        try
        {
            response = new PIUAfiliacionesResponse(service.piuPIUAfiliaciones(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAfiliaciones(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAfiliacionesResponse();
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
