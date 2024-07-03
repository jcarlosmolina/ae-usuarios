package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class LogFuncionarioJpaRepositoryImpl extends AbstractRepository implements LogFuncionarioJpaRepositoryCustom {

    @Override
    public List<LogFuncionario> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<LogFuncionario> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<LogFuncionario> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<LogFuncionario> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, LogFuncionario.class);
    }
    
    public List<LogFuncionario> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<LogFuncionario> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
