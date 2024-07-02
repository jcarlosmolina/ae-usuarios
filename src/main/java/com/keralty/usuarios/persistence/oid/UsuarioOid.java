package com.keralty.usuarios.persistence.oid;

import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.utils.Utilities;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import com.keralty.usuarios.global.UsuarioConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Embeddable
public class UsuarioOid implements IOid {

    private static final long serialVersionUID = 1L;

    /** Identification function field ID_SOLICITUD **/
    @Column(name=UsuarioConstants.FLD_AESOLICITUDESIDSOLICITUD)
    @JsonProperty(value = "id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;
    /** Identification function field Identificador **/
    @Column(name=UsuarioConstants.FLD_USUARIOIDENTIFICADOR)
    @JsonProperty(value = "identificador")
    private Long usuarioIdentificador;

    /** Default constructor. **/
    public UsuarioOid() {
        // Default constructor
    }

    /**
     * Constructor that initializes the attributes values.
     * 
     * @param aESOLICITUDESIDSOLICITUD value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute.
     * @param usuarioIdentificador value of the <code>usuarioIdentificador</code> attribute.
     */
    public UsuarioOid(Long aESOLICITUDESIDSOLICITUD, Long usuarioIdentificador) {
        this.aESOLICITUDESIDSOLICITUD = aESOLICITUDESIDSOLICITUD;
        this.usuarioIdentificador = usuarioIdentificador;
    }

    /**
     * Constructor that initializes the attributes values in the List.
     * 
     * @param col is an ArrayList with the attribute values.
     */
    public UsuarioOid(List<Object> col) {
        this.aESOLICITUDESIDSOLICITUD = (Long) col.get(0);
        this.usuarioIdentificador = (Long) col.get(1);
    }

    /**
     * Constructor that initializes the attributes values from the identifiers of the related instances.
     * @param solicitudOID the OID of <code>Solicitud</code>
     * @param Identificador value of the <code>Identificador</code> attribute
     */
    public UsuarioOid(SolicitudOid solicitudOID, java.lang.Long Identificador) {
        this.aESOLICITUDESIDSOLICITUD = solicitudOID.getAESOLICITUDESIDSOLICITUD();
        this.usuarioIdentificador = Identificador;
    }

    /**
     * Tells whether this OID is null or not.
     * 
     * @return true if this OID is null. False otherwise.
     */
    public boolean isNull() {
        boolean nullValue;
        if (aESOLICITUDESIDSOLICITUD == null || usuarioIdentificador == null)
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
     * Gets the value of Identificador attribute.
     * 
     * @return the value.
     */
    @JsonIgnore
    public Long getUsuarioIdentificador() {
        return usuarioIdentificador;
    }

    /**
     * Sets the value of Identificador attribute.
     * 
     * @param usuarioIdentificador the new value.
     */
    public void setUsuarioIdentificador(Long usuarioIdentificador) {
        this.usuarioIdentificador = usuarioIdentificador;
    }

    /**
     * Provides a unique hashcode for the instance.
     * 
     * @return hashcode representing this instance.
     */
    public int hashCode() {
        try {
            return aESOLICITUDESIDSOLICITUD.hashCode() + usuarioIdentificador.hashCode();
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
        } else if (!(obj instanceof UsuarioOid)) {
            returnValue = false;
        } else {
            UsuarioOid oid = (UsuarioOid) obj;
            if (oid == this) {
                returnValue = true;
            } else {
                returnValue = Utilities.isEqual(oid.aESOLICITUDESIDSOLICITUD, aESOLICITUDESIDSOLICITUD) && Utilities.isEqual(oid.usuarioIdentificador, usuarioIdentificador);
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
        return "[aESOLICITUDESIDSOLICITUD=" + aESOLICITUDESIDSOLICITUD + ", usuarioIdentificador=" + usuarioIdentificador + "]";
    }



    /**
     * Returns the values of the fields composing the OID in an array.
     * 
     * @return an array with the values of the OID fields.
     */
    public Object[] getValue() {
        Object[] values = new Object[2];
        values[0] = aESOLICITUDESIDSOLICITUD;
        values[1] = usuarioIdentificador;
        return values;
    }

    /**
     * Returns the name of the fields composing the OID in an array.
     * 
     * @return an array with the names of the OID fields.
     */
    public String[] getKeys() {
        String[] values = new String[2];
        values[0] = UsuarioConstants.ATTR_NAME_SOLICITUD_AE_SOLICITUDES_AESOLICITUDESIDSOLICITUD;
        values[1] = UsuarioConstants.ATTR_NAME_USUARIOIDENTIFICADOR;
        return values;
    }

    /**
     * Returns the types of the fields composing the OID in an array.
     * 
     * @return an array with the types of the OID fields.
     */
    public String[] getDataTypes() {
        String[] dataTypes = new String[2];
        dataTypes[0] = Constants.Type.AUTONUMERIC.getTypeName();
        dataTypes[1] = Constants.Type.AUTONUMERIC.getTypeName();
        return dataTypes;
    }

    /**
     * Returns the definition class of this OID.
     * 
     * @return Name of the definition class of this OID.
     */
    public String getDefinitionClass() {
        return UsuarioConstants.CLASS_NAME;
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
        UsuarioOid candidateOID = null;
        try {
            candidateOID = new UsuarioOid((Long) instance[0], (Long) instance[1]);
        } catch (Exception e) {
            hasError = true;
        }
        if (!hasError && candidateOID != null && !(candidateOID.isNull())) {
            returnValue = this.equals(candidateOID);
        }
        return returnValue;
    }

    public UsuarioOid fromJsonString(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        UsuarioOid temp;
        try {
            temp = mapper.readValue(jsonString, UsuarioOid.class);
        } catch (Exception e) {
            temp = null;
        }
        if (temp != null) {
            this.aESOLICITUDESIDSOLICITUD = temp.aESOLICITUDESIDSOLICITUD;
            this.usuarioIdentificador = temp.usuarioIdentificador;
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
