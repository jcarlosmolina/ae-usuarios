package com.keralty.usuarios.viewmodel.solicitud.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.sql.Timestamp;

public class SolicitudPutViewModel {

    @JsonProperty(value="NumContrato")
    private String solicitudNumContrato;

    @JsonProperty(value="FInicioContrato")
    private Date solicitudFInicioContrato;

    @JsonProperty(value="tipoContrato")
    private Long solicitudtipoContrato;

    @JsonProperty(value="codigoSucursalRad")
    private String solicitudcodigoSucursalRad;

    @JsonProperty(value="contratoConFirma")
    private Boolean solicitudcontratoConFirma;

    @JsonProperty(value="observacions")
    private String solicitudobservacions;

    @JsonProperty(value="exentoIVA")
    private String solicitudexentoIVA;

    @JsonProperty(value="valorCuota")
    private Double solicitudvalorCuota;

    @JsonProperty(value="valorDtoComercialSim")
    private Double solicitudvalorDtoComercialSim;

    @JsonProperty(value="ValorCuotaInscrip")
    private Double solicitudValorCuotaInscrip;

    @JsonProperty(value="ValorDtoFinanciero")
    private Double solicitudValorDtoFinanciero;

    @JsonProperty(value="ValorDtoComercial")
    private Double solicitudValorDtoComercial;

    @JsonProperty(value="datosPagoOK")
    private Boolean solicituddatosPagoOK;

    @JsonProperty(value="valorCuotaPeriodoC")
    private Double solicitudvalorCuotaPeriodoC;

    @JsonProperty(value="descuentoComercialC")
    private Double solicituddescuentoComercialC;

    @JsonProperty(value="IVAC")
    private Double solicitudIVAC;

    @JsonProperty(value="descuentoFinancieroC")
    private Double solicituddescuentoFinancieroC;

    @JsonProperty(value="TieneDifLiquidacion")
    private Boolean solicitudTieneDifLiquidacion;

    @JsonProperty(value="UsuariosValidados")
    private Boolean solicitudUsuariosValidados;

    @JsonProperty(value="EmailURLPagoEnviado")
    private String solicitudEmailURLPagoEnviado;

    @JsonProperty(value="EmailDocuEnviado")
    private String solicitudEmailDocuEnviado;

    @JsonProperty(value="DocsEnviados")
    private Boolean solicitudDocsEnviados;

    @JsonProperty(value="valorCuotaBrutaC")
    private Double solicitudvalorCuotaBrutaC;

    @JsonProperty(value="CodTarifa")
    private String solicitudCodTarifa;

    @JsonProperty(value="Completada")
    private Boolean solicitudCompletada;

    @JsonProperty(value="Estado")
    private Long solicitudEstado;

    @JsonProperty(value="FIniVigContInc")
    private Date solicitudFIniVigContInc;

    @JsonProperty(value="PorcentajeProrrateo")
    private Double solicitudPorcentajeProrrateo;

    @JsonProperty(value="GrupoDelCORE")
    private Long solicitudGrupoDelCORE;

    @JsonProperty(value="TipoFacturaCORE")
    private String solicitudTipoFacturaCORE;

    @JsonProperty(value="ResultSMSInfoPago")
    private String solicitudResultSMSInfoPago;

    @JsonProperty(value="FechaCompletada")
    private Timestamp solicitudFechaCompletada;

    @JsonProperty(value="FechaUltimoDoc")
    private Timestamp solicitudFechaUltimoDoc;

    @JsonProperty(value="Prioridad")
    private Long solicitudPrioridad;

    @JsonProperty(value="FechaTerminada")
    private Date solicitudFechaTerminada;

    @JsonProperty(value="FechaFUG")
    private Timestamp solicitudFechaFUG;

    @JsonProperty(value="FechaFA")
    private Timestamp solicitudFechaFA;

    @JsonProperty(value="FechaFAAM")
    private Timestamp solicitudFechaFAAM;

    @JsonProperty(value="SemaforoGrabAse")
    private Double solicitudSemaforoGrabAse;

