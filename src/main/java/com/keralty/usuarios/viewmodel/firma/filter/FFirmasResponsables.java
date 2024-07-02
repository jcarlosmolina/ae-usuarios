package com.keralty.usuarios.viewmodel.firma.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.usuarios.persistence.oid.RegionalOid;
import com.keralty.usuarios.global.FirmaConstants;
import com.keralty.usuarios.viewmodel.FilterRequest;

public class FFirmasResponsables {

    @JsonProperty("v_usuario")
    private String vUsuario;

    @JsonProperty("v_nombre")
    private String vNombre;

    @JsonProperty("vo_regional")
    private RegionalOid voRegional;

    public FFirmasResponsables() {
        // Default constructor
    }

    @JsonIgnore
    public String getVUsuario() {
        return this.vUsuario;
    }
    
    public void setVUsuario(String vUsuario) {
        this.vUsuario = vUsuario;
    }

    @JsonIgnore
    public String getVNombre() {
        return this.vNombre;
    }
    
    public void setVNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    @JsonIgnore
    public RegionalOid getVoRegional() {
        return this.voRegional;
    }
    
    public void setVoRegional(RegionalOid voRegional) {
        this.voRegional = voRegional;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(FirmaConstants.FILTER_NAME_FFIRMASRESPONSABLES);
        filterRequest.addFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VUSUARIO, vUsuario);
        filterRequest.addFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VNOMBRE, vNombre);
        filterRequest.addFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL, voRegional);
        return filterRequest;
    }
}
