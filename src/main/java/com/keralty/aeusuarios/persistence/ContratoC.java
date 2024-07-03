package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.global.EstadoContratoConstants;
import com.keralty.aeusuarios.global.GrupoAsociadoConstants;
import com.keralty.aeusuarios.global.MunicipioConstants;
import com.keralty.aeusuarios.global.PeriodicidadConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.global.TarifaConstants;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.repository.AsesorJpaRepository;
import com.keralty.aeusuarios.repository.ContratoCJpaRepository;
import com.keralty.aeusuarios.repository.PlanesJpaRepository;
import com.keralty.aeusuarios.repository.ProductosJpaRepository;
import com.keralty.aeusuarios.repository.SolicitudJpaRepository;
import com.keralty.aeusuarios.repository.SucursalJpaRepository;
import com.keralty.aeusuarios.service.EstadoContratoService;
import com.keralty.aeusuarios.service.GrupoAsociadoService;
import com.keralty.aeusuarios.service.MunicipioService;
import com.keralty.aeusuarios.service.PeriodicidadService;
import com.keralty.aeusuarios.service.TarifaService;
import com.keralty.aeusuarios.utils.Utilities;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.microprofile.rest.client.inject.RestClient;
/**
 * Persistent representation of the <code>ContratoC</code> model class.
 * <p>
 * Model Class: <code>ContratoC</code><br>
 */
