package com.keralty.aeusuarios.global;

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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * User functions proxy
 */
@Path("/api/UserFunctionsApi")
@RegisterRestClient(configKey="ae-apigateway")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeapigateway}")
public interface UserFunctionsProxy {

    /** 
     * Method that solves the fuformarListaValoresPregunta user function.
     *
     * @param "pfuPregunta" This parameter represents the pfuPregunta inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_formarListaValoresPregunta")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuformarListaValoresPreguntaFun(FuformarListaValoresPreguntaRequest request);

    /** 
     * Method that solves the fuconcatenarConNulos user function.
     *
     * @param "pfuPrefijo" This parameter represents the pfuPrefijo inbound argument.
     *
     * @param "pfuString" This parameter represents the pfuString inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_concatenarConNulos")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuconcatenarConNulosFun(FuconcatenarConNulosRequest request);

    /** 
     * Method that solves the fugetTipoDirResidencial user function.
     *
     * @return Return TipoDireccion value of the User Function
     */
    @POST
    @Path(value = "/fu_getTipoDirResidencial")
    public TipoDireccion fugetTipoDirResidencialFun();

    /** 
     * Method that solves the fugetTipoDirCorrespondencia user function.
     *
     * @return Return TipoDireccion value of the User Function
     */
    @POST
    @Path(value = "/fu_getTipoDirCorrespondencia")
    public TipoDireccion fugetTipoDirCorrespondenciaFun();

    /** 
     * Method that solves the fuValidarEmail user function.
     *
     * @param "pfuEmail" This parameter represents the pfuEmail inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_ValidarEmail")
    public java.lang.Boolean fuValidarEmailFun(FuValidarEmailRequest request);

    /** 
     * Method that solves the fuValidarNombre user function.
     *
     * @param "pfuNombre" This parameter represents the pfuNombre inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_ValidarNombre")
    public java.lang.Boolean fuValidarNombreFun(FuValidarNombreRequest request);

    /** 
     * Method that solves the fuSoloNumeros user function.
     *
     * @param "pfuNumero" This parameter represents the pfuNumero inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_SoloNumeros")
    public java.lang.Boolean fuSoloNumerosFun(FuSoloNumerosRequest request);

    /** 
     * Method that solves the fuContieneCharEspecial user function.
     *
     * @param "pfustring" This parameter represents the pfustring inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_ContieneCharEspecial")
    public java.lang.Boolean fuContieneCharEspecialFun(FuContieneCharEspecialRequest request);

    /** 
     * Method that solves the fugetTipoIdentificacion user function.
     *
     * @param "pfuNombreCorto" This parameter represents the pfuNombreCorto inbound argument.
     *
     * @return Return TipoIdentificacion value of the User Function
     */
    @POST
    @Path(value = "/fu_getTipoIdentificacion")
    public TipoIdentificacion fugetTipoIdentificacionFun(FugetTipoIdentificacionRequest request);

    /** 
     * Method that solves the fugetMunicipio user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return Municipio value of the User Function
     */
    @POST
    @Path(value = "/fu_getMunicipio")
    public Municipio fugetMunicipioFun(FugetMunicipioRequest request);

    /** 
     * Method that solves the fugetDepartamento user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return Departamento value of the User Function
     */
    @POST
    @Path(value = "/fu_getDepartamento")
    public Departamento fugetDepartamentoFun(FugetDepartamentoRequest request);

    /** 
     * Method that solves the fugetEstadoCivil user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoCivil value of the User Function
     */
    @POST
    @Path(value = "/fu_getEstadoCivil")
    public EstadoCivil fugetEstadoCivilFun(FugetEstadoCivilRequest request);

    /** 
     * Method that solves the fugetEstadoPersona user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoPersona value of the User Function
     */
    @POST
    @Path(value = "/fu_getEstadoPersona")
    public EstadoPersona fugetEstadoPersonaFun(FugetEstadoPersonaRequest request);

    /** 
     * Method that solves the fugetTipoDireccion user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return TipoDireccion value of the User Function
     */
    @POST
    @Path(value = "/fu_getTipoDireccion")
    public TipoDireccion fugetTipoDireccionFun(FugetTipoDireccionRequest request);

    /** 
     * Method that solves the fugetPais user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return Pais value of the User Function
     */
    @POST
    @Path(value = "/fu_getPais")
    public Pais fugetPaisFun(FugetPaisRequest request);

    /** 
     * Method that solves the fugetProducto user function.
     *
     * @param "pfuNumero" This parameter represents the pfuNumero inbound argument.
     *
     * @return Return Productos value of the User Function
     */
    @POST
    @Path(value = "/fu_getProducto")
    public Productos fugetProductoFun(FugetProductoRequest request);

