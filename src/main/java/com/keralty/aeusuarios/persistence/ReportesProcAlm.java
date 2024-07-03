package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.ReportesProcAlmConstants;
import com.keralty.aeusuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.aeusuarios.repository.FuncionarioJpaRepository;
import com.keralty.aeusuarios.repository.ReportesProcAlmJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>ReportesProcAlm</code> model class.
 * <p>
 * Model Class: <code>ReportesProcAlm</code><br>
 */
@Entity(name = ReportesProcAlmConstants.CLASS_NAME)
@Table(name = ReportesProcAlmConstants.TBL_NAME)
public class ReportesProcAlm extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient ReportesProcAlmJpaRepository reportesProcAlmRepository;

    @JsonIgnore
    private transient FuncionarioJpaRepository funcionarioRepository;

    /** Class identification function. */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = ReportesProcAlmConstants.FLD_REPORTESPROCALMIDREPORTE )
    @JsonProperty(value="id_reporte")
    private Long reportesProcAlmidReporte;

    /** Class member attribute. */
    @Column(name = ReportesProcAlmConstants.FLD_REPORTESPROCALMDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String reportesProcAlmDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedReportesProcAlmDescripcion;

    /** Class member attribute. */
    @Column(name = ReportesProcAlmConstants.FLD_REPORTESPROCALMNOMBREPROC )
    @JsonProperty(value="nombreproc")
    private String reportesProcAlmNombreProc;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedReportesProcAlmNombreProc;

    /** Class member attribute. */
    @Column(name = ReportesProcAlmConstants.FLD_REPORTESPROCALMNOMBREFICHERO )
    @JsonProperty(value="nombrefichero")
    private String reportesProcAlmNombreFichero;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedReportesProcAlmNombreFichero;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_REPORTESPROCALMFUNCIONARIO,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMREPORTESPROCALMFUNCIONARIO_REPORTESPROCALMIDREPORTE, referencedColumnName=ReportesProcAlmConstants.FLD_REPORTESPROCALMIDREPORTE)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMREPORTESPROCALMFUNCIONARIO_FUNCIONARIOID, referencedColumnName=FuncionarioConstants.FLD_FUNCIONARIOID)
    })
    @JsonIgnore
    private Collection <Funcionario> funcionarios;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedFuncionarios;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public ReportesProcAlm() {
        reportesProcAlmidReporte = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>ReportesProcAlm</code>.
     * @param oid Object Identifier of the instance of <code>ReportesProcAlm</code> to be created.
     * @throws SystemException
     */
    public ReportesProcAlm(ReportesProcAlmOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            reportesProcAlmidReporte = oid.getReportesProcAlmidReporte();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>reportesProcAlmidReporte</code> attribute<br>in class <code>ReportesProcAlm</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ReportesProcAlm</code>
     * @return The value of the <code>reportesProcAlmidReporte</code> attribute<br>in class <code>ReportesProcAlm</code>.
     */
    public Long getReportesProcAlmidReporte() {
        return reportesProcAlmidReporte;
    }

    /**
     * Sets the value of the <code>reportesProcAlmidReporte</code> attribute<br>in class <code>ReportesProcAlm</code>.
     * This is part of the identification for this class, which depends on the identification of <code>ReportesProcAlm</code>
     * @param reportesProcAlmidReporte The new value of the <code>reportesProcAlmidReporte</code> attribute<br>in class <code>ReportesProcAlm</code>.
     */
    public void setReportesProcAlmidReporte(Long reportesProcAlmidReporte) {
        this.reportesProcAlmidReporte = reportesProcAlmidReporte;
    }

   /**
    * Returns the value of the <code>reportesProcAlmDescripcion</code> attribute.<br>
    * Model Attribute: <code>reportesProcAlmDescripcion</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>reportesProcAlmDescripcion</code> attribute.
    */

    public String getReportesProcAlmDescripcion()  {
    	String value;
        value =  reportesProcAlmDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>reportesProcAlmDescripcion</code> attribute.<br>
    * Model Attribute: <code>reportesProcAlmDescripcion</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param reportesProcAlmDescripcion The new value of the <code>reportesProcAlmDescripcion</code> attribute.
    */
    public void setReportesProcAlmDescripcion (String reportesProcAlmDescripcion) {
        modifiedReportesProcAlmDescripcion = true;
        this.reportesProcAlmDescripcion = reportesProcAlmDescripcion;
    }

   /**
    * Returns the value of the <code>modifiedReportesProcAlmDescripcion</code> class property.<br>
    *
    * @return The value of the <code>modifiedReportesProcAlmDescripcion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedReportesProcAlmDescripcion() {
        return modifiedReportesProcAlmDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedReportesProcAlmDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedReportesProcAlmDescripcion</code>.
    */
    public void setModifiedReportesProcAlmDescripcion(boolean modified) {
        this.modifiedReportesProcAlmDescripcion = modified;
    }

   /**
    * Returns the value of the <code>reportesProcAlmNombreProc</code> attribute.<br>
    * Model Attribute: <code>reportesProcAlmNombreProc</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>reportesProcAlmNombreProc</code> attribute.
    */

    public String getReportesProcAlmNombreProc()  {
    	String value;
        value =  reportesProcAlmNombreProc;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>reportesProcAlmNombreProc</code> attribute.<br>
    * Model Attribute: <code>reportesProcAlmNombreProc</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param reportesProcAlmNombreProc The new value of the <code>reportesProcAlmNombreProc</code> attribute.
    */
    public void setReportesProcAlmNombreProc (String reportesProcAlmNombreProc) {
        modifiedReportesProcAlmNombreProc = true;
        this.reportesProcAlmNombreProc = reportesProcAlmNombreProc;
    }

   /**
    * Returns the value of the <code>modifiedReportesProcAlmNombreProc</code> class property.<br>
    *
    * @return The value of the <code>modifiedReportesProcAlmNombreProc</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedReportesProcAlmNombreProc() {
        return modifiedReportesProcAlmNombreProc;
    }

   /**
    * Sets the value of the <code>modifiedReportesProcAlmNombreProc</code> class property.<br>
    * @param modified The new value of the <code>modifiedReportesProcAlmNombreProc</code>.
    */
    public void setModifiedReportesProcAlmNombreProc(boolean modified) {
        this.modifiedReportesProcAlmNombreProc = modified;
    }

   /**
    * Returns the value of the <code>reportesProcAlmNombreFichero</code> attribute.<br>
    * Model Attribute: <code>reportesProcAlmNombreFichero</code>. Variable String Size=200<br>
    * Comments: <br>
    * @return The value of the <code>reportesProcAlmNombreFichero</code> attribute.
    */

    public String getReportesProcAlmNombreFichero()  {
    	String value;
        value =  reportesProcAlmNombreFichero;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>reportesProcAlmNombreFichero</code> attribute.<br>
    * Model Attribute: <code>reportesProcAlmNombreFichero</code>. Variable String Size=200<br>
    * Comments: <br>
    * @param reportesProcAlmNombreFichero The new value of the <code>reportesProcAlmNombreFichero</code> attribute.
    */
    public void setReportesProcAlmNombreFichero (String reportesProcAlmNombreFichero) {
        modifiedReportesProcAlmNombreFichero = true;
        this.reportesProcAlmNombreFichero = reportesProcAlmNombreFichero;
    }

   /**
    * Returns the value of the <code>modifiedReportesProcAlmNombreFichero</code> class property.<br>
    *
    * @return The value of the <code>modifiedReportesProcAlmNombreFichero</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedReportesProcAlmNombreFichero() {
        return modifiedReportesProcAlmNombreFichero;
    }

   /**
    * Sets the value of the <code>modifiedReportesProcAlmNombreFichero</code> class property.<br>
    * @param modified The new value of the <code>modifiedReportesProcAlmNombreFichero</code>.
    */
    public void setModifiedReportesProcAlmNombreFichero(boolean modified) {
        this.modifiedReportesProcAlmNombreFichero = modified;
    }

    /**
     * Returns the instance of <code>Funcionario</code> related through the <code>Funcionarios</code> role.
     * Model Relationship:
     * <code>[Funcionario] Funcionarios 0:M  ------ 0:M  Reportes [ReportesProcAlm]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Funcionario</code> related through the <code>Funcionarios</code> role.
     */
    @JsonIgnore
    public Collection <Funcionario> getFuncionarios() {
        return funcionarios;
    }

   /**
    * Adds an instance of <code>Funcionario</code> related through the <code>Funcionarios</code> role.
    * @param funcionarios The instance to add to the <code>Funcionarios</code> role.
    */
    public void add2Funcionarios(Funcionario funcionarios) {
        this.getFuncionarios().add(funcionarios);
    }
    /**
     * Sets instances of <code>Funcionario</code> related through the <code>Funcionarios</code> role.
     * @param funcionarios The new value for the <code>Funcionarios</code> role.
     */
    public void setFuncionarios(Collection < Funcionario > funcionarios) {
        this.funcionarios = funcionarios;
    }

   /**
    * This method gets the attribute value <code>modifiedFuncionarios</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedFuncionarios</code> has been modified.
    */
    public boolean isModifiedFuncionarios(){
        return modifiedFuncionarios;
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
        reportesProcAlmDescripcion = "";
        reportesProcAlmNombreProc = "";
        reportesProcAlmNombreFichero = "";
        funcionarios = null;
        values = new HashMap<>();
        reportesProcAlmRepository = Arc.container().select(ReportesProcAlmJpaRepository.class).get();
        funcionarioRepository = Arc.container().select(FuncionarioJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return ReportesProcAlm.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ReportesProcAlmConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedReportesProcAlmDescripcion = false;
    	values.put("reportesProcAlmDescripcion", getReportesProcAlmDescripcion());
    	modifiedReportesProcAlmNombreProc = false;
    	values.put("reportesProcAlmNombreProc", getReportesProcAlmNombreProc());
    	modifiedReportesProcAlmNombreFichero = false;
    	values.put("reportesProcAlmNombreFichero", getReportesProcAlmNombreFichero());
    	modifiedFuncionarios = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>ReportesProcAlmOid</code> object that identifies this instance of <code>ReportesProcAlm</code>.
     * @return <code>ReportesProcAlmOid </code> object that identifies this instance of <code>ReportesProcAlm</code>
     */
    public ReportesProcAlmOid getOid() {
        return new ReportesProcAlmOid(getReportesProcAlmidReporte());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ReportesProcAlmConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.REPORTESPROCALM)) {
            // Add this class
            activeFacets.add(Constants.REPORTESPROCALM);
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


        if (getAgent().isFacetActive(Constants.AGENT_FUNCIONARIO) || getAgent().isFacetActive(Constants.AGENT_ASESOR) || getAgent().isFacetActive(Constants.AGENT_AREAMEDICA) || getAgent().isFacetActive(Constants.AGENT_AFILIACIONES) || getAgent().isFacetActive(Constants.AGENT_RESPREGIONAL) || getAgent().isFacetActive(Constants.AGENT_GESTOR) || getAgent().isFacetActive(Constants.AGENT_MESADEAPOYO) && (!getAgent().isFacetActive(Constants.AGENT_ADMIN) || !getAgent().isFacetActive(Constants.AGENT_SUPERADMIN))) {
            Funcionario agentInstance = (Funcionario) getAgent().getAgentInstance(Constants.FUNCIONARIO);

            // Check the HV formula.
            /* 
            COUNT( Funcionarios ) WHERE (Funcionarios = agent) > 0
            */
            try {
                if (reportesProcAlmRepository.assocOperator000() > Long.valueOf(0)) {
                    returnValue = true;
                }
            } catch (Exception e) {
            	returnValue = false;
            }
        }
        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN)) {
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

    public String buildICReportesProcAlm() {
        try {
            return getReportesProcAlmDescripcion();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSReportesProcAlm() {
        try {
            return getReportesProcAlmDescripcion() + " " + getReportesProcAlmNombreProc() + " " + getReportesProcAlmNombreFichero();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSMMD() {
        try {
            return getReportesProcAlmNombreProc() + " " + getReportesProcAlmNombreFichero() + " " + getReportesProcAlmDescripcion();
        } catch(Exception e) {
            return "";
        }
    }
}
