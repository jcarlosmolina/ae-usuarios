package com.keralty.aeusuarios.viewmodel.respregional.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.RespRegional;
public class DSRespRegional {

    @JsonProperty("drvnombrecompleto")
    private String dSRespRegionalDrvNombreCompleto;

    public DSRespRegional() {
    
    }

    public DSRespRegional(RespRegional instance) {
        if (instance != null) {
            try {
                this.dSRespRegionalDrvNombreCompleto = instance.getFuncionariodrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSRespRegionalDrvNombreCompleto() {
        return this.dSRespRegionalDrvNombreCompleto;
    }
    
    public void setDSRespRegionalDrvNombreCompleto(String dSRespRegionalDrvNombreCompleto) {
        this.dSRespRegionalDrvNombreCompleto = dSRespRegionalDrvNombreCompleto;
    }
}
