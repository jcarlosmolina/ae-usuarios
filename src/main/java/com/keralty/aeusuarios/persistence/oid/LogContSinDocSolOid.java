package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;
import com.keralty.aeusuarios.global.LogContSinDocSolConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LogContSinDocSolOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_LogContSinDocSol **/
    @JsonProperty(value = "id_logcontsindocsol")
    private Long logContSinDocSolidLogContSinDocSol;

    /** Default constructor. **/
    public LogContSinDocSolOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param logContSinDocSolidLogContSinDocSol value of the <code>logContSinDocSolidLogContSinDocSol</code> attribute.
     */
    public LogContSinDocSolOid(Long logContSinDocSolidLogContSinDocSol) {
        this.logContSinDocSolidLogContSinDocSol = logContSinDocSolidLogContSinDocSol;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public LogContSinDocSolOid(List<Object> col) {
        this.logContSinDocSolidLogContSinDocSol = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (logContSinDocSolidLogContSinDocSol == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_LogContSinDocSol attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getLogContSinDocSolidLogContSinDocSol() {
        return logContSinDocSolidLogContSinDocSol;
    }

    /**
     * Sets the value of id_LogContSinDocSol attribute.
     * 
     * @param logContSinDocSolidLogContSinDocSol the new value.
     */
    public void setLogContSinDocSolidLogContSinDocSol(Long logContSinDocSolidLogContSinDocSol) {
        this.logContSinDocSolidLogContSinDocSol = logContSinDocSolidLogContSinDocSol;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return logContSinDocSolidLogContSinDocSol.hashCode();
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
        } else if (!(obj instanceof LogContSinDocSolOid)) {
            returnValue = false;
        } else {
            LogContSinDocSolOid oid = (LogContSinDocSolOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.logContSinDocSolidLogContSinDocSol, logContSinDocSolidLogContSinDocSol);
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
        return "[logContSinDocSolidLogContSinDocSol=" + logContSinDocSolidLogContSinDocSol + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = logContSinDocSolidLogContSinDocSol;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = LogContSinDocSolConstants.ATTR_NAME_LOGCONTSINDOCSOLIDLOGCONTSINDOCSOL;
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
        return LogContSinDocSolConstants.CLASS_NAME;
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
        LogContSinDocSolOid candidateOID = null;
        try {
            candidateOID = new LogContSinDocSolOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public LogContSinDocSolOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        LogContSinDocSolOid temp;
        try {
            temp = mapper.readValue(jsonString, LogContSinDocSolOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.logContSinDocSolidLogContSinDocSol = temp.logContSinDocSolidLogContSinDocSol;
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
