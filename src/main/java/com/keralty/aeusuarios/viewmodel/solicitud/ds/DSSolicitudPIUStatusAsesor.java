package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudPIUStatusAsesor {

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("estadodoc")
    private Long dSSolicitudPIUStatusAsesorEstadoDoc;

    @JsonProperty("drvestadohomologado")
    private Long dSSolicitudPIUStatusAsesorDrvEstadoHomologado;

    @JsonProperty("fechacompletada")
    private Timestamp dSSolicitudPIUStatusAsesorFechaCompletada;

    @JsonProperty("fechaultimodoc")
    private Timestamp dSSolicitudPIUStatusAsesorFechaUltimoDoc;

    @JsonProperty("finiciocontrato")
    private Date dSSolicitudPIUStatusAsesorFInicioContrato;

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("tramite")
    private Long dSSolicitudPIUStatusAsesorTramite;

    @JsonProperty("drvnumcontrato")
    private String dSSolicitudPIUStatusAsesorDrvNumContrato;

    @JsonProperty("prioridad")
    private Long dSSolicitudPIUStatusAsesorPrioridad;

    @JsonProperty("agente_drvnombrecompleto")
    private String dSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto;

    public DSSolicitudPIUStatusAsesor() {
    
    }

    public DSSolicitudPIUStatusAsesor(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIUStatusAsesorEstadoDoc = instance.getSolicitudEstadoDoc();
                this.dSSolicitudPIUStatusAsesorDrvEstadoHomologado = instance.getSolicitudDrvEstadoHomologado();
                this.dSSolicitudPIUStatusAsesorFechaCompletada = instance.getSolicitudFechaCompletada();
                this.dSSolicitudPIUStatusAsesorFechaUltimoDoc = instance.getSolicitudFechaUltimoDoc();
                this.dSSolicitudPIUStatusAsesorFInicioContrato = instance.getSolicitudFInicioContrato();
                this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIUStatusAsesorTramite = instance.getSolicitudTramite();
                this.dSSolicitudPIUStatusAsesorDrvNumContrato = instance.getSolicituddrvNumContrato();
                this.dSSolicitudPIUStatusAsesorPrioridad = instance.getSolicitudPrioridad();
                this.dSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto = instance.getAgente().getFuncionariodrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIUStatusAsesorAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIUStatusAsesorAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAsesorEstadoDoc() {
        return this.dSSolicitudPIUStatusAsesorEstadoDoc;
    }
    
    public void setDSSolicitudPIUStatusAsesorEstadoDoc(Long dSSolicitudPIUStatusAsesorEstadoDoc) {
        this.dSSolicitudPIUStatusAsesorEstadoDoc = dSSolicitudPIUStatusAsesorEstadoDoc;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAsesorDrvEstadoHomologado() {
        return this.dSSolicitudPIUStatusAsesorDrvEstadoHomologado;
    }
    
    public void setDSSolicitudPIUStatusAsesorDrvEstadoHomologado(Long dSSolicitudPIUStatusAsesorDrvEstadoHomologado) {
        this.dSSolicitudPIUStatusAsesorDrvEstadoHomologado = dSSolicitudPIUStatusAsesorDrvEstadoHomologado;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusAsesorFechaCompletada() {
        return this.dSSolicitudPIUStatusAsesorFechaCompletada;
    }
    
    public void setDSSolicitudPIUStatusAsesorFechaCompletada(Timestamp dSSolicitudPIUStatusAsesorFechaCompletada) {
        this.dSSolicitudPIUStatusAsesorFechaCompletada = dSSolicitudPIUStatusAsesorFechaCompletada;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusAsesorFechaUltimoDoc() {
        return this.dSSolicitudPIUStatusAsesorFechaUltimoDoc;
    }
    
    public void setDSSolicitudPIUStatusAsesorFechaUltimoDoc(Timestamp dSSolicitudPIUStatusAsesorFechaUltimoDoc) {
        this.dSSolicitudPIUStatusAsesorFechaUltimoDoc = dSSolicitudPIUStatusAsesorFechaUltimoDoc;
    }

    @JsonIgnore
    public Date getDSSolicitudPIUStatusAsesorFInicioContrato() {
        return this.dSSolicitudPIUStatusAsesorFInicioContrato;
    }
    
    public void setDSSolicitudPIUStatusAsesorFInicioContrato(Date dSSolicitudPIUStatusAsesorFInicioContrato) {
        this.dSSolicitudPIUStatusAsesorFInicioContrato = dSSolicitudPIUStatusAsesorFInicioContrato;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIUStatusAsesorAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAsesorTramite() {
        return this.dSSolicitudPIUStatusAsesorTramite;
    }
    
    public void setDSSolicitudPIUStatusAsesorTramite(Long dSSolicitudPIUStatusAsesorTramite) {
        this.dSSolicitudPIUStatusAsesorTramite = dSSolicitudPIUStatusAsesorTramite;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAsesorDrvNumContrato() {
        return this.dSSolicitudPIUStatusAsesorDrvNumContrato;
    }
    
    public void setDSSolicitudPIUStatusAsesorDrvNumContrato(String dSSolicitudPIUStatusAsesorDrvNumContrato) {
        this.dSSolicitudPIUStatusAsesorDrvNumContrato = dSSolicitudPIUStatusAsesorDrvNumContrato;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAsesorPrioridad() {
        return this.dSSolicitudPIUStatusAsesorPrioridad;
    }
    
    public void setDSSolicitudPIUStatusAsesorPrioridad(Long dSSolicitudPIUStatusAsesorPrioridad) {
        this.dSSolicitudPIUStatusAsesorPrioridad = dSSolicitudPIUStatusAsesorPrioridad;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto() {
        return this.dSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto;
    }
    
    public void setDSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto(String dSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto) {
        this.dSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto = dSSolicitudPIUStatusAsesorAgenteDotDrvNombreCompleto;
    }
}
