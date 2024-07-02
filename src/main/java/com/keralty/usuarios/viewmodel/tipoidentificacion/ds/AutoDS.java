package com.keralty.usuarios.viewmodel.tipoidentificacion.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.TipoIdentificacion;
public class AutoDS {

    @JsonProperty("codigo")
    private Long _Auto_Codigo;

    @JsonProperty("descripcion")
    private String _Auto_Descripcion;

    @JsonProperty("nombrecorto")
    private String _Auto_NombreCorto;

    @JsonProperty("validocontratante")
    private Boolean _Auto_ValidoContratante;

    @JsonProperty("validotitular")
    private Boolean _Auto_ValidoTitular;

    @JsonProperty("diplomatico")
    private Boolean _Auto_Diplomatico;

    @JsonProperty("nit")
    private Boolean _Auto_NIT;

    @JsonProperty("hijode")
    private Boolean _Auto_HijoDe;

    @JsonProperty("requiereeps")
    private Boolean _Auto_RequiereEPS;

    @JsonProperty("menorsinidentificar")
    private Boolean _Auto_MenorSinIdentificar;

    @JsonProperty("espasaporte")
    private Boolean _Auto_EsPasaporte;

    @JsonProperty("visiblevalidadorusu")
    private Boolean _Auto_VisibleValidadorUsu;

    public AutoDS() {
    
    }

    public AutoDS(TipoIdentificacion instance) {
        if (instance != null) {
            this._Auto_Codigo = instance.getTipoIdentificacionCodigo();
            this._Auto_Descripcion = instance.getTipoIdentificacionDescripcion();
            this._Auto_NombreCorto = instance.getTipoIdentificacionNombreCorto();
            this._Auto_ValidoContratante = instance.getTipoIdentificacionValidoContratante();
            this._Auto_ValidoTitular = instance.getTipoIdentificacionValidoTitular();
            this._Auto_Diplomatico = instance.getTipoIdentificacionDiplomatico();
            this._Auto_NIT = instance.getTipoIdentificacionNIT();
            this._Auto_HijoDe = instance.getTipoIdentificacionHijoDe();
            this._Auto_RequiereEPS = instance.getTipoIdentificacionRequiereEPS();
            this._Auto_MenorSinIdentificar = instance.getTipoIdentificacionMenorSinIdentificar();
            this._Auto_EsPasaporte = instance.getTipoIdentificacionEsPasaporte();
            this._Auto_VisibleValidadorUsu = instance.getTipoIdentificacionVisibleValidadorUsu();
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

    @JsonIgnore
    public String get_Auto_NombreCorto() {
        return this._Auto_NombreCorto;
    }
    
    public void set_Auto_NombreCorto(String _Auto_NombreCorto) {
        this._Auto_NombreCorto = _Auto_NombreCorto;
    }

    @JsonIgnore
    public Boolean get_Auto_ValidoContratante() {
        return this._Auto_ValidoContratante;
    }
    
    public void set_Auto_ValidoContratante(Boolean _Auto_ValidoContratante) {
        this._Auto_ValidoContratante = _Auto_ValidoContratante;
    }

    @JsonIgnore
    public Boolean get_Auto_ValidoTitular() {
        return this._Auto_ValidoTitular;
    }
    
    public void set_Auto_ValidoTitular(Boolean _Auto_ValidoTitular) {
        this._Auto_ValidoTitular = _Auto_ValidoTitular;
    }

    @JsonIgnore
    public Boolean get_Auto_Diplomatico() {
        return this._Auto_Diplomatico;
    }
    
    public void set_Auto_Diplomatico(Boolean _Auto_Diplomatico) {
        this._Auto_Diplomatico = _Auto_Diplomatico;
    }

    @JsonIgnore
    public Boolean get_Auto_NIT() {
        return this._Auto_NIT;
    }
    
    public void set_Auto_NIT(Boolean _Auto_NIT) {
        this._Auto_NIT = _Auto_NIT;
    }

    @JsonIgnore
    public Boolean get_Auto_HijoDe() {
        return this._Auto_HijoDe;
    }
    
    public void set_Auto_HijoDe(Boolean _Auto_HijoDe) {
        this._Auto_HijoDe = _Auto_HijoDe;
    }

    @JsonIgnore
    public Boolean get_Auto_RequiereEPS() {
        return this._Auto_RequiereEPS;
    }
    
    public void set_Auto_RequiereEPS(Boolean _Auto_RequiereEPS) {
        this._Auto_RequiereEPS = _Auto_RequiereEPS;
    }

    @JsonIgnore
    public Boolean get_Auto_MenorSinIdentificar() {
        return this._Auto_MenorSinIdentificar;
    }
    
    public void set_Auto_MenorSinIdentificar(Boolean _Auto_MenorSinIdentificar) {
        this._Auto_MenorSinIdentificar = _Auto_MenorSinIdentificar;
    }

    @JsonIgnore
    public Boolean get_Auto_EsPasaporte() {
        return this._Auto_EsPasaporte;
    }
    
    public void set_Auto_EsPasaporte(Boolean _Auto_EsPasaporte) {
        this._Auto_EsPasaporte = _Auto_EsPasaporte;
    }

    @JsonIgnore
    public Boolean get_Auto_VisibleValidadorUsu() {
        return this._Auto_VisibleValidadorUsu;
    }
    
    public void set_Auto_VisibleValidadorUsu(Boolean _Auto_VisibleValidadorUsu) {
        this._Auto_VisibleValidadorUsu = _Auto_VisibleValidadorUsu;
    }
}