    /** 
     * Method that solves the fuValidarTelefonoFijo user function.
     *
     * @param "pfuTelefonoFijo" This parameter represents the pfuTelefonoFijo inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_ValidarTelefonoFijo")
    public java.lang.Boolean fuValidarTelefonoFijoFun(FuValidarTelefonoFijoRequest request);

    /** 
     * Method that solves the fuValidarTelefonoCelular user function.
     *
     * @param "pfuTelefonoCelular" This parameter represents the pfuTelefonoCelular inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_ValidarTelefonoCelular")
    public java.lang.Boolean fuValidarTelefonoCelularFun(FuValidarTelefonoCelularRequest request);

    /** 
     * Method that solves the fuStrONull user function.
     *
     * @param "pfuNumero" This parameter represents the pfuNumero inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_StrONull")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuStrONullFun(FuStrONullRequest request);

    /** 
     * Method that solves the fugetEPSSanitas user function.
     *
     * @return Return EPS value of the User Function
     */
    @POST
    @Path(value = "/fu_getEPSSanitas")
    public EPS fugetEPSSanitasFun();

    /** 
     * Method that solves the fugetParentescoTitular user function.
     *
     * @return Return Parentesco value of the User Function
     */
    @POST
    @Path(value = "/fu_getParentescoTitular")
    public Parentesco fugetParentescoTitularFun();

    /** 
     * Method that solves the fugetParentescoConyuge user function.
     *
     * @return Return Parentesco value of the User Function
     */
    @POST
    @Path(value = "/fu_getParentescoConyuge")
    public Parentesco fugetParentescoConyugeFun();

    /** 
     * Method that solves the fugetCuestionarioMedico user function.
     *
     * @return Return CuestionarioMed value of the User Function
     */
    @POST
    @Path(value = "/fu_getCuestionarioMedico")
    public CuestionarioMed fugetCuestionarioMedicoFun();

    /** 
     * Method that solves the fugetValorParametroConf user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_getValorParametroConf")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetValorParametroConfFun(FugetValorParametroConfRequest request);

    /** 
     * Method that solves the fugetRol user function.
     *
     * @param "pfuNombre" This parameter represents the pfuNombre inbound argument.
     *
     * @return Return Rol value of the User Function
     */
    @POST
    @Path(value = "/fu_getRol")
    public Rol fugetRolFun(FugetRolRequest request);

    /** 
     * Method that solves the fugetPersonaXCodCORE user function.
     *
     * @param "pfucodigo" This parameter represents the pfucodigo inbound argument.
     *
     * @return Return Persona value of the User Function
     */
    @POST
    @Path(value = "/fu_getPersonaXCodCORE")
    public Persona fugetPersonaXCodCOREFun(FugetPersonaXCodCORERequest request);

    /** 
     * Method that solves the fulengthText user function.
     *
     * @param "pfuTexto" This parameter represents the pfuTexto inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fu_lengthText")
    public java.lang.Long fulengthTextFun(FulengthTextRequest request);

    /** 
     * Method that solves the fusubstringText user function.
     *
     * @param "pfuText" This parameter represents the pfuText inbound argument.
     *
     * @param "pfuDesde" This parameter represents the pfuDesde inbound argument.
     *
     * @param "pfuHasta" This parameter represents the pfuHasta inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_substringText")
    @Produces(MediaType.TEXT_PLAIN)
    public String fusubstringTextFun(FusubstringTextRequest request);

    /** 
     * Method that solves the fugetParentesco user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return Parentesco value of the User Function
     */
    @POST
    @Path(value = "/fu_getParentesco")
    public Parentesco fugetParentescoFun(FugetParentescoRequest request);

    /** 
     * Method that solves the fugetTipoIVA user function.
     *
     * @param "pfuProducto" This parameter represents the pfuProducto inbound argument.
     *
     * @param "pfuPlan" This parameter represents the pfuPlan inbound argument.
     *
     * @param "pfuFecha" This parameter represents the pfuFecha inbound argument.
     *
     * @return Return TipoIVA value of the User Function
     */
    @POST
    @Path(value = "/fu_getTipoIVA")
    public TipoIVA fugetTipoIVAFun(FugetTipoIVARequest request);

