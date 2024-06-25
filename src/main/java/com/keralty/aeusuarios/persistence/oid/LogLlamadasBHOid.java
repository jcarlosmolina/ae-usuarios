package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;
import com.keralty.aeusuarios.global.LogLlamadasBHConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LogLlamadasBHOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field ID **/
    @JsonProperty(value = "id")
    private Long logLlamadasBHID;

    /** Default constructor. **/
    public LogLlamadasBHOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param logLlamadasBHID value of the <code>logLlamadasBHID</code> attribute.
     */
    public LogLlamadasBHOid(Long logLlamadasBHID) {
        this.logLlamadasBHID = logLlamadasBHID;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public LogLlamadasBHOid(List<Object> col) {
        this.logLlamadasBHID = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (logLlamadasBHID == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of ID attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getLogLlamadasBHID() {
        return logLlamadasBHID;
    }

    /**
     * Sets the value of ID attribute.
     * 
     * @param logLlamadasBHID the new value.
     */
    public void setLogLlamadasBHID(Long logLlamadasBHID) {
        this.logLlamadasBHID = logLlamadasBHID;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return logLlamadasBHID.hashCode();
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
        } else if (!(obj instanceof LogLlamadasBHOid)) {
            returnValue = false;
        } else {
            LogLlamadasBHOid oid = (LogLlamadasBHOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.logLlamadasBHID, logLlamadasBHID);
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
        return "[logLlamadasBHID=" + logLlamadasBHID + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = logLlamadasBHID;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = LogLlamadasBHConstants.ATTR_NAME_LOGLLAMADASBHID;
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
        return LogLlamadasBHConstants.CLASS_NAME;
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
        LogLlamadasBHOid candidateOID = null;
        try {
            candidateOID = new LogLlamadasBHOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public LogLlamadasBHOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        LogLlamadasBHOid temp;
        try {
            temp = mapper.readValue(jsonString, LogLlamadasBHOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.logLlamadasBHID = temp.logLlamadasBHID;
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
