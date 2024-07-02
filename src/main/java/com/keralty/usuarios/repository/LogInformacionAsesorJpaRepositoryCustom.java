package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.LogInformacionAsesor;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface LogInformacionAsesorJpaRepositoryCustom {

    List<LogInformacionAsesor> solveQuery(SQLSelect query);
    
    List<LogInformacionAsesor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogInformacionAsesor> executeQuery(String query);

    public List<LogInformacionAsesor> executeQuery(String query, List<SQLParam> params);
}
