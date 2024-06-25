package com.keralty.aeusuarios.viewmodel.sucursal.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SucursalPostViewModel {

    @JsonProperty(value="Codigo")
    private Long sucursalCodigo;

    @JsonProperty(value="Descripcion")
    private String sucursalDescripcion;

    public Long getSucursalCodigo() {
        return sucursalCodigo;
    }
    
    public void setSucursalCodigo(Long sucursalCodigo) {
        this.sucursalCodigo = sucursalCodigo;
    }

    public String getSucursalDescripcion() {
        return sucursalDescripcion;
    }
    
    public void setSucursalDescripcion(String sucursalDescripcion) {
        this.sucursalDescripcion = sucursalDescripcion;
    }
}
