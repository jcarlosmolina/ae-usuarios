package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetProductoRequest {

    @JsonProperty("pfu_numero")
    private Long pfuNumero;

    public FugetProductoRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public Long getPfuNumero() {
        return this.pfuNumero;
    }
    
    public void setPfuNumero(Long pfuNumero) {
        this.pfuNumero = pfuNumero;
    }
}
