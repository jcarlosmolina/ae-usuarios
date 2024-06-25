package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import java.util.List;

public interface AreaMedicaJpaRepositoryCustom {

    List<AreaMedica> solveQuery(SQLSelect query);
    
    List<AreaMedica> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<AreaMedica> executeQuery(String query);

    public List<AreaMedica> executeQuery(String query, List<SQLParam> params);
}
