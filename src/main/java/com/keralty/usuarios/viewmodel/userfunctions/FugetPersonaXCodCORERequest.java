package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetPersonaXCodCORERequest {

    @JsonProperty("pfu_codigo")
    private Long pfucodigo;

    public FugetPersonaXCodCORERequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public Long getPfucodigo() {
        return this.pfucodigo;
    }
    
    public void setPfucodigo(Long pfucodigo) {
        this.pfucodigo = pfucodigo;
    }
}
