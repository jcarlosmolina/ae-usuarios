package com.keralty.aeusuarios.viewmodel.frecuenciaact.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class FrecuenciaActPutViewModel {

    @JsonProperty(value="Frecuencia")
    private Long frecuenciaActFrecuencia;

    @JsonProperty(value="FechaUltimaSinc")
    private Date frecuenciaActFechaUltimaSinc;

    @JsonProperty(value="ResultadoSinc")
    private String frecuenciaActResultadoSinc;

    @JsonProperty(value="Usuario")
    private String frecuenciaActUsuario;

    @JsonProperty(value="NombreUsuario")
    private String frecuenciaActNombreUsuario;

    public Long getFrecuenciaActFrecuencia() {
        return frecuenciaActFrecuencia;
    }
    
    public void setFrecuenciaActFrecuencia(Long frecuenciaActFrecuencia) {
        this.frecuenciaActFrecuencia = frecuenciaActFrecuencia;
    }

    public Date getFrecuenciaActFechaUltimaSinc() {
        return frecuenciaActFechaUltimaSinc;
    }
    
    public void setFrecuenciaActFechaUltimaSinc(Date frecuenciaActFechaUltimaSinc) {
        this.frecuenciaActFechaUltimaSinc = frecuenciaActFechaUltimaSinc;
    }

    public String getFrecuenciaActResultadoSinc() {
        return frecuenciaActResultadoSinc;
    }
    
    public void setFrecuenciaActResultadoSinc(String frecuenciaActResultadoSinc) {
        this.frecuenciaActResultadoSinc = frecuenciaActResultadoSinc;
    }

    public String getFrecuenciaActUsuario() {
        return frecuenciaActUsuario;
    }
    
    public void setFrecuenciaActUsuario(String frecuenciaActUsuario) {
        this.frecuenciaActUsuario = frecuenciaActUsuario;
    }

    public String getFrecuenciaActNombreUsuario() {
        return frecuenciaActNombreUsuario;
    }
    
    public void setFrecuenciaActNombreUsuario(String frecuenciaActNombreUsuario) {
        this.frecuenciaActNombreUsuario = frecuenciaActNombreUsuario;
    }
}
