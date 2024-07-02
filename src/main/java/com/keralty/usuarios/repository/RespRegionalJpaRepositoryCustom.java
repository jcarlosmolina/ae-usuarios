package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface RespRegionalJpaRepositoryCustom {

    List<RespRegional> solveQuery(SQLSelect query);
    
    List<RespRegional> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    Boolean assocOperator001(RespRegional instance) throws SystemException;

    Boolean assocOperator001Range1(RespRegional instance) throws SystemException;
    
    SQLExists assocOperator001Range1Query(RespRegional instance) throws SystemException;

    Boolean assocOperator003(RespRegional instance) throws SystemException;

    Boolean assocOperator003Range1(RespRegional instance) throws SystemException;
    
    SQLExists assocOperator003Range1Query(RespRegional instance) throws SystemException;

    public List<RespRegional> executeQuery(String query);

    public List<RespRegional> executeQuery(String query, List<SQLParam> params);
}
