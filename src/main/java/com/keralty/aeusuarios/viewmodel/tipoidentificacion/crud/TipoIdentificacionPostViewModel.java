package com.keralty.aeusuarios.viewmodel.tipoidentificacion.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoIdentificacionPostViewModel {

    @JsonProperty(value="Codigo")
    private Long tipoIdentificacionCodigo;

    @JsonProperty(value="Descripcion")
    private String tipoIdentificacionDescripcion;

    @JsonProperty(value="NombreCorto")
    private String tipoIdentificacionNombreCorto;

    @JsonProperty(value="ValidoContratante")
    private Boolean tipoIdentificacionValidoContratante;

    @JsonProperty(value="ValidoTitular")
    private Boolean tipoIdentificacionValidoTitular;

    @JsonProperty(value="Diplomatico")
    private Boolean tipoIdentificacionDiplomatico;

    @JsonProperty(value="NIT")
    private Boolean tipoIdentificacionNIT;

    @JsonProperty(value="HijoDe")
    private Boolean tipoIdentificacionHijoDe;

    @JsonProperty(value="RequiereEPS")
    private Boolean tipoIdentificacionRequiereEPS;

    @JsonProperty(value="MenorSinIdentificar")
    private Boolean tipoIdentificacionMenorSinIdentificar;

    @JsonProperty(value="EsPasaporte")
    private Boolean tipoIdentificacionEsPasaporte;

    @JsonProperty(value="VisibleValidadorUsu")
    private Boolean tipoIdentificacionVisibleValidadorUsu;

    public Long getTipoIdentificacionCodigo() {
        return tipoIdentificacionCodigo;
    }
    
    public void setTipoIdentificacionCodigo(Long tipoIdentificacionCodigo) {
        this.tipoIdentificacionCodigo = tipoIdentificacionCodigo;
    }

    public String getTipoIdentificacionDescripcion() {
        return tipoIdentificacionDescripcion;
    }
    
    public void setTipoIdentificacionDescripcion(String tipoIdentificacionDescripcion) {
        this.tipoIdentificacionDescripcion = tipoIdentificacionDescripcion;
    }

    public String getTipoIdentificacionNombreCorto() {
        return tipoIdentificacionNombreCorto;
    }
    
    public void setTipoIdentificacionNombreCorto(String tipoIdentificacionNombreCorto) {
        this.tipoIdentificacionNombreCorto = tipoIdentificacionNombreCorto;
    }

    public Boolean getTipoIdentificacionValidoContratante() {
        return tipoIdentificacionValidoContratante;
    }
    
    public void setTipoIdentificacionValidoContratante(Boolean tipoIdentificacionValidoContratante) {
        this.tipoIdentificacionValidoContratante = tipoIdentificacionValidoContratante;
    }

    public Boolean getTipoIdentificacionValidoTitular() {
        return tipoIdentificacionValidoTitular;
    }
    
    public void setTipoIdentificacionValidoTitular(Boolean tipoIdentificacionValidoTitular) {
        this.tipoIdentificacionValidoTitular = tipoIdentificacionValidoTitular;
    }

    public Boolean getTipoIdentificacionDiplomatico() {
        return tipoIdentificacionDiplomatico;
    }
    
    public void setTipoIdentificacionDiplomatico(Boolean tipoIdentificacionDiplomatico) {
        this.tipoIdentificacionDiplomatico = tipoIdentificacionDiplomatico;
    }

    public Boolean getTipoIdentificacionNIT() {
        return tipoIdentificacionNIT;
    }
    
    public void setTipoIdentificacionNIT(Boolean tipoIdentificacionNIT) {
        this.tipoIdentificacionNIT = tipoIdentificacionNIT;
    }

    public Boolean getTipoIdentificacionHijoDe() {
        return tipoIdentificacionHijoDe;
    }
    
    public void setTipoIdentificacionHijoDe(Boolean tipoIdentificacionHijoDe) {
        this.tipoIdentificacionHijoDe = tipoIdentificacionHijoDe;
    }

    public Boolean getTipoIdentificacionRequiereEPS() {
        return tipoIdentificacionRequiereEPS;
    }
    
    public void setTipoIdentificacionRequiereEPS(Boolean tipoIdentificacionRequiereEPS) {
        this.tipoIdentificacionRequiereEPS = tipoIdentificacionRequiereEPS;
    }

    public Boolean getTipoIdentificacionMenorSinIdentificar() {
        return tipoIdentificacionMenorSinIdentificar;
    }
    
    public void setTipoIdentificacionMenorSinIdentificar(Boolean tipoIdentificacionMenorSinIdentificar) {
        this.tipoIdentificacionMenorSinIdentificar = tipoIdentificacionMenorSinIdentificar;
    }

    public Boolean getTipoIdentificacionEsPasaporte() {
        return tipoIdentificacionEsPasaporte;
    }
    
    public void setTipoIdentificacionEsPasaporte(Boolean tipoIdentificacionEsPasaporte) {
        this.tipoIdentificacionEsPasaporte = tipoIdentificacionEsPasaporte;
    }

    public Boolean getTipoIdentificacionVisibleValidadorUsu() {
        return tipoIdentificacionVisibleValidadorUsu;
    }
    
    public void setTipoIdentificacionVisibleValidadorUsu(Boolean tipoIdentificacionVisibleValidadorUsu) {
        this.tipoIdentificacionVisibleValidadorUsu = tipoIdentificacionVisibleValidadorUsu;
    }
}
