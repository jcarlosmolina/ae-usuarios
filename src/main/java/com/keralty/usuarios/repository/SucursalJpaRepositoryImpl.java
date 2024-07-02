package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Sucursal;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class SucursalJpaRepositoryImpl extends AbstractRepository implements SucursalJpaRepositoryCustom {

    @Override
    public List<Sucursal> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Sucursal> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Sucursal> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Sucursal> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Sucursal.class);
    }
    
    public List<Sucursal> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Sucursal> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
