package com.keralty.usuarios.viewmodel.loginformacionasesor.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogInformacionAsesorPostViewModel {

    @JsonProperty(value="LoginFuncionario")
    private String logInformacionAsesorLoginFuncionario;

    @JsonProperty(value="VerDatosPersona")
    private Boolean logInformacionAsesorVerDatosPersona;

    @JsonProperty(value="VerDocsPersona")
    private Boolean logInformacionAsesorVerDocsPersona;

    @JsonProperty(value="VerContratoNovedad")
    private Boolean logInformacionAsesorVerContratoNovedad;

    @JsonProperty(value="AccesoValidadorUsuarios")
    private Boolean logInformacionAsesorAccesoValidadorUsuarios;

    public String getLogInformacionAsesorLoginFuncionario() {
        return logInformacionAsesorLoginFuncionario;
    }
    
    public void setLogInformacionAsesorLoginFuncionario(String logInformacionAsesorLoginFuncionario) {
        this.logInformacionAsesorLoginFuncionario = logInformacionAsesorLoginFuncionario;
    }

    public Boolean getLogInformacionAsesorVerDatosPersona() {
        return logInformacionAsesorVerDatosPersona;
    }
    
    public void setLogInformacionAsesorVerDatosPersona(Boolean logInformacionAsesorVerDatosPersona) {
        this.logInformacionAsesorVerDatosPersona = logInformacionAsesorVerDatosPersona;
    }

    public Boolean getLogInformacionAsesorVerDocsPersona() {
        return logInformacionAsesorVerDocsPersona;
    }
    
    public void setLogInformacionAsesorVerDocsPersona(Boolean logInformacionAsesorVerDocsPersona) {
        this.logInformacionAsesorVerDocsPersona = logInformacionAsesorVerDocsPersona;
    }

    public Boolean getLogInformacionAsesorVerContratoNovedad() {
        return logInformacionAsesorVerContratoNovedad;
    }
    
    public void setLogInformacionAsesorVerContratoNovedad(Boolean logInformacionAsesorVerContratoNovedad) {
        this.logInformacionAsesorVerContratoNovedad = logInformacionAsesorVerContratoNovedad;
    }

    public Boolean getLogInformacionAsesorAccesoValidadorUsuarios() {
        return logInformacionAsesorAccesoValidadorUsuarios;
    }
    
    public void setLogInformacionAsesorAccesoValidadorUsuarios(Boolean logInformacionAsesorAccesoValidadorUsuarios) {
        this.logInformacionAsesorAccesoValidadorUsuarios = logInformacionAsesorAccesoValidadorUsuarios;
    }
}