    /** 
     * Method that solves the fugetValorTarifaSegunEdad user function.
     *
     * @param "pfuProducto" This parameter represents the pfuProducto inbound argument.
     *
     * @param "pfuPlan" This parameter represents the pfuPlan inbound argument.
     *
     * @param "pfuEdad" This parameter represents the pfuEdad inbound argument.
     *
     * @param "pfuTipoContrato" This parameter represents the pfuTipoContrato inbound argument.
     *
     * @param "pfuVieneTraslado" This parameter represents the pfuVieneTraslado inbound argument.
     *
     * @param "pfuFechaContratacion" This parameter represents the pfuFechaContratacion inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @POST
    @Path(value = "/fu_getValorTarifaSegunEdad")
    public java.lang.Double fugetValorTarifaSegunEdadFun(FugetValorTarifaSegunEdadRequest request);

    /** 
     * Method that solves the fugetDominioProdPlan user function.
     *
     * @param "pfuProducto" This parameter represents the pfuProducto inbound argument.
     *
     * @param "pfuPlan" This parameter represents the pfuPlan inbound argument.
     *
     * @return Return Dominio value of the User Function
     */
    @POST
    @Path(value = "/fu_getDominioProdPlan")
    public Dominio fugetDominioProdPlanFun(FugetDominioProdPlanRequest request);

    /** 
     * Method that solves the fugetPersonaPorTipoYNumDoc user function.
     *
    * @param Nombre corto
     *
     * @param "pfuNumDoc" This parameter represents the pfuNumDoc inbound argument.
     *
     * @return Return Persona value of the User Function
     */
    @POST
    @Path(value = "/fu_getPersonaPorTipoYNumDoc")
    public Persona fugetPersonaPorTipoYNumDocFun(FugetPersonaPorTipoYNumDocRequest request);

    /** 
     * Method that solves the fugetGrupoAsoc user function.
     *
     * @param "pfuCodioLegal" This parameter represents the pfuCodioLegal inbound argument.
     *
     * @return Return GrupoAsociado value of the User Function
     */
    @POST
    @Path(value = "/fu_getGrupoAsoc")
    public GrupoAsociado fugetGrupoAsocFun(FugetGrupoAsocRequest request);

    /** 
     * Method that solves the fugetEstadoBeneficiarioCORE user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoBeneficiario value of the User Function
     */
    @POST
    @Path(value = "/fu_getEstadoBeneficiarioCORE")
    public EstadoBeneficiario fugetEstadoBeneficiarioCOREFun(FugetEstadoBeneficiarioCORERequest request);

    /** 
     * Method that solves the fuGuardarDocumento user function.
     *
     * @param "pDocumento" This parameter represents the pDocumento inbound argument.
     *
     * @param "pNombreDoc" This parameter represents the pNombreDoc inbound argument.
     *
     * @param "pPathParcial" This parameter represents the pPathParcial inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_GuardarDocumento")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGuardarDocumentoFun(FuGuardarDocumentoRequest request);

    /** 
     * Method that solves the fuObtenerDocumento user function.
     *
     * @param "pPathCompleto" This parameter represents the pPathCompleto inbound argument.
     *
     * @return Return byte[] value of the User Function
     */
    @POST
    @Path(value = "/fu_ObtenerDocumento")
    public byte[] fuObtenerDocumentoFun(FuObtenerDocumentoRequest request);

    /** 
     * Method that solves the fugetPeriodicidadMensual user function.
     *
     * @return Return Periodicidad value of the User Function
     */
    @POST
    @Path(value = "/fu_getPeriodicidadMensual")
    public Periodicidad fugetPeriodicidadMensualFun();

    /** 
     * Method that solves the fugetParentescoDominio user function.
     *
     * @param "pfuDominio" This parameter represents the pfuDominio inbound argument.
     *
     * @param "pfuParentesco" This parameter represents the pfuParentesco inbound argument.
     *
     * @return Return ParentescoDom value of the User Function
     */
    @POST
    @Path(value = "/fu_getParentescoDominio")
    public ParentescoDom fugetParentescoDominioFun(FugetParentescoDominioRequest request);

    /** 
     * Method that solves the fugetPlantillaEmail user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return PlantillaEmail value of the User Function
     */
    @POST
    @Path(value = "/fu_getPlantillaEmail")
    public PlantillaEmail fugetPlantillaEmailFun(FugetPlantillaEmailRequest request);

