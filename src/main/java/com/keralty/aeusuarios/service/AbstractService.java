package com.keralty.aeusuarios.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Admin;
import com.keralty.aeusuarios.persistence.SuperAdmin;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.persistence.Gestor;
import com.keralty.aeusuarios.persistence.MesaDeApoyo;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.AdminOid;
import com.keralty.aeusuarios.persistence.oid.SuperAdminOid;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.AreaMedicaOid;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.oid.GestorOid;
import com.keralty.aeusuarios.persistence.oid.MesaDeApoyoOid;
import com.keralty.aeusuarios.repository.GenericRepository;
import com.keralty.aeusuarios.repository.SPBuilder;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.utils.Agent;
import com.keralty.aeusuarios.utils.QueryContext;
import com.keralty.aeusuarios.utils.Utilities;
import com.keralty.aeusuarios.viewmodel.FilterRequest;
import com.keralty.aeusuarios.viewmodel.FilterVariableRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;

@ApplicationScoped
public class AbstractService {

    @Inject
    GenericRepository genericRepository;

    @Inject
    Agent agentSrv;

    @Inject
    FuncionarioService funcionarioSrv;

    @Inject
    AdminService adminSrv;

    @Inject
    SuperAdminService superadminSrv;

    @Inject
    AsesorService asesorSrv;

    @Inject
    AreaMedicaService areamedicaSrv;

    @Inject
    AfiliacionesService afiliacionesSrv;

    @Inject
    RespRegionalService respregionalSrv;

    @Inject
    GestorService gestorSrv;

    @Inject
    MesaDeApoyoService mesadeapoyoSrv;

    protected QueryContext serCtx;
    
    public QueryContext getSerCtx() {
    	if (serCtx == null) {
    		serCtx = buildQueryContext();
    	}
    	return serCtx;
    }

    private QueryContext buildQueryContext() {
    	QueryContext queryContext = new QueryContext();
    	queryContext.setAgent(agentSrv);
    	return queryContext;
    }

    protected AbstractService() {

    }

    protected AbstractAppEntity getAgentInstance() {
        return funcionarioSrv != null ? funcionarioSrv.getById(Long.valueOf(getAgentName())) : null;
    }
    
    protected AbstractAppEntity getAgentInstance(String className) {
        if (Constants.FUNCIONARIO.equalsIgnoreCase(className))
            return getAgentFuncionario();
        if (Constants.ADMIN.equalsIgnoreCase(className))
            return getAgentAdmin();
        if (Constants.SUPERADMIN.equalsIgnoreCase(className))
            return getAgentSuperAdmin();
        if (Constants.ASESOR.equalsIgnoreCase(className))
            return getAgentAsesor();
        if (Constants.AREAMEDICA.equalsIgnoreCase(className))
            return getAgentAreaMedica();
        if (Constants.AFILIACIONES.equalsIgnoreCase(className))
            return getAgentAfiliaciones();
        if (Constants.RESPREGIONAL.equalsIgnoreCase(className))
            return getAgentRespRegional();
        if (Constants.GESTOR.equalsIgnoreCase(className))
            return getAgentGestor();
        if (Constants.MESADEAPOYO.equalsIgnoreCase(className))
            return getAgentMesaDeApoyo();
        return null;
    }


    protected Funcionario getAgentFuncionario() {
        return !getAgentName().startsWith("{")
                ? funcionarioSrv.getById(Long.valueOf(getAgentName()))
                : funcionarioSrv.getByOID(new FuncionarioOid().fromJsonString(getAgentName()));
    }

    protected Admin getAgentAdmin() {
        return !getAgentName().startsWith("{")
                ? adminSrv.getById(Long.valueOf(getAgentName()))
                : adminSrv.getByOID(new AdminOid().fromJsonString(getAgentName()));
    }

    protected SuperAdmin getAgentSuperAdmin() {
        return !getAgentName().startsWith("{")
                ? superadminSrv.getById(Long.valueOf(getAgentName()))
                : superadminSrv.getByOID(new SuperAdminOid().fromJsonString(getAgentName()));
    }

    protected Asesor getAgentAsesor() {
        return !getAgentName().startsWith("{")
                ? asesorSrv.getById(Long.valueOf(getAgentName()))
                : asesorSrv.getByOID(new AsesorOid().fromJsonString(getAgentName()));
    }