    @JsonProperty(value="SemaforoAreaMed")
    private Double solicitudSemaforoAreaMed;

    @JsonProperty(value="EstadoDoc")
    private Long solicitudEstadoDoc;

    @JsonProperty(value="EnvioCarnetFisico")
    private Boolean solicitudEnvioCarnetFisico;

    public String getSolicitudNumContrato() {
        return solicitudNumContrato;
    }
    
    public void setSolicitudNumContrato(String solicitudNumContrato) {
        this.solicitudNumContrato = solicitudNumContrato;
    }

    public Date getSolicitudFInicioContrato() {
        return solicitudFInicioContrato;
    }
    
    public void setSolicitudFInicioContrato(Date solicitudFInicioContrato) {
        this.solicitudFInicioContrato = solicitudFInicioContrato;
    }

    public Long getSolicitudtipoContrato() {
        return solicitudtipoContrato;
    }
    
    public void setSolicitudtipoContrato(Long solicitudtipoContrato) {
        this.solicitudtipoContrato = solicitudtipoContrato;
    }

    public String getSolicitudcodigoSucursalRad() {
        return solicitudcodigoSucursalRad;
    }
    
    public void setSolicitudcodigoSucursalRad(String solicitudcodigoSucursalRad) {
        this.solicitudcodigoSucursalRad = solicitudcodigoSucursalRad;
    }

    public Boolean getSolicitudcontratoConFirma() {
        return solicitudcontratoConFirma;
    }
    
    public void setSolicitudcontratoConFirma(Boolean solicitudcontratoConFirma) {
        this.solicitudcontratoConFirma = solicitudcontratoConFirma;
    }

    public String getSolicitudobservacions() {
        return solicitudobservacions;
    }
    
    public void setSolicitudobservacions(String solicitudobservacions) {
        this.solicitudobservacions = solicitudobservacions;
    }

    public String getSolicitudexentoIVA() {
        return solicitudexentoIVA;
    }
    
    public void setSolicitudexentoIVA(String solicitudexentoIVA) {
        this.solicitudexentoIVA = solicitudexentoIVA;
    }

    public Double getSolicitudvalorCuota() {
        return solicitudvalorCuota;
    }
    
    public void setSolicitudvalorCuota(Double solicitudvalorCuota) {
        this.solicitudvalorCuota = solicitudvalorCuota;
    }

    public Double getSolicitudvalorDtoComercialSim() {
        return solicitudvalorDtoComercialSim;
    }
    
    public void setSolicitudvalorDtoComercialSim(Double solicitudvalorDtoComercialSim) {
        this.solicitudvalorDtoComercialSim = solicitudvalorDtoComercialSim;
    }

    public Double getSolicitudValorCuotaInscrip() {
        return solicitudValorCuotaInscrip;
    }
    
    public void setSolicitudValorCuotaInscrip(Double solicitudValorCuotaInscrip) {
        this.solicitudValorCuotaInscrip = solicitudValorCuotaInscrip;
    }

    public Double getSolicitudValorDtoFinanciero() {
        return solicitudValorDtoFinanciero;
    }
    
    public void setSolicitudValorDtoFinanciero(Double solicitudValorDtoFinanciero) {
        this.solicitudValorDtoFinanciero = solicitudValorDtoFinanciero;
    }

    public Double getSolicitudValorDtoComercial() {
        return solicitudValorDtoComercial;
    }
    
    public void setSolicitudValorDtoComercial(Double solicitudValorDtoComercial) {
        this.solicitudValorDtoComercial = solicitudValorDtoComercial;
    }

    public Boolean getSolicituddatosPagoOK() {
        return solicituddatosPagoOK;
    }
    
    public void setSolicituddatosPagoOK(Boolean solicituddatosPagoOK) {
        this.solicituddatosPagoOK = solicituddatosPagoOK;
    }

    public Double getSolicitudvalorCuotaPeriodoC() {
        return solicitudvalorCuotaPeriodoC;
    }
    
