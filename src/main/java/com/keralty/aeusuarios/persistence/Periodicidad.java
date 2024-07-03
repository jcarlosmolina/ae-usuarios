package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.PeriodicidadConstants;
import com.keralty.aeusuarios.persistence.oid.PeriodicidadOid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
 * Persistent representation of the <code>Periodicidad</code> model class.
 * <p>
 * Model Class: <code>Periodicidad</code><br>
 */
@Entity(name = PeriodicidadConstants.CLASS_NAME)
@Table(name = PeriodicidadConstants.TBL_NAME)
public class Periodicidad extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @Column(name = PeriodicidadConstants.FLD_PERIODICIDADCODIGO )
    @JsonProperty(value="codigo")
    private Long periodicidadCodigo;

    /** Class member attribute. */
    @Column(name = PeriodicidadConstants.FLD_PERIODICIDADDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String periodicidadDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPeriodicidadDescripcion;

    /** Class member attribute. */
    @Column(name = PeriodicidadConstants.FLD_PERIODICIDADESMENSUAL )
    @JsonProperty(value="esmensual")
    private Boolean periodicidadEsMensual;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPeriodicidadEsMensual;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnumpagos")
    protected Long periodicidaddrvNumPagos;

    /** Related Class. */
    @ManyToMany(mappedBy=PeriodicidadConstants.ROLE_INVNAME_DOMINIOS)
    @JsonIgnore
    private Collection <Dominio> dominios;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominios;

    /** Related Class. */
    @OneToMany(mappedBy = PeriodicidadConstants.ROLE_INVNAME_SOLICITUDES)
    @JsonIgnore
    private Collection <Solicitud> solicitudes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudes;

    /** Related Class. */
    @OneToMany(mappedBy = PeriodicidadConstants.ROLE_INVNAME_ANEXOSMAT)
    @JsonIgnore
    private Collection <AnexoMat> anexosMat;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAnexosMat;

    /** Related Class. */
    @OneToMany(mappedBy = PeriodicidadConstants.ROLE_INVNAME_ANEXOSNEO)
    @JsonIgnore
    private Collection <AnexoNeo> anexosNeo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAnexosNeo;

    /** Related Class. */
    @OneToMany(mappedBy = PeriodicidadConstants.ROLE_INVNAME_CONTRATOSC)
    @JsonIgnore
    private Collection <ContratoC> contratosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @OneToMany(mappedBy = PeriodicidadConstants.ROLE_INVNAME_SOLICITUDESNOVEDAD)
    @JsonIgnore
    private Collection <SolicitudNovedad> solicitudesNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudesNovedad;

    /** Related Class. */
    @OneToMany(mappedBy = PeriodicidadConstants.ROLE_INVNAME_SOLICITUDESNOVEDADNUEVA)
    @JsonIgnore
    private Collection <SolicitudNovedad> solicitudesNovedadNueva;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudesNovedadNueva;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Periodicidad() {
        periodicidadCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Periodicidad</code>.
     * @param oid Object Identifier of the instance of <code>Periodicidad</code> to be created.
     * @throws SystemException
     */
    public Periodicidad(PeriodicidadOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            periodicidadCodigo = oid.getPeriodicidadCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>periodicidadCodigo</code> attribute<br>in class <code>Periodicidad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Periodicidad</code>
     * @return The value of the <code>periodicidadCodigo</code> attribute<br>in class <code>Periodicidad</code>.
     */
    public Long getPeriodicidadCodigo() {
        return periodicidadCodigo;
    }

    /**
     * Sets the value of the <code>periodicidadCodigo</code> attribute<br>in class <code>Periodicidad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Periodicidad</code>
     * @param periodicidadCodigo The new value of the <code>periodicidadCodigo</code> attribute<br>in class <code>Periodicidad</code>.
     */
    public void setPeriodicidadCodigo(Long periodicidadCodigo) {
        this.periodicidadCodigo = periodicidadCodigo;
    }

   /**
    * Returns the value of the <code>periodicidadDescripcion</code> attribute.<br>
    * Model Attribute: <code>periodicidadDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @return The value of the <code>periodicidadDescripcion</code> attribute.
    */

    public String getPeriodicidadDescripcion()  {
    	String value;
        value =  periodicidadDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>periodicidadDescripcion</code> attribute.<br>
    * Model Attribute: <code>periodicidadDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @param periodicidadDescripcion The new value of the <code>periodicidadDescripcion</code> attribute.
    */
    public void setPeriodicidadDescripcion (String periodicidadDescripcion) {
        modifiedPeriodicidadDescripcion = true;
        this.periodicidadDescripcion = periodicidadDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedPeriodicidadDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedPeriodicidadDescripcion</code>.
    */
    public void setModifiedPeriodicidadDescripcion(boolean modified) {
        this.modifiedPeriodicidadDescripcion = modified;
    }

   /**
    * Returns the value of the <code>periodicidadEsMensual</code> attribute.<br>
    * Model Attribute: <code>periodicidadEsMensual</code>. Variable Bool<br>
    * Comments: Necesitamos identificar la periodicidad mensual porque cambia la lógica de los datos de pago de la solicitud<br>
    * @return The value of the <code>periodicidadEsMensual</code> attribute.
    */

    public Boolean getPeriodicidadEsMensual()  {
    	Boolean value;
        value =  periodicidadEsMensual;
        return value;
    }

   /**
    * Sets the value of the <code>periodicidadEsMensual</code> attribute.<br>
    * Model Attribute: <code>periodicidadEsMensual</code>. Variable Bool<br>
    * Comments: Necesitamos identificar la periodicidad mensual porque cambia la lógica de los datos de pago de la solicitud<br>
    * @param periodicidadEsMensual The new value of the <code>periodicidadEsMensual</code> attribute.
    */
    public void setPeriodicidadEsMensual (Boolean periodicidadEsMensual) {
        modifiedPeriodicidadEsMensual = true;
        this.periodicidadEsMensual = periodicidadEsMensual;
    }

   /**
    * Sets the value of the <code>modifiedPeriodicidadEsMensual</code> class property.<br>
    * @param modified The new value of the <code>modifiedPeriodicidadEsMensual</code>.
    */
    public void setModifiedPeriodicidadEsMensual(boolean modified) {
        this.modifiedPeriodicidadEsMensual = modified;
    }

   /**
    * Returns the value of the <code>periodicidaddrvNumPagos</code> attribute.<br>
    * Model Attribute: <code>periodicidaddrvNumPagos</code>. Variable Nat<br>
    * Comments: <br>
    * @return The value of the <code>periodicidaddrvNumPagos</code> attribute.
    */

    public Long getPeriodicidaddrvNumPagos()  {
    	Long value;
        try {
            value = periodicidaddrvNumPagosDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Periodicidad, Attribute: periodicidaddrvNumPagos");
        }
        return value;
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>Dominios</code> role.
     * Model Relationship:
     * <code>[Dominio] Dominios 0:M  ------ 0:M  Periodicidades [Periodicidad]</code>
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
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitudes</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitudes 0:M  ------ 0:1  Periodicidad [Periodicidad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>Solicitudes</code> role.
     */
    @JsonIgnore
    public Collection <Solicitud> getSolicitudes() {
        return solicitudes;
    }

   /**
    * Adds an instance of <code>Solicitud</code> related through the <code>Solicitudes</code> role.
    * @param solicitudes The instance to add to the <code>Solicitudes</code> role.
    */
    public void add2Solicitudes(Solicitud solicitudes) {
        this.getSolicitudes().add(solicitudes);
    }
    /**
     * Sets instances of <code>Solicitud</code> related through the <code>Solicitudes</code> role.
     * @param solicitudes The new value for the <code>Solicitudes</code> role.
     */
    public void setSolicitudes(Collection < Solicitud > solicitudes) {
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
     * Returns the instance of <code>AnexoMat</code> related through the <code>AnexosMat</code> role.
     * Model Relationship:
     * <code>[AnexoMat] AnexosMat 0:M  ------ 1:1  Periodicidad [Periodicidad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AnexoMat</code> related through the <code>AnexosMat</code> role.
     */
    @JsonIgnore
    public Collection <AnexoMat> getAnexosMat() {
        return anexosMat;
    }

   /**
    * Adds an instance of <code>AnexoMat</code> related through the <code>AnexosMat</code> role.
    * @param anexosMat The instance to add to the <code>AnexosMat</code> role.
    */
    public void add2AnexosMat(AnexoMat anexosMat) {
        this.getAnexosMat().add(anexosMat);
    }
    /**
     * Sets instances of <code>AnexoMat</code> related through the <code>AnexosMat</code> role.
     * @param anexosMat The new value for the <code>AnexosMat</code> role.
     */
    public void setAnexosMat(Collection < AnexoMat > anexosMat) {
        this.anexosMat = anexosMat;
    }

   /**
    * This method gets the attribute value <code>modifiedAnexosMat</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAnexosMat</code> has been modified.
    */
    public boolean isModifiedAnexosMat(){
        return modifiedAnexosMat;
    }

    /**
     * Returns the instance of <code>AnexoNeo</code> related through the <code>AnexosNeo</code> role.
     * Model Relationship:
     * <code>[AnexoNeo] AnexosNeo 0:M  ------ 1:1  Periodicidad [Periodicidad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AnexoNeo</code> related through the <code>AnexosNeo</code> role.
     */
    @JsonIgnore
    public Collection <AnexoNeo> getAnexosNeo() {
        return anexosNeo;
    }

   /**
    * Adds an instance of <code>AnexoNeo</code> related through the <code>AnexosNeo</code> role.
    * @param anexosNeo The instance to add to the <code>AnexosNeo</code> role.
    */
    public void add2AnexosNeo(AnexoNeo anexosNeo) {
        this.getAnexosNeo().add(anexosNeo);
    }
    /**
     * Sets instances of <code>AnexoNeo</code> related through the <code>AnexosNeo</code> role.
     * @param anexosNeo The new value for the <code>AnexosNeo</code> role.
     */
    public void setAnexosNeo(Collection < AnexoNeo > anexosNeo) {
        this.anexosNeo = anexosNeo;
    }

   /**
    * This method gets the attribute value <code>modifiedAnexosNeo</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAnexosNeo</code> has been modified.
    */
    public boolean isModifiedAnexosNeo(){
        return modifiedAnexosNeo;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 0:1  PeriodicidadC [Periodicidad]</code>
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
     * <code>[SolicitudNovedad] SolicitudesNovedad 0:M  ------ 0:1  Periodicidad [Periodicidad]</code>
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
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedadNueva</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] SolicitudesNovedadNueva 0:M  ------ 0:1  PeriodicidadNueva [Periodicidad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedadNueva</code> role.
     */
    @JsonIgnore
    public Collection <SolicitudNovedad> getSolicitudesNovedadNueva() {
        return solicitudesNovedadNueva;
    }

   /**
    * Adds an instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedadNueva</code> role.
    * @param solicitudesNovedadNueva The instance to add to the <code>SolicitudesNovedadNueva</code> role.
    */
    public void add2SolicitudesNovedadNueva(SolicitudNovedad solicitudesNovedadNueva) {
        this.getSolicitudesNovedadNueva().add(solicitudesNovedadNueva);
    }
    /**
     * Sets instances of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedadNueva</code> role.
     * @param solicitudesNovedadNueva The new value for the <code>SolicitudesNovedadNueva</code> role.
     */
    public void setSolicitudesNovedadNueva(Collection < SolicitudNovedad > solicitudesNovedadNueva) {
        this.solicitudesNovedadNueva = solicitudesNovedadNueva;
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitudesNovedadNueva</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitudesNovedadNueva</code> has been modified.
    */
    public boolean isModifiedSolicitudesNovedadNueva(){
        return modifiedSolicitudesNovedadNueva;
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
     * Returns the value of the <code>periodicidaddrvNumPagos</code> derived attribute.
     *
     * @return Value of the <code>periodicidaddrvNumPagos</code> derived attribute.
     */
    public Long periodicidaddrvNumPagosDerivations() {
        return periodicidaddrvNumPagos;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        periodicidadDescripcion = "";
        periodicidadEsMensual = false;
        dominios = null;
        solicitudes = null;
        anexosMat = null;
        anexosNeo = null;
        contratosC = null;
        solicitudesNovedad = null;
        solicitudesNovedadNueva = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Periodicidad.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return PeriodicidadConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedPeriodicidadDescripcion = false;
    	values.put("periodicidadDescripcion", getPeriodicidadDescripcion());
    	modifiedPeriodicidadEsMensual = false;
    	values.put("periodicidadEsMensual", getPeriodicidadEsMensual());
    	modifiedDominios = false;
    	modifiedSolicitudes = false;
    	modifiedAnexosMat = false;
    	modifiedAnexosNeo = false;
    	modifiedContratosC = false;
    	modifiedSolicitudesNovedad = false;
    	modifiedSolicitudesNovedadNueva = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            periodicidaddrvNumPagos = null;
    }

    /**
     * Returns the <code>PeriodicidadOid</code> object that identifies this instance of <code>Periodicidad</code>.
     * @return <code>PeriodicidadOid </code> object that identifies this instance of <code>Periodicidad</code>
     */
    public PeriodicidadOid getOid() {
        return new PeriodicidadOid(getPeriodicidadCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(PeriodicidadConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.PERIODICIDAD)) {
            // Add this class
            activeFacets.add(Constants.PERIODICIDAD);
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
