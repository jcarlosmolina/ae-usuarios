package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;
public class FuformarListaUsuariosSinCuesRequest {

    @JsonProperty("pfu_solicitud")
    private SolicitudOid pfuSolicitud;

    @JsonIgnore
    private Solicitud pfuSolicitudInstance;

    public FuformarListaUsuariosSinCuesRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public SolicitudOid getPfuSolicitud() {
        return this.pfuSolicitud;
    }
    
    public void setPfuSolicitud(SolicitudOid pfuSolicitud) {
        this.pfuSolicitud = pfuSolicitud;
    }

    @JsonIgnore
    public Solicitud getPfuSolicitudInstance() {
        if (this.pfuSolicitudInstance == null)
            this.pfuSolicitudInstance = new Solicitud();
        return this.pfuSolicitudInstance;
    }
    
    public void setPfuSolicitudInstance(Solicitud pfuSolicitud) {
        this.pfuSolicitudInstance = pfuSolicitud;
    }
}
