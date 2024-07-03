package com.keralty.aeusuarios.viewmodel.grupoasignacion.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrupoAsignacionPostViewModel {

    @JsonProperty(value="Tipo")
    private Long grupoAsignacionTipo;

    @JsonProperty(value="Nombre")
    private String grupoAsignacionNombre;

    @JsonProperty(value="Descripcion")
    private String grupoAsignacionDescripcion;

    public Long getGrupoAsignacionTipo() {
        return grupoAsignacionTipo;
    }
    
    public void setGrupoAsignacionTipo(Long grupoAsignacionTipo) {
        this.grupoAsignacionTipo = grupoAsignacionTipo;
    }

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
