package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetValorPropertyRequest {

    @JsonProperty("pfu_nombreproperty")
    private String pfuNombreProperty;

    public FugetValorPropertyRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuNombreProperty() {
        return this.pfuNombreProperty;
    }
    
    public void setPfuNombreProperty(String pfuNombreProperty) {
        this.pfuNombreProperty = pfuNombreProperty;
    }
}
