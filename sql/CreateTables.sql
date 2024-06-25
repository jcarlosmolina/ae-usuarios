CREATE TABLE TM_ValorPregunta(Identificador INT NOT NULL, Numero INT NOT NULL);
CREATE TABLE TM_DominioPeriodicidad(Numero INT NOT NULL, Codigo INT NOT NULL);
CREATE TABLE TM_DominioRol(Numero INT NOT NULL, Identificador INT NOT NULL);
CREATE TABLE TM_DominioFormaPago(Numero INT NOT NULL, Codigo INT NOT NULL);
CREATE TABLE TM_DominiosPlantillas(Numero INT NOT NULL, IdPlantilla INT NOT NULL);
CREATE TABLE TM_DominioNovedad(Numero INT NOT NULL, id_Novedad INT NOT NULL);
CREATE TABLE TM_IncompatibilidadesDominio(Numero INT NOT NULL, DominiosIncompatibles_Numero INT NOT NULL);
CREATE TABLE TM_DirSucursalCTipoSucursalC(Codigo INT NOT NULL, TiposSucursalC_Codigo INT NOT NULL);
CREATE TABLE TM_AfiliacionesPlanes(Id INT NOT NULL, Plan INT NOT NULL);
CREATE TABLE TM_AgentexProductoDominio(Id INT NOT NULL, AgentexProducto_Id INT NOT NULL, Numero INT NOT NULL);
CREATE TABLE TM_ReportesProcAlmFuncionario(id_Reporte INT NOT NULL, Id INT NOT NULL);
CREATE TABLE TM_GrupoAsignacionFuncionario(Id INT NOT NULL, Funcionario_Id INT NOT NULL);
CREATE TABLE Funcionario(Id INT IDENTITY, Identificador INT NOT NULL, Codigo INT NOT NULL, PassWord VARCHAR(128) NOT NULL, Manual BIT NOT NULL, Usuario VARCHAR(20) NOT NULL, PrimerNombre VARCHAR(50) NOT NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, UsuarioLDAP VARCHAR(50) NULL, Email VARCHAR(100) NULL, CodJefe VARCHAR(20) NULL, Disponible BIT NOT NULL, NumSolNoTerminadas INT NOT NULL);
CREATE TABLE Admin(Id INT NOT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE SuperAdmin(Id INT NOT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE Asesor(Id INT NOT NULL, Codigo INT NULL, PassWord VARCHAR(128) NOT NULL, ModDBasicosPersona BIT NOT NULL, modificaDirector BIT NOT NULL, esDirector BIT NOT NULL, NumIdentificacion VARCHAR(60) NULL, EsIntegral BIT NOT NULL, VerDBasicosPersona BIT NOT NULL, VerDocIdentificacionPersona BIT NOT NULL, VerContratoNovedad BIT NOT NULL, CanalComercial VARCHAR(50) NULL, Cargo VARCHAR(50) NULL, Estado VARCHAR(50) NULL, AccesoValidadorUsuarios BIT NOT NULL);
CREATE TABLE AreaMedica(Id INT NOT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE Afiliaciones(Id INT NOT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE RespRegional(Id INT NOT NULL, Codigo INT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE Gestor(Id INT NOT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE MesaDeApoyo(Id INT NOT NULL, PassWord VARCHAR(128) NOT NULL);
CREATE TABLE ParamConfig(Codigo VARCHAR(50) NOT NULL, Descripcion VARCHAR(255) NOT NULL, Valor VARCHAR(999) NOT NULL, EsNumerico BIT NOT NULL);
CREATE TABLE LogParam(Codigo INT IDENTITY, ParamConfig_Codigo VARCHAR(50) NOT NULL, Fecha DATETIME NOT NULL, Usuario VARCHAR(20) NOT NULL, NombreUsuario VARCHAR(255) NOT NULL, ValorAnterior VARCHAR(999) NOT NULL, NuevoValor VARCHAR(999) NOT NULL);
CREATE TABLE FrecuenciaAct(Codigo INT IDENTITY, Parametrica INT NOT NULL, Frecuencia INT NOT NULL, FechaUltimaSinc DATETIME NULL, ResultadoSinc VARCHAR(255) NULL, Usuario VARCHAR(20) NULL, NombreUsuario VARCHAR(255) NULL);
CREATE TABLE CuestionarioMed(Numero INT IDENTITY, Nombre VARCHAR(100) NOT NULL);
CREATE TABLE Seccion(Identificador INT IDENTITY, Numero INT NOT NULL, Nombre VARCHAR(150) NOT NULL, NumOrden INT NOT NULL);
CREATE TABLE Pregunta(Numero INT NOT NULL, Identificador INT NOT NULL, NumOrden INT NOT NULL, Descripcion VARCHAR(255) NOT NULL, ValorSNObliga BIT NOT NULL, ObsOblig BIT NOT NULL, EsNumero BIT NOT NULL, ValorMax DECIMAL(19,6) NULL, ValorMin DECIMAL(19,6) NULL, SoloHombres BIT NOT NULL, SoloMujeres BIT NOT NULL, RespMultiple BIT NOT NULL, SeEnviaAlCORE BIT NOT NULL, CondicionEdad INT NOT NULL, CondicionEdadAnyos INT NULL);
CREATE TABLE Valor(Identificador INT IDENTITY, ValorPosible VARCHAR(150) NOT NULL);
CREATE TABLE Productos(Producto INT NOT NULL, Descripcion VARCHAR(100) NOT NULL, CodAnexoMat INT NULL, CodAnexoNeo INT NULL, NIT VARCHAR(60) NULL, CodigoLegal VARCHAR(10) NOT NULL, FechaDocSolicitud DATETIME NULL);
CREATE TABLE Planes(Plan INT NOT NULL, Producto INT NOT NULL, Nombre VARCHAR(150) NOT NULL, EsBancoRep BIT NOT NULL, CodigoLegal VARCHAR(10) NOT NULL, AceptaPreexistencias BIT NOT NULL, EsVoluntario BIT NOT NULL, InicioContDiaUno BIT NOT NULL);
CREATE TABLE Parentesco(Codigo INT NOT NULL, Descripcion VARCHAR(100) NOT NULL, EsTitular BIT NOT NULL, EsConyuge BIT NOT NULL, EsPadre BIT NOT NULL, EsHijo BIT NOT NULL, NombreCorto VARCHAR(10) NOT NULL);
CREATE TABLE Periodicidad(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, EsMensual BIT NOT NULL);
CREATE TABLE Rol(Identificador INT IDENTITY, Nombre VARCHAR(50) NOT NULL);
CREATE TABLE Dominio(Numero INT IDENTITY, Plan INT NOT NULL, Producto INT NOT NULL, Id INT NULL, GrupoAreaMedica_Id INT NULL, ReqCuesMed BIT NOT NULL, NoCuesMedTras BIT NOT NULL, NuevaAfiliacion BIT NOT NULL, Inclusion BIT NOT NULL, AcepCuesMat BIT NOT NULL, AcepCuesNeo BIT NOT NULL, AcepBBGestante BIT NOT NULL, MostrarPreexAnexos BIT NOT NULL, MostrarPreexContrato BIT NOT NULL, IgnorarPreexistencias BIT NOT NULL, RespClauNombre VARCHAR(100) NULL, RespClauCelula VARCHAR(15) NULL, RespClauExpCelula VARCHAR(50) NULL, RespClauCargo VARCHAR(50) NULL, RespClauFirma IMAGE NULL, DiaIniVigencia INT NULL, DiaFinVigencia INT NULL, DiasCaducidad INT NOT NULL, ProrrateoUsuExistente BIT NOT NULL, InclusionModGrupoAsoc BIT NOT NULL, PermiteRechazadosAfi BIT NOT NULL, AcepPolizaInter BIT NOT NULL, NovExcepcionReqDoc BIT NOT NULL, SolNovColorOscuro VARCHAR(10) NULL, SolNovColorClaro VARCHAR(10) NULL, SolNovLogo VARCHAR(50) NULL, TramiteEnLinea BIT NOT NULL, VigenciaRadicacion BIT NOT NULL);
CREATE TABLE PlantillaEmail(IdPlantilla INT IDENTITY, Codigo INT NOT NULL, Descripcion VARCHAR(255) NOT NULL, Asunto VARCHAR(255) NULL, TextoMensaje TEXT NOT NULL, EmailConf VARCHAR(100) NULL);
CREATE TABLE EstadoContrato(Codigo INT NOT NULL, Descripcion VARCHAR(100) NOT NULL);
CREATE TABLE EstadoBeneficiario(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, EsActivo BIT NOT NULL, Confirmado BIT NOT NULL, EsError BIT NOT NULL);
CREATE TABLE EstadoBeneficiarioAE(Codigo INT IDENTITY, EstadoBeneficiarioCORE_Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE Tarifa(Id INT IDENTITY, Producto INT NOT NULL, Plan INT NOT NULL, Codigo VARCHAR(12) NOT NULL, TipoContrato INT NOT NULL);
CREATE TABLE Regional(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE Sucursal(Codigo INT NOT NULL, Regional_Codigo INT NOT NULL, Descripcion VARCHAR(200) NOT NULL);
CREATE TABLE GrupoAsociado(Codigo INT NOT NULL, Producto INT NOT NULL, Plan INT NOT NULL, CodigoLegal VARCHAR(50) NOT NULL, CodTarifaCORE VARCHAR(50) NULL, Descripcion VARCHAR(150) NOT NULL, FIniVigencia DATETIME NOT NULL, FFinVigencia DATETIME NOT NULL, Estado INT NOT NULL, DisminucionCarencia INT NOT NULL);
CREATE TABLE EstadoCivil(Codigo INT NOT NULL, Descripcion VARCHAR(100) NOT NULL, NombreCorto VARCHAR(50) NOT NULL);
CREATE TABLE Departamento(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, CodigoLegal VARCHAR(5) NOT NULL);
CREATE TABLE TipoIVA(Codigo INT IDENTITY, Producto INT NOT NULL, Plan INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, Porcentaje DECIMAL(19,6) NOT NULL, FechaInicio DATETIME NOT NULL, FechaFin DATETIME NOT NULL);
CREATE TABLE Persona(Identificador INT IDENTITY, TipoIdentificacion_Codigo INT NOT NULL, DepartamentoNacimiento_Codigo INT NULL, MunicipioNacimiento_Codigo INT NULL, EstadoCivil_Codigo INT NULL, EstadoPersona_Codigo INT NULL, Codigo INT NULL, NumIdentificacion VARCHAR(60) NOT NULL, TipoPersona VARCHAR(1) NOT NULL, PrimerNombre VARCHAR(50) NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, RazonSocial VARCHAR(254) NULL, FechaNacimiento DATETIME NULL, Genero VARCHAR(1) NULL, IndicadorExtranjero BIT NULL, TelefonoFijo VARCHAR(15) NULL, TelefonoCelular VARCHAR(15) NULL, CorreoElectronico VARCHAR(100) NULL, TieneEPSSanitas BIT NULL, RechazadoAfiliacion VARCHAR(50) NULL, DatosBasicosMod BIT NOT NULL);
CREATE TABLE Companyia(Codigo INT NOT NULL, Nombre VARCHAR(150) NOT NULL, EsDeMP BIT NOT NULL);
CREATE TABLE Municipio(Codigo INT NOT NULL, Departamento_Codigo INT NULL, Descripcion VARCHAR(150) NOT NULL, CodigoLegal VARCHAR(10) NOT NULL, EsValidoEPS BIT NOT NULL, AplicaIVA BIT NOT NULL);
CREATE TABLE TipoDireccion(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, EsResidencia BIT NOT NULL, EsCorrespondencia BIT NOT NULL);
CREATE TABLE EstadoPersona(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, UnBeneficiarioDistino BIT NOT NULL, ProhibidoBeneficiarios BIT NOT NULL, ProhibidoContratante BIT NOT NULL, ProhibidoTitular BIT NOT NULL);
CREATE TABLE FormaPago(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, AbrirURL BIT NOT NULL, EsVisible BIT NOT NULL);
CREATE TABLE TipoIdentificacion(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, NombreCorto VARCHAR(20) NOT NULL, ValidoContratante BIT NOT NULL, ValidoTitular BIT NOT NULL, Diplomatico BIT NOT NULL, NIT BIT NOT NULL, HijoDe BIT NOT NULL, RequiereEPS BIT NOT NULL, MenorSinIdentificar BIT NOT NULL, EsPasaporte BIT NOT NULL, VisibleValidadorUsu BIT NOT NULL);
CREATE TABLE EPS(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL, EPSSanitas BIT NOT NULL);
CREATE TABLE EntidadFinancieraC(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE TipoEntidadC(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE TipoInstitucionC(Codigo INT NOT NULL, Nombre VARCHAR(150) NOT NULL);
CREATE TABLE AE_SOLICITUDES(ID_SOLICITUD INT IDENTITY, Producto INT NOT NULL, Plan INT NULL, Codigo INT NULL, NUMERO_SOLICITUD VARCHAR(50) NULL, SW_ESTADO VARCHAR(2) NULL, FECHA_ASIGNACION DATETIME NOT NULL, CDMOTANU VARCHAR(250) NULL, CDMOTDEV VARCHAR(250) NULL, FESOLICI DATETIME NULL, LOGIN VARCHAR(20) NULL, OBSERVACION VARCHAR(500) NULL, TIPO_SOLICITUD VARCHAR(1) NULL);
CREATE TABLE Solicitud(ID_SOLICITUD INT NOT NULL, Identificador INT NULL, TitularPersona_Identificador INT NULL, Codigo INT NULL, Id INT NOT NULL, FormaPago_Codigo INT NULL, Periodicidad_Codigo INT NULL, ContratoC_ID INT NULL, UsrAreaMedica_Id INT NULL, TipoFactura_Codigo VARCHAR(20) NULL, UsrAfiliacion_Id INT NULL, NumRadicado INT NOT NULL, Tramite INT NOT NULL, NumContrato VARCHAR(50) NULL, FInicioContrato DATETIME NULL, EsTraslado BIT NOT NULL, tipoContrato INT NOT NULL, codigoSucursalRad VARCHAR(200) NULL, contratoConFirma BIT NOT NULL, observacions VARCHAR(700) NULL, exentoIVA VARCHAR(50) NULL, valorCuota DECIMAL(19,6) NULL, valorDtoComercialSim DECIMAL(19,6) NULL, ValorCuotaInscrip DECIMAL(19,6) NULL, ValorDtoFinanciero DECIMAL(19,6) NULL, ValorDtoComercial DECIMAL(19,6) NULL, datosPagoOK BIT NOT NULL, valorCuotaPeriodoC DECIMAL(19,6) NULL, descuentoComercialC DECIMAL(19,6) NULL, IVAC DECIMAL(19,6) NULL, descuentoFinancieroC DECIMAL(19,6) NULL, TieneDifLiquidacion BIT NOT NULL, UsuariosValidados BIT NOT NULL, NumContratoInclusion VARCHAR(50) NULL, NumFamilia VARCHAR(5) NULL, EmailURLPagoEnviado VARCHAR(999) NULL, EmailDocuEnviado VARCHAR(999) NULL, DocsEnviados BIT NULL, codDirector VARCHAR(20) NOT NULL, valorCuotaBrutaC DECIMAL(19,6) NULL, CodTarifa VARCHAR(50) NULL, Completada BIT NOT NULL, Estado INT NOT NULL, FIniVigContInc DATETIME NULL, PorcentajeProrrateo DECIMAL(19,6) NULL, GrupoDelCORE INT NULL, TipoFacturaCORE VARCHAR(20) NULL, ResultSMSInfoPago VARCHAR(999) NULL, FechaCompletada DATETIME NULL, FechaUltimoDoc DATETIME NULL, Prioridad INT NOT NULL, FechaTerminada DATETIME NULL, FechaFUG DATETIME NULL, FechaFA DATETIME NULL, FechaFAAM DATETIME NULL, SemaforoGrabAse DECIMAL(19,6) NULL, SemaforoAreaMed DECIMAL(19,6) NULL, EstadoDoc INT NOT NULL, EnvioCarnetFisico BIT NOT NULL);
CREATE TABLE PersonaC(ID INT IDENTITY, TipoInstitucionC_Codigo INT NULL, TipoEntidadC_Codigo INT NULL, EstadoCivilC_Codigo INT NULL, EstadoPersonaC_Codigo INT NULL, TipoIdentificacionC_Codigo INT NOT NULL, MunicipioCNac_Codigo INT NULL, DepartamentoCNac_Codigo INT NULL, ContratosC_ID INT NULL, FamiliasC_ID INT NULL, FamiliasC_ID_1 INT NULL, BeneficiariosC_ID INT NULL, BeneficiariosC_ID_1 INT NULL, Codigo INT NULL, NumIdentificacion VARCHAR(60) NOT NULL, Mail VARCHAR(100) NULL, PrimerNombre VARCHAR(50) NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, FechaNacimiento DATETIME NULL, Genero VARCHAR(1) NULL, IndicadorExtranjero BIT NULL, RazonSocial VARCHAR(254) NULL, TieneEPSSanitas BIT NULL, RechazadoAfiliacion VARCHAR(50) NULL, NombreCompleto VARCHAR(100) NULL, UltimaActualizacion DATETIME NULL);
CREATE TABLE DireccionC(Codigo INT IDENTITY, ID INT NULL, ContratoC_ID INT NULL, TipoDireccionC_Codigo INT NULL, DepartamentoC_Codigo INT NULL, MunicipioC_Codigo INT NULL, PaisC_Codigo VARCHAR(10) NULL, DireccionCompleta VARCHAR(250) NULL, Localidad VARCHAR(50) NULL);
CREATE TABLE TelefonoC(ID INT IDENTITY, DirSucursalC_Codigo INT NULL, DireccionC_Codigo INT NULL, Codigo INT NOT NULL, Telefono VARCHAR(15) NULL, IndicativoPais VARCHAR(10) NULL, CodigoArea VARCHAR(10) NULL, Ext VARCHAR(10) NULL);
CREATE TABLE ProteccionDatosC(ID INT NOT NULL, Producto INT NOT NULL, Codigo INT NOT NULL, CodRol VARCHAR(2) NULL, InformacionSaludSMS BIT NULL, InformacionSaludEmail BIT NULL, IinformacionSaludCorreo BIT NULL, InformacionPublicidadSMS BIT NULL, InformacionPublicidadEmail BIT NULL, InformacionPublicidadCorreo BIT NULL, InformacionTerceros BIT NULL, Rol VARCHAR(50) NULL);
CREATE TABLE Direccion(Identificador INT IDENTITY, Persona_Identificador INT NULL, TipoDireccion_Codigo INT NULL, Municipio_Codigo INT NULL, Departamento_Codigo INT NULL, Pais_Codigo VARCHAR(10) NULL, ID_SOLICITUD INT NULL, Titular_ID_SOLICITUD INT NULL, Codigo INT NULL, DireccionCompleta VARCHAR(250) NULL, Rural BIT NULL);
CREATE TABLE Pais(Codigo VARCHAR(10) NOT NULL, Descripcion VARCHAR(50) NULL);
CREATE TABLE ProteccionDatos(Identificador INT IDENTITY, Producto INT NULL, ID_SOLICITUD INT NULL, Rol VARCHAR(2) NULL, SaludSMS BIT NULL, SaludEmail BIT NULL, SaludCorreo BIT NULL, PublicidadSMS BIT NULL, PublicidadEmail BIT NULL, PublicidadCorreo BIT NULL, InfoTerceros BIT NULL);
CREATE TABLE Usuario(ID_SOLICITUD INT NOT NULL, Identificador INT NOT NULL, UsuarioPersona_Identificador INT NOT NULL, Codigo INT NULL, Parentesco_Codigo INT NULL, Companyia_Codigo INT NULL, TipoIdentificacion_Codigo INT NOT NULL, EstadoBeneficiario_Codigo INT NULL, BebeGestante BIT NOT NULL, NumUsuario INT NULL, NumIdentificacion VARCHAR(60) NOT NULL, CodigoTipoUsuario INT NOT NULL, PrimerNombre VARCHAR(50) NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, attrUsuarioDiligenciados BIT NOT NULL, codigoBancoRep VARCHAR(30) NULL, UsuarioReplicado BIT NOT NULL, FechaAntiguedadBeneficiario DATETIME NULL, RequierExamenMedico BIT NULL, EstadoMedico INT NULL, ValorCuotaInscripcion DECIMAL(19,6) NULL, TienePreexistencias BIT NULL, FechaInicioVigencia DATETIME NULL, FechaFinVigencia DATETIME NULL, tieneDocIdentificacion BIT NOT NULL, tieneDocsSolicitud BIT NOT NULL, PolizaInternacional BIT NOT NULL, IMC DECIMAL(19,6) NULL);
CREATE TABLE CuestionarioP(Numero INT IDENTITY, ID_SOLICITUD INT NOT NULL, Identificador INT NOT NULL, Nombre VARCHAR(100) NOT NULL, YaDiligenciado BIT NOT NULL);
CREATE TABLE SeccionP(Identificador INT IDENTITY, Numero INT NOT NULL, Nombre VARCHAR(150) NOT NULL, NumOrden INT NOT NULL);
CREATE TABLE PreguntaP(Identificador INT IDENTITY, Seccion_Identificador INT NOT NULL, Pregunta_Numero INT NULL, Numero INT NOT NULL, NumOrden INT NOT NULL, Descripcion VARCHAR(255) NOT NULL, SeEnviaACORE BIT NOT NULL, RespuestaSiNo BIT NOT NULL, RespuestaObs VARCHAR(999) NULL, VieneDeCORE BIT NOT NULL, ValoresRespuestas VARCHAR(999) NULL);
CREATE TABLE Contratante(ID_SOLICITUD INT NOT NULL, TipoIdentificacion_Codigo INT NOT NULL, DepartamentoNac_Codigo INT NULL, MunicipioNac_Codigo INT NULL, DepartamentoRes_Codigo INT NULL, MunicipioRes_Codigo INT NULL, Codigo INT NULL, NumIdentificacion VARCHAR(60) NOT NULL, TipoPersona VARCHAR(1) NOT NULL, PrimerNombre VARCHAR(50) NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, RazonSocial VARCHAR(254) NULL, FechaNacimiento DATETIME NULL, Genero VARCHAR(1) NULL, IndicadorExtranjero BIT NULL, TelefonoFijo VARCHAR(15) NULL, TelefonoCelular VARCHAR(15) NULL, CorreoElectronico VARCHAR(100) NULL, TitularConBeneficios BIT NOT NULL, Diplomatico BIT NOT NULL, DireccionRes VARCHAR(250) NULL, TelefonoFijoRes VARCHAR(15) NULL, TelefonoCelularRes VARCHAR(15) NULL, RuralDirRes BIT NULL, TitularConBeneficiosCORE BIT NOT NULL, DireccionesModificadas BIT NOT NULL);
CREATE TABLE AnexoMat(Identificador INT IDENTITY, ID_SOLICITUD INT NOT NULL, Usuario_Identificador INT NOT NULL, Codigo INT NOT NULL, InstitucionMaternal_Codigo VARCHAR(20) NOT NULL, FechaUltRegla DATETIME NOT NULL, NumCuotas INT NOT NULL);
CREATE TABLE AnexoNeo(Identificador INT IDENTITY, ID_SOLICITUD INT NOT NULL, Usuario_Identificador INT NOT NULL, Codigo INT NOT NULL, InstitucionNeonatal_Codigo VARCHAR(20) NOT NULL, FechaUltRegla DATETIME NOT NULL, NumHijos INT NOT NULL, NumCuotas INT NOT NULL);
CREATE TABLE Firma(Identificador INT IDENTITY, ID_SOLICITUD INT NULL, SolicitudSegunda_ID_SOLICITUD INT NULL, Id INT NULL, SolicitudContratante_ID_SOLICI INT NULL, ImagenFirma IMAGE NULL, Latitud VARCHAR(25) NULL, Longitud VARCHAR(25) NULL);
CREATE TABLE ContratoC(ID INT IDENTITY, Codigo INT NULL, FormaPagoC_Codigo INT NULL, EstadoContratoC_Codigo INT NULL, Producto INT NOT NULL, Plan INT NOT NULL, TarifaC_Id INT NULL, GrupoAsociadoC_Codigo INT NULL, MunicipioC_Codigo INT NULL, SucursalC_Codigo INT NULL, AsesorC_Id INT NULL, NumContrato VARCHAR(50) NULL, NumSolicitud VARCHAR(50) NULL, FechaSolicitud DATETIME NULL, TipoContrato INT NULL, FechaIniVigencia DATETIME NULL, FechaFinVigencia DATETIME NULL, Direccion VARCHAR(259) NULL, correoContratante VARCHAR(100) NULL, numTelContratante VARCHAR(15) NULL, numCelContratante VARCHAR(15) NULL, exentoIVA VARCHAR(50) NULL, ContratoConFirma BIT NULL, valorCuotaPeriodo DECIMAL(19,6) NOT NULL, descuentoComercial DECIMAL(19,6) NOT NULL, IVA DECIMAL(19,6) NOT NULL, descuentoFinanciero DECIMAL(19,6) NOT NULL, contratoNotificado BIT NOT NULL, UltimaActualizacion DATETIME NULL, CodTarifa VARCHAR(50) NULL);
CREATE TABLE ObservacionesC(Identificador INT IDENTITY, ID INT NOT NULL, CodTipoObservacion VARCHAR(9) NOT NULL, TipoObservacion VARCHAR(50) NOT NULL, Observacions VARCHAR(100) NOT NULL);
CREATE TABLE BeneficiarioC(ContratoC_ID INT NOT NULL, ID INT NOT NULL, FamiliasC_ID INT NOT NULL, FamiliasC_ID_1 INT NOT NULL, Codigo INT NULL, CompanyiaMPC_Codigo INT NULL, ParentescoC_Codigo INT NOT NULL, EstadoBeneficiarioC_Codigo INT NULL, NumUsuario INT NULL, CodigoTipoUsuario VARCHAR(50) NULL, IndicadorBBGestacion BIT NULL, CodUsuarioBancoRep VARCHAR(30) NULL, FechaAntiguedad DATETIME NULL, RequiereExamenMedico BIT NULL, EstadoMedico INT NULL, FechaAntiguedadRealOSI DATETIME NULL, ValorCuotaInscripcion DECIMAL(19,6) NULL, TienePreexistencias BIT NULL, FechaInicioVigencia DATETIME NULL, FechaFinVigencia DATETIME NULL);
CREATE TABLE AnexoC(Identificador INT IDENTITY, ID INT NOT NULL, BeneficiarioC_ID INT NOT NULL, Codigo INT NULL, TipoIdentificacionC_Codigo INT NULL, CodigoPlanAnexo VARCHAR(10) NULL, CodigoTarifa VARCHAR(10) NULL, FechaInicioVigencia DATETIME NULL, FechaUltimaRegla DATETIME NULL, NumCuotasPago INT NULL, NumIdentificacion VARCHAR(60) NULL, CodSucursal VARCHAR(20) NULL);
CREATE TABLE PregCuesMedC(ID INT NOT NULL, CodPregunta INT NOT NULL, RptaPregunta BIT NOT NULL, Observacions VARCHAR(999) NULL);
CREATE TABLE DirSucursalC(Codigo INT IDENTITY, ID INT NOT NULL, MunicipioC_Codigo INT NULL, DepartamentoC_Codigo INT NULL, PaisC_Codigo VARCHAR(10) NULL, RegionalC_Codigo INT NULL, CodLegalSucursal VARCHAR(9) NULL, Nombre VARCHAR(200) NULL, EsPrincipal BIT NOT NULL, Activa BIT NOT NULL, Direccion VARCHAR(255) NOT NULL, Mail VARCHAR(500) NULL);
CREATE TABLE FamiliaC(ContratoC_ID INT NOT NULL, ID INT NOT NULL, Codigo INT NULL, NumFamilia VARCHAR(20) NULL, TitularConBeneficios BIT NULL, EstadoTitularFamilia VARCHAR(10) NULL, FechaFinVigencia DATETIME NULL, direccionCorrespondencia VARCHAR(255) NULL);
CREATE TABLE UsuarioReg(ID_SOLICITUD INT NOT NULL, Identificador INT NOT NULL, Codigo INT NULL, Parentesco_Codigo INT NULL, TipoIdentificacion VARCHAR(20) NOT NULL, NumIdentificacion VARCHAR(60) NOT NULL, TipoYNumDoc VARCHAR(80) NULL, PrimerNombre VARCHAR(50) NOT NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NOT NULL, SegundoApellido VARCHAR(50) NULL, NumUsuario INT NULL, FechaInicioVigencia DATETIME NULL, FechaFinVigencia DATETIME NULL, Genero VARCHAR(1) NULL, FechaNacimiento DATETIME NULL);
CREATE TABLE Titular(ID_SOLICITUD INT NOT NULL, TipoIdentificacion_Codigo INT NOT NULL, DepartamentoNac_Codigo INT NULL, MunicipioNac_Codigo INT NULL, Codigo INT NULL, NumIdentificacion VARCHAR(60) NOT NULL, TipoPersona VARCHAR(1) NOT NULL, PrimerNombre VARCHAR(50) NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, FechaNacimiento DATETIME NULL, Genero VARCHAR(1) NULL, IndicadorExtranjero BIT NULL, TelefonoFijo VARCHAR(15) NULL, TelefonoCelular VARCHAR(15) NULL, CorreoElectronico VARCHAR(100) NULL, TitularConBeneficios BIT NOT NULL, TitularRecuperadoInc BIT NOT NULL, TelefonoFijoDC VARCHAR(15) NULL, TelefonoCelularDC VARCHAR(15) NULL, TitularConBeneficiosCORE BIT NOT NULL, RazonSocial VARCHAR(254) NULL, DireccionesModificadas BIT NOT NULL);
CREATE TABLE PreexistenciaC(ID INT NOT NULL, Identificador INT NOT NULL, Descripcion VARCHAR(200) NOT NULL, FecInicio DATETIME NOT NULL, FecFin DATETIME NULL, Observacion VARCHAR(500) NULL);
CREATE TABLE Preexistencia(ID_SOLICITUD INT NOT NULL, Usuario_Identificador INT NOT NULL, Identificador INT NOT NULL, Descripcion VARCHAR(200) NOT NULL, FecInicio DATETIME NOT NULL, FecFin DATETIME NULL, Observacion VARCHAR(500) NULL);
CREATE TABLE DocumentoG(Identificador INT IDENTITY, ID_SOLICITUD INT NOT NULL, Persona_Identificador INT NOT NULL, Descripcion VARCHAR(150) NULL, Tipo INT NULL, Estado INT NOT NULL, FechaSubida DATETIME NOT NULL, PathCompleto VARCHAR(255) NULL, Extension VARCHAR(15) NULL, NumDescargas INT NOT NULL, EmailEnvioDevuelto VARCHAR(255) NULL, ResultadoSubida TEXT NULL, IdDocEnGestor VARCHAR(255) NULL, Nombre VARCHAR(255) NULL, UsuarioCreador VARCHAR(50) NOT NULL);
CREATE TABLE ObsEstado(Identificador INT NOT NULL, Id INT NOT NULL, Agente_Id INT NOT NULL, Observacions VARCHAR(999) NULL, EstadoAnterior INT NOT NULL, EstadoNuevo INT NOT NULL, Fecha DATETIME NOT NULL);
CREATE TABLE ErrorWS(Identificador INT IDENTITY, ID_SOLICITUD INT NOT NULL, Descripcion VARCHAR(999) NOT NULL);
CREATE TABLE ParentescoDom(Numero INT NOT NULL, Identificador INT NOT NULL, Codigo INT NOT NULL, EdadMinimaA INT NULL, EdadMaximaA INT NULL, EdadMinimaD INT NULL, EdadMaximaP INT NULL);
CREATE TABLE MarcaMedicaC(ID INT NOT NULL, Producto INT NOT NULL, Codigo VARCHAR(10) NOT NULL, Descripcion VARCHAR(100) NULL, TipoMarcacion VARCHAR(100) NULL, EximePagoPrestacion BIT NULL, EstadoMarcacionMedica VARCHAR(50) NULL, FechaInicio DATETIME NULL, FechaFin DATETIME NULL);
CREATE TABLE TipoSucursalC(Codigo INT NOT NULL, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE ConceptoC(IdConcepto INT IDENTITY, ID INT NOT NULL, BeneficiarioC_ID INT NOT NULL, codConceptoContrato VARCHAR(4) NULL, nombreConcepto VARCHAR(50) NULL, porcentajeConcepto DECIMAL(19,6) NULL, valorConcepto DECIMAL(19,6) NULL);
CREATE TABLE DetalleTarifa(id_DetalleTarifa INT IDENTITY, Id INT NOT NULL, Anyo INT NOT NULL, LimInferiorEdad INT NOT NULL, LimSuperiorEdad INT NOT NULL, Valor DECIMAL(19,6) NOT NULL);
CREATE TABLE XClass(xcodigo VARCHAR(20) NOT NULL, xdescripcion VARCHAR(100) NULL);
CREATE TABLE AgentexProducto(Asesor_Id INT NOT NULL, Id INT NOT NULL, Producto INT NOT NULL, Codigo INT NOT NULL, FechaInicio DATETIME NULL, FechaFin DATETIME NULL, TodosDominios BIT NOT NULL);
CREATE TABLE InstitucionMatNeo(Codigo VARCHAR(20) NOT NULL, TipoIdentificacion_Codigo INT NOT NULL, Id INT NOT NULL, Municipio_Codigo INT NOT NULL, NumIdentificacion VARCHAR(60) NOT NULL, Nombre VARCHAR(100) NOT NULL, ParaMaternidad BIT NOT NULL, ParaNeonatal BIT NOT NULL, FechaInicial DATETIME NOT NULL, FechaFinal DATETIME NOT NULL);
CREATE TABLE LogEstado(Id INT IDENTITY, ID_SOLICITUD INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Observacion VARCHAR(255) NULL, MotDevolucion VARCHAR(50) NULL, Estado INT NOT NULL, EstadoDoc INT NOT NULL);
CREATE TABLE MotDevAreaMedica(Id INT IDENTITY, Descripcion VARCHAR(50) NOT NULL);
CREATE TABLE ContSinDocSol(id_ContSinDocSol INT IDENTITY, NumContrato VARCHAR(50) NOT NULL);
CREATE TABLE LogContSinDocSol(id_LogContSinDocSol INT IDENTITY, NumContrato VARCHAR(50) NOT NULL, Fecha DATETIME NOT NULL, Usuario VARCHAR(50) NOT NULL);
CREATE TABLE LogAsignaciones(id_LogAsignaciones INT IDENTITY, ID_SOLICITUD INT NOT NULL, Tipo VARCHAR(30) NOT NULL, FechaHora DATETIME NOT NULL, Quien VARCHAR(50) NOT NULL, Usuario VARCHAR(50) NOT NULL);
CREATE TABLE ReportesProcAlm(id_Reporte INT IDENTITY, Descripcion VARCHAR(50) NOT NULL, NombreProc VARCHAR(200) NOT NULL, NombreFichero VARCHAR(200) NOT NULL);
CREATE TABLE Prorrateo(Numero INT NOT NULL, id_Prorrateo INT NOT NULL, Dia INT NOT NULL, Porcentaje DECIMAL(19,6) NOT NULL);
CREATE TABLE TipoFactura(Codigo VARCHAR(20) NOT NULL, Descripcion VARCHAR(50) NOT NULL, EsEmail BIT NOT NULL, EsCelular BIT NOT NULL, Activo BIT NOT NULL);
CREATE TABLE ParamReporte(id_ParamReporte INT IDENTITY, id_Reporte INT NOT NULL, Titulo VARCHAR(50) NOT NULL, Descripcion VARCHAR(200) NULL, EsNumerico BIT NOT NULL, Orden INT NULL);
CREATE TABLE TipoNovedad(Tipo INT NOT NULL, AliasTipo VARCHAR(50) NOT NULL, Nombre VARCHAR(50) NOT NULL, Descripcion VARCHAR(200) NOT NULL, CodigoLegal VARCHAR(5) NOT NULL);
CREATE TABLE Novedad(id_Novedad INT IDENTITY, Tipo INT NOT NULL, AliasNovedad VARCHAR(2) NOT NULL, Nombre VARCHAR(50) NOT NULL, Descripcion VARCHAR(200) NOT NULL, CodigoLegal VARCHAR(5) NOT NULL, ReqDocPersona BIT NOT NULL, ReqDocSolicitud BIT NOT NULL, VariasFamilias BIT NOT NULL, MinValorMeses INT NULL, MaxValorMeses INT NULL);
CREATE TABLE Causal(id_Causal INT IDENTITY, id_Novedad INT NOT NULL, AliasCausal VARCHAR(50) NOT NULL, Nombre VARCHAR(50) NOT NULL, Descripcion VARCHAR(200) NOT NULL, CodigoLegal VARCHAR(5) NOT NULL, ReqDocPersona BIT NOT NULL, ReqDocSolicitud BIT NOT NULL);
CREATE TABLE SolicitudNovedad(Id INT IDENTITY, Plan INT NOT NULL, id_Novedad INT NOT NULL, id_Causal INT NULL, Identificador INT NULL, Codigo INT NULL, EstadoContrato_Codigo INT NULL, GrupoAsociado_Codigo INT NULL, Periodicidad_Codigo INT NULL, Agente_Id INT NOT NULL, PeriodicidadNueva_Codigo INT NULL, MotivoExcepcion_Id INT NULL, UsrAfiliacion_Id INT NULL, Firma_Identificador INT NULL, NumRadicado INT IDENTITY, FechaCreacion DATETIME NOT NULL, FechaVigencia DATETIME NOT NULL, NumContrato VARCHAR(50) NOT NULL, Excepcion BIT NOT NULL, FechaIniExcepcion DATETIME NULL, FechaFinExcepcion DATETIME NULL, CtrCodigoTarifa VARCHAR(12) NULL, CtrDescTarifa VARCHAR(100) NULL, CtrCodigoConvenio VARCHAR(12) NULL, CtrDescConvenio VARCHAR(100) NULL, CtrEsColectivo BIT NOT NULL, CtrTagCausaExclusion VARCHAR(100) NULL, ContraNumIden VARCHAR(60) NULL, ContraPrimerNombre VARCHAR(50) NULL, ContraSegundoNombre VARCHAR(50) NULL, ContraPrimerApellido VARCHAR(50) NULL, ContraSegundoApellido VARCHAR(50) NULL, ContraRazonSocial VARCHAR(200) NULL, FechaUltimoDoc DATETIME NULL, Observacions VARCHAR(900) NULL, Estado INT NULL, EstadoDocumentacion INT NULL, Completada BIT NOT NULL, FechaCompletada DATETIME NULL, CtrActivo BIT NOT NULL, CtrTipoContrato INT NULL, SCNumMeses INT NULL, ContraNuevaRazonSocial VARCHAR(200) NULL, ContraTipoPersona VARCHAR(1) NULL, CtrFInicioContrato DATETIME NULL, Prioridad INT NOT NULL, FechaTerminada DATETIME NULL, FechaFUG DATETIME NULL, FechaFA DATETIME NULL, SemaforoGrabAse DECIMAL(19,6) NULL);
CREATE TABLE FamiliaNovedad(id_FamiliaNovedad INT IDENTITY, Id INT NOT NULL, Codigo INT NULL, Identificador INT NULL, NumFamilia INT NOT NULL, TitNumidentificacion VARCHAR(60) NOT NULL, TitPrimerNombre VARCHAR(50) NULL, TitSegundoNombre VARCHAR(50) NULL, TitPrimerApellido VARCHAR(50) NULL, TitSegundoApellido VARCHAR(50) NULL, TitRazonSocial VARCHAR(200) NULL, TitTieneBeneficios BIT NOT NULL, FamActiva BIT NOT NULL);
CREATE TABLE UsuarioNovedad(id_UsuarioNovedad INT IDENTITY, id_FamiliaNovedad INT NOT NULL, Codigo INT NULL, Parentesco_Codigo INT NULL, EstadoBeneficiario_Codigo INT NULL, ParentescoNuevo_Codigo INT NULL, TipoIdentificacionCD_Codigo INT NULL, NumIdentificacion VARCHAR(60) NOT NULL, PrimerNombre VARCHAR(50) NULL, SegundoNombre VARCHAR(50) NULL, PrimerApellido VARCHAR(50) NULL, SegundoApellido VARCHAR(50) NULL, MotivoEstado VARCHAR(200) NULL, FechaIniVigencia DATETIME NULL, FechaAntiguedad DATETIME NULL, NumUsuario INT NOT NULL, Genero VARCHAR(1) NULL, FechaNacimiento DATETIME NULL, SUNumMeses INT NULL, NumIdentificacionCD VARCHAR(60) NULL, Excluido BIT NOT NULL, ContratacionRO BIT NOT NULL, ProrrogaSuspension BIT NOT NULL, ActivacionSuspension BIT NOT NULL);
CREATE TABLE CausaExclusion(id_CausaExclusion INT IDENTITY, id_Novedad INT NOT NULL, AliasCausa VARCHAR(10) NOT NULL, Descripcion VARCHAR(100) NOT NULL);
CREATE TABLE NovedadCT(id_NovedadCT INT IDENTITY, id_FamiliaNovedad INT NOT NULL, Codigo INT NOT NULL, Identificador INT NULL, MunicipioNac_Codigo INT NULL, MunicipioRes_Codigo INT NULL, DepartamentoNac_Codigo INT NULL, DepartamentoRes_Codigo INT NULL, Pais_Codigo VARCHAR(10) NULL, TitNumidentificacion VARCHAR(60) NOT NULL, TitPrimerNombre VARCHAR(50) NULL, TitSegundoNombre VARCHAR(50) NULL, TitPrimerApellido VARCHAR(50) NULL, TitSegundoApellido VARCHAR(50) NULL, TitRazonSocial VARCHAR(200) NULL, TitTieneBeneficios BIT NOT NULL, FechaNacimiento DATETIME NULL, Genero VARCHAR(1) NULL, IndicadorExtranjero BIT NULL, TelefonoFijo VARCHAR(15) NULL, TelefonoCelular VARCHAR(15) NULL, CorreoElectronico VARCHAR(100) NULL, DireccionCompleta VARCHAR(250) NULL, Rural BIT NULL, CodigoCORE INT NULL);
CREATE TABLE DocumentoNovedad(IdDocumento INT IDENTITY, Id INT NOT NULL, id_UsuarioNovedad INT NULL, Tipo INT NOT NULL, FechaSubida DATETIME NOT NULL, Descripcion VARCHAR(150) NULL, Estado INT NOT NULL, PathCompleto VARCHAR(255) NULL, Extension VARCHAR(15) NULL, ResultadoSubida TEXT NULL, IdDocEnGestor VARCHAR(255) NULL, Nombre VARCHAR(255) NULL, UsuarioCreador VARCHAR(50) NOT NULL);
CREATE TABLE NovedadMD(id_NovedadMD INT IDENTITY, id_FamiliaNovedad INT NOT NULL, Codigo VARCHAR(10) NULL, Departamento_Codigo INT NULL, Municipio_Codigo INT NULL, DireccionCompleta VARCHAR(250) NULL, Rural BIT NULL, TelefonoFijo VARCHAR(15) NULL, TelefonoCelular VARCHAR(15) NULL, CorreoElectronico VARCHAR(100) NULL);
CREATE TABLE LogEstadoSN(Id INT IDENTITY, SolicitudNovedad_Id INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Estado INT NOT NULL, EstadoDoc INT NOT NULL);
CREATE TABLE MotivoExcepcionSolNov(Id INT IDENTITY, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE PriorizacionSolicitudes(EstadoSolicitud INT NOT NULL, EstadoDoc INT NOT NULL, Prioridad INT NOT NULL);
CREATE TABLE LogPriorizacionSol(Id INT IDENTITY, PriSolicitud_EstadoSolicitud INT NULL, PriSolicitud_EstadoDoc INT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, EstadoSolicitud INT NOT NULL, EstadoDoc INT NOT NULL, Prioridad INT NOT NULL);
CREATE TABLE GrupoAsignacion(Id INT IDENTITY, Tipo INT NOT NULL, Nombre VARCHAR(50) NOT NULL, Descripcion VARCHAR(150) NOT NULL);
CREATE TABLE LogGrupoAsignacion(Id INT IDENTITY, GrupoAsignacion_Id INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Accion VARCHAR(50) NOT NULL, Valor VARCHAR(200) NOT NULL);
CREATE TABLE LogGruposUsuarios(Id INT IDENTITY, Numero INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, TipoGrupo INT NOT NULL, Accion VARCHAR(50) NOT NULL, Grupo VARCHAR(100) NOT NULL);
CREATE TABLE GrupoAsignacionNovedad(Id INT IDENTITY, Numero INT NOT NULL, id_Causal INT NOT NULL, GrupoUsuarios_Id INT NULL);
CREATE TABLE LogFuncionario(Id INT IDENTITY, Funcionario_Id INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Disponible BIT NOT NULL);
CREATE TABLE LogUsrSolNov(Id INT IDENTITY, SolicitudNovedad_Id INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Usuario VARCHAR(50) NOT NULL);
CREATE TABLE ContratoCombo(Id INT IDENTITY, ContratoIntegral VARCHAR(50) NOT NULL, ContratoOdontologico VARCHAR(50) NOT NULL);
CREATE TABLE LogContratoCombo(Id INT IDENTITY, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, ContratoIntegral VARCHAR(50) NULL, ContratoOdontologico VARCHAR(50) NULL, Accion VARCHAR(50) NOT NULL);
CREATE TABLE ConfiguracionANS(Id INT IDENTITY, Numero INT NOT NULL, id_Novedad INT NULL, id_Causal INT NULL, Tramite INT NOT NULL, ANSAfiliaciones INT NOT NULL, ANSAreaMedica INT NOT NULL, HabilLunes BIT NOT NULL, HabilMartes BIT NOT NULL, HabilMiercoles BIT NOT NULL, HabilJueves BIT NOT NULL, HabilViernes BIT NOT NULL, HabilSabado BIT NOT NULL, HabilDomingo BIT NOT NULL);
CREATE TABLE LogConfiguracionANS(Id INT IDENTITY, ConfiguracionANS_Id INT NOT NULL, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, ANSAfiliaciones INT NOT NULL, ANSAreaMedica INT NOT NULL, HabilLunes BIT NOT NULL, HabilMartes BIT NOT NULL, HabilMiercoles BIT NOT NULL, HabilJueves BIT NOT NULL, HabilViernes BIT NOT NULL, HabilSabado BIT NOT NULL, HabilDomingo BIT NOT NULL);
CREATE TABLE ConfiguracionFestivos(Id INT IDENTITY, DiaFestivo DATETIME NOT NULL);
CREATE TABLE LogEstadoDocNov(Id INT IDENTITY, IdDocumento INT NOT NULL, Fecha DATETIME NOT NULL, NombreFuncionario VARCHAR(200) NOT NULL, EstadoAnterior INT NOT NULL, EstadoNuevo INT NOT NULL, Observacions VARCHAR(999) NULL);
CREATE TABLE PlantillaReporte(id_PlantillaReporte INT IDENTITY, Tipo INT NOT NULL, Titulo VARCHAR(100) NOT NULL, FechaVigencia DATETIME NOT NULL, RutaArchivos VARCHAR(255) NOT NULL, NombreArchivoPDF VARCHAR(50) NOT NULL);
CREATE TABLE ReportesDominio(Numero INT NOT NULL, id_PlantillaReporte INT NOT NULL, EnviarAuto BIT NOT NULL);
CREATE TABLE LogInformacionAsesor(id_LogInformacionAsesor INT IDENTITY, Id INT NOT NULL, FechaHora DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, VerDatosPersona BIT NOT NULL, VerDocsPersona BIT NOT NULL, VerContratoNovedad BIT NOT NULL, AccesoValidadorUsuarios BIT NOT NULL);
CREATE TABLE LogHistoricoPlanes(id_LogHistoricoPlanes INT IDENTITY, Id INT NOT NULL, FechaHora DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Producto VARCHAR(10) NOT NULL, Plan VARCHAR(10) NOT NULL, Accion VARCHAR(10) NOT NULL);
CREATE TABLE LogLlamadasAE(ID INT IDENTITY, TipoServicio VARCHAR(20) NOT NULL, Solicitud VARCHAR(50) NULL, Servicio VARCHAR(100) NOT NULL, Capacidad VARCHAR(100) NULL, FechaHora DATETIME NOT NULL, TextoError TEXT NULL, TiempoEjecucion DECIMAL(19,6) NULL, DatosRecibidos TEXT NULL, DatosEnviados TEXT NULL);
CREATE TABLE LogLlamadasBH(ID INT IDENTITY, TipoServicio VARCHAR(20) NOT NULL, Solicitud VARCHAR(50) NULL, Servicio VARCHAR(100) NOT NULL, Capacidad VARCHAR(100) NULL, FechaHora DATETIME NOT NULL, TextoError TEXT NULL, TiempoEjecucion DECIMAL(19,6) NULL, Peticion TEXT NULL, Respuesta TEXT NULL, Usuario VARCHAR(50) NULL);
CREATE TABLE FechaIniEPS(Id INT IDENTITY, Tramite INT NOT NULL, TipoContrato INT NOT NULL, Desde DATETIME NOT NULL, Hasta DATETIME NOT NULL, FechaInicioAplicar DATETIME NOT NULL);
CREATE TABLE LogIncompatibilidades(id_LogIncompatibilidades INT IDENTITY, Numero INT NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Fecha DATETIME NOT NULL, Accion VARCHAR(12) NOT NULL, NomDominio VARCHAR(50) NOT NULL);
CREATE TABLE LogDatosDominio(id_LogDatosDominio INT IDENTITY, Numero INT NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Fecha DATETIME NOT NULL, TramiteEnLinea BIT NOT NULL, VigenciaRadicacion BIT NOT NULL);
CREATE TABLE ContratosExentosFIngreso(id_ContratosExentosFIngreso INT IDENTITY, NumContrato VARCHAR(50) NOT NULL);
CREATE TABLE LogContratosExentosFIngreso(id_LogContratosExentosFIngreso INT IDENTITY, Fecha DATETIME NOT NULL, LoginFuncionario VARCHAR(50) NOT NULL, Accion VARCHAR(15) NOT NULL, NumContrato VARCHAR(50) NOT NULL);

CREATE TABLE GridPreferences (agentName VARCHAR(200) NOT NULL, piuName VARCHAR(200) NOT NULL, gridState TEXT NULL);
