package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;
public class FugetTipoRegimenRequest {

    @JsonProperty("pftipoid")
    private String pfTipoId;

    @JsonProperty("pfnumid")
    private String pfNumId;

    @JsonProperty("pfsolicitud")
    private SolicitudOid pfSolicitud;

    @JsonIgnore
    private Solicitud pfSolicitudInstance;

    public FugetTipoRegimenRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfTipoId() {
        return this.pfTipoId;
    }
    
    public void setPfTipoId(String pfTipoId) {
        this.pfTipoId = pfTipoId;
    }
    @JsonIgnore
    public String getPfNumId() {
        return this.pfNumId;
    }
    
    public void setPfNumId(String pfNumId) {
        this.pfNumId = pfNumId;
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
