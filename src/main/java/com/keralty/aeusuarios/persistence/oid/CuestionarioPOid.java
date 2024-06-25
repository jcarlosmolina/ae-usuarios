package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;
import com.keralty.aeusuarios.global.CuestionarioPConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CuestionarioPOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Numero **/
    @JsonProperty(value = "numero")
    private Long cuestionarioPNumero;

    /** Default constructor. **/
    public CuestionarioPOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param cuestionarioPNumero value of the <code>cuestionarioPNumero</code> attribute.
     */
    public CuestionarioPOid(Long cuestionarioPNumero) {
        this.cuestionarioPNumero = cuestionarioPNumero;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public CuestionarioPOid(List<Object> col) {
        this.cuestionarioPNumero = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (cuestionarioPNumero == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of Numero attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getCuestionarioPNumero() {
        return cuestionarioPNumero;
    }

    /**
     * Sets the value of Numero attribute.
     * 
     * @param cuestionarioPNumero the new value.
     */
    public void setCuestionarioPNumero(Long cuestionarioPNumero) {
        this.cuestionarioPNumero = cuestionarioPNumero;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return cuestionarioPNumero.hashCode();
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
        } else if (!(obj instanceof CuestionarioPOid)) {
            returnValue = false;
        } else {
            CuestionarioPOid oid = (CuestionarioPOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.cuestionarioPNumero, cuestionarioPNumero);
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
        return "[cuestionarioPNumero=" + cuestionarioPNumero + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = cuestionarioPNumero;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = CuestionarioPConstants.ATTR_NAME_CUESTIONARIOPNUMERO;
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
        return CuestionarioPConstants.CLASS_NAME;
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
        CuestionarioPOid candidateOID = null;
        try {
            candidateOID = new CuestionarioPOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public CuestionarioPOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        CuestionarioPOid temp;
        try {
            temp = mapper.readValue(jsonString, CuestionarioPOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.cuestionarioPNumero = temp.cuestionarioPNumero;
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
