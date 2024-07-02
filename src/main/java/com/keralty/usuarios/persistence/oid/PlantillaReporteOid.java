package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;
import com.keralty.usuarios.global.PlantillaReporteConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlantillaReporteOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field id_PlantillaReporte **/
    @JsonProperty(value = "id_plantillareporte")
    private Long plantillaReporteidPlantillaReporte;

    /** Default constructor. **/
    public PlantillaReporteOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param plantillaReporteidPlantillaReporte value of the <code>plantillaReporteidPlantillaReporte</code> attribute.
     */
    public PlantillaReporteOid(Long plantillaReporteidPlantillaReporte) {
        this.plantillaReporteidPlantillaReporte = plantillaReporteidPlantillaReporte;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public PlantillaReporteOid(List<Object> col) {
        this.plantillaReporteidPlantillaReporte = (Long) col.get(0);
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (plantillaReporteidPlantillaReporte == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of id_PlantillaReporte attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getPlantillaReporteidPlantillaReporte() {
        return plantillaReporteidPlantillaReporte;
    }

    /**
     * Sets the value of id_PlantillaReporte attribute.
     * 
     * @param plantillaReporteidPlantillaReporte the new value.
     */
    public void setPlantillaReporteidPlantillaReporte(Long plantillaReporteidPlantillaReporte) {
        this.plantillaReporteidPlantillaReporte = plantillaReporteidPlantillaReporte;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return plantillaReporteidPlantillaReporte.hashCode();
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
        } else if (!(obj instanceof PlantillaReporteOid)) {
            returnValue = false;
        } else {
            PlantillaReporteOid oid = (PlantillaReporteOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.plantillaReporteidPlantillaReporte, plantillaReporteidPlantillaReporte);
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
        return "[plantillaReporteidPlantillaReporte=" + plantillaReporteidPlantillaReporte + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[1];
        values[0] = plantillaReporteidPlantillaReporte;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[1];
        values[0] = PlantillaReporteConstants.ATTR_NAME_PLANTILLAREPORTEIDPLANTILLAREPORTE;
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
        return PlantillaReporteConstants.CLASS_NAME;
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
        PlantillaReporteOid candidateOID = null;
        try {
            candidateOID = new PlantillaReporteOid((Long) instance[0]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public PlantillaReporteOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        PlantillaReporteOid temp;
        try {
            temp = mapper.readValue(jsonString, PlantillaReporteOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.plantillaReporteidPlantillaReporte = temp.plantillaReporteidPlantillaReporte;
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
