package com.keralty.aeusuarios.api.respregional;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.service.RespRegionalService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.respregional.ds.DSRespRegional;
import com.keralty.aeusuarios.viewmodel.respregional.piu.PIURespRegionalResponse;
import com.keralty.aeusuarios.viewmodel.respregional.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.respregional.siu.TCREAROMODFIRMARequest;
import com.keralty.aeusuarios.viewmodel.respregional.siu.TMODIFICARRequest;
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
