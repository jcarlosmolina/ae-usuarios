package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class GrupoAsignacionJpaRepositoryImpl extends AbstractRepository implements GrupoAsignacionJpaRepositoryCustom {

    @Override
    public List<GrupoAsignacion> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<GrupoAsignacion> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<GrupoAsignacion> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<GrupoAsignacion> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, GrupoAsignacion.class);
    }
    
    public List<GrupoAsignacion> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<GrupoAsignacion> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
