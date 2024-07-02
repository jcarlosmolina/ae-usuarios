package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.GrupoAsignacionNovedadConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GrupoAsignacionNovedadOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field Id **/
    @JsonProperty(value = "id")
    private Long grupoAsignacionNovedadId;

    /** Default constructor. **/
    public GrupoAsignacionNovedadOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param grupoAsignacionNovedadId value of the <code>grupoAsignacionNovedadId</code> attribute.
     */
    public GrupoAsignacionNovedadOid(Long grupoAsignacionNovedadId) {
        this.grupoAsignacionNovedadId = grupoAsignacionNovedadId;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public GrupoAsignacionNovedadOid(List<Object> col) {
        this.grupoAsignacionNovedadId = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (grupoAsignacionNovedadId == null)
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
    public Long getGrupoAsignacionNovedadId() {
        return grupoAsignacionNovedadId;
    }

    /**
     * Sets the value of Id attribute.
     * 
     * @param grupoAsignacionNovedadId the new value.
     */
    public void setGrupoAsignacionNovedadId(Long grupoAsignacionNovedadId) {
        this.grupoAsignacionNovedadId = grupoAsignacionNovedadId;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return grupoAsignacionNovedadId.hashCode();
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
        } else if (!(obj instanceof GrupoAsignacionNovedadOid)) {
            returnValue = false;
        } else {
            GrupoAsignacionNovedadOid oid = (GrupoAsignacionNovedadOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.grupoAsignacionNovedadId, grupoAsignacionNovedadId);
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
        return "[grupoAsignacionNovedadId=" + grupoAsignacionNovedadId + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = grupoAsignacionNovedadId;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = GrupoAsignacionNovedadConstants.ATTR_NAME_GRUPOASIGNACIONNOVEDADID;
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
        return GrupoAsignacionNovedadConstants.CLASS_NAME;
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
        GrupoAsignacionNovedadOid candidateOID = null;
        try {
            candidateOID = new GrupoAsignacionNovedadOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public GrupoAsignacionNovedadOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        GrupoAsignacionNovedadOid temp;
        try {
            temp = mapper.readValue(jsonString, GrupoAsignacionNovedadOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.grupoAsignacionNovedadId = temp.grupoAsignacionNovedadId;
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