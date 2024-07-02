package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.AnexoMatConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.PeriodicidadConstants;
import com.keralty.usuarios.global.UsuarioConstants;
import com.keralty.usuarios.persistence.oid.AnexoMatOid;
import com.keralty.usuarios.persistence.oid.UsuarioOid;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>AnexoMat</code> model class.
 * <p>
 * Model Class: <code>AnexoMat</code><br>
 */
@Entity(name = AnexoMatConstants.CLASS_NAME)
@Table(name = AnexoMatConstants.TBL_NAME)
public class AnexoMat extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = AnexoMatConstants.FLD_ANEXOMATIDENTIFICADOR )
    @JsonProperty(value="identificador")
    private Long anexoMatIdentificador;

    /** Class member attribute. */
    @Column(name = AnexoMatConstants.FLD_ANEXOMATFECHAULTREGLA )
    @JsonProperty(value="fechaultregla")
    private Date anexoMatFechaUltRegla;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAnexoMatFechaUltRegla;

    /** Class member attribute. */
    @Column(name = AnexoMatConstants.FLD_ANEXOMATNUMCUOTAS )
    @JsonProperty(value="numcuotas")
    private Long anexoMatNumCuotas;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAnexoMatNumCuotas;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalor")
    protected Double anexoMatdrvValor;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=AnexoMatConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=UsuarioConstants.FLD_AESOLICITUDESIDSOLICITUD), 
        @JoinColumn(name=AnexoMatConstants.FLD_USUARIOUSUARIOIDENTIFICADOR, referencedColumnName=UsuarioConstants.FLD_USUARIOIDENTIFICADOR)
    })
    @JsonIgnore
    private Usuario usuario;
    /** Related attribute. */
    @Column(name = AnexoMatConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false)
    private Long aESOLICITUDESIDSOLICITUD;
    /** Related attribute. */
    @Column(name = AnexoMatConstants.FLD_USUARIOUSUARIOIDENTIFICADOR, insertable = false, updatable = false)
    private Long usuarioUsuarioIdentificador;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuario;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=AnexoMatConstants.FLD_PERIODICIDADCODIGO, referencedColumnName=PeriodicidadConstants.FLD_PERIODICIDADCODIGO)
    })
    @JsonIgnore
    private Periodicidad periodicidad;
    /** Related attribute. */
    @Column(name = AnexoMatConstants.FLD_PERIODICIDADCODIGO, insertable = false, updatable = false)
    private Long periodicidadCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPeriodicidad;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public AnexoMat() {
        anexoMatIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>AnexoMat</code>.
     * @param oid Object Identifier of the instance of <code>AnexoMat</code> to be created.
     * @throws SystemException
     */
    public AnexoMat(AnexoMatOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            anexoMatIdentificador = oid.getAnexoMatIdentificador();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>anexoMatIdentificador</code> attribute<br>in class <code>AnexoMat</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AnexoMat</code>
     * @return The value of the <code>anexoMatIdentificador</code> attribute<br>in class <code>AnexoMat</code>.
     */
    public Long getAnexoMatIdentificador() {
        return anexoMatIdentificador;
    }

    /**
     * Sets the value of the <code>anexoMatIdentificador</code> attribute<br>in class <code>AnexoMat</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AnexoMat</code>
     * @param anexoMatIdentificador The new value of the <code>anexoMatIdentificador</code> attribute<br>in class <code>AnexoMat</code>.
     */
    public void setAnexoMatIdentificador(Long anexoMatIdentificador) {
        this.anexoMatIdentificador = anexoMatIdentificador;
    }

   /**
    * Returns the value of the <code>anexoMatFechaUltRegla</code> attribute.<br>
    * Model Attribute: <code>anexoMatFechaUltRegla</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>anexoMatFechaUltRegla</code> attribute.
    */

    public Date getAnexoMatFechaUltRegla()  {
    	Date value;
        value =  anexoMatFechaUltRegla;
        return value;
    }

   /**
    * Sets the value of the <code>anexoMatFechaUltRegla</code> attribute.<br>
    * Model Attribute: <code>anexoMatFechaUltRegla</code>. Variable Date<br>
    * Comments: <br>
    * @param anexoMatFechaUltRegla The new value of the <code>anexoMatFechaUltRegla</code> attribute.
    */
    public void setAnexoMatFechaUltRegla (Date anexoMatFechaUltRegla) {
        modifiedAnexoMatFechaUltRegla = true;
        this.anexoMatFechaUltRegla = anexoMatFechaUltRegla;
    }

   /**
    * Sets the value of the <code>modifiedAnexoMatFechaUltRegla</code> class property.<br>
    * @param modified The new value of the <code>modifiedAnexoMatFechaUltRegla</code>.
    */
    public void setModifiedAnexoMatFechaUltRegla(boolean modified) {
        this.modifiedAnexoMatFechaUltRegla = modified;
    }

   /**
    * Returns the value of the <code>anexoMatNumCuotas</code> attribute.<br>
    * Model Attribute: <code>anexoMatNumCuotas</code>. Variable Nat<br>
    * Comments: Sólo podrá tener hasta 4<br>
    * @return The value of the <code>anexoMatNumCuotas</code> attribute.
    */

    public Long getAnexoMatNumCuotas()  {
    	Long value;
        value =  anexoMatNumCuotas;
        return value;
    }

   /**
    * Sets the value of the <code>anexoMatNumCuotas</code> attribute.<br>
    * Model Attribute: <code>anexoMatNumCuotas</code>. Variable Nat<br>
    * Comments: Sólo podrá tener hasta 4<br>
    * @param anexoMatNumCuotas The new value of the <code>anexoMatNumCuotas</code> attribute.
    */
    public void setAnexoMatNumCuotas (Long anexoMatNumCuotas) {
        modifiedAnexoMatNumCuotas = true;
        this.anexoMatNumCuotas = anexoMatNumCuotas;
    }

   /**
    * Sets the value of the <code>modifiedAnexoMatNumCuotas</code> class property.<br>
    * @param modified The new value of the <code>modifiedAnexoMatNumCuotas</code>.
    */
    public void setModifiedAnexoMatNumCuotas(boolean modified) {
        this.modifiedAnexoMatNumCuotas = modified;
    }

   /**
    * Returns the value of the <code>anexoMatdrvValor</code> attribute.<br>
    * Model Attribute: <code>anexoMatdrvValor</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>anexoMatdrvValor</code> attribute.
    */

    public Double getAnexoMatdrvValor()  {
    	Double value;
        try {
            value = anexoMatdrvValorDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: AnexoMat, Attribute: anexoMatdrvValor");
        }
        return value;
    }

    /**
     * Returns the instance of <code>Usuario</code> related through the <code>Usuario</code> role.
     * Model Relationship:
     * <code>[Usuario] Usuario 1:1  ------ 0:1  AnexoMat [AnexoMat]</code>
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
     * Returns the instance of <code>Periodicidad</code> related through the <code>Periodicidad</code> role.
     * Model Relationship:
     * <code>[Periodicidad] Periodicidad 1:1  ------ 0:M  AnexosMat [AnexoMat]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Periodicidad</code> related through the <code>Periodicidad</code> role.
     */
    @JsonIgnore
    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

   /**
    * Adds an instance of <code>Periodicidad</code> related through the <code>Periodicidad</code> role.
    * @param periodicidad The instance to add to the <code>Periodicidad</code> role.
    */
    public void add2Periodicidad(Periodicidad periodicidad) {
        if (periodicidad == null || periodicidad.isNull()) {
            this.modifiedPeriodicidad = true;
            this.periodicidadCodigo = null;
        } else {
            this.periodicidadCodigo = periodicidad.getPeriodicidadCodigo();
        }
        this.periodicidad = (periodicidad == null  || periodicidad.isNull() ? null : periodicidad);
    }

   /**
    * This method gets the attribute value <code>modifiedPeriodicidad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPeriodicidad</code> has been modified.
    */
    public boolean isModifiedPeriodicidad(){
        return modifiedPeriodicidad;
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
     * Returns the value of the <code>anexoMatdrvValor</code> derived attribute.
     *
     * @return Value of the <code>anexoMatdrvValor</code> derived attribute.
     */
    public Double anexoMatdrvValorDerivations() {
        return anexoMatdrvValor;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        anexoMatFechaUltRegla = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        anexoMatNumCuotas = Long.valueOf(0);
        usuario = null;
        periodicidad = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return AnexoMat.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return AnexoMatConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedAnexoMatFechaUltRegla = false;
    	values.put("anexoMatFechaUltRegla", getAnexoMatFechaUltRegla());
    	modifiedAnexoMatNumCuotas = false;
    	values.put("anexoMatNumCuotas", getAnexoMatNumCuotas());
    	modifiedUsuario = false;
    	modifiedPeriodicidad = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            anexoMatdrvValor = null;
    }

    /**
     * Returns the <code>AnexoMatOid</code> object that identifies this instance of <code>AnexoMat</code>.
     * @return <code>AnexoMatOid </code> object that identifies this instance of <code>AnexoMat</code>
     */
    public AnexoMatOid getOid() {
        return new AnexoMatOid(getAnexoMatIdentificador());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(AnexoMatConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(AnexoMatConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.ANEXOMAT)) {
            // Add this class
            activeFacets.add(Constants.ANEXOMAT);
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
