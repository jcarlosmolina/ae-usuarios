package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FamiliaNovedadConstants;
import com.keralty.aeusuarios.global.FirmaConstants;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.oid.FamiliaNovedadOid;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
 * Persistent representation of the <code>FamiliaNovedad</code> model class.
 * <p>
 * Model Class: <code>FamiliaNovedad</code><br>
 */
@Entity(name = FamiliaNovedadConstants.CLASS_NAME)
@Table(name = FamiliaNovedadConstants.TBL_NAME)
public class FamiliaNovedad extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private transient UserFunctions userFunctionsSrv;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADIDFAMILIANOVEDAD )
    @JsonProperty(value="id_familianovedad")
    private Long familiaNovedadidFamiliaNovedad;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADNUMFAMILIA )
    @JsonProperty(value="numfamilia")
    private Long familiaNovedadNumFamilia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadNumFamilia;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITNUMIDENTIFICACION )
    @JsonProperty(value="titnumidentificacion")
    private String familiaNovedadTitNumidentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitNumidentificacion;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITPRIMERNOMBRE )
    @JsonProperty(value="titprimernombre")
    private String familiaNovedadTitPrimerNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitPrimerNombre;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITSEGUNDONOMBRE )
    @JsonProperty(value="titsegundonombre")
    private String familiaNovedadTitSegundoNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitSegundoNombre;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITPRIMERAPELLIDO )
    @JsonProperty(value="titprimerapellido")
    private String familiaNovedadTitPrimerApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitPrimerApellido;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITSEGUNDOAPELLIDO )
    @JsonProperty(value="titsegundoapellido")
    private String familiaNovedadTitSegundoApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitSegundoApellido;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITRAZONSOCIAL )
    @JsonProperty(value="titrazonsocial")
    private String familiaNovedadTitRazonSocial;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitRazonSocial;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADTITTIENEBENEFICIOS )
    @JsonProperty(value="tittienebeneficios")
    private Boolean familiaNovedadTitTieneBeneficios;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadTitTieneBeneficios;

    /** Class member attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FAMILIANOVEDADFAMACTIVA )
    @JsonProperty(value="famactiva")
    private Boolean familiaNovedadFamActiva;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedadFamActiva;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtieneusuarioactivo")
    protected Boolean familiaNovedaddrvTieneUsuarioActivo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnumtitulares")
    protected Long familiaNovedaddrvNumTitulares;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienenuevotitular")
    protected Boolean familiaNovedaddrvTieneNuevoTitular;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="titdrvnombrecompleto")
    protected String familiaNovedadTitDrvNombreCompleto;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="titdrvidentificacion")
    protected String familiaNovedadTitDrvIdentificacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="titdrvnombreanterior")
    protected String familiaNovedadTitDrvNombreAnterior;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienenuevadir")
    protected Boolean familiaNovedadDrvTieneNuevaDir;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienefirmatit")
    protected Boolean familiaNovedadDrvTieneFirmaTit;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienefirmanuevotit")
    protected Boolean familiaNovedadDrvTieneFirmaNuevoTit;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalidarcp1")
    protected Boolean familiaNovedadDrvValidarCP1;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalidarct1")
    protected Boolean familiaNovedadDrvValidarCT1;

    /** Related Class. */
    @OneToMany(mappedBy = FamiliaNovedadConstants.ROLE_INVNAME_USUARIONOVEDAD)
    @JsonIgnore
    private Collection <UsuarioNovedad> usuarioNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedad;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = FamiliaNovedadConstants.ROLE_INVNAME_NOVEDADCT)
    @JsonIgnore
    private NovedadCT novedadCT;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadCT;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FamiliaNovedadConstants.FLD_SOLICITUDNOVEDADID, referencedColumnName=SolicitudNovedadConstants.FLD_SOLICITUDNOVEDADID)
    })
    @JsonIgnore
    private SolicitudNovedad solicitud;
    /** Related attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_SOLICITUDNOVEDADID, insertable = false, updatable = false)
    private Long solicitudNovedadId;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitud;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FamiliaNovedadConstants.FLD_TIPOIDENTIFICACIONCODIGO, referencedColumnName=TipoIdentificacionConstants.FLD_TIPOIDENTIFICACIONCODIGO)
    })
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacion;
    /** Related attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_TIPOIDENTIFICACIONCODIGO, insertable = false, updatable = false)
    private Long tipoIdentificacionCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoIdentificacion;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FamiliaNovedadConstants.FLD_FIRMAIDENTIFICADOR, referencedColumnName=FirmaConstants.FLD_FIRMAIDENTIFICADOR)
    })
    @JsonIgnore
    private Firma firma;
    /** Related attribute. */
    @Column(name = FamiliaNovedadConstants.FLD_FIRMAIDENTIFICADOR, insertable = false, updatable = false)
    private Long firmaIdentificador;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFirma;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public FamiliaNovedad() {
        familiaNovedadidFamiliaNovedad = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>FamiliaNovedad</code>.
     * @param oid Object Identifier of the instance of <code>FamiliaNovedad</code> to be created.
     * @throws SystemException
     */
    public FamiliaNovedad(FamiliaNovedadOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            familiaNovedadidFamiliaNovedad = oid.getFamiliaNovedadidFamiliaNovedad();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>familiaNovedadidFamiliaNovedad</code> attribute<br>in class <code>FamiliaNovedad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>FamiliaNovedad</code>
     * @return The value of the <code>familiaNovedadidFamiliaNovedad</code> attribute<br>in class <code>FamiliaNovedad</code>.
     */
    public Long getFamiliaNovedadidFamiliaNovedad() {
        return familiaNovedadidFamiliaNovedad;
    }

    /**
     * Sets the value of the <code>familiaNovedadidFamiliaNovedad</code> attribute<br>in class <code>FamiliaNovedad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>FamiliaNovedad</code>
     * @param familiaNovedadidFamiliaNovedad The new value of the <code>familiaNovedadidFamiliaNovedad</code> attribute<br>in class <code>FamiliaNovedad</code>.
     */
    public void setFamiliaNovedadidFamiliaNovedad(Long familiaNovedadidFamiliaNovedad) {
        this.familiaNovedadidFamiliaNovedad = familiaNovedadidFamiliaNovedad;
    }

   /**
    * Returns the value of the <code>familiaNovedadNumFamilia</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadNumFamilia</code>. Variable Nat<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadNumFamilia</code> attribute.
    */

    public Long getFamiliaNovedadNumFamilia()  {
    	Long value;
        value =  familiaNovedadNumFamilia;
        return value;
    }

   /**
    * Sets the value of the <code>familiaNovedadNumFamilia</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadNumFamilia</code>. Variable Nat<br>
    * Comments: <br>
    * @param familiaNovedadNumFamilia The new value of the <code>familiaNovedadNumFamilia</code> attribute.
    */
    public void setFamiliaNovedadNumFamilia (Long familiaNovedadNumFamilia) {
        modifiedFamiliaNovedadNumFamilia = true;
        this.familiaNovedadNumFamilia = familiaNovedadNumFamilia;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadNumFamilia</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadNumFamilia</code>.
    */
    public void setModifiedFamiliaNovedadNumFamilia(boolean modified) {
        this.modifiedFamiliaNovedadNumFamilia = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitNumidentificacion</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitNumidentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitNumidentificacion</code> attribute.
    */

    public String getFamiliaNovedadTitNumidentificacion()  {
    	String value;
        value =  familiaNovedadTitNumidentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>familiaNovedadTitNumidentificacion</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitNumidentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @param familiaNovedadTitNumidentificacion The new value of the <code>familiaNovedadTitNumidentificacion</code> attribute.
    */
    public void setFamiliaNovedadTitNumidentificacion (String familiaNovedadTitNumidentificacion) {
        modifiedFamiliaNovedadTitNumidentificacion = true;
        this.familiaNovedadTitNumidentificacion = familiaNovedadTitNumidentificacion;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitNumidentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitNumidentificacion</code>.
    */
    public void setModifiedFamiliaNovedadTitNumidentificacion(boolean modified) {
        this.modifiedFamiliaNovedadTitNumidentificacion = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitPrimerNombre</code> attribute.
    */

    public String getFamiliaNovedadTitPrimerNombre()  {
    	String value;
        value =  familiaNovedadTitPrimerNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>familiaNovedadTitPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param familiaNovedadTitPrimerNombre The new value of the <code>familiaNovedadTitPrimerNombre</code> attribute.
    */
    public void setFamiliaNovedadTitPrimerNombre (String familiaNovedadTitPrimerNombre) {
        modifiedFamiliaNovedadTitPrimerNombre = true;
        this.familiaNovedadTitPrimerNombre = familiaNovedadTitPrimerNombre;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitPrimerNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitPrimerNombre</code>.
    */
    public void setModifiedFamiliaNovedadTitPrimerNombre(boolean modified) {
        this.modifiedFamiliaNovedadTitPrimerNombre = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitSegundoNombre</code> attribute.
    */

    public String getFamiliaNovedadTitSegundoNombre()  {
    	String value;
        value =  familiaNovedadTitSegundoNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>familiaNovedadTitSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param familiaNovedadTitSegundoNombre The new value of the <code>familiaNovedadTitSegundoNombre</code> attribute.
    */
    public void setFamiliaNovedadTitSegundoNombre (String familiaNovedadTitSegundoNombre) {
        modifiedFamiliaNovedadTitSegundoNombre = true;
        this.familiaNovedadTitSegundoNombre = familiaNovedadTitSegundoNombre;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitSegundoNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitSegundoNombre</code>.
    */
    public void setModifiedFamiliaNovedadTitSegundoNombre(boolean modified) {
        this.modifiedFamiliaNovedadTitSegundoNombre = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitPrimerApellido</code> attribute.
    */

    public String getFamiliaNovedadTitPrimerApellido()  {
    	String value;
        value =  familiaNovedadTitPrimerApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>familiaNovedadTitPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param familiaNovedadTitPrimerApellido The new value of the <code>familiaNovedadTitPrimerApellido</code> attribute.
    */
    public void setFamiliaNovedadTitPrimerApellido (String familiaNovedadTitPrimerApellido) {
        modifiedFamiliaNovedadTitPrimerApellido = true;
        this.familiaNovedadTitPrimerApellido = familiaNovedadTitPrimerApellido;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitPrimerApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitPrimerApellido</code>.
    */
    public void setModifiedFamiliaNovedadTitPrimerApellido(boolean modified) {
        this.modifiedFamiliaNovedadTitPrimerApellido = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitSegundoApellido</code> attribute.
    */

    public String getFamiliaNovedadTitSegundoApellido()  {
    	String value;
        value =  familiaNovedadTitSegundoApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>familiaNovedadTitSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param familiaNovedadTitSegundoApellido The new value of the <code>familiaNovedadTitSegundoApellido</code> attribute.
    */
    public void setFamiliaNovedadTitSegundoApellido (String familiaNovedadTitSegundoApellido) {
        modifiedFamiliaNovedadTitSegundoApellido = true;
        this.familiaNovedadTitSegundoApellido = familiaNovedadTitSegundoApellido;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitSegundoApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitSegundoApellido</code>.
    */
    public void setModifiedFamiliaNovedadTitSegundoApellido(boolean modified) {
        this.modifiedFamiliaNovedadTitSegundoApellido = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitRazonSocial</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitRazonSocial</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitRazonSocial</code> attribute.
    */

    public String getFamiliaNovedadTitRazonSocial()  {
    	String value;
        value =  familiaNovedadTitRazonSocial;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>familiaNovedadTitRazonSocial</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitRazonSocial</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param familiaNovedadTitRazonSocial The new value of the <code>familiaNovedadTitRazonSocial</code> attribute.
    */
    public void setFamiliaNovedadTitRazonSocial (String familiaNovedadTitRazonSocial) {
        modifiedFamiliaNovedadTitRazonSocial = true;
        this.familiaNovedadTitRazonSocial = familiaNovedadTitRazonSocial;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitRazonSocial</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitRazonSocial</code>.
    */
    public void setModifiedFamiliaNovedadTitRazonSocial(boolean modified) {
        this.modifiedFamiliaNovedadTitRazonSocial = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitTieneBeneficios</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitTieneBeneficios</code>. Constant Bool<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitTieneBeneficios</code> attribute.
    */

    public Boolean getFamiliaNovedadTitTieneBeneficios()  {
    	Boolean value;
        value =  familiaNovedadTitTieneBeneficios;
        return value;
    }

   /**
    * Sets the value of the <code>familiaNovedadTitTieneBeneficios</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitTieneBeneficios</code>. Constant Bool<br>
    * Comments: <br>
    * @param familiaNovedadTitTieneBeneficios The new value of the <code>familiaNovedadTitTieneBeneficios</code> attribute.
    */
    public void setFamiliaNovedadTitTieneBeneficios (Boolean familiaNovedadTitTieneBeneficios) {
        modifiedFamiliaNovedadTitTieneBeneficios = true;
        this.familiaNovedadTitTieneBeneficios = familiaNovedadTitTieneBeneficios;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadTitTieneBeneficios</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadTitTieneBeneficios</code>.
    */
    public void setModifiedFamiliaNovedadTitTieneBeneficios(boolean modified) {
        this.modifiedFamiliaNovedadTitTieneBeneficios = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedadFamActiva</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadFamActiva</code>. Constant Bool<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadFamActiva</code> attribute.
    */

    public Boolean getFamiliaNovedadFamActiva()  {
    	Boolean value;
        value =  familiaNovedadFamActiva;
        return value;
    }

   /**
    * Sets the value of the <code>familiaNovedadFamActiva</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadFamActiva</code>. Constant Bool<br>
    * Comments: <br>
    * @param familiaNovedadFamActiva The new value of the <code>familiaNovedadFamActiva</code> attribute.
    */
    public void setFamiliaNovedadFamActiva (Boolean familiaNovedadFamActiva) {
        modifiedFamiliaNovedadFamActiva = true;
        this.familiaNovedadFamActiva = familiaNovedadFamActiva;
    }

   /**
    * Sets the value of the <code>modifiedFamiliaNovedadFamActiva</code> class property.<br>
    * @param modified The new value of the <code>modifiedFamiliaNovedadFamActiva</code>.
    */
    public void setModifiedFamiliaNovedadFamActiva(boolean modified) {
        this.modifiedFamiliaNovedadFamActiva = modified;
    }

   /**
    * Returns the value of the <code>familiaNovedaddrvTieneUsuarioActivo</code> attribute.<br>
    * Model Attribute: <code>familiaNovedaddrvTieneUsuarioActivo</code>. Variable Bool<br>
    * Comments: Indica que al menos un usuario de esta familia está activo<br>
    * @return The value of the <code>familiaNovedaddrvTieneUsuarioActivo</code> attribute.
    */

    public Boolean getFamiliaNovedaddrvTieneUsuarioActivo()  {
    	Boolean value;
        try {
            value = familiaNovedaddrvTieneUsuarioActivoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedaddrvTieneUsuarioActivo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedaddrvNumTitulares</code> attribute.<br>
    * Model Attribute: <code>familiaNovedaddrvNumTitulares</code>. Variable Int<br>
    * Comments: Indica el número de usuarios que son titulares en la familia<br>
    * @return The value of the <code>familiaNovedaddrvNumTitulares</code> attribute.
    */

    public Long getFamiliaNovedaddrvNumTitulares()  {
    	Long value;
        try {
            value = familiaNovedaddrvNumTitularesDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedaddrvNumTitulares");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedaddrvTieneNuevoTitular</code> attribute.<br>
    * Model Attribute: <code>familiaNovedaddrvTieneNuevoTitular</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedaddrvTieneNuevoTitular</code> attribute.
    */

    public Boolean getFamiliaNovedaddrvTieneNuevoTitular()  {
    	Boolean value;
        try {
            value = familiaNovedaddrvTieneNuevoTitularDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedaddrvTieneNuevoTitular");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedadTitDrvNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitDrvNombreCompleto</code>. Variable String Size=210<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitDrvNombreCompleto</code> attribute.
    */

    public String getFamiliaNovedadTitDrvNombreCompleto()  {
    	String value;
        try {
            value = familiaNovedadTitDrvNombreCompletoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadTitDrvNombreCompleto");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>familiaNovedadTitDrvIdentificacion</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitDrvIdentificacion</code>. Variable String Size=70<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitDrvIdentificacion</code> attribute.
    */

    public String getFamiliaNovedadTitDrvIdentificacion()  {
    	String value;
        try {
            value = familiaNovedadTitDrvIdentificacionDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadTitDrvIdentificacion");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>familiaNovedadTitDrvNombreAnterior</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadTitDrvNombreAnterior</code>. Variable String Size=210<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadTitDrvNombreAnterior</code> attribute.
    */

    public String getFamiliaNovedadTitDrvNombreAnterior()  {
    	String value;
        try {
            value = familiaNovedadTitDrvNombreAnteriorDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadTitDrvNombreAnterior");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>familiaNovedadDrvTieneNuevaDir</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadDrvTieneNuevaDir</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadDrvTieneNuevaDir</code> attribute.
    */

    public Boolean getFamiliaNovedadDrvTieneNuevaDir()  {
    	Boolean value;
        try {
            value = familiaNovedadDrvTieneNuevaDirDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadDrvTieneNuevaDir");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedadDrvTieneFirmaTit</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadDrvTieneFirmaTit</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadDrvTieneFirmaTit</code> attribute.
    */

    public Boolean getFamiliaNovedadDrvTieneFirmaTit()  {
    	Boolean value;
        try {
            value = familiaNovedadDrvTieneFirmaTitDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadDrvTieneFirmaTit");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedadDrvTieneFirmaNuevoTit</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadDrvTieneFirmaNuevoTit</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>familiaNovedadDrvTieneFirmaNuevoTit</code> attribute.
    */

    public Boolean getFamiliaNovedadDrvTieneFirmaNuevoTit()  {
    	Boolean value;
        try {
            value = familiaNovedadDrvTieneFirmaNuevoTitDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadDrvTieneFirmaNuevoTit");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedadDrvValidarCP1</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadDrvValidarCP1</code>. Variable Bool<br>
    * Comments: Validacion de Cambio de parentesco: "Los contratos con contratante Jurídico deben tener al menos un beneficiario con parentesco TITULAR activo"<br>
    * @return The value of the <code>familiaNovedadDrvValidarCP1</code> attribute.
    */

    public Boolean getFamiliaNovedadDrvValidarCP1()  {
    	Boolean value;
        try {
            value = familiaNovedadDrvValidarCP1Derivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadDrvValidarCP1");
        }
        return value;
    }

   /**
    * Returns the value of the <code>familiaNovedadDrvValidarCT1</code> attribute.<br>
    * Model Attribute: <code>familiaNovedadDrvValidarCT1</code>. Variable Bool<br>
    * Comments: Validacion de Cambio de Titular: ""El nuevo titular de la familia no puede ser persona jurídica""<br>
    * @return The value of the <code>familiaNovedadDrvValidarCT1</code> attribute.
    */

    public Boolean getFamiliaNovedadDrvValidarCT1()  {
    	Boolean value;
        try {
            value = familiaNovedadDrvValidarCT1Derivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: FamiliaNovedad, Attribute: familiaNovedadDrvValidarCT1");
        }
        return value;
    }

    /**
     * Returns the instance of <code>UsuarioNovedad</code> related through the <code>UsuarioNovedad</code> role.
     * Model Relationship:
     * <code>[UsuarioNovedad] UsuarioNovedad 0:M  ------ 1:1  FamiliaNovedad [FamiliaNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>UsuarioNovedad</code> related through the <code>UsuarioNovedad</code> role.
     */
    @JsonIgnore
    public Collection <UsuarioNovedad> getUsuarioNovedad() {
        return usuarioNovedad;
    }

   /**
    * Adds an instance of <code>UsuarioNovedad</code> related through the <code>UsuarioNovedad</code> role.
    * @param usuarioNovedad The instance to add to the <code>UsuarioNovedad</code> role.
    */
    public void add2UsuarioNovedad(UsuarioNovedad usuarioNovedad) {
        this.getUsuarioNovedad().add(usuarioNovedad);
    }
    /**
     * Sets instances of <code>UsuarioNovedad</code> related through the <code>UsuarioNovedad</code> role.
     * @param usuarioNovedad The new value for the <code>UsuarioNovedad</code> role.
     */
    public void setUsuarioNovedad(Collection < UsuarioNovedad > usuarioNovedad) {
        this.usuarioNovedad = usuarioNovedad;
    }

   /**
    * This method gets the attribute value <code>modifiedUsuarioNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedUsuarioNovedad</code> has been modified.
    */
    public boolean isModifiedUsuarioNovedad(){
        return modifiedUsuarioNovedad;
    }

    /**
     * Returns the instance of <code>NovedadCT</code> related through the <code>NovedadCT</code> role.
     * Model Relationship:
     * <code>[NovedadCT] NovedadCT 0:1  ------ 1:1  FamiliaNovedad [FamiliaNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>NovedadCT</code> related through the <code>NovedadCT</code> role.
     */
    @JsonIgnore
    public NovedadCT getNovedadCT() {
        return novedadCT;
    }

   /**
    * Adds an instance of <code>NovedadCT</code> related through the <code>NovedadCT</code> role.
    * @param novedadCT The instance to add to the <code>NovedadCT</code> role.
    */
    public void add2NovedadCT(NovedadCT novedadCT) {
        this.novedadCT = (novedadCT == null  || novedadCT.isNull() ? null : novedadCT);
    }

   /**
    * This method gets the attribute value <code>modifiedNovedadCT</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedNovedadCT</code> has been modified.
    */
    public boolean isModifiedNovedadCT(){
        return modifiedNovedadCT;
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] Solicitud 1:1  ------ 0:M  Familias [FamiliaNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>Solicitud</code> role.
     */
    @JsonIgnore
    public SolicitudNovedad getSolicitud() {
        return solicitud;
    }

   /**
    * Adds an instance of <code>SolicitudNovedad</code> related through the <code>Solicitud</code> role.
    * @param solicitud The instance to add to the <code>Solicitud</code> role.
    */
    public void add2Solicitud(SolicitudNovedad solicitud) {
        if (solicitud == null || solicitud.isNull()) {
            this.modifiedSolicitud = true;
            this.solicitudNovedadId = null;
        } else {
            this.solicitudNovedadId = solicitud.getSolicitudNovedadId();
        }
        this.solicitud = (solicitud == null  || solicitud.isNull() ? null : solicitud);
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitud</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitud</code> has been modified.
    */
    public boolean isModifiedSolicitud(){
        return modifiedSolicitud;
    }

    /**
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacion 0:1  ------ 0:M  FamiliasNovedad [FamiliaNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     */
    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

   /**
    * Adds an instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
    * @param tipoIdentificacion The instance to add to the <code>TipoIdentificacion</code> role.
    */
    public void add2TipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        if (tipoIdentificacion == null || tipoIdentificacion.isNull()) {
            this.modifiedTipoIdentificacion = true;
            this.tipoIdentificacionCodigo = null;
        } else {
            this.tipoIdentificacionCodigo = tipoIdentificacion.getTipoIdentificacionCodigo();
        }
        this.tipoIdentificacion = (tipoIdentificacion == null  || tipoIdentificacion.isNull() ? null : tipoIdentificacion);
    }

   /**
    * This method gets the attribute value <code>modifiedTipoIdentificacion</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTipoIdentificacion</code> has been modified.
    */
    public boolean isModifiedTipoIdentificacion(){
        return modifiedTipoIdentificacion;
    }

    /**
     * Returns the instance of <code>Firma</code> related through the <code>Firma</code> role.
     * Model Relationship:
     * <code>[Firma] Firma 0:1  ------ 0:1  FamiliaNovedad [FamiliaNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Firma</code> related through the <code>Firma</code> role.
     */
    @JsonIgnore
    public Firma getFirma() {
        return firma;
    }

   /**
    * Adds an instance of <code>Firma</code> related through the <code>Firma</code> role.
    * @param firma The instance to add to the <code>Firma</code> role.
    */
    public void add2Firma(Firma firma) {
        if (firma == null || firma.isNull()) {
            this.modifiedFirma = true;
            this.firmaIdentificador = null;
        } else {
            this.firmaIdentificador = firma.getFirmaIdentificador();
        }
        this.firma = (firma == null  || firma.isNull() ? null : firma);
    }

   /**
    * This method gets the attribute value <code>modifiedFirma</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFirma</code> has been modified.
    */
    public boolean isModifiedFirma(){
        return modifiedFirma;
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
     * Returns the value of the <code>familiaNovedaddrvTieneUsuarioActivo</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedaddrvTieneUsuarioActivo</code> derived attribute.
     */
    public Boolean familiaNovedaddrvTieneUsuarioActivoDerivations() {
        return familiaNovedaddrvTieneUsuarioActivo;
    }    

    /**
     * Returns the value of the <code>familiaNovedaddrvNumTitulares</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedaddrvNumTitulares</code> derived attribute.
     */
    public Long familiaNovedaddrvNumTitularesDerivations() {
        return familiaNovedaddrvNumTitulares;
    }    

    /**
     * Returns the value of the <code>familiaNovedaddrvTieneNuevoTitular</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedaddrvTieneNuevoTitular</code> derived attribute.
     */
    public Boolean familiaNovedaddrvTieneNuevoTitularDerivations() {
        return familiaNovedaddrvTieneNuevoTitular;
    }    

    /**
     * Returns the value of the <code>familiaNovedadTitDrvNombreCompleto</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadTitDrvNombreCompleto</code> derived attribute.
     */
    public String familiaNovedadTitDrvNombreCompletoDerivations() {
        return familiaNovedadTitDrvNombreCompleto;
    }    

    /**
     * Returns the value of the <code>familiaNovedadTitDrvIdentificacion</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadTitDrvIdentificacion</code> derived attribute.
     */
    public String familiaNovedadTitDrvIdentificacionDerivations() {
        return familiaNovedadTitDrvIdentificacion;
    }    

    /**
     * Returns the value of the <code>familiaNovedadTitDrvNombreAnterior</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadTitDrvNombreAnterior</code> derived attribute.
     */
    public String familiaNovedadTitDrvNombreAnteriorDerivations() {
        return familiaNovedadTitDrvNombreAnterior;
    }    

    /**
     * Returns the value of the <code>familiaNovedadDrvTieneNuevaDir</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadDrvTieneNuevaDir</code> derived attribute.
     */
    public Boolean familiaNovedadDrvTieneNuevaDirDerivations() {
        return familiaNovedadDrvTieneNuevaDir;
    }    

    /**
     * Returns the value of the <code>familiaNovedadDrvTieneFirmaTit</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadDrvTieneFirmaTit</code> derived attribute.
     */
    public Boolean familiaNovedadDrvTieneFirmaTitDerivations() {
        return familiaNovedadDrvTieneFirmaTit;
    }    

    /**
     * Returns the value of the <code>familiaNovedadDrvTieneFirmaNuevoTit</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadDrvTieneFirmaNuevoTit</code> derived attribute.
     */
    public Boolean familiaNovedadDrvTieneFirmaNuevoTitDerivations() {
        return familiaNovedadDrvTieneFirmaNuevoTit;
    }    

    /**
     * Returns the value of the <code>familiaNovedadDrvValidarCP1</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadDrvValidarCP1</code> derived attribute.
     */
    public Boolean familiaNovedadDrvValidarCP1Derivations() {
        return familiaNovedadDrvValidarCP1;
    }    

    /**
     * Returns the value of the <code>familiaNovedadDrvValidarCT1</code> derived attribute.
     *
     * @return Value of the <code>familiaNovedadDrvValidarCT1</code> derived attribute.
     */
    public Boolean familiaNovedadDrvValidarCT1Derivations() {
        return familiaNovedadDrvValidarCT1;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        familiaNovedadNumFamilia = Long.valueOf(0);
        familiaNovedadTitNumidentificacion = "";
        familiaNovedadTitPrimerNombre = null;
        familiaNovedadTitSegundoNombre = null;
        familiaNovedadTitPrimerApellido = null;
        familiaNovedadTitSegundoApellido = null;
        familiaNovedadTitRazonSocial = null;
        familiaNovedadTitTieneBeneficios = false;
        familiaNovedadFamActiva = false;
        usuarioNovedad = null;
        novedadCT = null;
        solicitud = null;
        tipoIdentificacion = null;
        firma = null;
        values = new HashMap<>();
        userFunctionsSrv = Arc.container().select(UserFunctions.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return FamiliaNovedad.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return FamiliaNovedadConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedFamiliaNovedadNumFamilia = false;
    	values.put("familiaNovedadNumFamilia", getFamiliaNovedadNumFamilia());
    	modifiedFamiliaNovedadTitNumidentificacion = false;
    	values.put("familiaNovedadTitNumidentificacion", getFamiliaNovedadTitNumidentificacion());
    	modifiedFamiliaNovedadTitPrimerNombre = false;
    	values.put("familiaNovedadTitPrimerNombre", getFamiliaNovedadTitPrimerNombre());
    	modifiedFamiliaNovedadTitSegundoNombre = false;
    	values.put("familiaNovedadTitSegundoNombre", getFamiliaNovedadTitSegundoNombre());
    	modifiedFamiliaNovedadTitPrimerApellido = false;
    	values.put("familiaNovedadTitPrimerApellido", getFamiliaNovedadTitPrimerApellido());
    	modifiedFamiliaNovedadTitSegundoApellido = false;
    	values.put("familiaNovedadTitSegundoApellido", getFamiliaNovedadTitSegundoApellido());
    	modifiedFamiliaNovedadTitRazonSocial = false;
    	values.put("familiaNovedadTitRazonSocial", getFamiliaNovedadTitRazonSocial());
    	modifiedFamiliaNovedadTitTieneBeneficios = false;
    	values.put("familiaNovedadTitTieneBeneficios", getFamiliaNovedadTitTieneBeneficios());
    	modifiedFamiliaNovedadFamActiva = false;
    	values.put("familiaNovedadFamActiva", getFamiliaNovedadFamActiva());
    	modifiedUsuarioNovedad = false;
    	modifiedNovedadCT = false;
    	modifiedSolicitud = false;
    	modifiedTipoIdentificacion = false;
    	modifiedFirma = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            familiaNovedaddrvTieneUsuarioActivo = null;
            familiaNovedaddrvNumTitulares = null;
            familiaNovedaddrvTieneNuevoTitular = null;
            familiaNovedadTitDrvNombreCompleto = null;
            familiaNovedadTitDrvIdentificacion = null;
            familiaNovedadTitDrvNombreAnterior = null;
            familiaNovedadDrvTieneNuevaDir = null;
            familiaNovedadDrvTieneFirmaTit = null;
            familiaNovedadDrvTieneFirmaNuevoTit = null;
            familiaNovedadDrvValidarCP1 = null;
            familiaNovedadDrvValidarCT1 = null;
    }

    /**
     * Returns the <code>FamiliaNovedadOid</code> object that identifies this instance of <code>FamiliaNovedad</code>.
     * @return <code>FamiliaNovedadOid </code> object that identifies this instance of <code>FamiliaNovedad</code>
     */
    public FamiliaNovedadOid getOid() {
        return new FamiliaNovedadOid(getFamiliaNovedadidFamiliaNovedad());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(FamiliaNovedadConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(FamiliaNovedadConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.FAMILIANOVEDAD)) {
            // Add this class
            activeFacets.add(Constants.FAMILIANOVEDAD);
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
