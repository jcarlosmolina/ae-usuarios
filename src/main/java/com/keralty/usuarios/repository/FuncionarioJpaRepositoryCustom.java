package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.Admin;
import com.keralty.usuarios.persistence.Afiliaciones;
import com.keralty.usuarios.persistence.AreaMedica;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Gestor;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.persistence.LogFuncionario;
import com.keralty.usuarios.persistence.MesaDeApoyo;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.persistence.SuperAdmin;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLPopulation;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.Collection;
import java.util.List;

public interface FuncionarioJpaRepositoryCustom {

    List<Funcionario> solveQuery(SQLSelect query);
    
    List<Funcionario> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Admin findChildAdmin(Long oid);

    SuperAdmin findChildSuperAdmin(Long oid);

    Asesor findChildAsesor(Long oid);

    AreaMedica findChildAreaMedica(Long oid);

    Afiliaciones findChildAfiliaciones(Long oid);

    RespRegional findChildRespRegional(Long oid);

    Gestor findChildGestor(Long oid);

    MesaDeApoyo findChildMesaDeApoyo(Long oid);

    Collection<LogFuncionario> assocOperator000(Funcionario instance) throws SystemException;

    Collection<LogFuncionario> assocOperator000Range1(Funcionario instance) throws SystemException;
    
    SQLPopulation assocOperator000Range1Query(Funcionario instance) throws SystemException;

    Boolean assocOperator001(GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion) throws SystemException;

    Boolean assocOperator001Range1(GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion) throws SystemException;
    
    SQLExists assocOperator001Range1Query(GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator002(GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion) throws SystemException;

    Boolean assocOperator002Range1(GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion) throws SystemException;
    
    SQLExists assocOperator002Range1Query(GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion, SQLSelect superQuery) throws SystemException;

    public List<Funcionario> executeQuery(String query);

    public List<Funcionario> executeQuery(String query, List<SQLParam> params);
}
