package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.PlantillaReporteConstants;
import com.keralty.aeusuarios.global.ReportesDominioConstants;
import com.keralty.aeusuarios.persistence.oid.ReportesDominioOid;
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
 * Persistent representation of the <code>ReportesDominio</code> model class.
 * <p>
 * Model Class: <code>ReportesDominio</code><br>
 */
@Entity(name = ReportesDominioConstants.CLASS_NAME)
@Table(name = ReportesDominioConstants.TBL_NAME)
public class ReportesDominio extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /** Embedded Class Identification Function */
    @EmbeddedId
    private ReportesDominioOid oid;

    /** Class identification function. */
    @Column(name = ReportesDominioConstants.FLD_DOMINIONUMERO, insertable = false, updatable = false )
    @JsonProperty(value="numero")
    private Long dominioNumero;

    /** Class identification function. */
    @Column(name = ReportesDominioConstants.FLD_PLANTILLAREPORTEIDPLANTILLAREPORTE, insertable = false, updatable = false )
    @JsonProperty(value="id_plantillareporte")
    private Long plantillaReporteidPlantillaReporte;

    /** Class member attribute. */
    @Column(name = ReportesDominioConstants.FLD_REPORTESDOMINIOENVIARAUTO )
    @JsonProperty(value="enviarauto")
    private Boolean reportesDominioEnviarAuto;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedReportesDominioEnviarAuto;

    /** Class member attribute. */
    @Transient
    @JsonProperty(value="drvfechahasta")
    protected Date reportesDominiodrvFechaHasta;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ReportesDominioConstants.FLD_DOMINIONUMERO, referencedColumnName=DominioConstants.FLD_DOMINIONUMERO, insertable = false, updatable = false)
    })
    @JsonIgnore
    private Dominio dominio;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominio;

    /** Related Class. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name=ReportesDominioConstants.FLD_PLANTILLAREPORTEIDPLANTILLAREPORTE, referencedColumnName=PlantillaReporteConstants.FLD_PLANTILLAREPORTEIDPLANTILLAREPORTE, insertable = false, updatable = false)
    })
    @JsonIgnore
    private PlantillaReporte plantillaReporte;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlantillaReporte;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ReportesDominio() {
        dominioNumero = null;
        plantillaReporteidPlantillaReporte = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ReportesDominio</code>.
     * @param oid Object Identifier of the instance of <code>ReportesDominio</code> to be created.
     * @throws SystemException
     */
    public ReportesDominio(ReportesDominioOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            dominioNumero = oid.getDominioNumero();
            plantillaReporteidPlantillaReporte = oid.getPlantillaReporteidPlantillaReporte();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code> through <code>Dominio</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Dominio</code>
     * @return The value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code> through <code>Dominio</code>.
     */
    public Long getDominioNumero() {
        return dominioNumero;
    }

    /**
     * Sets the value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code> through <code>Dominio</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Dominio</code>
     * @param dominioNumero The new value of the <code>dominioNumero</code> attribute<br>in class <code>Dominio</code> through <code>Dominio</code>.
     */
    public void setDominioNumero(Long dominioNumero) {
        this.dominioNumero = dominioNumero;
    }

    /**
     * Returns the value of the <code>plantillaReporteidPlantillaReporte</code> attribute<br>in class <code>PlantillaReporte</code> through <code>PlantillaReporte</code>.
     * This is part of the identification for this class, which depends on the identification of <code>PlantillaReporte</code>
     * @return The value of the <code>plantillaReporteidPlantillaReporte</code> attribute<br>in class <code>PlantillaReporte</code> through <code>PlantillaReporte</code>.
     */
    public Long getPlantillaReporteidPlantillaReporte() {
        return plantillaReporteidPlantillaReporte;
    }

    /**
     * Sets the value of the <code>plantillaReporteidPlantillaReporte</code> attribute<br>in class <code>PlantillaReporte</code> through <code>PlantillaReporte</code>.
     * This is part of the identification for this class, which depends on the identification of <code>PlantillaReporte</code>
     * @param plantillaReporteidPlantillaReporte The new value of the <code>plantillaReporteidPlantillaReporte</code> attribute<br>in class <code>PlantillaReporte</code> through <code>PlantillaReporte</code>.
     */
    public void setPlantillaReporteidPlantillaReporte(Long plantillaReporteidPlantillaReporte) {
        this.plantillaReporteidPlantillaReporte = plantillaReporteidPlantillaReporte;
    }

   /**
    * Returns the value of the <code>reportesDominioEnviarAuto</code> attribute.<br>
    * Model Attribute: <code>reportesDominioEnviarAuto</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>reportesDominioEnviarAuto</code> attribute.
    */

    public Boolean getReportesDominioEnviarAuto()  {
    	Boolean value;
        value =  reportesDominioEnviarAuto;
        return value;
    }

   /**
    * Sets the value of the <code>reportesDominioEnviarAuto</code> attribute.<br>
    * Model Attribute: <code>reportesDominioEnviarAuto</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param reportesDominioEnviarAuto The new value of the <code>reportesDominioEnviarAuto</code> attribute.
    */
    public void setReportesDominioEnviarAuto (Boolean reportesDominioEnviarAuto) {
        modifiedReportesDominioEnviarAuto = true;
        this.reportesDominioEnviarAuto = reportesDominioEnviarAuto;
    }

   /**
    * Sets the value of the <code>modifiedReportesDominioEnviarAuto</code> class property.<br>
    * @param modified The new value of the <code>modifiedReportesDominioEnviarAuto</code>.
    */
    public void setModifiedReportesDominioEnviarAuto(boolean modified) {
        this.modifiedReportesDominioEnviarAuto = modified;
    }

   /**
    * Returns the value of the <code>reportesDominiodrvFechaHasta</code> attribute.<br>
    * Model Attribute: <code>reportesDominiodrvFechaHasta</code>. Variable Date<br>
    * Comments: Devuelve la fecha fin de validez del reporte para este Dominio.
Si en el Dominio de mi tipo y fecha posterior a la mia no hay ninguno  entonces asignamos una fecha fin muy lejana, si no, es la menor de las fechas siguientes de mi mismo tipo<br>
    * @return The value of the <code>reportesDominiodrvFechaHasta</code> attribute.
    */

    public Date getReportesDominiodrvFechaHasta()  {
    	Date value;
        try {
            value = reportesDominiodrvFechaHastaDerivations();
        } catch (Exception e) {
            value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error("Definition Class: ReportesDominio, Attribute: reportesDominiodrvFechaHasta");
        }
        return value;
    }

    /**
     * Returns the instance of <code>Dominio</code> related through the <code>Dominio</code> role.
     * Model Relationship:
     * <code>[Dominio] Dominio 1:1  ------ 0:M  ReportesDominio [ReportesDominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>Dominio</code> role.
     */
    @JsonIgnore
    public Dominio getDominio() {
        return dominio;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>Dominio</code> role.
    * @param dominio The instance to add to the <code>Dominio</code> role.
    */
    public void add2Dominio(Dominio dominio) {
        if (dominio == null || dominio.isNull()) {
            this.modifiedDominio = true;
            this.dominioNumero = null;
        } else {
            this.dominioNumero = dominio.getDominioNumero();
        }
        this.dominio = (dominio == null  || dominio.isNull() ? null : dominio);
    }

   /**
    * This method gets the attribute value <code>modifiedDominio</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominio</code> has been modified.
    */
    public boolean isModifiedDominio(){
        return modifiedDominio;
    }

    /**
     * Returns the instance of <code>PlantillaReporte</code> related through the <code>PlantillaReporte</code> role.
     * Model Relationship:
     * <code>[PlantillaReporte] PlantillaReporte 1:1  ------ 0:M  ReportesDominio [ReportesDominio]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>PlantillaReporte</code> related through the <code>PlantillaReporte</code> role.
     */
    @JsonIgnore
    public PlantillaReporte getPlantillaReporte() {
        return plantillaReporte;
    }

   /**
    * Adds an instance of <code>PlantillaReporte</code> related through the <code>PlantillaReporte</code> role.
    * @param plantillaReporte The instance to add to the <code>PlantillaReporte</code> role.
    */
    public void add2PlantillaReporte(PlantillaReporte plantillaReporte) {
        if (plantillaReporte == null || plantillaReporte.isNull()) {
            this.modifiedPlantillaReporte = true;
            this.plantillaReporteidPlantillaReporte = null;
        } else {
            this.plantillaReporteidPlantillaReporte = plantillaReporte.getPlantillaReporteidPlantillaReporte();
        }
        this.plantillaReporte = (plantillaReporte == null  || plantillaReporte.isNull() ? null : plantillaReporte);
    }

   /**
    * This method gets the attribute value <code>modifiedPlantillaReporte</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPlantillaReporte</code> has been modified.
    */
    public boolean isModifiedPlantillaReporte(){
        return modifiedPlantillaReporte;
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
     * Returns the value of the <code>reportesDominiodrvFechaHasta</code> derived attribute.
     *
     * @return Value of the <code>reportesDominiodrvFechaHasta</code> derived attribute.
     */
    public Date reportesDominiodrvFechaHastaDerivations() {
        return reportesDominiodrvFechaHasta;
    }    
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        reportesDominioEnviarAuto = false;
        dominio = null;
        plantillaReporte = null;
        values = new HashMap<>();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return ReportesDominio.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ReportesDominioConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedReportesDominioEnviarAuto = false;
    	values.put("reportesDominioEnviarAuto", getReportesDominioEnviarAuto());
    	modifiedDominio = false;
    	modifiedPlantillaReporte = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
            reportesDominiodrvFechaHasta = null;
    }

    /**
     * Returns the <code>ReportesDominioOid</code> object that identifies this instance of <code>ReportesDominio</code>.
     * @return <code>ReportesDominioOid </code> object that identifies this instance of <code>ReportesDominio</code>
     */
    public ReportesDominioOid getOid() {
        return new ReportesDominioOid(getDominioNumero(), getPlantillaReporteidPlantillaReporte());
    }

    /**
     * Sets the <code>ReportesDominioOid</code> object that identifies this instance of <code>ReportesDominio</code>.
     */    
    public void setOid(ReportesDominioOid oid) {
        this.oid = oid;
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ReportesDominioConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(ReportesDominioConstants.ROLE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.REPORTESDOMINIO)) {
            // Add this class
            activeFacets.add(Constants.REPORTESDOMINIO);
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
