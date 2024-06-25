package com.keralty.aeusuarios.viewmodel.firma.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Firma;
public class DSFirmaPIUResponsable {

    @JsonProperty("respregional_usuario")
    private String dSFirmaPIUResponsableRespRegionalDotUsuario;

    @JsonProperty("respregional_drvnombrecompleto")
    private String dSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto;

    @JsonProperty("respregional_sucursal_descripcion")
    private String dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion;

    @JsonProperty("respregional_sucursal_regional_descripcion")
    private String dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion;

    public DSFirmaPIUResponsable() {
    
    }

    public DSFirmaPIUResponsable(Firma instance) {
        if (instance != null) {
            try {
                this.dSFirmaPIUResponsableRespRegionalDotUsuario = instance.getRespRegional().getFuncionarioUsuario();
                this.dSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto = instance.getRespRegional().getFuncionariodrvNombreCompleto();
                this.dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion = instance.getRespRegional().getSucursal().getSucursalDescripcion();
                this.dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion = instance.getRespRegional().getSucursal().getRegional().getRegionalDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotUsuario() {
        return this.dSFirmaPIUResponsableRespRegionalDotUsuario;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotUsuario(String dSFirmaPIUResponsableRespRegionalDotUsuario) {
        this.dSFirmaPIUResponsableRespRegionalDotUsuario = dSFirmaPIUResponsableRespRegionalDotUsuario;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto() {
        return this.dSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto(String dSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto) {
        this.dSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto = dSFirmaPIUResponsableRespRegionalDotDrvNombreCompleto;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion() {
        return this.dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion(String dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion) {
        this.dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion = dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion() {
        return this.dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion(String dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion) {
        this.dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion = dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion;
    }
}
