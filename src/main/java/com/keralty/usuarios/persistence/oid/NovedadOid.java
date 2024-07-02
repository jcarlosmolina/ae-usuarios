package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.NovedadConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NovedadOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_Novedad **/
    @JsonProperty(value = "id_novedad")
    private Long novedadidNovedad;

    /** Default constructor. **/
    public NovedadOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param novedadidNovedad value of the <code>novedadidNovedad</code> attribute.
     */
    public NovedadOid(Long novedadidNovedad) {
        this.novedadidNovedad = novedadidNovedad;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public NovedadOid(List<Object> col) {
        this.novedadidNovedad = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (novedadidNovedad == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_Novedad attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getNovedadidNovedad() {
        return novedadidNovedad;
    }

    /**
     * Sets the value of id_Novedad attribute.
     * 
     * @param novedadidNovedad the new value.
     */
    public void setNovedadidNovedad(Long novedadidNovedad) {
        this.novedadidNovedad = novedadidNovedad;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return novedadidNovedad.hashCode();
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
        } else if (!(obj instanceof NovedadOid)) {
            returnValue = false;
        } else {
            NovedadOid oid = (NovedadOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.novedadidNovedad, novedadidNovedad);
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
        return "[novedadidNovedad=" + novedadidNovedad + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = novedadidNovedad;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = NovedadConstants.ATTR_NAME_NOVEDADIDNOVEDAD;
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
        return NovedadConstants.CLASS_NAME;
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
        NovedadOid candidateOID = null;
        try {
            candidateOID = new NovedadOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public NovedadOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        NovedadOid temp;
        try {
            temp = mapper.readValue(jsonString, NovedadOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.novedadidNovedad = temp.novedadidNovedad;
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
