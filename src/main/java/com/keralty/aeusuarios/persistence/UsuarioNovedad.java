package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.global.FamiliaNovedadConstants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioNovedadConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioNovedadOid;
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
 * Persistent representation of the <code>UsuarioNovedad</code> model class.
 * <p>
 * Model Class: <code>UsuarioNovedad</code><br>
 */
@Entity(name = UsuarioNovedadConstants.CLASS_NAME)
@Table(name = UsuarioNovedadConstants.TBL_NAME)
public class UsuarioNovedad extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private transient UserFunctions userFunctionsSrv;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADIDUSUARIONOVEDAD )
    @JsonProperty(value="id_usuarionovedad")
    private Long usuarioNovedadidUsuarioNovedad;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADNUMIDENTIFICACION )
    @JsonProperty(value="numidentificacion")
    private String usuarioNovedadNumIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadNumIdentificacion;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADPRIMERNOMBRE )
    @JsonProperty(value="primernombre")
    private String usuarioNovedadPrimerNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadPrimerNombre;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADSEGUNDONOMBRE )
    @JsonProperty(value="segundonombre")
    private String usuarioNovedadSegundoNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadSegundoNombre;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADPRIMERAPELLIDO )
    @JsonProperty(value="primerapellido")
    private String usuarioNovedadPrimerApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadPrimerApellido;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADSEGUNDOAPELLIDO )
    @JsonProperty(value="segundoapellido")
    private String usuarioNovedadSegundoApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadSegundoApellido;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADMOTIVOESTADO )
    @JsonProperty(value="motivoestado")
    private String usuarioNovedadMotivoEstado;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadMotivoEstado;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADFECHAINIVIGENCIA )
    @JsonProperty(value="fechainivigencia")
    private Date usuarioNovedadFechaIniVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadFechaIniVigencia;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADFECHAANTIGUEDAD )
    @JsonProperty(value="fechaantiguedad")
    private Date usuarioNovedadFechaAntiguedad;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadFechaAntiguedad;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADNUMUSUARIO )
    @JsonProperty(value="numusuario")
    private Long usuarioNovedadNumUsuario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadNumUsuario;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADGENERO )
    @JsonProperty(value="genero")
    private String usuarioNovedadGenero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadGenero;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADFECHANACIMIENTO )
    @JsonProperty(value="fechanacimiento")
    private Date usuarioNovedadFechaNacimiento;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadFechaNacimiento;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADSUNUMMESES )
    @JsonProperty(value="sunummeses")
    private Long usuarioNovedadSUNumMeses;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadSUNumMeses;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADNUMIDENTIFICACIONCD )
    @JsonProperty(value="numidentificacioncd")
    private String usuarioNovedadNumIdentificacionCD;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadNumIdentificacionCD;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvestaactivo")
    protected Boolean usuarioNovedaddrvEstaActivo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvparentescook")
    protected Boolean usuarioNovedaddrvParentescoOK;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvestitular")
    protected Boolean usuarioNovedaddrvEsTitular;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvespadre")
    protected Boolean usuarioNovedaddrvEsPadre;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedad")
    protected Long usuarioNovedaddrvEdad;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drveshijo")
    protected Boolean usuarioNovedaddrvEsHijo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvesconyuge")
    protected Boolean usuarioNovedaddrvEsConyuge;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drveseltitular")
    protected Boolean usuarioNovedaddrvEsElTitular;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvpuedesertitular")
    protected Boolean usuarioNovedaddrvPuedeSerTitular;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvestasuspendido")
    protected Boolean usuarioNovedaddrvEstaSuspendido;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADEXCLUIDO )
    @JsonProperty(value="excluido")
    private Boolean usuarioNovedadExcluido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadExcluido;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADCONTRATACIONRO )
    @JsonProperty(value="contratacionro")
    private Boolean usuarioNovedadContratacionRO;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadContratacionRO;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADPRORROGASUSPENSION )
    @JsonProperty(value="prorrogasuspension")
    private Boolean usuarioNovedadProrrogaSuspension;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadProrrogaSuspension;

    /** Class member attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_USUARIONOVEDADACTIVACIONSUSPENSION )
    @JsonProperty(value="activacionsuspension")
    private Boolean usuarioNovedadActivacionSuspension;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNovedadActivacionSuspension;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnombrecompleto")
    protected String usuarioNovedadDrvNombreCompleto;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvidentificacion")
    protected String usuarioNovedadDrvIdentificacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvaplicanovedad")
    protected Boolean usuarioNovedadDrvAplicaNovedad;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnuevaidentificacion")
    protected String usuarioNovedadDrvNuevaIdentificacion;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioNovedadConstants.FLD_FAMILIANOVEDADIDFAMILIANOVEDAD, referencedColumnName=FamiliaNovedadConstants.FLD_FAMILIANOVEDADIDFAMILIANOVEDAD)
    })
    @JsonIgnore
    private FamiliaNovedad familiaNovedad;
    /** Related attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_FAMILIANOVEDADIDFAMILIANOVEDAD, insertable = false, updatable = false)
    private Long familiaNovedadidFamiliaNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedad;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioNovedadConstants.FLD_TIPOIDENTIFICACIONCODIGO, referencedColumnName=TipoIdentificacionConstants.FLD_TIPOIDENTIFICACIONCODIGO)
    })
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacion;
    /** Related attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_TIPOIDENTIFICACIONCODIGO, insertable = false, updatable = false)
    private Long tipoIdentificacionCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoIdentificacion;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioNovedadConstants.FLD_PARENTESCOPARENTESCOCODIGO, referencedColumnName=ParentescoConstants.FLD_PARENTESCOCODIGO)
    })
    @JsonIgnore
    private Parentesco parentesco;
    /** Related attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_PARENTESCOPARENTESCOCODIGO, insertable = false, updatable = false)
    private Long parentescoParentescoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedParentesco;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioNovedadConstants.FLD_ESTADOBENEFICIARIOESTADOBENEFICIARIOCODIGO, referencedColumnName=EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOCODIGO)
    })
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiario;
    /** Related attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_ESTADOBENEFICIARIOESTADOBENEFICIARIOCODIGO, insertable = false, updatable = false)
    private Long estadoBeneficiarioEstadoBeneficiarioCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiario;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioNovedadConstants.FLD_PARENTESCOPARENTESCONUEVOCODIGO, referencedColumnName=ParentescoConstants.FLD_PARENTESCOCODIGO)
    })
    @JsonIgnore
    private Parentesco parentescoNuevo;
    /** Related attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_PARENTESCOPARENTESCONUEVOCODIGO, insertable = false, updatable = false)
    private Long parentescoParentescoNuevoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedParentescoNuevo;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioNovedadConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCDCODIGO, referencedColumnName=TipoIdentificacionConstants.FLD_TIPOIDENTIFICACIONCODIGO)
    })
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionCD;
    /** Related attribute. */
    @Column(name = UsuarioNovedadConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCDCODIGO, insertable = false, updatable = false)
    private Long tipoIdentificacionTipoIdentificacionCDCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoIdentificacionCD;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public UsuarioNovedad() {
        usuarioNovedadidUsuarioNovedad = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>UsuarioNovedad</code>.
     * @param oid Object Identifier of the instance of <code>UsuarioNovedad</code> to be created.
     * @throws SystemException
     */
    public UsuarioNovedad(UsuarioNovedadOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            usuarioNovedadidUsuarioNovedad = oid.getUsuarioNovedadidUsuarioNovedad();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>usuarioNovedadidUsuarioNovedad</code> attribute<br>in class <code>UsuarioNovedad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>UsuarioNovedad</code>
     * @return The value of the <code>usuarioNovedadidUsuarioNovedad</code> attribute<br>in class <code>UsuarioNovedad</code>.
     */
    public Long getUsuarioNovedadidUsuarioNovedad() {
        return usuarioNovedadidUsuarioNovedad;
    }

    /**
     * Sets the value of the <code>usuarioNovedadidUsuarioNovedad</code> attribute<br>in class <code>UsuarioNovedad</code>.
     * This is part of the identification for this class, which depends on the identification of <code>UsuarioNovedad</code>
     * @param usuarioNovedadidUsuarioNovedad The new value of the <code>usuarioNovedadidUsuarioNovedad</code> attribute<br>in class <code>UsuarioNovedad</code>.
     */
    public void setUsuarioNovedadidUsuarioNovedad(Long usuarioNovedadidUsuarioNovedad) {
        this.usuarioNovedadidUsuarioNovedad = usuarioNovedadidUsuarioNovedad;
    }

   /**
    * Returns the value of the <code>usuarioNovedadNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadNumIdentificacion</code> attribute.
    */

    public String getUsuarioNovedadNumIdentificacion()  {
    	String value;
        value =  usuarioNovedadNumIdentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @param usuarioNovedadNumIdentificacion The new value of the <code>usuarioNovedadNumIdentificacion</code> attribute.
    */
    public void setUsuarioNovedadNumIdentificacion (String usuarioNovedadNumIdentificacion) {
        modifiedUsuarioNovedadNumIdentificacion = true;
        this.usuarioNovedadNumIdentificacion = usuarioNovedadNumIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadNumIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadNumIdentificacion</code>.
    */
    public void setModifiedUsuarioNovedadNumIdentificacion(boolean modified) {
        this.modifiedUsuarioNovedadNumIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadPrimerNombre</code> attribute.
    */

    public String getUsuarioNovedadPrimerNombre()  {
    	String value;
        value =  usuarioNovedadPrimerNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioNovedadPrimerNombre The new value of the <code>usuarioNovedadPrimerNombre</code> attribute.
    */
    public void setUsuarioNovedadPrimerNombre (String usuarioNovedadPrimerNombre) {
        modifiedUsuarioNovedadPrimerNombre = true;
        this.usuarioNovedadPrimerNombre = usuarioNovedadPrimerNombre;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadPrimerNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadPrimerNombre</code>.
    */
    public void setModifiedUsuarioNovedadPrimerNombre(boolean modified) {
        this.modifiedUsuarioNovedadPrimerNombre = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadSegundoNombre</code> attribute.
    */

    public String getUsuarioNovedadSegundoNombre()  {
    	String value;
        value =  usuarioNovedadSegundoNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioNovedadSegundoNombre The new value of the <code>usuarioNovedadSegundoNombre</code> attribute.
    */
    public void setUsuarioNovedadSegundoNombre (String usuarioNovedadSegundoNombre) {
        modifiedUsuarioNovedadSegundoNombre = true;
        this.usuarioNovedadSegundoNombre = usuarioNovedadSegundoNombre;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadSegundoNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadSegundoNombre</code>.
    */
    public void setModifiedUsuarioNovedadSegundoNombre(boolean modified) {
        this.modifiedUsuarioNovedadSegundoNombre = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadPrimerApellido</code> attribute.
    */

    public String getUsuarioNovedadPrimerApellido()  {
    	String value;
        value =  usuarioNovedadPrimerApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioNovedadPrimerApellido The new value of the <code>usuarioNovedadPrimerApellido</code> attribute.
    */
    public void setUsuarioNovedadPrimerApellido (String usuarioNovedadPrimerApellido) {
        modifiedUsuarioNovedadPrimerApellido = true;
        this.usuarioNovedadPrimerApellido = usuarioNovedadPrimerApellido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadPrimerApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadPrimerApellido</code>.
    */
    public void setModifiedUsuarioNovedadPrimerApellido(boolean modified) {
        this.modifiedUsuarioNovedadPrimerApellido = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadSegundoApellido</code> attribute.
    */

    public String getUsuarioNovedadSegundoApellido()  {
    	String value;
        value =  usuarioNovedadSegundoApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioNovedadSegundoApellido The new value of the <code>usuarioNovedadSegundoApellido</code> attribute.
    */
    public void setUsuarioNovedadSegundoApellido (String usuarioNovedadSegundoApellido) {
        modifiedUsuarioNovedadSegundoApellido = true;
        this.usuarioNovedadSegundoApellido = usuarioNovedadSegundoApellido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadSegundoApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadSegundoApellido</code>.
    */
    public void setModifiedUsuarioNovedadSegundoApellido(boolean modified) {
        this.modifiedUsuarioNovedadSegundoApellido = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadMotivoEstado</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadMotivoEstado</code>. Constant String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadMotivoEstado</code> attribute.
    */

    public String getUsuarioNovedadMotivoEstado()  {
    	String value;
        value =  usuarioNovedadMotivoEstado;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadMotivoEstado</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadMotivoEstado</code>. Constant String Size=200<br>
    * Comments: <br>
    * @param usuarioNovedadMotivoEstado The new value of the <code>usuarioNovedadMotivoEstado</code> attribute.
    */
    public void setUsuarioNovedadMotivoEstado (String usuarioNovedadMotivoEstado) {
        modifiedUsuarioNovedadMotivoEstado = true;
        this.usuarioNovedadMotivoEstado = usuarioNovedadMotivoEstado;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadMotivoEstado</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadMotivoEstado</code>.
    */
    public void setModifiedUsuarioNovedadMotivoEstado(boolean modified) {
        this.modifiedUsuarioNovedadMotivoEstado = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadFechaIniVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadFechaIniVigencia</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadFechaIniVigencia</code> attribute.
    */

    public Date getUsuarioNovedadFechaIniVigencia()  {
    	Date value;
        value =  usuarioNovedadFechaIniVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadFechaIniVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadFechaIniVigencia</code>. Constant Date<br>
    * Comments: <br>
    * @param usuarioNovedadFechaIniVigencia The new value of the <code>usuarioNovedadFechaIniVigencia</code> attribute.
    */
    public void setUsuarioNovedadFechaIniVigencia (Date usuarioNovedadFechaIniVigencia) {
        modifiedUsuarioNovedadFechaIniVigencia = true;
        this.usuarioNovedadFechaIniVigencia = usuarioNovedadFechaIniVigencia;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadFechaIniVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadFechaIniVigencia</code>.
    */
    public void setModifiedUsuarioNovedadFechaIniVigencia(boolean modified) {
        this.modifiedUsuarioNovedadFechaIniVigencia = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadFechaAntiguedad</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadFechaAntiguedad</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadFechaAntiguedad</code> attribute.
    */

    public Date getUsuarioNovedadFechaAntiguedad()  {
    	Date value;
        value =  usuarioNovedadFechaAntiguedad;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadFechaAntiguedad</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadFechaAntiguedad</code>. Constant Date<br>
    * Comments: <br>
    * @param usuarioNovedadFechaAntiguedad The new value of the <code>usuarioNovedadFechaAntiguedad</code> attribute.
    */
    public void setUsuarioNovedadFechaAntiguedad (Date usuarioNovedadFechaAntiguedad) {
        modifiedUsuarioNovedadFechaAntiguedad = true;
        this.usuarioNovedadFechaAntiguedad = usuarioNovedadFechaAntiguedad;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadFechaAntiguedad</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadFechaAntiguedad</code>.
    */
    public void setModifiedUsuarioNovedadFechaAntiguedad(boolean modified) {
        this.modifiedUsuarioNovedadFechaAntiguedad = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadNumUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadNumUsuario</code>. Constant Int<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadNumUsuario</code> attribute.
    */

    public Long getUsuarioNovedadNumUsuario()  {
    	Long value;
        value =  usuarioNovedadNumUsuario;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadNumUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadNumUsuario</code>. Constant Int<br>
    * Comments: <br>
    * @param usuarioNovedadNumUsuario The new value of the <code>usuarioNovedadNumUsuario</code> attribute.
    */
    public void setUsuarioNovedadNumUsuario (Long usuarioNovedadNumUsuario) {
        modifiedUsuarioNovedadNumUsuario = true;
        this.usuarioNovedadNumUsuario = usuarioNovedadNumUsuario;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadNumUsuario</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadNumUsuario</code>.
    */
    public void setModifiedUsuarioNovedadNumUsuario(boolean modified) {
        this.modifiedUsuarioNovedadNumUsuario = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadGenero</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadGenero</code>. Variable String Size=1<br>
    * Comments: F - Femenino, M - Masculino<br>
    * @return The value of the <code>usuarioNovedadGenero</code> attribute.
    */

    public String getUsuarioNovedadGenero()  {
    	String value;
        value =  usuarioNovedadGenero;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadGenero</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadGenero</code>. Variable String Size=1<br>
    * Comments: F - Femenino, M - Masculino<br>
    * @param usuarioNovedadGenero The new value of the <code>usuarioNovedadGenero</code> attribute.
    */
    public void setUsuarioNovedadGenero (String usuarioNovedadGenero) {
        modifiedUsuarioNovedadGenero = true;
        this.usuarioNovedadGenero = usuarioNovedadGenero;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadGenero</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadGenero</code>.
    */
    public void setModifiedUsuarioNovedadGenero(boolean modified) {
        this.modifiedUsuarioNovedadGenero = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadFechaNacimiento</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadFechaNacimiento</code> attribute.
    */

    public Date getUsuarioNovedadFechaNacimiento()  {
    	Date value;
        value =  usuarioNovedadFechaNacimiento;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadFechaNacimiento</code>. Variable Date<br>
    * Comments: <br>
    * @param usuarioNovedadFechaNacimiento The new value of the <code>usuarioNovedadFechaNacimiento</code> attribute.
    */
    public void setUsuarioNovedadFechaNacimiento (Date usuarioNovedadFechaNacimiento) {
        modifiedUsuarioNovedadFechaNacimiento = true;
        this.usuarioNovedadFechaNacimiento = usuarioNovedadFechaNacimiento;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadFechaNacimiento</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadFechaNacimiento</code>.
    */
    public void setModifiedUsuarioNovedadFechaNacimiento(boolean modified) {
        this.modifiedUsuarioNovedadFechaNacimiento = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadSUNumMeses</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadSUNumMeses</code>. Variable Nat<br>
    * Comments: GdC 25 - Req 8: SU Suspensión de usuarios
Datos adicionales: Se debe ingresar el número de meses. El valor mínimo es 6, valor máximo es 24 meses.<br>
    * @return The value of the <code>usuarioNovedadSUNumMeses</code> attribute.
    */

    public Long getUsuarioNovedadSUNumMeses()  {
    	Long value;
        value =  usuarioNovedadSUNumMeses;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadSUNumMeses</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadSUNumMeses</code>. Variable Nat<br>
    * Comments: GdC 25 - Req 8: SU Suspensión de usuarios
Datos adicionales: Se debe ingresar el número de meses. El valor mínimo es 6, valor máximo es 24 meses.<br>
    * @param usuarioNovedadSUNumMeses The new value of the <code>usuarioNovedadSUNumMeses</code> attribute.
    */
    public void setUsuarioNovedadSUNumMeses (Long usuarioNovedadSUNumMeses) {
        modifiedUsuarioNovedadSUNumMeses = true;
        this.usuarioNovedadSUNumMeses = usuarioNovedadSUNumMeses;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadSUNumMeses</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadSUNumMeses</code>.
    */
    public void setModifiedUsuarioNovedadSUNumMeses(boolean modified) {
        this.modifiedUsuarioNovedadSUNumMeses = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadNumIdentificacionCD</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadNumIdentificacionCD</code>. Variable String Size=60<br>
    * Comments: En el caso de que se produzca una novedad de cambio de tipo de identificación, aquí guardaremos el nuevo número. <br>
    * @return The value of the <code>usuarioNovedadNumIdentificacionCD</code> attribute.
    */

    public String getUsuarioNovedadNumIdentificacionCD()  {
    	String value;
        value =  usuarioNovedadNumIdentificacionCD;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNovedadNumIdentificacionCD</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadNumIdentificacionCD</code>. Variable String Size=60<br>
    * Comments: En el caso de que se produzca una novedad de cambio de tipo de identificación, aquí guardaremos el nuevo número. <br>
    * @param usuarioNovedadNumIdentificacionCD The new value of the <code>usuarioNovedadNumIdentificacionCD</code> attribute.
    */
    public void setUsuarioNovedadNumIdentificacionCD (String usuarioNovedadNumIdentificacionCD) {
        modifiedUsuarioNovedadNumIdentificacionCD = true;
        this.usuarioNovedadNumIdentificacionCD = usuarioNovedadNumIdentificacionCD;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadNumIdentificacionCD</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadNumIdentificacionCD</code>.
    */
    public void setModifiedUsuarioNovedadNumIdentificacionCD(boolean modified) {
        this.modifiedUsuarioNovedadNumIdentificacionCD = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEstaActivo</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEstaActivo</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedaddrvEstaActivo</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEstaActivo()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEstaActivoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEstaActivo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvParentescoOK</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvParentescoOK</code>. Variable Bool<br>
    * Comments: Indica si el parentesco es válido respecto al resto de usuarios de la familia y respecto al titular:
El titular debe tener por lo menos un diferencia de 10 años con la edad del beneficiario de parentesco PADRE.
El titular debe tener por lo menos un diferencia de 10 años con la edad del beneficiario de parentesco HIJO
Los beneficiarios con parentesco CONYUGE deben tener sexo distinto al del TITULAR
La edad de los beneficiarios con parentesco CONYUGE debe ser mayor o igual a 13 años
Si existe un conyuge no activo su vigencia no puede estar traslapada con el nuevo conyuge <br>
    * @return The value of the <code>usuarioNovedaddrvParentescoOK</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvParentescoOK()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvParentescoOKDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvParentescoOK");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEsTitular</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEsTitular</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedaddrvEsTitular</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEsTitular()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEsTitularDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEsTitular");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEsPadre</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEsPadre</code>. Variable Bool<br>
    * Comments: Tiene el parentesco padre, se utiliza para validaciones<br>
    * @return The value of the <code>usuarioNovedaddrvEsPadre</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEsPadre()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEsPadreDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEsPadre");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEdad</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEdad</code>. Variable Int<br>
    * Comments: Se utilizará para validaciones. <br>
    * @return The value of the <code>usuarioNovedaddrvEdad</code> attribute.
    */

    public Long getUsuarioNovedaddrvEdad()  {
    	Long value;
        try {
            value = usuarioNovedaddrvEdadDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEdad");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEsHijo</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEsHijo</code>. Variable Bool<br>
    * Comments: Tiene el parentesco hijo, se utiliza para validaciones<br>
    * @return The value of the <code>usuarioNovedaddrvEsHijo</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEsHijo()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEsHijoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEsHijo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEsConyuge</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEsConyuge</code>. Variable Bool<br>
    * Comments: Tiene el parentesco conyuge, se utiliza para validaciones<br>
    * @return The value of the <code>usuarioNovedaddrvEsConyuge</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEsConyuge()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEsConyugeDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEsConyuge");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEsElTitular</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEsElTitular</code>. Variable Bool<br>
    * Comments: Si tiene parentesco titular, o si se ha hecho un cambio de titular y se ha añadido este usuario como titular<br>
    * @return The value of the <code>usuarioNovedaddrvEsElTitular</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEsElTitular()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEsElTitularDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEsElTitular");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvPuedeSerTitular</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvPuedeSerTitular</code>. Variable Bool<br>
    * Comments: Devuelve true si puede ser titular de la solicitud. Este dato se utiliza en el filtrado navegacional de parentesco cuando se va a hacer una solicitud de novedad de CP (cambio de parentesco)<br>
    * @return The value of the <code>usuarioNovedaddrvPuedeSerTitular</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvPuedeSerTitular()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvPuedeSerTitularDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvPuedeSerTitular");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedaddrvEstaSuspendido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedaddrvEstaSuspendido</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedaddrvEstaSuspendido</code> attribute.
    */

    public Boolean getUsuarioNovedaddrvEstaSuspendido()  {
    	Boolean value;
        try {
            value = usuarioNovedaddrvEstaSuspendidoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedaddrvEstaSuspendido");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedadExcluido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadExcluido</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadExcluido</code> attribute.
    */

    public Boolean getUsuarioNovedadExcluido()  {
    	Boolean value;
        value =  usuarioNovedadExcluido;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadExcluido</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadExcluido</code>. Variable Bool<br>
    * Comments: <br>
    * @param usuarioNovedadExcluido The new value of the <code>usuarioNovedadExcluido</code> attribute.
    */
    public void setUsuarioNovedadExcluido (Boolean usuarioNovedadExcluido) {
        modifiedUsuarioNovedadExcluido = true;
        this.usuarioNovedadExcluido = usuarioNovedadExcluido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadExcluido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadExcluido</code>.
    */
    public void setModifiedUsuarioNovedadExcluido(boolean modified) {
        this.modifiedUsuarioNovedadExcluido = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadContratacionRO</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadContratacionRO</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadContratacionRO</code> attribute.
    */

    public Boolean getUsuarioNovedadContratacionRO()  {
    	Boolean value;
        value =  usuarioNovedadContratacionRO;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadContratacionRO</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadContratacionRO</code>. Variable Bool<br>
    * Comments: <br>
    * @param usuarioNovedadContratacionRO The new value of the <code>usuarioNovedadContratacionRO</code> attribute.
    */
    public void setUsuarioNovedadContratacionRO (Boolean usuarioNovedadContratacionRO) {
        modifiedUsuarioNovedadContratacionRO = true;
        this.usuarioNovedadContratacionRO = usuarioNovedadContratacionRO;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadContratacionRO</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadContratacionRO</code>.
    */
    public void setModifiedUsuarioNovedadContratacionRO(boolean modified) {
        this.modifiedUsuarioNovedadContratacionRO = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadProrrogaSuspension</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadProrrogaSuspension</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadProrrogaSuspension</code> attribute.
    */

    public Boolean getUsuarioNovedadProrrogaSuspension()  {
    	Boolean value;
        value =  usuarioNovedadProrrogaSuspension;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadProrrogaSuspension</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadProrrogaSuspension</code>. Variable Bool<br>
    * Comments: <br>
    * @param usuarioNovedadProrrogaSuspension The new value of the <code>usuarioNovedadProrrogaSuspension</code> attribute.
    */
    public void setUsuarioNovedadProrrogaSuspension (Boolean usuarioNovedadProrrogaSuspension) {
        modifiedUsuarioNovedadProrrogaSuspension = true;
        this.usuarioNovedadProrrogaSuspension = usuarioNovedadProrrogaSuspension;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadProrrogaSuspension</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadProrrogaSuspension</code>.
    */
    public void setModifiedUsuarioNovedadProrrogaSuspension(boolean modified) {
        this.modifiedUsuarioNovedadProrrogaSuspension = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadActivacionSuspension</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadActivacionSuspension</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadActivacionSuspension</code> attribute.
    */

    public Boolean getUsuarioNovedadActivacionSuspension()  {
    	Boolean value;
        value =  usuarioNovedadActivacionSuspension;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNovedadActivacionSuspension</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadActivacionSuspension</code>. Variable Bool<br>
    * Comments: <br>
    * @param usuarioNovedadActivacionSuspension The new value of the <code>usuarioNovedadActivacionSuspension</code> attribute.
    */
    public void setUsuarioNovedadActivacionSuspension (Boolean usuarioNovedadActivacionSuspension) {
        modifiedUsuarioNovedadActivacionSuspension = true;
        this.usuarioNovedadActivacionSuspension = usuarioNovedadActivacionSuspension;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNovedadActivacionSuspension</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNovedadActivacionSuspension</code>.
    */
    public void setModifiedUsuarioNovedadActivacionSuspension(boolean modified) {
        this.modifiedUsuarioNovedadActivacionSuspension = modified;
    }

   /**
    * Returns the value of the <code>usuarioNovedadDrvNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadDrvNombreCompleto</code>. Variable String Size=210<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNovedadDrvNombreCompleto</code> attribute.
    */

    public String getUsuarioNovedadDrvNombreCompleto()  {
    	String value;
        try {
            value = usuarioNovedadDrvNombreCompletoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedadDrvNombreCompleto");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>usuarioNovedadDrvIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadDrvIdentificacion</code>. Variable String Size=70<br>
    * Comments: Si no se ha producido cambio de tipo de identificación tomo unos atributos, si se ha producido tomo otros<br>
    * @return The value of the <code>usuarioNovedadDrvIdentificacion</code> attribute.
    */

    public String getUsuarioNovedadDrvIdentificacion()  {
    	String value;
        try {
            value = usuarioNovedadDrvIdentificacionDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedadDrvIdentificacion");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>usuarioNovedadDrvAplicaNovedad</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadDrvAplicaNovedad</code>. Variable Bool<br>
    * Comments: Indica si al usuario le afecta la novedad o no<br>
    * @return The value of the <code>usuarioNovedadDrvAplicaNovedad</code> attribute.
    */

    public Boolean getUsuarioNovedadDrvAplicaNovedad()  {
    	Boolean value;
        try {
            value = usuarioNovedadDrvAplicaNovedadDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedadDrvAplicaNovedad");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioNovedadDrvNuevaIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioNovedadDrvNuevaIdentificacion</code>. Variable String Size=70<br>
    * Comments: Si no se ha producido cambio de tipo de identificación tomo unos atributos, si se ha producido tomo otros<br>
    * @return The value of the <code>usuarioNovedadDrvNuevaIdentificacion</code> attribute.
    */

    public String getUsuarioNovedadDrvNuevaIdentificacion()  {
    	String value;
        try {
            value = usuarioNovedadDrvNuevaIdentificacionDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioNovedad, Attribute: usuarioNovedadDrvNuevaIdentificacion");
        }
        return (value == null ? null : value.trim());
    }

    /**
     * Returns the instance of <code>FamiliaNovedad</code> related through the <code>FamiliaNovedad</code> role.
     * Model Relationship:
     * <code>[FamiliaNovedad] FamiliaNovedad 1:1  ------ 0:M  UsuarioNovedad [UsuarioNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>FamiliaNovedad</code> related through the <code>FamiliaNovedad</code> role.
     */
    @JsonIgnore
    public FamiliaNovedad getFamiliaNovedad() {
        return familiaNovedad;
    }

   /**
    * Adds an instance of <code>FamiliaNovedad</code> related through the <code>FamiliaNovedad</code> role.
    * @param familiaNovedad The instance to add to the <code>FamiliaNovedad</code> role.
    */
    public void add2FamiliaNovedad(FamiliaNovedad familiaNovedad) {
        if (familiaNovedad == null || familiaNovedad.isNull()) {
            this.modifiedFamiliaNovedad = true;
            this.familiaNovedadidFamiliaNovedad = null;
        } else {
            this.familiaNovedadidFamiliaNovedad = familiaNovedad.getFamiliaNovedadidFamiliaNovedad();
        }
        this.familiaNovedad = (familiaNovedad == null  || familiaNovedad.isNull() ? null : familiaNovedad);
    }

   /**
    * This method gets the attribute value <code>modifiedFamiliaNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFamiliaNovedad</code> has been modified.
    */
    public boolean isModifiedFamiliaNovedad(){
        return modifiedFamiliaNovedad;
    }

    /**
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacion 0:1  ------ 0:M  UsuariosNovedad [UsuarioNovedad]</code>
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
     * Returns the instance of <code>Parentesco</code> related through the <code>Parentesco</code> role.
     * Model Relationship:
     * <code>[Parentesco] Parentesco 0:1  ------ 0:M  UsuariosNovedad [UsuarioNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Parentesco</code> related through the <code>Parentesco</code> role.
     */
    @JsonIgnore
    public Parentesco getParentesco() {
        return parentesco;
    }

   /**
    * Adds an instance of <code>Parentesco</code> related through the <code>Parentesco</code> role.
    * @param parentesco The instance to add to the <code>Parentesco</code> role.
    */
    public void add2Parentesco(Parentesco parentesco) {
        if (parentesco == null || parentesco.isNull()) {
            this.modifiedParentesco = true;
            this.parentescoParentescoCodigo = null;
        } else {
            this.parentescoParentescoCodigo = parentesco.getParentescoCodigo();
        }
        this.parentesco = (parentesco == null  || parentesco.isNull() ? null : parentesco);
    }

   /**
    * This method gets the attribute value <code>modifiedParentesco</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedParentesco</code> has been modified.
    */
    public boolean isModifiedParentesco(){
        return modifiedParentesco;
    }

    /**
     * Returns the instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiario</code> role.
     * Model Relationship:
     * <code>[EstadoBeneficiario] EstadoBeneficiario 0:1  ------ 0:M  UsuariosNovedad [UsuarioNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiario</code> role.
     */
    @JsonIgnore
    public EstadoBeneficiario getEstadoBeneficiario() {
        return estadoBeneficiario;
    }

   /**
    * Adds an instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiario</code> role.
    * @param estadoBeneficiario The instance to add to the <code>EstadoBeneficiario</code> role.
    */
    public void add2EstadoBeneficiario(EstadoBeneficiario estadoBeneficiario) {
        if (estadoBeneficiario == null || estadoBeneficiario.isNull()) {
            this.modifiedEstadoBeneficiario = true;
            this.estadoBeneficiarioEstadoBeneficiarioCodigo = null;
        } else {
            this.estadoBeneficiarioEstadoBeneficiarioCodigo = estadoBeneficiario.getEstadoBeneficiarioCodigo();
        }
        this.estadoBeneficiario = (estadoBeneficiario == null  || estadoBeneficiario.isNull() ? null : estadoBeneficiario);
    }

   /**
    * This method gets the attribute value <code>modifiedEstadoBeneficiario</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedEstadoBeneficiario</code> has been modified.
    */
    public boolean isModifiedEstadoBeneficiario(){
        return modifiedEstadoBeneficiario;
    }

    /**
     * Returns the instance of <code>Parentesco</code> related through the <code>ParentescoNuevo</code> role.
     * Model Relationship:
     * <code>[Parentesco] ParentescoNuevo 0:1  ------ 0:M  UsuarioNovedad [UsuarioNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Parentesco</code> related through the <code>ParentescoNuevo</code> role.
     */
    @JsonIgnore
    public Parentesco getParentescoNuevo() {
        return parentescoNuevo;
    }

   /**
    * Adds an instance of <code>Parentesco</code> related through the <code>ParentescoNuevo</code> role.
    * @param parentescoNuevo The instance to add to the <code>ParentescoNuevo</code> role.
    */
    public void add2ParentescoNuevo(Parentesco parentescoNuevo) {
        if (parentescoNuevo == null || parentescoNuevo.isNull()) {
            this.modifiedParentescoNuevo = true;
            this.parentescoParentescoNuevoCodigo = null;
        } else {
            this.parentescoParentescoNuevoCodigo = parentescoNuevo.getParentescoCodigo();
        }
        this.parentescoNuevo = (parentescoNuevo == null  || parentescoNuevo.isNull() ? null : parentescoNuevo);
    }

   /**
    * This method gets the attribute value <code>modifiedParentescoNuevo</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedParentescoNuevo</code> has been modified.
    */
    public boolean isModifiedParentescoNuevo(){
        return modifiedParentescoNuevo;
    }

    /**
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacionCD</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacionCD 0:1  ------ 0:M  UsuarioNovedad [UsuarioNovedad]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacionCD</code> role.
     */
    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionCD() {
        return tipoIdentificacionCD;
    }

   /**
    * Adds an instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacionCD</code> role.
    * @param tipoIdentificacionCD The instance to add to the <code>TipoIdentificacionCD</code> role.
    */
    public void add2TipoIdentificacionCD(TipoIdentificacion tipoIdentificacionCD) {
        if (tipoIdentificacionCD == null || tipoIdentificacionCD.isNull()) {
            this.modifiedTipoIdentificacionCD = true;
            this.tipoIdentificacionTipoIdentificacionCDCodigo = null;
        } else {
            this.tipoIdentificacionTipoIdentificacionCDCodigo = tipoIdentificacionCD.getTipoIdentificacionCodigo();
        }
        this.tipoIdentificacionCD = (tipoIdentificacionCD == null  || tipoIdentificacionCD.isNull() ? null : tipoIdentificacionCD);
    }

   /**
    * This method gets the attribute value <code>modifiedTipoIdentificacionCD</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTipoIdentificacionCD</code> has been modified.
    */
    public boolean isModifiedTipoIdentificacionCD(){
        return modifiedTipoIdentificacionCD;
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
     * Returns the value of the <code>usuarioNovedaddrvEstaActivo</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEstaActivo</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEstaActivoDerivations() {
        return usuarioNovedaddrvEstaActivo;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvParentescoOK</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvParentescoOK</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvParentescoOKDerivations() {
        return usuarioNovedaddrvParentescoOK;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEsTitular</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEsTitular</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEsTitularDerivations() {
        return usuarioNovedaddrvEsTitular;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEsPadre</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEsPadre</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEsPadreDerivations() {
        return usuarioNovedaddrvEsPadre;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEdad</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEdad</code> derived attribute.
     */
    public Long usuarioNovedaddrvEdadDerivations() {
        return usuarioNovedaddrvEdad;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEsHijo</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEsHijo</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEsHijoDerivations() {
        return usuarioNovedaddrvEsHijo;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEsConyuge</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEsConyuge</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEsConyugeDerivations() {
        return usuarioNovedaddrvEsConyuge;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEsElTitular</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEsElTitular</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEsElTitularDerivations() {
        return usuarioNovedaddrvEsElTitular;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvPuedeSerTitular</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvPuedeSerTitular</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvPuedeSerTitularDerivations() {
        return usuarioNovedaddrvPuedeSerTitular;
    }    

    /**
     * Returns the value of the <code>usuarioNovedaddrvEstaSuspendido</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedaddrvEstaSuspendido</code> derived attribute.
     */
    public Boolean usuarioNovedaddrvEstaSuspendidoDerivations() {
        return usuarioNovedaddrvEstaSuspendido;
    }    

    /**
     * Returns the value of the <code>usuarioNovedadDrvNombreCompleto</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedadDrvNombreCompleto</code> derived attribute.
     */
    public String usuarioNovedadDrvNombreCompletoDerivations() {
        return usuarioNovedadDrvNombreCompleto;
    }    

    /**
     * Returns the value of the <code>usuarioNovedadDrvIdentificacion</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedadDrvIdentificacion</code> derived attribute.
     */
    public String usuarioNovedadDrvIdentificacionDerivations() {
        return usuarioNovedadDrvIdentificacion;
    }    

    /**
     * Returns the value of the <code>usuarioNovedadDrvAplicaNovedad</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedadDrvAplicaNovedad</code> derived attribute.
     */
    public Boolean usuarioNovedadDrvAplicaNovedadDerivations() {
        return usuarioNovedadDrvAplicaNovedad;
    }    

    /**
     * Returns the value of the <code>usuarioNovedadDrvNuevaIdentificacion</code> derived attribute.
     *
     * @return Value of the <code>usuarioNovedadDrvNuevaIdentificacion</code> derived attribute.
     */
    public String usuarioNovedadDrvNuevaIdentificacionDerivations() {
        return usuarioNovedadDrvNuevaIdentificacion;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        usuarioNovedadNumIdentificacion = "";
        usuarioNovedadPrimerNombre = null;
        usuarioNovedadSegundoNombre = null;
        usuarioNovedadPrimerApellido = null;
        usuarioNovedadSegundoApellido = null;
        usuarioNovedadMotivoEstado = null;
        usuarioNovedadFechaIniVigencia = null;
        usuarioNovedadFechaAntiguedad = null;
        usuarioNovedadNumUsuario = Long.valueOf(0);
        usuarioNovedadGenero = null;
        usuarioNovedadFechaNacimiento = null;
        usuarioNovedadSUNumMeses = null;
        usuarioNovedadNumIdentificacionCD = null;
        usuarioNovedadExcluido = false;
        usuarioNovedadContratacionRO = false;
        usuarioNovedadProrrogaSuspension = false;
        usuarioNovedadActivacionSuspension = false;
        familiaNovedad = null;
        tipoIdentificacion = null;
        parentesco = null;
        estadoBeneficiario = null;
        parentescoNuevo = null;
        tipoIdentificacionCD = null;
        values = new HashMap<>();
        userFunctionsSrv = Arc.container().select(UserFunctions.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return UsuarioNovedad.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return UsuarioNovedadConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedUsuarioNovedadNumIdentificacion = false;
    	values.put("usuarioNovedadNumIdentificacion", getUsuarioNovedadNumIdentificacion());
    	modifiedUsuarioNovedadPrimerNombre = false;
    	values.put("usuarioNovedadPrimerNombre", getUsuarioNovedadPrimerNombre());
    	modifiedUsuarioNovedadSegundoNombre = false;
    	values.put("usuarioNovedadSegundoNombre", getUsuarioNovedadSegundoNombre());
    	modifiedUsuarioNovedadPrimerApellido = false;
    	values.put("usuarioNovedadPrimerApellido", getUsuarioNovedadPrimerApellido());
    	modifiedUsuarioNovedadSegundoApellido = false;
    	values.put("usuarioNovedadSegundoApellido", getUsuarioNovedadSegundoApellido());
    	modifiedUsuarioNovedadMotivoEstado = false;
    	values.put("usuarioNovedadMotivoEstado", getUsuarioNovedadMotivoEstado());
    	modifiedUsuarioNovedadFechaIniVigencia = false;
    	values.put("usuarioNovedadFechaIniVigencia", getUsuarioNovedadFechaIniVigencia());
    	modifiedUsuarioNovedadFechaAntiguedad = false;
    	values.put("usuarioNovedadFechaAntiguedad", getUsuarioNovedadFechaAntiguedad());
    	modifiedUsuarioNovedadNumUsuario = false;
    	values.put("usuarioNovedadNumUsuario", getUsuarioNovedadNumUsuario());
    	modifiedUsuarioNovedadGenero = false;
    	values.put("usuarioNovedadGenero", getUsuarioNovedadGenero());
    	modifiedUsuarioNovedadFechaNacimiento = false;
    	values.put("usuarioNovedadFechaNacimiento", getUsuarioNovedadFechaNacimiento());
    	modifiedUsuarioNovedadSUNumMeses = false;
    	values.put("usuarioNovedadSUNumMeses", getUsuarioNovedadSUNumMeses());
    	modifiedUsuarioNovedadNumIdentificacionCD = false;
    	values.put("usuarioNovedadNumIdentificacionCD", getUsuarioNovedadNumIdentificacionCD());
    	modifiedUsuarioNovedadExcluido = false;
    	values.put("usuarioNovedadExcluido", getUsuarioNovedadExcluido());
    	modifiedUsuarioNovedadContratacionRO = false;
    	values.put("usuarioNovedadContratacionRO", getUsuarioNovedadContratacionRO());
    	modifiedUsuarioNovedadProrrogaSuspension = false;
    	values.put("usuarioNovedadProrrogaSuspension", getUsuarioNovedadProrrogaSuspension());
    	modifiedUsuarioNovedadActivacionSuspension = false;
    	values.put("usuarioNovedadActivacionSuspension", getUsuarioNovedadActivacionSuspension());
    	modifiedFamiliaNovedad = false;
    	modifiedTipoIdentificacion = false;
    	modifiedParentesco = false;
    	modifiedEstadoBeneficiario = false;
    	modifiedParentescoNuevo = false;
    	modifiedTipoIdentificacionCD = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            usuarioNovedaddrvEstaActivo = null;
            usuarioNovedaddrvParentescoOK = null;
            usuarioNovedaddrvEsTitular = null;
            usuarioNovedaddrvEsPadre = null;
            usuarioNovedaddrvEdad = null;
            usuarioNovedaddrvEsHijo = null;
            usuarioNovedaddrvEsConyuge = null;
            usuarioNovedaddrvEsElTitular = null;
            usuarioNovedaddrvPuedeSerTitular = null;
            usuarioNovedaddrvEstaSuspendido = null;
            usuarioNovedadDrvNombreCompleto = null;
            usuarioNovedadDrvIdentificacion = null;
            usuarioNovedadDrvAplicaNovedad = null;
            usuarioNovedadDrvNuevaIdentificacion = null;
    }

    /**
     * Returns the <code>UsuarioNovedadOid</code> object that identifies this instance of <code>UsuarioNovedad</code>.
     * @return <code>UsuarioNovedadOid </code> object that identifies this instance of <code>UsuarioNovedad</code>
     */
    public UsuarioNovedadOid getOid() {
        return new UsuarioNovedadOid(getUsuarioNovedadidUsuarioNovedad());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(UsuarioNovedadConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(UsuarioNovedadConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.USUARIONOVEDAD)) {
            // Add this class
            activeFacets.add(Constants.USUARIONOVEDAD);
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