    protected AreaMedica getAgentAreaMedica() {
        return !getAgentName().startsWith("{")
                ? areamedicaSrv.getById(Long.valueOf(getAgentName()))
                : areamedicaSrv.getByOID(new AreaMedicaOid().fromJsonString(getAgentName()));
    }

    protected Afiliaciones getAgentAfiliaciones() {
        return !getAgentName().startsWith("{")
                ? afiliacionesSrv.getById(Long.valueOf(getAgentName()))
                : afiliacionesSrv.getByOID(new AfiliacionesOid().fromJsonString(getAgentName()));
    }

    protected RespRegional getAgentRespRegional() {
        return !getAgentName().startsWith("{")
                ? respregionalSrv.getById(Long.valueOf(getAgentName()))
                : respregionalSrv.getByOID(new RespRegionalOid().fromJsonString(getAgentName()));
    }

    protected Gestor getAgentGestor() {
        return !getAgentName().startsWith("{")
                ? gestorSrv.getById(Long.valueOf(getAgentName()))
                : gestorSrv.getByOID(new GestorOid().fromJsonString(getAgentName()));
    }

    protected MesaDeApoyo getAgentMesaDeApoyo() {
        return !getAgentName().startsWith("{")
                ? mesadeapoyoSrv.getById(Long.valueOf(getAgentName()))
                : mesadeapoyoSrv.getByOID(new MesaDeApoyoOid().fromJsonString(getAgentName()));
    }

    protected String getAgentName() {
        return agentSrv != null ? agentSrv.getAgentName() : "";
    }

    protected List<String> getAgentRoles() {
    	return agentSrv != null ? agentSrv.getAgentRoles() : new ArrayList<>();
    }

    protected List<Map<String, Object>> solveGenericQuery(QueryRequest request, String forClass) {
        List<Map<String, Object>> results;
        try {
            SQLPopulation query = new SQLPopulation(forClass, forClass, getDSItems(request));
            List<String> dsItems = getDSItems(request);

            results = genericRepository.solveQuery(query).stream().map(o -> buildDynamicObject(o, dsItems))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            results = new ArrayList<>();
        }
        return results;
    }

    private static List<String> getDSItems(QueryRequest request) {
        return Arrays.asList(request.getDisplaySetItems().split("\\,"));
    }

    private static Map<String, Object> buildDynamicObject(Object record, List<String> dsItems) {
        Map<String, Object> element = new HashMap<>();
        int dsItemCount = 0;
        Object[] queryRecord = (Object[]) record;
        for (String dsElement : dsItems) {
            element.put(dsElement, queryRecord[dsItemCount++]);
        }
        return element;
    }

    protected static Map<String, Object> buildDynamicObject(AbstractAppEntity instance, String displaySetAtributtes) {
        Map<String, Object> element = new HashMap<>();
        element.put("oid", instance.getOid().toJson());
        String dsElementNormalized = "";
        String dsElementWithDots = "";
        for (String dsElement : splitDSItems(displaySetAtributtes)) {
            dsElementWithDots = dsElement.trim();
            dsElementNormalized = dsElementWithDots.replace('.', '-');

            String dsElementName = getDSElementName(dsElementNormalized);
            String dsElementFields = getDSElementStructure(dsElementNormalized);

            if (!dsElementName.isEmpty() && !element.containsKey(dsElementName)) {
                if (dsElementFields.isEmpty()) {
                    element.put(dsElementName, instance.getAttribute(dsElementWithDots.replace("_", "")));
                } else {
                    element.put(dsElementName, buildDynamicRelation(instance, dsElementName, dsElementFields));
                }

            }
        }
        return element;
    }

    private static List<String> splitDSItems(String dsItems) {
        List<String> items = new ArrayList<>();
        String nextItem = getNextDSItem(dsItems);
        if (!nextItem.isEmpty())
            items.add(getNextDSItem(dsItems));
        String restOfDSItems = getRestOfDSItems(nextItem, dsItems);
        if (!restOfDSItems.isEmpty())
            items.addAll(splitDSItems(restOfDSItems));
        return items;
    }

