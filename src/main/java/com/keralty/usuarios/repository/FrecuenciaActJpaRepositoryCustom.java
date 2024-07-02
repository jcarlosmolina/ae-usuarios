package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.FrecuenciaAct;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface FrecuenciaActJpaRepositoryCustom {

    List<FrecuenciaAct> solveQuery(SQLSelect query);
    
    List<FrecuenciaAct> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    public List<FrecuenciaAct> executeQuery(String query);

    public List<FrecuenciaAct> executeQuery(String query, List<SQLParam> params);
}
