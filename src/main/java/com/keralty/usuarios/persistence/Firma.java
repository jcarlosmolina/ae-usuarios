package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.FirmaConstants;
import com.keralty.usuarios.global.RespRegionalConstants;
import com.keralty.usuarios.global.SolicitudConstants;
import com.keralty.usuarios.persistence.oid.FirmaOid;
import com.keralty.usuarios.repository.RespRegionalJpaRepository;
import com.keralty.usuarios.repository.SolicitudJpaRepository;
import com.keralty.usuarios.repository.SolicitudNovedadJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
 * Persistent representation of the <code>Firma</code> model class.
 * <p>
 * Model Class: <code>Firma</code><br>
 */
@Entity(name = FirmaConstants.CLASS_NAME)
@Table(name = FirmaConstants.TBL_NAME)
public class Firma extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient SolicitudNovedadJpaRepository solicitudNovedadRepository;

    @JsonIgnore
    private transient SolicitudJpaRepository solicitudRepository;

    @JsonIgnore
    private transient RespRegionalJpaRepository respRegionalRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = FirmaConstants.FLD_FIRMAIDENTIFICADOR )
    @JsonProperty(value="identificador")
    private Long firmaIdentificador;

    /** Class member attribute. */
    @Column(name = FirmaConstants.FLD_FIRMAIMAGENFIRMA )
    @JsonProperty(value="imagenfirma")
    private byte[] firmaImagenFirma;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFirmaImagenFirma;

    @Transient
    @JsonIgnore
    public boolean firmaImagenFirmaInit = false;

    /** Class member attribute. */
    @Column(name = FirmaConstants.FLD_FIRMALATITUD )
    @JsonProperty(value="latitud")
    private String firmaLatitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFirmaLatitud;

    /** Class member attribute. */
    @Column(name = FirmaConstants.FLD_FIRMALONGITUD )
    @JsonProperty(value="longitud")
    private String firmaLongitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFirmaLongitud;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = FirmaConstants.ROLE_INVNAME_SOLICITUDNOVEDAD)
    @JsonIgnore
    private SolicitudNovedad solicitudNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudNovedad;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = FirmaConstants.ROLE_INVNAME_FAMILIANOVEDAD)
    @JsonIgnore
    private FamiliaNovedad familiaNovedad;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFamiliaNovedad;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = FirmaConstants.ROLE_INVNAME_NOVEDADESCT)
    @JsonIgnore
    private NovedadCT novedadesCT;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedNovedadesCT;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FirmaConstants.FLD_AESOLICITUDESIDSOLICITUD, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD)
    })
    @JsonIgnore
    private Solicitud solicitud;
    /** Related attribute. */
    @Column(name = FirmaConstants.FLD_AESOLICITUDESIDSOLICITUD, insertable = false, updatable = false)
    private Long aESOLICITUDESIDSOLICITUD;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitud;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FirmaConstants.FLD_AESOLICITUDESSOLICITUDSEGUNDAIDSOLICITUD, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD)
    })
    @JsonIgnore
    private Solicitud solicitudSegunda;
    /** Related attribute. */
    @Column(name = FirmaConstants.FLD_AESOLICITUDESSOLICITUDSEGUNDAIDSOLICITUD, insertable = false, updatable = false)
    private Long aESOLICITUDESSolicitudSegundaIDSOLICITUD;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudSegunda;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FirmaConstants.FLD_FUNCIONARIOID, referencedColumnName=RespRegionalConstants.FLD_FUNCIONARIOID)
    })
    @JsonIgnore
    private RespRegional respRegional;
    /** Related attribute. */
    @Column(name = FirmaConstants.FLD_FUNCIONARIOID, insertable = false, updatable = false)
    private Long funcionarioId;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedRespRegional;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=FirmaConstants.FLD_AESOLICITUDESSOLICITUDCONTRATANTEIDSOLICI, referencedColumnName=SolicitudConstants.FLD_AESOLICITUDESIDSOLICITUD)
    })
    @JsonIgnore
    private Solicitud solicitudContratante;
    /** Related attribute. */
    @Column(name = FirmaConstants.FLD_AESOLICITUDESSOLICITUDCONTRATANTEIDSOLICI, insertable = false, updatable = false)
    private Long aESOLICITUDESSolicitudContratanteIDSOLICI;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitudContratante;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Firma() {
        firmaIdentificador = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Firma</code>.
     * @param oid Object Identifier of the instance of <code>Firma</code> to be created.
     * @throws SystemException
     */
    public Firma(FirmaOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            firmaIdentificador = oid.getFirmaIdentificador();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>firmaIdentificador</code> attribute<br>in class <code>Firma</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Firma</code>
     * @return The value of the <code>firmaIdentificador</code> attribute<br>in class <code>Firma</code>.
     */
    public Long getFirmaIdentificador() {
        return firmaIdentificador;
    }

    /**
     * Sets the value of the <code>firmaIdentificador</code> attribute<br>in class <code>Firma</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Firma</code>
     * @param firmaIdentificador The new value of the <code>firmaIdentificador</code> attribute<br>in class <code>Firma</code>.
     */
    public void setFirmaIdentificador(Long firmaIdentificador) {
        this.firmaIdentificador = firmaIdentificador;
    }

   /**
    * Returns the value of the <code>firmaImagenFirma</code> attribute.<br>
    * Model Attribute: <code>firmaImagenFirma</code>. Variable Blob<br>
    * Comments: <br>
    * @return The value of the <code>firmaImagenFirma</code> attribute.
    */

    public byte[] getFirmaImagenFirma()  {
    	byte[] value;
        value =  firmaImagenFirma;
        return value;
    }

   /**
    * Sets the value of the <code>firmaImagenFirma</code> attribute.<br>
    * Model Attribute: <code>firmaImagenFirma</code>. Variable Blob<br>
    * Comments: <br>
    * @param firmaImagenFirma The new value of the <code>firmaImagenFirma</code> attribute.
    */
    public void setFirmaImagenFirma (byte[] firmaImagenFirma) {
        this.firmaImagenFirmaInit = true;
        modifiedFirmaImagenFirma = true;
        this.firmaImagenFirma = firmaImagenFirma;
    }

   /**
    * Returns the value of the <code>modifiedFirmaImagenFirma</code> class property.<br>
    *
    * @return The value of the <code>modifiedFirmaImagenFirma</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedFirmaImagenFirma() {
        return modifiedFirmaImagenFirma;
    }

   /**
    * Sets the value of the <code>modifiedFirmaImagenFirma</code> class property.<br>
    * @param modified The new value of the <code>modifiedFirmaImagenFirma</code>.
    */
    public void setModifiedFirmaImagenFirma(boolean modified) {
        this.modifiedFirmaImagenFirma = modified;
    }

   /**
    * Returns the value of the <code>firmaLatitud</code> attribute.<br>
    * Model Attribute: <code>firmaLatitud</code>. Variable String Size=25<br>
    * Comments: <br>
    * @return The value of the <code>firmaLatitud</code> attribute.
    */

    public String getFirmaLatitud()  {
    	String value;
        value =  firmaLatitud;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>firmaLatitud</code> attribute.<br>
    * Model Attribute: <code>firmaLatitud</code>. Variable String Size=25<br>
    * Comments: <br>
    * @param firmaLatitud The new value of the <code>firmaLatitud</code> attribute.
    */
    public void setFirmaLatitud (String firmaLatitud) {
        modifiedFirmaLatitud = true;
        this.firmaLatitud = firmaLatitud;
    }

   /**
    * Returns the value of the <code>modifiedFirmaLatitud</code> class property.<br>
    *
    * @return The value of the <code>modifiedFirmaLatitud</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedFirmaLatitud() {
        return modifiedFirmaLatitud;
    }

   /**
    * Sets the value of the <code>modifiedFirmaLatitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedFirmaLatitud</code>.
    */
    public void setModifiedFirmaLatitud(boolean modified) {
        this.modifiedFirmaLatitud = modified;
    }

   /**
    * Returns the value of the <code>firmaLongitud</code> attribute.<br>
    * Model Attribute: <code>firmaLongitud</code>. Variable String Size=25<br>
    * Comments: <br>
    * @return The value of the <code>firmaLongitud</code> attribute.
    */

    public String getFirmaLongitud()  {
    	String value;
        value =  firmaLongitud;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>firmaLongitud</code> attribute.<br>
    * Model Attribute: <code>firmaLongitud</code>. Variable String Size=25<br>
    * Comments: <br>
    * @param firmaLongitud The new value of the <code>firmaLongitud</code> attribute.
    */
    public void setFirmaLongitud (String firmaLongitud) {
        modifiedFirmaLongitud = true;
        this.firmaLongitud = firmaLongitud;
    }

   /**
    * Returns the value of the <code>modifiedFirmaLongitud</code> class property.<br>
    *
    * @return The value of the <code>modifiedFirmaLongitud</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedFirmaLongitud() {
        return modifiedFirmaLongitud;
    }

   /**
    * Sets the value of the <code>modifiedFirmaLongitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedFirmaLongitud</code>.
    */
    public void setModifiedFirmaLongitud(boolean modified) {
        this.modifiedFirmaLongitud = modified;
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>SolicitudNovedad</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] SolicitudNovedad 0:1  ------ 0:1  Firma [Firma]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>SolicitudNovedad</code> role.
     */
    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedad() {
        if (solicitudNovedad == null) {
            List<SolicitudNovedad> collection = solicitudNovedadRepository.findByFirma(this);
            if (collection.isEmpty()) {
                solicitudNovedad = null;
            } else {
                solicitudNovedad = (SolicitudNovedad)collection.toArray()[0];
            }
        }
        return (solicitudNovedad == null ? new SolicitudNovedad(null) : solicitudNovedad);
    }

   /**
    * Adds an instance of <code>SolicitudNovedad</code> related through the <code>SolicitudNovedad</code> role.
    * @param solicitudNovedad The instance to add to the <code>SolicitudNovedad</code> role.
    */
    public void add2SolicitudNovedad(SolicitudNovedad solicitudNovedad) {
        this.solicitudNovedad = (solicitudNovedad == null  || solicitudNovedad.isNull() ? null : solicitudNovedad);
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitudNovedad</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitudNovedad</code> has been modified.
    */
    public boolean isModifiedSolicitudNovedad(){
        return modifiedSolicitudNovedad;
    }

    /**
     * Returns the instance of <code>FamiliaNovedad</code> related through the <code>FamiliaNovedad</code> role.
     * Model Relationship:
     * <code>[FamiliaNovedad] FamiliaNovedad 0:1  ------ 0:1  Firma [Firma]</code>
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
     * Returns the instance of <code>NovedadCT</code> related through the <code>NovedadesCT</code> role.
     * Model Relationship:
     * <code>[NovedadCT] NovedadesCT 0:1  ------ 0:1  Firma [Firma]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>NovedadCT</code> related through the <code>NovedadesCT</code> role.
     */
    @JsonIgnore
    public NovedadCT getNovedadesCT() {
        return novedadesCT;
    }

   /**
    * Adds an instance of <code>NovedadCT</code> related through the <code>NovedadesCT</code> role.
    * @param novedadesCT The instance to add to the <code>NovedadesCT</code> role.
    */
    public void add2NovedadesCT(NovedadCT novedadesCT) {
        this.novedadesCT = (novedadesCT == null  || novedadesCT.isNull() ? null : novedadesCT);
    }

   /**
    * This method gets the attribute value <code>modifiedNovedadesCT</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedNovedadesCT</code> has been modified.
    */
    public boolean isModifiedNovedadesCT(){
        return modifiedNovedadesCT;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitud 0:1  ------ 0:1  Firma [Firma]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     */
    @JsonIgnore
    public Solicitud getSolicitud() {
        try {
            if (solicitud != null && solicitud.isNull()) {
                solicitud = null;
            }
        } catch (Exception ex) {
            solicitud = null;
        }
        if (solicitud == null) {
            if (aESOLICITUDESIDSOLICITUD != null) {
                solicitud = solicitudRepository.findById(aESOLICITUDESIDSOLICITUD).orElse(null);
            } else {
                solicitud = null;
            }
        }
        return (solicitud == null ? new Solicitud(null) : solicitud);
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
     * Returns the instance of <code>Solicitud</code> related through the <code>SolicitudSegunda</code> role.
     * Model Relationship:
     * <code>[Solicitud] SolicitudSegunda 0:1  ------ 0:1  SegundaFirma [Firma]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>SolicitudSegunda</code> role.
     */
    @JsonIgnore
    public Solicitud getSolicitudSegunda() {
        try {
            if (solicitudSegunda != null && solicitudSegunda.isNull()) {
                solicitudSegunda = null;
            }
        } catch (Exception ex) {
            solicitudSegunda = null;
        }
        if (solicitudSegunda == null) {
            if (aESOLICITUDESSolicitudSegundaIDSOLICITUD != null) {
                solicitudSegunda = solicitudRepository.findById(aESOLICITUDESSolicitudSegundaIDSOLICITUD).orElse(null);
            } else {
                solicitudSegunda = null;
            }
        }
        return (solicitudSegunda == null ? new Solicitud(null) : solicitudSegunda);
    }

   /**
    * Adds an instance of <code>Solicitud</code> related through the <code>SolicitudSegunda</code> role.
    * @param solicitudSegunda The instance to add to the <code>SolicitudSegunda</code> role.
    */
    public void add2SolicitudSegunda(Solicitud solicitudSegunda) {
        if (solicitudSegunda == null || solicitudSegunda.isNull()) {
            this.modifiedSolicitudSegunda = true;
            this.aESOLICITUDESSolicitudSegundaIDSOLICITUD = null;
        } else {
            this.aESOLICITUDESSolicitudSegundaIDSOLICITUD = solicitudSegunda.getAESOLICITUDESIDSOLICITUD();
        }
        this.solicitudSegunda = (solicitudSegunda == null  || solicitudSegunda.isNull() ? null : solicitudSegunda);
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitudSegunda</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitudSegunda</code> has been modified.
    */
    public boolean isModifiedSolicitudSegunda(){
        return modifiedSolicitudSegunda;
    }

    /**
     * Returns the instance of <code>RespRegional</code> related through the <code>RespRegional</code> role.
     * Model Relationship:
     * <code>[RespRegional] RespRegional 0:1  ------ 0:1  Firma [Firma]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>RespRegional</code> related through the <code>RespRegional</code> role.
     */
    @JsonIgnore
    public RespRegional getRespRegional() {
        try {
            if (respRegional != null && respRegional.isNull()) {
                respRegional = null;
            }
        } catch (Exception ex) {
            respRegional = null;
        }
        if (respRegional == null) {
            if (funcionarioId != null) {
                respRegional = respRegionalRepository.findById(funcionarioId).orElse(null);
            } else {
                respRegional = null;
            }
        }
        return (respRegional == null ? new RespRegional(null) : respRegional);
    }

   /**
    * Adds an instance of <code>RespRegional</code> related through the <code>RespRegional</code> role.
    * @param respRegional The instance to add to the <code>RespRegional</code> role.
    */
    public void add2RespRegional(RespRegional respRegional) {
        if (respRegional == null || respRegional.isNull()) {
            this.modifiedRespRegional = true;
            this.funcionarioId = null;
        } else {
            this.funcionarioId = respRegional.getFuncionarioId();
        }
        this.respRegional = (respRegional == null  || respRegional.isNull() ? null : respRegional);
    }

   /**
    * This method gets the attribute value <code>modifiedRespRegional</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedRespRegional</code> has been modified.
    */
    public boolean isModifiedRespRegional(){
        return modifiedRespRegional;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>SolicitudContratante</code> role.
     * Model Relationship:
     * <code>[Solicitud] SolicitudContratante 0:1  ------ 0:1  FirmaContratanteIncl [Firma]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>SolicitudContratante</code> role.
     */
    @JsonIgnore
    public Solicitud getSolicitudContratante() {
        try {
            if (solicitudContratante != null && solicitudContratante.isNull()) {
                solicitudContratante = null;
            }
        } catch (Exception ex) {
            solicitudContratante = null;
        }
        if (solicitudContratante == null) {
            if (aESOLICITUDESSolicitudContratanteIDSOLICI != null) {
                solicitudContratante = solicitudRepository.findById(aESOLICITUDESSolicitudContratanteIDSOLICI).orElse(null);
            } else {
                solicitudContratante = null;
            }
        }
        return (solicitudContratante == null ? new Solicitud(null) : solicitudContratante);
    }

   /**
    * Adds an instance of <code>Solicitud</code> related through the <code>SolicitudContratante</code> role.
    * @param solicitudContratante The instance to add to the <code>SolicitudContratante</code> role.
    */
    public void add2SolicitudContratante(Solicitud solicitudContratante) {
        if (solicitudContratante == null || solicitudContratante.isNull()) {
            this.modifiedSolicitudContratante = true;
            this.aESOLICITUDESSolicitudContratanteIDSOLICI = null;
        } else {
            this.aESOLICITUDESSolicitudContratanteIDSOLICI = solicitudContratante.getAESOLICITUDESIDSOLICITUD();
        }
        this.solicitudContratante = (solicitudContratante == null  || solicitudContratante.isNull() ? null : solicitudContratante);
    }

   /**
    * This method gets the attribute value <code>modifiedSolicitudContratante</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedSolicitudContratante</code> has been modified.
    */
    public boolean isModifiedSolicitudContratante(){
        return modifiedSolicitudContratante;
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
        firmaImagenFirma = null;
        firmaLatitud = null;
        firmaLongitud = null;
        solicitudNovedad = null;
        familiaNovedad = null;
        novedadesCT = null;
        solicitud = null;
        solicitudSegunda = null;
        respRegional = null;
        solicitudContratante = null;
        values = new HashMap<>();
        solicitudNovedadRepository = Arc.container().select(SolicitudNovedadJpaRepository.class).get();
        solicitudRepository = Arc.container().select(SolicitudJpaRepository.class).get();
        respRegionalRepository = Arc.container().select(RespRegionalJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Firma.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return FirmaConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	if (modifiedFirmaImagenFirma) {
    		values.put("firmaImagenFirma", firmaImagenFirma);
    		modifiedFirmaImagenFirma = false;
    	}
    	modifiedFirmaLatitud = false;
    	values.put("firmaLatitud", getFirmaLatitud());
    	modifiedFirmaLongitud = false;
    	values.put("firmaLongitud", getFirmaLongitud());
    	modifiedSolicitudNovedad = false;
    	modifiedFamiliaNovedad = false;
    	modifiedNovedadesCT = false;
    	modifiedSolicitud = false;
    	modifiedSolicitudSegunda = false;
    	modifiedRespRegional = false;
    	modifiedSolicitudContratante = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>FirmaOid</code> object that identifies this instance of <code>Firma</code>.
     * @return <code>FirmaOid </code> object that identifies this instance of <code>Firma</code>
     */
    public FirmaOid getOid() {
        return new FirmaOid(getFirmaIdentificador());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(FirmaConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(FirmaConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.FIRMA)) {
            // Add this class
            activeFacets.add(Constants.FIRMA);
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


        if (getAgent().isFacetActive(Constants.AGENT_RESPREGIONAL)) {
            RespRegional agentInstance = (RespRegional) getAgent().getAgentInstance(Constants.RESPREGIONAL);

            // Check the HV formula.
            /* 
            RespRegional = agent
            */
            try {
                if (this.getRespRegional().equalsObject(agentInstance)) {
                    returnValue = true;
                }
            } catch (Exception e) {
            	returnValue = false;
            }
        }
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

    public String buildDSFirmaPIUResponsable() {
        try {
            return getRespRegional().getFuncionarioUsuario() + " " + getRespRegional().getFuncionariodrvNombreCompleto() + " " + getRespRegional().getSucursal().getSucursalDescripcion() + " " + getRespRegional().getSucursal().getRegional().getRegionalDescripcion();
        } catch(Exception e) {
            return "";
        }
    }
}
