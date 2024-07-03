package com.keralty.aeusuarios.viewmodel.dominio.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DominioPostViewModel {

    @JsonProperty(value="ReqCuesMed")
    private Boolean dominioReqCuesMed;

    @JsonProperty(value="NoCuesMedTras")
    private Boolean dominioNoCuesMedTras;

    @JsonProperty(value="NuevaAfiliacion")
    private Boolean dominioNuevaAfiliacion;

    @JsonProperty(value="Inclusion")
    private Boolean dominioInclusion;

    @JsonProperty(value="AcepCuesMat")
    private Boolean dominioAcepCuesMat;

    @JsonProperty(value="AcepCuesNeo")
    private Boolean dominioAcepCuesNeo;

    @JsonProperty(value="AcepBBGestante")
    private Boolean dominioAcepBBGestante;

    @JsonProperty(value="MostrarPreexAnexos")
    private Boolean dominioMostrarPreexAnexos;

    @JsonProperty(value="MostrarPreexContrato")
    private Boolean dominioMostrarPreexContrato;

    @JsonProperty(value="IgnorarPreexistencias")
    private Boolean dominioIgnorarPreexistencias;

    @JsonProperty(value="ProrrateoUsuExistente")
    private Boolean dominioProrrateoUsuExistente;

    @JsonProperty(value="InclusionModGrupoAsoc")
    private Boolean dominioInclusionModGrupoAsoc;

    @JsonProperty(value="PermiteRechazadosAfi")
    private Boolean dominioPermiteRechazadosAfi;

    @JsonProperty(value="AcepPolizaInter")
    private Boolean dominioAcepPolizaInter;

    @JsonProperty(value="NovExcepcionReqDoc")
    private Boolean dominioNovExcepcionReqDoc;

    @JsonProperty(value="SolNovColorOscuro")
    private String dominioSolNovColorOscuro;

    @JsonProperty(value="SolNovColorClaro")
    private String dominioSolNovColorClaro;

    @JsonProperty(value="SolNovLogo")
    private String dominioSolNovLogo;

    @JsonProperty(value="TramiteEnLinea")
    private Boolean dominioTramiteEnLinea;

    @JsonProperty(value="VigenciaRadicacion")
    private Boolean dominioVigenciaRadicacion;

    public Boolean getDominioReqCuesMed() {
        return dominioReqCuesMed;
    }
    
    public void setDominioReqCuesMed(Boolean dominioReqCuesMed) {
        this.dominioReqCuesMed = dominioReqCuesMed;
    }

    public Boolean getDominioNoCuesMedTras() {
        return dominioNoCuesMedTras;
    }
    
    public void setDominioNoCuesMedTras(Boolean dominioNoCuesMedTras) {
        this.dominioNoCuesMedTras = dominioNoCuesMedTras;
    }

    public Boolean getDominioNuevaAfiliacion() {
        return dominioNuevaAfiliacion;
    }
    
    public void setDominioNuevaAfiliacion(Boolean dominioNuevaAfiliacion) {
        this.dominioNuevaAfiliacion = dominioNuevaAfiliacion;
    }

    public Boolean getDominioInclusion() {
        return dominioInclusion;
    }
    
    public void setDominioInclusion(Boolean dominioInclusion) {
        this.dominioInclusion = dominioInclusion;
    }

    public Boolean getDominioAcepCuesMat() {
        return dominioAcepCuesMat;
    }
    
    public void setDominioAcepCuesMat(Boolean dominioAcepCuesMat) {
        this.dominioAcepCuesMat = dominioAcepCuesMat;
    }

    public Boolean getDominioAcepCuesNeo() {
        return dominioAcepCuesNeo;
    }
    
    public void setDominioAcepCuesNeo(Boolean dominioAcepCuesNeo) {
        this.dominioAcepCuesNeo = dominioAcepCuesNeo;
    }

    public Boolean getDominioAcepBBGestante() {
        return dominioAcepBBGestante;
    }
    
    public void setDominioAcepBBGestante(Boolean dominioAcepBBGestante) {
        this.dominioAcepBBGestante = dominioAcepBBGestante;
    }

    public Boolean getDominioMostrarPreexAnexos() {
        return dominioMostrarPreexAnexos;
    }
    
    public void setDominioMostrarPreexAnexos(Boolean dominioMostrarPreexAnexos) {
        this.dominioMostrarPreexAnexos = dominioMostrarPreexAnexos;
    }

    public Boolean getDominioMostrarPreexContrato() {
        return dominioMostrarPreexContrato;
    }
    
    public void setDominioMostrarPreexContrato(Boolean dominioMostrarPreexContrato) {
        this.dominioMostrarPreexContrato = dominioMostrarPreexContrato;
    }

    public Boolean getDominioIgnorarPreexistencias() {
        return dominioIgnorarPreexistencias;
    }
    
    public void setDominioIgnorarPreexistencias(Boolean dominioIgnorarPreexistencias) {
        this.dominioIgnorarPreexistencias = dominioIgnorarPreexistencias;
    }

    public Boolean getDominioProrrateoUsuExistente() {
        return dominioProrrateoUsuExistente;
    }
    
    public void setDominioProrrateoUsuExistente(Boolean dominioProrrateoUsuExistente) {
        this.dominioProrrateoUsuExistente = dominioProrrateoUsuExistente;
    }

    public Boolean getDominioInclusionModGrupoAsoc() {
        return dominioInclusionModGrupoAsoc;
    }
    
    public void setDominioInclusionModGrupoAsoc(Boolean dominioInclusionModGrupoAsoc) {
        this.dominioInclusionModGrupoAsoc = dominioInclusionModGrupoAsoc;
    }

    public Boolean getDominioPermiteRechazadosAfi() {
        return dominioPermiteRechazadosAfi;
    }
    
    public void setDominioPermiteRechazadosAfi(Boolean dominioPermiteRechazadosAfi) {
        this.dominioPermiteRechazadosAfi = dominioPermiteRechazadosAfi;
    }

    public Boolean getDominioAcepPolizaInter() {
        return dominioAcepPolizaInter;
    }
    
    public void setDominioAcepPolizaInter(Boolean dominioAcepPolizaInter) {
        this.dominioAcepPolizaInter = dominioAcepPolizaInter;
    }

    public Boolean getDominioNovExcepcionReqDoc() {
        return dominioNovExcepcionReqDoc;
    }
    
    public void setDominioNovExcepcionReqDoc(Boolean dominioNovExcepcionReqDoc) {
        this.dominioNovExcepcionReqDoc = dominioNovExcepcionReqDoc;
    }

    public String getDominioSolNovColorOscuro() {
        return dominioSolNovColorOscuro;
    }
    
    public void setDominioSolNovColorOscuro(String dominioSolNovColorOscuro) {
        this.dominioSolNovColorOscuro = dominioSolNovColorOscuro;
    }

    public String getDominioSolNovColorClaro() {
        return dominioSolNovColorClaro;
    }
    
    public void setDominioSolNovColorClaro(String dominioSolNovColorClaro) {
        this.dominioSolNovColorClaro = dominioSolNovColorClaro;
    }

    public String getDominioSolNovLogo() {
        return dominioSolNovLogo;
    }
    
    public void setDominioSolNovLogo(String dominioSolNovLogo) {
        this.dominioSolNovLogo = dominioSolNovLogo;
    }

    public Boolean getDominioTramiteEnLinea() {
        return dominioTramiteEnLinea;
    }
    
    public void setDominioTramiteEnLinea(Boolean dominioTramiteEnLinea) {
        this.dominioTramiteEnLinea = dominioTramiteEnLinea;
    }

    public Boolean getDominioVigenciaRadicacion() {
        return dominioVigenciaRadicacion;
    }
    
    public void setDominioVigenciaRadicacion(Boolean dominioVigenciaRadicacion) {
        this.dominioVigenciaRadicacion = dominioVigenciaRadicacion;
    }
}
