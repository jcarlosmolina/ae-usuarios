package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.oid.SolicitudOid;
import com.keralty.usuarios.persistence.Solicitud;
public class FuSustituirParamsEnURLRequest {

    @JsonProperty("pfu_url")
    private String pfuURL;

    @JsonProperty("pfu_solicitud")
    private SolicitudOid pfuSolicitud;

    @JsonIgnore
    private Solicitud pfuSolicitudInstance;

    public FuSustituirParamsEnURLRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuURL() {
        return this.pfuURL;
    }
    
    public void setPfuURL(String pfuURL) {
        this.pfuURL = pfuURL;
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
