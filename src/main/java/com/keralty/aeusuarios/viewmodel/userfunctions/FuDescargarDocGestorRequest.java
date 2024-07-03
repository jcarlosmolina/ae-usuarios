package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuDescargarDocGestorRequest {

    @JsonProperty("pfu_iddoc")
    private String pfuIdDoc;

    @JsonProperty("pfu_solicitud")
    private String pfuSolicitud;

    public FuDescargarDocGestorRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuIdDoc() {
        return this.pfuIdDoc;
    }
    
    public void setPfuIdDoc(String pfuIdDoc) {
        this.pfuIdDoc = pfuIdDoc;
    }
    @JsonIgnore
    public String getPfuSolicitud() {
        return this.pfuSolicitud;
    }
    
    public void setPfuSolicitud(String pfuSolicitud) {
        this.pfuSolicitud = pfuSolicitud;
    }
}
