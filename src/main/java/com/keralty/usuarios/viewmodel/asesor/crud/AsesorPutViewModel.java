package com.keralty.usuarios.viewmodel.asesor.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsesorPutViewModel {

    @JsonProperty(value="ModDBasicosPersona")
    private Boolean asesorModDBasicosPersona;

    @JsonProperty(value="modificaDirector")
    private Boolean asesormodificaDirector;

    @JsonProperty(value="esDirector")
    private Boolean asesoresDirector;

    @JsonProperty(value="NumIdentificacion")
    private String asesorNumIdentificacion;

    @JsonProperty(value="EsIntegral")
    private Boolean asesorEsIntegral;

    @JsonProperty(value="VerDBasicosPersona")
    private Boolean asesorVerDBasicosPersona;

    @JsonProperty(value="VerDocIdentificacionPersona")
    private Boolean asesorVerDocIdentificacionPersona;

    @JsonProperty(value="VerContratoNovedad")
    private Boolean asesorVerContratoNovedad;

    @JsonProperty(value="CanalComercial")
    private String asesorCanalComercial;

    @JsonProperty(value="Cargo")
    private String asesorCargo;

    @JsonProperty(value="Estado")
    private String asesorEstado;

    @JsonProperty(value="AccesoValidadorUsuarios")
    private Boolean asesorAccesoValidadorUsuarios;

    public Boolean getAsesorModDBasicosPersona() {
        return asesorModDBasicosPersona;
    }
    
    public void setAsesorModDBasicosPersona(Boolean asesorModDBasicosPersona) {
        this.asesorModDBasicosPersona = asesorModDBasicosPersona;
    }

    public Boolean getAsesormodificaDirector() {
        return asesormodificaDirector;
    }
    
    public void setAsesormodificaDirector(Boolean asesormodificaDirector) {
        this.asesormodificaDirector = asesormodificaDirector;
    }

    public Boolean getAsesoresDirector() {
        return asesoresDirector;
    }
    
    public void setAsesoresDirector(Boolean asesoresDirector) {
        this.asesoresDirector = asesoresDirector;
    }

    public String getAsesorNumIdentificacion() {
        return asesorNumIdentificacion;
    }
    
    public void setAsesorNumIdentificacion(String asesorNumIdentificacion) {
        this.asesorNumIdentificacion = asesorNumIdentificacion;
    }

    public Boolean getAsesorEsIntegral() {
        return asesorEsIntegral;
    }
    
    public void setAsesorEsIntegral(Boolean asesorEsIntegral) {
        this.asesorEsIntegral = asesorEsIntegral;
    }

    public Boolean getAsesorVerDBasicosPersona() {
        return asesorVerDBasicosPersona;
    }
    
    public void setAsesorVerDBasicosPersona(Boolean asesorVerDBasicosPersona) {
        this.asesorVerDBasicosPersona = asesorVerDBasicosPersona;
    }

    public Boolean getAsesorVerDocIdentificacionPersona() {
        return asesorVerDocIdentificacionPersona;
    }
    
    public void setAsesorVerDocIdentificacionPersona(Boolean asesorVerDocIdentificacionPersona) {
        this.asesorVerDocIdentificacionPersona = asesorVerDocIdentificacionPersona;
    }

    public Boolean getAsesorVerContratoNovedad() {
        return asesorVerContratoNovedad;
    }
    
    public void setAsesorVerContratoNovedad(Boolean asesorVerContratoNovedad) {
        this.asesorVerContratoNovedad = asesorVerContratoNovedad;
    }

    public String getAsesorCanalComercial() {
        return asesorCanalComercial;
    }
    
    public void setAsesorCanalComercial(String asesorCanalComercial) {
        this.asesorCanalComercial = asesorCanalComercial;
    }

    public String getAsesorCargo() {
        return asesorCargo;
    }
    
    public void setAsesorCargo(String asesorCargo) {
        this.asesorCargo = asesorCargo;
    }

    public String getAsesorEstado() {
        return asesorEstado;
    }
    
    public void setAsesorEstado(String asesorEstado) {
        this.asesorEstado = asesorEstado;
    }

    public Boolean getAsesorAccesoValidadorUsuarios() {
        return asesorAccesoValidadorUsuarios;
    }
    
    public void setAsesorAccesoValidadorUsuarios(Boolean asesorAccesoValidadorUsuarios) {
        this.asesorAccesoValidadorUsuarios = asesorAccesoValidadorUsuarios;
    }
}
