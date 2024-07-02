package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.oid.PersonaOid;
import com.keralty.usuarios.persistence.oid.ProteccionDatosOid;
import com.keralty.usuarios.persistence.Persona;
import com.keralty.usuarios.persistence.ProteccionDatos;
public class FuCrearPersonaCORERequest {

    @JsonProperty("pfpersona")
    private PersonaOid pfPersona;

    @JsonIgnore
    private Persona pfPersonaInstance;

    @JsonProperty("pfprotdatos")
    private ProteccionDatosOid pfProtDatos;

    @JsonIgnore
    private ProteccionDatos pfProtDatosInstance;

    public FuCrearPersonaCORERequest() {
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
    @JsonIgnore
    public ProteccionDatosOid getPfProtDatos() {
        return this.pfProtDatos;
    }
    
    public void setPfProtDatos(ProteccionDatosOid pfProtDatos) {
        this.pfProtDatos = pfProtDatos;
    }

    @JsonIgnore
    public ProteccionDatos getPfProtDatosInstance() {
        if (this.pfProtDatosInstance == null)
            this.pfProtDatosInstance = new ProteccionDatos();
        return this.pfProtDatosInstance;
    }
    
    public void setPfProtDatosInstance(ProteccionDatos pfProtDatos) {
        this.pfProtDatosInstance = pfProtDatos;
    }
}
