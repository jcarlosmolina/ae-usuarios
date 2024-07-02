package com.keralty.usuarios.viewmodel.regional.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionalPutViewModel {

    @JsonProperty(value="Descripcion")
    private String regionalDescripcion;

    public String getRegionalDescripcion() {
        return regionalDescripcion;
    }
    
    public void setRegionalDescripcion(String regionalDescripcion) {
        this.regionalDescripcion = regionalDescripcion;
    }
}
