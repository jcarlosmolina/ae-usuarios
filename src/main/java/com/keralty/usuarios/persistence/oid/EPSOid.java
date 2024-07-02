package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.EPSConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EPSOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Codigo **/
    @JsonProperty(value = "codigo")
    private Long ePSCodigo;

    /** Default constructor. **/
    public EPSOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param ePSCodigo value of the <code>ePSCodigo</code> attribute.
     */
    public EPSOid(Long ePSCodigo) {
        this.ePSCodigo = ePSCodigo;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public EPSOid(List<Object> col) {
        this.ePSCodigo = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (ePSCodigo == null)
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
    public Long getEPSCodigo() {
        return ePSCodigo;
    }

    /**
     * Sets the value of Codigo attribute.
     * 
     * @param ePSCodigo the new value.
     */
    public void setEPSCodigo(Long ePSCodigo) {
        this.ePSCodigo = ePSCodigo;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return ePSCodigo.hashCode();
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
        } else if (!(obj instanceof EPSOid)) {
            returnValue = false;
        } else {
            EPSOid oid = (EPSOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.ePSCodigo, ePSCodigo);
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
        return "[ePSCodigo=" + ePSCodigo + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = ePSCodigo;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = EPSConstants.ATTR_NAME_EPSCODIGO;
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
        return EPSConstants.CLASS_NAME;
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
        EPSOid candidateOID = null;
        try {
            candidateOID = new EPSOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public EPSOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        EPSOid temp;
        try {
            temp = mapper.readValue(jsonString, EPSOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.ePSCodigo = temp.ePSCodigo;
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