    /** 
     * Method that solves the fugetValorProperty user function.
     *
     * @param "pfuNombreProperty" This parameter represents the pfuNombreProperty inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_getValorProperty")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetValorPropertyFun(FugetValorPropertyRequest request);

    /** 
     * Method that solves the fuSustituirParamsEnURL user function.
     *
    * @param Valor sacado del fichero de propiedades
     *
     * @param "pfuSolicitud" This parameter represents the pfuSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_SustituirParamsEnURL")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuSustituirParamsEnURLFun(FuSustituirParamsEnURLRequest request);

    /** 
     * Method that solves the fuEnviarEmail user function.
     *
     * @param "pfuAsunto" This parameter represents the pfuAsunto inbound argument.
     *
     * @param "pfuDestinatario" This parameter represents the pfuDestinatario inbound argument.
     *
     * @param "pfuEmailConfirmacion" This parameter represents the pfuEmailConfirmacion inbound argument.
     *
     * @param "pfuCuerpo" This parameter represents the pfuCuerpo inbound argument.
     *
    * @param Si se manda un adjunto, el nombre del adjunto
     *
    * @param Si hay adjunto, el adjunto
     *
    * @param El número de la solicitud en el marco de la cual se envía el email (si es en el marco de una solicitud).
    * GdC37, para el log
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_EnviarEmail")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEnviarEmailFun(FuEnviarEmailRequest request);

    /** 
     * Method that solves the fuAnadirTexto user function.
     *
     * @param "pfuTexto" This parameter represents the pfuTexto inbound argument.
     *
     * @param "pfuAnadir" This parameter represents the pfuAnadir inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_AnadirTexto")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuAnadirTextoFun(FuAnadirTextoRequest request);

    /** 
     * Method that solves the fugetPlan user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return Planes value of the User Function
     */
    @POST
    @Path(value = "/fu_getPlan")
    public Planes fugetPlanFun(FugetPlanRequest request);

    /** 
     * Method that solves the fugetEstadoContrato user function.
     *
     * @param "pfuCodigo" This parameter represents the pfuCodigo inbound argument.
     *
     * @return Return EstadoContrato value of the User Function
     */
    @POST
    @Path(value = "/fu_getEstadoContrato")
    public EstadoContrato fugetEstadoContratoFun(FugetEstadoContratoRequest request);

    /** 
     * Method that solves the fuSubirDocGestor user function.
     *
     * @param "pfuDocumento" This parameter represents the pfuDocumento inbound argument.
     *
    * @param Le pasamos la clase documentoG que se ha creado porque ahí tenemos toda la información de la solicitud la persona y todo, por que no sabemos que metadatos habrá que pasar
     *
    * @param Le pasamos la clase documentoNovedad si se ha subido el documento desde novedad
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_SubirDocGestor")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuSubirDocGestorFun(FuSubirDocGestorRequest request);

    /** 
     * Method that solves the fuDescargarDocGestor user function.
     *
     * @param "pfuIdDoc" This parameter represents the pfuIdDoc inbound argument.
     *
    * @param GdC-37 Id de solicitud o de solicitud de novedad en el marco de la cual se solicita la descarga
     *
     * @return Return byte[] value of the User Function
     */
    @POST
    @Path(value = "/fu_DescargarDocGestor")
    public byte[] fuDescargarDocGestorFun(FuDescargarDocGestorRequest request);

    /** 
     * Method that solves the fuformarListaUsuariosSinCues user function.
     *
     * @param "pfuSolicitud" This parameter represents the pfuSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_formarListaUsuariosSinCues")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuformarListaUsuariosSinCuesFun(FuformarListaUsuariosSinCuesRequest request);

    /** 
     * Method that solves the fugetDepartamentoCL user function.
     *
    * @param Código legal del departamento
     *
     * @return Return Departamento value of the User Function
     */
    @POST
    @Path(value = "/fu_getDepartamentoCL")
    public Departamento fugetDepartamentoCLFun(FugetDepartamentoCLRequest request);

    /** 
     * Method that solves the fugetSolicitudByNumero user function.
     *
     * @param "pfuNumSolicitud" This parameter represents the pfuNumSolicitud inbound argument.
     *
     * @return Return Solicitud value of the User Function
     */
    @POST
    @Path(value = "/fu_getSolicitudByNumero")
    public Solicitud fugetSolicitudByNumeroFun(FugetSolicitudByNumeroRequest request);

    /** 
     * Method that solves the fugetAgente user function.
     *
     * @param "pfuLogin" This parameter represents the pfuLogin inbound argument.
     *
     * @return Return Funcionario value of the User Function
     */
    @POST
    @Path(value = "/fu_getAgente")
    public Funcionario fugetAgenteFun(FugetAgenteRequest request);

