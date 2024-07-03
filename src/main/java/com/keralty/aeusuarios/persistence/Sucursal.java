package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.repository.ContratoCJpaRepository;
import com.keralty.aeusuarios.repository.FuncionarioJpaRepository;
import com.keralty.aeusuarios.repository.RegionalJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
 * Persistent representation of the <code>Sucursal</code> model class.
 * <p>
 * Model Class: <code>Sucursal</code><br>
 */
@Entity(name = SucursalConstants.CLASS_NAME)
@Table(name = SucursalConstants.TBL_NAME)
public class Sucursal extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient FuncionarioJpaRepository funcionarioRepository;

    @JsonIgnore
    private transient ContratoCJpaRepository contratoCRepository;

    @JsonIgnore
    private transient RegionalJpaRepository regionalRepository;

    /** Class identification function. */
    @Id
    @Column(name = SucursalConstants.FLD_SUCURSALCODIGO )
    @JsonProperty(value="codigo")
    private Long sucursalCodigo;

    /** Class member attribute. */
    @Column(name = SucursalConstants.FLD_SUCURSALDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String sucursalDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSucursalDescripcion;

    /** Related Class. */
    @OneToMany(mappedBy = SucursalConstants.ROLE_INVNAME_AGENTES)
    @JsonIgnore
    private Collection <Funcionario> agentes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAgentes;

    /** Related Class. */
    @OneToMany(mappedBy = SucursalConstants.ROLE_INVNAME_CONTRATOSC)
    @JsonIgnore
    private Collection <ContratoC> contratosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=SucursalConstants.FLD_REGIONALREGIONALCODIGO, referencedColumnName=RegionalConstants.FLD_REGIONALCODIGO)
    })
    @JsonIgnore
    private Regional regional;
    /** Related attribute. */
    @Column(name = SucursalConstants.FLD_REGIONALREGIONALCODIGO, insertable = false, updatable = false)
    private Long regionalRegionalCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedRegional;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Sucursal() {
        sucursalCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Sucursal</code>.
     * @param oid Object Identifier of the instance of <code>Sucursal</code> to be created.
     * @throws SystemException
     */
    public Sucursal(SucursalOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            sucursalCodigo = oid.getSucursalCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>sucursalCodigo</code> attribute<br>in class <code>Sucursal</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Sucursal</code>
     * @return The value of the <code>sucursalCodigo</code> attribute<br>in class <code>Sucursal</code>.
     */
    public Long getSucursalCodigo() {
        return sucursalCodigo;
    }

    /**
     * Sets the value of the <code>sucursalCodigo</code> attribute<br>in class <code>Sucursal</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Sucursal</code>
     * @param sucursalCodigo The new value of the <code>sucursalCodigo</code> attribute<br>in class <code>Sucursal</code>.
     */
    public void setSucursalCodigo(Long sucursalCodigo) {
        this.sucursalCodigo = sucursalCodigo;
    }

   /**
    * Returns the value of the <code>sucursalDescripcion</code> attribute.<br>
    * Model Attribute: <code>sucursalDescripcion</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>sucursalDescripcion</code> attribute.
    */

    public String getSucursalDescripcion()  {
    	String value;
        value =  sucursalDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>sucursalDescripcion</code> attribute.<br>
    * Model Attribute: <code>sucursalDescripcion</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param sucursalDescripcion The new value of the <code>sucursalDescripcion</code> attribute.
    */
    public void setSucursalDescripcion (String sucursalDescripcion) {
        modifiedSucursalDescripcion = true;
        this.sucursalDescripcion = sucursalDescripcion;
    }

   /**
    * Returns the value of the <code>modifiedSucursalDescripcion</code> class property.<br>
    *
    * @return The value of the <code>modifiedSucursalDescripcion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedSucursalDescripcion() {
        return modifiedSucursalDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedSucursalDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedSucursalDescripcion</code>.
    */
    public void setModifiedSucursalDescripcion(boolean modified) {
        this.modifiedSucursalDescripcion = modified;
    }

    /**
     * Returns the instance of <code>Funcionario</code> related through the <code>Agentes</code> role.
     * Model Relationship:
     * <code>[Funcionario] Agentes 0:M  ------ 1:1  Sucursal [Sucursal]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Funcionario</code> related through the <code>Agentes</code> role.
     */
    @JsonIgnore
    public Collection <Funcionario> getAgentes() {
        return agentes;
    }

   /**
    * Adds an instance of <code>Funcionario</code> related through the <code>Agentes</code> role.
    * @param agentes The instance to add to the <code>Agentes</code> role.
    */
    public void add2Agentes(Funcionario agentes) {
        this.getAgentes().add(agentes);
    }
    /**
     * Sets instances of <code>Funcionario</code> related through the <code>Agentes</code> role.
     * @param agentes The new value for the <code>Agentes</code> role.
     */
    public void setAgentes(Collection < Funcionario > agentes) {
        this.agentes = agentes;
    }

   /**
    * This method gets the attribute value <code>modifiedAgentes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAgentes</code> has been modified.
    */
    public boolean isModifiedAgentes(){
        return modifiedAgentes;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 0:1  SucursalC [Sucursal]</code>
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
     * Returns the instance of <code>Regional</code> related through the <code>Regional</code> role.
     * Model Relationship:
     * <code>[Regional] Regional 1:1  ------ 0:M  Sucursales [Sucursal]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Regional</code> related through the <code>Regional</code> role.
     */
    @JsonIgnore
    public Regional getRegional() {
        try {
            if (regional != null && regional.isNull()) {
                regional = null;
            }
        } catch (Exception ex) {
            regional = null;
        }
        if (regional == null) {
            if (regionalRegionalCodigo != null) {
                regional = regionalRepository.findById(regionalRegionalCodigo).orElse(null);
            } else {
                regional = null;
            }
        }
        return (regional == null ? new Regional(null) : regional);
    }

   /**
    * Adds an instance of <code>Regional</code> related through the <code>Regional</code> role.
    * @param regional The instance to add to the <code>Regional</code> role.
    */
    public void add2Regional(Regional regional) {
        if (regional == null || regional.isNull()) {
            this.modifiedRegional = true;
            this.regionalRegionalCodigo = null;
        } else {
            this.regionalRegionalCodigo = regional.getRegionalCodigo();
        }
        this.regional = (regional == null  || regional.isNull() ? null : regional);
    }

   /**
    * This method gets the attribute value <code>modifiedRegional</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedRegional</code> has been modified.
    */
    public boolean isModifiedRegional(){
        return modifiedRegional;
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
        sucursalDescripcion = "";
        agentes = null;
        contratosC = null;
        regional = null;
        values = new HashMap<>();
        funcionarioRepository = Arc.container().select(FuncionarioJpaRepository.class).get();
        contratoCRepository = Arc.container().select(ContratoCJpaRepository.class).get();
        regionalRepository = Arc.container().select(RegionalJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Sucursal.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return SucursalConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedSucursalDescripcion = false;
    	values.put("sucursalDescripcion", getSucursalDescripcion());
    	modifiedAgentes = false;
    	modifiedContratosC = false;
    	modifiedRegional = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>SucursalOid</code> object that identifies this instance of <code>Sucursal</code>.
     * @return <code>SucursalOid </code> object that identifies this instance of <code>Sucursal</code>
     */
    public SucursalOid getOid() {
        return new SucursalOid(getSucursalCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(SucursalConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(SucursalConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.SUCURSAL)) {
            // Add this class
            activeFacets.add(Constants.SUCURSAL);
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

    public String buildICSucursal() {
        try {
            return getSucursalDescripcion();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSSucursalPIU() {
        try {
            return getRegional().getRegionalDescripcion() + " " + (getSucursalCodigo() != null ? getSucursalCodigo().toString() : "") + " " + getSucursalDescripcion();
        } catch(Exception e) {
            return "";
        }
    }
}
