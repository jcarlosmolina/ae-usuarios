package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface GrupoAsignacionJpaRepositoryCustom {

    List<GrupoAsignacion> solveQuery(SQLSelect query);
    
    List<GrupoAsignacion> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<GrupoAsignacion> executeQuery(String query);

    public List<GrupoAsignacion> executeQuery(String query, List<SQLParam> params);
}