    public void setSolicitudvalorCuotaPeriodoC(Double solicitudvalorCuotaPeriodoC) {
        this.solicitudvalorCuotaPeriodoC = solicitudvalorCuotaPeriodoC;
    }

    public Double getSolicituddescuentoComercialC() {
        return solicituddescuentoComercialC;
    }
    
    public void setSolicituddescuentoComercialC(Double solicituddescuentoComercialC) {
        this.solicituddescuentoComercialC = solicituddescuentoComercialC;
    }

    public Double getSolicitudIVAC() {
        return solicitudIVAC;
    }
    
    public void setSolicitudIVAC(Double solicitudIVAC) {
        this.solicitudIVAC = solicitudIVAC;
    }

    public Double getSolicituddescuentoFinancieroC() {
        return solicituddescuentoFinancieroC;
    }
    
    public void setSolicituddescuentoFinancieroC(Double solicituddescuentoFinancieroC) {
        this.solicituddescuentoFinancieroC = solicituddescuentoFinancieroC;
    }

    public Boolean getSolicitudTieneDifLiquidacion() {
        return solicitudTieneDifLiquidacion;
    }
    
    public void setSolicitudTieneDifLiquidacion(Boolean solicitudTieneDifLiquidacion) {
        this.solicitudTieneDifLiquidacion = solicitudTieneDifLiquidacion;
    }

    public Boolean getSolicitudUsuariosValidados() {
        return solicitudUsuariosValidados;
    }
    
    public void setSolicitudUsuariosValidados(Boolean solicitudUsuariosValidados) {
        this.solicitudUsuariosValidados = solicitudUsuariosValidados;
    }

    public String getSolicitudEmailURLPagoEnviado() {
        return solicitudEmailURLPagoEnviado;
    }
    
    public void setSolicitudEmailURLPagoEnviado(String solicitudEmailURLPagoEnviado) {
        this.solicitudEmailURLPagoEnviado = solicitudEmailURLPagoEnviado;
    }

    public String getSolicitudEmailDocuEnviado() {
        return solicitudEmailDocuEnviado;
    }
    
    public void setSolicitudEmailDocuEnviado(String solicitudEmailDocuEnviado) {
        this.solicitudEmailDocuEnviado = solicitudEmailDocuEnviado;
    }

    public Boolean getSolicitudDocsEnviados() {
        return solicitudDocsEnviados;
    }
    
    public void setSolicitudDocsEnviados(Boolean solicitudDocsEnviados) {
        this.solicitudDocsEnviados = solicitudDocsEnviados;
    }

    public Double getSolicitudvalorCuotaBrutaC() {
        return solicitudvalorCuotaBrutaC;
    }
    
    public void setSolicitudvalorCuotaBrutaC(Double solicitudvalorCuotaBrutaC) {
        this.solicitudvalorCuotaBrutaC = solicitudvalorCuotaBrutaC;
    }

    public String getSolicitudCodTarifa() {
        return solicitudCodTarifa;
    }
    
    public void setSolicitudCodTarifa(String solicitudCodTarifa) {
        this.solicitudCodTarifa = solicitudCodTarifa;
    }

    public Boolean getSolicitudCompletada() {
        return solicitudCompletada;
    }
    
    public void setSolicitudCompletada(Boolean solicitudCompletada) {
        this.solicitudCompletada = solicitudCompletada;
    }

    public Long getSolicitudEstado() {
        return solicitudEstado;
    }
    
    public void setSolicitudEstado(Long solicitudEstado) {
        this.solicitudEstado = solicitudEstado;
    }

    public Date getSolicitudFIniVigContInc() {
        return solicitudFIniVigContInc;
    }
    
    public void setSolicitudFIniVigContInc(Date solicitudFIniVigContInc) {
        this.solicitudFIniVigContInc = solicitudFIniVigContInc;
    }

    public Double getSolicitudPorcentajeProrrateo() {
        return solicitudPorcentajeProrrateo;
    }
    
    public void setSolicitudPorcentajeProrrateo(Double solicitudPorcentajeProrrateo) {
        this.solicitudPorcentajeProrrateo = solicitudPorcentajeProrrateo;
    }

