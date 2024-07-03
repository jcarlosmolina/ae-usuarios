package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudIIUPreexistencias {

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("numcontrato")
    private String dSSolicitudIIUPreexistenciasNumContrato;

    public DSSolicitudIIUPreexistencias() {
    
    }

    public DSSolicitudIIUPreexistencias(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudIIUPreexistenciasNumContrato = instance.getSolicitudNumContrato();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudIIUPreexistenciasAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public String getDSSolicitudIIUPreexistenciasNumContrato() {
        return this.dSSolicitudIIUPreexistenciasNumContrato;
    }
    
    public void setDSSolicitudIIUPreexistenciasNumContrato(String dSSolicitudIIUPreexistenciasNumContrato) {
        this.dSSolicitudIIUPreexistenciasNumContrato = dSSolicitudIIUPreexistenciasNumContrato;
    }
}
