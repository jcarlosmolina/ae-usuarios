package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.TipoIdentificacionConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TipoIdentificacionOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Codigo **/
    @JsonProperty(value = "codigo")
    private Long tipoIdentificacionCodigo;

    /** Default constructor. **/
    public TipoIdentificacionOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param tipoIdentificacionCodigo value of the <code>tipoIdentificacionCodigo</code> attribute.
     */
    public TipoIdentificacionOid(Long tipoIdentificacionCodigo) {
        this.tipoIdentificacionCodigo = tipoIdentificacionCodigo;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public TipoIdentificacionOid(List<Object> col) {
        this.tipoIdentificacionCodigo = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (tipoIdentificacionCodigo == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of Codigo attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getTipoIdentificacionCodigo() {
        return tipoIdentificacionCodigo;
    }

    /**
     * Sets the value of Codigo attribute.
     * 
     * @param tipoIdentificacionCodigo the new value.
     */
    public void setTipoIdentificacionCodigo(Long tipoIdentificacionCodigo) {
        this.tipoIdentificacionCodigo = tipoIdentificacionCodigo;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return tipoIdentificacionCodigo.hashCode();
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
        } else if (!(obj instanceof TipoIdentificacionOid)) {
            returnValue = false;
        } else {
            TipoIdentificacionOid oid = (TipoIdentificacionOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.tipoIdentificacionCodigo, tipoIdentificacionCodigo);
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
        return "[tipoIdentificacionCodigo=" + tipoIdentificacionCodigo + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = tipoIdentificacionCodigo;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONCODIGO;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[1];
        dataTypes[0] = Constants.Type.INT.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return TipoIdentificacionConstants.CLASS_NAME;
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
        TipoIdentificacionOid candidateOID = null;
        try {
            candidateOID = new TipoIdentificacionOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public TipoIdentificacionOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        TipoIdentificacionOid temp;
        try {
            temp = mapper.readValue(jsonString, TipoIdentificacionOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.tipoIdentificacionCodigo = temp.tipoIdentificacionCodigo;
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