    public Long getSolicitudGrupoDelCORE() {
        return solicitudGrupoDelCORE;
    }
    
    public void setSolicitudGrupoDelCORE(Long solicitudGrupoDelCORE) {
        this.solicitudGrupoDelCORE = solicitudGrupoDelCORE;
    }

    public String getSolicitudTipoFacturaCORE() {
        return solicitudTipoFacturaCORE;
    }
    
    public void setSolicitudTipoFacturaCORE(String solicitudTipoFacturaCORE) {
        this.solicitudTipoFacturaCORE = solicitudTipoFacturaCORE;
    }

    public String getSolicitudResultSMSInfoPago() {
        return solicitudResultSMSInfoPago;
    }
    
    public void setSolicitudResultSMSInfoPago(String solicitudResultSMSInfoPago) {
        this.solicitudResultSMSInfoPago = solicitudResultSMSInfoPago;
    }

    public Timestamp getSolicitudFechaCompletada() {
        return solicitudFechaCompletada;
    }
    
    public void setSolicitudFechaCompletada(Timestamp solicitudFechaCompletada) {
        this.solicitudFechaCompletada = solicitudFechaCompletada;
    }

    public Timestamp getSolicitudFechaUltimoDoc() {
        return solicitudFechaUltimoDoc;
    }
    
    public void setSolicitudFechaUltimoDoc(Timestamp solicitudFechaUltimoDoc) {
        this.solicitudFechaUltimoDoc = solicitudFechaUltimoDoc;
    }

    public Long getSolicitudPrioridad() {
        return solicitudPrioridad;
    }
    
    public void setSolicitudPrioridad(Long solicitudPrioridad) {
        this.solicitudPrioridad = solicitudPrioridad;
    }

    public Date getSolicitudFechaTerminada() {
        return solicitudFechaTerminada;
    }
    
    public void setSolicitudFechaTerminada(Date solicitudFechaTerminada) {
        this.solicitudFechaTerminada = solicitudFechaTerminada;
    }

    public Timestamp getSolicitudFechaFUG() {
        return solicitudFechaFUG;
    }
    
    public void setSolicitudFechaFUG(Timestamp solicitudFechaFUG) {
        this.solicitudFechaFUG = solicitudFechaFUG;
    }

    public Timestamp getSolicitudFechaFA() {
        return solicitudFechaFA;
    }
    
    public void setSolicitudFechaFA(Timestamp solicitudFechaFA) {
        this.solicitudFechaFA = solicitudFechaFA;
    }

    public Timestamp getSolicitudFechaFAAM() {
        return solicitudFechaFAAM;
    }
    
    public void setSolicitudFechaFAAM(Timestamp solicitudFechaFAAM) {
        this.solicitudFechaFAAM = solicitudFechaFAAM;
    }

    public Double getSolicitudSemaforoGrabAse() {
        return solicitudSemaforoGrabAse;
    }
    
    public void setSolicitudSemaforoGrabAse(Double solicitudSemaforoGrabAse) {
        this.solicitudSemaforoGrabAse = solicitudSemaforoGrabAse;
    }

    public Double getSolicitudSemaforoAreaMed() {
        return solicitudSemaforoAreaMed;
    }
    
    public void setSolicitudSemaforoAreaMed(Double solicitudSemaforoAreaMed) {
        this.solicitudSemaforoAreaMed = solicitudSemaforoAreaMed;
    }

    public Long getSolicitudEstadoDoc() {
        return solicitudEstadoDoc;
    }
    
    public void setSolicitudEstadoDoc(Long solicitudEstadoDoc) {
        this.solicitudEstadoDoc = solicitudEstadoDoc;
    }

    public Boolean getSolicitudEnvioCarnetFisico() {
        return solicitudEnvioCarnetFisico;
    }
    
    public void setSolicitudEnvioCarnetFisico(Boolean solicitudEnvioCarnetFisico) {
        this.solicitudEnvioCarnetFisico = solicitudEnvioCarnetFisico;
    }
}
