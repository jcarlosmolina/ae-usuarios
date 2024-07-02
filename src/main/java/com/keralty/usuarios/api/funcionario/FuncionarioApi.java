package com.keralty.usuarios.api.funcionario;

import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.oid.FuncionarioOid;
import com.keralty.usuarios.persistence.oid.RolOid;
import com.keralty.usuarios.persistence.oid.SucursalOid;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.service.FuncionarioService;
import com.keralty.usuarios.utils.TokenUtilities;
import com.keralty.usuarios.viewmodel.funcionario.crud.FuncionarioPostViewModel;
import com.keralty.usuarios.viewmodel.funcionario.crud.FuncionarioPutViewModel;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUAgenteResponse;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUDFuncionariosReporteResponse;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUFuncionarioDDominioResponse;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUFuncionarioDGrupoResponse;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUFuncionarioGrupoUsuariosRequest;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUFuncionarioGrupoUsuariosResponse;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUUsuariosRequest;
import com.keralty.usuarios.viewmodel.funcionario.piu.PIUUsuariosResponse;
import com.keralty.usuarios.viewmodel.funcionario.siu.CambRolAgenteRequest;
import com.keralty.usuarios.viewmodel.funcionario.siu.ChangePasswordRequest;
import com.keralty.usuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest;
import com.keralty.usuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest;
import com.keralty.usuarios.viewmodel.funcionario.siu.SetPasswordRequest;
import com.keralty.usuarios.viewmodel.funcionario.siu.TBORRARRequest;
import com.keralty.usuarios.viewmodel.funcionario.siu.TCAMBIARDISPONIBLERequest;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.ServiceResponse;
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

@Path("/api/FuncionarioApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class FuncionarioApi {

    @Inject
    FuncionarioService service;

    @Inject
    public FuncionarioApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<Funcionario> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public Funcionario getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }

    @POST
    @Path(value="/")
    public Funcionario postInstance(FuncionarioPostViewModel payload) {
    	return service.post(payload);
    }

    @PUT
    @Path(value="/{funcionarioId}")
    public Funcionario putInstance(Long funcionarioId, FuncionarioPutViewModel payload) throws ModelException {
    	return service.put(funcionarioId, payload);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @POST
    @Path(value = "/GetPreload")
    public List<PreloadViewModel> getFuncionarioPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    public Funcionario getByOid(FuncionarioOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public Funcionario getByOIDWithHV(FuncionarioOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetFuncionarioDynamic")
    public InstanceResponseViewModel getFuncionarioDynamic(QueryRequest request) {
        FuncionarioOid oid = new FuncionarioOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getFuncionarioDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    public PreloadResponseViewModel getFuncionarioWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getFuncionarioPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/setPassword")
    public ServiceResponse funcionarioSetPassword(SetPasswordRequest request) {
        return service.setPassword(request);
    }
    

    @POST
    @Path(value = "/CambRolAgente")
    public ServiceResponse funcionarioCambRolAgente(CambRolAgenteRequest request) {
        return service.cambRolAgente(request);
    }
    

    @POST
    @Path(value = "/InsReporteFuncionario")
    public ServiceResponse funcionarioInsReporteFuncionario(InsReporteFuncionarioRequest request) {
        return service.insReporteFuncionario(request);
    }
    

    @POST
    @Path(value = "/DelReporteFuncionario")
    public ServiceResponse funcionarioDelReporteFuncionario(DelReporteFuncionarioRequest request) {
        return service.delReporteFuncionario(request);
    }
    

    @POST
    @Path(value = "/TCAMBIARDISPONIBLE")
    public ServiceResponse funcionarioTCAMBIARDISPONIBLE(TCAMBIARDISPONIBLERequest request) {
        return service.tCAMBIARDISPONIBLE(request);
    }
    

    @POST
    @Path(value = "/TBORRAR")
    public ServiceResponse funcionarioTBORRAR(TBORRARRequest request) {
        return service.tBORRAR(request);
    }
    

    @POST
    @Path(value = "/TBORRARCheckPreconditions")
    public ServiceResponse funcionarioTBORRARCheckPreconditions(TBORRARRequest request) {

        return service.tBORRARCheckPreconditions(request);
    }

    @POST
    @Path(value = "/changePassword")
    public ServiceResponse funcionarioChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_Agente")
    public PIUAgenteResponse piuPIUAgente(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAgenteResponse response;
        try
        {
            response = new PIUAgenteResponse(service.piuPIUAgente(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAgente(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAgenteResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_D_FuncionariosReporte")
    public PIUDFuncionariosReporteResponse piuPIUDFuncionariosReporte(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDFuncionariosReporteResponse response;
        try
        {
            response = new PIUDFuncionariosReporteResponse(service.piuPIUDFuncionariosReporte(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDFuncionariosReporte(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUDFuncionariosReporteResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_D_Grupo")
    public PIUFuncionarioDGrupoResponse piuPIUFuncionarioDGrupo(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioDGrupoResponse response;
        try
        {
            response = new PIUFuncionarioDGrupoResponse(service.piuPIUFuncionarioDGrupo(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioDGrupo(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUFuncionarioDGrupoResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_D_Dominio")
    public PIUFuncionarioDDominioResponse piuPIUFuncionarioDDominio(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioDDominioResponse response;
        try
        {
            response = new PIUFuncionarioDDominioResponse(service.piuPIUFuncionarioDDominio(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioDDominio(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUFuncionarioDDominioResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_GrupoUsuarios")
    public PIUFuncionarioGrupoUsuariosResponse piuPIUFuncionarioGrupoUsuarios(PIUFuncionarioGrupoUsuariosRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioGrupoUsuariosResponse response;
        try
        {
            response = new PIUFuncionarioGrupoUsuariosResponse(service.piuPIUFuncionarioGrupoUsuarios(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioGrupoUsuarios(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUFuncionarioGrupoUsuariosResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Usuarios")
    public PIUUsuariosResponse piuPIUUsuarios(PIUUsuariosRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuariosResponse response;
        try
        {
            response = new PIUUsuariosResponse(service.piuPIUUsuarios(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuarios(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUUsuariosResponse();
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
