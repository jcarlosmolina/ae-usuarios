package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.LogHistoricoPlanes;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface LogHistoricoPlanesJpaRepositoryCustom {

    List<LogHistoricoPlanes> solveQuery(SQLSelect query);
    
    List<LogHistoricoPlanes> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogHistoricoPlanes> executeQuery(String query);

    public List<LogHistoricoPlanes> executeQuery(String query, List<SQLParam> params);
}
