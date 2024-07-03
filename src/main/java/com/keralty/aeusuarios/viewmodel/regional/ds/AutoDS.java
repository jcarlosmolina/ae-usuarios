package com.keralty.aeusuarios.viewmodel.regional.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Regional;
public class AutoDS {

    @JsonProperty("codigo")
    private Long _Auto_Codigo;

    @JsonProperty("descripcion")
    private String _Auto_Descripcion;

    public AutoDS() {
    
    }

    public AutoDS(Regional instance) {
        if (instance != null) {
            this._Auto_Codigo = instance.getRegionalCodigo();
            this._Auto_Descripcion = instance.getRegionalDescripcion();
        }
    }

    @JsonIgnore
    public Long get_Auto_Codigo() {
        return this._Auto_Codigo;
    }
    
    public void set_Auto_Codigo(Long _Auto_Codigo) {
        this._Auto_Codigo = _Auto_Codigo;
    }

    @JsonIgnore
    public String get_Auto_Descripcion() {
        return this._Auto_Descripcion;
    }
    
    public void set_Auto_Descripcion(String _Auto_Descripcion) {
        this._Auto_Descripcion = _Auto_Descripcion;
    }
}
