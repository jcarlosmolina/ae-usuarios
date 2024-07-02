package com.keralty.usuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.AfiliacionesConstants;
import com.keralty.usuarios.global.AreaMedicaConstants;
import com.keralty.usuarios.global.AsesorConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.GestorConstants;
import com.keralty.usuarios.global.RespRegionalConstants;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Gestor;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.persistence.LogFuncionario;
import com.keralty.usuarios.persistence.LogHistoricoPlanes;
import com.keralty.usuarios.persistence.LogInformacionAsesor;
import com.keralty.usuarios.persistence.oid.AgentexProductoOid;
import com.keralty.usuarios.persistence.oid.ContratoCOid;
import com.keralty.usuarios.persistence.oid.FirmaOid;
import com.keralty.usuarios.persistence.oid.GestorOid;
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
import com.keralty.usuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.ReportesProcAlm;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.persistence.Solicitud;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.persistence.TipoIdentificacion;
import com.keralty.usuarios.repository.GestorJpaRepository;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
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
public class GestorService extends AbstractService {

    @Inject
    GestorJpaRepository repository;

    @Inject
    GestorService gestorSrv;

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
        return solveGenericQuery(request, GestorConstants.CLASS_NAME);
    }

    private List<Gestor> solveGestorTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, GestorConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveGestorTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, GestorConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class Gestor
     *
     * @return Population of class Gestor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Gestor> get() {
        List<Gestor> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSGestor for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSGestor for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.gestor.ds.DSGestor getDSGestor(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Gestor instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.gestor.ds.DSGestor(instance);
    }

    /*
     * Returns the population of class Gestor that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Gestor matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Gestor> get(QueryRequest queryRequest) {
        return solveGestorTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveGestorTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveGestorTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveGestorTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Gestor by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of Gestor
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Gestor getById(Long funcionarioId) {
        return getByOID(new GestorOid(funcionarioId));
    }
    
    /*
     * Returns an instance of Gestor by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Gestor
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Gestor getByOID(GestorOid oid) {
        Optional<Gestor> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Gestor by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Gestor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Gestor getByOIDWithHV(GestorOid oid) {
        Optional<Gestor> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Gestor> getInstanceByOid(GestorOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Gestor by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Gestor
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Gestor getByJsonOid(String jsonOid) {
        GestorOid oid = new GestorOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Gestor related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Gestor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Gestor> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveGestorTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Gestor related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Gestor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Gestor> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Gestor
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Gestor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getGestorDynamic(GestorOid oid, String displaySetItems) {
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
    public String getSuppInfo(GestorOid oid, String dsName) {
        Gestor instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Gestor instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (GestorConstants.FILTER_NAME_FGESTOR.equalsIgnoreCase(filterRequest.getName()))
            fGestor(filterRequest, sql);
    }


    private void fGestor(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfPrimerNombre = filterRequest.hasFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFPRIMERNOMBRE) ? (String) filterRequest.getFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFPRIMERNOMBRE, FilterVariableRequest.STRING) : null;
        String vfSegundoNombre = filterRequest.hasFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFSEGUNDONOMBRE) ? (String) filterRequest.getFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFSEGUNDONOMBRE, FilterVariableRequest.STRING) : null;
        String vfPrimerApe = filterRequest.hasFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFPRIMERAPE) ? (String) filterRequest.getFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFPRIMERAPE, FilterVariableRequest.STRING) : null;
        String vfSegundoApe = filterRequest.hasFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFSEGUNDOAPE) ? (String) filterRequest.getFilterVariable(GestorConstants.VAR_NAME_FGESTOR_VFSEGUNDOAPE, FilterVariableRequest.STRING) : null;

        // PrimerNombre LIKE vfPrimerNombre
        if (vfPrimerNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vfPrimerNombre, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // SegundoNombre LIKE vfSegundoNombre
        if (vfSegundoNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vfSegundoNombre, Constants.Type.STRING.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // PrimerApellido LIKE vfPrimerApe
        if (vfPrimerApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(vfPrimerApe, Constants.Type.STRING.getTypeName());
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        // SegundoApellido LIKE vfSegundoApe
        if (vfSegundoApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            SQLWhereOperandLiteral operand226 = new SQLWhereOperandLiteral(vfSegundoApe, Constants.Type.STRING.getTypeName());
            comparison4.setSecondOperand(operand226);
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUGestores
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Gestor using displayset DSGestor that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.usuarios.viewmodel.gestor.ds.DSGestor> piuPIUGestores(QueryRequest queryRequest) {
        return solveGestorTypedQuery(queryRequest).stream()
                .map(com.keralty.usuarios.viewmodel.gestor.ds.DSGestor::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUGestores
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUGestores
     */
    public int getCount4PIUGestores(QueryRequest queryRequest) {
        return solveGestorTypedQuery(queryRequest).size();
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
            com.keralty.usuarios.viewmodel.gestor.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = gestorSrv.changePasswordTxn(request);
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
            com.keralty.usuarios.viewmodel.gestor.siu.ChangePasswordRequest request) throws ModelException {
        request.setGestorchangePasswordpthisAdminInstance(gestorSrv.getByOIDWithHV(request.getGestorchangePasswordpthisAdmin()));
        return gestorSrv.changePasswordImplementation(request);
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
            com.keralty.usuarios.viewmodel.gestor.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Gestor gestorchangePasswordpthisAdmin = request.getGestorchangePasswordpthisAdminInstance();
        String gestorchangePasswordpOldPassword = request.getGestorchangePasswordpOldPassword();
        String gestorchangePasswordpNewPassword = request.getGestorchangePasswordpNewPassword();

        request.checkArguments();
        Gestor instance = gestorchangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(gestorchangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(gestorchangePasswordpNewPassword));


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: hacerGestor

    /*
     * Implements service hacerGestor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerGestorImplementation(
            com.keralty.usuarios.viewmodel.funcionario.siu.HacerGestorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerGestorpthisFuncionario = request.getFuncionariohacerGestorpthisFuncionarioInstance();

        request.checkArguments();
        Gestor instance = new Gestor();

        instance.setFuncionarioId(funcionariohacerGestorpthisFuncionario.getFuncionarioId());

        instance.setParentFuncionario(funcionariohacerGestorpthisFuncionario);
        instance.setPassWord(funcionariohacerGestorpthisFuncionario.getPassWord());


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: deshacerGestor

    /*
     * Implements service deshacerGestor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerGestorImplementation(
            com.keralty.usuarios.viewmodel.funcionario.siu.DeshacerGestorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerGestorpthisFuncionario = request.getFuncionariodeshacerGestorpthisFuncionarioInstance();

        request.checkArguments();
        Gestor instance = funcionariodeshacerGestorpthisFuncionario.getChildGestor();
        funcionariodeshacerGestorpthisFuncionario.setChildGestor(null);
        instance.setParentFuncionario(null);

        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildGestorRelatedInstance(relatedInstanceJsonOid);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGestorRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildGestorRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Gestor(mapper.readValue(relatedInstanceJsonOid, GestorOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): solicitudSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): reportesProcAlmSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): solicitudNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): grupoAsignacionSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): logFuncionarioSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): contratoCSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): agentexProductoSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): logInformacionAsesorSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): logHistoricoPlanesSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): firmaSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): rolSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): sucursalSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): tipoIdentificacionSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): planesSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildGestorRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
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
            GestorOid oid = new GestorOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(GestorService.class).error(e.getMessage());
        }
    }

}