@Entity(name = ContratoCConstants.CLASS_NAME)
@Table(name = ContratoCConstants.TBL_NAME)
public class ContratoC extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient ContratoCJpaRepository contratoCRepository;

    @JsonIgnore
    private transient SolicitudJpaRepository solicitudRepository;

    @RestClient
    private transient PeriodicidadService periodicidadService;

    @RestClient
    private transient EstadoContratoService estadoContratoService;

    @JsonIgnore
    private transient ProductosJpaRepository productosRepository;

    @JsonIgnore
    private transient PlanesJpaRepository planesRepository;

    @RestClient
    private transient TarifaService tarifaService;

    @RestClient
    private transient GrupoAsociadoService grupoAsociadoService;

    @RestClient
    private transient MunicipioService municipioService;

    @JsonIgnore
    private transient SucursalJpaRepository sucursalRepository;

    @JsonIgnore
    private transient AsesorJpaRepository asesorRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = ContratoCConstants.FLD_CONTRATOCID )
    @JsonProperty(value="id")
    private Long contratoCID;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCNUMCONTRATO )
    @JsonProperty(value="numcontrato")
    private String contratoCNumContrato;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCNumContrato;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCNUMSOLICITUD )
    @JsonProperty(value="numsolicitud")
    private String contratoCNumSolicitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCNumSolicitud;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCFECHASOLICITUD )
    @JsonProperty(value="fechasolicitud")
    private Date contratoCFechaSolicitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCFechaSolicitud;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCTIPOCONTRATO )
    @JsonProperty(value="tipocontrato")
    private Long contratoCTipoContrato;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCTipoContrato;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCFECHAINIVIGENCIA )
    @JsonProperty(value="fechainivigencia")
    private Date contratoCFechaIniVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCFechaIniVigencia;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCFECHAFINVIGENCIA )
    @JsonProperty(value="fechafinvigencia")
    private Date contratoCFechaFinVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCFechaFinVigencia;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCDIRECCION )
    @JsonProperty(value="direccion")
    private String contratoCDireccion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCDireccion;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCCORREOCONTRATANTE )
    @JsonProperty(value="correocontratante")
    private String contratoCcorreoContratante;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCcorreoContratante;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCNUMTELCONTRATANTE )
    @JsonProperty(value="numtelcontratante")
    private String contratoCnumTelContratante;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCnumTelContratante;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCNUMCELCONTRATANTE )
    @JsonProperty(value="numcelcontratante")
    private String contratoCnumCelContratante;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCnumCelContratante;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCEXENTOIVA )
    @JsonProperty(value="exentoiva")
    private String contratoCexentoIVA;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCexentoIVA;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCCONTRATOCONFIRMA )
    @JsonProperty(value="contratoconfirma")
    private Boolean contratoCContratoConFirma;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCContratoConFirma;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCVALORCUOTAPERIODO )
    @JsonProperty(value="valorcuotaperiodo")
    private Double contratoCvalorCuotaPeriodo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCvalorCuotaPeriodo;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCDESCUENTOCOMERCIAL )
    @JsonProperty(value="descuentocomercial")
    private Double contratoCdescuentoComercial;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCdescuentoComercial;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCIVA )
    @JsonProperty(value="iva")
    private Double contratoCIVA;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCIVA;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCDESCUENTOFINANCIERO )
    @JsonProperty(value="descuentofinanciero")
    private Double contratoCdescuentoFinanciero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCdescuentoFinanciero;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvtipocontrato")
    protected String contratoCdrvTipoContrato;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnumpagos")
    protected Long contratoCdrvNumPagos;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorinicialcontrato")
    protected Double contratoCdrvValorInicialContrato;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorcuotaafiliacion")
    protected Double contratoCdrvValorCuotaAfiliacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorinicialcontratobbges")
    protected Double contratoCdrvValorInicialContratoBBGes;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCCONTRATONOTIFICADO )
    @JsonProperty(value="contratonotificado")
    private Boolean contratoCcontratoNotificado;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCcontratoNotificado;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCULTIMAACTUALIZACION )
    @JsonProperty(value="ultimaactualizacion")
    private Timestamp contratoCUltimaActualizacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCUltimaActualizacion;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvvalorcuotabruta")
    protected Double contratoCdrvValorCuotaBruta;

    /** Class member attribute. */
    @Column(name = ContratoCConstants.FLD_CONTRATOCCODTARIFA )
    @JsonProperty(value="codtarifa")
    private String contratoCCodTarifa;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratoCCodTarifa;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvmostrarpreenrepanexo")
    protected Boolean contratoCdrvMostrarPreEnRepAnexo;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvmostrarpreenrepcon")
    protected Boolean contratoCdrvMostrarPreEnRepCon;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvnumfamilia")
    protected String contratoCdrvNumFamilia;

    /** Related Class. */
    @OneToMany(mappedBy = ContratoCConstants.ROLE_INVNAME_SOLICITUD)
    @JsonIgnore
    private Collection <Solicitud> solicitud;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitud;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = ContratoCConstants.ROLE_INVNAME_PERSONACCONTRATANTE)
    @JsonIgnore
    private PersonaC personaCContratante;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPersonaCContratante;

    /** Related Class. */
    @OneToMany(mappedBy = ContratoCConstants.ROLE_INVNAME_BENEFICIARIOSC)
    @JsonIgnore
    private Collection <BeneficiarioC> beneficiariosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedBeneficiariosC;

    /** Related Class. */
    @OneToMany(mappedBy = ContratoCConstants.ROLE_INVNAME_FAMILIASC)
    @JsonIgnore
    private Collection <FamiliaC> familiasC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliasC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_PERIODICIDADCODIGO, referencedColumnName=PeriodicidadConstants.FLD_PERIODICIDADCODIGO)
    })
    @JsonIgnore
    private Periodicidad periodicidadC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_PERIODICIDADCODIGO, insertable = false, updatable = false)
    private Long periodicidadCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPeriodicidadC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_ESTADOCONTRATOESTADOCONTRATOCCODIGO, referencedColumnName=EstadoContratoConstants.FLD_ESTADOCONTRATOCODIGO)
    })
    @JsonIgnore
    private EstadoContrato estadoContratoC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_ESTADOCONTRATOESTADOCONTRATOCCODIGO, insertable = false, updatable = false)
    private Long estadoContratoEstadoContratoCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedEstadoContratoC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_PRODUCTOSPRODUCTO, referencedColumnName=ProductosConstants.FLD_PRODUCTOSPRODUCTO)
    })
    @JsonIgnore
    private Productos productoC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_PRODUCTOSPRODUCTO, insertable = false, updatable = false)
    private Long productosProducto;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductoC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_PLANESPLAN, referencedColumnName=PlanesConstants.FLD_PLANESPLAN)
    })
    @JsonIgnore
    private Planes planC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_PLANESPLAN, insertable = false, updatable = false)
    private Long planesPlan;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlanC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_TARIFATARIFACID, referencedColumnName=TarifaConstants.FLD_TARIFAID)
    })
    @JsonIgnore
    private Tarifa tarifaC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_TARIFATARIFACID, insertable = false, updatable = false)
    private Long tarifaTarifaCId;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTarifaC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_GRUPOASOCIADOGRUPOASOCIADOCCODIGO, referencedColumnName=GrupoAsociadoConstants.FLD_GRUPOASOCIADOCODIGO)
    })
    @JsonIgnore
    private GrupoAsociado grupoAsociadoC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_GRUPOASOCIADOGRUPOASOCIADOCCODIGO, insertable = false, updatable = false)
    private Long grupoAsociadoGrupoAsociadoCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGrupoAsociadoC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_MUNICIPIOMUNICIPIOCCODIGO, referencedColumnName=MunicipioConstants.FLD_MUNICIPIOCODIGO)
    })
    @JsonIgnore
    private Municipio municipioC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_MUNICIPIOMUNICIPIOCCODIGO, insertable = false, updatable = false)
    private Long municipioMunicipioCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedMunicipioC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_SUCURSALSUCURSALCCODIGO, referencedColumnName=SucursalConstants.FLD_SUCURSALCODIGO)
    })
    @JsonIgnore
    private Sucursal sucursalC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_SUCURSALSUCURSALCCODIGO, insertable = false, updatable = false)
    private Long sucursalSucursalCCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSucursalC;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ContratoCConstants.FLD_FUNCIONARIOASESORCID, referencedColumnName=AsesorConstants.FLD_FUNCIONARIOID)
    })
    @JsonIgnore
    private Asesor asesorC;
    /** Related attribute. */
    @Column(name = ContratoCConstants.FLD_FUNCIONARIOASESORCID, insertable = false, updatable = false)
    private Long funcionarioAsesorCId;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAsesorC;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ContratoC() {
        contratoCID = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ContratoC</code>.
     * @param oid Object Identifier of the instance of <code>ContratoC</code> to be created.
     * @throws SystemException
     */
    public ContratoC(ContratoCOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            contratoCID = oid.getContratoCID();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ContratoC</code>
     * @return The value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code>.
     */
    public Long getContratoCID() {
        return contratoCID;
    }

    /**
     * Sets the value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ContratoC</code>
     * @param contratoCID The new value of the <code>contratoCID</code> attribute<br>in class <code>ContratoC</code>.
     */
    public void setContratoCID(Long contratoCID) {
        this.contratoCID = contratoCID;
    }

   /**
    * Returns the value of the <code>contratoCNumContrato</code> attribute.<br>
    * Model Attribute: <code>contratoCNumContrato</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>contratoCNumContrato</code> attribute.
    */

    public String getContratoCNumContrato()  {
    	String value;
        value =  contratoCNumContrato;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCNumContrato</code> attribute.<br>
    * Model Attribute: <code>contratoCNumContrato</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param contratoCNumContrato The new value of the <code>contratoCNumContrato</code> attribute.
    */
    public void setContratoCNumContrato (String contratoCNumContrato) {
        modifiedContratoCNumContrato = true;
        this.contratoCNumContrato = contratoCNumContrato;
    }

   /**
    * Returns the value of the <code>modifiedContratoCNumContrato</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCNumContrato</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCNumContrato() {
        return modifiedContratoCNumContrato;
    }

   /**
    * Sets the value of the <code>modifiedContratoCNumContrato</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCNumContrato</code>.
    */
    public void setModifiedContratoCNumContrato(boolean modified) {
        this.modifiedContratoCNumContrato = modified;
    }

   /**
    * Returns the value of the <code>contratoCNumSolicitud</code> attribute.<br>
    * Model Attribute: <code>contratoCNumSolicitud</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>contratoCNumSolicitud</code> attribute.
    */

    public String getContratoCNumSolicitud()  {
    	String value;
        value =  contratoCNumSolicitud;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCNumSolicitud</code> attribute.<br>
    * Model Attribute: <code>contratoCNumSolicitud</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param contratoCNumSolicitud The new value of the <code>contratoCNumSolicitud</code> attribute.
    */
    public void setContratoCNumSolicitud (String contratoCNumSolicitud) {
        modifiedContratoCNumSolicitud = true;
        this.contratoCNumSolicitud = contratoCNumSolicitud;
    }

   /**
    * Returns the value of the <code>modifiedContratoCNumSolicitud</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCNumSolicitud</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCNumSolicitud() {
        return modifiedContratoCNumSolicitud;
    }

   /**
    * Sets the value of the <code>modifiedContratoCNumSolicitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCNumSolicitud</code>.
    */
    public void setModifiedContratoCNumSolicitud(boolean modified) {
        this.modifiedContratoCNumSolicitud = modified;
    }

   /**
    * Returns the value of the <code>contratoCFechaSolicitud</code> attribute.<br>
    * Model Attribute: <code>contratoCFechaSolicitud</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>contratoCFechaSolicitud</code> attribute.
    */

    public Date getContratoCFechaSolicitud()  {
    	Date value;
        value =  contratoCFechaSolicitud;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCFechaSolicitud</code> attribute.<br>
    * Model Attribute: <code>contratoCFechaSolicitud</code>. Variable Date<br>
    * Comments: <br>
    * @param contratoCFechaSolicitud The new value of the <code>contratoCFechaSolicitud</code> attribute.
    */
    public void setContratoCFechaSolicitud (Date contratoCFechaSolicitud) {
        modifiedContratoCFechaSolicitud = true;
        this.contratoCFechaSolicitud = contratoCFechaSolicitud;
    }

   /**
    * Returns the value of the <code>modifiedContratoCFechaSolicitud</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCFechaSolicitud</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCFechaSolicitud() {
        return modifiedContratoCFechaSolicitud;
    }

   /**
    * Sets the value of the <code>modifiedContratoCFechaSolicitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCFechaSolicitud</code>.
    */
    public void setModifiedContratoCFechaSolicitud(boolean modified) {
        this.modifiedContratoCFechaSolicitud = modified;
    }

   /**
    * Returns the value of the <code>contratoCTipoContrato</code> attribute.<br>
    * Model Attribute: <code>contratoCTipoContrato</code>. Variable Nat<br>
    * Comments: <br>
    * @return The value of the <code>contratoCTipoContrato</code> attribute.
    */

    public Long getContratoCTipoContrato()  {
    	Long value;
        value =  contratoCTipoContrato;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCTipoContrato</code> attribute.<br>
    * Model Attribute: <code>contratoCTipoContrato</code>. Variable Nat<br>
    * Comments: <br>
    * @param contratoCTipoContrato The new value of the <code>contratoCTipoContrato</code> attribute.
    */
    public void setContratoCTipoContrato (Long contratoCTipoContrato) {
        modifiedContratoCTipoContrato = true;
        this.contratoCTipoContrato = contratoCTipoContrato;
    }

   /**
    * Returns the value of the <code>modifiedContratoCTipoContrato</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCTipoContrato</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCTipoContrato() {
        return modifiedContratoCTipoContrato;
    }

   /**
    * Sets the value of the <code>modifiedContratoCTipoContrato</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCTipoContrato</code>.
    */
    public void setModifiedContratoCTipoContrato(boolean modified) {
        this.modifiedContratoCTipoContrato = modified;
    }

   /**
    * Returns the value of the <code>contratoCFechaIniVigencia</code> attribute.<br>
    * Model Attribute: <code>contratoCFechaIniVigencia</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>contratoCFechaIniVigencia</code> attribute.
    */

    public Date getContratoCFechaIniVigencia()  {
    	Date value;
        value =  contratoCFechaIniVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCFechaIniVigencia</code> attribute.<br>
    * Model Attribute: <code>contratoCFechaIniVigencia</code>. Variable Date<br>
    * Comments: <br>
    * @param contratoCFechaIniVigencia The new value of the <code>contratoCFechaIniVigencia</code> attribute.
    */
    public void setContratoCFechaIniVigencia (Date contratoCFechaIniVigencia) {
        modifiedContratoCFechaIniVigencia = true;
        this.contratoCFechaIniVigencia = contratoCFechaIniVigencia;
    }

   /**
    * Returns the value of the <code>modifiedContratoCFechaIniVigencia</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCFechaIniVigencia</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCFechaIniVigencia() {
        return modifiedContratoCFechaIniVigencia;
    }

   /**
    * Sets the value of the <code>modifiedContratoCFechaIniVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCFechaIniVigencia</code>.
    */
    public void setModifiedContratoCFechaIniVigencia(boolean modified) {
        this.modifiedContratoCFechaIniVigencia = modified;
    }

   /**
    * Returns the value of the <code>contratoCFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>contratoCFechaFinVigencia</code>. Variable Date<br>
    * Comments: <br>
    * @return The value of the <code>contratoCFechaFinVigencia</code> attribute.
    */

    public Date getContratoCFechaFinVigencia()  {
    	Date value;
        value =  contratoCFechaFinVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCFechaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>contratoCFechaFinVigencia</code>. Variable Date<br>
    * Comments: <br>
    * @param contratoCFechaFinVigencia The new value of the <code>contratoCFechaFinVigencia</code> attribute.
    */
    public void setContratoCFechaFinVigencia (Date contratoCFechaFinVigencia) {
        modifiedContratoCFechaFinVigencia = true;
        this.contratoCFechaFinVigencia = contratoCFechaFinVigencia;
    }

   /**
    * Returns the value of the <code>modifiedContratoCFechaFinVigencia</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCFechaFinVigencia</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCFechaFinVigencia() {
        return modifiedContratoCFechaFinVigencia;
    }

   /**
    * Sets the value of the <code>modifiedContratoCFechaFinVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCFechaFinVigencia</code>.
    */
    public void setModifiedContratoCFechaFinVigencia(boolean modified) {
        this.modifiedContratoCFechaFinVigencia = modified;
    }

   /**
    * Returns the value of the <code>contratoCDireccion</code> attribute.<br>
    * Model Attribute: <code>contratoCDireccion</code>. Variable String Size=259<br>
    * Comments: <br>
    * @return The value of the <code>contratoCDireccion</code> attribute.
    */

    public String getContratoCDireccion()  {
    	String value;
        value =  contratoCDireccion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCDireccion</code> attribute.<br>
    * Model Attribute: <code>contratoCDireccion</code>. Variable String Size=259<br>
    * Comments: <br>
    * @param contratoCDireccion The new value of the <code>contratoCDireccion</code> attribute.
    */
    public void setContratoCDireccion (String contratoCDireccion) {
        modifiedContratoCDireccion = true;
        this.contratoCDireccion = contratoCDireccion;
    }

   /**
    * Returns the value of the <code>modifiedContratoCDireccion</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCDireccion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCDireccion() {
        return modifiedContratoCDireccion;
    }

   /**
    * Sets the value of the <code>modifiedContratoCDireccion</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCDireccion</code>.
    */
    public void setModifiedContratoCDireccion(boolean modified) {
        this.modifiedContratoCDireccion = modified;
    }

   /**
    * Returns the value of the <code>contratoCcorreoContratante</code> attribute.<br>
    * Model Attribute: <code>contratoCcorreoContratante</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>contratoCcorreoContratante</code> attribute.
    */

    public String getContratoCcorreoContratante()  {
    	String value;
        value =  contratoCcorreoContratante;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCcorreoContratante</code> attribute.<br>
    * Model Attribute: <code>contratoCcorreoContratante</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param contratoCcorreoContratante The new value of the <code>contratoCcorreoContratante</code> attribute.
    */
    public void setContratoCcorreoContratante (String contratoCcorreoContratante) {
        modifiedContratoCcorreoContratante = true;
        this.contratoCcorreoContratante = contratoCcorreoContratante;
    }

   /**
    * Returns the value of the <code>modifiedContratoCcorreoContratante</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCcorreoContratante</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCcorreoContratante() {
        return modifiedContratoCcorreoContratante;
    }

   /**
    * Sets the value of the <code>modifiedContratoCcorreoContratante</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCcorreoContratante</code>.
    */
    public void setModifiedContratoCcorreoContratante(boolean modified) {
        this.modifiedContratoCcorreoContratante = modified;
    }

   /**
    * Returns the value of the <code>contratoCnumTelContratante</code> attribute.<br>
    * Model Attribute: <code>contratoCnumTelContratante</code>. Variable String Size=15<br>
    * Comments: <br>
    * @return The value of the <code>contratoCnumTelContratante</code> attribute.
    */

    public String getContratoCnumTelContratante()  {
    	String value;
        value =  contratoCnumTelContratante;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCnumTelContratante</code> attribute.<br>
    * Model Attribute: <code>contratoCnumTelContratante</code>. Variable String Size=15<br>
    * Comments: <br>
    * @param contratoCnumTelContratante The new value of the <code>contratoCnumTelContratante</code> attribute.
    */
    public void setContratoCnumTelContratante (String contratoCnumTelContratante) {
        modifiedContratoCnumTelContratante = true;
        this.contratoCnumTelContratante = contratoCnumTelContratante;
    }

   /**
    * Returns the value of the <code>modifiedContratoCnumTelContratante</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCnumTelContratante</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCnumTelContratante() {
        return modifiedContratoCnumTelContratante;
    }

   /**
    * Sets the value of the <code>modifiedContratoCnumTelContratante</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCnumTelContratante</code>.
    */
    public void setModifiedContratoCnumTelContratante(boolean modified) {
        this.modifiedContratoCnumTelContratante = modified;
    }

   /**
    * Returns the value of the <code>contratoCnumCelContratante</code> attribute.<br>
    * Model Attribute: <code>contratoCnumCelContratante</code>. Variable String Size=15<br>
    * Comments: <br>
    * @return The value of the <code>contratoCnumCelContratante</code> attribute.
    */

    public String getContratoCnumCelContratante()  {
    	String value;
        value =  contratoCnumCelContratante;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCnumCelContratante</code> attribute.<br>
    * Model Attribute: <code>contratoCnumCelContratante</code>. Variable String Size=15<br>
    * Comments: <br>
    * @param contratoCnumCelContratante The new value of the <code>contratoCnumCelContratante</code> attribute.
    */
    public void setContratoCnumCelContratante (String contratoCnumCelContratante) {
        modifiedContratoCnumCelContratante = true;
        this.contratoCnumCelContratante = contratoCnumCelContratante;
    }

   /**
    * Returns the value of the <code>modifiedContratoCnumCelContratante</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCnumCelContratante</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCnumCelContratante() {
        return modifiedContratoCnumCelContratante;
    }

   /**
    * Sets the value of the <code>modifiedContratoCnumCelContratante</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCnumCelContratante</code>.
    */
    public void setModifiedContratoCnumCelContratante(boolean modified) {
        this.modifiedContratoCnumCelContratante = modified;
    }

   /**
    * Returns the value of the <code>contratoCexentoIVA</code> attribute.<br>
    * Model Attribute: <code>contratoCexentoIVA</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>contratoCexentoIVA</code> attribute.
    */

    public String getContratoCexentoIVA()  {
    	String value;
        value =  contratoCexentoIVA;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCexentoIVA</code> attribute.<br>
    * Model Attribute: <code>contratoCexentoIVA</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param contratoCexentoIVA The new value of the <code>contratoCexentoIVA</code> attribute.
    */
    public void setContratoCexentoIVA (String contratoCexentoIVA) {
        modifiedContratoCexentoIVA = true;
        this.contratoCexentoIVA = contratoCexentoIVA;
    }

   /**
    * Returns the value of the <code>modifiedContratoCexentoIVA</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCexentoIVA</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCexentoIVA() {
        return modifiedContratoCexentoIVA;
    }

   /**
    * Sets the value of the <code>modifiedContratoCexentoIVA</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCexentoIVA</code>.
    */
    public void setModifiedContratoCexentoIVA(boolean modified) {
        this.modifiedContratoCexentoIVA = modified;
    }

   /**
    * Returns the value of the <code>contratoCContratoConFirma</code> attribute.<br>
    * Model Attribute: <code>contratoCContratoConFirma</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>contratoCContratoConFirma</code> attribute.
    */

    public Boolean getContratoCContratoConFirma()  {
    	Boolean value;
        value =  contratoCContratoConFirma;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCContratoConFirma</code> attribute.<br>
    * Model Attribute: <code>contratoCContratoConFirma</code>. Variable Bool<br>
    * Comments: <br>
    * @param contratoCContratoConFirma The new value of the <code>contratoCContratoConFirma</code> attribute.
    */
    public void setContratoCContratoConFirma (Boolean contratoCContratoConFirma) {
        modifiedContratoCContratoConFirma = true;
        this.contratoCContratoConFirma = contratoCContratoConFirma;
    }

   /**
    * Returns the value of the <code>modifiedContratoCContratoConFirma</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCContratoConFirma</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCContratoConFirma() {
        return modifiedContratoCContratoConFirma;
    }

   /**
    * Sets the value of the <code>modifiedContratoCContratoConFirma</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCContratoConFirma</code>.
    */
    public void setModifiedContratoCContratoConFirma(boolean modified) {
        this.modifiedContratoCContratoConFirma = modified;
    }

   /**
    * Returns the value of the <code>contratoCvalorCuotaPeriodo</code> attribute.<br>
    * Model Attribute: <code>contratoCvalorCuotaPeriodo</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>contratoCvalorCuotaPeriodo</code> attribute.
    */

    public Double getContratoCvalorCuotaPeriodo()  {
    	Double value;
        value =  contratoCvalorCuotaPeriodo;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCvalorCuotaPeriodo</code> attribute.<br>
    * Model Attribute: <code>contratoCvalorCuotaPeriodo</code>. Variable Real<br>
    * Comments: <br>
    * @param contratoCvalorCuotaPeriodo The new value of the <code>contratoCvalorCuotaPeriodo</code> attribute.
    */
    public void setContratoCvalorCuotaPeriodo (Double contratoCvalorCuotaPeriodo) {
        modifiedContratoCvalorCuotaPeriodo = true;
        this.contratoCvalorCuotaPeriodo = contratoCvalorCuotaPeriodo;
    }

   /**
    * Returns the value of the <code>modifiedContratoCvalorCuotaPeriodo</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCvalorCuotaPeriodo</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCvalorCuotaPeriodo() {
        return modifiedContratoCvalorCuotaPeriodo;
    }

   /**
    * Sets the value of the <code>modifiedContratoCvalorCuotaPeriodo</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCvalorCuotaPeriodo</code>.
    */
    public void setModifiedContratoCvalorCuotaPeriodo(boolean modified) {
        this.modifiedContratoCvalorCuotaPeriodo = modified;
    }

   /**
    * Returns the value of the <code>contratoCdescuentoComercial</code> attribute.<br>
    * Model Attribute: <code>contratoCdescuentoComercial</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>contratoCdescuentoComercial</code> attribute.
    */

    public Double getContratoCdescuentoComercial()  {
    	Double value;
        value =  contratoCdescuentoComercial;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCdescuentoComercial</code> attribute.<br>
    * Model Attribute: <code>contratoCdescuentoComercial</code>. Variable Real<br>
    * Comments: <br>
    * @param contratoCdescuentoComercial The new value of the <code>contratoCdescuentoComercial</code> attribute.
    */
    public void setContratoCdescuentoComercial (Double contratoCdescuentoComercial) {
        modifiedContratoCdescuentoComercial = true;
        this.contratoCdescuentoComercial = contratoCdescuentoComercial;
    }

   /**
    * Returns the value of the <code>modifiedContratoCdescuentoComercial</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCdescuentoComercial</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCdescuentoComercial() {
        return modifiedContratoCdescuentoComercial;
    }

   /**
    * Sets the value of the <code>modifiedContratoCdescuentoComercial</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCdescuentoComercial</code>.
    */
    public void setModifiedContratoCdescuentoComercial(boolean modified) {
        this.modifiedContratoCdescuentoComercial = modified;
    }

   /**
    * Returns the value of the <code>contratoCIVA</code> attribute.<br>
    * Model Attribute: <code>contratoCIVA</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>contratoCIVA</code> attribute.
    */

    public Double getContratoCIVA()  {
    	Double value;
        value =  contratoCIVA;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCIVA</code> attribute.<br>
    * Model Attribute: <code>contratoCIVA</code>. Variable Real<br>
    * Comments: <br>
    * @param contratoCIVA The new value of the <code>contratoCIVA</code> attribute.
    */
    public void setContratoCIVA (Double contratoCIVA) {
        modifiedContratoCIVA = true;
        this.contratoCIVA = contratoCIVA;
    }

   /**
    * Returns the value of the <code>modifiedContratoCIVA</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCIVA</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCIVA() {
        return modifiedContratoCIVA;
    }

   /**
    * Sets the value of the <code>modifiedContratoCIVA</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCIVA</code>.
    */
    public void setModifiedContratoCIVA(boolean modified) {
        this.modifiedContratoCIVA = modified;
    }

   /**
    * Returns the value of the <code>contratoCdescuentoFinanciero</code> attribute.<br>
    * Model Attribute: <code>contratoCdescuentoFinanciero</code>. Variable Real<br>
    * Comments: <br>
    * @return The value of the <code>contratoCdescuentoFinanciero</code> attribute.
    */

    public Double getContratoCdescuentoFinanciero()  {
    	Double value;
        value =  contratoCdescuentoFinanciero;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCdescuentoFinanciero</code> attribute.<br>
    * Model Attribute: <code>contratoCdescuentoFinanciero</code>. Variable Real<br>
    * Comments: <br>
    * @param contratoCdescuentoFinanciero The new value of the <code>contratoCdescuentoFinanciero</code> attribute.
    */
    public void setContratoCdescuentoFinanciero (Double contratoCdescuentoFinanciero) {
        modifiedContratoCdescuentoFinanciero = true;
        this.contratoCdescuentoFinanciero = contratoCdescuentoFinanciero;
    }

   /**
    * Returns the value of the <code>modifiedContratoCdescuentoFinanciero</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCdescuentoFinanciero</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCdescuentoFinanciero() {
        return modifiedContratoCdescuentoFinanciero;
    }

   /**
    * Sets the value of the <code>modifiedContratoCdescuentoFinanciero</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCdescuentoFinanciero</code>.
    */
    public void setModifiedContratoCdescuentoFinanciero(boolean modified) {
        this.modifiedContratoCdescuentoFinanciero = modified;
    }

   /**
    * Returns the value of the <code>contratoCdrvTipoContrato</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvTipoContrato</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>contratoCdrvTipoContrato</code> attribute.
    */

    public String getContratoCdrvTipoContrato()  {
    	String value;
        try {
            value = contratoCdrvTipoContratoDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvTipoContrato");
        }
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>contratoCdrvNumPagos</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvNumPagos</code>. Variable Nat<br>
    * Comments: Periodicidad Mensual = 12, Semestral = 6...<br>
    * @return The value of the <code>contratoCdrvNumPagos</code> attribute.
    */

    public Long getContratoCdrvNumPagos()  {
    	Long value;
        try {
            value = contratoCdrvNumPagosDerivations();
        } catch (Exception e) {
            value = Long.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvNumPagos");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCdrvValorInicialContrato</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvValorInicialContrato</code>. Variable Real<br>
    * Comments: Es la suma del concepto VALOR BRUTO que viene en la lista de conceptos por la periodicidad de pago.
Debe multiplicarse porque bh siempre nos va a devolver el valor por cada mes y este dato indica cuanto vale el contrato por todo el año (Mail 12/4/2017)<br>
    * @return The value of the <code>contratoCdrvValorInicialContrato</code> attribute.
    */

    public Double getContratoCdrvValorInicialContrato()  {
    	Double value;
        try {
            value = contratoCdrvValorInicialContratoDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvValorInicialContrato");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCdrvValorCuotaAfiliacion</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvValorCuotaAfiliacion</code>. Variable Real<br>
    * Comments: (es la suma del concepto VALOR BRUTO que viene en la lista de conceptos) dividido en la periodicidad de pago<br>
    * @return The value of the <code>contratoCdrvValorCuotaAfiliacion</code> attribute.
    */

    public Double getContratoCdrvValorCuotaAfiliacion()  {
    	Double value;
        try {
            value = contratoCdrvValorCuotaAfiliacionDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvValorCuotaAfiliacion");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCdrvValorInicialContratoBBGes</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvValorInicialContratoBBGes</code>. Variable Real<br>
    * Comments: (es la suma del concepto VALOR BRUTO que viene en la lista de conceptos para los usuarios de la solicitud con tipo de identificación MS) por la periodicidad de pago para el usuario <br>
    * @return The value of the <code>contratoCdrvValorInicialContratoBBGes</code> attribute.
    */

    public Double getContratoCdrvValorInicialContratoBBGes()  {
    	Double value;
        try {
            value = contratoCdrvValorInicialContratoBBGesDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvValorInicialContratoBBGes");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCcontratoNotificado</code> attribute.<br>
    * Model Attribute: <code>contratoCcontratoNotificado</code>. Variable Bool<br>
    * Comments: Esta marca se pondrá a TRUE cuando sea el CORE el que nos notifica este contrato a traves de NotificadorSolicitudesMP<br>
    * @return The value of the <code>contratoCcontratoNotificado</code> attribute.
    */

    public Boolean getContratoCcontratoNotificado()  {
    	Boolean value;
        value =  contratoCcontratoNotificado;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCcontratoNotificado</code> attribute.<br>
    * Model Attribute: <code>contratoCcontratoNotificado</code>. Variable Bool<br>
    * Comments: Esta marca se pondrá a TRUE cuando sea el CORE el que nos notifica este contrato a traves de NotificadorSolicitudesMP<br>
    * @param contratoCcontratoNotificado The new value of the <code>contratoCcontratoNotificado</code> attribute.
    */
    public void setContratoCcontratoNotificado (Boolean contratoCcontratoNotificado) {
        modifiedContratoCcontratoNotificado = true;
        this.contratoCcontratoNotificado = contratoCcontratoNotificado;
    }

   /**
    * Returns the value of the <code>modifiedContratoCcontratoNotificado</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCcontratoNotificado</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCcontratoNotificado() {
        return modifiedContratoCcontratoNotificado;
    }

   /**
    * Sets the value of the <code>modifiedContratoCcontratoNotificado</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCcontratoNotificado</code>.
    */
    public void setModifiedContratoCcontratoNotificado(boolean modified) {
        this.modifiedContratoCcontratoNotificado = modified;
    }

   /**
    * Returns the value of the <code>contratoCUltimaActualizacion</code> attribute.<br>
    * Model Attribute: <code>contratoCUltimaActualizacion</code>. Variable DateTime<br>
    * Comments: Timestamp de la última actualización de la instancia, para evitar estar trayéndola del CORE a cada poco.<br>
    * @return The value of the <code>contratoCUltimaActualizacion</code> attribute.
    */

    public Timestamp getContratoCUltimaActualizacion()  {
    	Timestamp value;
        value =  contratoCUltimaActualizacion;
        return value;
    }

   /**
    * Sets the value of the <code>contratoCUltimaActualizacion</code> attribute.<br>
    * Model Attribute: <code>contratoCUltimaActualizacion</code>. Variable DateTime<br>
    * Comments: Timestamp de la última actualización de la instancia, para evitar estar trayéndola del CORE a cada poco.<br>
    * @param contratoCUltimaActualizacion The new value of the <code>contratoCUltimaActualizacion</code> attribute.
    */
    public void setContratoCUltimaActualizacion (Timestamp contratoCUltimaActualizacion) {
        modifiedContratoCUltimaActualizacion = true;
        this.contratoCUltimaActualizacion = contratoCUltimaActualizacion;
    }

   /**
    * Returns the value of the <code>modifiedContratoCUltimaActualizacion</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCUltimaActualizacion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCUltimaActualizacion() {
        return modifiedContratoCUltimaActualizacion;
    }

   /**
    * Sets the value of the <code>modifiedContratoCUltimaActualizacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCUltimaActualizacion</code>.
    */
    public void setModifiedContratoCUltimaActualizacion(boolean modified) {
        this.modifiedContratoCUltimaActualizacion = modified;
    }

   /**
    * Returns the value of the <code>contratoCdrvValorCuotaBruta</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvValorCuotaBruta</code>. Variable Real<br>
    * Comments: Es la suma del concepto Valor Bruto que viene en la lista de conceptos por la periodicidad de pago.
Modificado el 26/8/2016 a petición de JC Quinche<br>
    * @return The value of the <code>contratoCdrvValorCuotaBruta</code> attribute.
    */

    public Double getContratoCdrvValorCuotaBruta()  {
    	Double value;
        try {
            value = contratoCdrvValorCuotaBrutaDerivations();
        } catch (Exception e) {
            value = Double.valueOf(0);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvValorCuotaBruta");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCCodTarifa</code> attribute.<br>
    * Model Attribute: <code>contratoCCodTarifa</code>. Constant String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>contratoCCodTarifa</code> attribute.
    */

    public String getContratoCCodTarifa()  {
    	String value;
        value =  contratoCCodTarifa;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>contratoCCodTarifa</code> attribute.<br>
    * Model Attribute: <code>contratoCCodTarifa</code>. Constant String Size=50<br>
    * Comments: <br>
    * @param contratoCCodTarifa The new value of the <code>contratoCCodTarifa</code> attribute.
    */
    public void setContratoCCodTarifa (String contratoCCodTarifa) {
        modifiedContratoCCodTarifa = true;
        this.contratoCCodTarifa = contratoCCodTarifa;
    }

   /**
    * Returns the value of the <code>modifiedContratoCCodTarifa</code> class property.<br>
    *
    * @return The value of the <code>modifiedContratoCCodTarifa</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedContratoCCodTarifa() {
        return modifiedContratoCCodTarifa;
    }

   /**
    * Sets the value of the <code>modifiedContratoCCodTarifa</code> class property.<br>
    * @param modified The new value of the <code>modifiedContratoCCodTarifa</code>.
    */
    public void setModifiedContratoCCodTarifa(boolean modified) {
        this.modifiedContratoCCodTarifa = modified;
    }

   /**
    * Returns the value of the <code>contratoCdrvMostrarPreEnRepAnexo</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvMostrarPreEnRepAnexo</code>. Variable Bool<br>
    * Comments: Indica si en el report de anexos de inclusión se deben mostrar las preexistencias. Se utiliza solo para el report. La información de si mostrarlo o no, se saca del dominio. GdC4<br>
    * @return The value of the <code>contratoCdrvMostrarPreEnRepAnexo</code> attribute.
    */

    public Boolean getContratoCdrvMostrarPreEnRepAnexo()  {
    	Boolean value;
        try {
            value = contratoCdrvMostrarPreEnRepAnexoDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvMostrarPreEnRepAnexo");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCdrvMostrarPreEnRepCon</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvMostrarPreEnRepCon</code>. Variable Bool<br>
    * Comments: Indica si en el report de contrato se deben mostrar las preexistencias. Se utiliza solo para el report. La información de si mostrarlo o no, se saca del dominio. GdC4<br>
    * @return The value of the <code>contratoCdrvMostrarPreEnRepCon</code> attribute.
    */

    public Boolean getContratoCdrvMostrarPreEnRepCon()  {
    	Boolean value;
        try {
            value = contratoCdrvMostrarPreEnRepConDerivations();
        } catch (Exception e) {
            value = false;
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvMostrarPreEnRepCon");
        }
        return value;
    }

   /**
    * Returns the value of the <code>contratoCdrvNumFamilia</code> attribute.<br>
    * Model Attribute: <code>contratoCdrvNumFamilia</code>. Variable String Size=20<br>
    * Comments: Devuelve el Nº de familia de la familia del contrato<br>
    * @return The value of the <code>contratoCdrvNumFamilia</code> attribute.
    */

    public String getContratoCdrvNumFamilia()  {
    	String value;
        try {
            value = contratoCdrvNumFamiliaDerivations();
        } catch (Exception e) {
            value = "";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ContratoC, Attribute: contratoCdrvNumFamilia");
        }
        return (value == null ? null : value.trim());
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitud 0:M  ------ 0:1  ContratoC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     */
    @JsonIgnore
    public Collection <Solicitud> getSolicitud() {
        return solicitud;
    }

   /**
    * Adds an instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
    * @param solicitud The instance to add to the <code>Solicitud</code> role.
    */
    public void add2Solicitud(Solicitud solicitud) {
        this.getSolicitud().add(solicitud);
    }
    /**
     * Sets instances of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * @param solicitud The new value for the <code>Solicitud</code> role.
     */
    public void setSolicitud(Collection < Solicitud > solicitud) {
        this.solicitud = solicitud;
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitud</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitud</code> has been modified.
    */
    public boolean isModifiedSolicitud(){
        return modifiedSolicitud;
    }

    /**
     * Returns the instance of <code>PersonaC</code> related through the <code>PersonaCContratante</code> role.
     * Model Relationship:
     * <code>[PersonaC] PersonaCContratante 0:1  ------ 0:1  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>PersonaC</code> related through the <code>PersonaCContratante</code> role.
     */
    @JsonIgnore
    public PersonaC getPersonaCContratante() {
        return personaCContratante;
    }

   /**
    * Adds an instance of <code>PersonaC</code> related through the <code>PersonaCContratante</code> role.
    * @param personaCContratante The instance to add to the <code>PersonaCContratante</code> role.
    */
    public void add2PersonaCContratante(PersonaC personaCContratante) {
        this.personaCContratante = (personaCContratante == null  || personaCContratante.isNull() ? null : personaCContratante);
    }

   /**
    * This method gets the attribute value <code>modifiedPersonaCContratante</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPersonaCContratante</code> has been modified.
    */
    public boolean isModifiedPersonaCContratante(){
        return modifiedPersonaCContratante;
    }

    /**
     * Returns the instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     * Model Relationship:
     * <code>[BeneficiarioC] BeneficiariosC 0:M  ------ 1:1  ContratoC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     */
    @JsonIgnore
    public Collection <BeneficiarioC> getBeneficiariosC() {
        return beneficiariosC;
    }

   /**
    * Adds an instance of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
    * @param beneficiariosC The instance to add to the <code>BeneficiariosC</code> role.
    */
    public void add2BeneficiariosC(BeneficiarioC beneficiariosC) {
        this.getBeneficiariosC().add(beneficiariosC);
    }
    /**
     * Sets instances of <code>BeneficiarioC</code> related through the <code>BeneficiariosC</code> role.
     * @param beneficiariosC The new value for the <code>BeneficiariosC</code> role.
     */
    public void setBeneficiariosC(Collection < BeneficiarioC > beneficiariosC) {
        this.beneficiariosC = beneficiariosC;
    }

   /**
    * This method gets the attribute value <code>modifiedBeneficiariosC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedBeneficiariosC</code> has been modified.
    */
    public boolean isModifiedBeneficiariosC(){
        return modifiedBeneficiariosC;
    }

    /**
     * Returns the instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
     * Model Relationship:
     * <code>[FamiliaC] FamiliasC 0:M  ------ 1:1  ContratoC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
     */
    @JsonIgnore
    public Collection <FamiliaC> getFamiliasC() {
        return familiasC;
    }

   /**
    * Adds an instance of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
    * @param familiasC The instance to add to the <code>FamiliasC</code> role.
    */
    public void add2FamiliasC(FamiliaC familiasC) {
        this.getFamiliasC().add(familiasC);
    }
    /**
     * Sets instances of <code>FamiliaC</code> related through the <code>FamiliasC</code> role.
     * @param familiasC The new value for the <code>FamiliasC</code> role.
     */
    public void setFamiliasC(Collection < FamiliaC > familiasC) {
        this.familiasC = familiasC;
    }

   /**
    * This method gets the attribute value <code>modifiedFamiliasC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFamiliasC</code> has been modified.
    */
    public boolean isModifiedFamiliasC(){
        return modifiedFamiliasC;
    }

    /**
     * Returns the instance of <code>Periodicidad</code> related through the <code>PeriodicidadC</code> role.
     * Model Relationship:
     * <code>[Periodicidad] PeriodicidadC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Periodicidad</code> related through the <code>PeriodicidadC</code> role.
     */
    @JsonIgnore
    public Periodicidad getPeriodicidadC() {
        return periodicidadC;
    }

   /**
    * Adds an instance of <code>Periodicidad</code> related through the <code>PeriodicidadC</code> role.
    * @param periodicidadC The instance to add to the <code>PeriodicidadC</code> role.
    */
    public void add2PeriodicidadC(Periodicidad periodicidadC) {
        if (periodicidadC == null || periodicidadC.isNull()) {
            this.modifiedPeriodicidadC = true;
            this.periodicidadCodigo = null;
        } else {
            this.periodicidadCodigo = periodicidadC.getPeriodicidadCodigo();
        }
        this.periodicidadC = (periodicidadC == null  || periodicidadC.isNull() ? null : periodicidadC);
    }

   /**
    * This method gets the attribute value <code>modifiedPeriodicidadC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPeriodicidadC</code> has been modified.
    */
    public boolean isModifiedPeriodicidadC(){
        return modifiedPeriodicidadC;
    }

    /**
     * Returns the instance of <code>EstadoContrato</code> related through the <code>EstadoContratoC</code> role.
     * Model Relationship:
     * <code>[EstadoContrato] EstadoContratoC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>EstadoContrato</code> related through the <code>EstadoContratoC</code> role.
     */
    @JsonIgnore
    public EstadoContrato getEstadoContratoC() {
        return estadoContratoC;
    }

   /**
    * Adds an instance of <code>EstadoContrato</code> related through the <code>EstadoContratoC</code> role.
    * @param estadoContratoC The instance to add to the <code>EstadoContratoC</code> role.
    */
    public void add2EstadoContratoC(EstadoContrato estadoContratoC) {
        if (estadoContratoC == null || estadoContratoC.isNull()) {
            this.modifiedEstadoContratoC = true;
            this.estadoContratoEstadoContratoCCodigo = null;
        } else {
            this.estadoContratoEstadoContratoCCodigo = estadoContratoC.getEstadoContratoCodigo();
        }
        this.estadoContratoC = (estadoContratoC == null  || estadoContratoC.isNull() ? null : estadoContratoC);
    }

   /**
    * This method gets the attribute value <code>modifiedEstadoContratoC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedEstadoContratoC</code> has been modified.
    */
    public boolean isModifiedEstadoContratoC(){
        return modifiedEstadoContratoC;
    }

    /**
     * Returns the instance of <code>Productos</code> related through the <code>ProductoC</code> role.
     * Model Relationship:
     * <code>[Productos] ProductoC 1:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Productos</code> related through the <code>ProductoC</code> role.
     */
    @JsonIgnore
    public Productos getProductoC() {
        try {
            if (productoC != null && productoC.isNull()) {
                productoC = null;
            }
        } catch (Exception ex) {
            productoC = null;
        }
        if (productoC == null) {
            if (productosProducto != null) {
                productoC = productosRepository.findById(productosProducto).orElse(null);
            } else {
                productoC = null;
            }
        }
        return (productoC == null ? new Productos(null) : productoC);
    }

   /**
    * Adds an instance of <code>Productos</code> related through the <code>ProductoC</code> role.
    * @param productoC The instance to add to the <code>ProductoC</code> role.
    */
    public void add2ProductoC(Productos productoC) {
        if (productoC == null || productoC.isNull()) {
            this.modifiedProductoC = true;
            this.productosProducto = null;
        } else {
            this.productosProducto = productoC.getProductosProducto();
        }
        this.productoC = (productoC == null  || productoC.isNull() ? null : productoC);
    }

   /**
    * This method gets the attribute value <code>modifiedProductoC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedProductoC</code> has been modified.
    */
    public boolean isModifiedProductoC(){
        return modifiedProductoC;
    }

    /**
     * Returns the instance of <code>Planes</code> related through the <code>PlanC</code> role.
     * Model Relationship:
     * <code>[Planes] PlanC 1:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Planes</code> related through the <code>PlanC</code> role.
     */
    @JsonIgnore
    public Planes getPlanC() {
        try {
            if (planC != null && planC.isNull()) {
                planC = null;
            }
        } catch (Exception ex) {
            planC = null;
        }
        if (planC == null) {
            if (planesPlan != null) {
                planC = planesRepository.findById(planesPlan).orElse(null);
            } else {
                planC = null;
            }
        }
        return (planC == null ? new Planes(null) : planC);
    }

   /**
    * Adds an instance of <code>Planes</code> related through the <code>PlanC</code> role.
    * @param planC The instance to add to the <code>PlanC</code> role.
    */
    public void add2PlanC(Planes planC) {
        if (planC == null || planC.isNull()) {
            this.modifiedPlanC = true;
            this.planesPlan = null;
        } else {
            this.planesPlan = planC.getPlanesPlan();
        }
        this.planC = (planC == null  || planC.isNull() ? null : planC);
    }

   /**
    * This method gets the attribute value <code>modifiedPlanC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPlanC</code> has been modified.
    */
    public boolean isModifiedPlanC(){
        return modifiedPlanC;
    }

    /**
     * Returns the instance of <code>Tarifa</code> related through the <code>TarifaC</code> role.
     * Model Relationship:
     * <code>[Tarifa] TarifaC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Tarifa</code> related through the <code>TarifaC</code> role.
     */
    @JsonIgnore
    public Tarifa getTarifaC() {
        return tarifaC;
    }

   /**
    * Adds an instance of <code>Tarifa</code> related through the <code>TarifaC</code> role.
    * @param tarifaC The instance to add to the <code>TarifaC</code> role.
    */
    public void add2TarifaC(Tarifa tarifaC) {
        if (tarifaC == null || tarifaC.isNull()) {
            this.modifiedTarifaC = true;
            this.tarifaTarifaCId = null;
        } else {
            this.tarifaTarifaCId = tarifaC.getTarifaId();
        }
        this.tarifaC = (tarifaC == null  || tarifaC.isNull() ? null : tarifaC);
    }

   /**
    * This method gets the attribute value <code>modifiedTarifaC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTarifaC</code> has been modified.
    */
    public boolean isModifiedTarifaC(){
        return modifiedTarifaC;
    }

    /**
     * Returns the instance of <code>GrupoAsociado</code> related through the <code>GrupoAsociadoC</code> role.
     * Model Relationship:
     * <code>[GrupoAsociado] GrupoAsociadoC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>GrupoAsociado</code> related through the <code>GrupoAsociadoC</code> role.
     */
    @JsonIgnore
    public GrupoAsociado getGrupoAsociadoC() {
        return grupoAsociadoC;
    }

   /**
    * Adds an instance of <code>GrupoAsociado</code> related through the <code>GrupoAsociadoC</code> role.
    * @param grupoAsociadoC The instance to add to the <code>GrupoAsociadoC</code> role.
    */
    public void add2GrupoAsociadoC(GrupoAsociado grupoAsociadoC) {
        if (grupoAsociadoC == null || grupoAsociadoC.isNull()) {
            this.modifiedGrupoAsociadoC = true;
            this.grupoAsociadoGrupoAsociadoCCodigo = null;
        } else {
            this.grupoAsociadoGrupoAsociadoCCodigo = grupoAsociadoC.getGrupoAsociadoCodigo();
        }
        this.grupoAsociadoC = (grupoAsociadoC == null  || grupoAsociadoC.isNull() ? null : grupoAsociadoC);
    }

   /**
    * This method gets the attribute value <code>modifiedGrupoAsociadoC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedGrupoAsociadoC</code> has been modified.
    */
    public boolean isModifiedGrupoAsociadoC(){
        return modifiedGrupoAsociadoC;
    }

    /**
     * Returns the instance of <code>Municipio</code> related through the <code>MunicipioC</code> role.
     * Model Relationship:
     * <code>[Municipio] MunicipioC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Municipio</code> related through the <code>MunicipioC</code> role.
     */
    @JsonIgnore
    public Municipio getMunicipioC() {
        return municipioC;
    }

   /**
    * Adds an instance of <code>Municipio</code> related through the <code>MunicipioC</code> role.
    * @param municipioC The instance to add to the <code>MunicipioC</code> role.
    */
    public void add2MunicipioC(Municipio municipioC) {
        if (municipioC == null || municipioC.isNull()) {
            this.modifiedMunicipioC = true;
            this.municipioMunicipioCCodigo = null;
        } else {
            this.municipioMunicipioCCodigo = municipioC.getMunicipioCodigo();
        }
        this.municipioC = (municipioC == null  || municipioC.isNull() ? null : municipioC);
    }

   /**
    * This method gets the attribute value <code>modifiedMunicipioC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedMunicipioC</code> has been modified.
    */
    public boolean isModifiedMunicipioC(){
        return modifiedMunicipioC;
    }

    /**
     * Returns the instance of <code>Sucursal</code> related through the <code>SucursalC</code> role.
     * Model Relationship:
     * <code>[Sucursal] SucursalC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Sucursal</code> related through the <code>SucursalC</code> role.
     */
    @JsonIgnore
    public Sucursal getSucursalC() {
        try {
            if (sucursalC != null && sucursalC.isNull()) {
                sucursalC = null;
            }
        } catch (Exception ex) {
            sucursalC = null;
        }
        if (sucursalC == null) {
            if (sucursalSucursalCCodigo != null) {
                sucursalC = sucursalRepository.findById(sucursalSucursalCCodigo).orElse(null);
            } else {
                sucursalC = null;
            }
        }
        return (sucursalC == null ? new Sucursal(null) : sucursalC);
    }

   /**
    * Adds an instance of <code>Sucursal</code> related through the <code>SucursalC</code> role.
    * @param sucursalC The instance to add to the <code>SucursalC</code> role.
    */
    public void add2SucursalC(Sucursal sucursalC) {
        if (sucursalC == null || sucursalC.isNull()) {
            this.modifiedSucursalC = true;
            this.sucursalSucursalCCodigo = null;
        } else {
            this.sucursalSucursalCCodigo = sucursalC.getSucursalCodigo();
        }
        this.sucursalC = (sucursalC == null  || sucursalC.isNull() ? null : sucursalC);
    }

   /**
    * This method gets the attribute value <code>modifiedSucursalC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSucursalC</code> has been modified.
    */
    public boolean isModifiedSucursalC(){
        return modifiedSucursalC;
    }

    /**
     * Returns the instance of <code>Asesor</code> related through the <code>AsesorC</code> role.
     * Model Relationship:
     * <code>[Asesor] AsesorC 0:1  ------ 0:M  ContratosC [ContratoC]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Asesor</code> related through the <code>AsesorC</code> role.
     */
    @JsonIgnore
    public Asesor getAsesorC() {
        try {
            if (asesorC != null && asesorC.isNull()) {
                asesorC = null;
            }
        } catch (Exception ex) {
            asesorC = null;
        }
        if (asesorC == null) {
            if (funcionarioAsesorCId != null) {
                asesorC = asesorRepository.findById(funcionarioAsesorCId).orElse(null);
            } else {
                asesorC = null;
            }
        }
        return (asesorC == null ? new Asesor(null) : asesorC);
    }

   /**
    * Adds an instance of <code>Asesor</code> related through the <code>AsesorC</code> role.
    * @param asesorC The instance to add to the <code>AsesorC</code> role.
    */
    public void add2AsesorC(Asesor asesorC) {
        if (asesorC == null || asesorC.isNull()) {
            this.modifiedAsesorC = true;
            this.funcionarioAsesorCId = null;
        } else {
            this.funcionarioAsesorCId = asesorC.getFuncionarioId();
        }
        this.asesorC = (asesorC == null  || asesorC.isNull() ? null : asesorC);
    }

   /**
    * This method gets the attribute value <code>modifiedAsesorC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAsesorC</code> has been modified.
    */
    public boolean isModifiedAsesorC(){
        return modifiedAsesorC;
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
     * Computes the value of the <code>contratoCdrvTipoContrato</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvTipoContrato</code> derived attribute.
     */
    public String contratoCdrvTipoContratoDerivations() {

        contratoCdrvTipoContrato = null;

        contratoCdrvTipoContratoDerivationsConditional1();
        contratoCdrvTipoContratoDerivationsDefault();
        return contratoCdrvTipoContrato;
    }

    private void contratoCdrvTipoContratoDerivationsConditional1() {
        if (contratoCdrvTipoContrato != null) return;
        // CONDITION: TipoContrato = 3
        // EFFECT   : \"COLECTIVO\"
        boolean contratoCdrvTipoContratoCond = Long.valueOf(this.getContratoCTipoContrato()).equals(Long.valueOf(3));
        if (contratoCdrvTipoContratoCond) {
            contratoCdrvTipoContrato = "COLECTIVO";
        }
    }

    private void contratoCdrvTipoContratoDerivationsDefault() {
        if (contratoCdrvTipoContrato != null) return;
        // Default derivation
        // EFFECT   : \"FAMILIAR\"
        contratoCdrvTipoContrato = "FAMILIAR";
    }

    /**
     * Computes the value of the <code>contratoCdrvNumPagos</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvNumPagos</code> derived attribute.
     */
    public Long contratoCdrvNumPagosDerivations() {

        contratoCdrvNumPagos = null;

        contratoCdrvNumPagosDerivationsConditional1();
        contratoCdrvNumPagosDerivationsConditional2();
        contratoCdrvNumPagosDerivationsConditional3();
        contratoCdrvNumPagosDerivationsConditional4();
        contratoCdrvNumPagosDerivationsConditional5();
        contratoCdrvNumPagosDerivationsDefault();
        return contratoCdrvNumPagos;
    }

    private void contratoCdrvNumPagosDerivationsConditional1() {
        if (contratoCdrvNumPagos != null) return;
        // CONDITION: PeriodicidadC.Descripcion LIKE \"%BI%\"
        // EFFECT   : 6
        boolean contratoCdrvNumPagosCond = Utilities.like(this.getPeriodicidadC().getPeriodicidadDescripcion(), "%BI%");
        if (contratoCdrvNumPagosCond) {
            contratoCdrvNumPagos = Long.valueOf(6);
        }
    }

    private void contratoCdrvNumPagosDerivationsConditional2() {
        if (contratoCdrvNumPagos != null) return;
        // CONDITION: PeriodicidadC.Descripcion LIKE \"%MENSUAL%\"
        // EFFECT   : 12
        boolean contratoCdrvNumPagosCond = Utilities.like(this.getPeriodicidadC().getPeriodicidadDescripcion(), "%MENSUAL%");
        if (contratoCdrvNumPagosCond) {
            contratoCdrvNumPagos = Long.valueOf(12);
        }
    }

    private void contratoCdrvNumPagosDerivationsConditional3() {
        if (contratoCdrvNumPagos != null) return;
        // CONDITION: PeriodicidadC.Descripcion LIKE \"%CU%\"
        // EFFECT   : 3
        boolean contratoCdrvNumPagosCond = Utilities.like(this.getPeriodicidadC().getPeriodicidadDescripcion(), "%CU%");
        if (contratoCdrvNumPagosCond) {
            contratoCdrvNumPagos = Long.valueOf(3);
        }
    }

    private void contratoCdrvNumPagosDerivationsConditional4() {
        if (contratoCdrvNumPagos != null) return;
        // CONDITION: PeriodicidadC.Descripcion LIKE \"%TRI%\"
        // EFFECT   : 4
        boolean contratoCdrvNumPagosCond = Utilities.like(this.getPeriodicidadC().getPeriodicidadDescripcion(), "%TRI%");
        if (contratoCdrvNumPagosCond) {
            contratoCdrvNumPagos = Long.valueOf(4);
        }
    }

    private void contratoCdrvNumPagosDerivationsConditional5() {
        if (contratoCdrvNumPagos != null) return;
        // CONDITION: PeriodicidadC.Descripcion LIKE \"%SE%\"
        // EFFECT   : 2
        boolean contratoCdrvNumPagosCond = Utilities.like(this.getPeriodicidadC().getPeriodicidadDescripcion(), "%SE%");
        if (contratoCdrvNumPagosCond) {
            contratoCdrvNumPagos = Long.valueOf(2);
        }
    }

    private void contratoCdrvNumPagosDerivationsDefault() {
        if (contratoCdrvNumPagos != null) return;
        // Default derivation
        // EFFECT   : 1
        contratoCdrvNumPagos = Long.valueOf(1);
    }

    /**
     * Computes the value of the <code>contratoCdrvValorInicialContrato</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvValorInicialContrato</code> derived attribute.
     */
    public Double contratoCdrvValorInicialContratoDerivations() throws SystemException {

        contratoCdrvValorInicialContrato = null;

        contratoCdrvValorInicialContratoDerivationsDefault();
        return contratoCdrvValorInicialContrato;
    }

    private void contratoCdrvValorInicialContratoDerivationsDefault() throws SystemException {
        if (contratoCdrvValorInicialContrato != null) return;
        // Default derivation
        // EFFECT   : RoundEx(SUM(BeneficiariosC.drvValorCuotaAfiliacion) * 12, 0)
        contratoCdrvValorInicialContrato = STDFunctions.roundExFun(contratoCRepository.assocOperator000(this) * Long.valueOf(12), Long.valueOf(0));
    }

    /**
     * Computes the value of the <code>contratoCdrvValorCuotaAfiliacion</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvValorCuotaAfiliacion</code> derived attribute.
     */
    public Double contratoCdrvValorCuotaAfiliacionDerivations() {

        contratoCdrvValorCuotaAfiliacion = null;

        contratoCdrvValorCuotaAfiliacionDerivationsDefault();
        return contratoCdrvValorCuotaAfiliacion;
    }

    private void contratoCdrvValorCuotaAfiliacionDerivationsDefault() {
        if (contratoCdrvValorCuotaAfiliacion != null) return;
        // Default derivation
        // EFFECT   : RoundEx( drvValorInicialContrato / drvNumPagos  , 0)
        contratoCdrvValorCuotaAfiliacion = STDFunctions.roundExFun(this.getContratoCdrvValorInicialContrato() / this.getContratoCdrvNumPagos(), Long.valueOf(0));
    }

    /**
     * Computes the value of the <code>contratoCdrvValorInicialContratoBBGes</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvValorInicialContratoBBGes</code> derived attribute.
     */
    public Double contratoCdrvValorInicialContratoBBGesDerivations() throws SystemException {

        contratoCdrvValorInicialContratoBBGes = null;

        contratoCdrvValorInicialContratoBBGesDerivationsDefault();
        return contratoCdrvValorInicialContratoBBGes;
    }

    private void contratoCdrvValorInicialContratoBBGesDerivationsDefault() throws SystemException {
        if (contratoCdrvValorInicialContratoBBGes != null) return;
        // Default derivation
        // EFFECT   : RoundEx(SUM( BeneficiariosC.drvValorInicialContrato ) WHERE (BeneficiariosC.PersonaC.TipoIdentificacionC.NombreCorto = \"MS\"), 0)
        contratoCdrvValorInicialContratoBBGes = STDFunctions.roundExFun(contratoCRepository.assocOperator001(this), Long.valueOf(0));
    }

    /**
     * Computes the value of the <code>contratoCdrvValorCuotaBruta</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvValorCuotaBruta</code> derived attribute.
     */
    public Double contratoCdrvValorCuotaBrutaDerivations() throws SystemException {

        contratoCdrvValorCuotaBruta = null;

        contratoCdrvValorCuotaBrutaDerivationsDefault();
        return contratoCdrvValorCuotaBruta;
    }

    private void contratoCdrvValorCuotaBrutaDerivationsDefault() throws SystemException {
        if (contratoCdrvValorCuotaBruta != null) return;
        // Default derivation
        // EFFECT   : RoundEx(SUM(BeneficiariosC.drvValorCuotaBruta), 0)
        contratoCdrvValorCuotaBruta = STDFunctions.roundExFun(contratoCRepository.assocOperator002(this), Long.valueOf(0));
    }

    /**
     * Computes the value of the <code>contratoCdrvMostrarPreEnRepAnexo</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvMostrarPreEnRepAnexo</code> derived attribute.
     */
    public Boolean contratoCdrvMostrarPreEnRepAnexoDerivations() throws SystemException {

        contratoCdrvMostrarPreEnRepAnexo = null;

        contratoCdrvMostrarPreEnRepAnexoDerivationsConditional1();
        contratoCdrvMostrarPreEnRepAnexoDerivationsDefault();
        return contratoCdrvMostrarPreEnRepAnexo;
    }

    private void contratoCdrvMostrarPreEnRepAnexoDerivationsConditional1() throws SystemException {
        if (contratoCdrvMostrarPreEnRepAnexo != null) return;
        // CONDITION: EXIST( ProductoC.Dominios ) WHERE (ProductoC.Dominios.PlanT = PlanC AND ProductoC.Dominios.MostrarPreexAnexos = true) = true
        // EFFECT   : TRUE
        boolean contratoCdrvMostrarPreEnRepAnexoCond = contratoCRepository.assocOperator003(this).equals(true);
        if (contratoCdrvMostrarPreEnRepAnexoCond) {
            contratoCdrvMostrarPreEnRepAnexo = Boolean.TRUE;
        }
    }

    private void contratoCdrvMostrarPreEnRepAnexoDerivationsDefault() {
        if (contratoCdrvMostrarPreEnRepAnexo != null) return;
        // Default derivation
        // EFFECT   : FALSE
        contratoCdrvMostrarPreEnRepAnexo = Boolean.FALSE;
    }

    /**
     * Computes the value of the <code>contratoCdrvMostrarPreEnRepCon</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvMostrarPreEnRepCon</code> derived attribute.
     */
    public Boolean contratoCdrvMostrarPreEnRepConDerivations() throws SystemException {

        contratoCdrvMostrarPreEnRepCon = null;

        contratoCdrvMostrarPreEnRepConDerivationsConditional1();
        contratoCdrvMostrarPreEnRepConDerivationsDefault();
        return contratoCdrvMostrarPreEnRepCon;
    }

    private void contratoCdrvMostrarPreEnRepConDerivationsConditional1() throws SystemException {
        if (contratoCdrvMostrarPreEnRepCon != null) return;
        // CONDITION: EXIST( ProductoC.Dominios ) WHERE (ProductoC.Dominios.PlanT = PlanC AND ProductoC.Dominios.MostrarPreexContrato = true) = true
        // EFFECT   : TRUE
        boolean contratoCdrvMostrarPreEnRepConCond = contratoCRepository.assocOperator004(this).equals(true);
        if (contratoCdrvMostrarPreEnRepConCond) {
            contratoCdrvMostrarPreEnRepCon = Boolean.TRUE;
        }
    }

    private void contratoCdrvMostrarPreEnRepConDerivationsDefault() {
        if (contratoCdrvMostrarPreEnRepCon != null) return;
        // Default derivation
        // EFFECT   : FALSE
        contratoCdrvMostrarPreEnRepCon = Boolean.FALSE;
    }

    /**
     * Computes the value of the <code>contratoCdrvNumFamilia</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>contratoCdrvNumFamilia</code> derived attribute.
     */
    public String contratoCdrvNumFamiliaDerivations() throws SystemException {

        contratoCdrvNumFamilia = null;

        contratoCdrvNumFamiliaDerivationsConditional1();
        contratoCdrvNumFamiliaDerivationsDefault();
        return contratoCdrvNumFamilia;
    }

    private void contratoCdrvNumFamiliaDerivationsConditional1() throws SystemException {
        if (contratoCdrvNumFamilia != null) return;
        // CONDITION: EXIST(FamiliasC) WHERE (FamiliasC.NumFamilia <> NULL) = TRUE
        // EFFECT   : GETONE(FamiliasC.NumFamilia) WHERE (FamiliasC.NumFamilia <> NULL)
        boolean contratoCdrvNumFamiliaCond = contratoCRepository.assocOperator005(this).equals(true);
        if (contratoCdrvNumFamiliaCond) {
            contratoCdrvNumFamilia = contratoCRepository.assocOperator006(this);
        }
    }

    private void contratoCdrvNumFamiliaDerivationsDefault() {
        if (contratoCdrvNumFamilia != null) return;
        // Default derivation
        // EFFECT   : \"1\"
        contratoCdrvNumFamilia = "1";
    }
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        contratoCNumContrato = null;
        contratoCNumSolicitud = null;
        contratoCFechaSolicitud = null;
        contratoCTipoContrato = null;
        contratoCFechaIniVigencia = null;
        contratoCFechaFinVigencia = null;
        contratoCDireccion = null;
        contratoCcorreoContratante = null;
        contratoCnumTelContratante = null;
        contratoCnumCelContratante = null;
        contratoCexentoIVA = null;
        contratoCContratoConFirma = null;
        contratoCvalorCuotaPeriodo = Double.valueOf(0);
        contratoCdescuentoComercial = Double.valueOf(0);
        contratoCIVA = Double.valueOf(0);
        contratoCdescuentoFinanciero = Double.valueOf(0);
        contratoCcontratoNotificado = false;
        contratoCUltimaActualizacion = null;
        contratoCCodTarifa = null;
        solicitud = null;
        personaCContratante = null;
        beneficiariosC = null;
        familiasC = null;
        periodicidadC = null;
        estadoContratoC = null;
        productoC = null;
        planC = null;
        tarifaC = null;
        grupoAsociadoC = null;
        municipioC = null;
        sucursalC = null;
        asesorC = null;
        values = new HashMap<>();
        contratoCRepository = Arc.container().select(ContratoCJpaRepository.class).get();
        solicitudRepository = Arc.container().select(SolicitudJpaRepository.class).get();
        productosRepository = Arc.container().select(ProductosJpaRepository.class).get();
        planesRepository = Arc.container().select(PlanesJpaRepository.class).get();
        sucursalRepository = Arc.container().select(SucursalJpaRepository.class).get();
        asesorRepository = Arc.container().select(AsesorJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return ContratoC.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ContratoCConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedContratoCNumContrato = false;
    	values.put("contratoCNumContrato", getContratoCNumContrato());
    	modifiedContratoCNumSolicitud = false;
    	values.put("contratoCNumSolicitud", getContratoCNumSolicitud());
    	modifiedContratoCFechaSolicitud = false;
    	values.put("contratoCFechaSolicitud", getContratoCFechaSolicitud());
    	modifiedContratoCTipoContrato = false;
    	values.put("contratoCTipoContrato", getContratoCTipoContrato());
    	modifiedContratoCFechaIniVigencia = false;
    	values.put("contratoCFechaIniVigencia", getContratoCFechaIniVigencia());
    	modifiedContratoCFechaFinVigencia = false;
    	values.put("contratoCFechaFinVigencia", getContratoCFechaFinVigencia());
    	modifiedContratoCDireccion = false;
    	values.put("contratoCDireccion", getContratoCDireccion());
    	modifiedContratoCcorreoContratante = false;
    	values.put("contratoCcorreoContratante", getContratoCcorreoContratante());
    	modifiedContratoCnumTelContratante = false;
    	values.put("contratoCnumTelContratante", getContratoCnumTelContratante());
    	modifiedContratoCnumCelContratante = false;
    	values.put("contratoCnumCelContratante", getContratoCnumCelContratante());
    	modifiedContratoCexentoIVA = false;
    	values.put("contratoCexentoIVA", getContratoCexentoIVA());
    	modifiedContratoCContratoConFirma = false;
    	values.put("contratoCContratoConFirma", getContratoCContratoConFirma());
    	modifiedContratoCvalorCuotaPeriodo = false;
    	values.put("contratoCvalorCuotaPeriodo", getContratoCvalorCuotaPeriodo());
    	modifiedContratoCdescuentoComercial = false;
    	values.put("contratoCdescuentoComercial", getContratoCdescuentoComercial());
    	modifiedContratoCIVA = false;
    	values.put("contratoCIVA", getContratoCIVA());
    	modifiedContratoCdescuentoFinanciero = false;
    	values.put("contratoCdescuentoFinanciero", getContratoCdescuentoFinanciero());
    	modifiedContratoCcontratoNotificado = false;
    	values.put("contratoCcontratoNotificado", getContratoCcontratoNotificado());
    	modifiedContratoCUltimaActualizacion = false;
    	values.put("contratoCUltimaActualizacion", getContratoCUltimaActualizacion());
    	modifiedContratoCCodTarifa = false;
    	values.put("contratoCCodTarifa", getContratoCCodTarifa());
    	modifiedSolicitud = false;
    	modifiedPersonaCContratante = false;
    	modifiedBeneficiariosC = false;
    	modifiedFamiliasC = false;
    	modifiedPeriodicidadC = false;
    	modifiedEstadoContratoC = false;
    	modifiedProductoC = false;
    	modifiedPlanC = false;
    	modifiedTarifaC = false;
    	modifiedGrupoAsociadoC = false;
    	modifiedMunicipioC = false;
    	modifiedSucursalC = false;
    	modifiedAsesorC = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            contratoCdrvTipoContrato = null;
            contratoCdrvNumPagos = null;
            contratoCdrvValorInicialContrato = null;
            contratoCdrvValorCuotaAfiliacion = null;
            contratoCdrvValorInicialContratoBBGes = null;
            contratoCdrvValorCuotaBruta = null;
            contratoCdrvMostrarPreEnRepAnexo = null;
            contratoCdrvMostrarPreEnRepCon = null;
            contratoCdrvNumFamilia = null;
    }

    /**
     * Returns the <code>ContratoCOid</code> object that identifies this instance of <code>ContratoC</code>.
     * @return <code>ContratoCOid </code> object that identifies this instance of <code>ContratoC</code>
     */
    public ContratoCOid getOid() {
        return new ContratoCOid(getContratoCID());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ContratoCConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ContratoCConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.CONTRATOC)) {
            // Add this class
            activeFacets.add(Constants.CONTRATOC);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.RESPREGIONAL) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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
