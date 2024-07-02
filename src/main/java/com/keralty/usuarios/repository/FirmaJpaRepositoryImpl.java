package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.FirmaConstants;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.sqlutils.SQLExists;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class FirmaJpaRepositoryImpl extends AbstractRepository implements FirmaJpaRepositoryCustom {

    @Override
    public List<Firma> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Firma> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Firma> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Firma> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Firma.class);
    }
    
    public List<Firma> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Firma> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    // AssocOperator: AssocOperator000
    public Boolean assocOperator000() throws SystemException {
        try {
            // EXIST (RespRegional)
            return assocOperator000Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Firma, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 0 for AssocOperator AssocOperator000
    public Boolean assocOperator000Range1 () throws SystemException {
        SQLExists sql = assocOperator000Range1Query(null);
        return !new TypedQueryBuilder<Firma>(em, Firma.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator000
    public SQLExists assocOperator000Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            return new SQLExists(superQuery, FirmaConstants.CLASS_NAME, FirmaConstants.ROLE_NAME_RESPREGIONAL);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Firma, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }
}
