package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.CausalConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.NovedadConstants;
import com.keralty.usuarios.persistence.oid.CausalOid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
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
 * Persistent representation of the <code>Causal</code> model class.
 * <p>
 * Model Class: <code>Causal</code><br>
 */
@Entity(name = CausalConstants.CLASS_NAME)
@Table(name = CausalConstants.TBL_NAME)
public class Causal extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = CausalConstants.FLD_CAUSALIDCAUSAL )
    @JsonProperty(value="id_causal")
    private Long causalidCausal;

    /** Class member attribute. */
    @Column(name = CausalConstants.FLD_CAUSALALIASCAUSAL )
    @JsonProperty(value="aliascausal")
    private String causalAliasCausal;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausalAliasCausal;

    /** Class member attribute. */
    @Column(name = CausalConstants.FLD_CAUSALNOMBRE )
    @JsonProperty(value="nombre")
    private String causalNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausalNombre;

    /** Class member attribute. */
    @Column(name = CausalConstants.FLD_CAUSALDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String causalDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausalDescripcion;

    /** Class member attribute. */
    @Column(name = CausalConstants.FLD_CAUSALCODIGOLEGAL )
    @JsonProperty(value="codigolegal")
    private String causalCodigoLegal;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausalCodigoLegal;

    /** Class member attribute. */
    @Column(name = CausalConstants.FLD_CAUSALREQDOCPERSONA )
    @JsonProperty(value="reqdocpersona")
    private Boolean causalReqDocPersona;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausalReqDocPersona;

    /** Class member attribute. */
    @Column(name = CausalConstants.FLD_CAUSALREQDOCSOLICITUD )
    @JsonProperty(value="reqdocsolicitud")
    private Boolean causalReqDocSolicitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausalReqDocSolicitud;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtextomostrar")
    protected String causalDrvTextoMostrar;

    /** Related Class. */
    @OneToMany(mappedBy = CausalConstants.ROLE_INVNAME_SOLICITUDES)
    @JsonIgnore
    private Collection <SolicitudNovedad> solicitudes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudes;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=CausalConstants.FLD_NOVEDADIDNOVEDAD, referencedColumnName=NovedadConstants.FLD_NOVEDADIDNOVEDAD)
    })
    @JsonIgnore
    private Novedad novedad;
    /** Related attribute. */
    @Column(name = CausalConstants.FLD_NOVEDADIDNOVEDAD, insertable = false, updatable = false)
    private Long novedadidNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedad;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Causal() {
        causalidCausal = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Causal</code>.
     * @param oid Object Identifier of the instance of <code>Causal</code> to be created.
     * @throws SystemException
     */
    public Causal(CausalOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            causalidCausal = oid.getCausalidCausal();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>causalidCausal</code> attribute<br>in class <code>Causal</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Causal</code>
     * @return The value of the <code>causalidCausal</code> attribute<br>in class <code>Causal</code>.
     */
    public Long getCausalidCausal() {
        return causalidCausal;
    }

    /**
     * Sets the value of the <code>causalidCausal</code> attribute<br>in class <code>Causal</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Causal</code>
     * @param causalidCausal The new value of the <code>causalidCausal</code> attribute<br>in class <code>Causal</code>.
     */
    public void setCausalidCausal(Long causalidCausal) {
        this.causalidCausal = causalidCausal;
    }

   /**
    * Returns the value of the <code>causalAliasCausal</code> attribute.<br>
    * Model Attribute: <code>causalAliasCausal</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>causalAliasCausal</code> attribute.
    */

    public String getCausalAliasCausal()  {
    	String value;
        value =  causalAliasCausal;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>causalAliasCausal</code> attribute.<br>
    * Model Attribute: <code>causalAliasCausal</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param causalAliasCausal The new value of the <code>causalAliasCausal</code> attribute.
    */
    public void setCausalAliasCausal (String causalAliasCausal) {
        modifiedCausalAliasCausal = true;
        this.causalAliasCausal = causalAliasCausal;
    }

   /**
    * Sets the value of the <code>modifiedCausalAliasCausal</code> class property.<br>
    * @param modified The new value of the <code>modifiedCausalAliasCausal</code>.
    */
    public void setModifiedCausalAliasCausal(boolean modified) {
        this.modifiedCausalAliasCausal = modified;
    }

   /**
    * Returns the value of the <code>causalNombre</code> attribute.<br>
    * Model Attribute: <code>causalNombre</code>. Variable String Size=50<br>
    * Comments: El nombre es el valor que se utilizará para mostrar al usuario de la aplicación cuando debe seleccionar o se muestre una novedad<br>
    * @return The value of the <code>causalNombre</code> attribute.
    */

    public String getCausalNombre()  {
    	String value;
        value =  causalNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>causalNombre</code> attribute.<br>
    * Model Attribute: <code>causalNombre</code>. Variable String Size=50<br>
    * Comments: El nombre es el valor que se utilizará para mostrar al usuario de la aplicación cuando debe seleccionar o se muestre una novedad<br>
    * @param causalNombre The new value of the <code>causalNombre</code> attribute.
    */
    public void setCausalNombre (String causalNombre) {
        modifiedCausalNombre = true;
        this.causalNombre = causalNombre;
    }

   /**
    * Sets the value of the <code>modifiedCausalNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedCausalNombre</code>.
    */
    public void setModifiedCausalNombre(boolean modified) {
        this.modifiedCausalNombre = modified;
    }

   /**
    * Returns the value of the <code>causalDescripcion</code> attribute.<br>
    * Model Attribute: <code>causalDescripcion</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>causalDescripcion</code> attribute.
    */

    public String getCausalDescripcion()  {
    	String value;
        value =  causalDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>causalDescripcion</code> attribute.<br>
    * Model Attribute: <code>causalDescripcion</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param causalDescripcion The new value of the <code>causalDescripcion</code> attribute.
    */
    public void setCausalDescripcion (String causalDescripcion) {
        modifiedCausalDescripcion = true;
        this.causalDescripcion = causalDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedCausalDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedCausalDescripcion</code>.
    */
    public void setModifiedCausalDescripcion(boolean modified) {
        this.modifiedCausalDescripcion = modified;
    }

   /**
    * Returns the value of the <code>causalCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>causalCodigoLegal</code>. Variable String Size=5<br>
    * Comments: <br>
    * @return The value of the <code>causalCodigoLegal</code> attribute.
    */

    public String getCausalCodigoLegal()  {
    	String value;
        value =  causalCodigoLegal;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>causalCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>causalCodigoLegal</code>. Variable String Size=5<br>
    * Comments: <br>
    * @param causalCodigoLegal The new value of the <code>causalCodigoLegal</code> attribute.
    */
    public void setCausalCodigoLegal (String causalCodigoLegal) {
        modifiedCausalCodigoLegal = true;
        this.causalCodigoLegal = causalCodigoLegal;
    }

   /**
    * Sets the value of the <code>modifiedCausalCodigoLegal</code> class property.<br>
    * @param modified The new value of the <code>modifiedCausalCodigoLegal</code>.
    */
    public void setModifiedCausalCodigoLegal(boolean modified) {
        this.modifiedCausalCodigoLegal = modified;
    }

   /**
    * Returns the value of the <code>causalReqDocPersona</code> attribute.<br>
    * Model Attribute: <code>causalReqDocPersona</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental persona (identificación de la persona). Si la novedad a la que está asociado el causal tiene la marca, entonces el causal también la tiene
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>causalReqDocPersona</code> attribute.
    */

    public Boolean getCausalReqDocPersona()  {
    	Boolean value;
        value =  causalReqDocPersona;
        return value;
    }

   /**
    * Sets the value of the <code>causalReqDocPersona</code> attribute.<br>
    * Model Attribute: <code>causalReqDocPersona</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental persona (identificación de la persona). Si la novedad a la que está asociado el causal tiene la marca, entonces el causal también la tiene
<Options>
RADIO=1;
</Options><br>
    * @param causalReqDocPersona The new value of the <code>causalReqDocPersona</code> attribute.
    */
    public void setCausalReqDocPersona (Boolean causalReqDocPersona) {
        modifiedCausalReqDocPersona = true;
        this.causalReqDocPersona = causalReqDocPersona;
    }

   /**
    * Sets the value of the <code>modifiedCausalReqDocPersona</code> class property.<br>
    * @param modified The new value of the <code>modifiedCausalReqDocPersona</code>.
    */
    public void setModifiedCausalReqDocPersona(boolean modified) {
        this.modifiedCausalReqDocPersona = modified;
    }

   /**
    * Returns the value of the <code>causalReqDocSolicitud</code> attribute.<br>
    * Model Attribute: <code>causalReqDocSolicitud</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental solicitud. Si la novedad a la que está asociado el causal tiene la marca, entonces el causal también la tiene
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>causalReqDocSolicitud</code> attribute.
    */

    public Boolean getCausalReqDocSolicitud()  {
    	Boolean value;
        value =  causalReqDocSolicitud;
        return value;
    }

   /**
    * Sets the value of the <code>causalReqDocSolicitud</code> attribute.<br>
    * Model Attribute: <code>causalReqDocSolicitud</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental solicitud. Si la novedad a la que está asociado el causal tiene la marca, entonces el causal también la tiene
<Options>
RADIO=1;
</Options><br>
    * @param causalReqDocSolicitud The new value of the <code>causalReqDocSolicitud</code> attribute.
    */
    public void setCausalReqDocSolicitud (Boolean causalReqDocSolicitud) {
        modifiedCausalReqDocSolicitud = true;
        this.causalReqDocSolicitud = causalReqDocSolicitud;
    }

   /**
    * Sets the value of the <code>modifiedCausalReqDocSolicitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedCausalReqDocSolicitud</code>.
    */
    public void setModifiedCausalReqDocSolicitud(boolean modified) {
        this.modifiedCausalReqDocSolicitud = modified;
    }

   /**
    * Returns the value of the <code>causalDrvTextoMostrar</code> attribute.<br>
    * Model Attribute: <code>causalDrvTextoMostrar</code>. Variable String Size=110<br>
    * Comments: <br>
    * @return The value of the <code>causalDrvTextoMostrar</code> attribute.
    */

    public String getCausalDrvTextoMostrar()  {
    	String value;
        try {
            value = causalDrvTextoMostrarDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Causal, Attribute: causalDrvTextoMostrar");
        }
        return (value == null ? null : value.trim());
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] Solicitudes 0:M  ------ 0:1  Causal [Causal]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
     */
    @JsonIgnore
    public Collection <SolicitudNovedad> getSolicitudes() {
        return solicitudes;
    }

   /**
    * Adds an instance of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
    * @param solicitudes The instance to add to the <code>Solicitudes</code> role.
    */
    public void add2Solicitudes(SolicitudNovedad solicitudes) {
        this.getSolicitudes().add(solicitudes);
    }
    /**
     * Sets instances of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
     * @param solicitudes The new value for the <code>Solicitudes</code> role.
     */
    public void setSolicitudes(Collection < SolicitudNovedad > solicitudes) {
        this.solicitudes = solicitudes;
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitudes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitudes</code> has been modified.
    */
    public boolean isModifiedSolicitudes(){
        return modifiedSolicitudes;
    }

    /**
     * Returns the instance of <code>Novedad</code> related through the <code>Novedad</code> role.
     * Model Relationship:
     * <code>[Novedad] Novedad 1:1  ------ 0:M  Causales [Causal]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Novedad</code> related through the <code>Novedad</code> role.
     */
    @JsonIgnore
    public Novedad getNovedad() {
        return novedad;
    }

   /**
    * Adds an instance of <code>Novedad</code> related through the <code>Novedad</code> role.
    * @param novedad The instance to add to the <code>Novedad</code> role.
    */
    public void add2Novedad(Novedad novedad) {
        if (novedad == null || novedad.isNull()) {
            this.modifiedNovedad = true;
            this.novedadidNovedad = null;
        } else {
            this.novedadidNovedad = novedad.getNovedadidNovedad();
        }
        this.novedad = (novedad == null  || novedad.isNull() ? null : novedad);
    }

   /**
    * This method gets the attribute value <code>modifiedNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedNovedad</code> has been modified.
    */
    public boolean isModifiedNovedad(){
        return modifiedNovedad;
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
     * Returns the value of the <code>causalDrvTextoMostrar</code> derived attribute.
     *
     * @return Value of the <code>causalDrvTextoMostrar</code> derived attribute.
     */
    public String causalDrvTextoMostrarDerivations() {
        return causalDrvTextoMostrar;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        causalAliasCausal = "";
        causalNombre = "";
        causalDescripcion = "";
        causalCodigoLegal = "";
        causalReqDocPersona = false;
        causalReqDocSolicitud = false;
        solicitudes = null;
        novedad = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Causal.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return CausalConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedCausalAliasCausal = false;
    	values.put("causalAliasCausal", getCausalAliasCausal());
    	modifiedCausalNombre = false;
    	values.put("causalNombre", getCausalNombre());
    	modifiedCausalDescripcion = false;
    	values.put("causalDescripcion", getCausalDescripcion());
    	modifiedCausalCodigoLegal = false;
    	values.put("causalCodigoLegal", getCausalCodigoLegal());
    	modifiedCausalReqDocPersona = false;
    	values.put("causalReqDocPersona", getCausalReqDocPersona());
    	modifiedCausalReqDocSolicitud = false;
    	values.put("causalReqDocSolicitud", getCausalReqDocSolicitud());
    	modifiedSolicitudes = false;
    	modifiedNovedad = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            causalDrvTextoMostrar = null;
    }

    /**
     * Returns the <code>CausalOid</code> object that identifies this instance of <code>Causal</code>.
     * @return <code>CausalOid </code> object that identifies this instance of <code>Causal</code>
     */
    public CausalOid getOid() {
        return new CausalOid(getCausalidCausal());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(CausalConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(CausalConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.CAUSAL)) {
            // Add this class
            activeFacets.add(Constants.CAUSAL);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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
