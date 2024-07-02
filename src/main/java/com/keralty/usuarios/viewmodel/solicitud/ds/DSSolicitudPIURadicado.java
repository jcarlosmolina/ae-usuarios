package com.keralty.usuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Solicitud;
public class DSSolicitudPIURadicado {

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("tramite")
    private Long dSSolicitudPIURadicadoTramite;

    @JsonProperty("aesolicitudes_fechaasignacion")
    private Date dSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION;

    @JsonProperty("numradicado")
    private Long dSSolicitudPIURadicadoNumRadicado;

    @JsonProperty("contratantepersona_drvnombrecompleto")
    private String dSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto;

    @JsonProperty("titularpersona_drvnombrecompleto")
    private String dSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto;

    public DSSolicitudPIURadicado() {
    
    }

    public DSSolicitudPIURadicado(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIURadicadoTramite = instance.getSolicitudTramite();
                this.dSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION = instance.getAESOLICITUDES().getAESOLICITUDESFECHAASIGNACION();
                this.dSSolicitudPIURadicadoNumRadicado = instance.getSolicitudNumRadicado();
                this.dSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto = instance.getContratantePersona().getPersonadrvNombreCompleto();
                this.dSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto = instance.getTitularPersona().getPersonadrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIURadicadoAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public String getDSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIURadicadoAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIURadicadoAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolicitudPIURadicadoTramite() {
        return this.dSSolicitudPIURadicadoTramite;
    }
    
    public void setDSSolicitudPIURadicadoTramite(Long dSSolicitudPIURadicadoTramite) {
        this.dSSolicitudPIURadicadoTramite = dSSolicitudPIURadicadoTramite;
    }

    @JsonIgnore
    public Date getDSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION() {
        return this.dSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION;
    }
    
    public void setDSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION(Date dSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION) {
        this.dSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION = dSSolicitudPIURadicadoAESOLICITUDESDotFECHAASIGNACION;
    }

    @JsonIgnore
    public Long getDSSolicitudPIURadicadoNumRadicado() {
        return this.dSSolicitudPIURadicadoNumRadicado;
    }
    
    public void setDSSolicitudPIURadicadoNumRadicado(Long dSSolicitudPIURadicadoNumRadicado) {
        this.dSSolicitudPIURadicadoNumRadicado = dSSolicitudPIURadicadoNumRadicado;
    }

    @JsonIgnore
    public String getDSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto() {
        return this.dSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto;
    }
    
    public void setDSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto(String dSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto) {
        this.dSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto = dSSolicitudPIURadicadoContratantePersonaDotDrvNombreCompleto;
    }

    @JsonIgnore
    public String getDSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto() {
        return this.dSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto;
    }
    
    public void setDSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto(String dSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto) {
        this.dSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto = dSSolicitudPIURadicadoTitularPersonaDotDrvNombreCompleto;
    }
}
