package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.oid.SolicitudOid;
import com.keralty.usuarios.persistence.Solicitud;
public class FuFormarTextoObservacionesRequest {

    @JsonProperty("pfsolicitud")
    private SolicitudOid pfSolicitud;

    @JsonIgnore
    private Solicitud pfSolicitudInstance;

    public FuFormarTextoObservacionesRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public SolicitudOid getPfSolicitud() {
        return this.pfSolicitud;
    }
    
    public void setPfSolicitud(SolicitudOid pfSolicitud) {
        this.pfSolicitud = pfSolicitud;
    }

    @JsonIgnore
    public Solicitud getPfSolicitudInstance() {
        if (this.pfSolicitudInstance == null)
            this.pfSolicitudInstance = new Solicitud();
        return this.pfSolicitudInstance;
    }
    
    public void setPfSolicitudInstance(Solicitud pfSolicitud) {
        this.pfSolicitudInstance = pfSolicitud;
    }
}
