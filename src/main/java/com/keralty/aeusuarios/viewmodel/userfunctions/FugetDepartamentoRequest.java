package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetDepartamentoRequest {

    @JsonProperty("pfu_codigo")
    private Long pfuCodigo;

    public FugetDepartamentoRequest() {
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
