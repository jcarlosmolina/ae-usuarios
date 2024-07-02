package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.MotDevAreaMedicaConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MotDevAreaMedicaOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Id **/
    @JsonProperty(value = "id")
    private Long motDevAreaMedicaId;

    /** Default constructor. **/
    public MotDevAreaMedicaOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param motDevAreaMedicaId value of the <code>motDevAreaMedicaId</code> attribute.
     */
    public MotDevAreaMedicaOid(Long motDevAreaMedicaId) {
        this.motDevAreaMedicaId = motDevAreaMedicaId;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public MotDevAreaMedicaOid(List<Object> col) {
        this.motDevAreaMedicaId = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (motDevAreaMedicaId == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of Id attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getMotDevAreaMedicaId() {
        return motDevAreaMedicaId;
    }

    /**
     * Sets the value of Id attribute.
     * 
     * @param motDevAreaMedicaId the new value.
     */
    public void setMotDevAreaMedicaId(Long motDevAreaMedicaId) {
        this.motDevAreaMedicaId = motDevAreaMedicaId;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return motDevAreaMedicaId.hashCode();
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
        } else if (!(obj instanceof MotDevAreaMedicaOid)) {
            returnValue = false;
        } else {
            MotDevAreaMedicaOid oid = (MotDevAreaMedicaOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.motDevAreaMedicaId, motDevAreaMedicaId);
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
        return "[motDevAreaMedicaId=" + motDevAreaMedicaId + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = motDevAreaMedicaId;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = MotDevAreaMedicaConstants.ATTR_NAME_MOTDEVAREAMEDICAID;
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
        return MotDevAreaMedicaConstants.CLASS_NAME;
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
        MotDevAreaMedicaOid candidateOID = null;
        try {
            candidateOID = new MotDevAreaMedicaOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public MotDevAreaMedicaOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        MotDevAreaMedicaOid temp;
        try {
            temp = mapper.readValue(jsonString, MotDevAreaMedicaOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.motDevAreaMedicaId = temp.motDevAreaMedicaId;
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
