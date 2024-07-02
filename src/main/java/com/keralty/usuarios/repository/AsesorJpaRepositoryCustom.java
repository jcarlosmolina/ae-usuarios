package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.LogInformacionAsesor;
import com.keralty.usuarios.sqlutils.SQLCount;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLPopulation;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface AsesorJpaRepositoryCustom {

    List<Asesor> solveQuery(SQLSelect query);
    
    List<Asesor> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Funcionario findParent(Long oid);

    Long assocOperator000(Asesor instance) throws SystemException;

    Long assocOperator000Range1(Asesor instance) throws SystemException;
    
    SQLCount assocOperator000Range1Query(Asesor instance) throws SystemException;

    Boolean assocOperator002(Asesor instance) throws SystemException;

    Boolean assocOperator002Range1(Asesor instance) throws SystemException;
    
    SQLExists assocOperator002Range1Query(Asesor instance) throws SystemException;

    Boolean assocOperator004(Asesor instance) throws SystemException;

    Boolean assocOperator004Range1(Asesor instance) throws SystemException;
    
    SQLExists assocOperator004Range1Query(Asesor instance) throws SystemException;

    Collection<AgentexProducto> assocOperator005(Asesor instance) throws SystemException;

    Collection<AgentexProducto> assocOperator005Range1(Asesor instance) throws SystemException;
    
    SQLPopulation assocOperator005Range1Query(Asesor instance) throws SystemException;

    Collection<LogInformacionAsesor> assocOperator006(Asesor instance) throws SystemException;

    Collection<LogInformacionAsesor> assocOperator006Range1(Asesor instance) throws SystemException;
    
    SQLPopulation assocOperator006Range1Query(Asesor instance) throws SystemException;

    Collection<AgentexProducto> assocOperator007(Asesor instance, String asesorTCARGARDOMINIOPLANptCodLegalProducto) throws SystemException;

    Collection<AgentexProducto> assocOperator007Range1(Asesor instance, String asesorTCARGARDOMINIOPLANptCodLegalProducto) throws SystemException;
    
    SQLPopulation assocOperator007Range1Query(Asesor instance, String asesorTCARGARDOMINIOPLANptCodLegalProducto) throws SystemException;

    public List<Asesor> executeQuery(String query);

    public List<Asesor> executeQuery(String query, List<SQLParam> params);
}
