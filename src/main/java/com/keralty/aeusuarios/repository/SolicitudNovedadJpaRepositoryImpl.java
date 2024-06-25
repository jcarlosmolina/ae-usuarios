package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.CausaExclusionConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.FamiliaNovedadConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.NovedadConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.TipoNovedadConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioNovedadConstants;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLGetOne;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class SolicitudNovedadJpaRepositoryImpl extends AbstractRepository implements SolicitudNovedadJpaRepositoryCustom {

    @Override
    public List<SolicitudNovedad> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<SolicitudNovedad> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<SolicitudNovedad> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<SolicitudNovedad> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, SolicitudNovedad.class);
    }
    
    public List<SolicitudNovedad> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<SolicitudNovedad> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000() throws SystemException {
        try {
            // EXIST (UsrAfiliacion) WHERE (UsrAfiliacion = agent)
            return assocOperator000Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 () throws SystemException {
        SQLExists sql = assocOperator000Range1Query(null);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // UsrAfiliacion = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, FuncionarioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Long assocOperator001() throws SystemException {
        try {
            // COUNT (PlanT.Afiliaciones) WHERE (PlanT.Afiliaciones = agent)
            return assocOperator001Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 0 for AssocOperator AssocOperator001
    public Long assocOperator001Range1 () throws SystemException {
        SQLCount sql = assocOperator001Range1Query(null);
        return Long.valueOf(new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator001
    public SQLCount assocOperator001Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Afiliaciones = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_AFILIACIONES, AfiliacionesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AfiliacionesConstants.CLASS_NAME, AfiliacionesConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (GrupoAsociado)
            return assocOperator002Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Boolean assocOperator002Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLExists assocOperator002Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_GRUPOASOCIADO, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Boolean assocOperator003(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Periodicidad)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Boolean assocOperator003Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLExists assocOperator003Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PERIODICIDAD, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Long assocOperator004(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Familias)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Long assocOperator004Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator004Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLCount assocOperator004Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Long assocOperator005(SolicitudNovedad instance) throws SystemException {
        try {
            // COUNT (Familias)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Long assocOperator005Range1 (SolicitudNovedad instance) throws SystemException {
        SQLCount sql = assocOperator005Range1Query(instance);
        return Long.valueOf(new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().size());
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLCount assocOperator005Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLCount(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }

    // AssocOperator: AssocOperator006
    public Boolean assocOperator006(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Causal)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator006, Method: assocOperator006");
        }
    }

    // Range 1 for AssocOperator AssocOperator006
    public Boolean assocOperator006Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator006Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator006
    public SQLExists assocOperator006Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_CAUSAL, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query");
        }
    }

    // AssocOperator: AssocOperator007
    public Boolean assocOperator007(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Causal)
            return assocOperator007Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator007, Method: assocOperator007");
        }
    }

    // Range 1 for AssocOperator AssocOperator007
    public Boolean assocOperator007Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator007Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator007
    public SQLExists assocOperator007Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_CAUSAL, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query");
        }
    }

    // AssocOperator: AssocOperator008
    public Boolean assocOperator008(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PlanT.Dominios) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorOscuro <> NULL)
            return assocOperator008Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator008, Method: assocOperator008");
        }
    }

    // Range 1 for AssocOperator AssocOperator008
    public Boolean assocOperator008Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator008Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator008
    public SQLExists assocOperator008Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorOscuro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLOROSCURO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query");
        }
    }

    // AssocOperator: AssocOperator009
    public String assocOperator009(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.Dominios.SolNovColorOscuro) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorOscuro <> NULL)
            return assocOperator009Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator009, Method: assocOperator009");
        }
    }

    // Range 1 for AssocOperator AssocOperator009
    public String assocOperator009Range1 (SolicitudNovedad instance) throws SystemException {
        SQLGetOne sql = assocOperator009Range1Query(instance);
        return new TypedQueryBuilder<String>(em, String.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator009
    public SQLGetOne assocOperator009Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLOROSCURO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorOscuro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLOROSCURO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator009, Method: assocOperator009Range1Query");
        }
    }

    // AssocOperator: AssocOperator010
    public Boolean assocOperator010(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PlanT.Dominios) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorClaro <> NULL)
            return assocOperator010Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator010, Method: assocOperator010");
        }
    }

    // Range 1 for AssocOperator AssocOperator010
    public Boolean assocOperator010Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator010Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator010
    public SQLExists assocOperator010Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorClaro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLORCLARO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query");
        }
    }

    // AssocOperator: AssocOperator011
    public String assocOperator011(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.Dominios.SolNovColorClaro) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovColorClaro <> NULL)
            return assocOperator011Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator011, Method: assocOperator011");
        }
    }

    // Range 1 for AssocOperator AssocOperator011
    public String assocOperator011Range1 (SolicitudNovedad instance) throws SystemException {
        SQLGetOne sql = assocOperator011Range1Query(instance);
        return new TypedQueryBuilder<String>(em, String.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator011
    public SQLGetOne assocOperator011Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLORCLARO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovColorClaro <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVCOLORCLARO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query");
        }
    }

    // AssocOperator: AssocOperator012
    public Boolean assocOperator012(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PlanT.Dominios) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovLogo <> NULL)
            return assocOperator012Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator012, Method: assocOperator012");
        }
    }

    // Range 1 for AssocOperator AssocOperator012
    public Boolean assocOperator012Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator012Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator012
    public SQLExists assocOperator012Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovLogo <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVLOGO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query");
        }
    }

    // AssocOperator: AssocOperator013
    public String assocOperator013(SolicitudNovedad instance) throws SystemException {
        try {
            // GETONE (PlanT.Dominios.SolNovLogo) WHERE (PlanT.Dominios.ProductoT = PlanT.ProductoT AND PlanT.Dominios.SolNovLogo <> NULL)
            return assocOperator013Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator013, Method: assocOperator013");
        }
    }

    // Range 1 for AssocOperator AssocOperator013
    public String assocOperator013Range1 (SolicitudNovedad instance) throws SystemException {
        SQLGetOne sql = assocOperator013Range1Query(instance);
        return new TypedQueryBuilder<String>(em, String.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator013
    public SQLGetOne assocOperator013Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVLOGO, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // PlanT.Dominios.ProductoT = PlanT.ProductoT
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, instance.getPlanT().getProductoT().getOid(), SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // PlanT.Dominios.SolNovLogo <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOSOLNOVLOGO, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query");
        }
    }

    // AssocOperator: AssocOperator014
    public Boolean assocOperator014(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (PeriodicidadNueva)
            return assocOperator014Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator014, Method: assocOperator014");
        }
    }

    // Range 1 for AssocOperator AssocOperator014
    public Boolean assocOperator014Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator014Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator014
    public SQLExists assocOperator014Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_PERIODICIDADNUEVA, instance.getOid());
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator014, Method: assocOperator014Range1Query");
        }
    }

    // AssocOperator: AssocOperator015
    public Boolean assocOperator015(SolicitudNovedad instance) throws SystemException {
        try {
            // EXIST (Novedad.TipoNovedad.Novedades.CausasExclusion) WHERE (Novedad.TipoNovedad.Novedades.CausasExclusion.Novedad.AliasNovedad = fugetValorParametroConf("SOLNOVSUSVIAJE") AND Novedad.TipoNovedad.Novedades.CausasExclusion.Descripcion = CtrTagCausaExclusion)
            return assocOperator015Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator015, Method: assocOperator015");
        }
    }

    // Range 1 for AssocOperator AssocOperator015
    public Boolean assocOperator015Range1 (SolicitudNovedad instance) throws SystemException {
        SQLExists sql = assocOperator015Range1Query(instance);
        return !new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator015
    public SQLExists assocOperator015Range1Query (SolicitudNovedad instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ROLE_NAME_NOVEDADES + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Novedad.TipoNovedad.Novedades.CausasExclusion.Novedad.AliasNovedad = fugetValorParametroConf("SOLNOVSUSVIAJE")
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ROLE_NAME_NOVEDADES + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION + "." + CausaExclusionConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                            if (userFunctionsSrv.fugetValorParametroConfFun("SOLNOVSUSVIAJE") != null) {
                                SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(userFunctionsSrv.fugetValorParametroConfFun("SOLNOVSUSVIAJE"), Constants.Type.STRING.getTypeName());
                            comparison1.setSecondOperand(operand223);
                            } else {
                                SQLWhereOperandNull operand223 = new SQLWhereOperandNull();
                    comparison1.setSecondOperand(operand223);
                                }
                    conjunction.addOperand(comparison1);


            // Novedad.TipoNovedad.Novedades.CausasExclusion.Descripcion = CtrTagCausaExclusion
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ROLE_NAME_NOVEDADES + "." + NovedadConstants.ROLE_NAME_CAUSASEXCLUSION + "." + CausaExclusionConstants.ATTR_NAME_CAUSAEXCLUSIONDESCRIPCION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    if (instance.getSolicitudNovedadCtrTagCausaExclusion()!= null){
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(instance.getSolicitudNovedadCtrTagCausaExclusion(), Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    } else {
                    comparison2.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator015, Method: assocOperator015Range1Query");
        }
    }

    // AssocOperator: AssocOperator016
    public Long assocOperator016(String vfTipoIdent, String vfNumIdent) throws SystemException {
        try {
            // COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent)
            return assocOperator016Range1(vfTipoIdent, vfNumIdent);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator016, Method: assocOperator016");
        }
    }

    // Range 0 for AssocOperator AssocOperator016
    public Long assocOperator016Range1 (String vfTipoIdent, String vfNumIdent) throws SystemException {
        SQLCount sql = assocOperator016Range1Query(vfTipoIdent, vfNumIdent, null);
        return Long.valueOf(new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator016
    public SQLCount assocOperator016Range1Query (String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vfTipoIdent, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vfNumIdent, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator016, Method: assocOperator016Range1Query");
        }
    }

    // AssocOperator: AssocOperator017
    public Long assocOperator017(String vfTipoIdent, String vfNumIdent) throws SystemException {
        try {
            // COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent AND Familias.UsuarioNovedad.Excluido = true)
            return assocOperator017Range1(vfTipoIdent, vfNumIdent);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator017, Method: assocOperator017");
        }
    }

    // Range 0 for AssocOperator AssocOperator017
    public Long assocOperator017Range1 (String vfTipoIdent, String vfNumIdent) throws SystemException {
        SQLCount sql = assocOperator017Range1Query(vfTipoIdent, vfNumIdent, null);
        return Long.valueOf(new TypedQueryBuilder<SolicitudNovedad>(em, SolicitudNovedad.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator017
    public SQLCount assocOperator017Range1Query (String vfTipoIdent, String vfNumIdent, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ROLE_NAME_TIPOIDENTIFICACION + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vfTipoIdent, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADNUMIDENTIFICACION, Constants.Type.STRING.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vfNumIdent, Constants.Type.STRING.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);


            // Familias.UsuarioNovedad.Excluido = true
                    // '=' Comparison
                    SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                    comparison3.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_FAMILIAS + "." + FamiliaNovedadConstants.ROLE_NAME_USUARIONOVEDAD + "." + UsuarioNovedadConstants.ATTR_NAME_USUARIONOVEDADEXCLUIDO, Constants.Type.BOOL.getTypeName());
                    comparison3.setFirstOperand(operand114);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison3.setSecondOperand(operand225);
                    conjunction.addOperand(comparison3);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: SolicitudNovedad, Assoc.Operator: AssocOperator017, Method: assocOperator017Range1Query");
        }
    }
}
