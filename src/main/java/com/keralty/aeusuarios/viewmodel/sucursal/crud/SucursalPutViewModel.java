package com.keralty.aeusuarios.viewmodel.sucursal.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SucursalPutViewModel {

    @JsonProperty(value="Descripcion")
    private String sucursalDescripcion;

    public String getSucursalDescripcion() {
        return sucursalDescripcion;
    }
    
    public void setSucursalDescripcion(String sucursalDescripcion) {
        this.sucursalDescripcion = sucursalDescripcion;
    }
}
