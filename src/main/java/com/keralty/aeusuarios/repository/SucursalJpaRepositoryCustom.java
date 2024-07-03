package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface SucursalJpaRepositoryCustom {

    List<Sucursal> solveQuery(SQLSelect query);
    
    List<Sucursal> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<Sucursal> executeQuery(String query);

    public List<Sucursal> executeQuery(String query, List<SQLParam> params);
}
