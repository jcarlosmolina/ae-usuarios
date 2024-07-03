package com.keralty.aeusuarios.api.logfuncionario;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.aeusuarios.service.LogFuncionarioService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.logfuncionario.crud.LogFuncionarioPostViewModel;
import com.keralty.aeusuarios.viewmodel.logfuncionario.piu.PIULogFuncionarioResponse;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
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

@Path("/api/LogFuncionarioApi")
@RequestScoped
@RolesAllowed({"Admin","SuperAdmin"})
public class LogFuncionarioApi {

    @Inject
    LogFuncionarioService service;

    @Inject
    public LogFuncionarioApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<LogFuncionario> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{logFuncionarioId}")
    public LogFuncionario getInstance(Long logFuncionarioId) {
    	return service.getById(logFuncionarioId);
    }

    @POST
    @Path(value="/")
    public LogFuncionario postInstance(LogFuncionarioPostViewModel payload) {
    	return service.post(payload);
    }
    
    @DELETE
    @Path(value="/{logFuncionarioId}")
    public void deleteInstance(Long logFuncionarioId) throws ModelException {
    	service.delete(logFuncionarioId);
    }

    @GET
    @Path(value="/getByOid")
    public LogFuncionario getByOid(LogFuncionarioOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public LogFuncionario getByOIDWithHV(LogFuncionarioOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetLogFuncionarioDynamic")
    public InstanceResponseViewModel getLogFuncionarioDynamic(QueryRequest request) {
        LogFuncionarioOid oid = new LogFuncionarioOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getLogFuncionarioDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getLogFuncionarioPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }




    @POST
    @Path(value = "/PIU_LogFuncionario")
    public PIULogFuncionarioResponse piuPIULogFuncionario(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIULogFuncionarioResponse response;
        try
        {
            response = new PIULogFuncionarioResponse(service.piuPIULogFuncionario(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIULogFuncionario(queryRequest));
            }
        } catch (Exception e) {
            response = new PIULogFuncionarioResponse();
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
