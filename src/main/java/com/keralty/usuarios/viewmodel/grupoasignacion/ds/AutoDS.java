package com.keralty.usuarios.viewmodel.grupoasignacion.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.GrupoAsignacion;
public class AutoDS {

    @JsonProperty("id")
    private Long _Auto_Id;

    @JsonProperty("tipo")
    private Long _Auto_Tipo;

    @JsonProperty("nombre")
    private String _Auto_Nombre;

    @JsonProperty("descripcion")
    private String _Auto_Descripcion;

    public AutoDS() {
    
    }

    public AutoDS(GrupoAsignacion instance) {
        if (instance != null) {
            this._Auto_Id = instance.getGrupoAsignacionId();
            this._Auto_Tipo = instance.getGrupoAsignacionTipo();
            this._Auto_Nombre = instance.getGrupoAsignacionNombre();
            this._Auto_Descripcion = instance.getGrupoAsignacionDescripcion();
        }
    }

    @JsonIgnore
    public Long get_Auto_Id() {
        return this._Auto_Id;
    }
    
    public void set_Auto_Id(Long _Auto_Id) {
        this._Auto_Id = _Auto_Id;
    }

    @JsonIgnore
    public Long get_Auto_Tipo() {
        return this._Auto_Tipo;
    }
    
    public void set_Auto_Tipo(Long _Auto_Tipo) {
        this._Auto_Tipo = _Auto_Tipo;
    }

    @JsonIgnore
    public String get_Auto_Nombre() {
        return this._Auto_Nombre;
    }
    
    public void set_Auto_Nombre(String _Auto_Nombre) {
        this._Auto_Nombre = _Auto_Nombre;
    }

    @JsonIgnore
    public String get_Auto_Descripcion() {
        return this._Auto_Descripcion;
    }
    
    public void set_Auto_Descripcion(String _Auto_Descripcion) {
        this._Auto_Descripcion = _Auto_Descripcion;
    }
}
