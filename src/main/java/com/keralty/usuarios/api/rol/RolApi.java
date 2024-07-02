package com.keralty.usuarios.api.rol;

import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.oid.RolOid;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.service.RolService;
import com.keralty.usuarios.utils.TokenUtilities;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.rol.crud.RolPostViewModel;
import com.keralty.usuarios.viewmodel.rol.piu.PIURolDetDominioResponse;
import com.keralty.usuarios.viewmodel.rol.piu.PIURolResponse;
import com.keralty.usuarios.viewmodel.rol.siu.CrearRequest;
import com.keralty.usuarios.viewmodel.rol.siu.EliminarRequest;
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

@Path("/api/RolApi")
@RequestScoped
@RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
public class RolApi {

    @Inject
    RolService service;

    @Inject
    public RolApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<Rol> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{rolIdentificador}")
    public Rol getInstance(Long rolIdentificador) {
    	return service.getById(rolIdentificador);
    }

    @POST
    @Path(value="/")
    public Rol postInstance(RolPostViewModel payload) {
    	return service.post(payload);
    }
    
    @DELETE
    @Path(value="/{rolIdentificador}")
    public void deleteInstance(Long rolIdentificador) throws ModelException {
    	service.delete(rolIdentificador);
    }

    @POST
    @Path(value = "/GetPreload")
    public List<PreloadViewModel> getRolPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    public Rol getByOid(RolOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public Rol getByOIDWithHV(RolOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetRolDynamic")
    public InstanceResponseViewModel getRolDynamic(QueryRequest request) {
        RolOid oid = new RolOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getRolDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    public PreloadResponseViewModel getRolWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getRolPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/crear")
    public ServiceResponse rolCrear(CrearRequest request) {
        return service.crear(request);
    }
    

    @POST
    @Path(value = "/eliminar")
    public ServiceResponse rolEliminar(EliminarRequest request) {
        return service.eliminar(request);
    }
    

    @POST
    @Path(value = "/eliminarCheckPreconditions")
    public ServiceResponse rolEliminarCheckPreconditions(EliminarRequest request) {

        return service.eliminarCheckPreconditions(request);
    }


    @POST
    @Path(value = "/PIU_Rol")
    public PIURolResponse piuPIURol(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIURolResponse response;
        try
        {
            response = new PIURolResponse(service.piuPIURol(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIURol(queryRequest));
            }
        } catch (Exception e) {
            response = new PIURolResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_RolDetDominio")
    public PIURolDetDominioResponse piuPIURolDetDominio(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIURolDetDominioResponse response;
        try
        {
            response = new PIURolDetDominioResponse(service.piuPIURolDetDominio(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIURolDetDominio(queryRequest));
            }
        } catch (Exception e) {
            response = new PIURolDetDominioResponse();
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
