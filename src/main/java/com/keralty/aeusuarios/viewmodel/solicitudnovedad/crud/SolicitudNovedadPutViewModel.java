package com.keralty.aeusuarios.viewmodel.solicitudnovedad.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.sql.Date;

public class SolicitudNovedadPutViewModel {

    @JsonProperty(value="CtrCodigoTarifa")
    private String solicitudNovedadCtrCodigoTarifa;

    @JsonProperty(value="CtrDescTarifa")
    private String solicitudNovedadCtrDescTarifa;

    @JsonProperty(value="CtrCodigoConvenio")
    private String solicitudNovedadCtrCodigoConvenio;

    @JsonProperty(value="CtrDescConvenio")
    private String solicitudNovedadCtrDescConvenio;

    @JsonProperty(value="CtrEsColectivo")
    private Boolean solicitudNovedadCtrEsColectivo;

    @JsonProperty(value="CtrTagCausaExclusion")
    private String solicitudNovedadCtrTagCausaExclusion;

    @JsonProperty(value="ContraNumIden")
    private String solicitudNovedadContraNumIden;

    @JsonProperty(value="ContraPrimerNombre")
    private String solicitudNovedadContraPrimerNombre;

    @JsonProperty(value="ContraSegundoNombre")
    private String solicitudNovedadContraSegundoNombre;

    @JsonProperty(value="ContraPrimerApellido")
    private String solicitudNovedadContraPrimerApellido;

    @JsonProperty(value="ContraSegundoApellido")
    private String solicitudNovedadContraSegundoApellido;

    @JsonProperty(value="ContraRazonSocial")
    private String solicitudNovedadContraRazonSocial;

    @JsonProperty(value="FechaUltimoDoc")
    private Timestamp solicitudNovedadFechaUltimoDoc;

    @JsonProperty(value="Observacions")
    private String solicitudNovedadObservacions;

    @JsonProperty(value="Estado")
    private Long solicitudNovedadEstado;

    @JsonProperty(value="EstadoDocumentacion")
    private Long solicitudNovedadEstadoDocumentacion;

    @JsonProperty(value="Completada")
    private Boolean solicitudNovedadCompletada;

    @JsonProperty(value="FechaCompletada")
    private Timestamp solicitudNovedadFechaCompletada;

    @JsonProperty(value="CtrActivo")
    private Boolean solicitudNovedadCtrActivo;

    @JsonProperty(value="CtrTipoContrato")
    private Long solicitudNovedadCtrTipoContrato;

    @JsonProperty(value="SCNumMeses")
    private Long solicitudNovedadSCNumMeses;

    @JsonProperty(value="ContraNuevaRazonSocial")
    private String solicitudNovedadContraNuevaRazonSocial;

    @JsonProperty(value="ContraTipoPersona")
    private String solicitudNovedadContraTipoPersona;

    @JsonProperty(value="CtrFInicioContrato")
    private Date solicitudNovedadCtrFInicioContrato;

    @JsonProperty(value="Prioridad")
    private Long solicitudNovedadPrioridad;

    @JsonProperty(value="FechaTerminada")
    private Date solicitudNovedadFechaTerminada;

    @JsonProperty(value="FechaFUG")
    private Timestamp solicitudNovedadFechaFUG;

    @JsonProperty(value="FechaFA")
    private Timestamp solicitudNovedadFechaFA;

    @JsonProperty(value="SemaforoGrabAse")
    private Double solicitudNovedadSemaforoGrabAse;

    public String getSolicitudNovedadCtrCodigoTarifa() {
        return solicitudNovedadCtrCodigoTarifa;
    }
    
    public void setSolicitudNovedadCtrCodigoTarifa(String solicitudNovedadCtrCodigoTarifa) {
        this.solicitudNovedadCtrCodigoTarifa = solicitudNovedadCtrCodigoTarifa;
    }

    public String getSolicitudNovedadCtrDescTarifa() {
        return solicitudNovedadCtrDescTarifa;
    }
    
    public void setSolicitudNovedadCtrDescTarifa(String solicitudNovedadCtrDescTarifa) {
        this.solicitudNovedadCtrDescTarifa = solicitudNovedadCtrDescTarifa;
    }

    public String getSolicitudNovedadCtrCodigoConvenio() {
        return solicitudNovedadCtrCodigoConvenio;
    }
    
