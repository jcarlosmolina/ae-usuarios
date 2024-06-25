package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class ICSolicitud {

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String iCSolicitudAESOLICITUDESDotNUMEROSOLICITUD;

    public ICSolicitud() {
    
    }

    public ICSolicitud(Solicitud instance) {
        if (instance != null) {
            try {
                this.iCSolicitudAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICSolicitudAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.iCSolicitudAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setICSolicitudAESOLICITUDESDotNUMEROSOLICITUD(String iCSolicitudAESOLICITUDESDotNUMEROSOLICITUD) {
        this.iCSolicitudAESOLICITUDESDotNUMEROSOLICITUD = iCSolicitudAESOLICITUDESDotNUMEROSOLICITUD;
    }
}
