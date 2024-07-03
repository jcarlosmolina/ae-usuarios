package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AESOLICITUDESConstants;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameterAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class PlanesJpaRepositoryImpl extends AbstractRepository implements PlanesJpaRepositoryCustom {

    @Override
    public List<Planes> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Planes> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Planes> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Planes> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Planes.class);
    }
    
    public List<Planes> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Planes> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Long assocOperator000(Afiliaciones afiliacionesInsPlanpthisAfiliaciones) throws SystemException {
        try {
            // COUNT (pthisAfiliaciones.Planes) WHERE (pthisAfiliaciones.Planes.Plan = Plan)
            return assocOperator000Range1(afiliacionesInsPlanpthisAfiliaciones);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Long assocOperator000Range1 (Afiliaciones afiliacionesInsPlanpthisAfiliaciones) throws SystemException {
        SQLCount sql = assocOperator000Range1Query(afiliacionesInsPlanpthisAfiliaciones, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLCount assocOperator000Range1Query (Afiliaciones afiliacionesInsPlanpthisAfiliaciones, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES + "." + AfiliacionesConstants.ROLE_NAME_PLANES, AfiliacionesConstants.CLASS_NAME, afiliacionesInsPlanpthisAfiliaciones.getOid(), AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES);
            } else {
                sql = new SQLCount(PlanesConstants.CLASS_NAME, AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES + "." + AfiliacionesConstants.ROLE_NAME_PLANES, AfiliacionesConstants.CLASS_NAME, afiliacionesInsPlanpthisAfiliaciones.getOid(), AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // pthisAfiliaciones.Planes.Plan = Plan
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand112 = new SQLWhereOperandOVParameterAttribute(AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES + "." + AfiliacionesConstants.ROLE_NAME_PLANES + "." + PlanesConstants.ATTR_NAME_PLANESPLAN, AfiliacionesConstants.CLASS_NAME, afiliacionesInsPlanpthisAfiliaciones.getOid(), AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESPLAN, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Long assocOperator001(Afiliaciones afiliacionesDelPlanpthisAfiliaciones) throws SystemException {
        try {
            // COUNT (pthisAfiliaciones.Planes) WHERE (pthisAfiliaciones.Planes.Plan = Plan)
            return assocOperator001Range1(afiliacionesDelPlanpthisAfiliaciones);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Long assocOperator001Range1 (Afiliaciones afiliacionesDelPlanpthisAfiliaciones) throws SystemException {
        SQLCount sql = assocOperator001Range1Query(afiliacionesDelPlanpthisAfiliaciones, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLCount assocOperator001Range1Query (Afiliaciones afiliacionesDelPlanpthisAfiliaciones, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES + "." + AfiliacionesConstants.ROLE_NAME_PLANES, AfiliacionesConstants.CLASS_NAME, afiliacionesDelPlanpthisAfiliaciones.getOid(), AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES);
            } else {
                sql = new SQLCount(PlanesConstants.CLASS_NAME, AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES + "." + AfiliacionesConstants.ROLE_NAME_PLANES, AfiliacionesConstants.CLASS_NAME, afiliacionesDelPlanpthisAfiliaciones.getOid(), AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // pthisAfiliaciones.Planes.Plan = Plan
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand112 = new SQLWhereOperandOVParameterAttribute(AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES + "." + AfiliacionesConstants.ROLE_NAME_PLANES + "." + PlanesConstants.ATTR_NAME_PLANESPLAN, AfiliacionesConstants.CLASS_NAME, afiliacionesDelPlanpthisAfiliaciones.getOid(), AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESPLAN, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator006
    public Boolean assocOperator006(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.ProductoT = ptpagrProducto AND Dominios.NuevaAfiliacion = true)
            return assocOperator006Range1(aESOLICITUDESTNUEVAAFILIACIONptpagrProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator006, Method: assocOperator006");
        }
    }

    // Range 0 for AssocOperator AssocOperator006
    public Boolean assocOperator006Range1 (Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, null);
        return !new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator006
    public SQLExists assocOperator006Range1Query (Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.ProductoT = ptpagrProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AESOLICITUDESConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aESOLICITUDESTNUEVAAFILIACIONptpagrProducto.getOid(), AESOLICITUDESConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.NuevaAfiliacion = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIONUEVAAFILIACION, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query");
        }
    }

    // AssocOperator: AssocOperator007
    public Long assocOperator007(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException {
        try {
            // COUNT (AGENTAsesor.AgentexProducto) WHERE (AGENTAsesor.AgentexProducto.ProductoT = ptpagrProducto AND AGENTAsesor.AgentexProducto.TodosDominios = true)
            return assocOperator007Range1(aESOLICITUDESTNUEVAAFILIACIONptpagrProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator007, Method: assocOperator007");
        }
    }

    // Range 1 for AssocOperator AssocOperator007
    public Long assocOperator007Range1 (Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException {
        SQLCount sql = assocOperator007Range1Query(aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator007
    public SQLCount assocOperator007Range1Query (Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO, AsesorConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
            } else {
                sql = new SQLCount(PlanesConstants.CLASS_NAME, Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO, AsesorConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AGENTAsesor.AgentexProducto.ProductoT = ptpagrProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT, AsesorConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AESOLICITUDESConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aESOLICITUDESTNUEVAAFILIACIONptpagrProducto.getOid(), AESOLICITUDESConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AGENTAsesor.AgentexProducto.TodosDominios = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand113 = new SQLWhereOperandOVParameterAttribute(Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOTODOSDOMINIOS, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query");
        }
    }

    // AssocOperator: AssocOperator008
    public Long assocOperator008(Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException {
        try {
            // COUNT (Dominios.AgentexProducto) WHERE (Dominios.AgentexProducto.ProductoT = ptpagrProducto AND Dominios.AgentexProducto.Asesor = AGENTAsesor)
            return assocOperator008Range1(aESOLICITUDESTNUEVAAFILIACIONptpagrProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator008, Method: assocOperator008");
        }
    }

    // Range 0 for AssocOperator AssocOperator008
    public Long assocOperator008Range1 (Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto) throws SystemException {
        SQLCount sql = assocOperator008Range1Query(aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator008
    public SQLCount assocOperator008Range1Query (Productos aESOLICITUDESTNUEVAAFILIACIONptpagrProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.AgentexProducto.ProductoT = ptpagrProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AESOLICITUDESConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aESOLICITUDESTNUEVAAFILIACIONptpagrProducto.getOid(), AESOLICITUDESConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query");
        }
    }

    // AssocOperator: AssocOperator009
    public Boolean assocOperator009(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.ProductoT = ptpagrProducto AND Dominios.Inclusion = true)
            return assocOperator009Range1(aESOLICITUDESTINCLUSIONSCptpagrProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator009, Method: assocOperator009");
        }
    }

    // Range 0 for AssocOperator AssocOperator009
    public Boolean assocOperator009Range1 (Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException {
        SQLExists sql = assocOperator009Range1Query(aESOLICITUDESTINCLUSIONSCptpagrProducto, null);
        return !new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator009
    public SQLExists assocOperator009Range1Query (Productos aESOLICITUDESTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.ProductoT = ptpagrProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AESOLICITUDESConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aESOLICITUDESTINCLUSIONSCptpagrProducto.getOid(), AESOLICITUDESConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.Inclusion = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOINCLUSION, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query");
        }
    }

    // AssocOperator: AssocOperator010
    public Long assocOperator010(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException {
        try {
            // COUNT (AGENTAsesor.AgentexProducto) WHERE (AGENTAsesor.AgentexProducto.ProductoT = ptpagrProducto AND AGENTAsesor.AgentexProducto.TodosDominios = true)
            return assocOperator010Range1(aESOLICITUDESTINCLUSIONSCptpagrProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator010, Method: assocOperator010");
        }
    }

    // Range 1 for AssocOperator AssocOperator010
    public Long assocOperator010Range1 (Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException {
        SQLCount sql = assocOperator010Range1Query(aESOLICITUDESTINCLUSIONSCptpagrProducto, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator010
    public SQLCount assocOperator010Range1Query (Productos aESOLICITUDESTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO, AsesorConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
            } else {
                sql = new SQLCount(PlanesConstants.CLASS_NAME, Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO, AsesorConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AGENTAsesor.AgentexProducto.ProductoT = ptpagrProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT, AsesorConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AESOLICITUDESConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aESOLICITUDESTINCLUSIONSCptpagrProducto.getOid(), AESOLICITUDESConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AGENTAsesor.AgentexProducto.TodosDominios = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand113 = new SQLWhereOperandOVParameterAttribute(Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOTODOSDOMINIOS, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query");
        }
    }

    // AssocOperator: AssocOperator011
    public Long assocOperator011(Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException {
        try {
            // COUNT (Dominios.AgentexProducto) WHERE (Dominios.AgentexProducto.ProductoT = ptpagrProducto AND Dominios.AgentexProducto.Asesor = AGENTAsesor)
            return assocOperator011Range1(aESOLICITUDESTINCLUSIONSCptpagrProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator011, Method: assocOperator011");
        }
    }

    // Range 0 for AssocOperator AssocOperator011
    public Long assocOperator011Range1 (Productos aESOLICITUDESTINCLUSIONSCptpagrProducto) throws SystemException {
        SQLCount sql = assocOperator011Range1Query(aESOLICITUDESTINCLUSIONSCptpagrProducto, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator011
    public SQLCount assocOperator011Range1Query (Productos aESOLICITUDESTINCLUSIONSCptpagrProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.AgentexProducto.ProductoT = ptpagrProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AESOLICITUDESConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aESOLICITUDESTINCLUSIONSCptpagrProducto.getOid(), AESOLICITUDESConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query");
        }
    }

    // AssocOperator: AssocOperator012
    public Boolean assocOperator012(Productos solicitudNovedadTCREARptProducto) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.ProductoT = ptProducto)
            return assocOperator012Range1(solicitudNovedadTCREARptProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator012, Method: assocOperator012");
        }
    }

    // Range 0 for AssocOperator AssocOperator012
    public Boolean assocOperator012Range1 (Productos solicitudNovedadTCREARptProducto) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(solicitudNovedadTCREARptProducto, null);
        return !new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator012
    public SQLExists assocOperator012Range1Query (Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.ProductoT = ptProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, solicitudNovedadTCREARptProducto.getOid(), SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query");
        }
    }

    // AssocOperator: AssocOperator013
    public Long assocOperator013(Productos solicitudNovedadTCREARptProducto) throws SystemException {
        try {
            // COUNT (AGENTAsesor.AgentexProducto) WHERE (AGENTAsesor.AgentexProducto.ProductoT = ptProducto AND AGENTAsesor.AgentexProducto.TodosDominios = true)
            return assocOperator013Range1(solicitudNovedadTCREARptProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator013, Method: assocOperator013");
        }
    }

    // Range 1 for AssocOperator AssocOperator013
    public Long assocOperator013Range1 (Productos solicitudNovedadTCREARptProducto) throws SystemException {
        SQLCount sql = assocOperator013Range1Query(solicitudNovedadTCREARptProducto, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator013
    public SQLCount assocOperator013Range1Query (Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO, AsesorConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
            } else {
                sql = new SQLCount(PlanesConstants.CLASS_NAME, Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO, AsesorConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AGENTAsesor.AgentexProducto.ProductoT = ptProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT, AsesorConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, ((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, solicitudNovedadTCREARptProducto.getOid(), SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AGENTAsesor.AgentexProducto.TodosDominios = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandOVParameterAttribute operand113 = new SQLWhereOperandOVParameterAttribute(Constants.AGENT_ASESOR + "." + AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOTODOSDOMINIOS, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query");
        }
    }

    // AssocOperator: AssocOperator014
    public Long assocOperator014(Productos solicitudNovedadTCREARptProducto) throws SystemException {
        try {
            // COUNT (Dominios.AgentexProducto) WHERE (Dominios.AgentexProducto.ProductoT = ptProducto AND Dominios.AgentexProducto.Asesor = AGENTAsesor)
            return assocOperator014Range1(solicitudNovedadTCREARptProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator014, Method: assocOperator014");
        }
    }

    // Range 0 for AssocOperator AssocOperator014
    public Long assocOperator014Range1 (Productos solicitudNovedadTCREARptProducto) throws SystemException {
        SQLCount sql = assocOperator014Range1Query(solicitudNovedadTCREARptProducto, null);
        return Long.valueOf(new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator014
    public SQLCount assocOperator014Range1Query (Productos solicitudNovedadTCREARptProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.AgentexProducto.ProductoT = ptProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, solicitudNovedadTCREARptProducto.getOid(), SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query");
        }
    }

    // AssocOperator: AssocOperator015
    public Boolean assocOperator015(Productos solicitudNovedadTCREAREXCEPCIONptProducto) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.ProductoT = ptProducto)
            return assocOperator015Range1(solicitudNovedadTCREAREXCEPCIONptProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator015, Method: assocOperator015");
        }
    }

    // Range 0 for AssocOperator AssocOperator015
    public Boolean assocOperator015Range1 (Productos solicitudNovedadTCREAREXCEPCIONptProducto) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(solicitudNovedadTCREAREXCEPCIONptProducto, null);
        return !new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator015
    public SQLExists assocOperator015Range1Query (Productos solicitudNovedadTCREAREXCEPCIONptProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.ProductoT = ptProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ARG_NAME_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, solicitudNovedadTCREAREXCEPCIONptProducto.getOid(), SolicitudNovedadConstants.ARG_NAME_TCREAREXCEPCION_SOLICITUDNOVEDADTCREAREXCEPCIONPTPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query");
        }
    }

    // AssocOperator: AssocOperator016
    public Boolean assocOperator016(Productos tGDUMMYFASE1ptProducto) throws SystemException {
        try {
            // EXIST (Dominios) WHERE (Dominios.ProductoT = ptProducto AND Dominios.Inclusion = true)
            return assocOperator016Range1(tGDUMMYFASE1ptProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Planes, Assoc.Operator: AssocOperator016, Method: assocOperator016");
        }
    }

    // Range 0 for AssocOperator AssocOperator016
    public Boolean assocOperator016Range1 (Productos tGDUMMYFASE1ptProducto) throws SystemException {
        SQLExists sql = assocOperator016Range1Query(tGDUMMYFASE1ptProducto, null);
        return !new TypedQueryBuilder<Planes>(em, Planes.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator016
    public SQLExists assocOperator016Range1Query (Productos tGDUMMYFASE1ptProducto, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, PlanesConstants.CLASS_NAME, PlanesConstants.ROLE_NAME_DOMINIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Dominios.ProductoT = ptProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_TGDUMMYFASE1_TGDUMMYFASE1PTPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, tGDUMMYFASE1ptProducto.getOid(), GlobalServiceConstants.GS_ARG_NAME_TGDUMMYFASE1_TGDUMMYFASE1PTPRODUCTO);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Dominios.Inclusion = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOINCLUSION, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Planes, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query");
        }
    }
}
