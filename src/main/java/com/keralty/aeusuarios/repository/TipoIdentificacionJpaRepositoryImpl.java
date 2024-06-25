package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class TipoIdentificacionJpaRepositoryImpl extends AbstractRepository implements TipoIdentificacionJpaRepositoryCustom {

    @Override
    public List<TipoIdentificacion> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<TipoIdentificacion> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<TipoIdentificacion> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<TipoIdentificacion> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, TipoIdentificacion.class);
    }
    
    public List<TipoIdentificacion> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<TipoIdentificacion> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }
}
