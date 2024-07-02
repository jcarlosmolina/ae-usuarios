package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.FrecuenciaAct;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class FrecuenciaActJpaRepositoryImpl extends AbstractRepository implements FrecuenciaActJpaRepositoryCustom {

    @Override
    public List<FrecuenciaAct> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<FrecuenciaAct> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<FrecuenciaAct> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<FrecuenciaAct> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, FrecuenciaAct.class);
    }
    
    public List<FrecuenciaAct> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<FrecuenciaAct> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
