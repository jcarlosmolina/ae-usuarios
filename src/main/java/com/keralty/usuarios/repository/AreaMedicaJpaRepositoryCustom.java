package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.AreaMedica;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface AreaMedicaJpaRepositoryCustom {

    List<AreaMedica> solveQuery(SQLSelect query);
    
    List<AreaMedica> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<AreaMedica> executeQuery(String query);

    public List<AreaMedica> executeQuery(String query, List<SQLParam> params);
}
