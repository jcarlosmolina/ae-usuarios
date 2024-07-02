package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.PlanesConstants;
import com.keralty.usuarios.global.ProductosConstants;
import com.keralty.usuarios.global.TarifaConstants;
import com.keralty.usuarios.persistence.oid.TarifaOid;
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
 * Persistent representation of the <code>Tarifa</code> model class.
 * <p>
 * Model Class: <code>Tarifa</code><br>
 */
@Entity(name = TarifaConstants.CLASS_NAME)
@Table(name = TarifaConstants.TBL_NAME)
public class Tarifa extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = TarifaConstants.FLD_TARIFAID )
    @JsonProperty(value="id")
    private Long tarifaId;

    /** Class member attribute. */
    @Column(name = TarifaConstants.FLD_TARIFACODIGO )
    @JsonProperty(value="codigo")
    private String tarifaCodigo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTarifaCodigo;

    /** Class member attribute. */
    @Column(name = TarifaConstants.FLD_TARIFATIPOCONTRATO )
    @JsonProperty(value="tipocontrato")
    private Long tarifaTipoContrato;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTarifaTipoContrato;

    /** Related Class. */
    @OneToMany(mappedBy = TarifaConstants.ROLE_INVNAME_CONTRATOSC)
    @JsonIgnore
    private Collection <ContratoC> contratosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @OneToMany(mappedBy = TarifaConstants.ROLE_INVNAME_DETALLESTARIFA)
    @JsonIgnore
    private Collection <DetalleTarifa> detallesTarifa;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDetallesTarifa;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=TarifaConstants.FLD_PRODUCTOSPRODUCTO, referencedColumnName=ProductosConstants.FLD_PRODUCTOSPRODUCTO)
    })
    @JsonIgnore
    private Productos productoT;
    /** Related attribute. */
    @Column(name = TarifaConstants.FLD_PRODUCTOSPRODUCTO, insertable = false, updatable = false)
    private Long productosProducto;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductoT;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=TarifaConstants.FLD_PLANESPLAN, referencedColumnName=PlanesConstants.FLD_PLANESPLAN)
    })
    @JsonIgnore
    private Planes planT;
    /** Related attribute. */
    @Column(name = TarifaConstants.FLD_PLANESPLAN, insertable = false, updatable = false)
    private Long planesPlan;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlanT;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Tarifa() {
        tarifaId = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Tarifa</code>.
     * @param oid Object Identifier of the instance of <code>Tarifa</code> to be created.
     * @throws SystemException
     */
    public Tarifa(TarifaOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            tarifaId = oid.getTarifaId();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>tarifaId</code> attribute<br>in class <code>Tarifa</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Tarifa</code>
     * @return The value of the <code>tarifaId</code> attribute<br>in class <code>Tarifa</code>.
     */
    public Long getTarifaId() {
        return tarifaId;
    }

    /**
     * Sets the value of the <code>tarifaId</code> attribute<br>in class <code>Tarifa</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Tarifa</code>
     * @param tarifaId The new value of the <code>tarifaId</code> attribute<br>in class <code>Tarifa</code>.
     */
    public void setTarifaId(Long tarifaId) {
        this.tarifaId = tarifaId;
    }

   /**
    * Returns the value of the <code>tarifaCodigo</code> attribute.<br>
    * Model Attribute: <code>tarifaCodigo</code>. Constant String Size=12<br>
    * Comments: <br>
    * @return The value of the <code>tarifaCodigo</code> attribute.
    */

    public String getTarifaCodigo()  {
    	String value;
        value =  tarifaCodigo;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>tarifaCodigo</code> attribute.<br>
    * Model Attribute: <code>tarifaCodigo</code>. Constant String Size=12<br>
    * Comments: <br>
    * @param tarifaCodigo The new value of the <code>tarifaCodigo</code> attribute.
    */
    public void setTarifaCodigo (String tarifaCodigo) {
        modifiedTarifaCodigo = true;
        this.tarifaCodigo = tarifaCodigo;
    }

   /**
    * Sets the value of the <code>modifiedTarifaCodigo</code> class property.<br>
    * @param modified The new value of the <code>modifiedTarifaCodigo</code>.
    */
    public void setModifiedTarifaCodigo(boolean modified) {
        this.modifiedTarifaCodigo = modified;
    }

   /**
    * Returns the value of the <code>tarifaTipoContrato</code> attribute.<br>
    * Model Attribute: <code>tarifaTipoContrato</code>. Variable Nat<br>
    * Comments: <br>
    * @return The value of the <code>tarifaTipoContrato</code> attribute.
    */

    public Long getTarifaTipoContrato()  {
    	Long value;
        value =  tarifaTipoContrato;
        return value;
    }

   /**
    * Sets the value of the <code>tarifaTipoContrato</code> attribute.<br>
    * Model Attribute: <code>tarifaTipoContrato</code>. Variable Nat<br>
    * Comments: <br>
    * @param tarifaTipoContrato The new value of the <code>tarifaTipoContrato</code> attribute.
    */
    public void setTarifaTipoContrato (Long tarifaTipoContrato) {
        modifiedTarifaTipoContrato = true;
        this.tarifaTipoContrato = tarifaTipoContrato;
    }

   /**
    * Sets the value of the <code>modifiedTarifaTipoContrato</code> class property.<br>
    * @param modified The new value of the <code>modifiedTarifaTipoContrato</code>.
    */
    public void setModifiedTarifaTipoContrato(boolean modified) {
        this.modifiedTarifaTipoContrato = modified;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 0:1  TarifaC [Tarifa]</code>
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
     * Returns the instance of <code>DetalleTarifa</code> related through the <code>DetallesTarifa</code> role.
     * Model Relationship:
     * <code>[DetalleTarifa] DetallesTarifa 0:M  ------ 1:1  Tarifa [Tarifa]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>DetalleTarifa</code> related through the <code>DetallesTarifa</code> role.
     */
    @JsonIgnore
    public Collection <DetalleTarifa> getDetallesTarifa() {
        return detallesTarifa;
    }

   /**
    * Adds an instance of <code>DetalleTarifa</code> related through the <code>DetallesTarifa</code> role.
    * @param detallesTarifa The instance to add to the <code>DetallesTarifa</code> role.
    */
    public void add2DetallesTarifa(DetalleTarifa detallesTarifa) {
        this.getDetallesTarifa().add(detallesTarifa);
    }
    /**
     * Sets instances of <code>DetalleTarifa</code> related through the <code>DetallesTarifa</code> role.
     * @param detallesTarifa The new value for the <code>DetallesTarifa</code> role.
     */
    public void setDetallesTarifa(Collection < DetalleTarifa > detallesTarifa) {
        this.detallesTarifa = detallesTarifa;
    }

   /**
    * This method gets the attribute value <code>modifiedDetallesTarifa</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDetallesTarifa</code> has been modified.
    */
    public boolean isModifiedDetallesTarifa(){
        return modifiedDetallesTarifa;
    }

    /**
     * Returns the instance of <code>Productos</code> related through the <code>ProductoT</code> role.
     * Model Relationship:
     * <code>[Productos] ProductoT 1:1  ------ 0:M  Tarifas [Tarifa]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Productos</code> related through the <code>ProductoT</code> role.
     */
    @JsonIgnore
    public Productos getProductoT() {
        return productoT;
    }

   /**
    * Adds an instance of <code>Productos</code> related through the <code>ProductoT</code> role.
    * @param productoT The instance to add to the <code>ProductoT</code> role.
    */
    public void add2ProductoT(Productos productoT) {
        if (productoT == null || productoT.isNull()) {
            this.modifiedProductoT = true;
            this.productosProducto = null;
        } else {
            this.productosProducto = productoT.getProductosProducto();
        }
        this.productoT = (productoT == null  || productoT.isNull() ? null : productoT);
    }

   /**
    * This method gets the attribute value <code>modifiedProductoT</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedProductoT</code> has been modified.
    */
    public boolean isModifiedProductoT(){
        return modifiedProductoT;
    }

    /**
     * Returns the instance of <code>Planes</code> related through the <code>PlanT</code> role.
     * Model Relationship:
     * <code>[Planes] PlanT 1:1  ------ 0:M  Tarifas [Tarifa]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Planes</code> related through the <code>PlanT</code> role.
     */
    @JsonIgnore
    public Planes getPlanT() {
        return planT;
    }

   /**
    * Adds an instance of <code>Planes</code> related through the <code>PlanT</code> role.
    * @param planT The instance to add to the <code>PlanT</code> role.
    */
    public void add2PlanT(Planes planT) {
        if (planT == null || planT.isNull()) {
            this.modifiedPlanT = true;
            this.planesPlan = null;
        } else {
            this.planesPlan = planT.getPlanesPlan();
        }
        this.planT = (planT == null  || planT.isNull() ? null : planT);
    }

   /**
    * This method gets the attribute value <code>modifiedPlanT</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPlanT</code> has been modified.
    */
    public boolean isModifiedPlanT(){
        return modifiedPlanT;
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
        tarifaCodigo = "";
        tarifaTipoContrato = Long.valueOf(0);
        contratosC = null;
        detallesTarifa = null;
        productoT = null;
        planT = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Tarifa.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return TarifaConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedTarifaCodigo = false;
    	values.put("tarifaCodigo", getTarifaCodigo());
    	modifiedTarifaTipoContrato = false;
    	values.put("tarifaTipoContrato", getTarifaTipoContrato());
    	modifiedContratosC = false;
    	modifiedDetallesTarifa = false;
    	modifiedProductoT = false;
    	modifiedPlanT = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>TarifaOid</code> object that identifies this instance of <code>Tarifa</code>.
     * @return <code>TarifaOid </code> object that identifies this instance of <code>Tarifa</code>
     */
    public TarifaOid getOid() {
        return new TarifaOid(getTarifaId());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(TarifaConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(TarifaConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.TARIFA)) {
            // Add this class
            activeFacets.add(Constants.TARIFA);
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
}
