package com.keralty.usuarios.viewmodel.rol.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RolPostViewModel {

    @JsonProperty(value="Nombre")
    private String rolNombre;

    public String getRolNombre() {
        return rolNombre;
    }
    
    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
}
