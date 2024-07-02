package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.RespRegionalConstants;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLJoin;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class RespRegionalJpaRepositoryImpl extends AbstractRepository implements RespRegionalJpaRepositoryCustom {

    @Override
    public List<RespRegional> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<RespRegional> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<RespRegional> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<RespRegional> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, RespRegional.class);
    }
    
    public List<RespRegional> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<RespRegional> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Funcionario findParent(Long oid) {
        return em.find(Funcionario.class, oid);
    }

    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param parentAlias Alias of the parent entity.
     */
    public void addFacetWhereparentfuncionario (String myAlias, SQLJoin join, String parentAlias) {
        join.getWheres().add(myAlias + "." + RespRegionalConstants.FLD_FUNCIONARIOID + " = " + parentAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID);
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(RespRegional instance) throws SystemException {
        try {
            // EXIST (Regional)
            return assocOperator001Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: RespRegional, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (RespRegional instance) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(instance);
        return !new TypedQueryBuilder<RespRegional>(em, RespRegional.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (RespRegional instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(RespRegionalConstants.CLASS_NAME, RespRegionalConstants.ROLE_NAME_REGIONAL, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: RespRegional, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Boolean assocOperator003(RespRegional instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: RespRegional, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Boolean assocOperator003Range1 (RespRegional instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<RespRegional>(em, RespRegional.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLExists assocOperator003Range1Query (RespRegional instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(RespRegionalConstants.CLASS_NAME, RespRegionalConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: RespRegional, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }
}
