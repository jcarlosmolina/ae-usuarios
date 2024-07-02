package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.SolicitudConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SolicitudOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field ID_SOLICITUD **/
    @JsonProperty(value = "id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;

    /** Default constructor. **/
    public SolicitudOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param aESOLICITUDESIDSOLICITUD value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute.
     */
    public SolicitudOid(Long aESOLICITUDESIDSOLICITUD) {
        this.aESOLICITUDESIDSOLICITUD = aESOLICITUDESIDSOLICITUD;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public SolicitudOid(List<Object> col) {
        this.aESOLICITUDESIDSOLICITUD = (Long) col.get(0);
    }

    /**
     * Constructor that initializes the attributes values from the identifiers of the related instances.
     * @param aesolicitudesOID the OID of <code>AESOLICITUDES</code>
     */
    public SolicitudOid(AESOLICITUDESOid aesolicitudesOID) {
        this.aESOLICITUDESIDSOLICITUD = aesolicitudesOID.getAESOLICITUDESIDSOLICITUD();
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (aESOLICITUDESIDSOLICITUD == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of ID_SOLICITUD attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getAESOLICITUDESIDSOLICITUD() {
        return aESOLICITUDESIDSOLICITUD;
    }

    /**
     * Sets the value of ID_SOLICITUD attribute.
     * 
     * @param aESOLICITUDESIDSOLICITUD the new value.
     */
    public void setAESOLICITUDESIDSOLICITUD(Long aESOLICITUDESIDSOLICITUD) {
        this.aESOLICITUDESIDSOLICITUD = aESOLICITUDESIDSOLICITUD;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return aESOLICITUDESIDSOLICITUD.hashCode();
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
        } else if (!(obj instanceof SolicitudOid)) {
            returnValue = false;
        } else {
            SolicitudOid oid = (SolicitudOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.aESOLICITUDESIDSOLICITUD, aESOLICITUDESIDSOLICITUD);
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
        return "[aESOLICITUDESIDSOLICITUD=" + aESOLICITUDESIDSOLICITUD + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = aESOLICITUDESIDSOLICITUD;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = SolicitudConstants.ATTR_NAME_AE_SOLICITUDES_AESOLICITUDESIDSOLICITUD;
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
        return SolicitudConstants.CLASS_NAME;
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
        SolicitudOid candidateOID = null;
        try {
            candidateOID = new SolicitudOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public SolicitudOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        SolicitudOid temp;
        try {
            temp = mapper.readValue(jsonString, SolicitudOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.aESOLICITUDESIDSOLICITUD = temp.aESOLICITUDESIDSOLICITUD;
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
