package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.UsuarioRegConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioRegOid;
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
 * Persistent representation of the <code>UsuarioReg</code> model class.
 * <p>
 * Model Class: <code>UsuarioReg</code><br>
 */
@Entity(name = UsuarioRegConstants.CLASS_NAME)
@Table(name = UsuarioRegConstants.TBL_NAME)
public class UsuarioReg extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Embedded Class Identification Function */
    @EmbeddedId
    private UsuarioRegOid oid;

    /** Class identification function. */
    @Column(name = UsuarioRegConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false )
    @JsonProperty(value="id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;

    /** Class identification function. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGIDENTIFICADOR, insertable = false, updatable = false )
    @JsonProperty(value="identificador")
    private Long usuarioRegIdentificador;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGTIPOIDENTIFICACION )
    @JsonProperty(value="tipoidentificacion")
    private String usuarioRegTipoIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegTipoIdentificacion;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGNUMIDENTIFICACION )
    @JsonProperty(value="numidentificacion")
    private String usuarioRegNumIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegNumIdentificacion;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGTIPOYNUMDOC )
    @JsonProperty(value="tipoynumdoc")
    private String usuarioRegTipoYNumDoc;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegTipoYNumDoc;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGPRIMERNOMBRE )
    @JsonProperty(value="primernombre")
    private String usuarioRegPrimerNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegPrimerNombre;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGSEGUNDONOMBRE )
    @JsonProperty(value="segundonombre")
    private String usuarioRegSegundoNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegSegundoNombre;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGPRIMERAPELLIDO )
    @JsonProperty(value="primerapellido")
    private String usuarioRegPrimerApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegPrimerApellido;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGSEGUNDOAPELLIDO )
    @JsonProperty(value="segundoapellido")
    private String usuarioRegSegundoApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegSegundoApellido;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGNUMUSUARIO )
    @JsonProperty(value="numusuario")
    private Long usuarioRegNumUsuario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegNumUsuario;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGFECHAINICIOVIGENCIA )
    @JsonProperty(value="fechainiciovigencia")
    private Date usuarioRegFechaInicioVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegFechaInicioVigencia;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGFECHAFINVIGENCIA )
    @JsonProperty(value="fechafinvigencia")
    private Date usuarioRegFechaFinVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegFechaFinVigencia;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGGENERO )
    @JsonProperty(value="genero")
    private String usuarioRegGenero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegGenero;

    /** Class member attribute. */
    @Column(name = UsuarioRegConstants.FLD_USUARIOREGFECHANACIMIENTO )
    @JsonProperty(value="fechanacimiento")
    private Date usuarioRegFechaNacimiento;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRegFechaNacimiento;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedad")
    protected Long usuarioRegdrvEdad;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioRegConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false)
    })
    @JsonIgnore
    private Solicitud solicitud;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitud;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioRegConstants.FLD_ESTADOBENEFICIARIOCODIGO, referencedColumnName=EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOCODIGO)
    })
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiario;
    /** Related attribute. */
    @Column(name = UsuarioRegConstants.FLD_ESTADOBENEFICIARIOCODIGO, insertable = false, updatable = false)
    private Long estadoBeneficiarioCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiario;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioRegConstants.FLD_PARENTESCOPARENTESCOCODIGO, referencedColumnName=ParentescoConstants.FLD_PARENTESCOCODIGO)
    })
    @JsonIgnore
    private Parentesco parentesco;
    /** Related attribute. */
    @Column(name = UsuarioRegConstants.FLD_PARENTESCOPARENTESCOCODIGO, insertable = false, updatable = false)
    private Long parentescoParentescoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedParentesco;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public UsuarioReg() {
        aESOLICITUDESIDSOLICITUD = null;
        usuarioRegIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>UsuarioReg</code>.
     * @param oid Object Identifier of the instance of <code>UsuarioReg</code> to be created.
     * @throws SystemException
     */
    public UsuarioReg(UsuarioRegOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            aESOLICITUDESIDSOLICITUD = oid.getAESOLICITUDESIDSOLICITUD();
            usuarioRegIdentificador = oid.getUsuarioRegIdentificador();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Solicitud.AE_SOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @return The value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Solicitud.AE_SOLICITUDES</code>.
     */
    public Long getAESOLICITUDESIDSOLICITUD() {
        return (solicitud != null ? solicitud.getAESOLICITUDESIDSOLICITUD() : aESOLICITUDESIDSOLICITUD);
    }

    /**
     * Sets the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Solicitud.AE_SOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @param aESOLICITUDESIDSOLICITUD The new value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Solicitud.AE_SOLICITUDES</code>.
     */
    public void setAESOLICITUDESIDSOLICITUD(Long aESOLICITUDESIDSOLICITUD) {
        this.aESOLICITUDESIDSOLICITUD = aESOLICITUDESIDSOLICITUD;
    }

    /**
     * Returns the value of the <code>usuarioRegIdentificador</code> attribute<br>in class <code>UsuarioReg</code>.
     * This is part of the identification for this class, which depends on the identification of <code>UsuarioReg</code>
     * @return The value of the <code>usuarioRegIdentificador</code> attribute<br>in class <code>UsuarioReg</code>.
     */
    public Long getUsuarioRegIdentificador() {
        return usuarioRegIdentificador;
    }

    /**
     * Sets the value of the <code>usuarioRegIdentificador</code> attribute<br>in class <code>UsuarioReg</code>.
     * This is part of the identification for this class, which depends on the identification of <code>UsuarioReg</code>
     * @param usuarioRegIdentificador The new value of the <code>usuarioRegIdentificador</code> attribute<br>in class <code>UsuarioReg</code>.
     */
    public void setUsuarioRegIdentificador(Long usuarioRegIdentificador) {
        this.usuarioRegIdentificador = usuarioRegIdentificador;
    }

   /**
    * Returns the value of the <code>usuarioRegTipoIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioRegTipoIdentificacion</code>. Constant String Size=20<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegTipoIdentificacion</code> attribute.
    */

    public String getUsuarioRegTipoIdentificacion()  {
    	String value;
        value =  usuarioRegTipoIdentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegTipoIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioRegTipoIdentificacion</code>. Constant String Size=20<br>
    * Comments: <br>
    * @param usuarioRegTipoIdentificacion The new value of the <code>usuarioRegTipoIdentificacion</code> attribute.
    */
    public void setUsuarioRegTipoIdentificacion (String usuarioRegTipoIdentificacion) {
        modifiedUsuarioRegTipoIdentificacion = true;
        this.usuarioRegTipoIdentificacion = usuarioRegTipoIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegTipoIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegTipoIdentificacion</code>.
    */
    public void setModifiedUsuarioRegTipoIdentificacion(boolean modified) {
        this.modifiedUsuarioRegTipoIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioRegNumIdentificacion</code>. Constant String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegNumIdentificacion</code> attribute.
    */

    public String getUsuarioRegNumIdentificacion()  {
    	String value;
        value =  usuarioRegNumIdentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioRegNumIdentificacion</code>. Constant String Size=60<br>
    * Comments: <br>
    * @param usuarioRegNumIdentificacion The new value of the <code>usuarioRegNumIdentificacion</code> attribute.
    */
    public void setUsuarioRegNumIdentificacion (String usuarioRegNumIdentificacion) {
        modifiedUsuarioRegNumIdentificacion = true;
        this.usuarioRegNumIdentificacion = usuarioRegNumIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegNumIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegNumIdentificacion</code>.
    */
    public void setModifiedUsuarioRegNumIdentificacion(boolean modified) {
        this.modifiedUsuarioRegNumIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegTipoYNumDoc</code> attribute.<br>
    * Model Attribute: <code>usuarioRegTipoYNumDoc</code>. Variable String Size=80<br>
    * Comments: La información que se mostrará en el formulario. No se pide al crear, se formará a partir del tipo y número de identificación<br>
    * @return The value of the <code>usuarioRegTipoYNumDoc</code> attribute.
    */

    public String getUsuarioRegTipoYNumDoc()  {
    	String value;
        value =  usuarioRegTipoYNumDoc;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegTipoYNumDoc</code> attribute.<br>
    * Model Attribute: <code>usuarioRegTipoYNumDoc</code>. Variable String Size=80<br>
    * Comments: La información que se mostrará en el formulario. No se pide al crear, se formará a partir del tipo y número de identificación<br>
    * @param usuarioRegTipoYNumDoc The new value of the <code>usuarioRegTipoYNumDoc</code> attribute.
    */
    public void setUsuarioRegTipoYNumDoc (String usuarioRegTipoYNumDoc) {
        modifiedUsuarioRegTipoYNumDoc = true;
        this.usuarioRegTipoYNumDoc = usuarioRegTipoYNumDoc;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegTipoYNumDoc</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegTipoYNumDoc</code>.
    */
    public void setModifiedUsuarioRegTipoYNumDoc(boolean modified) {
        this.modifiedUsuarioRegTipoYNumDoc = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioRegPrimerNombre</code>. Constant String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegPrimerNombre</code> attribute.
    */

    public String getUsuarioRegPrimerNombre()  {
    	String value;
        value =  usuarioRegPrimerNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioRegPrimerNombre</code>. Constant String Size=50<br>
    * Comments: <br>
    * @param usuarioRegPrimerNombre The new value of the <code>usuarioRegPrimerNombre</code> attribute.
    */
    public void setUsuarioRegPrimerNombre (String usuarioRegPrimerNombre) {
        modifiedUsuarioRegPrimerNombre = true;
        this.usuarioRegPrimerNombre = usuarioRegPrimerNombre;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegPrimerNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegPrimerNombre</code>.
    */
    public void setModifiedUsuarioRegPrimerNombre(boolean modified) {
        this.modifiedUsuarioRegPrimerNombre = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioRegSegundoNombre</code>. Constant String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegSegundoNombre</code> attribute.
    */

    public String getUsuarioRegSegundoNombre()  {
    	String value;
        value =  usuarioRegSegundoNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioRegSegundoNombre</code>. Constant String Size=50<br>
    * Comments: <br>
    * @param usuarioRegSegundoNombre The new value of the <code>usuarioRegSegundoNombre</code> attribute.
    */
    public void setUsuarioRegSegundoNombre (String usuarioRegSegundoNombre) {
        modifiedUsuarioRegSegundoNombre = true;
        this.usuarioRegSegundoNombre = usuarioRegSegundoNombre;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegSegundoNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegSegundoNombre</code>.
    */
    public void setModifiedUsuarioRegSegundoNombre(boolean modified) {
        this.modifiedUsuarioRegSegundoNombre = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioRegPrimerApellido</code>. Constant String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegPrimerApellido</code> attribute.
    */

    public String getUsuarioRegPrimerApellido()  {
    	String value;
        value =  usuarioRegPrimerApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioRegPrimerApellido</code>. Constant String Size=50<br>
    * Comments: <br>
    * @param usuarioRegPrimerApellido The new value of the <code>usuarioRegPrimerApellido</code> attribute.
    */
    public void setUsuarioRegPrimerApellido (String usuarioRegPrimerApellido) {
        modifiedUsuarioRegPrimerApellido = true;
        this.usuarioRegPrimerApellido = usuarioRegPrimerApellido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegPrimerApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegPrimerApellido</code>.
    */
    public void setModifiedUsuarioRegPrimerApellido(boolean modified) {
        this.modifiedUsuarioRegPrimerApellido = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioRegSegundoApellido</code>. Constant String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegSegundoApellido</code> attribute.
    */

    public String getUsuarioRegSegundoApellido()  {
    	String value;
        value =  usuarioRegSegundoApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioRegSegundoApellido</code>. Constant String Size=50<br>
    * Comments: <br>
    * @param usuarioRegSegundoApellido The new value of the <code>usuarioRegSegundoApellido</code> attribute.
    */
    public void setUsuarioRegSegundoApellido (String usuarioRegSegundoApellido) {
        modifiedUsuarioRegSegundoApellido = true;
        this.usuarioRegSegundoApellido = usuarioRegSegundoApellido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegSegundoApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegSegundoApellido</code>.
    */
    public void setModifiedUsuarioRegSegundoApellido(boolean modified) {
        this.modifiedUsuarioRegSegundoApellido = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegNumUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioRegNumUsuario</code>. Constant Int<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegNumUsuario</code> attribute.
    */

    public Long getUsuarioRegNumUsuario()  {
    	Long value;
        value =  usuarioRegNumUsuario;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioRegNumUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioRegNumUsuario</code>. Constant Int<br>
    * Comments: <br>
    * @param usuarioRegNumUsuario The new value of the <code>usuarioRegNumUsuario</code> attribute.
    */
    public void setUsuarioRegNumUsuario (Long usuarioRegNumUsuario) {
        modifiedUsuarioRegNumUsuario = true;
        this.usuarioRegNumUsuario = usuarioRegNumUsuario;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegNumUsuario</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegNumUsuario</code>.
    */
    public void setModifiedUsuarioRegNumUsuario(boolean modified) {
        this.modifiedUsuarioRegNumUsuario = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegFechaInicioVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioRegFechaInicioVigencia</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegFechaInicioVigencia</code> attribute.
    */

    public Date getUsuarioRegFechaInicioVigencia()  {
    	Date value;
        value =  usuarioRegFechaInicioVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioRegFechaInicioVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioRegFechaInicioVigencia</code>. Constant Date<br>
    * Comments: <br>
    * @param usuarioRegFechaInicioVigencia The new value of the <code>usuarioRegFechaInicioVigencia</code> attribute.
    */
    public void setUsuarioRegFechaInicioVigencia (Date usuarioRegFechaInicioVigencia) {
        modifiedUsuarioRegFechaInicioVigencia = true;
        this.usuarioRegFechaInicioVigencia = usuarioRegFechaInicioVigencia;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegFechaInicioVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegFechaInicioVigencia</code>.
    */
    public void setModifiedUsuarioRegFechaInicioVigencia(boolean modified) {
        this.modifiedUsuarioRegFechaInicioVigencia = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioRegFechaFinVigencia</code>. Constant Date<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRegFechaFinVigencia</code> attribute.
    */

    public Date getUsuarioRegFechaFinVigencia()  {
    	Date value;
        value =  usuarioRegFechaFinVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioRegFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioRegFechaFinVigencia</code>. Constant Date<br>
    * Comments: <br>
    * @param usuarioRegFechaFinVigencia The new value of the <code>usuarioRegFechaFinVigencia</code> attribute.
    */
    public void setUsuarioRegFechaFinVigencia (Date usuarioRegFechaFinVigencia) {
        modifiedUsuarioRegFechaFinVigencia = true;
        this.usuarioRegFechaFinVigencia = usuarioRegFechaFinVigencia;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegFechaFinVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegFechaFinVigencia</code>.
    */
    public void setModifiedUsuarioRegFechaFinVigencia(boolean modified) {
        this.modifiedUsuarioRegFechaFinVigencia = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegGenero</code> attribute.<br>
    * Model Attribute: <code>usuarioRegGenero</code>. Constant String Size=1<br>
    * Comments: F - Femenino, M - Masculino<br>
    * @return The value of the <code>usuarioRegGenero</code> attribute.
    */

    public String getUsuarioRegGenero()  {
    	String value;
        value =  usuarioRegGenero;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioRegGenero</code> attribute.<br>
    * Model Attribute: <code>usuarioRegGenero</code>. Constant String Size=1<br>
    * Comments: F - Femenino, M - Masculino<br>
    * @param usuarioRegGenero The new value of the <code>usuarioRegGenero</code> attribute.
    */
    public void setUsuarioRegGenero (String usuarioRegGenero) {
        modifiedUsuarioRegGenero = true;
        this.usuarioRegGenero = usuarioRegGenero;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegGenero</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegGenero</code>.
    */
    public void setModifiedUsuarioRegGenero(boolean modified) {
        this.modifiedUsuarioRegGenero = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>usuarioRegFechaNacimiento</code>. Constant Date<br>
    * Comments: Necesaria para realizar las comprobaciones de edades cuando es el titular<br>
    * @return The value of the <code>usuarioRegFechaNacimiento</code> attribute.
    */

    public Date getUsuarioRegFechaNacimiento()  {
    	Date value;
        value =  usuarioRegFechaNacimiento;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioRegFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>usuarioRegFechaNacimiento</code>. Constant Date<br>
    * Comments: Necesaria para realizar las comprobaciones de edades cuando es el titular<br>
    * @param usuarioRegFechaNacimiento The new value of the <code>usuarioRegFechaNacimiento</code> attribute.
    */
    public void setUsuarioRegFechaNacimiento (Date usuarioRegFechaNacimiento) {
        modifiedUsuarioRegFechaNacimiento = true;
        this.usuarioRegFechaNacimiento = usuarioRegFechaNacimiento;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRegFechaNacimiento</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRegFechaNacimiento</code>.
    */
    public void setModifiedUsuarioRegFechaNacimiento(boolean modified) {
        this.modifiedUsuarioRegFechaNacimiento = modified;
    }

   /**
    * Returns the value of the <code>usuarioRegdrvEdad</code> attribute.<br>
    * Model Attribute: <code>usuarioRegdrvEdad</code>. Variable Int<br>
    * Comments: Edad del usuario<br>
    * @return The value of the <code>usuarioRegdrvEdad</code> attribute.
    */

    public Long getUsuarioRegdrvEdad()  {
    	Long value;
        try {
            value = usuarioRegdrvEdadDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: UsuarioReg, Attribute: usuarioRegdrvEdad");
        }
        return value;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitud 1:1  ------ 0:M  UsuariosRegistrados [UsuarioReg]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     */
    @JsonIgnore
    public Solicitud getSolicitud() {
        return solicitud;
    }

   /**
    * Adds an instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
    * @param solicitud The instance to add to the <code>Solicitud</code> role.
    */
    public void add2Solicitud(Solicitud solicitud) {
        if (solicitud == null || solicitud.isNull()) {
            this.modifiedSolicitud = true;
            this.aESOLICITUDESIDSOLICITUD = null;
        } else {
            this.aESOLICITUDESIDSOLICITUD = solicitud.getAESOLICITUDESIDSOLICITUD();
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
     * Returns the instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiario</code> role.
     * Model Relationship:
     * <code>[EstadoBeneficiario] EstadoBeneficiario 0:1  ------ 0:M  UsuariosReg [UsuarioReg]</code>
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
            this.estadoBeneficiarioCodigo = null;
        } else {
            this.estadoBeneficiarioCodigo = estadoBeneficiario.getEstadoBeneficiarioCodigo();
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
     * Returns the instance of <code>Parentesco</code> related through the <code>Parentesco</code> role.
     * Model Relationship:
     * <code>[Parentesco] Parentesco 0:1  ------ 0:M  UsuariosReg [UsuarioReg]</code>
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
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    @JsonIgnore
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Returns the value of the <code>usuarioRegdrvEdad</code> derived attribute.
     *
     * @return Value of the <code>usuarioRegdrvEdad</code> derived attribute.
     */
    public Long usuarioRegdrvEdadDerivations() {
        return usuarioRegdrvEdad;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        usuarioRegTipoIdentificacion = "";
        usuarioRegNumIdentificacion = "";
        usuarioRegTipoYNumDoc = null;
        usuarioRegPrimerNombre = "";
        usuarioRegSegundoNombre = null;
        usuarioRegPrimerApellido = "";
        usuarioRegSegundoApellido = null;
        usuarioRegNumUsuario = null;
        usuarioRegFechaInicioVigencia = null;
        usuarioRegFechaFinVigencia = null;
        usuarioRegGenero = null;
        usuarioRegFechaNacimiento = null;
        solicitud = null;
        estadoBeneficiario = null;
        parentesco = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return UsuarioReg.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return UsuarioRegConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedUsuarioRegTipoIdentificacion = false;
    	values.put("usuarioRegTipoIdentificacion", getUsuarioRegTipoIdentificacion());
    	modifiedUsuarioRegNumIdentificacion = false;
    	values.put("usuarioRegNumIdentificacion", getUsuarioRegNumIdentificacion());
    	modifiedUsuarioRegTipoYNumDoc = false;
    	values.put("usuarioRegTipoYNumDoc", getUsuarioRegTipoYNumDoc());
    	modifiedUsuarioRegPrimerNombre = false;
    	values.put("usuarioRegPrimerNombre", getUsuarioRegPrimerNombre());
    	modifiedUsuarioRegSegundoNombre = false;
    	values.put("usuarioRegSegundoNombre", getUsuarioRegSegundoNombre());
    	modifiedUsuarioRegPrimerApellido = false;
    	values.put("usuarioRegPrimerApellido", getUsuarioRegPrimerApellido());
    	modifiedUsuarioRegSegundoApellido = false;
    	values.put("usuarioRegSegundoApellido", getUsuarioRegSegundoApellido());
    	modifiedUsuarioRegNumUsuario = false;
    	values.put("usuarioRegNumUsuario", getUsuarioRegNumUsuario());
    	modifiedUsuarioRegFechaInicioVigencia = false;
    	values.put("usuarioRegFechaInicioVigencia", getUsuarioRegFechaInicioVigencia());
    	modifiedUsuarioRegFechaFinVigencia = false;
    	values.put("usuarioRegFechaFinVigencia", getUsuarioRegFechaFinVigencia());
    	modifiedUsuarioRegGenero = false;
    	values.put("usuarioRegGenero", getUsuarioRegGenero());
    	modifiedUsuarioRegFechaNacimiento = false;
    	values.put("usuarioRegFechaNacimiento", getUsuarioRegFechaNacimiento());
    	modifiedSolicitud = false;
    	modifiedEstadoBeneficiario = false;
    	modifiedParentesco = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            usuarioRegdrvEdad = null;
    }

    /**
     * Returns the <code>UsuarioRegOid</code> object that identifies this instance of <code>UsuarioReg</code>.
     * @return <code>UsuarioRegOid </code> object that identifies this instance of <code>UsuarioReg</code>
     */
    public UsuarioRegOid getOid() {
        return new UsuarioRegOid(getAESOLICITUDESIDSOLICITUD(), getUsuarioRegIdentificador());
    }

    /**
     * Sets the <code>UsuarioRegOid</code> object that identifies this instance of <code>UsuarioReg</code>.
     */    
    public void setOid(UsuarioRegOid oid) {
        this.oid = oid;
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(UsuarioRegConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(UsuarioRegConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.USUARIOREG)) {
            // Add this class
            activeFacets.add(Constants.USUARIOREG);
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


        if (getAgent().isFacetActive(Constants.AGENT_ASESOR)) {
            returnValue = true;
        }
        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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
