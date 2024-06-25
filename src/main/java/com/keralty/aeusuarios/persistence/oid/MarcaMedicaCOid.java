package com.keralty.aeusuarios.persistence.oid;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.utils.Utilities;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import com.keralty.aeusuarios.global.MarcaMedicaCConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.keralty.aeusuarios.global.STDFunctions;

@Embeddable
public class MarcaMedicaCOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field ID **/
    @Column(name=MarcaMedicaCConstants.FLD_PERSONACID)
    @JsonProperty(value = "id")
    private Long personaCID;
    /** Identification function field Producto **/
    @Column(name=MarcaMedicaCConstants.FLD_PRODUCTOSPRODUCTO)
    @JsonProperty(value = "producto")
    private Long productosProducto;
    /** Identification function field Codigo **/
    @Column(name=MarcaMedicaCConstants.FLD_MARCAMEDICACCODIGO)
    @JsonProperty(value = "codigo")
    private String marcaMedicaCCodigo;

    /** Default constructor. **/
    public MarcaMedicaCOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param personaCID value of the <code>personaCID</code> attribute.
     * @param productosProducto value of the <code>productosProducto</code> attribute.
     * @param marcaMedicaCCodigo value of the <code>marcaMedicaCCodigo</code> attribute.
     */
    public MarcaMedicaCOid(Long personaCID, Long productosProducto, String marcaMedicaCCodigo) {
        this.personaCID = personaCID;
        this.productosProducto = productosProducto;
        this.marcaMedicaCCodigo = marcaMedicaCCodigo;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public MarcaMedicaCOid(List<Object> col) {
        this.personaCID = (Long) col.get(0);
        this.productosProducto = (Long) col.get(1);
        this.marcaMedicaCCodigo = (String) col.get(2);
    }

    /**
     * Constructor that initializes the attributes values from the identifiers of the related instances.
     * @param personacOID the OID of <code>PersonaC</code>
     * @param productocOID the OID of <code>Productos</code>
     * @param Codigo value of the <code>Codigo</code> attribute
     */
    public MarcaMedicaCOid(PersonaCOid personacOID, ProductosOid productocOID, String Codigo) {
        this.personaCID = personacOID.getPersonaCID();
        this.productosProducto = productocOID.getProductosProducto();
        this.marcaMedicaCCodigo = Codigo;
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (personaCID == null || productosProducto == null || marcaMedicaCCodigo == null)
            nullValue = true;
        else
            nullValue = false;
        return nullValue;
    }

    /**
     * Gets the value of ID attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getPersonaCID() {
        return personaCID;
    }

    /**
     * Sets the value of ID attribute.
     * 
     * @param personaCID the new value.
     */
    public void setPersonaCID(Long personaCID) {
        this.personaCID = personaCID;
    }
    /**
     * Gets the value of Producto attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getProductosProducto() {
        return productosProducto;
    }

    /**
     * Sets the value of Producto attribute.
     * 
     * @param productosProducto the new value.
     */
    public void setProductosProducto(Long productosProducto) {
        this.productosProducto = productosProducto;
    }
    /**
     * Gets the value of Codigo attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public String getMarcaMedicaCCodigo() {
        return marcaMedicaCCodigo;
    }

    /**
     * Sets the value of Codigo attribute.
     * 
     * @param marcaMedicaCCodigo the new value.
     */
    public void setMarcaMedicaCCodigo(String marcaMedicaCCodigo) {
        this.marcaMedicaCCodigo = marcaMedicaCCodigo;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return personaCID.hashCode() + productosProducto.hashCode() + marcaMedicaCCodigo.hashCode();
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
        } else if (!(obj instanceof MarcaMedicaCOid)) {
            returnValue = false;
        } else {
            MarcaMedicaCOid oid = (MarcaMedicaCOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.personaCID, personaCID) && Utilities.isEqual(oid.productosProducto, productosProducto) && Utilities.isEqual(oid.marcaMedicaCCodigo, marcaMedicaCCodigo);
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
        return "[personaCID=" + personaCID + ", productosProducto=" + productosProducto + ", marcaMedicaCCodigo=" + marcaMedicaCCodigo + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[3];
        values[0] = personaCID;
        values[1] = productosProducto;
        values[2] = marcaMedicaCCodigo;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[3];
        values[0] = MarcaMedicaCConstants.ATTR_NAME_PERSONAC_PERSONACID;
        values[1] = MarcaMedicaCConstants.ATTR_NAME_PRODUCTOC_PRODUCTOSPRODUCTO;
        values[2] = MarcaMedicaCConstants.ATTR_NAME_MARCAMEDICACCODIGO;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[3];
        dataTypes[0] = Constants.Type.AUTONUMERIC.getTypeName();
        dataTypes[1] = Constants.Type.INT.getTypeName();
        dataTypes[2] = Constants.Type.STRING.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return MarcaMedicaCConstants.CLASS_NAME;
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
        MarcaMedicaCOid candidateOID = null;
        try {
            candidateOID = new MarcaMedicaCOid((Long) instance[0], (Long) instance[1], STDFunctions.rightTrimFun((String) instance[2]));
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public MarcaMedicaCOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        MarcaMedicaCOid temp;
        try {
            temp = mapper.readValue(jsonString, MarcaMedicaCOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.personaCID = temp.personaCID;
            this.productosProducto = temp.productosProducto;
            this.marcaMedicaCCodigo = temp.marcaMedicaCCodigo;
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
