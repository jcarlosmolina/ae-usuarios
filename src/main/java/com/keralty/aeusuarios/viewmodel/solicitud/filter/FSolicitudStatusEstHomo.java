package com.keralty.aeusuarios.viewmodel.solicitud.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FSolicitudStatusEstHomo {

    @JsonProperty("v_numsolicitud")
    private String vNumSolicitud;

    @JsonProperty("v_tramite")
    private Long vTramite;

    @JsonProperty("vo_producto")
    private ProductosOid voProducto;

    @JsonProperty("vo_plan")
    private PlanesOid voPlan;

    @JsonProperty("vo_estado")
    private Long voEstado;

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

    @JsonProperty("v_estadodoc")
    private Long vEstadoDoc;

    public FSolicitudStatusEstHomo() {
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
    public Long getVoEstado() {
        return this.voEstado;
    }
    
    public void setVoEstado(Long voEstado) {
        this.voEstado = voEstado;
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
    public Long getVEstadoDoc() {
        return this.vEstadoDoc;
    }
    
    public void setVEstadoDoc(Long vEstadoDoc) {
        this.vEstadoDoc = vEstadoDoc;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudConstants.FILTER_NAME_FSOLICITUDSTATUSESTHOMO);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VNUMSOLICITUD, vNumSolicitud);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VTRAMITE, vTramite);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VOPRODUCTO, voProducto);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VOPLAN, voPlan);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VOESTADO, voEstado);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VFELABINI, vFElabIni);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VFELABFIN, vFElabFin);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VFCONTRATOINI, vFContratoIni);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VFCONTRATOFIN, vFContratoFin);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VCODASESOR, vCodAsesor);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VTIPODOC, vTipoDoc);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VNUMDOC, vNumDoc);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VOREGIONAL, voRegional);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_FSOLICITUDSTATUSESTHOMO_VESTADODOC, vEstadoDoc);
        return filterRequest;
    }
}
