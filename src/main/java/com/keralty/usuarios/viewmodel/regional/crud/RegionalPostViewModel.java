package com.keralty.usuarios.viewmodel.regional.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionalPostViewModel {

    @JsonProperty(value="Codigo")
    private Long regionalCodigo;

    @JsonProperty(value="Descripcion")
    private String regionalDescripcion;

    public Long getRegionalCodigo() {
        return regionalCodigo;
    }
    
    public void setRegionalCodigo(Long regionalCodigo) {
        this.regionalCodigo = regionalCodigo;
    }

    public String getRegionalDescripcion() {
        return regionalDescripcion;
    }
    
    public void setRegionalDescripcion(String regionalDescripcion) {
        this.regionalDescripcion = regionalDescripcion;
    }
}
