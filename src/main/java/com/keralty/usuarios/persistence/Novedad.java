package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.NovedadConstants;
import com.keralty.usuarios.global.TipoNovedadConstants;
import com.keralty.usuarios.persistence.oid.NovedadOid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
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
 * Persistent representation of the <code>Novedad</code> model class.
 * <p>
 * Model Class: <code>Novedad</code><br>
 */
@Entity(name = NovedadConstants.CLASS_NAME)
@Table(name = NovedadConstants.TBL_NAME)
public class Novedad extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = NovedadConstants.FLD_NOVEDADIDNOVEDAD )
    @JsonProperty(value="id_novedad")
    private Long novedadidNovedad;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADALIASNOVEDAD )
    @JsonProperty(value="aliasnovedad")
    private String novedadAliasNovedad;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadAliasNovedad;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADNOMBRE )
    @JsonProperty(value="nombre")
    private String novedadNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadNombre;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String novedadDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadDescripcion;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADCODIGOLEGAL )
    @JsonProperty(value="codigolegal")
    private String novedadCodigoLegal;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadCodigoLegal;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADREQDOCPERSONA )
    @JsonProperty(value="reqdocpersona")
    private Boolean novedadReqDocPersona;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadReqDocPersona;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADREQDOCSOLICITUD )
    @JsonProperty(value="reqdocsolicitud")
    private Boolean novedadReqDocSolicitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadReqDocSolicitud;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADVARIASFAMILIAS )
    @JsonProperty(value="variasfamilias")
    private Boolean novedadVariasFamilias;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadVariasFamilias;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienecausales")
    protected Boolean novedaddrvTieneCausales;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienecausasexcepcion")
    protected Boolean novedaddrvTieneCausasExcepcion;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADMINVALORMESES )
    @JsonProperty(value="minvalormeses")
    private Long novedadMinValorMeses;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadMinValorMeses;

    /** Class member attribute. */
    @Column(name = NovedadConstants.FLD_NOVEDADMAXVALORMESES )
    @JsonProperty(value="maxvalormeses")
    private Long novedadMaxValorMeses;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadMaxValorMeses;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtextomostrar")
    protected String novedadDrvTextoMostrar;

    /** Related Class. */
    @ManyToMany(mappedBy=NovedadConstants.ROLE_INVNAME_DOMINIOS)
    @JsonIgnore
    private Collection <Dominio> dominios;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominios;

    /** Related Class. */
    @OneToMany(mappedBy = NovedadConstants.ROLE_INVNAME_CAUSALES)
    @JsonIgnore
    private Collection <Causal> causales;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausales;

    /** Related Class. */
    @OneToMany(mappedBy = NovedadConstants.ROLE_INVNAME_SOLICITUDES)
    @JsonIgnore
    private Collection <SolicitudNovedad> solicitudes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudes;

    /** Related Class. */
    @OneToMany(mappedBy = NovedadConstants.ROLE_INVNAME_CAUSASEXCLUSION)
    @JsonIgnore
    private Collection <CausaExclusion> causasExclusion;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCausasExclusion;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=NovedadConstants.FLD_TIPONOVEDADTIPO, referencedColumnName=TipoNovedadConstants.FLD_TIPONOVEDADTIPO)
    })
    @JsonIgnore
    private TipoNovedad tipoNovedad;
    /** Related attribute. */
    @Column(name = NovedadConstants.FLD_TIPONOVEDADTIPO, insertable = false, updatable = false)
    private Long tipoNovedadTipo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoNovedad;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Novedad() {
        novedadidNovedad = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Novedad</code>.
     * @param oid Object Identifier of the instance of <code>Novedad</code> to be created.
     * @throws SystemException
     */
    public Novedad(NovedadOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            novedadidNovedad = oid.getNovedadidNovedad();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>novedadidNovedad</code> attribute<br>in class <code>Novedad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Novedad</code>
     * @return The value of the <code>novedadidNovedad</code> attribute<br>in class <code>Novedad</code>.
     */
    public Long getNovedadidNovedad() {
        return novedadidNovedad;
    }

    /**
     * Sets the value of the <code>novedadidNovedad</code> attribute<br>in class <code>Novedad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Novedad</code>
     * @param novedadidNovedad The new value of the <code>novedadidNovedad</code> attribute<br>in class <code>Novedad</code>.
     */
    public void setNovedadidNovedad(Long novedadidNovedad) {
        this.novedadidNovedad = novedadidNovedad;
    }

   /**
    * Returns the value of the <code>novedadAliasNovedad</code> attribute.<br>
    * Model Attribute: <code>novedadAliasNovedad</code>. Constant String Size=2<br>
    * Comments: <br>
    * @return The value of the <code>novedadAliasNovedad</code> attribute.
    */

    public String getNovedadAliasNovedad()  {
    	String value;
        value =  novedadAliasNovedad;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>novedadAliasNovedad</code> attribute.<br>
    * Model Attribute: <code>novedadAliasNovedad</code>. Constant String Size=2<br>
    * Comments: <br>
    * @param novedadAliasNovedad The new value of the <code>novedadAliasNovedad</code> attribute.
    */
    public void setNovedadAliasNovedad (String novedadAliasNovedad) {
        modifiedNovedadAliasNovedad = true;
        this.novedadAliasNovedad = novedadAliasNovedad;
    }

   /**
    * Sets the value of the <code>modifiedNovedadAliasNovedad</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadAliasNovedad</code>.
    */
    public void setModifiedNovedadAliasNovedad(boolean modified) {
        this.modifiedNovedadAliasNovedad = modified;
    }

   /**
    * Returns the value of the <code>novedadNombre</code> attribute.<br>
    * Model Attribute: <code>novedadNombre</code>. Variable String Size=50<br>
    * Comments: El nombre es el valor que se utilizará para mostrar al usuario de la aplicación cuando debe seleccionar o se muestre una novedad.<br>
    * @return The value of the <code>novedadNombre</code> attribute.
    */

    public String getNovedadNombre()  {
    	String value;
        value =  novedadNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>novedadNombre</code> attribute.<br>
    * Model Attribute: <code>novedadNombre</code>. Variable String Size=50<br>
    * Comments: El nombre es el valor que se utilizará para mostrar al usuario de la aplicación cuando debe seleccionar o se muestre una novedad.<br>
    * @param novedadNombre The new value of the <code>novedadNombre</code> attribute.
    */
    public void setNovedadNombre (String novedadNombre) {
        modifiedNovedadNombre = true;
        this.novedadNombre = novedadNombre;
    }

   /**
    * Sets the value of the <code>modifiedNovedadNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadNombre</code>.
    */
    public void setModifiedNovedadNombre(boolean modified) {
        this.modifiedNovedadNombre = modified;
    }

   /**
    * Returns the value of the <code>novedadDescripcion</code> attribute.<br>
    * Model Attribute: <code>novedadDescripcion</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>novedadDescripcion</code> attribute.
    */

    public String getNovedadDescripcion()  {
    	String value;
        value =  novedadDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>novedadDescripcion</code> attribute.<br>
    * Model Attribute: <code>novedadDescripcion</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param novedadDescripcion The new value of the <code>novedadDescripcion</code> attribute.
    */
    public void setNovedadDescripcion (String novedadDescripcion) {
        modifiedNovedadDescripcion = true;
        this.novedadDescripcion = novedadDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedNovedadDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadDescripcion</code>.
    */
    public void setModifiedNovedadDescripcion(boolean modified) {
        this.modifiedNovedadDescripcion = modified;
    }

   /**
    * Returns the value of the <code>novedadCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>novedadCodigoLegal</code>. Variable String Size=5<br>
    * Comments: Código legal que se utiliza para identificar el código asociado en BH<br>
    * @return The value of the <code>novedadCodigoLegal</code> attribute.
    */

    public String getNovedadCodigoLegal()  {
    	String value;
        value =  novedadCodigoLegal;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>novedadCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>novedadCodigoLegal</code>. Variable String Size=5<br>
    * Comments: Código legal que se utiliza para identificar el código asociado en BH<br>
    * @param novedadCodigoLegal The new value of the <code>novedadCodigoLegal</code> attribute.
    */
    public void setNovedadCodigoLegal (String novedadCodigoLegal) {
        modifiedNovedadCodigoLegal = true;
        this.novedadCodigoLegal = novedadCodigoLegal;
    }

   /**
    * Sets the value of the <code>modifiedNovedadCodigoLegal</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadCodigoLegal</code>.
    */
    public void setModifiedNovedadCodigoLegal(boolean modified) {
        this.modifiedNovedadCodigoLegal = modified;
    }

   /**
    * Returns the value of the <code>novedadReqDocPersona</code> attribute.<br>
    * Model Attribute: <code>novedadReqDocPersona</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental persona (identificación de la persona)
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>novedadReqDocPersona</code> attribute.
    */

    public Boolean getNovedadReqDocPersona()  {
    	Boolean value;
        value =  novedadReqDocPersona;
        return value;
    }

   /**
    * Sets the value of the <code>novedadReqDocPersona</code> attribute.<br>
    * Model Attribute: <code>novedadReqDocPersona</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental persona (identificación de la persona)
<Options>
RADIO=1;
</Options><br>
    * @param novedadReqDocPersona The new value of the <code>novedadReqDocPersona</code> attribute.
    */
    public void setNovedadReqDocPersona (Boolean novedadReqDocPersona) {
        modifiedNovedadReqDocPersona = true;
        this.novedadReqDocPersona = novedadReqDocPersona;
    }

   /**
    * Sets the value of the <code>modifiedNovedadReqDocPersona</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadReqDocPersona</code>.
    */
    public void setModifiedNovedadReqDocPersona(boolean modified) {
        this.modifiedNovedadReqDocPersona = modified;
    }

   /**
    * Returns the value of the <code>novedadReqDocSolicitud</code> attribute.<br>
    * Model Attribute: <code>novedadReqDocSolicitud</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental solicitud
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>novedadReqDocSolicitud</code> attribute.
    */

    public Boolean getNovedadReqDocSolicitud()  {
    	Boolean value;
        value =  novedadReqDocSolicitud;
        return value;
    }

   /**
    * Sets the value of the <code>novedadReqDocSolicitud</code> attribute.<br>
    * Model Attribute: <code>novedadReqDocSolicitud</code>. Variable Bool<br>
    * Comments: Una marca que indicará si esta novedad requiere de documentación adjunta asociada a la clase documental solicitud
<Options>
RADIO=1;
</Options><br>
    * @param novedadReqDocSolicitud The new value of the <code>novedadReqDocSolicitud</code> attribute.
    */
    public void setNovedadReqDocSolicitud (Boolean novedadReqDocSolicitud) {
        modifiedNovedadReqDocSolicitud = true;
        this.novedadReqDocSolicitud = novedadReqDocSolicitud;
    }

   /**
    * Sets the value of the <code>modifiedNovedadReqDocSolicitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadReqDocSolicitud</code>.
    */
    public void setModifiedNovedadReqDocSolicitud(boolean modified) {
        this.modifiedNovedadReqDocSolicitud = modified;
    }

   /**
    * Returns the value of the <code>novedadVariasFamilias</code> attribute.<br>
    * Model Attribute: <code>novedadVariasFamilias</code>. Variable Bool<br>
    * Comments: Una marca que indicará si la novedad permite grabar novedades para distintas familias en un mismo contrato. No aplica a novedades de tipo contrato
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>novedadVariasFamilias</code> attribute.
    */

    public Boolean getNovedadVariasFamilias()  {
    	Boolean value;
        value =  novedadVariasFamilias;
        return value;
    }

   /**
    * Sets the value of the <code>novedadVariasFamilias</code> attribute.<br>
    * Model Attribute: <code>novedadVariasFamilias</code>. Variable Bool<br>
    * Comments: Una marca que indicará si la novedad permite grabar novedades para distintas familias en un mismo contrato. No aplica a novedades de tipo contrato
<Options>
RADIO=1;
</Options><br>
    * @param novedadVariasFamilias The new value of the <code>novedadVariasFamilias</code> attribute.
    */
    public void setNovedadVariasFamilias (Boolean novedadVariasFamilias) {
        modifiedNovedadVariasFamilias = true;
        this.novedadVariasFamilias = novedadVariasFamilias;
    }

   /**
    * Sets the value of the <code>modifiedNovedadVariasFamilias</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadVariasFamilias</code>.
    */
    public void setModifiedNovedadVariasFamilias(boolean modified) {
        this.modifiedNovedadVariasFamilias = modified;
    }

   /**
    * Returns the value of the <code>novedaddrvTieneCausales</code> attribute.<br>
    * Model Attribute: <code>novedaddrvTieneCausales</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>novedaddrvTieneCausales</code> attribute.
    */

    public Boolean getNovedaddrvTieneCausales()  {
    	Boolean value;
        try {
            value = novedaddrvTieneCausalesDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Novedad, Attribute: novedaddrvTieneCausales");
        }
        return value;
    }

   /**
    * Returns the value of the <code>novedaddrvTieneCausasExcepcion</code> attribute.<br>
    * Model Attribute: <code>novedaddrvTieneCausasExcepcion</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>novedaddrvTieneCausasExcepcion</code> attribute.
    */

    public Boolean getNovedaddrvTieneCausasExcepcion()  {
    	Boolean value;
        try {
            value = novedaddrvTieneCausasExcepcionDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Novedad, Attribute: novedaddrvTieneCausasExcepcion");
        }
        return value;
    }

   /**
    * Returns the value of the <code>novedadMinValorMeses</code> attribute.<br>
    * Model Attribute: <code>novedadMinValorMeses</code>. Variable Nat<br>
    * Comments: Para contratos de tipo SC el número de meses mínimo a validar<br>
    * @return The value of the <code>novedadMinValorMeses</code> attribute.
    */

    public Long getNovedadMinValorMeses()  {
    	Long value;
        value =  novedadMinValorMeses;
        return value;
    }

   /**
    * Sets the value of the <code>novedadMinValorMeses</code> attribute.<br>
    * Model Attribute: <code>novedadMinValorMeses</code>. Variable Nat<br>
    * Comments: Para contratos de tipo SC el número de meses mínimo a validar<br>
    * @param novedadMinValorMeses The new value of the <code>novedadMinValorMeses</code> attribute.
    */
    public void setNovedadMinValorMeses (Long novedadMinValorMeses) {
        modifiedNovedadMinValorMeses = true;
        this.novedadMinValorMeses = novedadMinValorMeses;
    }

   /**
    * Sets the value of the <code>modifiedNovedadMinValorMeses</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadMinValorMeses</code>.
    */
    public void setModifiedNovedadMinValorMeses(boolean modified) {
        this.modifiedNovedadMinValorMeses = modified;
    }

   /**
    * Returns the value of the <code>novedadMaxValorMeses</code> attribute.<br>
    * Model Attribute: <code>novedadMaxValorMeses</code>. Variable Nat<br>
    * Comments: Para contratos de tipo SC el número de meses máximo a validar<br>
    * @return The value of the <code>novedadMaxValorMeses</code> attribute.
    */

    public Long getNovedadMaxValorMeses()  {
    	Long value;
        value =  novedadMaxValorMeses;
        return value;
    }

   /**
    * Sets the value of the <code>novedadMaxValorMeses</code> attribute.<br>
    * Model Attribute: <code>novedadMaxValorMeses</code>. Variable Nat<br>
    * Comments: Para contratos de tipo SC el número de meses máximo a validar<br>
    * @param novedadMaxValorMeses The new value of the <code>novedadMaxValorMeses</code> attribute.
    */
    public void setNovedadMaxValorMeses (Long novedadMaxValorMeses) {
        modifiedNovedadMaxValorMeses = true;
        this.novedadMaxValorMeses = novedadMaxValorMeses;
    }

   /**
    * Sets the value of the <code>modifiedNovedadMaxValorMeses</code> class property.<br>
    * @param modified The new value of the <code>modifiedNovedadMaxValorMeses</code>.
    */
    public void setModifiedNovedadMaxValorMeses(boolean modified) {
        this.modifiedNovedadMaxValorMeses = modified;
    }

   /**
    * Returns the value of the <code>novedadDrvTextoMostrar</code> attribute.<br>
    * Model Attribute: <code>novedadDrvTextoMostrar</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>novedadDrvTextoMostrar</code> attribute.
    */

    public String getNovedadDrvTextoMostrar()  {
    	String value;
        try {
            value = novedadDrvTextoMostrarDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Novedad, Attribute: novedadDrvTextoMostrar");
        }
        return (value == null ? null : value.trim());
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>Dominios</code> role.
     * Model Relationship:
     * <code>[Dominio] Dominios 0:M  ------ 0:M  Novedades [Novedad]</code>
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
     * Returns the instance of <code>Causal</code> related through the <code>Causales</code> role.
     * Model Relationship:
     * <code>[Causal] Causales 0:M  ------ 1:1  Novedad [Novedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Causal</code> related through the <code>Causales</code> role.
     */
    @JsonIgnore
    public Collection <Causal> getCausales() {
        return causales;
    }

   /**
    * Adds an instance of <code>Causal</code> related through the <code>Causales</code> role.
    * @param causales The instance to add to the <code>Causales</code> role.
    */
    public void add2Causales(Causal causales) {
        this.getCausales().add(causales);
    }
    /**
     * Sets instances of <code>Causal</code> related through the <code>Causales</code> role.
     * @param causales The new value for the <code>Causales</code> role.
     */
    public void setCausales(Collection < Causal > causales) {
        this.causales = causales;
    }

   /**
    * This method gets the attribute value <code>modifiedCausales</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedCausales</code> has been modified.
    */
    public boolean isModifiedCausales(){
        return modifiedCausales;
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] Solicitudes 0:M  ------ 1:1  Novedad [Novedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
     */
    @JsonIgnore
    public Collection <SolicitudNovedad> getSolicitudes() {
        return solicitudes;
    }

   /**
    * Adds an instance of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
    * @param solicitudes The instance to add to the <code>Solicitudes</code> role.
    */
    public void add2Solicitudes(SolicitudNovedad solicitudes) {
        this.getSolicitudes().add(solicitudes);
    }
    /**
     * Sets instances of <code>SolicitudNovedad</code> related through the <code>Solicitudes</code> role.
     * @param solicitudes The new value for the <code>Solicitudes</code> role.
     */
    public void setSolicitudes(Collection < SolicitudNovedad > solicitudes) {
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
     * Returns the instance of <code>CausaExclusion</code> related through the <code>CausasExclusion</code> role.
     * Model Relationship:
     * <code>[CausaExclusion] CausasExclusion 0:M  ------ 1:1  Novedad [Novedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>CausaExclusion</code> related through the <code>CausasExclusion</code> role.
     */
    @JsonIgnore
    public Collection <CausaExclusion> getCausasExclusion() {
        return causasExclusion;
    }

   /**
    * Adds an instance of <code>CausaExclusion</code> related through the <code>CausasExclusion</code> role.
    * @param causasExclusion The instance to add to the <code>CausasExclusion</code> role.
    */
    public void add2CausasExclusion(CausaExclusion causasExclusion) {
        this.getCausasExclusion().add(causasExclusion);
    }
    /**
     * Sets instances of <code>CausaExclusion</code> related through the <code>CausasExclusion</code> role.
     * @param causasExclusion The new value for the <code>CausasExclusion</code> role.
     */
    public void setCausasExclusion(Collection < CausaExclusion > causasExclusion) {
        this.causasExclusion = causasExclusion;
    }

   /**
    * This method gets the attribute value <code>modifiedCausasExclusion</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedCausasExclusion</code> has been modified.
    */
    public boolean isModifiedCausasExclusion(){
        return modifiedCausasExclusion;
    }

    /**
     * Returns the instance of <code>TipoNovedad</code> related through the <code>TipoNovedad</code> role.
     * Model Relationship:
     * <code>[TipoNovedad] TipoNovedad 1:1  ------ 0:M  Novedades [Novedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>TipoNovedad</code> related through the <code>TipoNovedad</code> role.
     */
    @JsonIgnore
    public TipoNovedad getTipoNovedad() {
        return tipoNovedad;
    }

   /**
    * Adds an instance of <code>TipoNovedad</code> related through the <code>TipoNovedad</code> role.
    * @param tipoNovedad The instance to add to the <code>TipoNovedad</code> role.
    */
    public void add2TipoNovedad(TipoNovedad tipoNovedad) {
        if (tipoNovedad == null || tipoNovedad.isNull()) {
            this.modifiedTipoNovedad = true;
            this.tipoNovedadTipo = null;
        } else {
            this.tipoNovedadTipo = tipoNovedad.getTipoNovedadTipo();
        }
        this.tipoNovedad = (tipoNovedad == null  || tipoNovedad.isNull() ? null : tipoNovedad);
    }

   /**
    * This method gets the attribute value <code>modifiedTipoNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTipoNovedad</code> has been modified.
    */
    public boolean isModifiedTipoNovedad(){
        return modifiedTipoNovedad;
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
     * Returns the value of the <code>novedaddrvTieneCausales</code> derived attribute.
     *
     * @return Value of the <code>novedaddrvTieneCausales</code> derived attribute.
     */
    public Boolean novedaddrvTieneCausalesDerivations() {
        return novedaddrvTieneCausales;
    }    

    /**
     * Returns the value of the <code>novedaddrvTieneCausasExcepcion</code> derived attribute.
     *
     * @return Value of the <code>novedaddrvTieneCausasExcepcion</code> derived attribute.
     */
    public Boolean novedaddrvTieneCausasExcepcionDerivations() {
        return novedaddrvTieneCausasExcepcion;
    }    

    /**
     * Returns the value of the <code>novedadDrvTextoMostrar</code> derived attribute.
     *
     * @return Value of the <code>novedadDrvTextoMostrar</code> derived attribute.
     */
    public String novedadDrvTextoMostrarDerivations() {
        return novedadDrvTextoMostrar;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        novedadAliasNovedad = "";
        novedadNombre = "";
        novedadDescripcion = "";
        novedadCodigoLegal = "";
        novedadReqDocPersona = false;
        novedadReqDocSolicitud = false;
        novedadVariasFamilias = false;
        novedadMinValorMeses = null;
        novedadMaxValorMeses = null;
        dominios = null;
        causales = null;
        solicitudes = null;
        causasExclusion = null;
        tipoNovedad = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Novedad.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return NovedadConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedNovedadAliasNovedad = false;
    	values.put("novedadAliasNovedad", getNovedadAliasNovedad());
    	modifiedNovedadNombre = false;
    	values.put("novedadNombre", getNovedadNombre());
    	modifiedNovedadDescripcion = false;
    	values.put("novedadDescripcion", getNovedadDescripcion());
    	modifiedNovedadCodigoLegal = false;
    	values.put("novedadCodigoLegal", getNovedadCodigoLegal());
    	modifiedNovedadReqDocPersona = false;
    	values.put("novedadReqDocPersona", getNovedadReqDocPersona());
    	modifiedNovedadReqDocSolicitud = false;
    	values.put("novedadReqDocSolicitud", getNovedadReqDocSolicitud());
    	modifiedNovedadVariasFamilias = false;
    	values.put("novedadVariasFamilias", getNovedadVariasFamilias());
    	modifiedNovedadMinValorMeses = false;
    	values.put("novedadMinValorMeses", getNovedadMinValorMeses());
    	modifiedNovedadMaxValorMeses = false;
    	values.put("novedadMaxValorMeses", getNovedadMaxValorMeses());
    	modifiedDominios = false;
    	modifiedCausales = false;
    	modifiedSolicitudes = false;
    	modifiedCausasExclusion = false;
    	modifiedTipoNovedad = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            novedaddrvTieneCausales = null;
            novedaddrvTieneCausasExcepcion = null;
            novedadDrvTextoMostrar = null;
    }

    /**
     * Returns the <code>NovedadOid</code> object that identifies this instance of <code>Novedad</code>.
     * @return <code>NovedadOid </code> object that identifies this instance of <code>Novedad</code>
     */
    public NovedadOid getOid() {
        return new NovedadOid(getNovedadidNovedad());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(NovedadConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(NovedadConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.NOVEDAD)) {
            // Add this class
            activeFacets.add(Constants.NOVEDAD);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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
