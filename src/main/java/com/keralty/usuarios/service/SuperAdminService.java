package com.keralty.usuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.global.AfiliacionesConstants;
import com.keralty.usuarios.global.AreaMedicaConstants;
import com.keralty.usuarios.global.AsesorConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.RespRegionalConstants;
import com.keralty.usuarios.global.SuperAdminConstants;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.persistence.LogFuncionario;
import com.keralty.usuarios.persistence.LogHistoricoPlanes;
import com.keralty.usuarios.persistence.LogInformacionAsesor;
import com.keralty.usuarios.persistence.oid.AgentexProductoOid;
import com.keralty.usuarios.persistence.oid.ContratoCOid;
import com.keralty.usuarios.persistence.oid.FirmaOid;
import com.keralty.usuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.usuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.usuarios.persistence.oid.LogHistoricoPlanesOid;
import com.keralty.usuarios.persistence.oid.LogInformacionAsesorOid;
import com.keralty.usuarios.persistence.oid.PlanesOid;
import com.keralty.usuarios.persistence.oid.RegionalOid;
import com.keralty.usuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.usuarios.persistence.oid.RolOid;
import com.keralty.usuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.usuarios.persistence.oid.SolicitudOid;
import com.keralty.usuarios.persistence.oid.SucursalOid;
import com.keralty.usuarios.persistence.oid.SuperAdminOid;
import com.keralty.usuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.ReportesProcAlm;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.persistence.Solicitud;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.persistence.SuperAdmin;
import com.keralty.usuarios.persistence.TipoIdentificacion;
import com.keralty.usuarios.repository.SuperAdminJpaRepository;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.usuarios.viewmodel.FilterRequest;
import com.keralty.usuarios.viewmodel.FilterVariableRequest;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class SuperAdminService extends AbstractService {

    @Inject
    SuperAdminJpaRepository repository;

    @Inject
    SuperAdminService superAdminSrv;

    @Inject
    FuncionarioService funcionarioSrv;

    @Inject
    SolicitudService solicitudSrv;

    @Inject
    ReportesProcAlmService reportesProcAlmSrv;

    @Inject
    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    GrupoAsignacionService grupoAsignacionSrv;

    @Inject
    LogFuncionarioService logFuncionarioSrv;

    @Inject
    ContratoCService contratoCSrv;

    @Inject
    AgentexProductoService agentexProductoSrv;

    @Inject
    LogInformacionAsesorService logInformacionAsesorSrv;

    @Inject
    LogHistoricoPlanesService logHistoricoPlanesSrv;

    @Inject
    FirmaService firmaSrv;

    @Inject
    RolService rolSrv;

    @Inject
    SucursalService sucursalSrv;

    @Inject
    TipoIdentificacionService tipoIdentificacionSrv;

    @Inject
    PlanesService planesSrv;

    @Inject
    RegionalService regionalSrv;

    public void delete(Long funcionarioId) throws ModelException {
        if (!repository.existsById(funcionarioId)) throw new ModelException("Not found-Delete");
        repository.deleteById(funcionarioId);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, SuperAdminConstants.CLASS_NAME);
    }

    private List<SuperAdmin> solveSuperAdminTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, SuperAdminConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveSuperAdminTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, SuperAdminConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class SuperAdmin
     *
     * @return Population of class SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> get() {
        List<SuperAdmin> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    /*
     * Gets the properties of DisplaySet ICSuperAdmin for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet ICSuperAdmin for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.superadmin.ds.ICSuperAdmin getICSuperAdmin(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        SuperAdmin instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.superadmin.ds.ICSuperAdmin(instance);
    }

    /*
     * Gets the properties of DisplaySet AutoDS for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet AutoDS for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.superadmin.ds.AutoDS getAutoDS(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        SuperAdmin instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.superadmin.ds.AutoDS(instance);
    }

    /*
     * Returns the population of class SuperAdmin that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class SuperAdmin matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> get(QueryRequest queryRequest) {
        return solveSuperAdminTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveSuperAdminTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveSuperAdminTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveSuperAdminTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of SuperAdmin by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SuperAdmin getById(Long funcionarioId) {
        return getByOID(new SuperAdminOid(funcionarioId));
    }
    
    /*
     * Returns an instance of SuperAdmin by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SuperAdmin getByOID(SuperAdminOid oid) {
        Optional<SuperAdmin> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of SuperAdmin by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public SuperAdmin getByOIDWithHV(SuperAdminOid oid) {
        Optional<SuperAdmin> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<SuperAdmin> getInstanceByOid(SuperAdminOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of SuperAdmin by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of SuperAdmin
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public SuperAdmin getByJsonOid(String jsonOid) {
        SuperAdminOid oid = new SuperAdminOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of SuperAdmin related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveSuperAdminTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of SuperAdmin related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SuperAdmin> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of SuperAdmin
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of SuperAdmin
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getSuperAdminDynamic(SuperAdminOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String getSuppInfo(SuperAdminOid oid, String dsName) {
        SuperAdmin instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(SuperAdmin instance, String dsName) {
        if (SuperAdminConstants.DSICSUPERADMIN.equals(dsName))
            return instance.buildICSuperAdmin();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUSuperAdmin
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SuperAdmin using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.usuarios.viewmodel.superadmin.ds.AutoDS> piuPIUSuperAdmin(QueryRequest queryRequest) {
        return solveSuperAdminTypedQuery(queryRequest).stream()
                .map(com.keralty.usuarios.viewmodel.superadmin.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSuperAdmin
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSuperAdmin
     */
    public int getCount4PIUSuperAdmin(QueryRequest queryRequest) {
        return solveSuperAdminTypedQuery(queryRequest).size();
    }

    // Service: changePassword

    /*
     * Entry point for service changePassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse changePassword(
            com.keralty.usuarios.viewmodel.superadmin.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = superAdminSrv.changePasswordTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service changePassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse changePasswordTxn(
            com.keralty.usuarios.viewmodel.superadmin.siu.ChangePasswordRequest request) throws ModelException {
        request.setSuperAdminchangePasswordpthisAdminInstance(superAdminSrv.getByOIDWithHV(request.getSuperAdminchangePasswordpthisAdmin()));
        return superAdminSrv.changePasswordImplementation(request);
    }

    /*
     * Implements service changePassword
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse changePasswordImplementation(
            com.keralty.usuarios.viewmodel.superadmin.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SuperAdmin superAdminchangePasswordpthisAdmin = request.getSuperAdminchangePasswordpthisAdminInstance();
        String superAdminchangePasswordpOldPassword = request.getSuperAdminchangePasswordpOldPassword();
        String superAdminchangePasswordpNewPassword = request.getSuperAdminchangePasswordpNewPassword();

        request.checkArguments();
        SuperAdmin instance = superAdminchangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(superAdminchangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(superAdminchangePasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSuperAdmin());

        return response;
    }

    // Service: hacerSuperAdmin

    /*
     * Implements service hacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerSuperAdminImplementation(
            com.keralty.usuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerSuperAdminpthisAgente = request.getFuncionariohacerSuperAdminpthisAgenteInstance();

        request.checkArguments();
        SuperAdmin instance = new SuperAdmin();

        instance.setFuncionarioId(funcionariohacerSuperAdminpthisAgente.getFuncionarioId());

        instance.setParentFuncionario(funcionariohacerSuperAdminpthisAgente);
        instance.setPassWord(funcionariohacerSuperAdminpthisAgente.getPassWord());
        response.setInstanceSuppInfo(instance.buildICSuperAdmin());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSuperAdmin());

        return response;
    }

    // Service: deshacerSuperAdmin

    /*
     * Implements service deshacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerSuperAdminImplementation(
            com.keralty.usuarios.viewmodel.funcionario.siu.DeshacerSuperAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerSuperAdminpthisAgente = request.getFuncionariodeshacerSuperAdminpthisAgenteInstance();

        request.checkArguments();
        SuperAdmin instance = funcionariodeshacerSuperAdminpthisAgente.getChildSuperAdmin();
        funcionariodeshacerSuperAdminpthisAgente.setChildSuperAdmin(null);
        instance.setParentFuncionario(null);

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICSuperAdmin());

        response.setInstanceSuppInfo(instance.buildICSuperAdmin());

        return response;
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildSuperAdminRelatedInstance(relatedInstanceJsonOid);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSuperAdminRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildSuperAdminRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new SuperAdmin(mapper.readValue(relatedInstanceJsonOid, SuperAdminOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): solicitudSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): reportesProcAlmSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): solicitudNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): grupoAsignacionSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): logFuncionarioSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): contratoCSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): agentexProductoSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): logInformacionAsesorSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): logHistoricoPlanesSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): firmaSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): rolSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): sucursalSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): tipoIdentificacionSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): planesSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildSuperAdminRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class)): regionalSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            SuperAdminOid oid = new SuperAdminOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(SuperAdminService.class).error(e.getMessage());
        }
    }

}
