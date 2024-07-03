package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.EstadoContratoConstants;
import com.keralty.aeusuarios.persistence.oid.EstadoContratoOid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>EstadoContrato</code> model class.
 * <p>
 * Model Class: <code>EstadoContrato</code><br>
 */
@Entity(name = EstadoContratoConstants.CLASS_NAME)
@Table(name = EstadoContratoConstants.TBL_NAME)
public class EstadoContrato extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @Column(name = EstadoContratoConstants.FLD_ESTADOCONTRATOCODIGO )
    @JsonProperty(value="codigo")
    private Long estadoContratoCodigo;

    /** Class member attribute. */
    @Column(name = EstadoContratoConstants.FLD_ESTADOCONTRATODESCRIPCION )
    @JsonProperty(value="descripcion")
    private String estadoContratoDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoContratoDescripcion;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoContratoConstants.ROLE_INVNAME_AESOLICITUDES)
    @JsonIgnore
    private Collection <AESOLICITUDES> aESOLICITUDES;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDES;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoContratoConstants.ROLE_INVNAME_CONTRATOSC)
    @JsonIgnore
    private Collection <ContratoC> contratosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoContratoConstants.ROLE_INVNAME_SOLICITUDESNOVEDAD)
    @JsonIgnore
    private Collection <SolicitudNovedad> solicitudesNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudesNovedad;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public EstadoContrato() {
        estadoContratoCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>EstadoContrato</code>.
     * @param oid Object Identifier of the instance of <code>EstadoContrato</code> to be created.
     * @throws SystemException
     */
    public EstadoContrato(EstadoContratoOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            estadoContratoCodigo = oid.getEstadoContratoCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>estadoContratoCodigo</code> attribute<br>in class <code>EstadoContrato</code>.
     * This is part of the identification for this class, which depends on the identification of <code>EstadoContrato</code>
     * @return The value of the <code>estadoContratoCodigo</code> attribute<br>in class <code>EstadoContrato</code>.
     */
    public Long getEstadoContratoCodigo() {
        return estadoContratoCodigo;
    }

    /**
     * Sets the value of the <code>estadoContratoCodigo</code> attribute<br>in class <code>EstadoContrato</code>.
     * This is part of the identification for this class, which depends on the identification of <code>EstadoContrato</code>
     * @param estadoContratoCodigo The new value of the <code>estadoContratoCodigo</code> attribute<br>in class <code>EstadoContrato</code>.
     */
    public void setEstadoContratoCodigo(Long estadoContratoCodigo) {
        this.estadoContratoCodigo = estadoContratoCodigo;
    }

   /**
    * Returns the value of the <code>estadoContratoDescripcion</code> attribute.<br>
    * Model Attribute: <code>estadoContratoDescripcion</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>estadoContratoDescripcion</code> attribute.
    */

    public String getEstadoContratoDescripcion()  {
    	String value;
        value =  estadoContratoDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>estadoContratoDescripcion</code> attribute.<br>
    * Model Attribute: <code>estadoContratoDescripcion</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param estadoContratoDescripcion The new value of the <code>estadoContratoDescripcion</code> attribute.
    */
    public void setEstadoContratoDescripcion (String estadoContratoDescripcion) {
        modifiedEstadoContratoDescripcion = true;
        this.estadoContratoDescripcion = estadoContratoDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedEstadoContratoDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedEstadoContratoDescripcion</code>.
    */
    public void setModifiedEstadoContratoDescripcion(boolean modified) {
        this.modifiedEstadoContratoDescripcion = modified;
    }

    /**
     * Returns the instance of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
     * Model Relationship:
     * <code>[AESOLICITUDES] AESOLICITUDES 0:M  ------ 0:1  ESTADOSOLICITUD [EstadoContrato]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
     */
    @JsonIgnore
    public Collection <AESOLICITUDES> getAESOLICITUDES() {
        return aESOLICITUDES;
    }

   /**
    * Adds an instance of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
    * @param aESOLICITUDES The instance to add to the <code>AESOLICITUDES</code> role.
    */
    public void add2AESOLICITUDES(AESOLICITUDES aESOLICITUDES) {
        this.getAESOLICITUDES().add(aESOLICITUDES);
    }
    /**
     * Sets instances of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
     * @param aESOLICITUDES The new value for the <code>AESOLICITUDES</code> role.
     */
    public void setAESOLICITUDES(Collection < AESOLICITUDES > aESOLICITUDES) {
        this.aESOLICITUDES = aESOLICITUDES;
    }

   /**
    * This method gets the attribute value <code>modifiedAESOLICITUDES</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAESOLICITUDES</code> has been modified.
    */
    public boolean isModifiedAESOLICITUDES(){
        return modifiedAESOLICITUDES;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 0:1  EstadoContratoC [EstadoContrato]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     */
    @JsonIgnore
    public Collection <ContratoC> getContratosC() {
        return contratosC;
    }

   /**
    * Adds an instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
    * @param contratosC The instance to add to the <code>ContratosC</code> role.
    */
    public void add2ContratosC(ContratoC contratosC) {
        this.getContratosC().add(contratosC);
    }
    /**
     * Sets instances of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * @param contratosC The new value for the <code>ContratosC</code> role.
     */
    public void setContratosC(Collection < ContratoC > contratosC) {
        this.contratosC = contratosC;
    }

   /**
    * This method gets the attribute value <code>modifiedContratosC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratosC</code> has been modified.
    */
    public boolean isModifiedContratosC(){
        return modifiedContratosC;
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedad</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] SolicitudesNovedad 0:M  ------ 0:1  EstadoContrato [EstadoContrato]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedad</code> role.
     */
    @JsonIgnore
    public Collection <SolicitudNovedad> getSolicitudesNovedad() {
        return solicitudesNovedad;
    }

   /**
    * Adds an instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedad</code> role.
    * @param solicitudesNovedad The instance to add to the <code>SolicitudesNovedad</code> role.
    */
    public void add2SolicitudesNovedad(SolicitudNovedad solicitudesNovedad) {
        this.getSolicitudesNovedad().add(solicitudesNovedad);
    }
    /**
     * Sets instances of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedad</code> role.
     * @param solicitudesNovedad The new value for the <code>SolicitudesNovedad</code> role.
     */
    public void setSolicitudesNovedad(Collection < SolicitudNovedad > solicitudesNovedad) {
        this.solicitudesNovedad = solicitudesNovedad;
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitudesNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitudesNovedad</code> has been modified.
    */
    public boolean isModifiedSolicitudesNovedad(){
        return modifiedSolicitudesNovedad;
    }

    /**
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    @JsonIgnore
    public Map<String, Object> getValues() {
        return values;
    }
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        estadoContratoDescripcion = "";
        aESOLICITUDES = null;
        contratosC = null;
        solicitudesNovedad = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return EstadoContrato.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return EstadoContratoConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
    }

    /**
     * Returns the data type of the <code>attribute</code> defined in <code>role</code>.
     * @param role the owner class of the attribute.
     * @param attribute the attribute name whose data type name is to be returned.
     * @return the data type name of the given attribute or null if the attribute does not exist.
     */
    @Override
    public String getAttributeTypeRelated(String role, String attribute) {
        String returnedType = "";
        return returnedType;
    }


   /**
    * This method sets all flags modifiers with false value.
    */
    public void clearModifiedFlags() {
    	values = new HashMap<>();
    	modifiedEstadoContratoDescripcion = false;
    	values.put("estadoContratoDescripcion", getEstadoContratoDescripcion());
    	modifiedAESOLICITUDES = false;
    	modifiedContratosC = false;
    	modifiedSolicitudesNovedad = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>EstadoContratoOid</code> object that identifies this instance of <code>EstadoContrato</code>.
     * @return <code>EstadoContratoOid </code> object that identifies this instance of <code>EstadoContrato</code>
     */
    public EstadoContratoOid getOid() {
        return new EstadoContratoOid(getEstadoContratoCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(EstadoContratoConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }

    /**
     * Gets the list of active facets.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getActiveFacets() {
        return this.getFacets();
    }

     /**
     * Gets the list of active facets recursively from the root of the inheritance net.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getFacets() {
        List<String> activeFacets = new ArrayList<>();

        if (!activeFacets.contains(Constants.ESTADOCONTRATO)) {
            // Add this class
            activeFacets.add(Constants.ESTADOCONTRATO);
        }
        return activeFacets;
    }

   /**
    * Returns true if this instance can be observed by the connected agent.
    * @param agent Connected agent instance
    * @return TRUE if the connected agent can observe this instance. FALSE otherwise.
    */
    public boolean checkHorizontalVisibility(IEntity agent) {
        boolean returnValue = (!this.isNull());

        if (agent == null) return returnValue;


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * Checks Integrity Constraints defined in the class this entity is an instance of.
     * <p>
     * Raises an exception whenever an Integrity Constraint does not hold.
     * @throws IntegrityConstraintException if an integrity constraint isn't fulfilled.
     * @throws SystemException if there is any error on having checked integrity constraints.
     */
    public void checkIntegrityConstraints() throws IntegrityConstraintException, SystemException {
        /* There are no Integrity Constraints defined in this class */
    }
}
