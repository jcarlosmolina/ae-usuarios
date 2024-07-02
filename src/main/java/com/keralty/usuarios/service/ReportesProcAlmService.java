package com.keralty.usuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.ReportesProcAlmConstants;
import com.keralty.usuarios.global.UserFunctions;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.oid.FuncionarioOid;
import com.keralty.usuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.usuarios.persistence.ReportesProcAlm;
import com.keralty.usuarios.repository.ReportesProcAlmJpaRepository;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.usuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.usuarios.viewmodel.FilterRequest;
import com.keralty.usuarios.viewmodel.FilterVariableRequest;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.reportesprocalm.crud.ReportesProcAlmPostViewModel;
import com.keralty.usuarios.viewmodel.reportesprocalm.crud.ReportesProcAlmPutViewModel;
import com.keralty.usuarios.viewmodel.ServiceResponse;
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
public class ReportesProcAlmService extends AbstractService {

    @Inject
    ReportesProcAlmJpaRepository repository;

    @Inject
    ReportesProcAlmService reportesProcAlmSrv;

    @Inject
    FuncionarioService funcionarioSrv;

    @Inject
    UserFunctions userFunctionsSrv;
    
    public ReportesProcAlm post(ReportesProcAlmPostViewModel payload) {
        ReportesProcAlm instance = new ReportesProcAlm();
        instance.setReportesProcAlmDescripcion(payload.getReportesProcAlmDescripcion());
        instance.setReportesProcAlmNombreProc(payload.getReportesProcAlmNombreProc());
        instance.setReportesProcAlmNombreFichero(payload.getReportesProcAlmNombreFichero());
        return repository.save(instance);
    }

    public ReportesProcAlm put(Long reportesProcAlmidReporte, ReportesProcAlmPutViewModel payload) throws ModelException {
        if (!repository.existsById(reportesProcAlmidReporte)) throw new ModelException("Not found-Put");
        ReportesProcAlm instance = new ReportesProcAlm(new ReportesProcAlmOid(reportesProcAlmidReporte));
        instance.setReportesProcAlmDescripcion(payload.getReportesProcAlmDescripcion());
        instance.setReportesProcAlmNombreProc(payload.getReportesProcAlmNombreProc());
        instance.setReportesProcAlmNombreFichero(payload.getReportesProcAlmNombreFichero());
        return repository.save(instance);
    }

