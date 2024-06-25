package com.keralty.aeusuarios.viewmodel.rol.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Rol;
public class AutoDS {

    @JsonProperty("identificador")
    private Long _Auto_Identificador;

    @JsonProperty("nombre")
    private String _Auto_Nombre;

    public AutoDS() {
    
    }

    public AutoDS(Rol instance) {
        if (instance != null) {
            this._Auto_Identificador = instance.getRolIdentificador();
            this._Auto_Nombre = instance.getRolNombre();
        }
    }

    @JsonIgnore
    public Long get_Auto_Identificador() {
        return this._Auto_Identificador;
    }
    
    public void set_Auto_Identificador(Long _Auto_Identificador) {
        this._Auto_Identificador = _Auto_Identificador;
    }

    @JsonIgnore
    public String get_Auto_Nombre() {
        return this._Auto_Nombre;
    }
    
    public void set_Auto_Nombre(String _Auto_Nombre) {
        this._Auto_Nombre = _Auto_Nombre;
    }
}
