ALTER TABLE TM_ValorPregunta ADD CONSTRAINT fkc_TM_ValorPregunta_Valores FOREIGN KEY (Identificador) REFERENCES Valor;
ALTER TABLE TM_ValorPregunta ADD CONSTRAINT fkc_TM_ValorPregunta_Preguntas FOREIGN KEY (Numero) REFERENCES Pregunta;
ALTER TABLE TM_DominioPeriodicidad ADD CONSTRAINT fkc_TM_DominioPeriodicidad_Dominios FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_DominioPeriodicidad ADD CONSTRAINT fkc_TM_DominioPeriodicidad_Periodicidades FOREIGN KEY (Codigo) REFERENCES Periodicidad;
ALTER TABLE TM_DominioRol ADD CONSTRAINT fkc_TM_DominioRol_Dominios FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_DominioRol ADD CONSTRAINT fkc_TM_DominioRol_Roles FOREIGN KEY (Identificador) REFERENCES Rol;
ALTER TABLE TM_DominioFormaPago ADD CONSTRAINT fkc_TM_DominioFormaPago_Dominios FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_DominioFormaPago ADD CONSTRAINT fkc_TM_DominioFormaPago_FormasPago FOREIGN KEY (Codigo) REFERENCES FormaPago;
ALTER TABLE TM_DominiosPlantillas ADD CONSTRAINT fkc_TM_DominiosPlantillas_Dominios FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_DominiosPlantillas ADD CONSTRAINT fkc_TM_DominiosPlantillas_Plantillas FOREIGN KEY (IdPlantilla) REFERENCES PlantillaEmail;
ALTER TABLE TM_DominioNovedad ADD CONSTRAINT fkc_TM_DominioNovedad_Dominios FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_DominioNovedad ADD CONSTRAINT fkc_TM_DominioNovedad_Novedades FOREIGN KEY (id_Novedad) REFERENCES Novedad;
ALTER TABLE TM_IncompatibilidadesDominio ADD CONSTRAINT fkc_TM_IncompatibilidadesDominio_DominiosConIncompatibilidad FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_IncompatibilidadesDominio ADD CONSTRAINT fkc_TM_IncompatibilidadesDominio_DominiosIncompatibles FOREIGN KEY (DominiosIncompatibles_Numero) REFERENCES Dominio;
ALTER TABLE TM_DirSucursalCTipoSucursalC ADD CONSTRAINT fkc_TM_DirSucursalCTipoSucursalC_DirSucursalesC FOREIGN KEY (Codigo) REFERENCES DirSucursalC;
ALTER TABLE TM_DirSucursalCTipoSucursalC ADD CONSTRAINT fkc_TM_DirSucursalCTipoSucursalC_TiposSucursalC FOREIGN KEY (TiposSucursalC_Codigo) REFERENCES TipoSucursalC;
ALTER TABLE TM_AfiliacionesPlanes ADD CONSTRAINT fkc_TM_AfiliacionesPlanes_Afiliaciones FOREIGN KEY (Id) REFERENCES Afiliaciones;
ALTER TABLE TM_AfiliacionesPlanes ADD CONSTRAINT fkc_TM_AfiliacionesPlanes_Planes FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE TM_AgentexProductoDominio ADD CONSTRAINT fkc_TM_AgentexProductoDominio_AgentexProducto FOREIGN KEY (Id, AgentexProducto_Id) REFERENCES AgentexProducto;
ALTER TABLE TM_AgentexProductoDominio ADD CONSTRAINT fkc_TM_AgentexProductoDominio_Dominios FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE TM_ReportesProcAlmFuncionario ADD CONSTRAINT fkc_TM_ReportesProcAlmFuncionario_Reportes FOREIGN KEY (id_Reporte) REFERENCES ReportesProcAlm;
ALTER TABLE TM_ReportesProcAlmFuncionario ADD CONSTRAINT fkc_TM_ReportesProcAlmFuncionario_Funcionarios FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE TM_GrupoAsignacionFuncionario ADD CONSTRAINT fkc_TM_GrupoAsignacionFuncionario_GrupoAsignacion FOREIGN KEY (Id) REFERENCES GrupoAsignacion;
ALTER TABLE TM_GrupoAsignacionFuncionario ADD CONSTRAINT fkc_TM_GrupoAsignacionFuncionario_Funcionario FOREIGN KEY (Funcionario_Id) REFERENCES Funcionario;
ALTER TABLE Funcionario ADD CONSTRAINT fkc_Funcionario_Rol FOREIGN KEY (Identificador) REFERENCES Rol;
ALTER TABLE Funcionario ADD CONSTRAINT fkc_Funcionario_Sucursal FOREIGN KEY (Codigo) REFERENCES Sucursal;
ALTER TABLE Admin ADD CONSTRAINT fkc_Admin_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE SuperAdmin ADD CONSTRAINT fkc_SuperAdmin_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE Asesor ADD CONSTRAINT fkc_Asesor_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE Asesor ADD CONSTRAINT fkc_Asesor_TipoIdentificacion FOREIGN KEY (Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE AreaMedica ADD CONSTRAINT fkc_AreaMedica_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE Afiliaciones ADD CONSTRAINT fkc_Afiliaciones_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE RespRegional ADD CONSTRAINT fkc_RespRegional_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE RespRegional ADD CONSTRAINT fkc_RespRegional_Regional FOREIGN KEY (Codigo) REFERENCES Regional;
ALTER TABLE Gestor ADD CONSTRAINT fkc_Gestor_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE MesaDeApoyo ADD CONSTRAINT fkc_MesaDeApoyo_ FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE LogParam ADD CONSTRAINT fkc_LogParam_ParamConfig FOREIGN KEY (ParamConfig_Codigo) REFERENCES ParamConfig;
ALTER TABLE Seccion ADD CONSTRAINT fkc_Seccion_Cuestionario FOREIGN KEY (Numero) REFERENCES CuestionarioMed;
ALTER TABLE Pregunta ADD CONSTRAINT fkc_Pregunta_Seccion FOREIGN KEY (Identificador) REFERENCES Seccion;
ALTER TABLE Planes ADD CONSTRAINT fkc_Planes_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE Dominio ADD CONSTRAINT fkc_Dominio_PlanT FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE Dominio ADD CONSTRAINT fkc_Dominio_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE Dominio ADD CONSTRAINT fkc_Dominio_GrupoAsesores FOREIGN KEY (Id) REFERENCES GrupoAsignacion;
ALTER TABLE Dominio ADD CONSTRAINT fkc_Dominio_GrupoAreaMedica FOREIGN KEY (GrupoAreaMedica_Id) REFERENCES GrupoAsignacion;
ALTER TABLE EstadoBeneficiarioAE ADD CONSTRAINT fkc_EstadoBeneficiarioAE_EstadoBeneficiarioCORE FOREIGN KEY (EstadoBeneficiarioCORE_Codigo) REFERENCES EstadoBeneficiario;
ALTER TABLE Tarifa ADD CONSTRAINT fkc_Tarifa_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE Tarifa ADD CONSTRAINT fkc_Tarifa_PlanT FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE Sucursal ADD CONSTRAINT fkc_Sucursal_Regional FOREIGN KEY (Regional_Codigo) REFERENCES Regional;
ALTER TABLE GrupoAsociado ADD CONSTRAINT fkc_GrupoAsociado_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE GrupoAsociado ADD CONSTRAINT fkc_GrupoAsociado_PlanT FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE TipoIVA ADD CONSTRAINT fkc_TipoIVA_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE TipoIVA ADD CONSTRAINT fkc_TipoIVA_PlanT FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE Persona ADD CONSTRAINT fkc_Persona_TipoIdentificacion FOREIGN KEY (TipoIdentificacion_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE Persona ADD CONSTRAINT fkc_Persona_DepartamentoNacimiento FOREIGN KEY (DepartamentoNacimiento_Codigo) REFERENCES Departamento;
ALTER TABLE Persona ADD CONSTRAINT fkc_Persona_MunicipioNacimiento FOREIGN KEY (MunicipioNacimiento_Codigo) REFERENCES Municipio;
ALTER TABLE Persona ADD CONSTRAINT fkc_Persona_EstadoCivil FOREIGN KEY (EstadoCivil_Codigo) REFERENCES EstadoCivil;
ALTER TABLE Persona ADD CONSTRAINT fkc_Persona_EstadoPersona FOREIGN KEY (EstadoPersona_Codigo) REFERENCES EstadoPersona;
ALTER TABLE Municipio ADD CONSTRAINT fkc_Municipio_Departamento FOREIGN KEY (Departamento_Codigo) REFERENCES Departamento;
ALTER TABLE AE_SOLICITUDES ADD CONSTRAINT fkc_AE_SOLICITUDES_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE AE_SOLICITUDES ADD CONSTRAINT fkc_AE_SOLICITUDES_PlanT FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE AE_SOLICITUDES ADD CONSTRAINT fkc_AE_SOLICITUDES_ESTADO_SOLICITUD FOREIGN KEY (Codigo) REFERENCES EstadoContrato;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_AE_SOLICITUDES FOREIGN KEY (ID_SOLICITUD) REFERENCES AE_SOLICITUDES;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_ContratantePersona FOREIGN KEY (Identificador) REFERENCES Persona;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_TitularPersona FOREIGN KEY (TitularPersona_Identificador) REFERENCES Persona;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_GrupoAsociado FOREIGN KEY (Codigo) REFERENCES GrupoAsociado;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_Agente FOREIGN KEY (Id) REFERENCES Funcionario;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_FormaPago FOREIGN KEY (FormaPago_Codigo) REFERENCES FormaPago;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_Periodicidad FOREIGN KEY (Periodicidad_Codigo) REFERENCES Periodicidad;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_ContratoC FOREIGN KEY (ContratoC_ID) REFERENCES ContratoC;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_UsrAreaMedica FOREIGN KEY (UsrAreaMedica_Id) REFERENCES AreaMedica;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_TipoFactura FOREIGN KEY (TipoFactura_Codigo) REFERENCES TipoFactura;
ALTER TABLE Solicitud ADD CONSTRAINT fkc_Solicitud_UsrAfiliacion FOREIGN KEY (UsrAfiliacion_Id) REFERENCES Funcionario;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_TipoInstitucionC FOREIGN KEY (TipoInstitucionC_Codigo) REFERENCES TipoInstitucionC;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_TipoEntidadC FOREIGN KEY (TipoEntidadC_Codigo) REFERENCES TipoEntidadC;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_EstadoCivilC FOREIGN KEY (EstadoCivilC_Codigo) REFERENCES EstadoCivil;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_EstadoPersonaC FOREIGN KEY (EstadoPersonaC_Codigo) REFERENCES EstadoPersona;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_TipoIdentificacionC FOREIGN KEY (TipoIdentificacionC_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_MunicipioCNac FOREIGN KEY (MunicipioCNac_Codigo) REFERENCES Municipio;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_DepartamentoCNac FOREIGN KEY (DepartamentoCNac_Codigo) REFERENCES Departamento;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_ContratosC FOREIGN KEY (ContratosC_ID) REFERENCES ContratoC;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_FamiliasC FOREIGN KEY (FamiliasC_ID, FamiliasC_ID_1) REFERENCES FamiliaC;
ALTER TABLE PersonaC ADD CONSTRAINT fkc_PersonaC_BeneficiariosC FOREIGN KEY (BeneficiariosC_ID, BeneficiariosC_ID_1) REFERENCES BeneficiarioC;
ALTER TABLE DireccionC ADD CONSTRAINT fkc_DireccionC_PersonaC FOREIGN KEY (ID) REFERENCES PersonaC;
ALTER TABLE DireccionC ADD CONSTRAINT fkc_DireccionC_ContratoC FOREIGN KEY (ContratoC_ID) REFERENCES ContratoC;
ALTER TABLE DireccionC ADD CONSTRAINT fkc_DireccionC_TipoDireccionC FOREIGN KEY (TipoDireccionC_Codigo) REFERENCES TipoDireccion;
ALTER TABLE DireccionC ADD CONSTRAINT fkc_DireccionC_DepartamentoC FOREIGN KEY (DepartamentoC_Codigo) REFERENCES Departamento;
ALTER TABLE DireccionC ADD CONSTRAINT fkc_DireccionC_MunicipioC FOREIGN KEY (MunicipioC_Codigo) REFERENCES Municipio;
ALTER TABLE DireccionC ADD CONSTRAINT fkc_DireccionC_PaisC FOREIGN KEY (PaisC_Codigo) REFERENCES Pais;
ALTER TABLE TelefonoC ADD CONSTRAINT fkc_TelefonoC_DirSucursalC FOREIGN KEY (DirSucursalC_Codigo) REFERENCES DirSucursalC;
ALTER TABLE TelefonoC ADD CONSTRAINT fkc_TelefonoC_DireccionC FOREIGN KEY (DireccionC_Codigo) REFERENCES DireccionC;
ALTER TABLE ProteccionDatosC ADD CONSTRAINT fkc_ProteccionDatosC_PersonaC FOREIGN KEY (ID) REFERENCES PersonaC;
ALTER TABLE ProteccionDatosC ADD CONSTRAINT fkc_ProteccionDatosC_ProductoC FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_Persona FOREIGN KEY (Persona_Identificador) REFERENCES Persona;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_TipoDireccion FOREIGN KEY (TipoDireccion_Codigo) REFERENCES TipoDireccion;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_Municipio FOREIGN KEY (Municipio_Codigo) REFERENCES Municipio;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_Departamento FOREIGN KEY (Departamento_Codigo) REFERENCES Departamento;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_Pais FOREIGN KEY (Pais_Codigo) REFERENCES Pais;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_Contrato FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Direccion ADD CONSTRAINT fkc_Direccion_Titular FOREIGN KEY (Titular_ID_SOLICITUD) REFERENCES Titular;
ALTER TABLE ProteccionDatos ADD CONSTRAINT fkc_ProteccionDatos_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE ProteccionDatos ADD CONSTRAINT fkc_ProteccionDatos_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_UsuarioPersona FOREIGN KEY (UsuarioPersona_Identificador) REFERENCES Persona;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_EPS FOREIGN KEY (Codigo) REFERENCES EPS;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_Parentesco FOREIGN KEY (Parentesco_Codigo) REFERENCES Parentesco;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_Companyia FOREIGN KEY (Companyia_Codigo) REFERENCES Companyia;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_TipoIdentificacion FOREIGN KEY (TipoIdentificacion_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE Usuario ADD CONSTRAINT fkc_Usuario_EstadoBeneficiario FOREIGN KEY (EstadoBeneficiario_Codigo) REFERENCES EstadoBeneficiario;
ALTER TABLE CuestionarioP ADD CONSTRAINT fkc_CuestionarioP_Usuario FOREIGN KEY (ID_SOLICITUD, Identificador) REFERENCES Usuario;
ALTER TABLE SeccionP ADD CONSTRAINT fkc_SeccionP_Cuestionario FOREIGN KEY (Numero) REFERENCES CuestionarioP;
ALTER TABLE PreguntaP ADD CONSTRAINT fkc_PreguntaP_Seccion FOREIGN KEY (Seccion_Identificador) REFERENCES SeccionP;
ALTER TABLE PreguntaP ADD CONSTRAINT fkc_PreguntaP_Pregunta FOREIGN KEY (Pregunta_Numero) REFERENCES Pregunta;
ALTER TABLE Contratante ADD CONSTRAINT fkc_Contratante_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Contratante ADD CONSTRAINT fkc_Contratante_TipoIdentificacion FOREIGN KEY (TipoIdentificacion_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE Contratante ADD CONSTRAINT fkc_Contratante_DepartamentoNac FOREIGN KEY (DepartamentoNac_Codigo) REFERENCES Departamento;
ALTER TABLE Contratante ADD CONSTRAINT fkc_Contratante_MunicipioNac FOREIGN KEY (MunicipioNac_Codigo) REFERENCES Municipio;
ALTER TABLE Contratante ADD CONSTRAINT fkc_Contratante_DepartamentoRes FOREIGN KEY (DepartamentoRes_Codigo) REFERENCES Departamento;
ALTER TABLE Contratante ADD CONSTRAINT fkc_Contratante_MunicipioRes FOREIGN KEY (MunicipioRes_Codigo) REFERENCES Municipio;
ALTER TABLE AnexoMat ADD CONSTRAINT fkc_AnexoMat_Usuario FOREIGN KEY (ID_SOLICITUD, Usuario_Identificador) REFERENCES Usuario;
ALTER TABLE AnexoMat ADD CONSTRAINT fkc_AnexoMat_Periodicidad FOREIGN KEY (Codigo) REFERENCES Periodicidad;
ALTER TABLE AnexoMat ADD CONSTRAINT fkc_AnexoMat_InstitucionMaternal FOREIGN KEY (InstitucionMaternal_Codigo) REFERENCES InstitucionMatNeo;
ALTER TABLE AnexoNeo ADD CONSTRAINT fkc_AnexoNeo_Usuario FOREIGN KEY (ID_SOLICITUD, Usuario_Identificador) REFERENCES Usuario;
ALTER TABLE AnexoNeo ADD CONSTRAINT fkc_AnexoNeo_Periodicidad FOREIGN KEY (Codigo) REFERENCES Periodicidad;
ALTER TABLE AnexoNeo ADD CONSTRAINT fkc_AnexoNeo_InstitucionNeonatal FOREIGN KEY (InstitucionNeonatal_Codigo) REFERENCES InstitucionMatNeo;
ALTER TABLE Firma ADD CONSTRAINT fkc_Firma_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Firma ADD CONSTRAINT fkc_Firma_SolicitudSegunda FOREIGN KEY (SolicitudSegunda_ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Firma ADD CONSTRAINT fkc_Firma_RespRegional FOREIGN KEY (Id) REFERENCES RespRegional;
ALTER TABLE Firma ADD CONSTRAINT fkc_Firma_SolicitudContratante FOREIGN KEY (SolicitudContratante_ID_SOLICI) REFERENCES Solicitud;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_PeriodicidadC FOREIGN KEY (Codigo) REFERENCES Periodicidad;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_FormaPagoC FOREIGN KEY (FormaPagoC_Codigo) REFERENCES FormaPago;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_EstadoContratoC FOREIGN KEY (EstadoContratoC_Codigo) REFERENCES EstadoContrato;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_ProductoC FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_PlanC FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_TarifaC FOREIGN KEY (TarifaC_Id) REFERENCES Tarifa;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_GrupoAsociadoC FOREIGN KEY (GrupoAsociadoC_Codigo) REFERENCES GrupoAsociado;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_MunicipioC FOREIGN KEY (MunicipioC_Codigo) REFERENCES Municipio;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_SucursalC FOREIGN KEY (SucursalC_Codigo) REFERENCES Sucursal;
ALTER TABLE ContratoC ADD CONSTRAINT fkc_ContratoC_AsesorC FOREIGN KEY (AsesorC_Id) REFERENCES Asesor;
ALTER TABLE ObservacionesC ADD CONSTRAINT fkc_ObservacionesC_ContratoC FOREIGN KEY (ID) REFERENCES ContratoC;
ALTER TABLE BeneficiarioC ADD CONSTRAINT fkc_BeneficiarioC_ContratoC FOREIGN KEY (ContratoC_ID) REFERENCES ContratoC;
ALTER TABLE BeneficiarioC ADD CONSTRAINT fkc_BeneficiarioC_FamiliasC FOREIGN KEY (FamiliasC_ID, FamiliasC_ID_1) REFERENCES FamiliaC;
ALTER TABLE BeneficiarioC ADD CONSTRAINT fkc_BeneficiarioC_EPSC FOREIGN KEY (Codigo) REFERENCES EPS;
ALTER TABLE BeneficiarioC ADD CONSTRAINT fkc_BeneficiarioC_CompanyiaMPC FOREIGN KEY (CompanyiaMPC_Codigo) REFERENCES Companyia;
ALTER TABLE BeneficiarioC ADD CONSTRAINT fkc_BeneficiarioC_ParentescoC FOREIGN KEY (ParentescoC_Codigo) REFERENCES Parentesco;
ALTER TABLE BeneficiarioC ADD CONSTRAINT fkc_BeneficiarioC_EstadoBeneficiarioC FOREIGN KEY (EstadoBeneficiarioC_Codigo) REFERENCES EstadoBeneficiario;
ALTER TABLE AnexoC ADD CONSTRAINT fkc_AnexoC_BeneficiarioC FOREIGN KEY (ID, BeneficiarioC_ID) REFERENCES BeneficiarioC;
ALTER TABLE AnexoC ADD CONSTRAINT fkc_AnexoC_PeriodicidadC FOREIGN KEY (Codigo) REFERENCES Periodicidad;
ALTER TABLE AnexoC ADD CONSTRAINT fkc_AnexoC_TipoIdentificacionC FOREIGN KEY (TipoIdentificacionC_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE PregCuesMedC ADD CONSTRAINT fkc_PregCuesMedC_PersonaC FOREIGN KEY (ID) REFERENCES PersonaC;
ALTER TABLE DirSucursalC ADD CONSTRAINT fkc_DirSucursalC_PersonaC FOREIGN KEY (ID) REFERENCES PersonaC;
ALTER TABLE DirSucursalC ADD CONSTRAINT fkc_DirSucursalC_MunicipioC FOREIGN KEY (MunicipioC_Codigo) REFERENCES Municipio;
ALTER TABLE DirSucursalC ADD CONSTRAINT fkc_DirSucursalC_DepartamentoC FOREIGN KEY (DepartamentoC_Codigo) REFERENCES Departamento;
ALTER TABLE DirSucursalC ADD CONSTRAINT fkc_DirSucursalC_PaisC FOREIGN KEY (PaisC_Codigo) REFERENCES Pais;
ALTER TABLE DirSucursalC ADD CONSTRAINT fkc_DirSucursalC_RegionalC FOREIGN KEY (RegionalC_Codigo) REFERENCES Regional;
ALTER TABLE FamiliaC ADD CONSTRAINT fkc_FamiliaC_ContratoC FOREIGN KEY (ContratoC_ID) REFERENCES ContratoC;
ALTER TABLE FamiliaC ADD CONSTRAINT fkc_FamiliaC_MunicipioC FOREIGN KEY (Codigo) REFERENCES Municipio;
ALTER TABLE UsuarioReg ADD CONSTRAINT fkc_UsuarioReg_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE UsuarioReg ADD CONSTRAINT fkc_UsuarioReg_EstadoBeneficiario FOREIGN KEY (Codigo) REFERENCES EstadoBeneficiario;
ALTER TABLE UsuarioReg ADD CONSTRAINT fkc_UsuarioReg_Parentesco FOREIGN KEY (Parentesco_Codigo) REFERENCES Parentesco;
ALTER TABLE Titular ADD CONSTRAINT fkc_Titular_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Titular ADD CONSTRAINT fkc_Titular_TipoIdentificacion FOREIGN KEY (TipoIdentificacion_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE Titular ADD CONSTRAINT fkc_Titular_DepartamentoNac FOREIGN KEY (DepartamentoNac_Codigo) REFERENCES Departamento;
ALTER TABLE Titular ADD CONSTRAINT fkc_Titular_MunicipioNac FOREIGN KEY (MunicipioNac_Codigo) REFERENCES Municipio;
ALTER TABLE PreexistenciaC ADD CONSTRAINT fkc_PreexistenciaC_PersonaC FOREIGN KEY (ID) REFERENCES PersonaC;
ALTER TABLE Preexistencia ADD CONSTRAINT fkc_Preexistencia_Usuario FOREIGN KEY (ID_SOLICITUD, Usuario_Identificador) REFERENCES Usuario;
ALTER TABLE DocumentoG ADD CONSTRAINT fkc_DocumentoG_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE DocumentoG ADD CONSTRAINT fkc_DocumentoG_Persona FOREIGN KEY (Persona_Identificador) REFERENCES Persona;
ALTER TABLE ObsEstado ADD CONSTRAINT fkc_ObsEstado_DocumentoG FOREIGN KEY (Identificador) REFERENCES DocumentoG;
ALTER TABLE ObsEstado ADD CONSTRAINT fkc_ObsEstado_Agente FOREIGN KEY (Agente_Id) REFERENCES Funcionario;
ALTER TABLE ErrorWS ADD CONSTRAINT fkc_ErrorWS_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE ParentescoDom ADD CONSTRAINT fkc_ParentescoDom_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE ParentescoDom ADD CONSTRAINT fkc_ParentescoDom_Parentesco FOREIGN KEY (Codigo) REFERENCES Parentesco;
ALTER TABLE MarcaMedicaC ADD CONSTRAINT fkc_MarcaMedicaC_PersonaC FOREIGN KEY (ID) REFERENCES PersonaC;
ALTER TABLE MarcaMedicaC ADD CONSTRAINT fkc_MarcaMedicaC_ProductoC FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE ConceptoC ADD CONSTRAINT fkc_ConceptoC_BeneficiarioC FOREIGN KEY (ID, BeneficiarioC_ID) REFERENCES BeneficiarioC;
ALTER TABLE DetalleTarifa ADD CONSTRAINT fkc_DetalleTarifa_Tarifa FOREIGN KEY (Id) REFERENCES Tarifa;
ALTER TABLE AgentexProducto ADD CONSTRAINT fkc_AgentexProducto_Asesor FOREIGN KEY (Asesor_Id) REFERENCES Asesor;
ALTER TABLE AgentexProducto ADD CONSTRAINT fkc_AgentexProducto_ProductoT FOREIGN KEY (Producto) REFERENCES Productos;
ALTER TABLE InstitucionMatNeo ADD CONSTRAINT fkc_InstitucionMatNeo_TipoIdentificacion FOREIGN KEY (TipoIdentificacion_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE InstitucionMatNeo ADD CONSTRAINT fkc_InstitucionMatNeo_Tarifa FOREIGN KEY (Id) REFERENCES Tarifa;
ALTER TABLE InstitucionMatNeo ADD CONSTRAINT fkc_InstitucionMatNeo_Municipio FOREIGN KEY (Municipio_Codigo) REFERENCES Municipio;
ALTER TABLE LogEstado ADD CONSTRAINT fkc_LogEstado_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE LogAsignaciones ADD CONSTRAINT fkc_LogAsignaciones_Solicitud FOREIGN KEY (ID_SOLICITUD) REFERENCES Solicitud;
ALTER TABLE Prorrateo ADD CONSTRAINT fkc_Prorrateo_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE ParamReporte ADD CONSTRAINT fkc_ParamReporte_Reporte FOREIGN KEY (id_Reporte) REFERENCES ReportesProcAlm;
ALTER TABLE Novedad ADD CONSTRAINT fkc_Novedad_TipoNovedad FOREIGN KEY (Tipo) REFERENCES TipoNovedad;
ALTER TABLE Causal ADD CONSTRAINT fkc_Causal_Novedad FOREIGN KEY (id_Novedad) REFERENCES Novedad;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_PlanT FOREIGN KEY (Plan) REFERENCES Planes;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_Novedad FOREIGN KEY (id_Novedad) REFERENCES Novedad;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_Causal FOREIGN KEY (id_Causal) REFERENCES Causal;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_ProteccionDatos FOREIGN KEY (Identificador) REFERENCES ProteccionDatos;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_TipoIdentContratante FOREIGN KEY (Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_EstadoContrato FOREIGN KEY (EstadoContrato_Codigo) REFERENCES EstadoContrato;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_GrupoAsociado FOREIGN KEY (GrupoAsociado_Codigo) REFERENCES GrupoAsociado;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_Periodicidad FOREIGN KEY (Periodicidad_Codigo) REFERENCES Periodicidad;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_Agente FOREIGN KEY (Agente_Id) REFERENCES Funcionario;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_PeriodicidadNueva FOREIGN KEY (PeriodicidadNueva_Codigo) REFERENCES Periodicidad;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_MotivoExcepcion FOREIGN KEY (MotivoExcepcion_Id) REFERENCES MotivoExcepcionSolNov;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_UsrAfiliacion FOREIGN KEY (UsrAfiliacion_Id) REFERENCES Funcionario;
ALTER TABLE SolicitudNovedad ADD CONSTRAINT fkc_SolicitudNovedad_Firma FOREIGN KEY (Firma_Identificador) REFERENCES Firma;
ALTER TABLE FamiliaNovedad ADD CONSTRAINT fkc_FamiliaNovedad_Solicitud FOREIGN KEY (Id) REFERENCES SolicitudNovedad;
ALTER TABLE FamiliaNovedad ADD CONSTRAINT fkc_FamiliaNovedad_TipoIdentificacion FOREIGN KEY (Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE FamiliaNovedad ADD CONSTRAINT fkc_FamiliaNovedad_Firma FOREIGN KEY (Identificador) REFERENCES Firma;
ALTER TABLE UsuarioNovedad ADD CONSTRAINT fkc_UsuarioNovedad_FamiliaNovedad FOREIGN KEY (id_FamiliaNovedad) REFERENCES FamiliaNovedad;
ALTER TABLE UsuarioNovedad ADD CONSTRAINT fkc_UsuarioNovedad_TipoIdentificacion FOREIGN KEY (Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE UsuarioNovedad ADD CONSTRAINT fkc_UsuarioNovedad_Parentesco FOREIGN KEY (Parentesco_Codigo) REFERENCES Parentesco;
ALTER TABLE UsuarioNovedad ADD CONSTRAINT fkc_UsuarioNovedad_EstadoBeneficiario FOREIGN KEY (EstadoBeneficiario_Codigo) REFERENCES EstadoBeneficiario;
ALTER TABLE UsuarioNovedad ADD CONSTRAINT fkc_UsuarioNovedad_ParentescoNuevo FOREIGN KEY (ParentescoNuevo_Codigo) REFERENCES Parentesco;
ALTER TABLE UsuarioNovedad ADD CONSTRAINT fkc_UsuarioNovedad_TipoIdentificacionCD FOREIGN KEY (TipoIdentificacionCD_Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE CausaExclusion ADD CONSTRAINT fkc_CausaExclusion_Novedad FOREIGN KEY (id_Novedad) REFERENCES Novedad;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_FamiliaNovedad FOREIGN KEY (id_FamiliaNovedad) REFERENCES FamiliaNovedad;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_TipoIdentificacion FOREIGN KEY (Codigo) REFERENCES TipoIdentificacion;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_Firma FOREIGN KEY (Identificador) REFERENCES Firma;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_MunicipioNac FOREIGN KEY (MunicipioNac_Codigo) REFERENCES Municipio;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_MunicipioRes FOREIGN KEY (MunicipioRes_Codigo) REFERENCES Municipio;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_DepartamentoNac FOREIGN KEY (DepartamentoNac_Codigo) REFERENCES Departamento;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_DepartamentoRes FOREIGN KEY (DepartamentoRes_Codigo) REFERENCES Departamento;
ALTER TABLE NovedadCT ADD CONSTRAINT fkc_NovedadCT_Pais FOREIGN KEY (Pais_Codigo) REFERENCES Pais;
ALTER TABLE DocumentoNovedad ADD CONSTRAINT fkc_DocumentoNovedad_Solicitud FOREIGN KEY (Id) REFERENCES SolicitudNovedad;
ALTER TABLE DocumentoNovedad ADD CONSTRAINT fkc_DocumentoNovedad_Usuario FOREIGN KEY (id_UsuarioNovedad) REFERENCES UsuarioNovedad;
ALTER TABLE NovedadMD ADD CONSTRAINT fkc_NovedadMD_FamiliaNovedad FOREIGN KEY (id_FamiliaNovedad) REFERENCES FamiliaNovedad;
ALTER TABLE NovedadMD ADD CONSTRAINT fkc_NovedadMD_Pais FOREIGN KEY (Codigo) REFERENCES Pais;
ALTER TABLE NovedadMD ADD CONSTRAINT fkc_NovedadMD_Departamento FOREIGN KEY (Departamento_Codigo) REFERENCES Departamento;
ALTER TABLE NovedadMD ADD CONSTRAINT fkc_NovedadMD_Municipio FOREIGN KEY (Municipio_Codigo) REFERENCES Municipio;
ALTER TABLE LogEstadoSN ADD CONSTRAINT fkc_LogEstadoSN_SolicitudNovedad FOREIGN KEY (SolicitudNovedad_Id) REFERENCES SolicitudNovedad;
ALTER TABLE LogPriorizacionSol ADD CONSTRAINT fkc_LogPriorizacionSol_PriSolicitud FOREIGN KEY (PriSolicitud_EstadoSolicitud, PriSolicitud_EstadoDoc) REFERENCES PriorizacionSolicitudes;
ALTER TABLE LogGrupoAsignacion ADD CONSTRAINT fkc_LogGrupoAsignacion_GrupoAsignacion FOREIGN KEY (GrupoAsignacion_Id) REFERENCES GrupoAsignacion;
ALTER TABLE LogGruposUsuarios ADD CONSTRAINT fkc_LogGruposUsuarios_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE GrupoAsignacionNovedad ADD CONSTRAINT fkc_GrupoAsignacionNovedad_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE GrupoAsignacionNovedad ADD CONSTRAINT fkc_GrupoAsignacionNovedad_Causal FOREIGN KEY (id_Causal) REFERENCES Causal;
ALTER TABLE GrupoAsignacionNovedad ADD CONSTRAINT fkc_GrupoAsignacionNovedad_GrupoUsuarios FOREIGN KEY (GrupoUsuarios_Id) REFERENCES GrupoAsignacion;
ALTER TABLE LogFuncionario ADD CONSTRAINT fkc_LogFuncionario_Funcionario FOREIGN KEY (Funcionario_Id) REFERENCES Funcionario;
ALTER TABLE LogUsrSolNov ADD CONSTRAINT fkc_LogUsrSolNov_SolicitudNovedad FOREIGN KEY (SolicitudNovedad_Id) REFERENCES SolicitudNovedad;
ALTER TABLE ConfiguracionANS ADD CONSTRAINT fkc_ConfiguracionANS_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE ConfiguracionANS ADD CONSTRAINT fkc_ConfiguracionANS_Novedad FOREIGN KEY (id_Novedad) REFERENCES Novedad;
ALTER TABLE ConfiguracionANS ADD CONSTRAINT fkc_ConfiguracionANS_Causal FOREIGN KEY (id_Causal) REFERENCES Causal;
ALTER TABLE LogConfiguracionANS ADD CONSTRAINT fkc_LogConfiguracionANS_ConfiguracionANS FOREIGN KEY (ConfiguracionANS_Id) REFERENCES ConfiguracionANS;
ALTER TABLE LogEstadoDocNov ADD CONSTRAINT fkc_LogEstadoDocNov_DocumentoNovedad FOREIGN KEY (IdDocumento) REFERENCES DocumentoNovedad;
ALTER TABLE ReportesDominio ADD CONSTRAINT fkc_ReportesDominio_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE ReportesDominio ADD CONSTRAINT fkc_ReportesDominio_PlantillaReporte FOREIGN KEY (id_PlantillaReporte) REFERENCES PlantillaReporte;
ALTER TABLE LogInformacionAsesor ADD CONSTRAINT fkc_LogInformacionAsesor_Asesor FOREIGN KEY (Id) REFERENCES Asesor;
ALTER TABLE LogHistoricoPlanes ADD CONSTRAINT fkc_LogHistoricoPlanes_Asesor FOREIGN KEY (Id) REFERENCES Asesor;
ALTER TABLE LogIncompatibilidades ADD CONSTRAINT fkc_LogIncompatibilidades_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
ALTER TABLE LogDatosDominio ADD CONSTRAINT fkc_LogDatosDominio_Dominio FOREIGN KEY (Numero) REFERENCES Dominio;
