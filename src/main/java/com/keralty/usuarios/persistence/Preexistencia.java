package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.PreexistenciaConstants;
import com.keralty.usuarios.global.UsuarioConstants;
import com.keralty.usuarios.persistence.oid.PreexistenciaOid;
import com.keralty.usuarios.persistence.oid.UsuarioOid;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>Preexistencia</code> model class.
 * <p>
 * Model Class: <code>Preexistencia</code><br>
 */
@Entity(name = PreexistenciaConstants.CLASS_NAME)
@Table(name = PreexistenciaConstants.TBL_NAME)
public class Preexistencia extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Embedded Class Identification Function */
    @EmbeddedId
    private PreexistenciaOid oid;

    /** Class identification function. */
    @Column(name = PreexistenciaConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false )
    @JsonProperty(value="id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;

    /** Class identification function. */
    @Column(name = PreexistenciaConstants.FLD_USUARIOUSUARIOIDENTIFICADOR, insertable = false, updatable = false )
    @JsonProperty(value="usuario_identificador")
    private Long usuarioUsuarioIdentificador;

    /** Class identification function. */
    @Column(name = PreexistenciaConstants.FLD_PREEXISTENCIAIDENTIFICADOR, insertable = false, updatable = false )
    @JsonProperty(value="identificador")
    private Long preexistenciaIdentificador;

    /** Class member attribute. */
    @Column(name = PreexistenciaConstants.FLD_PREEXISTENCIADESCRIPCION )
    @JsonProperty(value="descripcion")
    private String preexistenciaDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPreexistenciaDescripcion;

    /** Class member attribute. */
    @Column(name = PreexistenciaConstants.FLD_PREEXISTENCIAFECINICIO )
    @JsonProperty(value="fecinicio")
    private Date preexistenciaFecInicio;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPreexistenciaFecInicio;

    /** Class member attribute. */
    @Column(name = PreexistenciaConstants.FLD_PREEXISTENCIAFECFIN )
    @JsonProperty(value="fecfin")
    private Date preexistenciaFecFin;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPreexistenciaFecFin;

    /** Class member attribute. */
    @Column(name = PreexistenciaConstants.FLD_PREEXISTENCIAOBSERVACION )
    @JsonProperty(value="observacion")
    private String preexistenciaObservacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPreexistenciaObservacion;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PreexistenciaConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=UsuarioConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false), 
        @JoinColumn(name=PreexistenciaConstants.FLD_USUARIOUSUARIOIDENTIFICADOR, referencedColumnName=UsuarioConstants.FLD_USUARIOIDENTIFICADOR, insertable = false, updatable = false)
    })
    @JsonIgnore
    private Usuario usuario;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuario;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Preexistencia() {
        aESOLICITUDESIDSOLICITUD = null;
        usuarioUsuarioIdentificador = null;
        preexistenciaIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Preexistencia</code>.
     * @param oid Object Identifier of the instance of <code>Preexistencia</code> to be created.
     * @throws SystemException
     */
    public Preexistencia(PreexistenciaOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            aESOLICITUDESIDSOLICITUD = oid.getAESOLICITUDESIDSOLICITUD();
            usuarioUsuarioIdentificador = oid.getUsuarioUsuarioIdentificador();
            preexistenciaIdentificador = oid.getPreexistenciaIdentificador();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Usuario.Solicitud.AE_SOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @return The value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Usuario.Solicitud.AE_SOLICITUDES</code>.
     */
    public Long getAESOLICITUDESIDSOLICITUD() {
        return (usuario != null ? usuario.getAESOLICITUDESIDSOLICITUD() : aESOLICITUDESIDSOLICITUD);
    }

    /**
     * Sets the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Usuario.Solicitud.AE_SOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @param aESOLICITUDESIDSOLICITUD The new value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Usuario.Solicitud.AE_SOLICITUDES</code>.
     */
    public void setAESOLICITUDESIDSOLICITUD(Long aESOLICITUDESIDSOLICITUD) {
        this.aESOLICITUDESIDSOLICITUD = aESOLICITUDESIDSOLICITUD;
    }

    /**
     * Returns the value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code> through <code>Usuario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Usuario</code>
     * @return The value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code> through <code>Usuario</code>.
     */
    public Long getUsuarioUsuarioIdentificador() {
        return (usuario != null ? usuario.getUsuarioIdentificador() : usuarioUsuarioIdentificador);
    }

    /**
     * Sets the value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code> through <code>Usuario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Usuario</code>
     * @param usuarioUsuarioIdentificador The new value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code> through <code>Usuario</code>.
     */
    public void setUsuarioUsuarioIdentificador(Long usuarioUsuarioIdentificador) {
        this.usuarioUsuarioIdentificador = usuarioUsuarioIdentificador;
    }

    /**
     * Returns the value of the <code>preexistenciaIdentificador</code> attribute<br>in class <code>Preexistencia</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Preexistencia</code>
     * @return The value of the <code>preexistenciaIdentificador</code> attribute<br>in class <code>Preexistencia</code>.
     */
    public Long getPreexistenciaIdentificador() {
        return preexistenciaIdentificador;
    }

    /**
     * Sets the value of the <code>preexistenciaIdentificador</code> attribute<br>in class <code>Preexistencia</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Preexistencia</code>
     * @param preexistenciaIdentificador The new value of the <code>preexistenciaIdentificador</code> attribute<br>in class <code>Preexistencia</code>.
     */
    public void setPreexistenciaIdentificador(Long preexistenciaIdentificador) {
        this.preexistenciaIdentificador = preexistenciaIdentificador;
    }

   /**
    * Returns the value of the <code>preexistenciaDescripcion</code> attribute.<br>
    * Model Attribute: <code>preexistenciaDescripcion</code>. Constant String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>preexistenciaDescripcion</code> attribute.
    */

    public String getPreexistenciaDescripcion()  {
    	String value;
        value =  preexistenciaDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>preexistenciaDescripcion</code> attribute.<br>
    * Model Attribute: <code>preexistenciaDescripcion</code>. Constant String Size=200<br>
    * Comments: <br>
    * @param preexistenciaDescripcion The new value of the <code>preexistenciaDescripcion</code> attribute.
    */
    public void setPreexistenciaDescripcion (String preexistenciaDescripcion) {
        modifiedPreexistenciaDescripcion = true;
        this.preexistenciaDescripcion = preexistenciaDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedPreexistenciaDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedPreexistenciaDescripcion</code>.
    */
    public void setModifiedPreexistenciaDescripcion(boolean modified) {
        this.modifiedPreexistenciaDescripcion = modified;
    }

   /**
    * Returns the value of the <code>preexistenciaFecInicio</code> attribute.<br>
    * Model Attribute: <code>preexistenciaFecInicio</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>preexistenciaFecInicio</code> attribute.
    */

    public Date getPreexistenciaFecInicio()  {
    	Date value;
        value =  preexistenciaFecInicio;
        return value;
    }

   /**
    * Sets the value of the <code>preexistenciaFecInicio</code> attribute.<br>
    * Model Attribute: <code>preexistenciaFecInicio</code>. Constant Date<br>
    * Comments: <br>
    * @param preexistenciaFecInicio The new value of the <code>preexistenciaFecInicio</code> attribute.
    */
    public void setPreexistenciaFecInicio (Date preexistenciaFecInicio) {
        modifiedPreexistenciaFecInicio = true;
        this.preexistenciaFecInicio = preexistenciaFecInicio;
    }

   /**
    * Sets the value of the <code>modifiedPreexistenciaFecInicio</code> class property.<br>
    * @param modified The new value of the <code>modifiedPreexistenciaFecInicio</code>.
    */
    public void setModifiedPreexistenciaFecInicio(boolean modified) {
        this.modifiedPreexistenciaFecInicio = modified;
    }

   /**
    * Returns the value of the <code>preexistenciaFecFin</code> attribute.<br>
    * Model Attribute: <code>preexistenciaFecFin</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>preexistenciaFecFin</code> attribute.
    */

    public Date getPreexistenciaFecFin()  {
    	Date value;
        value =  preexistenciaFecFin;
        return value;
    }

   /**
    * Sets the value of the <code>preexistenciaFecFin</code> attribute.<br>
    * Model Attribute: <code>preexistenciaFecFin</code>. Constant Date<br>
    * Comments: <br>
    * @param preexistenciaFecFin The new value of the <code>preexistenciaFecFin</code> attribute.
    */
    public void setPreexistenciaFecFin (Date preexistenciaFecFin) {
        modifiedPreexistenciaFecFin = true;
        this.preexistenciaFecFin = preexistenciaFecFin;
    }

   /**
    * Sets the value of the <code>modifiedPreexistenciaFecFin</code> class property.<br>
    * @param modified The new value of the <code>modifiedPreexistenciaFecFin</code>.
    */
    public void setModifiedPreexistenciaFecFin(boolean modified) {
        this.modifiedPreexistenciaFecFin = modified;
    }

   /**
    * Returns the value of the <code>preexistenciaObservacion</code> attribute.<br>
    * Model Attribute: <code>preexistenciaObservacion</code>. Constant String Size=500<br>
    * Comments: <br>
    * @return The value of the <code>preexistenciaObservacion</code> attribute.
    */

    public String getPreexistenciaObservacion()  {
    	String value;
        value =  preexistenciaObservacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>preexistenciaObservacion</code> attribute.<br>
    * Model Attribute: <code>preexistenciaObservacion</code>. Constant String Size=500<br>
    * Comments: <br>
    * @param preexistenciaObservacion The new value of the <code>preexistenciaObservacion</code> attribute.
    */
    public void setPreexistenciaObservacion (String preexistenciaObservacion) {
        modifiedPreexistenciaObservacion = true;
        this.preexistenciaObservacion = preexistenciaObservacion;
    }

   /**
    * Sets the value of the <code>modifiedPreexistenciaObservacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedPreexistenciaObservacion</code>.
    */
    public void setModifiedPreexistenciaObservacion(boolean modified) {
        this.modifiedPreexistenciaObservacion = modified;
    }

    /**
     * Returns the instance of <code>Usuario</code> related through the <code>Usuario</code> role.
     * Model Relationship:
     * <code>[Usuario] Usuario 1:1  ------ 0:M  Preexistencias [Preexistencia]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Usuario</code> related through the <code>Usuario</code> role.
     */
    @JsonIgnore
    public Usuario getUsuario() {
        return usuario;
    }

   /**
    * Adds an instance of <code>Usuario</code> related through the <code>Usuario</code> role.
    * @param usuario The instance to add to the <code>Usuario</code> role.
    */
    public void add2Usuario(Usuario usuario) {
        if (usuario == null || usuario.isNull()) {
            this.modifiedUsuario = true;
            this.aESOLICITUDESIDSOLICITUD = null;
            this.usuarioUsuarioIdentificador = null;
        } else {
            this.aESOLICITUDESIDSOLICITUD = usuario.getAESOLICITUDESIDSOLICITUD();
            this.usuarioUsuarioIdentificador = usuario.getUsuarioIdentificador();
        }
        this.usuario = (usuario == null  || usuario.isNull() ? null : usuario);
    }

   /**
    * This method gets the attribute value <code>modifiedUsuario</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedUsuario</code> has been modified.
    */
    public boolean isModifiedUsuario(){
        return modifiedUsuario;
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
        preexistenciaDescripcion = "";
        preexistenciaFecInicio = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        preexistenciaFecFin = null;
        preexistenciaObservacion = null;
        usuario = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Preexistencia.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return PreexistenciaConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedPreexistenciaDescripcion = false;
    	values.put("preexistenciaDescripcion", getPreexistenciaDescripcion());
    	modifiedPreexistenciaFecInicio = false;
    	values.put("preexistenciaFecInicio", getPreexistenciaFecInicio());
    	modifiedPreexistenciaFecFin = false;
    	values.put("preexistenciaFecFin", getPreexistenciaFecFin());
    	modifiedPreexistenciaObservacion = false;
    	values.put("preexistenciaObservacion", getPreexistenciaObservacion());
    	modifiedUsuario = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>PreexistenciaOid</code> object that identifies this instance of <code>Preexistencia</code>.
     * @return <code>PreexistenciaOid </code> object that identifies this instance of <code>Preexistencia</code>
     */
    public PreexistenciaOid getOid() {
        return new PreexistenciaOid(getAESOLICITUDESIDSOLICITUD(), getUsuarioUsuarioIdentificador(), getPreexistenciaIdentificador());
    }

    /**
     * Sets the <code>PreexistenciaOid</code> object that identifies this instance of <code>Preexistencia</code>.
     */    
    public void setOid(PreexistenciaOid oid) {
        this.oid = oid;
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(PreexistenciaConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(PreexistenciaConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.PREEXISTENCIA)) {
            // Add this class
            activeFacets.add(Constants.PREEXISTENCIA);
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
