package com.keralty.aeusuarios.viewmodel.logfuncionario.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogFuncionarioPostViewModel {

    @JsonProperty(value="LoginFuncionario")
    private String logFuncionarioLoginFuncionario;

    @JsonProperty(value="Disponible")
    private Boolean logFuncionarioDisponible;

    public String getLogFuncionarioLoginFuncionario() {
        return logFuncionarioLoginFuncionario;
    }
    
    public void setLogFuncionarioLoginFuncionario(String logFuncionarioLoginFuncionario) {
        this.logFuncionarioLoginFuncionario = logFuncionarioLoginFuncionario;
    }

    public Boolean getLogFuncionarioDisponible() {
        return logFuncionarioDisponible;
    }
    
    public void setLogFuncionarioDisponible(Boolean logFuncionarioDisponible) {
        this.logFuncionarioDisponible = logFuncionarioDisponible;
    }
}
