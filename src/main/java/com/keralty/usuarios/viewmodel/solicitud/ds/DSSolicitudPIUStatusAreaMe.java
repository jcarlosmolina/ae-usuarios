package com.keralty.usuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Solicitud;
public class DSSolicitudPIUStatusAreaMe {

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("estadodoc")
    private Long dSSolicitudPIUStatusAreaMeEstadoDoc;

    @JsonProperty("drvestadohomologado")
    private Long dSSolicitudPIUStatusAreaMeDrvEstadoHomologado;

    @JsonProperty("fechacompletada")
    private Timestamp dSSolicitudPIUStatusAreaMeFechaCompletada;

    @JsonProperty("fechaultimodoc")
    private Timestamp dSSolicitudPIUStatusAreaMeFechaUltimoDoc;

    @JsonProperty("finiciocontrato")
    private Date dSSolicitudPIUStatusAreaMeFInicioContrato;

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("tramite")
    private Long dSSolicitudPIUStatusAreaMeTramite;

    @JsonProperty("drvnumcontrato")
    private String dSSolicitudPIUStatusAreaMeDrvNumContrato;

    @JsonProperty("prioridad")
    private Long dSSolicitudPIUStatusAreaMePrioridad;

    @JsonProperty("drvsemaforoareamed")
    private Double dSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed;

    @JsonProperty("agente_drvnombrecompleto")
    private String dSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto;

    public DSSolicitudPIUStatusAreaMe() {
    
    }

    public DSSolicitudPIUStatusAreaMe(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIUStatusAreaMeEstadoDoc = instance.getSolicitudEstadoDoc();
                this.dSSolicitudPIUStatusAreaMeDrvEstadoHomologado = instance.getSolicitudDrvEstadoHomologado();
                this.dSSolicitudPIUStatusAreaMeFechaCompletada = instance.getSolicitudFechaCompletada();
                this.dSSolicitudPIUStatusAreaMeFechaUltimoDoc = instance.getSolicitudFechaUltimoDoc();
                this.dSSolicitudPIUStatusAreaMeFInicioContrato = instance.getSolicitudFInicioContrato();
                this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIUStatusAreaMeTramite = instance.getSolicitudTramite();
                this.dSSolicitudPIUStatusAreaMeDrvNumContrato = instance.getSolicituddrvNumContrato();
                this.dSSolicitudPIUStatusAreaMePrioridad = instance.getSolicitudPrioridad();
                this.dSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed = instance.getSolicituddrvSemaforoAreaMed();
                this.dSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto = instance.getAgente().getFuncionariodrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIUStatusAreaMeAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIUStatusAreaMeAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAreaMeEstadoDoc() {
        return this.dSSolicitudPIUStatusAreaMeEstadoDoc;
    }
    
    public void setDSSolicitudPIUStatusAreaMeEstadoDoc(Long dSSolicitudPIUStatusAreaMeEstadoDoc) {
        this.dSSolicitudPIUStatusAreaMeEstadoDoc = dSSolicitudPIUStatusAreaMeEstadoDoc;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAreaMeDrvEstadoHomologado() {
        return this.dSSolicitudPIUStatusAreaMeDrvEstadoHomologado;
    }
    
    public void setDSSolicitudPIUStatusAreaMeDrvEstadoHomologado(Long dSSolicitudPIUStatusAreaMeDrvEstadoHomologado) {
        this.dSSolicitudPIUStatusAreaMeDrvEstadoHomologado = dSSolicitudPIUStatusAreaMeDrvEstadoHomologado;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusAreaMeFechaCompletada() {
        return this.dSSolicitudPIUStatusAreaMeFechaCompletada;
    }
    
    public void setDSSolicitudPIUStatusAreaMeFechaCompletada(Timestamp dSSolicitudPIUStatusAreaMeFechaCompletada) {
        this.dSSolicitudPIUStatusAreaMeFechaCompletada = dSSolicitudPIUStatusAreaMeFechaCompletada;
    }

    @JsonIgnore
    public Timestamp getDSSolicitudPIUStatusAreaMeFechaUltimoDoc() {
        return this.dSSolicitudPIUStatusAreaMeFechaUltimoDoc;
    }
    
    public void setDSSolicitudPIUStatusAreaMeFechaUltimoDoc(Timestamp dSSolicitudPIUStatusAreaMeFechaUltimoDoc) {
        this.dSSolicitudPIUStatusAreaMeFechaUltimoDoc = dSSolicitudPIUStatusAreaMeFechaUltimoDoc;
    }

    @JsonIgnore
    public Date getDSSolicitudPIUStatusAreaMeFInicioContrato() {
        return this.dSSolicitudPIUStatusAreaMeFInicioContrato;
    }
    
    public void setDSSolicitudPIUStatusAreaMeFInicioContrato(Date dSSolicitudPIUStatusAreaMeFInicioContrato) {
        this.dSSolicitudPIUStatusAreaMeFInicioContrato = dSSolicitudPIUStatusAreaMeFInicioContrato;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIUStatusAreaMeAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAreaMeTramite() {
        return this.dSSolicitudPIUStatusAreaMeTramite;
    }
    
    public void setDSSolicitudPIUStatusAreaMeTramite(Long dSSolicitudPIUStatusAreaMeTramite) {
        this.dSSolicitudPIUStatusAreaMeTramite = dSSolicitudPIUStatusAreaMeTramite;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAreaMeDrvNumContrato() {
        return this.dSSolicitudPIUStatusAreaMeDrvNumContrato;
    }
    
    public void setDSSolicitudPIUStatusAreaMeDrvNumContrato(String dSSolicitudPIUStatusAreaMeDrvNumContrato) {
        this.dSSolicitudPIUStatusAreaMeDrvNumContrato = dSSolicitudPIUStatusAreaMeDrvNumContrato;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUStatusAreaMePrioridad() {
        return this.dSSolicitudPIUStatusAreaMePrioridad;
    }
    
    public void setDSSolicitudPIUStatusAreaMePrioridad(Long dSSolicitudPIUStatusAreaMePrioridad) {
        this.dSSolicitudPIUStatusAreaMePrioridad = dSSolicitudPIUStatusAreaMePrioridad;
    }

    @JsonIgnore
    public Double getDSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed() {
        return this.dSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed;
    }
    
    public void setDSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed(Double dSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed) {
        this.dSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed = dSSolicitudPIUStatusAreaMeDrvSemaforoAreaMed;
    }

    @JsonIgnore
    public String getDSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto() {
        return this.dSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto;
    }
    
    public void setDSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto(String dSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto) {
        this.dSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto = dSSolicitudPIUStatusAreaMeAgenteDotDrvNombreCompleto;
    }
}
