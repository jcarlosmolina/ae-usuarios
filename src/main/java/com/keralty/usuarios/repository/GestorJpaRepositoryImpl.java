package com.keralty.usuarios.repository;

import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.GestorConstants;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Gestor;
import com.keralty.usuarios.sqlutils.SQLJoin;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class GestorJpaRepositoryImpl extends AbstractRepository implements GestorJpaRepositoryCustom {

    @Override
    public List<Gestor> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Gestor> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Gestor> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Gestor> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Gestor.class);
    }
    
    public List<Gestor> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Gestor> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
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
        join.getWheres().add(myAlias + "." + GestorConstants.FLD_FUNCIONARIOID + " = " + parentAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID);
    }
}
