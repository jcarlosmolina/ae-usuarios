package com.keralty.usuarios.viewmodel.sucursal.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.NotNullArgumentException;
import com.keralty.usuarios.global.SucursalConstants;
import com.keralty.usuarios.persistence.oid.SucursalOid;
import com.keralty.usuarios.persistence.Sucursal;

public class SincronizarRequest {

    @JsonProperty("p_thissucursal_oid")
    private SucursalOid sucursalsincronizarpthisSucursal;
    
    @JsonIgnore
    private Sucursal sucursalsincronizarpthisSucursalInstance;

    @JsonProperty("p_descripcion")
    private String sucursalsincronizarpDescripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkSucursalsincronizarpthisSucursal();
        checkSucursalsincronizarpDescripcion();
    }

    @JsonIgnore
    public SucursalOid getSucursalsincronizarpthisSucursal() {
        return this.sucursalsincronizarpthisSucursal;
    }
    
    public void setSucursalsincronizarpthisSucursal(SucursalOid sucursalsincronizarpthisSucursal) {
        this.sucursalsincronizarpthisSucursal = sucursalsincronizarpthisSucursal;
    }

    @JsonIgnore
    public Sucursal getSucursalsincronizarpthisSucursalInstance() {
        return this.sucursalsincronizarpthisSucursalInstance;
    }
    
    public void setSucursalsincronizarpthisSucursalInstance(Sucursal sucursalsincronizarpthisSucursal) {
        this.sucursalsincronizarpthisSucursalInstance = sucursalsincronizarpthisSucursal;
        this.sucursalsincronizarpthisSucursal = sucursalsincronizarpthisSucursal != null ? sucursalsincronizarpthisSucursal.getOid() : null;
    }

    private void checkSucursalsincronizarpthisSucursal() throws NotNullArgumentException {
        if(this.getSucursalsincronizarpthisSucursalInstance() == null || this.getSucursalsincronizarpthisSucursalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_SINCRONIZAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_SINCRONIZAR_SUCURSALSINCRONIZARPTHISSUCURSAL, SucursalConstants.SERV_ALIAS_SINCRONIZAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_SINCRONIZAR_SUCURSALSINCRONIZARPTHISSUCURSAL);
        }
    }

    @JsonIgnore
    public String getSucursalsincronizarpDescripcion() {
        return this.sucursalsincronizarpDescripcion;
    }
    
    public void setSucursalsincronizarpDescripcion(String sucursalsincronizarpDescripcion) {
        this.sucursalsincronizarpDescripcion = sucursalsincronizarpDescripcion;
    }

    private void checkSucursalsincronizarpDescripcion() throws NotNullArgumentException {
        if(this.getSucursalsincronizarpDescripcion() == null) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_SINCRONIZAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_SINCRONIZAR_SUCURSALSINCRONIZARPDESCRIPCION, SucursalConstants.SERV_ALIAS_SINCRONIZAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_SINCRONIZAR_SUCURSALSINCRONIZARPDESCRIPCION);
        }
    }
}
