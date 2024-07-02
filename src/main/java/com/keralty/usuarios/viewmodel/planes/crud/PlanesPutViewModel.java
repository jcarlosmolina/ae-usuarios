package com.keralty.usuarios.viewmodel.planes.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanesPutViewModel {

    @JsonProperty(value="Nombre")
    private String planesNombre;

    @JsonProperty(value="EsBancoRep")
    private Boolean planesEsBancoRep;

    @JsonProperty(value="CodigoLegal")
    private String planesCodigoLegal;

    @JsonProperty(value="AceptaPreexistencias")
    private Boolean planesAceptaPreexistencias;

    @JsonProperty(value="EsVoluntario")
    private Boolean planesEsVoluntario;

    @JsonProperty(value="InicioContDiaUno")
    private Boolean planesInicioContDiaUno;

    public String getPlanesNombre() {
        return planesNombre;
    }
    
    public void setPlanesNombre(String planesNombre) {
        this.planesNombre = planesNombre;
    }

    public Boolean getPlanesEsBancoRep() {
        return planesEsBancoRep;
    }
    
    public void setPlanesEsBancoRep(Boolean planesEsBancoRep) {
        this.planesEsBancoRep = planesEsBancoRep;
    }

    public String getPlanesCodigoLegal() {
        return planesCodigoLegal;
    }
    
    public void setPlanesCodigoLegal(String planesCodigoLegal) {
        this.planesCodigoLegal = planesCodigoLegal;
    }

    public Boolean getPlanesAceptaPreexistencias() {
        return planesAceptaPreexistencias;
    }
    
    public void setPlanesAceptaPreexistencias(Boolean planesAceptaPreexistencias) {
        this.planesAceptaPreexistencias = planesAceptaPreexistencias;
    }

    public Boolean getPlanesEsVoluntario() {
        return planesEsVoluntario;
    }
    
    public void setPlanesEsVoluntario(Boolean planesEsVoluntario) {
        this.planesEsVoluntario = planesEsVoluntario;
    }

    public Boolean getPlanesInicioContDiaUno() {
        return planesInicioContDiaUno;
    }
    
    public void setPlanesInicioContDiaUno(Boolean planesInicioContDiaUno) {
        this.planesInicioContDiaUno = planesInicioContDiaUno;
    }
}
