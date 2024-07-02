package com.keralty.usuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.FirmaConstants;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.RegionalConstants;
import com.keralty.usuarios.global.RespRegionalConstants;
import com.keralty.usuarios.global.SucursalConstants;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.FamiliaNovedad;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.NovedadCT;
import com.keralty.usuarios.persistence.oid.FamiliaNovedadOid;
import com.keralty.usuarios.persistence.oid.FirmaOid;
import com.keralty.usuarios.persistence.oid.NovedadCTOid;
import com.keralty.usuarios.persistence.oid.RegionalOid;
import com.keralty.usuarios.persistence.oid.RespRegionalOid;
import com.keralty.usuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.usuarios.persistence.oid.SolicitudOid;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.persistence.Solicitud;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.repository.FirmaJpaRepository;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.usuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.usuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.usuarios.utils.Utilities;
import com.keralty.usuarios.viewmodel.FilterRequest;
import com.keralty.usuarios.viewmodel.FilterVariableRequest;
import com.keralty.usuarios.viewmodel.firma.crud.FirmaPostViewModel;
import com.keralty.usuarios.viewmodel.firma.crud.FirmaPutViewModel;
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
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class FirmaService extends AbstractService {

    @Inject
    FirmaJpaRepository repository;

    @Inject
    FirmaService firmaSrv;

    @Inject
    SolicitudService solicitudSrv;

    @Inject
    RespRegionalService respRegionalSrv;

    @RestClient
    FamiliaNovedadService familiaNovedadSrv;

    @RestClient
    NovedadCTService novedadCTSrv;

    @Inject
    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    RegionalService regionalSrv;
    
    public Firma post(FirmaPostViewModel payload) {
        Firma instance = new Firma();
        instance.setFirmaImagenFirma(payload.getFirmaImagenFirma());
        instance.setFirmaLatitud(payload.getFirmaLatitud());
        instance.setFirmaLongitud(payload.getFirmaLongitud());
        return repository.save(instance);
    }

    public Firma put(Long firmaIdentificador, FirmaPutViewModel payload) throws ModelException {
        if (!repository.existsById(firmaIdentificador)) throw new ModelException("Not found-Put");
        Firma instance = new Firma(new FirmaOid(firmaIdentificador));
        instance.setFirmaImagenFirma(payload.getFirmaImagenFirma());
        instance.setFirmaLatitud(payload.getFirmaLatitud());
        instance.setFirmaLongitud(payload.getFirmaLongitud());
        return repository.save(instance);
    }

    public void delete(Long firmaIdentificador) throws ModelException {
        if (!repository.existsById(firmaIdentificador)) throw new ModelException("Not found-Delete");
        repository.deleteById(firmaIdentificador);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FirmaConstants.CLASS_NAME);
    }

    private List<Firma> solveFirmaTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, FirmaConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber()).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList());
    }
    
    private int solveFirmaTypedCountQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, FirmaConstants.CLASS_NAME)).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size();
    }
    
    /*
     * Returns the population of class Firma
     *
     * @return Population of class Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> get() {
        List<Firma> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSFirmaPIUResponsable for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSFirmaPIUResponsable for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.firma.ds.DSFirmaPIUResponsable getDSFirmaPIUResponsable(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Firma instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.firma.ds.DSFirmaPIUResponsable(instance);
    }

    /*
     * Returns the population of class Firma that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Firma matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> get(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveFirmaTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFirmaTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveFirmaTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Firma by ID
     *
     * @param firmaIdentificador Identification field firmaIdentificador
     *
     * @return Instance of Firma
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Firma getById(Long firmaIdentificador) {
        return getByOID(new FirmaOid(firmaIdentificador));
    }
    
    /*
     * Returns an instance of Firma by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Firma
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Firma getByOID(FirmaOid oid) {
        Optional<Firma> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Firma by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Firma getByOIDWithHV(FirmaOid oid) {
        Optional<Firma> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Firma> getInstanceByOid(FirmaOid oid) {
        return oid != null && oid.getFirmaIdentificador() != null
               ? repository.findById(oid.getFirmaIdentificador())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Firma by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Firma
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Firma getByJsonOid(String jsonOid) {
        FirmaOid oid = new FirmaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Firma related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveFirmaTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Firma related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Firma
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFirmaDynamic(FirmaOid oid, String displaySetItems) {
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
    public String getSuppInfo(FirmaOid oid, String dsName) {
        Firma instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Firma instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (FirmaConstants.FILTER_NAME_FFIRMASRESPONSABLES.equalsIgnoreCase(filterRequest.getName()))
            fFirmasResponsables(filterRequest, sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Firma instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Firma instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, Firma entity) {
        if (FirmaConstants.FILTER_NAME_FFIRMASRESPONSABLES.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFFirmasResponsables(filterRequest,  entity);
        return true;
    }


    private void fFirmasResponsables(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vUsuario = filterRequest.hasFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VUSUARIO) ? (String) filterRequest.getFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VUSUARIO, FilterVariableRequest.STRING) : null;
        Regional voRegional = filterRequest.hasFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL) ? regionalSrv.getByOID(new RegionalOid().fromJsonString(toJson(filterRequest.getFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL)))) : null;

        // EXIST (RespRegional) = true
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(sql));
    conjunction.addOperand(operandSubQueryAssocOperator000);


        // RespRegional.Usuario LIKE "%" + vUsuario
        if (vUsuario != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FirmaConstants.ROLE_NAME_RESPREGIONAL + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral("%" + vUsuario, Constants.Type.STRING.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // RespRegional.Sucursal.Regional = voRegional
        if (voRegional != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand114 = new SQLWhereOperandPathInstance(FirmaConstants.ROLE_NAME_RESPREGIONAL + "." + RespRegionalConstants.ROLE_NAME_SUCURSAL + "." + SucursalConstants.ROLE_NAME_REGIONAL, RegionalConstants.CLASS_NAME);
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandOVParameter operand225 = new SQLWhereOperandOVParameter(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL, RegionalConstants.CLASS_NAME, RegionalConstants.CLASS_NAME, voRegional.getOid(), FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL);
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFFirmasResponsables(FilterRequest filterRequest, Firma entity) {
        boolean result = true;
        String vNombre = filterRequest.hasFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VNOMBRE) ? (String) filterRequest.getFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VNOMBRE, FilterVariableRequest.STRING) : null;

        // RespRegional.drvNombreCompleto LIKE "%" + vNombre
        try {
            if (vNombre != null) {
                result = Utilities.like(entity.getRespRegional().getFuncionariodrvNombreCompleto(), "%" + vNombre);
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUFirmasRespRegional
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Firma using displayset DSFirmaPIUResponsable that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.usuarios.viewmodel.firma.ds.DSFirmaPIUResponsable> piuPIUFirmasRespRegional(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest).stream()
                .map(com.keralty.usuarios.viewmodel.firma.ds.DSFirmaPIUResponsable::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFirmasRespRegional
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFirmasRespRegional
     */
    public int getCount4PIUFirmasRespRegional(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest).size();
    }

    // Service: crear

    /*
     * Entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse crear(
            com.keralty.usuarios.viewmodel.firma.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = firmaSrv.crearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse crearTxn(
            com.keralty.usuarios.viewmodel.firma.siu.CrearRequest request) {
        request.setFirmacrearpagrSolicitudSegundaInstance(solicitudSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitudSegunda()));
        request.setFirmacrearpagrRespRegionalInstance(respRegionalSrv.getByOIDWithHV(request.getFirmacrearpagrRespRegional()));
        request.setFirmacrearpagrSolicitudContratanteInstance(solicitudSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitudContratante()));
        request.setFirmacrearpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFirmacrearpagrFamiliaNovedad()));
        request.setFirmacrearpagrNovedadesCTInstance(novedadCTSrv.getByOIDWithHV(request.getFirmacrearpagrNovedadesCT()));
        request.setFirmacrearpagrSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitud()));
        request.setFirmacrearpagrSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitudNovedad()));
        return firmaSrv.crearImplementation(request);
    }

    /*
     * Implements service crear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse crearImplementation(
            com.keralty.usuarios.viewmodel.firma.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        Solicitud firmacrearpagrSolicitudSegunda = request.getFirmacrearpagrSolicitudSegundaInstance();
        RespRegional firmacrearpagrRespRegional = request.getFirmacrearpagrRespRegionalInstance();
        Solicitud firmacrearpagrSolicitudContratante = request.getFirmacrearpagrSolicitudContratanteInstance();
        Solicitud firmacrearpagrSolicitud = request.getFirmacrearpagrSolicitudInstance();
        byte[] firmacrearpatrImagenFirma = request.getFirmacrearpatrImagenFirma();
        String firmacrearpatrLatitud = request.getFirmacrearpatrLatitud();
        String firmacrearpatrLongitud = request.getFirmacrearpatrLongitud();
        Firma instance = new Firma();
        if (firmacrearpagrSolicitudSegunda != null && !firmacrearpagrSolicitudSegunda.isNull()) {
            firmacrearpagrSolicitudSegunda.add2SegundaFirma(instance);
            instance.add2SolicitudSegunda(firmacrearpagrSolicitudSegunda);
        }

        if (firmacrearpagrRespRegional != null && !firmacrearpagrRespRegional.isNull()) {
            firmacrearpagrRespRegional.add2Firma(instance);
            instance.add2RespRegional(firmacrearpagrRespRegional);
        }

        if (firmacrearpagrSolicitudContratante != null && !firmacrearpagrSolicitudContratante.isNull()) {
            firmacrearpagrSolicitudContratante.add2FirmaContratanteIncl(instance);
            instance.add2SolicitudContratante(firmacrearpagrSolicitudContratante);
        }



        if (firmacrearpagrSolicitud != null && !firmacrearpagrSolicitud.isNull()) {
            firmacrearpagrSolicitud.add2Firma(instance);
            instance.add2Solicitud(firmacrearpagrSolicitud);
        }


        instance.setFirmaIdentificador(Long.valueOf(0));
        instance.setFirmaImagenFirma(firmacrearpatrImagenFirma);
        instance.setFirmaLatitud(firmacrearpatrLatitud);
        instance.setFirmaLongitud(firmacrearpatrLongitud);

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.usuarios.viewmodel.firma.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = firmaSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.usuarios.viewmodel.firma.siu.ModificarRequest request) throws ModelException {
        request.setFirmamodificarpthisFirmaInstance(firmaSrv.getByOIDWithHV(request.getFirmamodificarpthisFirma()));
        return firmaSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.usuarios.viewmodel.firma.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Firma firmamodificarpthisFirma = request.getFirmamodificarpthisFirmaInstance();
        byte[] firmamodificarpImagenFirma = request.getFirmamodificarpImagenFirma();
        String firmamodificarpLatitud = request.getFirmamodificarpLatitud();
        String firmamodificarpLongitud = request.getFirmamodificarpLongitud();

        request.checkArguments();
        Firma instance = firmamodificarpthisFirma;
        instance.setFirmaImagenFirma(firmamodificarpImagenFirma);
        instance.setFirmaLatitud(firmamodificarpLatitud);
        instance.setFirmaLongitud(firmamodificarpLongitud);


        response.setInstance(repository.save(instance));

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(RespRegionalConstants.CLASS_NAME)) applyHVFilter4RespRegional(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4RespRegional(SQLSelect sql, SQLWhereDisjunction disjunction) {
        // RespRegional = agent
        RespRegional agentInstance = getAgentRespRegional();
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FirmaConstants.ROLE_NAME_RESPREGIONAL, RespRegionalConstants.CLASS_NAME);
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, RespRegionalConstants.CLASS_NAME, RespRegionalConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
        comparison1.setSecondOperand(operand223);
        disjunction.addOperand(comparison1);

    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildFirmaRelatedInstance(relatedInstanceJsonOid);
        }
        if (FirmaConstants.ROLE_NAME_SOLICITUDNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_FAMILIANOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_NOVEDADESCT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4NovedadCT(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem) || FirmaConstants.ROLE_NAME_SOLICITUDSEGUNDA.equalsIgnoreCase(relatedInstancePathFirstItem) || FirmaConstants.ROLE_NAME_SOLICITUDCONTRATANTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_RESPREGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4RespRegional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildFirmaRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): solicitudNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): familiaNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4NovedadCT(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class)): novedadCTSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): solicitudSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4RespRegional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new RespRegional(mapper.readValue(relatedInstanceJsonOid, RespRegionalOid.class)): respRegionalSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FirmaOid oid = new FirmaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FirmaConstants.ATTR_FIELD_FIRMAIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFirmaIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FirmaService.class).error(e.getMessage());
        }
    }

}
