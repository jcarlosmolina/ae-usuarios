package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.MesaDeApoyo;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface MesaDeApoyoJpaRepositoryCustom {

    List<MesaDeApoyo> solveQuery(SQLSelect query);
    
    List<MesaDeApoyo> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    public List<MesaDeApoyo> executeQuery(String query);

    public List<MesaDeApoyo> executeQuery(String query, List<SQLParam> params);
}
