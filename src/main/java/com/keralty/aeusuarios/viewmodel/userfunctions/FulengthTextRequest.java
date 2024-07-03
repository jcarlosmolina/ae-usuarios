package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FulengthTextRequest {

    @JsonProperty("pfu_texto")
    private String pfuTexto;

    public FulengthTextRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuTexto() {
        return this.pfuTexto;
    }
    
    public void setPfuTexto(String pfuTexto) {
        this.pfuTexto = pfuTexto;
    }
}
