package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetTipoDireccionRequest {

    @JsonProperty("pfu_codigo")
    private Long pfuCodigo;

    public FugetTipoDireccionRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public Long getPfuCodigo() {
        return this.pfuCodigo;
    }
    
    public void setPfuCodigo(Long pfuCodigo) {
        this.pfuCodigo = pfuCodigo;
    }
}