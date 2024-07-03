package com.keralty.aeusuarios.viewmodel.funcionario.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionarioPutViewModel {

    @JsonProperty(value="Usuario")
    private String funcionarioUsuario;

    @JsonProperty(value="PrimerNombre")
    private String funcionarioPrimerNombre;

    @JsonProperty(value="SegundoNombre")
    private String funcionarioSegundoNombre;

    @JsonProperty(value="PrimerApellido")
    private String funcionarioPrimerApellido;

    @JsonProperty(value="SegundoApellido")
    private String funcionarioSegundoApellido;

    @JsonProperty(value="UsuarioLDAP")
    private String funcionarioUsuarioLDAP;

    @JsonProperty(value="Email")
    private String funcionarioEmail;

    @JsonProperty(value="CodJefe")
    private String funcionarioCodJefe;

    @JsonProperty(value="Disponible")
    private Boolean funcionarioDisponible;

    @JsonProperty(value="NumSolNoTerminadas")
    private Long funcionarioNumSolNoTerminadas;

    public String getFuncionarioUsuario() {
        return funcionarioUsuario;
    }
    
    public void setFuncionarioUsuario(String funcionarioUsuario) {
        this.funcionarioUsuario = funcionarioUsuario;
    }

    public String getFuncionarioPrimerNombre() {
        return funcionarioPrimerNombre;
    }
    
    public void setFuncionarioPrimerNombre(String funcionarioPrimerNombre) {
        this.funcionarioPrimerNombre = funcionarioPrimerNombre;
    }

    public String getFuncionarioSegundoNombre() {
        return funcionarioSegundoNombre;
    }
    
    public void setFuncionarioSegundoNombre(String funcionarioSegundoNombre) {
        this.funcionarioSegundoNombre = funcionarioSegundoNombre;
    }

    public String getFuncionarioPrimerApellido() {
        return funcionarioPrimerApellido;
    }
    
    public void setFuncionarioPrimerApellido(String funcionarioPrimerApellido) {
        this.funcionarioPrimerApellido = funcionarioPrimerApellido;
    }

    public String getFuncionarioSegundoApellido() {
        return funcionarioSegundoApellido;
    }
    
    public void setFuncionarioSegundoApellido(String funcionarioSegundoApellido) {
        this.funcionarioSegundoApellido = funcionarioSegundoApellido;
    }

    public String getFuncionarioUsuarioLDAP() {
        return funcionarioUsuarioLDAP;
    }
    
    public void setFuncionarioUsuarioLDAP(String funcionarioUsuarioLDAP) {
        this.funcionarioUsuarioLDAP = funcionarioUsuarioLDAP;
    }

    public String getFuncionarioEmail() {
        return funcionarioEmail;
    }
    
    public void setFuncionarioEmail(String funcionarioEmail) {
        this.funcionarioEmail = funcionarioEmail;
    }

    public String getFuncionarioCodJefe() {
        return funcionarioCodJefe;
    }
    
    public void setFuncionarioCodJefe(String funcionarioCodJefe) {
        this.funcionarioCodJefe = funcionarioCodJefe;
    }

    public Boolean getFuncionarioDisponible() {
        return funcionarioDisponible;
    }
    
    public void setFuncionarioDisponible(Boolean funcionarioDisponible) {
        this.funcionarioDisponible = funcionarioDisponible;
    }

    public Long getFuncionarioNumSolNoTerminadas() {
        return funcionarioNumSolNoTerminadas;
    }
    
    public void setFuncionarioNumSolNoTerminadas(Long funcionarioNumSolNoTerminadas) {
        this.funcionarioNumSolNoTerminadas = funcionarioNumSolNoTerminadas;
    }
}
