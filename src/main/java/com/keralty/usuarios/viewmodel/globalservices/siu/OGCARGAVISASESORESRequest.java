package com.keralty.usuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.NotNullArgumentException;
import com.keralty.usuarios.global.GlobalServiceConstants;

public class OGCARGAVISASESORESRequest {

    @JsonProperty("ptfichero")
    private byte[] oGCARGAVISASESORESptFichero;

    public void checkArguments() throws NotNullArgumentException {
        checkOGCARGAVISASESORESptFichero();
    }

    @JsonIgnore
    public byte[] getOGCARGAVISASESORESptFichero() {
        return this.oGCARGAVISASESORESptFichero;
    }
    
    public void setOGCARGAVISASESORESptFichero(byte[] oGCARGAVISASESORESptFichero) {
        this.oGCARGAVISASESORESptFichero = oGCARGAVISASESORESptFichero;
    }

    private void checkOGCARGAVISASESORESptFichero() throws NotNullArgumentException {
        if(this.getOGCARGAVISASESORESptFichero() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGCARGAVISASESORES, GlobalServiceConstants.GS_ARG_ID_OGCARGAVISASESORES_OGCARGAVISASESORESPTFICHERO, GlobalServiceConstants.G_SERV_ALIAS_OGCARGAVISASESORES, GlobalServiceConstants.GS_ARG_ALIAS_OGCARGAVISASESORES_OGCARGAVISASESORESPTFICHERO);
        }
    }
}
