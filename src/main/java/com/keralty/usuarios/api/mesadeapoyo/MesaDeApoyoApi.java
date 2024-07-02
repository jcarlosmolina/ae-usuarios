package com.keralty.usuarios.api.mesadeapoyo;

import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.MesaDeApoyo;
import com.keralty.usuarios.persistence.oid.MesaDeApoyoOid;
import com.keralty.usuarios.persistence.oid.RolOid;
import com.keralty.usuarios.persistence.oid.SucursalOid;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.service.MesaDeApoyoService;
import com.keralty.usuarios.utils.TokenUtilities;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.mesadeapoyo.piu.PIUMesaDeApoyoRequest;
import com.keralty.usuarios.viewmodel.mesadeapoyo.piu.PIUMesaDeApoyoResponse;
import com.keralty.usuarios.viewmodel.mesadeapoyo.siu.ChangePasswordRequest;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
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

@Path("/api/MesaDeApoyoApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class MesaDeApoyoApi {

    @Inject
    MesaDeApoyoService service;

    @Inject
    public MesaDeApoyoApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<MesaDeApoyo> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioId}")
    public MesaDeApoyo getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }
    
    @DELETE
    @Path(value="/{funcionarioId}")
    public void deleteInstance(Long funcionarioId) throws ModelException {
    	service.delete(funcionarioId);
    }

    @GET
    @Path(value="/getByOid")
    public MesaDeApoyo getByOid(MesaDeApoyoOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public MesaDeApoyo getByOIDWithHV(MesaDeApoyoOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetMesaDeApoyoDynamic")
    public InstanceResponseViewModel getMesaDeApoyoDynamic(QueryRequest request) {
        MesaDeApoyoOid oid = new MesaDeApoyoOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getMesaDeApoyoDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getMesaDeApoyoPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/changePassword")
    public ServiceResponse mesaDeApoyoChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_MesaDeApoyo")
    public PIUMesaDeApoyoResponse piuPIUMesaDeApoyo(PIUMesaDeApoyoRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUMesaDeApoyoResponse response;
        try
        {
            response = new PIUMesaDeApoyoResponse(service.piuPIUMesaDeApoyo(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUMesaDeApoyo(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUMesaDeApoyoResponse();
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
