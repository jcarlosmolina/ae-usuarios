package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuGetParametrosConfiguracionRequest {

    @JsonProperty("pflistaparametros")
    private String pfListaParametros;

    public FuGetParametrosConfiguracionRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfListaParametros() {
        return this.pfListaParametros;
    }
    
    public void setPfListaParametros(String pfListaParametros) {
        this.pfListaParametros = pfListaParametros;
    }
}
