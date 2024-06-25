package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudPIUStatusAfil {

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("estadodoc")
    private Long dSSolicitudPIUStatusAfilEstadoDoc;

    @JsonProperty("drvestadohomologado")
    private Long dSSolicitudPIUStatusAfilDrvEstadoHomologado;

    @JsonProperty("fechacompletada")
    private Timestamp dSSolicitudPIUStatusAfilFechaCompletada;

    @JsonProperty("fechaultimodoc")
    private Timestamp dSSolicitudPIUStatusAfilFechaUltimoDoc;

    @JsonProperty("finiciocontrato")
    private Date dSSolicitudPIUStatusAfilFInicioContrato;

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("tramite")
    private Long dSSolicitudPIUStatusAfilTramite;

    @JsonProperty("drvnumcontrato")
    private String dSSolicitudPIUStatusAfilDrvNumContrato;

    @JsonProperty("prioridad")
    private Long dSSolicitudPIUStatusAfilPrioridad;

    @JsonProperty("drvsemaforograbase")
    private Double dSSolicitudPIUStatusAfilDrvSemaforoGrabAse;

    @JsonProperty("agente_drvnombrecompleto")
    private String dSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto;

    public DSSolicitudPIUStatusAfil() {
    
    }

    public DSSolicitudPIUStatusAfil(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIUStatusAfilEstadoDoc = instance.getSolicitudEstadoDoc();
                this.dSSolicitudPIUStatusAfilDrvEstadoHomologado = instance.getSolicitudDrvEstadoHomologado();
                this.dSSolicitudPIUStatusAfilFechaCompletada = instance.getSolicitudFechaCompletada();
                this.dSSolicitudPIUStatusAfilFechaUltimoDoc = instance.getSolicitudFechaUltimoDoc();
                this.dSSolicitudPIUStatusAfilFInicioContrato = instance.getSolicitudFInicioContrato();
                this.dSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIUStatusAfilTramite = instance.getSolicitudTramite();
                this.dSSolicitudPIUStatusAfilDrvNumContrato = instance.getSolicituddrvNumContrato();
                this.dSSolicitudPIUStatusAfilPrioridad = instance.getSolicitudPrioridad();
                this.dSSolicitudPIUStatusAfilDrvSemaforoGrabAse = instance.getSolicituddrvSemaforoGrabAse();
                this.dSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto = instance.getAgente().getFuncionariodrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIUStatusAfilAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIUStatusAfilAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAfilEstadoDoc() {
        return this.dSSolicitudPIUStatusAfilEstadoDoc;
    }
    
    public void setDSSolicitudPIUStatusAfilEstadoDoc(Long dSSolicitudPIUStatusAfilEstadoDoc) {
        this.dSSolicitudPIUStatusAfilEstadoDoc = dSSolicitudPIUStatusAfilEstadoDoc;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAfilDrvEstadoHomologado() {
        return this.dSSolicitudPIUStatusAfilDrvEstadoHomologado;
    }
    
    public void setDSSolicitudPIUStatusAfilDrvEstadoHomologado(Long dSSolicitudPIUStatusAfilDrvEstadoHomologado) {
        this.dSSolicitudPIUStatusAfilDrvEstadoHomologado = dSSolicitudPIUStatusAfilDrvEstadoHomologado;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusAfilFechaCompletada() {
        return this.dSSolicitudPIUStatusAfilFechaCompletada;
    }
    
    public void setDSSolicitudPIUStatusAfilFechaCompletada(Timestamp dSSolicitudPIUStatusAfilFechaCompletada) {
        this.dSSolicitudPIUStatusAfilFechaCompletada = dSSolicitudPIUStatusAfilFechaCompletada;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusAfilFechaUltimoDoc() {
        return this.dSSolicitudPIUStatusAfilFechaUltimoDoc;
    }
    
    public void setDSSolicitudPIUStatusAfilFechaUltimoDoc(Timestamp dSSolicitudPIUStatusAfilFechaUltimoDoc) {
        this.dSSolicitudPIUStatusAfilFechaUltimoDoc = dSSolicitudPIUStatusAfilFechaUltimoDoc;
    }

    @JsonIgnore
    public Date getDSSolicitudPIUStatusAfilFInicioContrato() {
        return this.dSSolicitudPIUStatusAfilFInicioContrato;
    }
    
    public void setDSSolicitudPIUStatusAfilFInicioContrato(Date dSSolicitudPIUStatusAfilFInicioContrato) {
        this.dSSolicitudPIUStatusAfilFInicioContrato = dSSolicitudPIUStatusAfilFInicioContrato;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIUStatusAfilAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAfilTramite() {
        return this.dSSolicitudPIUStatusAfilTramite;
    }
    
    public void setDSSolicitudPIUStatusAfilTramite(Long dSSolicitudPIUStatusAfilTramite) {
        this.dSSolicitudPIUStatusAfilTramite = dSSolicitudPIUStatusAfilTramite;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAfilDrvNumContrato() {
        return this.dSSolicitudPIUStatusAfilDrvNumContrato;
    }
    
    public void setDSSolicitudPIUStatusAfilDrvNumContrato(String dSSolicitudPIUStatusAfilDrvNumContrato) {
        this.dSSolicitudPIUStatusAfilDrvNumContrato = dSSolicitudPIUStatusAfilDrvNumContrato;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAfilPrioridad() {
        return this.dSSolicitudPIUStatusAfilPrioridad;
    }
    
    public void setDSSolicitudPIUStatusAfilPrioridad(Long dSSolicitudPIUStatusAfilPrioridad) {
        this.dSSolicitudPIUStatusAfilPrioridad = dSSolicitudPIUStatusAfilPrioridad;
    }

    @JsonIgnore
    public Double getDSSolicitudPIUStatusAfilDrvSemaforoGrabAse() {
        return this.dSSolicitudPIUStatusAfilDrvSemaforoGrabAse;
    }
    
    public void setDSSolicitudPIUStatusAfilDrvSemaforoGrabAse(Double dSSolicitudPIUStatusAfilDrvSemaforoGrabAse) {
        this.dSSolicitudPIUStatusAfilDrvSemaforoGrabAse = dSSolicitudPIUStatusAfilDrvSemaforoGrabAse;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto() {
        return this.dSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto;
    }
    
    public void setDSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto(String dSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto) {
        this.dSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto = dSSolicitudPIUStatusAfilAgenteDotDrvNombreCompleto;
    }
}
