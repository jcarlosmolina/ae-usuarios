package com.keralty.usuarios.api.agentexproducto;

import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.oid.AgentexProductoOid;
import com.keralty.usuarios.persistence.oid.AsesorOid;
import com.keralty.usuarios.persistence.oid.ProductosOid;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.service.AgentexProductoService;
import com.keralty.usuarios.utils.TokenUtilities;
import com.keralty.usuarios.viewmodel.agentexproducto.crud.AgentexProductoPostViewModel;
import com.keralty.usuarios.viewmodel.agentexproducto.crud.AgentexProductoPutViewModel;
import com.keralty.usuarios.viewmodel.agentexproducto.piu.PIUAgentexProductoResponse;
import com.keralty.usuarios.viewmodel.agentexproducto.siu.EliminarRequest;
import com.keralty.usuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest;
import com.keralty.usuarios.viewmodel.agentexproducto.siu.TCREARRequest;
import com.keralty.usuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest;
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

@Path("/api/AgentexProductoApi")
@RequestScoped
@RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
public class AgentexProductoApi {

    @Inject
    AgentexProductoService service;

    @Inject
    public AgentexProductoApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/")
    public List<AgentexProducto> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }
    
    @GET
    @Path(value="/{funcionarioAsesorId}/{agentexProductoId}")
    public AgentexProducto getInstance(Long funcionarioAsesorId, Long agentexProductoId) {
    	return service.getById(funcionarioAsesorId, agentexProductoId);
    }

    @POST
    @Path(value="/")
    public AgentexProducto postInstance(AgentexProductoPostViewModel payload) {
    	return service.post(payload);
    }

    @PUT
    @Path(value="/{funcionarioAsesorId}/{agentexProductoId}")
    public AgentexProducto putInstance(Long funcionarioAsesorId, Long agentexProductoId, AgentexProductoPutViewModel payload) throws ModelException {
    	return service.put(funcionarioAsesorId, agentexProductoId, payload);
    }
    
    @DELETE
    @Path(value="/{funcionarioAsesorId}/{agentexProductoId}")
    public void deleteInstance(Long funcionarioAsesorId, Long agentexProductoId) throws ModelException {
    	service.delete(funcionarioAsesorId, agentexProductoId);
    }

    @POST
    @Path(value = "/GetPreload")
    public List<PreloadViewModel> getAgentexProductoPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    public AgentexProducto getByOid(AgentexProductoOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    public AgentexProducto getByOIDWithHV(AgentexProductoOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAgentexProductoDynamic")
    public InstanceResponseViewModel getAgentexProductoDynamic(QueryRequest request) {
        AgentexProductoOid oid = new AgentexProductoOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAgentexProductoDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    public PreloadResponseViewModel getAgentexProductoWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    public PopulationResponseViewModel getAgentexProductoPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }


    @POST
    @Path(value = "/eliminar")
    public ServiceResponse agentexProductoEliminar(EliminarRequest request) {
        return service.eliminar(request);
    }
    

    @POST
    @Path(value = "/TCREAR")
    public ServiceResponse agentexProductoTCREAR(TCREARRequest request) {
        return service.tCREAR(request);
    }
    

    @POST
    @Path(value = "/TADDDOMINIO")
    public ServiceResponse agentexProductoTADDDOMINIO(TADDDOMINIORequest request) {
        return service.tADDDOMINIO(request);
    }
    

    @POST
    @Path(value = "/TADDDOMINIOCheckPreconditions")
    public ServiceResponse agentexProductoTADDDOMINIOCheckPreconditions(TADDDOMINIORequest request) {

        return service.tADDDOMINIOCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TDELDOMINIO")
    public ServiceResponse agentexProductoTDELDOMINIO(TDELDOMINIORequest request) {
        return service.tDELDOMINIO(request);
    }
    


    @POST
    @Path(value = "/PIU_AgentexProducto")
    public PIUAgentexProductoResponse piuPIUAgentexProducto(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAgentexProductoResponse response;
        try
        {
            response = new PIUAgentexProductoResponse(service.piuPIUAgentexProducto(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAgentexProducto(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAgentexProductoResponse();
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
