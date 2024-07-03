package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.GrupoAsignacionConstants;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.aeusuarios.repository.DominioJpaRepository;
import com.keralty.aeusuarios.repository.FuncionarioJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
 * Persistent representation of the <code>GrupoAsignacion</code> model class.
 * <p>
 * Model Class: <code>GrupoAsignacion</code><br>
 */
@Entity(name = GrupoAsignacionConstants.CLASS_NAME)
@Table(name = GrupoAsignacionConstants.TBL_NAME)
public class GrupoAsignacion extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient DominioJpaRepository dominioRepository;

    @JsonIgnore
    private transient FuncionarioJpaRepository funcionarioRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = GrupoAsignacionConstants.FLD_GRUPOASIGNACIONID )
    @JsonProperty(value="id")
    private Long grupoAsignacionId;

    /** Class member attribute. */
    @Column(name = GrupoAsignacionConstants.FLD_GRUPOASIGNACIONTIPO )
    @JsonProperty(value="tipo")
    private Long grupoAsignacionTipo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGrupoAsignacionTipo;

    /** Class member attribute. */
    @Column(name = GrupoAsignacionConstants.FLD_GRUPOASIGNACIONNOMBRE )
    @JsonProperty(value="nombre")
    private String grupoAsignacionNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGrupoAsignacionNombre;

    /** Class member attribute. */
    @Column(name = GrupoAsignacionConstants.FLD_GRUPOASIGNACIONDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String grupoAsignacionDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGrupoAsignacionDescripcion;

    /** Related Class. */
    @OneToMany(mappedBy = GrupoAsignacionConstants.ROLE_INVNAME_DOMINIOASESORES)
    @JsonIgnore
    private Collection <Dominio> dominioAsesores;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioAsesores;

    /** Related Class. */
    @OneToMany(mappedBy = GrupoAsignacionConstants.ROLE_INVNAME_DOMINIOAREAMEDICA)
    @JsonIgnore
    private Collection <Dominio> dominioAreaMedica;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioAreaMedica;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_GRUPOASIGNACIONFUNCIONARIO,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMGRUPOASIGNACIONFUNCIONARIO_GRUPOASIGNACIONID, referencedColumnName=GrupoAsignacionConstants.FLD_GRUPOASIGNACIONID)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMGRUPOASIGNACIONFUNCIONARIO_FUNCIONARIOFUNCIONARIOID, referencedColumnName=FuncionarioConstants.FLD_FUNCIONARIOID)
    })
    @JsonIgnore
    private Collection <Funcionario> funcionario;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFuncionario;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public GrupoAsignacion() {
        grupoAsignacionId = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>GrupoAsignacion</code>.
     * @param oid Object Identifier of the instance of <code>GrupoAsignacion</code> to be created.
     * @throws SystemException
     */
    public GrupoAsignacion(GrupoAsignacionOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            grupoAsignacionId = oid.getGrupoAsignacionId();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>grupoAsignacionId</code> attribute<br>in class <code>GrupoAsignacion</code>.
     * This is part of the identification for this class, which depends on the identification of <code>GrupoAsignacion</code>
     * @return The value of the <code>grupoAsignacionId</code> attribute<br>in class <code>GrupoAsignacion</code>.
     */
    public Long getGrupoAsignacionId() {
        return grupoAsignacionId;
    }

    /**
     * Sets the value of the <code>grupoAsignacionId</code> attribute<br>in class <code>GrupoAsignacion</code>.
     * This is part of the identification for this class, which depends on the identification of <code>GrupoAsignacion</code>
     * @param grupoAsignacionId The new value of the <code>grupoAsignacionId</code> attribute<br>in class <code>GrupoAsignacion</code>.
     */
    public void setGrupoAsignacionId(Long grupoAsignacionId) {
        this.grupoAsignacionId = grupoAsignacionId;
    }

   /**
    * Returns the value of the <code>grupoAsignacionTipo</code> attribute.<br>
    * Model Attribute: <code>grupoAsignacionTipo</code>. Constant Nat<br>
    * Comments: <br>
    * @return The value of the <code>grupoAsignacionTipo</code> attribute.
    */

    public Long getGrupoAsignacionTipo()  {
    	Long value;
        value =  grupoAsignacionTipo;
        return value;
    }

   /**
    * Sets the value of the <code>grupoAsignacionTipo</code> attribute.<br>
    * Model Attribute: <code>grupoAsignacionTipo</code>. Constant Nat<br>
    * Comments: <br>
    * @param grupoAsignacionTipo The new value of the <code>grupoAsignacionTipo</code> attribute.
    */
    public void setGrupoAsignacionTipo (Long grupoAsignacionTipo) {
        modifiedGrupoAsignacionTipo = true;
        this.grupoAsignacionTipo = grupoAsignacionTipo;
    }

   /**
    * Returns the value of the <code>modifiedGrupoAsignacionTipo</code> class property.<br>
    *
    * @return The value of the <code>modifiedGrupoAsignacionTipo</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedGrupoAsignacionTipo() {
        return modifiedGrupoAsignacionTipo;
    }

   /**
    * Sets the value of the <code>modifiedGrupoAsignacionTipo</code> class property.<br>
    * @param modified The new value of the <code>modifiedGrupoAsignacionTipo</code>.
    */
    public void setModifiedGrupoAsignacionTipo(boolean modified) {
        this.modifiedGrupoAsignacionTipo = modified;
    }

   /**
    * Returns the value of the <code>grupoAsignacionNombre</code> attribute.<br>
    * Model Attribute: <code>grupoAsignacionNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>grupoAsignacionNombre</code> attribute.
    */

    public String getGrupoAsignacionNombre()  {
    	String value;
        value =  grupoAsignacionNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>grupoAsignacionNombre</code> attribute.<br>
    * Model Attribute: <code>grupoAsignacionNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param grupoAsignacionNombre The new value of the <code>grupoAsignacionNombre</code> attribute.
    */
    public void setGrupoAsignacionNombre (String grupoAsignacionNombre) {
        modifiedGrupoAsignacionNombre = true;
        this.grupoAsignacionNombre = grupoAsignacionNombre;
    }

   /**
    * Returns the value of the <code>modifiedGrupoAsignacionNombre</code> class property.<br>
    *
    * @return The value of the <code>modifiedGrupoAsignacionNombre</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedGrupoAsignacionNombre() {
        return modifiedGrupoAsignacionNombre;
    }

   /**
    * Sets the value of the <code>modifiedGrupoAsignacionNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedGrupoAsignacionNombre</code>.
    */
    public void setModifiedGrupoAsignacionNombre(boolean modified) {
        this.modifiedGrupoAsignacionNombre = modified;
    }

   /**
    * Returns the value of the <code>grupoAsignacionDescripcion</code> attribute.<br>
    * Model Attribute: <code>grupoAsignacionDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @return The value of the <code>grupoAsignacionDescripcion</code> attribute.
    */

    public String getGrupoAsignacionDescripcion()  {
    	String value;
        value =  grupoAsignacionDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>grupoAsignacionDescripcion</code> attribute.<br>
    * Model Attribute: <code>grupoAsignacionDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @param grupoAsignacionDescripcion The new value of the <code>grupoAsignacionDescripcion</code> attribute.
    */
    public void setGrupoAsignacionDescripcion (String grupoAsignacionDescripcion) {
        modifiedGrupoAsignacionDescripcion = true;
        this.grupoAsignacionDescripcion = grupoAsignacionDescripcion;
    }

   /**
    * Returns the value of the <code>modifiedGrupoAsignacionDescripcion</code> class property.<br>
    *
    * @return The value of the <code>modifiedGrupoAsignacionDescripcion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedGrupoAsignacionDescripcion() {
        return modifiedGrupoAsignacionDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedGrupoAsignacionDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedGrupoAsignacionDescripcion</code>.
    */
    public void setModifiedGrupoAsignacionDescripcion(boolean modified) {
        this.modifiedGrupoAsignacionDescripcion = modified;
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>DominioAsesores</code> role.
     * Model Relationship:
     * <code>[Dominio] DominioAsesores 0:M  ------ 0:1  GrupoAsesores [GrupoAsignacion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>DominioAsesores</code> role.
     */
    @JsonIgnore
    public Collection <Dominio> getDominioAsesores() {
        return dominioAsesores;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>DominioAsesores</code> role.
    * @param dominioAsesores The instance to add to the <code>DominioAsesores</code> role.
    */
    public void add2DominioAsesores(Dominio dominioAsesores) {
        this.getDominioAsesores().add(dominioAsesores);
    }
    /**
     * Sets instances of <code>Dominio</code> related through the <code>DominioAsesores</code> role.
     * @param dominioAsesores The new value for the <code>DominioAsesores</code> role.
     */
    public void setDominioAsesores(Collection < Dominio > dominioAsesores) {
        this.dominioAsesores = dominioAsesores;
    }

   /**
    * This method gets the attribute value <code>modifiedDominioAsesores</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominioAsesores</code> has been modified.
    */
    public boolean isModifiedDominioAsesores(){
        return modifiedDominioAsesores;
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>DominioAreaMedica</code> role.
     * Model Relationship:
     * <code>[Dominio] DominioAreaMedica 0:M  ------ 0:1  GrupoAreaMedica [GrupoAsignacion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>DominioAreaMedica</code> role.
     */
    @JsonIgnore
    public Collection <Dominio> getDominioAreaMedica() {
        return dominioAreaMedica;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>DominioAreaMedica</code> role.
    * @param dominioAreaMedica The instance to add to the <code>DominioAreaMedica</code> role.
    */
    public void add2DominioAreaMedica(Dominio dominioAreaMedica) {
        this.getDominioAreaMedica().add(dominioAreaMedica);
    }
    /**
     * Sets instances of <code>Dominio</code> related through the <code>DominioAreaMedica</code> role.
     * @param dominioAreaMedica The new value for the <code>DominioAreaMedica</code> role.
     */
    public void setDominioAreaMedica(Collection < Dominio > dominioAreaMedica) {
        this.dominioAreaMedica = dominioAreaMedica;
    }

   /**
    * This method gets the attribute value <code>modifiedDominioAreaMedica</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominioAreaMedica</code> has been modified.
    */
    public boolean isModifiedDominioAreaMedica(){
        return modifiedDominioAreaMedica;
    }

    /**
     * Returns the instance of <code>Funcionario</code> related through the <code>Funcionario</code> role.
     * Model Relationship:
     * <code>[Funcionario] Funcionario 0:M  ------ 0:M  GrupoAsignacion [GrupoAsignacion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Funcionario</code> related through the <code>Funcionario</code> role.
     */
    @JsonIgnore
    public Collection <Funcionario> getFuncionario() {
        return funcionario;
    }

   /**
    * Adds an instance of <code>Funcionario</code> related through the <code>Funcionario</code> role.
    * @param funcionario The instance to add to the <code>Funcionario</code> role.
    */
    public void add2Funcionario(Funcionario funcionario) {
        this.getFuncionario().add(funcionario);
    }
    /**
     * Sets instances of <code>Funcionario</code> related through the <code>Funcionario</code> role.
     * @param funcionario The new value for the <code>Funcionario</code> role.
     */
    public void setFuncionario(Collection < Funcionario > funcionario) {
        this.funcionario = funcionario;
    }

   /**
    * This method gets the attribute value <code>modifiedFuncionario</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFuncionario</code> has been modified.
    */
    public boolean isModifiedFuncionario(){
        return modifiedFuncionario;
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
        grupoAsignacionTipo = Long.valueOf(0);
        grupoAsignacionNombre = "";
        grupoAsignacionDescripcion = "";
        dominioAsesores = null;
        dominioAreaMedica = null;
        funcionario = null;
        values = new HashMap<>();
        dominioRepository = Arc.container().select(DominioJpaRepository.class).get();
        funcionarioRepository = Arc.container().select(FuncionarioJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return GrupoAsignacion.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return GrupoAsignacionConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedGrupoAsignacionTipo = false;
    	values.put("grupoAsignacionTipo", getGrupoAsignacionTipo());
    	modifiedGrupoAsignacionNombre = false;
    	values.put("grupoAsignacionNombre", getGrupoAsignacionNombre());
    	modifiedGrupoAsignacionDescripcion = false;
    	values.put("grupoAsignacionDescripcion", getGrupoAsignacionDescripcion());
    	modifiedDominioAsesores = false;
    	modifiedDominioAreaMedica = false;
    	modifiedFuncionario = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>GrupoAsignacionOid</code> object that identifies this instance of <code>GrupoAsignacion</code>.
     * @return <code>GrupoAsignacionOid </code> object that identifies this instance of <code>GrupoAsignacion</code>
     */
    public GrupoAsignacionOid getOid() {
        return new GrupoAsignacionOid(getGrupoAsignacionId());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(GrupoAsignacionConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.GRUPOASIGNACION)) {
            // Add this class
            activeFacets.add(Constants.GRUPOASIGNACION);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.GESTOR)) {
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

    public String buildDSGrupoAsignacion() {
        try {
            return (getGrupoAsignacionId() != null ? getGrupoAsignacionId().toString() : "") + " " + (getGrupoAsignacionTipo() != null ? getGrupoAsignacionTipo().toString() : "") + " " + getGrupoAsignacionNombre() + " " + getGrupoAsignacionDescripcion();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildICGrupoAsignacion() {
        try {
            return getGrupoAsignacionNombre();
        } catch(Exception e) {
            return "";
        }
    }
}
