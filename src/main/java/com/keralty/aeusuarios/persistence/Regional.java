package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.repository.RespRegionalJpaRepository;
import com.keralty.aeusuarios.repository.SucursalJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>Regional</code> model class.
 * <p>
 * Model Class: <code>Regional</code><br>
 */
@Entity(name = RegionalConstants.CLASS_NAME)
@Table(name = RegionalConstants.TBL_NAME)
public class Regional extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient RespRegionalJpaRepository respRegionalRepository;

    @JsonIgnore
    private transient SucursalJpaRepository sucursalRepository;

    /** Class identification function. */
    @Id
    @Column(name = RegionalConstants.FLD_REGIONALCODIGO )
    @JsonProperty(value="codigo")
    private Long regionalCodigo;

    /** Class member attribute. */
    @Column(name = RegionalConstants.FLD_REGIONALDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String regionalDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedRegionalDescripcion;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = RegionalConstants.ROLE_INVNAME_RESPREGIONAL)
    @JsonIgnore
    private RespRegional respRegional;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedRespRegional;

    /** Related Class. */
    @OneToMany(mappedBy = RegionalConstants.ROLE_INVNAME_SUCURSALES)
    @JsonIgnore
    private Collection <Sucursal> sucursales;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSucursales;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Regional() {
        regionalCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Regional</code>.
     * @param oid Object Identifier of the instance of <code>Regional</code> to be created.
     * @throws SystemException
     */
    public Regional(RegionalOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            regionalCodigo = oid.getRegionalCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>regionalCodigo</code> attribute<br>in class <code>Regional</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Regional</code>
     * @return The value of the <code>regionalCodigo</code> attribute<br>in class <code>Regional</code>.
     */
    public Long getRegionalCodigo() {
        return regionalCodigo;
    }

    /**
     * Sets the value of the <code>regionalCodigo</code> attribute<br>in class <code>Regional</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Regional</code>
     * @param regionalCodigo The new value of the <code>regionalCodigo</code> attribute<br>in class <code>Regional</code>.
     */
    public void setRegionalCodigo(Long regionalCodigo) {
        this.regionalCodigo = regionalCodigo;
    }

   /**
    * Returns the value of the <code>regionalDescripcion</code> attribute.<br>
    * Model Attribute: <code>regionalDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @return The value of the <code>regionalDescripcion</code> attribute.
    */

    public String getRegionalDescripcion()  {
    	String value;
        value =  regionalDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>regionalDescripcion</code> attribute.<br>
    * Model Attribute: <code>regionalDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @param regionalDescripcion The new value of the <code>regionalDescripcion</code> attribute.
    */
    public void setRegionalDescripcion (String regionalDescripcion) {
        modifiedRegionalDescripcion = true;
        this.regionalDescripcion = regionalDescripcion;
    }

   /**
    * Returns the value of the <code>modifiedRegionalDescripcion</code> class property.<br>
    *
    * @return The value of the <code>modifiedRegionalDescripcion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedRegionalDescripcion() {
        return modifiedRegionalDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedRegionalDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedRegionalDescripcion</code>.
    */
    public void setModifiedRegionalDescripcion(boolean modified) {
        this.modifiedRegionalDescripcion = modified;
    }

    /**
     * Returns the instance of <code>RespRegional</code> related through the <code>RespRegional</code> role.
     * Model Relationship:
     * <code>[RespRegional] RespRegional 0:1  ------ 0:1  Regional [Regional]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>RespRegional</code> related through the <code>RespRegional</code> role.
     */
    @JsonIgnore
    public RespRegional getRespRegional() {
        if (respRegional == null) {
            List<RespRegional> collection = respRegionalRepository.findByRegional(this);
            if (collection.isEmpty()) {
                respRegional = null;
            } else {
                respRegional = (RespRegional)collection.toArray()[0];
            }
        }
        return (respRegional == null ? new RespRegional(null) : respRegional);
    }

   /**
    * Adds an instance of <code>RespRegional</code> related through the <code>RespRegional</code> role.
    * @param respRegional The instance to add to the <code>RespRegional</code> role.
    */
    public void add2RespRegional(RespRegional respRegional) {
        this.respRegional = (respRegional == null  || respRegional.isNull() ? null : respRegional);
    }

   /**
    * This method gets the attribute value <code>modifiedRespRegional</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedRespRegional</code> has been modified.
    */
    public boolean isModifiedRespRegional(){
        return modifiedRespRegional;
    }

    /**
     * Returns the instance of <code>Sucursal</code> related through the <code>Sucursales</code> role.
     * Model Relationship:
     * <code>[Sucursal] Sucursales 0:M  ------ 1:1  Regional [Regional]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Sucursal</code> related through the <code>Sucursales</code> role.
     */
    @JsonIgnore
    public Collection <Sucursal> getSucursales() {
        return sucursales;
    }

   /**
    * Adds an instance of <code>Sucursal</code> related through the <code>Sucursales</code> role.
    * @param sucursales The instance to add to the <code>Sucursales</code> role.
    */
    public void add2Sucursales(Sucursal sucursales) {
        this.getSucursales().add(sucursales);
    }
    /**
     * Sets instances of <code>Sucursal</code> related through the <code>Sucursales</code> role.
     * @param sucursales The new value for the <code>Sucursales</code> role.
     */
    public void setSucursales(Collection < Sucursal > sucursales) {
        this.sucursales = sucursales;
    }

   /**
    * This method gets the attribute value <code>modifiedSucursales</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSucursales</code> has been modified.
    */
    public boolean isModifiedSucursales(){
        return modifiedSucursales;
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
        regionalDescripcion = "";
        respRegional = null;
        sucursales = null;
        values = new HashMap<>();
        respRegionalRepository = Arc.container().select(RespRegionalJpaRepository.class).get();
        sucursalRepository = Arc.container().select(SucursalJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Regional.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return RegionalConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedRegionalDescripcion = false;
    	values.put("regionalDescripcion", getRegionalDescripcion());
    	modifiedRespRegional = false;
    	modifiedSucursales = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>RegionalOid</code> object that identifies this instance of <code>Regional</code>.
     * @return <code>RegionalOid </code> object that identifies this instance of <code>Regional</code>
     */
    public RegionalOid getOid() {
        return new RegionalOid(getRegionalCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(RegionalConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(RegionalConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.REGIONAL)) {
            // Add this class
            activeFacets.add(Constants.REGIONAL);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.RESPREGIONAL) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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

    public String buildICRegional() {
        try {
            return getRegionalDescripcion();
        } catch(Exception e) {
            return "";
        }
    }
}