    public void setSolicitudNovedadCtrCodigoConvenio(String solicitudNovedadCtrCodigoConvenio) {
        this.solicitudNovedadCtrCodigoConvenio = solicitudNovedadCtrCodigoConvenio;
    }

    public String getSolicitudNovedadCtrDescConvenio() {
        return solicitudNovedadCtrDescConvenio;
    }
    
    public void setSolicitudNovedadCtrDescConvenio(String solicitudNovedadCtrDescConvenio) {
        this.solicitudNovedadCtrDescConvenio = solicitudNovedadCtrDescConvenio;
    }

    public Boolean getSolicitudNovedadCtrEsColectivo() {
        return solicitudNovedadCtrEsColectivo;
    }
    
    public void setSolicitudNovedadCtrEsColectivo(Boolean solicitudNovedadCtrEsColectivo) {
        this.solicitudNovedadCtrEsColectivo = solicitudNovedadCtrEsColectivo;
    }

    public String getSolicitudNovedadCtrTagCausaExclusion() {
        return solicitudNovedadCtrTagCausaExclusion;
    }
    
    public void setSolicitudNovedadCtrTagCausaExclusion(String solicitudNovedadCtrTagCausaExclusion) {
        this.solicitudNovedadCtrTagCausaExclusion = solicitudNovedadCtrTagCausaExclusion;
    }

    public String getSolicitudNovedadContraNumIden() {
        return solicitudNovedadContraNumIden;
    }
    
    public void setSolicitudNovedadContraNumIden(String solicitudNovedadContraNumIden) {
        this.solicitudNovedadContraNumIden = solicitudNovedadContraNumIden;
    }

    public String getSolicitudNovedadContraPrimerNombre() {
        return solicitudNovedadContraPrimerNombre;
    }
    
    public void setSolicitudNovedadContraPrimerNombre(String solicitudNovedadContraPrimerNombre) {
        this.solicitudNovedadContraPrimerNombre = solicitudNovedadContraPrimerNombre;
    }

    public String getSolicitudNovedadContraSegundoNombre() {
        return solicitudNovedadContraSegundoNombre;
    }
    
    public void setSolicitudNovedadContraSegundoNombre(String solicitudNovedadContraSegundoNombre) {
        this.solicitudNovedadContraSegundoNombre = solicitudNovedadContraSegundoNombre;
    }

    public String getSolicitudNovedadContraPrimerApellido() {
        return solicitudNovedadContraPrimerApellido;
    }
    
    public void setSolicitudNovedadContraPrimerApellido(String solicitudNovedadContraPrimerApellido) {
        this.solicitudNovedadContraPrimerApellido = solicitudNovedadContraPrimerApellido;
    }

    public String getSolicitudNovedadContraSegundoApellido() {
        return solicitudNovedadContraSegundoApellido;
    }
    
    public void setSolicitudNovedadContraSegundoApellido(String solicitudNovedadContraSegundoApellido) {
        this.solicitudNovedadContraSegundoApellido = solicitudNovedadContraSegundoApellido;
    }

    public String getSolicitudNovedadContraRazonSocial() {
        return solicitudNovedadContraRazonSocial;
    }
    
    public void setSolicitudNovedadContraRazonSocial(String solicitudNovedadContraRazonSocial) {
        this.solicitudNovedadContraRazonSocial = solicitudNovedadContraRazonSocial;
    }

    public Timestamp getSolicitudNovedadFechaUltimoDoc() {
        return solicitudNovedadFechaUltimoDoc;
    }
    
    public void setSolicitudNovedadFechaUltimoDoc(Timestamp solicitudNovedadFechaUltimoDoc) {
        this.solicitudNovedadFechaUltimoDoc = solicitudNovedadFechaUltimoDoc;
    }

    public String getSolicitudNovedadObservacions() {
        return solicitudNovedadObservacions;
    }
    
    public void setSolicitudNovedadObservacions(String solicitudNovedadObservacions) {
        this.solicitudNovedadObservacions = solicitudNovedadObservacions;
    }

    public Long getSolicitudNovedadEstado() {
        return solicitudNovedadEstado;
    }
    
    public void setSolicitudNovedadEstado(Long solicitudNovedadEstado) {
        this.solicitudNovedadEstado = solicitudNovedadEstado;
    }

    public Long getSolicitudNovedadEstadoDocumentacion() {
        return solicitudNovedadEstadoDocumentacion;
    }
    
    public void setSolicitudNovedadEstadoDocumentacion(Long solicitudNovedadEstadoDocumentacion) {
        this.solicitudNovedadEstadoDocumentacion = solicitudNovedadEstadoDocumentacion;
    }

