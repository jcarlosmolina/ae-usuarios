package com.keralty.usuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Solicitud;
public class DSSolicitudPIUEnvioDoc {

    @JsonProperty("tramite")
    private Long dSSolicitudPIUEnvioDocTramite;

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("estado")
    private Long dSSolicitudPIUEnvioDocEstado;

    @JsonProperty("numcontrato")
    private String dSSolicitudPIUEnvioDocNumContrato;

    @JsonProperty("docsenviados")
    private Boolean dSSolicitudPIUEnvioDocDocsEnviados;

    @JsonProperty("agente_usuario")
    private String dSSolicitudPIUEnvioDocAgenteDotUsuario;

    @JsonProperty("tienedifliquidacion")
    private Boolean dSSolicitudPIUEnvioDocTieneDifLiquidacion;

    @JsonProperty("drvtienesegundafirma")
    private Boolean dSSolicitudPIUEnvioDocDrvTieneSegundaFirma;

    @JsonProperty("estadodoc")
    private Long dSSolicitudPIUEnvioDocEstadoDoc;

    public DSSolicitudPIUEnvioDoc() {
    
    }

    public DSSolicitudPIUEnvioDoc(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIUEnvioDocTramite = instance.getSolicitudTramite();
                this.dSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIUEnvioDocEstado = instance.getSolicitudEstado();
                this.dSSolicitudPIUEnvioDocNumContrato = instance.getSolicitudNumContrato();
                this.dSSolicitudPIUEnvioDocDocsEnviados = instance.getSolicitudDocsEnviados();
                this.dSSolicitudPIUEnvioDocAgenteDotUsuario = instance.getAgente().getFuncionarioUsuario();
                this.dSSolicitudPIUEnvioDocTieneDifLiquidacion = instance.getSolicitudTieneDifLiquidacion();
                this.dSSolicitudPIUEnvioDocDrvTieneSegundaFirma = instance.getSolicituddrvTieneSegundaFirma();
                this.dSSolicitudPIUEnvioDocEstadoDoc = instance.getSolicitudEstadoDoc();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Long getDSSolicitudPIUEnvioDocTramite() {
        return this.dSSolicitudPIUEnvioDocTramite;
    }
    
    public void setDSSolicitudPIUEnvioDocTramite(Long dSSolicitudPIUEnvioDocTramite) {
        this.dSSolicitudPIUEnvioDocTramite = dSSolicitudPIUEnvioDocTramite;
    }

    @JsonIgnore
    public String getDSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIUEnvioDocAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIUEnvioDocAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIUEnvioDocAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUEnvioDocEstado() {
        return this.dSSolicitudPIUEnvioDocEstado;
    }
    
    public void setDSSolicitudPIUEnvioDocEstado(Long dSSolicitudPIUEnvioDocEstado) {
        this.dSSolicitudPIUEnvioDocEstado = dSSolicitudPIUEnvioDocEstado;
    }

    @JsonIgnore
    public String getDSSolicitudPIUEnvioDocNumContrato() {
        return this.dSSolicitudPIUEnvioDocNumContrato;
    }
    
    public void setDSSolicitudPIUEnvioDocNumContrato(String dSSolicitudPIUEnvioDocNumContrato) {
        this.dSSolicitudPIUEnvioDocNumContrato = dSSolicitudPIUEnvioDocNumContrato;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUEnvioDocDocsEnviados() {
        return this.dSSolicitudPIUEnvioDocDocsEnviados;
    }
    
    public void setDSSolicitudPIUEnvioDocDocsEnviados(Boolean dSSolicitudPIUEnvioDocDocsEnviados) {
        this.dSSolicitudPIUEnvioDocDocsEnviados = dSSolicitudPIUEnvioDocDocsEnviados;
    }

    @JsonIgnore
    public String getDSSolicitudPIUEnvioDocAgenteDotUsuario() {
        return this.dSSolicitudPIUEnvioDocAgenteDotUsuario;
    }
    
    public void setDSSolicitudPIUEnvioDocAgenteDotUsuario(String dSSolicitudPIUEnvioDocAgenteDotUsuario) {
        this.dSSolicitudPIUEnvioDocAgenteDotUsuario = dSSolicitudPIUEnvioDocAgenteDotUsuario;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUEnvioDocTieneDifLiquidacion() {
        return this.dSSolicitudPIUEnvioDocTieneDifLiquidacion;
    }
    
    public void setDSSolicitudPIUEnvioDocTieneDifLiquidacion(Boolean dSSolicitudPIUEnvioDocTieneDifLiquidacion) {
        this.dSSolicitudPIUEnvioDocTieneDifLiquidacion = dSSolicitudPIUEnvioDocTieneDifLiquidacion;
    }

    @JsonIgnore
    public Boolean getDSSolicitudPIUEnvioDocDrvTieneSegundaFirma() {
        return this.dSSolicitudPIUEnvioDocDrvTieneSegundaFirma;
    }
    
    public void setDSSolicitudPIUEnvioDocDrvTieneSegundaFirma(Boolean dSSolicitudPIUEnvioDocDrvTieneSegundaFirma) {
        this.dSSolicitudPIUEnvioDocDrvTieneSegundaFirma = dSSolicitudPIUEnvioDocDrvTieneSegundaFirma;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUEnvioDocEstadoDoc() {
        return this.dSSolicitudPIUEnvioDocEstadoDoc;
    }
    
    public void setDSSolicitudPIUEnvioDocEstadoDoc(Long dSSolicitudPIUEnvioDocEstadoDoc) {
        this.dSSolicitudPIUEnvioDocEstadoDoc = dSSolicitudPIUEnvioDocEstadoDoc;
    }
}