    /** 
     * Method that solves the fuBuscarDocGestorNumId user function.
     *
     * @param "pfuNumIdentificacion" This parameter represents the pfuNumIdentificacion inbound argument.
     *
    * @param GdC37: Nº de solicitud en el marco de la cual se realiza la búsqueda. Para log.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_BuscarDocGestorNumId")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuBuscarDocGestorNumIdFun(FuBuscarDocGestorNumIdRequest request);

    /** 
     * Method that solves the fuBuscarDocGestorSolicitud user function.
     *
     * @param "pfuNumSolicitud" This parameter represents the pfuNumSolicitud inbound argument.
     *
     * @param "pfuNumIdentidad" This parameter represents the pfuNumIdentidad inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_BuscarDocGestorSolicitud")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuBuscarDocGestorSolicitudFun(FuBuscarDocGestorSolicitudRequest request);

    /** 
     * Method that solves the fuDefaultBoolSiNull user function.
     *
     * @param "pfubool" This parameter represents the pfubool inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_DefaultBoolSiNull")
    public java.lang.Boolean fuDefaultBoolSiNullFun(FuDefaultBoolSiNullRequest request);

    /** 
     * Method that solves the fuSoloLetras user function.
     *
     * @param "pfuNumero" This parameter represents the pfuNumero inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_SoloLetras")
    public java.lang.Boolean fuSoloLetrasFun(FuSoloLetrasRequest request);

    /** 
     * Method that solves the fuGetTextoProteccionDatos user function.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_GetTextoProteccionDatos")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetTextoProteccionDatosFun();

    /** 
     * Method that solves the fugetAsesor user function.
     *
     * @param "pfuUsuario" This parameter represents the pfuUsuario inbound argument.
     *
     * @return Return Asesor value of the User Function
     */
    @POST
    @Path(value = "/fu_getAsesor")
    public Asesor fugetAsesorFun(FugetAsesorRequest request);

    /** 
     * Method that solves the fugetMunicipioCL user function.
     *
     * @param "pfCodLegal" This parameter represents the pfCodLegal inbound argument.
     *
     * @return Return Municipio value of the User Function
     */
    @POST
    @Path(value = "/fu_getMunicipioCL")
    public Municipio fugetMunicipioCLFun(FugetMunicipioCLRequest request);

    /** 
     * Method that solves the fuGetDirResidenciaPersona user function.
     *
     * @param "pfPersona" This parameter represents the pfPersona inbound argument.
     *
     * @return Return Direccion value of the User Function
     */
    @POST
    @Path(value = "/fu_GetDirResidenciaPersona")
    public Direccion fuGetDirResidenciaPersonaFun(FuGetDirResidenciaPersonaRequest request);

    /** 
     * Method that solves the fuGetTextoAvisoFirma user function.
     *
    * @param Indica si es el texto para la primera (1) o la segunda (2) firma
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_GetTextoAvisoFirma")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetTextoAvisoFirmaFun(FuGetTextoAvisoFirmaRequest request);

    /** 
     * Method that solves the fugetTipoRegimen user function.
     *
    * @param Tipo de identificación (nombre corto)
     *
    * @param Nº de identificación
     *
    * @param GdC-37: Log de llamadas a WS del CORE
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_getTipoRegimen")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetTipoRegimenFun(FugetTipoRegimenRequest request);

    /** 
     * Method that solves the fugetListaErrores user function.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_getListaErrores")
    @Produces(MediaType.TEXT_PLAIN)
    public String fugetListaErroresFun(FugetListaErroresRequest request);

    /** 
     * Method that solves the fuCrearPersonaCORE user function.
     *
     * @param "pfPersona" This parameter represents the pfPersona inbound argument.
     *
     * @param "pfProtDatos" This parameter represents the pfProtDatos inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_CrearPersonaCORE")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuCrearPersonaCOREFun(FuCrearPersonaCORERequest request);

    /** 
     * Method that solves the fuActualizarPersonaCORE user function.
     *
     * @param "pfPersona" This parameter represents the pfPersona inbound argument.
     *
     * @param "pfProtDatos" This parameter represents the pfProtDatos inbound argument.
     *
    * @param GdC 37: El número de solicitud en el marco de la cual llamamos a esta fu, para hacer log.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_ActualizarPersonaCORE")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuActualizarPersonaCOREFun(FuActualizarPersonaCORERequest request);

    /** 
     * Method that solves the fuCrearZipDocumentacionAuto user function.
     *
     * @param "psSolicitud" This parameter represents the psSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fuCrearZipDocumentacionAuto")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuCrearZipDocumentacionAutoFun(FuCrearZipDocumentacionAutoRequest request);

    /** 
     * Method that solves the fuGetCodTarifaProdPlanAnyo user function.
     *
     * @param "pfProducto" This parameter represents the pfProducto inbound argument.
     *
     * @param "pfPlan" This parameter represents the pfPlan inbound argument.
     *
     * @param "pfAnyo" This parameter represents the pfAnyo inbound argument.
     *
     * @param "pfTipoContrato" This parameter represents the pfTipoContrato inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_GetCodTarifaProdPlanAnyo")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetCodTarifaProdPlanAnyoFun(FuGetCodTarifaProdPlanAnyoRequest request);

    /** 
     * Method that solves the fugetParentescoPorNombre user function.
     *
     * @param "pfNombreCorto" This parameter represents the pfNombreCorto inbound argument.
     *
     * @return Return Parentesco value of the User Function
     */
    @POST
    @Path(value = "/fu_getParentescoPorNombre")
    public Parentesco fugetParentescoPorNombreFun(FugetParentescoPorNombreRequest request);

