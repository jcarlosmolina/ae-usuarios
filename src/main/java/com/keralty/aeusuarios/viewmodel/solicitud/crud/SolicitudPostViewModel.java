package com.keralty.aeusuarios.viewmodel.solicitud.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class SolicitudPostViewModel {

    @JsonProperty(value="NumRadicado")
    private Long solicitudNumRadicado;

    @JsonProperty(value="Tramite")
    private Long solicitudTramite;

    @JsonProperty(value="FInicioContrato")
    private Date solicitudFInicioContrato;

    @JsonProperty(value="EsTraslado")
    private Boolean solicitudEsTraslado;

    @JsonProperty(value="NumContratoInclusion")
    private String solicitudNumContratoInclusion;

    @JsonProperty(value="NumFamilia")
    private String solicitudNumFamilia;

    @JsonProperty(value="codDirector")
    private String solicitudcodDirector;

    @JsonProperty(value="CodTarifa")
    private String solicitudCodTarifa;

    @JsonProperty(value="PorcentajeProrrateo")
    private Double solicitudPorcentajeProrrateo;

    @JsonProperty(value="EnvioCarnetFisico")
    private Boolean solicitudEnvioCarnetFisico;

    public Long getSolicitudNumRadicado() {
        return solicitudNumRadicado;
    }
    
    public void setSolicitudNumRadicado(Long solicitudNumRadicado) {
        this.solicitudNumRadicado = solicitudNumRadicado;
    }

    public Long getSolicitudTramite() {
        return solicitudTramite;
    }
    
    public void setSolicitudTramite(Long solicitudTramite) {
        this.solicitudTramite = solicitudTramite;
    }

    public Date getSolicitudFInicioContrato() {
        return solicitudFInicioContrato;
    }
    
    public void setSolicitudFInicioContrato(Date solicitudFInicioContrato) {
        this.solicitudFInicioContrato = solicitudFInicioContrato;
    }

    public Boolean getSolicitudEsTraslado() {
        return solicitudEsTraslado;
    }
    
    public void setSolicitudEsTraslado(Boolean solicitudEsTraslado) {
        this.solicitudEsTraslado = solicitudEsTraslado;
    }

    public String getSolicitudNumContratoInclusion() {
        return solicitudNumContratoInclusion;
    }
    
    public void setSolicitudNumContratoInclusion(String solicitudNumContratoInclusion) {
        this.solicitudNumContratoInclusion = solicitudNumContratoInclusion;
    }

    public String getSolicitudNumFamilia() {
        return solicitudNumFamilia;
    }
    
    public void setSolicitudNumFamilia(String solicitudNumFamilia) {
        this.solicitudNumFamilia = solicitudNumFamilia;
    }

    public String getSolicitudcodDirector() {
        return solicitudcodDirector;
    }
    
    public void setSolicitudcodDirector(String solicitudcodDirector) {
        this.solicitudcodDirector = solicitudcodDirector;
    }

    public String getSolicitudCodTarifa() {
        return solicitudCodTarifa;
    }
    
    public void setSolicitudCodTarifa(String solicitudCodTarifa) {
        this.solicitudCodTarifa = solicitudCodTarifa;
    }

    public Double getSolicitudPorcentajeProrrateo() {
        return solicitudPorcentajeProrrateo;
    }
    
    public void setSolicitudPorcentajeProrrateo(Double solicitudPorcentajeProrrateo) {
        this.solicitudPorcentajeProrrateo = solicitudPorcentajeProrrateo;
    }

    public Boolean getSolicitudEnvioCarnetFisico() {
        return solicitudEnvioCarnetFisico;
    }
    
    public void setSolicitudEnvioCarnetFisico(Boolean solicitudEnvioCarnetFisico) {
        this.solicitudEnvioCarnetFisico = solicitudEnvioCarnetFisico;
    }
}
