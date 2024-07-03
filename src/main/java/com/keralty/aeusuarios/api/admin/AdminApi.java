package com.keralty.aeusuarios.api.admin;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Admin;
import com.keralty.aeusuarios.persistence.oid.AdminOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.service.AdminService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.admin.piu.PIUAdminResponse;
import com.keralty.aeusuarios.viewmodel.admin.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
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

@Path("/api/AdminApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class AdminApi {

    @Inject
    AdminService service;

    @Inject
    public AdminApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<Admin> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public Admin getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @GET
    @Path(value="/getByOid")
    public Admin getByOid(AdminOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public Admin getByOIDWithHV(AdminOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAdminDynamic")
    public InstanceResponseViewModel getAdminDynamic(QueryRequest request) {
        AdminOid oid = new AdminOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAdminDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getAdminPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/changePassword")
    public ServiceResponse adminChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_Admin")
    public PIUAdminResponse piuPIUAdmin(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAdminResponse response;
        try
        {
            response = new PIUAdminResponse(service.piuPIUAdmin(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAdmin(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAdminResponse();
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
