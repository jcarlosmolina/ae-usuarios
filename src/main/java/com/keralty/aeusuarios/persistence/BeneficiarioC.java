package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.BeneficiarioCConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.global.FamiliaCConstants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.persistence.oid.BeneficiarioCOid;
import com.keralty.aeusuarios.persistence.oid.FamiliaCOid;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
 * Persistent representation of the <code>BeneficiarioC</code> model class.
 * <p>
 * Model Class: <code>BeneficiarioC</code><br>
 */
@Entity(name = BeneficiarioCConstants.CLASS_NAME)
@Table(name = BeneficiarioCConstants.TBL_NAME)
public class BeneficiarioC extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Embedded Class Identification Function */
    @EmbeddedId
    private BeneficiarioCOid oid;

    /** Class identification function. */
    @Column(name = BeneficiarioCConstants.FLD_CONTRATOCCONTRATOCID, insertable = false, updatable = false )
    @JsonProperty(value="contratoc_id")
    private Long contratoCContratoCID;

    /** Class identification function. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCID, insertable = false, updatable = false )
    @JsonProperty(value="id")
    private Long beneficiarioCID;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCNUMUSUARIO )
    @JsonProperty(value="numusuario")
    private Long beneficiarioCNumUsuario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCNumUsuario;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCCODIGOTIPOUSUARIO )
    @JsonProperty(value="codigotipousuario")
    private String beneficiarioCCodigoTipoUsuario;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCCodigoTipoUsuario;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCINDICADORBBGESTACION )
    @JsonProperty(value="indicadorbbgestacion")
    private Boolean beneficiarioCIndicadorBBGestacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCIndicadorBBGestacion;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCCODUSUARIOBANCOREP )
    @JsonProperty(value="codusuariobancorep")
    private String beneficiarioCCodUsuarioBancoRep;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCCodUsuarioBancoRep;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCFECHAANTIGUEDAD )
    @JsonProperty(value="fechaantiguedad")
    private Date beneficiarioCFechaAntiguedad;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCFechaAntiguedad;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCREQUIEREEXAMENMEDICO )
    @JsonProperty(value="requiereexamenmedico")
    private Boolean beneficiarioCRequiereExamenMedico;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCRequiereExamenMedico;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCESTADOMEDICO )
    @JsonProperty(value="estadomedico")
    private Long beneficiarioCEstadoMedico;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCEstadoMedico;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCFECHAANTIGUEDADREALOSI )
    @JsonProperty(value="fechaantiguedadrealosi")
    private Date beneficiarioCFechaAntiguedadRealOSI;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCFechaAntiguedadRealOSI;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCVALORCUOTAINSCRIPCION )
    @JsonProperty(value="valorcuotainscripcion")
    private Double beneficiarioCValorCuotaInscripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCValorCuotaInscripcion;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCTIENEPREEXISTENCIAS )
    @JsonProperty(value="tienepreexistencias")
    private Boolean beneficiarioCTienePreexistencias;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCTienePreexistencias;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCFECHAINICIOVIGENCIA )
    @JsonProperty(value="fechainiciovigencia")
    private Date beneficiarioCFechaInicioVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCFechaInicioVigencia;

    /** Class member attribute. */
    @Column(name = BeneficiarioCConstants.FLD_BENEFICIARIOCFECHAFINVIGENCIA )
    @JsonProperty(value="fechafinvigencia")
    private Date beneficiarioCFechaFinVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiarioCFechaFinVigencia;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorinicialcontrato")
    protected Double beneficiarioCdrvValorInicialContrato;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorcuotaafiliacion")
    protected Double beneficiarioCdrvValorCuotaAfiliacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorcuotaperiodo")
    protected Double beneficiarioCdrvValorCuotaPeriodo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvdescuentocomercial")
    protected Double beneficiarioCdrvDescuentoComercial;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvdescuentofinanciero")
    protected Double beneficiarioCdrvDescuentoFinanciero;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorcuotabruta")
    protected Double beneficiarioCdrvValorCuotaBruta;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtienepreexistencias")
    protected Boolean beneficiarioCdrvTienePreexistencias;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = BeneficiarioCConstants.ROLE_INVNAME_PERSONAC)
    @JsonIgnore
    private PersonaC personaC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=BeneficiarioCConstants.FLD_CONTRATOCCONTRATOCID, referencedColumnName=ContratoCConstants.FLD_CONTRATOCID, insertable = false, updatable = false)
    })
    @JsonIgnore
    private ContratoC contratoC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=BeneficiarioCConstants.FLD_CONTRATOCFAMILIASCID, referencedColumnName=FamiliaCConstants.FLD_CONTRATOCCONTRATOCID), 
        @JoinColumn(name=BeneficiarioCConstants.FLD_FAMILIACFAMILIASCID1, referencedColumnName=FamiliaCConstants.FLD_FAMILIACID)
    })
    @JsonIgnore
    private FamiliaC familiasC;
    /** Related attribute. */
    @Column(name = BeneficiarioCConstants.FLD_CONTRATOCFAMILIASCID, insertable = false, updatable = false)
    private Long contratoCFamiliasCID;
    /** Related attribute. */
    @Column(name = BeneficiarioCConstants.FLD_FAMILIACFAMILIASCID1, insertable = false, updatable = false)
    private Long familiaCFamiliasCID1;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliasC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=BeneficiarioCConstants.FLD_PARENTESCOPARENTESCOCCODIGO, referencedColumnName=ParentescoConstants.FLD_PARENTESCOCODIGO)
    })
    @JsonIgnore
    private Parentesco parentescoC;
    /** Related attribute. */
    @Column(name = BeneficiarioCConstants.FLD_PARENTESCOPARENTESCOCCODIGO, insertable = false, updatable = false)
    private Long parentescoParentescoCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedParentescoC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=BeneficiarioCConstants.FLD_ESTADOBENEFICIARIOESTADOBENEFICIARIOCCODIGO, referencedColumnName=EstadoBeneficiarioConstants.FLD_ESTADOBENEFICIARIOCODIGO)
    })
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiarioC;
    /** Related attribute. */
    @Column(name = BeneficiarioCConstants.FLD_ESTADOBENEFICIARIOESTADOBENEFICIARIOCCODIGO, insertable = false, updatable = false)
    private Long estadoBeneficiarioEstadoBeneficiarioCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoBeneficiarioC;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public BeneficiarioC() {
        contratoCContratoCID = null;
        beneficiarioCID = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>BeneficiarioC</code>.
     * @param oid Object Identifier of the instance of <code>BeneficiarioC</code> to be created.
     * @throws SystemException
     */
    public BeneficiarioC(BeneficiarioCOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            contratoCContratoCID = oid.getContratoCContratoCID();
            beneficiarioCID = oid.getBeneficiarioCID();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code> through <code>ContratoC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ContratoC</code>
     * @return The value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code> through <code>ContratoC</code>.
     */
    public Long getContratoCContratoCID() {
        return (contratoC != null ? contratoC.getContratoCID() : contratoCContratoCID);
    }

    /**
     * Sets the value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code> through <code>ContratoC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ContratoC</code>
     * @param contratoCContratoCID The new value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code> through <code>ContratoC</code>.
     */
    public void setContratoCContratoCID(Long contratoCContratoCID) {
        this.contratoCContratoCID = contratoCContratoCID;
    }

    /**
     * Returns the value of the <code>beneficiarioCID</code> attribute<br>in class <code>BeneficiarioC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>BeneficiarioC</code>
     * @return The value of the <code>beneficiarioCID</code> attribute<br>in class <code>BeneficiarioC</code>.
     */
    public Long getBeneficiarioCID() {
        return beneficiarioCID;
    }

    /**
     * Sets the value of the <code>beneficiarioCID</code> attribute<br>in class <code>BeneficiarioC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>BeneficiarioC</code>
     * @param beneficiarioCID The new value of the <code>beneficiarioCID</code> attribute<br>in class <code>BeneficiarioC</code>.
     */
    public void setBeneficiarioCID(Long beneficiarioCID) {
        this.beneficiarioCID = beneficiarioCID;
    }

   /**
    * Returns the value of the <code>beneficiarioCNumUsuario</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCNumUsuario</code>. Variable Int<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCNumUsuario</code> attribute.
    */

    public Long getBeneficiarioCNumUsuario()  {
    	Long value;
        value =  beneficiarioCNumUsuario;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCNumUsuario</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCNumUsuario</code>. Variable Int<br>
    * Comments: <br>
    * @param beneficiarioCNumUsuario The new value of the <code>beneficiarioCNumUsuario</code> attribute.
    */
    public void setBeneficiarioCNumUsuario (Long beneficiarioCNumUsuario) {
        modifiedBeneficiarioCNumUsuario = true;
        this.beneficiarioCNumUsuario = beneficiarioCNumUsuario;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCNumUsuario</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCNumUsuario</code>.
    */
    public void setModifiedBeneficiarioCNumUsuario(boolean modified) {
        this.modifiedBeneficiarioCNumUsuario = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCCodigoTipoUsuario</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCCodigoTipoUsuario</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCCodigoTipoUsuario</code> attribute.
    */

    public String getBeneficiarioCCodigoTipoUsuario()  {
    	String value;
        value =  beneficiarioCCodigoTipoUsuario;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>beneficiarioCCodigoTipoUsuario</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCCodigoTipoUsuario</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param beneficiarioCCodigoTipoUsuario The new value of the <code>beneficiarioCCodigoTipoUsuario</code> attribute.
    */
    public void setBeneficiarioCCodigoTipoUsuario (String beneficiarioCCodigoTipoUsuario) {
        modifiedBeneficiarioCCodigoTipoUsuario = true;
        this.beneficiarioCCodigoTipoUsuario = beneficiarioCCodigoTipoUsuario;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCCodigoTipoUsuario</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCCodigoTipoUsuario</code>.
    */
    public void setModifiedBeneficiarioCCodigoTipoUsuario(boolean modified) {
        this.modifiedBeneficiarioCCodigoTipoUsuario = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCIndicadorBBGestacion</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCIndicadorBBGestacion</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCIndicadorBBGestacion</code> attribute.
    */

    public Boolean getBeneficiarioCIndicadorBBGestacion()  {
    	Boolean value;
        value =  beneficiarioCIndicadorBBGestacion;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCIndicadorBBGestacion</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCIndicadorBBGestacion</code>. Variable Bool<br>
    * Comments: <br>
    * @param beneficiarioCIndicadorBBGestacion The new value of the <code>beneficiarioCIndicadorBBGestacion</code> attribute.
    */
    public void setBeneficiarioCIndicadorBBGestacion (Boolean beneficiarioCIndicadorBBGestacion) {
        modifiedBeneficiarioCIndicadorBBGestacion = true;
        this.beneficiarioCIndicadorBBGestacion = beneficiarioCIndicadorBBGestacion;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCIndicadorBBGestacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCIndicadorBBGestacion</code>.
    */
    public void setModifiedBeneficiarioCIndicadorBBGestacion(boolean modified) {
        this.modifiedBeneficiarioCIndicadorBBGestacion = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCCodUsuarioBancoRep</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCCodUsuarioBancoRep</code>. Variable String Size=30<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCCodUsuarioBancoRep</code> attribute.
    */

    public String getBeneficiarioCCodUsuarioBancoRep()  {
    	String value;
        value =  beneficiarioCCodUsuarioBancoRep;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>beneficiarioCCodUsuarioBancoRep</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCCodUsuarioBancoRep</code>. Variable String Size=30<br>
    * Comments: <br>
    * @param beneficiarioCCodUsuarioBancoRep The new value of the <code>beneficiarioCCodUsuarioBancoRep</code> attribute.
    */
    public void setBeneficiarioCCodUsuarioBancoRep (String beneficiarioCCodUsuarioBancoRep) {
        modifiedBeneficiarioCCodUsuarioBancoRep = true;
        this.beneficiarioCCodUsuarioBancoRep = beneficiarioCCodUsuarioBancoRep;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCCodUsuarioBancoRep</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCCodUsuarioBancoRep</code>.
    */
    public void setModifiedBeneficiarioCCodUsuarioBancoRep(boolean modified) {
        this.modifiedBeneficiarioCCodUsuarioBancoRep = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCFechaAntiguedad</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaAntiguedad</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCFechaAntiguedad</code> attribute.
    */

    public Date getBeneficiarioCFechaAntiguedad()  {
    	Date value;
        value =  beneficiarioCFechaAntiguedad;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCFechaAntiguedad</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaAntiguedad</code>. Variable Date<br>
    * Comments: <br>
    * @param beneficiarioCFechaAntiguedad The new value of the <code>beneficiarioCFechaAntiguedad</code> attribute.
    */
    public void setBeneficiarioCFechaAntiguedad (Date beneficiarioCFechaAntiguedad) {
        modifiedBeneficiarioCFechaAntiguedad = true;
        this.beneficiarioCFechaAntiguedad = beneficiarioCFechaAntiguedad;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCFechaAntiguedad</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCFechaAntiguedad</code>.
    */
    public void setModifiedBeneficiarioCFechaAntiguedad(boolean modified) {
        this.modifiedBeneficiarioCFechaAntiguedad = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCRequiereExamenMedico</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCRequiereExamenMedico</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCRequiereExamenMedico</code> attribute.
    */

    public Boolean getBeneficiarioCRequiereExamenMedico()  {
    	Boolean value;
        value =  beneficiarioCRequiereExamenMedico;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCRequiereExamenMedico</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCRequiereExamenMedico</code>. Variable Bool<br>
    * Comments: <br>
    * @param beneficiarioCRequiereExamenMedico The new value of the <code>beneficiarioCRequiereExamenMedico</code> attribute.
    */
    public void setBeneficiarioCRequiereExamenMedico (Boolean beneficiarioCRequiereExamenMedico) {
        modifiedBeneficiarioCRequiereExamenMedico = true;
        this.beneficiarioCRequiereExamenMedico = beneficiarioCRequiereExamenMedico;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCRequiereExamenMedico</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCRequiereExamenMedico</code>.
    */
    public void setModifiedBeneficiarioCRequiereExamenMedico(boolean modified) {
        this.modifiedBeneficiarioCRequiereExamenMedico = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCEstadoMedico</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCEstadoMedico</code>. Variable Nat<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCEstadoMedico</code> attribute.
    */

    public Long getBeneficiarioCEstadoMedico()  {
    	Long value;
        value =  beneficiarioCEstadoMedico;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCEstadoMedico</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCEstadoMedico</code>. Variable Nat<br>
    * Comments: <br>
    * @param beneficiarioCEstadoMedico The new value of the <code>beneficiarioCEstadoMedico</code> attribute.
    */
    public void setBeneficiarioCEstadoMedico (Long beneficiarioCEstadoMedico) {
        modifiedBeneficiarioCEstadoMedico = true;
        this.beneficiarioCEstadoMedico = beneficiarioCEstadoMedico;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCEstadoMedico</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCEstadoMedico</code>.
    */
    public void setModifiedBeneficiarioCEstadoMedico(boolean modified) {
        this.modifiedBeneficiarioCEstadoMedico = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCFechaAntiguedadRealOSI</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaAntiguedadRealOSI</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCFechaAntiguedadRealOSI</code> attribute.
    */

    public Date getBeneficiarioCFechaAntiguedadRealOSI()  {
    	Date value;
        value =  beneficiarioCFechaAntiguedadRealOSI;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCFechaAntiguedadRealOSI</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaAntiguedadRealOSI</code>. Variable Date<br>
    * Comments: <br>
    * @param beneficiarioCFechaAntiguedadRealOSI The new value of the <code>beneficiarioCFechaAntiguedadRealOSI</code> attribute.
    */
    public void setBeneficiarioCFechaAntiguedadRealOSI (Date beneficiarioCFechaAntiguedadRealOSI) {
        modifiedBeneficiarioCFechaAntiguedadRealOSI = true;
        this.beneficiarioCFechaAntiguedadRealOSI = beneficiarioCFechaAntiguedadRealOSI;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCFechaAntiguedadRealOSI</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCFechaAntiguedadRealOSI</code>.
    */
    public void setModifiedBeneficiarioCFechaAntiguedadRealOSI(boolean modified) {
        this.modifiedBeneficiarioCFechaAntiguedadRealOSI = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCValorCuotaInscripcion</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCValorCuotaInscripcion</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCValorCuotaInscripcion</code> attribute.
    */

    public Double getBeneficiarioCValorCuotaInscripcion()  {
    	Double value;
        value =  beneficiarioCValorCuotaInscripcion;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCValorCuotaInscripcion</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCValorCuotaInscripcion</code>. Variable Real<br>
    * Comments: <br>
    * @param beneficiarioCValorCuotaInscripcion The new value of the <code>beneficiarioCValorCuotaInscripcion</code> attribute.
    */
    public void setBeneficiarioCValorCuotaInscripcion (Double beneficiarioCValorCuotaInscripcion) {
        modifiedBeneficiarioCValorCuotaInscripcion = true;
        this.beneficiarioCValorCuotaInscripcion = beneficiarioCValorCuotaInscripcion;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCValorCuotaInscripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCValorCuotaInscripcion</code>.
    */
    public void setModifiedBeneficiarioCValorCuotaInscripcion(boolean modified) {
        this.modifiedBeneficiarioCValorCuotaInscripcion = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCTienePreexistencias</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCTienePreexistencias</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>beneficiarioCTienePreexistencias</code> attribute.
    */

    public Boolean getBeneficiarioCTienePreexistencias()  {
    	Boolean value;
        value =  beneficiarioCTienePreexistencias;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCTienePreexistencias</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCTienePreexistencias</code>. Variable Bool<br>
    * Comments: <br>
    * @param beneficiarioCTienePreexistencias The new value of the <code>beneficiarioCTienePreexistencias</code> attribute.
    */
    public void setBeneficiarioCTienePreexistencias (Boolean beneficiarioCTienePreexistencias) {
        modifiedBeneficiarioCTienePreexistencias = true;
        this.beneficiarioCTienePreexistencias = beneficiarioCTienePreexistencias;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCTienePreexistencias</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCTienePreexistencias</code>.
    */
    public void setModifiedBeneficiarioCTienePreexistencias(boolean modified) {
        this.modifiedBeneficiarioCTienePreexistencias = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCFechaInicioVigencia</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaInicioVigencia</code>. Variable Date<br>
    * Comments: Indica la fecha a partir de la cual inicia la prestación de servicios en medicina prepagada<br>
    * @return The value of the <code>beneficiarioCFechaInicioVigencia</code> attribute.
    */

    public Date getBeneficiarioCFechaInicioVigencia()  {
    	Date value;
        value =  beneficiarioCFechaInicioVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCFechaInicioVigencia</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaInicioVigencia</code>. Variable Date<br>
    * Comments: Indica la fecha a partir de la cual inicia la prestación de servicios en medicina prepagada<br>
    * @param beneficiarioCFechaInicioVigencia The new value of the <code>beneficiarioCFechaInicioVigencia</code> attribute.
    */
    public void setBeneficiarioCFechaInicioVigencia (Date beneficiarioCFechaInicioVigencia) {
        modifiedBeneficiarioCFechaInicioVigencia = true;
        this.beneficiarioCFechaInicioVigencia = beneficiarioCFechaInicioVigencia;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCFechaInicioVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCFechaInicioVigencia</code>.
    */
    public void setModifiedBeneficiarioCFechaInicioVigencia(boolean modified) {
        this.modifiedBeneficiarioCFechaInicioVigencia = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaFinVigencia</code>. Variable Date<br>
    * Comments: Indica la fecha de finalización para la prestación de servicios al beneficiario.<br>
    * @return The value of the <code>beneficiarioCFechaFinVigencia</code> attribute.
    */

    public Date getBeneficiarioCFechaFinVigencia()  {
    	Date value;
        value =  beneficiarioCFechaFinVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>beneficiarioCFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCFechaFinVigencia</code>. Variable Date<br>
    * Comments: Indica la fecha de finalización para la prestación de servicios al beneficiario.<br>
    * @param beneficiarioCFechaFinVigencia The new value of the <code>beneficiarioCFechaFinVigencia</code> attribute.
    */
    public void setBeneficiarioCFechaFinVigencia (Date beneficiarioCFechaFinVigencia) {
        modifiedBeneficiarioCFechaFinVigencia = true;
        this.beneficiarioCFechaFinVigencia = beneficiarioCFechaFinVigencia;
    }

   /**
    * Sets the value of the <code>modifiedBeneficiarioCFechaFinVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedBeneficiarioCFechaFinVigencia</code>.
    */
    public void setModifiedBeneficiarioCFechaFinVigencia(boolean modified) {
        this.modifiedBeneficiarioCFechaFinVigencia = modified;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvValorInicialContrato</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvValorInicialContrato</code>. Variable Real<br>
    * Comments: Es la suma del concepto VALOR BRUTO que viene en la lista de conceptos por la periodicidad de pago.<br>
    * @return The value of the <code>beneficiarioCdrvValorInicialContrato</code> attribute.
    */

    public Double getBeneficiarioCdrvValorInicialContrato()  {
    	Double value;
        try {
            value = beneficiarioCdrvValorInicialContratoDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvValorInicialContrato");
        }
        return value;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvValorCuotaAfiliacion</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvValorCuotaAfiliacion</code>. Variable Real<br>
    * Comments: (es la suma del concepto VALOR BRUTO que viene en la lista de conceptos) dividido en la periodicidad de pago<br>
    * @return The value of the <code>beneficiarioCdrvValorCuotaAfiliacion</code> attribute.
    */

    public Double getBeneficiarioCdrvValorCuotaAfiliacion()  {
    	Double value;
        try {
            value = beneficiarioCdrvValorCuotaAfiliacionDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvValorCuotaAfiliacion");
        }
        return value;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvValorCuotaPeriodo</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvValorCuotaPeriodo</code>. Variable Real<br>
    * Comments: En BH corresponde a "VALOR BRUTO" <br>
    * @return The value of the <code>beneficiarioCdrvValorCuotaPeriodo</code> attribute.
    */

    public Double getBeneficiarioCdrvValorCuotaPeriodo()  {
    	Double value;
        try {
            value = beneficiarioCdrvValorCuotaPeriodoDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvValorCuotaPeriodo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvDescuentoComercial</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvDescuentoComercial</code>. Variable Real<br>
    * Comments: En BH corresponde a "%DESC. BEN" -  "%DESC. FAM" + "%DESC. CON" <br>
    * @return The value of the <code>beneficiarioCdrvDescuentoComercial</code> attribute.
    */

    public Double getBeneficiarioCdrvDescuentoComercial()  {
    	Double value;
        try {
            value = beneficiarioCdrvDescuentoComercialDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvDescuentoComercial");
        }
        return value;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvDescuentoFinanciero</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvDescuentoFinanciero</code>. Variable Real<br>
    * Comments: En BH corresponde a "%DESC. FINANCIERO" <br>
    * @return The value of the <code>beneficiarioCdrvDescuentoFinanciero</code> attribute.
    */

    public Double getBeneficiarioCdrvDescuentoFinanciero()  {
    	Double value;
        try {
            value = beneficiarioCdrvDescuentoFinancieroDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvDescuentoFinanciero");
        }
        return value;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvValorCuotaBruta</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvValorCuotaBruta</code>. Variable Real<br>
    * Comments: Es la suma del concepto Valor Bruto que viene en la lista de conceptos por la periodicidad de pago.
Cambiado el 26/8/2016 a petición de JC Quinche<br>
    * @return The value of the <code>beneficiarioCdrvValorCuotaBruta</code> attribute.
    */

    public Double getBeneficiarioCdrvValorCuotaBruta()  {
    	Double value;
        try {
            value = beneficiarioCdrvValorCuotaBrutaDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvValorCuotaBruta");
        }
        return value;
    }

   /**
    * Returns the value of the <code>beneficiarioCdrvTienePreexistencias</code> attribute.<br>
    * Model Attribute: <code>beneficiarioCdrvTienePreexistencias</code>. Variable Bool<br>
    * Comments: Lo ponemos como un derivado porque la capacidad de inclusión NO nos dice si tiene preexistencias aunque sí que las tenga. <br>
    * @return The value of the <code>beneficiarioCdrvTienePreexistencias</code> attribute.
    */

    public Boolean getBeneficiarioCdrvTienePreexistencias()  {
    	Boolean value;
        try {
            value = beneficiarioCdrvTienePreexistenciasDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: BeneficiarioC, Attribute: beneficiarioCdrvTienePreexistencias");
        }
        return value;
    }

    /**
     * Returns the instance of <code>PersonaC</code> related through the <code>PersonaC</code> role.
     * Model Relationship:
     * <code>[PersonaC] PersonaC 0:1  ------ 0:1  BeneficiariosC [BeneficiarioC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>PersonaC</code> related through the <code>PersonaC</code> role.
     */
    @JsonIgnore
    public PersonaC getPersonaC() {
        return personaC;
    }

   /**
    * Adds an instance of <code>PersonaC</code> related through the <code>PersonaC</code> role.
    * @param personaC The instance to add to the <code>PersonaC</code> role.
    */
    public void add2PersonaC(PersonaC personaC) {
        this.personaC = (personaC == null  || personaC.isNull() ? null : personaC);
    }

   /**
    * This method gets the attribute value <code>modifiedPersonaC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPersonaC</code> has been modified.
    */
    public boolean isModifiedPersonaC(){
        return modifiedPersonaC;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratoC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratoC 1:1  ------ 0:M  BeneficiariosC [BeneficiarioC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ContratoC</code> related through the <code>ContratoC</code> role.
     */
    @JsonIgnore
    public ContratoC getContratoC() {
        return contratoC;
    }

   /**
    * Adds an instance of <code>ContratoC</code> related through the <code>ContratoC</code> role.
    * @param contratoC The instance to add to the <code>ContratoC</code> role.
    */
    public void add2ContratoC(ContratoC contratoC) {
        if (contratoC == null || contratoC.isNull()) {
            this.modifiedContratoC = true;
            this.contratoCContratoCID = null;
        } else {
            this.contratoCContratoCID = contratoC.getContratoCID();
        }
        this.contratoC = (contratoC == null  || contratoC.isNull() ? null : contratoC);
    }

   /**
    * This method gets the attribute value <code>modifiedContratoC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratoC</code> has been modified.
    */
    public boolean isModifiedContratoC(){
        return modifiedContratoC;
    }

    /**
     * Returns the instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
     * Model Relationship:
     * <code>[FamiliaC] FamiliasC 1:1  ------ 0:M  BeneficiariosC [BeneficiarioC]</code>
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
     * Returns the instance of <code>Parentesco</code> related through the <code>ParentescoC</code> role.
     * Model Relationship:
     * <code>[Parentesco] ParentescoC 1:1  ------ 0:M  BeneficiariosC [BeneficiarioC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Parentesco</code> related through the <code>ParentescoC</code> role.
     */
    @JsonIgnore
    public Parentesco getParentescoC() {
        return parentescoC;
    }

   /**
    * Adds an instance of <code>Parentesco</code> related through the <code>ParentescoC</code> role.
    * @param parentescoC The instance to add to the <code>ParentescoC</code> role.
    */
    public void add2ParentescoC(Parentesco parentescoC) {
        if (parentescoC == null || parentescoC.isNull()) {
            this.modifiedParentescoC = true;
            this.parentescoParentescoCCodigo = null;
        } else {
            this.parentescoParentescoCCodigo = parentescoC.getParentescoCodigo();
        }
        this.parentescoC = (parentescoC == null  || parentescoC.isNull() ? null : parentescoC);
    }

   /**
    * This method gets the attribute value <code>modifiedParentescoC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedParentescoC</code> has been modified.
    */
    public boolean isModifiedParentescoC(){
        return modifiedParentescoC;
    }

    /**
     * Returns the instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiarioC</code> role.
     * Model Relationship:
     * <code>[EstadoBeneficiario] EstadoBeneficiarioC 0:1  ------ 0:M  BeneficiariosC [BeneficiarioC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiarioC</code> role.
     */
    @JsonIgnore
    public EstadoBeneficiario getEstadoBeneficiarioC() {
        return estadoBeneficiarioC;
    }

   /**
    * Adds an instance of <code>EstadoBeneficiario</code> related through the <code>EstadoBeneficiarioC</code> role.
    * @param estadoBeneficiarioC The instance to add to the <code>EstadoBeneficiarioC</code> role.
    */
    public void add2EstadoBeneficiarioC(EstadoBeneficiario estadoBeneficiarioC) {
        if (estadoBeneficiarioC == null || estadoBeneficiarioC.isNull()) {
            this.modifiedEstadoBeneficiarioC = true;
            this.estadoBeneficiarioEstadoBeneficiarioCCodigo = null;
        } else {
            this.estadoBeneficiarioEstadoBeneficiarioCCodigo = estadoBeneficiarioC.getEstadoBeneficiarioCodigo();
        }
        this.estadoBeneficiarioC = (estadoBeneficiarioC == null  || estadoBeneficiarioC.isNull() ? null : estadoBeneficiarioC);
    }

   /**
    * This method gets the attribute value <code>modifiedEstadoBeneficiarioC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedEstadoBeneficiarioC</code> has been modified.
    */
    public boolean isModifiedEstadoBeneficiarioC(){
        return modifiedEstadoBeneficiarioC;
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
     * Returns the value of the <code>beneficiarioCdrvValorInicialContrato</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvValorInicialContrato</code> derived attribute.
     */
    public Double beneficiarioCdrvValorInicialContratoDerivations() {
        return beneficiarioCdrvValorInicialContrato;
    }    

    /**
     * Returns the value of the <code>beneficiarioCdrvValorCuotaAfiliacion</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvValorCuotaAfiliacion</code> derived attribute.
     */
    public Double beneficiarioCdrvValorCuotaAfiliacionDerivations() {
        return beneficiarioCdrvValorCuotaAfiliacion;
    }    

    /**
     * Returns the value of the <code>beneficiarioCdrvValorCuotaPeriodo</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvValorCuotaPeriodo</code> derived attribute.
     */
    public Double beneficiarioCdrvValorCuotaPeriodoDerivations() {
        return beneficiarioCdrvValorCuotaPeriodo;
    }    

    /**
     * Returns the value of the <code>beneficiarioCdrvDescuentoComercial</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvDescuentoComercial</code> derived attribute.
     */
    public Double beneficiarioCdrvDescuentoComercialDerivations() {
        return beneficiarioCdrvDescuentoComercial;
    }    

    /**
     * Returns the value of the <code>beneficiarioCdrvDescuentoFinanciero</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvDescuentoFinanciero</code> derived attribute.
     */
    public Double beneficiarioCdrvDescuentoFinancieroDerivations() {
        return beneficiarioCdrvDescuentoFinanciero;
    }    

    /**
     * Returns the value of the <code>beneficiarioCdrvValorCuotaBruta</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvValorCuotaBruta</code> derived attribute.
     */
    public Double beneficiarioCdrvValorCuotaBrutaDerivations() {
        return beneficiarioCdrvValorCuotaBruta;
    }    

    /**
     * Returns the value of the <code>beneficiarioCdrvTienePreexistencias</code> derived attribute.
     *
     * @return Value of the <code>beneficiarioCdrvTienePreexistencias</code> derived attribute.
     */
    public Boolean beneficiarioCdrvTienePreexistenciasDerivations() {
        return beneficiarioCdrvTienePreexistencias;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        beneficiarioCNumUsuario = null;
        beneficiarioCCodigoTipoUsuario = null;
        beneficiarioCIndicadorBBGestacion = null;
        beneficiarioCCodUsuarioBancoRep = null;
        beneficiarioCFechaAntiguedad = null;
        beneficiarioCRequiereExamenMedico = null;
        beneficiarioCEstadoMedico = null;
        beneficiarioCFechaAntiguedadRealOSI = null;
        beneficiarioCValorCuotaInscripcion = null;
        beneficiarioCTienePreexistencias = null;
        beneficiarioCFechaInicioVigencia = null;
        beneficiarioCFechaFinVigencia = null;
        personaC = null;
        contratoC = null;
        familiasC = null;
        parentescoC = null;
        estadoBeneficiarioC = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return BeneficiarioC.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return BeneficiarioCConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedBeneficiarioCNumUsuario = false;
    	values.put("beneficiarioCNumUsuario", getBeneficiarioCNumUsuario());
    	modifiedBeneficiarioCCodigoTipoUsuario = false;
    	values.put("beneficiarioCCodigoTipoUsuario", getBeneficiarioCCodigoTipoUsuario());
    	modifiedBeneficiarioCIndicadorBBGestacion = false;
    	values.put("beneficiarioCIndicadorBBGestacion", getBeneficiarioCIndicadorBBGestacion());
    	modifiedBeneficiarioCCodUsuarioBancoRep = false;
    	values.put("beneficiarioCCodUsuarioBancoRep", getBeneficiarioCCodUsuarioBancoRep());
    	modifiedBeneficiarioCFechaAntiguedad = false;
    	values.put("beneficiarioCFechaAntiguedad", getBeneficiarioCFechaAntiguedad());
    	modifiedBeneficiarioCRequiereExamenMedico = false;
    	values.put("beneficiarioCRequiereExamenMedico", getBeneficiarioCRequiereExamenMedico());
    	modifiedBeneficiarioCEstadoMedico = false;
    	values.put("beneficiarioCEstadoMedico", getBeneficiarioCEstadoMedico());
    	modifiedBeneficiarioCFechaAntiguedadRealOSI = false;
    	values.put("beneficiarioCFechaAntiguedadRealOSI", getBeneficiarioCFechaAntiguedadRealOSI());
    	modifiedBeneficiarioCValorCuotaInscripcion = false;
    	values.put("beneficiarioCValorCuotaInscripcion", getBeneficiarioCValorCuotaInscripcion());
    	modifiedBeneficiarioCTienePreexistencias = false;
    	values.put("beneficiarioCTienePreexistencias", getBeneficiarioCTienePreexistencias());
    	modifiedBeneficiarioCFechaInicioVigencia = false;
    	values.put("beneficiarioCFechaInicioVigencia", getBeneficiarioCFechaInicioVigencia());
    	modifiedBeneficiarioCFechaFinVigencia = false;
    	values.put("beneficiarioCFechaFinVigencia", getBeneficiarioCFechaFinVigencia());
    	modifiedPersonaC = false;
    	modifiedContratoC = false;
    	modifiedFamiliasC = false;
    	modifiedParentescoC = false;
    	modifiedEstadoBeneficiarioC = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            beneficiarioCdrvValorInicialContrato = null;
            beneficiarioCdrvValorCuotaAfiliacion = null;
            beneficiarioCdrvValorCuotaPeriodo = null;
            beneficiarioCdrvDescuentoComercial = null;
            beneficiarioCdrvDescuentoFinanciero = null;
            beneficiarioCdrvValorCuotaBruta = null;
            beneficiarioCdrvTienePreexistencias = null;
    }

    /**
     * Returns the <code>BeneficiarioCOid</code> object that identifies this instance of <code>BeneficiarioC</code>.
     * @return <code>BeneficiarioCOid </code> object that identifies this instance of <code>BeneficiarioC</code>
     */
    public BeneficiarioCOid getOid() {
        return new BeneficiarioCOid(getContratoCContratoCID(), getBeneficiarioCID());
    }

    /**
     * Sets the <code>BeneficiarioCOid</code> object that identifies this instance of <code>BeneficiarioC</code>.
     */    
    public void setOid(BeneficiarioCOid oid) {
        this.oid = oid;
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(BeneficiarioCConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(BeneficiarioCConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.BENEFICIARIOC)) {
            // Add this class
            activeFacets.add(Constants.BENEFICIARIOC);
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
