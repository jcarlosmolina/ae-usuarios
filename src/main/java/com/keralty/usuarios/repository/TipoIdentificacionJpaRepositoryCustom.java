package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.TipoIdentificacion;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface TipoIdentificacionJpaRepositoryCustom {

    List<TipoIdentificacion> solveQuery(SQLSelect query);
    
    List<TipoIdentificacion> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<TipoIdentificacion> executeQuery(String query);

    public List<TipoIdentificacion> executeQuery(String query, List<SQLParam> params);
}