    private static String getNextDSItem(String dsItems) {
        String result = dsItems;
        int separatorIndex = dsItems.indexOf(',');
        int relationStartIndex = dsItems.indexOf('(');
        if (separatorIndex > 0) {
            // Comma
            if (relationStartIndex > 0) {
                if (separatorIndex < relationStartIndex) {
                    result = dsItems.substring(0, separatorIndex);
                } else {
                    int relationEndIndex = getRelationEndIndex(dsItems, relationStartIndex);
                    result = dsItems.substring(0, relationEndIndex + 1);
                }
            } else {
                result = dsItems.substring(0, separatorIndex);
            }
        } else {
            // No comma
            if (relationStartIndex > 0) {
                int relationEndIndex = getRelationEndIndex(dsItems, relationStartIndex);
                result = dsItems.substring(0, relationEndIndex + 1);
            }
        }
        return result;
    }

    private static String getRestOfDSItems(String firstDSItem, String dsItems) {
        String result = dsItems.substring(firstDSItem.length());
        if (result.indexOf(',') == 0)
            result = result.substring(1);
        return result.trim();
    }

    private static int getRelationEndIndex(String dsItems, int startingIndex) {
        int endIndex = -1;
        int openParenCount = 0;
        for (int i = startingIndex; i < dsItems.length(); i++) {
            openParenCount += (dsItems.charAt(i) == '(' ? 1 : 0);
            if (dsItems.charAt(i) == ')') {
                openParenCount--;
                if (openParenCount == 0) {
                    endIndex = i;
                    break;
                }
            }
        }
        return endIndex;
    }

    private static String getDSElementName(String dsElementNormalized) {
        int index = dsElementNormalized.indexOf('(');
        return (index < 0 ? dsElementNormalized : dsElementNormalized.substring(0, index));
    }

    private static String getDSElementStructure(String dsElementNormalized) {
        int startIndex = dsElementNormalized.indexOf('(');
        int endIndex = dsElementNormalized.lastIndexOf(')');

        return (startIndex > 0 && endIndex > 0 ? dsElementNormalized.substring(startIndex + 1, endIndex) : "");
    }

    private static Object buildDynamicRelation(AbstractAppEntity instance, String relationName,
            String relationAttributes) {
        if (instance.hasRelation(relationName)) {
            if (instance.isUnivaluedRelation(relationName)) {
                return buildDynamicObject(instance.getRelatedInstance(relationName), relationAttributes);
            } else {
                return buildDynamicObjectCollection(instance, relationName, relationAttributes);
            }
        } else {
            return null;
        }
    }

    private static List<Map<String, Object>> buildDynamicObjectCollection(AbstractAppEntity instance,
            String relationName, String displaySetItems) {
        List<Map<String, Object>> items = new ArrayList<>();
        for (AbstractAppEntity relatedInstance : instance.getRelatedInstances(relationName)) {
            items.add(buildDynamicObject(relatedInstance, displaySetItems));
        }
        return items;
    }

    protected SQLPopulation processQueryRequest(QueryRequest queryRequest, String className) {
        SQLPopulation sql;
        try {
            sql = new SQLPopulation(className);
            processQuery(queryRequest, sql);
        } catch (Exception e) {
            sql = null;
        }
        return sql;
    }

    protected SQLCount processCountQueryRequest(QueryRequest queryRequest, String className) {
    	SQLCount sql;
    	try {
    		sql = new SQLCount(null, className, className);
    		processQuery(queryRequest, sql);
        } catch (Exception e) {
            sql = null;
        }
    	return sql;
    }
    
    protected void processQuery(QueryRequest queryRequest, SQLSelect select) throws SystemException {
        applyFilters(queryRequest, select);
        applyOrderCriteria(queryRequest, select);
    }

