package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Afiliaciones;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface AfiliacionesJpaRepositoryCustom {

    List<Afiliaciones> solveQuery(SQLSelect query);
    
    List<Afiliaciones> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Afiliaciones> executeQuery(String query);

    public List<Afiliaciones> executeQuery(String query, List<SQLParam> params);
}