    /** 
     * Method that solves the fugetProductoPorCL user function.
     *
     * @param "pfCodLegalProd" This parameter represents the pfCodLegalProd inbound argument.
     *
     * @return Return Productos value of the User Function
     */
    @POST
    @Path(value = "/fu_getProductoPorCL")
    public Productos fugetProductoPorCLFun(FugetProductoPorCLRequest request);

    /** 
     * Method that solves the fugetPlanPorCL user function.
     *
     * @param "pfCodLegalPlan" This parameter represents the pfCodLegalPlan inbound argument.
     *
     * @return Return Planes value of the User Function
     */
    @POST
    @Path(value = "/fu_getPlanPorCL")
    public Planes fugetPlanPorCLFun(FugetPlanPorCLRequest request);

    /** 
     * Method that solves the fugetFuncionarioPorLDAP user function.
     *
     * @param "pfUsuLDAP" This parameter represents the pfUsuLDAP inbound argument.
     *
     * @return Return Funcionario value of the User Function
     */
    @POST
    @Path(value = "/fu_getFuncionarioPorLDAP")
    public Funcionario fugetFuncionarioPorLDAPFun(FugetFuncionarioPorLDAPRequest request);

    /** 
     * Method that solves the fuFormarTextoObservaciones user function.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fuFormarTextoObservaciones")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuFormarTextoObservacionesFun(FuFormarTextoObservacionesRequest request);

    /** 
     * Method that solves the fuGetCodigoPersonaCORE user function.
     *
     * @param "tipoId" This parameter represents the tipoId inbound argument.
     *
     * @param "numId" This parameter represents the numId inbound argument.
     *
    * @param GdC 37: El número de solicitud en el marco de la cual se llama a esta fu. Para hacer log.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fuGetCodigoPersonaCORE")
    public java.lang.Long fuGetCodigoPersonaCOREFun(FuGetCodigoPersonaCORERequest request);

    /** 
     * Method that solves the fuGetFechaFinVigenciaUsuario user function.
     *
     * @param "pfTipoIdentificacion" This parameter represents the pfTipoIdentificacion inbound argument.
     *
     * @param "pfNumIdentificacion" This parameter represents the pfNumIdentificacion inbound argument.
     *
    * @param GcD-37 Log llamadas a BH con el Num solicitud
     *
     * @return Return java.sql.Date value of the User Function
     */
    @POST
    @Path(value = "/fuGetFechaFinVigenciaUsuario")
    public java.sql.Date fuGetFechaFinVigenciaUsuarioFun(FuGetFechaFinVigenciaUsuarioRequest request);

    /** 
     * Method that solves the fuGetNombreAsesor user function.
     *
     * @param "pfUsuario" This parameter represents the pfUsuario inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fuGetNombreAsesor")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetNombreAsesorFun(FuGetNombreAsesorRequest request);

    /** 
     * Method that solves the fuGetNombreFuncionario user function.
     *
     * @param "pfUsuario" This parameter represents the pfUsuario inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fuGetNombreFuncionario")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetNombreFuncionarioFun(FuGetNombreFuncionarioRequest request);

    /** 
     * Method that solves the fuCalcularEdad user function.
     *
     * @param "pfFechaNacimiento" This parameter represents the pfFechaNacimiento inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fuCalcularEdad")
    public java.lang.Long fuCalcularEdadFun(FuCalcularEdadRequest request);

    /** 
     * Method that solves the fuformarMsgErrorUsrSinDocs user function.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_formarMsgErrorUsrSinDocs")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuformarMsgErrorUsrSinDocsFun(FuformarMsgErrorUsrSinDocsRequest request);

    /** 
     * Method that solves the fuEnviarEmailDevDoc user function.
     *
     * @param "pfAsunto" This parameter represents the pfAsunto inbound argument.
     *
     * @param "pfCuerpo" This parameter represents the pfCuerpo inbound argument.
     *
     * @param "pfDestinatario" This parameter represents the pfDestinatario inbound argument.
     *
     * @param "pfEmailConf" This parameter represents the pfEmailConf inbound argument.
     *
     * @param "ptObservaciones" This parameter represents the ptObservaciones inbound argument.
     *
    * @param GdC 37, si el email se envía en el marco de una solicitud, el número de la misma
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_EnviarEmailDevDoc")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEnviarEmailDevDocFun(FuEnviarEmailDevDocRequest request);

    /** 
     * Method that solves the fuContratoExentoDocSol user function.
     *
     * @param "pfNumContrato" This parameter represents the pfNumContrato inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fu_ContratoExentoDocSol")
    public java.lang.Boolean fuContratoExentoDocSolFun(FuContratoExentoDocSolRequest request);

    /** 
     * Method that solves the fuEstadoSolicitud user function.
     *
     * @param "pfEstadoSol" This parameter represents the pfEstadoSol inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_EstadoSolicitud")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEstadoSolicitudFun(FuEstadoSolicitudRequest request);

    /** 
     * Method that solves the fuGenerarReporteOracle user function.
     *
     * @param "pfNombreReporte" This parameter represents the pfNombreReporte inbound argument.
     *
     * @param "pfUsuario" This parameter represents the pfUsuario inbound argument.
     *
     * @param "pfParametros" This parameter represents the pfParametros inbound argument.
     *
     * @return Return byte[] value of the User Function
     */
    @POST
    @Path(value = "/fuGenerarReporteOracle")
    public byte[] fuGenerarReporteOracleFun(FuGenerarReporteOracleRequest request);

