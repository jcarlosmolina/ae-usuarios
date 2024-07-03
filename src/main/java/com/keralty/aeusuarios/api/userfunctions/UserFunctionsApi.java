package com.keralty.aeusuarios.api.userfunctions;

import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.CuestionarioMed;
import com.keralty.aeusuarios.persistence.Departamento;
import com.keralty.aeusuarios.persistence.Direccion;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.EPS;
import com.keralty.aeusuarios.persistence.EstadoBeneficiario;
import com.keralty.aeusuarios.persistence.EstadoCivil;
import com.keralty.aeusuarios.persistence.EstadoContrato;
import com.keralty.aeusuarios.persistence.EstadoPersona;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsociado;
import com.keralty.aeusuarios.persistence.Municipio;
import com.keralty.aeusuarios.persistence.Pais;
import com.keralty.aeusuarios.persistence.Parentesco;
import com.keralty.aeusuarios.persistence.ParentescoDom;
import com.keralty.aeusuarios.persistence.Periodicidad;
import com.keralty.aeusuarios.persistence.Persona;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.PlantillaEmail;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.TipoDireccion;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.persistence.TipoIVA;
import com.keralty.aeusuarios.service.DocumentoGService;
import com.keralty.aeusuarios.service.DocumentoNovedadService;
import com.keralty.aeusuarios.service.DominioService;
import com.keralty.aeusuarios.service.ParentescoService;
import com.keralty.aeusuarios.service.PersonaCService;
import com.keralty.aeusuarios.service.PersonaService;
import com.keralty.aeusuarios.service.PlanesService;
import com.keralty.aeusuarios.service.PlantillaEmailService;
import com.keralty.aeusuarios.service.PreguntaService;
import com.keralty.aeusuarios.service.ProductosService;
import com.keralty.aeusuarios.service.ProteccionDatosService;
import com.keralty.aeusuarios.service.SolicitudService;
import com.keralty.aeusuarios.service.UsuarioService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuActualizarPersonaCORERequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuAnadirTextoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuBuscarDocGestorNumIdRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuBuscarDocGestorSolicitudRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCalcularEdadRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCalcularIMCRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCalcularIMCUsuarioRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCallSPgetsemaforoareamedRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCallSPgetsemaforograbadornovRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCallSPgetsemaforograbadorRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCallSPgetusuareamedRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCallSPgetusugrabadornovRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCallSPgetusugrabadorRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCheckRegimenSubsidiadoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuconcatenarConNulosRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuContieneCharEspecialRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuContratoExentoDocSolRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCrearPersonaCORERequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuCrearZipDocumentacionAutoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuDefaultBoolSiNullRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuDescargarDocGestorRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuEnviarEmailDevDocRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuEnviarEmailRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuEnviarSMSRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuEstadoSolicitudRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuExisteContratoExentoFIngresoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuformarListaUsuariosSinCuesRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuformarListaValoresPreguntaRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuformarMsgErrorUsrSinDocsRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuFormarTextoObservacionesRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGenerarReporteOracleRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetAgenteRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetAreaMedicaPorIdRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetAsesorRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetCodigoPersonaCORERequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetCodTarifaProdPlanAnyoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetDepartamentoCLRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetDepartamentoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetDirResidenciaPersonaRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetDominioProdPlanRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetEstadoBeneficiarioCORERequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetEstadoCivilRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetEstadoContratoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetEstadoPersonaRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetFechaFinVigenciaUsuarioRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetFInicioPlanVolRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetFuncionarioPorIdRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetFuncionarioPorLDAPRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetGrupoAsocRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetListaErroresRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetMunicipioCLRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetMunicipioRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetNombreAsesorRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetNombreFuncionarioRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPaisRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetParametrosConfiguracionRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetParentescoDominioRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetParentescoPorNombreRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetParentescoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPersonaPorTipoYNumDocRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPersonaXCodCORERequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPlanPorCLRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPlanRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPlantillaEmailRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetPrioridadRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetProductoPorCLRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetProductoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetRolRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetSolicitudByNumeroRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetSolicitudNovedadByNumRadicadoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetTextoAvisoFirmaRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetTipoDireccionRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetTipoIdentificacionRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetTipoIVARequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetTipoRegimenRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGetTokenRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetValorParametroConfRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetValorPropertyRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FugetValorTarifaSegunEdadRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuGuardarDocumentoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FulengthTextRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuObtenerDocumentoRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuSoloLetrasRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuSoloNumerosRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuStrONullRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuSubirDocGestorRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FusubstringTextRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuSustituirParamsEnURLRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuValidarDominioIncompatiblesRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuValidarEmailRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuValidarNombreRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuValidarTelefonoCelularRequest;
import com.keralty.aeusuarios.viewmodel.userfunctions.FuValidarTelefonoFijoRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import java.sql.Date;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/UserFunctionsApi")
@RequestScoped
@RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
public class UserFunctionsApi {

