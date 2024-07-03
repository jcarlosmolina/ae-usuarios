package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetPersonaPorTipoYNumDocRequest {

    @JsonProperty("pfu_tipodoc")
    private String pfuTipoDoc;

    @JsonProperty("pfu_numdoc")
    private String pfuNumDoc;

    public FugetPersonaPorTipoYNumDocRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuTipoDoc() {
        return this.pfuTipoDoc;
    }
    
    public void setPfuTipoDoc(String pfuTipoDoc) {
        this.pfuTipoDoc = pfuTipoDoc;
    }
    @JsonIgnore
    public String getPfuNumDoc() {
        return this.pfuNumDoc;
    }
    
    public void setPfuNumDoc(String pfuNumDoc) {
        this.pfuNumDoc = pfuNumDoc;
    }
}
