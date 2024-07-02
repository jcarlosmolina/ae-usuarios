package com.keralty.usuarios.repository;

import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.AdminConstants;
import com.keralty.usuarios.global.AfiliacionesConstants;
import com.keralty.usuarios.global.AreaMedicaConstants;
import com.keralty.usuarios.global.AsesorConstants;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.GestorConstants;
import com.keralty.usuarios.global.GrupoAsignacionConstants;
import com.keralty.usuarios.global.LogFuncionarioConstants;
import com.keralty.usuarios.global.MesaDeApoyoConstants;
import com.keralty.usuarios.global.RespRegionalConstants;
import com.keralty.usuarios.global.SuperAdminConstants;
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
import com.keralty.usuarios.sqlutils.SQLJoin;
import com.keralty.usuarios.sqlutils.SQLParam;
import com.keralty.usuarios.sqlutils.SQLPopulation;
import com.keralty.usuarios.sqlutils.SQLSelect;
import com.keralty.usuarios.sqlutils.SQLWhereComparison;
import com.keralty.usuarios.sqlutils.SQLWhereConjunction;
import com.keralty.usuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.usuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.usuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import java.util.List;

public class FuncionarioJpaRepositoryImpl extends AbstractRepository implements FuncionarioJpaRepositoryCustom {

    @Override
    public List<Funcionario> executeQuery(String jpqlQuery) {
        return getQueryBuilder().build(jpqlQuery).execute();
    }
    
    @Override
    public List<Funcionario> executeQuery(String jpqlQuery, List<SQLParam> params) {
        return getQueryBuilder().build(jpqlQuery).setParameters(params).execute();
    }
    
    public Collection<Funcionario> executeQuery(SQLSelect select) {
        return getQueryBuilder().build(select).execute();
    }

    private TypedQueryBuilder<Funcionario> getQueryBuilder() {
        return new TypedQueryBuilder<>(em, Funcionario.class);
    }
    
    public List<Funcionario> solveQuery(SQLSelect select) {
        return solveQuery(select, 0, 0);
    }

    public List<Funcionario> solveQuery(SQLSelect select, int pageSize, int pageNumber) {
        return getQueryBuilder().build(select, pageSize, pageNumber).execute();
    }

    public Admin findChildAdmin(Long oid) {
        return em.find(Admin.class, oid);
    }

    public SuperAdmin findChildSuperAdmin(Long oid) {
        return em.find(SuperAdmin.class, oid);
    }

    public Asesor findChildAsesor(Long oid) {
        return em.find(Asesor.class, oid);
    }

    public AreaMedica findChildAreaMedica(Long oid) {
        return em.find(AreaMedica.class, oid);
    }

    public Afiliaciones findChildAfiliaciones(Long oid) {
        return em.find(Afiliaciones.class, oid);
    }

    public RespRegional findChildRespRegional(Long oid) {
        return em.find(RespRegional.class, oid);
    }

    public Gestor findChildGestor(Long oid) {
        return em.find(Gestor.class, oid);
    }

