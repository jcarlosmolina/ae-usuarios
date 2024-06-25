package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.BeneficiarioCConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.global.DepartamentoConstants;
import com.keralty.aeusuarios.global.FamiliaCConstants;
import com.keralty.aeusuarios.global.MunicipioConstants;
import com.keralty.aeusuarios.global.PersonaCConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.oid.BeneficiarioCOid;
import com.keralty.aeusuarios.persistence.oid.FamiliaCOid;
import com.keralty.aeusuarios.persistence.oid.PersonaCOid;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>PersonaC</code> model class.
 * <p>
 * Model Class: <code>PersonaC</code><br>
 */
@Entity(name = PersonaCConstants.CLASS_NAME)
@Table(name = PersonaCConstants.TBL_NAME)
public class PersonaC extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    private transient UserFunctions userFunctionsSrv;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = PersonaCConstants.FLD_PERSONACID )
    @JsonProperty(value="id")
    private Long personaCID;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACCODIGO )
    @JsonProperty(value="codigo")
    private Long personaCCodigo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCCodigo;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACNUMIDENTIFICACION )
    @JsonProperty(value="numidentificacion")
    private String personaCNumIdentificacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCNumIdentificacion;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACMAIL )
    @JsonProperty(value="mail")
    private String personaCMail;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCMail;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACPRIMERNOMBRE )
    @JsonProperty(value="primernombre")
    private String personaCPrimerNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCPrimerNombre;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACSEGUNDONOMBRE )
    @JsonProperty(value="segundonombre")
    private String personaCSegundoNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCSegundoNombre;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACPRIMERAPELLIDO )
    @JsonProperty(value="primerapellido")
    private String personaCPrimerApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCPrimerApellido;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACSEGUNDOAPELLIDO )
    @JsonProperty(value="segundoapellido")
    private String personaCSegundoApellido;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCSegundoApellido;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACFECHANACIMIENTO )
    @JsonProperty(value="fechanacimiento")
    private Date personaCFechaNacimiento;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCFechaNacimiento;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACGENERO )
    @JsonProperty(value="genero")
    private String personaCGenero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCGenero;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACINDICADOREXTRANJERO )
    @JsonProperty(value="indicadorextranjero")
    private Boolean personaCIndicadorExtranjero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCIndicadorExtranjero;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACRAZONSOCIAL )
    @JsonProperty(value="razonsocial")
    private String personaCRazonSocial;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCRazonSocial;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtipopersona")
    protected String personaCdrvTipoPersona;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACTIENEEPSSANITAS )
    @JsonProperty(value="tieneepssanitas")
    private Boolean personaCTieneEPSSanitas;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCTieneEPSSanitas;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACRECHAZADOAFILIACION )
    @JsonProperty(value="rechazadoafiliacion")
    private String personaCRechazadoAfiliacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCRechazadoAfiliacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvrechazada")
    protected Boolean personaCdrvRechazada;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACNOMBRECOMPLETO )
    @JsonProperty(value="nombrecompleto")
    private String personaCNombreCompleto;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCNombreCompleto;

    /** Class member attribute. */
    @Column(name = PersonaCConstants.FLD_PERSONACULTIMAACTUALIZACION )
    @JsonProperty(value="ultimaactualizacion")
    private Timestamp personaCUltimaActualizacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCUltimaActualizacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnombrecompleto")
    protected String personaCdrvNombreCompleto;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvdircorrespondencia")
    protected String personaCdrvDirCorrespondencia;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvciudadcorrespondencia")
    protected String personaCdrvCiudadCorrespondencia;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtiponumdoc")
    protected String personaCdrvTipoNumDoc;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvedad")
    protected Long personaCdrvEdad;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvobscontrato")
    protected String personaCdrvObsContrato;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvimc")
    protected Double personaCdrvIMC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PersonaCConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCCODIGO, referencedColumnName=TipoIdentificacionConstants.FLD_TIPOIDENTIFICACIONCODIGO)
    })
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionC;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_TIPOIDENTIFICACIONTIPOIDENTIFICACIONCCODIGO, insertable = false, updatable = false)
    private Long tipoIdentificacionTipoIdentificacionCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTipoIdentificacionC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PersonaCConstants.FLD_MUNICIPIOMUNICIPIOCNACCODIGO, referencedColumnName=MunicipioConstants.FLD_MUNICIPIOCODIGO)
    })
    @JsonIgnore
    private Municipio municipioCNac;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_MUNICIPIOMUNICIPIOCNACCODIGO, insertable = false, updatable = false)
    private Long municipioMunicipioCNacCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioCNac;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PersonaCConstants.FLD_DEPARTAMENTODEPARTAMENTOCNACCODIGO, referencedColumnName=DepartamentoConstants.FLD_DEPARTAMENTOCODIGO)
    })
    @JsonIgnore
    private Departamento departamentoCNac;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_DEPARTAMENTODEPARTAMENTOCNACCODIGO, insertable = false, updatable = false)
    private Long departamentoDepartamentoCNacCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDepartamentoCNac;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PersonaCConstants.FLD_CONTRATOCCONTRATOSCID, referencedColumnName=ContratoCConstants.FLD_CONTRATOCID)
    })
    @JsonIgnore
    private ContratoC contratosC;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_CONTRATOCCONTRATOSCID, insertable = false, updatable = false)
    private Long contratoCContratosCID;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PersonaCConstants.FLD_CONTRATOCFAMILIASCID, referencedColumnName=FamiliaCConstants.FLD_CONTRATOCCONTRATOCID), 
        @JoinColumn(name=PersonaCConstants.FLD_FAMILIACFAMILIASCID1, referencedColumnName=FamiliaCConstants.FLD_FAMILIACID)
    })
    @JsonIgnore
    private FamiliaC familiasC;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_CONTRATOCFAMILIASCID, insertable = false, updatable = false)
    private Long contratoCFamiliasCID;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_FAMILIACFAMILIASCID1, insertable = false, updatable = false)
    private Long familiaCFamiliasCID1;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliasC;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=PersonaCConstants.FLD_CONTRATOCBENEFICIARIOSCID, referencedColumnName=BeneficiarioCConstants.FLD_CONTRATOCCONTRATOCID), 
        @JoinColumn(name=PersonaCConstants.FLD_BENEFICIARIOCBENEFICIARIOSCID1, referencedColumnName=BeneficiarioCConstants.FLD_BENEFICIARIOCID)
    })
    @JsonIgnore
    private BeneficiarioC beneficiariosC;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_CONTRATOCBENEFICIARIOSCID, insertable = false, updatable = false)
    private Long contratoCBeneficiariosCID;
    /** Related attribute. */
    @Column(name = PersonaCConstants.FLD_BENEFICIARIOCBENEFICIARIOSCID1, insertable = false, updatable = false)
    private Long beneficiarioCBeneficiariosCID1;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiariosC;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public PersonaC() {
        personaCID = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>PersonaC</code>.
     * @param oid Object Identifier of the instance of <code>PersonaC</code> to be created.
     * @throws SystemException
     */
    public PersonaC(PersonaCOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            personaCID = oid.getPersonaCID();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>personaCID</code> attribute<br>in class <code>PersonaC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>PersonaC</code>
     * @return The value of the <code>personaCID</code> attribute<br>in class <code>PersonaC</code>.
     */
    public Long getPersonaCID() {
        return personaCID;
    }

    /**
     * Sets the value of the <code>personaCID</code> attribute<br>in class <code>PersonaC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>PersonaC</code>
     * @param personaCID The new value of the <code>personaCID</code> attribute<br>in class <code>PersonaC</code>.
     */
    public void setPersonaCID(Long personaCID) {
        this.personaCID = personaCID;
    }

   /**
    * Returns the value of the <code>personaCCodigo</code> attribute.<br>
    * Model Attribute: <code>personaCCodigo</code>. Variable Int<br>
    * Comments: Consecutivo de la tabla de persona o institución. Tiene que ser variable porque si creamos la personaC nosotros para pasarla al CORE no sabemos este código y lo tenemos que modificar después. <br>
    * @return The value of the <code>personaCCodigo</code> attribute.
    */

    public Long getPersonaCCodigo()  {
    	Long value;
        value =  personaCCodigo;
        return value;
    }

   /**
    * Sets the value of the <code>personaCCodigo</code> attribute.<br>
    * Model Attribute: <code>personaCCodigo</code>. Variable Int<br>
    * Comments: Consecutivo de la tabla de persona o institución. Tiene que ser variable porque si creamos la personaC nosotros para pasarla al CORE no sabemos este código y lo tenemos que modificar después. <br>
    * @param personaCCodigo The new value of the <code>personaCCodigo</code> attribute.
    */
    public void setPersonaCCodigo (Long personaCCodigo) {
        modifiedPersonaCCodigo = true;
        this.personaCCodigo = personaCCodigo;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCCodigo</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCCodigo</code>.
    */
    public void setModifiedPersonaCCodigo(boolean modified) {
        this.modifiedPersonaCCodigo = modified;
    }

   /**
    * Returns the value of the <code>personaCNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>personaCNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>personaCNumIdentificacion</code> attribute.
    */

    public String getPersonaCNumIdentificacion()  {
    	String value;
        value =  personaCNumIdentificacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>personaCNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @param personaCNumIdentificacion The new value of the <code>personaCNumIdentificacion</code> attribute.
    */
    public void setPersonaCNumIdentificacion (String personaCNumIdentificacion) {
        modifiedPersonaCNumIdentificacion = true;
        this.personaCNumIdentificacion = personaCNumIdentificacion;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCNumIdentificacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCNumIdentificacion</code>.
    */
    public void setModifiedPersonaCNumIdentificacion(boolean modified) {
        this.modifiedPersonaCNumIdentificacion = modified;
    }

   /**
    * Returns the value of the <code>personaCMail</code> attribute.<br>
    * Model Attribute: <code>personaCMail</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>personaCMail</code> attribute.
    */

    public String getPersonaCMail()  {
    	String value;
        value =  personaCMail;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCMail</code> attribute.<br>
    * Model Attribute: <code>personaCMail</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param personaCMail The new value of the <code>personaCMail</code> attribute.
    */
    public void setPersonaCMail (String personaCMail) {
        modifiedPersonaCMail = true;
        this.personaCMail = personaCMail;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCMail</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCMail</code>.
    */
    public void setModifiedPersonaCMail(boolean modified) {
        this.modifiedPersonaCMail = modified;
    }

   /**
    * Returns the value of the <code>personaCPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>personaCPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>personaCPrimerNombre</code> attribute.
    */

    public String getPersonaCPrimerNombre()  {
    	String value;
        value =  personaCPrimerNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>personaCPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param personaCPrimerNombre The new value of the <code>personaCPrimerNombre</code> attribute.
    */
    public void setPersonaCPrimerNombre (String personaCPrimerNombre) {
        modifiedPersonaCPrimerNombre = true;
        this.personaCPrimerNombre = personaCPrimerNombre;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCPrimerNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCPrimerNombre</code>.
    */
    public void setModifiedPersonaCPrimerNombre(boolean modified) {
        this.modifiedPersonaCPrimerNombre = modified;
    }

   /**
    * Returns the value of the <code>personaCSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>personaCSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>personaCSegundoNombre</code> attribute.
    */

    public String getPersonaCSegundoNombre()  {
    	String value;
        value =  personaCSegundoNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>personaCSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param personaCSegundoNombre The new value of the <code>personaCSegundoNombre</code> attribute.
    */
    public void setPersonaCSegundoNombre (String personaCSegundoNombre) {
        modifiedPersonaCSegundoNombre = true;
        this.personaCSegundoNombre = personaCSegundoNombre;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCSegundoNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCSegundoNombre</code>.
    */
    public void setModifiedPersonaCSegundoNombre(boolean modified) {
        this.modifiedPersonaCSegundoNombre = modified;
    }

   /**
    * Returns the value of the <code>personaCPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>personaCPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>personaCPrimerApellido</code> attribute.
    */

    public String getPersonaCPrimerApellido()  {
    	String value;
        value =  personaCPrimerApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>personaCPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param personaCPrimerApellido The new value of the <code>personaCPrimerApellido</code> attribute.
    */
    public void setPersonaCPrimerApellido (String personaCPrimerApellido) {
        modifiedPersonaCPrimerApellido = true;
        this.personaCPrimerApellido = personaCPrimerApellido;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCPrimerApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCPrimerApellido</code>.
    */
    public void setModifiedPersonaCPrimerApellido(boolean modified) {
        this.modifiedPersonaCPrimerApellido = modified;
    }

   /**
    * Returns the value of the <code>personaCSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>personaCSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>personaCSegundoApellido</code> attribute.
    */

    public String getPersonaCSegundoApellido()  {
    	String value;
        value =  personaCSegundoApellido;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>personaCSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param personaCSegundoApellido The new value of the <code>personaCSegundoApellido</code> attribute.
    */
    public void setPersonaCSegundoApellido (String personaCSegundoApellido) {
        modifiedPersonaCSegundoApellido = true;
        this.personaCSegundoApellido = personaCSegundoApellido;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCSegundoApellido</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCSegundoApellido</code>.
    */
    public void setModifiedPersonaCSegundoApellido(boolean modified) {
        this.modifiedPersonaCSegundoApellido = modified;
    }

   /**
    * Returns the value of the <code>personaCFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>personaCFechaNacimiento</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>personaCFechaNacimiento</code> attribute.
    */

    public Date getPersonaCFechaNacimiento()  {
    	Date value;
        value =  personaCFechaNacimiento;
        return value;
    }

   /**
    * Sets the value of the <code>personaCFechaNacimiento</code> attribute.<br>
    * Model Attribute: <code>personaCFechaNacimiento</code>. Variable Date<br>
    * Comments: <br>
    * @param personaCFechaNacimiento The new value of the <code>personaCFechaNacimiento</code> attribute.
    */
    public void setPersonaCFechaNacimiento (Date personaCFechaNacimiento) {
        modifiedPersonaCFechaNacimiento = true;
        this.personaCFechaNacimiento = personaCFechaNacimiento;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCFechaNacimiento</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCFechaNacimiento</code>.
    */
    public void setModifiedPersonaCFechaNacimiento(boolean modified) {
        this.modifiedPersonaCFechaNacimiento = modified;
    }

   /**
    * Returns the value of the <code>personaCGenero</code> attribute.<br>
    * Model Attribute: <code>personaCGenero</code>. Variable String Size=1<br>
    * Comments: <br>
    * @return The value of the <code>personaCGenero</code> attribute.
    */

    public String getPersonaCGenero()  {
    	String value;
        value =  personaCGenero;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCGenero</code> attribute.<br>
    * Model Attribute: <code>personaCGenero</code>. Variable String Size=1<br>
    * Comments: <br>
    * @param personaCGenero The new value of the <code>personaCGenero</code> attribute.
    */
    public void setPersonaCGenero (String personaCGenero) {
        modifiedPersonaCGenero = true;
        this.personaCGenero = personaCGenero;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCGenero</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCGenero</code>.
    */
    public void setModifiedPersonaCGenero(boolean modified) {
        this.modifiedPersonaCGenero = modified;
    }

   /**
    * Returns the value of the <code>personaCIndicadorExtranjero</code> attribute.<br>
    * Model Attribute: <code>personaCIndicadorExtranjero</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>personaCIndicadorExtranjero</code> attribute.
    */

    public Boolean getPersonaCIndicadorExtranjero()  {
    	Boolean value;
        value =  personaCIndicadorExtranjero;
        return value;
    }

   /**
    * Sets the value of the <code>personaCIndicadorExtranjero</code> attribute.<br>
    * Model Attribute: <code>personaCIndicadorExtranjero</code>. Variable Bool<br>
    * Comments: <br>
    * @param personaCIndicadorExtranjero The new value of the <code>personaCIndicadorExtranjero</code> attribute.
    */
    public void setPersonaCIndicadorExtranjero (Boolean personaCIndicadorExtranjero) {
        modifiedPersonaCIndicadorExtranjero = true;
        this.personaCIndicadorExtranjero = personaCIndicadorExtranjero;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCIndicadorExtranjero</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCIndicadorExtranjero</code>.
    */
    public void setModifiedPersonaCIndicadorExtranjero(boolean modified) {
        this.modifiedPersonaCIndicadorExtranjero = modified;
    }

   /**
    * Returns the value of the <code>personaCRazonSocial</code> attribute.<br>
    * Model Attribute: <code>personaCRazonSocial</code>. Variable String Size=254<br>
    * Comments: <br>
    * @return The value of the <code>personaCRazonSocial</code> attribute.
    */

    public String getPersonaCRazonSocial()  {
    	String value;
        value =  personaCRazonSocial;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCRazonSocial</code> attribute.<br>
    * Model Attribute: <code>personaCRazonSocial</code>. Variable String Size=254<br>
    * Comments: <br>
    * @param personaCRazonSocial The new value of the <code>personaCRazonSocial</code> attribute.
    */
    public void setPersonaCRazonSocial (String personaCRazonSocial) {
        modifiedPersonaCRazonSocial = true;
        this.personaCRazonSocial = personaCRazonSocial;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCRazonSocial</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCRazonSocial</code>.
    */
    public void setModifiedPersonaCRazonSocial(boolean modified) {
        this.modifiedPersonaCRazonSocial = modified;
    }

   /**
    * Returns the value of the <code>personaCdrvTipoPersona</code> attribute.<br>
    * Model Attribute: <code>personaCdrvTipoPersona</code>. Variable String Size=1<br>
    * Comments: N - Natural, J - Jurídica<br>
    * @return The value of the <code>personaCdrvTipoPersona</code> attribute.
    */

    public String getPersonaCdrvTipoPersona()  {
    	String value;
        try {
            value = personaCdrvTipoPersonaDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvTipoPersona");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>personaCTieneEPSSanitas</code> attribute.<br>
    * Model Attribute: <code>personaCTieneEPSSanitas</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>personaCTieneEPSSanitas</code> attribute.
    */

    public Boolean getPersonaCTieneEPSSanitas()  {
    	Boolean value;
        value =  personaCTieneEPSSanitas;
        return value;
    }

   /**
    * Sets the value of the <code>personaCTieneEPSSanitas</code> attribute.<br>
    * Model Attribute: <code>personaCTieneEPSSanitas</code>. Variable Bool<br>
    * Comments: <br>
    * @param personaCTieneEPSSanitas The new value of the <code>personaCTieneEPSSanitas</code> attribute.
    */
    public void setPersonaCTieneEPSSanitas (Boolean personaCTieneEPSSanitas) {
        modifiedPersonaCTieneEPSSanitas = true;
        this.personaCTieneEPSSanitas = personaCTieneEPSSanitas;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCTieneEPSSanitas</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCTieneEPSSanitas</code>.
    */
    public void setModifiedPersonaCTieneEPSSanitas(boolean modified) {
        this.modifiedPersonaCTieneEPSSanitas = modified;
    }

   /**
    * Returns the value of the <code>personaCRechazadoAfiliacion</code> attribute.<br>
    * Model Attribute: <code>personaCRechazadoAfiliacion</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>personaCRechazadoAfiliacion</code> attribute.
    */

    public String getPersonaCRechazadoAfiliacion()  {
    	String value;
        value =  personaCRechazadoAfiliacion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCRechazadoAfiliacion</code> attribute.<br>
    * Model Attribute: <code>personaCRechazadoAfiliacion</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param personaCRechazadoAfiliacion The new value of the <code>personaCRechazadoAfiliacion</code> attribute.
    */
    public void setPersonaCRechazadoAfiliacion (String personaCRechazadoAfiliacion) {
        modifiedPersonaCRechazadoAfiliacion = true;
        this.personaCRechazadoAfiliacion = personaCRechazadoAfiliacion;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCRechazadoAfiliacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCRechazadoAfiliacion</code>.
    */
    public void setModifiedPersonaCRechazadoAfiliacion(boolean modified) {
        this.modifiedPersonaCRechazadoAfiliacion = modified;
    }

   /**
    * Returns the value of the <code>personaCdrvRechazada</code> attribute.<br>
    * Model Attribute: <code>personaCdrvRechazada</code>. Variable Bool<br>
    * Comments: Indica que la persona está rechazada. El valor de RechazadoAfiliación es un texto y necesitamos saber si está rechazada o no.<br>
    * @return The value of the <code>personaCdrvRechazada</code> attribute.
    */

    public Boolean getPersonaCdrvRechazada()  {
    	Boolean value;
        try {
            value = personaCdrvRechazadaDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvRechazada");
        }
        return value;
    }

   /**
    * Returns the value of the <code>personaCNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>personaCNombreCompleto</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>personaCNombreCompleto</code> attribute.
    */

    public String getPersonaCNombreCompleto()  {
    	String value;
        value =  personaCNombreCompleto;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>personaCNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>personaCNombreCompleto</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param personaCNombreCompleto The new value of the <code>personaCNombreCompleto</code> attribute.
    */
    public void setPersonaCNombreCompleto (String personaCNombreCompleto) {
        modifiedPersonaCNombreCompleto = true;
        this.personaCNombreCompleto = personaCNombreCompleto;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCNombreCompleto</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCNombreCompleto</code>.
    */
    public void setModifiedPersonaCNombreCompleto(boolean modified) {
        this.modifiedPersonaCNombreCompleto = modified;
    }

   /**
    * Returns the value of the <code>personaCUltimaActualizacion</code> attribute.<br>
    * Model Attribute: <code>personaCUltimaActualizacion</code>. Variable DateTime<br>
    * Comments: Timestamp de la última actualización de la instancia, para evitar estar trayéndola del CORE a cada poco.<br>
    * @return The value of the <code>personaCUltimaActualizacion</code> attribute.
    */

    public Timestamp getPersonaCUltimaActualizacion()  {
    	Timestamp value;
        value =  personaCUltimaActualizacion;
        return value;
    }

   /**
    * Sets the value of the <code>personaCUltimaActualizacion</code> attribute.<br>
    * Model Attribute: <code>personaCUltimaActualizacion</code>. Variable DateTime<br>
    * Comments: Timestamp de la última actualización de la instancia, para evitar estar trayéndola del CORE a cada poco.<br>
    * @param personaCUltimaActualizacion The new value of the <code>personaCUltimaActualizacion</code> attribute.
    */
    public void setPersonaCUltimaActualizacion (Timestamp personaCUltimaActualizacion) {
        modifiedPersonaCUltimaActualizacion = true;
        this.personaCUltimaActualizacion = personaCUltimaActualizacion;
    }

   /**
    * Sets the value of the <code>modifiedPersonaCUltimaActualizacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedPersonaCUltimaActualizacion</code>.
    */
    public void setModifiedPersonaCUltimaActualizacion(boolean modified) {
        this.modifiedPersonaCUltimaActualizacion = modified;
    }

   /**
    * Returns the value of the <code>personaCdrvNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>personaCdrvNombreCompleto</code>. Variable String Size=255<br>
    * Comments: <br>
    * @return The value of the <code>personaCdrvNombreCompleto</code> attribute.
    */

    public String getPersonaCdrvNombreCompleto()  {
    	String value;
        try {
            value = personaCdrvNombreCompletoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvNombreCompleto");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>personaCdrvDirCorrespondencia</code> attribute.<br>
    * Model Attribute: <code>personaCdrvDirCorrespondencia</code>. Variable String Size=999<br>
    * Comments: Si tiene dirección de correspondencia una persona natural o la dirección de la sucursal princiapal si es persona jurídica<br>
    * @return The value of the <code>personaCdrvDirCorrespondencia</code> attribute.
    */

    public String getPersonaCdrvDirCorrespondencia()  {
    	String value;
        try {
            value = personaCdrvDirCorrespondenciaDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvDirCorrespondencia");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>personaCdrvCiudadCorrespondencia</code> attribute.<br>
    * Model Attribute: <code>personaCdrvCiudadCorrespondencia</code>. Variable String Size=150<br>
    * Comments: Si tiene dirección de correspondencia una persona natural o la dirección de la sucursal princiapal si es persona jurídica<br>
    * @return The value of the <code>personaCdrvCiudadCorrespondencia</code> attribute.
    */

    public String getPersonaCdrvCiudadCorrespondencia()  {
    	String value;
        try {
            value = personaCdrvCiudadCorrespondenciaDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvCiudadCorrespondencia");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>personaCdrvTipoNumDoc</code> attribute.<br>
    * Model Attribute: <code>personaCdrvTipoNumDoc</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>personaCdrvTipoNumDoc</code> attribute.
    */

    public String getPersonaCdrvTipoNumDoc()  {
    	String value;
        try {
            value = personaCdrvTipoNumDocDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvTipoNumDoc");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>personaCdrvEdad</code> attribute.<br>
    * Model Attribute: <code>personaCdrvEdad</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>personaCdrvEdad</code> attribute.
    */

    public Long getPersonaCdrvEdad()  {
    	Long value;
        try {
            value = personaCdrvEdadDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvEdad");
        }
        return value;
    }

   /**
    * Returns the value of the <code>personaCdrvObsContrato</code> attribute.<br>
    * Model Attribute: <code>personaCdrvObsContrato</code>. Variable String Size=100<br>
    * Comments: Si el usuario tiene pre-existencias debe ir el texto “ ver carta de preexistencia”<br>
    * @return The value of the <code>personaCdrvObsContrato</code> attribute.
    */

    public String getPersonaCdrvObsContrato()  {
    	String value;
        try {
            value = personaCdrvObsContratoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvObsContrato");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>personaCdrvIMC</code> attribute.<br>
    * Model Attribute: <code>personaCdrvIMC</code>. Variable Real<br>
    * Comments: Indice de masa corporal. Es el Peso (kg) dividido por el cuadrado de la talla (metros). Ambos son datos que están (o deberían estar) es las respuestas del cuestionario. Para saber cuales son los códigos de las preguntas se utilizan dos parametros de configuración (ParamConfig) PREGUNTAPESO y PREGUNTATALLA<br>
    * @return The value of the <code>personaCdrvIMC</code> attribute.
    */

    public Double getPersonaCdrvIMC()  {
    	Double value;
        try {
            value = personaCdrvIMCDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: PersonaC, Attribute: personaCdrvIMC");
        }
        return value;
    }

    /**
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacionC</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacionC 1:1  ------ 0:M  PersonasC [PersonaC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacionC</code> role.
     */
    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionC() {
        return tipoIdentificacionC;
    }

   /**
    * Adds an instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacionC</code> role.
    * @param tipoIdentificacionC The instance to add to the <code>TipoIdentificacionC</code> role.
    */
    public void add2TipoIdentificacionC(TipoIdentificacion tipoIdentificacionC) {
        if (tipoIdentificacionC == null || tipoIdentificacionC.isNull()) {
            this.modifiedTipoIdentificacionC = true;
            this.tipoIdentificacionTipoIdentificacionCCodigo = null;
        } else {
            this.tipoIdentificacionTipoIdentificacionCCodigo = tipoIdentificacionC.getTipoIdentificacionCodigo();
        }
        this.tipoIdentificacionC = (tipoIdentificacionC == null  || tipoIdentificacionC.isNull() ? null : tipoIdentificacionC);
    }

   /**
    * This method gets the attribute value <code>modifiedTipoIdentificacionC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTipoIdentificacionC</code> has been modified.
    */
    public boolean isModifiedTipoIdentificacionC(){
        return modifiedTipoIdentificacionC;
    }

    /**
     * Returns the instance of <code>Municipio</code> related through the <code>MunicipioCNac</code> role.
     * Model Relationship:
     * <code>[Municipio] MunicipioCNac 0:1  ------ 0:M  PersonasC [PersonaC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Municipio</code> related through the <code>MunicipioCNac</code> role.
     */
    @JsonIgnore
    public Municipio getMunicipioCNac() {
        return municipioCNac;
    }

   /**
    * Adds an instance of <code>Municipio</code> related through the <code>MunicipioCNac</code> role.
    * @param municipioCNac The instance to add to the <code>MunicipioCNac</code> role.
    */
    public void add2MunicipioCNac(Municipio municipioCNac) {
        if (municipioCNac == null || municipioCNac.isNull()) {
            this.modifiedMunicipioCNac = true;
            this.municipioMunicipioCNacCodigo = null;
        } else {
            this.municipioMunicipioCNacCodigo = municipioCNac.getMunicipioCodigo();
        }
        this.municipioCNac = (municipioCNac == null  || municipioCNac.isNull() ? null : municipioCNac);
    }

   /**
    * This method gets the attribute value <code>modifiedMunicipioCNac</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedMunicipioCNac</code> has been modified.
    */
    public boolean isModifiedMunicipioCNac(){
        return modifiedMunicipioCNac;
    }

    /**
     * Returns the instance of <code>Departamento</code> related through the <code>DepartamentoCNac</code> role.
     * Model Relationship:
     * <code>[Departamento] DepartamentoCNac 0:1  ------ 0:M  PersonasC [PersonaC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Departamento</code> related through the <code>DepartamentoCNac</code> role.
     */
    @JsonIgnore
    public Departamento getDepartamentoCNac() {
        return departamentoCNac;
    }

   /**
    * Adds an instance of <code>Departamento</code> related through the <code>DepartamentoCNac</code> role.
    * @param departamentoCNac The instance to add to the <code>DepartamentoCNac</code> role.
    */
    public void add2DepartamentoCNac(Departamento departamentoCNac) {
        if (departamentoCNac == null || departamentoCNac.isNull()) {
            this.modifiedDepartamentoCNac = true;
            this.departamentoDepartamentoCNacCodigo = null;
        } else {
            this.departamentoDepartamentoCNacCodigo = departamentoCNac.getDepartamentoCodigo();
        }
        this.departamentoCNac = (departamentoCNac == null  || departamentoCNac.isNull() ? null : departamentoCNac);
    }

   /**
    * This method gets the attribute value <code>modifiedDepartamentoCNac</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDepartamentoCNac</code> has been modified.
    */
    public boolean isModifiedDepartamentoCNac(){
        return modifiedDepartamentoCNac;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:1  ------ 0:1  PersonaCContratante [PersonaC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     */
    @JsonIgnore
    public ContratoC getContratosC() {
        return contratosC;
    }

   /**
    * Adds an instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
    * @param contratosC The instance to add to the <code>ContratosC</code> role.
    */
    public void add2ContratosC(ContratoC contratosC) {
        if (contratosC == null || contratosC.isNull()) {
            this.modifiedContratosC = true;
            this.contratoCContratosCID = null;
        } else {
            this.contratoCContratosCID = contratosC.getContratoCID();
        }
        this.contratosC = (contratosC == null  || contratosC.isNull() ? null : contratosC);
    }

   /**
    * This method gets the attribute value <code>modifiedContratosC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratosC</code> has been modified.
    */
    public boolean isModifiedContratosC(){
        return modifiedContratosC;
    }

    /**
     * Returns the instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
     * Model Relationship:
     * <code>[FamiliaC] FamiliasC 0:1  ------ 0:1  PersonaCTitular [PersonaC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
     */
    @JsonIgnore
    public FamiliaC getFamiliasC() {
        return familiasC;
    }

   /**
    * Adds an instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
    * @param familiasC The instance to add to the <code>FamiliasC</code> role.
    */
    public void add2FamiliasC(FamiliaC familiasC) {
        if (familiasC == null || familiasC.isNull()) {
            this.modifiedFamiliasC = true;
            this.contratoCFamiliasCID = null;
            this.familiaCFamiliasCID1 = null;
        } else {
            this.contratoCFamiliasCID = familiasC.getContratoCContratoCID();
            this.familiaCFamiliasCID1 = familiasC.getFamiliaCID();
        }
        this.familiasC = (familiasC == null  || familiasC.isNull() ? null : familiasC);
    }

   /**
    * This method gets the attribute value <code>modifiedFamiliasC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFamiliasC</code> has been modified.
    */
    public boolean isModifiedFamiliasC(){
        return modifiedFamiliasC;
    }

    /**
     * Returns the instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     * Model Relationship:
     * <code>[BeneficiarioC] BeneficiariosC 0:1  ------ 0:1  PersonaC [PersonaC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     */
    @JsonIgnore
    public BeneficiarioC getBeneficiariosC() {
        return beneficiariosC;
    }

   /**
    * Adds an instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
    * @param beneficiariosC The instance to add to the <code>BeneficiariosC</code> role.
    */
    public void add2BeneficiariosC(BeneficiarioC beneficiariosC) {
        if (beneficiariosC == null || beneficiariosC.isNull()) {
            this.modifiedBeneficiariosC = true;
            this.contratoCBeneficiariosCID = null;
            this.beneficiarioCBeneficiariosCID1 = null;
        } else {
            this.contratoCBeneficiariosCID = beneficiariosC.getContratoCContratoCID();
            this.beneficiarioCBeneficiariosCID1 = beneficiariosC.getBeneficiarioCID();
        }
        this.beneficiariosC = (beneficiariosC == null  || beneficiariosC.isNull() ? null : beneficiariosC);
    }

   /**
    * This method gets the attribute value <code>modifiedBeneficiariosC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedBeneficiariosC</code> has been modified.
    */
    public boolean isModifiedBeneficiariosC(){
        return modifiedBeneficiariosC;
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
     * Returns the value of the <code>personaCdrvTipoPersona</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvTipoPersona</code> derived attribute.
     */
    public String personaCdrvTipoPersonaDerivations() {
        return personaCdrvTipoPersona;
    }    

    /**
     * Returns the value of the <code>personaCdrvRechazada</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvRechazada</code> derived attribute.
     */
    public Boolean personaCdrvRechazadaDerivations() {
        return personaCdrvRechazada;
    }    

    /**
     * Returns the value of the <code>personaCdrvNombreCompleto</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvNombreCompleto</code> derived attribute.
     */
    public String personaCdrvNombreCompletoDerivations() {
        return personaCdrvNombreCompleto;
    }    

    /**
     * Returns the value of the <code>personaCdrvDirCorrespondencia</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvDirCorrespondencia</code> derived attribute.
     */
    public String personaCdrvDirCorrespondenciaDerivations() {
        return personaCdrvDirCorrespondencia;
    }    

    /**
     * Returns the value of the <code>personaCdrvCiudadCorrespondencia</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvCiudadCorrespondencia</code> derived attribute.
     */
    public String personaCdrvCiudadCorrespondenciaDerivations() {
        return personaCdrvCiudadCorrespondencia;
    }    

    /**
     * Returns the value of the <code>personaCdrvTipoNumDoc</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvTipoNumDoc</code> derived attribute.
     */
    public String personaCdrvTipoNumDocDerivations() {
        return personaCdrvTipoNumDoc;
    }    

    /**
     * Returns the value of the <code>personaCdrvEdad</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvEdad</code> derived attribute.
     */
    public Long personaCdrvEdadDerivations() {
        return personaCdrvEdad;
    }    

    /**
     * Returns the value of the <code>personaCdrvObsContrato</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvObsContrato</code> derived attribute.
     */
    public String personaCdrvObsContratoDerivations() {
        return personaCdrvObsContrato;
    }    

    /**
     * Returns the value of the <code>personaCdrvIMC</code> derived attribute.
     *
     * @return Value of the <code>personaCdrvIMC</code> derived attribute.
     */
    public Double personaCdrvIMCDerivations() {
        return personaCdrvIMC;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        personaCCodigo = null;
        personaCNumIdentificacion = "";
        personaCMail = null;
        personaCPrimerNombre = null;
        personaCSegundoNombre = null;
        personaCPrimerApellido = null;
        personaCSegundoApellido = null;
        personaCFechaNacimiento = null;
        personaCGenero = null;
        personaCIndicadorExtranjero = null;
        personaCRazonSocial = null;
        personaCTieneEPSSanitas = null;
        personaCRechazadoAfiliacion = null;
        personaCNombreCompleto = null;
        personaCUltimaActualizacion = null;
        tipoIdentificacionC = null;
        municipioCNac = null;
        departamentoCNac = null;
        contratosC = null;
        familiasC = null;
        beneficiariosC = null;
        values = new HashMap<>();
        userFunctionsSrv = Arc.container().select(UserFunctions.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return PersonaC.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return PersonaCConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedPersonaCCodigo = false;
    	values.put("personaCCodigo", getPersonaCCodigo());
    	modifiedPersonaCNumIdentificacion = false;
    	values.put("personaCNumIdentificacion", getPersonaCNumIdentificacion());
    	modifiedPersonaCMail = false;
    	values.put("personaCMail", getPersonaCMail());
    	modifiedPersonaCPrimerNombre = false;
    	values.put("personaCPrimerNombre", getPersonaCPrimerNombre());
    	modifiedPersonaCSegundoNombre = false;
    	values.put("personaCSegundoNombre", getPersonaCSegundoNombre());
    	modifiedPersonaCPrimerApellido = false;
    	values.put("personaCPrimerApellido", getPersonaCPrimerApellido());
    	modifiedPersonaCSegundoApellido = false;
    	values.put("personaCSegundoApellido", getPersonaCSegundoApellido());
    	modifiedPersonaCFechaNacimiento = false;
    	values.put("personaCFechaNacimiento", getPersonaCFechaNacimiento());
    	modifiedPersonaCGenero = false;
    	values.put("personaCGenero", getPersonaCGenero());
    	modifiedPersonaCIndicadorExtranjero = false;
    	values.put("personaCIndicadorExtranjero", getPersonaCIndicadorExtranjero());
    	modifiedPersonaCRazonSocial = false;
    	values.put("personaCRazonSocial", getPersonaCRazonSocial());
    	modifiedPersonaCTieneEPSSanitas = false;
    	values.put("personaCTieneEPSSanitas", getPersonaCTieneEPSSanitas());
    	modifiedPersonaCRechazadoAfiliacion = false;
    	values.put("personaCRechazadoAfiliacion", getPersonaCRechazadoAfiliacion());
    	modifiedPersonaCNombreCompleto = false;
    	values.put("personaCNombreCompleto", getPersonaCNombreCompleto());
    	modifiedPersonaCUltimaActualizacion = false;
    	values.put("personaCUltimaActualizacion", getPersonaCUltimaActualizacion());
    	modifiedTipoIdentificacionC = false;
    	modifiedMunicipioCNac = false;
    	modifiedDepartamentoCNac = false;
    	modifiedContratosC = false;
    	modifiedFamiliasC = false;
    	modifiedBeneficiariosC = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            personaCdrvTipoPersona = null;
            personaCdrvRechazada = null;
            personaCdrvNombreCompleto = null;
            personaCdrvDirCorrespondencia = null;
            personaCdrvCiudadCorrespondencia = null;
            personaCdrvTipoNumDoc = null;
            personaCdrvEdad = null;
            personaCdrvObsContrato = null;
            personaCdrvIMC = null;
    }

    /**
     * Returns the <code>PersonaCOid</code> object that identifies this instance of <code>PersonaC</code>.
     * @return <code>PersonaCOid </code> object that identifies this instance of <code>PersonaC</code>
     */
    public PersonaCOid getOid() {
        return new PersonaCOid(getPersonaCID());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(PersonaCConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(PersonaCConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.PERSONAC)) {
            // Add this class
            activeFacets.add(Constants.PERSONAC);
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
