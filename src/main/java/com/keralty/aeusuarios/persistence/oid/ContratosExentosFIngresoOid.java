package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;
import com.keralty.aeusuarios.global.ContratosExentosFIngresoConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContratosExentosFIngresoOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_ContratosExentosFIngreso **/
    @JsonProperty(value = "id_contratosexentosfingreso")
    private Long contratosExentosFIngresoidContratosExentosFIngreso;

    /** Default constructor. **/
    public ContratosExentosFIngresoOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param contratosExentosFIngresoidContratosExentosFIngreso value of the <code>contratosExentosFIngresoidContratosExentosFIngreso</code> attribute.
     */
    public ContratosExentosFIngresoOid(Long contratosExentosFIngresoidContratosExentosFIngreso) {
        this.contratosExentosFIngresoidContratosExentosFIngreso = contratosExentosFIngresoidContratosExentosFIngreso;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public ContratosExentosFIngresoOid(List<Object> col) {
        this.contratosExentosFIngresoidContratosExentosFIngreso = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (contratosExentosFIngresoidContratosExentosFIngreso == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_ContratosExentosFIngreso attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getContratosExentosFIngresoidContratosExentosFIngreso() {
        return contratosExentosFIngresoidContratosExentosFIngreso;
    }

    /**
     * Sets the value of id_ContratosExentosFIngreso attribute.
     * 
     * @param contratosExentosFIngresoidContratosExentosFIngreso the new value.
     */
    public void setContratosExentosFIngresoidContratosExentosFIngreso(Long contratosExentosFIngresoidContratosExentosFIngreso) {
        this.contratosExentosFIngresoidContratosExentosFIngreso = contratosExentosFIngresoidContratosExentosFIngreso;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return contratosExentosFIngresoidContratosExentosFIngreso.hashCode();
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
        } else if (!(obj instanceof ContratosExentosFIngresoOid)) {
            returnValue = false;
        } else {
            ContratosExentosFIngresoOid oid = (ContratosExentosFIngresoOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.contratosExentosFIngresoidContratosExentosFIngreso, contratosExentosFIngresoidContratosExentosFIngreso);
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
        return "[contratosExentosFIngresoidContratosExentosFIngreso=" + contratosExentosFIngresoidContratosExentosFIngreso + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = contratosExentosFIngresoidContratosExentosFIngreso;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = ContratosExentosFIngresoConstants.ATTR_NAME_CONTRATOSEXENTOSFINGRESOIDCONTRATOSEXENTOSFINGRESO;
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
        return ContratosExentosFIngresoConstants.CLASS_NAME;
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
        ContratosExentosFIngresoOid candidateOID = null;
        try {
            candidateOID = new ContratosExentosFIngresoOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public ContratosExentosFIngresoOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        ContratosExentosFIngresoOid temp;
        try {
            temp = mapper.readValue(jsonString, ContratosExentosFIngresoOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.contratosExentosFIngresoidContratosExentosFIngreso = temp.contratosExentosFIngresoidContratosExentosFIngreso;
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
