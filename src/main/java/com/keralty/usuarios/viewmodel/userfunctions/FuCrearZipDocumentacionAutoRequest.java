package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.oid.SolicitudOid;
import com.keralty.usuarios.persistence.Solicitud;
public class FuCrearZipDocumentacionAutoRequest {

    @JsonProperty("pssolicitud")
    private SolicitudOid psSolicitud;

    @JsonIgnore
    private Solicitud psSolicitudInstance;

    public FuCrearZipDocumentacionAutoRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public SolicitudOid getPsSolicitud() {
        return this.psSolicitud;
    }
    
    public void setPsSolicitud(SolicitudOid psSolicitud) {
        this.psSolicitud = psSolicitud;
    }

    @JsonIgnore
    public Solicitud getPsSolicitudInstance() {
        if (this.psSolicitudInstance == null)
            this.psSolicitudInstance = new Solicitud();
        return this.psSolicitudInstance;
    }
    
    public void setPsSolicitudInstance(Solicitud psSolicitud) {
        this.psSolicitudInstance = psSolicitud;
    }
}
