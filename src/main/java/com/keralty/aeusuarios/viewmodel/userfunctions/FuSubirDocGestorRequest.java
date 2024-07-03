package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.DocumentoG;
import com.keralty.aeusuarios.persistence.DocumentoNovedad;
import com.keralty.aeusuarios.persistence.oid.DocumentoGOid;
import com.keralty.aeusuarios.persistence.oid.DocumentoNovedadOid;
public class FuSubirDocGestorRequest {

    @JsonProperty("pfu_documento")
    private byte[] pfuDocumento;

    @JsonProperty("pfu_documentog")
    private DocumentoGOid pfuDocumentoG;

    @JsonIgnore
    private DocumentoG pfuDocumentoGInstance;

    @JsonProperty("pfu_documentonov")
    private DocumentoNovedadOid pfuDocumentoNov;

    @JsonIgnore
    private DocumentoNovedad pfuDocumentoNovInstance;

    public FuSubirDocGestorRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public byte[] getPfuDocumento() {
        return this.pfuDocumento;
    }
    
    public void setPfuDocumento(byte[] pfuDocumento) {
        this.pfuDocumento = pfuDocumento;
    }
    @JsonIgnore
    public DocumentoGOid getPfuDocumentoG() {
        return this.pfuDocumentoG;
    }
    
    public void setPfuDocumentoG(DocumentoGOid pfuDocumentoG) {
        this.pfuDocumentoG = pfuDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getPfuDocumentoGInstance() {
        if (this.pfuDocumentoGInstance == null)
            this.pfuDocumentoGInstance = new DocumentoG();
        return this.pfuDocumentoGInstance;
    }
    
    public void setPfuDocumentoGInstance(DocumentoG pfuDocumentoG) {
        this.pfuDocumentoGInstance = pfuDocumentoG;
    }
    @JsonIgnore
    public DocumentoNovedadOid getPfuDocumentoNov() {
        return this.pfuDocumentoNov;
    }
    
    public void setPfuDocumentoNov(DocumentoNovedadOid pfuDocumentoNov) {
        this.pfuDocumentoNov = pfuDocumentoNov;
    }

    @JsonIgnore
    public DocumentoNovedad getPfuDocumentoNovInstance() {
        if (this.pfuDocumentoNovInstance == null)
            this.pfuDocumentoNovInstance = new DocumentoNovedad();
        return this.pfuDocumentoNovInstance;
    }
    
    public void setPfuDocumentoNovInstance(DocumentoNovedad pfuDocumentoNov) {
        this.pfuDocumentoNovInstance = pfuDocumentoNov;
    }
}