    /** 
     * Method that solves the fuCalcularIMC user function.
     *
     * @param "pfPersonaC" This parameter represents the pfPersonaC inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @POST
    @Path(value = "/fuCalcularIMC")
    public java.lang.Double fuCalcularIMCFun(FuCalcularIMCRequest request);

    /** 
     * Method that solves the fuGetEstadoPersonaError user function.
     *
     * @return Return EstadoBeneficiario value of the User Function
     */
    @POST
    @Path(value = "/fu_GetEstadoPersonaError")
    public EstadoBeneficiario fuGetEstadoPersonaErrorFun();

    /** 
     * Method that solves the fuCalcularIMCUsuario user function.
     *
     * @param "pfUsuario" This parameter represents the pfUsuario inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @POST
    @Path(value = "/fuCalcularIMCUsuario")
    public java.lang.Double fuCalcularIMCUsuarioFun(FuCalcularIMCUsuarioRequest request);

    /** 
     * Method that solves the fuEnviarSMS user function.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @param "pfNumCelulcar" This parameter represents the pfNumCelulcar inbound argument.
     *
     * @param "pfPlantilla" This parameter represents the pfPlantilla inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fu_EnviarSMS")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuEnviarSMSFun(FuEnviarSMSRequest request);

    /** 
     * Method that solves the fugetFuncionarioPorId user function.
     *
     * @param "pfIdFuncionario" This parameter represents the pfIdFuncionario inbound argument.
     *
     * @return Return Funcionario value of the User Function
     */
    @POST
    @Path(value = "/fu_getFuncionarioPorId")
    public Funcionario fugetFuncionarioPorIdFun(FugetFuncionarioPorIdRequest request);

    /** 
     * Method that solves the fuCallSPgetusugrabador user function.
     *
     * @param "pfIdSolicitud" This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fuCallSPgetusugrabador")
    public java.lang.Long fuCallSPgetusugrabadorFun(FuCallSPgetusugrabadorRequest request);

    /** 
     * Method that solves the fuCallSPgetusugrabadornov user function.
     *
     * @param "pfIdSolcitudNov" This parameter represents the pfIdSolcitudNov inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fuCallSPgetusugrabadornov")
    public java.lang.Long fuCallSPgetusugrabadornovFun(FuCallSPgetusugrabadornovRequest request);

    /** 
     * Method that solves the fuCallSPgetusuareamed user function.
     *
     * @param "pfIdSolicitud" This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fuCallSPgetusuareamed")
    public java.lang.Long fuCallSPgetusuareamedFun(FuCallSPgetusuareamedRequest request);

    /** 
     * Method that solves the fugetAreaMedicaPorId user function.
     *
     * @param "pfIdAreaMedica" This parameter represents the pfIdAreaMedica inbound argument.
     *
     * @return Return AreaMedica value of the User Function
     */
    @POST
    @Path(value = "/fu_getAreaMedicaPorId")
    public AreaMedica fugetAreaMedicaPorIdFun(FugetAreaMedicaPorIdRequest request);

    /** 
     * Method that solves the fugetPrioridad user function.
     *
     * @param "pfEstadoSol" This parameter represents the pfEstadoSol inbound argument.
     *
     * @param "pfEstadoDoc" This parameter represents the pfEstadoDoc inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fugetPrioridad")
    public java.lang.Long fugetPrioridadFun(FugetPrioridadRequest request);

    /** 
     * Method that solves the fuCallSPgetsemaforograbador user function.
     *
     * @param "pfIdSolicitud" This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @POST
    @Path(value = "/fuCallSPgetsemaforograbador")
    public java.lang.Double fuCallSPgetsemaforograbadorFun(FuCallSPgetsemaforograbadorRequest request);

    /** 
     * Method that solves the fuCallSPgetsemaforograbadornov user function.
     *
     * @param "pfIdSolcitudNov" This parameter represents the pfIdSolcitudNov inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @POST
    @Path(value = "/fuCallSPgetsemaforograbadornov")
    public java.lang.Double fuCallSPgetsemaforograbadornovFun(FuCallSPgetsemaforograbadornovRequest request);

    /** 
     * Method that solves the fuCallSPgetsemaforoareamed user function.
     *
     * @param "pfIdSolicitud" This parameter represents the pfIdSolicitud inbound argument.
     *
     * @return Return java.lang.Double value of the User Function
     */
    @POST
    @Path(value = "/fuCallSPgetsemaforoareamed")
    public java.lang.Double fuCallSPgetsemaforoareamedFun(FuCallSPgetsemaforoareamedRequest request);

