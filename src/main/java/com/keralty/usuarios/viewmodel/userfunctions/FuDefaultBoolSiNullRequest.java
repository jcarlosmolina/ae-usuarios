package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuDefaultBoolSiNullRequest {

    @JsonProperty("pfu_bool")
    private Boolean pfubool;

    public FuDefaultBoolSiNullRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public Boolean getPfubool() {
        return this.pfubool;
    }
    
    public void setPfubool(Boolean pfubool) {
        this.pfubool = pfubool;
    }
}
