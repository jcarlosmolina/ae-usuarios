package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudInfoContratanteID {

    @JsonProperty("contratante_drvidentificacion")
    private String dSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion;

    public DSSolicitudInfoContratanteID() {
    
    }

    public DSSolicitudInfoContratanteID(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion = instance.getContratante().getContratantedrvIdentificacion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion() {
        return this.dSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion;
    }
    
    public void setDSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion(String dSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion) {
        this.dSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion = dSSolicitudInfoContratanteIDContratanteDotDrvIdentificacion;
    }
}
