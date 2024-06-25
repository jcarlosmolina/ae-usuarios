package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FrecuenciaActConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereNegation;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class GlobalServicesJpaRepositoryImpl extends AbstractRepository implements GlobalServicesJpaRepository {

    // AssocOperator: AssocOperator001
    public Collection<Productos> assocOperator001(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        try {
            // FOR ALL Productos WHERE (Productos.Producto = ptpatrNumero) DO Productos.sincronizar(Productos, ptpatrDescripcion, ptpatrCodigoLegal)
            return assocOperator001Range1(tGSINC1PRODUCTOptpatrNumero);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator001, Method: assocOperator001");
        }
    }



    public Collection<Productos> assocOperator001Range1 (Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(tGSINC1PRODUCTOptpatrNumero);
        return new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute();
    }


    public SQLPopulation assocOperator001Range1Query (Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", ProductosConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.Producto = ptpatrNumero
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1PRODUCTOptpatrNumero, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query");
        }
    }
    // AssocOperator: AssocOperator002
    public Boolean assocOperator002(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        try {
            // EXIST (Productos) WHERE (Productos.Producto = ptpatrNumero)
            return assocOperator002Range1(tGSINC1PRODUCTOptpatrNumero);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator002, Method: assocOperator002");
        }
    }



    public Boolean assocOperator002Range1 (Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(tGSINC1PRODUCTOptpatrNumero, null);
        return !new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator002Range1Query (Long tGSINC1PRODUCTOptpatrNumero, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.Producto = ptpatrNumero
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1PRODUCTOptpatrNumero, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query");
        }
    }

    // AssocOperator: AssocOperator003
    public Collection<FrecuenciaAct> assocOperator003() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 2) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "Éxito", AGENTFuncionario.Usuario, AGENTFuncionario.drvNombreCompleto)
            return assocOperator003Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator003, Method: assocOperator003");
        }
    }



    public Collection<FrecuenciaAct> assocOperator003Range1 () throws SystemException {

        SQLSelect sql = assocOperator003Range1Query();
        return new TypedQueryBuilder<FrecuenciaAct>(em, FrecuenciaAct.class).build(sql).execute();
    }


    public SQLPopulation assocOperator003Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FrecuenciaActConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FrecuenciaAct.Parametrica = 2
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.CLASS_NAME + "." + FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator003, Method: assocOperator003Range1Query");
        }
    }
    // AssocOperator: AssocOperator004
    public Collection<FrecuenciaAct> assocOperator004() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 2) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "Exito", "Auto", "")
            return assocOperator003();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator004, Method: assocOperator004");
        }
    }

    // AssocOperator: AssocOperator039
    public Collection<Regional> assocOperator039(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        try {
            // FOR ALL Regional WHERE (Regional.Codigo = ptpatrCodigo) DO TGSINC1SUCURSALAUX(Regional, ptpatrCodigoSucursal, ptpatrDescripcion)
            return assocOperator039Range1(tGSINC1SUCURSALptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator039, Method: assocOperator039");
        }
    }



    public Collection<Regional> assocOperator039Range1 (Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator039Range1Query(tGSINC1SUCURSALptpatrCodigo);
        return new TypedQueryBuilder<Regional>(em, Regional.class).build(sql).execute();
    }


    public SQLPopulation assocOperator039Range1Query (Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", RegionalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Regional.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(RegionalConstants.CLASS_NAME + "." + RegionalConstants.ATTR_NAME_REGIONALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1SUCURSALptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator039, Method: assocOperator039Range1Query");
        }
    }
    // AssocOperator: AssocOperator040
    public Boolean assocOperator040(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        try {
            // EXIST (Regional) WHERE (Regional.Codigo = ptpatrCodigo)
            return assocOperator040Range1(tGSINC1SUCURSALptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator040, Method: assocOperator040");
        }
    }



    public Boolean assocOperator040Range1 (Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator040Range1Query(tGSINC1SUCURSALptpatrCodigo, null);
        return !new TypedQueryBuilder<Regional>(em, Regional.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator040Range1Query (Long tGSINC1SUCURSALptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", RegionalConstants.CLASS_NAME, RegionalConstants.CLASS_NAME, null, RegionalConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", RegionalConstants.CLASS_NAME, RegionalConstants.CLASS_NAME, null, RegionalConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Regional.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(RegionalConstants.CLASS_NAME + "." + RegionalConstants.ATTR_NAME_REGIONALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1SUCURSALptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator040, Method: assocOperator040Range1Query");
        }
    }

    // AssocOperator: AssocOperator042
    public Collection<Sucursal> assocOperator042(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        try {
            // FOR ALL Sucursal WHERE (Sucursal.Codigo = ptpatrCodigo) DO Sucursal.TSINCRONIZAR(Sucursal, ptpatrDescripcion, ptpagrRegional)
            return assocOperator042Range1(tGSINC1SUCURSALAUXptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator042, Method: assocOperator042");
        }
    }



    public Collection<Sucursal> assocOperator042Range1 (Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator042Range1Query(tGSINC1SUCURSALAUXptpatrCodigo);
        return new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute();
    }


    public SQLPopulation assocOperator042Range1Query (Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SucursalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1SUCURSALAUXptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator042, Method: assocOperator042Range1Query");
        }
    }
    // AssocOperator: AssocOperator043
    public Boolean assocOperator043(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        try {
            // EXIST (Sucursal) WHERE (Sucursal.Codigo = ptpatrCodigo)
            return assocOperator043Range1(tGSINC1SUCURSALAUXptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator043, Method: assocOperator043");
        }
    }



    public Boolean assocOperator043Range1 (Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator043Range1Query(tGSINC1SUCURSALAUXptpatrCodigo, null);
        return !new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator043Range1Query (Long tGSINC1SUCURSALAUXptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", SucursalConstants.CLASS_NAME, SucursalConstants.CLASS_NAME, null, SucursalConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", SucursalConstants.CLASS_NAME, SucursalConstants.CLASS_NAME, null, SucursalConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1SUCURSALAUXptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator043, Method: assocOperator043Range1Query");
        }
    }

    // AssocOperator: AssocOperator044
    public Collection<FrecuenciaAct> assocOperator044() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 16) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "Éxito", AGENTFuncionario.Usuario, AGENTFuncionario.drvNombreCompleto)
            return assocOperator044Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator044, Method: assocOperator044");
        }
    }



    public Collection<FrecuenciaAct> assocOperator044Range1 () throws SystemException {

        SQLSelect sql = assocOperator044Range1Query();
        return new TypedQueryBuilder<FrecuenciaAct>(em, FrecuenciaAct.class).build(sql).execute();
    }


    public SQLPopulation assocOperator044Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FrecuenciaActConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FrecuenciaAct.Parametrica = 16
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.CLASS_NAME + "." + FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(16), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator044, Method: assocOperator044Range1Query");
        }
    }
    // AssocOperator: AssocOperator045
    public Collection<FrecuenciaAct> assocOperator045() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 16) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "Exito", "Auto", "")
            return assocOperator044();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator045, Method: assocOperator045");
        }
    }

    // AssocOperator: AssocOperator063
    public Collection<Sucursal> assocOperator063(Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException {
        try {
            // FOR ALL Sucursal WHERE (Sucursal.Codigo = ptpatrCodigoSucursal) DO TGSINC1ASESORAUX(Sucursal, ptpatrUsuario, ptpatrPrimerNombre, ptpatrSegundoNombre, ptpatrPrimerApellido, ptpatrSegundoApellido, ptpatrEmail, pCodDirector, fugetTipoIdentificacion(pTipoIdentificacion), pNumIdentificacion, ptpCanal, ptpCargo, ptpEstado)
            return assocOperator063Range1(tGSINC1ASESORptpatrCodigoSucursal);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator063, Method: assocOperator063");
        }
    }



    public Collection<Sucursal> assocOperator063Range1 (Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException {

        SQLSelect sql = assocOperator063Range1Query(tGSINC1ASESORptpatrCodigoSucursal);
        return new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute();
    }


    public SQLPopulation assocOperator063Range1Query (Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SucursalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = ptpatrCodigoSucursal
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1ASESORptpatrCodigoSucursal, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator063, Method: assocOperator063Range1Query");
        }
    }

    // AssocOperator: AssocOperator065
    public Collection<Asesor> assocOperator065(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.Usuario = ptpatrUsuario AND Asesor.Manual = false) DO Asesor.TSINCRONIZAR(Asesor, ptpatrPrimerNombre, ptpatrSegundoNombre, ptpatrPrimerApellido, ptpatrSegundoApellido, ptpagrSucursal, pCodDirector, pNumIdentificacion, pTipoIdentificacion, ptpCanal, ptpCargo, ptpEstado)
            return assocOperator065Range1(tGSINC1ASESORAUXptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator065, Method: assocOperator065");
        }
    }



    public Collection<Asesor> assocOperator065Range1 (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator065Range1Query(tGSINC1ASESORAUXptpatrUsuario);
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator065Range1Query (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1ASESORAUXptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Asesor.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator065, Method: assocOperator065Range1Query");
        }
    }
    // AssocOperator: AssocOperator066
    public Collection<Asesor> assocOperator066(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.Usuario = ptpatrUsuario AND Asesor.Manual = true) DO Asesor.modAsesorAgencia(Asesor, ptpatrUsuario, pCodDirector)
            return assocOperator066Range1(tGSINC1ASESORAUXptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator066, Method: assocOperator066");
        }
    }



    public Collection<Asesor> assocOperator066Range1 (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator066Range1Query(tGSINC1ASESORAUXptpatrUsuario);
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator066Range1Query (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1ASESORAUXptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Asesor.Manual = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator066, Method: assocOperator066Range1Query");
        }
    }
    // AssocOperator: AssocOperator067
    public Boolean assocOperator067(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.Usuario = ptpatrUsuario)
            return assocOperator067Range1(tGSINC1ASESORAUXptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator067, Method: assocOperator067");
        }
    }



    public Boolean assocOperator067Range1 (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        SQLExists sql = assocOperator067Range1Query(tGSINC1ASESORAUXptpatrUsuario, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator067Range1Query (String tGSINC1ASESORAUXptpatrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1ASESORAUXptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator067, Method: assocOperator067Range1Query");
        }
    }

    // AssocOperator: AssocOperator068
    public Collection<FrecuenciaAct> assocOperator068() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 4) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "X-DE-TOTAL", AGENTFuncionario.Usuario, AGENTFuncionario.drvNombreCompleto)
            return assocOperator068Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator068, Method: assocOperator068");
        }
    }



    public Collection<FrecuenciaAct> assocOperator068Range1 () throws SystemException {

        SQLSelect sql = assocOperator068Range1Query();
        return new TypedQueryBuilder<FrecuenciaAct>(em, FrecuenciaAct.class).build(sql).execute();
    }


    public SQLPopulation assocOperator068Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FrecuenciaActConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FrecuenciaAct.Parametrica = 4
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.CLASS_NAME + "." + FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator068, Method: assocOperator068Range1Query");
        }
    }
    // AssocOperator: AssocOperator069
    public Collection<FrecuenciaAct> assocOperator069() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 4) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "X-DE-TOTAL", "Auto", "")
            return assocOperator068();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator069, Method: assocOperator069");
        }
    }

    // AssocOperator: AssocOperator096
    public Collection<TipoIdentificacion> assocOperator096(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        try {
            // FOR ALL TipoIdentificacion WHERE (TipoIdentificacion.Codigo = ptpatrCodigo) DO TipoIdentificacion.sincronizar(TipoIdentificacion, ptpatrDescripcion, ptpatrNombreCorto)
            return assocOperator096Range1(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator096, Method: assocOperator096");
        }
    }



    public Collection<TipoIdentificacion> assocOperator096Range1 (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator096Range1Query(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
        return new TypedQueryBuilder<TipoIdentificacion>(em, TipoIdentificacion.class).build(sql).execute();
    }


    public SQLPopulation assocOperator096Range1Query (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", TipoIdentificacionConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TipoIdentificacion.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.CLASS_NAME + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1TIPOIDENTIFICACIONptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator096, Method: assocOperator096Range1Query");
        }
    }
    // AssocOperator: AssocOperator097
    public Boolean assocOperator097(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        try {
            // EXIST (TipoIdentificacion) WHERE (TipoIdentificacion.Codigo = ptpatrCodigo)
            return assocOperator097Range1(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator097, Method: assocOperator097");
        }
    }



    public Boolean assocOperator097Range1 (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator097Range1Query(tGSINC1TIPOIDENTIFICACIONptpatrCodigo, null);
        return !new TypedQueryBuilder<TipoIdentificacion>(em, TipoIdentificacion.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator097Range1Query (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, null, TipoIdentificacionConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, null, TipoIdentificacionConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TipoIdentificacion.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.CLASS_NAME + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1TIPOIDENTIFICACIONptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator097, Method: assocOperator097Range1Query");
        }
    }

    // AssocOperator: AssocOperator098
    public Collection<FrecuenciaAct> assocOperator098() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 19) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "Éxito", AGENTFuncionario.Usuario, AGENTFuncionario.drvNombreCompleto)
            return assocOperator098Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator098, Method: assocOperator098");
        }
    }



    public Collection<FrecuenciaAct> assocOperator098Range1 () throws SystemException {

        SQLSelect sql = assocOperator098Range1Query();
        return new TypedQueryBuilder<FrecuenciaAct>(em, FrecuenciaAct.class).build(sql).execute();
    }


    public SQLPopulation assocOperator098Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FrecuenciaActConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FrecuenciaAct.Parametrica = 19
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.CLASS_NAME + "." + FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(19), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator098, Method: assocOperator098Range1Query");
        }
    }
    // AssocOperator: AssocOperator099
    public Collection<FrecuenciaAct> assocOperator099() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 19) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "Exito", "Auto", "")
            return assocOperator098();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator099, Method: assocOperator099");
        }
    }

    // AssocOperator: AssocOperator139
    public Collection<Sucursal> assocOperator139() throws SystemException {
        try {
            // FOR ALL Sucursal WHERE (Sucursal.Codigo = 0) DO Funcionario.TCREAR(fugetRol(ptpagrRol), ptpatrUsuario, pPrimerNombre, pSegundoNombre, pPrimerApellido, pSegundoApellido, "Q", Sucursal, ptpatrUsuario, pEmail, NULL)
            return assocOperator139Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator139, Method: assocOperator139");
        }
    }



    public Collection<Sucursal> assocOperator139Range1 () throws SystemException {

        SQLSelect sql = assocOperator139Range1Query();
        return new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute();
    }


    public SQLPopulation assocOperator139Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SucursalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = 0
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator139, Method: assocOperator139Range1Query");
        }
    }
    // AssocOperator: AssocOperator140
    public Collection<Funcionario> assocOperator140(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Funcionario WHERE (Funcionario.UsuarioLDAP = ptpatrUsuario) DO Funcionario.TMODIFICARYROL(Funcionario, pPrimerNombre, pSegundoNombre, pPrimerApellido, pSegundoApellido, fugetRol(ptpagrRol), ptpatrUsuario, pEmail, NULL)
            return assocOperator140Range1(tGVERIFICARUSUARIOptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator140, Method: assocOperator140");
        }
    }



    public Collection<Funcionario> assocOperator140Range1 (String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator140Range1Query(tGVERIFICARUSUARIOptpatrUsuario);
        return new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute();
    }


    public SQLPopulation assocOperator140Range1Query (String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGVERIFICARUSUARIOptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator140, Method: assocOperator140Range1Query");
        }
    }
    // AssocOperator: AssocOperator141
    public Boolean assocOperator141(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.UsuarioLDAP = ptpatrUsuario)
            return assocOperator141Range1(tGVERIFICARUSUARIOptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator141, Method: assocOperator141");
        }
    }



    public Boolean assocOperator141Range1 (String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        SQLExists sql = assocOperator141Range1Query(tGVERIFICARUSUARIOptpatrUsuario, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator141Range1Query (String tGVERIFICARUSUARIOptpatrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGVERIFICARUSUARIOptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator141, Method: assocOperator141Range1Query");
        }
    }

    // AssocOperator: AssocOperator144
    public Collection<FrecuenciaAct> assocOperator144() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 28) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "X-DE-TOTAL", AGENTFuncionario.Usuario, AGENTFuncionario.drvNombreCompleto)
            return assocOperator144Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator144, Method: assocOperator144");
        }
    }



    public Collection<FrecuenciaAct> assocOperator144Range1 () throws SystemException {

        SQLSelect sql = assocOperator144Range1Query();
        return new TypedQueryBuilder<FrecuenciaAct>(em, FrecuenciaAct.class).build(sql).execute();
    }


    public SQLPopulation assocOperator144Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FrecuenciaActConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FrecuenciaAct.Parametrica = 28
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.CLASS_NAME + "." + FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Long.valueOf(28), Constants.Type.NAT.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator144, Method: assocOperator144Range1Query");
        }
    }
    // AssocOperator: AssocOperator145
    public Collection<FrecuenciaAct> assocOperator145() throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = 28) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), "X-DE-TOTAL", "Auto", "")
            return assocOperator144();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator145, Method: assocOperator145");
        }
    }

    // AssocOperator: AssocOperator147
    public Collection<Productos> assocOperator147(String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        try {
            // FOR ALL Productos WHERE (Productos.CodigoLegal = pProducto) DO TGSINC1AGENTEXPRODAUX(Productos, fugetAsesor(ptpAsesor), pCodigo, ptpatrFechaInicio, ptpatrFechaFin)
            return assocOperator147Range1(tGSINC1AGENTEXPRODpProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator147, Method: assocOperator147");
        }
    }



    public Collection<Productos> assocOperator147Range1 (String tGSINC1AGENTEXPRODpProducto) throws SystemException {

        SQLSelect sql = assocOperator147Range1Query(tGSINC1AGENTEXPRODpProducto);
        return new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute();
    }


    public SQLPopulation assocOperator147Range1Query (String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", ProductosConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.CodigoLegal = pProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODpProducto, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator147, Method: assocOperator147Range1Query");
        }
    }
    // AssocOperator: AssocOperator148
    public Boolean assocOperator148(String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        try {
            // EXIST (Productos) WHERE (Productos.CodigoLegal = pProducto)
            return assocOperator148Range1(tGSINC1AGENTEXPRODpProducto);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator148, Method: assocOperator148");
        }
    }



    public Boolean assocOperator148Range1 (String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        SQLExists sql = assocOperator148Range1Query(tGSINC1AGENTEXPRODpProducto, null);
        return !new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator148Range1Query (String tGSINC1AGENTEXPRODpProducto, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.CodigoLegal = pProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODpProducto, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator148, Method: assocOperator148Range1Query");
        }
    }

    // AssocOperator: AssocOperator150
    public Collection<AgentexProducto> assocOperator150(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        try {
            // FOR ALL AgentexProducto WHERE (AgentexProducto.Asesor = ptpagrAsesor AND AgentexProducto.Codigo = ptpatrCodigo) DO AgentexProducto.TSINCRONIZAR(AgentexProducto, ptpatrFechaInicio, ptpatrFechaFin, ptpagrProducto)
            return assocOperator150Range1(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator150, Method: assocOperator150");
        }
    }



    public Collection<AgentexProducto> assocOperator150Range1 (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator150Range1Query(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }


    public SQLPopulation assocOperator150Range1Query (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AgentexProductoConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = ptpagrAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(AgentexProductoConstants.CLASS_NAME + "." + AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, tGSINC1AGENTEXPRODAUXptpagrAsesor.getOid(), GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AgentexProducto.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.CLASS_NAME + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOCODIGO, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODAUXptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator150, Method: assocOperator150Range1Query");
        }
    }
    // AssocOperator: AssocOperator151
    public Boolean assocOperator151(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        try {
            // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = ptpagrAsesor AND AgentexProducto.Codigo = ptpatrCodigo)
            return assocOperator151Range1(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator151, Method: assocOperator151");
        }
    }



    public Boolean assocOperator151Range1 (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator151Range1Query(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo, null);
        return !new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator151Range1Query (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, null, AgentexProductoConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, null, AgentexProductoConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = ptpagrAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(AgentexProductoConstants.CLASS_NAME + "." + AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, tGSINC1AGENTEXPRODAUXptpagrAsesor.getOid(), GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AgentexProducto.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.CLASS_NAME + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOCODIGO, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODAUXptpatrCodigo, Constants.Type.INT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator151, Method: assocOperator151Range1Query");
        }
    }

    // AssocOperator: AssocOperator166
    public Collection<Asesor> assocOperator166(String tGPOSPROCESS1ASESORpUsuario) throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.Usuario = pUsuario) DO Asesor.TPOSPROCESOSINC(Asesor, pEsDirector)
            return assocOperator166Range1(tGPOSPROCESS1ASESORpUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator166, Method: assocOperator166");
        }
    }



    public Collection<Asesor> assocOperator166Range1 (String tGPOSPROCESS1ASESORpUsuario) throws SystemException {

        SQLSelect sql = assocOperator166Range1Query(tGPOSPROCESS1ASESORpUsuario);
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator166Range1Query (String tGPOSPROCESS1ASESORpUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.Usuario = pUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGPOSPROCESS1ASESORpUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator166, Method: assocOperator166Range1Query");
        }
    }

    // AssocOperator: AssocOperator167
    public Collection<Asesor> assocOperator167() throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.esDirector = false AND EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = true) DO Asesor.TPOSPROCESOSINC(Asesor, true)
            return assocOperator167Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator167, Method: assocOperator167");
        }
    }



    public Collection<Asesor> assocOperator167Range1 () throws SystemException {

        SQLSelect sql = assocOperator167Range1Query();
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator167Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.esDirector = false
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + AsesorConstants.ATTR_NAME_ASESORESDIRECTOR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator168 = new SQLWhereOperandSubQuery(assocOperator168Range1Query(sql));
                conjunction.addOperand(operandSubQueryAssocOperator168);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator167, Method: assocOperator167Range1Query");
        }
    }
    // AssocOperator: AssocOperator168
    public Boolean assocOperator168() throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario)
            return assocOperator168Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator168, Method: assocOperator168");
        }
    }



    public Boolean assocOperator168Range1 () throws SystemException {
        SQLExists sql = assocOperator168Range1Query(null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator168Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            SQLExists sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.CodJefe = Asesor.Usuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator168, Method: assocOperator168Range1Query");
        }
    }
    // AssocOperator: AssocOperator169
    public Collection<Asesor> assocOperator169() throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.esDirector = true AND EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = false) DO Asesor.TPOSPROCESOSINC(Asesor, false)
            return assocOperator169Range1();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator169, Method: assocOperator169");
        }
    }



    public Collection<Asesor> assocOperator169Range1 () throws SystemException {

        SQLSelect sql = assocOperator169Range1Query();
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator169Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.esDirector = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + AsesorConstants.ATTR_NAME_ASESORESDIRECTOR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = false
                {
                    // 'not' Logical operator
                    SQLWhereNegation comparison2 = new SQLWhereNegation(sql);
                
                    // Operand 1
                    // 'exist' Association operator
                    SQLWhereOperandSubQuery operandSubQueryAssocOperator170 = new SQLWhereOperandSubQuery(assocOperator168Range1Query(sql));
                    comparison2.addOperand(operandSubQueryAssocOperator170);
                    
                    conjunction.addOperand(comparison2);
                }

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator169, Method: assocOperator169Range1Query");
        }
    }
    // AssocOperator: AssocOperator170
    public Boolean assocOperator170() throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario)
            return assocOperator168();
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator170, Method: assocOperator170");
        }
    }

    // AssocOperator: AssocOperator171
    public Boolean assocOperator171(String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP)
            return assocOperator171Range1(tCREARAGENTEptpatrUsuarioLDAP);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator171, Method: assocOperator171");
        }
    }



    public Boolean assocOperator171Range1 (String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException {
        SQLExists sql = assocOperator171Range1Query(tCREARAGENTEptpatrUsuarioLDAP, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator171Range1Query (String tCREARAGENTEptpatrUsuarioLDAP, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tCREARAGENTEptpatrUsuarioLDAP!= null){
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tCREARAGENTEptpatrUsuarioLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator171, Method: assocOperator171Range1Query");
        }
    }

    // AssocOperator: AssocOperator172
    public Long assocOperator172(String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP AND Funcionario.Id <> pt_p_thisAgente.Id)
            return assocOperator172Range1(tMODIFICARAGENTEptpatrUsuarioLDAP, tMODIFICARAGENTEptpthisAgente);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator172, Method: assocOperator172");
        }
    }



    public Long assocOperator172Range1 (String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException {
        SQLCount sql = assocOperator172Range1Query(tMODIFICARAGENTEptpatrUsuarioLDAP, tMODIFICARAGENTEptpthisAgente, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator172Range1Query (String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tMODIFICARAGENTEptpatrUsuarioLDAP!= null){
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tMODIFICARAGENTEptpatrUsuarioLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);


            // Funcionario.Id <> pt_p_thisAgente.Id
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOID, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(tMODIFICARAGENTEptpthisAgente.getFuncionarioId(), Constants.Type.INT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator172, Method: assocOperator172Range1Query");
        }
    }

    // AssocOperator: AssocOperator173
    public Collection<Funcionario> assocOperator173(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Funcionario WHERE (Funcionario.Usuario = ptpatrUsuario AND Funcionario.Manual = false) DO Funcionario.modAsesorAgencia(oaFuncionario, ptpatrUsuario, Funcionario.CodJefe)
            return assocOperator173Range1(tGNEWASESORAGENCIAptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator173, Method: assocOperator173");
        }
    }



    public Collection<Funcionario> assocOperator173Range1 (String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator173Range1Query(tGNEWASESORAGENCIAptpatrUsuario);
        return new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute();
    }


    public SQLPopulation assocOperator173Range1Query (String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGNEWASESORAGENCIAptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator173, Method: assocOperator173Range1Query");
        }
    }
    // AssocOperator: AssocOperator174
    public Long assocOperator174(String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP)
            return assocOperator174Range1(tGNEWASESORAGENCIAptpatrUsuarioLDAP);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator174, Method: assocOperator174");
        }
    }



    public Long assocOperator174Range1 (String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException {
        SQLCount sql = assocOperator174Range1Query(tGNEWASESORAGENCIAptpatrUsuarioLDAP, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator174Range1Query (String tGNEWASESORAGENCIAptpatrUsuarioLDAP, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tGNEWASESORAGENCIAptpatrUsuarioLDAP!= null){
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGNEWASESORAGENCIAptpatrUsuarioLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator174, Method: assocOperator174Range1Query");
        }
    }
    // AssocOperator: AssocOperator175
    public Long assocOperator175(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.Usuario = pt_p_atrUsuario AND Funcionario.Manual = false)
            return assocOperator175Range1(tGNEWASESORAGENCIAptpatrUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator175, Method: assocOperator175");
        }
    }



    public Long assocOperator175Range1 (String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        SQLCount sql = assocOperator175Range1Query(tGNEWASESORAGENCIAptpatrUsuario, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator175Range1Query (String tGNEWASESORAGENCIAptpatrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = pt_p_atrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGNEWASESORAGENCIAptpatrUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator175, Method: assocOperator175Range1Query");
        }
    }

    // AssocOperator: AssocOperator176
    public Collection<Funcionario> assocOperator176(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        try {
            // FOR ALL Funcionario WHERE (Funcionario.Usuario = ptpeNumUsuario AND Funcionario.Manual = false) DO Funcionario.modAsesorAgencia(ptpthisAsesor, ptpeNumUsuario, Funcionario.CodJefe)
            return assocOperator176Range1(tGMODASESORAGENCIAptpeNumUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator176, Method: assocOperator176");
        }
    }



    public Collection<Funcionario> assocOperator176Range1 (String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {

        SQLSelect sql = assocOperator176Range1Query(tGMODASESORAGENCIAptpeNumUsuario);
        return new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute();
    }


    public SQLPopulation assocOperator176Range1Query (String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = ptpeNumUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGMODASESORAGENCIAptpeNumUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator176, Method: assocOperator176Range1Query");
        }
    }
    // AssocOperator: AssocOperator177
    public Long assocOperator177(String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_ptUsuarioLDAP AND Funcionario.Id <> pt_p_thisAsesor.Id)
            return assocOperator177Range1(tGMODASESORAGENCIAptptUsuarioLDAP, tGMODASESORAGENCIAptpthisAsesor);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator177, Method: assocOperator177");
        }
    }



    public Long assocOperator177Range1 (String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException {
        SQLCount sql = assocOperator177Range1Query(tGMODASESORAGENCIAptptUsuarioLDAP, tGMODASESORAGENCIAptpthisAsesor, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator177Range1Query (String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_ptUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tGMODASESORAGENCIAptptUsuarioLDAP!= null){
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGMODASESORAGENCIAptptUsuarioLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);


            // Funcionario.Id <> pt_p_thisAsesor.Id
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOID, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(tGMODASESORAGENCIAptpthisAsesor.getFuncionarioId(), Constants.Type.INT.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator177, Method: assocOperator177Range1Query");
        }
    }
    // AssocOperator: AssocOperator178
    public Long assocOperator178(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.Usuario = pt_peNumUsuario AND Funcionario.Manual = false)
            return assocOperator178Range1(tGMODASESORAGENCIAptpeNumUsuario);
        } catch (Exception e) {
            throw new SystemException(e, 
                    "Definition Class: GLOBAL, Assoc.Operator: AssocOperator178, Method: assocOperator178");
        }
    }



    public Long assocOperator178Range1 (String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        SQLCount sql = assocOperator178Range1Query(tGMODASESORAGENCIAptpeNumUsuario, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator178Range1Query (String tGMODASESORAGENCIAptpeNumUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = pt_peNumUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(tGMODASESORAGENCIAptpeNumUsuario, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName());
                    comparison2.setSecondOperand(operand224);
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            throw new SystemException(e, 
                "Assoc.Operator: AssocOperator178, Method: assocOperator178Range1Query");
        }
    }
}
