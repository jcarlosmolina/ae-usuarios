package com.keralty.usuarios.viewmodel.solicitudnovedad.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class SolicitudNovedadPostViewModel {

    @JsonProperty(value="FechaVigencia")
    private Date solicitudNovedadFechaVigencia;

    @JsonProperty(value="NumContrato")
    private String solicitudNovedadNumContrato;

    @JsonProperty(value="Excepcion")
    private Boolean solicitudNovedadExcepcion;

    @JsonProperty(value="FechaIniExcepcion")
    private Date solicitudNovedadFechaIniExcepcion;

    @JsonProperty(value="FechaFinExcepcion")
    private Date solicitudNovedadFechaFinExcepcion;

    public Date getSolicitudNovedadFechaVigencia() {
        return solicitudNovedadFechaVigencia;
    }
    
    public void setSolicitudNovedadFechaVigencia(Date solicitudNovedadFechaVigencia) {
        this.solicitudNovedadFechaVigencia = solicitudNovedadFechaVigencia;
    }

    public String getSolicitudNovedadNumContrato() {
        return solicitudNovedadNumContrato;
    }
    
    public void setSolicitudNovedadNumContrato(String solicitudNovedadNumContrato) {
        this.solicitudNovedadNumContrato = solicitudNovedadNumContrato;
    }

    public Boolean getSolicitudNovedadExcepcion() {
        return solicitudNovedadExcepcion;
    }
    
    public void setSolicitudNovedadExcepcion(Boolean solicitudNovedadExcepcion) {
        this.solicitudNovedadExcepcion = solicitudNovedadExcepcion;
    }

    public Date getSolicitudNovedadFechaIniExcepcion() {
        return solicitudNovedadFechaIniExcepcion;
    }
    
    public void setSolicitudNovedadFechaIniExcepcion(Date solicitudNovedadFechaIniExcepcion) {
        this.solicitudNovedadFechaIniExcepcion = solicitudNovedadFechaIniExcepcion;
    }

    public Date getSolicitudNovedadFechaFinExcepcion() {
        return solicitudNovedadFechaFinExcepcion;
    }
    
    public void setSolicitudNovedadFechaFinExcepcion(Date solicitudNovedadFechaFinExcepcion) {
        this.solicitudNovedadFechaFinExcepcion = solicitudNovedadFechaFinExcepcion;
    }
}
