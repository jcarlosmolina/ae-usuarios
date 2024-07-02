package com.keralty.usuarios.api.respregional;

import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.oid.FirmaOid;
import com.keralty.usuarios.persistence.oid.RegionalOid;
import com.keralty.usuarios.persistence.oid.RespRegionalOid;
import com.keralty.usuarios.persistence.oid.RolOid;
import com.keralty.usuarios.persistence.oid.SucursalOid;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.service.RespRegionalService;
import com.keralty.usuarios.utils.TokenUtilities;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.respregional.ds.DSRespRegional;
import com.keralty.usuarios.viewmodel.respregional.piu.PIURespRegionalResponse;
import com.keralty.usuarios.viewmodel.respregional.siu.ChangePasswordRequest;
import com.keralty.usuarios.viewmodel.respregional.siu.TCREAROMODFIRMARequest;
import com.keralty.usuarios.viewmodel.respregional.siu.TMODIFICARRequest;
import com.keralty.usuarios.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/RespRegionalApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class RespRegionalApi {

    @Inject
    RespRegionalService service;

    @Inject
    public RespRegionalApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<RespRegional> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public RespRegional getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @POST
    @Path(value = "/GetPreload")
    public List<PreloadViewModel> getRespRegionalPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    public RespRegional getByOid(RespRegionalOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public RespRegional getByOIDWithHV(RespRegionalOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetRespRegionalDynamic")
    public InstanceResponseViewModel getRespRegionalDynamic(QueryRequest request) {
        RespRegionalOid oid = new RespRegionalOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getRespRegionalDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    public PreloadResponseViewModel getRespRegionalWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getRespRegionalPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/TMODIFICAR")
    public ServiceResponse respRegionalTMODIFICAR(TMODIFICARRequest request) {
        return service.tMODIFICAR(request);
    }
    

    @POST
    @Path(value = "/TCREAROMODFIRMA")
    public ServiceResponse respRegionalTCREAROMODFIRMA(TCREAROMODFIRMARequest request) {
        return service.tCREAROMODFIRMA(request);
    }
    

    @POST
    @Path(value = "/changePassword")
    public ServiceResponse respRegionalChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    

    @POST
    @Path(value = "/IIU_RespRegional_Firma")
    public DSRespRegional iiuIIURespRegionalFirma(RespRegionalOid oid) {
        return service.iIURespRegionalFirma(oid);
    }

    @POST
    @Path(value = "/PIU_RespRegional")
    public PIURespRegionalResponse piuPIURespRegional(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIURespRegionalResponse response;
        try
        {
            response = new PIURespRegionalResponse(service.piuPIURespRegional(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIURespRegional(queryRequest));
            }
        } catch (Exception e) {
            response = new PIURespRegionalResponse();
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
