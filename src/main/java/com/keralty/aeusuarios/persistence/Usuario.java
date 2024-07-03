package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.global.PersonaConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioOid;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
 * Persistent representation of the <code>Usuario</code> model class.
 * <p>
 * Model Class: <code>Usuario</code><br>
 */
@Entity(name = UsuarioConstants.CLASS_NAME)
@Table(name = UsuarioConstants.TBL_NAME)
public class Usuario extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private transient UserFunctions userFunctionsSrv;

    /** Embedded Class Identification Function */
    @EmbeddedId
    private UsuarioOid oid;

    /** Class identification function. */
    @Column(name = UsuarioConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false )
    @JsonProperty(value="id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;

    /** Class identification function. */
    @Column(name = UsuarioConstants.FLD_USUARIOIDENTIFICADOR, insertable = false, updatable = false )
    @JsonProperty(value="identificador")
    private Long usuarioIdentificador;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOBEBEGESTANTE )
    @JsonProperty(value="bebegestante")
    private Boolean usuarioBebeGestante;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioBebeGestante;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIONUMUSUARIO )
    @JsonProperty(value="numusuario")
    private Long usuarioNumUsuario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNumUsuario;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIONUMIDENTIFICACION )
    @JsonProperty(value="numidentificacion")
    private String usuarioNumIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioNumIdentificacion;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOCODIGOTIPOUSUARIO )
    @JsonProperty(value="codigotipousuario")
    private Long usuarioCodigoTipoUsuario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioCodigoTipoUsuario;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOPRIMERNOMBRE )
    @JsonProperty(value="primernombre")
    private String usuarioPrimerNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioPrimerNombre;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOSEGUNDONOMBRE )
    @JsonProperty(value="segundonombre")
    private String usuarioSegundoNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioSegundoNombre;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOPRIMERAPELLIDO )
    @JsonProperty(value="primerapellido")
    private String usuarioPrimerApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioPrimerApellido;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOSEGUNDOAPELLIDO )
    @JsonProperty(value="segundoapellido")
    private String usuarioSegundoApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioSegundoApellido;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvidentificacion")
    protected String usuariodrvIdentificacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drveseltitular")
    protected Boolean usuariodrvEsElTitular;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvaccesocuesmed")
    protected Boolean usuariodrvAccesoCuesMed;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvaceptaanexomat")
    protected Boolean usuariodrvAceptaAnexoMat;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvaceptaanexoneo")
    protected Boolean usuariodrvAceptaAnexoNeo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtieneanexomat")
    protected Boolean usuariodrvTieneAnexoMat;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOATTRUSUARIODILIGENCIADOS )
    @JsonProperty(value="attrusuariodiligenciados")
    private Boolean usuarioattrUsuarioDiligenciados;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioattrUsuarioDiligenciados;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedadparacuotains")
    protected Long usuariodrvEdadParaCuotaIns;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorcuotainscrip")
    protected Double usuariodrvValorCuotaInscrip;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvcuesmedok")
    protected Boolean usuariodrvCuesMedOK;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOCODIGOBANCOREP )
    @JsonProperty(value="codigobancorep")
    private String usuariocodigoBancoRep;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuariocodigoBancoRep;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOUSUARIOREPLICADO )
    @JsonProperty(value="usuarioreplicado")
    private Boolean usuarioUsuarioReplicado;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioUsuarioReplicado;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOFECHAANTIGUEDADBENEFICIARIO )
    @JsonProperty(value="fechaantiguedadbeneficiario")
    private Date usuarioFechaAntiguedadBeneficiario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioFechaAntiguedadBeneficiario;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOREQUIEREXAMENMEDICO )
    @JsonProperty(value="requierexamenmedico")
    private Boolean usuarioRequierExamenMedico;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioRequierExamenMedico;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOESTADOMEDICO )
    @JsonProperty(value="estadomedico")
    private Long usuarioEstadoMedico;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioEstadoMedico;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOVALORCUOTAINSCRIPCION )
    @JsonProperty(value="valorcuotainscripcion")
    private Double usuarioValorCuotaInscripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioValorCuotaInscripcion;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOTIENEPREEXISTENCIAS )
    @JsonProperty(value="tienepreexistencias")
    private Boolean usuarioTienePreexistencias;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioTienePreexistencias;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnombrecompleto")
    protected String usuariodrvNombreCompleto;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOFECHAINICIOVIGENCIA )
    @JsonProperty(value="fechainiciovigencia")
    private Date usuarioFechaInicioVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioFechaInicioVigencia;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOFECHAFINVIGENCIA )
    @JsonProperty(value="fechafinvigencia")
    private Date usuarioFechaFinVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioFechaFinVigencia;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvconfirmado")
    protected Boolean usuariodrvConfirmado;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtiempoembarazo")
    protected Long usuariodrvTiempoEmbarazo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvestaactivo")
    protected Boolean usuariodrvEstaActivo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedad")
    protected Long usuariodrvEdad;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedadmaxingreso")
    protected Long usuariodrvEdadMaxIngreso;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedadmaxperm")
    protected Long usuariodrvEdadMaxPerm;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtotalanexos")
    protected Double usuariodrvTotalAnexos;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtieneepssanitas")
    protected Boolean usuariodrvTieneEPSSanitas;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienedocumentos")
    protected Boolean usuariodrvTieneDocumentos;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOTIENEDOCIDENTIFICACION )
    @JsonProperty(value="tienedocidentificacion")
    private Boolean usuariotieneDocIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuariotieneDocIdentificacion;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOTIENEDOCSSOLICITUD )
    @JsonProperty(value="tienedocssolicitud")
    private Boolean usuariotieneDocsSolicitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuariotieneDocsSolicitud;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtieneparentesco")
    protected Boolean usuariodrvTieneParentesco;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvpuedesertitular")
    protected Boolean usuariodrvPuedeSerTitular;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienecuesmed")
    protected Boolean usuariodrvTieneCuesMed;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvimptarifaplanvol")
    protected Double usuariodrvImpTarifaPlanVol;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOPOLIZAINTERNACIONAL )
    @JsonProperty(value="polizainternacional")
    private Boolean usuarioPolizaInternacional;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioPolizaInternacional;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvdirresvalidoeps")
    protected Boolean usuariodrvDirResValidoEPS;

    /** Class member attribute. */
    @Column(name = UsuarioConstants.FLD_USUARIOIMC )
    @JsonProperty(value="imc")
    private Double usuarioIMC;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioIMC;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = UsuarioConstants.ROLE_INVNAME_CUESTIONARIOP)
    @JsonIgnore
    private CuestionarioP cuestionarioP;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedCuestionarioP;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = UsuarioConstants.ROLE_INVNAME_ANEXOMAT)
    @JsonIgnore
    private AnexoMat anexoMat;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAnexoMat;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = UsuarioConstants.ROLE_INVNAME_ANEXONEO)
    @JsonIgnore
    private AnexoNeo anexoNeo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAnexoNeo;

    /** Related Class. */
    @OneToMany(mappedBy = UsuarioConstants.ROLE_INVNAME_PREEXISTENCIAS)
    @JsonIgnore
    private Collection <Preexistencia> preexistencias;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPreexistencias;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false)
    })
    @JsonIgnore
    private Solicitud solicitud;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitud;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioConstants.FLD_PERSONAUSUARIOPERSONAIDENTIFICADOR, referencedColumnName=PersonaConstants.FLD_PERSONAIDENTIFICADOR)
    })
    @JsonIgnore
    private Persona usuarioPersona;
    /** Related attribute. */
    @Column(name = UsuarioConstants.FLD_PERSONAUSUARIOPERSONAIDENTIFICADOR, insertable = false, updatable = false)
    private Long personaUsuarioPersonaIdentificador;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedUsuarioPersona;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioConstants.FLD_PARENTESCOPARENTESCOCODIGO, referencedColumnName=ParentescoConstants.FLD_PARENTESCOCODIGO)
    })
    @JsonIgnore
    private Parentesco parentesco;
    /** Related attribute. */
    @Column(name = UsuarioConstants.FLD_PARENTESCOPARENTESCOCODIGO, insertable = false, updatable = false)
    private Long parentescoParentescoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedParentesco;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCODIGO, referencedColumnName=TipoIdentificacionConstants.FLD_TIPOIDENTIFICACIONCODIGO)
    })
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacion;
    /** Related attribute. */
    @Column(name = UsuarioConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCODIGO, insertable = false, updatable = false)
    private Long tipoIdentificacionTipoIdentificacionCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoIdentificacion;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=UsuarioConstants.FLD_ESTADOBENEFICIARIOESTADOBENEFICIARIOCODIGO, referencedColumnName=EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOCODIGO)
    })
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiario;
    /** Related attribute. */
    @Column(name = UsuarioConstants.FLD_ESTADOBENEFICIARIOESTADOBENEFICIARIOCODIGO, insertable = false, updatable = false)
    private Long estadoBeneficiarioEstadoBeneficiarioCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiario;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Usuario() {
        aESOLICITUDESIDSOLICITUD = null;
        usuarioIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Usuario</code>.
     * @param oid Object Identifier of the instance of <code>Usuario</code> to be created.
     * @throws SystemException
     */
    public Usuario(UsuarioOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            aESOLICITUDESIDSOLICITUD = oid.getAESOLICITUDESIDSOLICITUD();
            usuarioIdentificador = oid.getUsuarioIdentificador();
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
     * Returns the value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Usuario</code>
     * @return The value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code>.
     */
    public Long getUsuarioIdentificador() {
        return usuarioIdentificador;
    }

    /**
     * Sets the value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Usuario</code>
     * @param usuarioIdentificador The new value of the <code>usuarioIdentificador</code> attribute<br>in class <code>Usuario</code>.
     */
    public void setUsuarioIdentificador(Long usuarioIdentificador) {
        this.usuarioIdentificador = usuarioIdentificador;
    }

   /**
    * Returns the value of the <code>usuarioBebeGestante</code> attribute.<br>
    * Model Attribute: <code>usuarioBebeGestante</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioBebeGestante</code> attribute.
    */

    public Boolean getUsuarioBebeGestante()  {
    	Boolean value;
        value =  usuarioBebeGestante;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioBebeGestante</code> attribute.<br>
    * Model Attribute: <code>usuarioBebeGestante</code>. Variable Bool<br>
    * Comments: <br>
    * @param usuarioBebeGestante The new value of the <code>usuarioBebeGestante</code> attribute.
    */
    public void setUsuarioBebeGestante (Boolean usuarioBebeGestante) {
        modifiedUsuarioBebeGestante = true;
        this.usuarioBebeGestante = usuarioBebeGestante;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioBebeGestante</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioBebeGestante</code>.
    */
    public void setModifiedUsuarioBebeGestante(boolean modified) {
        this.modifiedUsuarioBebeGestante = modified;
    }

   /**
    * Returns the value of the <code>usuarioNumUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioNumUsuario</code>. Variable Int<br>
    * Comments: Este es el código de persona que en el CORE<br>
    * @return The value of the <code>usuarioNumUsuario</code> attribute.
    */

    public Long getUsuarioNumUsuario()  {
    	Long value;
        value =  usuarioNumUsuario;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioNumUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioNumUsuario</code>. Variable Int<br>
    * Comments: Este es el código de persona que en el CORE<br>
    * @param usuarioNumUsuario The new value of the <code>usuarioNumUsuario</code> attribute.
    */
    public void setUsuarioNumUsuario (Long usuarioNumUsuario) {
        modifiedUsuarioNumUsuario = true;
        this.usuarioNumUsuario = usuarioNumUsuario;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNumUsuario</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNumUsuario</code>.
    */
    public void setModifiedUsuarioNumUsuario(boolean modified) {
        this.modifiedUsuarioNumUsuario = modified;
    }

   /**
    * Returns the value of the <code>usuarioNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>usuarioNumIdentificacion</code> attribute.
    */

    public String getUsuarioNumIdentificacion()  {
    	String value;
        value =  usuarioNumIdentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuarioNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @param usuarioNumIdentificacion The new value of the <code>usuarioNumIdentificacion</code> attribute.
    */
    public void setUsuarioNumIdentificacion (String usuarioNumIdentificacion) {
        modifiedUsuarioNumIdentificacion = true;
        this.usuarioNumIdentificacion = usuarioNumIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioNumIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioNumIdentificacion</code>.
    */
    public void setModifiedUsuarioNumIdentificacion(boolean modified) {
        this.modifiedUsuarioNumIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>usuarioCodigoTipoUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioCodigoTipoUsuario</code>. Variable Nat<br>
    * Comments: Indica si el tipo de usuario dentro del contrato es Beneficiario o Titular. 1 - BENEFICIARIO,  2 - TITULAR
<br>
    * @return The value of the <code>usuarioCodigoTipoUsuario</code> attribute.
    */

    public Long getUsuarioCodigoTipoUsuario()  {
    	Long value;
        value =  usuarioCodigoTipoUsuario;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioCodigoTipoUsuario</code> attribute.<br>
    * Model Attribute: <code>usuarioCodigoTipoUsuario</code>. Variable Nat<br>
    * Comments: Indica si el tipo de usuario dentro del contrato es Beneficiario o Titular. 1 - BENEFICIARIO,  2 - TITULAR
<br>
    * @param usuarioCodigoTipoUsuario The new value of the <code>usuarioCodigoTipoUsuario</code> attribute.
    */
    public void setUsuarioCodigoTipoUsuario (Long usuarioCodigoTipoUsuario) {
        modifiedUsuarioCodigoTipoUsuario = true;
        this.usuarioCodigoTipoUsuario = usuarioCodigoTipoUsuario;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioCodigoTipoUsuario</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioCodigoTipoUsuario</code>.
    */
    public void setModifiedUsuarioCodigoTipoUsuario(boolean modified) {
        this.modifiedUsuarioCodigoTipoUsuario = modified;
    }

   /**
    * Returns the value of the <code>usuarioPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioPrimerNombre</code> attribute.
    */

    public String getUsuarioPrimerNombre()  {
    	String value;
        value =  usuarioPrimerNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioPrimerNombre The new value of the <code>usuarioPrimerNombre</code> attribute.
    */
    public void setUsuarioPrimerNombre (String usuarioPrimerNombre) {
        modifiedUsuarioPrimerNombre = true;
        this.usuarioPrimerNombre = usuarioPrimerNombre;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioPrimerNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioPrimerNombre</code>.
    */
    public void setModifiedUsuarioPrimerNombre(boolean modified) {
        this.modifiedUsuarioPrimerNombre = modified;
    }

   /**
    * Returns the value of the <code>usuarioSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioSegundoNombre</code> attribute.
    */

    public String getUsuarioSegundoNombre()  {
    	String value;
        value =  usuarioSegundoNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>usuarioSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioSegundoNombre The new value of the <code>usuarioSegundoNombre</code> attribute.
    */
    public void setUsuarioSegundoNombre (String usuarioSegundoNombre) {
        modifiedUsuarioSegundoNombre = true;
        this.usuarioSegundoNombre = usuarioSegundoNombre;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioSegundoNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioSegundoNombre</code>.
    */
    public void setModifiedUsuarioSegundoNombre(boolean modified) {
        this.modifiedUsuarioSegundoNombre = modified;
    }

   /**
    * Returns the value of the <code>usuarioPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioPrimerApellido</code> attribute.
    */

    public String getUsuarioPrimerApellido()  {
    	String value;
        value =  usuarioPrimerApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioPrimerApellido The new value of the <code>usuarioPrimerApellido</code> attribute.
    */
    public void setUsuarioPrimerApellido (String usuarioPrimerApellido) {
        modifiedUsuarioPrimerApellido = true;
        this.usuarioPrimerApellido = usuarioPrimerApellido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioPrimerApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioPrimerApellido</code>.
    */
    public void setModifiedUsuarioPrimerApellido(boolean modified) {
        this.modifiedUsuarioPrimerApellido = modified;
    }

   /**
    * Returns the value of the <code>usuarioSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>usuarioSegundoApellido</code> attribute.
    */

    public String getUsuarioSegundoApellido()  {
    	String value;
        value =  usuarioSegundoApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuarioSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>usuarioSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param usuarioSegundoApellido The new value of the <code>usuarioSegundoApellido</code> attribute.
    */
    public void setUsuarioSegundoApellido (String usuarioSegundoApellido) {
        modifiedUsuarioSegundoApellido = true;
        this.usuarioSegundoApellido = usuarioSegundoApellido;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioSegundoApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioSegundoApellido</code>.
    */
    public void setModifiedUsuarioSegundoApellido(boolean modified) {
        this.modifiedUsuarioSegundoApellido = modified;
    }

   /**
    * Returns the value of the <code>usuariodrvIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuariodrvIdentificacion</code>. Variable String Size=100<br>
    * Comments: Para ser usado en display sets<br>
    * @return The value of the <code>usuariodrvIdentificacion</code> attribute.
    */

    public String getUsuariodrvIdentificacion()  {
    	String value;
        try {
            value = usuariodrvIdentificacionDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvIdentificacion");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>usuariodrvEsElTitular</code> attribute.<br>
    * Model Attribute: <code>usuariodrvEsElTitular</code>. Variable Bool<br>
    * Comments: El que tiene el parentesco titular<br>
    * @return The value of the <code>usuariodrvEsElTitular</code> attribute.
    */

    public Boolean getUsuariodrvEsElTitular()  {
    	Boolean value;
        try {
            value = usuariodrvEsElTitularDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvEsElTitular");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvAccesoCuesMed</code> attribute.<br>
    * Model Attribute: <code>usuariodrvAccesoCuesMed</code>. Variable Bool<br>
    * Comments: Se utilizará en precondiciones para saber si se le tiene que habilitar el LINK de cuestionario médico o no.  En la creación del usuario ya se ha controlado si tiene que crearsele el cuestionario médico o no, esto es, si lo debe diligenciar o no. <br>
    * @return The value of the <code>usuariodrvAccesoCuesMed</code> attribute.
    */

    public Boolean getUsuariodrvAccesoCuesMed()  {
    	Boolean value;
        try {
            value = usuariodrvAccesoCuesMedDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvAccesoCuesMed");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvAceptaAnexoMat</code> attribute.<br>
    * Model Attribute: <code>usuariodrvAceptaAnexoMat</code>. Variable Bool<br>
    * Comments: Derivado para ser usado en una precondición y que funcione la anticipación. <br>
    * @return The value of the <code>usuariodrvAceptaAnexoMat</code> attribute.
    */

    public Boolean getUsuariodrvAceptaAnexoMat()  {
    	Boolean value;
        try {
            value = usuariodrvAceptaAnexoMatDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvAceptaAnexoMat");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvAceptaAnexoNeo</code> attribute.<br>
    * Model Attribute: <code>usuariodrvAceptaAnexoNeo</code>. Variable Bool<br>
    * Comments: Derivado para ser usado en una precondición y que funcione la anticipación. <br>
    * @return The value of the <code>usuariodrvAceptaAnexoNeo</code> attribute.
    */

    public Boolean getUsuariodrvAceptaAnexoNeo()  {
    	Boolean value;
        try {
            value = usuariodrvAceptaAnexoNeoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvAceptaAnexoNeo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvTieneAnexoMat</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTieneAnexoMat</code>. Variable Bool<br>
    * Comments: Derivado para ser usado en una precondición y que funcione la anticipación. <br>
    * @return The value of the <code>usuariodrvTieneAnexoMat</code> attribute.
    */

    public Boolean getUsuariodrvTieneAnexoMat()  {
    	Boolean value;
        try {
            value = usuariodrvTieneAnexoMatDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTieneAnexoMat");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioattrUsuarioDiligenciados</code> attribute.<br>
    * Model Attribute: <code>usuarioattrUsuarioDiligenciados</code>. Variable Bool<br>
    * Comments: Marca que se pondrá a TRUE cuando ya se hayan diligenciado los atributos de usuario. Es necesario saberlo porque si no no se puede diligenciar el cuestionario médico.<br>
    * @return The value of the <code>usuarioattrUsuarioDiligenciados</code> attribute.
    */

    public Boolean getUsuarioattrUsuarioDiligenciados()  {
    	Boolean value;
        value =  usuarioattrUsuarioDiligenciados;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioattrUsuarioDiligenciados</code> attribute.<br>
    * Model Attribute: <code>usuarioattrUsuarioDiligenciados</code>. Variable Bool<br>
    * Comments: Marca que se pondrá a TRUE cuando ya se hayan diligenciado los atributos de usuario. Es necesario saberlo porque si no no se puede diligenciar el cuestionario médico.<br>
    * @param usuarioattrUsuarioDiligenciados The new value of the <code>usuarioattrUsuarioDiligenciados</code> attribute.
    */
    public void setUsuarioattrUsuarioDiligenciados (Boolean usuarioattrUsuarioDiligenciados) {
        modifiedUsuarioattrUsuarioDiligenciados = true;
        this.usuarioattrUsuarioDiligenciados = usuarioattrUsuarioDiligenciados;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioattrUsuarioDiligenciados</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioattrUsuarioDiligenciados</code>.
    */
    public void setModifiedUsuarioattrUsuarioDiligenciados(boolean modified) {
        this.modifiedUsuarioattrUsuarioDiligenciados = modified;
    }

   /**
    * Returns the value of the <code>usuariodrvEdadParaCuotaIns</code> attribute.<br>
    * Model Attribute: <code>usuariodrvEdadParaCuotaIns</code>. Variable Int<br>
    * Comments: Es la edad de este usuario tomando la fecha de nacimiento vs la fecha de inicio de vigencia del contrato<br>
    * @return The value of the <code>usuariodrvEdadParaCuotaIns</code> attribute.
    */

    public Long getUsuariodrvEdadParaCuotaIns()  {
    	Long value;
        try {
            value = usuariodrvEdadParaCuotaInsDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvEdadParaCuotaIns");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvValorCuotaInscrip</code> attribute.<br>
    * Model Attribute: <code>usuariodrvValorCuotaInscrip</code>. Variable Real<br>
    * Comments: Derivado que será usado desde la solicitud para calcular el valor de la cuota de inscripción. <br>
    * @return The value of the <code>usuariodrvValorCuotaInscrip</code> attribute.
    */

    public Double getUsuariodrvValorCuotaInscrip()  {
    	Double value;
        try {
            value = usuariodrvValorCuotaInscripDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvValorCuotaInscrip");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvCuesMedOK</code> attribute.<br>
    * Model Attribute: <code>usuariodrvCuesMedOK</code>. Variable Bool<br>
    * Comments: Si se tiene que diligenciar cuestionario médico, verifica que ya lo tiene diligenciado<br>
    * @return The value of the <code>usuariodrvCuesMedOK</code> attribute.
    */

    public Boolean getUsuariodrvCuesMedOK()  {
    	Boolean value;
        try {
            value = usuariodrvCuesMedOKDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvCuesMedOK");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariocodigoBancoRep</code> attribute.<br>
    * Model Attribute: <code>usuariocodigoBancoRep</code>. Variable String Size=30<br>
    * Comments: <br>
    * @return The value of the <code>usuariocodigoBancoRep</code> attribute.
    */

    public String getUsuariocodigoBancoRep()  {
    	String value;
        value =  usuariocodigoBancoRep;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>usuariocodigoBancoRep</code> attribute.<br>
    * Model Attribute: <code>usuariocodigoBancoRep</code>. Variable String Size=30<br>
    * Comments: <br>
    * @param usuariocodigoBancoRep The new value of the <code>usuariocodigoBancoRep</code> attribute.
    */
    public void setUsuariocodigoBancoRep (String usuariocodigoBancoRep) {
        modifiedUsuariocodigoBancoRep = true;
        this.usuariocodigoBancoRep = usuariocodigoBancoRep;
    }

   /**
    * Sets the value of the <code>modifiedUsuariocodigoBancoRep</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuariocodigoBancoRep</code>.
    */
    public void setModifiedUsuariocodigoBancoRep(boolean modified) {
        this.modifiedUsuariocodigoBancoRep = modified;
    }

   /**
    * Returns the value of the <code>usuarioUsuarioReplicado</code> attribute.<br>
    * Model Attribute: <code>usuarioUsuarioReplicado</code>. Constant Bool<br>
    * Comments: Indica que este usuario se ha replicado porque se seleccionó un contrato anterior. En este caso si tenía código de banco de la república el dato no se puede modificar<br>
    * @return The value of the <code>usuarioUsuarioReplicado</code> attribute.
    */

    public Boolean getUsuarioUsuarioReplicado()  {
    	Boolean value;
        value =  usuarioUsuarioReplicado;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioUsuarioReplicado</code> attribute.<br>
    * Model Attribute: <code>usuarioUsuarioReplicado</code>. Constant Bool<br>
    * Comments: Indica que este usuario se ha replicado porque se seleccionó un contrato anterior. En este caso si tenía código de banco de la república el dato no se puede modificar<br>
    * @param usuarioUsuarioReplicado The new value of the <code>usuarioUsuarioReplicado</code> attribute.
    */
    public void setUsuarioUsuarioReplicado (Boolean usuarioUsuarioReplicado) {
        modifiedUsuarioUsuarioReplicado = true;
        this.usuarioUsuarioReplicado = usuarioUsuarioReplicado;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioUsuarioReplicado</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioUsuarioReplicado</code>.
    */
    public void setModifiedUsuarioUsuarioReplicado(boolean modified) {
        this.modifiedUsuarioUsuarioReplicado = modified;
    }

   /**
    * Returns the value of the <code>usuarioFechaAntiguedadBeneficiario</code> attribute.<br>
    * Model Attribute: <code>usuarioFechaAntiguedadBeneficiario</code>. Variable Date<br>
    * Comments: Nos la devuelve el CORE. Fecha que indica la antigüedad de un beneficiario en una compañía de medicina prepagada diferente a la OSI <br>
    * @return The value of the <code>usuarioFechaAntiguedadBeneficiario</code> attribute.
    */

    public Date getUsuarioFechaAntiguedadBeneficiario()  {
    	Date value;
        value =  usuarioFechaAntiguedadBeneficiario;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioFechaAntiguedadBeneficiario</code> attribute.<br>
    * Model Attribute: <code>usuarioFechaAntiguedadBeneficiario</code>. Variable Date<br>
    * Comments: Nos la devuelve el CORE. Fecha que indica la antigüedad de un beneficiario en una compañía de medicina prepagada diferente a la OSI <br>
    * @param usuarioFechaAntiguedadBeneficiario The new value of the <code>usuarioFechaAntiguedadBeneficiario</code> attribute.
    */
    public void setUsuarioFechaAntiguedadBeneficiario (Date usuarioFechaAntiguedadBeneficiario) {
        modifiedUsuarioFechaAntiguedadBeneficiario = true;
        this.usuarioFechaAntiguedadBeneficiario = usuarioFechaAntiguedadBeneficiario;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioFechaAntiguedadBeneficiario</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioFechaAntiguedadBeneficiario</code>.
    */
    public void setModifiedUsuarioFechaAntiguedadBeneficiario(boolean modified) {
        this.modifiedUsuarioFechaAntiguedadBeneficiario = modified;
    }

   /**
    * Returns the value of the <code>usuarioRequierExamenMedico</code> attribute.<br>
    * Model Attribute: <code>usuarioRequierExamenMedico</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>usuarioRequierExamenMedico</code> attribute.
    */

    public Boolean getUsuarioRequierExamenMedico()  {
    	Boolean value;
        value =  usuarioRequierExamenMedico;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioRequierExamenMedico</code> attribute.<br>
    * Model Attribute: <code>usuarioRequierExamenMedico</code>. Variable Bool<br>
    * Comments: <br>
    * @param usuarioRequierExamenMedico The new value of the <code>usuarioRequierExamenMedico</code> attribute.
    */
    public void setUsuarioRequierExamenMedico (Boolean usuarioRequierExamenMedico) {
        modifiedUsuarioRequierExamenMedico = true;
        this.usuarioRequierExamenMedico = usuarioRequierExamenMedico;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioRequierExamenMedico</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioRequierExamenMedico</code>.
    */
    public void setModifiedUsuarioRequierExamenMedico(boolean modified) {
        this.modifiedUsuarioRequierExamenMedico = modified;
    }

   /**
    * Returns the value of the <code>usuarioEstadoMedico</code> attribute.<br>
    * Model Attribute: <code>usuarioEstadoMedico</code>. Variable Nat<br>
    * Comments: 1 - APROBADO 
2 - RECHAZADO
3 - PENDIENTE 
4 - PENDIENTE EXAMEN MEDICO<br>
    * @return The value of the <code>usuarioEstadoMedico</code> attribute.
    */

    public Long getUsuarioEstadoMedico()  {
    	Long value;
        value =  usuarioEstadoMedico;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioEstadoMedico</code> attribute.<br>
    * Model Attribute: <code>usuarioEstadoMedico</code>. Variable Nat<br>
    * Comments: 1 - APROBADO 
2 - RECHAZADO
3 - PENDIENTE 
4 - PENDIENTE EXAMEN MEDICO<br>
    * @param usuarioEstadoMedico The new value of the <code>usuarioEstadoMedico</code> attribute.
    */
    public void setUsuarioEstadoMedico (Long usuarioEstadoMedico) {
        modifiedUsuarioEstadoMedico = true;
        this.usuarioEstadoMedico = usuarioEstadoMedico;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioEstadoMedico</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioEstadoMedico</code>.
    */
    public void setModifiedUsuarioEstadoMedico(boolean modified) {
        this.modifiedUsuarioEstadoMedico = modified;
    }

   /**
    * Returns the value of the <code>usuarioValorCuotaInscripcion</code> attribute.<br>
    * Model Attribute: <code>usuarioValorCuotaInscripcion</code>. Variable Real<br>
    * Comments: Lo devuelve el CORE. El valor de la cuota de inscripción aplica cuando la persona es mayor a 64 años.<br>
    * @return The value of the <code>usuarioValorCuotaInscripcion</code> attribute.
    */

    public Double getUsuarioValorCuotaInscripcion()  {
    	Double value;
        value =  usuarioValorCuotaInscripcion;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioValorCuotaInscripcion</code> attribute.<br>
    * Model Attribute: <code>usuarioValorCuotaInscripcion</code>. Variable Real<br>
    * Comments: Lo devuelve el CORE. El valor de la cuota de inscripción aplica cuando la persona es mayor a 64 años.<br>
    * @param usuarioValorCuotaInscripcion The new value of the <code>usuarioValorCuotaInscripcion</code> attribute.
    */
    public void setUsuarioValorCuotaInscripcion (Double usuarioValorCuotaInscripcion) {
        modifiedUsuarioValorCuotaInscripcion = true;
        this.usuarioValorCuotaInscripcion = usuarioValorCuotaInscripcion;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioValorCuotaInscripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioValorCuotaInscripcion</code>.
    */
    public void setModifiedUsuarioValorCuotaInscripcion(boolean modified) {
        this.modifiedUsuarioValorCuotaInscripcion = modified;
    }

   /**
    * Returns the value of the <code>usuarioTienePreexistencias</code> attribute.<br>
    * Model Attribute: <code>usuarioTienePreexistencias</code>. Variable Bool<br>
    * Comments: Nos lo devuelve el CORE. Marca para identificar que el usuario tiene preexistencias. <br>
    * @return The value of the <code>usuarioTienePreexistencias</code> attribute.
    */

    public Boolean getUsuarioTienePreexistencias()  {
    	Boolean value;
        value =  usuarioTienePreexistencias;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioTienePreexistencias</code> attribute.<br>
    * Model Attribute: <code>usuarioTienePreexistencias</code>. Variable Bool<br>
    * Comments: Nos lo devuelve el CORE. Marca para identificar que el usuario tiene preexistencias. <br>
    * @param usuarioTienePreexistencias The new value of the <code>usuarioTienePreexistencias</code> attribute.
    */
    public void setUsuarioTienePreexistencias (Boolean usuarioTienePreexistencias) {
        modifiedUsuarioTienePreexistencias = true;
        this.usuarioTienePreexistencias = usuarioTienePreexistencias;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioTienePreexistencias</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioTienePreexistencias</code>.
    */
    public void setModifiedUsuarioTienePreexistencias(boolean modified) {
        this.modifiedUsuarioTienePreexistencias = modified;
    }

   /**
    * Returns the value of the <code>usuariodrvNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>usuariodrvNombreCompleto</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>usuariodrvNombreCompleto</code> attribute.
    */

    public String getUsuariodrvNombreCompleto()  {
    	String value;
        try {
            value = usuariodrvNombreCompletoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvNombreCompleto");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>usuarioFechaInicioVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioFechaInicioVigencia</code>. Variable Date<br>
    * Comments: Lo devuelve el CORE. <br>
    * @return The value of the <code>usuarioFechaInicioVigencia</code> attribute.
    */

    public Date getUsuarioFechaInicioVigencia()  {
    	Date value;
        value =  usuarioFechaInicioVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioFechaInicioVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioFechaInicioVigencia</code>. Variable Date<br>
    * Comments: Lo devuelve el CORE. <br>
    * @param usuarioFechaInicioVigencia The new value of the <code>usuarioFechaInicioVigencia</code> attribute.
    */
    public void setUsuarioFechaInicioVigencia (Date usuarioFechaInicioVigencia) {
        modifiedUsuarioFechaInicioVigencia = true;
        this.usuarioFechaInicioVigencia = usuarioFechaInicioVigencia;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioFechaInicioVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioFechaInicioVigencia</code>.
    */
    public void setModifiedUsuarioFechaInicioVigencia(boolean modified) {
        this.modifiedUsuarioFechaInicioVigencia = modified;
    }

   /**
    * Returns the value of the <code>usuarioFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioFechaFinVigencia</code>. Variable Date<br>
    * Comments: Lo devuelve el CORE. <br>
    * @return The value of the <code>usuarioFechaFinVigencia</code> attribute.
    */

    public Date getUsuarioFechaFinVigencia()  {
    	Date value;
        value =  usuarioFechaFinVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>usuarioFechaFinVigencia</code>. Variable Date<br>
    * Comments: Lo devuelve el CORE. <br>
    * @param usuarioFechaFinVigencia The new value of the <code>usuarioFechaFinVigencia</code> attribute.
    */
    public void setUsuarioFechaFinVigencia (Date usuarioFechaFinVigencia) {
        modifiedUsuarioFechaFinVigencia = true;
        this.usuarioFechaFinVigencia = usuarioFechaFinVigencia;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioFechaFinVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioFechaFinVigencia</code>.
    */
    public void setModifiedUsuarioFechaFinVigencia(boolean modified) {
        this.modifiedUsuarioFechaFinVigencia = modified;
    }

   /**
    * Returns the value of the <code>usuariodrvConfirmado</code> attribute.<br>
    * Model Attribute: <code>usuariodrvConfirmado</code>. Variable Bool<br>
    * Comments: Si el usuario está confirmado. <br>
    * @return The value of the <code>usuariodrvConfirmado</code> attribute.
    */

    public Boolean getUsuariodrvConfirmado()  {
    	Boolean value;
        try {
            value = usuariodrvConfirmadoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvConfirmado");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvTiempoEmbarazo</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTiempoEmbarazo</code>. Variable Int<br>
    * Comments: Si ha dicho en el cuestionario que está embarazada, se guarda el tiempo de embarazo en semanas<br>
    * @return The value of the <code>usuariodrvTiempoEmbarazo</code> attribute.
    */

    public Long getUsuariodrvTiempoEmbarazo()  {
    	Long value;
        try {
            value = usuariodrvTiempoEmbarazoDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTiempoEmbarazo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvEstaActivo</code> attribute.<br>
    * Model Attribute: <code>usuariodrvEstaActivo</code>. Variable Bool<br>
    * Comments: Mientras el usuario no tenga estado, diremos que está activo, ya que este derivado sólo se usará en precondiciones y antes de enviar al CORE suponemos que estará activo. Luego el CORE ya nos devolverá el estado que toque. <br>
    * @return The value of the <code>usuariodrvEstaActivo</code> attribute.
    */

    public Boolean getUsuariodrvEstaActivo()  {
    	Boolean value;
        try {
            value = usuariodrvEstaActivoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvEstaActivo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvEdad</code> attribute.<br>
    * Model Attribute: <code>usuariodrvEdad</code>. Variable Int<br>
    * Comments: Se utilizará para validaciones. <br>
    * @return The value of the <code>usuariodrvEdad</code> attribute.
    */

    public Long getUsuariodrvEdad()  {
    	Long value;
        try {
            value = usuariodrvEdadDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvEdad");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvEdadMaxIngreso</code> attribute.<br>
    * Model Attribute: <code>usuariodrvEdadMaxIngreso</code>. Variable Int<br>
    * Comments: Edad máxima de ingreso en la solicitud, según esté configurado en el dominio para el parentesco de este usuario.
Si no está configurada en el plan no debemos verificar la condición, por eso le ponemos una edad imposible<br>
    * @return The value of the <code>usuariodrvEdadMaxIngreso</code> attribute.
    */

    public Long getUsuariodrvEdadMaxIngreso()  {
    	Long value;
        try {
            value = usuariodrvEdadMaxIngresoDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvEdadMaxIngreso");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvEdadMaxPerm</code> attribute.<br>
    * Model Attribute: <code>usuariodrvEdadMaxPerm</code>. Variable Int<br>
    * Comments: Edad máxima de permanencia en la solicitud, según esté configurado en el dominio para el parentesco de este usuario
Si no está configurada en el plan no debemos verificar la condición, por eso le ponemos una edad imposible<br>
    * @return The value of the <code>usuariodrvEdadMaxPerm</code> attribute.
    */

    public Long getUsuariodrvEdadMaxPerm()  {
    	Long value;
        try {
            value = usuariodrvEdadMaxPermDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvEdadMaxPerm");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvTotalAnexos</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTotalAnexos</code>. Variable Real<br>
    * Comments: Valor que tiene parametrizada la tarifa para los anexos de maternidad y neonatal.<br>
    * @return The value of the <code>usuariodrvTotalAnexos</code> attribute.
    */

    public Double getUsuariodrvTotalAnexos()  {
    	Double value;
        try {
            value = usuariodrvTotalAnexosDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTotalAnexos");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvTieneEPSSanitas</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTieneEPSSanitas</code>. Variable Bool<br>
    * Comments: Se utilizará en precondiciones para controlar que para un usuario que tenga EPS Sanitas NO se pueda subir un documento de tipo "Documentos de Solicitud"<br>
    * @return The value of the <code>usuariodrvTieneEPSSanitas</code> attribute.
    */

    public Boolean getUsuariodrvTieneEPSSanitas()  {
    	Boolean value;
        try {
            value = usuariodrvTieneEPSSanitasDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTieneEPSSanitas");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvTieneDocumentos</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTieneDocumentos</code>. Variable Bool<br>
    * Comments: Se utiliza en las precondiciones de la generación de la solicitud para controlar que todos los usuarios tengan ya subidos los documentos que corresponde.
Según ALM Nº 166, el documento de solicitud es opcional. Lo quitamos de la comprobación
GC3-6: Los menores sin identificar no tienen por qué tener documento de identificación. Para el resto, si la fecha de inicio de contratación es menor a la que indica el Producto, es obligatorio el documento de solicitud
GC4-13: Si en una solicitud se incluye una persona nueva, esto es, que NO exista en el CORE, aunque sea contratante o titular (con o sin beneficios) se deberá solicitar el documento de identificación para esta persona. Esto es, será obligatorio proporcionarlo para poder generar la solicitud. Igualmente, si la persona es jurídica, también será obligatorio registrar el documento de identificación.
GdC12 Req 47: Si el dominio tiene configurado que requiere cuestionario médico, pero al usuario no se le habilita cuestionario médico (por tener contratos anteriores que lo requerían y las fechas del contrato e inicio de contratación difieren en menos de 31 días), no es obligatorio solicitar documento de identificación a ese usuario.
GdC 12 - Usuario Nuevo (que No exista como persona en BH) debe adjuntar documento de identificación.<br>
    * @return The value of the <code>usuariodrvTieneDocumentos</code> attribute.
    */

    public Boolean getUsuariodrvTieneDocumentos()  {
    	Boolean value;
        try {
            value = usuariodrvTieneDocumentosDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTieneDocumentos");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariotieneDocIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuariotieneDocIdentificacion</code>. Variable Bool<br>
    * Comments: Indica si se ha subido o ya existe en el gestor el documento de identificación para este usuario<br>
    * @return The value of the <code>usuariotieneDocIdentificacion</code> attribute.
    */

    public Boolean getUsuariotieneDocIdentificacion()  {
    	Boolean value;
        value =  usuariotieneDocIdentificacion;
        return value;
    }

   /**
    * Sets the value of the <code>usuariotieneDocIdentificacion</code> attribute.<br>
    * Model Attribute: <code>usuariotieneDocIdentificacion</code>. Variable Bool<br>
    * Comments: Indica si se ha subido o ya existe en el gestor el documento de identificación para este usuario<br>
    * @param usuariotieneDocIdentificacion The new value of the <code>usuariotieneDocIdentificacion</code> attribute.
    */
    public void setUsuariotieneDocIdentificacion (Boolean usuariotieneDocIdentificacion) {
        modifiedUsuariotieneDocIdentificacion = true;
        this.usuariotieneDocIdentificacion = usuariotieneDocIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedUsuariotieneDocIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuariotieneDocIdentificacion</code>.
    */
    public void setModifiedUsuariotieneDocIdentificacion(boolean modified) {
        this.modifiedUsuariotieneDocIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>usuariotieneDocsSolicitud</code> attribute.<br>
    * Model Attribute: <code>usuariotieneDocsSolicitud</code>. Variable Bool<br>
    * Comments: Indica si se ha subido o ya existe en el gestor el archivo con los documentos de solicitud para este usuario<br>
    * @return The value of the <code>usuariotieneDocsSolicitud</code> attribute.
    */

    public Boolean getUsuariotieneDocsSolicitud()  {
    	Boolean value;
        value =  usuariotieneDocsSolicitud;
        return value;
    }

   /**
    * Sets the value of the <code>usuariotieneDocsSolicitud</code> attribute.<br>
    * Model Attribute: <code>usuariotieneDocsSolicitud</code>. Variable Bool<br>
    * Comments: Indica si se ha subido o ya existe en el gestor el archivo con los documentos de solicitud para este usuario<br>
    * @param usuariotieneDocsSolicitud The new value of the <code>usuariotieneDocsSolicitud</code> attribute.
    */
    public void setUsuariotieneDocsSolicitud (Boolean usuariotieneDocsSolicitud) {
        modifiedUsuariotieneDocsSolicitud = true;
        this.usuariotieneDocsSolicitud = usuariotieneDocsSolicitud;
    }

   /**
    * Sets the value of the <code>modifiedUsuariotieneDocsSolicitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuariotieneDocsSolicitud</code>.
    */
    public void setModifiedUsuariotieneDocsSolicitud(boolean modified) {
        this.modifiedUsuariotieneDocsSolicitud = modified;
    }

   /**
    * Returns the value of the <code>usuariodrvTieneParentesco</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTieneParentesco</code>. Variable Bool<br>
    * Comments: Se utiliza en precondiciones de OGENERARSOLICITUD para verificar que todos los usuarios de la solicitud tengan indicado el parentesco.<br>
    * @return The value of the <code>usuariodrvTieneParentesco</code> attribute.
    */

    public Boolean getUsuariodrvTieneParentesco()  {
    	Boolean value;
        try {
            value = usuariodrvTieneParentescoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTieneParentesco");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvPuedeSerTitular</code> attribute.<br>
    * Model Attribute: <code>usuariodrvPuedeSerTitular</code>. Variable Bool<br>
    * Comments: Devuelve True si el usuario puede ser Titular de la solicitud. Este dato se utiliza en el filtrado navegacional de Parentesco en el servicio modificar atributos de usuario (TMODIFICARATTR).
Para contratos de inclusión colectivo el titular o viene dado o se añade por la opción de Indicar Titular, nunca como beneficiario<br>
    * @return The value of the <code>usuariodrvPuedeSerTitular</code> attribute.
    */

    public Boolean getUsuariodrvPuedeSerTitular()  {
    	Boolean value;
        try {
            value = usuariodrvPuedeSerTitularDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvPuedeSerTitular");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvTieneCuesMed</code> attribute.<br>
    * Model Attribute: <code>usuariodrvTieneCuesMed</code>. Variable Bool<br>
    * Comments: Indica si el usuario tiene cuestionario médico<br>
    * @return The value of the <code>usuariodrvTieneCuesMed</code> attribute.
    */

    public Boolean getUsuariodrvTieneCuesMed()  {
    	Boolean value;
        try {
            value = usuariodrvTieneCuesMedDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvTieneCuesMed");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuariodrvImpTarifaPlanVol</code> attribute.<br>
    * Model Attribute: <code>usuariodrvImpTarifaPlanVol</code>. Variable Real<br>
    * Comments: Calcular el importe de la tarifa para el usuario para planes voluntarios.
 - Producto
 - Plan
 - Tipo de contrato
 - Año
 - Edad (desde - hasta)<br>
    * @return The value of the <code>usuariodrvImpTarifaPlanVol</code> attribute.
    */

    public Double getUsuariodrvImpTarifaPlanVol()  {
    	Double value;
        try {
            value = usuariodrvImpTarifaPlanVolDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvImpTarifaPlanVol");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioPolizaInternacional</code> attribute.<br>
    * Model Attribute: <code>usuarioPolizaInternacional</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options>

GdC23-Req. 10: Cambio de nombre Póliza Internacional
Se solicita cambiar el nombre de 'Póliza internacional' por 'Respaldo global'.<br>
    * @return The value of the <code>usuarioPolizaInternacional</code> attribute.
    */

    public Boolean getUsuarioPolizaInternacional()  {
    	Boolean value;
        value =  usuarioPolizaInternacional;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioPolizaInternacional</code> attribute.<br>
    * Model Attribute: <code>usuarioPolizaInternacional</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options>

GdC23-Req. 10: Cambio de nombre Póliza Internacional
Se solicita cambiar el nombre de 'Póliza internacional' por 'Respaldo global'.<br>
    * @param usuarioPolizaInternacional The new value of the <code>usuarioPolizaInternacional</code> attribute.
    */
    public void setUsuarioPolizaInternacional (Boolean usuarioPolizaInternacional) {
        modifiedUsuarioPolizaInternacional = true;
        this.usuarioPolizaInternacional = usuarioPolizaInternacional;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioPolizaInternacional</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioPolizaInternacional</code>.
    */
    public void setModifiedUsuarioPolizaInternacional(boolean modified) {
        this.modifiedUsuarioPolizaInternacional = modified;
    }

   /**
    * Returns the value of the <code>usuariodrvDirResValidoEPS</code> attribute.<br>
    * Model Attribute: <code>usuariodrvDirResValidoEPS</code>. Variable Bool<br>
    * Comments: Indica si la dirección de residencia tiene un municipio que es válido para EPS Sanitas<br>
    * @return The value of the <code>usuariodrvDirResValidoEPS</code> attribute.
    */

    public Boolean getUsuariodrvDirResValidoEPS()  {
    	Boolean value;
        try {
            value = usuariodrvDirResValidoEPSDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Usuario, Attribute: usuariodrvDirResValidoEPS");
        }
        return value;
    }

   /**
    * Returns the value of the <code>usuarioIMC</code> attribute.<br>
    * Model Attribute: <code>usuarioIMC</code>. Variable Real<br>
    * Comments: GcD-18: Req 2: El cálculo del IMC de los beneficiarios se realizará y guardará (si procede) cuando se marque como completado el cuestionario médico<br>
    * @return The value of the <code>usuarioIMC</code> attribute.
    */

    public Double getUsuarioIMC()  {
    	Double value;
        value =  usuarioIMC;
        return value;
    }

   /**
    * Sets the value of the <code>usuarioIMC</code> attribute.<br>
    * Model Attribute: <code>usuarioIMC</code>. Variable Real<br>
    * Comments: GcD-18: Req 2: El cálculo del IMC de los beneficiarios se realizará y guardará (si procede) cuando se marque como completado el cuestionario médico<br>
    * @param usuarioIMC The new value of the <code>usuarioIMC</code> attribute.
    */
    public void setUsuarioIMC (Double usuarioIMC) {
        modifiedUsuarioIMC = true;
        this.usuarioIMC = usuarioIMC;
    }

   /**
    * Sets the value of the <code>modifiedUsuarioIMC</code> class property.<br>
    * @param modified The new value of the <code>modifiedUsuarioIMC</code>.
    */
    public void setModifiedUsuarioIMC(boolean modified) {
        this.modifiedUsuarioIMC = modified;
    }

    /**
     * Returns the instance of <code>CuestionarioP</code> related through the <code>CuestionarioP</code> role.
     * Model Relationship:
     * <code>[CuestionarioP] CuestionarioP 0:1  ------ 1:1  Usuario [Usuario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>CuestionarioP</code> related through the <code>CuestionarioP</code> role.
     */
    @JsonIgnore
    public CuestionarioP getCuestionarioP() {
        return cuestionarioP;
    }

   /**
    * Adds an instance of <code>CuestionarioP</code> related through the <code>CuestionarioP</code> role.
    * @param cuestionarioP The instance to add to the <code>CuestionarioP</code> role.
    */
    public void add2CuestionarioP(CuestionarioP cuestionarioP) {
        this.cuestionarioP = (cuestionarioP == null  || cuestionarioP.isNull() ? null : cuestionarioP);
    }

   /**
    * This method gets the attribute value <code>modifiedCuestionarioP</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedCuestionarioP</code> has been modified.
    */
    public boolean isModifiedCuestionarioP(){
        return modifiedCuestionarioP;
    }

    /**
     * Returns the instance of <code>AnexoMat</code> related through the <code>AnexoMat</code> role.
     * Model Relationship:
     * <code>[AnexoMat] AnexoMat 0:1  ------ 1:1  Usuario [Usuario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AnexoMat</code> related through the <code>AnexoMat</code> role.
     */
    @JsonIgnore
    public AnexoMat getAnexoMat() {
        return anexoMat;
    }

   /**
    * Adds an instance of <code>AnexoMat</code> related through the <code>AnexoMat</code> role.
    * @param anexoMat The instance to add to the <code>AnexoMat</code> role.
    */
    public void add2AnexoMat(AnexoMat anexoMat) {
        this.anexoMat = (anexoMat == null  || anexoMat.isNull() ? null : anexoMat);
    }

   /**
    * This method gets the attribute value <code>modifiedAnexoMat</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAnexoMat</code> has been modified.
    */
    public boolean isModifiedAnexoMat(){
        return modifiedAnexoMat;
    }

    /**
     * Returns the instance of <code>AnexoNeo</code> related through the <code>AnexoNeo</code> role.
     * Model Relationship:
     * <code>[AnexoNeo] AnexoNeo 0:1  ------ 1:1  Usuario [Usuario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AnexoNeo</code> related through the <code>AnexoNeo</code> role.
     */
    @JsonIgnore
    public AnexoNeo getAnexoNeo() {
        return anexoNeo;
    }

   /**
    * Adds an instance of <code>AnexoNeo</code> related through the <code>AnexoNeo</code> role.
    * @param anexoNeo The instance to add to the <code>AnexoNeo</code> role.
    */
    public void add2AnexoNeo(AnexoNeo anexoNeo) {
        this.anexoNeo = (anexoNeo == null  || anexoNeo.isNull() ? null : anexoNeo);
    }

   /**
    * This method gets the attribute value <code>modifiedAnexoNeo</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAnexoNeo</code> has been modified.
    */
    public boolean isModifiedAnexoNeo(){
        return modifiedAnexoNeo;
    }

    /**
     * Returns the instance of <code>Preexistencia</code> related through the <code>Preexistencias</code> role.
     * Model Relationship:
     * <code>[Preexistencia] Preexistencias 0:M  ------ 1:1  Usuario [Usuario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Preexistencia</code> related through the <code>Preexistencias</code> role.
     */
    @JsonIgnore
    public Collection <Preexistencia> getPreexistencias() {
        return preexistencias;
    }

   /**
    * Adds an instance of <code>Preexistencia</code> related through the <code>Preexistencias</code> role.
    * @param preexistencias The instance to add to the <code>Preexistencias</code> role.
    */
    public void add2Preexistencias(Preexistencia preexistencias) {
        this.getPreexistencias().add(preexistencias);
    }
    /**
     * Sets instances of <code>Preexistencia</code> related through the <code>Preexistencias</code> role.
     * @param preexistencias The new value for the <code>Preexistencias</code> role.
     */
    public void setPreexistencias(Collection < Preexistencia > preexistencias) {
        this.preexistencias = preexistencias;
    }

   /**
    * This method gets the attribute value <code>modifiedPreexistencias</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPreexistencias</code> has been modified.
    */
    public boolean isModifiedPreexistencias(){
        return modifiedPreexistencias;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitud 1:1  ------ 0:M  Usuarios [Usuario]</code>
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
     * Returns the instance of <code>Persona</code> related through the <code>UsuarioPersona</code> role.
     * Model Relationship:
     * <code>[Persona] UsuarioPersona 1:1  ------ 0:1  Usuarios [Usuario]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Persona</code> related through the <code>UsuarioPersona</code> role.
     */
    @JsonIgnore
    public Persona getUsuarioPersona() {
        return usuarioPersona;
    }

   /**
    * Adds an instance of <code>Persona</code> related through the <code>UsuarioPersona</code> role.
    * @param usuarioPersona The instance to add to the <code>UsuarioPersona</code> role.
    */
    public void add2UsuarioPersona(Persona usuarioPersona) {
        if (usuarioPersona == null || usuarioPersona.isNull()) {
            this.modifiedUsuarioPersona = true;
            this.personaUsuarioPersonaIdentificador = null;
        } else {
            this.personaUsuarioPersonaIdentificador = usuarioPersona.getPersonaIdentificador();
        }
        this.usuarioPersona = (usuarioPersona == null  || usuarioPersona.isNull() ? null : usuarioPersona);
    }

   /**
    * This method gets the attribute value <code>modifiedUsuarioPersona</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedUsuarioPersona</code> has been modified.
    */
    public boolean isModifiedUsuarioPersona(){
        return modifiedUsuarioPersona;
    }

    /**
     * Returns the instance of <code>Parentesco</code> related through the <code>Parentesco</code> role.
     * Model Relationship:
     * <code>[Parentesco] Parentesco 0:1  ------ 0:M  AtributosUsuario [Usuario]</code>
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
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacion 1:1  ------ 0:M  UsuarioS [Usuario]</code>
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
            this.tipoIdentificacionTipoIdentificacionCodigo = null;
        } else {
            this.tipoIdentificacionTipoIdentificacionCodigo = tipoIdentificacion.getTipoIdentificacionCodigo();
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
     * Returns the instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiario</code> role.
     * Model Relationship:
     * <code>[EstadoBeneficiario] EstadoBeneficiario 0:1  ------ 0:M  UsuarioS [Usuario]</code>
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
     * Returns a Map with the values of the attributes.
     * @return Map with the values of the attributes.
     */
    @JsonIgnore
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Returns the value of the <code>usuariodrvIdentificacion</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvIdentificacion</code> derived attribute.
     */
    public String usuariodrvIdentificacionDerivations() {
        return usuariodrvIdentificacion;
    }    

    /**
     * Returns the value of the <code>usuariodrvEsElTitular</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvEsElTitular</code> derived attribute.
     */
    public Boolean usuariodrvEsElTitularDerivations() {
        return usuariodrvEsElTitular;
    }    

    /**
     * Returns the value of the <code>usuariodrvAccesoCuesMed</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvAccesoCuesMed</code> derived attribute.
     */
    public Boolean usuariodrvAccesoCuesMedDerivations() {
        return usuariodrvAccesoCuesMed;
    }    

    /**
     * Returns the value of the <code>usuariodrvAceptaAnexoMat</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvAceptaAnexoMat</code> derived attribute.
     */
    public Boolean usuariodrvAceptaAnexoMatDerivations() {
        return usuariodrvAceptaAnexoMat;
    }    

    /**
     * Returns the value of the <code>usuariodrvAceptaAnexoNeo</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvAceptaAnexoNeo</code> derived attribute.
     */
    public Boolean usuariodrvAceptaAnexoNeoDerivations() {
        return usuariodrvAceptaAnexoNeo;
    }    

    /**
     * Returns the value of the <code>usuariodrvTieneAnexoMat</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTieneAnexoMat</code> derived attribute.
     */
    public Boolean usuariodrvTieneAnexoMatDerivations() {
        return usuariodrvTieneAnexoMat;
    }    

    /**
     * Returns the value of the <code>usuariodrvEdadParaCuotaIns</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvEdadParaCuotaIns</code> derived attribute.
     */
    public Long usuariodrvEdadParaCuotaInsDerivations() {
        return usuariodrvEdadParaCuotaIns;
    }    

    /**
     * Returns the value of the <code>usuariodrvValorCuotaInscrip</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvValorCuotaInscrip</code> derived attribute.
     */
    public Double usuariodrvValorCuotaInscripDerivations() {
        return usuariodrvValorCuotaInscrip;
    }    

    /**
     * Returns the value of the <code>usuariodrvCuesMedOK</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvCuesMedOK</code> derived attribute.
     */
    public Boolean usuariodrvCuesMedOKDerivations() {
        return usuariodrvCuesMedOK;
    }    

    /**
     * Returns the value of the <code>usuariodrvNombreCompleto</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvNombreCompleto</code> derived attribute.
     */
    public String usuariodrvNombreCompletoDerivations() {
        return usuariodrvNombreCompleto;
    }    

    /**
     * Returns the value of the <code>usuariodrvConfirmado</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvConfirmado</code> derived attribute.
     */
    public Boolean usuariodrvConfirmadoDerivations() {
        return usuariodrvConfirmado;
    }    

    /**
     * Returns the value of the <code>usuariodrvTiempoEmbarazo</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTiempoEmbarazo</code> derived attribute.
     */
    public Long usuariodrvTiempoEmbarazoDerivations() {
        return usuariodrvTiempoEmbarazo;
    }    

    /**
     * Returns the value of the <code>usuariodrvEstaActivo</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvEstaActivo</code> derived attribute.
     */
    public Boolean usuariodrvEstaActivoDerivations() {
        return usuariodrvEstaActivo;
    }    

    /**
     * Returns the value of the <code>usuariodrvEdad</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvEdad</code> derived attribute.
     */
    public Long usuariodrvEdadDerivations() {
        return usuariodrvEdad;
    }    

    /**
     * Returns the value of the <code>usuariodrvEdadMaxIngreso</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvEdadMaxIngreso</code> derived attribute.
     */
    public Long usuariodrvEdadMaxIngresoDerivations() {
        return usuariodrvEdadMaxIngreso;
    }    

    /**
     * Returns the value of the <code>usuariodrvEdadMaxPerm</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvEdadMaxPerm</code> derived attribute.
     */
    public Long usuariodrvEdadMaxPermDerivations() {
        return usuariodrvEdadMaxPerm;
    }    

    /**
     * Returns the value of the <code>usuariodrvTotalAnexos</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTotalAnexos</code> derived attribute.
     */
    public Double usuariodrvTotalAnexosDerivations() {
        return usuariodrvTotalAnexos;
    }    

    /**
     * Returns the value of the <code>usuariodrvTieneEPSSanitas</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTieneEPSSanitas</code> derived attribute.
     */
    public Boolean usuariodrvTieneEPSSanitasDerivations() {
        return usuariodrvTieneEPSSanitas;
    }    

    /**
     * Returns the value of the <code>usuariodrvTieneDocumentos</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTieneDocumentos</code> derived attribute.
     */
    public Boolean usuariodrvTieneDocumentosDerivations() {
        return usuariodrvTieneDocumentos;
    }    

    /**
     * Returns the value of the <code>usuariodrvTieneParentesco</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTieneParentesco</code> derived attribute.
     */
    public Boolean usuariodrvTieneParentescoDerivations() {
        return usuariodrvTieneParentesco;
    }    

    /**
     * Returns the value of the <code>usuariodrvPuedeSerTitular</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvPuedeSerTitular</code> derived attribute.
     */
    public Boolean usuariodrvPuedeSerTitularDerivations() {
        return usuariodrvPuedeSerTitular;
    }    

    /**
     * Returns the value of the <code>usuariodrvTieneCuesMed</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvTieneCuesMed</code> derived attribute.
     */
    public Boolean usuariodrvTieneCuesMedDerivations() {
        return usuariodrvTieneCuesMed;
    }    

    /**
     * Returns the value of the <code>usuariodrvImpTarifaPlanVol</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvImpTarifaPlanVol</code> derived attribute.
     */
    public Double usuariodrvImpTarifaPlanVolDerivations() {
        return usuariodrvImpTarifaPlanVol;
    }    

    /**
     * Returns the value of the <code>usuariodrvDirResValidoEPS</code> derived attribute.
     *
     * @return Value of the <code>usuariodrvDirResValidoEPS</code> derived attribute.
     */
    public Boolean usuariodrvDirResValidoEPSDerivations() {
        return usuariodrvDirResValidoEPS;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        usuarioBebeGestante = false;
        usuarioNumUsuario = null;
        usuarioNumIdentificacion = "";
        usuarioCodigoTipoUsuario = Long.valueOf(0);
        usuarioPrimerNombre = null;
        usuarioSegundoNombre = null;
        usuarioPrimerApellido = null;
        usuarioSegundoApellido = null;
        usuarioattrUsuarioDiligenciados = false;
        usuariocodigoBancoRep = null;
        usuarioUsuarioReplicado = false;
        usuarioFechaAntiguedadBeneficiario = null;
        usuarioRequierExamenMedico = null;
        usuarioEstadoMedico = null;
        usuarioValorCuotaInscripcion = null;
        usuarioTienePreexistencias = null;
        usuarioFechaInicioVigencia = null;
        usuarioFechaFinVigencia = null;
        usuariotieneDocIdentificacion = false;
        usuariotieneDocsSolicitud = false;
        usuarioPolizaInternacional = false;
        usuarioIMC = null;
        cuestionarioP = null;
        anexoMat = null;
        anexoNeo = null;
        preexistencias = null;
        solicitud = null;
        usuarioPersona = null;
        parentesco = null;
        tipoIdentificacion = null;
        estadoBeneficiario = null;
        values = new HashMap<>();
        userFunctionsSrv = Arc.container().select(UserFunctions.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Usuario.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return UsuarioConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedUsuarioBebeGestante = false;
    	values.put("usuarioBebeGestante", getUsuarioBebeGestante());
    	modifiedUsuarioNumUsuario = false;
    	values.put("usuarioNumUsuario", getUsuarioNumUsuario());
    	modifiedUsuarioNumIdentificacion = false;
    	values.put("usuarioNumIdentificacion", getUsuarioNumIdentificacion());
    	modifiedUsuarioCodigoTipoUsuario = false;
    	values.put("usuarioCodigoTipoUsuario", getUsuarioCodigoTipoUsuario());
    	modifiedUsuarioPrimerNombre = false;
    	values.put("usuarioPrimerNombre", getUsuarioPrimerNombre());
    	modifiedUsuarioSegundoNombre = false;
    	values.put("usuarioSegundoNombre", getUsuarioSegundoNombre());
    	modifiedUsuarioPrimerApellido = false;
    	values.put("usuarioPrimerApellido", getUsuarioPrimerApellido());
    	modifiedUsuarioSegundoApellido = false;
    	values.put("usuarioSegundoApellido", getUsuarioSegundoApellido());
    	modifiedUsuarioattrUsuarioDiligenciados = false;
    	values.put("usuarioattrUsuarioDiligenciados", getUsuarioattrUsuarioDiligenciados());
    	modifiedUsuariocodigoBancoRep = false;
    	values.put("usuariocodigoBancoRep", getUsuariocodigoBancoRep());
    	modifiedUsuarioUsuarioReplicado = false;
    	values.put("usuarioUsuarioReplicado", getUsuarioUsuarioReplicado());
    	modifiedUsuarioFechaAntiguedadBeneficiario = false;
    	values.put("usuarioFechaAntiguedadBeneficiario", getUsuarioFechaAntiguedadBeneficiario());
    	modifiedUsuarioRequierExamenMedico = false;
    	values.put("usuarioRequierExamenMedico", getUsuarioRequierExamenMedico());
    	modifiedUsuarioEstadoMedico = false;
    	values.put("usuarioEstadoMedico", getUsuarioEstadoMedico());
    	modifiedUsuarioValorCuotaInscripcion = false;
    	values.put("usuarioValorCuotaInscripcion", getUsuarioValorCuotaInscripcion());
    	modifiedUsuarioTienePreexistencias = false;
    	values.put("usuarioTienePreexistencias", getUsuarioTienePreexistencias());
    	modifiedUsuarioFechaInicioVigencia = false;
    	values.put("usuarioFechaInicioVigencia", getUsuarioFechaInicioVigencia());
    	modifiedUsuarioFechaFinVigencia = false;
    	values.put("usuarioFechaFinVigencia", getUsuarioFechaFinVigencia());
    	modifiedUsuariotieneDocIdentificacion = false;
    	values.put("usuariotieneDocIdentificacion", getUsuariotieneDocIdentificacion());
    	modifiedUsuariotieneDocsSolicitud = false;
    	values.put("usuariotieneDocsSolicitud", getUsuariotieneDocsSolicitud());
    	modifiedUsuarioPolizaInternacional = false;
    	values.put("usuarioPolizaInternacional", getUsuarioPolizaInternacional());
    	modifiedUsuarioIMC = false;
    	values.put("usuarioIMC", getUsuarioIMC());
    	modifiedCuestionarioP = false;
    	modifiedAnexoMat = false;
    	modifiedAnexoNeo = false;
    	modifiedPreexistencias = false;
    	modifiedSolicitud = false;
    	modifiedUsuarioPersona = false;
    	modifiedParentesco = false;
    	modifiedTipoIdentificacion = false;
    	modifiedEstadoBeneficiario = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            usuariodrvIdentificacion = null;
            usuariodrvEsElTitular = null;
            usuariodrvAccesoCuesMed = null;
            usuariodrvAceptaAnexoMat = null;
            usuariodrvAceptaAnexoNeo = null;
            usuariodrvTieneAnexoMat = null;
            usuariodrvEdadParaCuotaIns = null;
            usuariodrvValorCuotaInscrip = null;
            usuariodrvCuesMedOK = null;
            usuariodrvNombreCompleto = null;
            usuariodrvConfirmado = null;
            usuariodrvTiempoEmbarazo = null;
            usuariodrvEstaActivo = null;
            usuariodrvEdad = null;
            usuariodrvEdadMaxIngreso = null;
            usuariodrvEdadMaxPerm = null;
            usuariodrvTotalAnexos = null;
            usuariodrvTieneEPSSanitas = null;
            usuariodrvTieneDocumentos = null;
            usuariodrvTieneParentesco = null;
            usuariodrvPuedeSerTitular = null;
            usuariodrvTieneCuesMed = null;
            usuariodrvImpTarifaPlanVol = null;
            usuariodrvDirResValidoEPS = null;
    }

    /**
     * Returns the <code>UsuarioOid</code> object that identifies this instance of <code>Usuario</code>.
     * @return <code>UsuarioOid </code> object that identifies this instance of <code>Usuario</code>
     */
    public UsuarioOid getOid() {
        return new UsuarioOid(getAESOLICITUDESIDSOLICITUD(), getUsuarioIdentificador());
    }

    /**
     * Sets the <code>UsuarioOid</code> object that identifies this instance of <code>Usuario</code>.
     */    
    public void setOid(UsuarioOid oid) {
        this.oid = oid;
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(UsuarioConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(UsuarioConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.USUARIO)) {
            // Add this class
            activeFacets.add(Constants.USUARIO);
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
