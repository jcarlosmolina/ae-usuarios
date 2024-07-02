package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class RegionalJpaRepositoryImpl extends AbstractRepository implements RegionalJpaRepositoryCustom {

    @Override
    public List<Regional> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Regional> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Regional> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Regional> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Regional.class);
    }
    
    public List<Regional> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Regional> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
