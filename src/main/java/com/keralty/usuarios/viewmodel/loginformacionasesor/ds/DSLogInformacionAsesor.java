package com.keralty.usuarios.viewmodel.loginformacionasesor.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.LogInformacionAsesor;
public class DSLogInformacionAsesor {

    @JsonProperty("fechahora")
    private Timestamp dSLogInformacionAsesorFechaHora;

    @JsonProperty("loginfuncionario")
    private String dSLogInformacionAsesorLoginFuncionario;

    @JsonProperty("verdatospersona")
    private Boolean dSLogInformacionAsesorVerDatosPersona;

    @JsonProperty("verdocspersona")
    private Boolean dSLogInformacionAsesorVerDocsPersona;

    @JsonProperty("vercontratonovedad")
    private Boolean dSLogInformacionAsesorVerContratoNovedad;

    @JsonProperty("accesovalidadorusuarios")
    private Boolean dSLogInformacionAsesorAccesoValidadorUsuarios;

    public DSLogInformacionAsesor() {
    
    }

    public DSLogInformacionAsesor(LogInformacionAsesor instance) {
        if (instance != null) {
            this.dSLogInformacionAsesorFechaHora = instance.getLogInformacionAsesorFechaHora();
            this.dSLogInformacionAsesorLoginFuncionario = instance.getLogInformacionAsesorLoginFuncionario();
            this.dSLogInformacionAsesorVerDatosPersona = instance.getLogInformacionAsesorVerDatosPersona();
            this.dSLogInformacionAsesorVerDocsPersona = instance.getLogInformacionAsesorVerDocsPersona();
            this.dSLogInformacionAsesorVerContratoNovedad = instance.getLogInformacionAsesorVerContratoNovedad();
            this.dSLogInformacionAsesorAccesoValidadorUsuarios = instance.getLogInformacionAsesorAccesoValidadorUsuarios();
        }
    }

    @JsonIgnore
    public Timestamp getDSLogInformacionAsesorFechaHora() {
        return this.dSLogInformacionAsesorFechaHora;
    }
    
    public void setDSLogInformacionAsesorFechaHora(Timestamp dSLogInformacionAsesorFechaHora) {
        this.dSLogInformacionAsesorFechaHora = dSLogInformacionAsesorFechaHora;
    }

    @JsonIgnore
    public String getDSLogInformacionAsesorLoginFuncionario() {
        return this.dSLogInformacionAsesorLoginFuncionario;
    }
    
    public void setDSLogInformacionAsesorLoginFuncionario(String dSLogInformacionAsesorLoginFuncionario) {
        this.dSLogInformacionAsesorLoginFuncionario = dSLogInformacionAsesorLoginFuncionario;
    }

    @JsonIgnore
    public Boolean getDSLogInformacionAsesorVerDatosPersona() {
        return this.dSLogInformacionAsesorVerDatosPersona;
    }
    
    public void setDSLogInformacionAsesorVerDatosPersona(Boolean dSLogInformacionAsesorVerDatosPersona) {
        this.dSLogInformacionAsesorVerDatosPersona = dSLogInformacionAsesorVerDatosPersona;
    }

    @JsonIgnore
    public Boolean getDSLogInformacionAsesorVerDocsPersona() {
        return this.dSLogInformacionAsesorVerDocsPersona;
    }
    
    public void setDSLogInformacionAsesorVerDocsPersona(Boolean dSLogInformacionAsesorVerDocsPersona) {
        this.dSLogInformacionAsesorVerDocsPersona = dSLogInformacionAsesorVerDocsPersona;
    }

    @JsonIgnore
    public Boolean getDSLogInformacionAsesorVerContratoNovedad() {
        return this.dSLogInformacionAsesorVerContratoNovedad;
    }
    
    public void setDSLogInformacionAsesorVerContratoNovedad(Boolean dSLogInformacionAsesorVerContratoNovedad) {
        this.dSLogInformacionAsesorVerContratoNovedad = dSLogInformacionAsesorVerContratoNovedad;
    }

    @JsonIgnore
    public Boolean getDSLogInformacionAsesorAccesoValidadorUsuarios() {
        return this.dSLogInformacionAsesorAccesoValidadorUsuarios;
    }
    
    public void setDSLogInformacionAsesorAccesoValidadorUsuarios(Boolean dSLogInformacionAsesorAccesoValidadorUsuarios) {
        this.dSLogInformacionAsesorAccesoValidadorUsuarios = dSLogInformacionAsesorAccesoValidadorUsuarios;
    }
}
