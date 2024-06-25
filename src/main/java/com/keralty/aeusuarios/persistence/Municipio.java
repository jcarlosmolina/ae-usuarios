package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DepartamentoConstants;
import com.keralty.aeusuarios.global.MunicipioConstants;
import com.keralty.aeusuarios.persistence.oid.MunicipioOid;
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
 * Persistent representation of the <code>Municipio</code> model class.
 * <p>
 * Model Class: <code>Municipio</code><br>
 */
@Entity(name = MunicipioConstants.CLASS_NAME)
@Table(name = MunicipioConstants.TBL_NAME)
public class Municipio extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @Column(name = MunicipioConstants.FLD_MUNICIPIOCODIGO )
    @JsonProperty(value="codigo")
    private Long municipioCodigo;

    /** Class member attribute. */
    @Column(name = MunicipioConstants.FLD_MUNICIPIODESCRIPCION )
    @JsonProperty(value="descripcion")
    private String municipioDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioDescripcion;

    /** Class member attribute. */
    @Column(name = MunicipioConstants.FLD_MUNICIPIOCODIGOLEGAL )
    @JsonProperty(value="codigolegal")
    private String municipioCodigoLegal;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioCodigoLegal;

    /** Class member attribute. */
    @Column(name = MunicipioConstants.FLD_MUNICIPIOESVALIDOEPS )
    @JsonProperty(value="esvalidoeps")
    private Boolean municipioEsValidoEPS;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioEsValidoEPS;

    /** Class member attribute. */
    @Column(name = MunicipioConstants.FLD_MUNICIPIOAPLICAIVA )
    @JsonProperty(value="aplicaiva")
    private Boolean municipioAplicaIVA;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioAplicaIVA;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_PERSONAS)
    @JsonIgnore
    private Collection <Persona> personas;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonas;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_PERSONASC)
    @JsonIgnore
    private Collection <PersonaC> personasC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonasC;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_DIRECCIONES)
    @JsonIgnore
    private Collection <Direccion> direcciones;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDirecciones;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_CONTRATANTES)
    @JsonIgnore
    private Collection <Contratante> contratantes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratantes;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_CONTRATANTERES)
    @JsonIgnore
    private Collection <Contratante> contratanteRes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratanteRes;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_CONTRATOSC)
    @JsonIgnore
    private Collection <ContratoC> contratosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_FAMILIAC)
    @JsonIgnore
    private Collection <FamiliaC> familiaC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaC;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_TITULARES)
    @JsonIgnore
    private Collection <Titular> titulares;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitulares;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_NOVEDADCTNAC)
    @JsonIgnore
    private Collection <NovedadCT> novedadCTNac;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadCTNac;

    /** Related Class. */
    @OneToMany(mappedBy = MunicipioConstants.ROLE_INVNAME_NOVEDADCTRES)
    @JsonIgnore
    private Collection <NovedadCT> novedadCTRes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadCTRes;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=MunicipioConstants.FLD_DEPARTAMENTODEPARTAMENTOCODIGO, referencedColumnName=DepartamentoConstants.FLD_DEPARTAMENTOCODIGO)
    })
    @JsonIgnore
    private Departamento departamento;
    /** Related attribute. */
    @Column(name = MunicipioConstants.FLD_DEPARTAMENTODEPARTAMENTOCODIGO, insertable = false, updatable = false)
    private Long departamentoDepartamentoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDepartamento;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Municipio() {
        municipioCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Municipio</code>.
     * @param oid Object Identifier of the instance of <code>Municipio</code> to be created.
     * @throws SystemException
     */
    public Municipio(MunicipioOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            municipioCodigo = oid.getMunicipioCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>municipioCodigo</code> attribute<br>in class <code>Municipio</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Municipio</code>
     * @return The value of the <code>municipioCodigo</code> attribute<br>in class <code>Municipio</code>.
     */
    public Long getMunicipioCodigo() {
        return municipioCodigo;
    }

    /**
     * Sets the value of the <code>municipioCodigo</code> attribute<br>in class <code>Municipio</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Municipio</code>
     * @param municipioCodigo The new value of the <code>municipioCodigo</code> attribute<br>in class <code>Municipio</code>.
     */
    public void setMunicipioCodigo(Long municipioCodigo) {
        this.municipioCodigo = municipioCodigo;
    }

   /**
    * Returns the value of the <code>municipioDescripcion</code> attribute.<br>
    * Model Attribute: <code>municipioDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @return The value of the <code>municipioDescripcion</code> attribute.
    */

    public String getMunicipioDescripcion()  {
    	String value;
        value =  municipioDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>municipioDescripcion</code> attribute.<br>
    * Model Attribute: <code>municipioDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @param municipioDescripcion The new value of the <code>municipioDescripcion</code> attribute.
    */
    public void setMunicipioDescripcion (String municipioDescripcion) {
        modifiedMunicipioDescripcion = true;
        this.municipioDescripcion = municipioDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedMunicipioDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedMunicipioDescripcion</code>.
    */
    public void setModifiedMunicipioDescripcion(boolean modified) {
        this.modifiedMunicipioDescripcion = modified;
    }

   /**
    * Returns the value of the <code>municipioCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>municipioCodigoLegal</code>. Variable String Size=10<br>
    * Comments: <br>
    * @return The value of the <code>municipioCodigoLegal</code> attribute.
    */

    public String getMunicipioCodigoLegal()  {
    	String value;
        value =  municipioCodigoLegal;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>municipioCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>municipioCodigoLegal</code>. Variable String Size=10<br>
    * Comments: <br>
    * @param municipioCodigoLegal The new value of the <code>municipioCodigoLegal</code> attribute.
    */
    public void setMunicipioCodigoLegal (String municipioCodigoLegal) {
        modifiedMunicipioCodigoLegal = true;
        this.municipioCodigoLegal = municipioCodigoLegal;
    }

   /**
    * Sets the value of the <code>modifiedMunicipioCodigoLegal</code> class property.<br>
    * @param modified The new value of the <code>modifiedMunicipioCodigoLegal</code>.
    */
    public void setModifiedMunicipioCodigoLegal(boolean modified) {
        this.modifiedMunicipioCodigoLegal = modified;
    }

   /**
    * Returns the value of the <code>municipioEsValidoEPS</code> attribute.<br>
    * Model Attribute: <code>municipioEsValidoEPS</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>municipioEsValidoEPS</code> attribute.
    */

    public Boolean getMunicipioEsValidoEPS()  {
    	Boolean value;
        value =  municipioEsValidoEPS;
        return value;
    }

   /**
    * Sets the value of the <code>municipioEsValidoEPS</code> attribute.<br>
    * Model Attribute: <code>municipioEsValidoEPS</code>. Variable Bool<br>
    * Comments: <br>
    * @param municipioEsValidoEPS The new value of the <code>municipioEsValidoEPS</code> attribute.
    */
    public void setMunicipioEsValidoEPS (Boolean municipioEsValidoEPS) {
        modifiedMunicipioEsValidoEPS = true;
        this.municipioEsValidoEPS = municipioEsValidoEPS;
    }

   /**
    * Sets the value of the <code>modifiedMunicipioEsValidoEPS</code> class property.<br>
    * @param modified The new value of the <code>modifiedMunicipioEsValidoEPS</code>.
    */
    public void setModifiedMunicipioEsValidoEPS(boolean modified) {
        this.modifiedMunicipioEsValidoEPS = modified;
    }

   /**
    * Returns the value of the <code>municipioAplicaIVA</code> attribute.<br>
    * Model Attribute: <code>municipioAplicaIVA</code>. Variable Bool<br>
    * Comments: Hay algunos municipios para los que no aplica IVA. Este dato no nos lo proporciona el CORE, por eso lo gestionaremos en Afiliación Electrónica<br>
    * @return The value of the <code>municipioAplicaIVA</code> attribute.
    */

    public Boolean getMunicipioAplicaIVA()  {
    	Boolean value;
        value =  municipioAplicaIVA;
        return value;
    }

   /**
    * Sets the value of the <code>municipioAplicaIVA</code> attribute.<br>
    * Model Attribute: <code>municipioAplicaIVA</code>. Variable Bool<br>
    * Comments: Hay algunos municipios para los que no aplica IVA. Este dato no nos lo proporciona el CORE, por eso lo gestionaremos en Afiliación Electrónica<br>
    * @param municipioAplicaIVA The new value of the <code>municipioAplicaIVA</code> attribute.
    */
    public void setMunicipioAplicaIVA (Boolean municipioAplicaIVA) {
        modifiedMunicipioAplicaIVA = true;
        this.municipioAplicaIVA = municipioAplicaIVA;
    }

   /**
    * Sets the value of the <code>modifiedMunicipioAplicaIVA</code> class property.<br>
    * @param modified The new value of the <code>modifiedMunicipioAplicaIVA</code>.
    */
    public void setModifiedMunicipioAplicaIVA(boolean modified) {
        this.modifiedMunicipioAplicaIVA = modified;
    }

    /**
     * Returns the instance of <code>Persona</code> related through the <code>Personas</code> role.
     * Model Relationship:
     * <code>[Persona] Personas 0:M  ------ 0:1  MunicipioNacimiento [Municipio]</code>
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
     * Returns the instance of <code>PersonaC</code> related through the <code>PersonasC</code> role.
     * Model Relationship:
     * <code>[PersonaC] PersonasC 0:M  ------ 0:1  MunicipioCNac [Municipio]</code>
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
     * <code>[Direccion] Direcciones 0:M  ------ 0:1  Municipio [Municipio]</code>
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
     * <code>[Contratante] Contratantes 0:M  ------ 0:1  MunicipioNac [Municipio]</code>
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
     * Returns the instance of <code>Contratante</code> related through the <code>ContratanteRes</code> role.
     * Model Relationship:
     * <code>[Contratante] ContratanteRes 0:M  ------ 0:1  MunicipioRes [Municipio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Contratante</code> related through the <code>ContratanteRes</code> role.
     */
    @JsonIgnore
    public Collection <Contratante> getContratanteRes() {
        return contratanteRes;
    }

   /**
    * Adds an instance of <code>Contratante</code> related through the <code>ContratanteRes</code> role.
    * @param contratanteRes The instance to add to the <code>ContratanteRes</code> role.
    */
    public void add2ContratanteRes(Contratante contratanteRes) {
        this.getContratanteRes().add(contratanteRes);
    }
    /**
     * Sets instances of <code>Contratante</code> related through the <code>ContratanteRes</code> role.
     * @param contratanteRes The new value for the <code>ContratanteRes</code> role.
     */
    public void setContratanteRes(Collection < Contratante > contratanteRes) {
        this.contratanteRes = contratanteRes;
    }

   /**
    * This method gets the attribute value <code>modifiedContratanteRes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratanteRes</code> has been modified.
    */
    public boolean isModifiedContratanteRes(){
        return modifiedContratanteRes;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 0:1  MunicipioC [Municipio]</code>
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
     * Returns the instance of <code>FamiliaC</code> related through the <code>FamiliaC</code> role.
     * Model Relationship:
     * <code>[FamiliaC] FamiliaC 0:M  ------ 0:1  MunicipioC [Municipio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>FamiliaC</code> related through the <code>FamiliaC</code> role.
     */
    @JsonIgnore
    public Collection <FamiliaC> getFamiliaC() {
        return familiaC;
    }

   /**
    * Adds an instance of <code>FamiliaC</code> related through the <code>FamiliaC</code> role.
    * @param familiaC The instance to add to the <code>FamiliaC</code> role.
    */
    public void add2FamiliaC(FamiliaC familiaC) {
        this.getFamiliaC().add(familiaC);
    }
    /**
     * Sets instances of <code>FamiliaC</code> related through the <code>FamiliaC</code> role.
     * @param familiaC The new value for the <code>FamiliaC</code> role.
     */
    public void setFamiliaC(Collection < FamiliaC > familiaC) {
        this.familiaC = familiaC;
    }

   /**
    * This method gets the attribute value <code>modifiedFamiliaC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFamiliaC</code> has been modified.
    */
    public boolean isModifiedFamiliaC(){
        return modifiedFamiliaC;
    }

    /**
     * Returns the instance of <code>Titular</code> related through the <code>Titulares</code> role.
     * Model Relationship:
     * <code>[Titular] Titulares 0:M  ------ 0:1  MunicipioNac [Municipio]</code>
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
     * <code>[NovedadCT] NovedadCTNac 0:M  ------ 0:1  MunicipioNac [Municipio]</code>
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
     * <code>[NovedadCT] NovedadCTRes 0:M  ------ 0:1  MunicipioRes [Municipio]</code>
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
     * Returns the instance of <code>Departamento</code> related through the <code>Departamento</code> role.
     * Model Relationship:
     * <code>[Departamento] Departamento 0:1  ------ 0:M  Municipios [Municipio]</code>
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
        municipioDescripcion = "";
        municipioCodigoLegal = "";
        municipioEsValidoEPS = false;
        municipioAplicaIVA = false;
        personas = null;
        personasC = null;
        direcciones = null;
        contratantes = null;
        contratanteRes = null;
        contratosC = null;
        familiaC = null;
        titulares = null;
        novedadCTNac = null;
        novedadCTRes = null;
        departamento = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Municipio.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return MunicipioConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedMunicipioDescripcion = false;
    	values.put("municipioDescripcion", getMunicipioDescripcion());
    	modifiedMunicipioCodigoLegal = false;
    	values.put("municipioCodigoLegal", getMunicipioCodigoLegal());
    	modifiedMunicipioEsValidoEPS = false;
    	values.put("municipioEsValidoEPS", getMunicipioEsValidoEPS());
    	modifiedMunicipioAplicaIVA = false;
    	values.put("municipioAplicaIVA", getMunicipioAplicaIVA());
    	modifiedPersonas = false;
    	modifiedPersonasC = false;
    	modifiedDirecciones = false;
    	modifiedContratantes = false;
    	modifiedContratanteRes = false;
    	modifiedContratosC = false;
    	modifiedFamiliaC = false;
    	modifiedTitulares = false;
    	modifiedNovedadCTNac = false;
    	modifiedNovedadCTRes = false;
    	modifiedDepartamento = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>MunicipioOid</code> object that identifies this instance of <code>Municipio</code>.
     * @return <code>MunicipioOid </code> object that identifies this instance of <code>Municipio</code>
     */
    public MunicipioOid getOid() {
        return new MunicipioOid(getMunicipioCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(MunicipioConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(MunicipioConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.MUNICIPIO)) {
            // Add this class
            activeFacets.add(Constants.MUNICIPIO);
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
