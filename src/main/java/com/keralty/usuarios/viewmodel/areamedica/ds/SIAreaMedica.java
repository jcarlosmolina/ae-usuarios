package com.keralty.usuarios.viewmodel.areamedica.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.AreaMedica;
public class SIAreaMedica {

    @JsonProperty("usuarioldap")
    private String sIAreaMedicaUsuarioLDAP;

    public SIAreaMedica() {
    
    }

    public SIAreaMedica(AreaMedica instance) {
        if (instance != null) {
            try {
                this.sIAreaMedicaUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getSIAreaMedicaUsuarioLDAP() {
        return this.sIAreaMedicaUsuarioLDAP;
    }
    
    public void setSIAreaMedicaUsuarioLDAP(String sIAreaMedicaUsuarioLDAP) {
        this.sIAreaMedicaUsuarioLDAP = sIAreaMedicaUsuarioLDAP;
    }
}
