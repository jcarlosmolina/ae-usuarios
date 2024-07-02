package com.keralty.usuarios.api.loginformacionasesor;

import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.LogInformacionAsesor;
import com.keralty.usuarios.persistence.oid.AsesorOid;
import com.keralty.usuarios.persistence.oid.LogInformacionAsesorOid;
import com.keralty.usuarios.service.LogInformacionAsesorService;
import com.keralty.usuarios.utils.TokenUtilities;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.loginformacionasesor.crud.LogInformacionAsesorPostViewModel;
import com.keralty.usuarios.viewmodel.loginformacionasesor.piu.PIULogInformacionAsesorResponse;
import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/LogInformacionAsesorApi")
@RequestScoped
@RolesAllowed({"Admin","SuperAdmin"})
public class LogInformacionAsesorApi {

    @Inject
    LogInformacionAsesorService service;

    @Inject
    public LogInformacionAsesorApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<LogInformacionAsesor> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{logInformacionAsesoridLogInformacionAsesor}")
    public LogInformacionAsesor getInstance(Long logInformacionAsesoridLogInformacionAsesor) {
    	return service.getById(logInformacionAsesoridLogInformacionAsesor);
    }

    @POST
    @Path(value="/")
    public LogInformacionAsesor postInstance(LogInformacionAsesorPostViewModel payload) {
    	return service.post(payload);
    }
    
    @DELETE
    @Path(value="/{logInformacionAsesoridLogInformacionAsesor}")
    public void deleteInstance(Long logInformacionAsesoridLogInformacionAsesor) throws ModelException {
    	service.delete(logInformacionAsesoridLogInformacionAsesor);
    }

    @GET
    @Path(value="/getByOid")
    public LogInformacionAsesor getByOid(LogInformacionAsesorOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public LogInformacionAsesor getByOIDWithHV(LogInformacionAsesorOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetLogInformacionAsesorDynamic")
    public InstanceResponseViewModel getLogInformacionAsesorDynamic(QueryRequest request) {
        LogInformacionAsesorOid oid = new LogInformacionAsesorOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getLogInformacionAsesorDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getLogInformacionAsesorPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }




    @POST
    @Path(value = "/PIU_LogInformacionAsesor")
    public PIULogInformacionAsesorResponse piuPIULogInformacionAsesor(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIULogInformacionAsesorResponse response;
        try
        {
            response = new PIULogInformacionAsesorResponse(service.piuPIULogInformacionAsesor(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIULogInformacionAsesor(queryRequest));
            }
        } catch (Exception e) {
            response = new PIULogInformacionAsesorResponse();
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
