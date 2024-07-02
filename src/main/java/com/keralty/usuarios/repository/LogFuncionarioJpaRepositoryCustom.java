package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.LogFuncionario;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface LogFuncionarioJpaRepositoryCustom {

    List<LogFuncionario> solveQuery(SQLSelect query);
    
    List<LogFuncionario> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<LogFuncionario> executeQuery(String query);

    public List<LogFuncionario> executeQuery(String query, List<SQLParam> params);
}