    public Boolean getSolicitudNovedadCompletada() {
        return solicitudNovedadCompletada;
    }
    
    public void setSolicitudNovedadCompletada(Boolean solicitudNovedadCompletada) {
        this.solicitudNovedadCompletada = solicitudNovedadCompletada;
    }

    public Timestamp getSolicitudNovedadFechaCompletada() {
        return solicitudNovedadFechaCompletada;
    }
    
    public void setSolicitudNovedadFechaCompletada(Timestamp solicitudNovedadFechaCompletada) {
        this.solicitudNovedadFechaCompletada = solicitudNovedadFechaCompletada;
    }

    public Boolean getSolicitudNovedadCtrActivo() {
        return solicitudNovedadCtrActivo;
    }
    
    public void setSolicitudNovedadCtrActivo(Boolean solicitudNovedadCtrActivo) {
        this.solicitudNovedadCtrActivo = solicitudNovedadCtrActivo;
    }

    public Long getSolicitudNovedadCtrTipoContrato() {
        return solicitudNovedadCtrTipoContrato;
    }
    
    public void setSolicitudNovedadCtrTipoContrato(Long solicitudNovedadCtrTipoContrato) {
        this.solicitudNovedadCtrTipoContrato = solicitudNovedadCtrTipoContrato;
    }

    public Long getSolicitudNovedadSCNumMeses() {
        return solicitudNovedadSCNumMeses;
    }
    
    public void setSolicitudNovedadSCNumMeses(Long solicitudNovedadSCNumMeses) {
        this.solicitudNovedadSCNumMeses = solicitudNovedadSCNumMeses;
    }

    public String getSolicitudNovedadContraNuevaRazonSocial() {
        return solicitudNovedadContraNuevaRazonSocial;
    }
    
    public void setSolicitudNovedadContraNuevaRazonSocial(String solicitudNovedadContraNuevaRazonSocial) {
        this.solicitudNovedadContraNuevaRazonSocial = solicitudNovedadContraNuevaRazonSocial;
    }

    public String getSolicitudNovedadContraTipoPersona() {
        return solicitudNovedadContraTipoPersona;
    }
    
    public void setSolicitudNovedadContraTipoPersona(String solicitudNovedadContraTipoPersona) {
        this.solicitudNovedadContraTipoPersona = solicitudNovedadContraTipoPersona;
    }

    public Date getSolicitudNovedadCtrFInicioContrato() {
        return solicitudNovedadCtrFInicioContrato;
    }
    
    public void setSolicitudNovedadCtrFInicioContrato(Date solicitudNovedadCtrFInicioContrato) {
        this.solicitudNovedadCtrFInicioContrato = solicitudNovedadCtrFInicioContrato;
    }

    public Long getSolicitudNovedadPrioridad() {
        return solicitudNovedadPrioridad;
    }
    
    public void setSolicitudNovedadPrioridad(Long solicitudNovedadPrioridad) {
        this.solicitudNovedadPrioridad = solicitudNovedadPrioridad;
    }

    public Date getSolicitudNovedadFechaTerminada() {
        return solicitudNovedadFechaTerminada;
    }
    
    public void setSolicitudNovedadFechaTerminada(Date solicitudNovedadFechaTerminada) {
        this.solicitudNovedadFechaTerminada = solicitudNovedadFechaTerminada;
    }

    public Timestamp getSolicitudNovedadFechaFUG() {
        return solicitudNovedadFechaFUG;
    }
    
    public void setSolicitudNovedadFechaFUG(Timestamp solicitudNovedadFechaFUG) {
        this.solicitudNovedadFechaFUG = solicitudNovedadFechaFUG;
    }

    public Timestamp getSolicitudNovedadFechaFA() {
        return solicitudNovedadFechaFA;
    }
    
    public void setSolicitudNovedadFechaFA(Timestamp solicitudNovedadFechaFA) {
        this.solicitudNovedadFechaFA = solicitudNovedadFechaFA;
    }

    public Double getSolicitudNovedadSemaforoGrabAse() {
        return solicitudNovedadSemaforoGrabAse;
    }
    
    public void setSolicitudNovedadSemaforoGrabAse(Double solicitudNovedadSemaforoGrabAse) {
        this.solicitudNovedadSemaforoGrabAse = solicitudNovedadSemaforoGrabAse;
    }
}
