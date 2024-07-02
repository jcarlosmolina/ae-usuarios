ALTER TABLE TM_ValorPregunta DROP CONSTRAINT pk_TM_ValorPregunta;
ALTER TABLE TM_DominioPeriodicidad DROP CONSTRAINT pk_TM_DominioPeriodicidad;
ALTER TABLE TM_DominioRol DROP CONSTRAINT pk_TM_DominioRol;
ALTER TABLE TM_DominioFormaPago DROP CONSTRAINT pk_TM_DominioFormaPago;
ALTER TABLE TM_DominiosPlantillas DROP CONSTRAINT pk_TM_DominiosPlantillas;
ALTER TABLE TM_DominioNovedad DROP CONSTRAINT pk_TM_DominioNovedad;
ALTER TABLE TM_IncompatibilidadesDominio DROP CONSTRAINT pk_TM_IncompatibilidadesDomini;
ALTER TABLE TM_DirSucursalCTipoSucursalC DROP CONSTRAINT pk_TM_DirSucursalCTipoSucursal;
ALTER TABLE TM_AfiliacionesPlanes DROP CONSTRAINT pk_TM_AfiliacionesPlanes;
ALTER TABLE TM_AgentexProductoDominio DROP CONSTRAINT pk_TM_AgentexProductoDominio;
ALTER TABLE TM_ReportesProcAlmFuncionario DROP CONSTRAINT pk_TM_ReportesProcAlmFuncionar;
ALTER TABLE TM_GrupoAsignacionFuncionario DROP CONSTRAINT pk_TM_GrupoAsignacionFuncionar;
ALTER TABLE Funcionario DROP CONSTRAINT pk_Funcionario;
ALTER TABLE Admin DROP CONSTRAINT pk_Admin;
ALTER TABLE SuperAdmin DROP CONSTRAINT pk_SuperAdmin;
ALTER TABLE Asesor DROP CONSTRAINT pk_Asesor;
ALTER TABLE AreaMedica DROP CONSTRAINT pk_AreaMedica;
ALTER TABLE Afiliaciones DROP CONSTRAINT pk_Afiliaciones;
ALTER TABLE RespRegional DROP CONSTRAINT pk_RespRegional;
ALTER TABLE Gestor DROP CONSTRAINT pk_Gestor;
ALTER TABLE MesaDeApoyo DROP CONSTRAINT pk_MesaDeApoyo;
ALTER TABLE ParamConfig DROP CONSTRAINT pk_ParamConfig;
ALTER TABLE LogParam DROP CONSTRAINT pk_LogParam;
ALTER TABLE FrecuenciaAct DROP CONSTRAINT pk_FrecuenciaAct;
ALTER TABLE CuestionarioMed DROP CONSTRAINT pk_CuestionarioMed;
ALTER TABLE Seccion DROP CONSTRAINT pk_Seccion;
ALTER TABLE Pregunta DROP CONSTRAINT pk_Pregunta;
ALTER TABLE Valor DROP CONSTRAINT pk_Valor;
ALTER TABLE Productos DROP CONSTRAINT pk_Productos;
ALTER TABLE Planes DROP CONSTRAINT pk_Planes;
ALTER TABLE Parentesco DROP CONSTRAINT pk_Parentesco;
ALTER TABLE Periodicidad DROP CONSTRAINT pk_Periodicidad;
ALTER TABLE Rol DROP CONSTRAINT pk_Rol;
ALTER TABLE Dominio DROP CONSTRAINT pk_Dominio;
ALTER TABLE PlantillaEmail DROP CONSTRAINT pk_PlantillaEmail;
ALTER TABLE EstadoContrato DROP CONSTRAINT pk_EstadoContrato;
ALTER TABLE EstadoBeneficiario DROP CONSTRAINT pk_EstadoBeneficiario;
ALTER TABLE EstadoBeneficiarioAE DROP CONSTRAINT pk_EstadoBeneficiarioAE;
ALTER TABLE Tarifa DROP CONSTRAINT pk_Tarifa;
ALTER TABLE Regional DROP CONSTRAINT pk_Regional;
ALTER TABLE Sucursal DROP CONSTRAINT pk_Sucursal;
ALTER TABLE GrupoAsociado DROP CONSTRAINT pk_GrupoAsociado;
ALTER TABLE EstadoCivil DROP CONSTRAINT pk_EstadoCivil;
ALTER TABLE Departamento DROP CONSTRAINT pk_Departamento;
ALTER TABLE TipoIVA DROP CONSTRAINT pk_TipoIVA;
ALTER TABLE Persona DROP CONSTRAINT pk_Persona;
ALTER TABLE Companyia DROP CONSTRAINT pk_Companyia;
ALTER TABLE Municipio DROP CONSTRAINT pk_Municipio;
ALTER TABLE TipoDireccion DROP CONSTRAINT pk_TipoDireccion;
ALTER TABLE EstadoPersona DROP CONSTRAINT pk_EstadoPersona;
ALTER TABLE FormaPago DROP CONSTRAINT pk_FormaPago;
ALTER TABLE TipoIdentificacion DROP CONSTRAINT pk_TipoIdentificacion;
ALTER TABLE EPS DROP CONSTRAINT pk_EPS;
ALTER TABLE EntidadFinancieraC DROP CONSTRAINT pk_EntidadFinancieraC;
ALTER TABLE TipoEntidadC DROP CONSTRAINT pk_TipoEntidadC;
ALTER TABLE TipoInstitucionC DROP CONSTRAINT pk_TipoInstitucionC;
ALTER TABLE AE_SOLICITUDES DROP CONSTRAINT pk_AE_SOLICITUDES;
ALTER TABLE Solicitud DROP CONSTRAINT pk_Solicitud;
ALTER TABLE PersonaC DROP CONSTRAINT pk_PersonaC;
ALTER TABLE DireccionC DROP CONSTRAINT pk_DireccionC;
ALTER TABLE TelefonoC DROP CONSTRAINT pk_TelefonoC;
ALTER TABLE ProteccionDatosC DROP CONSTRAINT pk_ProteccionDatosC;
ALTER TABLE Direccion DROP CONSTRAINT pk_Direccion;
ALTER TABLE Pais DROP CONSTRAINT pk_Pais;
ALTER TABLE ProteccionDatos DROP CONSTRAINT pk_ProteccionDatos;
ALTER TABLE Usuario DROP CONSTRAINT pk_Usuario;
ALTER TABLE CuestionarioP DROP CONSTRAINT pk_CuestionarioP;
ALTER TABLE SeccionP DROP CONSTRAINT pk_SeccionP;
ALTER TABLE PreguntaP DROP CONSTRAINT pk_PreguntaP;
ALTER TABLE Contratante DROP CONSTRAINT pk_Contratante;
ALTER TABLE AnexoMat DROP CONSTRAINT pk_AnexoMat;
ALTER TABLE AnexoNeo DROP CONSTRAINT pk_AnexoNeo;
ALTER TABLE Firma DROP CONSTRAINT pk_Firma;
ALTER TABLE ContratoC DROP CONSTRAINT pk_ContratoC;
ALTER TABLE ObservacionesC DROP CONSTRAINT pk_ObservacionesC;
ALTER TABLE BeneficiarioC DROP CONSTRAINT pk_BeneficiarioC;
ALTER TABLE AnexoC DROP CONSTRAINT pk_AnexoC;
ALTER TABLE PregCuesMedC DROP CONSTRAINT pk_PregCuesMedC;
ALTER TABLE DirSucursalC DROP CONSTRAINT pk_DirSucursalC;
ALTER TABLE FamiliaC DROP CONSTRAINT pk_FamiliaC;
ALTER TABLE UsuarioReg DROP CONSTRAINT pk_UsuarioReg;
ALTER TABLE Titular DROP CONSTRAINT pk_Titular;
ALTER TABLE PreexistenciaC DROP CONSTRAINT pk_PreexistenciaC;
ALTER TABLE Preexistencia DROP CONSTRAINT pk_Preexistencia;
ALTER TABLE DocumentoG DROP CONSTRAINT pk_DocumentoG;
ALTER TABLE ObsEstado DROP CONSTRAINT pk_ObsEstado;
ALTER TABLE ErrorWS DROP CONSTRAINT pk_ErrorWS;
ALTER TABLE ParentescoDom DROP CONSTRAINT pk_ParentescoDom;
ALTER TABLE MarcaMedicaC DROP CONSTRAINT pk_MarcaMedicaC;
ALTER TABLE TipoSucursalC DROP CONSTRAINT pk_TipoSucursalC;
ALTER TABLE ConceptoC DROP CONSTRAINT pk_ConceptoC;
ALTER TABLE DetalleTarifa DROP CONSTRAINT pk_DetalleTarifa;
ALTER TABLE XClass DROP CONSTRAINT pk_XClass;
ALTER TABLE AgentexProducto DROP CONSTRAINT pk_AgentexProducto;
ALTER TABLE InstitucionMatNeo DROP CONSTRAINT pk_InstitucionMatNeo;
ALTER TABLE LogEstado DROP CONSTRAINT pk_LogEstado;
ALTER TABLE MotDevAreaMedica DROP CONSTRAINT pk_MotDevAreaMedica;
ALTER TABLE ContSinDocSol DROP CONSTRAINT pk_ContSinDocSol;
ALTER TABLE LogContSinDocSol DROP CONSTRAINT pk_LogContSinDocSol;
ALTER TABLE LogAsignaciones DROP CONSTRAINT pk_LogAsignaciones;
ALTER TABLE ReportesProcAlm DROP CONSTRAINT pk_ReportesProcAlm;
ALTER TABLE Prorrateo DROP CONSTRAINT pk_Prorrateo;
ALTER TABLE TipoFactura DROP CONSTRAINT pk_TipoFactura;
ALTER TABLE ParamReporte DROP CONSTRAINT pk_ParamReporte;
ALTER TABLE TipoNovedad DROP CONSTRAINT pk_TipoNovedad;
ALTER TABLE Novedad DROP CONSTRAINT pk_Novedad;
ALTER TABLE Causal DROP CONSTRAINT pk_Causal;
ALTER TABLE SolicitudNovedad DROP CONSTRAINT pk_SolicitudNovedad;
ALTER TABLE FamiliaNovedad DROP CONSTRAINT pk_FamiliaNovedad;
ALTER TABLE UsuarioNovedad DROP CONSTRAINT pk_UsuarioNovedad;
ALTER TABLE CausaExclusion DROP CONSTRAINT pk_CausaExclusion;
ALTER TABLE NovedadCT DROP CONSTRAINT pk_NovedadCT;
ALTER TABLE DocumentoNovedad DROP CONSTRAINT pk_DocumentoNovedad;
ALTER TABLE NovedadMD DROP CONSTRAINT pk_NovedadMD;
ALTER TABLE LogEstadoSN DROP CONSTRAINT pk_LogEstadoSN;
ALTER TABLE MotivoExcepcionSolNov DROP CONSTRAINT pk_MotivoExcepcionSolNov;
ALTER TABLE PriorizacionSolicitudes DROP CONSTRAINT pk_PriorizacionSolicitudes;
ALTER TABLE LogPriorizacionSol DROP CONSTRAINT pk_LogPriorizacionSol;
ALTER TABLE GrupoAsignacion DROP CONSTRAINT pk_GrupoAsignacion;
ALTER TABLE LogGrupoAsignacion DROP CONSTRAINT pk_LogGrupoAsignacion;
ALTER TABLE LogGruposUsuarios DROP CONSTRAINT pk_LogGruposUsuarios;
ALTER TABLE GrupoAsignacionNovedad DROP CONSTRAINT pk_GrupoAsignacionNovedad;
ALTER TABLE LogFuncionario DROP CONSTRAINT pk_LogFuncionario;
ALTER TABLE LogUsrSolNov DROP CONSTRAINT pk_LogUsrSolNov;
ALTER TABLE ContratoCombo DROP CONSTRAINT pk_ContratoCombo;
ALTER TABLE LogContratoCombo DROP CONSTRAINT pk_LogContratoCombo;
ALTER TABLE ConfiguracionANS DROP CONSTRAINT pk_ConfiguracionANS;
ALTER TABLE LogConfiguracionANS DROP CONSTRAINT pk_LogConfiguracionANS;
ALTER TABLE ConfiguracionFestivos DROP CONSTRAINT pk_ConfiguracionFestivos;
ALTER TABLE LogEstadoDocNov DROP CONSTRAINT pk_LogEstadoDocNov;
ALTER TABLE PlantillaReporte DROP CONSTRAINT pk_PlantillaReporte;
ALTER TABLE ReportesDominio DROP CONSTRAINT pk_ReportesDominio;
ALTER TABLE LogInformacionAsesor DROP CONSTRAINT pk_LogInformacionAsesor;
ALTER TABLE LogHistoricoPlanes DROP CONSTRAINT pk_LogHistoricoPlanes;
ALTER TABLE LogLlamadasAE DROP CONSTRAINT pk_LogLlamadasAE;
ALTER TABLE LogLlamadasBH DROP CONSTRAINT pk_LogLlamadasBH;
ALTER TABLE FechaIniEPS DROP CONSTRAINT pk_FechaIniEPS;
ALTER TABLE LogIncompatibilidades DROP CONSTRAINT pk_LogIncompatibilidades;
ALTER TABLE LogDatosDominio DROP CONSTRAINT pk_LogDatosDominio;
ALTER TABLE ContratosExentosFIngreso DROP CONSTRAINT pk_ContratosExentosFIngreso;
ALTER TABLE LogContratosExentosFIngreso DROP CONSTRAINT pk_LogContratosExentosFIngreso;

ALTER TABLE GridPreferences DROP CONSTRAINT pk_GridPreferences;
