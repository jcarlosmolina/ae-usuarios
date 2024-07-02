package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.XClassConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.keralty.usuarios.global.STDFunctions;

public class XClassOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field xcodigo **/
    @JsonProperty(value = "xcodigo")
    private String xClassxcodigo;

    /** Default constructor. **/
    public XClassOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param xClassxcodigo value of the <code>xClassxcodigo</code> attribute.
     */
    public XClassOid(String xClassxcodigo) {
        this.xClassxcodigo = xClassxcodigo;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public XClassOid(List<Object> col) {
        this.xClassxcodigo = (String) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (xClassxcodigo == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of xcodigo attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public String getXClassxcodigo() {
        return xClassxcodigo;
    }

    /**
     * Sets the value of xcodigo attribute.
     * 
     * @param xClassxcodigo the new value.
     */
    public void setXClassxcodigo(String xClassxcodigo) {
        this.xClassxcodigo = xClassxcodigo;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return xClassxcodigo.hashCode();
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
        } else if (!(obj instanceof XClassOid)) {
            returnValue = false;
        } else {
            XClassOid oid = (XClassOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.xClassxcodigo, xClassxcodigo);
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
        return "[xClassxcodigo=" + xClassxcodigo + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = xClassxcodigo;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = XClassConstants.ATTR_NAME_XCLASSXCODIGO;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[1];
        dataTypes[0] = Constants.Type.STRING.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return XClassConstants.CLASS_NAME;
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
        XClassOid candidateOID = null;
        try {
            candidateOID = new XClassOid(STDFunctions.rightTrimFun((String) instance[0]));
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public XClassOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        XClassOid temp;
        try {
            temp = mapper.readValue(jsonString, XClassOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.xClassxcodigo = temp.xClassxcodigo;
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
