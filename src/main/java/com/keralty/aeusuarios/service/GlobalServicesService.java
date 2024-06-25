package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.PreconditionException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.repository.GlobalServicesJpaRepository;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.sql.Timestamp;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class GlobalServicesService extends AbstractService {

    @Inject
    GlobalServicesService globalServicesSrv;

    @Inject
    UserFunctions userFunctionsSrv;

    @Inject
    AsesorService asesorSrv;

    @Inject
    FrecuenciaActService frecuenciaActSrv;

    @Inject
    ProductosService productosSrv;

    @Inject
    AgentexProductoService agentexProductoSrv;

    @Inject
    RegionalService regionalSrv;

    @Inject
    SucursalService sucursalSrv;

    @Inject
    TipoIdentificacionService tipoIdentificacionSrv;

    @Inject
    FuncionarioService funcionarioSrv;

    @Inject
    RolService rolSrv;

    @Inject
    GlobalServicesJpaRepository globalServicesRepository;

    /*
     * Implements global service TGSINC1PRODUCTO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1PRODUCTOImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1PRODUCTORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long tGSINC1PRODUCTOptpatrNumero = request.getTGSINC1PRODUCTOptpatrNumero();
        String tGSINC1PRODUCTOptpatrDescripcion = request.getTGSINC1PRODUCTOptpatrDescripcion();
        String tGSINC1PRODUCTOptpatrCodigoLegal = request.getTGSINC1PRODUCTOptpatrCodigoLegal();

        request.checkArguments();

        /* Action 1: IF (EXIST (Productos) WHERE (Productos.Producto = ptpatrNumero) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator002(tGSINC1PRODUCTOptpatrNumero).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.productos.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.productos.siu.CrearRequest();
            step10Request.setProductoscrearpatrProducto(tGSINC1PRODUCTOptpatrNumero);
            step10Request.setProductoscrearpatrDescripcion(tGSINC1PRODUCTOptpatrDescripcion);
            step10Request.setProductoscrearpatrCodAnexoMat(null);
            step10Request.setProductoscrearpatrCodAnexoNeo(null);
            step10Request.setProductoscrearpatrNIT(null);
            step10Request.setProductoscrearpatrCodigoLegal(tGSINC1PRODUCTOptpatrCodigoLegal);
            productosSrv.crearImplementation(step10Request);
        } else {
            for(Productos step111Entity : globalServicesRepository.assocOperator001(tGSINC1PRODUCTOptpatrNumero)) {
                com.keralty.aeusuarios.viewmodel.productos.siu.SincronizarRequest step11Request = new com.keralty.aeusuarios.viewmodel.productos.siu.SincronizarRequest();
                step11Request.setProductossincronizarpthisProductoInstance(step111Entity);
                step11Request.setProductossincronizarpDescripcion(tGSINC1PRODUCTOptpatrDescripcion);
                step11Request.setProductossincronizarpCodigoLegal(tGSINC1PRODUCTOptpatrCodigoLegal);
                productosSrv.sincronizarImplementation(step11Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service TGSINCPRODUCTOS
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSINCPRODUCTOS(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCPRODUCTOSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSINCPRODUCTOSTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSINCPRODUCTOS
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSINCPRODUCTOSTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCPRODUCTOSRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSINCPRODUCTOSImplementation(request);
    }

    /*
     * Implements global service TGSINCPRODUCTOS
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINCPRODUCTOSImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCPRODUCTOSRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1PRODUCTORequest step1Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1PRODUCTORequest();
        step1Request.setTGSINC1PRODUCTOptpatrNumero(Long.valueOf(0));
        step1Request.setTGSINC1PRODUCTOptpatrDescripcion("0");
        step1Request.setTGSINC1PRODUCTOptpatrCodigoLegal("0");
        globalServicesSrv.tGSINC1PRODUCTOImplementation(step1Request);

        /* Action 2: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition2 = ((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null;
        if (ifCondition2) {
            for(FrecuenciaAct step220Entity : globalServicesRepository.assocOperator003()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step20Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step20Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step220Entity);
                step20Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step20Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("Éxito");
                step20Request.setFrecuenciaActfijarSincronizacionpUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
                step20Request.setFrecuenciaActfijarSincronizacionpNombreUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionariodrvNombreCompleto());
                frecuenciaActSrv.fijarSincronizacionImplementation(step20Request);
            }
        } else {
            for(FrecuenciaAct step221Entity : globalServicesRepository.assocOperator004()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step21Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step21Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step221Entity);
                step21Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step21Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("Exito");
                step21Request.setFrecuenciaActfijarSincronizacionpUsuario("Auto");
                step21Request.setFrecuenciaActfijarSincronizacionpNombreUsuario("");
                frecuenciaActSrv.fijarSincronizacionImplementation(step21Request);
            }
        }
        return response;
    }

    /*
     * Implements global service TGSINC1SUCURSAL
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1SUCURSALImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1SUCURSALRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long tGSINC1SUCURSALptpatrCodigo = request.getTGSINC1SUCURSALptpatrCodigo();
        String tGSINC1SUCURSALptpatrDescripcion = request.getTGSINC1SUCURSALptpatrDescripcion();
        Long tGSINC1SUCURSALptpatrCodigoSucursal = request.getTGSINC1SUCURSALptpatrCodigoSucursal();

        request.checkArguments();

        /* Action 1: IF (EXIST (Regional) WHERE (Regional.Codigo = ptpatrCodigo) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator040(tGSINC1SUCURSALptpatrCodigo).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.regional.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.regional.siu.CrearRequest();
            step10Request.setRegionalcrearpagrRespRegionalInstance(null);
            step10Request.setRegionalcrearpatrCodigo(tGSINC1SUCURSALptpatrCodigo);
            step10Request.setRegionalcrearpatrDescripcion("Pendiente de sincronización");
            regionalSrv.crearImplementation(step10Request);
        }

        for(Regional step2Entity : globalServicesRepository.assocOperator039(tGSINC1SUCURSALptpatrCodigo)) {
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1SUCURSALAUXRequest step2Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1SUCURSALAUXRequest();
            step2Request.setTGSINC1SUCURSALAUXptpagrRegionalInstance(step2Entity);
            step2Request.setTGSINC1SUCURSALAUXptpatrCodigo(tGSINC1SUCURSALptpatrCodigoSucursal);
            step2Request.setTGSINC1SUCURSALAUXptpatrDescripcion(tGSINC1SUCURSALptpatrDescripcion);
            globalServicesSrv.tGSINC1SUCURSALAUXImplementation(step2Request);
        }
        return response;
    }

    /*
     * Implements global service TGSINC1SUCURSALAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1SUCURSALAUXImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1SUCURSALAUXRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Regional tGSINC1SUCURSALAUXptpagrRegional = request.getTGSINC1SUCURSALAUXptpagrRegionalInstance();
        Long tGSINC1SUCURSALAUXptpatrCodigo = request.getTGSINC1SUCURSALAUXptpatrCodigo();
        String tGSINC1SUCURSALAUXptpatrDescripcion = request.getTGSINC1SUCURSALAUXptpatrDescripcion();

        request.checkArguments();

        /* Action 1: IF (EXIST (Sucursal) WHERE (Sucursal.Codigo = ptpatrCodigo) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator043(tGSINC1SUCURSALAUXptpatrCodigo).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.sucursal.siu.CrearRequest();
            step10Request.setSucursalcrearpagrRegionalInstance(tGSINC1SUCURSALAUXptpagrRegional);
            step10Request.setSucursalcrearpatrCodigo(tGSINC1SUCURSALAUXptpatrCodigo);
            step10Request.setSucursalcrearpatrDescripcion(tGSINC1SUCURSALAUXptpatrDescripcion);
            sucursalSrv.crearImplementation(step10Request);
        } else {
            for(Sucursal step111Entity : globalServicesRepository.assocOperator042(tGSINC1SUCURSALAUXptpatrCodigo)) {
                com.keralty.aeusuarios.viewmodel.sucursal.siu.TSINCRONIZARRequest step11Request = new com.keralty.aeusuarios.viewmodel.sucursal.siu.TSINCRONIZARRequest();
                step11Request.setSucursalTSINCRONIZARpthisSucursalInstance(step111Entity);
                step11Request.setSucursalTSINCRONIZARptpDescripcion(tGSINC1SUCURSALAUXptpatrDescripcion);
                step11Request.setSucursalTSINCRONIZARptpevcRegionalInstance(tGSINC1SUCURSALAUXptpagrRegional);
                sucursalSrv.tSINCRONIZARImplementation(step11Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service TGSINCSUCURSALES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSINCSUCURSALES(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCSUCURSALESRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSINCSUCURSALESTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSINCSUCURSALES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSINCSUCURSALESTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCSUCURSALESRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSINCSUCURSALESImplementation(request);
    }

    /*
     * Implements global service TGSINCSUCURSALES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINCSUCURSALESImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCSUCURSALESRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1SUCURSALRequest step1Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1SUCURSALRequest();
        step1Request.setTGSINC1SUCURSALptpatrCodigo(Long.valueOf(0));
        step1Request.setTGSINC1SUCURSALptpatrDescripcion("0");
        step1Request.setTGSINC1SUCURSALptpatrCodigoSucursal(Long.valueOf(0));
        globalServicesSrv.tGSINC1SUCURSALImplementation(step1Request);

        /* Action 2: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition2 = ((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null;
        if (ifCondition2) {
            for(FrecuenciaAct step220Entity : globalServicesRepository.assocOperator044()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step20Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step20Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step220Entity);
                step20Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step20Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("Éxito");
                step20Request.setFrecuenciaActfijarSincronizacionpUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
                step20Request.setFrecuenciaActfijarSincronizacionpNombreUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionariodrvNombreCompleto());
                frecuenciaActSrv.fijarSincronizacionImplementation(step20Request);
            }
        } else {
            for(FrecuenciaAct step221Entity : globalServicesRepository.assocOperator045()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step21Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step21Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step221Entity);
                step21Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step21Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("Exito");
                step21Request.setFrecuenciaActfijarSincronizacionpUsuario("Auto");
                step21Request.setFrecuenciaActfijarSincronizacionpNombreUsuario("");
                frecuenciaActSrv.fijarSincronizacionImplementation(step21Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service TGSINC1ASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSINC1ASESOR(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSINC1ASESORTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSINC1ASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSINC1ASESORTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSINC1ASESORImplementation(request);
    }

    /*
     * Implements global service TGSINC1ASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1ASESORImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String tGSINC1ASESORptpatrUsuario = request.getTGSINC1ASESORptpatrUsuario();
        String tGSINC1ASESORptpatrPrimerNombre = request.getTGSINC1ASESORptpatrPrimerNombre();
        String tGSINC1ASESORptpatrSegundoNombre = request.getTGSINC1ASESORptpatrSegundoNombre();
        String tGSINC1ASESORptpatrPrimerApellido = request.getTGSINC1ASESORptpatrPrimerApellido();
        String tGSINC1ASESORptpatrSegundoApellido = request.getTGSINC1ASESORptpatrSegundoApellido();
        String tGSINC1ASESORptpatrEmail = request.getTGSINC1ASESORptpatrEmail();
        Long tGSINC1ASESORptpatrCodigoSucursal = request.getTGSINC1ASESORptpatrCodigoSucursal();
        String tGSINC1ASESORpCodDirector = request.getTGSINC1ASESORpCodDirector();
        String tGSINC1ASESORpTipoIdentificacion = request.getTGSINC1ASESORpTipoIdentificacion();
        String tGSINC1ASESORpNumIdentificacion = request.getTGSINC1ASESORpNumIdentificacion();
        String tGSINC1ASESORptpCanal = request.getTGSINC1ASESORptpCanal();
        String tGSINC1ASESORptpCargo = request.getTGSINC1ASESORptpCargo();
        String tGSINC1ASESORptpEstado = request.getTGSINC1ASESORptpEstado();

        request.checkArguments();

        for(Sucursal step1Entity : globalServicesRepository.assocOperator063(tGSINC1ASESORptpatrCodigoSucursal)) {
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORAUXRequest step1Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORAUXRequest();
            step1Request.setTGSINC1ASESORAUXptpagrSucursalInstance(step1Entity);
            step1Request.setTGSINC1ASESORAUXptpatrUsuario(tGSINC1ASESORptpatrUsuario);
            step1Request.setTGSINC1ASESORAUXptpatrPrimerNombre(tGSINC1ASESORptpatrPrimerNombre);
            step1Request.setTGSINC1ASESORAUXptpatrSegundoNombre(tGSINC1ASESORptpatrSegundoNombre);
            step1Request.setTGSINC1ASESORAUXptpatrPrimerApellido(tGSINC1ASESORptpatrPrimerApellido);
            step1Request.setTGSINC1ASESORAUXptpatrSegundoApellido(tGSINC1ASESORptpatrSegundoApellido);
            step1Request.setTGSINC1ASESORAUXptpatrEmail(tGSINC1ASESORptpatrEmail);
            step1Request.setTGSINC1ASESORAUXpCodDirector(tGSINC1ASESORpCodDirector);
            step1Request.setTGSINC1ASESORAUXpTipoIdentificacionInstance(userFunctionsSrv.fugetTipoIdentificacionFun(tGSINC1ASESORpTipoIdentificacion));
            step1Request.setTGSINC1ASESORAUXpNumIdentificacion(tGSINC1ASESORpNumIdentificacion);
            step1Request.setTGSINC1ASESORAUXptpCanal(tGSINC1ASESORptpCanal);
            step1Request.setTGSINC1ASESORAUXptpCargo(tGSINC1ASESORptpCargo);
            step1Request.setTGSINC1ASESORAUXptpEstado(tGSINC1ASESORptpEstado);
            globalServicesSrv.tGSINC1ASESORAUXImplementation(step1Request);
        }
        return response;
    }

    /*
     * Implements global service TGSINC1ASESORAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1ASESORAUXImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORAUXRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Sucursal tGSINC1ASESORAUXptpagrSucursal = request.getTGSINC1ASESORAUXptpagrSucursalInstance();
        String tGSINC1ASESORAUXptpatrUsuario = request.getTGSINC1ASESORAUXptpatrUsuario();
        String tGSINC1ASESORAUXptpatrPrimerNombre = request.getTGSINC1ASESORAUXptpatrPrimerNombre();
        String tGSINC1ASESORAUXptpatrSegundoNombre = request.getTGSINC1ASESORAUXptpatrSegundoNombre();
        String tGSINC1ASESORAUXptpatrPrimerApellido = request.getTGSINC1ASESORAUXptpatrPrimerApellido();
        String tGSINC1ASESORAUXptpatrSegundoApellido = request.getTGSINC1ASESORAUXptpatrSegundoApellido();
        String tGSINC1ASESORAUXptpatrEmail = request.getTGSINC1ASESORAUXptpatrEmail();
        String tGSINC1ASESORAUXpCodDirector = request.getTGSINC1ASESORAUXpCodDirector();
        TipoIdentificacion tGSINC1ASESORAUXpTipoIdentificacion = request.getTGSINC1ASESORAUXpTipoIdentificacionInstance();
        String tGSINC1ASESORAUXpNumIdentificacion = request.getTGSINC1ASESORAUXpNumIdentificacion();
        String tGSINC1ASESORAUXptpCanal = request.getTGSINC1ASESORAUXptpCanal();
        String tGSINC1ASESORAUXptpCargo = request.getTGSINC1ASESORAUXptpCargo();
        String tGSINC1ASESORAUXptpEstado = request.getTGSINC1ASESORAUXptpEstado();

        request.checkArguments();

        /* Action 1: IF (EXIST (Funcionario) WHERE (Funcionario.Usuario = ptpatrUsuario) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator067(tGSINC1ASESORAUXptpatrUsuario).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARASESORRequest step10Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARASESORRequest();
            step10Request.setFuncionarioTCREARASESORptpagrSucursalInstance(tGSINC1ASESORAUXptpagrSucursal);
            step10Request.setFuncionarioTCREARASESORptpatrUsuario(tGSINC1ASESORAUXptpatrUsuario);
            step10Request.setFuncionarioTCREARASESORptpatrPrimerNombre(tGSINC1ASESORAUXptpatrPrimerNombre);
            step10Request.setFuncionarioTCREARASESORptpatrSegundoNombre(tGSINC1ASESORAUXptpatrSegundoNombre);
            step10Request.setFuncionarioTCREARASESORptpatrPrimerApellido(tGSINC1ASESORAUXptpatrPrimerApellido);
            step10Request.setFuncionarioTCREARASESORptpatrSegundoApellido(tGSINC1ASESORAUXptpatrSegundoApellido);
            step10Request.setFuncionarioTCREARASESORptpatrEmail(tGSINC1ASESORAUXptpatrEmail);
            step10Request.setFuncionarioTCREARASESORptpagrTipoIdentificacionInstance(tGSINC1ASESORAUXpTipoIdentificacion);
            step10Request.setFuncionarioTCREARASESORptpatrNumIdentificacion(tGSINC1ASESORAUXpNumIdentificacion);
            step10Request.setFuncionarioTCREARASESORptpCodJefe(tGSINC1ASESORAUXpCodDirector);
            step10Request.setFuncionarioTCREARASESORptCanal(tGSINC1ASESORAUXptpCanal);
            step10Request.setFuncionarioTCREARASESORptCargo(tGSINC1ASESORAUXptpCargo);
            step10Request.setFuncionarioTCREARASESORptEstado(tGSINC1ASESORAUXptpEstado);
            funcionarioSrv.tCREARASESORImplementation(step10Request);
        } else {
            for(Asesor step1111Entity : globalServicesRepository.assocOperator065(tGSINC1ASESORAUXptpatrUsuario)) {
                com.keralty.aeusuarios.viewmodel.asesor.siu.TSINCRONIZARRequest step11Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TSINCRONIZARRequest();
                step11Request.setAsesorTSINCRONIZARpthisAsesorInstance(step1111Entity);
                step11Request.setAsesorTSINCRONIZARptpPrimerNombre(tGSINC1ASESORAUXptpatrPrimerNombre);
                step11Request.setAsesorTSINCRONIZARptpSegundoNombre(tGSINC1ASESORAUXptpatrSegundoNombre);
                step11Request.setAsesorTSINCRONIZARptpPrimerApellido(tGSINC1ASESORAUXptpatrPrimerApellido);
                step11Request.setAsesorTSINCRONIZARptpSegundoApellido(tGSINC1ASESORAUXptpatrSegundoApellido);
                step11Request.setAsesorTSINCRONIZARptpevcSucursalInstance(tGSINC1ASESORAUXptpagrSucursal);
                step11Request.setAsesorTSINCRONIZARpCodDirector(tGSINC1ASESORAUXpCodDirector);
                step11Request.setAsesorTSINCRONIZARpNumIdentificacion(tGSINC1ASESORAUXpNumIdentificacion);
                step11Request.setAsesorTSINCRONIZARpTipoIdentificacionInstance(tGSINC1ASESORAUXpTipoIdentificacion);
                step11Request.setAsesorTSINCRONIZARptpCanal(tGSINC1ASESORAUXptpCanal);
                step11Request.setAsesorTSINCRONIZARptpCargo(tGSINC1ASESORAUXptpCargo);
                step11Request.setAsesorTSINCRONIZARptpEstado(tGSINC1ASESORAUXptpEstado);
                asesorSrv.tSINCRONIZARImplementation(step11Request);
            }
            for(Asesor step1112Entity : globalServicesRepository.assocOperator066(tGSINC1ASESORAUXptpatrUsuario)) {
                com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest step12Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest();
                step12Request.setFuncionariomodAsesorAgenciapthisFuncionarioInstance(step1112Entity.getFuncionarioFacet());
                step12Request.setFuncionariomodAsesorAgenciapeNumUsuario(tGSINC1ASESORAUXptpatrUsuario);
                step12Request.setFuncionariomodAsesorAgenciapeCodJefe(tGSINC1ASESORAUXpCodDirector);
                funcionarioSrv.modAsesorAgenciaImplementation(step12Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service OGSINCASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse oGSINCASESORES(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.oGSINCASESORESTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGSINCASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse oGSINCASESORESTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGSINCASESORESImplementation(request);
    }

    /*
     * Implements global service OGSINCASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse oGSINCASESORESImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCSUCURSALESRequest step1Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCSUCURSALESRequest();
        globalServicesSrv.tGSINCSUCURSALESImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest step2Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest();
        globalServicesSrv.tGSINCTIPOSIDENTIFICACIONImplementation(step2Request);

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORRequest step3Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORRequest();
        step3Request.setTGSINC1ASESORptpatrUsuario("0");
        step3Request.setTGSINC1ASESORptpatrPrimerNombre("0");
        step3Request.setTGSINC1ASESORptpatrSegundoNombre("0");
        step3Request.setTGSINC1ASESORptpatrPrimerApellido("0");
        step3Request.setTGSINC1ASESORptpatrSegundoApellido("0");
        step3Request.setTGSINC1ASESORptpatrEmail("0");
        step3Request.setTGSINC1ASESORptpatrCodigoSucursal(Long.valueOf(0));
        step3Request.setTGSINC1ASESORpCodDirector("0");
        step3Request.setTGSINC1ASESORpTipoIdentificacion("0");
        step3Request.setTGSINC1ASESORpNumIdentificacion("0");
        step3Request.setTGSINC1ASESORptpCanal("0");
        step3Request.setTGSINC1ASESORptpCargo("0");
        step3Request.setTGSINC1ASESORptpEstado("0");
        globalServicesSrv.tGSINC1ASESORImplementation(step3Request);

        /* Action 4: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition4 = ((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null;
        if (ifCondition4) {
            for(FrecuenciaAct step440Entity : globalServicesRepository.assocOperator068()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step40Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step40Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step440Entity);
                step40Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step40Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("X-DE-TOTAL");
                step40Request.setFrecuenciaActfijarSincronizacionpUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
                step40Request.setFrecuenciaActfijarSincronizacionpNombreUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionariodrvNombreCompleto());
                frecuenciaActSrv.fijarSincronizacionImplementation(step40Request);
            }
        } else {
            for(FrecuenciaAct step441Entity : globalServicesRepository.assocOperator069()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step41Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step41Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step441Entity);
                step41Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step41Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("X-DE-TOTAL");
                step41Request.setFrecuenciaActfijarSincronizacionpUsuario("Auto");
                step41Request.setFrecuenciaActfijarSincronizacionpNombreUsuario("");
                frecuenciaActSrv.fijarSincronizacionImplementation(step41Request);
            }
        }

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESARASESORESRequest step5Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESARASESORESRequest();
        globalServicesSrv.tGPOSPROCESARASESORESImplementation(step5Request);

        com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCAGENTESXPRODRequest step6Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCAGENTESXPRODRequest();
        globalServicesSrv.oGSINCAGENTESXPRODImplementation(step6Request);
        return response;
    }

    /*
     * Implements global service TGSINC1TIPOIDENTIFICACION
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1TIPOIDENTIFICACIONImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1TIPOIDENTIFICACIONRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo = request.getTGSINC1TIPOIDENTIFICACIONptpatrCodigo();
        String tGSINC1TIPOIDENTIFICACIONptpatrDescripcion = request.getTGSINC1TIPOIDENTIFICACIONptpatrDescripcion();
        String tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto = request.getTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto();

        request.checkArguments();

        /* Action 1: IF (EXIST (TipoIdentificacion) WHERE (TipoIdentificacion.Codigo = ptpatrCodigo) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator097(tGSINC1TIPOIDENTIFICACIONptpatrCodigo).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.CrearRequest();
            step10Request.setTipoIdentificacioncrearpatrCodigo(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
            step10Request.setTipoIdentificacioncrearpatrDescripcion(tGSINC1TIPOIDENTIFICACIONptpatrDescripcion);
            step10Request.setTipoIdentificacioncrearpatrNombreCorto(tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto);
            step10Request.setTipoIdentificacioncrearpatrValidoContratante(Boolean.TRUE);
            step10Request.setTipoIdentificacioncrearpatrValidoTitular(Boolean.TRUE);
            step10Request.setTipoIdentificacioncrearpatrDiplomatico(Boolean.FALSE);
            step10Request.setTipoIdentificacioncrearpatrNIT(Boolean.FALSE);
            step10Request.setTipoIdentificacioncrearpatrHijoDe(Boolean.FALSE);
            step10Request.setTipoIdentificacioncrearpatrRequiereEPS(Boolean.TRUE);
            step10Request.setTipoIdentificacioncrearpatrMenorSinIdentificar(Boolean.FALSE);
            step10Request.setTipoIdentificacioncrearpatrEsPasaporte(Boolean.FALSE);
            step10Request.setTipoIdentificacioncrearpatrVisibleValidadorUsu(Boolean.TRUE);
            tipoIdentificacionSrv.crearImplementation(step10Request);
        } else {
            for(TipoIdentificacion step111Entity : globalServicesRepository.assocOperator096(tGSINC1TIPOIDENTIFICACIONptpatrCodigo)) {
                com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.SincronizarRequest step11Request = new com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.SincronizarRequest();
                step11Request.setTipoIdentificacionsincronizarpthisTipoIdentificacionInstance(step111Entity);
                step11Request.setTipoIdentificacionsincronizarpDescripcion(tGSINC1TIPOIDENTIFICACIONptpatrDescripcion);
                step11Request.setTipoIdentificacionsincronizarpNombreCorto(tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto);
                tipoIdentificacionSrv.sincronizarImplementation(step11Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service TGSINCTIPOSIDENTIFICACION
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSINCTIPOSIDENTIFICACION(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSINCTIPOSIDENTIFICACIONTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSINCTIPOSIDENTIFICACION
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSINCTIPOSIDENTIFICACIONTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSINCTIPOSIDENTIFICACIONImplementation(request);
    }

    /*
     * Implements global service TGSINCTIPOSIDENTIFICACION
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINCTIPOSIDENTIFICACIONImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1TIPOIDENTIFICACIONRequest step1Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1TIPOIDENTIFICACIONRequest();
        step1Request.setTGSINC1TIPOIDENTIFICACIONptpatrCodigo(Long.valueOf(0));
        step1Request.setTGSINC1TIPOIDENTIFICACIONptpatrDescripcion("0");
        step1Request.setTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto("0");
        globalServicesSrv.tGSINC1TIPOIDENTIFICACIONImplementation(step1Request);

        /* Action 2: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition2 = ((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null;
        if (ifCondition2) {
            for(FrecuenciaAct step220Entity : globalServicesRepository.assocOperator098()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step20Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step20Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step220Entity);
                step20Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step20Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("Éxito");
                step20Request.setFrecuenciaActfijarSincronizacionpUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
                step20Request.setFrecuenciaActfijarSincronizacionpNombreUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionariodrvNombreCompleto());
                frecuenciaActSrv.fijarSincronizacionImplementation(step20Request);
            }
        } else {
            for(FrecuenciaAct step221Entity : globalServicesRepository.assocOperator099()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step21Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step21Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step221Entity);
                step21Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step21Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("Exito");
                step21Request.setFrecuenciaActfijarSincronizacionpUsuario("Auto");
                step21Request.setFrecuenciaActfijarSincronizacionpNombreUsuario("");
                frecuenciaActSrv.fijarSincronizacionImplementation(step21Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service TGVERIFICARUSUARIO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGVERIFICARUSUARIO(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGVERIFICARUSUARIORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGVERIFICARUSUARIOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGVERIFICARUSUARIO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGVERIFICARUSUARIOTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGVERIFICARUSUARIORequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGVERIFICARUSUARIOImplementation(request);
    }

    /*
     * Implements global service TGVERIFICARUSUARIO
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGVERIFICARUSUARIOImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGVERIFICARUSUARIORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String tGVERIFICARUSUARIOptpagrRol = request.getTGVERIFICARUSUARIOptpagrRol();
        String tGVERIFICARUSUARIOptpatrUsuario = request.getTGVERIFICARUSUARIOptpatrUsuario();
        String tGVERIFICARUSUARIOpPrimerNombre = request.getTGVERIFICARUSUARIOpPrimerNombre();
        String tGVERIFICARUSUARIOpSegundoNombre = request.getTGVERIFICARUSUARIOpSegundoNombre();
        String tGVERIFICARUSUARIOpPrimerApellido = request.getTGVERIFICARUSUARIOpPrimerApellido();
        String tGVERIFICARUSUARIOpSegundoApellido = request.getTGVERIFICARUSUARIOpSegundoApellido();
        String tGVERIFICARUSUARIOpEmail = request.getTGVERIFICARUSUARIOpEmail();

        request.checkArguments();

        /* Action 1: IF (indexOf(upperCase(ptpagrRol), "ASESOR") = 0) */
        boolean ifCondition1 = Long.valueOf(STDFunctions.indexOfFun(STDFunctions.upperCaseFun(tGVERIFICARUSUARIOptpagrRol), "ASESOR")).equals(Long.valueOf(0));
        if (ifCondition1) {
            /* Action 10: IF (EXIST (Funcionario) WHERE (Funcionario.UsuarioLDAP = ptpatrUsuario) = false) */
            boolean ifCondition10 = globalServicesRepository.assocOperator141(tGVERIFICARUSUARIOptpatrUsuario).equals(false);
            if (ifCondition10) {
                for(Sucursal step1100Entity : globalServicesRepository.assocOperator139()) {
                    com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest step100Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest();
                    step100Request.setFuncionarioTCREARptpagrRolInstance(userFunctionsSrv.fugetRolFun(tGVERIFICARUSUARIOptpagrRol));
                    step100Request.setFuncionarioTCREARptpatrUsuario(tGVERIFICARUSUARIOptpatrUsuario);
                    step100Request.setFuncionarioTCREARptpatrPrimerNombre(tGVERIFICARUSUARIOpPrimerNombre);
                    step100Request.setFuncionarioTCREARptpatrSegundoNombre(tGVERIFICARUSUARIOpSegundoNombre);
                    step100Request.setFuncionarioTCREARptpatrPrimerApellido(tGVERIFICARUSUARIOpPrimerApellido);
                    step100Request.setFuncionarioTCREARptpatrSegundoApellido(tGVERIFICARUSUARIOpSegundoApellido);
                    step100Request.setFuncionarioTCREARptppassword("Q");
                    step100Request.setFuncionarioTCREARptpagrSucursalInstance(step1100Entity);
                    step100Request.setFuncionarioTCREARptpatrUsuarioLDAP(tGVERIFICARUSUARIOptpatrUsuario);
                    step100Request.setFuncionarioTCREARptpatrEmail(tGVERIFICARUSUARIOpEmail);
                    step100Request.setFuncionarioTCREARptpagrRegionalInstance(null);
                    funcionarioSrv.tCREARImplementation(step100Request);
                }
            } else {
                for(Funcionario step1101Entity : globalServicesRepository.assocOperator140(tGVERIFICARUSUARIOptpatrUsuario)) {
                    com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest step101Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest();
                    step101Request.setFuncionarioTMODIFICARYROLpthisAgenteInstance(step1101Entity);
                    step101Request.setFuncionarioTMODIFICARYROLptpPrimerNombre(tGVERIFICARUSUARIOpPrimerNombre);
                    step101Request.setFuncionarioTMODIFICARYROLptpSegundoNombre(tGVERIFICARUSUARIOpSegundoNombre);
                    step101Request.setFuncionarioTMODIFICARYROLptpPrimerApellido(tGVERIFICARUSUARIOpPrimerApellido);
                    step101Request.setFuncionarioTMODIFICARYROLptpSegundoApellido(tGVERIFICARUSUARIOpSegundoApellido);
                    step101Request.setFuncionarioTMODIFICARYROLptNuevoRolInstance(userFunctionsSrv.fugetRolFun(tGVERIFICARUSUARIOptpagrRol));
                    step101Request.setFuncionarioTMODIFICARYROLptpatrUsuarioLDAP(tGVERIFICARUSUARIOptpatrUsuario);
                    step101Request.setFuncionarioTMODIFICARYROLptpatrEmail(tGVERIFICARUSUARIOpEmail);
                    step101Request.setFuncionarioTMODIFICARYROLptpagrRegionalInstance(null);
                    funcionarioSrv.tMODIFICARYROLImplementation(step101Request);
                }
            }
        }
        return response;
    }

    /*
     * Entry point for global service OGSINCAGENTESXPROD
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse oGSINCAGENTESXPROD(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCAGENTESXPRODRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.oGSINCAGENTESXPRODTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGSINCAGENTESXPROD
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse oGSINCAGENTESXPRODTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCAGENTESXPRODRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGSINCAGENTESXPRODImplementation(request);
    }

    /*
     * Implements global service OGSINCAGENTESXPROD
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse oGSINCAGENTESXPRODImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCAGENTESXPRODRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODRequest step1Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODRequest();
        step1Request.setTGSINC1AGENTEXPRODpProducto("0");
        step1Request.setTGSINC1AGENTEXPRODptpatrFechaInicio(null);
        step1Request.setTGSINC1AGENTEXPRODptpatrFechaFin(null);
        step1Request.setTGSINC1AGENTEXPRODptpAsesor("0");
        step1Request.setTGSINC1AGENTEXPRODpCodigo(Long.valueOf(0));
        globalServicesSrv.tGSINC1AGENTEXPRODImplementation(step1Request);

        /* Action 2: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition2 = ((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null;
        if (ifCondition2) {
            for(FrecuenciaAct step220Entity : globalServicesRepository.assocOperator144()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step20Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step20Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step220Entity);
                step20Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step20Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("X-DE-TOTAL");
                step20Request.setFrecuenciaActfijarSincronizacionpUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuario());
                step20Request.setFrecuenciaActfijarSincronizacionpNombreUsuario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionariodrvNombreCompleto());
                frecuenciaActSrv.fijarSincronizacionImplementation(step20Request);
            }
        } else {
            for(FrecuenciaAct step221Entity : globalServicesRepository.assocOperator145()) {
                com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest step21Request = new com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest();
                step21Request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(step221Entity);
                step21Request.setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(STDFunctions.systemDateFun());
                step21Request.setFrecuenciaActfijarSincronizacionpResultadoSinc("X-DE-TOTAL");
                step21Request.setFrecuenciaActfijarSincronizacionpUsuario("Auto");
                step21Request.setFrecuenciaActfijarSincronizacionpNombreUsuario("");
                frecuenciaActSrv.fijarSincronizacionImplementation(step21Request);
            }
        }
        return response;
    }

    /*
     * Entry point for global service TGSINC1AGENTEXPROD
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSINC1AGENTEXPROD(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSINC1AGENTEXPRODTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSINC1AGENTEXPROD
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSINC1AGENTEXPRODTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGSINC1AGENTEXPRODImplementation(request);
    }

    /*
     * Implements global service TGSINC1AGENTEXPROD
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1AGENTEXPRODImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String tGSINC1AGENTEXPRODpProducto = request.getTGSINC1AGENTEXPRODpProducto();
        Timestamp tGSINC1AGENTEXPRODptpatrFechaInicio = request.getTGSINC1AGENTEXPRODptpatrFechaInicio();
        Timestamp tGSINC1AGENTEXPRODptpatrFechaFin = request.getTGSINC1AGENTEXPRODptpatrFechaFin();
        String tGSINC1AGENTEXPRODptpAsesor = request.getTGSINC1AGENTEXPRODptpAsesor();
        Long tGSINC1AGENTEXPRODpCodigo = request.getTGSINC1AGENTEXPRODpCodigo();

        request.checkArguments();

        /* Action 1: IF (EXIST (Productos) WHERE (Productos.CodigoLegal = pProducto) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator148(tGSINC1AGENTEXPRODpProducto).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCPRODUCTOSRequest step10Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCPRODUCTOSRequest();
            globalServicesSrv.tGSINCPRODUCTOSImplementation(step10Request);
        }

        for(Productos step2Entity : globalServicesRepository.assocOperator147(tGSINC1AGENTEXPRODpProducto)) {
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODAUXRequest step2Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODAUXRequest();
            step2Request.setTGSINC1AGENTEXPRODAUXptpagrProductoInstance(step2Entity);
            step2Request.setTGSINC1AGENTEXPRODAUXptpagrAsesorInstance(userFunctionsSrv.fugetAsesorFun(tGSINC1AGENTEXPRODptpAsesor));
            step2Request.setTGSINC1AGENTEXPRODAUXptpatrCodigo(tGSINC1AGENTEXPRODpCodigo);
            step2Request.setTGSINC1AGENTEXPRODAUXptpatrFechaInicio(tGSINC1AGENTEXPRODptpatrFechaInicio);
            step2Request.setTGSINC1AGENTEXPRODAUXptpatrFechaFin(tGSINC1AGENTEXPRODptpatrFechaFin);
            globalServicesSrv.tGSINC1AGENTEXPRODAUXImplementation(step2Request);
        }
        return response;
    }

    /*
     * Entry point for global service TGSINC1AGENTEXPRODAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGSINC1AGENTEXPRODAUX(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODAUXRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGSINC1AGENTEXPRODAUXTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGSINC1AGENTEXPRODAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGSINC1AGENTEXPRODAUXTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODAUXRequest request) throws ModelException, SystemException {
        request.setTGSINC1AGENTEXPRODAUXptpagrProductoInstance(productosSrv.getByOIDWithHV(request.getTGSINC1AGENTEXPRODAUXptpagrProducto()));
        request.setTGSINC1AGENTEXPRODAUXptpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getTGSINC1AGENTEXPRODAUXptpagrAsesor()));
        return globalServicesSrv.tGSINC1AGENTEXPRODAUXImplementation(request);
    }

    /*
     * Implements global service TGSINC1AGENTEXPRODAUX
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGSINC1AGENTEXPRODAUXImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODAUXRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Productos tGSINC1AGENTEXPRODAUXptpagrProducto = request.getTGSINC1AGENTEXPRODAUXptpagrProductoInstance();
        Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor = request.getTGSINC1AGENTEXPRODAUXptpagrAsesorInstance();
        Long tGSINC1AGENTEXPRODAUXptpatrCodigo = request.getTGSINC1AGENTEXPRODAUXptpatrCodigo();
        Timestamp tGSINC1AGENTEXPRODAUXptpatrFechaInicio = request.getTGSINC1AGENTEXPRODAUXptpatrFechaInicio();
        Timestamp tGSINC1AGENTEXPRODAUXptpatrFechaFin = request.getTGSINC1AGENTEXPRODAUXptpatrFechaFin();

        request.checkArguments();

        /* Action 1: IF (EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = ptpagrAsesor AND AgentexProducto.Codigo = ptpatrCodigo) = false) */
        boolean ifCondition1 = globalServicesRepository.assocOperator151(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCREARRequest step10Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCREARRequest();
            step10Request.setAgentexProductoTCREARptpagrProductoTInstance(tGSINC1AGENTEXPRODAUXptpagrProducto);
            step10Request.setAgentexProductoTCREARptpagrAsesorInstance(tGSINC1AGENTEXPRODAUXptpagrAsesor);
            step10Request.setAgentexProductoTCREARptpatrFechaInicio(tGSINC1AGENTEXPRODAUXptpatrFechaInicio);
            step10Request.setAgentexProductoTCREARptpatrFechaFin(tGSINC1AGENTEXPRODAUXptpatrFechaFin);
            step10Request.setAgentexProductoTCREARptpatrCodigo(tGSINC1AGENTEXPRODAUXptpatrCodigo);
            agentexProductoSrv.tCREARImplementation(step10Request);
        } else {
            for(AgentexProducto step111Entity : globalServicesRepository.assocOperator150(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo)) {
                com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TSINCRONIZARRequest step11Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TSINCRONIZARRequest();
                step11Request.setAgentexProductoTSINCRONIZARpthisAgentexProductoInstance(step111Entity);
                step11Request.setAgentexProductoTSINCRONIZARptpFechaInicio(tGSINC1AGENTEXPRODAUXptpatrFechaInicio);
                step11Request.setAgentexProductoTSINCRONIZARptpFechaFin(tGSINC1AGENTEXPRODAUXptpatrFechaFin);
                step11Request.setAgentexProductoTSINCRONIZARpProductoInstance(tGSINC1AGENTEXPRODAUXptpagrProducto);
                agentexProductoSrv.tSINCRONIZARImplementation(step11Request);
            }
        }
        return response;
    }

    /*
     * Implements global service TGPOSPROCESS1ASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGPOSPROCESS1ASESORImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESS1ASESORRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String tGPOSPROCESS1ASESORpUsuario = request.getTGPOSPROCESS1ASESORpUsuario();
        Boolean tGPOSPROCESS1ASESORpEsDirector = request.getTGPOSPROCESS1ASESORpEsDirector();
        Rol tGPOSPROCESS1ASESORpRol = request.getTGPOSPROCESS1ASESORpRolInstance();

        request.checkArguments();

        for(Asesor step1Entity : globalServicesRepository.assocOperator166(tGPOSPROCESS1ASESORpUsuario)) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest();
            step1Request.setAsesorTPOSPROCESOSINCpthisAsesorInstance(step1Entity);
            step1Request.setAsesorTPOSPROCESOSINCpEsDirector(tGPOSPROCESS1ASESORpEsDirector);
            asesorSrv.tPOSPROCESOSINCImplementation(step1Request);
        }
        return response;
    }

    /*
     * Entry point for global service TGPOSPROCESARASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGPOSPROCESARASESORES(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESARASESORESRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGPOSPROCESARASESORESTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGPOSPROCESARASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGPOSPROCESARASESORESTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESARASESORESRequest request) throws ModelException, SystemException {
        return globalServicesSrv.tGPOSPROCESARASESORESImplementation(request);
    }

    /*
     * Implements global service TGPOSPROCESARASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGPOSPROCESARASESORESImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESARASESORESRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();

        for(Asesor step1Entity : globalServicesRepository.assocOperator167()) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest();
            step1Request.setAsesorTPOSPROCESOSINCpthisAsesorInstance(step1Entity);
            step1Request.setAsesorTPOSPROCESOSINCpEsDirector(Boolean.TRUE);
            asesorSrv.tPOSPROCESOSINCImplementation(step1Request);
        }

        for(Asesor step2Entity : globalServicesRepository.assocOperator169()) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest step2Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest();
            step2Request.setAsesorTPOSPROCESOSINCpthisAsesorInstance(step2Entity);
            step2Request.setAsesorTPOSPROCESOSINCpEsDirector(Boolean.FALSE);
            asesorSrv.tPOSPROCESOSINCImplementation(step2Request);
        }
        return response;
    }

    /*
     * Entry point for global service TCREARAGENTE
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARAGENTE(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tCREARAGENTETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TCREARAGENTE
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARAGENTETxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) throws ModelException, SystemException {
        request.setTCREARAGENTEptpagrRolInstance(rolSrv.getByOIDWithHV(new RolOid().fromJsonString(request.getTCREARAGENTEptpagrRol())));
        request.setTCREARAGENTEptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getTCREARAGENTEptpagrSucursal()));
        request.setTCREARAGENTEptpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getTCREARAGENTEptpagrRegional()));
        return globalServicesSrv.tCREARAGENTEImplementation(request);
    }

    /*
     * Implements global service TCREARAGENTE
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARAGENTEImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Rol tCREARAGENTEptpagrRol = request.getTCREARAGENTEptpagrRolInstance();
        String tCREARAGENTEptpatrUsuario = request.getTCREARAGENTEptpatrUsuario();
        String tCREARAGENTEptpatrPrimerNombre = request.getTCREARAGENTEptpatrPrimerNombre();
        String tCREARAGENTEptpatrSegundoNombre = request.getTCREARAGENTEptpatrSegundoNombre();
        String tCREARAGENTEptpatrPrimerApellido = request.getTCREARAGENTEptpatrPrimerApellido();
        String tCREARAGENTEptpatrSegundoApellido = request.getTCREARAGENTEptpatrSegundoApellido();
        Sucursal tCREARAGENTEptpagrSucursal = request.getTCREARAGENTEptpagrSucursalInstance();
        String tCREARAGENTEptpatrUsuarioLDAP = request.getTCREARAGENTEptpatrUsuarioLDAP();
        String tCREARAGENTEptpatrEmail = request.getTCREARAGENTEptpatrEmail();
        Regional tCREARAGENTEptpagrRegional = request.getTCREARAGENTEptpagrRegionalInstance();

        request.checkArguments();

        tCREARAGENTEPreconditions(request);

        com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest();
        step1Request.setFuncionarioTCREARptpagrRolInstance(tCREARAGENTEptpagrRol);
        step1Request.setFuncionarioTCREARptpatrUsuario(tCREARAGENTEptpatrUsuario);
        step1Request.setFuncionarioTCREARptpatrPrimerNombre(tCREARAGENTEptpatrPrimerNombre);
        step1Request.setFuncionarioTCREARptpatrSegundoNombre(tCREARAGENTEptpatrSegundoNombre);
        step1Request.setFuncionarioTCREARptpatrPrimerApellido(tCREARAGENTEptpatrPrimerApellido);
        step1Request.setFuncionarioTCREARptpatrSegundoApellido(tCREARAGENTEptpatrSegundoApellido);
        step1Request.setFuncionarioTCREARptppassword("1");
        step1Request.setFuncionarioTCREARptpagrSucursalInstance(tCREARAGENTEptpagrSucursal);
        step1Request.setFuncionarioTCREARptpatrUsuarioLDAP(tCREARAGENTEptpatrUsuarioLDAP);
        step1Request.setFuncionarioTCREARptpatrEmail(tCREARAGENTEptpatrEmail);
        step1Request.setFuncionarioTCREARptpagrRegionalInstance(tCREARAGENTEptpagrRegional);
        funcionarioSrv.tCREARImplementation(step1Request);
        return response;
    }

    /*
     * Checks service TCREARAGENTE preconditions individually
     * @param request Service request viewmodel
     * @returns Service response viewmodel with the execution results
     */
    public ServiceResponse tCREARAGENTECheckPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setTCREARAGENTEptpagrRolInstance(rolSrv.getByOIDWithHV(new RolOid().fromJsonString(request.getTCREARAGENTEptpagrRol())));
        request.setTCREARAGENTEptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getTCREARAGENTEptpagrSucursal()));
        request.setTCREARAGENTEptpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getTCREARAGENTEptpagrRegional()));
        try {
            if("IGl_1462447112192088Pre_1".equals(request.getPreconditionId()))
                checkIGl1462447112192088Pre1(request);
            if("IGl_1462447112192088Pre_2".equals(request.getPreconditionId()))
                checkIGl1462447112192088Pre2(request);
            if("IGl_1462447112192088Pre_3".equals(request.getPreconditionId()))
                checkIGl1462447112192088Pre3(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tCREARAGENTEPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) 
            throws ModelException {
        checkIGl1462447112192088Pre1(request);
        checkIGl1462447112192088Pre2(request);
        checkIGl1462447112192088Pre3(request);
    }

    private void checkIGl1462447112192088Pre1 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) 
            throws ModelException {
        // pt_p_atrUsuarioLDAP = NULL OR EXIST( Funcionario ) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP) = false

        String tCREARAGENTEptpatrUsuarioLDAP = request.getTCREARAGENTEptpatrUsuarioLDAP();
        try {
            boolean preconditionHolds = tCREARAGENTEptpatrUsuarioLDAP == null || globalServicesRepository.assocOperator171(tCREARAGENTEptpatrUsuarioLDAP).equals(false);
            if (!preconditionHolds) throw new PreconditionException("No puede crear el usuario porque ya existe uno con el mismo valor para Usuario LDAP");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkIGl1462447112192088Pre2 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) 
            throws ModelException {
        // pt_p_agrRol.Nombre <> "JEFEASESORES"

        Rol tCREARAGENTEptpagrRol = request.getTCREARAGENTEptpagrRolInstance();
        boolean preconditionHolds = !(tCREARAGENTEptpagrRol.getRolNombre()).equals("JEFEASESORES");
        if (!preconditionHolds) throw new PreconditionException("Los jefes de asesores no se pueden crear, sólo es posible sincronizarlos");
    }

    private void checkIGl1462447112192088Pre3 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest request) 
            throws ModelException {
        // pt_p_agrRol.Nombre <> "ASESOR COMERCIAL"

        Rol tCREARAGENTEptpagrRol = request.getTCREARAGENTEptpagrRolInstance();
        boolean preconditionHolds = !(tCREARAGENTEptpagrRol.getRolNombre()).equals("ASESOR COMERCIAL");
        if (!preconditionHolds) throw new PreconditionException("Los asesores no se pueden crear, sólo es posible sincronizarlos");
    }

    /*
     * Entry point for global service TMODIFICARAGENTE
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICARAGENTE(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tMODIFICARAGENTETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TMODIFICARAGENTE
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARAGENTETxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) throws ModelException, SystemException {
        request.setTMODIFICARAGENTEptpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getTMODIFICARAGENTEptpthisAgente()));
        request.setTMODIFICARAGENTEptNuevoRolInstance(rolSrv.getByOIDWithHV(new RolOid().fromJsonString(request.getTMODIFICARAGENTEptNuevoRol())));
        request.setTMODIFICARAGENTEptpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getTMODIFICARAGENTEptpagrRegional()));
        return globalServicesSrv.tMODIFICARAGENTEImplementation(request);
    }

    /*
     * Implements global service TMODIFICARAGENTE
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARAGENTEImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Funcionario tMODIFICARAGENTEptpthisAgente = request.getTMODIFICARAGENTEptpthisAgenteInstance();
        String tMODIFICARAGENTEptpPrimerNombre = request.getTMODIFICARAGENTEptpPrimerNombre();
        String tMODIFICARAGENTEptpSegundoNombre = request.getTMODIFICARAGENTEptpSegundoNombre();
        String tMODIFICARAGENTEptpPrimerApellido = request.getTMODIFICARAGENTEptpPrimerApellido();
        String tMODIFICARAGENTEptpSegundoApellido = request.getTMODIFICARAGENTEptpSegundoApellido();
        Rol tMODIFICARAGENTEptNuevoRol = request.getTMODIFICARAGENTEptNuevoRolInstance();
        String tMODIFICARAGENTEptpatrUsuarioLDAP = request.getTMODIFICARAGENTEptpatrUsuarioLDAP();
        String tMODIFICARAGENTEptpatrEmail = request.getTMODIFICARAGENTEptpatrEmail();
        Regional tMODIFICARAGENTEptpagrRegional = request.getTMODIFICARAGENTEptpagrRegionalInstance();

        request.checkArguments();

        tMODIFICARAGENTEPreconditions(request);

        com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest();
        step1Request.setFuncionarioTMODIFICARYROLpthisAgenteInstance(tMODIFICARAGENTEptpthisAgente);
        step1Request.setFuncionarioTMODIFICARYROLptpPrimerNombre(tMODIFICARAGENTEptpPrimerNombre);
        step1Request.setFuncionarioTMODIFICARYROLptpSegundoNombre(tMODIFICARAGENTEptpSegundoNombre);
        step1Request.setFuncionarioTMODIFICARYROLptpPrimerApellido(tMODIFICARAGENTEptpPrimerApellido);
        step1Request.setFuncionarioTMODIFICARYROLptpSegundoApellido(tMODIFICARAGENTEptpSegundoApellido);
        step1Request.setFuncionarioTMODIFICARYROLptNuevoRolInstance(tMODIFICARAGENTEptNuevoRol);
        step1Request.setFuncionarioTMODIFICARYROLptpatrUsuarioLDAP(tMODIFICARAGENTEptpatrUsuarioLDAP);
        step1Request.setFuncionarioTMODIFICARYROLptpatrEmail(tMODIFICARAGENTEptpatrEmail);
        step1Request.setFuncionarioTMODIFICARYROLptpagrRegionalInstance(tMODIFICARAGENTEptpagrRegional);
        funcionarioSrv.tMODIFICARYROLImplementation(step1Request);
        return response;
    }

    /*
     * Checks service TMODIFICARAGENTE preconditions individually
     * @param request Service request viewmodel
     * @returns Service response viewmodel with the execution results
     */
    public ServiceResponse tMODIFICARAGENTECheckPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setTMODIFICARAGENTEptpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getTMODIFICARAGENTEptpthisAgente()));
        request.setTMODIFICARAGENTEptNuevoRolInstance(rolSrv.getByOIDWithHV(new RolOid().fromJsonString(request.getTMODIFICARAGENTEptNuevoRol())));
        request.setTMODIFICARAGENTEptpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getTMODIFICARAGENTEptpagrRegional()));
        try {
            if("IGl_1462447243264368Pre_1".equals(request.getPreconditionId()))
                checkIGl1462447243264368Pre1(request);
            if("IGl_1462447243264368Pre_2".equals(request.getPreconditionId()))
                checkIGl1462447243264368Pre2(request);
            if("IGl_1462447243264368Pre_3".equals(request.getPreconditionId()))
                checkIGl1462447243264368Pre3(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tMODIFICARAGENTEPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) 
            throws ModelException {
        checkIGl1462447243264368Pre1(request);
        checkIGl1462447243264368Pre2(request);
        checkIGl1462447243264368Pre3(request);
    }

    private void checkIGl1462447243264368Pre1 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) 
            throws ModelException {
        // pt_p_atrUsuarioLDAP = NULL OR (COUNT( Funcionario ) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP AND Funcionario.Id <> pt_p_thisAgente.Id) = 0)

        String tMODIFICARAGENTEptpatrUsuarioLDAP = request.getTMODIFICARAGENTEptpatrUsuarioLDAP();
        Funcionario tMODIFICARAGENTEptpthisAgente = request.getTMODIFICARAGENTEptpthisAgenteInstance();
        try {
            boolean preconditionHolds = tMODIFICARAGENTEptpatrUsuarioLDAP == null || (Long.valueOf(globalServicesRepository.assocOperator172(tMODIFICARAGENTEptpatrUsuarioLDAP, tMODIFICARAGENTEptpthisAgente)).equals(Long.valueOf(0)));
            if (!preconditionHolds) throw new PreconditionException("No puede asignar el valor de Usuario LDAP indicado porque ya existe otro usuario con dicho valor");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkIGl1462447243264368Pre2 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) 
            throws ModelException {
        // pt_NuevoRol.Nombre <> "JEFEASESORES"

        Rol tMODIFICARAGENTEptNuevoRol = request.getTMODIFICARAGENTEptNuevoRolInstance();
        boolean preconditionHolds = !(tMODIFICARAGENTEptNuevoRol.getRolNombre()).equals("JEFEASESORES");
        if (!preconditionHolds) throw new PreconditionException("Los jefes de asesores no se pueden crear, sólo es posible sincronizarlos");
    }

    private void checkIGl1462447243264368Pre3 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest request) 
            throws ModelException {
        // pt_NuevoRol.Nombre <> "ASESOR COMERCIAL"

        Rol tMODIFICARAGENTEptNuevoRol = request.getTMODIFICARAGENTEptNuevoRolInstance();
        boolean preconditionHolds = !(tMODIFICARAGENTEptNuevoRol.getRolNombre()).equals("ASESOR COMERCIAL");
        if (!preconditionHolds) throw new PreconditionException("Los asesores no se pueden crear, sólo es posible sincronizarlos");
    }

    /*
     * Entry point for global service TGNEWASESORAGENCIA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse tGNEWASESORAGENCIA(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse();
        try {
            response = globalServicesSrv.tGNEWASESORAGENCIATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGNEWASESORAGENCIA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse tGNEWASESORAGENCIATxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) throws ModelException, SystemException {
        request.setTGNEWASESORAGENCIAptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getTGNEWASESORAGENCIAptpagrSucursal()));
        request.setTGNEWASESORAGENCIAptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTGNEWASESORAGENCIAptpagrTipoIdentificacion())));
        return globalServicesSrv.tGNEWASESORAGENCIAImplementation(request);
    }

    /*
     * Implements global service TGNEWASESORAGENCIA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse tGNEWASESORAGENCIAImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) throws ModelException, SystemException {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse();
        Sucursal tGNEWASESORAGENCIAptpagrSucursal = request.getTGNEWASESORAGENCIAptpagrSucursalInstance();
        String tGNEWASESORAGENCIAptpatrUsuario = request.getTGNEWASESORAGENCIAptpatrUsuario();
        String tGNEWASESORAGENCIAptpatrPrimerNombre = request.getTGNEWASESORAGENCIAptpatrPrimerNombre();
        String tGNEWASESORAGENCIAptpatrSegundoNombre = request.getTGNEWASESORAGENCIAptpatrSegundoNombre();
        String tGNEWASESORAGENCIAptpatrPrimerApellido = request.getTGNEWASESORAGENCIAptpatrPrimerApellido();
        String tGNEWASESORAGENCIAptpatrSegundoApellido = request.getTGNEWASESORAGENCIAptpatrSegundoApellido();
        String tGNEWASESORAGENCIAptpatrUsuarioLDAP = request.getTGNEWASESORAGENCIAptpatrUsuarioLDAP();
        String tGNEWASESORAGENCIAptpatrEmail = request.getTGNEWASESORAGENCIAptpatrEmail();
        TipoIdentificacion tGNEWASESORAGENCIAptpagrTipoIdentificacion = request.getTGNEWASESORAGENCIAptpagrTipoIdentificacionInstance();
        Boolean tGNEWASESORAGENCIAptpatrmodificaDirector = request.getTGNEWASESORAGENCIAptpatrmodificaDirector();
        String tGNEWASESORAGENCIAptpatrNumIdentificacion = request.getTGNEWASESORAGENCIAptpatrNumIdentificacion();
        Boolean tGNEWASESORAGENCIAptpatrModDBasicosPersona = request.getTGNEWASESORAGENCIAptpatrModDBasicosPersona();

        request.checkArguments();

        tGNEWASESORAGENCIAPreconditions(request);

        com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALRequest();
        step1Request.setFuncionarioTNEWASESORMANUALptpagrSucursalInstance(tGNEWASESORAGENCIAptpagrSucursal);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrUsuario(tGNEWASESORAGENCIAptpatrUsuario);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrPrimerNombre(tGNEWASESORAGENCIAptpatrPrimerNombre);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrSegundoNombre(tGNEWASESORAGENCIAptpatrSegundoNombre);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrPrimerApellido(tGNEWASESORAGENCIAptpatrPrimerApellido);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrSegundoApellido(tGNEWASESORAGENCIAptpatrSegundoApellido);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrUsuarioLDAP(tGNEWASESORAGENCIAptpatrUsuarioLDAP);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrEmail(tGNEWASESORAGENCIAptpatrEmail);
        step1Request.setFuncionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance(tGNEWASESORAGENCIAptpagrTipoIdentificacion);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrmodificaDirector(tGNEWASESORAGENCIAptpatrmodificaDirector);
        step1Request.setFuncionarioTNEWASESORMANUALptpatresDirector(Boolean.FALSE);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrNumIdentificacion(tGNEWASESORAGENCIAptpatrNumIdentificacion);
        step1Request.setFuncionarioTNEWASESORMANUALptpCodJefe(null);
        step1Request.setFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona(tGNEWASESORAGENCIAptpatrModDBasicosPersona);
        com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse step1Response = funcionarioSrv.tNEWASESORMANUALImplementation(step1Request);
        response.setTGNEWASESORAGENCIAoaFuncionarioInstance(step1Response.getFuncionarioTNEWASESORMANUALoaFuncionarioInstance());

        for(Funcionario step2Entity : globalServicesRepository.assocOperator173(tGNEWASESORAGENCIAptpatrUsuario)) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest step2Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest();
            step2Request.setFuncionariomodAsesorAgenciapthisFuncionarioInstance(response.getTGNEWASESORAGENCIAoaFuncionarioInstance());
            step2Request.setFuncionariomodAsesorAgenciapeNumUsuario(tGNEWASESORAGENCIAptpatrUsuario);
            step2Request.setFuncionariomodAsesorAgenciapeCodJefe(step2Entity.getFuncionarioCodJefe());
            funcionarioSrv.modAsesorAgenciaImplementation(step2Request);
        }
        return response;
    }

    /*
     * Checks service TGNEWASESORAGENCIA preconditions individually
     * @param request Service request viewmodel
     * @returns Service response viewmodel with the execution results
     */
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse tGNEWASESORAGENCIACheckPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse();
        request.setTGNEWASESORAGENCIAptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getTGNEWASESORAGENCIAptpagrSucursal()));
        request.setTGNEWASESORAGENCIAptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTGNEWASESORAGENCIAptpagrTipoIdentificacion())));
        try {
            if("IGl_1475495198720658Pre_1".equals(request.getPreconditionId()))
                checkIGl1475495198720658Pre1(request);
            if("IGl_1475495198720658Pre_2".equals(request.getPreconditionId()))
                checkIGl1475495198720658Pre2(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tGNEWASESORAGENCIAPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) 
            throws ModelException {
        checkIGl1475495198720658Pre1(request);
        checkIGl1475495198720658Pre2(request);
    }

    private void checkIGl1475495198720658Pre1 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) 
            throws ModelException {
        // pt_p_atrUsuarioLDAP = NULL OR COUNT( Funcionario ) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP) = 0

        String tGNEWASESORAGENCIAptpatrUsuarioLDAP = request.getTGNEWASESORAGENCIAptpatrUsuarioLDAP();
        try {
            boolean preconditionHolds = tGNEWASESORAGENCIAptpatrUsuarioLDAP == null || Long.valueOf(globalServicesRepository.assocOperator174(tGNEWASESORAGENCIAptpatrUsuarioLDAP)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("No puede asignar el valor de Usuario LDAP indicado porque ya existe otro usuario con dicho valor");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkIGl1475495198720658Pre2 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest request) 
            throws ModelException {
        // COUNT( Funcionario ) WHERE (Funcionario.Usuario = pt_p_atrUsuario AND Funcionario.Manual = false) > 0

        String tGNEWASESORAGENCIAptpatrUsuario = request.getTGNEWASESORAGENCIAptpatrUsuario();
        try {
            boolean preconditionHolds = globalServicesRepository.assocOperator175(tGNEWASESORAGENCIAptpatrUsuario) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("El número de usuario diligenciado debe corresponderse con un número de asesor existente");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    /*
     * Entry point for global service TGMODASESORAGENCIA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tGMODASESORAGENCIA(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = globalServicesSrv.tGMODASESORAGENCIATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service TGMODASESORAGENCIA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tGMODASESORAGENCIATxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) throws ModelException, SystemException {
        request.setTGMODASESORAGENCIAptpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getTGMODASESORAGENCIAptpthisAsesor()));
        request.setTGMODASESORAGENCIAptptSucursalInstance(sucursalSrv.getByOIDWithHV(request.getTGMODASESORAGENCIAptptSucursal()));
        request.setTGMODASESORAGENCIAptptTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTGMODASESORAGENCIAptptTipoIdentificacion())));
        return globalServicesSrv.tGMODASESORAGENCIAImplementation(request);
    }

    /*
     * Implements global service TGMODASESORAGENCIA
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tGMODASESORAGENCIAImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Asesor tGMODASESORAGENCIAptpthisAsesor = request.getTGMODASESORAGENCIAptpthisAsesorInstance();
        Boolean tGMODASESORAGENCIAptpModDBasicosPersona = request.getTGMODASESORAGENCIAptpModDBasicosPersona();
        Boolean tGMODASESORAGENCIAptpModificaDirector = request.getTGMODASESORAGENCIAptpModificaDirector();
        String tGMODASESORAGENCIAptptUsuarioLDAP = request.getTGMODASESORAGENCIAptptUsuarioLDAP();
        String tGMODASESORAGENCIAptptEmail = request.getTGMODASESORAGENCIAptptEmail();
        String tGMODASESORAGENCIAptpPrimerNombre = request.getTGMODASESORAGENCIAptpPrimerNombre();
        String tGMODASESORAGENCIAptpSegundoNombre = request.getTGMODASESORAGENCIAptpSegundoNombre();
        String tGMODASESORAGENCIAptpPrimerApellido = request.getTGMODASESORAGENCIAptpPrimerApellido();
        String tGMODASESORAGENCIAptpSegundoApellido = request.getTGMODASESORAGENCIAptpSegundoApellido();
        String tGMODASESORAGENCIAptpeNumUsuario = request.getTGMODASESORAGENCIAptpeNumUsuario();
        Sucursal tGMODASESORAGENCIAptptSucursal = request.getTGMODASESORAGENCIAptptSucursalInstance();
        TipoIdentificacion tGMODASESORAGENCIAptptTipoIdentificacion = request.getTGMODASESORAGENCIAptptTipoIdentificacionInstance();
        String tGMODASESORAGENCIAptptNumIdentificacion = request.getTGMODASESORAGENCIAptptNumIdentificacion();
        Boolean tGMODASESORAGENCIAptpVerDBasicosPersona = request.getTGMODASESORAGENCIAptpVerDBasicosPersona();
        Boolean tGMODASESORAGENCIAptpVerDocsPersona = request.getTGMODASESORAGENCIAptpVerDocsPersona();
        Boolean tGMODASESORAGENCIAptpVerContratoNovedad = request.getTGMODASESORAGENCIAptpVerContratoNovedad();
        Boolean tGMODASESORAGENCIAptValidadorUsuarios = request.getTGMODASESORAGENCIAptValidadorUsuarios();

        request.checkArguments();

        tGMODASESORAGENCIAPreconditions(request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORAGENCIARequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORAGENCIARequest();
        step1Request.setAsesorTMODIFICARASESORAGENCIApthisAsesorInstance(tGMODASESORAGENCIAptpthisAsesor);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona(tGMODASESORAGENCIAptpModDBasicosPersona);
        step1Request.setAsesorTMODIFICARASESORAGENCIApModificaDirector(tGMODASESORAGENCIAptpModificaDirector);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptUsuarioLDAP(tGMODASESORAGENCIAptptUsuarioLDAP);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptEmail(tGMODASESORAGENCIAptptEmail);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpPrimerNombre(tGMODASESORAGENCIAptpPrimerNombre);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpSegundoNombre(tGMODASESORAGENCIAptpSegundoNombre);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpPrimerApellido(tGMODASESORAGENCIAptpPrimerApellido);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpSegundoApellido(tGMODASESORAGENCIAptpSegundoApellido);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpeNumUsuario(tGMODASESORAGENCIAptpeNumUsuario);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpEsDirector(Boolean.FALSE);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpeCodJefe(null);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptSucursalInstance(tGMODASESORAGENCIAptptSucursal);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance(tGMODASESORAGENCIAptptTipoIdentificacion);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptNumIdentificacion(tGMODASESORAGENCIAptptNumIdentificacion);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona(tGMODASESORAGENCIAptpVerDBasicosPersona);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona(tGMODASESORAGENCIAptpVerDocsPersona);
        step1Request.setAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad(tGMODASESORAGENCIAptpVerContratoNovedad);
        step1Request.setAsesorTMODIFICARASESORAGENCIApeValidadorUsuarios(tGMODASESORAGENCIAptValidadorUsuarios);
        asesorSrv.tMODIFICARASESORAGENCIAImplementation(step1Request);

        for(Funcionario step2Entity : globalServicesRepository.assocOperator176(tGMODASESORAGENCIAptpeNumUsuario)) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest step2Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest();
            step2Request.setFuncionariomodAsesorAgenciapthisFuncionarioInstance(tGMODASESORAGENCIAptpthisAsesor.getFuncionarioFacet());
            step2Request.setFuncionariomodAsesorAgenciapeNumUsuario(tGMODASESORAGENCIAptpeNumUsuario);
            step2Request.setFuncionariomodAsesorAgenciapeCodJefe(step2Entity.getFuncionarioCodJefe());
            funcionarioSrv.modAsesorAgenciaImplementation(step2Request);
        }
        return response;
    }

    /*
     * Checks service TGMODASESORAGENCIA preconditions individually
     * @param request Service request viewmodel
     * @returns Service response viewmodel with the execution results
     */
    public ServiceResponse tGMODASESORAGENCIACheckPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setTGMODASESORAGENCIAptpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getTGMODASESORAGENCIAptpthisAsesor()));
        request.setTGMODASESORAGENCIAptptSucursalInstance(sucursalSrv.getByOIDWithHV(request.getTGMODASESORAGENCIAptptSucursal()));
        request.setTGMODASESORAGENCIAptptTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(new TipoIdentificacionOid().fromJsonString(request.getTGMODASESORAGENCIAptptTipoIdentificacion())));
        try {
            if("IGl_1475495460864793Pre_1".equals(request.getPreconditionId()))
                checkIGl1475495460864793Pre1(request);
            if("IGl_1475495460864793Pre_2".equals(request.getPreconditionId()))
                checkIGl1475495460864793Pre2(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tGMODASESORAGENCIAPreconditions(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) 
            throws ModelException {
        checkIGl1475495460864793Pre1(request);
        checkIGl1475495460864793Pre2(request);
    }

    private void checkIGl1475495460864793Pre1 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) 
            throws ModelException {
        // pt_ptUsuarioLDAP = NULL OR COUNT( Funcionario ) WHERE (Funcionario.UsuarioLDAP = pt_ptUsuarioLDAP AND Funcionario.Id <> pt_p_thisAsesor.Id) = 0

        String tGMODASESORAGENCIAptptUsuarioLDAP = request.getTGMODASESORAGENCIAptptUsuarioLDAP();
        Asesor tGMODASESORAGENCIAptpthisAsesor = request.getTGMODASESORAGENCIAptpthisAsesorInstance();
        try {
            boolean preconditionHolds = tGMODASESORAGENCIAptptUsuarioLDAP == null || Long.valueOf(globalServicesRepository.assocOperator177(tGMODASESORAGENCIAptptUsuarioLDAP, tGMODASESORAGENCIAptpthisAsesor)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("No puede asignar el valor de Usuario LDAP indicado porque ya existe otro usuario con dicho valor");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkIGl1475495460864793Pre2 (
            com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest request) 
            throws ModelException {
        // COUNT( Funcionario ) WHERE (Funcionario.Usuario = pt_peNumUsuario AND Funcionario.Manual = false) > 0

        String tGMODASESORAGENCIAptpeNumUsuario = request.getTGMODASESORAGENCIAptpeNumUsuario();
        try {
            boolean preconditionHolds = globalServicesRepository.assocOperator178(tGMODASESORAGENCIAptpeNumUsuario) > Long.valueOf(0);
            if (!preconditionHolds) throw new PreconditionException("El número de usuario diligenciado debe corresponderse con un número de asesor existente");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    /*
     * Entry point for global service OGCARGAVISASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse oGCARGAVISASESORES(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESRequest request) {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse();
        try {
            response = globalServicesSrv.oGCARGAVISASESORESTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGCARGAVISASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse oGCARGAVISASESORESTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGCARGAVISASESORESImplementation(request);
    }

    /*
     * Implements global service OGCARGAVISASESORES
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse oGCARGAVISASESORESImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESRequest request) throws ModelException, SystemException {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse();
        byte[] oGCARGAVISASESORESptFichero = request.getOGCARGAVISASESORESptFichero();

        request.checkArguments();

        /* Action 1: IF (1 > 2) */
        boolean ifCondition1 = Long.valueOf(1) > Long.valueOf(2);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest step10Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest();
            step10Request.setAsesorTMODVISIBILIDADpthisAsesorInstance(((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)));
            step10Request.setAsesorTMODVISIBILIDADptpVerDatosPersona(Boolean.TRUE);
            step10Request.setAsesorTMODVISIBILIDADptpVerDocsPersona(Boolean.TRUE);
            step10Request.setAsesorTMODVISIBILIDADptpVerContratoNovedad(Boolean.TRUE);
            asesorSrv.tMODVISIBILIDADImplementation(step10Request);
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESRequest step11Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESRequest();
            step11Request.setOGCARGAVISASESORESptFichero(oGCARGAVISASESORESptFichero);
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse step11Response = globalServicesSrv.oGCARGAVISASESORESImplementation(step11Request);
            response.setOGCARGAVISASESORESoaProcesados(step11Response.getOGCARGAVISASESORESoaProcesados());
            response.setOGCARGAVISASESORESoaErrores(step11Response.getOGCARGAVISASESORESoaErrores());
            response.setOGCARGAVISASESORESoaResultado(step11Response.getOGCARGAVISASESORESoaResultado());
        }
        return response;
    }

    /*
     * Entry point for global service OGCARGAPLANASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse oGCARGAPLANASESOR(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORRequest request) {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse();
        try {
            response = globalServicesSrv.oGCARGAPLANASESORTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for global service OGCARGAPLANASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse oGCARGAPLANASESORTxn(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORRequest request) throws ModelException, SystemException {
        return globalServicesSrv.oGCARGAPLANASESORImplementation(request);
    }

    /*
     * Implements global service OGCARGAPLANASESOR
     * @param request Service request viewmodel
     * @return Service response viewmodel with the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse oGCARGAPLANASESORImplementation(
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORRequest request) throws ModelException, SystemException {
        com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse response = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse();
        byte[] oGCARGAPLANASESORptFichero = request.getOGCARGAPLANASESORptFichero();

        request.checkArguments();

        /* Action 1: IF (1 > 2) */
        boolean ifCondition1 = Long.valueOf(1) > Long.valueOf(2);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest step10Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest();
            step10Request.setAsesorTCARGARDOMINIOPLANpthisAsesorInstance(((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)));
            step10Request.setAsesorTCARGARDOMINIOPLANptCodLegalProducto("");
            step10Request.setAsesorTCARGARDOMINIOPLANptCodLegalPlan("");
            step10Request.setAsesorTCARGARDOMINIOPLANptAccion("");
            asesorSrv.tCARGARDOMINIOPLANImplementation(step10Request);
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORRequest step11Request = new com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORRequest();
            step11Request.setOGCARGAPLANASESORptFichero(oGCARGAPLANASESORptFichero);
            com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse step11Response = globalServicesSrv.oGCARGAPLANASESORImplementation(step11Request);
            response.setOGCARGAPLANASESORoaProcesados(step11Response.getOGCARGAPLANASESORoaProcesados());
            response.setOGCARGAPLANASESORoaErrores(step11Response.getOGCARGAPLANASESORoaErrores());
            response.setOGCARGAPLANASESORoaResultado(step11Response.getOGCARGAPLANASESORoaResultado());
        }
        return response;
    }
}
