package com.keralty.usuarios.repository;

import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.SuperAdminConstants;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.SuperAdmin;
import com.keralty.usuarios.sqlutils.SQLJoin;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class SuperAdminJpaRepositoryImpl extends AbstractRepository implements SuperAdminJpaRepositoryCustom {

    @Override
    public List<SuperAdmin> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<SuperAdmin> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<SuperAdmin> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<SuperAdmin> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, SuperAdmin.class);
    }
    
    public List<SuperAdmin> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<SuperAdmin> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
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
        join.getWheres().add(myAlias + "." + SuperAdminConstants.FLD_FUNCIONARIOID + " = " + parentAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID);
    }
}
