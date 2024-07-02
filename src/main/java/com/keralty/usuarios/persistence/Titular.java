package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.DepartamentoConstants;
import com.keralty.usuarios.global.MunicipioConstants;
import com.keralty.usuarios.global.SolicitudConstants;
import com.keralty.usuarios.global.TipoIdentificacionConstants;
import com.keralty.usuarios.global.TitularConstants;
import com.keralty.usuarios.global.UserFunctions;
import com.keralty.usuarios.persistence.oid.TitularOid;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
 * Persistent representation of the <code>Titular</code> model class.
 * <p>
 * Model Class: <code>Titular</code><br>
 */
@Entity(name = TitularConstants.CLASS_NAME)
@Table(name = TitularConstants.TBL_NAME)
public class Titular extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private transient UserFunctions userFunctionsSrv;

    /** Class identification function. */
    @Id
    @Column(name = TitularConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false )
    @JsonProperty(value="id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARCODIGO )
    @JsonProperty(value="codigo")
    private Long titularCodigo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularCodigo;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARNUMIDENTIFICACION )
    @JsonProperty(value="numidentificacion")
    private String titularNumIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularNumIdentificacion;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTIPOPERSONA )
    @JsonProperty(value="tipopersona")
    private String titularTipoPersona;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTipoPersona;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARPRIMERNOMBRE )
    @JsonProperty(value="primernombre")
    private String titularPrimerNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularPrimerNombre;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARSEGUNDONOMBRE )
    @JsonProperty(value="segundonombre")
    private String titularSegundoNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularSegundoNombre;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARPRIMERAPELLIDO )
    @JsonProperty(value="primerapellido")
    private String titularPrimerApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularPrimerApellido;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARSEGUNDOAPELLIDO )
    @JsonProperty(value="segundoapellido")
    private String titularSegundoApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularSegundoApellido;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARFECHANACIMIENTO )
    @JsonProperty(value="fechanacimiento")
    private Date titularFechaNacimiento;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularFechaNacimiento;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARGENERO )
    @JsonProperty(value="genero")
    private String titularGenero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularGenero;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARINDICADOREXTRANJERO )
    @JsonProperty(value="indicadorextranjero")
    private Boolean titularIndicadorExtranjero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularIndicadorExtranjero;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTELEFONOFIJO )
    @JsonProperty(value="telefonofijo")
    private String titularTelefonoFijo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTelefonoFijo;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTELEFONOCELULAR )
    @JsonProperty(value="telefonocelular")
    private String titularTelefonoCelular;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTelefonoCelular;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARCORREOELECTRONICO )
    @JsonProperty(value="correoelectronico")
    private String titularCorreoElectronico;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularCorreoElectronico;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTITULARCONBENEFICIOS )
    @JsonProperty(value="titularconbeneficios")
    private Boolean titularTitularConBeneficios;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTitularConBeneficios;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvidentificacion")
    protected String titulardrvIdentificacion;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTITULARRECUPERADOINC )
    @JsonProperty(value="titularrecuperadoinc")
    private Boolean titularTitularRecuperadoInc;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTitularRecuperadoInc;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnombrecompleto")
    protected String titulardrvNombreCompleto;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTELEFONOFIJODC )
    @JsonProperty(value="telefonofijodc")
    private String titularTelefonoFijoDC;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTelefonoFijoDC;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTELEFONOCELULARDC )
    @JsonProperty(value="telefonocelulardc")
    private String titularTelefonoCelularDC;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTelefonoCelularDC;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARTITULARCONBENEFICIOSCORE )
    @JsonProperty(value="titularconbeneficioscore")
    private Boolean titularTitularConBeneficiosCORE;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularTitularConBeneficiosCORE;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARRAZONSOCIAL )
    @JsonProperty(value="razonsocial")
    private String titularRazonSocial;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularRazonSocial;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvbeneficiosactivo")
    protected Boolean titulardrvBeneficiosActivo;

    /** Class member attribute. */
    @Column(name = TitularConstants.FLD_TITULARDIRECCIONESMODIFICADAS )
    @JsonProperty(value="direccionesmodificadas")
    private Boolean titularDireccionesModificadas;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTitularDireccionesModificadas;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = TitularConstants.ROLE_INVNAME_DIRECCION)
    @JsonIgnore
    private Direccion direccion;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDireccion;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=TitularConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false)
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
        @JoinColumn(name=TitularConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCODIGO, referencedColumnName=TipoIdentificacionConstants.FLD_TIPOIDENTIFICACIONCODIGO)
    })
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacion;
    /** Related attribute. */
    @Column(name = TitularConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCODIGO, insertable = false, updatable = false)
    private Long tipoIdentificacionTipoIdentificacionCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoIdentificacion;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=TitularConstants.FLD_DEPARTAMENTODEPARTAMENTONACCODIGO, referencedColumnName=DepartamentoConstants.FLD_DEPARTAMENTOCODIGO)
    })
    @JsonIgnore
    private Departamento departamentoNac;
    /** Related attribute. */
    @Column(name = TitularConstants.FLD_DEPARTAMENTODEPARTAMENTONACCODIGO, insertable = false, updatable = false)
    private Long departamentoDepartamentoNacCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDepartamentoNac;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=TitularConstants.FLD_MUNICIPIOMUNICIPIONACCODIGO, referencedColumnName=MunicipioConstants.FLD_MUNICIPIOCODIGO)
    })
    @JsonIgnore
    private Municipio municipioNac;
    /** Related attribute. */
    @Column(name = TitularConstants.FLD_MUNICIPIOMUNICIPIONACCODIGO, insertable = false, updatable = false)
    private Long municipioMunicipioNacCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioNac;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Titular() {
        aESOLICITUDESIDSOLICITUD = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Titular</code>.
     * @param oid Object Identifier of the instance of <code>Titular</code> to be created.
     * @throws SystemException
     */
    public Titular(TitularOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            aESOLICITUDESIDSOLICITUD = oid.getAESOLICITUDESIDSOLICITUD();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Solicitud.AE_SOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @return The value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code> through <code>Solicitud.AE_SOLICITUDES</code>.
     */
    public Long getAESOLICITUDESIDSOLICITUD() {
        return aESOLICITUDESIDSOLICITUD;
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
    * Returns the value of the <code>titularCodigo</code> attribute.<br>
    * Model Attribute: <code>titularCodigo</code>. Variable Int<br>
    * Comments: Este es el código de persona que en el CORE<br>
    * @return The value of the <code>titularCodigo</code> attribute.
    */

    public Long getTitularCodigo()  {
    	Long value;
        value =  titularCodigo;
        return value;
    }

   /**
    * Sets the value of the <code>titularCodigo</code> attribute.<br>
    * Model Attribute: <code>titularCodigo</code>. Variable Int<br>
    * Comments: Este es el código de persona que en el CORE<br>
    * @param titularCodigo The new value of the <code>titularCodigo</code> attribute.
    */
    public void setTitularCodigo (Long titularCodigo) {
        modifiedTitularCodigo = true;
        this.titularCodigo = titularCodigo;
    }

   /**
    * Sets the value of the <code>modifiedTitularCodigo</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularCodigo</code>.
    */
    public void setModifiedTitularCodigo(boolean modified) {
        this.modifiedTitularCodigo = modified;
    }

   /**
    * Returns the value of the <code>titularNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>titularNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>titularNumIdentificacion</code> attribute.
    */

    public String getTitularNumIdentificacion()  {
    	String value;
        value =  titularNumIdentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>titularNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @param titularNumIdentificacion The new value of the <code>titularNumIdentificacion</code> attribute.
    */
    public void setTitularNumIdentificacion (String titularNumIdentificacion) {
        modifiedTitularNumIdentificacion = true;
        this.titularNumIdentificacion = titularNumIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedTitularNumIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularNumIdentificacion</code>.
    */
    public void setModifiedTitularNumIdentificacion(boolean modified) {
        this.modifiedTitularNumIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>titularTipoPersona</code> attribute.<br>
    * Model Attribute: <code>titularTipoPersona</code>. Variable String Size=1<br>
    * Comments: N - Natural, J - Jurídica<br>
    * @return The value of the <code>titularTipoPersona</code> attribute.
    */

    public String getTitularTipoPersona()  {
    	String value;
        value =  titularTipoPersona;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularTipoPersona</code> attribute.<br>
    * Model Attribute: <code>titularTipoPersona</code>. Variable String Size=1<br>
    * Comments: N - Natural, J - Jurídica<br>
    * @param titularTipoPersona The new value of the <code>titularTipoPersona</code> attribute.
    */
    public void setTitularTipoPersona (String titularTipoPersona) {
        modifiedTitularTipoPersona = true;
        this.titularTipoPersona = titularTipoPersona;
    }

   /**
    * Sets the value of the <code>modifiedTitularTipoPersona</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTipoPersona</code>.
    */
    public void setModifiedTitularTipoPersona(boolean modified) {
        this.modifiedTitularTipoPersona = modified;
    }

   /**
    * Returns the value of the <code>titularPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>titularPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>titularPrimerNombre</code> attribute.
    */

    public String getTitularPrimerNombre()  {
    	String value;
        value =  titularPrimerNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>titularPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param titularPrimerNombre The new value of the <code>titularPrimerNombre</code> attribute.
    */
    public void setTitularPrimerNombre (String titularPrimerNombre) {
        modifiedTitularPrimerNombre = true;
        this.titularPrimerNombre = titularPrimerNombre;
    }

   /**
    * Sets the value of the <code>modifiedTitularPrimerNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularPrimerNombre</code>.
    */
    public void setModifiedTitularPrimerNombre(boolean modified) {
        this.modifiedTitularPrimerNombre = modified;
    }

   /**
    * Returns the value of the <code>titularSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>titularSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>titularSegundoNombre</code> attribute.
    */

    public String getTitularSegundoNombre()  {
    	String value;
        value =  titularSegundoNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>titularSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param titularSegundoNombre The new value of the <code>titularSegundoNombre</code> attribute.
    */
    public void setTitularSegundoNombre (String titularSegundoNombre) {
        modifiedTitularSegundoNombre = true;
        this.titularSegundoNombre = titularSegundoNombre;
    }

   /**
    * Sets the value of the <code>modifiedTitularSegundoNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularSegundoNombre</code>.
    */
    public void setModifiedTitularSegundoNombre(boolean modified) {
        this.modifiedTitularSegundoNombre = modified;
    }

   /**
    * Returns the value of the <code>titularPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>titularPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>titularPrimerApellido</code> attribute.
    */

    public String getTitularPrimerApellido()  {
    	String value;
        value =  titularPrimerApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>titularPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param titularPrimerApellido The new value of the <code>titularPrimerApellido</code> attribute.
    */
    public void setTitularPrimerApellido (String titularPrimerApellido) {
        modifiedTitularPrimerApellido = true;
        this.titularPrimerApellido = titularPrimerApellido;
    }

   /**
    * Sets the value of the <code>modifiedTitularPrimerApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularPrimerApellido</code>.
    */
    public void setModifiedTitularPrimerApellido(boolean modified) {
        this.modifiedTitularPrimerApellido = modified;
    }

   /**
    * Returns the value of the <code>titularSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>titularSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>titularSegundoApellido</code> attribute.
    */

    public String getTitularSegundoApellido()  {
    	String value;
        value =  titularSegundoApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>titularSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param titularSegundoApellido The new value of the <code>titularSegundoApellido</code> attribute.
    */
    public void setTitularSegundoApellido (String titularSegundoApellido) {
        modifiedTitularSegundoApellido = true;
        this.titularSegundoApellido = titularSegundoApellido;
    }

   /**
    * Sets the value of the <code>modifiedTitularSegundoApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularSegundoApellido</code>.
    */
    public void setModifiedTitularSegundoApellido(boolean modified) {
        this.modifiedTitularSegundoApellido = modified;
    }

   /**
    * Returns the value of the <code>titularFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>titularFechaNacimiento</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>titularFechaNacimiento</code> attribute.
    */

    public Date getTitularFechaNacimiento()  {
    	Date value;
        value =  titularFechaNacimiento;
        return value;
    }

   /**
    * Sets the value of the <code>titularFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>titularFechaNacimiento</code>. Variable Date<br>
    * Comments: <br>
    * @param titularFechaNacimiento The new value of the <code>titularFechaNacimiento</code> attribute.
    */
    public void setTitularFechaNacimiento (Date titularFechaNacimiento) {
        modifiedTitularFechaNacimiento = true;
        this.titularFechaNacimiento = titularFechaNacimiento;
    }

   /**
    * Sets the value of the <code>modifiedTitularFechaNacimiento</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularFechaNacimiento</code>.
    */
    public void setModifiedTitularFechaNacimiento(boolean modified) {
        this.modifiedTitularFechaNacimiento = modified;
    }

   /**
    * Returns the value of the <code>titularGenero</code> attribute.<br>
    * Model Attribute: <code>titularGenero</code>. Variable String Size=1<br>
    * Comments: F - Femenino, M - Masculino<br>
    * @return The value of the <code>titularGenero</code> attribute.
    */

    public String getTitularGenero()  {
    	String value;
        value =  titularGenero;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularGenero</code> attribute.<br>
    * Model Attribute: <code>titularGenero</code>. Variable String Size=1<br>
    * Comments: F - Femenino, M - Masculino<br>
    * @param titularGenero The new value of the <code>titularGenero</code> attribute.
    */
    public void setTitularGenero (String titularGenero) {
        modifiedTitularGenero = true;
        this.titularGenero = titularGenero;
    }

   /**
    * Sets the value of the <code>modifiedTitularGenero</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularGenero</code>.
    */
    public void setModifiedTitularGenero(boolean modified) {
        this.modifiedTitularGenero = modified;
    }

   /**
    * Returns the value of the <code>titularIndicadorExtranjero</code> attribute.<br>
    * Model Attribute: <code>titularIndicadorExtranjero</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>titularIndicadorExtranjero</code> attribute.
    */

    public Boolean getTitularIndicadorExtranjero()  {
    	Boolean value;
        value =  titularIndicadorExtranjero;
        return value;
    }

   /**
    * Sets the value of the <code>titularIndicadorExtranjero</code> attribute.<br>
    * Model Attribute: <code>titularIndicadorExtranjero</code>. Variable Bool<br>
    * Comments: <br>
    * @param titularIndicadorExtranjero The new value of the <code>titularIndicadorExtranjero</code> attribute.
    */
    public void setTitularIndicadorExtranjero (Boolean titularIndicadorExtranjero) {
        modifiedTitularIndicadorExtranjero = true;
        this.titularIndicadorExtranjero = titularIndicadorExtranjero;
    }

   /**
    * Sets the value of the <code>modifiedTitularIndicadorExtranjero</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularIndicadorExtranjero</code>.
    */
    public void setModifiedTitularIndicadorExtranjero(boolean modified) {
        this.modifiedTitularIndicadorExtranjero = modified;
    }

   /**
    * Returns the value of the <code>titularTelefonoFijo</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoFijo</code>. Variable String Size=15<br>
    * Comments: <br>
    * @return The value of the <code>titularTelefonoFijo</code> attribute.
    */

    public String getTitularTelefonoFijo()  {
    	String value;
        value =  titularTelefonoFijo;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularTelefonoFijo</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoFijo</code>. Variable String Size=15<br>
    * Comments: <br>
    * @param titularTelefonoFijo The new value of the <code>titularTelefonoFijo</code> attribute.
    */
    public void setTitularTelefonoFijo (String titularTelefonoFijo) {
        modifiedTitularTelefonoFijo = true;
        this.titularTelefonoFijo = titularTelefonoFijo;
    }

   /**
    * Sets the value of the <code>modifiedTitularTelefonoFijo</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTelefonoFijo</code>.
    */
    public void setModifiedTitularTelefonoFijo(boolean modified) {
        this.modifiedTitularTelefonoFijo = modified;
    }

   /**
    * Returns the value of the <code>titularTelefonoCelular</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoCelular</code>. Variable String Size=15<br>
    * Comments: <br>
    * @return The value of the <code>titularTelefonoCelular</code> attribute.
    */

    public String getTitularTelefonoCelular()  {
    	String value;
        value =  titularTelefonoCelular;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularTelefonoCelular</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoCelular</code>. Variable String Size=15<br>
    * Comments: <br>
    * @param titularTelefonoCelular The new value of the <code>titularTelefonoCelular</code> attribute.
    */
    public void setTitularTelefonoCelular (String titularTelefonoCelular) {
        modifiedTitularTelefonoCelular = true;
        this.titularTelefonoCelular = titularTelefonoCelular;
    }

   /**
    * Sets the value of the <code>modifiedTitularTelefonoCelular</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTelefonoCelular</code>.
    */
    public void setModifiedTitularTelefonoCelular(boolean modified) {
        this.modifiedTitularTelefonoCelular = modified;
    }

   /**
    * Returns the value of the <code>titularCorreoElectronico</code> attribute.<br>
    * Model Attribute: <code>titularCorreoElectronico</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>titularCorreoElectronico</code> attribute.
    */

    public String getTitularCorreoElectronico()  {
    	String value;
        value =  titularCorreoElectronico;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularCorreoElectronico</code> attribute.<br>
    * Model Attribute: <code>titularCorreoElectronico</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param titularCorreoElectronico The new value of the <code>titularCorreoElectronico</code> attribute.
    */
    public void setTitularCorreoElectronico (String titularCorreoElectronico) {
        modifiedTitularCorreoElectronico = true;
        this.titularCorreoElectronico = titularCorreoElectronico;
    }

   /**
    * Sets the value of the <code>modifiedTitularCorreoElectronico</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularCorreoElectronico</code>.
    */
    public void setModifiedTitularCorreoElectronico(boolean modified) {
        this.modifiedTitularCorreoElectronico = modified;
    }

   /**
    * Returns the value of the <code>titularTitularConBeneficios</code> attribute.<br>
    * Model Attribute: <code>titularTitularConBeneficios</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>titularTitularConBeneficios</code> attribute.
    */

    public Boolean getTitularTitularConBeneficios()  {
    	Boolean value;
        value =  titularTitularConBeneficios;
        return value;
    }

   /**
    * Sets the value of the <code>titularTitularConBeneficios</code> attribute.<br>
    * Model Attribute: <code>titularTitularConBeneficios</code>. Variable Bool<br>
    * Comments: <br>
    * @param titularTitularConBeneficios The new value of the <code>titularTitularConBeneficios</code> attribute.
    */
    public void setTitularTitularConBeneficios (Boolean titularTitularConBeneficios) {
        modifiedTitularTitularConBeneficios = true;
        this.titularTitularConBeneficios = titularTitularConBeneficios;
    }

   /**
    * Sets the value of the <code>modifiedTitularTitularConBeneficios</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTitularConBeneficios</code>.
    */
    public void setModifiedTitularTitularConBeneficios(boolean modified) {
        this.modifiedTitularTitularConBeneficios = modified;
    }

   /**
    * Returns the value of the <code>titulardrvIdentificacion</code> attribute.<br>
    * Model Attribute: <code>titulardrvIdentificacion</code>. Variable String Size=100<br>
    * Comments: Para ser mostrado en display set de solicitud<br>
    * @return The value of the <code>titulardrvIdentificacion</code> attribute.
    */

    public String getTitulardrvIdentificacion()  {
    	String value;
        try {
            value = titulardrvIdentificacionDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Titular, Attribute: titulardrvIdentificacion");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>titularTitularRecuperadoInc</code> attribute.<br>
    * Model Attribute: <code>titularTitularRecuperadoInc</code>. Constant Bool<br>
    * Comments: Si el titular se ha recuperado del CORE en una inclusión, no se le puede modificar la dirección, ya que dicha dirección corresponde con la de la familia y no hay capacidad para modificar una dirección de una familia en el CORE<br>
    * @return The value of the <code>titularTitularRecuperadoInc</code> attribute.
    */

    public Boolean getTitularTitularRecuperadoInc()  {
    	Boolean value;
        value =  titularTitularRecuperadoInc;
        return value;
    }

   /**
    * Sets the value of the <code>titularTitularRecuperadoInc</code> attribute.<br>
    * Model Attribute: <code>titularTitularRecuperadoInc</code>. Constant Bool<br>
    * Comments: Si el titular se ha recuperado del CORE en una inclusión, no se le puede modificar la dirección, ya que dicha dirección corresponde con la de la familia y no hay capacidad para modificar una dirección de una familia en el CORE<br>
    * @param titularTitularRecuperadoInc The new value of the <code>titularTitularRecuperadoInc</code> attribute.
    */
    public void setTitularTitularRecuperadoInc (Boolean titularTitularRecuperadoInc) {
        modifiedTitularTitularRecuperadoInc = true;
        this.titularTitularRecuperadoInc = titularTitularRecuperadoInc;
    }

   /**
    * Sets the value of the <code>modifiedTitularTitularRecuperadoInc</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTitularRecuperadoInc</code>.
    */
    public void setModifiedTitularTitularRecuperadoInc(boolean modified) {
        this.modifiedTitularTitularRecuperadoInc = modified;
    }

   /**
    * Returns the value of the <code>titulardrvNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>titulardrvNombreCompleto</code>. Variable String Size=255<br>
    * Comments: <br>
    * @return The value of the <code>titulardrvNombreCompleto</code> attribute.
    */

    public String getTitulardrvNombreCompleto()  {
    	String value;
        try {
            value = titulardrvNombreCompletoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Titular, Attribute: titulardrvNombreCompleto");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>titularTelefonoFijoDC</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoFijoDC</code>. Variable String Size=15<br>
    * Comments: <br>
    * @return The value of the <code>titularTelefonoFijoDC</code> attribute.
    */

    public String getTitularTelefonoFijoDC()  {
    	String value;
        value =  titularTelefonoFijoDC;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularTelefonoFijoDC</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoFijoDC</code>. Variable String Size=15<br>
    * Comments: <br>
    * @param titularTelefonoFijoDC The new value of the <code>titularTelefonoFijoDC</code> attribute.
    */
    public void setTitularTelefonoFijoDC (String titularTelefonoFijoDC) {
        modifiedTitularTelefonoFijoDC = true;
        this.titularTelefonoFijoDC = titularTelefonoFijoDC;
    }

   /**
    * Sets the value of the <code>modifiedTitularTelefonoFijoDC</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTelefonoFijoDC</code>.
    */
    public void setModifiedTitularTelefonoFijoDC(boolean modified) {
        this.modifiedTitularTelefonoFijoDC = modified;
    }

   /**
    * Returns the value of the <code>titularTelefonoCelularDC</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoCelularDC</code>. Variable String Size=15<br>
    * Comments: <br>
    * @return The value of the <code>titularTelefonoCelularDC</code> attribute.
    */

    public String getTitularTelefonoCelularDC()  {
    	String value;
        value =  titularTelefonoCelularDC;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularTelefonoCelularDC</code> attribute.<br>
    * Model Attribute: <code>titularTelefonoCelularDC</code>. Variable String Size=15<br>
    * Comments: <br>
    * @param titularTelefonoCelularDC The new value of the <code>titularTelefonoCelularDC</code> attribute.
    */
    public void setTitularTelefonoCelularDC (String titularTelefonoCelularDC) {
        modifiedTitularTelefonoCelularDC = true;
        this.titularTelefonoCelularDC = titularTelefonoCelularDC;
    }

   /**
    * Sets the value of the <code>modifiedTitularTelefonoCelularDC</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTelefonoCelularDC</code>.
    */
    public void setModifiedTitularTelefonoCelularDC(boolean modified) {
        this.modifiedTitularTelefonoCelularDC = modified;
    }

   /**
    * Returns the value of the <code>titularTitularConBeneficiosCORE</code> attribute.<br>
    * Model Attribute: <code>titularTitularConBeneficiosCORE</code>. Constant Bool<br>
    * Comments: GC3: Si tiene valor TRUE, indica que el Titular ha sido recuperado del CORE y en ese momento es titular con beneficios. Se utilizará para poder cambiar o no la marca de titular con beneficios en la pantalla de Titular<br>
    * @return The value of the <code>titularTitularConBeneficiosCORE</code> attribute.
    */

    public Boolean getTitularTitularConBeneficiosCORE()  {
    	Boolean value;
        value =  titularTitularConBeneficiosCORE;
        return value;
    }

   /**
    * Sets the value of the <code>titularTitularConBeneficiosCORE</code> attribute.<br>
    * Model Attribute: <code>titularTitularConBeneficiosCORE</code>. Constant Bool<br>
    * Comments: GC3: Si tiene valor TRUE, indica que el Titular ha sido recuperado del CORE y en ese momento es titular con beneficios. Se utilizará para poder cambiar o no la marca de titular con beneficios en la pantalla de Titular<br>
    * @param titularTitularConBeneficiosCORE The new value of the <code>titularTitularConBeneficiosCORE</code> attribute.
    */
    public void setTitularTitularConBeneficiosCORE (Boolean titularTitularConBeneficiosCORE) {
        modifiedTitularTitularConBeneficiosCORE = true;
        this.titularTitularConBeneficiosCORE = titularTitularConBeneficiosCORE;
    }

   /**
    * Sets the value of the <code>modifiedTitularTitularConBeneficiosCORE</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularTitularConBeneficiosCORE</code>.
    */
    public void setModifiedTitularTitularConBeneficiosCORE(boolean modified) {
        this.modifiedTitularTitularConBeneficiosCORE = modified;
    }

   /**
    * Returns the value of the <code>titularRazonSocial</code> attribute.<br>
    * Model Attribute: <code>titularRazonSocial</code>. Variable String Size=254<br>
    * Comments: GC3: Permitir que una persona jurídica sea titular de un contrato familiar<br>
    * @return The value of the <code>titularRazonSocial</code> attribute.
    */

    public String getTitularRazonSocial()  {
    	String value;
        value =  titularRazonSocial;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>titularRazonSocial</code> attribute.<br>
    * Model Attribute: <code>titularRazonSocial</code>. Variable String Size=254<br>
    * Comments: GC3: Permitir que una persona jurídica sea titular de un contrato familiar<br>
    * @param titularRazonSocial The new value of the <code>titularRazonSocial</code> attribute.
    */
    public void setTitularRazonSocial (String titularRazonSocial) {
        modifiedTitularRazonSocial = true;
        this.titularRazonSocial = titularRazonSocial;
    }

   /**
    * Sets the value of the <code>modifiedTitularRazonSocial</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularRazonSocial</code>.
    */
    public void setModifiedTitularRazonSocial(boolean modified) {
        this.modifiedTitularRazonSocial = modified;
    }

   /**
    * Returns the value of the <code>titulardrvBeneficiosActivo</code> attribute.<br>
    * Model Attribute: <code>titulardrvBeneficiosActivo</code>. Variable Bool<br>
    * Comments: Devuelve si se debe activar a no el argumento de "Tiene beneficios" para el titular<br>
    * @return The value of the <code>titulardrvBeneficiosActivo</code> attribute.
    */

    public Boolean getTitulardrvBeneficiosActivo()  {
    	Boolean value;
        try {
            value = titulardrvBeneficiosActivoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: Titular, Attribute: titulardrvBeneficiosActivo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>titularDireccionesModificadas</code> attribute.<br>
    * Model Attribute: <code>titularDireccionesModificadas</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>titularDireccionesModificadas</code> attribute.
    */

    public Boolean getTitularDireccionesModificadas()  {
    	Boolean value;
        value =  titularDireccionesModificadas;
        return value;
    }

   /**
    * Sets the value of the <code>titularDireccionesModificadas</code> attribute.<br>
    * Model Attribute: <code>titularDireccionesModificadas</code>. Variable Bool<br>
    * Comments: <br>
    * @param titularDireccionesModificadas The new value of the <code>titularDireccionesModificadas</code> attribute.
    */
    public void setTitularDireccionesModificadas (Boolean titularDireccionesModificadas) {
        modifiedTitularDireccionesModificadas = true;
        this.titularDireccionesModificadas = titularDireccionesModificadas;
    }

   /**
    * Sets the value of the <code>modifiedTitularDireccionesModificadas</code> class property.<br>
    * @param modified The new value of the <code>modifiedTitularDireccionesModificadas</code>.
    */
    public void setModifiedTitularDireccionesModificadas(boolean modified) {
        this.modifiedTitularDireccionesModificadas = modified;
    }

    /**
     * Returns the instance of <code>Direccion</code> related through the <code>Direccion</code> role.
     * Model Relationship:
     * <code>[Direccion] Direccion 0:1  ------ 0:1  Titular [Titular]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Direccion</code> related through the <code>Direccion</code> role.
     */
    @JsonIgnore
    public Direccion getDireccion() {
        return direccion;
    }

   /**
    * Adds an instance of <code>Direccion</code> related through the <code>Direccion</code> role.
    * @param direccion The instance to add to the <code>Direccion</code> role.
    */
    public void add2Direccion(Direccion direccion) {
        this.direccion = (direccion == null  || direccion.isNull() ? null : direccion);
    }

   /**
    * This method gets the attribute value <code>modifiedDireccion</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDireccion</code> has been modified.
    */
    public boolean isModifiedDireccion(){
        return modifiedDireccion;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitud 1:1  ------ 0:1  Titular [Titular]</code>
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
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacion 1:1  ------ 0:M  Titulares [Titular]</code>
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
     * Returns the instance of <code>Departamento</code> related through the <code>DepartamentoNac</code> role.
     * Model Relationship:
     * <code>[Departamento] DepartamentoNac 0:1  ------ 0:M  Titulares [Titular]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Departamento</code> related through the <code>DepartamentoNac</code> role.
     */
    @JsonIgnore
    public Departamento getDepartamentoNac() {
        return departamentoNac;
    }

   /**
    * Adds an instance of <code>Departamento</code> related through the <code>DepartamentoNac</code> role.
    * @param departamentoNac The instance to add to the <code>DepartamentoNac</code> role.
    */
    public void add2DepartamentoNac(Departamento departamentoNac) {
        if (departamentoNac == null || departamentoNac.isNull()) {
            this.modifiedDepartamentoNac = true;
            this.departamentoDepartamentoNacCodigo = null;
        } else {
            this.departamentoDepartamentoNacCodigo = departamentoNac.getDepartamentoCodigo();
        }
        this.departamentoNac = (departamentoNac == null  || departamentoNac.isNull() ? null : departamentoNac);
    }

   /**
    * This method gets the attribute value <code>modifiedDepartamentoNac</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDepartamentoNac</code> has been modified.
    */
    public boolean isModifiedDepartamentoNac(){
        return modifiedDepartamentoNac;
    }

    /**
     * Returns the instance of <code>Municipio</code> related through the <code>MunicipioNac</code> role.
     * Model Relationship:
     * <code>[Municipio] MunicipioNac 0:1  ------ 0:M  Titulares [Titular]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Municipio</code> related through the <code>MunicipioNac</code> role.
     */
    @JsonIgnore
    public Municipio getMunicipioNac() {
        return municipioNac;
    }

   /**
    * Adds an instance of <code>Municipio</code> related through the <code>MunicipioNac</code> role.
    * @param municipioNac The instance to add to the <code>MunicipioNac</code> role.
    */
    public void add2MunicipioNac(Municipio municipioNac) {
        if (municipioNac == null || municipioNac.isNull()) {
            this.modifiedMunicipioNac = true;
            this.municipioMunicipioNacCodigo = null;
        } else {
            this.municipioMunicipioNacCodigo = municipioNac.getMunicipioCodigo();
        }
        this.municipioNac = (municipioNac == null  || municipioNac.isNull() ? null : municipioNac);
    }

   /**
    * This method gets the attribute value <code>modifiedMunicipioNac</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedMunicipioNac</code> has been modified.
    */
    public boolean isModifiedMunicipioNac(){
        return modifiedMunicipioNac;
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
     * Returns the value of the <code>titulardrvIdentificacion</code> derived attribute.
     *
     * @return Value of the <code>titulardrvIdentificacion</code> derived attribute.
     */
    public String titulardrvIdentificacionDerivations() {
        return titulardrvIdentificacion;
    }    

    /**
     * Returns the value of the <code>titulardrvNombreCompleto</code> derived attribute.
     *
     * @return Value of the <code>titulardrvNombreCompleto</code> derived attribute.
     */
    public String titulardrvNombreCompletoDerivations() {
        return titulardrvNombreCompleto;
    }    

    /**
     * Returns the value of the <code>titulardrvBeneficiosActivo</code> derived attribute.
     *
     * @return Value of the <code>titulardrvBeneficiosActivo</code> derived attribute.
     */
    public Boolean titulardrvBeneficiosActivoDerivations() {
        return titulardrvBeneficiosActivo;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        titularCodigo = null;
        titularNumIdentificacion = "";
        titularTipoPersona = "";
        titularPrimerNombre = null;
        titularSegundoNombre = null;
        titularPrimerApellido = null;
        titularSegundoApellido = null;
        titularFechaNacimiento = null;
        titularGenero = null;
        titularIndicadorExtranjero = null;
        titularTelefonoFijo = null;
        titularTelefonoCelular = null;
        titularCorreoElectronico = null;
        titularTitularConBeneficios = false;
        titularTitularRecuperadoInc = false;
        titularTelefonoFijoDC = null;
        titularTelefonoCelularDC = null;
        titularTitularConBeneficiosCORE = false;
        titularRazonSocial = null;
        titularDireccionesModificadas = false;
        direccion = null;
        solicitud = null;
        tipoIdentificacion = null;
        departamentoNac = null;
        municipioNac = null;
        values = new HashMap<>();
        userFunctionsSrv = Arc.container().select(UserFunctions.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Titular.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return TitularConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedTitularCodigo = false;
    	values.put("titularCodigo", getTitularCodigo());
    	modifiedTitularNumIdentificacion = false;
    	values.put("titularNumIdentificacion", getTitularNumIdentificacion());
    	modifiedTitularTipoPersona = false;
    	values.put("titularTipoPersona", getTitularTipoPersona());
    	modifiedTitularPrimerNombre = false;
    	values.put("titularPrimerNombre", getTitularPrimerNombre());
    	modifiedTitularSegundoNombre = false;
    	values.put("titularSegundoNombre", getTitularSegundoNombre());
    	modifiedTitularPrimerApellido = false;
    	values.put("titularPrimerApellido", getTitularPrimerApellido());
    	modifiedTitularSegundoApellido = false;
    	values.put("titularSegundoApellido", getTitularSegundoApellido());
    	modifiedTitularFechaNacimiento = false;
    	values.put("titularFechaNacimiento", getTitularFechaNacimiento());
    	modifiedTitularGenero = false;
    	values.put("titularGenero", getTitularGenero());
    	modifiedTitularIndicadorExtranjero = false;
    	values.put("titularIndicadorExtranjero", getTitularIndicadorExtranjero());
    	modifiedTitularTelefonoFijo = false;
    	values.put("titularTelefonoFijo", getTitularTelefonoFijo());
    	modifiedTitularTelefonoCelular = false;
    	values.put("titularTelefonoCelular", getTitularTelefonoCelular());
    	modifiedTitularCorreoElectronico = false;
    	values.put("titularCorreoElectronico", getTitularCorreoElectronico());
    	modifiedTitularTitularConBeneficios = false;
    	values.put("titularTitularConBeneficios", getTitularTitularConBeneficios());
    	modifiedTitularTitularRecuperadoInc = false;
    	values.put("titularTitularRecuperadoInc", getTitularTitularRecuperadoInc());
    	modifiedTitularTelefonoFijoDC = false;
    	values.put("titularTelefonoFijoDC", getTitularTelefonoFijoDC());
    	modifiedTitularTelefonoCelularDC = false;
    	values.put("titularTelefonoCelularDC", getTitularTelefonoCelularDC());
    	modifiedTitularTitularConBeneficiosCORE = false;
    	values.put("titularTitularConBeneficiosCORE", getTitularTitularConBeneficiosCORE());
    	modifiedTitularRazonSocial = false;
    	values.put("titularRazonSocial", getTitularRazonSocial());
    	modifiedTitularDireccionesModificadas = false;
    	values.put("titularDireccionesModificadas", getTitularDireccionesModificadas());
    	modifiedDireccion = false;
    	modifiedSolicitud = false;
    	modifiedTipoIdentificacion = false;
    	modifiedDepartamentoNac = false;
    	modifiedMunicipioNac = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            titulardrvIdentificacion = null;
            titulardrvNombreCompleto = null;
            titulardrvBeneficiosActivo = null;
    }

    /**
     * Returns the <code>TitularOid</code> object that identifies this instance of <code>Titular</code>.
     * @return <code>TitularOid </code> object that identifies this instance of <code>Titular</code>
     */
    public TitularOid getOid() {
        return new TitularOid(getAESOLICITUDESIDSOLICITUD());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(TitularConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(TitularConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.TITULAR)) {
            // Add this class
            activeFacets.add(Constants.TITULAR);
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


        if (getAgent().isFacetActive(Constants.FUNCIONARIO) || getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.RESPREGIONAL) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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
