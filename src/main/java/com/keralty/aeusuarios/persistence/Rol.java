package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.repository.DominioJpaRepository;
import com.keralty.aeusuarios.repository.FuncionarioJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
 * Persistent representation of the <code>Rol</code> model class.
 * <p>
 * Model Class: <code>Rol</code><br>
 */
@Entity(name = RolConstants.CLASS_NAME)
@Table(name = RolConstants.TBL_NAME)
public class Rol extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient FuncionarioJpaRepository funcionarioRepository;

    @JsonIgnore
    private transient DominioJpaRepository dominioRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = RolConstants.FLD_ROLIDENTIFICADOR )
    @JsonProperty(value="identificador")
    private Long rolIdentificador;

    /** Class member attribute. */
    @Column(name = RolConstants.FLD_ROLNOMBRE )
    @JsonProperty(value="nombre")
    private String rolNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedRolNombre;

    /** Related Class. */
    @OneToMany(mappedBy = RolConstants.ROLE_INVNAME_AGENTES)
    @JsonIgnore
    private Collection <Funcionario> agentes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAgentes;

    /** Related Class. */
    @ManyToMany(mappedBy=RolConstants.ROLE_INVNAME_DOMINIOS)
    @JsonIgnore
    private Collection <Dominio> dominios;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominios;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Rol() {
        rolIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Rol</code>.
     * @param oid Object Identifier of the instance of <code>Rol</code> to be created.
     * @throws SystemException
     */
    public Rol(RolOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            rolIdentificador = oid.getRolIdentificador();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>rolIdentificador</code> attribute<br>in class <code>Rol</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Rol</code>
     * @return The value of the <code>rolIdentificador</code> attribute<br>in class <code>Rol</code>.
     */
    public Long getRolIdentificador() {
        return rolIdentificador;
    }

    /**
     * Sets the value of the <code>rolIdentificador</code> attribute<br>in class <code>Rol</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Rol</code>
     * @param rolIdentificador The new value of the <code>rolIdentificador</code> attribute<br>in class <code>Rol</code>.
     */
    public void setRolIdentificador(Long rolIdentificador) {
        this.rolIdentificador = rolIdentificador;
    }

   /**
    * Returns the value of the <code>rolNombre</code> attribute.<br>
    * Model Attribute: <code>rolNombre</code>. Constant String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>rolNombre</code> attribute.
    */

    public String getRolNombre()  {
    	String value;
        value =  rolNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>rolNombre</code> attribute.<br>
    * Model Attribute: <code>rolNombre</code>. Constant String Size=50<br>
    * Comments: <br>
    * @param rolNombre The new value of the <code>rolNombre</code> attribute.
    */
    public void setRolNombre (String rolNombre) {
        modifiedRolNombre = true;
        this.rolNombre = rolNombre;
    }

   /**
    * Returns the value of the <code>modifiedRolNombre</code> class property.<br>
    *
    * @return The value of the <code>modifiedRolNombre</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedRolNombre() {
        return modifiedRolNombre;
    }

   /**
    * Sets the value of the <code>modifiedRolNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedRolNombre</code>.
    */
    public void setModifiedRolNombre(boolean modified) {
        this.modifiedRolNombre = modified;
    }

    /**
     * Returns the instance of <code>Funcionario</code> related through the <code>Agentes</code> role.
     * Model Relationship:
     * <code>[Funcionario] Agentes 0:M  ------ 1:1  Rol [Rol]</code>
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
     * Returns the instance of <code>Dominio</code> related through the <code>Dominios</code> role.
     * Model Relationship:
     * <code>[Dominio] Dominios 0:M  ------ 0:M  Roles [Rol]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>Dominios</code> role.
     */
    @JsonIgnore
    public Collection <Dominio> getDominios() {
        return dominios;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>Dominios</code> role.
    * @param dominios The instance to add to the <code>Dominios</code> role.
    */
    public void add2Dominios(Dominio dominios) {
        this.getDominios().add(dominios);
    }
    /**
     * Sets instances of <code>Dominio</code> related through the <code>Dominios</code> role.
     * @param dominios The new value for the <code>Dominios</code> role.
     */
    public void setDominios(Collection < Dominio > dominios) {
        this.dominios = dominios;
    }

   /**
    * This method gets the attribute value <code>modifiedDominios</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominios</code> has been modified.
    */
    public boolean isModifiedDominios(){
        return modifiedDominios;
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
        rolNombre = "";
        agentes = null;
        dominios = null;
        values = new HashMap<>();
        funcionarioRepository = Arc.container().select(FuncionarioJpaRepository.class).get();
        dominioRepository = Arc.container().select(DominioJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Rol.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return RolConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedRolNombre = false;
    	values.put("rolNombre", getRolNombre());
    	modifiedAgentes = false;
    	modifiedDominios = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>RolOid</code> object that identifies this instance of <code>Rol</code>.
     * @return <code>RolOid </code> object that identifies this instance of <code>Rol</code>
     */
    public RolOid getOid() {
        return new RolOid(getRolIdentificador());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(RolConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.ROL)) {
            // Add this class
            activeFacets.add(Constants.ROL);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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

    public String buildICRol() {
        try {
            return getRolNombre();
        } catch(Exception e) {
            return "";
        }
    }
}
