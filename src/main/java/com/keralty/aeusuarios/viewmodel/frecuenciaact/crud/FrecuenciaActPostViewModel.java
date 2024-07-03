package com.keralty.aeusuarios.viewmodel.frecuenciaact.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrecuenciaActPostViewModel {

    @JsonProperty(value="Parametrica")
    private Long frecuenciaActParametrica;

    @JsonProperty(value="Frecuencia")
    private Long frecuenciaActFrecuencia;

    public Long getFrecuenciaActParametrica() {
        return frecuenciaActParametrica;
    }
    
    public void setFrecuenciaActParametrica(Long frecuenciaActParametrica) {
        this.frecuenciaActParametrica = frecuenciaActParametrica;
    }

    public Long getFrecuenciaActFrecuencia() {
        return frecuenciaActFrecuencia;
    }
    
    public void setFrecuenciaActFrecuencia(Long frecuenciaActFrecuencia) {
        this.frecuenciaActFrecuencia = frecuenciaActFrecuencia;
    }
}