    @Inject
    UserFunctions service;

    @RestClient
    PreguntaService preguntaSrv;

    @Inject
    ProductosService productosSrv;

    @Inject
    PlanesService planesSrv;

    @Inject
    DominioService dominioSrv;

    @RestClient
    ParentescoService parentescoSrv;

    @Inject
    SolicitudService solicitudSrv;

    @RestClient
    DocumentoGService documentoGSrv;

    @RestClient
    DocumentoNovedadService documentoNovedadSrv;

    @RestClient
    PersonaService personaSrv;

    @RestClient
    ProteccionDatosService proteccionDatosSrv;

    @RestClient
    PersonaCService personaCSrv;

    @RestClient
    UsuarioService usuarioSrv;

    @RestClient
    PlantillaEmailService plantillaEmailSrv;

    @Inject
    public UserFunctionsApi(JsonWebToken jwt) {
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @POST
    @Path(value = "/fu_formarListaValoresPregunta")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuformarListaValoresPregunta(FuformarListaValoresPreguntaRequest request) {
        request.setPfuPreguntaInstance(preguntaSrv.getByOIDWithHV(request.getPfuPregunta()));
        return service.fuformarListaValoresPreguntaFun(request);
    }

    @POST
    @Path(value = "/fu_concatenarConNulos")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuconcatenarConNulos(FuconcatenarConNulosRequest request) {
        return service.fuconcatenarConNulosFun(request);
    }

    @POST
    @Path(value = "/fu_getTipoDirResidencial")
    public TipoDireccion fugetTipoDirResidencial() {
        return service.fugetTipoDirResidencialFun();
    }

    @POST
    @Path(value = "/fu_getTipoDirCorrespondencia")
    public TipoDireccion fugetTipoDirCorrespondencia() {
        return service.fugetTipoDirCorrespondenciaFun();
    }

    @POST
    @Path(value = "/fu_ValidarEmail")
    public Boolean fuValidarEmail(FuValidarEmailRequest request) {
        return service.fuValidarEmailFun(request);
    }

    @POST
    @Path(value = "/fu_ValidarNombre")
    public Boolean fuValidarNombre(FuValidarNombreRequest request) {
        return service.fuValidarNombreFun(request);
    }

    @POST
    @Path(value = "/fu_SoloNumeros")
    public Boolean fuSoloNumeros(FuSoloNumerosRequest request) {
        return service.fuSoloNumerosFun(request);
    }

    @POST
    @Path(value = "/fu_ContieneCharEspecial")
    public Boolean fuContieneCharEspecial(FuContieneCharEspecialRequest request) {
        return service.fuContieneCharEspecialFun(request);
    }

    @POST
    @Path(value = "/fu_getTipoIdentificacion")
    public TipoIdentificacion fugetTipoIdentificacion(FugetTipoIdentificacionRequest request) {
        return service.fugetTipoIdentificacionFun(request);
    }

    @POST
    @Path(value = "/fu_getMunicipio")
    public Municipio fugetMunicipio(FugetMunicipioRequest request) {
        return service.fugetMunicipioFun(request);
    }

    @POST
    @Path(value = "/fu_getDepartamento")
    public Departamento fugetDepartamento(FugetDepartamentoRequest request) {
        return service.fugetDepartamentoFun(request);
    }

    @POST
    @Path(value = "/fu_getEstadoCivil")
    public EstadoCivil fugetEstadoCivil(FugetEstadoCivilRequest request) {
        return service.fugetEstadoCivilFun(request);
    }

    @POST
    @Path(value = "/fu_getEstadoPersona")
    public EstadoPersona fugetEstadoPersona(FugetEstadoPersonaRequest request) {
        return service.fugetEstadoPersonaFun(request);
    }

    @POST
    @Path(value = "/fu_getTipoDireccion")
    public TipoDireccion fugetTipoDireccion(FugetTipoDireccionRequest request) {
        return service.fugetTipoDireccionFun(request);
    }

    @POST
    @Path(value = "/fu_getPais")
    public Pais fugetPais(FugetPaisRequest request) {
        return service.fugetPaisFun(request);
    }

    @POST
    @Path(value = "/fu_getProducto")
    public Productos fugetProducto(FugetProductoRequest request) {
        return service.fugetProductoFun(request);
    }

    @POST
    @Path(value = "/fu_ValidarTelefonoFijo")
    public Boolean fuValidarTelefonoFijo(FuValidarTelefonoFijoRequest request) {
        return service.fuValidarTelefonoFijoFun(request);
    }

    @POST
    @Path(value = "/fu_ValidarTelefonoCelular")
    public Boolean fuValidarTelefonoCelular(FuValidarTelefonoCelularRequest request) {
        return service.fuValidarTelefonoCelularFun(request);
    }

    @POST
    @Path(value = "/fu_StrONull")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuStrONull(FuStrONullRequest request) {
        return service.fuStrONullFun(request);
    }

    @POST
    @Path(value = "/fu_getEPSSanitas")
    public EPS fugetEPSSanitas() {
        return service.fugetEPSSanitasFun();
    }

    @POST
    @Path(value = "/fu_getParentescoTitular")
    public Parentesco fugetParentescoTitular() {
        return service.fugetParentescoTitularFun();
    }

    @POST
    @Path(value = "/fu_getParentescoConyuge")
    public Parentesco fugetParentescoConyuge() {
        return service.fugetParentescoConyugeFun();
    }

    @POST
    @Path(value = "/fu_getCuestionarioMedico")
    public CuestionarioMed fugetCuestionarioMedico() {
        return service.fugetCuestionarioMedicoFun();
    }

    @POST
    @Path(value = "/fu_getValorParametroConf")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetValorParametroConf(FugetValorParametroConfRequest request) {
        return service.fugetValorParametroConfFun(request);
    }

    @POST
    @Path(value = "/fu_getRol")
    public Rol fugetRol(FugetRolRequest request) {
        return service.fugetRolFun(request);
    }

    @POST
    @Path(value = "/fu_getPersonaXCodCORE")
    public Persona fugetPersonaXCodCORE(FugetPersonaXCodCORERequest request) {
        return service.fugetPersonaXCodCOREFun(request);
    }

    @POST
    @Path(value = "/fu_lengthText")
    public Long fulengthText(FulengthTextRequest request) {
        return service.fulengthTextFun(request);
    }

    @POST
    @Path(value = "/fu_substringText")
    @Produces(MediaType.TEXT_PLAIN)
    public String fusubstringText(FusubstringTextRequest request) {
        return service.fusubstringTextFun(request);
    }

    @POST
    @Path(value = "/fu_getParentesco")
    public Parentesco fugetParentesco(FugetParentescoRequest request) {
        return service.fugetParentescoFun(request);
    }

    @POST
    @Path(value = "/fu_getTipoIVA")
    public TipoIVA fugetTipoIVA(FugetTipoIVARequest request) {
        request.setPfuProductoInstance(productosSrv.getByOIDWithHV(request.getPfuProducto()));
        request.setPfuPlanInstance(planesSrv.getByOIDWithHV(request.getPfuPlan()));
        return service.fugetTipoIVAFun(request);
    }

    @POST
    @Path(value = "/fu_getValorTarifaSegunEdad")
    public Double fugetValorTarifaSegunEdad(FugetValorTarifaSegunEdadRequest request) {
        request.setPfuProductoInstance(productosSrv.getByOIDWithHV(request.getPfuProducto()));
        request.setPfuPlanInstance(planesSrv.getByOIDWithHV(request.getPfuPlan()));
        return service.fugetValorTarifaSegunEdadFun(request);
    }

    @POST
    @Path(value = "/fu_getDominioProdPlan")
    public Dominio fugetDominioProdPlan(FugetDominioProdPlanRequest request) {
        request.setPfuProductoInstance(productosSrv.getByOIDWithHV(request.getPfuProducto()));
        request.setPfuPlanInstance(planesSrv.getByOIDWithHV(request.getPfuPlan()));
        return service.fugetDominioProdPlanFun(request);
    }

    @POST
    @Path(value = "/fu_getPersonaPorTipoYNumDoc")
    public Persona fugetPersonaPorTipoYNumDoc(FugetPersonaPorTipoYNumDocRequest request) {
        return service.fugetPersonaPorTipoYNumDocFun(request);
    }

    @POST
    @Path(value = "/fu_getGrupoAsoc")
    public GrupoAsociado fugetGrupoAsoc(FugetGrupoAsocRequest request) {
        return service.fugetGrupoAsocFun(request);
    }

    @POST
    @Path(value = "/fu_getEstadoBeneficiarioCORE")
    public EstadoBeneficiario fugetEstadoBeneficiarioCORE(FugetEstadoBeneficiarioCORERequest request) {
        return service.fugetEstadoBeneficiarioCOREFun(request);
    }

    @POST
    @Path(value = "/fu_GuardarDocumento")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGuardarDocumento(FuGuardarDocumentoRequest request) {
        return service.fuGuardarDocumentoFun(request);
    }

    @POST
    @Path(value = "/fu_ObtenerDocumento")
    public byte[] fuObtenerDocumento(FuObtenerDocumentoRequest request) {
        return service.fuObtenerDocumentoFun(request);
    }

    @POST
    @Path(value = "/fu_getPeriodicidadMensual")
    public Periodicidad fugetPeriodicidadMensual() {
        return service.fugetPeriodicidadMensualFun();
    }

    @POST
    @Path(value = "/fu_getParentescoDominio")
    public ParentescoDom fugetParentescoDominio(FugetParentescoDominioRequest request) {
        request.setPfuDominioInstance(dominioSrv.getByOIDWithHV(request.getPfuDominio()));
        request.setPfuParentescoInstance(parentescoSrv.getByOIDWithHV(request.getPfuParentesco()));
        return service.fugetParentescoDominioFun(request);
    }

    @POST
    @Path(value = "/fu_getPlantillaEmail")
    public PlantillaEmail fugetPlantillaEmail(FugetPlantillaEmailRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fugetPlantillaEmailFun(request);
    }

    @POST
    @Path(value = "/fu_getValorProperty")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetValorProperty(FugetValorPropertyRequest request) {
        return service.fugetValorPropertyFun(request);
    }

    @POST
    @Path(value = "/fu_SustituirParamsEnURL")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuSustituirParamsEnURL(FuSustituirParamsEnURLRequest request) {
        request.setPfuSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfuSolicitud()));
        return service.fuSustituirParamsEnURLFun(request);
    }

    @POST
    @Path(value = "/fu_EnviarEmail")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEnviarEmail(FuEnviarEmailRequest request) {
        return service.fuEnviarEmailFun(request);
    }

    @POST
    @Path(value = "/fu_AnadirTexto")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuAnadirTexto(FuAnadirTextoRequest request) {
        return service.fuAnadirTextoFun(request);
    }

    @POST
    @Path(value = "/fu_getPlan")
    public Planes fugetPlan(FugetPlanRequest request) {
        return service.fugetPlanFun(request);
    }

    @POST
    @Path(value = "/fu_getEstadoContrato")
    public EstadoContrato fugetEstadoContrato(FugetEstadoContratoRequest request) {
        return service.fugetEstadoContratoFun(request);
    }

    @POST
    @Path(value = "/fu_SubirDocGestor")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuSubirDocGestor(FuSubirDocGestorRequest request) {
        request.setPfuDocumentoGInstance(documentoGSrv.getByOIDWithHV(request.getPfuDocumentoG()));
        request.setPfuDocumentoNovInstance(documentoNovedadSrv.getByOIDWithHV(request.getPfuDocumentoNov()));
        return service.fuSubirDocGestorFun(request);
    }

    @POST
    @Path(value = "/fu_DescargarDocGestor")
    public byte[] fuDescargarDocGestor(FuDescargarDocGestorRequest request) {
        return service.fuDescargarDocGestorFun(request);
    }

    @POST
    @Path(value = "/fu_formarListaUsuariosSinCues")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuformarListaUsuariosSinCues(FuformarListaUsuariosSinCuesRequest request) {
        request.setPfuSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfuSolicitud()));
        return service.fuformarListaUsuariosSinCuesFun(request);
    }

    @POST
    @Path(value = "/fu_getDepartamentoCL")
    public Departamento fugetDepartamentoCL(FugetDepartamentoCLRequest request) {
        return service.fugetDepartamentoCLFun(request);
    }

    @POST
    @Path(value = "/fu_getSolicitudByNumero")
    public Solicitud fugetSolicitudByNumero(FugetSolicitudByNumeroRequest request) {
        return service.fugetSolicitudByNumeroFun(request);
    }

    @POST
    @Path(value = "/fu_getAgente")
    public Funcionario fugetAgente(FugetAgenteRequest request) {
        return service.fugetAgenteFun(request);
    }

    @POST
    @Path(value = "/fu_BuscarDocGestorNumId")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuBuscarDocGestorNumId(FuBuscarDocGestorNumIdRequest request) {
        return service.fuBuscarDocGestorNumIdFun(request);
    }

    @POST
    @Path(value = "/fu_BuscarDocGestorSolicitud")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuBuscarDocGestorSolicitud(FuBuscarDocGestorSolicitudRequest request) {
        return service.fuBuscarDocGestorSolicitudFun(request);
    }

    @POST
    @Path(value = "/fu_DefaultBoolSiNull")
    public Boolean fuDefaultBoolSiNull(FuDefaultBoolSiNullRequest request) {
        return service.fuDefaultBoolSiNullFun(request);
    }

    @POST
    @Path(value = "/fu_SoloLetras")
    public Boolean fuSoloLetras(FuSoloLetrasRequest request) {
        return service.fuSoloLetrasFun(request);
    }

    @POST
    @Path(value = "/fu_GetTextoProteccionDatos")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetTextoProteccionDatos() {
        return service.fuGetTextoProteccionDatosFun();
    }

    @POST
    @Path(value = "/fu_getAsesor")
    public Asesor fugetAsesor(FugetAsesorRequest request) {
        return service.fugetAsesorFun(request);
    }

    @POST
    @Path(value = "/fu_getMunicipioCL")
    public Municipio fugetMunicipioCL(FugetMunicipioCLRequest request) {
        return service.fugetMunicipioCLFun(request);
    }

    @POST
    @Path(value = "/fu_GetDirResidenciaPersona")
    public Direccion fuGetDirResidenciaPersona(FuGetDirResidenciaPersonaRequest request) {
        request.setPfPersonaInstance(personaSrv.getByOIDWithHV(request.getPfPersona()));
        return service.fuGetDirResidenciaPersonaFun(request);
    }

    @POST
    @Path(value = "/fu_GetTextoAvisoFirma")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetTextoAvisoFirma(FuGetTextoAvisoFirmaRequest request) {
        return service.fuGetTextoAvisoFirmaFun(request);
    }

    @POST
    @Path(value = "/fu_getTipoRegimen")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetTipoRegimen(FugetTipoRegimenRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fugetTipoRegimenFun(request);
    }

    @POST
    @Path(value = "/fu_getListaErrores")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetListaErrores(FugetListaErroresRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fugetListaErroresFun(request);
    }

    @POST
    @Path(value = "/fu_CrearPersonaCORE")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuCrearPersonaCORE(FuCrearPersonaCORERequest request) {
        request.setPfPersonaInstance(personaSrv.getByOIDWithHV(request.getPfPersona()));
        request.setPfProtDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getPfProtDatos()));
        return service.fuCrearPersonaCOREFun(request);
    }

    @POST
    @Path(value = "/fu_ActualizarPersonaCORE")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuActualizarPersonaCORE(FuActualizarPersonaCORERequest request) {
        request.setPfPersonaInstance(personaSrv.getByOIDWithHV(request.getPfPersona()));
        request.setPfProtDatosInstance(proteccionDatosSrv.getByOIDWithHV(request.getPfProtDatos()));
        return service.fuActualizarPersonaCOREFun(request);
    }

    @POST
    @Path(value = "/fuCrearZipDocumentacionAuto")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuCrearZipDocumentacionAuto(FuCrearZipDocumentacionAutoRequest request) {
        request.setPsSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPsSolicitud()));
        return service.fuCrearZipDocumentacionAutoFun(request);
    }

    @POST
    @Path(value = "/fu_GetCodTarifaProdPlanAnyo")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetCodTarifaProdPlanAnyo(FuGetCodTarifaProdPlanAnyoRequest request) {
        request.setPfProductoInstance(productosSrv.getByOIDWithHV(request.getPfProducto()));
        request.setPfPlanInstance(planesSrv.getByOIDWithHV(request.getPfPlan()));
        return service.fuGetCodTarifaProdPlanAnyoFun(request);
    }

    @POST
    @Path(value = "/fu_getParentescoPorNombre")
    public Parentesco fugetParentescoPorNombre(FugetParentescoPorNombreRequest request) {
        return service.fugetParentescoPorNombreFun(request);
    }

    @POST
    @Path(value = "/fu_getProductoPorCL")
    public Productos fugetProductoPorCL(FugetProductoPorCLRequest request) {
        return service.fugetProductoPorCLFun(request);
    }

    @POST
    @Path(value = "/fu_getPlanPorCL")
    public Planes fugetPlanPorCL(FugetPlanPorCLRequest request) {
        return service.fugetPlanPorCLFun(request);
    }

    @POST
    @Path(value = "/fu_getFuncionarioPorLDAP")
    public Funcionario fugetFuncionarioPorLDAP(FugetFuncionarioPorLDAPRequest request) {
        return service.fugetFuncionarioPorLDAPFun(request);
    }

    @POST
    @Path(value = "/fuFormarTextoObservaciones")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuFormarTextoObservaciones(FuFormarTextoObservacionesRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fuFormarTextoObservacionesFun(request);
    }

    @POST
    @Path(value = "/fuGetCodigoPersonaCORE")
    public Long fuGetCodigoPersonaCORE(FuGetCodigoPersonaCORERequest request) {
        return service.fuGetCodigoPersonaCOREFun(request);
    }

    @POST
    @Path(value = "/fuGetFechaFinVigenciaUsuario")
    public Date fuGetFechaFinVigenciaUsuario(FuGetFechaFinVigenciaUsuarioRequest request) {
        return service.fuGetFechaFinVigenciaUsuarioFun(request);
    }

    @POST
    @Path(value = "/fuGetNombreAsesor")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetNombreAsesor(FuGetNombreAsesorRequest request) {
        return service.fuGetNombreAsesorFun(request);
    }

    @POST
    @Path(value = "/fuGetNombreFuncionario")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetNombreFuncionario(FuGetNombreFuncionarioRequest request) {
        return service.fuGetNombreFuncionarioFun(request);
    }

    @POST
    @Path(value = "/fuCalcularEdad")
    public Long fuCalcularEdad(FuCalcularEdadRequest request) {
        return service.fuCalcularEdadFun(request);
    }

    @POST
    @Path(value = "/fu_formarMsgErrorUsrSinDocs")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuformarMsgErrorUsrSinDocs(FuformarMsgErrorUsrSinDocsRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fuformarMsgErrorUsrSinDocsFun(request);
    }

    @POST
    @Path(value = "/fu_EnviarEmailDevDoc")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEnviarEmailDevDoc(FuEnviarEmailDevDocRequest request) {
        return service.fuEnviarEmailDevDocFun(request);
    }

    @POST
    @Path(value = "/fu_ContratoExentoDocSol")
    public Boolean fuContratoExentoDocSol(FuContratoExentoDocSolRequest request) {
        return service.fuContratoExentoDocSolFun(request);
    }

    @POST
    @Path(value = "/fu_EstadoSolicitud")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEstadoSolicitud(FuEstadoSolicitudRequest request) {
        return service.fuEstadoSolicitudFun(request);
    }

    @POST
    @Path(value = "/fuGenerarReporteOracle")
    public byte[] fuGenerarReporteOracle(FuGenerarReporteOracleRequest request) {
        return service.fuGenerarReporteOracleFun(request);
    }

    @POST
    @Path(value = "/fuCalcularIMC")
    public Double fuCalcularIMC(FuCalcularIMCRequest request) {
        request.setPfPersonaCInstance(personaCSrv.getByOIDWithHV(request.getPfPersonaC()));
        return service.fuCalcularIMCFun(request);
    }

    @POST
    @Path(value = "/fu_GetEstadoPersonaError")
    public EstadoBeneficiario fuGetEstadoPersonaError() {
        return service.fuGetEstadoPersonaErrorFun();
    }

    @POST
    @Path(value = "/fuCalcularIMCUsuario")
    public Double fuCalcularIMCUsuario(FuCalcularIMCUsuarioRequest request) {
        request.setPfUsuarioInstance(usuarioSrv.getByOIDWithHV(request.getPfUsuario()));
        return service.fuCalcularIMCUsuarioFun(request);
    }

    @POST
    @Path(value = "/fu_EnviarSMS")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEnviarSMS(FuEnviarSMSRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        request.setPfPlantillaInstance(plantillaEmailSrv.getByOIDWithHV(request.getPfPlantilla()));
        return service.fuEnviarSMSFun(request);
    }

    @POST
    @Path(value = "/fu_getFuncionarioPorId")
    public Funcionario fugetFuncionarioPorId(FugetFuncionarioPorIdRequest request) {
        return service.fugetFuncionarioPorIdFun(request);
    }

    @POST
    @Path(value = "/fuCallSPgetusugrabador")
    public Long fuCallSPgetusugrabador(FuCallSPgetusugrabadorRequest request) {
        return service.fuCallSPgetusugrabadorFun(request);
    }

    @POST
    @Path(value = "/fuCallSPgetusugrabadornov")
    public Long fuCallSPgetusugrabadornov(FuCallSPgetusugrabadornovRequest request) {
        return service.fuCallSPgetusugrabadornovFun(request);
    }

    @POST
    @Path(value = "/fuCallSPgetusuareamed")
    public Long fuCallSPgetusuareamed(FuCallSPgetusuareamedRequest request) {
        return service.fuCallSPgetusuareamedFun(request);
    }

    @POST
    @Path(value = "/fu_getAreaMedicaPorId")
    public AreaMedica fugetAreaMedicaPorId(FugetAreaMedicaPorIdRequest request) {
        return service.fugetAreaMedicaPorIdFun(request);
    }

    @POST
    @Path(value = "/fugetPrioridad")
    public Long fugetPrioridad(FugetPrioridadRequest request) {
        return service.fugetPrioridadFun(request);
    }

    @POST
    @Path(value = "/fuCallSPgetsemaforograbador")
    public Double fuCallSPgetsemaforograbador(FuCallSPgetsemaforograbadorRequest request) {
        return service.fuCallSPgetsemaforograbadorFun(request);
    }

    @POST
    @Path(value = "/fuCallSPgetsemaforograbadornov")
    public Double fuCallSPgetsemaforograbadornov(FuCallSPgetsemaforograbadornovRequest request) {
        return service.fuCallSPgetsemaforograbadornovFun(request);
    }

    @POST
    @Path(value = "/fuCallSPgetsemaforoareamed")
    public Double fuCallSPgetsemaforoareamed(FuCallSPgetsemaforoareamedRequest request) {
        return service.fuCallSPgetsemaforoareamedFun(request);
    }

    @POST
    @Path(value = "/fu_getSolicitudNovedadByNumRadicado")
    public SolicitudNovedad fugetSolicitudNovedadByNumRadicado(FugetSolicitudNovedadByNumRadicadoRequest request) {
        return service.fugetSolicitudNovedadByNumRadicadoFun(request);
    }

    @POST
    @Path(value = "/fuGetFechaDesdeVarFiltro")
    public Date fuGetFechaDesdeVarFiltro() {
        return service.fuGetFechaDesdeVarFiltroFun();
    }

    @POST
    @Path(value = "/fuCheckRegimenSubsidiado")
    public Long fuCheckRegimenSubsidiado(FuCheckRegimenSubsidiadoRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fuCheckRegimenSubsidiadoFun(request);
    }

    @POST
    @Path(value = "/fuGetFInicioPlanVol")
    public Date fuGetFInicioPlanVol(FuGetFInicioPlanVolRequest request) {
        return service.fuGetFInicioPlanVolFun(request);
    }

    @POST
    @Path(value = "/fuValidarDominioIncompatibles")
    public Boolean fuValidarDominioIncompatibles(FuValidarDominioIncompatiblesRequest request) {
        request.setPfSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getPfSolicitud()));
        return service.fuValidarDominioIncompatiblesFun(request);
    }

    @POST
    @Path(value = "/fuExisteContratoExentoFIngreso")
    public Boolean fuExisteContratoExentoFIngreso(FuExisteContratoExentoFIngresoRequest request) {
        return service.fuExisteContratoExentoFIngresoFun(request);
    }

    @POST
    @Path(value = "/fuGetFechaLimiteDescargaDoc")
    public Date fuGetFechaLimiteDescargaDoc() {
        return service.fuGetFechaLimiteDescargaDocFun();
    }

    @POST
    @Path(value = "/fuGetToken")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetToken(FuGetTokenRequest request) {
        return service.fuGetTokenFun(request);
    }

    @POST
    @Path(value = "/fuGetParametrosConfiguracion")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetParametrosConfiguracion(FuGetParametrosConfiguracionRequest request) {
        return service.fuGetParametrosConfiguracionFun(request);
    }
}
