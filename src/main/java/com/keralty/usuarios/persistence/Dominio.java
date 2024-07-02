package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.DominioConstants;
import com.keralty.usuarios.global.GrupoAsignacionConstants;
import com.keralty.usuarios.global.NovedadConstants;
import com.keralty.usuarios.global.PeriodicidadConstants;
import com.keralty.usuarios.global.PlanesConstants;
import com.keralty.usuarios.global.PlantillaEmailConstants;
import com.keralty.usuarios.global.ProductosConstants;
import com.keralty.usuarios.global.RolConstants;
import com.keralty.usuarios.persistence.oid.DominioOid;
import com.keralty.usuarios.repository.AgentexProductoJpaRepository;
import com.keralty.usuarios.repository.DominioJpaRepository;
import com.keralty.usuarios.repository.GrupoAsignacionJpaRepository;
import com.keralty.usuarios.repository.PlanesJpaRepository;
import com.keralty.usuarios.repository.ProductosJpaRepository;
import com.keralty.usuarios.repository.RolJpaRepository;
import com.keralty.usuarios.service.NovedadService;
import com.keralty.usuarios.service.PeriodicidadService;
import com.keralty.usuarios.service.PlantillaEmailService;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.microprofile.rest.client.inject.RestClient;
/**
 * Persistent representation of the <code>Dominio</code> model class.
 * <p>
 * Model Class: <code>Dominio</code><br>
 */
