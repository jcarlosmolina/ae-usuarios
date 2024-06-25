package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class LogHistoricoPlanesJpaRepositoryImpl extends AbstractRepository implements LogHistoricoPlanesJpaRepositoryCustom {

    @Override
    public List<LogHistoricoPlanes> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<LogHistoricoPlanes> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<LogHistoricoPlanes> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<LogHistoricoPlanes> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, LogHistoricoPlanes.class);
    }
    
    public List<LogHistoricoPlanes> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<LogHistoricoPlanes> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
