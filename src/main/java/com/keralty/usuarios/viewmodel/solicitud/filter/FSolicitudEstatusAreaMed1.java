package com.keralty.usuarios.viewmodel.solicitud.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.usuarios.persistence.oid.ProductosOid;
import com.keralty.usuarios.persistence.oid.PlanesOid;
import com.keralty.usuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.usuarios.persistence.oid.RegionalOid;
import com.keralty.usuarios.global.SolicitudConstants;
import com.keralty.usuarios.viewmodel.FilterRequest;

public class FSolicitudEstatusAreaMed1 {

    @JsonProperty("v_numsolicitud")
    private String vNumSolicitud;

    @JsonProperty("v_tramite")
    private Long vTramite;

    @JsonProperty("vo_producto")
    private ProductosOid voProducto;

    @JsonProperty("vo_plan")
    private PlanesOid voPlan;

    @JsonProperty("v_felabini")
    private Date vFElabIni;

    @JsonProperty("v_felabfin")
    private Date vFElabFin;

    @JsonProperty("v_fcontratoini")
    private Date vFContratoIni;

    @JsonProperty("v_fcontratofin")
    private Date vFContratoFin;

    @JsonProperty("v_codasesor")
    private String vCodAsesor;

    @JsonProperty("v_tipodoc")
    private TipoIdentificacionOid vTipoDoc;

    @JsonProperty("v_numdoc")
    private String vNumDoc;

    @JsonProperty("vo_regional")
    private RegionalOid voRegional;

    @JsonProperty("vo_estadodoc")
    private Long voEstadoDoc;

    public FSolicitudEstatusAreaMed1() {
        // Default constructor
    }

    @JsonIgnore
    public String getVNumSolicitud() {
        return this.vNumSolicitud;
    }
    
    public void setVNumSolicitud(String vNumSolicitud) {
        this.vNumSolicitud = vNumSolicitud;
    }

    @JsonIgnore
    public Long getVTramite() {
        return this.vTramite;
    }
    
    public void setVTramite(Long vTramite) {
        this.vTramite = vTramite;
    }

    @JsonIgnore
    public ProductosOid getVoProducto() {
        return this.voProducto;
    }
    
    public void setVoProducto(ProductosOid voProducto) {
        this.voProducto = voProducto;
    }

    @JsonIgnore
    public PlanesOid getVoPlan() {
        return this.voPlan;
    }
    
    public void setVoPlan(PlanesOid voPlan) {
        this.voPlan = voPlan;
    }

    @JsonIgnore
    public Date getVFElabIni() {
        return this.vFElabIni;
    }
    
    public void setVFElabIni(Date vFElabIni) {
        this.vFElabIni = vFElabIni;
    }

    @JsonIgnore
    public Date getVFElabFin() {
        return this.vFElabFin;
    }
    
    public void setVFElabFin(Date vFElabFin) {
        this.vFElabFin = vFElabFin;
    }

    @JsonIgnore
    public Date getVFContratoIni() {
        return this.vFContratoIni;
    }
    
    public void setVFContratoIni(Date vFContratoIni) {
        this.vFContratoIni = vFContratoIni;
    }

    @JsonIgnore
    public Date getVFContratoFin() {
        return this.vFContratoFin;
    }
    
    public void setVFContratoFin(Date vFContratoFin) {
        this.vFContratoFin = vFContratoFin;
    }

    @JsonIgnore
    public String getVCodAsesor() {
        return this.vCodAsesor;
    }
    
    public void setVCodAsesor(String vCodAsesor) {
        this.vCodAsesor = vCodAsesor;
    }

    @JsonIgnore
    public TipoIdentificacionOid getVTipoDoc() {
        return this.vTipoDoc;
    }
    
    public void setVTipoDoc(TipoIdentificacionOid vTipoDoc) {
        this.vTipoDoc = vTipoDoc;
    }

    @JsonIgnore
    public String getVNumDoc() {
        return this.vNumDoc;
    }
    
    public void setVNumDoc(String vNumDoc) {
        this.vNumDoc = vNumDoc;
    }

    @JsonIgnore
    public RegionalOid getVoRegional() {
        return this.voRegional;
    }
    
    public void setVoRegional(RegionalOid voRegional) {
        this.voRegional = voRegional;
    }

    @JsonIgnore
    public Long getVoEstadoDoc() {
        return this.voEstadoDoc;
    }
    
    public void setVoEstadoDoc(Long voEstadoDoc) {
        this.voEstadoDoc = voEstadoDoc;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudConstants.FILTER_NAME_FSOLICITUDESTATUSAREAMED1);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VNUMSOLICITUD, vNumSolicitud);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VTRAMITE, vTramite);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VOPRODUCTO, voProducto);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VOPLAN, voPlan);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VFELABINI, vFElabIni);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VFELABFIN, vFElabFin);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VFCONTRATOINI, vFContratoIni);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VFCONTRATOFIN, vFContratoFin);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VCODASESOR, vCodAsesor);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VTIPODOC, vTipoDoc);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VNUMDOC, vNumDoc);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VOREGIONAL, voRegional);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDESTATUSAREAMED1_VOESTADODOC, voEstadoDoc);
        return filterRequest;
    }
}
