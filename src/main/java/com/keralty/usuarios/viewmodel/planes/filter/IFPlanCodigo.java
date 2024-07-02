package com.keralty.usuarios.viewmodel.planes.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.usuarios.global.PlanesConstants;
import com.keralty.usuarios.viewmodel.FilterRequest;

public class IFPlanCodigo {

    @JsonProperty("v_codigo")
    private Long vCodigo;

    public IFPlanCodigo() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVCodigo() {
        return this.vCodigo;
    }
    
    public void setVCodigo(Long vCodigo) {
        this.vCodigo = vCodigo;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(PlanesConstants.FILTER_NAME_IFPLANCODIGO);
        filterRequest.addFilterVariable(PlanesConstants.VAR_NAME_IFPLANCODIGO_VCODIGO, vCodigo);
        return filterRequest;
    }
}
