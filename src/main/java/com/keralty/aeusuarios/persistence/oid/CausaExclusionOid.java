package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;
import com.keralty.aeusuarios.global.CausaExclusionConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CausaExclusionOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_CausaExclusion **/
    @JsonProperty(value = "id_causaexclusion")
    private Long causaExclusionidCausaExclusion;

    /** Default constructor. **/
    public CausaExclusionOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param causaExclusionidCausaExclusion value of the <code>causaExclusionidCausaExclusion</code> attribute.
     */
    public CausaExclusionOid(Long causaExclusionidCausaExclusion) {
        this.causaExclusionidCausaExclusion = causaExclusionidCausaExclusion;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public CausaExclusionOid(List<Object> col) {
        this.causaExclusionidCausaExclusion = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (causaExclusionidCausaExclusion == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_CausaExclusion attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getCausaExclusionidCausaExclusion() {
        return causaExclusionidCausaExclusion;
    }

    /**
     * Sets the value of id_CausaExclusion attribute.
     * 
     * @param causaExclusionidCausaExclusion the new value.
     */
    public void setCausaExclusionidCausaExclusion(Long causaExclusionidCausaExclusion) {
        this.causaExclusionidCausaExclusion = causaExclusionidCausaExclusion;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return causaExclusionidCausaExclusion.hashCode();
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
        } else if (!(obj instanceof CausaExclusionOid)) {
            returnValue = false;
        } else {
            CausaExclusionOid oid = (CausaExclusionOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.causaExclusionidCausaExclusion, causaExclusionidCausaExclusion);
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
        return "[causaExclusionidCausaExclusion=" + causaExclusionidCausaExclusion + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = causaExclusionidCausaExclusion;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = CausaExclusionConstants.ATTR_NAME_CAUSAEXCLUSIONIDCAUSAEXCLUSION;
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
        return CausaExclusionConstants.CLASS_NAME;
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
        CausaExclusionOid candidateOID = null;
        try {
            candidateOID = new CausaExclusionOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public CausaExclusionOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        CausaExclusionOid temp;
        try {
            temp = mapper.readValue(jsonString, CausaExclusionOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.causaExclusionidCausaExclusion = temp.causaExclusionidCausaExclusion;
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
