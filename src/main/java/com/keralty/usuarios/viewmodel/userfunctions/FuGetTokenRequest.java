package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuGetTokenRequest {

    @JsonProperty("pftipo")
    private String pfTipo;

    public FuGetTokenRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfTipo() {
        return this.pfTipo;
    }
    
    public void setPfTipo(String pfTipo) {
        this.pfTipo = pfTipo;
    }
}
