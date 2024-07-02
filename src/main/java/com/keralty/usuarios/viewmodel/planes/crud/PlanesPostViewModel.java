package com.keralty.usuarios.viewmodel.planes.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanesPostViewModel {

    @JsonProperty(value="Plan")
    private Long planesPlan;

    @JsonProperty(value="Nombre")
    private String planesNombre;

    @JsonProperty(value="EsBancoRep")
    private Boolean planesEsBancoRep;

    @JsonProperty(value="CodigoLegal")
    private String planesCodigoLegal;

    public Long getPlanesPlan() {
        return planesPlan;
    }
    
    public void setPlanesPlan(Long planesPlan) {
        this.planesPlan = planesPlan;
    }

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
}
