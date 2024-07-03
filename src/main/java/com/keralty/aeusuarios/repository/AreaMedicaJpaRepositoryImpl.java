package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.sqlutils.SQLJoin;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class AreaMedicaJpaRepositoryImpl extends AbstractRepository implements AreaMedicaJpaRepositoryCustom {

    @Override
    public List<AreaMedica> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<AreaMedica> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<AreaMedica> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<AreaMedica> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, AreaMedica.class);
    }
    
    public List<AreaMedica> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<AreaMedica> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
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
        join.getWheres().add(myAlias + "." + AreaMedicaConstants.FLD_FUNCIONARIOID + " = " + parentAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID);
    }
}
