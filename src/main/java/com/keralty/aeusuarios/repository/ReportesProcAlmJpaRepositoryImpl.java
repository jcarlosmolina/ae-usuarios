package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.ReportesProcAlmConstants;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLParam;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class ReportesProcAlmJpaRepositoryImpl extends AbstractRepository implements ReportesProcAlmJpaRepositoryCustom {

    @Override
    public List<ReportesProcAlm> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<ReportesProcAlm> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<ReportesProcAlm> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<ReportesProcAlm> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, ReportesProcAlm.class);
    }
    
    public List<ReportesProcAlm> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<ReportesProcAlm> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Long assocOperator000() throws SystemException {
        try {
            // COUNT (Funcionarios) WHERE (Funcionarios = agent)
            return assocOperator000Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: ReportesProcAlm, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Long assocOperator000Range1 () throws SystemException {
        SQLCount sql = assocOperator000Range1Query(null);
        return Long.valueOf(new TypedQueryBuilder<ReportesProcAlm>(em, ReportesProcAlm.class).build(sql).execute().size());
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLCount assocOperator000Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLCount sql = new SQLCount(superQuery, ReportesProcAlmConstants.CLASS_NAME, ReportesProcAlmConstants.ROLE_NAME_FUNCIONARIOS);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionarios = agent
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(ReportesProcAlmConstants.ROLE_NAME_FUNCIONARIOS, FuncionarioConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, agent.getAgentInstance().getOid(), Constants.AGENTKEYWORD);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: ReportesProcAlm, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }
}
