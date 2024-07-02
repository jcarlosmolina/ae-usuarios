package com.keralty.usuarios.viewmodel.contratoc.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.sql.Timestamp;

public class ContratoCPostViewModel {

    @JsonProperty(value="NumContrato")
    private String contratoCNumContrato;

    @JsonProperty(value="NumSolicitud")
    private String contratoCNumSolicitud;

    @JsonProperty(value="FechaSolicitud")
    private Date contratoCFechaSolicitud;

    @JsonProperty(value="TipoContrato")
    private Long contratoCTipoContrato;

    @JsonProperty(value="FechaIniVigencia")
    private Date contratoCFechaIniVigencia;

    @JsonProperty(value="FechaFinVigencia")
    private Date contratoCFechaFinVigencia;

    @JsonProperty(value="Direccion")
    private String contratoCDireccion;

    @JsonProperty(value="correoContratante")
    private String contratoCcorreoContratante;

    @JsonProperty(value="numTelContratante")
    private String contratoCnumTelContratante;

    @JsonProperty(value="numCelContratante")
    private String contratoCnumCelContratante;

    @JsonProperty(value="exentoIVA")
    private String contratoCexentoIVA;

    @JsonProperty(value="ContratoConFirma")
    private Boolean contratoCContratoConFirma;

    @JsonProperty(value="UltimaActualizacion")
    private Timestamp contratoCUltimaActualizacion;

    @JsonProperty(value="CodTarifa")
    private String contratoCCodTarifa;

    public String getContratoCNumContrato() {
        return contratoCNumContrato;
    }
    
    public void setContratoCNumContrato(String contratoCNumContrato) {
        this.contratoCNumContrato = contratoCNumContrato;
    }

    public String getContratoCNumSolicitud() {
        return contratoCNumSolicitud;
    }
    
    public void setContratoCNumSolicitud(String contratoCNumSolicitud) {
        this.contratoCNumSolicitud = contratoCNumSolicitud;
    }

    public Date getContratoCFechaSolicitud() {
        return contratoCFechaSolicitud;
    }
    
    public void setContratoCFechaSolicitud(Date contratoCFechaSolicitud) {
        this.contratoCFechaSolicitud = contratoCFechaSolicitud;
    }

    public Long getContratoCTipoContrato() {
        return contratoCTipoContrato;
    }
    
    public void setContratoCTipoContrato(Long contratoCTipoContrato) {
        this.contratoCTipoContrato = contratoCTipoContrato;
    }

    public Date getContratoCFechaIniVigencia() {
        return contratoCFechaIniVigencia;
    }
    
    public void setContratoCFechaIniVigencia(Date contratoCFechaIniVigencia) {
        this.contratoCFechaIniVigencia = contratoCFechaIniVigencia;
    }

    public Date getContratoCFechaFinVigencia() {
        return contratoCFechaFinVigencia;
    }
    
    public void setContratoCFechaFinVigencia(Date contratoCFechaFinVigencia) {
        this.contratoCFechaFinVigencia = contratoCFechaFinVigencia;
    }

    public String getContratoCDireccion() {
        return contratoCDireccion;
    }
    
    public void setContratoCDireccion(String contratoCDireccion) {
        this.contratoCDireccion = contratoCDireccion;
    }

    public String getContratoCcorreoContratante() {
        return contratoCcorreoContratante;
    }
    
    public void setContratoCcorreoContratante(String contratoCcorreoContratante) {
        this.contratoCcorreoContratante = contratoCcorreoContratante;
    }

    public String getContratoCnumTelContratante() {
        return contratoCnumTelContratante;
    }
    
    public void setContratoCnumTelContratante(String contratoCnumTelContratante) {
        this.contratoCnumTelContratante = contratoCnumTelContratante;
    }

    public String getContratoCnumCelContratante() {
        return contratoCnumCelContratante;
    }
    
    public void setContratoCnumCelContratante(String contratoCnumCelContratante) {
        this.contratoCnumCelContratante = contratoCnumCelContratante;
    }

    public String getContratoCexentoIVA() {
        return contratoCexentoIVA;
    }
    
    public void setContratoCexentoIVA(String contratoCexentoIVA) {
        this.contratoCexentoIVA = contratoCexentoIVA;
    }

    public Boolean getContratoCContratoConFirma() {
        return contratoCContratoConFirma;
    }
    
    public void setContratoCContratoConFirma(Boolean contratoCContratoConFirma) {
        this.contratoCContratoConFirma = contratoCContratoConFirma;
    }

    public Timestamp getContratoCUltimaActualizacion() {
        return contratoCUltimaActualizacion;
    }
    
    public void setContratoCUltimaActualizacion(Timestamp contratoCUltimaActualizacion) {
        this.contratoCUltimaActualizacion = contratoCUltimaActualizacion;
    }

    public String getContratoCCodTarifa() {
        return contratoCCodTarifa;
    }
    
    public void setContratoCCodTarifa(String contratoCCodTarifa) {
        this.contratoCCodTarifa = contratoCCodTarifa;
    }
}
