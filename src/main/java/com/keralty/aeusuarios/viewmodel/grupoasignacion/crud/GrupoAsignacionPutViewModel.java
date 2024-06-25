package com.keralty.aeusuarios.viewmodel.grupoasignacion.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrupoAsignacionPutViewModel {

    @JsonProperty(value="Nombre")
    private String grupoAsignacionNombre;

    @JsonProperty(value="Descripcion")
    private String grupoAsignacionDescripcion;

    public String getGrupoAsignacionNombre() {
        return grupoAsignacionNombre;
    }
    
    public void setGrupoAsignacionNombre(String grupoAsignacionNombre) {
        this.grupoAsignacionNombre = grupoAsignacionNombre;
    }

    public String getGrupoAsignacionDescripcion() {
        return grupoAsignacionDescripcion;
    }
    
    public void setGrupoAsignacionDescripcion(String grupoAsignacionDescripcion) {
        this.grupoAsignacionDescripcion = grupoAsignacionDescripcion;
    }
}
