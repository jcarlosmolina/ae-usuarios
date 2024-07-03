package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AESOLICITUDESConstants;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AnexoMatConstants;
import com.keralty.aeusuarios.global.AnexoNeoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratanteConstants;
import com.keralty.aeusuarios.global.CuestionarioPConstants;
import com.keralty.aeusuarios.global.DetalleTarifaConstants;
import com.keralty.aeusuarios.global.DireccionConstants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.global.PersonaConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.PlantillaReporteConstants;
import com.keralty.aeusuarios.global.PreexistenciaConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.ReportesDominioConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.global.TarifaConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.TipoIVAConstants;
import com.keralty.aeusuarios.global.TitularConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioConstants;
import com.keralty.aeusuarios.global.UsuarioRegConstants;
import com.keralty.aeusuarios.persistence.Persona;
import com.keralty.aeusuarios.persistence.ReportesDominio;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.persistence.Usuario;
import com.keralty.aeusuarios.persistence.UsuarioReg;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLSum;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.Collection;
import java.util.List;

public class SolicitudJpaRepositoryImpl extends AbstractRepository implements SolicitudJpaRepositoryCustom {

    @Override
    public List<Solicitud> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Solicitud> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Solicitud> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Solicitud> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Solicitud.class);
    }
    
    public List<Solicitud> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Solicitud> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000() throws SystemException {
        try {
            // EXIST (UsrAfiliacion) WHERE (UsrAfiliacion = agent)
            return assocOperator000Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 () throws SystemException {
        SQLExists sql = assocOperator000Range1Query(null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAFILIACION);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsrAfiliacion = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USRAFILIACION, FuncionarioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Long assocOperator001() throws SystemException {
        try {
            // COUNT (AESOLICITUDES.PlanT.Afiliaciones) WHERE (AESOLICITUDES.PlanT.Afiliaciones = agent)
            return assocOperator001Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 0 for AssocOperator AssocOperator001
    public Long assocOperator001Range1 () throws SystemException {
        SQLCount sql = assocOperator001Range1Query(null);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator001
    public SQLCount assocOperator001Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.PlanT.Afiliaciones = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES, AfiliacionesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AfiliacionesConstants.CLASS_NAME, AfiliacionesConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReqCuesMed = true)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Boolean assocOperator002Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLExists assocOperator002Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReqCuesMed = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOREQCUESMED, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Boolean assocOperator003(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReqCuesMed = true AND (AESOLICITUDES.ProductoT.Dominios.NoCuesMedTras = false))
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Boolean assocOperator003Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLExists assocOperator003Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReqCuesMed = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOREQCUESMED, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // (AESOLICITUDES.ProductoT.Dominios.NoCuesMedTras = false)
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIONOCUESMEDTRAS, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Boolean assocOperator004(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Boolean assocOperator004Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLExists assocOperator004Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Boolean assocOperator005(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Boolean assocOperator005Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLExists assocOperator005Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }

    // AssocOperator: AssocOperator006
    public Boolean assocOperator006(Solicitud instance) throws SystemException {
        try {
            // EXIST (Periodicidad)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator006, Method: assocOperator006");
        }
    }

    // Range 1 for AssocOperator AssocOperator006
    public Boolean assocOperator006Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
    public SQLExists assocOperator006Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_PERIODICIDAD, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query");
        }
    }

    // AssocOperator: AssocOperator007
    public Boolean assocOperator007(Solicitud instance) throws SystemException {
        try {
            // EXIST (Direccion.Municipio)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator007, Method: assocOperator007");
        }
    }

    // Range 1 for AssocOperator AssocOperator007
    public Boolean assocOperator007Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
    public SQLExists assocOperator007Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_DIRECCION + "." + DireccionConstants.ROLE_NAME_MUNICIPIO, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query");
        }
    }

    // AssocOperator: AssocOperator008
    public Double assocOperator008(Solicitud instance) throws SystemException {
        try {
            // SUM (AESOLICITUDES.PlanT.TiposIVA.Porcentaje) WHERE (AESOLICITUDES.PlanT.TiposIVA.FechaInicio <= drvFechaPorcenIVA AND AESOLICITUDES.PlanT.TiposIVA.FechaFin >= drvFechaPorcenIVA)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator008, Method: assocOperator008");
        }
    }

    // Range 1 for AssocOperator AssocOperator008
    public Double assocOperator008Range1 (Solicitud instance) throws SystemException {
        SQLSum sql = assocOperator008Range1Query(instance);
        return new TypedQueryBuilder<Double>(em, Double.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator008
    public SQLSum assocOperator008Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLSum sql = new SQLSum(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TIPOSIVA + "." + TipoIVAConstants.ATTR_NAME_TIPOIVAPORCENTAJE, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.PlanT.TiposIVA.FechaInicio <= drvFechaPorcenIVA
                    // '<=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TIPOSIVA + "." + TipoIVAConstants.ATTR_NAME_TIPOIVAFECHAINICIO, Constants.Type.DATE.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(instance.getSolicituddrvFechaPorcenIVA(), Constants.Type.DATE.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.PlanT.TiposIVA.FechaFin >= drvFechaPorcenIVA
                    // '>=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator(">=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TIPOSIVA + "." + TipoIVAConstants.ATTR_NAME_TIPOIVAFECHAFIN, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(instance.getSolicituddrvFechaPorcenIVA(), Constants.Type.DATE.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query");
        }
    }

    // AssocOperator: AssocOperator009
    public Boolean assocOperator009(Solicitud instance) throws SystemException {
        try {
            // FOR ALL Usuarios(Usuarios.drvCuesMedOK = true)
            for(Usuario item : assocOperator009Range1(instance)){
                // Usuarios.drvCuesMedOK = true
                boolean conditionsMet = item.getUsuariodrvCuesMedOK().equals(true);
                if (!conditionsMet) return false;
            }
            return true;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator009, Method: assocOperator009");
        }
    }

    // Range 1 for AssocOperator AssocOperator009
    public Collection<Usuario> assocOperator009Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator009Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator009
    public SQLPopulation assocOperator009Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query");
        }
    }

    // AssocOperator: AssocOperator010
    public Boolean assocOperator010(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator010, Method: assocOperator010");
        }
    }

    // Range 1 for AssocOperator AssocOperator010
    public Boolean assocOperator010Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
    public SQLExists assocOperator010Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query");
        }
    }

    // AssocOperator: AssocOperator011
    public Boolean assocOperator011(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.Preexistencias)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator011, Method: assocOperator011");
        }
    }

    // Range 1 for AssocOperator AssocOperator011
    public Boolean assocOperator011Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator011Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator011
    public SQLExists assocOperator011Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query");
        }
    }

    // AssocOperator: AssocOperator012
    public Boolean assocOperator012(Solicitud instance) throws SystemException {
        try {
            // EXIST (SegundaFirma)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator012, Method: assocOperator012");
        }
    }

    // Range 1 for AssocOperator AssocOperator012
    public Boolean assocOperator012Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
    public SQLExists assocOperator012Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_SEGUNDAFIRMA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query");
        }
    }

    // AssocOperator: AssocOperator013
    public Boolean assocOperator013(Solicitud instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator013, Method: assocOperator013");
        }
    }

    // Range 1 for AssocOperator AssocOperator013
    public Boolean assocOperator013Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator013Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator013
    public SQLExists assocOperator013Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query");
        }
    }

    // AssocOperator: AssocOperator014
    public Boolean assocOperator014(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 1 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator014Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator014, Method: assocOperator014");
        }
    }

    // Range 1 for AssocOperator AssocOperator014
    public Collection<ReportesDominio> assocOperator014Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator014Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator014
    public SQLPopulation assocOperator014Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 1
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query");
        }
    }

    // AssocOperator: AssocOperator015
    public Boolean assocOperator015(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator015, Method: assocOperator015");
        }
    }

    // Range 1 for AssocOperator AssocOperator015
    public Boolean assocOperator015Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
    public SQLExists assocOperator015Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query");
        }
    }

    // AssocOperator: AssocOperator016
    public Boolean assocOperator016(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 3 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator016Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator016, Method: assocOperator016");
        }
    }

    // Range 1 for AssocOperator AssocOperator016
    public Collection<ReportesDominio> assocOperator016Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator016Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator016
    public SQLPopulation assocOperator016Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 3
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query");
        }
    }

    // AssocOperator: AssocOperator017
    public Boolean assocOperator017(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.Preexistencias) WHERE (Usuarios.Preexistencias.Usuario.EstadoBeneficiario.EsActivo = true)
            return assocOperator017Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator017, Method: assocOperator017");
        }
    }

    // Range 1 for AssocOperator AssocOperator017
    public Boolean assocOperator017Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator017Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator017
    public SQLExists assocOperator017Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Preexistencias.Usuario.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PREEXISTENCIAS + "." + PreexistenciaConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query");
        }
    }

    // AssocOperator: AssocOperator018
    public Boolean assocOperator018(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 6 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator018Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator018, Method: assocOperator018");
        }
    }

    // Range 1 for AssocOperator AssocOperator018
    public Collection<ReportesDominio> assocOperator018Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator018Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator018
    public SQLPopulation assocOperator018Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 6
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(6), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator018, Method: assocOperator018Range1Query");
        }
    }

    // AssocOperator: AssocOperator019
    public Boolean assocOperator019(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.BebeGestante = true AND Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator019Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator019, Method: assocOperator019");
        }
    }

    // Range 1 for AssocOperator AssocOperator019
    public Boolean assocOperator019Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator019Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator019
    public SQLExists assocOperator019Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.BebeGestante = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOBEBEGESTANTE, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator019, Method: assocOperator019Range1Query");
        }
    }

    // AssocOperator: AssocOperator020
    public Boolean assocOperator020(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 8 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator020Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator020, Method: assocOperator020");
        }
    }

    // Range 1 for AssocOperator AssocOperator020
    public Collection<ReportesDominio> assocOperator020Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator020Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator020
    public SQLPopulation assocOperator020Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 8
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(8), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator020, Method: assocOperator020Range1Query");
        }
    }

    // AssocOperator: AssocOperator021
    public Boolean assocOperator021(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.AnexoMat) WHERE (Usuarios.AnexoMat.Usuario.EstadoBeneficiario.EsActivo = true)
            return assocOperator021Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator021, Method: assocOperator021");
        }
    }

    // Range 1 for AssocOperator AssocOperator021
    public Boolean assocOperator021Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator021Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator021
    public SQLExists assocOperator021Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXOMAT, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.AnexoMat.Usuario.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXOMAT + "." + AnexoMatConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator021, Method: assocOperator021Range1Query");
        }
    }

    // AssocOperator: AssocOperator022
    public Boolean assocOperator022(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 10 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator022Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator022, Method: assocOperator022");
        }
    }

    // Range 1 for AssocOperator AssocOperator022
    public Collection<ReportesDominio> assocOperator022Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator022Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator022
    public SQLPopulation assocOperator022Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 10
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(10), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator022, Method: assocOperator022Range1Query");
        }
    }

    // AssocOperator: AssocOperator023
    public Boolean assocOperator023(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.CuestionarioP) WHERE (Usuarios.CuestionarioP.YaDiligenciado = true)
            return assocOperator023Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator023, Method: assocOperator023");
        }
    }

    // Range 1 for AssocOperator AssocOperator023
    public Boolean assocOperator023Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator023Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator023
    public SQLExists assocOperator023Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.CuestionarioP.YaDiligenciado = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_CUESTIONARIOP + "." + CuestionarioPConstants.ATTR_NAME_CUESTIONARIOPYADILIGENCIADO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator023, Method: assocOperator023Range1Query");
        }
    }

    // AssocOperator: AssocOperator024
    public Boolean assocOperator024(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 4 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator024Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator024, Method: assocOperator024");
        }
    }

    // Range 1 for AssocOperator AssocOperator024
    public Collection<ReportesDominio> assocOperator024Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator024Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator024
    public SQLPopulation assocOperator024Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 4
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator024, Method: assocOperator024Range1Query");
        }
    }

    // AssocOperator: AssocOperator025
    public Boolean assocOperator025(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoMedico = 4 AND Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator025Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator025, Method: assocOperator025");
        }
    }

    // Range 1 for AssocOperator AssocOperator025
    public Boolean assocOperator025Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator025Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator025
    public SQLExists assocOperator025Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoMedico = 4
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOESTADOMEDICO, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query");
        }
    }

    // AssocOperator: AssocOperator026
    public Double assocOperator026(Solicitud instance) throws SystemException {
        try {
            // SUM (Usuarios.drvTotalAnexos)
            Double result = 0.0;
            for(Usuario item : assocOperator026Range1(instance)){
                result += item.getUsuariodrvTotalAnexos();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator026, Method: assocOperator026");
        }
    }

    // Range 1 for AssocOperator AssocOperator026
    public Collection<Usuario> assocOperator026Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator026Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator026
    public SQLPopulation assocOperator026Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query");
        }
    }

    // AssocOperator: AssocOperator027
    public Boolean assocOperator027(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvTieneEPSSanitas = true)
            for(Usuario item : assocOperator027Range1(instance)){
                // Usuarios.drvTieneEPSSanitas = true
                if(item.getUsuariodrvTieneEPSSanitas().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator027, Method: assocOperator027");
        }
    }

    // Range 1 for AssocOperator AssocOperator027
    public Collection<Usuario> assocOperator027Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator027Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator027
    public SQLPopulation assocOperator027Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator027, Method: assocOperator027Range1Query");
        }
    }

    // AssocOperator: AssocOperator028
    public Long assocOperator028(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true AND Usuarios.drvEstaActivo = true)
            Long count = 0L;
            for(Usuario item : assocOperator028Range1(instance)){
                // Usuarios.drvEstaActivo = true
                if(item.getUsuariodrvEstaActivo().equals(true))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator028, Method: assocOperator028");
        }
    }

    // Range 1 for AssocOperator AssocOperator028
    public Collection<Usuario> assocOperator028Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator028Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator028
    public SQLPopulation assocOperator028Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query");
        }
    }

    // AssocOperator: AssocOperator029
    public Long assocOperator029(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true AND UsuariosRegistrados.EstadoBeneficiario.EsActivo = true)
            return assocOperator029Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator029, Method: assocOperator029");
        }
    }

    // Range 1 for AssocOperator AssocOperator029
    public Long assocOperator029Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator029Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator029
    public SQLCount assocOperator029Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // UsuariosRegistrados.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query");
        }
    }

    // AssocOperator: AssocOperator030
    public Long assocOperator030(Solicitud instance) throws SystemException {
        try {
            // COUNT (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            Long count = 0L;
            for(ReportesDominio item : assocOperator030Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator030, Method: assocOperator030");
        }
    }

    // Range 1 for AssocOperator AssocOperator030
    public Collection<ReportesDominio> assocOperator030Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator030Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator030
    public SQLPopulation assocOperator030Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator030, Method: assocOperator030Range1Query");
        }
    }

    // AssocOperator: AssocOperator031
    public Boolean assocOperator031(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator031Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator031, Method: assocOperator031");
        }
    }

    // Range 1 for AssocOperator AssocOperator031
    public Boolean assocOperator031Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator031Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator031
    public SQLExists assocOperator031Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator031, Method: assocOperator031Range1Query");
        }
    }

    // AssocOperator: AssocOperator032
    public Boolean assocOperator032(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona) WHERE (TitularPersona.TipoIdentificacion.NIT = false)
            return assocOperator032Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator032, Method: assocOperator032");
        }
    }

    // Range 1 for AssocOperator AssocOperator032
    public Boolean assocOperator032Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator032Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator032
    public SQLExists assocOperator032Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TitularPersona.TipoIdentificacion.NIT = false
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    if (instance.getTitularPersona().getTipoIdentificacion().getTipoIdentificacionNIT()!= null){
                    SQLWhereOperandLiteral operand112 = new SQLWhereOperandLiteral(instance.getTitularPersona().getTipoIdentificacion().getTipoIdentificacionNIT(), Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    } else {
                    comparison1.setFirstOperand(new SQLWhereOperandNull());
                    }
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator032, Method: assocOperator032Range1Query");
        }
    }

    // AssocOperator: AssocOperator033
    public Boolean assocOperator033(Solicitud instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator033Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator033, Method: assocOperator033");
        }
    }

    // Range 1 for AssocOperator AssocOperator033
    public Boolean assocOperator033Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator033Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator033
    public SQLExists assocOperator033Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator033, Method: assocOperator033Range1Query");
        }
    }

    // AssocOperator: AssocOperator034
    public Long assocOperator034(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.drvTieneDocumentos = false)
            Long count = 0L;
            for(Usuario item : assocOperator034Range1(instance)){
                // Usuarios.drvTieneDocumentos = false
                if(item.getUsuariodrvTieneDocumentos().equals(false))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator034, Method: assocOperator034");
        }
    }

    // Range 1 for AssocOperator AssocOperator034
    public Collection<Usuario> assocOperator034Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator034Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator034
    public SQLPopulation assocOperator034Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator034, Method: assocOperator034Range1Query");
        }
    }

    // AssocOperator: AssocOperator035
    public Long assocOperator035(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.drvTieneParentesco = false)
            Long count = 0L;
            for(Usuario item : assocOperator035Range1(instance)){
                // Usuarios.drvTieneParentesco = false
                if(item.getUsuariodrvTieneParentesco().equals(false))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator035, Method: assocOperator035");
        }
    }

    // Range 1 for AssocOperator AssocOperator035
    public Collection<Usuario> assocOperator035Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator035Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator035
    public SQLPopulation assocOperator035Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator035, Method: assocOperator035Range1Query");
        }
    }

    // AssocOperator: AssocOperator036
    public Long assocOperator036(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true)
            return assocOperator036Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator036, Method: assocOperator036");
        }
    }

    // Range 1 for AssocOperator AssocOperator036
    public Long assocOperator036Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator036Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator036
    public SQLCount assocOperator036Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator036, Method: assocOperator036Range1Query");
        }
    }

    // AssocOperator: AssocOperator037
    public Long assocOperator037(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator037Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator037, Method: assocOperator037");
        }
    }

    // Range 1 for AssocOperator AssocOperator037
    public Long assocOperator037Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator037Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator037
    public SQLCount assocOperator037Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator037, Method: assocOperator037Range1Query");
        }
    }

    // AssocOperator: AssocOperator038
    public Boolean assocOperator038(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 9 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator038Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator038, Method: assocOperator038");
        }
    }

    // Range 1 for AssocOperator AssocOperator038
    public Collection<ReportesDominio> assocOperator038Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator038Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator038
    public SQLPopulation assocOperator038Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 9
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(9), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator038, Method: assocOperator038Range1Query");
        }
    }

    // AssocOperator: AssocOperator039
    public Boolean assocOperator039(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios.AnexoNeo) WHERE (Usuarios.AnexoNeo.Usuario.EstadoBeneficiario.EsActivo = true)
            return assocOperator039Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator039, Method: assocOperator039");
        }
    }

    // Range 1 for AssocOperator AssocOperator039
    public Boolean assocOperator039Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator039Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator039
    public SQLExists assocOperator039Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXONEO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.AnexoNeo.Usuario.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ANEXONEO + "." + AnexoNeoConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator039, Method: assocOperator039Range1Query");
        }
    }

    // AssocOperator: AssocOperator040
    public Boolean assocOperator040(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 2 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator040Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator040, Method: assocOperator040");
        }
    }

    // Range 1 for AssocOperator AssocOperator040
    public Collection<ReportesDominio> assocOperator040Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator040Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator040
    public SQLPopulation assocOperator040Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 2
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator040, Method: assocOperator040Range1Query");
        }
    }

    // AssocOperator: AssocOperator041
    public Boolean assocOperator041(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator041Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator041, Method: assocOperator041");
        }
    }

    // Range 1 for AssocOperator AssocOperator041
    public Boolean assocOperator041Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator041Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator041
    public SQLExists assocOperator041Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator041, Method: assocOperator041Range1Query");
        }
    }

    // AssocOperator: AssocOperator042
    public Boolean assocOperator042(Solicitud instance) throws SystemException {
        try {
            // EXIST (Contratante)
            return assocOperator042Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator042, Method: assocOperator042");
        }
    }

    // Range 1 for AssocOperator AssocOperator042
    public Boolean assocOperator042Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator042Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator042
    public SQLExists assocOperator042Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator042, Method: assocOperator042Range1Query");
        }
    }

    // AssocOperator: AssocOperator043
    public Long assocOperator043(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator043Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator043, Method: assocOperator043");
        }
    }

    // Range 1 for AssocOperator AssocOperator043
    public Long assocOperator043Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator043Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator043
    public SQLCount assocOperator043Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator043, Method: assocOperator043Range1Query");
        }
    }

    // AssocOperator: AssocOperator044
    public Long assocOperator044(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator044Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator044, Method: assocOperator044");
        }
    }

    // Range 1 for AssocOperator AssocOperator044
    public Long assocOperator044Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator044Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator044
    public SQLCount assocOperator044Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator044, Method: assocOperator044Range1Query");
        }
    }

    // AssocOperator: AssocOperator045
    public Long assocOperator045(Solicitud instance) throws SystemException {
        try {
            // MAX (UsuariosRegistrados.drvEdad) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            Long result = Long.MIN_VALUE;
            for(UsuarioReg item : assocOperator045Range1(instance)){
                if(result < item.getUsuarioRegdrvEdad())
                    result = item.getUsuarioRegdrvEdad();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator045, Method: assocOperator045");
        }
    }

    // Range 1 for AssocOperator AssocOperator045
    public Collection<UsuarioReg> assocOperator045Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator045Range1Query(instance);
        return new TypedQueryBuilder<UsuarioReg>(em, UsuarioReg.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator045
    public SQLPopulation assocOperator045Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioRegConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator045, Method: assocOperator045Range1Query");
        }
    }

    // AssocOperator: AssocOperator046
    public Long assocOperator046(Solicitud instance) throws SystemException {
        try {
            // MAX (Usuarios.drvEdad) WHERE (Usuarios.drvEsElTitular = true)
            Long result = Long.MIN_VALUE;
            for(Usuario item : assocOperator046Range1(instance)){
                // Usuarios.drvEsElTitular = true
                boolean conditionsMet = item.getUsuariodrvEsElTitular().equals(true);
                if (!conditionsMet) continue;

                if(result < item.getUsuariodrvEdad())
                    result = item.getUsuariodrvEdad();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator046, Method: assocOperator046");
        }
    }

    // Range 1 for AssocOperator AssocOperator046
    public Collection<Usuario> assocOperator046Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator046Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator046
    public SQLPopulation assocOperator046Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator046, Method: assocOperator046Range1Query");
        }
    }

    // AssocOperator: AssocOperator047
    public Long assocOperator047(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator047Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator047, Method: assocOperator047");
        }
    }

    // Range 1 for AssocOperator AssocOperator047
    public Long assocOperator047Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator047Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator047
    public SQLCount assocOperator047Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator047, Method: assocOperator047Range1Query");
        }
    }

    // AssocOperator: AssocOperator048
    public String assocOperator048(Solicitud instance) throws SystemException {
        try {
            // GETONE (UsuariosRegistrados.Genero) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator048Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator048, Method: assocOperator048");
        }
    }

    // Range 1 for AssocOperator AssocOperator048
    public String assocOperator048Range1 (Solicitud instance) throws SystemException {
        SQLGetOne sql = assocOperator048Range1Query(instance);
        return new TypedQueryBuilder<String>(em, String.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator048
    public SQLGetOne assocOperator048Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ATTR_NAME_USUARIOREGGENERO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator048, Method: assocOperator048Range1Query");
        }
    }

    // AssocOperator: AssocOperator049
    public Boolean assocOperator049(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvEsElTitular = true AND Usuarios.UsuarioPersona.Genero = "F")
            for(Usuario item : assocOperator049Range1(instance)){
                // Usuarios.drvEsElTitular = true
                if(item.getUsuariodrvEsElTitular().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator049, Method: assocOperator049");
        }
    }

    // Range 1 for AssocOperator AssocOperator049
    public Collection<Usuario> assocOperator049Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator049Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator049
    public SQLPopulation assocOperator049Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.Genero = "F"
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAGENERO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral("F", Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator049, Method: assocOperator049Range1Query");
        }
    }

    // AssocOperator: AssocOperator050
    public Boolean assocOperator050(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvEsElTitular = true AND Usuarios.UsuarioPersona.Genero = "M")
            for(Usuario item : assocOperator050Range1(instance)){
                // Usuarios.drvEsElTitular = true
                if(item.getUsuariodrvEsElTitular().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator050, Method: assocOperator050");
        }
    }

    // Range 1 for AssocOperator AssocOperator050
    public Collection<Usuario> assocOperator050Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator050Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator050
    public SQLPopulation assocOperator050Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.Genero = "M"
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONAGENERO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral("M", Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator050, Method: assocOperator050Range1Query");
        }
    }

    // AssocOperator: AssocOperator051
    public Long assocOperator051(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.Parentesco.EsTitular = true)
            return assocOperator051Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator051, Method: assocOperator051");
        }
    }

    // Range 1 for AssocOperator AssocOperator051
    public Long assocOperator051Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator051Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator051
    public SQLCount assocOperator051Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator051, Method: assocOperator051Range1Query");
        }
    }

    // AssocOperator: AssocOperator052
    public Long assocOperator052(Solicitud instance) throws SystemException {
        try {
            // COUNT (UsuariosRegistrados) WHERE (UsuariosRegistrados.Parentesco.EsTitular = true)
            return assocOperator052Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator052, Method: assocOperator052");
        }
    }

    // Range 1 for AssocOperator AssocOperator052
    public Long assocOperator052Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator052Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator052
    public SQLCount assocOperator052Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsuariosRegistrados.Parentesco.EsTitular = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOSREGISTRADOS + "." + UsuarioRegConstants.ROLE_NAME_PARENTESCO + "." + ParentescoConstants.ATTR_NAME_PARENTESCOESTITULAR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator052, Method: assocOperator052Range1Query");
        }
    }

    // AssocOperator: AssocOperator053
    public Boolean assocOperator053(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 0 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator053Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator053, Method: assocOperator053");
        }
    }

    // Range 1 for AssocOperator AssocOperator053
    public Collection<ReportesDominio> assocOperator053Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator053Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator053
    public SQLPopulation assocOperator053Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 0
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator053, Method: assocOperator053Range1Query");
        }
    }

    // AssocOperator: AssocOperator054
    public Boolean assocOperator054(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.IgnorarPreexistencias = true)
            return assocOperator054Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator054, Method: assocOperator054");
        }
    }

    // Range 1 for AssocOperator AssocOperator054
    public Boolean assocOperator054Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator054Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator054
    public SQLExists assocOperator054Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.IgnorarPreexistencias = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOIGNORARPREEXISTENCIAS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator054, Method: assocOperator054Range1Query");
        }
    }

    // AssocOperator: AssocOperator055
    public Boolean assocOperator055(Solicitud instance) throws SystemException {
        try {
            // EXIST (Firma)
            return assocOperator055Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator055, Method: assocOperator055");
        }
    }

    // Range 1 for AssocOperator AssocOperator055
    public Boolean assocOperator055Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator055Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator055
    public SQLExists assocOperator055Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_FIRMA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator055, Method: assocOperator055Range1Query");
        }
    }

    // AssocOperator: AssocOperator056
    public Boolean assocOperator056(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvImpTarifaPlanVol = 0)
            for(Usuario item : assocOperator056Range1(instance)){
                // Usuarios.drvImpTarifaPlanVol = 0
                if(Double.valueOf(item.getUsuariodrvImpTarifaPlanVol()).equals(Utilities.convertToDouble(Utilities.convertToDouble(Utilities.convertToDouble(Long.valueOf(0))))))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator056, Method: assocOperator056");
        }
    }

    // Range 1 for AssocOperator AssocOperator056
    public Collection<Usuario> assocOperator056Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator056Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator056
    public SQLPopulation assocOperator056Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator056, Method: assocOperator056Range1Query");
        }
    }

    // AssocOperator: AssocOperator057
    public Double assocOperator057(Solicitud instance) throws SystemException {
        try {
            // SUM (Usuarios.drvImpTarifaPlanVol)
            Double result = 0.0;
            for(Usuario item : assocOperator057Range1(instance)){
                result += item.getUsuariodrvImpTarifaPlanVol();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator057, Method: assocOperator057");
        }
    }

    // Range 1 for AssocOperator AssocOperator057
    public Collection<Usuario> assocOperator057Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator057Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator057
    public SQLPopulation assocOperator057Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator057, Method: assocOperator057Range1Query");
        }
    }

    // AssocOperator: AssocOperator058
    public Boolean assocOperator058(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios.ReportesDominio) WHERE (AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 5 AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI AND AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI)
            for(ReportesDominio item : assocOperator058Range1(instance)){
                // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.drvFechaHasta > AESOLICITUDES.FESOLICI
                if(STDFunctions.dateAfterFun(item.getReportesDominiodrvFechaHasta(),instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator058, Method: assocOperator058");
        }
    }

    // Range 1 for AssocOperator AssocOperator058
    public Collection<ReportesDominio> assocOperator058Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator058Range1Query(instance);
        return new TypedQueryBuilder<ReportesDominio>(em, ReportesDominio.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator058
    public SQLPopulation assocOperator058Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, ReportesDominioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.Dominio.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_DOMINIO + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.Tipo = 5
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTETIPO, Constants.Type.NAT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Long.valueOf(5), Constants.Type.NAT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // AESOLICITUDES.ProductoT.Dominios.ReportesDominio.PlantillaReporte.FechaVigencia <= AESOLICITUDES.FESOLICI
                    // '<=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("<=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_REPORTESDOMINIO + "." + ReportesDominioConstants.ROLE_NAME_PLANTILLAREPORTE + "." + PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEFECHAVIGENCIA, Constants.Type.DATE.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI()!= null){
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(instance.getAESOLICITUDES().getAESOLICITUDESFESOLICI(), Constants.Type.DATE.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    } else {
                    comparison3.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator058, Method: assocOperator058Range1Query");
        }
    }

    // AssocOperator: AssocOperator059
    public Boolean assocOperator059(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.EstadoBeneficiario.EsActivo = true)
            return assocOperator059Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator059, Method: assocOperator059");
        }
    }

    // Range 1 for AssocOperator AssocOperator059
    public Boolean assocOperator059Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator059Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator059
    public SQLExists assocOperator059Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.EstadoBeneficiario.EsActivo = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_ESTADOBENEFICIARIO + "." + EstadoBeneficiarioConstants.ATTR_NAME_ESTADOBENEFICIARIOESACTIVO, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator059, Method: assocOperator059Range1Query");
        }
    }

    // AssocOperator: AssocOperator060
    public Boolean assocOperator060(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.InclusionModGrupoAsoc = true)
            return assocOperator060Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator060, Method: assocOperator060");
        }
    }

    // Range 1 for AssocOperator AssocOperator060
    public Boolean assocOperator060Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator060Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator060
    public SQLExists assocOperator060Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.InclusionModGrupoAsoc = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOINCLUSIONMODGRUPOASOC, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator060, Method: assocOperator060Range1Query");
        }
    }

    // AssocOperator: AssocOperator061
    public Boolean assocOperator061(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.AcepPolizaInter = true)
            return assocOperator061Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator061, Method: assocOperator061");
        }
    }

    // Range 1 for AssocOperator AssocOperator061
    public Boolean assocOperator061Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator061Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator061
    public SQLExists assocOperator061Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.AcepPolizaInter = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOACEPPOLIZAINTER, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator061, Method: assocOperator061Range1Query");
        }
    }

    // AssocOperator: AssocOperator062
    public Long assocOperator062(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.PolizaInternacional = true)
            return assocOperator062Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator062, Method: assocOperator062");
        }
    }

    // Range 1 for AssocOperator AssocOperator062
    public Long assocOperator062Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator062Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator062
    public SQLCount assocOperator062Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.PolizaInternacional = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOPOLIZAINTERNACIONAL, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator062, Method: assocOperator062Range1Query");
        }
    }

    // AssocOperator: AssocOperator063
    public Boolean assocOperator063(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.PermiteRechazadosAfi = true)
            return assocOperator063Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator063, Method: assocOperator063");
        }
    }

    // Range 1 for AssocOperator AssocOperator063
    public Boolean assocOperator063Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator063Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator063
    public SQLExists assocOperator063Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.PermiteRechazadosAfi = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOPERMITERECHAZADOSAFI, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator063, Method: assocOperator063Range1Query");
        }
    }

    // AssocOperator: AssocOperator064
    public Long assocOperator064(Solicitud instance) throws SystemException {
        try {
            // COUNT (Usuarios) WHERE (Usuarios.IMC <> NULL AND Usuarios.drvEdad >= StrToReal(fugetValorParametroConf("EDADIMC")) AND Usuarios.IMC > StrToReal(fugetValorParametroConf("MAXIMC")))
            Long count = 0L;
            for(Usuario item : assocOperator064Range1(instance)){
                // Usuarios.drvEdad >= StrToReal(fugetValorParametroConf("EDADIMC"))
                if(Utilities.convertToDouble(Utilities.convertToDouble(item.getUsuariodrvEdad())) >= STDFunctions.strToRealFun(userFunctionsSrv.fugetValorParametroConfFun("EDADIMC")))
                    count += 1;
            }
            return count;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator064, Method: assocOperator064");
        }
    }

    // Range 1 for AssocOperator AssocOperator064
    public Collection<Usuario> assocOperator064Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator064Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator064
    public SQLPopulation assocOperator064Range1Query (Solicitud instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.IMC <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOIMC, Constants.Type.REAL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);


            // Usuarios.IMC > StrToReal(fugetValorParametroConf("MAXIMC"))
                    // '>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator(">");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIOIMC, Constants.Type.REAL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                            if (STDFunctions.strToRealFun(userFunctionsSrv.fugetValorParametroConfFun("MAXIMC")) != null) {
                                SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(STDFunctions.strToRealFun(userFunctionsSrv.fugetValorParametroConfFun("MAXIMC")), Constants.Type.REAL.getTypeName());
                            comparison2.setSecondOperand(operand224);
                            } else {
                                SQLWhereOperandNull operand224 = new SQLWhereOperandNull();
                    comparison2.setSecondOperand(operand224);
                                }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator064, Method: assocOperator064Range1Query");
        }
    }

    // AssocOperator: AssocOperator065
    public Boolean assocOperator065(Solicitud instance) throws SystemException {
        try {
            // EXIST (UsrAreaMedica)
            return assocOperator065Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator065, Method: assocOperator065");
        }
    }

    // Range 1 for AssocOperator AssocOperator065
    public Boolean assocOperator065Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator065Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator065
    public SQLExists assocOperator065Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USRAREAMEDICA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator065, Method: assocOperator065Range1Query");
        }
    }

    // AssocOperator: AssocOperator066
    public Boolean assocOperator066(Solicitud instance) throws SystemException {
        try {
            // EXIST (ContratantePersona)
            return assocOperator066Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator066, Method: assocOperator066");
        }
    }

    // Range 1 for AssocOperator AssocOperator066
    public Boolean assocOperator066Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator066Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator066
    public SQLExists assocOperator066Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTEPERSONA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator066, Method: assocOperator066Range1Query");
        }
    }

    // AssocOperator: AssocOperator067
    public Long assocOperator067(Solicitud instance) throws SystemException {
        try {
            // COUNT (AESOLICITUDES.ProductoT.Dominios) WHERE (AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT AND AESOLICITUDES.ProductoT.Dominios.TramiteEnLinea = true)
            return assocOperator067Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator067, Method: assocOperator067");
        }
    }

    // Range 1 for AssocOperator AssocOperator067
    public Long assocOperator067Range1 (Solicitud instance) throws SystemException {
        SQLCount sql = assocOperator067Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator067
    public SQLCount assocOperator067Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.ProductoT.Dominios.PlanT = AESOLICITUDES.PlanT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (instance.getAESOLICITUDES().isNull() || instance.getAESOLICITUDES().getPlanT().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getAESOLICITUDES().getPlanT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // AESOLICITUDES.ProductoT.Dominios.TramiteEnLinea = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOTRAMITEENLINEA, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator067, Method: assocOperator067Range1Query");
        }
    }

    // AssocOperator: AssocOperator068
    public String assocOperator068(Solicitud instance) throws SystemException {
        try {
            // GETONE (AESOLICITUDES.PlanT.Tarifas.Codigo) WHERE (AESOLICITUDES.PlanT.Tarifas.ProductoT = AESOLICITUDES.ProductoT AND EXIST (AESOLICITUDES.PlanT.Tarifas.DetallesTarifa) WHERE (AESOLICITUDES.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)) = true)
            return assocOperator068Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator068, Method: assocOperator068");
        }
    }

    // Range 1 for AssocOperator AssocOperator068
    public String assocOperator068Range1 (Solicitud instance) throws SystemException {
        SQLGetOne sql = assocOperator068Range1Query(instance);
        return new TypedQueryBuilder<String>(em, String.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator068
    public SQLGetOne assocOperator068Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ATTR_NAME_TARIFACODIGO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.PlanT.Tarifas.ProductoT = AESOLICITUDES.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getAESOLICITUDES().getProductoT().getOid(), SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // EXIST (AESOLICITUDES.PlanT.Tarifas.DetallesTarifa) WHERE (AESOLICITUDES.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator069 = new SQLWhereOperandSubQuery(assocOperator069Range1Query(instance, sql));
                conjunction.addOperand(operandSubQueryAssocOperator069);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator068, Method: assocOperator068Range1Query");
        }
    }

    // AssocOperator: AssocOperator069
    public Boolean assocOperator069(Solicitud instance) throws SystemException {
        try {
            // EXIST (AESOLICITUDES.PlanT.Tarifas.DetallesTarifa) WHERE (AESOLICITUDES.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato))
            return assocOperator069Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator069, Method: assocOperator069");
        }
    }

    // Range 1 for AssocOperator AssocOperator069
    public Boolean assocOperator069Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator069Range1Query(instance, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator069
    public SQLExists assocOperator069Range1Query (Solicitud instance, SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AESOLICITUDES.PlanT.Tarifas.DetallesTarifa.Anyo = getYear(FInicioContrato)
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AESOLICITUDESConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_TARIFAS + "." + TarifaConstants.ROLE_NAME_DETALLESTARIFA + "." + DetalleTarifaConstants.ATTR_NAME_DETALLETARIFAANYO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                            if (STDFunctions.getYearFun(instance.getSolicitudFInicioContrato()) != null) {
                                SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(STDFunctions.getYearFun(instance.getSolicitudFInicioContrato()), Constants.Type.INT.getTypeName());
                            comparison1.setSecondOperand(operand223);
                            } else {
                                SQLWhereOperandNull operand223 = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand223);
                                }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator069, Method: assocOperator069Range1Query");
        }
    }

    // AssocOperator: AssocOperator070
    public Boolean assocOperator070(Solicitud instance) throws SystemException {
        try {
            // EXIST (TitularPersona)
            return assocOperator070Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator070, Method: assocOperator070");
        }
    }

    // Range 1 for AssocOperator AssocOperator070
    public Boolean assocOperator070Range1 (Solicitud instance) throws SystemException {
        SQLExists sql = assocOperator070Range1Query(instance);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator070
    public SQLExists assocOperator070Range1Query (Solicitud instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULARPERSONA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator070, Method: assocOperator070Range1Query");
        }
    }

    // AssocOperator: AssocOperator071
    public Boolean assocOperator071() throws SystemException {
        try {
            // EXIST (ContratoC)
            return assocOperator071Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator071, Method: assocOperator071");
        }
    }

    // Range 0 for AssocOperator AssocOperator071
    public Boolean assocOperator071Range1 () throws SystemException {
        SQLExists sql = assocOperator071Range1Query(null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator071
    public SQLExists assocOperator071Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator071, Method: assocOperator071Range1Query");
        }
    }

    // AssocOperator: AssocOperator072
    public Boolean assocOperator072(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvConfirmado = false)
            for(Usuario item : assocOperator072Range1(instance)){
                // Usuarios.drvConfirmado = false
                if(item.getUsuariodrvConfirmado().equals(false))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator072, Method: assocOperator072");
        }
    }

    // Range 1 for AssocOperator AssocOperator072
    public Collection<Usuario> assocOperator072Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator072Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator072
    public SQLPopulation assocOperator072Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator072, Method: assocOperator072Range1Query");
        }
    }

    // AssocOperator: AssocOperator073
    public Boolean assocOperator073(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator073Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator073, Method: assocOperator073");
        }
    }

    // Range 0 for AssocOperator AssocOperator073
    public Boolean assocOperator073Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator073Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator073
    public SQLExists assocOperator073Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSADMIN_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSADMIN_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator073, Method: assocOperator073Range1Query");
        }
    }

    // AssocOperator: AssocOperator074
    public Boolean assocOperator074(Persona voPersona) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.UsuarioPersona.TipoIdentificacion = voPersona.TipoIdentificacion AND Usuarios.UsuarioPersona.NumIdentificacion = voPersona.NumIdentificacion)
            return assocOperator074Range1(voPersona);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator074, Method: assocOperator074");
        }
    }

    // Range 0 for AssocOperator AssocOperator074
    public Boolean assocOperator074Range1 (Persona voPersona) throws SystemException {
        SQLExists sql = assocOperator074Range1Query(voPersona, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator074
    public SQLExists assocOperator074Range1Query (Persona voPersona, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.UsuarioPersona.TipoIdentificacion = voPersona.TipoIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (voPersona.isNull() || voPersona.getTipoIdentificacion().isNull())
                    {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    else
                    {
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONTRATANTETITULAR_VOPERSONA + "." + PersonaConstants.ROLE_NAME_TIPOIDENTIFICACION, PersonaConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voPersona.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONTRATANTETITULAR_VOPERSONA);
                    comparison1.setSecondOperand(operand223);
                    }
                    conjunction.addOperand(comparison1);


            // Usuarios.UsuarioPersona.NumIdentificacion = voPersona.NumIdentificacion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_USUARIOPERSONA + "." + PersonaConstants.ATTR_NAME_PERSONANUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (voPersona.getPersonaNumIdentificacion()!= null){
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(voPersona.getPersonaNumIdentificacion(), Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator074, Method: assocOperator074Range1Query");
        }
    }

    // AssocOperator: AssocOperator075
    public Boolean assocOperator075() throws SystemException {
        try {
            // EXIST (ContratoC)
            return assocOperator075Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator075, Method: assocOperator075");
        }
    }

    // Range 0 for AssocOperator AssocOperator075
    public Boolean assocOperator075Range1 () throws SystemException {
        SQLExists sql = assocOperator075Range1Query(null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator075
    public SQLExists assocOperator075Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATOC);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator075, Method: assocOperator075Range1Query");
        }
    }

    // AssocOperator: AssocOperator076
    public Boolean assocOperator076(Solicitud instance) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.drvConfirmado = false)
            for(Usuario item : assocOperator076Range1(instance)){
                // Usuarios.drvConfirmado = false
                if(item.getUsuariodrvConfirmado().equals(false))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator076, Method: assocOperator076");
        }
    }

    // Range 1 for AssocOperator AssocOperator076
    public Collection<Usuario> assocOperator076Range1 (Solicitud instance) throws SystemException {

        SQLSelect sql = assocOperator076Range1Query(instance);
        return new TypedQueryBuilder<Usuario>(em, Usuario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator076
    public SQLPopulation assocOperator076Range1Query (Solicitud instance) throws SystemException {
        try {
            return new SQLPopulation(SolicitudConstants.CLASS_NAME, UsuarioConstants.CLASS_NAME, instance.getOid(), SolicitudConstants.ROLE_NAME_USUARIOS);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator076, Method: assocOperator076Range1Query");
        }
    }

    // AssocOperator: AssocOperator077
    public Boolean assocOperator077(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Contratante) WHERE (Contratante.TipoIdentificacion = voTipoDoc AND Contratante.NumIdentificacion = vNumDoc)
            return assocOperator077Range1(voTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator077, Method: assocOperator077");
        }
    }

    // Range 0 for AssocOperator AssocOperator077
    public Boolean assocOperator077Range1 (TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator077Range1Query(voTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator077
    public SQLExists assocOperator077Range1Query (TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_CONTRATANTE);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Contratante.TipoIdentificacion = voTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_CONTRATANTE + "." + ContratanteConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Contratante.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_CONTRATANTE + "." + ContratanteConstants.ATTR_NAME_CONTRATANTENUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator077, Method: assocOperator077Range1Query");
        }
    }

    // AssocOperator: AssocOperator078
    public Boolean assocOperator078(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Titular) WHERE (Titular.TipoIdentificacion = voTipoDoc AND Titular.NumIdentificacion = vNumDoc)
            return assocOperator078Range1(voTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator078, Method: assocOperator078");
        }
    }

    // Range 0 for AssocOperator AssocOperator078
    public Boolean assocOperator078Range1 (TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator078Range1Query(voTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator078
    public SQLExists assocOperator078Range1Query (TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_TITULAR);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Titular.TipoIdentificacion = voTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_TITULAR + "." + TitularConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Titular.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_TITULAR + "." + TitularConstants.ATTR_NAME_TITULARNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator078, Method: assocOperator078Range1Query");
        }
    }

    // AssocOperator: AssocOperator079
    public Boolean assocOperator079(TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = voTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator079Range1(voTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator079, Method: assocOperator079");
        }
    }

    // Range 0 for AssocOperator AssocOperator079
    public Boolean assocOperator079Range1 (TipoIdentificacion voTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator079Range1Query(voTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator079
    public SQLExists assocOperator079Range1Query (TipoIdentificacion voTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = voTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, voTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDCONSULTARADICADO_VOTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator079, Method: assocOperator079Range1Query");
        }
    }

    // AssocOperator: AssocOperator080
    public Boolean assocOperator080(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator080Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator080, Method: assocOperator080");
        }
    }

    // Range 0 for AssocOperator AssocOperator080
    public Boolean assocOperator080Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator080Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator080
    public SQLExists assocOperator080Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL1_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL1_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator080, Method: assocOperator080Range1Query");
        }
    }

    // AssocOperator: AssocOperator081
    public Boolean assocOperator081(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator081Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator081, Method: assocOperator081");
        }
    }

    // Range 0 for AssocOperator AssocOperator081
    public Boolean assocOperator081Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator081Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator081
    public SQLExists assocOperator081Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL2_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL2_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator081, Method: assocOperator081Range1Query");
        }
    }

    // AssocOperator: AssocOperator082
    public Boolean assocOperator082(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator082Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator082, Method: assocOperator082");
        }
    }

    // Range 0 for AssocOperator AssocOperator082
    public Boolean assocOperator082Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator082Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator082
    public SQLExists assocOperator082Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL3_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSAFIL3_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator082, Method: assocOperator082Range1Query");
        }
    }

    // AssocOperator: AssocOperator083
    public Boolean assocOperator083(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator083Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator083, Method: assocOperator083");
        }
    }

    // Range 0 for AssocOperator AssocOperator083
    public Boolean assocOperator083Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator083Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator083
    public SQLExists assocOperator083Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator083, Method: assocOperator083Range1Query");
        }
    }

    // AssocOperator: AssocOperator084
    public Boolean assocOperator084(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator084Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator084, Method: assocOperator084");
        }
    }

    // Range 0 for AssocOperator AssocOperator084
    public Boolean assocOperator084Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator084Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator084
    public SQLExists assocOperator084Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED2_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED2_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator084, Method: assocOperator084Range1Query");
        }
    }

    // AssocOperator: AssocOperator085
    public Boolean assocOperator085(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator085Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator085, Method: assocOperator085");
        }
    }

    // Range 0 for AssocOperator AssocOperator085
    public Boolean assocOperator085Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator085Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator085
    public SQLExists assocOperator085Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED3_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED3_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator085, Method: assocOperator085Range1Query");
        }
    }

    // AssocOperator: AssocOperator086
    public Boolean assocOperator086(TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        try {
            // EXIST (Usuarios) WHERE (Usuarios.TipoIdentificacion = vTipoDoc AND Usuarios.NumIdentificacion = vNumDoc)
            return assocOperator086Range1(vTipoDoc, vNumDoc);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Solicitud, Assoc.Operator: AssocOperator086, Method: assocOperator086");
        }
    }

    // Range 0 for AssocOperator AssocOperator086
    public Boolean assocOperator086Range1 (TipoIdentificacion vTipoDoc, String vNumDoc) throws SystemException {
        SQLExists sql = assocOperator086Range1Query(vTipoDoc, vNumDoc, null);
        return !new TypedQueryBuilder<Solicitud>(em, Solicitud.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator086
    public SQLExists assocOperator086Range1Query (TipoIdentificacion vTipoDoc, String vNumDoc, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudConstants.CLASS_NAME, SolicitudConstants.ROLE_NAME_USUARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Usuarios.TipoIdentificacion = vTipoDoc
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ROLE_NAME_TIPOIDENTIFICACION, TipoIdentificacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VTIPODOC, TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, vTipoDoc.getOid(), SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VTIPODOC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Usuarios.NumIdentificacion = vNumDoc
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudConstants.ROLE_NAME_USUARIOS + "." + UsuarioConstants.ATTR_NAME_USUARIONUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vNumDoc, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Solicitud, Assoc.Operator: AssocOperator086, Method: assocOperator086Range1Query");
        }
    }
}
