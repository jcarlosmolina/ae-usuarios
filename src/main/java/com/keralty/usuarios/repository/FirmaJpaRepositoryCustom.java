package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface FirmaJpaRepositoryCustom {

    List<Firma> solveQuery(SQLSelect query);
    
    List<Firma> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator000() throws SystemException;

    Boolean assocOperator000Range1() throws SystemException;
    
    SQLExists assocOperator000Range1Query(SQLSelect superQuery) throws SystemException;

    public List<Firma> executeQuery(String query);

    public List<Firma> executeQuery(String query, List<SQLParam> params);
}
