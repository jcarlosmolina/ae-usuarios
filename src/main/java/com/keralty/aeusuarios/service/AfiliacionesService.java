package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.LogHistoricoPlanesOid;
import com.keralty.aeusuarios.persistence.oid.LogInformacionAsesorOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.repository.AfiliacionesJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.viewmodel.FilterRequest;
import com.keralty.aeusuarios.viewmodel.FilterVariableRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class AfiliacionesService extends AbstractService {

    @Inject
    AfiliacionesJpaRepository repository;

    @Inject
    AfiliacionesService afiliacionesSrv;

    @Inject
    FuncionarioService funcionarioSrv;

    @Inject
    PlanesService planesSrv;

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
    RegionalService regionalSrv;

    public void delete(Long funcionarioId) throws ModelException {
        if (!repository.existsById(funcionarioId)) throw new ModelException("Not found-Delete");
        repository.deleteById(funcionarioId);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AfiliacionesConstants.CLASS_NAME);
    }

    private List<Afiliaciones> solveAfiliacionesTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AfiliacionesConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAfiliacionesTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AfiliacionesConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class Afiliaciones
     *
     * @return Population of class Afiliaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Afiliaciones> get() {
        List<Afiliaciones> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Afiliaciones
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Afiliaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Afiliaciones> instances = get(queryRequest);
        if(AfiliacionesConstants.DSSIAFILIACIONES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildSIAfiliaciones())).collect(Collectors.toList());
        }
        if(AfiliacionesConstants.DSDSAFILIACIONES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAfiliaciones())).collect(Collectors.toList());
        }
        if(AfiliacionesConstants.DSDSAFILIACIONESMPLANES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAfiliacionesMPlanes())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet SIAfiliaciones for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet SIAfiliaciones for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.afiliaciones.ds.SIAfiliaciones getSIAfiliaciones(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Afiliaciones instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aeusuarios.viewmodel.afiliaciones.ds.SIAfiliaciones(instance);
    }

    /*
     * Gets the properties of DisplaySet DSAfiliaciones for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSAfiliaciones for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliaciones getDSAfiliaciones(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Afiliaciones instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliaciones(instance);
    }

    /*
     * Gets the properties of DisplaySet DSAfiliacionesMPlanes for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSAfiliacionesMPlanes for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliacionesMPlanes getDSAfiliacionesMPlanes(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Afiliaciones instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliacionesMPlanes(instance);
    }

    /*
     * Returns the population of class Afiliaciones that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Afiliaciones matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Afiliaciones> get(QueryRequest queryRequest) {
        return solveAfiliacionesTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAfiliacionesTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAfiliacionesTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveAfiliacionesTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
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
        return new PopulationResponseViewModel(solveAfiliacionesTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Afiliaciones by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of Afiliaciones
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Afiliaciones getById(Long funcionarioId) {
        return getByOID(new AfiliacionesOid(funcionarioId));
    }
    
    /*
     * Returns an instance of Afiliaciones by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Afiliaciones
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Afiliaciones getByOID(AfiliacionesOid oid) {
        Optional<Afiliaciones> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Afiliaciones by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Afiliaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Afiliaciones getByOIDWithHV(AfiliacionesOid oid) {
        Optional<Afiliaciones> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Afiliaciones> getInstanceByOid(AfiliacionesOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Afiliaciones by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Afiliaciones
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Afiliaciones getByJsonOid(String jsonOid) {
        AfiliacionesOid oid = new AfiliacionesOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Afiliaciones related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Afiliaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Afiliaciones> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAfiliacionesTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Afiliaciones related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Afiliaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Afiliaciones> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Afiliaciones
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Afiliaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getAfiliacionesDynamic(AfiliacionesOid oid, String displaySetItems) {
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
    public String getSuppInfo(AfiliacionesOid oid, String dsName) {
        Afiliaciones instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Afiliaciones instance, String dsName) {
        if (AfiliacionesConstants.DSSIAFILIACIONES.equals(dsName))
            return instance.buildSIAfiliaciones();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Afiliaciones instance, String dsName) {
        if (AfiliacionesConstants.DSSIAFILIACIONES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildSIAfiliaciones());
        if (AfiliacionesConstants.DSDSAFILIACIONES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAfiliaciones());
        if (AfiliacionesConstants.DSDSAFILIACIONESMPLANES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAfiliacionesMPlanes());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (AfiliacionesConstants.FILTER_NAME_FAFILIACIONESPORNOMBRE.equalsIgnoreCase(filterRequest.getName()))
            fAfiliacionesPorNombre(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_SIAfiliaciones".equals(filterRequest.getName()))
            suppInfo4SIAfiliaciones(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fAfiliacionesPorNombre(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vUsuario = filterRequest.hasFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VUSUARIO) ? (String) filterRequest.getFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VUSUARIO, FilterVariableRequest.STRING) : null;
        String vPrimerNombre = filterRequest.hasFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VPRIMERNOMBRE) ? (String) filterRequest.getFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VPRIMERNOMBRE, FilterVariableRequest.STRING) : null;
        String vSegundoNombre = filterRequest.hasFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VSEGUNDONOMBRE) ? (String) filterRequest.getFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VSEGUNDONOMBRE, FilterVariableRequest.STRING) : null;
        String vPrimerApe = filterRequest.hasFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VPRIMERAPE) ? (String) filterRequest.getFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VPRIMERAPE, FilterVariableRequest.STRING) : null;
        String vSegundoApe = filterRequest.hasFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VSEGUNDOAPE) ? (String) filterRequest.getFilterVariable(AfiliacionesConstants.VAR_NAME_FAFILIACIONESPORNOMBRE_VSEGUNDOAPE, FilterVariableRequest.STRING) : null;

        // Usuario = vUsuario
        if (vUsuario != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vUsuario, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // PrimerNombre LIKE vPrimerNombre
        if (vPrimerNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vPrimerNombre, Constants.Type.STRING.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // SegundoNombre LIKE vSegundoNombre
        if (vSegundoNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(vSegundoNombre, Constants.Type.STRING.getTypeName());
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        // PrimerApellido LIKE vPrimerApe
        if (vPrimerApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            SQLWhereOperandLiteral operand226 = new SQLWhereOperandLiteral(vPrimerApe, Constants.Type.STRING.getTypeName());
            comparison4.setSecondOperand(operand226);
            conjunction.addOperand(comparison4);

        }        

        // SegundoApellido LIKE vSegundoApe
        if (vSegundoApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            SQLWhereOperandLiteral operand227 = new SQLWhereOperandLiteral(vSegundoApe, Constants.Type.STRING.getTypeName());
            comparison5.setSecondOperand(operand227);
            conjunction.addOperand(comparison5);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Afiliaciones with displayset DSAfiliacionesMPlanes for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Afiliaciones with displayset DSAfiliacionesMPlanes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliacionesMPlanes iIUAfiliacionesMPlanes(AfiliacionesOid oid) {
        return new com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliacionesMPlanes(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUAfiliaciones
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Afiliaciones using displayset DSAfiliaciones that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliaciones> piuPIUAfiliaciones(QueryRequest queryRequest) {
        return solveAfiliacionesTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliaciones::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAfiliaciones
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAfiliaciones
     */
    public int getCount4PIUAfiliaciones(QueryRequest queryRequest) {
        return solveAfiliacionesTypedQuery(queryRequest).size();
    }

    // Service: InsPlan

    /*
     * Entry point for service InsPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPlan(
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.InsPlanRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = afiliacionesSrv.insPlanTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPlanTxn(
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.InsPlanRequest request) throws ModelException {
        request.setAfiliacionesInsPlanpthisAfiliacionesInstance(afiliacionesSrv.getByOIDWithHV(request.getAfiliacionesInsPlanpthisAfiliaciones()));
        request.setAfiliacionesInsPlanpevcPlanesInstance(planesSrv.getByOIDWithHV(request.getAfiliacionesInsPlanpevcPlanes()));
        return afiliacionesSrv.insPlanImplementation(request, true);
    }

    /*
     * Implements service InsPlan
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPlanImplementation(
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.InsPlanRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Afiliaciones afiliacionesInsPlanpthisAfiliaciones = request.getAfiliacionesInsPlanpthisAfiliacionesInstance();
        Planes afiliacionesInsPlanpevcPlanes = request.getAfiliacionesInsPlanpevcPlanesInstance();

        request.checkArguments();
        Afiliaciones instance = afiliacionesInsPlanpthisAfiliaciones;

        instance.getPlanes().add(afiliacionesInsPlanpevcPlanes);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.planes.siu.InsPlanRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.planes.siu.InsPlanRequest();
            relatedRequest.setPlanesInsPlanpthisPlanesInstance(afiliacionesInsPlanpevcPlanes);
            relatedRequest.setPlanesInsPlanpevcAfiliacionesInstance(afiliacionesInsPlanpthisAfiliaciones);
            planesSrv.insPlanImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());

        return response;
    }

    // Service: DelPlan

    /*
     * Entry point for service DelPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPlan(
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.DelPlanRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = afiliacionesSrv.delPlanTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPlanTxn(
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.DelPlanRequest request) throws ModelException {
        request.setAfiliacionesDelPlanpthisAfiliacionesInstance(afiliacionesSrv.getByOIDWithHV(request.getAfiliacionesDelPlanpthisAfiliaciones()));
        request.setAfiliacionesDelPlanpevcPlanesInstance(planesSrv.getByOIDWithHV(request.getAfiliacionesDelPlanpevcPlanes()));
        return afiliacionesSrv.delPlanImplementation(request, true);
    }

    /*
     * Implements service DelPlan
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPlanImplementation(
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.DelPlanRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Afiliaciones afiliacionesDelPlanpthisAfiliaciones = request.getAfiliacionesDelPlanpthisAfiliacionesInstance();
        Planes afiliacionesDelPlanpevcPlanes = request.getAfiliacionesDelPlanpevcPlanesInstance();

        request.checkArguments();
        Afiliaciones instance = afiliacionesDelPlanpthisAfiliaciones;

        instance.getPlanes().remove(afiliacionesDelPlanpevcPlanes);
        afiliacionesDelPlanpevcPlanes.getAfiliaciones().remove(instance);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.planes.siu.DelPlanRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.planes.siu.DelPlanRequest();
            relatedRequest.setPlanesDelPlanpthisPlanesInstance(afiliacionesDelPlanpevcPlanes);
            relatedRequest.setPlanesDelPlanpevcAfiliacionesInstance(afiliacionesDelPlanpthisAfiliaciones);
            planesSrv.delPlanImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());

        return response;
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
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = afiliacionesSrv.changePasswordTxn(request);
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
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.ChangePasswordRequest request) throws ModelException {
        request.setAfiliacioneschangePasswordpthisAdminInstance(afiliacionesSrv.getByOIDWithHV(request.getAfiliacioneschangePasswordpthisAdmin()));
        return afiliacionesSrv.changePasswordImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Afiliaciones afiliacioneschangePasswordpthisAdmin = request.getAfiliacioneschangePasswordpthisAdminInstance();
        String afiliacioneschangePasswordpOldPassword = request.getAfiliacioneschangePasswordpOldPassword();
        String afiliacioneschangePasswordpNewPassword = request.getAfiliacioneschangePasswordpNewPassword();

        request.checkArguments();
        Afiliaciones instance = afiliacioneschangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(afiliacioneschangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(afiliacioneschangePasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());

        return response;
    }

    // Service: hacerAfiliaciones

    /*
     * Implements service hacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerAfiliacionesImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerAfiliacionespthisAgente = request.getFuncionariohacerAfiliacionespthisAgenteInstance();

        request.checkArguments();
        Afiliaciones instance = new Afiliaciones();

        instance.setFuncionarioId(funcionariohacerAfiliacionespthisAgente.getFuncionarioId());

        instance.setParentFuncionario(funcionariohacerAfiliacionespthisAgente);
        instance.setPassWord(funcionariohacerAfiliacionespthisAgente.getPassWord());
        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());

        return response;
    }

    // Service: deshacerAfiliaciones

    /*
     * Implements service deshacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerAfiliacionesImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAfiliacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerAfiliacionespthisAgente = request.getFuncionariodeshacerAfiliacionespthisAgenteInstance();

        request.checkArguments();
        Afiliaciones instance = funcionariodeshacerAfiliacionespthisAgente.getChildAfiliaciones();
        funcionariodeshacerAfiliacionespthisAgente.setChildAfiliaciones(null);
        instance.setParentFuncionario(null);

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());

        response.setInstanceSuppInfo(instance.buildSIAfiliaciones());

        return response;
    }


    private void suppInfo4SIAfiliaciones(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAfiliacionesRelatedInstance(relatedInstanceJsonOid);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAfiliacionesRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAfiliacionesRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Afiliaciones(mapper.readValue(relatedInstanceJsonOid, AfiliacionesOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): solicitudSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): reportesProcAlmSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): solicitudNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): grupoAsignacionSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): logFuncionarioSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): contratoCSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): agentexProductoSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): logInformacionAsesorSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): logHistoricoPlanesSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): firmaSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): planesSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): rolSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): sucursalSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): tipoIdentificacionSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAfiliacionesRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
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
            AfiliacionesOid oid = new AfiliacionesOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AfiliacionesService.class).error(e.getMessage());
        }
    }

}
