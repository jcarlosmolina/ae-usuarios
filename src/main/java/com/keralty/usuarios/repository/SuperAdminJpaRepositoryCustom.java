package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.SuperAdmin;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface SuperAdminJpaRepositoryCustom {

    List<SuperAdmin> solveQuery(SQLSelect query);
    
    List<SuperAdmin> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<SuperAdmin> executeQuery(String query);

    public List<SuperAdmin> executeQuery(String query, List<SQLParam> params);
}
