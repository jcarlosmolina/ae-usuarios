package com.keralty.aeusuarios.api.superadmin;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.SuperAdminOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.SuperAdmin;
import com.keralty.aeusuarios.service.SuperAdminService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import com.keralty.aeusuarios.viewmodel.superadmin.piu.PIUSuperAdminResponse;
import com.keralty.aeusuarios.viewmodel.superadmin.siu.ChangePasswordRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/SuperAdminApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class SuperAdminApi {

    @Inject
    SuperAdminService service;

    @Inject
    public SuperAdminApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<SuperAdmin> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public SuperAdmin getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @GET
    @Path(value="/getByOid")
    public SuperAdmin getByOid(SuperAdminOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public SuperAdmin getByOIDWithHV(SuperAdminOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetSuperAdminDynamic")
    public InstanceResponseViewModel getSuperAdminDynamic(QueryRequest request) {
        SuperAdminOid oid = new SuperAdminOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getSuperAdminDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getSuperAdminPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/changePassword")
    public ServiceResponse superAdminChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_SuperAdmin")
    public PIUSuperAdminResponse piuPIUSuperAdmin(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUSuperAdminResponse response;
        try
        {
            response = new PIUSuperAdminResponse(service.piuPIUSuperAdmin(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUSuperAdmin(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUSuperAdminResponse();
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
