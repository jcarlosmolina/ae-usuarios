package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.BeneficiarioCConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.ContratoCConstants;
import com.keralty.usuarios.global.DominioConstants;
import com.keralty.usuarios.global.FamiliaCConstants;
import com.keralty.usuarios.global.PersonaCConstants;
import com.keralty.usuarios.global.PlanesConstants;
import com.keralty.usuarios.global.ProductosConstants;
import com.keralty.usuarios.global.TipoIdentificacionConstants;
import com.keralty.usuarios.persistence.BeneficiarioC;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLGetOne;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLPopulation;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.usuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.usuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class ContratoCJpaRepositoryImpl extends AbstractRepository implements ContratoCJpaRepositoryCustom {

    @Override
    public List<ContratoC> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ContratoC> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ContratoC> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ContratoC> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ContratoC.class);
    }
    
    public List<ContratoC> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ContratoC> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Double assocOperator000(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvValorCuotaAfiliacion)
            Double result = 0.0;
            for(BeneficiarioC item : assocOperator000Range1(instance)){
                result += item.getBeneficiarioCdrvValorCuotaAfiliacion();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<BeneficiarioC> assocOperator000Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Double assocOperator001(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvValorInicialContrato) WHERE (BeneficiariosC.PersonaC.TipoIdentificacionC.NombreCorto = "MS")
            Double result = 0.0;
            for(BeneficiarioC item : assocOperator001Range1(instance)){
                result += item.getBeneficiarioCdrvValorInicialContrato();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 1 for AssocOperator AssocOperator001
    public Collection<BeneficiarioC> assocOperator001Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator001
    public SQLPopulation assocOperator001Range1Query (ContratoC instance) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // BeneficiariosC.PersonaC.TipoIdentificacionC.NombreCorto = "MS"
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_BENEFICIARIOSC + "." + BeneficiarioCConstants.ROLE_NAME_PERSONAC + "." + PersonaCConstants.ROLE_NAME_TIPOIDENTIFICACIONC + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONNOMBRECORTO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral("MS", Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Double assocOperator002(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvValorCuotaBruta)
            Double result = 0.0;
            for(BeneficiarioC item : assocOperator002Range1(instance)){
                result += item.getBeneficiarioCdrvValorCuotaBruta();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 1 for AssocOperator AssocOperator002
    public Collection<BeneficiarioC> assocOperator002Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator002Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator002
    public SQLPopulation assocOperator002Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Boolean assocOperator003(ContratoC instance) throws SystemException {
        try {
            // EXIST (ProductoC.Dominios) WHERE (ProductoC.Dominios.PlanT = PlanC AND ProductoC.Dominios.MostrarPreexAnexos = true)
            return assocOperator003Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }

    // Range 1 for AssocOperator AssocOperator003
    public Boolean assocOperator003Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator003Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator003
    public SQLExists assocOperator003Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ProductoC.Dominios.PlanT = PlanC
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ContratoCConstants.ROLE_NAME_PLANC, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getPlanC().getOid(), ContratoCConstants.ROLE_NAME_PLANC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ProductoC.Dominios.MostrarPreexAnexos = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOMOSTRARPREEXANEXOS, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }

    // AssocOperator: AssocOperator004
    public Boolean assocOperator004(ContratoC instance) throws SystemException {
        try {
            // EXIST (ProductoC.Dominios) WHERE (ProductoC.Dominios.PlanT = PlanC AND ProductoC.Dominios.MostrarPreexContrato = true)
            return assocOperator004Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // Range 1 for AssocOperator AssocOperator004
    public Boolean assocOperator004Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator004Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator004
    public SQLExists assocOperator004Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // ProductoC.Dominios.PlanT = PlanC
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(ContratoCConstants.ROLE_NAME_PLANC, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, instance.getPlanC().getOid(), ContratoCConstants.ROLE_NAME_PLANC);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // ProductoC.Dominios.MostrarPreexContrato = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_PRODUCTOC + "." + ProductosConstants.ROLE_NAME_DOMINIOS + "." + DominioConstants.ATTR_NAME_DOMINIOMOSTRARPREEXCONTRATO, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator004, Method: assocOperator004Range1Query");
        }
    }

    // AssocOperator: AssocOperator005
    public Boolean assocOperator005(ContratoC instance) throws SystemException {
        try {
            // EXIST (FamiliasC) WHERE (FamiliasC.NumFamilia <> NULL)
            return assocOperator005Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator005, Method: assocOperator005");
        }
    }

    // Range 1 for AssocOperator AssocOperator005
    public Boolean assocOperator005Range1 (ContratoC instance) throws SystemException {
        SQLExists sql = assocOperator005Range1Query(instance);
        return !new TypedQueryBuilder<ContratoC>(em, ContratoC.class).build(sql).execute().isEmpty();
    }

    // Range Query 1 for AssocOperator AssocOperator005
    public SQLExists assocOperator005Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_FAMILIASC, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FamiliasC.NumFamilia <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_FAMILIASC + "." + FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator005, Method: assocOperator005Range1Query");
        }
    }

    // AssocOperator: AssocOperator006
    public String assocOperator006(ContratoC instance) throws SystemException {
        try {
            // GETONE (FamiliasC.NumFamilia) WHERE (FamiliasC.NumFamilia <> NULL)
            return assocOperator006Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator006, Method: assocOperator006");
        }
    }

    // Range 1 for AssocOperator AssocOperator006
    public String assocOperator006Range1 (ContratoC instance) throws SystemException {
        SQLGetOne sql = assocOperator006Range1Query(instance);
        return new TypedQueryBuilder<String>(em, String.class).build(sql).getSingleResult();
    }

    // Range Query 1 for AssocOperator AssocOperator006
    public SQLGetOne assocOperator006Range1Query (ContratoC instance) throws SystemException {
        try {
            // The path starts with a role
            SQLGetOne sql = new SQLGetOne(ContratoCConstants.CLASS_NAME, ContratoCConstants.ROLE_NAME_FAMILIASC + "." + FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, instance.getOid());
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FamiliasC.NumFamilia <> NULL
                    // '<>' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ContratoCConstants.ROLE_NAME_FAMILIASC + "." + FamiliaCConstants.ATTR_NAME_FAMILIACNUMFAMILIA, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator006, Method: assocOperator006Range1Query");
        }
    }

    // AssocOperator: AssocOperator007
    public Double assocOperator007(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvDescuentoComercial)
            Double result = 0.0;
            for(BeneficiarioC item : assocOperator007Range1(instance)){
                result += item.getBeneficiarioCdrvDescuentoComercial();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator007, Method: assocOperator007");
        }
    }

    // Range 1 for AssocOperator AssocOperator007
    public Collection<BeneficiarioC> assocOperator007Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator007Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator007
    public SQLPopulation assocOperator007Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator007, Method: assocOperator007Range1Query");
        }
    }

    // AssocOperator: AssocOperator008
    public Double assocOperator008(ContratoC instance) throws SystemException {
        try {
            // SUM (BeneficiariosC.drvDescuentoFinanciero)
            Double result = 0.0;
            for(BeneficiarioC item : assocOperator008Range1(instance)){
                result += item.getBeneficiarioCdrvDescuentoFinanciero();
            }
            return result;
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ContratoC, Assoc.Operator: AssocOperator008, Method: assocOperator008");
        }
    }

    // Range 1 for AssocOperator AssocOperator008
    public Collection<BeneficiarioC> assocOperator008Range1 (ContratoC instance) throws SystemException {

        SQLSelect sql = assocOperator008Range1Query(instance);
        return new TypedQueryBuilder<BeneficiarioC>(em, BeneficiarioC.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator008
    public SQLPopulation assocOperator008Range1Query (ContratoC instance) throws SystemException {
        try {
            return new SQLPopulation(ContratoCConstants.CLASS_NAME, BeneficiarioCConstants.CLASS_NAME, instance.getOid(), ContratoCConstants.ROLE_NAME_BENEFICIARIOSC);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ContratoC, Assoc.Operator: AssocOperator008, Method: assocOperator008Range1Query");
        }
    }
}
