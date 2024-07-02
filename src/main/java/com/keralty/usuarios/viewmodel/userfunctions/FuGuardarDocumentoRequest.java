package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FuGuardarDocumentoRequest {

    @JsonProperty("p_documento")
    private byte[] pDocumento;

    @JsonProperty("p_nombredoc")
    private String pNombreDoc;

    @JsonProperty("p_pathparcial")
    private String pPathParcial;

    public FuGuardarDocumentoRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public byte[] getPDocumento() {
        return this.pDocumento;
    }
    
    public void setPDocumento(byte[] pDocumento) {
        this.pDocumento = pDocumento;
    }
    @JsonIgnore
    public String getPNombreDoc() {
        return this.pNombreDoc;
    }
    
    public void setPNombreDoc(String pNombreDoc) {
        this.pNombreDoc = pNombreDoc;
    }
    @JsonIgnore
    public String getPPathParcial() {
        return this.pPathParcial;
    }
    
    public void setPPathParcial(String pPathParcial) {
        this.pPathParcial = pPathParcial;
    }
}
