package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FugetParentescoPorNombreRequest {

    @JsonProperty("pfnombrecorto")
    private String pfNombreCorto;

    public FugetParentescoPorNombreRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfNombreCorto() {
        return this.pfNombreCorto;
    }
    
    public void setPfNombreCorto(String pfNombreCorto) {
        this.pfNombreCorto = pfNombreCorto;
    }
}
