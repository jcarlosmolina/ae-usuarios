package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Admin;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface AdminJpaRepositoryCustom {

    List<Admin> solveQuery(SQLSelect query);
    
    List<Admin> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<Admin> executeQuery(String query);

    public List<Admin> executeQuery(String query, List<SQLParam> params);
}
