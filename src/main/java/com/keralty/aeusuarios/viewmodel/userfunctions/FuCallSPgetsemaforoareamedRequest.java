package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuCallSPgetsemaforoareamedRequest {

    @JsonProperty("pfidsolicitud")
    private Long pfIdSolicitud;

    public FuCallSPgetsemaforoareamedRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public Long getPfIdSolicitud() {
        return this.pfIdSolicitud;
    }
    
    public void setPfIdSolicitud(Long pfIdSolicitud) {
        this.pfIdSolicitud = pfIdSolicitud;
    }
}