    public void delete(Long reportesProcAlmidReporte) throws ModelException {
        if (!repository.existsById(reportesProcAlmidReporte)) throw new ModelException("Not found-Delete");
        repository.deleteById(reportesProcAlmidReporte);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ReportesProcAlmConstants.CLASS_NAME);
    }

    private List<ReportesProcAlm> solveReportesProcAlmTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ReportesProcAlmConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveReportesProcAlmTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ReportesProcAlmConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ReportesProcAlm
     *
     * @return Population of class ReportesProcAlm
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesProcAlm> get() {
        List<ReportesProcAlm> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class ReportesProcAlm
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class ReportesProcAlm
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<ReportesProcAlm> instances = get(queryRequest);
        if(ReportesProcAlmConstants.DSICREPORTESPROCALM.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICReportesProcAlm())).collect(Collectors.toList());
        }
        if(ReportesProcAlmConstants.DSDSREPORTESPROCALM.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSReportesProcAlm())).collect(Collectors.toList());
        }
        if(ReportesProcAlmConstants.DSDSMMD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSMMD())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet ICReportesProcAlm for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet ICReportesProcAlm for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.reportesprocalm.ds.ICReportesProcAlm getICReportesProcAlm(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ReportesProcAlm instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.reportesprocalm.ds.ICReportesProcAlm(instance);
    }

    /*
     * Gets the properties of DisplaySet DSReportesProcAlm for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSReportesProcAlm for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSReportesProcAlm getDSReportesProcAlm(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ReportesProcAlm instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSReportesProcAlm(instance);
    }

    /*
     * Gets the properties of DisplaySet DSMMD for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSMMD for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSMMD getDSMMD(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ReportesProcAlm instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSMMD(instance);
    }

    /*
     * Returns the population of class ReportesProcAlm that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ReportesProcAlm matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesProcAlm> get(QueryRequest queryRequest) {
        return solveReportesProcAlmTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveReportesProcAlmTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveReportesProcAlmTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveReportesProcAlmTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveReportesProcAlmTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ReportesProcAlm by ID
     *
     * @param reportesProcAlmidReporte Identification field reportesProcAlmidReporte
     *
     * @return Instance of ReportesProcAlm
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ReportesProcAlm getById(Long reportesProcAlmidReporte) {
        return getByOID(new ReportesProcAlmOid(reportesProcAlmidReporte));
    }
    
    /*
     * Returns an instance of ReportesProcAlm by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ReportesProcAlm
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ReportesProcAlm getByOID(ReportesProcAlmOid oid) {
        Optional<ReportesProcAlm> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ReportesProcAlm by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ReportesProcAlm
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ReportesProcAlm getByOIDWithHV(ReportesProcAlmOid oid) {
        Optional<ReportesProcAlm> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ReportesProcAlm> getInstanceByOid(ReportesProcAlmOid oid) {
        return oid != null && oid.getReportesProcAlmidReporte() != null
               ? repository.findById(oid.getReportesProcAlmidReporte())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ReportesProcAlm by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ReportesProcAlm
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ReportesProcAlm getByJsonOid(String jsonOid) {
        ReportesProcAlmOid oid = new ReportesProcAlmOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ReportesProcAlm related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ReportesProcAlm
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesProcAlm> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveReportesProcAlmTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ReportesProcAlm related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ReportesProcAlm
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ReportesProcAlm> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ReportesProcAlm
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ReportesProcAlm
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getReportesProcAlmDynamic(ReportesProcAlmOid oid, String displaySetItems) {
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
    public String getSuppInfo(ReportesProcAlmOid oid, String dsName) {
        ReportesProcAlm instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ReportesProcAlm instance, String dsName) {
        if (ReportesProcAlmConstants.DSICREPORTESPROCALM.equals(dsName))
            return instance.buildICReportesProcAlm();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(ReportesProcAlm instance, String dsName) {
        if (ReportesProcAlmConstants.DSICREPORTESPROCALM.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICReportesProcAlm());
        if (ReportesProcAlmConstants.DSDSREPORTESPROCALM.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSReportesProcAlm());
        if (ReportesProcAlmConstants.DSDSMMD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSMMD());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_ReportesProcAlm".equals(filterRequest.getName()))
            suppInfo4ICReportesProcAlm(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods

    /*
     * Returns a viewmodel for class ReportesProcAlm with displayset DSMMD for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class ReportesProcAlm with displayset DSMMD
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSMMD iIUReportesProcAlm(ReportesProcAlmOid oid) {
        return new com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSMMD(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUReportesProcAlm
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ReportesProcAlm using displayset DSReportesProcAlm that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSReportesProcAlm> piuPIUReportesProcAlm(QueryRequest queryRequest) {
        return solveReportesProcAlmTypedQuery(queryRequest).stream()
                .map(com.keralty.usuarios.viewmodel.reportesprocalm.ds.DSReportesProcAlm::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUReportesProcAlm
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUReportesProcAlm
     */
    public int getCount4PIUReportesProcAlm(QueryRequest queryRequest) {
        return solveReportesProcAlmTypedQuery(queryRequest).size();
    }

    // Service: InsReporteFuncionario

    /*
     * Entry point for service InsReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insReporteFuncionario(
            com.keralty.usuarios.viewmodel.reportesprocalm.siu.InsReporteFuncionarioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = reportesProcAlmSrv.insReporteFuncionarioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insReporteFuncionarioTxn(
            com.keralty.usuarios.viewmodel.reportesprocalm.siu.InsReporteFuncionarioRequest request) throws ModelException {
        request.setReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance(reportesProcAlmSrv.getByOIDWithHV(request.getReportesProcAlmInsReporteFuncionariopthisReportesProcAlm()));
        request.setReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getReportesProcAlmInsReporteFuncionariopevcFuncionario()));
        return reportesProcAlmSrv.insReporteFuncionarioImplementation(request, true);
    }

    /*
     * Implements service InsReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insReporteFuncionarioImplementation(
            com.keralty.usuarios.viewmodel.reportesprocalm.siu.InsReporteFuncionarioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ReportesProcAlm reportesProcAlmInsReporteFuncionariopthisReportesProcAlm = request.getReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance();
        Funcionario reportesProcAlmInsReporteFuncionariopevcFuncionario = request.getReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance();

        request.checkArguments();
        ReportesProcAlm instance = reportesProcAlmInsReporteFuncionariopthisReportesProcAlm;

        instance.getFuncionarios().add(reportesProcAlmInsReporteFuncionariopevcFuncionario);
        if (isEntryPoint) {
            com.keralty.usuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest relatedRequest = new com.keralty.usuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest();
            relatedRequest.setFuncionarioInsReporteFuncionariopthisFuncionarioInstance(reportesProcAlmInsReporteFuncionariopevcFuncionario);
            relatedRequest.setFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance(reportesProcAlmInsReporteFuncionariopthisReportesProcAlm);
            funcionarioSrv.insReporteFuncionarioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICReportesProcAlm());

        return response;
    }

    // Service: DelReporteFuncionario

    /*
     * Entry point for service DelReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delReporteFuncionario(
            com.keralty.usuarios.viewmodel.reportesprocalm.siu.DelReporteFuncionarioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = reportesProcAlmSrv.delReporteFuncionarioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delReporteFuncionarioTxn(
            com.keralty.usuarios.viewmodel.reportesprocalm.siu.DelReporteFuncionarioRequest request) throws ModelException {
        request.setReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance(reportesProcAlmSrv.getByOIDWithHV(request.getReportesProcAlmDelReporteFuncionariopthisReportesProcAlm()));
        request.setReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getReportesProcAlmDelReporteFuncionariopevcFuncionario()));
        return reportesProcAlmSrv.delReporteFuncionarioImplementation(request, true);
    }

    /*
     * Implements service DelReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delReporteFuncionarioImplementation(
            com.keralty.usuarios.viewmodel.reportesprocalm.siu.DelReporteFuncionarioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ReportesProcAlm reportesProcAlmDelReporteFuncionariopthisReportesProcAlm = request.getReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance();
        Funcionario reportesProcAlmDelReporteFuncionariopevcFuncionario = request.getReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance();

        request.checkArguments();
        ReportesProcAlm instance = reportesProcAlmDelReporteFuncionariopthisReportesProcAlm;

        instance.getFuncionarios().remove(reportesProcAlmDelReporteFuncionariopevcFuncionario);
        reportesProcAlmDelReporteFuncionariopevcFuncionario.getReportes().remove(instance);
        if (isEntryPoint) {
            com.keralty.usuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest relatedRequest = new com.keralty.usuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest();
            relatedRequest.setFuncionarioDelReporteFuncionariopthisFuncionarioInstance(reportesProcAlmDelReporteFuncionariopevcFuncionario);
            relatedRequest.setFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance(reportesProcAlmDelReporteFuncionariopthisReportesProcAlm);
            funcionarioSrv.delReporteFuncionarioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICReportesProcAlm());

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(FuncionarioConstants.CLASS_NAME)) applyHVFilter4Funcionario(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4Funcionario(SQLSelect sql, SQLWhereDisjunction disjunction) throws SystemException{
        // COUNT (Funcionarios) WHERE (Funcionarios = agent) > 0
        Funcionario agentInstance = getAgentFuncionario();
        // '>' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator(">");
        
        // Operand 1
            // 'count' Association operator
            SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(sql));
        comparison1.setFirstOperand(operandSubQueryAssocOperator000);
        
        // Operand 2
        SQLWhereOperandLiteral operand221 = new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName());
        comparison1.setSecondOperand(operand221);
        disjunction.addOperand(comparison1);

    }


    private void suppInfo4ICReportesProcAlm(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ReportesProcAlmConstants.ATTR_NAME_REPORTESPROCALMDESCRIPCION, Constants.Type.STRING.getTypeName()));
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
            relatedInstance = buildReportesProcAlmRelatedInstance(relatedInstanceJsonOid);
        }
        if (ReportesProcAlmConstants.ROLE_NAME_FUNCIONARIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildReportesProcAlmRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildReportesProcAlmRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildReportesProcAlmRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): funcionarioSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ReportesProcAlmOid oid = new ReportesProcAlmOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ReportesProcAlmConstants.ATTR_FIELD_REPORTESPROCALMIDREPORTE, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getReportesProcAlmidReporte(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ReportesProcAlmService.class).error(e.getMessage());
        }
    }

}
