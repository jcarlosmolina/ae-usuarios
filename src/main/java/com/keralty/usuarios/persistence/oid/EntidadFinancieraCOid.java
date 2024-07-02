package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.EntidadFinancieraCConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntidadFinancieraCOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Codigo **/
    @JsonProperty(value = "codigo")
    private Long entidadFinancieraCCodigo;

    /** Default constructor. **/
    public EntidadFinancieraCOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param entidadFinancieraCCodigo value of the <code>entidadFinancieraCCodigo</code> attribute.
     */
    public EntidadFinancieraCOid(Long entidadFinancieraCCodigo) {
        this.entidadFinancieraCCodigo = entidadFinancieraCCodigo;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public EntidadFinancieraCOid(List<Object> col) {
        this.entidadFinancieraCCodigo = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (entidadFinancieraCCodigo == null)
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
    public Long getEntidadFinancieraCCodigo() {
        return entidadFinancieraCCodigo;
    }

    /**
     * Sets the value of Codigo attribute.
     * 
     * @param entidadFinancieraCCodigo the new value.
     */
    public void setEntidadFinancieraCCodigo(Long entidadFinancieraCCodigo) {
        this.entidadFinancieraCCodigo = entidadFinancieraCCodigo;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return entidadFinancieraCCodigo.hashCode();
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
        } else if (!(obj instanceof EntidadFinancieraCOid)) {
            returnValue = false;
        } else {
            EntidadFinancieraCOid oid = (EntidadFinancieraCOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.entidadFinancieraCCodigo, entidadFinancieraCCodigo);
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
        return "[entidadFinancieraCCodigo=" + entidadFinancieraCCodigo + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = entidadFinancieraCCodigo;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = EntidadFinancieraCConstants.ATTR_NAME_ENTIDADFINANCIERACCODIGO;
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
        return EntidadFinancieraCConstants.CLASS_NAME;
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
        EntidadFinancieraCOid candidateOID = null;
        try {
            candidateOID = new EntidadFinancieraCOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public EntidadFinancieraCOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        EntidadFinancieraCOid temp;
        try {
            temp = mapper.readValue(jsonString, EntidadFinancieraCOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.entidadFinancieraCCodigo = temp.entidadFinancieraCCodigo;
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
