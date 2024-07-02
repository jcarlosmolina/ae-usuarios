package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.DocumentoGConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DocumentoGOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Identificador **/
    @JsonProperty(value = "identificador")
    private Long documentoGIdentificador;

    /** Default constructor. **/
    public DocumentoGOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param documentoGIdentificador value of the <code>documentoGIdentificador</code> attribute.
     */
    public DocumentoGOid(Long documentoGIdentificador) {
        this.documentoGIdentificador = documentoGIdentificador;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public DocumentoGOid(List<Object> col) {
        this.documentoGIdentificador = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (documentoGIdentificador == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of Identificador attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getDocumentoGIdentificador() {
        return documentoGIdentificador;
    }

    /**
     * Sets the value of Identificador attribute.
     * 
     * @param documentoGIdentificador the new value.
     */
    public void setDocumentoGIdentificador(Long documentoGIdentificador) {
        this.documentoGIdentificador = documentoGIdentificador;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return documentoGIdentificador.hashCode();
        } catch (NullPointerException e) {
            return super.hashCode();
        }
    }

    /**
     * Says if the this object is the same object as <code>obj</code>.
     * 
     * @param obj object to compare this instance with.
     * @return true if the objects are the same object.
     */
    public boolean equals(Object obj) {
        boolean returnValue;
        if (obj == null) {
            returnValue = false;
        } else if (!(obj instanceof DocumentoGOid)) {
            returnValue = false;
        } else {
            DocumentoGOid oid = (DocumentoGOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.documentoGIdentificador, documentoGIdentificador);
            }
        }
        return returnValue;
    }

    /**
     * Returns a String representation of the instance's identifier.
     * 
     * @return String representing the object
     */
    public String toString() {
        return "[documentoGIdentificador=" + documentoGIdentificador + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = documentoGIdentificador;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = DocumentoGConstants.ATTR_NAME_DOCUMENTOGIDENTIFICADOR;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[1];
        dataTypes[0] = Constants.Type.AUTONUMERIC.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return DocumentoGConstants.CLASS_NAME;
    }

    /**
     * Compare the value of the OID in the array of objects with this
     * 
     * @param instance array of objects with the values of the OID to compare this
     *                 instance with.
     * @return true if the objects are the same object.
     */
    public boolean compareToRS(Object[] instance) {
        boolean returnValue = true;
        boolean hasError = false;
        DocumentoGOid candidateOID = null;
        try {
            candidateOID = new DocumentoGOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public DocumentoGOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        DocumentoGOid temp;
        try {
            temp = mapper.readValue(jsonString, DocumentoGOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.documentoGIdentificador = temp.documentoGIdentificador;
        }
        return this;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            json = "";
        }
        return json;
    }
}
