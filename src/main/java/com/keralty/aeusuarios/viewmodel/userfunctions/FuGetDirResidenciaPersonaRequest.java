package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.oid.PersonaOid;
import com.keralty.aeusuarios.persistence.Persona;
public class FuGetDirResidenciaPersonaRequest {

    @JsonProperty("pfpersona")
    private PersonaOid pfPersona;

    @JsonIgnore
    private Persona pfPersonaInstance;

    public FuGetDirResidenciaPersonaRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public PersonaOid getPfPersona() {
        return this.pfPersona;
    }
    
    public void setPfPersona(PersonaOid pfPersona) {
        this.pfPersona = pfPersona;
    }

    @JsonIgnore
    public Persona getPfPersonaInstance() {
        if (this.pfPersonaInstance == null)
            this.pfPersonaInstance = new Persona();
        return this.pfPersonaInstance;
    }
    
    public void setPfPersonaInstance(Persona pfPersona) {
        this.pfPersonaInstance = pfPersona;
    }
}