    /** 
     * Method that solves the fugetSolicitudNovedadByNumRadicado user function.
     *
     * @param "pfNumRadicado" This parameter represents the pfNumRadicado inbound argument.
     *
     * @return Return SolicitudNovedad value of the User Function
     */
    @POST
    @Path(value = "/fu_getSolicitudNovedadByNumRadicado")
    public SolicitudNovedad fugetSolicitudNovedadByNumRadicadoFun(FugetSolicitudNovedadByNumRadicadoRequest request);

    /** 
     * Method that solves the fuGetFechaDesdeVarFiltro user function.
     *
     * @return Return java.sql.Date value of the User Function
     */
    @POST
    @Path(value = "/fuGetFechaDesdeVarFiltro")
    public java.sql.Date fuGetFechaDesdeVarFiltroFun();

    /** 
     * Method that solves the fuCheckRegimenSubsidiado user function.
     *
     * @param "pfTipoId" This parameter represents the pfTipoId inbound argument.
     *
     * @param "pfNumId" This parameter represents the pfNumId inbound argument.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return java.lang.Long value of the User Function
     */
    @POST
    @Path(value = "/fuCheckRegimenSubsidiado")
    public java.lang.Long fuCheckRegimenSubsidiadoFun(FuCheckRegimenSubsidiadoRequest request);

    /** 
     * Method that solves the fuGetFInicioPlanVol user function.
     *
     * @param "pfTipoTramite" This parameter represents the pfTipoTramite inbound argument.
     *
     * @param "pfTipoContrato" This parameter represents the pfTipoContrato inbound argument.
     *
     * @param "pfFecha" This parameter represents the pfFecha inbound argument.
     *
     * @return Return java.sql.Date value of the User Function
     */
    @POST
    @Path(value = "/fuGetFInicioPlanVol")
    public java.sql.Date fuGetFInicioPlanVolFun(FuGetFInicioPlanVolRequest request);

    /** 
     * Method that solves the fuValidarDominioIncompatibles user function.
     *
     * @param "pfTipoId" This parameter represents the pfTipoId inbound argument.
     *
     * @param "pfNumId" This parameter represents the pfNumId inbound argument.
     *
     * @param "pfFechaInicioVigencia" This parameter represents the pfFechaInicioVigencia inbound argument.
     *
     * @param "pfSolicitud" This parameter represents the pfSolicitud inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fuValidarDominioIncompatibles")
    public java.lang.Boolean fuValidarDominioIncompatiblesFun(FuValidarDominioIncompatiblesRequest request);

    /** 
     * Method that solves the fuExisteContratoExentoFIngreso user function.
     *
     * @param "vfNumContrato" This parameter represents the vfNumContrato inbound argument.
     *
     * @return Return java.lang.Boolean value of the User Function
     */
    @POST
    @Path(value = "/fuExisteContratoExentoFIngreso")
    public java.lang.Boolean fuExisteContratoExentoFIngresoFun(FuExisteContratoExentoFIngresoRequest request);

    /** 
     * Method that solves the fuGetFechaLimiteDescargaDoc user function.
     *
     * @return Return java.sql.Date value of the User Function
     */
    @POST
    @Path(value = "/fuGetFechaLimiteDescargaDoc")
    public java.sql.Date fuGetFechaLimiteDescargaDocFun();

    /** 
     * Method that solves the fuGetToken user function.
     *
     * @param "pfTipo" This parameter represents the pfTipo inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fuGetToken")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetTokenFun(FuGetTokenRequest request);

    /** 
     * Method that solves the fuGetParametrosConfiguracion user function.
     *
     * @param "pfListaParametros" This parameter represents the pfListaParametros inbound argument.
     *
     * @return Return String value of the User Function
     */
    @POST
    @Path(value = "/fuGetParametrosConfiguracion")
    @Produces(MediaType.TEXT_PLAIN)
    public String fuGetParametrosConfiguracionFun(FuGetParametrosConfiguracionRequest request);
}