@Entity(name = DominioConstants.CLASS_NAME)
@Table(name = DominioConstants.TBL_NAME)
public class Dominio extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient DominioJpaRepository dominioRepository;

    @JsonIgnore
    private transient AgentexProductoJpaRepository agentexProductoRepository;

    @JsonIgnore
    private transient PlanesJpaRepository planesRepository;

    @JsonIgnore
    private transient ProductosJpaRepository productosRepository;

    @RestClient
    private transient PeriodicidadService periodicidadService;

    @JsonIgnore
    private transient RolJpaRepository rolRepository;

    @RestClient
    private transient PlantillaEmailService plantillaEmailService;

    @RestClient
    private transient NovedadService novedadService;

    @JsonIgnore
    private transient GrupoAsignacionJpaRepository grupoAsignacionRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = DominioConstants.FLD_DOMINIONUMERO )
    @JsonProperty(value="numero")
    private Long dominioNumero;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOREQCUESMED )
    @JsonProperty(value="reqcuesmed")
    private Boolean dominioReqCuesMed;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioReqCuesMed;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIONOCUESMEDTRAS )
    @JsonProperty(value="nocuesmedtras")
    private Boolean dominioNoCuesMedTras;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioNoCuesMedTras;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIONUEVAAFILIACION )
    @JsonProperty(value="nuevaafiliacion")
    private Boolean dominioNuevaAfiliacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioNuevaAfiliacion;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOINCLUSION )
    @JsonProperty(value="inclusion")
    private Boolean dominioInclusion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioInclusion;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOACEPCUESMAT )
    @JsonProperty(value="acepcuesmat")
    private Boolean dominioAcepCuesMat;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioAcepCuesMat;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOACEPCUESNEO )
    @JsonProperty(value="acepcuesneo")
    private Boolean dominioAcepCuesNeo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioAcepCuesNeo;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOACEPBBGESTANTE )
    @JsonProperty(value="acepbbgestante")
    private Boolean dominioAcepBBGestante;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioAcepBBGestante;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOMOSTRARPREEXANEXOS )
    @JsonProperty(value="mostrarpreexanexos")
    private Boolean dominioMostrarPreexAnexos;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioMostrarPreexAnexos;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOMOSTRARPREEXCONTRATO )
    @JsonProperty(value="mostrarpreexcontrato")
    private Boolean dominioMostrarPreexContrato;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioMostrarPreexContrato;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOIGNORARPREEXISTENCIAS )
    @JsonProperty(value="ignorarpreexistencias")
    private Boolean dominioIgnorarPreexistencias;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioIgnorarPreexistencias;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIORESPCLAUNOMBRE )
    @JsonProperty(value="respclaunombre")
    private String dominioRespClauNombre;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioRespClauNombre;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIORESPCLAUCELULA )
    @JsonProperty(value="respclaucelula")
    private String dominioRespClauCelula;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioRespClauCelula;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIORESPCLAUEXPCELULA )
    @JsonProperty(value="respclauexpcelula")
    private String dominioRespClauExpCelula;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioRespClauExpCelula;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIORESPCLAUCARGO )
    @JsonProperty(value="respclaucargo")
    private String dominioRespClauCargo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioRespClauCargo;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIORESPCLAUFIRMA )
    @JsonProperty(value="respclaufirma")
    private byte[] dominioRespClauFirma;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioRespClauFirma;

    @Transient
    @JsonIgnore
    public boolean dominioRespClauFirmaInit = false;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIODIAINIVIGENCIA )
    @JsonProperty(value="diainivigencia")
    private Long dominioDiaIniVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioDiaIniVigencia;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIODIAFINVIGENCIA )
    @JsonProperty(value="diafinvigencia")
    private Long dominioDiaFinVigencia;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioDiaFinVigencia;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIODIASCADUCIDAD )
    @JsonProperty(value="diascaducidad")
    private Long dominioDiasCaducidad;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioDiasCaducidad;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOPRORRATEOUSUEXISTENTE )
    @JsonProperty(value="prorrateousuexistente")
    private Boolean dominioProrrateoUsuExistente;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioProrrateoUsuExistente;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOINCLUSIONMODGRUPOASOC )
    @JsonProperty(value="inclusionmodgrupoasoc")
    private Boolean dominioInclusionModGrupoAsoc;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioInclusionModGrupoAsoc;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOPERMITERECHAZADOSAFI )
    @JsonProperty(value="permiterechazadosafi")
    private Boolean dominioPermiteRechazadosAfi;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioPermiteRechazadosAfi;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOACEPPOLIZAINTER )
    @JsonProperty(value="aceppolizainter")
    private Boolean dominioAcepPolizaInter;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioAcepPolizaInter;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIONOVEXCEPCIONREQDOC )
    @JsonProperty(value="novexcepcionreqdoc")
    private Boolean dominioNovExcepcionReqDoc;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioNovExcepcionReqDoc;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOSOLNOVCOLOROSCURO )
    @JsonProperty(value="solnovcoloroscuro")
    private String dominioSolNovColorOscuro;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioSolNovColorOscuro;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOSOLNOVCOLORCLARO )
    @JsonProperty(value="solnovcolorclaro")
    private String dominioSolNovColorClaro;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioSolNovColorClaro;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOSOLNOVLOGO )
    @JsonProperty(value="solnovlogo")
    private String dominioSolNovLogo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioSolNovLogo;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOTRAMITEENLINEA )
    @JsonProperty(value="tramiteenlinea")
    private Boolean dominioTramiteEnLinea;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioTramiteEnLinea;

    /** Class member attribute. */
    @Column(name = DominioConstants.FLD_DOMINIOVIGENCIARADICACION )
    @JsonProperty(value="vigenciaradicacion")
    private Boolean dominioVigenciaRadicacion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominioVigenciaRadicacion;

    /** Related Class. */
    @ManyToMany(mappedBy=DominioConstants.ROLE_INVNAME_DOMINIOSCONINCOMPATIBILIDAD)
    @JsonIgnore
    private Collection <Dominio> dominiosConIncompatibilidad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominiosConIncompatibilidad;

    /** Related Class. */
    @ManyToMany(mappedBy=DominioConstants.ROLE_INVNAME_AGENTEXPRODUCTO)
    @JsonIgnore
    private Collection <AgentexProducto> agentexProducto;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAgentexProducto;

    /** Related Class. */
    @OneToMany(mappedBy = DominioConstants.ROLE_INVNAME_REPORTESDOMINIO)
    @JsonIgnore
    private Collection <ReportesDominio> reportesDominio;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedReportesDominio;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DominioConstants.FLD_PLANESPLAN, referencedColumnName=PlanesConstants.FLD_PLANESPLAN)
    })
    @JsonIgnore
    private Planes planT;
    /** Related attribute. */
    @Column(name = DominioConstants.FLD_PLANESPLAN, insertable = false, updatable = false)
    private Long planesPlan;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlanT;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DominioConstants.FLD_PRODUCTOSPRODUCTO, referencedColumnName=ProductosConstants.FLD_PRODUCTOSPRODUCTO)
    })
    @JsonIgnore
    private Productos productoT;
    /** Related attribute. */
    @Column(name = DominioConstants.FLD_PRODUCTOSPRODUCTO, insertable = false, updatable = false)
    private Long productosProducto;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductoT;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_DOMINIOPERIODICIDAD,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIOPERIODICIDAD_DOMINIONUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIOPERIODICIDAD_PERIODICIDADCODIGO, referencedColumnName=PeriodicidadConstants.FLD_PERIODICIDADCODIGO)
    })
    @JsonIgnore
    private Collection <Periodicidad> periodicidades;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPeriodicidades;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_DOMINIOROL,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIOROL_DOMINIONUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIOROL_ROLIDENTIFICADOR, referencedColumnName=RolConstants.FLD_ROLIDENTIFICADOR)
    })
    @JsonIgnore
    private Collection <Rol> roles;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedRoles;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_DOMINIOSPLANTILLAS,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIOSPLANTILLAS_DOMINIONUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIOSPLANTILLAS_PLANTILLAEMAILIDPLANTILLA, referencedColumnName=PlantillaEmailConstants.FLD_PLANTILLAEMAILIDPLANTILLA)
    })
    @JsonIgnore
    private Collection <PlantillaEmail> plantillas;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlantillas;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_DOMINIONOVEDAD,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIONOVEDAD_DOMINIONUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMDOMINIONOVEDAD_NOVEDADIDNOVEDAD, referencedColumnName=NovedadConstants.FLD_NOVEDADIDNOVEDAD)
    })
    @JsonIgnore
    private Collection <Novedad> novedades;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedades;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DominioConstants.FLD_GRUPOASIGNACIONID, referencedColumnName=GrupoAsignacionConstants.FLD_GRUPOASIGNACIONID)
    })
    @JsonIgnore
    private GrupoAsignacion grupoAsesores;
    /** Related attribute. */
    @Column(name = DominioConstants.FLD_GRUPOASIGNACIONID, insertable = false, updatable = false)
    private Long grupoAsignacionId;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGrupoAsesores;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=DominioConstants.FLD_GRUPOASIGNACIONGRUPOAREAMEDICAID, referencedColumnName=GrupoAsignacionConstants.FLD_GRUPOASIGNACIONID)
    })
    @JsonIgnore
    private GrupoAsignacion grupoAreaMedica;
    /** Related attribute. */
    @Column(name = DominioConstants.FLD_GRUPOASIGNACIONGRUPOAREAMEDICAID, insertable = false, updatable = false)
    private Long grupoAsignacionGrupoAreaMedicaId;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGrupoAreaMedica;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_INCOMPATIBILIDADESDOMINIO,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMINCOMPATIBILIDADESDOMINIO_DOMINIONUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMINCOMPATIBILIDADESDOMINIO_DOMINIODOMINIOSINCOMPATIBLESNUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO)
    })
    @JsonIgnore
    private Collection <Dominio> dominiosIncompatibles;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominiosIncompatibles;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Dominio() {
        dominioNumero = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Dominio</code>.
     * @param oid Object Identifier of the instance of <code>Dominio</code> to be created.
     * @throws SystemException
     */
    public Dominio(DominioOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            dominioNumero = oid.getDominioNumero();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Dominio</code>
     * @return The value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code>.
     */
    public Long getDominioNumero() {
        return dominioNumero;
    }

    /**
     * Sets the value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Dominio</code>
     * @param dominioNumero The new value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code>.
     */
    public void setDominioNumero(Long dominioNumero) {
        this.dominioNumero = dominioNumero;
    }

   /**
    * Returns the value of the <code>dominioReqCuesMed</code> attribute.<br>
    * Model Attribute: <code>dominioReqCuesMed</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>dominioReqCuesMed</code> attribute.
    */

    public Boolean getDominioReqCuesMed()  {
    	Boolean value;
        value =  dominioReqCuesMed;
        return value;
    }

   /**
    * Sets the value of the <code>dominioReqCuesMed</code> attribute.<br>
    * Model Attribute: <code>dominioReqCuesMed</code>. Variable Bool<br>
    * Comments: <br>
    * @param dominioReqCuesMed The new value of the <code>dominioReqCuesMed</code> attribute.
    */
    public void setDominioReqCuesMed (Boolean dominioReqCuesMed) {
        modifiedDominioReqCuesMed = true;
        this.dominioReqCuesMed = dominioReqCuesMed;
    }

   /**
    * Returns the value of the <code>modifiedDominioReqCuesMed</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioReqCuesMed</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioReqCuesMed() {
        return modifiedDominioReqCuesMed;
    }

   /**
    * Sets the value of the <code>modifiedDominioReqCuesMed</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioReqCuesMed</code>.
    */
    public void setModifiedDominioReqCuesMed(boolean modified) {
        this.modifiedDominioReqCuesMed = modified;
    }

   /**
    * Returns the value of the <code>dominioNoCuesMedTras</code> attribute.<br>
    * Model Attribute: <code>dominioNoCuesMedTras</code>. Variable Bool<br>
    * Comments: Aunque se haya marcado que se debe diligenciar el cuestionario médico, si es traslado no se permitiría
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioNoCuesMedTras</code> attribute.
    */

    public Boolean getDominioNoCuesMedTras()  {
    	Boolean value;
        value =  dominioNoCuesMedTras;
        return value;
    }

   /**
    * Sets the value of the <code>dominioNoCuesMedTras</code> attribute.<br>
    * Model Attribute: <code>dominioNoCuesMedTras</code>. Variable Bool<br>
    * Comments: Aunque se haya marcado que se debe diligenciar el cuestionario médico, si es traslado no se permitiría
<Options>
RADIO=1;
</Options><br>
    * @param dominioNoCuesMedTras The new value of the <code>dominioNoCuesMedTras</code> attribute.
    */
    public void setDominioNoCuesMedTras (Boolean dominioNoCuesMedTras) {
        modifiedDominioNoCuesMedTras = true;
        this.dominioNoCuesMedTras = dominioNoCuesMedTras;
    }

   /**
    * Returns the value of the <code>modifiedDominioNoCuesMedTras</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioNoCuesMedTras</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioNoCuesMedTras() {
        return modifiedDominioNoCuesMedTras;
    }

   /**
    * Sets the value of the <code>modifiedDominioNoCuesMedTras</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioNoCuesMedTras</code>.
    */
    public void setModifiedDominioNoCuesMedTras(boolean modified) {
        this.modifiedDominioNoCuesMedTras = modified;
    }

   /**
    * Returns the value of the <code>dominioNuevaAfiliacion</code> attribute.<br>
    * Model Attribute: <code>dominioNuevaAfiliacion</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioNuevaAfiliacion</code> attribute.
    */

    public Boolean getDominioNuevaAfiliacion()  {
    	Boolean value;
        value =  dominioNuevaAfiliacion;
        return value;
    }

   /**
    * Sets the value of the <code>dominioNuevaAfiliacion</code> attribute.<br>
    * Model Attribute: <code>dominioNuevaAfiliacion</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioNuevaAfiliacion The new value of the <code>dominioNuevaAfiliacion</code> attribute.
    */
    public void setDominioNuevaAfiliacion (Boolean dominioNuevaAfiliacion) {
        modifiedDominioNuevaAfiliacion = true;
        this.dominioNuevaAfiliacion = dominioNuevaAfiliacion;
    }

   /**
    * Returns the value of the <code>modifiedDominioNuevaAfiliacion</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioNuevaAfiliacion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioNuevaAfiliacion() {
        return modifiedDominioNuevaAfiliacion;
    }

   /**
    * Sets the value of the <code>modifiedDominioNuevaAfiliacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioNuevaAfiliacion</code>.
    */
    public void setModifiedDominioNuevaAfiliacion(boolean modified) {
        this.modifiedDominioNuevaAfiliacion = modified;
    }

   /**
    * Returns the value of the <code>dominioInclusion</code> attribute.<br>
    * Model Attribute: <code>dominioInclusion</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioInclusion</code> attribute.
    */

    public Boolean getDominioInclusion()  {
    	Boolean value;
        value =  dominioInclusion;
        return value;
    }

   /**
    * Sets the value of the <code>dominioInclusion</code> attribute.<br>
    * Model Attribute: <code>dominioInclusion</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioInclusion The new value of the <code>dominioInclusion</code> attribute.
    */
    public void setDominioInclusion (Boolean dominioInclusion) {
        modifiedDominioInclusion = true;
        this.dominioInclusion = dominioInclusion;
    }

   /**
    * Returns the value of the <code>modifiedDominioInclusion</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioInclusion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioInclusion() {
        return modifiedDominioInclusion;
    }

   /**
    * Sets the value of the <code>modifiedDominioInclusion</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioInclusion</code>.
    */
    public void setModifiedDominioInclusion(boolean modified) {
        this.modifiedDominioInclusion = modified;
    }

   /**
    * Returns the value of the <code>dominioAcepCuesMat</code> attribute.<br>
    * Model Attribute: <code>dominioAcepCuesMat</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioAcepCuesMat</code> attribute.
    */

    public Boolean getDominioAcepCuesMat()  {
    	Boolean value;
        value =  dominioAcepCuesMat;
        return value;
    }

   /**
    * Sets the value of the <code>dominioAcepCuesMat</code> attribute.<br>
    * Model Attribute: <code>dominioAcepCuesMat</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioAcepCuesMat The new value of the <code>dominioAcepCuesMat</code> attribute.
    */
    public void setDominioAcepCuesMat (Boolean dominioAcepCuesMat) {
        modifiedDominioAcepCuesMat = true;
        this.dominioAcepCuesMat = dominioAcepCuesMat;
    }

   /**
    * Returns the value of the <code>modifiedDominioAcepCuesMat</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioAcepCuesMat</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioAcepCuesMat() {
        return modifiedDominioAcepCuesMat;
    }

   /**
    * Sets the value of the <code>modifiedDominioAcepCuesMat</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioAcepCuesMat</code>.
    */
    public void setModifiedDominioAcepCuesMat(boolean modified) {
        this.modifiedDominioAcepCuesMat = modified;
    }

   /**
    * Returns the value of the <code>dominioAcepCuesNeo</code> attribute.<br>
    * Model Attribute: <code>dominioAcepCuesNeo</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioAcepCuesNeo</code> attribute.
    */

    public Boolean getDominioAcepCuesNeo()  {
    	Boolean value;
        value =  dominioAcepCuesNeo;
        return value;
    }

   /**
    * Sets the value of the <code>dominioAcepCuesNeo</code> attribute.<br>
    * Model Attribute: <code>dominioAcepCuesNeo</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioAcepCuesNeo The new value of the <code>dominioAcepCuesNeo</code> attribute.
    */
    public void setDominioAcepCuesNeo (Boolean dominioAcepCuesNeo) {
        modifiedDominioAcepCuesNeo = true;
        this.dominioAcepCuesNeo = dominioAcepCuesNeo;
    }

   /**
    * Returns the value of the <code>modifiedDominioAcepCuesNeo</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioAcepCuesNeo</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioAcepCuesNeo() {
        return modifiedDominioAcepCuesNeo;
    }

   /**
    * Sets the value of the <code>modifiedDominioAcepCuesNeo</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioAcepCuesNeo</code>.
    */
    public void setModifiedDominioAcepCuesNeo(boolean modified) {
        this.modifiedDominioAcepCuesNeo = modified;
    }

   /**
    * Returns the value of the <code>dominioAcepBBGestante</code> attribute.<br>
    * Model Attribute: <code>dominioAcepBBGestante</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioAcepBBGestante</code> attribute.
    */

    public Boolean getDominioAcepBBGestante()  {
    	Boolean value;
        value =  dominioAcepBBGestante;
        return value;
    }

   /**
    * Sets the value of the <code>dominioAcepBBGestante</code> attribute.<br>
    * Model Attribute: <code>dominioAcepBBGestante</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioAcepBBGestante The new value of the <code>dominioAcepBBGestante</code> attribute.
    */
    public void setDominioAcepBBGestante (Boolean dominioAcepBBGestante) {
        modifiedDominioAcepBBGestante = true;
        this.dominioAcepBBGestante = dominioAcepBBGestante;
    }

   /**
    * Returns the value of the <code>modifiedDominioAcepBBGestante</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioAcepBBGestante</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioAcepBBGestante() {
        return modifiedDominioAcepBBGestante;
    }

   /**
    * Sets the value of the <code>modifiedDominioAcepBBGestante</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioAcepBBGestante</code>.
    */
    public void setModifiedDominioAcepBBGestante(boolean modified) {
        this.modifiedDominioAcepBBGestante = modified;
    }

   /**
    * Returns the value of the <code>dominioMostrarPreexAnexos</code> attribute.<br>
    * Model Attribute: <code>dominioMostrarPreexAnexos</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioMostrarPreexAnexos</code> attribute.
    */

    public Boolean getDominioMostrarPreexAnexos()  {
    	Boolean value;
        value =  dominioMostrarPreexAnexos;
        return value;
    }

   /**
    * Sets the value of the <code>dominioMostrarPreexAnexos</code> attribute.<br>
    * Model Attribute: <code>dominioMostrarPreexAnexos</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioMostrarPreexAnexos The new value of the <code>dominioMostrarPreexAnexos</code> attribute.
    */
    public void setDominioMostrarPreexAnexos (Boolean dominioMostrarPreexAnexos) {
        modifiedDominioMostrarPreexAnexos = true;
        this.dominioMostrarPreexAnexos = dominioMostrarPreexAnexos;
    }

   /**
    * Returns the value of the <code>modifiedDominioMostrarPreexAnexos</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioMostrarPreexAnexos</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioMostrarPreexAnexos() {
        return modifiedDominioMostrarPreexAnexos;
    }

   /**
    * Sets the value of the <code>modifiedDominioMostrarPreexAnexos</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioMostrarPreexAnexos</code>.
    */
    public void setModifiedDominioMostrarPreexAnexos(boolean modified) {
        this.modifiedDominioMostrarPreexAnexos = modified;
    }

   /**
    * Returns the value of the <code>dominioMostrarPreexContrato</code> attribute.<br>
    * Model Attribute: <code>dominioMostrarPreexContrato</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioMostrarPreexContrato</code> attribute.
    */

    public Boolean getDominioMostrarPreexContrato()  {
    	Boolean value;
        value =  dominioMostrarPreexContrato;
        return value;
    }

   /**
    * Sets the value of the <code>dominioMostrarPreexContrato</code> attribute.<br>
    * Model Attribute: <code>dominioMostrarPreexContrato</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioMostrarPreexContrato The new value of the <code>dominioMostrarPreexContrato</code> attribute.
    */
    public void setDominioMostrarPreexContrato (Boolean dominioMostrarPreexContrato) {
        modifiedDominioMostrarPreexContrato = true;
        this.dominioMostrarPreexContrato = dominioMostrarPreexContrato;
    }

   /**
    * Returns the value of the <code>modifiedDominioMostrarPreexContrato</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioMostrarPreexContrato</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioMostrarPreexContrato() {
        return modifiedDominioMostrarPreexContrato;
    }

   /**
    * Sets the value of the <code>modifiedDominioMostrarPreexContrato</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioMostrarPreexContrato</code>.
    */
    public void setModifiedDominioMostrarPreexContrato(boolean modified) {
        this.modifiedDominioMostrarPreexContrato = modified;
    }

   /**
    * Returns the value of the <code>dominioIgnorarPreexistencias</code> attribute.<br>
    * Model Attribute: <code>dominioIgnorarPreexistencias</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioIgnorarPreexistencias</code> attribute.
    */

    public Boolean getDominioIgnorarPreexistencias()  {
    	Boolean value;
        value =  dominioIgnorarPreexistencias;
        return value;
    }

   /**
    * Sets the value of the <code>dominioIgnorarPreexistencias</code> attribute.<br>
    * Model Attribute: <code>dominioIgnorarPreexistencias</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param dominioIgnorarPreexistencias The new value of the <code>dominioIgnorarPreexistencias</code> attribute.
    */
    public void setDominioIgnorarPreexistencias (Boolean dominioIgnorarPreexistencias) {
        modifiedDominioIgnorarPreexistencias = true;
        this.dominioIgnorarPreexistencias = dominioIgnorarPreexistencias;
    }

   /**
    * Returns the value of the <code>modifiedDominioIgnorarPreexistencias</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioIgnorarPreexistencias</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioIgnorarPreexistencias() {
        return modifiedDominioIgnorarPreexistencias;
    }

   /**
    * Sets the value of the <code>modifiedDominioIgnorarPreexistencias</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioIgnorarPreexistencias</code>.
    */
    public void setModifiedDominioIgnorarPreexistencias(boolean modified) {
        this.modifiedDominioIgnorarPreexistencias = modified;
    }

   /**
    * Returns the value of the <code>dominioRespClauNombre</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauNombre</code>. Variable String Size=100<br>
    * Comments: Req. 4: Firmas a los clausulados. Nombre completo
Referencia: HU-AEEPS-03<br>
    * @return The value of the <code>dominioRespClauNombre</code> attribute.
    */

    public String getDominioRespClauNombre()  {
    	String value;
        value =  dominioRespClauNombre;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioRespClauNombre</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauNombre</code>. Variable String Size=100<br>
    * Comments: Req. 4: Firmas a los clausulados. Nombre completo
Referencia: HU-AEEPS-03<br>
    * @param dominioRespClauNombre The new value of the <code>dominioRespClauNombre</code> attribute.
    */
    public void setDominioRespClauNombre (String dominioRespClauNombre) {
        modifiedDominioRespClauNombre = true;
        this.dominioRespClauNombre = dominioRespClauNombre;
    }

   /**
    * Returns the value of the <code>modifiedDominioRespClauNombre</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioRespClauNombre</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioRespClauNombre() {
        return modifiedDominioRespClauNombre;
    }

   /**
    * Sets the value of the <code>modifiedDominioRespClauNombre</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioRespClauNombre</code>.
    */
    public void setModifiedDominioRespClauNombre(boolean modified) {
        this.modifiedDominioRespClauNombre = modified;
    }

   /**
    * Returns the value of the <code>dominioRespClauCelula</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauCelula</code>. Variable String Size=15<br>
    * Comments: Req. 4: Firmas a los clausulados. Nº de célula de ciudadanía
Referencia: HU-AEEPS-03<br>
    * @return The value of the <code>dominioRespClauCelula</code> attribute.
    */

    public String getDominioRespClauCelula()  {
    	String value;
        value =  dominioRespClauCelula;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioRespClauCelula</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauCelula</code>. Variable String Size=15<br>
    * Comments: Req. 4: Firmas a los clausulados. Nº de célula de ciudadanía
Referencia: HU-AEEPS-03<br>
    * @param dominioRespClauCelula The new value of the <code>dominioRespClauCelula</code> attribute.
    */
    public void setDominioRespClauCelula (String dominioRespClauCelula) {
        modifiedDominioRespClauCelula = true;
        this.dominioRespClauCelula = dominioRespClauCelula;
    }

   /**
    * Returns the value of the <code>modifiedDominioRespClauCelula</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioRespClauCelula</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioRespClauCelula() {
        return modifiedDominioRespClauCelula;
    }

   /**
    * Sets the value of the <code>modifiedDominioRespClauCelula</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioRespClauCelula</code>.
    */
    public void setModifiedDominioRespClauCelula(boolean modified) {
        this.modifiedDominioRespClauCelula = modified;
    }

   /**
    * Returns the value of the <code>dominioRespClauExpCelula</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauExpCelula</code>. Variable String Size=50<br>
    * Comments: Req. 4: Firmas a los clausulados. Lugar de expedición de la célula de ciudadanía
Referencia: HU-AEEPS-03<br>
    * @return The value of the <code>dominioRespClauExpCelula</code> attribute.
    */

    public String getDominioRespClauExpCelula()  {
    	String value;
        value =  dominioRespClauExpCelula;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioRespClauExpCelula</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauExpCelula</code>. Variable String Size=50<br>
    * Comments: Req. 4: Firmas a los clausulados. Lugar de expedición de la célula de ciudadanía
Referencia: HU-AEEPS-03<br>
    * @param dominioRespClauExpCelula The new value of the <code>dominioRespClauExpCelula</code> attribute.
    */
    public void setDominioRespClauExpCelula (String dominioRespClauExpCelula) {
        modifiedDominioRespClauExpCelula = true;
        this.dominioRespClauExpCelula = dominioRespClauExpCelula;
    }

   /**
    * Returns the value of the <code>modifiedDominioRespClauExpCelula</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioRespClauExpCelula</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioRespClauExpCelula() {
        return modifiedDominioRespClauExpCelula;
    }

   /**
    * Sets the value of the <code>modifiedDominioRespClauExpCelula</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioRespClauExpCelula</code>.
    */
    public void setModifiedDominioRespClauExpCelula(boolean modified) {
        this.modifiedDominioRespClauExpCelula = modified;
    }

   /**
    * Returns the value of the <code>dominioRespClauCargo</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauCargo</code>. Variable String Size=50<br>
    * Comments: Req. 4: Firmas a los clausulados. cargo que ostenta en la empresa
Referencia: HU-AEEPS-03<br>
    * @return The value of the <code>dominioRespClauCargo</code> attribute.
    */

    public String getDominioRespClauCargo()  {
    	String value;
        value =  dominioRespClauCargo;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioRespClauCargo</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauCargo</code>. Variable String Size=50<br>
    * Comments: Req. 4: Firmas a los clausulados. cargo que ostenta en la empresa
Referencia: HU-AEEPS-03<br>
    * @param dominioRespClauCargo The new value of the <code>dominioRespClauCargo</code> attribute.
    */
    public void setDominioRespClauCargo (String dominioRespClauCargo) {
        modifiedDominioRespClauCargo = true;
        this.dominioRespClauCargo = dominioRespClauCargo;
    }

   /**
    * Returns the value of the <code>modifiedDominioRespClauCargo</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioRespClauCargo</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioRespClauCargo() {
        return modifiedDominioRespClauCargo;
    }

   /**
    * Sets the value of the <code>modifiedDominioRespClauCargo</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioRespClauCargo</code>.
    */
    public void setModifiedDominioRespClauCargo(boolean modified) {
        this.modifiedDominioRespClauCargo = modified;
    }

   /**
    * Returns the value of the <code>dominioRespClauFirma</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauFirma</code>. Variable Blob<br>
    * Comments: Req. 4: Firmas a los clausulados. Imagen de la firma
Referencia: HU-AEEPS-03<br>
    * @return The value of the <code>dominioRespClauFirma</code> attribute.
    */

    public byte[] getDominioRespClauFirma()  {
    	byte[] value;
        value =  dominioRespClauFirma;
        return value;
    }

   /**
    * Sets the value of the <code>dominioRespClauFirma</code> attribute.<br>
    * Model Attribute: <code>dominioRespClauFirma</code>. Variable Blob<br>
    * Comments: Req. 4: Firmas a los clausulados. Imagen de la firma
Referencia: HU-AEEPS-03<br>
    * @param dominioRespClauFirma The new value of the <code>dominioRespClauFirma</code> attribute.
    */
    public void setDominioRespClauFirma (byte[] dominioRespClauFirma) {
        this.dominioRespClauFirmaInit = true;
        modifiedDominioRespClauFirma = true;
        this.dominioRespClauFirma = dominioRespClauFirma;
    }

   /**
    * Returns the value of the <code>modifiedDominioRespClauFirma</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioRespClauFirma</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioRespClauFirma() {
        return modifiedDominioRespClauFirma;
    }

   /**
    * Sets the value of the <code>modifiedDominioRespClauFirma</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioRespClauFirma</code>.
    */
    public void setModifiedDominioRespClauFirma(boolean modified) {
        this.modifiedDominioRespClauFirma = modified;
    }

   /**
    * Returns the value of the <code>dominioDiaIniVigencia</code> attribute.<br>
    * Model Attribute: <code>dominioDiaIniVigencia</code>. Variable Nat<br>
    * Comments: Parametrización de la fecha inicio de contratación para los planes voluntarios.
La parametrización indicará el día inicial y final que serán los valores que se utilizarán para calcular la fecha de inicio de contratación, que no será solicitada al usuario.<br>
    * @return The value of the <code>dominioDiaIniVigencia</code> attribute.
    */

    public Long getDominioDiaIniVigencia()  {
    	Long value;
        value =  dominioDiaIniVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>dominioDiaIniVigencia</code> attribute.<br>
    * Model Attribute: <code>dominioDiaIniVigencia</code>. Variable Nat<br>
    * Comments: Parametrización de la fecha inicio de contratación para los planes voluntarios.
La parametrización indicará el día inicial y final que serán los valores que se utilizarán para calcular la fecha de inicio de contratación, que no será solicitada al usuario.<br>
    * @param dominioDiaIniVigencia The new value of the <code>dominioDiaIniVigencia</code> attribute.
    */
    public void setDominioDiaIniVigencia (Long dominioDiaIniVigencia) {
        modifiedDominioDiaIniVigencia = true;
        this.dominioDiaIniVigencia = dominioDiaIniVigencia;
    }

   /**
    * Returns the value of the <code>modifiedDominioDiaIniVigencia</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioDiaIniVigencia</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioDiaIniVigencia() {
        return modifiedDominioDiaIniVigencia;
    }

   /**
    * Sets the value of the <code>modifiedDominioDiaIniVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioDiaIniVigencia</code>.
    */
    public void setModifiedDominioDiaIniVigencia(boolean modified) {
        this.modifiedDominioDiaIniVigencia = modified;
    }

   /**
    * Returns the value of the <code>dominioDiaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>dominioDiaFinVigencia</code>. Variable Nat<br>
    * Comments: Parametrización de la fecha inicio de contratación para los planes voluntarios.
La parametrización indicará el día inicial y final que serán los valores que se utilizarán para calcular la fecha de inicio de contratación, que no será solicitada al usuario.<br>
    * @return The value of the <code>dominioDiaFinVigencia</code> attribute.
    */

    public Long getDominioDiaFinVigencia()  {
    	Long value;
        value =  dominioDiaFinVigencia;
        return value;
    }

   /**
    * Sets the value of the <code>dominioDiaFinVigencia</code> attribute.<br>
    * Model Attribute: <code>dominioDiaFinVigencia</code>. Variable Nat<br>
    * Comments: Parametrización de la fecha inicio de contratación para los planes voluntarios.
La parametrización indicará el día inicial y final que serán los valores que se utilizarán para calcular la fecha de inicio de contratación, que no será solicitada al usuario.<br>
    * @param dominioDiaFinVigencia The new value of the <code>dominioDiaFinVigencia</code> attribute.
    */
    public void setDominioDiaFinVigencia (Long dominioDiaFinVigencia) {
        modifiedDominioDiaFinVigencia = true;
        this.dominioDiaFinVigencia = dominioDiaFinVigencia;
    }

   /**
    * Returns the value of the <code>modifiedDominioDiaFinVigencia</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioDiaFinVigencia</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioDiaFinVigencia() {
        return modifiedDominioDiaFinVigencia;
    }

   /**
    * Sets the value of the <code>modifiedDominioDiaFinVigencia</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioDiaFinVigencia</code>.
    */
    public void setModifiedDominioDiaFinVigencia(boolean modified) {
        this.modifiedDominioDiaFinVigencia = modified;
    }

   /**
    * Returns the value of the <code>dominioDiasCaducidad</code> attribute.<br>
    * Model Attribute: <code>dominioDiasCaducidad</code>. Variable Nat<br>
    * Comments: Req. 14: Anulación automática de solicitudes sin tramitar
Referencia: HU-AEEPS-14
Anulación de solicitudes de afiliación electrónica que cumplido un tiempo no hayan sido gestionadas.
Se requiere implementar un parámetro de tiempo máximo en días calendario por producto plan para mantener una solicitud sin tramitar, una vez se supere el tiempo parametrizado la solicitud debe anularse.<br>
    * @return The value of the <code>dominioDiasCaducidad</code> attribute.
    */

    public Long getDominioDiasCaducidad()  {
    	Long value;
        value =  dominioDiasCaducidad;
        return value;
    }

   /**
    * Sets the value of the <code>dominioDiasCaducidad</code> attribute.<br>
    * Model Attribute: <code>dominioDiasCaducidad</code>. Variable Nat<br>
    * Comments: Req. 14: Anulación automática de solicitudes sin tramitar
Referencia: HU-AEEPS-14
Anulación de solicitudes de afiliación electrónica que cumplido un tiempo no hayan sido gestionadas.
Se requiere implementar un parámetro de tiempo máximo en días calendario por producto plan para mantener una solicitud sin tramitar, una vez se supere el tiempo parametrizado la solicitud debe anularse.<br>
    * @param dominioDiasCaducidad The new value of the <code>dominioDiasCaducidad</code> attribute.
    */
    public void setDominioDiasCaducidad (Long dominioDiasCaducidad) {
        modifiedDominioDiasCaducidad = true;
        this.dominioDiasCaducidad = dominioDiasCaducidad;
    }

   /**
    * Returns the value of the <code>modifiedDominioDiasCaducidad</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioDiasCaducidad</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioDiasCaducidad() {
        return modifiedDominioDiasCaducidad;
    }

   /**
    * Sets the value of the <code>modifiedDominioDiasCaducidad</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioDiasCaducidad</code>.
    */
    public void setModifiedDominioDiasCaducidad(boolean modified) {
        this.modifiedDominioDiasCaducidad = modified;
    }

   /**
    * Returns the value of the <code>dominioProrrateoUsuExistente</code> attribute.<br>
    * Model Attribute: <code>dominioProrrateoUsuExistente</code>. Variable Bool<br>
    * Comments: GdC-14: Req. 13: Prorrateo. Debe ser configurable por Producto-Plan que esta opción de prorrateo solo aplica para usuarios nuevos
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioProrrateoUsuExistente</code> attribute.
    */

    public Boolean getDominioProrrateoUsuExistente()  {
    	Boolean value;
        value =  dominioProrrateoUsuExistente;
        return value;
    }

   /**
    * Sets the value of the <code>dominioProrrateoUsuExistente</code> attribute.<br>
    * Model Attribute: <code>dominioProrrateoUsuExistente</code>. Variable Bool<br>
    * Comments: GdC-14: Req. 13: Prorrateo. Debe ser configurable por Producto-Plan que esta opción de prorrateo solo aplica para usuarios nuevos
<Options>
RADIO=1;
</Options><br>
    * @param dominioProrrateoUsuExistente The new value of the <code>dominioProrrateoUsuExistente</code> attribute.
    */
    public void setDominioProrrateoUsuExistente (Boolean dominioProrrateoUsuExistente) {
        modifiedDominioProrrateoUsuExistente = true;
        this.dominioProrrateoUsuExistente = dominioProrrateoUsuExistente;
    }

   /**
    * Returns the value of the <code>modifiedDominioProrrateoUsuExistente</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioProrrateoUsuExistente</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioProrrateoUsuExistente() {
        return modifiedDominioProrrateoUsuExistente;
    }

   /**
    * Sets the value of the <code>modifiedDominioProrrateoUsuExistente</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioProrrateoUsuExistente</code>.
    */
    public void setModifiedDominioProrrateoUsuExistente(boolean modified) {
        this.modifiedDominioProrrateoUsuExistente = modified;
    }

   /**
    * Returns the value of the <code>dominioInclusionModGrupoAsoc</code> attribute.<br>
    * Model Attribute: <code>dominioInclusionModGrupoAsoc</code>. Variable Bool<br>
    * Comments: GcD-14:Req. 16: Modificación del grupo asociado en inclusiones
En inclusiones poder modificar el grupo asociado. 
Esta opción debe ser parametrizable por Producto-Plan.

<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioInclusionModGrupoAsoc</code> attribute.
    */

    public Boolean getDominioInclusionModGrupoAsoc()  {
    	Boolean value;
        value =  dominioInclusionModGrupoAsoc;
        return value;
    }

   /**
    * Sets the value of the <code>dominioInclusionModGrupoAsoc</code> attribute.<br>
    * Model Attribute: <code>dominioInclusionModGrupoAsoc</code>. Variable Bool<br>
    * Comments: GcD-14:Req. 16: Modificación del grupo asociado en inclusiones
En inclusiones poder modificar el grupo asociado. 
Esta opción debe ser parametrizable por Producto-Plan.

<Options>
RADIO=1;
</Options><br>
    * @param dominioInclusionModGrupoAsoc The new value of the <code>dominioInclusionModGrupoAsoc</code> attribute.
    */
    public void setDominioInclusionModGrupoAsoc (Boolean dominioInclusionModGrupoAsoc) {
        modifiedDominioInclusionModGrupoAsoc = true;
        this.dominioInclusionModGrupoAsoc = dominioInclusionModGrupoAsoc;
    }

   /**
    * Returns the value of the <code>modifiedDominioInclusionModGrupoAsoc</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioInclusionModGrupoAsoc</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioInclusionModGrupoAsoc() {
        return modifiedDominioInclusionModGrupoAsoc;
    }

   /**
    * Sets the value of the <code>modifiedDominioInclusionModGrupoAsoc</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioInclusionModGrupoAsoc</code>.
    */
    public void setModifiedDominioInclusionModGrupoAsoc(boolean modified) {
        this.modifiedDominioInclusionModGrupoAsoc = modified;
    }

   /**
    * Returns the value of the <code>dominioPermiteRechazadosAfi</code> attribute.<br>
    * Model Attribute: <code>dominioPermiteRechazadosAfi</code>. Variable Bool<br>
    * Comments: Req. 26: Configurar registro rechazado afiliación
Configurar por Producto-Plan si se pueden registrar beneficiarios así el usuario tenga la marcación rechazado afiliación. 
Hay planes que no importa esta marcación para registrar usuarios

<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioPermiteRechazadosAfi</code> attribute.
    */

    public Boolean getDominioPermiteRechazadosAfi()  {
    	Boolean value;
        value =  dominioPermiteRechazadosAfi;
        return value;
    }

   /**
    * Sets the value of the <code>dominioPermiteRechazadosAfi</code> attribute.<br>
    * Model Attribute: <code>dominioPermiteRechazadosAfi</code>. Variable Bool<br>
    * Comments: Req. 26: Configurar registro rechazado afiliación
Configurar por Producto-Plan si se pueden registrar beneficiarios así el usuario tenga la marcación rechazado afiliación. 
Hay planes que no importa esta marcación para registrar usuarios

<Options>
RADIO=1;
</Options><br>
    * @param dominioPermiteRechazadosAfi The new value of the <code>dominioPermiteRechazadosAfi</code> attribute.
    */
    public void setDominioPermiteRechazadosAfi (Boolean dominioPermiteRechazadosAfi) {
        modifiedDominioPermiteRechazadosAfi = true;
        this.dominioPermiteRechazadosAfi = dominioPermiteRechazadosAfi;
    }

   /**
    * Returns the value of the <code>modifiedDominioPermiteRechazadosAfi</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioPermiteRechazadosAfi</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioPermiteRechazadosAfi() {
        return modifiedDominioPermiteRechazadosAfi;
    }

   /**
    * Sets the value of the <code>modifiedDominioPermiteRechazadosAfi</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioPermiteRechazadosAfi</code>.
    */
    public void setModifiedDominioPermiteRechazadosAfi(boolean modified) {
        this.modifiedDominioPermiteRechazadosAfi = modified;
    }

   /**
    * Returns the value of the <code>dominioAcepPolizaInter</code> attribute.<br>
    * Model Attribute: <code>dominioAcepPolizaInter</code>. Variable Bool<br>
    * Comments: GdC-14:Req. 75: Póliza internacional
Se requiere agregar una opción en el cuadro de atributos la cual nos informe si el usuario tiene o no Póliza internacional. 
La parametrización que indica si se le debe solicitar si tiene póliza internacional como dato a un beneficiario se realizará en el Dominio, junto con el resto de parametrizaciones similares.

<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioAcepPolizaInter</code> attribute.
    */

    public Boolean getDominioAcepPolizaInter()  {
    	Boolean value;
        value =  dominioAcepPolizaInter;
        return value;
    }

   /**
    * Sets the value of the <code>dominioAcepPolizaInter</code> attribute.<br>
    * Model Attribute: <code>dominioAcepPolizaInter</code>. Variable Bool<br>
    * Comments: GdC-14:Req. 75: Póliza internacional
Se requiere agregar una opción en el cuadro de atributos la cual nos informe si el usuario tiene o no Póliza internacional. 
La parametrización que indica si se le debe solicitar si tiene póliza internacional como dato a un beneficiario se realizará en el Dominio, junto con el resto de parametrizaciones similares.

<Options>
RADIO=1;
</Options><br>
    * @param dominioAcepPolizaInter The new value of the <code>dominioAcepPolizaInter</code> attribute.
    */
    public void setDominioAcepPolizaInter (Boolean dominioAcepPolizaInter) {
        modifiedDominioAcepPolizaInter = true;
        this.dominioAcepPolizaInter = dominioAcepPolizaInter;
    }

   /**
    * Returns the value of the <code>modifiedDominioAcepPolizaInter</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioAcepPolizaInter</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioAcepPolizaInter() {
        return modifiedDominioAcepPolizaInter;
    }

   /**
    * Sets the value of the <code>modifiedDominioAcepPolizaInter</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioAcepPolizaInter</code>.
    */
    public void setModifiedDominioAcepPolizaInter(boolean modified) {
        this.modifiedDominioAcepPolizaInter = modified;
    }

   /**
    * Returns the value of the <code>dominioNovExcepcionReqDoc</code> attribute.<br>
    * Model Attribute: <code>dominioNovExcepcionReqDoc</code>. Variable Bool<br>
    * Comments: GdC 25 -  Req 11: -	La opción para indicar si es obligatorio o no subir documentos para estas solicitudes debe ser configurable por dominio

<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioNovExcepcionReqDoc</code> attribute.
    */

    public Boolean getDominioNovExcepcionReqDoc()  {
    	Boolean value;
        value =  dominioNovExcepcionReqDoc;
        return value;
    }

   /**
    * Sets the value of the <code>dominioNovExcepcionReqDoc</code> attribute.<br>
    * Model Attribute: <code>dominioNovExcepcionReqDoc</code>. Variable Bool<br>
    * Comments: GdC 25 -  Req 11: -	La opción para indicar si es obligatorio o no subir documentos para estas solicitudes debe ser configurable por dominio

<Options>
RADIO=1;
</Options><br>
    * @param dominioNovExcepcionReqDoc The new value of the <code>dominioNovExcepcionReqDoc</code> attribute.
    */
    public void setDominioNovExcepcionReqDoc (Boolean dominioNovExcepcionReqDoc) {
        modifiedDominioNovExcepcionReqDoc = true;
        this.dominioNovExcepcionReqDoc = dominioNovExcepcionReqDoc;
    }

   /**
    * Returns the value of the <code>modifiedDominioNovExcepcionReqDoc</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioNovExcepcionReqDoc</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioNovExcepcionReqDoc() {
        return modifiedDominioNovExcepcionReqDoc;
    }

   /**
    * Sets the value of the <code>modifiedDominioNovExcepcionReqDoc</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioNovExcepcionReqDoc</code>.
    */
    public void setModifiedDominioNovExcepcionReqDoc(boolean modified) {
        this.modifiedDominioNovExcepcionReqDoc = modified;
    }

   /**
    * Returns the value of the <code>dominioSolNovColorOscuro</code> attribute.<br>
    * Model Attribute: <code>dominioSolNovColorOscuro</code>. Variable String Size=10<br>
    * Comments: GdC 25: Req 10: Reporte de solicitud de novedad. Desde la configuración de dominios se debe configurar que producto-plan tiene habilitada esta funcionalidad y que formato debe visualizar (para cambiar el logo y el color)<br>
    * @return The value of the <code>dominioSolNovColorOscuro</code> attribute.
    */

    public String getDominioSolNovColorOscuro()  {
    	String value;
        value =  dominioSolNovColorOscuro;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioSolNovColorOscuro</code> attribute.<br>
    * Model Attribute: <code>dominioSolNovColorOscuro</code>. Variable String Size=10<br>
    * Comments: GdC 25: Req 10: Reporte de solicitud de novedad. Desde la configuración de dominios se debe configurar que producto-plan tiene habilitada esta funcionalidad y que formato debe visualizar (para cambiar el logo y el color)<br>
    * @param dominioSolNovColorOscuro The new value of the <code>dominioSolNovColorOscuro</code> attribute.
    */
    public void setDominioSolNovColorOscuro (String dominioSolNovColorOscuro) {
        modifiedDominioSolNovColorOscuro = true;
        this.dominioSolNovColorOscuro = dominioSolNovColorOscuro;
    }

   /**
    * Returns the value of the <code>modifiedDominioSolNovColorOscuro</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioSolNovColorOscuro</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioSolNovColorOscuro() {
        return modifiedDominioSolNovColorOscuro;
    }

   /**
    * Sets the value of the <code>modifiedDominioSolNovColorOscuro</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioSolNovColorOscuro</code>.
    */
    public void setModifiedDominioSolNovColorOscuro(boolean modified) {
        this.modifiedDominioSolNovColorOscuro = modified;
    }

   /**
    * Returns the value of the <code>dominioSolNovColorClaro</code> attribute.<br>
    * Model Attribute: <code>dominioSolNovColorClaro</code>. Variable String Size=10<br>
    * Comments: GdC 25: Req 10: Reporte de solicitud de novedad. Desde la configuración de dominios se debe configurar que producto-plan tiene habilitada esta funcionalidad y que formato debe visualizar (para cambiar el logo y el color)<br>
    * @return The value of the <code>dominioSolNovColorClaro</code> attribute.
    */

    public String getDominioSolNovColorClaro()  {
    	String value;
        value =  dominioSolNovColorClaro;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioSolNovColorClaro</code> attribute.<br>
    * Model Attribute: <code>dominioSolNovColorClaro</code>. Variable String Size=10<br>
    * Comments: GdC 25: Req 10: Reporte de solicitud de novedad. Desde la configuración de dominios se debe configurar que producto-plan tiene habilitada esta funcionalidad y que formato debe visualizar (para cambiar el logo y el color)<br>
    * @param dominioSolNovColorClaro The new value of the <code>dominioSolNovColorClaro</code> attribute.
    */
    public void setDominioSolNovColorClaro (String dominioSolNovColorClaro) {
        modifiedDominioSolNovColorClaro = true;
        this.dominioSolNovColorClaro = dominioSolNovColorClaro;
    }

   /**
    * Returns the value of the <code>modifiedDominioSolNovColorClaro</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioSolNovColorClaro</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioSolNovColorClaro() {
        return modifiedDominioSolNovColorClaro;
    }

   /**
    * Sets the value of the <code>modifiedDominioSolNovColorClaro</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioSolNovColorClaro</code>.
    */
    public void setModifiedDominioSolNovColorClaro(boolean modified) {
        this.modifiedDominioSolNovColorClaro = modified;
    }

   /**
    * Returns the value of the <code>dominioSolNovLogo</code> attribute.<br>
    * Model Attribute: <code>dominioSolNovLogo</code>. Variable String Size=50<br>
    * Comments: GdC 25: Req 10: Reporte de solicitud de novedad. Desde la configuración de dominios se debe configurar que producto-plan tiene habilitada esta funcionalidad y que formato debe visualizar (para cambiar el logo y el color)<br>
    * @return The value of the <code>dominioSolNovLogo</code> attribute.
    */

    public String getDominioSolNovLogo()  {
    	String value;
        value =  dominioSolNovLogo;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>dominioSolNovLogo</code> attribute.<br>
    * Model Attribute: <code>dominioSolNovLogo</code>. Variable String Size=50<br>
    * Comments: GdC 25: Req 10: Reporte de solicitud de novedad. Desde la configuración de dominios se debe configurar que producto-plan tiene habilitada esta funcionalidad y que formato debe visualizar (para cambiar el logo y el color)<br>
    * @param dominioSolNovLogo The new value of the <code>dominioSolNovLogo</code> attribute.
    */
    public void setDominioSolNovLogo (String dominioSolNovLogo) {
        modifiedDominioSolNovLogo = true;
        this.dominioSolNovLogo = dominioSolNovLogo;
    }

   /**
    * Returns the value of the <code>modifiedDominioSolNovLogo</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioSolNovLogo</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioSolNovLogo() {
        return modifiedDominioSolNovLogo;
    }

   /**
    * Sets the value of the <code>modifiedDominioSolNovLogo</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioSolNovLogo</code>.
    */
    public void setModifiedDominioSolNovLogo(boolean modified) {
        this.modifiedDominioSolNovLogo = modified;
    }

   /**
    * Returns the value of the <code>dominioTramiteEnLinea</code> attribute.<br>
    * Model Attribute: <code>dominioTramiteEnLinea</code>. Variable Bool<br>
    * Comments: GdC-40:Req. 5: Configuración trámite en línea de solicitudesSe requiere un nuevo valor de configuración por Dominio (Producto-Plan) que indique si las solicitudes (tanto de nueva contratación como de inclusión) de este se tramitan en línea o no. 
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioTramiteEnLinea</code> attribute.
    */

    public Boolean getDominioTramiteEnLinea()  {
    	Boolean value;
        value =  dominioTramiteEnLinea;
        return value;
    }

   /**
    * Sets the value of the <code>dominioTramiteEnLinea</code> attribute.<br>
    * Model Attribute: <code>dominioTramiteEnLinea</code>. Variable Bool<br>
    * Comments: GdC-40:Req. 5: Configuración trámite en línea de solicitudesSe requiere un nuevo valor de configuración por Dominio (Producto-Plan) que indique si las solicitudes (tanto de nueva contratación como de inclusión) de este se tramitan en línea o no. 
<Options>
RADIO=1;
</Options><br>
    * @param dominioTramiteEnLinea The new value of the <code>dominioTramiteEnLinea</code> attribute.
    */
    public void setDominioTramiteEnLinea (Boolean dominioTramiteEnLinea) {
        modifiedDominioTramiteEnLinea = true;
        this.dominioTramiteEnLinea = dominioTramiteEnLinea;
    }

   /**
    * Returns the value of the <code>modifiedDominioTramiteEnLinea</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioTramiteEnLinea</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioTramiteEnLinea() {
        return modifiedDominioTramiteEnLinea;
    }

   /**
    * Sets the value of the <code>modifiedDominioTramiteEnLinea</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioTramiteEnLinea</code>.
    */
    public void setModifiedDominioTramiteEnLinea(boolean modified) {
        this.modifiedDominioTramiteEnLinea = modified;
    }

   /**
    * Returns the value of the <code>dominioVigenciaRadicacion</code> attribute.<br>
    * Model Attribute: <code>dominioVigenciaRadicacion</code>. Variable Bool<br>
    * Comments: GdC-40:Req. 7: Fecha de radicación por Producto-Plan

Se requiere añadir una nueva configuración a Dominio (Producto-Plan) que indique si sus solicitudes pueden radicarse cualquier día del mes o tan solo el día uno.
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>dominioVigenciaRadicacion</code> attribute.
    */

    public Boolean getDominioVigenciaRadicacion()  {
    	Boolean value;
        value =  dominioVigenciaRadicacion;
        return value;
    }

   /**
    * Sets the value of the <code>dominioVigenciaRadicacion</code> attribute.<br>
    * Model Attribute: <code>dominioVigenciaRadicacion</code>. Variable Bool<br>
    * Comments: GdC-40:Req. 7: Fecha de radicación por Producto-Plan

Se requiere añadir una nueva configuración a Dominio (Producto-Plan) que indique si sus solicitudes pueden radicarse cualquier día del mes o tan solo el día uno.
<Options>
RADIO=1;
</Options><br>
    * @param dominioVigenciaRadicacion The new value of the <code>dominioVigenciaRadicacion</code> attribute.
    */
    public void setDominioVigenciaRadicacion (Boolean dominioVigenciaRadicacion) {
        modifiedDominioVigenciaRadicacion = true;
        this.dominioVigenciaRadicacion = dominioVigenciaRadicacion;
    }

   /**
    * Returns the value of the <code>modifiedDominioVigenciaRadicacion</code> class property.<br>
    *
    * @return The value of the <code>modifiedDominioVigenciaRadicacion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedDominioVigenciaRadicacion() {
        return modifiedDominioVigenciaRadicacion;
    }

   /**
    * Sets the value of the <code>modifiedDominioVigenciaRadicacion</code> class property.<br>
    * @param modified The new value of the <code>modifiedDominioVigenciaRadicacion</code>.
    */
    public void setModifiedDominioVigenciaRadicacion(boolean modified) {
        this.modifiedDominioVigenciaRadicacion = modified;
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>DominiosConIncompatibilidad</code> role.
     * Model Relationship:
     * <code>[Dominio] DominiosConIncompatibilidad 0:M  ------ 0:M  DominiosIncompatibles [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>DominiosConIncompatibilidad</code> role.
     */
    @JsonIgnore
    public Collection <Dominio> getDominiosConIncompatibilidad() {
        return dominiosConIncompatibilidad;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>DominiosConIncompatibilidad</code> role.
    * @param dominiosConIncompatibilidad The instance to add to the <code>DominiosConIncompatibilidad</code> role.
    */
    public void add2DominiosConIncompatibilidad(Dominio dominiosConIncompatibilidad) {
        this.getDominiosConIncompatibilidad().add(dominiosConIncompatibilidad);
    }
    /**
     * Sets instances of <code>Dominio</code> related through the <code>DominiosConIncompatibilidad</code> role.
     * @param dominiosConIncompatibilidad The new value for the <code>DominiosConIncompatibilidad</code> role.
     */
    public void setDominiosConIncompatibilidad(Collection < Dominio > dominiosConIncompatibilidad) {
        this.dominiosConIncompatibilidad = dominiosConIncompatibilidad;
    }

   /**
    * This method gets the attribute value <code>modifiedDominiosConIncompatibilidad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominiosConIncompatibilidad</code> has been modified.
    */
    public boolean isModifiedDominiosConIncompatibilidad(){
        return modifiedDominiosConIncompatibilidad;
    }

    /**
     * Returns the instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     * Model Relationship:
     * <code>[AgentexProducto] AgentexProducto 0:M  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     */
    @JsonIgnore
    public Collection <AgentexProducto> getAgentexProducto() {
        return agentexProducto;
    }

   /**
    * Adds an instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
    * @param agentexProducto The instance to add to the <code>AgentexProducto</code> role.
    */
    public void add2AgentexProducto(AgentexProducto agentexProducto) {
        this.getAgentexProducto().add(agentexProducto);
    }
    /**
     * Sets instances of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     * @param agentexProducto The new value for the <code>AgentexProducto</code> role.
     */
    public void setAgentexProducto(Collection < AgentexProducto > agentexProducto) {
        this.agentexProducto = agentexProducto;
    }

   /**
    * This method gets the attribute value <code>modifiedAgentexProducto</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAgentexProducto</code> has been modified.
    */
    public boolean isModifiedAgentexProducto(){
        return modifiedAgentexProducto;
    }

    /**
     * Returns the instance of <code>ReportesDominio</code> related through the <code>ReportesDominio</code> role.
     * Model Relationship:
     * <code>[ReportesDominio] ReportesDominio 0:M  ------ 1:1  Dominio [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ReportesDominio</code> related through the <code>ReportesDominio</code> role.
     */
    @JsonIgnore
    public Collection <ReportesDominio> getReportesDominio() {
        return reportesDominio;
    }

   /**
    * Adds an instance of <code>ReportesDominio</code> related through the <code>ReportesDominio</code> role.
    * @param reportesDominio The instance to add to the <code>ReportesDominio</code> role.
    */
    public void add2ReportesDominio(ReportesDominio reportesDominio) {
        this.getReportesDominio().add(reportesDominio);
    }
    /**
     * Sets instances of <code>ReportesDominio</code> related through the <code>ReportesDominio</code> role.
     * @param reportesDominio The new value for the <code>ReportesDominio</code> role.
     */
    public void setReportesDominio(Collection < ReportesDominio > reportesDominio) {
        this.reportesDominio = reportesDominio;
    }

   /**
    * This method gets the attribute value <code>modifiedReportesDominio</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedReportesDominio</code> has been modified.
    */
    public boolean isModifiedReportesDominio(){
        return modifiedReportesDominio;
    }

    /**
     * Returns the instance of <code>Planes</code> related through the <code>PlanT</code> role.
     * Model Relationship:
     * <code>[Planes] PlanT 1:1  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Planes</code> related through the <code>PlanT</code> role.
     */
    @JsonIgnore
    public Planes getPlanT() {
        try {
            if (planT != null && planT.isNull()) {
                planT = null;
            }
        } catch (Exception ex) {
            planT = null;
        }
        if (planT == null) {
            if (planesPlan != null) {
                planT = planesRepository.findById(planesPlan).orElse(null);
            } else {
                planT = null;
            }
        }
        return (planT == null ? new Planes(null) : planT);
    }

   /**
    * Adds an instance of <code>Planes</code> related through the <code>PlanT</code> role.
    * @param planT The instance to add to the <code>PlanT</code> role.
    */
    public void add2PlanT(Planes planT) {
        if (planT == null || planT.isNull()) {
            this.modifiedPlanT = true;
            this.planesPlan = null;
        } else {
            this.planesPlan = planT.getPlanesPlan();
        }
        this.planT = (planT == null  || planT.isNull() ? null : planT);
    }

   /**
    * This method gets the attribute value <code>modifiedPlanT</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPlanT</code> has been modified.
    */
    public boolean isModifiedPlanT(){
        return modifiedPlanT;
    }

    /**
     * Returns the instance of <code>Productos</code> related through the <code>ProductoT</code> role.
     * Model Relationship:
     * <code>[Productos] ProductoT 1:1  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Productos</code> related through the <code>ProductoT</code> role.
     */
    @JsonIgnore
    public Productos getProductoT() {
        try {
            if (productoT != null && productoT.isNull()) {
                productoT = null;
            }
        } catch (Exception ex) {
            productoT = null;
        }
        if (productoT == null) {
            if (productosProducto != null) {
                productoT = productosRepository.findById(productosProducto).orElse(null);
            } else {
                productoT = null;
            }
        }
        return (productoT == null ? new Productos(null) : productoT);
    }

   /**
    * Adds an instance of <code>Productos</code> related through the <code>ProductoT</code> role.
    * @param productoT The instance to add to the <code>ProductoT</code> role.
    */
    public void add2ProductoT(Productos productoT) {
        if (productoT == null || productoT.isNull()) {
            this.modifiedProductoT = true;
            this.productosProducto = null;
        } else {
            this.productosProducto = productoT.getProductosProducto();
        }
        this.productoT = (productoT == null  || productoT.isNull() ? null : productoT);
    }

   /**
    * This method gets the attribute value <code>modifiedProductoT</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedProductoT</code> has been modified.
    */
    public boolean isModifiedProductoT(){
        return modifiedProductoT;
    }

    /**
     * Returns the instance of <code>Periodicidad</code> related through the <code>Periodicidades</code> role.
     * Model Relationship:
     * <code>[Periodicidad] Periodicidades 0:M  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Periodicidad</code> related through the <code>Periodicidades</code> role.
     */
    @JsonIgnore
    public Collection <Periodicidad> getPeriodicidades() {
        return periodicidades;
    }

   /**
    * Adds an instance of <code>Periodicidad</code> related through the <code>Periodicidades</code> role.
    * @param periodicidades The instance to add to the <code>Periodicidades</code> role.
    */
    public void add2Periodicidades(Periodicidad periodicidades) {
        this.getPeriodicidades().add(periodicidades);
    }
    /**
     * Sets instances of <code>Periodicidad</code> related through the <code>Periodicidades</code> role.
     * @param periodicidades The new value for the <code>Periodicidades</code> role.
     */
    public void setPeriodicidades(Collection < Periodicidad > periodicidades) {
        this.periodicidades = periodicidades;
    }

   /**
    * This method gets the attribute value <code>modifiedPeriodicidades</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPeriodicidades</code> has been modified.
    */
    public boolean isModifiedPeriodicidades(){
        return modifiedPeriodicidades;
    }

    /**
     * Returns the instance of <code>Rol</code> related through the <code>Roles</code> role.
     * Model Relationship:
     * <code>[Rol] Roles 0:M  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Rol</code> related through the <code>Roles</code> role.
     */
    @JsonIgnore
    public Collection <Rol> getRoles() {
        return roles;
    }

   /**
    * Adds an instance of <code>Rol</code> related through the <code>Roles</code> role.
    * @param roles The instance to add to the <code>Roles</code> role.
    */
    public void add2Roles(Rol roles) {
        this.getRoles().add(roles);
    }
    /**
     * Sets instances of <code>Rol</code> related through the <code>Roles</code> role.
     * @param roles The new value for the <code>Roles</code> role.
     */
    public void setRoles(Collection < Rol > roles) {
        this.roles = roles;
    }

   /**
    * This method gets the attribute value <code>modifiedRoles</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedRoles</code> has been modified.
    */
    public boolean isModifiedRoles(){
        return modifiedRoles;
    }

    /**
     * Returns the instance of <code>PlantillaEmail</code> related through the <code>Plantillas</code> role.
     * Model Relationship:
     * <code>[PlantillaEmail] Plantillas 0:M  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>PlantillaEmail</code> related through the <code>Plantillas</code> role.
     */
    @JsonIgnore
    public Collection <PlantillaEmail> getPlantillas() {
        return plantillas;
    }

   /**
    * Adds an instance of <code>PlantillaEmail</code> related through the <code>Plantillas</code> role.
    * @param plantillas The instance to add to the <code>Plantillas</code> role.
    */
    public void add2Plantillas(PlantillaEmail plantillas) {
        this.getPlantillas().add(plantillas);
    }
    /**
     * Sets instances of <code>PlantillaEmail</code> related through the <code>Plantillas</code> role.
     * @param plantillas The new value for the <code>Plantillas</code> role.
     */
    public void setPlantillas(Collection < PlantillaEmail > plantillas) {
        this.plantillas = plantillas;
    }

   /**
    * This method gets the attribute value <code>modifiedPlantillas</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPlantillas</code> has been modified.
    */
    public boolean isModifiedPlantillas(){
        return modifiedPlantillas;
    }

    /**
     * Returns the instance of <code>Novedad</code> related through the <code>Novedades</code> role.
     * Model Relationship:
     * <code>[Novedad] Novedades 0:M  ------ 0:M  Dominios [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Novedad</code> related through the <code>Novedades</code> role.
     */
    @JsonIgnore
    public Collection <Novedad> getNovedades() {
        return novedades;
    }

   /**
    * Adds an instance of <code>Novedad</code> related through the <code>Novedades</code> role.
    * @param novedades The instance to add to the <code>Novedades</code> role.
    */
    public void add2Novedades(Novedad novedades) {
        this.getNovedades().add(novedades);
    }
    /**
     * Sets instances of <code>Novedad</code> related through the <code>Novedades</code> role.
     * @param novedades The new value for the <code>Novedades</code> role.
     */
    public void setNovedades(Collection < Novedad > novedades) {
        this.novedades = novedades;
    }

   /**
    * This method gets the attribute value <code>modifiedNovedades</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedNovedades</code> has been modified.
    */
    public boolean isModifiedNovedades(){
        return modifiedNovedades;
    }

    /**
     * Returns the instance of <code>GrupoAsignacion</code> related through the <code>GrupoAsesores</code> role.
     * Model Relationship:
     * <code>[GrupoAsignacion] GrupoAsesores 0:1  ------ 0:M  DominioAsesores [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>GrupoAsignacion</code> related through the <code>GrupoAsesores</code> role.
     */
    @JsonIgnore
    public GrupoAsignacion getGrupoAsesores() {
        try {
            if (grupoAsesores != null && grupoAsesores.isNull()) {
                grupoAsesores = null;
            }
        } catch (Exception ex) {
            grupoAsesores = null;
        }
        if (grupoAsesores == null) {
            if (grupoAsignacionId != null) {
                grupoAsesores = grupoAsignacionRepository.findById(grupoAsignacionId).orElse(null);
            } else {
                grupoAsesores = null;
            }
        }
        return (grupoAsesores == null ? new GrupoAsignacion(null) : grupoAsesores);
    }

   /**
    * Adds an instance of <code>GrupoAsignacion</code> related through the <code>GrupoAsesores</code> role.
    * @param grupoAsesores The instance to add to the <code>GrupoAsesores</code> role.
    */
    public void add2GrupoAsesores(GrupoAsignacion grupoAsesores) {
        if (grupoAsesores == null || grupoAsesores.isNull()) {
            this.modifiedGrupoAsesores = true;
            this.grupoAsignacionId = null;
        } else {
            this.grupoAsignacionId = grupoAsesores.getGrupoAsignacionId();
        }
        this.grupoAsesores = (grupoAsesores == null  || grupoAsesores.isNull() ? null : grupoAsesores);
    }

   /**
    * This method gets the attribute value <code>modifiedGrupoAsesores</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedGrupoAsesores</code> has been modified.
    */
    public boolean isModifiedGrupoAsesores(){
        return modifiedGrupoAsesores;
    }

    /**
     * Returns the instance of <code>GrupoAsignacion</code> related through the <code>GrupoAreaMedica</code> role.
     * Model Relationship:
     * <code>[GrupoAsignacion] GrupoAreaMedica 0:1  ------ 0:M  DominioAreaMedica [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>GrupoAsignacion</code> related through the <code>GrupoAreaMedica</code> role.
     */
    @JsonIgnore
    public GrupoAsignacion getGrupoAreaMedica() {
        try {
            if (grupoAreaMedica != null && grupoAreaMedica.isNull()) {
                grupoAreaMedica = null;
            }
        } catch (Exception ex) {
            grupoAreaMedica = null;
        }
        if (grupoAreaMedica == null) {
            if (grupoAsignacionGrupoAreaMedicaId != null) {
                grupoAreaMedica = grupoAsignacionRepository.findById(grupoAsignacionGrupoAreaMedicaId).orElse(null);
            } else {
                grupoAreaMedica = null;
            }
        }
        return (grupoAreaMedica == null ? new GrupoAsignacion(null) : grupoAreaMedica);
    }

   /**
    * Adds an instance of <code>GrupoAsignacion</code> related through the <code>GrupoAreaMedica</code> role.
    * @param grupoAreaMedica The instance to add to the <code>GrupoAreaMedica</code> role.
    */
    public void add2GrupoAreaMedica(GrupoAsignacion grupoAreaMedica) {
        if (grupoAreaMedica == null || grupoAreaMedica.isNull()) {
            this.modifiedGrupoAreaMedica = true;
            this.grupoAsignacionGrupoAreaMedicaId = null;
        } else {
            this.grupoAsignacionGrupoAreaMedicaId = grupoAreaMedica.getGrupoAsignacionId();
        }
        this.grupoAreaMedica = (grupoAreaMedica == null  || grupoAreaMedica.isNull() ? null : grupoAreaMedica);
    }

   /**
    * This method gets the attribute value <code>modifiedGrupoAreaMedica</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedGrupoAreaMedica</code> has been modified.
    */
    public boolean isModifiedGrupoAreaMedica(){
        return modifiedGrupoAreaMedica;
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>DominiosIncompatibles</code> role.
     * Model Relationship:
     * <code>[Dominio] DominiosIncompatibles 0:M  ------ 0:M  DominiosConIncompatibilidad [Dominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>DominiosIncompatibles</code> role.
     */
    @JsonIgnore
    public Collection <Dominio> getDominiosIncompatibles() {
        return dominiosIncompatibles;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>DominiosIncompatibles</code> role.
    * @param dominiosIncompatibles The instance to add to the <code>DominiosIncompatibles</code> role.
    */
    public void add2DominiosIncompatibles(Dominio dominiosIncompatibles) {
        this.getDominiosIncompatibles().add(dominiosIncompatibles);
    }
    /**
     * Sets instances of <code>Dominio</code> related through the <code>DominiosIncompatibles</code> role.
     * @param dominiosIncompatibles The new value for the <code>DominiosIncompatibles</code> role.
     */
    public void setDominiosIncompatibles(Collection < Dominio > dominiosIncompatibles) {
        this.dominiosIncompatibles = dominiosIncompatibles;
    }

   /**
    * This method gets the attribute value <code>modifiedDominiosIncompatibles</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominiosIncompatibles</code> has been modified.
    */
    public boolean isModifiedDominiosIncompatibles(){
        return modifiedDominiosIncompatibles;
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
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        dominioReqCuesMed = false;
        dominioNoCuesMedTras = false;
        dominioNuevaAfiliacion = false;
        dominioInclusion = false;
        dominioAcepCuesMat = false;
        dominioAcepCuesNeo = false;
        dominioAcepBBGestante = false;
        dominioMostrarPreexAnexos = false;
        dominioMostrarPreexContrato = false;
        dominioIgnorarPreexistencias = false;
        dominioRespClauNombre = null;
        dominioRespClauCelula = null;
        dominioRespClauExpCelula = null;
        dominioRespClauCargo = null;
        dominioRespClauFirma = null;
        dominioDiaIniVigencia = null;
        dominioDiaFinVigencia = null;
        dominioDiasCaducidad = Long.valueOf(0);
        dominioProrrateoUsuExistente = false;
        dominioInclusionModGrupoAsoc = false;
        dominioPermiteRechazadosAfi = false;
        dominioAcepPolizaInter = false;
        dominioNovExcepcionReqDoc = false;
        dominioSolNovColorOscuro = null;
        dominioSolNovColorClaro = null;
        dominioSolNovLogo = null;
        dominioTramiteEnLinea = false;
        dominioVigenciaRadicacion = false;
        dominiosConIncompatibilidad = null;
        agentexProducto = null;
        reportesDominio = null;
        planT = null;
        productoT = null;
        periodicidades = null;
        roles = null;
        plantillas = null;
        novedades = null;
        grupoAsesores = null;
        grupoAreaMedica = null;
        dominiosIncompatibles = null;
        values = new HashMap<>();
        dominioRepository = Arc.container().select(DominioJpaRepository.class).get();
        agentexProductoRepository = Arc.container().select(AgentexProductoJpaRepository.class).get();
        planesRepository = Arc.container().select(PlanesJpaRepository.class).get();
        productosRepository = Arc.container().select(ProductosJpaRepository.class).get();
        rolRepository = Arc.container().select(RolJpaRepository.class).get();
        grupoAsignacionRepository = Arc.container().select(GrupoAsignacionJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Dominio.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return DominioConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedDominioReqCuesMed = false;
    	values.put("dominioReqCuesMed", getDominioReqCuesMed());
    	modifiedDominioNoCuesMedTras = false;
    	values.put("dominioNoCuesMedTras", getDominioNoCuesMedTras());
    	modifiedDominioNuevaAfiliacion = false;
    	values.put("dominioNuevaAfiliacion", getDominioNuevaAfiliacion());
    	modifiedDominioInclusion = false;
    	values.put("dominioInclusion", getDominioInclusion());
    	modifiedDominioAcepCuesMat = false;
    	values.put("dominioAcepCuesMat", getDominioAcepCuesMat());
    	modifiedDominioAcepCuesNeo = false;
    	values.put("dominioAcepCuesNeo", getDominioAcepCuesNeo());
    	modifiedDominioAcepBBGestante = false;
    	values.put("dominioAcepBBGestante", getDominioAcepBBGestante());
    	modifiedDominioMostrarPreexAnexos = false;
    	values.put("dominioMostrarPreexAnexos", getDominioMostrarPreexAnexos());
    	modifiedDominioMostrarPreexContrato = false;
    	values.put("dominioMostrarPreexContrato", getDominioMostrarPreexContrato());
    	modifiedDominioIgnorarPreexistencias = false;
    	values.put("dominioIgnorarPreexistencias", getDominioIgnorarPreexistencias());
    	modifiedDominioRespClauNombre = false;
    	values.put("dominioRespClauNombre", getDominioRespClauNombre());
    	modifiedDominioRespClauCelula = false;
    	values.put("dominioRespClauCelula", getDominioRespClauCelula());
    	modifiedDominioRespClauExpCelula = false;
    	values.put("dominioRespClauExpCelula", getDominioRespClauExpCelula());
    	modifiedDominioRespClauCargo = false;
    	values.put("dominioRespClauCargo", getDominioRespClauCargo());
    	if (modifiedDominioRespClauFirma) {
    		values.put("dominioRespClauFirma", dominioRespClauFirma);
    		modifiedDominioRespClauFirma = false;
    	}
    	modifiedDominioDiaIniVigencia = false;
    	values.put("dominioDiaIniVigencia", getDominioDiaIniVigencia());
    	modifiedDominioDiaFinVigencia = false;
    	values.put("dominioDiaFinVigencia", getDominioDiaFinVigencia());
    	modifiedDominioDiasCaducidad = false;
    	values.put("dominioDiasCaducidad", getDominioDiasCaducidad());
    	modifiedDominioProrrateoUsuExistente = false;
    	values.put("dominioProrrateoUsuExistente", getDominioProrrateoUsuExistente());
    	modifiedDominioInclusionModGrupoAsoc = false;
    	values.put("dominioInclusionModGrupoAsoc", getDominioInclusionModGrupoAsoc());
    	modifiedDominioPermiteRechazadosAfi = false;
    	values.put("dominioPermiteRechazadosAfi", getDominioPermiteRechazadosAfi());
    	modifiedDominioAcepPolizaInter = false;
    	values.put("dominioAcepPolizaInter", getDominioAcepPolizaInter());
    	modifiedDominioNovExcepcionReqDoc = false;
    	values.put("dominioNovExcepcionReqDoc", getDominioNovExcepcionReqDoc());
    	modifiedDominioSolNovColorOscuro = false;
    	values.put("dominioSolNovColorOscuro", getDominioSolNovColorOscuro());
    	modifiedDominioSolNovColorClaro = false;
    	values.put("dominioSolNovColorClaro", getDominioSolNovColorClaro());
    	modifiedDominioSolNovLogo = false;
    	values.put("dominioSolNovLogo", getDominioSolNovLogo());
    	modifiedDominioTramiteEnLinea = false;
    	values.put("dominioTramiteEnLinea", getDominioTramiteEnLinea());
    	modifiedDominioVigenciaRadicacion = false;
    	values.put("dominioVigenciaRadicacion", getDominioVigenciaRadicacion());
    	modifiedDominiosConIncompatibilidad = false;
    	modifiedAgentexProducto = false;
    	modifiedReportesDominio = false;
    	modifiedPlanT = false;
    	modifiedProductoT = false;
    	modifiedPeriodicidades = false;
    	modifiedRoles = false;
    	modifiedPlantillas = false;
    	modifiedNovedades = false;
    	modifiedGrupoAsesores = false;
    	modifiedGrupoAreaMedica = false;
    	modifiedDominiosIncompatibles = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>DominioOid</code> object that identifies this instance of <code>Dominio</code>.
     * @return <code>DominioOid </code> object that identifies this instance of <code>Dominio</code>
     */
    public DominioOid getOid() {
        return new DominioOid(getDominioNumero());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(DominioConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(DominioConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.DOMINIO)) {
            // Add this class
            activeFacets.add(Constants.DOMINIO);
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

    public String buildICDominio() {
        try {
            return getProductoT().getProductosDescripcion() + " " + getPlanT().getPlanesNombre();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioPIU() {
        try {
            return getProductoT().getProductosDescripcion() + " " + getPlanT().getPlanesNombre() + " " + (getDominioNuevaAfiliacion() != null ? getDominioNuevaAfiliacion().toString() : "") + " " + (getDominioInclusion() != null ? getDominioInclusion().toString() : "") + " " + (getDominioReqCuesMed() != null ? getDominioReqCuesMed().toString() : "") + " " + (getDominioNoCuesMedTras() != null ? getDominioNoCuesMedTras().toString() : "") + " " + (getDominioAcepCuesMat() != null ? getDominioAcepCuesMat().toString() : "") + " " + (getDominioAcepCuesNeo() != null ? getDominioAcepCuesNeo().toString() : "") + " " + (getDominioAcepBBGestante() != null ? getDominioAcepBBGestante().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioIIU() {
        try {
            return getProductoT().getProductosDescripcion() + " " + getPlanT().getPlanesNombre() + " " + (getDominioNuevaAfiliacion() != null ? getDominioNuevaAfiliacion().toString() : "") + " " + (getDominioInclusion() != null ? getDominioInclusion().toString() : "") + " " + (getDominioInclusionModGrupoAsoc() != null ? getDominioInclusionModGrupoAsoc().toString() : "") + " " + (getDominioReqCuesMed() != null ? getDominioReqCuesMed().toString() : "") + " " + (getDominioNoCuesMedTras() != null ? getDominioNoCuesMedTras().toString() : "") + " " + (getDominioAcepCuesMat() != null ? getDominioAcepCuesMat().toString() : "") + " " + (getDominioAcepCuesNeo() != null ? getDominioAcepCuesNeo().toString() : "") + " " + (getDominioAcepBBGestante() != null ? getDominioAcepBBGestante().toString() : "") + " " + (getDominioIgnorarPreexistencias() != null ? getDominioIgnorarPreexistencias().toString() : "") + " " + (getDominioProrrateoUsuExistente() != null ? getDominioProrrateoUsuExistente().toString() : "") + " " + (getDominioDiaIniVigencia() != null ? getDominioDiaIniVigencia().toString() : "") + " " + (getDominioDiaFinVigencia() != null ? getDominioDiaFinVigencia().toString() : "") + " " + (getDominioDiasCaducidad() != null ? getDominioDiasCaducidad().toString() : "") + " " + (getDominioPermiteRechazadosAfi() != null ? getDominioPermiteRechazadosAfi().toString() : "") + " " + (getDominioAcepPolizaInter() != null ? getDominioAcepPolizaInter().toString() : "") + " " + (getDominioMostrarPreexAnexos() != null ? getDominioMostrarPreexAnexos().toString() : "") + " " + (getDominioMostrarPreexContrato() != null ? getDominioMostrarPreexContrato().toString() : "") + " " + (getDominioTramiteEnLinea() != null ? getDominioTramiteEnLinea().toString() : "") + " " + (getDominioVigenciaRadicacion() != null ? getDominioVigenciaRadicacion().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioIIUReportes() {
        try {
            return (getDominioMostrarPreexContrato() != null ? getDominioMostrarPreexContrato().toString() : "") + " " + (getDominioMostrarPreexAnexos() != null ? getDominioMostrarPreexAnexos().toString() : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioFirmaRespClausulado() {
        try {
            return getDominioRespClauNombre() + " " + getDominioRespClauCelula() + " " + getDominioRespClauExpCelula() + " " + getDominioRespClauCargo() + " " + (getDominioRespClauFirma() != null ? Arrays.toString(getDominioRespClauFirma()) : "");
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioSolNovedad() {
        try {
            return (getDominioNovExcepcionReqDoc() != null ? getDominioNovExcepcionReqDoc().toString() : "") + " " + getDominioSolNovColorOscuro() + " " + getDominioSolNovColorClaro() + " " + getDominioSolNovLogo();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioMGrupoAsesores() {
        try {
            return (getGrupoAsesores().getGrupoAsignacionId() != null ? getGrupoAsesores().getGrupoAsignacionId().toString() : "") + " " + getGrupoAsesores().getGrupoAsignacionNombre() + " " + getGrupoAsesores().getGrupoAsignacionDescripcion();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioMGrupoAreaMedica() {
        try {
            return getGrupoAreaMedica().getGrupoAsignacionNombre() + " " + getGrupoAreaMedica().getGrupoAsignacionDescripcion();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioMGruposUsuarios() {
        try {
            return getProductoT().getProductosDescripcion() + " " + getPlanT().getPlanesNombre();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominiosPorAsesor() {
        try {
            return getPlanT().getPlanesCodigoLegal() + " " + getPlanT().getPlanesNombre();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioMLog() {
        try {
            return getProductoT().getProductosDescripcion() + " " + getPlanT().getPlanesNombre();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSDominioDIncompatibles() {
        try {
            return getProductoT().getProductosDescripcion() + " " + getPlanT().getPlanesNombre();
        } catch(Exception e) {
            return "";
        }
    }
}
