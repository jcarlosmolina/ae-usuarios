package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.persistence.Afiliaciones;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.sqlutils.SQLCount;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import java.util.List;

public interface PlanesJpaRepositoryCustom {

    List<Planes> solveQuery(SQLSelect query);
    
    List<Planes> solveQuery(SQLSelect query, int pageSize, int pageNumber);
    
    int solveCountQuery(SQLSelect query);

    Long assocOperator000(Afiliaciones afiliacionesInsPlanpthisAfiliaciones) throws SystemException;

    Long assocOperator000Range1(Afiliaciones afiliacionesInsPlanpthisAfiliaciones) throws SystemException;
    
    SQLCount assocOperator000Range1Query(Afiliaciones afiliacionesInsPlanpthisAfiliaciones, SQLSelect superQuery) throws SystemException;

    Long assocOperator001(Afiliaciones afiliacionesDelPlanpthisAfiliaciones) throws SystemException;

    Long assocOperator001Range1(Afiliaciones afiliacionesDelPlanpthisAfiliaciones) throws SystemException;
    
    SQLCount assocOperator001Range1Query(Afiliaciones afiliacionesDelPlanpthisAfiliaciones, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator006(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException;

    Boolean assocOperator006Range1(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException;
    
    SQLExists assocOperator006Range1Query(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator007(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException;

    Long assocOperator007Range1(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException;
    
    SQLCount assocOperator007Range1Query(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator008(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException;

    Long assocOperator008Range1(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException;
    
    SQLCount assocOperator008Range1Query(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator009(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException;

    Boolean assocOperator009Range1(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException;
    
    SQLExists assocOperator009Range1Query(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator010(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException;

    Long assocOperator010Range1(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException;
    
    SQLCount assocOperator010Range1Query(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator011(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException;

    Long assocOperator011Range1(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException;
    
    SQLCount assocOperator011Range1Query(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator012(Productos solicitudNovedadTCREARptProducto) throws SystemException;

    Boolean assocOperator012Range1(Productos solicitudNovedadTCREARptProducto) throws SystemException;
    
    SQLExists assocOperator012Range1Query(Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator013(Productos solicitudNovedadTCREARptProducto) throws SystemException;

    Long assocOperator013Range1(Productos solicitudNovedadTCREARptProducto) throws SystemException;
    
    SQLCount assocOperator013Range1Query(Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException;

    Long assocOperator014(Productos solicitudNovedadTCREARptProducto) throws SystemException;

    Long assocOperator014Range1(Productos solicitudNovedadTCREARptProducto) throws SystemException;
    
    SQLCount assocOperator014Range1Query(Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException;

    Boolean assocOperator015(Productos solicitudNovedadTCREAREXCEPCIONptProducto) throws SystemException;

    Boolean assocOperator015Range1(Productos solicitudNovedadTCREAREXCEPCIONptProducto) throws SystemException;
    
    SQLExists assocOperator015Range1Query(Productos solicitudNovedadTCREAREXCEPCIONptProducto, SQLSelect superQuery) throws SystemException;

    public List<Planes> executeQuery(String query);

    public List<Planes> executeQuery(String query, List<SQLParam> params);
}
