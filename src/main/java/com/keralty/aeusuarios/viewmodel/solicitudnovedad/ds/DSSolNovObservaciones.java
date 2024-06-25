package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovObservaciones {

    @JsonProperty("id")
    private Long dSSolNovObservacionesId;

    public DSSolNovObservaciones() {
    
    }

    public DSSolNovObservaciones(SolicitudNovedad instance) {
        if (instance != null) {
            this.dSSolNovObservacionesId = instance.getSolicitudNovedadId();
        }
    }

    @JsonIgnore
    public Long getDSSolNovObservacionesId() {
        return this.dSSolNovObservacionesId;
    }
    
    public void setDSSolNovObservacionesId(Long dSSolNovObservacionesId) {
        this.dSSolNovObservacionesId = dSSolNovObservacionesId;
    }
}
