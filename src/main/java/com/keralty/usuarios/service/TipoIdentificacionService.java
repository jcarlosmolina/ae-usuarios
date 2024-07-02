package com.keralty.usuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.TipoIdentificacionConstants;
import com.keralty.usuarios.persistence.AbstractAppEntity;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.Contratante;
import com.keralty.usuarios.persistence.FamiliaNovedad;
import com.keralty.usuarios.persistence.NovedadCT;
import com.keralty.usuarios.persistence.oid.AsesorOid;
import com.keralty.usuarios.persistence.oid.ContratanteOid;
import com.keralty.usuarios.persistence.oid.FamiliaNovedadOid;
import com.keralty.usuarios.persistence.oid.NovedadCTOid;
import com.keralty.usuarios.persistence.oid.PersonaCOid;
import com.keralty.usuarios.persistence.oid.PersonaOid;
import com.keralty.usuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.usuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.usuarios.persistence.oid.TitularOid;
import com.keralty.usuarios.persistence.oid.UsuarioNovedadOid;
import com.keralty.usuarios.persistence.oid.UsuarioOid;
import com.keralty.usuarios.persistence.Persona;
import com.keralty.usuarios.persistence.PersonaC;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.persistence.TipoIdentificacion;
import com.keralty.usuarios.persistence.Titular;
import com.keralty.usuarios.persistence.Usuario;
import com.keralty.usuarios.persistence.UsuarioNovedad;
import com.keralty.usuarios.repository.TipoIdentificacionJpaRepository;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.usuarios.viewmodel.FilterRequest;
import com.keralty.usuarios.viewmodel.FilterVariableRequest;
import com.keralty.usuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.usuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.usuarios.viewmodel.PreloadViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.ServiceResponse;
import com.keralty.usuarios.viewmodel.tipoidentificacion.crud.TipoIdentificacionPostViewModel;
import com.keralty.usuarios.viewmodel.tipoidentificacion.crud.TipoIdentificacionPutViewModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class TipoIdentificacionService extends AbstractService {

    @Inject
    TipoIdentificacionJpaRepository repository;

    @Inject
    TipoIdentificacionService tipoIdentificacionSrv;

    @Inject
    AsesorService asesorSrv;

    @RestClient
    PersonaService personaSrv;

    @RestClient
    PersonaCService personaCSrv;

    @RestClient
    UsuarioService usuarioSrv;

    @RestClient
    ContratanteService contratanteSrv;

    @RestClient
    TitularService titularSrv;

    @Inject
    SolicitudNovedadService solicitudNovedadSrv;

    @RestClient
    FamiliaNovedadService familiaNovedadSrv;

    @RestClient
    UsuarioNovedadService usuarioNovedadSrv;

    @RestClient
    NovedadCTService novedadCTSrv;
    
    public TipoIdentificacion post(TipoIdentificacionPostViewModel payload) {
        TipoIdentificacion instance = new TipoIdentificacion();
        instance.setTipoIdentificacionCodigo(payload.getTipoIdentificacionCodigo());
        instance.setTipoIdentificacionDescripcion(payload.getTipoIdentificacionDescripcion());
        instance.setTipoIdentificacionNombreCorto(payload.getTipoIdentificacionNombreCorto());
        instance.setTipoIdentificacionValidoContratante(payload.getTipoIdentificacionValidoContratante());
        instance.setTipoIdentificacionValidoTitular(payload.getTipoIdentificacionValidoTitular());
        instance.setTipoIdentificacionDiplomatico(payload.getTipoIdentificacionDiplomatico());
        instance.setTipoIdentificacionNIT(payload.getTipoIdentificacionNIT());
        instance.setTipoIdentificacionHijoDe(payload.getTipoIdentificacionHijoDe());
        instance.setTipoIdentificacionRequiereEPS(payload.getTipoIdentificacionRequiereEPS());
        instance.setTipoIdentificacionMenorSinIdentificar(payload.getTipoIdentificacionMenorSinIdentificar());
        instance.setTipoIdentificacionEsPasaporte(payload.getTipoIdentificacionEsPasaporte());
        instance.setTipoIdentificacionVisibleValidadorUsu(payload.getTipoIdentificacionVisibleValidadorUsu());
        return repository.save(instance);
    }

    public TipoIdentificacion put(Long tipoIdentificacionCodigo, TipoIdentificacionPutViewModel payload) throws ModelException {
        if (!repository.existsById(tipoIdentificacionCodigo)) throw new ModelException("Not found-Put");
        TipoIdentificacion instance = new TipoIdentificacion(new TipoIdentificacionOid(tipoIdentificacionCodigo));
        instance.setTipoIdentificacionDescripcion(payload.getTipoIdentificacionDescripcion());
        instance.setTipoIdentificacionNombreCorto(payload.getTipoIdentificacionNombreCorto());
        instance.setTipoIdentificacionValidoContratante(payload.getTipoIdentificacionValidoContratante());
        instance.setTipoIdentificacionValidoTitular(payload.getTipoIdentificacionValidoTitular());
        instance.setTipoIdentificacionDiplomatico(payload.getTipoIdentificacionDiplomatico());
        instance.setTipoIdentificacionNIT(payload.getTipoIdentificacionNIT());
        instance.setTipoIdentificacionHijoDe(payload.getTipoIdentificacionHijoDe());
        instance.setTipoIdentificacionRequiereEPS(payload.getTipoIdentificacionRequiereEPS());
        instance.setTipoIdentificacionMenorSinIdentificar(payload.getTipoIdentificacionMenorSinIdentificar());
        instance.setTipoIdentificacionEsPasaporte(payload.getTipoIdentificacionEsPasaporte());
        instance.setTipoIdentificacionVisibleValidadorUsu(payload.getTipoIdentificacionVisibleValidadorUsu());
        return repository.save(instance);
    }

    public void delete(Long tipoIdentificacionCodigo) throws ModelException {
        if (!repository.existsById(tipoIdentificacionCodigo)) throw new ModelException("Not found-Delete");
        repository.deleteById(tipoIdentificacionCodigo);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, TipoIdentificacionConstants.CLASS_NAME);
    }

    private List<TipoIdentificacion> solveTipoIdentificacionTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, TipoIdentificacionConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveTipoIdentificacionTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, TipoIdentificacionConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class TipoIdentificacion
     *
     * @return Population of class TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> get() {
        List<TipoIdentificacion> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class TipoIdentificacion
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<TipoIdentificacion> instances = get(queryRequest);
        if(TipoIdentificacionConstants.DSICTIPOIDENTIFICACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICTipoIdentificacion())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet ICTipoIdentificacion for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet ICTipoIdentificacion for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.usuarios.viewmodel.tipoidentificacion.ds.ICTipoIdentificacion getICTipoIdentificacion(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        TipoIdentificacion instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.tipoidentificacion.ds.ICTipoIdentificacion(instance);
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
    public com.keralty.usuarios.viewmodel.tipoidentificacion.ds.AutoDS getAutoDS(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        TipoIdentificacion instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.keralty.usuarios.viewmodel.tipoidentificacion.ds.AutoDS(instance);
    }

    /*
     * Returns the population of class TipoIdentificacion that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class TipoIdentificacion matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> get(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveTipoIdentificacionTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveTipoIdentificacionTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveTipoIdentificacionTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveTipoIdentificacionTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of TipoIdentificacion by ID
     *
     * @param tipoIdentificacionCodigo Identification field tipoIdentificacionCodigo
     *
     * @return Instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoIdentificacion getById(Long tipoIdentificacionCodigo) {
        return getByOID(new TipoIdentificacionOid(tipoIdentificacionCodigo));
    }
    
    /*
     * Returns an instance of TipoIdentificacion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoIdentificacion getByOID(TipoIdentificacionOid oid) {
        Optional<TipoIdentificacion> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of TipoIdentificacion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoIdentificacion getByOIDWithHV(TipoIdentificacionOid oid) {
        Optional<TipoIdentificacion> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<TipoIdentificacion> getInstanceByOid(TipoIdentificacionOid oid) {
        return oid != null && oid.getTipoIdentificacionCodigo() != null
               ? repository.findById(oid.getTipoIdentificacionCodigo())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of TipoIdentificacion by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of TipoIdentificacion
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoIdentificacion getByJsonOid(String jsonOid) {
        TipoIdentificacionOid oid = new TipoIdentificacionOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of TipoIdentificacion related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveTipoIdentificacionTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of TipoIdentificacion related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<TipoIdentificacion> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of TipoIdentificacion
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of TipoIdentificacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getTipoIdentificacionDynamic(TipoIdentificacionOid oid, String displaySetItems) {
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
    public String getSuppInfo(TipoIdentificacionOid oid, String dsName) {
        TipoIdentificacion instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(TipoIdentificacion instance, String dsName) {
        if (TipoIdentificacionConstants.DSICTIPOIDENTIFICACION.equals(dsName))
            return instance.buildICTipoIdentificacion();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(TipoIdentificacion instance, String dsName) {
        if (TipoIdentificacionConstants.DSICTIPOIDENTIFICACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICTipoIdentificacion());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (TipoIdentificacionConstants.FILTER_NAME_IFTIPOIDENTIFICACIONNOMBREC.equalsIgnoreCase(filterRequest.getName()))
            iFTipoIdentificacionNombreC(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Persona_TADDUSUARIOASOL_pt_p_agrTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600805FiltNav10(sql);
        if ("Solicitud_TINDICARCONTRATANTE2_pt_p_evcTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav32(sql);
        if ("Solicitud_TINDICARTITULAR2_pt_p_agrTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav31(sql);
        if ("Usuario_TMODUSUARIO_pt_p_evcTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1432633737216826FiltNav3(sql);
        if ("UsuarioNovedad_TCAMBIARTIPOIDENT_pt_p_evcTipoIdentificacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1581442138112529FiltNav4(sql);
        if ("TGValidadorUsuarios_ptTipoDoc_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            iGl1658391625728650FiltNav1(sql);
        if ("Persona_F_PersonaConsultarCORE_vo_TipoIdentificacion_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600805FiltNav6(sql);
        if ("Persona_F_PersonaConsultarCORENat_vo_TipoIdentificacion_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600805FiltNav8(sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_TipoIdentificacion".equals(filterRequest.getName()))
            suppInfo4ICTipoIdentificacion(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void iFTipoIdentificacionNombreC(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vNombreCorto = filterRequest.hasFilterVariable(TipoIdentificacionConstants.VAR_NAME_IFTIPOIDENTIFICACIONNOMBREC_VNOMBRECORTO) ? (String) filterRequest.getFilterVariable(TipoIdentificacionConstants.VAR_NAME_IFTIPOIDENTIFICACIONNOMBREC_VNOMBRECORTO, FilterVariableRequest.STRING) : null;

        // NombreCorto = vNombreCorto
        if (vNombreCorto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vNombreCorto, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1431886233600805FiltNav10(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // NIT = false
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNIT, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
        comparison1.setSecondOperand(operand223);
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav32(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // ValidoContratante = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONVALIDOCONTRATANTE, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
        comparison1.setSecondOperand(operand223);
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav31(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // ValidoTitular = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONVALIDOTITULAR, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
        comparison1.setSecondOperand(operand223);
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1432633737216826FiltNav3(SQLSelect sql) {
        clas1431886233600805FiltNav10(sql);
    }

    private void clas1581442138112529FiltNav4(SQLSelect sql) {
        clas1431886233600805FiltNav10(sql);
    }

    private void iGl1658391625728650FiltNav1(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // VisibleValidadorUsu = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONVISIBLEVALIDADORUSU, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
        comparison1.setSecondOperand(operand223);
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431886233600805FiltNav6(SQLSelect sql) {
        clas1431957012480960FiltNav32(sql);
    }

    private void clas1431886233600805FiltNav8(SQLSelect sql) {
        clas1431957012480960FiltNav32(sql);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUTipoIdentificacion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for TipoIdentificacion using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.usuarios.viewmodel.tipoidentificacion.ds.AutoDS> piuPIUTipoIdentificacion(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest).stream()
                .map(com.keralty.usuarios.viewmodel.tipoidentificacion.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTipoIdentificacion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTipoIdentificacion
     */
    public int getCount4PIUTipoIdentificacion(QueryRequest queryRequest) {
        return solveTipoIdentificacionTypedQuery(queryRequest).size();
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
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.crearTxn(request);
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
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.CrearRequest request) throws ModelException {
        return tipoIdentificacionSrv.crearImplementation(request);
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
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Long tipoIdentificacioncrearpatrCodigo = request.getTipoIdentificacioncrearpatrCodigo();
        String tipoIdentificacioncrearpatrDescripcion = request.getTipoIdentificacioncrearpatrDescripcion();
        String tipoIdentificacioncrearpatrNombreCorto = request.getTipoIdentificacioncrearpatrNombreCorto();
        Boolean tipoIdentificacioncrearpatrValidoContratante = request.getTipoIdentificacioncrearpatrValidoContratante();
        Boolean tipoIdentificacioncrearpatrValidoTitular = request.getTipoIdentificacioncrearpatrValidoTitular();
        Boolean tipoIdentificacioncrearpatrDiplomatico = request.getTipoIdentificacioncrearpatrDiplomatico();
        Boolean tipoIdentificacioncrearpatrNIT = request.getTipoIdentificacioncrearpatrNIT();
        Boolean tipoIdentificacioncrearpatrHijoDe = request.getTipoIdentificacioncrearpatrHijoDe();
        Boolean tipoIdentificacioncrearpatrRequiereEPS = request.getTipoIdentificacioncrearpatrRequiereEPS();
        Boolean tipoIdentificacioncrearpatrMenorSinIdentificar = request.getTipoIdentificacioncrearpatrMenorSinIdentificar();
        Boolean tipoIdentificacioncrearpatrEsPasaporte = request.getTipoIdentificacioncrearpatrEsPasaporte();
        Boolean tipoIdentificacioncrearpatrVisibleValidadorUsu = request.getTipoIdentificacioncrearpatrVisibleValidadorUsu();

        request.checkArguments();
        TipoIdentificacion instance = new TipoIdentificacion();
        instance.setTipoIdentificacionCodigo(tipoIdentificacioncrearpatrCodigo);
        instance.setTipoIdentificacionDescripcion(tipoIdentificacioncrearpatrDescripcion);
        instance.setTipoIdentificacionNombreCorto(tipoIdentificacioncrearpatrNombreCorto);
        instance.setTipoIdentificacionValidoContratante(tipoIdentificacioncrearpatrValidoContratante);
        instance.setTipoIdentificacionValidoTitular(tipoIdentificacioncrearpatrValidoTitular);
        instance.setTipoIdentificacionDiplomatico(tipoIdentificacioncrearpatrDiplomatico);
        instance.setTipoIdentificacionNIT(tipoIdentificacioncrearpatrNIT);
        instance.setTipoIdentificacionHijoDe(tipoIdentificacioncrearpatrHijoDe);
        instance.setTipoIdentificacionRequiereEPS(tipoIdentificacioncrearpatrRequiereEPS);
        instance.setTipoIdentificacionMenorSinIdentificar(tipoIdentificacioncrearpatrMenorSinIdentificar);
        instance.setTipoIdentificacionEsPasaporte(tipoIdentificacioncrearpatrEsPasaporte);
        instance.setTipoIdentificacionVisibleValidadorUsu(tipoIdentificacioncrearpatrVisibleValidadorUsu);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: sincronizar

    /*
     * Entry point for service sincronizar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse sincronizar(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.SincronizarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.sincronizarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service sincronizar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse sincronizarTxn(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.SincronizarRequest request) throws ModelException {
        request.setTipoIdentificacionsincronizarpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getTipoIdentificacionsincronizarpthisTipoIdentificacion()));
        return tipoIdentificacionSrv.sincronizarImplementation(request);
    }

    /*
     * Implements service sincronizar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse sincronizarImplementation(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.SincronizarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionsincronizarpthisTipoIdentificacion = request.getTipoIdentificacionsincronizarpthisTipoIdentificacionInstance();
        String tipoIdentificacionsincronizarpDescripcion = request.getTipoIdentificacionsincronizarpDescripcion();
        String tipoIdentificacionsincronizarpNombreCorto = request.getTipoIdentificacionsincronizarpNombreCorto();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionsincronizarpthisTipoIdentificacion;
        instance.setTipoIdentificacionDescripcion(tipoIdentificacionsincronizarpDescripcion);
        instance.setTipoIdentificacionNombreCorto(tipoIdentificacionsincronizarpNombreCorto);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: InsTipoIdentificacionAsesor

    /*
     * Entry point for service InsTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoIdentificacionAsesor(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.insTipoIdentificacionAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoIdentificacionAsesorTxn(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionAsesorRequest request) throws ModelException {
        request.setTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion()));
        request.setTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance(asesorSrv.getByOIDWithHV(request.getTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor()));
        return tipoIdentificacionSrv.insTipoIdentificacionAsesorImplementation(request, true);
    }

    /*
     * Implements service InsTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoIdentificacionAsesorImplementation(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionAsesorRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion = request.getTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance();
        Asesor tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor = request.getTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.usuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest relatedRequest = new com.keralty.usuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest();
            relatedRequest.setAsesorInsTipoIdentificacionAsesorpthisAsesorInstance(tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor);
            relatedRequest.setAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance(tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion);
            asesorSrv.insTipoIdentificacionAsesorImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }

    // Service: DelTipoIdentificacionAsesor

    /*
     * Entry point for service DelTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoIdentificacionAsesor(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = tipoIdentificacionSrv.delTipoIdentificacionAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoIdentificacionAsesorTxn(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionAsesorRequest request) throws ModelException {
        request.setTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion()));
        request.setTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance(asesorSrv.getByOIDWithHV(request.getTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor()));
        return tipoIdentificacionSrv.delTipoIdentificacionAsesorImplementation(request, true);
    }

    /*
     * Implements service DelTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoIdentificacionAsesorImplementation(
            com.keralty.usuarios.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionAsesorRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        TipoIdentificacion tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion = request.getTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance();
        Asesor tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor = request.getTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance();

        request.checkArguments();
        TipoIdentificacion instance = tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion;

        if (isEntryPoint) {
            com.keralty.usuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest relatedRequest = new com.keralty.usuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest();
            relatedRequest.setAsesorDelTipoIdentificacionAsesorpthisAsesorInstance(tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor);
            relatedRequest.setAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance(tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion);
            asesorSrv.delTipoIdentificacionAsesorImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICTipoIdentificacion());

        return response;
    }


    private void suppInfo4ICTipoIdentificacion(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(select);
            comparison2.setOperator("LIKE");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONDESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison2);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCTipoIdentificacion(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCTipoIdentificacion(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_TipoIdentificacion".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildTipoIdentificacionRelatedInstance(relatedInstanceJsonOid);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_ASESORES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_PERSONAS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Persona(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_PERSONASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_USUARIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Usuario(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_CONTRATANTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Contratante(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_TITULARES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4Titular(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_FAMILIASNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_USUARIOSNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || TipoIdentificacionConstants.ROLE_NAME_USUARIONOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4UsuarioNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (TipoIdentificacionConstants.ROLE_NAME_NOVEDADESCT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTipoIdentificacionRelatedInstance4NovedadCT(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildTipoIdentificacionRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class)): asesorSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Persona(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Persona(mapper.readValue(relatedInstanceJsonOid, PersonaOid.class)): personaSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): personaCSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Usuario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Usuario(mapper.readValue(relatedInstanceJsonOid, UsuarioOid.class)): usuarioSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Contratante(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Contratante(mapper.readValue(relatedInstanceJsonOid, ContratanteOid.class)): contratanteSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4Titular(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Titular(mapper.readValue(relatedInstanceJsonOid, TitularOid.class)): titularSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): solicitudNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): familiaNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4UsuarioNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new UsuarioNovedad(mapper.readValue(relatedInstanceJsonOid, UsuarioNovedadOid.class)): usuarioNovedadSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTipoIdentificacionRelatedInstance4NovedadCT(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class)): novedadCTSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            TipoIdentificacionOid oid = new TipoIdentificacionOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.ATTR_FIELD_TIPOIDENTIFICACIONCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTipoIdentificacionCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TipoIdentificacionService.class).error(e.getMessage());
        }
    }

}
