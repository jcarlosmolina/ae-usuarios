package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.DominioConstants;
import com.keralty.usuarios.global.RolConstants;
import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class DominioJpaRepositoryImpl extends AbstractRepository implements DominioJpaRepositoryCustom {

    @Override
    public List<Dominio> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Dominio> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Dominio> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Dominio> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Dominio.class);
    }
    
    public List<Dominio> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Dominio> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000(Rol voRol) throws SystemException {
        try {
            // EXIST (Roles) WHERE (Roles = voRol)
            return assocOperator000Range1(voRol);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Dominio, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 (Rol voRol) throws SystemException {
        SQLExists sql = assocOperator000Range1Query(voRol, null);
        return !new TypedQueryBuilder<Dominio>(em, Dominio.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (Rol voRol, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, DominioConstants.CLASS_NAME, DominioConstants.ROLE_NAME_ROLES);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Roles = voRol
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(DominioConstants.ROLE_NAME_ROLES, RolConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOROL, RolConstants.CLASS_NAME, RolConstants.CLASS_NAME, voRol.getOid(), DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOROL);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Dominio, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }
}
