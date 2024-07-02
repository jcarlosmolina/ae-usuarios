package com.keralty.usuarios.viewmodel.frecuenciaact.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.NotNullArgumentException;
import com.keralty.usuarios.global.FrecuenciaActConstants;
import com.keralty.usuarios.persistence.FrecuenciaAct;
import com.keralty.usuarios.persistence.oid.FrecuenciaActOid;
import java.sql.Date;

public class FijarSincronizacionRequest {

    @JsonProperty("p_thisfrecuenciaact_oid")
    private FrecuenciaActOid frecuenciaActfijarSincronizacionpthisFrecuenciaAct;
    
    @JsonIgnore
    private FrecuenciaAct frecuenciaActfijarSincronizacionpthisFrecuenciaActInstance;

    @JsonProperty("p_fechaultimasinc")
    private Date frecuenciaActfijarSincronizacionpFechaUltimaSinc;

    @JsonProperty("p_resultadosinc")
    private String frecuenciaActfijarSincronizacionpResultadoSinc;

    @JsonProperty("p_usuario")
    private String frecuenciaActfijarSincronizacionpUsuario;

    @JsonProperty("p_nombreusuario")
    private String frecuenciaActfijarSincronizacionpNombreUsuario;

    public void checkArguments() throws NotNullArgumentException {
        checkFrecuenciaActfijarSincronizacionpthisFrecuenciaAct();
    }

    @JsonIgnore
    public FrecuenciaActOid getFrecuenciaActfijarSincronizacionpthisFrecuenciaAct() {
        return this.frecuenciaActfijarSincronizacionpthisFrecuenciaAct;
    }
    
    public void setFrecuenciaActfijarSincronizacionpthisFrecuenciaAct(FrecuenciaActOid frecuenciaActfijarSincronizacionpthisFrecuenciaAct) {
        this.frecuenciaActfijarSincronizacionpthisFrecuenciaAct = frecuenciaActfijarSincronizacionpthisFrecuenciaAct;
    }

    @JsonIgnore
    public FrecuenciaAct getFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance() {
        return this.frecuenciaActfijarSincronizacionpthisFrecuenciaActInstance;
    }
    
    public void setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(FrecuenciaAct frecuenciaActfijarSincronizacionpthisFrecuenciaAct) {
        this.frecuenciaActfijarSincronizacionpthisFrecuenciaActInstance = frecuenciaActfijarSincronizacionpthisFrecuenciaAct;
        this.frecuenciaActfijarSincronizacionpthisFrecuenciaAct = frecuenciaActfijarSincronizacionpthisFrecuenciaAct != null ? frecuenciaActfijarSincronizacionpthisFrecuenciaAct.getOid() : null;
    }

    private void checkFrecuenciaActfijarSincronizacionpthisFrecuenciaAct() throws NotNullArgumentException {
        if(this.getFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance() == null || this.getFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance().isNull()) {
            throw new NotNullArgumentException(FrecuenciaActConstants.SERV_ID_FIJARSINCRONIZACION, FrecuenciaActConstants.CLASS_ID, FrecuenciaActConstants.ARG_ID_FIJARSINCRONIZACION_FRECUENCIAACTFIJARSINCRONIZACIONPTHISFRECUENCIAACT, FrecuenciaActConstants.SERV_ALIAS_FIJARSINCRONIZACION, FrecuenciaActConstants.CLASS_ALIAS, FrecuenciaActConstants.ARG_ALIAS_FIJARSINCRONIZACION_FRECUENCIAACTFIJARSINCRONIZACIONPTHISFRECUENCIAACT);
        }
    }

    @JsonIgnore
    public Date getFrecuenciaActfijarSincronizacionpFechaUltimaSinc() {
        return this.frecuenciaActfijarSincronizacionpFechaUltimaSinc;
    }
    
    public void setFrecuenciaActfijarSincronizacionpFechaUltimaSinc(Date frecuenciaActfijarSincronizacionpFechaUltimaSinc) {
        this.frecuenciaActfijarSincronizacionpFechaUltimaSinc = frecuenciaActfijarSincronizacionpFechaUltimaSinc;
    }

    @JsonIgnore
    public String getFrecuenciaActfijarSincronizacionpResultadoSinc() {
        return this.frecuenciaActfijarSincronizacionpResultadoSinc;
    }
    
    public void setFrecuenciaActfijarSincronizacionpResultadoSinc(String frecuenciaActfijarSincronizacionpResultadoSinc) {
        this.frecuenciaActfijarSincronizacionpResultadoSinc = frecuenciaActfijarSincronizacionpResultadoSinc;
    }

    @JsonIgnore
    public String getFrecuenciaActfijarSincronizacionpUsuario() {
        return this.frecuenciaActfijarSincronizacionpUsuario;
    }
    
    public void setFrecuenciaActfijarSincronizacionpUsuario(String frecuenciaActfijarSincronizacionpUsuario) {
        this.frecuenciaActfijarSincronizacionpUsuario = frecuenciaActfijarSincronizacionpUsuario;
    }

    @JsonIgnore
    public String getFrecuenciaActfijarSincronizacionpNombreUsuario() {
        return this.frecuenciaActfijarSincronizacionpNombreUsuario;
    }
    
    public void setFrecuenciaActfijarSincronizacionpNombreUsuario(String frecuenciaActfijarSincronizacionpNombreUsuario) {
        this.frecuenciaActfijarSincronizacionpNombreUsuario = frecuenciaActfijarSincronizacionpNombreUsuario;
    }
}
