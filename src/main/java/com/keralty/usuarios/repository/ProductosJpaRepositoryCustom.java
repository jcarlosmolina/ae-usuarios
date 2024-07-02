package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLPopulation;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

public interface ProductosJpaRepositoryCustom {

    List<Productos> solveQuery(SQLSelect query);
    
    List<Productos> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Boolean assocOperator010(Productos instance) throws SystemException;

    Collection<AgentexProducto> assocOperator010Range1(Productos instance) throws SystemException;
    
    SQLPopulation assocOperator010Range1Query(Productos instance) throws SystemException;

    Boolean assocOperator011(Productos instance) throws SystemException;

    Collection<AgentexProducto> assocOperator011Range1(Productos instance) throws SystemException;
    
    SQLPopulation assocOperator011Range1Query(Productos instance) throws SystemException;

    Boolean assocOperator012(Productos instance) throws SystemException;

    Collection<AgentexProducto> assocOperator012Range1(Productos instance) throws SystemException;
    
    SQLPopulation assocOperator012Range1Query(Productos instance) throws SystemException;

    Boolean assocOperator013(Productos instance) throws SystemException;

    Collection<AgentexProducto> assocOperator013Range1(Productos instance) throws SystemException;
    
    SQLPopulation assocOperator013Range1Query(Productos instance) throws SystemException;

    public List<Productos> executeQuery(String query);

    public List<Productos> executeQuery(String query, List<SQLParam> params);
}
