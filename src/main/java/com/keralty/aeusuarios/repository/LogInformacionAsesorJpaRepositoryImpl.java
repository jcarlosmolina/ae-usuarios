package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class LogInformacionAsesorJpaRepositoryImpl extends AbstractRepository implements LogInformacionAsesorJpaRepositoryCustom {

    @Override
    public List<LogInformacionAsesor> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<LogInformacionAsesor> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<LogInformacionAsesor> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<LogInformacionAsesor> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, LogInformacionAsesor.class);
    }
    
    public List<LogInformacionAsesor> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<LogInformacionAsesor> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
