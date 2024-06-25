package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DepartamentoConstants;
import com.keralty.aeusuarios.persistence.oid.DepartamentoOid;
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
 * Persistent representation of the <code>Departamento</code> model class.
 * <p>
 * Model Class: <code>Departamento</code><br>
 */
@Entity(name = DepartamentoConstants.CLASS_NAME)
@Table(name = DepartamentoConstants.TBL_NAME)
public class Departamento extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @Column(name = DepartamentoConstants.FLD_DEPARTAMENTOCODIGO )
    @JsonProperty(value="codigo")
    private Long departamentoCodigo;

    /** Class member attribute. */
    @Column(name = DepartamentoConstants.FLD_DEPARTAMENTODESCRIPCION )
    @JsonProperty(value="descripcion")
    private String departamentoDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDepartamentoDescripcion;

    /** Class member attribute. */
    @Column(name = DepartamentoConstants.FLD_DEPARTAMENTOCODIGOLEGAL )
    @JsonProperty(value="codigolegal")
    private String departamentoCodigoLegal;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDepartamentoCodigoLegal;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_PERSONAS)
    @JsonIgnore
    private Collection <Persona> personas;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonas;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_MUNICIPIOS)
    @JsonIgnore
    private Collection <Municipio> municipios;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipios;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_PERSONASC)
    @JsonIgnore
    private Collection <PersonaC> personasC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonasC;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_DIRECCIONES)
    @JsonIgnore
    private Collection <Direccion> direcciones;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDirecciones;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_CONTRATANTES)
    @JsonIgnore
    private Collection <Contratante> contratantes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratantes;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_CONTRATANTESRES)
    @JsonIgnore
    private Collection <Contratante> contratantesRes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratantesRes;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_TITULARES)
    @JsonIgnore
    private Collection <Titular> titulares;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitulares;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_NOVEDADCTNAC)
    @JsonIgnore
    private Collection <NovedadCT> novedadCTNac;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadCTNac;

    /** Related Class. */
    @OneToMany(mappedBy = DepartamentoConstants.ROLE_INVNAME_NOVEDADCTRES)
    @JsonIgnore
    private Collection <NovedadCT> novedadCTRes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadCTRes;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Departamento() {
        departamentoCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Departamento</code>.
     * @param oid Object Identifier of the instance of <code>Departamento</code> to be created.
     * @throws SystemException
     */
    public Departamento(DepartamentoOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            departamentoCodigo = oid.getDepartamentoCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>departamentoCodigo</code> attribute<br>in class <code>Departamento</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Departamento</code>
     * @return The value of the <code>departamentoCodigo</code> attribute<br>in class <code>Departamento</code>.
     */
    public Long getDepartamentoCodigo() {
        return departamentoCodigo;
    }

    /**
     * Sets the value of the <code>departamentoCodigo</code> attribute<br>in class <code>Departamento</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Departamento</code>
     * @param departamentoCodigo The new value of the <code>departamentoCodigo</code> attribute<br>in class <code>Departamento</code>.
     */
    public void setDepartamentoCodigo(Long departamentoCodigo) {
        this.departamentoCodigo = departamentoCodigo;
    }

   /**
    * Returns the value of the <code>departamentoDescripcion</code> attribute.<br>
    * Model Attribute: <code>departamentoDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @return The value of the <code>departamentoDescripcion</code> attribute.
    */

    public String getDepartamentoDescripcion()  {
    	String value;
        value =  departamentoDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>departamentoDescripcion</code> attribute.<br>
    * Model Attribute: <code>departamentoDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @param departamentoDescripcion The new value of the <code>departamentoDescripcion</code> attribute.
    */
    public void setDepartamentoDescripcion (String departamentoDescripcion) {
        modifiedDepartamentoDescripcion = true;
        this.departamentoDescripcion = departamentoDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedDepartamentoDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedDepartamentoDescripcion</code>.
    */
    public void setModifiedDepartamentoDescripcion(boolean modified) {
        this.modifiedDepartamentoDescripcion = modified;
    }

   /**
    * Returns the value of the <code>departamentoCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>departamentoCodigoLegal</code>. Constant String Size=5<br>
    * Comments: <br>
    * @return The value of the <code>departamentoCodigoLegal</code> attribute.
    */

    public String getDepartamentoCodigoLegal()  {
    	String value;
        value =  departamentoCodigoLegal;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>departamentoCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>departamentoCodigoLegal</code>. Constant String Size=5<br>
    * Comments: <br>
    * @param departamentoCodigoLegal The new value of the <code>departamentoCodigoLegal</code> attribute.
    */
    public void setDepartamentoCodigoLegal (String departamentoCodigoLegal) {
        modifiedDepartamentoCodigoLegal = true;
        this.departamentoCodigoLegal = departamentoCodigoLegal;
    }

   /**
    * Sets the value of the <code>modifiedDepartamentoCodigoLegal</code> class property.<br>
    * @param modified The new value of the <code>modifiedDepartamentoCodigoLegal</code>.
    */
    public void setModifiedDepartamentoCodigoLegal(boolean modified) {
        this.modifiedDepartamentoCodigoLegal = modified;
    }

    /**
     * Returns the instance of <code>Persona</code> related through the <code>Personas</code> role.
     * Model Relationship:
     * <code>[Persona] Personas 0:M  ------ 0:1  DepartamentoNacimiento [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Persona</code> related through the <code>Personas</code> role.
     */
    @JsonIgnore
    public Collection <Persona> getPersonas() {
        return personas;
    }

   /**
    * Adds an instance of <code>Persona</code> related through the <code>Personas</code> role.
    * @param personas The instance to add to the <code>Personas</code> role.
    */
    public void add2Personas(Persona personas) {
        this.getPersonas().add(personas);
    }
    /**
     * Sets instances of <code>Persona</code> related through the <code>Personas</code> role.
     * @param personas The new value for the <code>Personas</code> role.
     */
    public void setPersonas(Collection < Persona > personas) {
        this.personas = personas;
    }

   /**
    * This method gets the attribute value <code>modifiedPersonas</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPersonas</code> has been modified.
    */
    public boolean isModifiedPersonas(){
        return modifiedPersonas;
    }

    /**
     * Returns the instance of <code>Municipio</code> related through the <code>Municipios</code> role.
     * Model Relationship:
     * <code>[Municipio] Municipios 0:M  ------ 0:1  Departamento [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Municipio</code> related through the <code>Municipios</code> role.
     */
    @JsonIgnore
    public Collection <Municipio> getMunicipios() {
        return municipios;
    }

   /**
    * Adds an instance of <code>Municipio</code> related through the <code>Municipios</code> role.
    * @param municipios The instance to add to the <code>Municipios</code> role.
    */
    public void add2Municipios(Municipio municipios) {
        this.getMunicipios().add(municipios);
    }
    /**
     * Sets instances of <code>Municipio</code> related through the <code>Municipios</code> role.
     * @param municipios The new value for the <code>Municipios</code> role.
     */
    public void setMunicipios(Collection < Municipio > municipios) {
        this.municipios = municipios;
    }

   /**
    * This method gets the attribute value <code>modifiedMunicipios</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedMunicipios</code> has been modified.
    */
    public boolean isModifiedMunicipios(){
        return modifiedMunicipios;
    }

    /**
     * Returns the instance of <code>PersonaC</code> related through the <code>PersonasC</code> role.
     * Model Relationship:
     * <code>[PersonaC] PersonasC 0:M  ------ 0:1  DepartamentoCNac [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>PersonaC</code> related through the <code>PersonasC</code> role.
     */
    @JsonIgnore
    public Collection <PersonaC> getPersonasC() {
        return personasC;
    }

   /**
    * Adds an instance of <code>PersonaC</code> related through the <code>PersonasC</code> role.
    * @param personasC The instance to add to the <code>PersonasC</code> role.
    */
    public void add2PersonasC(PersonaC personasC) {
        this.getPersonasC().add(personasC);
    }
    /**
     * Sets instances of <code>PersonaC</code> related through the <code>PersonasC</code> role.
     * @param personasC The new value for the <code>PersonasC</code> role.
     */
    public void setPersonasC(Collection < PersonaC > personasC) {
        this.personasC = personasC;
    }

   /**
    * This method gets the attribute value <code>modifiedPersonasC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPersonasC</code> has been modified.
    */
    public boolean isModifiedPersonasC(){
        return modifiedPersonasC;
    }

    /**
     * Returns the instance of <code>Direccion</code> related through the <code>Direcciones</code> role.
     * Model Relationship:
     * <code>[Direccion] Direcciones 0:M  ------ 0:1  Departamento [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Direccion</code> related through the <code>Direcciones</code> role.
     */
    @JsonIgnore
    public Collection <Direccion> getDirecciones() {
        return direcciones;
    }

   /**
    * Adds an instance of <code>Direccion</code> related through the <code>Direcciones</code> role.
    * @param direcciones The instance to add to the <code>Direcciones</code> role.
    */
    public void add2Direcciones(Direccion direcciones) {
        this.getDirecciones().add(direcciones);
    }
    /**
     * Sets instances of <code>Direccion</code> related through the <code>Direcciones</code> role.
     * @param direcciones The new value for the <code>Direcciones</code> role.
     */
    public void setDirecciones(Collection < Direccion > direcciones) {
        this.direcciones = direcciones;
    }

   /**
    * This method gets the attribute value <code>modifiedDirecciones</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDirecciones</code> has been modified.
    */
    public boolean isModifiedDirecciones(){
        return modifiedDirecciones;
    }

    /**
     * Returns the instance of <code>Contratante</code> related through the <code>Contratantes</code> role.
     * Model Relationship:
     * <code>[Contratante] Contratantes 0:M  ------ 0:1  DepartamentoNac [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Contratante</code> related through the <code>Contratantes</code> role.
     */
    @JsonIgnore
    public Collection <Contratante> getContratantes() {
        return contratantes;
    }

   /**
    * Adds an instance of <code>Contratante</code> related through the <code>Contratantes</code> role.
    * @param contratantes The instance to add to the <code>Contratantes</code> role.
    */
    public void add2Contratantes(Contratante contratantes) {
        this.getContratantes().add(contratantes);
    }
    /**
     * Sets instances of <code>Contratante</code> related through the <code>Contratantes</code> role.
     * @param contratantes The new value for the <code>Contratantes</code> role.
     */
    public void setContratantes(Collection < Contratante > contratantes) {
        this.contratantes = contratantes;
    }

   /**
    * This method gets the attribute value <code>modifiedContratantes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratantes</code> has been modified.
    */
    public boolean isModifiedContratantes(){
        return modifiedContratantes;
    }

    /**
     * Returns the instance of <code>Contratante</code> related through the <code>ContratantesRes</code> role.
     * Model Relationship:
     * <code>[Contratante] ContratantesRes 0:M  ------ 0:1  DepartamentoRes [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Contratante</code> related through the <code>ContratantesRes</code> role.
     */
    @JsonIgnore
    public Collection <Contratante> getContratantesRes() {
        return contratantesRes;
    }

   /**
    * Adds an instance of <code>Contratante</code> related through the <code>ContratantesRes</code> role.
    * @param contratantesRes The instance to add to the <code>ContratantesRes</code> role.
    */
    public void add2ContratantesRes(Contratante contratantesRes) {
        this.getContratantesRes().add(contratantesRes);
    }
    /**
     * Sets instances of <code>Contratante</code> related through the <code>ContratantesRes</code> role.
     * @param contratantesRes The new value for the <code>ContratantesRes</code> role.
     */
    public void setContratantesRes(Collection < Contratante > contratantesRes) {
        this.contratantesRes = contratantesRes;
    }

   /**
    * This method gets the attribute value <code>modifiedContratantesRes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratantesRes</code> has been modified.
    */
    public boolean isModifiedContratantesRes(){
        return modifiedContratantesRes;
    }

    /**
     * Returns the instance of <code>Titular</code> related through the <code>Titulares</code> role.
     * Model Relationship:
     * <code>[Titular] Titulares 0:M  ------ 0:1  DepartamentoNac [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Titular</code> related through the <code>Titulares</code> role.
     */
    @JsonIgnore
    public Collection <Titular> getTitulares() {
        return titulares;
    }

   /**
    * Adds an instance of <code>Titular</code> related through the <code>Titulares</code> role.
    * @param titulares The instance to add to the <code>Titulares</code> role.
    */
    public void add2Titulares(Titular titulares) {
        this.getTitulares().add(titulares);
    }
    /**
     * Sets instances of <code>Titular</code> related through the <code>Titulares</code> role.
     * @param titulares The new value for the <code>Titulares</code> role.
     */
    public void setTitulares(Collection < Titular > titulares) {
        this.titulares = titulares;
    }

   /**
    * This method gets the attribute value <code>modifiedTitulares</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTitulares</code> has been modified.
    */
    public boolean isModifiedTitulares(){
        return modifiedTitulares;
    }

    /**
     * Returns the instance of <code>NovedadCT</code> related through the <code>NovedadCTNac</code> role.
     * Model Relationship:
     * <code>[NovedadCT] NovedadCTNac 0:M  ------ 0:1  DepartamentoNac [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>NovedadCT</code> related through the <code>NovedadCTNac</code> role.
     */
    @JsonIgnore
    public Collection <NovedadCT> getNovedadCTNac() {
        return novedadCTNac;
    }

   /**
    * Adds an instance of <code>NovedadCT</code> related through the <code>NovedadCTNac</code> role.
    * @param novedadCTNac The instance to add to the <code>NovedadCTNac</code> role.
    */
    public void add2NovedadCTNac(NovedadCT novedadCTNac) {
        this.getNovedadCTNac().add(novedadCTNac);
    }
    /**
     * Sets instances of <code>NovedadCT</code> related through the <code>NovedadCTNac</code> role.
     * @param novedadCTNac The new value for the <code>NovedadCTNac</code> role.
     */
    public void setNovedadCTNac(Collection < NovedadCT > novedadCTNac) {
        this.novedadCTNac = novedadCTNac;
    }

   /**
    * This method gets the attribute value <code>modifiedNovedadCTNac</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedNovedadCTNac</code> has been modified.
    */
    public boolean isModifiedNovedadCTNac(){
        return modifiedNovedadCTNac;
    }

    /**
     * Returns the instance of <code>NovedadCT</code> related through the <code>NovedadCTRes</code> role.
     * Model Relationship:
     * <code>[NovedadCT] NovedadCTRes 0:M  ------ 0:1  DepartamentoRes [Departamento]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>NovedadCT</code> related through the <code>NovedadCTRes</code> role.
     */
    @JsonIgnore
    public Collection <NovedadCT> getNovedadCTRes() {
        return novedadCTRes;
    }

   /**
    * Adds an instance of <code>NovedadCT</code> related through the <code>NovedadCTRes</code> role.
    * @param novedadCTRes The instance to add to the <code>NovedadCTRes</code> role.
    */
    public void add2NovedadCTRes(NovedadCT novedadCTRes) {
        this.getNovedadCTRes().add(novedadCTRes);
    }
    /**
     * Sets instances of <code>NovedadCT</code> related through the <code>NovedadCTRes</code> role.
     * @param novedadCTRes The new value for the <code>NovedadCTRes</code> role.
     */
    public void setNovedadCTRes(Collection < NovedadCT > novedadCTRes) {
        this.novedadCTRes = novedadCTRes;
    }

   /**
    * This method gets the attribute value <code>modifiedNovedadCTRes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedNovedadCTRes</code> has been modified.
    */
    public boolean isModifiedNovedadCTRes(){
        return modifiedNovedadCTRes;
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
        departamentoDescripcion = "";
        departamentoCodigoLegal = "";
        personas = null;
        municipios = null;
        personasC = null;
        direcciones = null;
        contratantes = null;
        contratantesRes = null;
        titulares = null;
        novedadCTNac = null;
        novedadCTRes = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Departamento.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return DepartamentoConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedDepartamentoDescripcion = false;
    	values.put("departamentoDescripcion", getDepartamentoDescripcion());
    	modifiedDepartamentoCodigoLegal = false;
    	values.put("departamentoCodigoLegal", getDepartamentoCodigoLegal());
    	modifiedPersonas = false;
    	modifiedMunicipios = false;
    	modifiedPersonasC = false;
    	modifiedDirecciones = false;
    	modifiedContratantes = false;
    	modifiedContratantesRes = false;
    	modifiedTitulares = false;
    	modifiedNovedadCTNac = false;
    	modifiedNovedadCTRes = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>DepartamentoOid</code> object that identifies this instance of <code>Departamento</code>.
     * @return <code>DepartamentoOid </code> object that identifies this instance of <code>Departamento</code>
     */
    public DepartamentoOid getOid() {
        return new DepartamentoOid(getDepartamentoCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(DepartamentoConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.DEPARTAMENTO)) {
            // Add this class
            activeFacets.add(Constants.DEPARTAMENTO);
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
