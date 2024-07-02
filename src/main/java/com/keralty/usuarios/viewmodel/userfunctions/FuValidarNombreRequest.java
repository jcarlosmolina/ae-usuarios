package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuValidarNombreRequest {

    @JsonProperty("pfu_nombre")
    private String pfuNombre;

    public FuValidarNombreRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfuNombre() {
        return this.pfuNombre;
    }
    
    public void setPfuNombre(String pfuNombre) {
        this.pfuNombre = pfuNombre;
    }
}