    protected void applyFilters(QueryRequest queryRequest, SQLSelect select) throws SystemException {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            applyFilter(filterRequest, select);
        }
        applyHVFilter(select);
    }

    protected void applyFilter(FilterRequest filterRequest, SQLSelect select) throws SystemException {
        if (Constants.FILTER_BY_OID.equalsIgnoreCase(filterRequest.getName()))
            applyFilterByOid(filterRequest.getFilterVariable(Constants.FILTER_BY_OID_FVAR_OID).toString(), select);
        if (Constants.FILTER_BY_RELATED.equals(filterRequest.getName()))
            applyFilterByRelated(filterRequest, select);
        applyQueryFilters(filterRequest, select);
        applyNavigationalFilters(filterRequest, select);
        applyServiceSIFilters(filterRequest, select);
    }
    
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect select) throws SystemException {
    	// To be implemented in each concrete class
    }
    
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect select) throws SystemException {
    	// To be implemented in each concrete class
    }
    
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect select) {
    	// To be implemented in each concrete class
    }

    protected void applyHVFilter(SQLSelect select) throws SystemException {
        // To be implemented in each concrete class
    }
    
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
    	// To be implemented in each concrete class
    }
    
    protected void applyDSItemSort(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isEmpty()) {
            select.getOrderByPart().addItem(queryRequest.getDsItemSort(), queryRequest.isDsItemSortAscending());
        }
    }
    
    protected void applyFilterByRelated(FilterRequest filterRequest, SQLSelect select) {
        try {
            String relatedInstancePath = filterRequest.getFilterVariable("relatedInstancePath").toString().replace("_","");
            String relatedInstanceOid = filterRequest.getFilterVariable("relatedInstanceOid").toString();
            AbstractAppEntity relatedInstance = getRelatedInstance(relatedInstanceOid, relatedInstancePath);
            String relatedInstanceDomain = relatedInstance.getClass().getSimpleName();
            SQLWhereComparison comparison = new SQLWhereComparison(select);
            comparison.setOperator("=");
            comparison.setFirstOperand(new SQLWhereOperandPathInstance(relatedInstancePath, relatedInstanceDomain));
            comparison.setSecondOperand(new SQLWhereOperandOVParameter("", relatedInstanceDomain, relatedInstanceDomain,
                    relatedInstance.getOid(), ""));
            select.addComparison(comparison);
        } catch (Exception e) {
            LoggerFactory.getLogger(AbstractService.class).error(e.getMessage());
        }
    }

    /*
     * Returns an instance with a certain structure
     *
     * @param queryRequest Request containing the jsonOID of the instance and the
     * displaySetItems dictating the structure to retrieve
     *
     * @return Instance matching the jsonOID
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getInstanceDynamic(QueryRequest queryRequest) {
        return new InstanceResponseViewModel(this.getByJsonOid(queryRequest.getJsonOID()), queryRequest.getDisplaySetItems());
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public AbstractAppEntity getByJsonOid(String jsonOid) {
        return null;
    }
    
    protected AbstractAppEntity getRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        return buildRelatedInstance(relatedInstanceJsonOid, relatedInstancePath);
    }
    
    /*
     * Builds an instance reached from a JSON oid through a given path
     *
     * @param relatedInstanceJsonOid JSON oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @return Related instance
     */
    public AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstanceJsonOid != null && relatedInstancePath != null) {
            List<String> relatedInstancePathItems = new ArrayList<>(Arrays.asList(relatedInstancePath.split("\\.")));
            String pathItem = relatedInstancePathItems.remove(0);
            String remainingPath = String.join(".", relatedInstancePathItems);
            relatedInstance = buildRelatedInstance(relatedInstanceJsonOid, pathItem, remainingPath);
        }
        return relatedInstance;
    }

    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
    	if (relatedInstanceJsonOid.isEmpty() || relatedInstancePathFirstItem.isEmpty() || remainingPath.isEmpty())
    		throw new UnsupportedOperationException();
    	return null;
    }

    protected void applyFilterByOid(String jsonOid, SQLSelect select) {
        // To be implemented in each concrete class
    }
    
    protected FilterRequest buildFilterByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return buildFilterByRelated(relatedInstance != null ? relatedInstance.getOid().toJson() : "",
                relatedInstancePath);

    }

    protected FilterRequest buildFilterByRelated(String relatedInstanceJsonOid, String relatedInstancePath) {
        return relatedInstanceJsonOid.isEmpty() || relatedInstancePath.isEmpty() ? null
                : new FilterRequest(Constants.FILTER_BY_RELATED,
                        Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                                new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid)));
    }
    
    protected String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            json = "";
        }
        return json;
    }
    
    @SuppressWarnings("unchecked")
    protected List<String> toJsonArray(Object obj) {
    	return (List<String>)obj;
    }

    protected String encrypt(String originalText) {
        return Utilities.encrypt(originalText);
    }
 
    protected SPBuilder getSPBuilder() {
    	return genericRepository.getSPBuilder();
    }
}
