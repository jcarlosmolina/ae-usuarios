package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.persistence.oid.EstadoBeneficiarioOid;
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
 * Persistent representation of the <code>EstadoBeneficiario</code> model class.
 * <p>
 * Model Class: <code>EstadoBeneficiario</code><br>
 */
@Entity(name = EstadoBeneficiarioConstants.CLASS_NAME)
@Table(name = EstadoBeneficiarioConstants.TBL_NAME)
public class EstadoBeneficiario extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @Column(name = EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOCODIGO )
    @JsonProperty(value="codigo")
    private Long estadoBeneficiarioCodigo;

    /** Class member attribute. */
    @Column(name = EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIODESCRIPCION )
    @JsonProperty(value="descripcion")
    private String estadoBeneficiarioDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiarioDescripcion;

    /** Class member attribute. */
    @Column(name = EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOESACTIVO )
    @JsonProperty(value="esactivo")
    private Boolean estadoBeneficiarioEsActivo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiarioEsActivo;

    /** Class member attribute. */
    @Column(name = EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOCONFIRMADO )
    @JsonProperty(value="confirmado")
    private Boolean estadoBeneficiarioConfirmado;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiarioConfirmado;

    /** Class member attribute. */
    @Column(name = EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOESERROR )
    @JsonProperty(value="eserror")
    private Boolean estadoBeneficiarioEsError;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiarioEsError;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoBeneficiarioConstants.ROLE_INVNAME_USUARIOS)
    @JsonIgnore
    private Collection <Usuario> usuarioS;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioS;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoBeneficiarioConstants.ROLE_INVNAME_BENEFICIARIOSC)
    @JsonIgnore
    private Collection <BeneficiarioC> beneficiariosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiariosC;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoBeneficiarioConstants.ROLE_INVNAME_USUARIOSREG)
    @JsonIgnore
    private Collection <UsuarioReg> usuariosReg;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuariosReg;

    /** Related Class. */
    @OneToMany(mappedBy = EstadoBeneficiarioConstants.ROLE_INVNAME_USUARIOSNOVEDAD)
    @JsonIgnore
    private Collection <UsuarioNovedad> usuariosNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuariosNovedad;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public EstadoBeneficiario() {
        estadoBeneficiarioCodigo = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>EstadoBeneficiario</code>.
     * @param oid Object Identifier of the instance of <code>EstadoBeneficiario</code> to be created.
     * @throws SystemException
     */
    public EstadoBeneficiario(EstadoBeneficiarioOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            estadoBeneficiarioCodigo = oid.getEstadoBeneficiarioCodigo();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>estadoBeneficiarioCodigo</code> attribute<br>in class <code>EstadoBeneficiario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>EstadoBeneficiario</code>
     * @return The value of the <code>estadoBeneficiarioCodigo</code> attribute<br>in class <code>EstadoBeneficiario</code>.
     */
    public Long getEstadoBeneficiarioCodigo() {
        return estadoBeneficiarioCodigo;
    }

    /**
     * Sets the value of the <code>estadoBeneficiarioCodigo</code> attribute<br>in class <code>EstadoBeneficiario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>EstadoBeneficiario</code>
     * @param estadoBeneficiarioCodigo The new value of the <code>estadoBeneficiarioCodigo</code> attribute<br>in class <code>EstadoBeneficiario</code>.
     */
    public void setEstadoBeneficiarioCodigo(Long estadoBeneficiarioCodigo) {
        this.estadoBeneficiarioCodigo = estadoBeneficiarioCodigo;
    }

   /**
    * Returns the value of the <code>estadoBeneficiarioDescripcion</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @return The value of the <code>estadoBeneficiarioDescripcion</code> attribute.
    */

    public String getEstadoBeneficiarioDescripcion()  {
    	String value;
        value =  estadoBeneficiarioDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>estadoBeneficiarioDescripcion</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioDescripcion</code>. Variable String Size=150<br>
    * Comments: <br>
    * @param estadoBeneficiarioDescripcion The new value of the <code>estadoBeneficiarioDescripcion</code> attribute.
    */
    public void setEstadoBeneficiarioDescripcion (String estadoBeneficiarioDescripcion) {
        modifiedEstadoBeneficiarioDescripcion = true;
        this.estadoBeneficiarioDescripcion = estadoBeneficiarioDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedEstadoBeneficiarioDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedEstadoBeneficiarioDescripcion</code>.
    */
    public void setModifiedEstadoBeneficiarioDescripcion(boolean modified) {
        this.modifiedEstadoBeneficiarioDescripcion = modified;
    }

   /**
    * Returns the value of the <code>estadoBeneficiarioEsActivo</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioEsActivo</code>. Variable Bool<br>
    * Comments: Indica que es el estado correspondiente con beneficiario activo. Por tanto en una inclusión si está como usuario registrado en este estado, no se podrá volver a añadir. <br>
    * @return The value of the <code>estadoBeneficiarioEsActivo</code> attribute.
    */

    public Boolean getEstadoBeneficiarioEsActivo()  {
    	Boolean value;
        value =  estadoBeneficiarioEsActivo;
        return value;
    }

   /**
    * Sets the value of the <code>estadoBeneficiarioEsActivo</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioEsActivo</code>. Variable Bool<br>
    * Comments: Indica que es el estado correspondiente con beneficiario activo. Por tanto en una inclusión si está como usuario registrado en este estado, no se podrá volver a añadir. <br>
    * @param estadoBeneficiarioEsActivo The new value of the <code>estadoBeneficiarioEsActivo</code> attribute.
    */
    public void setEstadoBeneficiarioEsActivo (Boolean estadoBeneficiarioEsActivo) {
        modifiedEstadoBeneficiarioEsActivo = true;
        this.estadoBeneficiarioEsActivo = estadoBeneficiarioEsActivo;
    }

   /**
    * Sets the value of the <code>modifiedEstadoBeneficiarioEsActivo</code> class property.<br>
    * @param modified The new value of the <code>modifiedEstadoBeneficiarioEsActivo</code>.
    */
    public void setModifiedEstadoBeneficiarioEsActivo(boolean modified) {
        this.modifiedEstadoBeneficiarioEsActivo = modified;
    }

   /**
    * Returns the value of the <code>estadoBeneficiarioConfirmado</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioConfirmado</code>. Variable Bool<br>
    * Comments: Indica que es el estado correspondiente con beneficiario INGRESADO o ELIMINADO. Esto es, que este beneficiario, si se ha hecho una inclusión, ya ha sido confirmado en el CORE. Desde la opción de envío de documentos sólo se podrán ver aquellas que tengan todos los usuarios en un estado que tenga esta marca a TRUE.<br>
    * @return The value of the <code>estadoBeneficiarioConfirmado</code> attribute.
    */

    public Boolean getEstadoBeneficiarioConfirmado()  {
    	Boolean value;
        value =  estadoBeneficiarioConfirmado;
        return value;
    }

   /**
    * Sets the value of the <code>estadoBeneficiarioConfirmado</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioConfirmado</code>. Variable Bool<br>
    * Comments: Indica que es el estado correspondiente con beneficiario INGRESADO o ELIMINADO. Esto es, que este beneficiario, si se ha hecho una inclusión, ya ha sido confirmado en el CORE. Desde la opción de envío de documentos sólo se podrán ver aquellas que tengan todos los usuarios en un estado que tenga esta marca a TRUE.<br>
    * @param estadoBeneficiarioConfirmado The new value of the <code>estadoBeneficiarioConfirmado</code> attribute.
    */
    public void setEstadoBeneficiarioConfirmado (Boolean estadoBeneficiarioConfirmado) {
        modifiedEstadoBeneficiarioConfirmado = true;
        this.estadoBeneficiarioConfirmado = estadoBeneficiarioConfirmado;
    }

   /**
    * Sets the value of the <code>modifiedEstadoBeneficiarioConfirmado</code> class property.<br>
    * @param modified The new value of the <code>modifiedEstadoBeneficiarioConfirmado</code>.
    */
    public void setModifiedEstadoBeneficiarioConfirmado(boolean modified) {
        this.modifiedEstadoBeneficiarioConfirmado = modified;
    }

   /**
    * Returns the value of the <code>estadoBeneficiarioEsError</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioEsError</code>. Variable Bool<br>
    * Comments: Indica que es el estado correspondiente con Error. <br>
    * @return The value of the <code>estadoBeneficiarioEsError</code> attribute.
    */

    public Boolean getEstadoBeneficiarioEsError()  {
    	Boolean value;
        value =  estadoBeneficiarioEsError;
        return value;
    }

   /**
    * Sets the value of the <code>estadoBeneficiarioEsError</code> attribute.<br>
    * Model Attribute: <code>estadoBeneficiarioEsError</code>. Variable Bool<br>
    * Comments: Indica que es el estado correspondiente con Error. <br>
    * @param estadoBeneficiarioEsError The new value of the <code>estadoBeneficiarioEsError</code> attribute.
    */
    public void setEstadoBeneficiarioEsError (Boolean estadoBeneficiarioEsError) {
        modifiedEstadoBeneficiarioEsError = true;
        this.estadoBeneficiarioEsError = estadoBeneficiarioEsError;
    }

   /**
    * Sets the value of the <code>modifiedEstadoBeneficiarioEsError</code> class property.<br>
    * @param modified The new value of the <code>modifiedEstadoBeneficiarioEsError</code>.
    */
    public void setModifiedEstadoBeneficiarioEsError(boolean modified) {
        this.modifiedEstadoBeneficiarioEsError = modified;
    }

    /**
     * Returns the instance of <code>Usuario</code> related through the <code>UsuarioS</code> role.
     * Model Relationship:
     * <code>[Usuario] UsuarioS 0:M  ------ 0:1  EstadoBeneficiario [EstadoBeneficiario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Usuario</code> related through the <code>UsuarioS</code> role.
     */
    @JsonIgnore
    public Collection <Usuario> getUsuarioS() {
        return usuarioS;
    }

   /**
    * Adds an instance of <code>Usuario</code> related through the <code>UsuarioS</code> role.
    * @param usuarioS The instance to add to the <code>UsuarioS</code> role.
    */
    public void add2UsuarioS(Usuario usuarioS) {
        this.getUsuarioS().add(usuarioS);
    }
    /**
     * Sets instances of <code>Usuario</code> related through the <code>UsuarioS</code> role.
     * @param usuarioS The new value for the <code>UsuarioS</code> role.
     */
    public void setUsuarioS(Collection < Usuario > usuarioS) {
        this.usuarioS = usuarioS;
    }

   /**
    * This method gets the attribute value <code>modifiedUsuarioS</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedUsuarioS</code> has been modified.
    */
    public boolean isModifiedUsuarioS(){
        return modifiedUsuarioS;
    }

    /**
     * Returns the instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     * Model Relationship:
     * <code>[BeneficiarioC] BeneficiariosC 0:M  ------ 0:1  EstadoBeneficiarioC [EstadoBeneficiario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     */
    @JsonIgnore
    public Collection <BeneficiarioC> getBeneficiariosC() {
        return beneficiariosC;
    }

   /**
    * Adds an instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
    * @param beneficiariosC The instance to add to the <code>BeneficiariosC</code> role.
    */
    public void add2BeneficiariosC(BeneficiarioC beneficiariosC) {
        this.getBeneficiariosC().add(beneficiariosC);
    }
    /**
     * Sets instances of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     * @param beneficiariosC The new value for the <code>BeneficiariosC</code> role.
     */
    public void setBeneficiariosC(Collection < BeneficiarioC > beneficiariosC) {
        this.beneficiariosC = beneficiariosC;
    }

   /**
    * This method gets the attribute value <code>modifiedBeneficiariosC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedBeneficiariosC</code> has been modified.
    */
    public boolean isModifiedBeneficiariosC(){
        return modifiedBeneficiariosC;
    }

    /**
     * Returns the instance of <code>UsuarioReg</code> related through the <code>UsuariosReg</code> role.
     * Model Relationship:
     * <code>[UsuarioReg] UsuariosReg 0:M  ------ 0:1  EstadoBeneficiario [EstadoBeneficiario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>UsuarioReg</code> related through the <code>UsuariosReg</code> role.
     */
    @JsonIgnore
    public Collection <UsuarioReg> getUsuariosReg() {
        return usuariosReg;
    }

   /**
    * Adds an instance of <code>UsuarioReg</code> related through the <code>UsuariosReg</code> role.
    * @param usuariosReg The instance to add to the <code>UsuariosReg</code> role.
    */
    public void add2UsuariosReg(UsuarioReg usuariosReg) {
        this.getUsuariosReg().add(usuariosReg);
    }
    /**
     * Sets instances of <code>UsuarioReg</code> related through the <code>UsuariosReg</code> role.
     * @param usuariosReg The new value for the <code>UsuariosReg</code> role.
     */
    public void setUsuariosReg(Collection < UsuarioReg > usuariosReg) {
        this.usuariosReg = usuariosReg;
    }

   /**
    * This method gets the attribute value <code>modifiedUsuariosReg</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedUsuariosReg</code> has been modified.
    */
    public boolean isModifiedUsuariosReg(){
        return modifiedUsuariosReg;
    }

    /**
     * Returns the instance of <code>UsuarioNovedad</code> related through the <code>UsuariosNovedad</code> role.
     * Model Relationship:
     * <code>[UsuarioNovedad] UsuariosNovedad 0:M  ------ 0:1  EstadoBeneficiario [EstadoBeneficiario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>UsuarioNovedad</code> related through the <code>UsuariosNovedad</code> role.
     */
    @JsonIgnore
    public Collection <UsuarioNovedad> getUsuariosNovedad() {
        return usuariosNovedad;
    }

   /**
    * Adds an instance of <code>UsuarioNovedad</code> related through the <code>UsuariosNovedad</code> role.
    * @param usuariosNovedad The instance to add to the <code>UsuariosNovedad</code> role.
    */
    public void add2UsuariosNovedad(UsuarioNovedad usuariosNovedad) {
        this.getUsuariosNovedad().add(usuariosNovedad);
    }
    /**
     * Sets instances of <code>UsuarioNovedad</code> related through the <code>UsuariosNovedad</code> role.
     * @param usuariosNovedad The new value for the <code>UsuariosNovedad</code> role.
     */
    public void setUsuariosNovedad(Collection < UsuarioNovedad > usuariosNovedad) {
        this.usuariosNovedad = usuariosNovedad;
    }

   /**
    * This method gets the attribute value <code>modifiedUsuariosNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedUsuariosNovedad</code> has been modified.
    */
    public boolean isModifiedUsuariosNovedad(){
        return modifiedUsuariosNovedad;
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
        estadoBeneficiarioDescripcion = "";
        estadoBeneficiarioEsActivo = false;
        estadoBeneficiarioConfirmado = false;
        estadoBeneficiarioEsError = false;
        usuarioS = null;
        beneficiariosC = null;
        usuariosReg = null;
        usuariosNovedad = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return EstadoBeneficiario.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return EstadoBeneficiarioConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedEstadoBeneficiarioDescripcion = false;
    	values.put("estadoBeneficiarioDescripcion", getEstadoBeneficiarioDescripcion());
    	modifiedEstadoBeneficiarioEsActivo = false;
    	values.put("estadoBeneficiarioEsActivo", getEstadoBeneficiarioEsActivo());
    	modifiedEstadoBeneficiarioConfirmado = false;
    	values.put("estadoBeneficiarioConfirmado", getEstadoBeneficiarioConfirmado());
    	modifiedEstadoBeneficiarioEsError = false;
    	values.put("estadoBeneficiarioEsError", getEstadoBeneficiarioEsError());
    	modifiedUsuarioS = false;
    	modifiedBeneficiariosC = false;
    	modifiedUsuariosReg = false;
    	modifiedUsuariosNovedad = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>EstadoBeneficiarioOid</code> object that identifies this instance of <code>EstadoBeneficiario</code>.
     * @return <code>EstadoBeneficiarioOid </code> object that identifies this instance of <code>EstadoBeneficiario</code>
     */
    public EstadoBeneficiarioOid getOid() {
        return new EstadoBeneficiarioOid(getEstadoBeneficiarioCodigo());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(EstadoBeneficiarioConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.ESTADOBENEFICIARIO)) {
            // Add this class
            activeFacets.add(Constants.ESTADOBENEFICIARIO);
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
