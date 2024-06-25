package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuSoloLetrasRequest {

    @JsonProperty("pfu_numero")
    private String pfuNumero;

    public FuSoloLetrasRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuNumero() {
        return this.pfuNumero;
    }
    
    public void setPfuNumero(String pfuNumero) {
        this.pfuNumero = pfuNumero;
    }
}
