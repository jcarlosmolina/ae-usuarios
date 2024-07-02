package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Gestor;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface GestorJpaRepositoryCustom {

    List<Gestor> solveQuery(SQLSelect query);
    
    List<Gestor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Gestor> executeQuery(String query);

    public List<Gestor> executeQuery(String query, List<SQLParam> params);
}
