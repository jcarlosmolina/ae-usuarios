package com.keralty.usuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Solicitud;
public class DSSolicitudIIUNuevaAfil {

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String dSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD;

    @JsonProperty("aesolicitudes_fechaasignacion")
    private Date dSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION;

    @JsonProperty("finiciocontrato")
    private Date dSSolicitudIIUNuevaAfilFInicioContrato;

    @JsonProperty("drvgrupoasociado")
    private String dSSolicitudIIUNuevaAfilDrvGrupoAsociado;

    @JsonProperty("estraslado")
    private Boolean dSSolicitudIIUNuevaAfilEsTraslado;

    @JsonProperty("enviocarnetfisico")
    private Boolean dSSolicitudIIUNuevaAfilEnvioCarnetFisico;

    public DSSolicitudIIUNuevaAfil() {
    
    }

    public DSSolicitudIIUNuevaAfil(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD = instance.getAESOLICITUDES().getAESOLICITUDESNUMEROSOLICITUD();
                this.dSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION = instance.getAESOLICITUDES().getAESOLICITUDESFECHAASIGNACION();
                this.dSSolicitudIIUNuevaAfilFInicioContrato = instance.getSolicitudFInicioContrato();
                this.dSSolicitudIIUNuevaAfilDrvGrupoAsociado = instance.getSolicituddrvGrupoAsociado();
                this.dSSolicitudIIUNuevaAfilEsTraslado = instance.getSolicitudEsTraslado();
                this.dSSolicitudIIUNuevaAfilEnvioCarnetFisico = instance.getSolicitudEnvioCarnetFisico();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD() {
        return this.dSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD;
    }
    
    public void setDSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD(String dSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD) {
        this.dSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD = dSSolicitudIIUNuevaAfilAESOLICITUDESDotNUMEROSOLICITUD;
    }

    @JsonIgnore
    public Date getDSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION() {
        return this.dSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION;
    }
    
    public void setDSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION(Date dSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION) {
        this.dSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION = dSSolicitudIIUNuevaAfilAESOLICITUDESDotFECHAASIGNACION;
    }

    @JsonIgnore
    public Date getDSSolicitudIIUNuevaAfilFInicioContrato() {
        return this.dSSolicitudIIUNuevaAfilFInicioContrato;
    }
    
    public void setDSSolicitudIIUNuevaAfilFInicioContrato(Date dSSolicitudIIUNuevaAfilFInicioContrato) {
        this.dSSolicitudIIUNuevaAfilFInicioContrato = dSSolicitudIIUNuevaAfilFInicioContrato;
    }

    @JsonIgnore
    public String getDSSolicitudIIUNuevaAfilDrvGrupoAsociado() {
        return this.dSSolicitudIIUNuevaAfilDrvGrupoAsociado;
    }
    
    public void setDSSolicitudIIUNuevaAfilDrvGrupoAsociado(String dSSolicitudIIUNuevaAfilDrvGrupoAsociado) {
        this.dSSolicitudIIUNuevaAfilDrvGrupoAsociado = dSSolicitudIIUNuevaAfilDrvGrupoAsociado;
    }

    @JsonIgnore
    public Boolean getDSSolicitudIIUNuevaAfilEsTraslado() {
        return this.dSSolicitudIIUNuevaAfilEsTraslado;
    }
    
    public void setDSSolicitudIIUNuevaAfilEsTraslado(Boolean dSSolicitudIIUNuevaAfilEsTraslado) {
        this.dSSolicitudIIUNuevaAfilEsTraslado = dSSolicitudIIUNuevaAfilEsTraslado;
    }

    @JsonIgnore
    public Boolean getDSSolicitudIIUNuevaAfilEnvioCarnetFisico() {
        return this.dSSolicitudIIUNuevaAfilEnvioCarnetFisico;
    }
    
    public void setDSSolicitudIIUNuevaAfilEnvioCarnetFisico(Boolean dSSolicitudIIUNuevaAfilEnvioCarnetFisico) {
        this.dSSolicitudIIUNuevaAfilEnvioCarnetFisico = dSSolicitudIIUNuevaAfilEnvioCarnetFisico;
    }
}
