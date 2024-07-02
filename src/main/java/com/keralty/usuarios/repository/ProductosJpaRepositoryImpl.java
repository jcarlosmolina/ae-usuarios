package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.AgentexProductoConstants;
import com.keralty.usuarios.global.AsesorConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.ProductosConstants;
import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLPopulation;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class ProductosJpaRepositoryImpl extends AbstractRepository implements ProductosJpaRepositoryCustom {

    @Override
    public List<Productos> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Productos> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Productos> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Productos> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Productos.class);
    }
    
    public List<Productos> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Productos> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator010
    public Boolean assocOperator010(Productos instance) throws SystemException {
        try {
            // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = AGENTAsesor AND AgentexProducto.drvVigente = true)
            for(AgentexProducto item : assocOperator010Range1(instance)){
                // AgentexProducto.drvVigente = true
                if(item.getAgentexProductodrvVigente().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Productos, Assoc.Operator: AssocOperator010, Method: assocOperator010");
        }
    }

    // Range 1 for AssocOperator AssocOperator010
    public Collection<AgentexProducto> assocOperator010Range1 (Productos instance) throws SystemException {

        SQLSelect sql = assocOperator010Range1Query(instance);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator010
    public SQLPopulation assocOperator010Range1Query (Productos instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ProductosConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, instance.getOid(), ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Productos, Assoc.Operator: AssocOperator010, Method: assocOperator010Range1Query");
        }
    }

    // AssocOperator: AssocOperator011
    public Boolean assocOperator011(Productos instance) throws SystemException {
        try {
            // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = AGENTAsesor AND AgentexProducto.drvVigente = true)
            for(AgentexProducto item : assocOperator011Range1(instance)){
                // AgentexProducto.drvVigente = true
                if(item.getAgentexProductodrvVigente().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Productos, Assoc.Operator: AssocOperator011, Method: assocOperator011");
        }
    }

    // Range 1 for AssocOperator AssocOperator011
    public Collection<AgentexProducto> assocOperator011Range1 (Productos instance) throws SystemException {

        SQLSelect sql = assocOperator011Range1Query(instance);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator011
    public SQLPopulation assocOperator011Range1Query (Productos instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ProductosConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, instance.getOid(), ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Productos, Assoc.Operator: AssocOperator011, Method: assocOperator011Range1Query");
        }
    }

    // AssocOperator: AssocOperator012
    public Boolean assocOperator012(Productos instance) throws SystemException {
        try {
            // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = AGENTAsesor AND AgentexProducto.drvVigente = true)
            for(AgentexProducto item : assocOperator012Range1(instance)){
                // AgentexProducto.drvVigente = true
                if(item.getAgentexProductodrvVigente().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Productos, Assoc.Operator: AssocOperator012, Method: assocOperator012");
        }
    }

    // Range 1 for AssocOperator AssocOperator012
    public Collection<AgentexProducto> assocOperator012Range1 (Productos instance) throws SystemException {

        SQLSelect sql = assocOperator012Range1Query(instance);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator012
    public SQLPopulation assocOperator012Range1Query (Productos instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ProductosConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, instance.getOid(), ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Productos, Assoc.Operator: AssocOperator012, Method: assocOperator012Range1Query");
        }
    }

    // AssocOperator: AssocOperator013
    public Boolean assocOperator013(Productos instance) throws SystemException {
        try {
            // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = AGENTAsesor AND AgentexProducto.drvVigente = true)
            for(AgentexProducto item : assocOperator013Range1(instance)){
                // AgentexProducto.drvVigente = true
                if(item.getAgentexProductodrvVigente().equals(true))
                    return true;
            }
            return false;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Productos, Assoc.Operator: AssocOperator013, Method: assocOperator013");
        }
    }

    // Range 1 for AssocOperator AssocOperator013
    public Collection<AgentexProducto> assocOperator013Range1 (Productos instance) throws SystemException {

        SQLSelect sql = assocOperator013Range1Query(instance);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator013
    public SQLPopulation assocOperator013Range1Query (Productos instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ProductosConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, instance.getOid(), ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = AGENTAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ProductosConstants.ROLE_NAME_AGENTEXPRODUCTO + "." + AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, (((Asesor)agent.getAgentInstance(AsesorConstants.CLASS_NAME))).getOid(), Constants.AGENT_ASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Productos, Assoc.Operator: AssocOperator013, Method: assocOperator013Range1Query");
        }
    }
}
