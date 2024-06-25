package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;
import com.keralty.aeusuarios.global.ContSinDocSolConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContSinDocSolOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_ContSinDocSol **/
    @JsonProperty(value = "id_contsindocsol")
    private Long contSinDocSolidContSinDocSol;

    /** Default constructor. **/
    public ContSinDocSolOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param contSinDocSolidContSinDocSol value of the <code>contSinDocSolidContSinDocSol</code> attribute.
     */
    public ContSinDocSolOid(Long contSinDocSolidContSinDocSol) {
        this.contSinDocSolidContSinDocSol = contSinDocSolidContSinDocSol;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public ContSinDocSolOid(List<Object> col) {
        this.contSinDocSolidContSinDocSol = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (contSinDocSolidContSinDocSol == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_ContSinDocSol attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getContSinDocSolidContSinDocSol() {
        return contSinDocSolidContSinDocSol;
    }

    /**
     * Sets the value of id_ContSinDocSol attribute.
     * 
     * @param contSinDocSolidContSinDocSol the new value.
     */
    public void setContSinDocSolidContSinDocSol(Long contSinDocSolidContSinDocSol) {
        this.contSinDocSolidContSinDocSol = contSinDocSolidContSinDocSol;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return contSinDocSolidContSinDocSol.hashCode();
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
        } else if (!(obj instanceof ContSinDocSolOid)) {
            returnValue = false;
        } else {
            ContSinDocSolOid oid = (ContSinDocSolOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.contSinDocSolidContSinDocSol, contSinDocSolidContSinDocSol);
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
        return "[contSinDocSolidContSinDocSol=" + contSinDocSolidContSinDocSol + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = contSinDocSolidContSinDocSol;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = ContSinDocSolConstants.ATTR_NAME_CONTSINDOCSOLIDCONTSINDOCSOL;
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
        return ContSinDocSolConstants.CLASS_NAME;
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
        ContSinDocSolOid candidateOID = null;
        try {
            candidateOID = new ContSinDocSolOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public ContSinDocSolOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        ContSinDocSolOid temp;
        try {
            temp = mapper.readValue(jsonString, ContSinDocSolOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.contSinDocSolidContSinDocSol = temp.contSinDocSolidContSinDocSol;
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
