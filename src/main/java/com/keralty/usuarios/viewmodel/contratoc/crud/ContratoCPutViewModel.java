package com.keralty.usuarios.viewmodel.contratoc.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.sql.Timestamp;

public class ContratoCPutViewModel {

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

    @JsonProperty(value="valorCuotaPeriodo")
    private Double contratoCvalorCuotaPeriodo;

    @JsonProperty(value="descuentoComercial")
    private Double contratoCdescuentoComercial;

    @JsonProperty(value="IVA")
    private Double contratoCIVA;

    @JsonProperty(value="descuentoFinanciero")
    private Double contratoCdescuentoFinanciero;

    @JsonProperty(value="contratoNotificado")
    private Boolean contratoCcontratoNotificado;

    @JsonProperty(value="UltimaActualizacion")
    private Timestamp contratoCUltimaActualizacion;

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

    public Double getContratoCvalorCuotaPeriodo() {
        return contratoCvalorCuotaPeriodo;
    }
    
    public void setContratoCvalorCuotaPeriodo(Double contratoCvalorCuotaPeriodo) {
        this.contratoCvalorCuotaPeriodo = contratoCvalorCuotaPeriodo;
    }

    public Double getContratoCdescuentoComercial() {
        return contratoCdescuentoComercial;
    }
    
    public void setContratoCdescuentoComercial(Double contratoCdescuentoComercial) {
        this.contratoCdescuentoComercial = contratoCdescuentoComercial;
    }

    public Double getContratoCIVA() {
        return contratoCIVA;
    }
    
    public void setContratoCIVA(Double contratoCIVA) {
        this.contratoCIVA = contratoCIVA;
    }

    public Double getContratoCdescuentoFinanciero() {
        return contratoCdescuentoFinanciero;
    }
    
    public void setContratoCdescuentoFinanciero(Double contratoCdescuentoFinanciero) {
        this.contratoCdescuentoFinanciero = contratoCdescuentoFinanciero;
    }

    public Boolean getContratoCcontratoNotificado() {
        return contratoCcontratoNotificado;
    }
    
    public void setContratoCcontratoNotificado(Boolean contratoCcontratoNotificado) {
        this.contratoCcontratoNotificado = contratoCcontratoNotificado;
    }

    public Timestamp getContratoCUltimaActualizacion() {
        return contratoCUltimaActualizacion;
    }
    
    public void setContratoCUltimaActualizacion(Timestamp contratoCUltimaActualizacion) {
        this.contratoCUltimaActualizacion = contratoCUltimaActualizacion;
    }
}
