package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudPIUConsultaRad {

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("aesolicitudes_productot_descripcion")
    private String dSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion;

    @JsonProperty("aesolicitudes_plant_nombre")
    private String dSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre;

    @JsonProperty("tramite")
    private Long dSSolicitudPIUConsultaRadTramite;

    public DSSolicitudPIUConsultaRad() {
    
    }

    public DSSolicitudPIUConsultaRad(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion = instance.getAESOLICITUDES().getProductoT().getProductosDescripcion();
                this.dSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre = instance.getAESOLICITUDES().getPlanT().getPlanesNombre();
                this.dSSolicitudPIUConsultaRadTramite = instance.getSolicitudTramite();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudPIUConsultaRadAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public String getDSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion() {
        return this.dSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion(String dSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion) {
        this.dSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion = dSSolicitudPIUConsultaRadAESOLICITUDESDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre() {
        return this.dSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre;
    }
    
    public void setDSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre(String dSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre) {
        this.dSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre = dSSolicitudPIUConsultaRadAESOLICITUDESDotPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolicitudPIUConsultaRadTramite() {
        return this.dSSolicitudPIUConsultaRadTramite;
    }
    
    public void setDSSolicitudPIUConsultaRadTramite(Long dSSolicitudPIUConsultaRadTramite) {
        this.dSSolicitudPIUConsultaRadTramite = dSSolicitudPIUConsultaRadTramite;
    }
}
