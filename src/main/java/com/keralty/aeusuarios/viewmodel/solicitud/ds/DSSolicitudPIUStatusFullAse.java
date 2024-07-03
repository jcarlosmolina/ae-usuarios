package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudPIUStatusFullAse {

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("estadodoc")
    private Long dSSolicitudPIUStatusFullAseEstadoDoc;

    @JsonProperty("estado")
    private Long dSSolicitudPIUStatusFullAseEstado;

    @JsonProperty("fechacompletada")
    private Timestamp dSSolicitudPIUStatusFullAseFechaCompletada;

    @JsonProperty("fechaultimodoc")
    private Timestamp dSSolicitudPIUStatusFullAseFechaUltimoDoc;

    @JsonProperty("finiciocontrato")
    private Date dSSolicitudPIUStatusFullAseFInicioContrato;

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("tramite")
    private Long dSSolicitudPIUStatusFullAseTramite;

    @JsonProperty("drvnumcontrato")
    private String dSSolicitudPIUStatusFullAseDrvNumContrato;

    @JsonProperty("agente_drvnombrecompleto")
    private String dSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto;

    @JsonProperty("prioridad")
    private Long dSSolicitudPIUStatusFullAsePrioridad;

    @JsonProperty("aesolicitudes_fechaasignacion")
    private Date dSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION;

    @JsonProperty("drvtieneprimerafirma")
    private Boolean dSSolicitudPIUStatusFullAseDrvTienePrimeraFirma;

    @JsonProperty("agente_sucursal_descripcion")
    private String dSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion;

    @JsonProperty("agente_sucursal_regional_descripcion")
    private String dSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion;

    @JsonProperty("agente_drvnomjefe")
    private String dSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe;

    @JsonProperty("agente_drvnomagencia")
    private String dSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia;

    @JsonProperty("drvalgunbeneficiarioepssanitas")
    private Boolean dSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas;

    @JsonProperty("drvpolizainternacional")
    private Boolean dSSolicitudPIUStatusFullAseDrvPolizaInternacional;

    @JsonProperty("drvlistaerrores")
    private String dSSolicitudPIUStatusFullAseDrvListaErrores;

    @JsonProperty("observacions")
    private String dSSolicitudPIUStatusFullAseObservacions;

    @JsonProperty("enviocarnetfisico")
    private Boolean dSSolicitudPIUStatusFullAseEnvioCarnetFisico;

    public DSSolicitudPIUStatusFullAse() {
    
    }

    public DSSolicitudPIUStatusFullAse(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIUStatusFullAseEstadoDoc = instance.getSolicitudEstadoDoc();
                this.dSSolicitudPIUStatusFullAseEstado = instance.getSolicitudEstado();
                this.dSSolicitudPIUStatusFullAseFechaCompletada = instance.getSolicitudFechaCompletada();
                this.dSSolicitudPIUStatusFullAseFechaUltimoDoc = instance.getSolicitudFechaUltimoDoc();
                this.dSSolicitudPIUStatusFullAseFInicioContrato = instance.getSolicitudFInicioContrato();
                this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIUStatusFullAseTramite = instance.getSolicitudTramite();
                this.dSSolicitudPIUStatusFullAseDrvNumContrato = instance.getSolicituddrvNumContrato();
                this.dSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto = instance.getAgente().getFuncionariodrvNombreCompleto();
                this.dSSolicitudPIUStatusFullAsePrioridad = instance.getSolicitudPrioridad();
                this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION = instance.getAESOLICITUDES().getAESOLICITUDESFECHAASIGNACION();
                this.dSSolicitudPIUStatusFullAseDrvTienePrimeraFirma = instance.getSolicituddrvTienePrimeraFirma();
                this.dSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion = instance.getAgente().getSucursal().getSucursalDescripcion();
                this.dSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion = instance.getAgente().getSucursal().getRegional().getRegionalDescripcion();
                this.dSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe = instance.getAgente().getFuncionariodrvNomJefe();
                this.dSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia = instance.getAgente().getFuncionariodrvNomAgencia();
                this.dSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas = instance.getSolicituddrvAlgunBeneficiarioEPSSanitas();
                this.dSSolicitudPIUStatusFullAseDrvPolizaInternacional = instance.getSolicituddrvPolizaInternacional();
                this.dSSolicitudPIUStatusFullAseDrvListaErrores = instance.getSolicituddrvListaErrores();
                this.dSSolicitudPIUStatusFullAseObservacions = instance.getSolicitudobservacions();
                this.dSSolicitudPIUStatusFullAseEnvioCarnetFisico = instance.getSolicitudEnvioCarnetFisico();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIUStatusFullAseAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIUStatusFullAseAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusFullAseEstadoDoc() {
        return this.dSSolicitudPIUStatusFullAseEstadoDoc;
    }
    
    public void setDSSolicitudPIUStatusFullAseEstadoDoc(Long dSSolicitudPIUStatusFullAseEstadoDoc) {
        this.dSSolicitudPIUStatusFullAseEstadoDoc = dSSolicitudPIUStatusFullAseEstadoDoc;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusFullAseEstado() {
        return this.dSSolicitudPIUStatusFullAseEstado;
    }
    
    public void setDSSolicitudPIUStatusFullAseEstado(Long dSSolicitudPIUStatusFullAseEstado) {
        this.dSSolicitudPIUStatusFullAseEstado = dSSolicitudPIUStatusFullAseEstado;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusFullAseFechaCompletada() {
        return this.dSSolicitudPIUStatusFullAseFechaCompletada;
    }
    
    public void setDSSolicitudPIUStatusFullAseFechaCompletada(Timestamp dSSolicitudPIUStatusFullAseFechaCompletada) {
        this.dSSolicitudPIUStatusFullAseFechaCompletada = dSSolicitudPIUStatusFullAseFechaCompletada;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusFullAseFechaUltimoDoc() {
        return this.dSSolicitudPIUStatusFullAseFechaUltimoDoc;
    }
    
    public void setDSSolicitudPIUStatusFullAseFechaUltimoDoc(Timestamp dSSolicitudPIUStatusFullAseFechaUltimoDoc) {
        this.dSSolicitudPIUStatusFullAseFechaUltimoDoc = dSSolicitudPIUStatusFullAseFechaUltimoDoc;
    }

    @JsonIgnore
    public Date getDSSolicitudPIUStatusFullAseFInicioContrato() {
        return this.dSSolicitudPIUStatusFullAseFInicioContrato;
    }
    
    public void setDSSolicitudPIUStatusFullAseFInicioContrato(Date dSSolicitudPIUStatusFullAseFInicioContrato) {
        this.dSSolicitudPIUStatusFullAseFInicioContrato = dSSolicitudPIUStatusFullAseFInicioContrato;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIUStatusFullAseAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusFullAseTramite() {
        return this.dSSolicitudPIUStatusFullAseTramite;
    }
    
    public void setDSSolicitudPIUStatusFullAseTramite(Long dSSolicitudPIUStatusFullAseTramite) {
        this.dSSolicitudPIUStatusFullAseTramite = dSSolicitudPIUStatusFullAseTramite;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseDrvNumContrato() {
        return this.dSSolicitudPIUStatusFullAseDrvNumContrato;
    }
    
    public void setDSSolicitudPIUStatusFullAseDrvNumContrato(String dSSolicitudPIUStatusFullAseDrvNumContrato) {
        this.dSSolicitudPIUStatusFullAseDrvNumContrato = dSSolicitudPIUStatusFullAseDrvNumContrato;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto() {
        return this.dSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto;
    }
    
    public void setDSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto(String dSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto) {
        this.dSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto = dSSolicitudPIUStatusFullAseAgenteDotDrvNombreCompleto;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusFullAsePrioridad() {
        return this.dSSolicitudPIUStatusFullAsePrioridad;
    }
    
    public void setDSSolicitudPIUStatusFullAsePrioridad(Long dSSolicitudPIUStatusFullAsePrioridad) {
        this.dSSolicitudPIUStatusFullAsePrioridad = dSSolicitudPIUStatusFullAsePrioridad;
    }

    @JsonIgnore
    public Date getDSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION() {
        return this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION;
    }
    
    public void setDSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION(Date dSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION) {
        this.dSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION = dSSolicitudPIUStatusFullAseAESOLICITUDESDotFECHAASIGNACION;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUStatusFullAseDrvTienePrimeraFirma() {
        return this.dSSolicitudPIUStatusFullAseDrvTienePrimeraFirma;
    }
    
    public void setDSSolicitudPIUStatusFullAseDrvTienePrimeraFirma(Boolean dSSolicitudPIUStatusFullAseDrvTienePrimeraFirma) {
        this.dSSolicitudPIUStatusFullAseDrvTienePrimeraFirma = dSSolicitudPIUStatusFullAseDrvTienePrimeraFirma;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion() {
        return this.dSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion;
    }
    
    public void setDSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion(String dSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion) {
        this.dSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion = dSSolicitudPIUStatusFullAseAgenteDotSucursalDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion() {
        return this.dSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion;
    }
    
    public void setDSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion(String dSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion) {
        this.dSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion = dSSolicitudPIUStatusFullAseAgenteDotSucursalDotRegionalDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe() {
        return this.dSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe;
    }
    
    public void setDSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe(String dSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe) {
        this.dSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe = dSSolicitudPIUStatusFullAseAgenteDotDrvNomJefe;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia() {
        return this.dSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia;
    }
    
    public void setDSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia(String dSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia) {
        this.dSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia = dSSolicitudPIUStatusFullAseAgenteDotDrvNomAgencia;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas() {
        return this.dSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas;
    }
    
    public void setDSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas(Boolean dSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas) {
        this.dSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas = dSSolicitudPIUStatusFullAseDrvAlgunBeneficiarioEPSSanitas;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUStatusFullAseDrvPolizaInternacional() {
        return this.dSSolicitudPIUStatusFullAseDrvPolizaInternacional;
    }
    
    public void setDSSolicitudPIUStatusFullAseDrvPolizaInternacional(Boolean dSSolicitudPIUStatusFullAseDrvPolizaInternacional) {
        this.dSSolicitudPIUStatusFullAseDrvPolizaInternacional = dSSolicitudPIUStatusFullAseDrvPolizaInternacional;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseDrvListaErrores() {
        return this.dSSolicitudPIUStatusFullAseDrvListaErrores;
    }
    
    public void setDSSolicitudPIUStatusFullAseDrvListaErrores(String dSSolicitudPIUStatusFullAseDrvListaErrores) {
        this.dSSolicitudPIUStatusFullAseDrvListaErrores = dSSolicitudPIUStatusFullAseDrvListaErrores;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusFullAseObservacions() {
        return this.dSSolicitudPIUStatusFullAseObservacions;
    }
    
    public void setDSSolicitudPIUStatusFullAseObservacions(String dSSolicitudPIUStatusFullAseObservacions) {
        this.dSSolicitudPIUStatusFullAseObservacions = dSSolicitudPIUStatusFullAseObservacions;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUStatusFullAseEnvioCarnetFisico() {
        return this.dSSolicitudPIUStatusFullAseEnvioCarnetFisico;
    }
    
    public void setDSSolicitudPIUStatusFullAseEnvioCarnetFisico(Boolean dSSolicitudPIUStatusFullAseEnvioCarnetFisico) {
        this.dSSolicitudPIUStatusFullAseEnvioCarnetFisico = dSSolicitudPIUStatusFullAseEnvioCarnetFisico;
    }
}
