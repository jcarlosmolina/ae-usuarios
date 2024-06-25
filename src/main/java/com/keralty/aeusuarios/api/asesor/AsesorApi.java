package com.keralty.aeusuarios.api.asesor;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.service.AsesorService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.asesor.crud.AsesorPostViewModel;
import com.keralty.aeusuarios.viewmodel.asesor.crud.AsesorPutViewModel;
import com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorIIU;
import com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIUMaestroProductos;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorDetalleResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesoresDeAgenciaRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesoresDeAgenciaResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUDirectoresRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUDirectoresResponse;
import com.keralty.aeusuarios.viewmodel.asesor.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORRequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
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
import jakarta.ws.rs.PUT;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/AsesorApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class AsesorApi {

    @Inject
    AsesorService service;

    @Inject
    public AsesorApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<Asesor> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public Asesor getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }

    @POST
    @Path(value="/")
    public Asesor postInstance(AsesorPostViewModel payload) {
    	return service.post(payload);
    }

    @PUT
    @Path(value="/{funcionarioId}")
    public Asesor putInstance(Long funcionarioId, AsesorPutViewModel payload) throws ModelException {
    	return service.put(funcionarioId, payload);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @POST
    @Path(value = "/GetPreload")
    public List<PreloadViewModel> getAsesorPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    public Asesor getByOid(AsesorOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public Asesor getByOIDWithHV(AsesorOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAsesorDynamic")
    public InstanceResponseViewModel getAsesorDynamic(QueryRequest request) {
        AsesorOid oid = new AsesorOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAsesorDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    public PreloadResponseViewModel getAsesorWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getAsesorPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/TMODIFICARASESOR")
    public ServiceResponse asesorTMODIFICARASESOR(TMODIFICARASESORRequest request) {
        return service.tMODIFICARASESOR(request);
    }
    

    @POST
    @Path(value = "/TDELETE")
    public ServiceResponse asesorTDELETE(TDELETERequest request) {
        return service.tDELETE(request);
    }
    

    @POST
    @Path(value = "/TDELETECheckPreconditions")
    public ServiceResponse asesorTDELETECheckPreconditions(TDELETERequest request) {

        return service.tDELETECheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMODVISIBILIDAD")
    public ServiceResponse asesorTMODVISIBILIDAD(TMODVISIBILIDADRequest request) {
        return service.tMODVISIBILIDAD(request);
    }
    

    @POST
    @Path(value = "/TCARGARDOMINIOPLAN")
    public ServiceResponse asesorTCARGARDOMINIOPLAN(TCARGARDOMINIOPLANRequest request) {
        return service.tCARGARDOMINIOPLAN(request);
    }
    

    @POST
    @Path(value = "/changePassword")
    public ServiceResponse asesorChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    

    @POST
    @Path(value = "/IIU_Asesor")
    public DSAsesorIIU iiuIIUAsesor(AsesorOid oid) {
        return service.iIUAsesor(oid);
    }

    @POST
    @Path(value = "/IIU_AsesorProductos")
    public DSAsesorPIUMaestroProductos iiuIIUAsesorProductos(AsesorOid oid) {
        return service.iIUAsesorProductos(oid);
    }

    @POST
    @Path(value = "/PIU_Asesor")
    public PIUAsesorResponse piuPIUAsesor(PIUAsesorRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesorResponse response;
        try
        {
            response = new PIUAsesorResponse(service.piuPIUAsesor(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesor(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAsesorResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_AsesorDetalle")
    public PIUAsesorDetalleResponse piuPIUAsesorDetalle(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesorDetalleResponse response;
        try
        {
            response = new PIUAsesorDetalleResponse(service.piuPIUAsesorDetalle(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesorDetalle(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAsesorDetalleResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Directores")
    public PIUDirectoresResponse piuPIUDirectores(PIUDirectoresRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDirectoresResponse response;
        try
        {
            response = new PIUDirectoresResponse(service.piuPIUDirectores(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDirectores(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUDirectoresResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_AsesoresDeAgencia")
    public PIUAsesoresDeAgenciaResponse piuPIUAsesoresDeAgencia(PIUAsesoresDeAgenciaRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesoresDeAgenciaResponse response;
        try
        {
            response = new PIUAsesoresDeAgenciaResponse(service.piuPIUAsesoresDeAgencia(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesoresDeAgencia(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAsesoresDeAgenciaResponse();
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
