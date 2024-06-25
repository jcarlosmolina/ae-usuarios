package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DepartamentoConstants;
import com.keralty.aeusuarios.global.DireccionConstants;
import com.keralty.aeusuarios.global.MunicipioConstants;
import com.keralty.aeusuarios.global.PersonaConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.TitularConstants;
import com.keralty.aeusuarios.persistence.oid.DireccionOid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
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
 * Persistent representation of the <code>Direccion</code> model class.
 * <p>
 * Model Class: <code>Direccion</code><br>
 */
@Entity(name = DireccionConstants.CLASS_NAME)
@Table(name = DireccionConstants.TBL_NAME)
public class Direccion extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = DireccionConstants.FLD_DIRECCIONIDENTIFICADOR )
    @JsonProperty(value="identificador")
    private Long direccionIdentificador;

    /** Class member attribute. */
    @Column(name = DireccionConstants.FLD_DIRECCIONCODIGO )
    @JsonProperty(value="codigo")
    private Long direccionCodigo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDireccionCodigo;

    /** Class member attribute. */
    @Column(name = DireccionConstants.FLD_DIRECCIONDIRECCIONCOMPLETA )
    @JsonProperty(value="direccioncompleta")
    private String direccionDireccionCompleta;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDireccionDireccionCompleta;

    /** Class member attribute. */
    @Column(name = DireccionConstants.FLD_DIRECCIONRURAL )
    @JsonProperty(value="rural")
    private Boolean direccionRural;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDireccionRural;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DireccionConstants.FLD_PERSONAPERSONAIDENTIFICADOR, referencedColumnName=PersonaConstants.FLD_PERSONAIDENTIFICADOR)
    })
    @JsonIgnore
    private Persona persona;
    /** Related attribute. */
    @Column(name = DireccionConstants.FLD_PERSONAPERSONAIDENTIFICADOR, insertable = false, updatable = false)
    private Long personaPersonaIdentificador;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersona;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DireccionConstants.FLD_MUNICIPIOMUNICIPIOCODIGO, referencedColumnName=MunicipioConstants.FLD_MUNICIPIOCODIGO)
    })
    @JsonIgnore
    private Municipio municipio;
    /** Related attribute. */
    @Column(name = DireccionConstants.FLD_MUNICIPIOMUNICIPIOCODIGO, insertable = false, updatable = false)
    private Long municipioMunicipioCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipio;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DireccionConstants.FLD_DEPARTAMENTODEPARTAMENTOCODIGO, referencedColumnName=DepartamentoConstants.FLD_DEPARTAMENTOCODIGO)
    })
    @JsonIgnore
    private Departamento departamento;
    /** Related attribute. */
    @Column(name = DireccionConstants.FLD_DEPARTAMENTODEPARTAMENTOCODIGO, insertable = false, updatable = false)
    private Long departamentoDepartamentoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDepartamento;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DireccionConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD)
    })
    @JsonIgnore
    private Solicitud contrato;
    /** Related attribute. */
    @Column(name = DireccionConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false)
    private Long aESOLICITUDESIDSOLICITUD;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContrato;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DireccionConstants.FLD_AESOLICITUDESTITULARIDSOLICITUD, referencedColumnName=TitularConstants.FLD_AESOLICITUDESIDSOLICITUD)
    })
    @JsonIgnore
    private Titular titular;
    /** Related attribute. */
    @Column(name = DireccionConstants.FLD_AESOLICITUDESTITULARIDSOLICITUD, insertable = false, updatable = false)
    private Long aESOLICITUDESTitularIDSOLICITUD;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitular;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Direccion() {
        direccionIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Direccion</code>.
     * @param oid Object Identifier of the instance of <code>Direccion</code> to be created.
     * @throws SystemException
     */
    public Direccion(DireccionOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            direccionIdentificador = oid.getDireccionIdentificador();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>direccionIdentificador</code> attribute<br>in class <code>Direccion</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Direccion</code>
     * @return The value of the <code>direccionIdentificador</code> attribute<br>in class <code>Direccion</code>.
     */
    public Long getDireccionIdentificador() {
        return direccionIdentificador;
    }

    /**
     * Sets the value of the <code>direccionIdentificador</code> attribute<br>in class <code>Direccion</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Direccion</code>
     * @param direccionIdentificador The new value of the <code>direccionIdentificador</code> attribute<br>in class <code>Direccion</code>.
     */
    public void setDireccionIdentificador(Long direccionIdentificador) {
        this.direccionIdentificador = direccionIdentificador;
    }

   /**
    * Returns the value of the <code>direccionCodigo</code> attribute.<br>
    * Model Attribute: <code>direccionCodigo</code>. Variable Int<br>
    * Comments: Este es el consecutivo que le asigna el CORE. Cuando recogemos los datos de la dirección en local este dato no lo sabemos. <br>
    * @return The value of the <code>direccionCodigo</code> attribute.
    */

    public Long getDireccionCodigo()  {
    	Long value;
        value =  direccionCodigo;
        return value;
    }

   /**
    * Sets the value of the <code>direccionCodigo</code> attribute.<br>
    * Model Attribute: <code>direccionCodigo</code>. Variable Int<br>
    * Comments: Este es el consecutivo que le asigna el CORE. Cuando recogemos los datos de la dirección en local este dato no lo sabemos. <br>
    * @param direccionCodigo The new value of the <code>direccionCodigo</code> attribute.
    */
    public void setDireccionCodigo (Long direccionCodigo) {
        modifiedDireccionCodigo = true;
        this.direccionCodigo = direccionCodigo;
    }

   /**
    * Sets the value of the <code>modifiedDireccionCodigo</code> class property.<br>
    * @param modified The new value of the <code>modifiedDireccionCodigo</code>.
    */
    public void setModifiedDireccionCodigo(boolean modified) {
        this.modifiedDireccionCodigo = modified;
    }

   /**
    * Returns the value of the <code>direccionDireccionCompleta</code> attribute.<br>
    * Model Attribute: <code>direccionDireccionCompleta</code>. Variable String Size=250<br>
    * Comments: <br>
    * @return The value of the <code>direccionDireccionCompleta</code> attribute.
    */

    public String getDireccionDireccionCompleta()  {
    	String value;
        value =  direccionDireccionCompleta;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>direccionDireccionCompleta</code> attribute.<br>
    * Model Attribute: <code>direccionDireccionCompleta</code>. Variable String Size=250<br>
    * Comments: <br>
    * @param direccionDireccionCompleta The new value of the <code>direccionDireccionCompleta</code> attribute.
    */
    public void setDireccionDireccionCompleta (String direccionDireccionCompleta) {
        modifiedDireccionDireccionCompleta = true;
        this.direccionDireccionCompleta = direccionDireccionCompleta;
    }

   /**
    * Sets the value of the <code>modifiedDireccionDireccionCompleta</code> class property.<br>
    * @param modified The new value of the <code>modifiedDireccionDireccionCompleta</code>.
    */
    public void setModifiedDireccionDireccionCompleta(boolean modified) {
        this.modifiedDireccionDireccionCompleta = modified;
    }

   /**
    * Returns the value of the <code>direccionRural</code> attribute.<br>
    * Model Attribute: <code>direccionRural</code>. Variable Bool<br>
    * Comments: Si la dirección es rural <br>
    * @return The value of the <code>direccionRural</code> attribute.
    */

    public Boolean getDireccionRural()  {
    	Boolean value;
        value =  direccionRural;
        return value;
    }

   /**
    * Sets the value of the <code>direccionRural</code> attribute.<br>
    * Model Attribute: <code>direccionRural</code>. Variable Bool<br>
    * Comments: Si la dirección es rural <br>
    * @param direccionRural The new value of the <code>direccionRural</code> attribute.
    */
    public void setDireccionRural (Boolean direccionRural) {
        modifiedDireccionRural = true;
        this.direccionRural = direccionRural;
    }

   /**
    * Sets the value of the <code>modifiedDireccionRural</code> class property.<br>
    * @param modified The new value of the <code>modifiedDireccionRural</code>.
    */
    public void setModifiedDireccionRural(boolean modified) {
        this.modifiedDireccionRural = modified;
    }

    /**
     * Returns the instance of <code>Persona</code> related through the <code>Persona</code> role.
     * Model Relationship:
     * <code>[Persona] Persona 0:1  ------ 0:M  Direcciones [Direccion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Persona</code> related through the <code>Persona</code> role.
     */
    @JsonIgnore
    public Persona getPersona() {
        return persona;
    }

   /**
    * Adds an instance of <code>Persona</code> related through the <code>Persona</code> role.
    * @param persona The instance to add to the <code>Persona</code> role.
    */
    public void add2Persona(Persona persona) {
        if (persona == null || persona.isNull()) {
            this.modifiedPersona = true;
            this.personaPersonaIdentificador = null;
        } else {
            this.personaPersonaIdentificador = persona.getPersonaIdentificador();
        }
        this.persona = (persona == null  || persona.isNull() ? null : persona);
    }

   /**
    * This method gets the attribute value <code>modifiedPersona</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPersona</code> has been modified.
    */
    public boolean isModifiedPersona(){
        return modifiedPersona;
    }

    /**
     * Returns the instance of <code>Municipio</code> related through the <code>Municipio</code> role.
     * Model Relationship:
     * <code>[Municipio] Municipio 0:1  ------ 0:M  Direcciones [Direccion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Municipio</code> related through the <code>Municipio</code> role.
     */
    @JsonIgnore
    public Municipio getMunicipio() {
        return municipio;
    }

   /**
    * Adds an instance of <code>Municipio</code> related through the <code>Municipio</code> role.
    * @param municipio The instance to add to the <code>Municipio</code> role.
    */
    public void add2Municipio(Municipio municipio) {
        if (municipio == null || municipio.isNull()) {
            this.modifiedMunicipio = true;
            this.municipioMunicipioCodigo = null;
        } else {
            this.municipioMunicipioCodigo = municipio.getMunicipioCodigo();
        }
        this.municipio = (municipio == null  || municipio.isNull() ? null : municipio);
    }

   /**
    * This method gets the attribute value <code>modifiedMunicipio</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedMunicipio</code> has been modified.
    */
    public boolean isModifiedMunicipio(){
        return modifiedMunicipio;
    }

    /**
     * Returns the instance of <code>Departamento</code> related through the <code>Departamento</code> role.
     * Model Relationship:
     * <code>[Departamento] Departamento 0:1  ------ 0:M  Direcciones [Direccion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Departamento</code> related through the <code>Departamento</code> role.
     */
    @JsonIgnore
    public Departamento getDepartamento() {
        return departamento;
    }

   /**
    * Adds an instance of <code>Departamento</code> related through the <code>Departamento</code> role.
    * @param departamento The instance to add to the <code>Departamento</code> role.
    */
    public void add2Departamento(Departamento departamento) {
        if (departamento == null || departamento.isNull()) {
            this.modifiedDepartamento = true;
            this.departamentoDepartamentoCodigo = null;
        } else {
            this.departamentoDepartamentoCodigo = departamento.getDepartamentoCodigo();
        }
        this.departamento = (departamento == null  || departamento.isNull() ? null : departamento);
    }

   /**
    * This method gets the attribute value <code>modifiedDepartamento</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDepartamento</code> has been modified.
    */
    public boolean isModifiedDepartamento(){
        return modifiedDepartamento;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Contrato</code> role.
     * Model Relationship:
     * <code>[Solicitud] Contrato 0:1  ------ 0:1  Direccion [Direccion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>Contrato</code> role.
     */
    @JsonIgnore
    public Solicitud getContrato() {
        return contrato;
    }

   /**
    * Adds an instance of <code>Solicitud</code> related through the <code>Contrato</code> role.
    * @param contrato The instance to add to the <code>Contrato</code> role.
    */
    public void add2Contrato(Solicitud contrato) {
        if (contrato == null || contrato.isNull()) {
            this.modifiedContrato = true;
            this.aESOLICITUDESIDSOLICITUD = null;
        } else {
            this.aESOLICITUDESIDSOLICITUD = contrato.getAESOLICITUDESIDSOLICITUD();
        }
        this.contrato = (contrato == null  || contrato.isNull() ? null : contrato);
    }

   /**
    * This method gets the attribute value <code>modifiedContrato</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContrato</code> has been modified.
    */
    public boolean isModifiedContrato(){
        return modifiedContrato;
    }

    /**
     * Returns the instance of <code>Titular</code> related through the <code>Titular</code> role.
     * Model Relationship:
     * <code>[Titular] Titular 0:1  ------ 0:1  Direccion [Direccion]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Titular</code> related through the <code>Titular</code> role.
     */
    @JsonIgnore
    public Titular getTitular() {
        return titular;
    }

   /**
    * Adds an instance of <code>Titular</code> related through the <code>Titular</code> role.
    * @param titular The instance to add to the <code>Titular</code> role.
    */
    public void add2Titular(Titular titular) {
        if (titular == null || titular.isNull()) {
            this.modifiedTitular = true;
            this.aESOLICITUDESTitularIDSOLICITUD = null;
        } else {
            this.aESOLICITUDESTitularIDSOLICITUD = titular.getAESOLICITUDESIDSOLICITUD();
        }
        this.titular = (titular == null  || titular.isNull() ? null : titular);
    }

   /**
    * This method gets the attribute value <code>modifiedTitular</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTitular</code> has been modified.
    */
    public boolean isModifiedTitular(){
        return modifiedTitular;
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
        direccionCodigo = null;
        direccionDireccionCompleta = null;
        direccionRural = null;
        persona = null;
        municipio = null;
        departamento = null;
        contrato = null;
        titular = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Direccion.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return DireccionConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedDireccionCodigo = false;
    	values.put("direccionCodigo", getDireccionCodigo());
    	modifiedDireccionDireccionCompleta = false;
    	values.put("direccionDireccionCompleta", getDireccionDireccionCompleta());
    	modifiedDireccionRural = false;
    	values.put("direccionRural", getDireccionRural());
    	modifiedPersona = false;
    	modifiedMunicipio = false;
    	modifiedDepartamento = false;
    	modifiedContrato = false;
    	modifiedTitular = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>DireccionOid</code> object that identifies this instance of <code>Direccion</code>.
     * @return <code>DireccionOid </code> object that identifies this instance of <code>Direccion</code>
     */
    public DireccionOid getOid() {
        return new DireccionOid(getDireccionIdentificador());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(DireccionConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(DireccionConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.DIRECCION)) {
            // Add this class
            activeFacets.add(Constants.DIRECCION);
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
