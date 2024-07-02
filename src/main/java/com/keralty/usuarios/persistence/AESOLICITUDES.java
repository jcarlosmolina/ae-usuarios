package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.AESOLICITUDESConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.EstadoContratoConstants;
import com.keralty.usuarios.global.PlanesConstants;
import com.keralty.usuarios.global.ProductosConstants;
import com.keralty.usuarios.persistence.oid.AESOLICITUDESOid;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>AESOLICITUDES</code> model class.
 * <p>
 * Model Class: <code>AESOLICITUDES</code><br>
 */
@Entity(name = AESOLICITUDESConstants.CLASS_NAME)
@Table(name = AESOLICITUDESConstants.TBL_NAME)
public class AESOLICITUDES extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESIDSOLICITUD )
    @JsonProperty(value="id_solicitud")
    private Long aESOLICITUDESIDSOLICITUD;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESNUMEROSOLICITUD )
    @JsonProperty(value="numero_solicitud")
    private String aESOLICITUDESNUMEROSOLICITUD;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESNUMEROSOLICITUD;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESSWESTADO )
    @JsonProperty(value="sw_estado")
    private String aESOLICITUDESSWESTADO;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESSWESTADO;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESFECHAASIGNACION )
    @JsonProperty(value="fecha_asignacion")
    private Date aESOLICITUDESFECHAASIGNACION;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESFECHAASIGNACION;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESCDMOTANU )
    @JsonProperty(value="cdmotanu")
    private String aESOLICITUDESCDMOTANU;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESCDMOTANU;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESCDMOTDEV )
    @JsonProperty(value="cdmotdev")
    private String aESOLICITUDESCDMOTDEV;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESCDMOTDEV;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESFESOLICI )
    @JsonProperty(value="fesolici")
    private Date aESOLICITUDESFESOLICI;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESFESOLICI;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESLOGIN )
    @JsonProperty(value="login")
    private String aESOLICITUDESLOGIN;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESLOGIN;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESOBSERVACION )
    @JsonProperty(value="observacion")
    private String aESOLICITUDESOBSERVACION;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESOBSERVACION;

    /** Class member attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_AESOLICITUDESTIPOSOLICITUD )
    @JsonProperty(value="tipo_solicitud")
    private String aESOLICITUDESTIPOSOLICITUD;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDESTIPOSOLICITUD;

    /** Related Class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = AESOLICITUDESConstants.ROLE_INVNAME_SOLICITUD)
    @JsonIgnore
    private Solicitud solicitud;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedSolicitud;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=AESOLICITUDESConstants.FLD_PRODUCTOSPRODUCTO, referencedColumnName=ProductosConstants.FLD_PRODUCTOSPRODUCTO)
    })
    @JsonIgnore
    private Productos productoT;
    /** Related attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_PRODUCTOSPRODUCTO, insertable = false, updatable = false)
    private Long productosProducto;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductoT;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=AESOLICITUDESConstants.FLD_PLANESPLAN, referencedColumnName=PlanesConstants.FLD_PLANESPLAN)
    })
    @JsonIgnore
    private Planes planT;
    /** Related attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_PLANESPLAN, insertable = false, updatable = false)
    private Long planesPlan;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlanT;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=AESOLICITUDESConstants.FLD_ESTADOCONTRATOCODIGO, referencedColumnName=EstadoContratoConstants.FLD_ESTADOCONTRATOCODIGO)
    })
    @JsonIgnore
    private EstadoContrato eSTADOSOLICITUD;
    /** Related attribute. */
    @Column(name = AESOLICITUDESConstants.FLD_ESTADOCONTRATOCODIGO, insertable = false, updatable = false)
    private Long estadoContratoCodigo;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedESTADOSOLICITUD;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public AESOLICITUDES() {
        aESOLICITUDESIDSOLICITUD = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>AESOLICITUDES</code>.
     * @param oid Object Identifier of the instance of <code>AESOLICITUDES</code> to be created.
     * @throws SystemException
     */
    public AESOLICITUDES(AESOLICITUDESOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            aESOLICITUDESIDSOLICITUD = oid.getAESOLICITUDESIDSOLICITUD();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @return The value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code>.
     */
    public Long getAESOLICITUDESIDSOLICITUD() {
        return aESOLICITUDESIDSOLICITUD;
    }

    /**
     * Sets the value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code>.
     * This is part of the identification for this class, which depends on the identification of <code>AESOLICITUDES</code>
     * @param aESOLICITUDESIDSOLICITUD The new value of the <code>aESOLICITUDESIDSOLICITUD</code> attribute<br>in class <code>AESOLICITUDES</code>.
     */
    public void setAESOLICITUDESIDSOLICITUD(Long aESOLICITUDESIDSOLICITUD) {
        this.aESOLICITUDESIDSOLICITUD = aESOLICITUDESIDSOLICITUD;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESNUMEROSOLICITUD</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESNUMEROSOLICITUD</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>aESOLICITUDESNUMEROSOLICITUD</code> attribute.
    */

    public String getAESOLICITUDESNUMEROSOLICITUD()  {
    	String value;
        value =  aESOLICITUDESNUMEROSOLICITUD;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESNUMEROSOLICITUD</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESNUMEROSOLICITUD</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param aESOLICITUDESNUMEROSOLICITUD The new value of the <code>aESOLICITUDESNUMEROSOLICITUD</code> attribute.
    */
    public void setAESOLICITUDESNUMEROSOLICITUD (String aESOLICITUDESNUMEROSOLICITUD) {
        modifiedAESOLICITUDESNUMEROSOLICITUD = true;
        this.aESOLICITUDESNUMEROSOLICITUD = aESOLICITUDESNUMEROSOLICITUD;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESNUMEROSOLICITUD</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESNUMEROSOLICITUD</code>.
    */
    public void setModifiedAESOLICITUDESNUMEROSOLICITUD(boolean modified) {
        this.modifiedAESOLICITUDESNUMEROSOLICITUD = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESSWESTADO</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESSWESTADO</code>. Variable String Size=2<br>
    * Comments: Habilitada( S) o no habiliatda (N)<br>
    * @return The value of the <code>aESOLICITUDESSWESTADO</code> attribute.
    */

    public String getAESOLICITUDESSWESTADO()  {
    	String value;
        value =  aESOLICITUDESSWESTADO;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESSWESTADO</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESSWESTADO</code>. Variable String Size=2<br>
    * Comments: Habilitada( S) o no habiliatda (N)<br>
    * @param aESOLICITUDESSWESTADO The new value of the <code>aESOLICITUDESSWESTADO</code> attribute.
    */
    public void setAESOLICITUDESSWESTADO (String aESOLICITUDESSWESTADO) {
        modifiedAESOLICITUDESSWESTADO = true;
        this.aESOLICITUDESSWESTADO = aESOLICITUDESSWESTADO;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESSWESTADO</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESSWESTADO</code>.
    */
    public void setModifiedAESOLICITUDESSWESTADO(boolean modified) {
        this.modifiedAESOLICITUDESSWESTADO = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESFECHAASIGNACION</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESFECHAASIGNACION</code>. Variable Date<br>
    * Comments: Fecha en que se actualiza el estado de la solicitud<br>
    * @return The value of the <code>aESOLICITUDESFECHAASIGNACION</code> attribute.
    */

    public Date getAESOLICITUDESFECHAASIGNACION()  {
    	Date value;
        value =  aESOLICITUDESFECHAASIGNACION;
        return value;
    }

   /**
    * Sets the value of the <code>aESOLICITUDESFECHAASIGNACION</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESFECHAASIGNACION</code>. Variable Date<br>
    * Comments: Fecha en que se actualiza el estado de la solicitud<br>
    * @param aESOLICITUDESFECHAASIGNACION The new value of the <code>aESOLICITUDESFECHAASIGNACION</code> attribute.
    */
    public void setAESOLICITUDESFECHAASIGNACION (Date aESOLICITUDESFECHAASIGNACION) {
        modifiedAESOLICITUDESFECHAASIGNACION = true;
        this.aESOLICITUDESFECHAASIGNACION = aESOLICITUDESFECHAASIGNACION;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESFECHAASIGNACION</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESFECHAASIGNACION</code>.
    */
    public void setModifiedAESOLICITUDESFECHAASIGNACION(boolean modified) {
        this.modifiedAESOLICITUDESFECHAASIGNACION = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESCDMOTANU</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESCDMOTANU</code>. Variable String Size=250<br>
    * Comments: Descipción de la anulación<br>
    * @return The value of the <code>aESOLICITUDESCDMOTANU</code> attribute.
    */

    public String getAESOLICITUDESCDMOTANU()  {
    	String value;
        value =  aESOLICITUDESCDMOTANU;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESCDMOTANU</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESCDMOTANU</code>. Variable String Size=250<br>
    * Comments: Descipción de la anulación<br>
    * @param aESOLICITUDESCDMOTANU The new value of the <code>aESOLICITUDESCDMOTANU</code> attribute.
    */
    public void setAESOLICITUDESCDMOTANU (String aESOLICITUDESCDMOTANU) {
        modifiedAESOLICITUDESCDMOTANU = true;
        this.aESOLICITUDESCDMOTANU = aESOLICITUDESCDMOTANU;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESCDMOTANU</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESCDMOTANU</code>.
    */
    public void setModifiedAESOLICITUDESCDMOTANU(boolean modified) {
        this.modifiedAESOLICITUDESCDMOTANU = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESCDMOTDEV</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESCDMOTDEV</code>. Variable String Size=250<br>
    * Comments: Descripcion de la devolución<br>
    * @return The value of the <code>aESOLICITUDESCDMOTDEV</code> attribute.
    */

    public String getAESOLICITUDESCDMOTDEV()  {
    	String value;
        value =  aESOLICITUDESCDMOTDEV;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESCDMOTDEV</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESCDMOTDEV</code>. Variable String Size=250<br>
    * Comments: Descripcion de la devolución<br>
    * @param aESOLICITUDESCDMOTDEV The new value of the <code>aESOLICITUDESCDMOTDEV</code> attribute.
    */
    public void setAESOLICITUDESCDMOTDEV (String aESOLICITUDESCDMOTDEV) {
        modifiedAESOLICITUDESCDMOTDEV = true;
        this.aESOLICITUDESCDMOTDEV = aESOLICITUDESCDMOTDEV;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESCDMOTDEV</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESCDMOTDEV</code>.
    */
    public void setModifiedAESOLICITUDESCDMOTDEV(boolean modified) {
        this.modifiedAESOLICITUDESCDMOTDEV = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESFESOLICI</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESFESOLICI</code>. Variable Date<br>
    * Comments: Fecha en que nace la solicitud<br>
    * @return The value of the <code>aESOLICITUDESFESOLICI</code> attribute.
    */

    public Date getAESOLICITUDESFESOLICI()  {
    	Date value;
        value =  aESOLICITUDESFESOLICI;
        return value;
    }

   /**
    * Sets the value of the <code>aESOLICITUDESFESOLICI</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESFESOLICI</code>. Variable Date<br>
    * Comments: Fecha en que nace la solicitud<br>
    * @param aESOLICITUDESFESOLICI The new value of the <code>aESOLICITUDESFESOLICI</code> attribute.
    */
    public void setAESOLICITUDESFESOLICI (Date aESOLICITUDESFESOLICI) {
        modifiedAESOLICITUDESFESOLICI = true;
        this.aESOLICITUDESFESOLICI = aESOLICITUDESFESOLICI;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESFESOLICI</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESFESOLICI</code>.
    */
    public void setModifiedAESOLICITUDESFESOLICI(boolean modified) {
        this.modifiedAESOLICITUDESFESOLICI = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESLOGIN</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESLOGIN</code>. Variable String Size=20<br>
    * Comments: Usuario que realiza la operacion<br>
    * @return The value of the <code>aESOLICITUDESLOGIN</code> attribute.
    */

    public String getAESOLICITUDESLOGIN()  {
    	String value;
        value =  aESOLICITUDESLOGIN;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESLOGIN</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESLOGIN</code>. Variable String Size=20<br>
    * Comments: Usuario que realiza la operacion<br>
    * @param aESOLICITUDESLOGIN The new value of the <code>aESOLICITUDESLOGIN</code> attribute.
    */
    public void setAESOLICITUDESLOGIN (String aESOLICITUDESLOGIN) {
        modifiedAESOLICITUDESLOGIN = true;
        this.aESOLICITUDESLOGIN = aESOLICITUDESLOGIN;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESLOGIN</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESLOGIN</code>.
    */
    public void setModifiedAESOLICITUDESLOGIN(boolean modified) {
        this.modifiedAESOLICITUDESLOGIN = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESOBSERVACION</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESOBSERVACION</code>. Variable String Size=500<br>
    * Comments: Observaciones a la solicitud<br>
    * @return The value of the <code>aESOLICITUDESOBSERVACION</code> attribute.
    */

    public String getAESOLICITUDESOBSERVACION()  {
    	String value;
        value =  aESOLICITUDESOBSERVACION;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESOBSERVACION</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESOBSERVACION</code>. Variable String Size=500<br>
    * Comments: Observaciones a la solicitud<br>
    * @param aESOLICITUDESOBSERVACION The new value of the <code>aESOLICITUDESOBSERVACION</code> attribute.
    */
    public void setAESOLICITUDESOBSERVACION (String aESOLICITUDESOBSERVACION) {
        modifiedAESOLICITUDESOBSERVACION = true;
        this.aESOLICITUDESOBSERVACION = aESOLICITUDESOBSERVACION;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESOBSERVACION</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESOBSERVACION</code>.
    */
    public void setModifiedAESOLICITUDESOBSERVACION(boolean modified) {
        this.modifiedAESOLICITUDESOBSERVACION = modified;
    }

   /**
    * Returns the value of the <code>aESOLICITUDESTIPOSOLICITUD</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESTIPOSOLICITUD</code>. Variable String Size=1<br>
    * Comments: F ( fisica) E ( electronica)<br>
    * @return The value of the <code>aESOLICITUDESTIPOSOLICITUD</code> attribute.
    */

    public String getAESOLICITUDESTIPOSOLICITUD()  {
    	String value;
        value =  aESOLICITUDESTIPOSOLICITUD;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>aESOLICITUDESTIPOSOLICITUD</code> attribute.<br>
    * Model Attribute: <code>aESOLICITUDESTIPOSOLICITUD</code>. Variable String Size=1<br>
    * Comments: F ( fisica) E ( electronica)<br>
    * @param aESOLICITUDESTIPOSOLICITUD The new value of the <code>aESOLICITUDESTIPOSOLICITUD</code> attribute.
    */
    public void setAESOLICITUDESTIPOSOLICITUD (String aESOLICITUDESTIPOSOLICITUD) {
        modifiedAESOLICITUDESTIPOSOLICITUD = true;
        this.aESOLICITUDESTIPOSOLICITUD = aESOLICITUDESTIPOSOLICITUD;
    }

   /**
    * Sets the value of the <code>modifiedAESOLICITUDESTIPOSOLICITUD</code> class property.<br>
    * @param modified The new value of the <code>modifiedAESOLICITUDESTIPOSOLICITUD</code>.
    */
    public void setModifiedAESOLICITUDESTIPOSOLICITUD(boolean modified) {
        this.modifiedAESOLICITUDESTIPOSOLICITUD = modified;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitud</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitud 0:1  ------ 1:1  AESOLICITUDES [AESOLICITUDES]</code>
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
     * Returns the instance of <code>Productos</code> related through the <code>ProductoT</code> role.
     * Model Relationship:
     * <code>[Productos] ProductoT 1:1  ------ 0:M  AESOLICITUDES [AESOLICITUDES]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Productos</code> related through the <code>ProductoT</code> role.
     */
    @JsonIgnore
    public Productos getProductoT() {
        return productoT;
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
     * Returns the instance of <code>Planes</code> related through the <code>PlanT</code> role.
     * Model Relationship:
     * <code>[Planes] PlanT 0:1  ------ 0:M  AESOLICITUDES [AESOLICITUDES]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Planes</code> related through the <code>PlanT</code> role.
     */
    @JsonIgnore
    public Planes getPlanT() {
        return planT;
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
     * Returns the instance of <code>EstadoContrato</code> related through the <code>ESTADOSOLICITUD</code> role.
     * Model Relationship:
     * <code>[EstadoContrato] ESTADOSOLICITUD 0:1  ------ 0:M  AESOLICITUDES [AESOLICITUDES]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>EstadoContrato</code> related through the <code>ESTADOSOLICITUD</code> role.
     */
    @JsonIgnore
    public EstadoContrato getESTADOSOLICITUD() {
        return eSTADOSOLICITUD;
    }

   /**
    * Adds an instance of <code>EstadoContrato</code> related through the <code>ESTADOSOLICITUD</code> role.
    * @param eSTADOSOLICITUD The instance to add to the <code>ESTADOSOLICITUD</code> role.
    */
    public void add2ESTADOSOLICITUD(EstadoContrato eSTADOSOLICITUD) {
        if (eSTADOSOLICITUD == null || eSTADOSOLICITUD.isNull()) {
            this.modifiedESTADOSOLICITUD = true;
            this.estadoContratoCodigo = null;
        } else {
            this.estadoContratoCodigo = eSTADOSOLICITUD.getEstadoContratoCodigo();
        }
        this.eSTADOSOLICITUD = (eSTADOSOLICITUD == null  || eSTADOSOLICITUD.isNull() ? null : eSTADOSOLICITUD);
    }

   /**
    * This method gets the attribute value <code>modifiedESTADOSOLICITUD</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedESTADOSOLICITUD</code> has been modified.
    */
    public boolean isModifiedESTADOSOLICITUD(){
        return modifiedESTADOSOLICITUD;
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
        aESOLICITUDESNUMEROSOLICITUD = null;
        aESOLICITUDESSWESTADO = null;
        aESOLICITUDESFECHAASIGNACION = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        aESOLICITUDESCDMOTANU = null;
        aESOLICITUDESCDMOTDEV = null;
        aESOLICITUDESFESOLICI = null;
        aESOLICITUDESLOGIN = null;
        aESOLICITUDESOBSERVACION = null;
        aESOLICITUDESTIPOSOLICITUD = null;
        solicitud = null;
        productoT = null;
        planT = null;
        eSTADOSOLICITUD = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return AESOLICITUDES.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return AESOLICITUDESConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedAESOLICITUDESNUMEROSOLICITUD = false;
    	values.put("aESOLICITUDESNUMEROSOLICITUD", getAESOLICITUDESNUMEROSOLICITUD());
    	modifiedAESOLICITUDESSWESTADO = false;
    	values.put("aESOLICITUDESSWESTADO", getAESOLICITUDESSWESTADO());
    	modifiedAESOLICITUDESFECHAASIGNACION = false;
    	values.put("aESOLICITUDESFECHAASIGNACION", getAESOLICITUDESFECHAASIGNACION());
    	modifiedAESOLICITUDESCDMOTANU = false;
    	values.put("aESOLICITUDESCDMOTANU", getAESOLICITUDESCDMOTANU());
    	modifiedAESOLICITUDESCDMOTDEV = false;
    	values.put("aESOLICITUDESCDMOTDEV", getAESOLICITUDESCDMOTDEV());
    	modifiedAESOLICITUDESFESOLICI = false;
    	values.put("aESOLICITUDESFESOLICI", getAESOLICITUDESFESOLICI());
    	modifiedAESOLICITUDESLOGIN = false;
    	values.put("aESOLICITUDESLOGIN", getAESOLICITUDESLOGIN());
    	modifiedAESOLICITUDESOBSERVACION = false;
    	values.put("aESOLICITUDESOBSERVACION", getAESOLICITUDESOBSERVACION());
    	modifiedAESOLICITUDESTIPOSOLICITUD = false;
    	values.put("aESOLICITUDESTIPOSOLICITUD", getAESOLICITUDESTIPOSOLICITUD());
    	modifiedSolicitud = false;
    	modifiedProductoT = false;
    	modifiedPlanT = false;
    	modifiedESTADOSOLICITUD = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>AESOLICITUDESOid</code> object that identifies this instance of <code>AESOLICITUDES</code>.
     * @return <code>AESOLICITUDESOid </code> object that identifies this instance of <code>AESOLICITUDES</code>
     */
    public AESOLICITUDESOid getOid() {
        return new AESOLICITUDESOid(getAESOLICITUDESIDSOLICITUD());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(AESOLICITUDESConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(AESOLICITUDESConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.AESOLICITUDES)) {
            // Add this class
            activeFacets.add(Constants.AESOLICITUDES);
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
        if (getAgent().isFacetActive(Constants.FUNCIONARIO) || getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.RESPREGIONAL) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO) || getAgent().isFacetActive(Constants.ANONIMO)) {
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
