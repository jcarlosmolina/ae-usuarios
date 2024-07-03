package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
public class FuCalcularEdadRequest {

    @JsonProperty("pffechanacimiento")
    private Date pfFechaNacimiento;

    public FuCalcularEdadRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public Date getPfFechaNacimiento() {
        return this.pfFechaNacimiento;
    }
    
    public void setPfFechaNacimiento(Date pfFechaNacimiento) {
        this.pfFechaNacimiento = pfFechaNacimiento;
    }
}
