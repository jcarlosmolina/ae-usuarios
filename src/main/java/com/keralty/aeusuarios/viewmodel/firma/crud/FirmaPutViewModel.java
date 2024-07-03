package com.keralty.aeusuarios.viewmodel.firma.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FirmaPutViewModel {

    @JsonProperty(value="ImagenFirma")
    private byte[] firmaImagenFirma;

    @JsonProperty(value="Latitud")
    private String firmaLatitud;

    @JsonProperty(value="Longitud")
    private String firmaLongitud;

    public byte[] getFirmaImagenFirma() {
        return firmaImagenFirma;
    }
    
    public void setFirmaImagenFirma(byte[] firmaImagenFirma) {
        this.firmaImagenFirma = firmaImagenFirma;
    }

    public String getFirmaLatitud() {
        return firmaLatitud;
    }
    
    public void setFirmaLatitud(String firmaLatitud) {
        this.firmaLatitud = firmaLatitud;
    }

    public String getFirmaLongitud() {
        return firmaLongitud;
    }
    
    public void setFirmaLongitud(String firmaLongitud) {
        this.firmaLongitud = firmaLongitud;
    }
}