    public MesaDeApoyo findChildMesaDeApoyo(Long oid) {
        return em.find(MesaDeApoyo.class, oid);
    }

    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhereadmin (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + AdminConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWheresuperadmin (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + SuperAdminConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhereasesor (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + AsesorConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhereareamedica (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + AreaMedicaConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhereafiliaciones (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + AfiliacionesConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWhererespregional (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + RespRegionalConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWheregestor (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + GestorConstants.FLD_FUNCIONARIOID);
    }


    /**
     * Adds facet where
     * @param myAlias Entity/Table alias.
     * @param join Join clause to add the where to.
     * @param childAlias Alias of the child entity.
     */
    public void addFacetWheremesadeapoyo (String myAlias, SQLJoin join, String childAlias) {
        join.getWheres().add(myAlias + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID + " = " + childAlias + "." + MesaDeApoyoConstants.FLD_FUNCIONARIOID);
    }


    // AssocOperator: AssocOperator000
    public Collection<LogFuncionario> assocOperator000(Funcionario instance) throws SystemException {
        try {
            // FOR ALL LogFuncionario DO LogFuncionario.eliminar(LogFuncionario)
        return assocOperator000Range1(instance);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Funcionario, Assoc.Operator: AssocOperator000, Method: assocOperator000");
        }
    }

    // Range 1 for AssocOperator AssocOperator000
    public Collection<LogFuncionario> assocOperator000Range1 (Funcionario instance) throws SystemException {

        SQLSelect sql = assocOperator000Range1Query(instance);
        return new TypedQueryBuilder<LogFuncionario>(em, LogFuncionario.class).build(sql).execute();
    }

    // Range Query 1 for AssocOperator AssocOperator000
    public SQLPopulation assocOperator000Range1Query (Funcionario instance) throws SystemException {
        try {
            return new SQLPopulation(FuncionarioConstants.CLASS_NAME, LogFuncionarioConstants.CLASS_NAME, instance.getOid(), FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO);
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Funcionario, Assoc.Operator: AssocOperator000, Method: assocOperator000Range1Query");
        }
    }

    // AssocOperator: AssocOperator001
    public Boolean assocOperator001(GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion) throws SystemException {
        try {
            // EXIST (GrupoAsignacion) WHERE (GrupoAsignacion = pthisGrupoAsignacion)
            return assocOperator001Range1(grupoAsignacionTADDUSUARIOpthisGrupoAsignacion);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Funcionario, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }

    // Range 0 for AssocOperator AssocOperator001
    public Boolean assocOperator001Range1 (GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion) throws SystemException {
        SQLExists sql = assocOperator001Range1Query(grupoAsignacionTADDUSUARIOpthisGrupoAsignacion, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator001
    public SQLExists assocOperator001Range1Query (GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, FuncionarioConstants.CLASS_NAME, FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // GrupoAsignacion = pthisGrupoAsignacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION, GrupoAsignacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GrupoAsignacionConstants.ARG_NAME_TADDUSUARIO_GRUPOASIGNACIONTADDUSUARIOPTHISGRUPOASIGNACION, GrupoAsignacionConstants.CLASS_NAME, GrupoAsignacionConstants.CLASS_NAME, grupoAsignacionTADDUSUARIOpthisGrupoAsignacion.getOid(), GrupoAsignacionConstants.ARG_NAME_TADDUSUARIO_GRUPOASIGNACIONTADDUSUARIOPTHISGRUPOASIGNACION);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Funcionario, Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }

    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion) throws SystemException {
        try {
            // EXIST (GrupoAsignacion) WHERE (GrupoAsignacion = pthisGrupoAsignacion)
            return assocOperator002Range1(grupoAsignacionTDELUSUARIOpthisGrupoAsignacion);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: Funcionario, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }

    // Range 0 for AssocOperator AssocOperator002
    public Boolean assocOperator002Range1 (GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(grupoAsignacionTDELUSUARIOpthisGrupoAsignacion, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }

    // Range Query 0 for AssocOperator AssocOperator002
    public SQLExists assocOperator002Range1Query (GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion, SQLSelect superQuery) throws SystemException {
        try {
            // The path starts with a role
            SQLExists sql = new SQLExists(superQuery, FuncionarioConstants.CLASS_NAME, FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // GrupoAsignacion = pthisGrupoAsignacion
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION, GrupoAsignacionConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GrupoAsignacionConstants.ARG_NAME_TDELUSUARIO_GRUPOASIGNACIONTDELUSUARIOPTHISGRUPOASIGNACION, GrupoAsignacionConstants.CLASS_NAME, GrupoAsignacionConstants.CLASS_NAME, grupoAsignacionTDELUSUARIOpthisGrupoAsignacion.getOid(), GrupoAsignacionConstants.ARG_NAME_TDELUSUARIO_GRUPOASIGNACIONTDELUSUARIOPTHISGRUPOASIGNACION);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Definition Class: Funcionario, Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }
}
