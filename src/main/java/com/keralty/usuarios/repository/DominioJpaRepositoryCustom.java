package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface DominioJpaRepositoryCustom {

    List<Dominio> solveQuery(SQLSelect query);
    
    List<Dominio> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000(Rol voRol) throws SystemException;

    Boolean assocOperator000Range1(Rol voRol) throws SystemException;
    
    SQLExists assocOperator000Range1Query(Rol voRol, SQLSelect superQuery) throws SystemException;

    public List<Dominio> executeQuery(String query);

    public List<Dominio> executeQuery(String query, List<SQLParam> params);
}
