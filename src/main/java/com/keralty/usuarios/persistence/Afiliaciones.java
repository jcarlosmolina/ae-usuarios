package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.IntegrityConstraintException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.AfiliacionesConstants;
import com.keralty.usuarios.global.AsesorConstants;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.global.PlanesConstants;
import com.keralty.usuarios.persistence.oid.AfiliacionesOid;
import com.keralty.usuarios.repository.AfiliacionesJpaRepository;
import com.keralty.usuarios.repository.PlanesJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
 * Persistent representation of the <code>Afiliaciones</code> model class.
 * <p>
 * Model Class: <code>Afiliaciones</code><br>
 */
@Entity(name = AfiliacionesConstants.CLASS_NAME)
@Table(name = AfiliacionesConstants.TBL_NAME)
public class Afiliaciones extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient AfiliacionesJpaRepository afiliacionesRepository;

    @JsonIgnore
    private transient PlanesJpaRepository planesRepository;

    /** Class identification function. */
    @Id
    @Column(name = AfiliacionesConstants.FLD_FUNCIONARIOID, insertable = false, updatable = false )
    @JsonProperty(value="id")
    private Long funcionarioId;

    @Column(name = AfiliacionesConstants.FLD_P4SSW0RD )
    @JsonProperty(value="password")
    private String passWord;

    @Transient
    @JsonIgnore
    private boolean modifiedPassWord;

    /** Related Class. */
    @ManyToMany
    @JoinTable(
        name=Constants.TBL_NAME_AFILIACIONESPLANES,
        joinColumns = {
            @JoinColumn(name=Constants.FLD_TMAFILIACIONESPLANES_FUNCIONARIOID, referencedColumnName=AfiliacionesConstants.FLD_FUNCIONARIOID)
        },
        inverseJoinColumns = {
            @JoinColumn(name=Constants.FLD_TMAFILIACIONESPLANES_PLANESPLAN, referencedColumnName=PlanesConstants.FLD_PLANESPLAN)
    })
    @JsonIgnore
    private Collection <Planes> planes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlanes;

    /** Class member parent. */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns({
        @JoinColumn(name=AfiliacionesConstants.FLD_FUNCIONARIOID, referencedColumnName=FuncionarioConstants.FLD_FUNCIONARIOID)
    })
    @JsonIgnore
    private Funcionario parentFuncionario;

    /** Class member parent initialized. */
    @Transient
    @JsonIgnore
    private boolean parentFuncionarioInitialized;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Afiliaciones() {
        funcionarioId = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Afiliaciones</code>.
     * @param oid Object Identifier of the instance of <code>Afiliaciones</code> to be created.
     * @throws SystemException
     */
    public Afiliaciones(AfiliacionesOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            funcionarioId = oid.getFuncionarioId();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>funcionarioId</code> attribute<br>in class <code>Funcionario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Funcionario</code>
     * @return The value of the <code>funcionarioId</code> attribute<br>in class <code>Funcionario</code>.
     */
    @JsonProperty(value="id")
    public Long getAfiliacionesId() {
        return getFuncionarioId();
    }

    @JsonIgnore
    public Long getFuncionarioId() {
        return funcionarioId;
    }

    /**
     * Sets the value of the <code>funcionarioId</code> attribute<br>in class <code>Funcionario</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Funcionario</code>
     * @param funcionarioId The new value of the <code>funcionarioId</code> attribute<br>in class <code>Funcionario</code>.
     */
    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

   /**
    * Returns the value of the <code>funcionarioManual</code> attribute.<br>
    * Model Attribute: <code>funcionarioManual</code>. Constant Bool<br>
    * Comments: GC3: Indica si es manual o viene de la sincronización<br>
    * @return The value of the <code>funcionarioManual</code> attribute.
    */
    @JsonProperty(value="manual")
    public Boolean getAfiliacionesManual()  {
        return getFuncionarioManual();
    }

    @JsonIgnore
    public Boolean getFuncionarioManual()  {
    	Boolean value;
        value = getParentFuncionario().getFuncionarioManual();
        return value;
    }

   /**
    * Sets the value of the <code>funcionarioManual</code> attribute.<br>
    * Model Attribute: <code>funcionarioManual</code>. Constant Bool<br>
    * Comments: GC3: Indica si es manual o viene de la sincronización<br>
    * @param funcionarioManual The new value of the <code>funcionarioManual</code> attribute.
    */
    public void setFuncionarioManual (Boolean funcionarioManual) {
        getParentFuncionario().setFuncionarioManual(funcionarioManual);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioManual</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioManual</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioManual() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioManual();
    }

   /**
    * Returns the value of the <code>funcionarioUsuario</code> attribute.<br>
    * Model Attribute: <code>funcionarioUsuario</code>. Variable String Size=20<br>
    * Comments: Admin's identification function<br>
    * @return The value of the <code>funcionarioUsuario</code> attribute.
    */
    @JsonProperty(value="usuario")
    public String getAfiliacionesUsuario()  {
        return getFuncionarioUsuario();
    }

    @JsonIgnore
    public String getFuncionarioUsuario()  {
    	String value;
        value = getParentFuncionario().getFuncionarioUsuario();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioUsuario</code> attribute.<br>
    * Model Attribute: <code>funcionarioUsuario</code>. Variable String Size=20<br>
    * Comments: Admin's identification function<br>
    * @param funcionarioUsuario The new value of the <code>funcionarioUsuario</code> attribute.
    */
    public void setFuncionarioUsuario (String funcionarioUsuario) {
        getParentFuncionario().setFuncionarioUsuario(funcionarioUsuario);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioUsuario</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioUsuario</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioUsuario() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioUsuario();
    }

   /**
    * Returns the value of the <code>funcionarioPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>funcionarioPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>funcionarioPrimerNombre</code> attribute.
    */
    @JsonProperty(value="primernombre")
    public String getAfiliacionesPrimerNombre()  {
        return getFuncionarioPrimerNombre();
    }

    @JsonIgnore
    public String getFuncionarioPrimerNombre()  {
    	String value;
        value = getParentFuncionario().getFuncionarioPrimerNombre();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioPrimerNombre</code> attribute.<br>
    * Model Attribute: <code>funcionarioPrimerNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param funcionarioPrimerNombre The new value of the <code>funcionarioPrimerNombre</code> attribute.
    */
    public void setFuncionarioPrimerNombre (String funcionarioPrimerNombre) {
        getParentFuncionario().setFuncionarioPrimerNombre(funcionarioPrimerNombre);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioPrimerNombre</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioPrimerNombre</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioPrimerNombre() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioPrimerNombre();
    }

   /**
    * Returns the value of the <code>funcionarioSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>funcionarioSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>funcionarioSegundoNombre</code> attribute.
    */
    @JsonProperty(value="segundonombre")
    public String getAfiliacionesSegundoNombre()  {
        return getFuncionarioSegundoNombre();
    }

    @JsonIgnore
    public String getFuncionarioSegundoNombre()  {
    	String value;
        value = getParentFuncionario().getFuncionarioSegundoNombre();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioSegundoNombre</code> attribute.<br>
    * Model Attribute: <code>funcionarioSegundoNombre</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param funcionarioSegundoNombre The new value of the <code>funcionarioSegundoNombre</code> attribute.
    */
    public void setFuncionarioSegundoNombre (String funcionarioSegundoNombre) {
        getParentFuncionario().setFuncionarioSegundoNombre(funcionarioSegundoNombre);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioSegundoNombre</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioSegundoNombre</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioSegundoNombre() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioSegundoNombre();
    }

   /**
    * Returns the value of the <code>funcionarioPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>funcionarioPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>funcionarioPrimerApellido</code> attribute.
    */
    @JsonProperty(value="primerapellido")
    public String getAfiliacionesPrimerApellido()  {
        return getFuncionarioPrimerApellido();
    }

    @JsonIgnore
    public String getFuncionarioPrimerApellido()  {
    	String value;
        value = getParentFuncionario().getFuncionarioPrimerApellido();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioPrimerApellido</code> attribute.<br>
    * Model Attribute: <code>funcionarioPrimerApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param funcionarioPrimerApellido The new value of the <code>funcionarioPrimerApellido</code> attribute.
    */
    public void setFuncionarioPrimerApellido (String funcionarioPrimerApellido) {
        getParentFuncionario().setFuncionarioPrimerApellido(funcionarioPrimerApellido);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioPrimerApellido</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioPrimerApellido</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioPrimerApellido() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioPrimerApellido();
    }

   /**
    * Returns the value of the <code>funcionarioSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>funcionarioSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>funcionarioSegundoApellido</code> attribute.
    */
    @JsonProperty(value="segundoapellido")
    public String getAfiliacionesSegundoApellido()  {
        return getFuncionarioSegundoApellido();
    }

    @JsonIgnore
    public String getFuncionarioSegundoApellido()  {
    	String value;
        value = getParentFuncionario().getFuncionarioSegundoApellido();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioSegundoApellido</code> attribute.<br>
    * Model Attribute: <code>funcionarioSegundoApellido</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param funcionarioSegundoApellido The new value of the <code>funcionarioSegundoApellido</code> attribute.
    */
    public void setFuncionarioSegundoApellido (String funcionarioSegundoApellido) {
        getParentFuncionario().setFuncionarioSegundoApellido(funcionarioSegundoApellido);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioSegundoApellido</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioSegundoApellido</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioSegundoApellido() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioSegundoApellido();
    }

   /**
    * Returns the value of the <code>funcionariodrvNombreCompleto</code> attribute.<br>
    * Model Attribute: <code>funcionariodrvNombreCompleto</code>. Variable String Size=255<br>
    * Comments: <br>
    * @return The value of the <code>funcionariodrvNombreCompleto</code> attribute.
    */
    @JsonProperty(value="drvnombrecompleto")
    public String getAfiliacionesDrvNombreCompleto()  {
        return getFuncionariodrvNombreCompleto();
    }

    @JsonIgnore
    public String getFuncionariodrvNombreCompleto()  {
    	String value;
        value = getParentFuncionario().getFuncionariodrvNombreCompleto();
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>funcionarioUsuarioLDAP</code> attribute.<br>
    * Model Attribute: <code>funcionarioUsuarioLDAP</code>. Variable String Size=50<br>
    * Comments: <br>
    * @return The value of the <code>funcionarioUsuarioLDAP</code> attribute.
    */
    @JsonProperty(value="usuarioldap")
    public String getAfiliacionesUsuarioLDAP()  {
        return getFuncionarioUsuarioLDAP();
    }

    @JsonIgnore
    public String getFuncionarioUsuarioLDAP()  {
    	String value;
        value = getParentFuncionario().getFuncionarioUsuarioLDAP();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioUsuarioLDAP</code> attribute.<br>
    * Model Attribute: <code>funcionarioUsuarioLDAP</code>. Variable String Size=50<br>
    * Comments: <br>
    * @param funcionarioUsuarioLDAP The new value of the <code>funcionarioUsuarioLDAP</code> attribute.
    */
    public void setFuncionarioUsuarioLDAP (String funcionarioUsuarioLDAP) {
        getParentFuncionario().setFuncionarioUsuarioLDAP(funcionarioUsuarioLDAP);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioUsuarioLDAP</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioUsuarioLDAP</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioUsuarioLDAP() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioUsuarioLDAP();
    }

   /**
    * Returns the value of the <code>funcionarioEmail</code> attribute.<br>
    * Model Attribute: <code>funcionarioEmail</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>funcionarioEmail</code> attribute.
    */
    @JsonProperty(value="email")
    public String getAfiliacionesEmail()  {
        return getFuncionarioEmail();
    }

    @JsonIgnore
    public String getFuncionarioEmail()  {
    	String value;
        value = getParentFuncionario().getFuncionarioEmail();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioEmail</code> attribute.<br>
    * Model Attribute: <code>funcionarioEmail</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param funcionarioEmail The new value of the <code>funcionarioEmail</code> attribute.
    */
    public void setFuncionarioEmail (String funcionarioEmail) {
        getParentFuncionario().setFuncionarioEmail(funcionarioEmail);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioEmail</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioEmail</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioEmail() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioEmail();
    }

   /**
    * Returns the value of the <code>funcionarioCodJefe</code> attribute.<br>
    * Model Attribute: <code>funcionarioCodJefe</code>. Variable String Size=20<br>
    * Comments: Este atributo tomará valor si el agente es un Asesor que tiene responsable (JefeAsesores). En este caso, se le dará como valor el código de usuario del JefeAsesores. Se utilizará en fórmulas de VH de JefeAsesores.<br>
    * @return The value of the <code>funcionarioCodJefe</code> attribute.
    */
    @JsonProperty(value="codjefe")
    public String getAfiliacionesCodJefe()  {
        return getFuncionarioCodJefe();
    }

    @JsonIgnore
    public String getFuncionarioCodJefe()  {
    	String value;
        value = getParentFuncionario().getFuncionarioCodJefe();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>funcionarioCodJefe</code> attribute.<br>
    * Model Attribute: <code>funcionarioCodJefe</code>. Variable String Size=20<br>
    * Comments: Este atributo tomará valor si el agente es un Asesor que tiene responsable (JefeAsesores). En este caso, se le dará como valor el código de usuario del JefeAsesores. Se utilizará en fórmulas de VH de JefeAsesores.<br>
    * @param funcionarioCodJefe The new value of the <code>funcionarioCodJefe</code> attribute.
    */
    public void setFuncionarioCodJefe (String funcionarioCodJefe) {
        getParentFuncionario().setFuncionarioCodJefe(funcionarioCodJefe);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioCodJefe</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioCodJefe</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioCodJefe() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioCodJefe();
    }

   /**
    * Returns the value of the <code>funcionariodrvNomJefe</code> attribute.<br>
    * Model Attribute: <code>funcionariodrvNomJefe</code>. Variable String Size=255<br>
    * Comments: Este atributo tomará valor si el agente es un Asesor que tiene responsable (JefeAsesores). En CodJefe se tendrá el código y aquí el nombre. Se necesita para el report de Solicitud. <br>
    * @return The value of the <code>funcionariodrvNomJefe</code> attribute.
    */
    @JsonProperty(value="drvnomjefe")
    public String getAfiliacionesDrvNomJefe()  {
        return getFuncionariodrvNomJefe();
    }

    @JsonIgnore
    public String getFuncionariodrvNomJefe()  {
    	String value;
        value = getParentFuncionario().getFuncionariodrvNomJefe();
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>funcionariodrvNomAgencia</code> attribute.<br>
    * Model Attribute: <code>funcionariodrvNomAgencia</code>. Variable String Size=255<br>
    * Comments: Unicamente para Asesores de Agencia (manuales) e indica el nombre de la AGencia (Jefe del asesor)<br>
    * @return The value of the <code>funcionariodrvNomAgencia</code> attribute.
    */
    @JsonProperty(value="drvnomagencia")
    public String getAfiliacionesDrvNomAgencia()  {
        return getFuncionariodrvNomAgencia();
    }

    @JsonIgnore
    public String getFuncionariodrvNomAgencia()  {
    	String value;
        value = getParentFuncionario().getFuncionariodrvNomAgencia();
        return (value == null ? null : value.trim());
    }

   /**
    * Returns the value of the <code>funcionarioDisponible</code> attribute.<br>
    * Model Attribute: <code>funcionarioDisponible</code>. Variable Bool<br>
    * Comments: GdC-26 Req. 5: Marcación de usuarios no disponibles
Se requiere que sea posible marcar a los usuarios que no se encuentran disponibles. Por ejemplo, para usuarios que están de vacaciones, o que no han ido a trabajar por causa médica o porqué se encuentra en otro proceso, etc.
<Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>funcionarioDisponible</code> attribute.
    */
    @JsonProperty(value="disponible")
    public Boolean getAfiliacionesDisponible()  {
        return getFuncionarioDisponible();
    }

    @JsonIgnore
    public Boolean getFuncionarioDisponible()  {
    	Boolean value;
        value = getParentFuncionario().getFuncionarioDisponible();
        return value;
    }

   /**
    * Sets the value of the <code>funcionarioDisponible</code> attribute.<br>
    * Model Attribute: <code>funcionarioDisponible</code>. Variable Bool<br>
    * Comments: GdC-26 Req. 5: Marcación de usuarios no disponibles
Se requiere que sea posible marcar a los usuarios que no se encuentran disponibles. Por ejemplo, para usuarios que están de vacaciones, o que no han ido a trabajar por causa médica o porqué se encuentra en otro proceso, etc.
<Options>
RADIO=1;
</Options><br>
    * @param funcionarioDisponible The new value of the <code>funcionarioDisponible</code> attribute.
    */
    public void setFuncionarioDisponible (Boolean funcionarioDisponible) {
        getParentFuncionario().setFuncionarioDisponible(funcionarioDisponible);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioDisponible</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioDisponible</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioDisponible() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioDisponible();
    }

   /**
    * Returns the value of the <code>funcionarioNumSolNoTerminadas</code> attribute.<br>
    * Model Attribute: <code>funcionarioNumSolNoTerminadas</code>. Variable Nat<br>
    * Comments: GdC-26 Req. 6: Asignación automática de solicitudes
Indica el número de solicitudes no terminadas que tiene asignadas el usuario. Se utilizará en los procesos de asignación automática de usuarios a solicitudes<br>
    * @return The value of the <code>funcionarioNumSolNoTerminadas</code> attribute.
    */
    @JsonProperty(value="numsolnoterminadas")
    public Long getAfiliacionesNumSolNoTerminadas()  {
        return getFuncionarioNumSolNoTerminadas();
    }

    @JsonIgnore
    public Long getFuncionarioNumSolNoTerminadas()  {
    	Long value;
        value = getParentFuncionario().getFuncionarioNumSolNoTerminadas();
        return value;
    }

   /**
    * Sets the value of the <code>funcionarioNumSolNoTerminadas</code> attribute.<br>
    * Model Attribute: <code>funcionarioNumSolNoTerminadas</code>. Variable Nat<br>
    * Comments: GdC-26 Req. 6: Asignación automática de solicitudes
Indica el número de solicitudes no terminadas que tiene asignadas el usuario. Se utilizará en los procesos de asignación automática de usuarios a solicitudes<br>
    * @param funcionarioNumSolNoTerminadas The new value of the <code>funcionarioNumSolNoTerminadas</code> attribute.
    */
    public void setFuncionarioNumSolNoTerminadas (Long funcionarioNumSolNoTerminadas) {
        getParentFuncionario().setFuncionarioNumSolNoTerminadas(funcionarioNumSolNoTerminadas);
    }

   /**
    * Returns the value of the <code>modifiedFuncionarioNumSolNoTerminadas</code> class property.<br>
    *
    * @return The value of the <code>modifiedFuncionarioNumSolNoTerminadas</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedFuncionarioNumSolNoTerminadas() throws SystemException {
        return getFuncionarioFacet().isModifiedFuncionarioNumSolNoTerminadas();
    }

   /**
    * Returns the value of the <code>funcionariodrvEsAsesorIntegral</code> attribute.<br>
    * Model Attribute: <code>funcionariodrvEsAsesorIntegral</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>funcionariodrvEsAsesorIntegral</code> attribute.
    */
    @JsonProperty(value="drvesasesorintegral")
    public Boolean getAfiliacionesDrvEsAsesorIntegral()  {
        return getFuncionariodrvEsAsesorIntegral();
    }

    @JsonIgnore
    public Boolean getFuncionariodrvEsAsesorIntegral()  {
    	Boolean value;
        value = getParentFuncionario().getFuncionariodrvEsAsesorIntegral();
        return value;
    }

   /**
    * Returns the value of the <code>funcionariodrvEsAfiliacion</code> attribute.<br>
    * Model Attribute: <code>funcionariodrvEsAfiliacion</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>funcionariodrvEsAfiliacion</code> attribute.
    */
    @JsonProperty(value="drvesafiliacion")
    public Boolean getAfiliacionesDrvEsAfiliacion()  {
        return getFuncionariodrvEsAfiliacion();
    }

    @JsonIgnore
    public Boolean getFuncionariodrvEsAfiliacion()  {
    	Boolean value;
        value = getParentFuncionario().getFuncionariodrvEsAfiliacion();
        return value;
    }

   /**
    * Returns the value of the <code>asesorModDBasicosPersona</code> attribute.<br>
    * Model Attribute: <code>asesorModDBasicosPersona</code>. Variable Bool<br>
    * Comments: Parametrización propia de AE. Para registrar si un asesor puede modificar los datos básicos de persona o no. <br>
    * @return The value of the <code>asesorModDBasicosPersona</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="moddbasicospersona")
    public Boolean getAfiliacionesModDBasicosPersona() throws SystemException  {
        return getAsesorModDBasicosPersona();
    }

    @JsonIgnore
    public Boolean getAsesorModDBasicosPersona() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesorModDBasicosPersona();
        return value;
    }

   /**
    * Sets the value of the <code>asesorModDBasicosPersona</code> attribute.<br>
    * Model Attribute: <code>asesorModDBasicosPersona</code>. Variable Bool<br>
    * Comments: Parametrización propia de AE. Para registrar si un asesor puede modificar los datos básicos de persona o no. <br>
    * @param asesorModDBasicosPersona The new value of the <code>asesorModDBasicosPersona</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorModDBasicosPersona (Boolean asesorModDBasicosPersona) throws SystemException {
        getAsesorFacet().setAsesorModDBasicosPersona(asesorModDBasicosPersona);
    }

   /**
    * Returns the value of the <code>modifiedAsesorModDBasicosPersona</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorModDBasicosPersona</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorModDBasicosPersona() throws SystemException {
        return getAsesorFacet().isModifiedAsesorModDBasicosPersona();
    }

   /**
    * Returns the value of the <code>asesormodificaDirector</code> attribute.<br>
    * Model Attribute: <code>asesormodificaDirector</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>asesormodificaDirector</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="modificadirector")
    public Boolean getAfiliacionesModificaDirector() throws SystemException  {
        return getAsesormodificaDirector();
    }

    @JsonIgnore
    public Boolean getAsesormodificaDirector() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesormodificaDirector();
        return value;
    }

   /**
    * Sets the value of the <code>asesormodificaDirector</code> attribute.<br>
    * Model Attribute: <code>asesormodificaDirector</code>. Variable Bool<br>
    * Comments: <br>
    * @param asesormodificaDirector The new value of the <code>asesormodificaDirector</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesormodificaDirector (Boolean asesormodificaDirector) throws SystemException {
        getAsesorFacet().setAsesormodificaDirector(asesormodificaDirector);
    }

   /**
    * Returns the value of the <code>modifiedAsesormodificaDirector</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesormodificaDirector</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesormodificaDirector() throws SystemException {
        return getAsesorFacet().isModifiedAsesormodificaDirector();
    }

   /**
    * Returns the value of the <code>asesoresDirector</code> attribute.<br>
    * Model Attribute: <code>asesoresDirector</code>. Variable Bool<br>
    * Comments: <br>
    * @return The value of the <code>asesoresDirector</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="esdirector")
    public Boolean getAfiliacionesEsDirector() throws SystemException  {
        return getAsesoresDirector();
    }

    @JsonIgnore
    public Boolean getAsesoresDirector() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesoresDirector();
        return value;
    }

   /**
    * Sets the value of the <code>asesoresDirector</code> attribute.<br>
    * Model Attribute: <code>asesoresDirector</code>. Variable Bool<br>
    * Comments: <br>
    * @param asesoresDirector The new value of the <code>asesoresDirector</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesoresDirector (Boolean asesoresDirector) throws SystemException {
        getAsesorFacet().setAsesoresDirector(asesoresDirector);
    }

   /**
    * Returns the value of the <code>modifiedAsesoresDirector</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesoresDirector</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesoresDirector() throws SystemException {
        return getAsesorFacet().isModifiedAsesoresDirector();
    }

   /**
    * Returns the value of the <code>asesorNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>asesorNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @return The value of the <code>asesorNumIdentificacion</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="numidentificacion")
    public String getAfiliacionesNumIdentificacion() throws SystemException  {
        return getAsesorNumIdentificacion();
    }

    @JsonIgnore
    public String getAsesorNumIdentificacion() throws SystemException  {
    	String value;
        value = getAsesorFacet().getAsesorNumIdentificacion();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>asesorNumIdentificacion</code> attribute.<br>
    * Model Attribute: <code>asesorNumIdentificacion</code>. Variable String Size=60<br>
    * Comments: <br>
    * @param asesorNumIdentificacion The new value of the <code>asesorNumIdentificacion</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorNumIdentificacion (String asesorNumIdentificacion) throws SystemException {
        getAsesorFacet().setAsesorNumIdentificacion(asesorNumIdentificacion);
    }

   /**
    * Returns the value of the <code>modifiedAsesorNumIdentificacion</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorNumIdentificacion</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorNumIdentificacion() throws SystemException {
        return getAsesorFacet().isModifiedAsesorNumIdentificacion();
    }

   /**
    * Returns the value of the <code>asesorEsIntegral</code> attribute.<br>
    * Model Attribute: <code>asesorEsIntegral</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @return The value of the <code>asesorEsIntegral</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="esintegral")
    public Boolean getAfiliacionesEsIntegral() throws SystemException  {
        return getAsesorEsIntegral();
    }

    @JsonIgnore
    public Boolean getAsesorEsIntegral() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesorEsIntegral();
        return value;
    }

   /**
    * Sets the value of the <code>asesorEsIntegral</code> attribute.<br>
    * Model Attribute: <code>asesorEsIntegral</code>. Variable Bool<br>
    * Comments: <Options>
RADIO=1;
</Options><br>
    * @param asesorEsIntegral The new value of the <code>asesorEsIntegral</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorEsIntegral (Boolean asesorEsIntegral) throws SystemException {
        getAsesorFacet().setAsesorEsIntegral(asesorEsIntegral);
    }

   /**
    * Returns the value of the <code>modifiedAsesorEsIntegral</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorEsIntegral</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorEsIntegral() throws SystemException {
        return getAsesorFacet().isModifiedAsesorEsIntegral();
    }

   /**
    * Returns the value of the <code>asesorVerDBasicosPersona</code> attribute.<br>
    * Model Attribute: <code>asesorVerDBasicosPersona</code>. Variable Bool<br>
    * Comments: GdC-36: Req 5: Se requiere incluir en la paramétrica de usuarios de asesores de agencias, asesores y directores y asesores una columna que indique SI/NO se puede visualizar los datos básicos de usuarios (Información del contratante o información de personas a afiliar) para inclusiones y nueva afiliación.<br>
    * @return The value of the <code>asesorVerDBasicosPersona</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="verdbasicospersona")
    public Boolean getAfiliacionesVerDBasicosPersona() throws SystemException  {
        return getAsesorVerDBasicosPersona();
    }

    @JsonIgnore
    public Boolean getAsesorVerDBasicosPersona() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesorVerDBasicosPersona();
        return value;
    }

   /**
    * Sets the value of the <code>asesorVerDBasicosPersona</code> attribute.<br>
    * Model Attribute: <code>asesorVerDBasicosPersona</code>. Variable Bool<br>
    * Comments: GdC-36: Req 5: Se requiere incluir en la paramétrica de usuarios de asesores de agencias, asesores y directores y asesores una columna que indique SI/NO se puede visualizar los datos básicos de usuarios (Información del contratante o información de personas a afiliar) para inclusiones y nueva afiliación.<br>
    * @param asesorVerDBasicosPersona The new value of the <code>asesorVerDBasicosPersona</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorVerDBasicosPersona (Boolean asesorVerDBasicosPersona) throws SystemException {
        getAsesorFacet().setAsesorVerDBasicosPersona(asesorVerDBasicosPersona);
    }

   /**
    * Returns the value of the <code>modifiedAsesorVerDBasicosPersona</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorVerDBasicosPersona</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorVerDBasicosPersona() throws SystemException {
        return getAsesorFacet().isModifiedAsesorVerDBasicosPersona();
    }

   /**
    * Returns the value of the <code>asesorVerDocIdentificacionPersona</code> attribute.<br>
    * Model Attribute: <code>asesorVerDocIdentificacionPersona</code>. Variable Bool<br>
    * Comments: GdC-36: Req 8: Se requiere incluir en la paramétrica de usuarios de asesores de agencias, asesores y directores y asesores una columna que indique SI/NO se pueden visualizar (abrir en otra pestaña del navegador o descargar) los documentos que se encuentran ya almacenados en el gestor documental (Información del contratante o información de personas a afiliar).<br>
    * @return The value of the <code>asesorVerDocIdentificacionPersona</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="verdocidentificacionpersona")
    public Boolean getAfiliacionesVerDocIdentificacionPersona() throws SystemException  {
        return getAsesorVerDocIdentificacionPersona();
    }

    @JsonIgnore
    public Boolean getAsesorVerDocIdentificacionPersona() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesorVerDocIdentificacionPersona();
        return value;
    }

   /**
    * Sets the value of the <code>asesorVerDocIdentificacionPersona</code> attribute.<br>
    * Model Attribute: <code>asesorVerDocIdentificacionPersona</code>. Variable Bool<br>
    * Comments: GdC-36: Req 8: Se requiere incluir en la paramétrica de usuarios de asesores de agencias, asesores y directores y asesores una columna que indique SI/NO se pueden visualizar (abrir en otra pestaña del navegador o descargar) los documentos que se encuentran ya almacenados en el gestor documental (Información del contratante o información de personas a afiliar).<br>
    * @param asesorVerDocIdentificacionPersona The new value of the <code>asesorVerDocIdentificacionPersona</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorVerDocIdentificacionPersona (Boolean asesorVerDocIdentificacionPersona) throws SystemException {
        getAsesorFacet().setAsesorVerDocIdentificacionPersona(asesorVerDocIdentificacionPersona);
    }

   /**
    * Returns the value of the <code>modifiedAsesorVerDocIdentificacionPersona</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorVerDocIdentificacionPersona</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorVerDocIdentificacionPersona() throws SystemException {
        return getAsesorFacet().isModifiedAsesorVerDocIdentificacionPersona();
    }

   /**
    * Returns the value of the <code>asesorVerContratoNovedad</code> attribute.<br>
    * Model Attribute: <code>asesorVerContratoNovedad</code>. Variable Bool<br>
    * Comments: GdC-36: Req 9: Se requiere incluir en la paramétrica de usuarios de asesores de agencias, asesores y directores y asesores una columna que indique SI/NO se puede visualizar la información correspondiente al contrato ingresado en la opción NOVEDADES (Ya sea Colectivo o Familiar)<br>
    * @return The value of the <code>asesorVerContratoNovedad</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="vercontratonovedad")
    public Boolean getAfiliacionesVerContratoNovedad() throws SystemException  {
        return getAsesorVerContratoNovedad();
    }

    @JsonIgnore
    public Boolean getAsesorVerContratoNovedad() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesorVerContratoNovedad();
        return value;
    }

   /**
    * Sets the value of the <code>asesorVerContratoNovedad</code> attribute.<br>
    * Model Attribute: <code>asesorVerContratoNovedad</code>. Variable Bool<br>
    * Comments: GdC-36: Req 9: Se requiere incluir en la paramétrica de usuarios de asesores de agencias, asesores y directores y asesores una columna que indique SI/NO se puede visualizar la información correspondiente al contrato ingresado en la opción NOVEDADES (Ya sea Colectivo o Familiar)<br>
    * @param asesorVerContratoNovedad The new value of the <code>asesorVerContratoNovedad</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorVerContratoNovedad (Boolean asesorVerContratoNovedad) throws SystemException {
        getAsesorFacet().setAsesorVerContratoNovedad(asesorVerContratoNovedad);
    }

   /**
    * Returns the value of the <code>modifiedAsesorVerContratoNovedad</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorVerContratoNovedad</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorVerContratoNovedad() throws SystemException {
        return getAsesorFacet().isModifiedAsesorVerContratoNovedad();
    }

   /**
    * Returns the value of the <code>asesorCanalComercial</code> attribute.<br>
    * Model Attribute: <code>asesorCanalComercial</code>. Variable String Size=50<br>
    * Comments: GdC-36. Req 7<br>
    * @return The value of the <code>asesorCanalComercial</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="canalcomercial")
    public String getAfiliacionesCanalComercial() throws SystemException  {
        return getAsesorCanalComercial();
    }

    @JsonIgnore
    public String getAsesorCanalComercial() throws SystemException  {
    	String value;
        value = getAsesorFacet().getAsesorCanalComercial();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>asesorCanalComercial</code> attribute.<br>
    * Model Attribute: <code>asesorCanalComercial</code>. Variable String Size=50<br>
    * Comments: GdC-36. Req 7<br>
    * @param asesorCanalComercial The new value of the <code>asesorCanalComercial</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorCanalComercial (String asesorCanalComercial) throws SystemException {
        getAsesorFacet().setAsesorCanalComercial(asesorCanalComercial);
    }

   /**
    * Returns the value of the <code>modifiedAsesorCanalComercial</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorCanalComercial</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorCanalComercial() throws SystemException {
        return getAsesorFacet().isModifiedAsesorCanalComercial();
    }

   /**
    * Returns the value of the <code>asesorCargo</code> attribute.<br>
    * Model Attribute: <code>asesorCargo</code>. Variable String Size=50<br>
    * Comments: GdC-36. Req 7<br>
    * @return The value of the <code>asesorCargo</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="cargo")
    public String getAfiliacionesCargo() throws SystemException  {
        return getAsesorCargo();
    }

    @JsonIgnore
    public String getAsesorCargo() throws SystemException  {
    	String value;
        value = getAsesorFacet().getAsesorCargo();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>asesorCargo</code> attribute.<br>
    * Model Attribute: <code>asesorCargo</code>. Variable String Size=50<br>
    * Comments: GdC-36. Req 7<br>
    * @param asesorCargo The new value of the <code>asesorCargo</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorCargo (String asesorCargo) throws SystemException {
        getAsesorFacet().setAsesorCargo(asesorCargo);
    }

   /**
    * Returns the value of the <code>modifiedAsesorCargo</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorCargo</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorCargo() throws SystemException {
        return getAsesorFacet().isModifiedAsesorCargo();
    }

   /**
    * Returns the value of the <code>asesorEstado</code> attribute.<br>
    * Model Attribute: <code>asesorEstado</code>. Variable String Size=50<br>
    * Comments: GdC-36. Req 7<br>
    * @return The value of the <code>asesorEstado</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="estado")
    public String getAfiliacionesEstado() throws SystemException  {
        return getAsesorEstado();
    }

    @JsonIgnore
    public String getAsesorEstado() throws SystemException  {
    	String value;
        value = getAsesorFacet().getAsesorEstado();
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>asesorEstado</code> attribute.<br>
    * Model Attribute: <code>asesorEstado</code>. Variable String Size=50<br>
    * Comments: GdC-36. Req 7<br>
    * @param asesorEstado The new value of the <code>asesorEstado</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorEstado (String asesorEstado) throws SystemException {
        getAsesorFacet().setAsesorEstado(asesorEstado);
    }

   /**
    * Returns the value of the <code>modifiedAsesorEstado</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorEstado</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorEstado() throws SystemException {
        return getAsesorFacet().isModifiedAsesorEstado();
    }

   /**
    * Returns the value of the <code>asesorAccesoValidadorUsuarios</code> attribute.<br>
    * Model Attribute: <code>asesorAccesoValidadorUsuarios</code>. Variable Bool<br>
    * Comments: GdC-40 req 4: Configuración del 'Validador de Usuarios' para rol Asesor<br>
    * @return The value of the <code>asesorAccesoValidadorUsuarios</code> attribute.
    * @throws SystemException in case of any error.
    */
    @JsonProperty(value="accesovalidadorusuarios")
    public Boolean getAfiliacionesAccesoValidadorUsuarios() throws SystemException  {
        return getAsesorAccesoValidadorUsuarios();
    }

    @JsonIgnore
    public Boolean getAsesorAccesoValidadorUsuarios() throws SystemException  {
    	Boolean value;
        value = getAsesorFacet().getAsesorAccesoValidadorUsuarios();
        return value;
    }

   /**
    * Sets the value of the <code>asesorAccesoValidadorUsuarios</code> attribute.<br>
    * Model Attribute: <code>asesorAccesoValidadorUsuarios</code>. Variable Bool<br>
    * Comments: GdC-40 req 4: Configuración del 'Validador de Usuarios' para rol Asesor<br>
    * @param asesorAccesoValidadorUsuarios The new value of the <code>asesorAccesoValidadorUsuarios</code> attribute.
    * @throws SystemException in case of any error.
    */
    public void setAsesorAccesoValidadorUsuarios (Boolean asesorAccesoValidadorUsuarios) throws SystemException {
        getAsesorFacet().setAsesorAccesoValidadorUsuarios(asesorAccesoValidadorUsuarios);
    }

   /**
    * Returns the value of the <code>modifiedAsesorAccesoValidadorUsuarios</code> class property.<br>
    *
    * @return The value of the <code>modifiedAsesorAccesoValidadorUsuarios</code> class property.
    * @throws SystemException in case of any error.
    */
    @JsonIgnore
    public boolean isModifiedAsesorAccesoValidadorUsuarios() throws SystemException {
        return getAsesorFacet().isModifiedAsesorAccesoValidadorUsuarios();
    }

   /**
    * Returns the password of this agent entity.
    * @return password of this agent entity
    */
    public String getPassWord() {
        return passWord;
    }

   /**
    * Sets the password of this agent entity.
    * @param passWord Password of this agent entity
    */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
        this.getParentFuncionario().setPassWord(passWord);
        this.modifiedPassWord = true;
    }

    /**
     * Returns the value of the <code>modifiedPassWord</code> class property.<br>
     * @return The value of the <code>modifiedPassWord</code> class property.
     */
    @JsonIgnore
    public boolean isModifiedPassWord() {
        return modifiedPassWord;
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>Solicitudes</code> role.
     * Model Relationship:
     * <code>[Solicitud] Solicitudes 0:M  ------ 1:1  Agente [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>Solicitudes</code> role.
     */
    @JsonIgnore
    public Collection <Solicitud> getSolicitudes() {
        return (getParentFuncionario() != null ? getParentFuncionario().getSolicitudes() : null);
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>SolicitudesAfiliacion</code> role.
     * Model Relationship:
     * <code>[Solicitud] SolicitudesAfiliacion 0:M  ------ 0:1  UsrAfiliacion [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>SolicitudesAfiliacion</code> role.
     */
    @JsonIgnore
    public Collection <Solicitud> getSolicitudesAfiliacion() {
        return (getParentFuncionario() != null ? getParentFuncionario().getSolicitudesAfiliacion() : null);
    }

    /**
     * Returns the instance of <code>ReportesProcAlm</code> related through the <code>Reportes</code> role.
     * Model Relationship:
     * <code>[ReportesProcAlm] Reportes 0:M  ------ 0:M  Funcionarios [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ReportesProcAlm</code> related through the <code>Reportes</code> role.
     */
    @JsonIgnore
    public Collection <ReportesProcAlm> getReportes() {
        return (getParentFuncionario() != null ? getParentFuncionario().getReportes() : null);
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedad</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] SolicitudesNovedad 0:M  ------ 1:1  Agente [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>SolicitudesNovedad</code> role.
     */
    @JsonIgnore
    public Collection <SolicitudNovedad> getSolicitudesNovedad() {
        return (getParentFuncionario() != null ? getParentFuncionario().getSolicitudesNovedad() : null);
    }

    /**
     * Returns the instance of <code>SolicitudNovedad</code> related through the <code>SolNovAifliaciones</code> role.
     * Model Relationship:
     * <code>[SolicitudNovedad] SolNovAifliaciones 0:M  ------ 0:1  UsrAfiliacion [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>SolicitudNovedad</code> related through the <code>SolNovAifliaciones</code> role.
     */
    @JsonIgnore
    public Collection <SolicitudNovedad> getSolNovAifliaciones() {
        return (getParentFuncionario() != null ? getParentFuncionario().getSolNovAifliaciones() : null);
    }

    /**
     * Returns the instance of <code>GrupoAsignacion</code> related through the <code>GrupoAsignacion</code> role.
     * Model Relationship:
     * <code>[GrupoAsignacion] GrupoAsignacion 0:M  ------ 0:M  Funcionario [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>GrupoAsignacion</code> related through the <code>GrupoAsignacion</code> role.
     */
    @JsonIgnore
    public Collection <GrupoAsignacion> getGrupoAsignacion() {
        return (getParentFuncionario() != null ? getParentFuncionario().getGrupoAsignacion() : null);
    }

    /**
     * Returns the instance of <code>LogFuncionario</code> related through the <code>LogFuncionario</code> role.
     * Model Relationship:
     * <code>[LogFuncionario] LogFuncionario 0:M  ------ 1:1  Funcionario [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>LogFuncionario</code> related through the <code>LogFuncionario</code> role.
     */
    @JsonIgnore
    public Collection <LogFuncionario> getLogFuncionario() {
        return (getParentFuncionario() != null ? getParentFuncionario().getLogFuncionario() : null);
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 0:1  AsesorC [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     */
    @JsonIgnore
    public Collection <ContratoC> getContratosC() {
        return (getParentFuncionario().getChildAsesor() != null ? getParentFuncionario().getChildAsesor().getContratosC() : null);
    }

    /**
     * Returns the instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     * Model Relationship:
     * <code>[AgentexProducto] AgentexProducto 0:M  ------ 1:1  Asesor [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     */
    @JsonIgnore
    public Collection <AgentexProducto> getAgentexProducto() {
        return (getParentFuncionario().getChildAsesor() != null ? getParentFuncionario().getChildAsesor().getAgentexProducto() : null);
    }

    /**
     * Returns the instance of <code>LogInformacionAsesor</code> related through the <code>LogInformacionAsesor</code> role.
     * Model Relationship:
     * <code>[LogInformacionAsesor] LogInformacionAsesor 0:M  ------ 1:1  Asesor [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>LogInformacionAsesor</code> related through the <code>LogInformacionAsesor</code> role.
     */
    @JsonIgnore
    public Collection <LogInformacionAsesor> getLogInformacionAsesor() {
        return (getParentFuncionario().getChildAsesor() != null ? getParentFuncionario().getChildAsesor().getLogInformacionAsesor() : null);
    }

    /**
     * Returns the instance of <code>LogHistoricoPlanes</code> related through the <code>LogHistoricoPlanes</code> role.
     * Model Relationship:
     * <code>[LogHistoricoPlanes] LogHistoricoPlanes 0:M  ------ 1:1  Asesor [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>LogHistoricoPlanes</code> related through the <code>LogHistoricoPlanes</code> role.
     */
    @JsonIgnore
    public Collection <LogHistoricoPlanes> getLogHistoricoPlanes() {
        return (getParentFuncionario().getChildAsesor() != null ? getParentFuncionario().getChildAsesor().getLogHistoricoPlanes() : null);
    }

    /**
     * Returns the instance of <code>Solicitud</code> related through the <code>SolicitudesArMe</code> role.
     * Model Relationship:
     * <code>[Solicitud] SolicitudesArMe 0:M  ------ 0:1  UsrAreaMedica [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Solicitud</code> related through the <code>SolicitudesArMe</code> role.
     */
    @JsonIgnore
    public Collection <Solicitud> getSolicitudesArMe() {
        return (getParentFuncionario().getChildAreaMedica() != null ? getParentFuncionario().getChildAreaMedica().getSolicitudesArMe() : null);
    }

    /**
     * Returns the instance of <code>Firma</code> related through the <code>Firma</code> role.
     * Model Relationship:
     * <code>[Firma] Firma 0:1  ------ 0:1  RespRegional [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Firma</code> related through the <code>Firma</code> role.
     */
    @JsonIgnore
    public Firma getFirma() {
        return (getParentFuncionario().getChildRespRegional() != null ? getParentFuncionario().getChildRespRegional().getFirma() : null);
    }

    /**
     * Returns the instance of <code>Planes</code> related through the <code>Planes</code> role.
     * Model Relationship:
     * <code>[Planes] Planes 0:M  ------ 0:M  Afiliaciones [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Planes</code> related through the <code>Planes</code> role.
     */
    @JsonIgnore
    public Collection <Planes> getPlanes() {
        return planes;
    }

   /**
    * Adds an instance of <code>Planes</code> related through the <code>Planes</code> role.
    * @param planes The instance to add to the <code>Planes</code> role.
    */
    public void add2Planes(Planes planes) {
        this.getPlanes().add(planes);
    }
    /**
     * Sets instances of <code>Planes</code> related through the <code>Planes</code> role.
     * @param planes The new value for the <code>Planes</code> role.
     */
    public void setPlanes(Collection < Planes > planes) {
        this.planes = planes;
    }

   /**
    * This method gets the attribute value <code>modifiedPlanes</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedPlanes</code> has been modified.
    */
    public boolean isModifiedPlanes(){
        return modifiedPlanes;
    }

    /**
     * Returns the instance of <code>Rol</code> related through the <code>Rol</code> role.
     * Model Relationship:
     * <code>[Rol] Rol 1:1  ------ 0:M  Agentes [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Rol</code> related through the <code>Rol</code> role.
     */
    @JsonIgnore
    public Rol getRol() {
        return (getParentFuncionario() != null ? getParentFuncionario().getRol() : null);
    }

    /**
     * Returns the instance of <code>Sucursal</code> related through the <code>Sucursal</code> role.
     * Model Relationship:
     * <code>[Sucursal] Sucursal 1:1  ------ 0:M  Agentes [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Sucursal</code> related through the <code>Sucursal</code> role.
     */
    @JsonIgnore
    public Sucursal getSucursal() {
        return (getParentFuncionario() != null ? getParentFuncionario().getSucursal() : null);
    }

    /**
     * Returns the instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     * Model Relationship:
     * <code>[TipoIdentificacion] TipoIdentificacion 0:1  ------ 0:M  Asesores [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>TipoIdentificacion</code> related through the <code>TipoIdentificacion</code> role.
     */
    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacion() {
        return (getParentFuncionario().getChildAsesor() != null ? getParentFuncionario().getChildAsesor().getTipoIdentificacion() : null);
    }

    /**
     * Returns the instance of <code>Regional</code> related through the <code>Regional</code> role.
     * Model Relationship:
     * <code>[Regional] Regional 0:1  ------ 0:1  RespRegional [Afiliaciones]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Regional</code> related through the <code>Regional</code> role.
     */
    @JsonIgnore
    public Regional getRegional() {
        return (getParentFuncionario().getChildRespRegional() != null ? getParentFuncionario().getChildRespRegional().getRegional() : null);
    }

    /**
     * Returns the parent <code>Funcionario</code> instance.
     * @return The parent <code>Funcionario</code> instance.
     */
    @JsonIgnore
    public Funcionario getParentFuncionario() {
        if (!parentFuncionarioInitialized) {
            setParentFuncionario(afiliacionesRepository.findParent(getFuncionarioId()));
        }
        return parentFuncionario;
    }

    /**
     * Sets the parent <code>Funcionario</code> instance.
     * @param parentFuncionario the parent of this object.
     */
    public void setParentFuncionario (Funcionario parentFuncionario) {
        this.parentFuncionario = parentFuncionario;
        this.parentFuncionarioInitialized = true;
    }

    /**
     * Returns The Facet <code>Funcionario</code> of this instance in an inheritance net.
     * @return the Facet of <code>Funcionario</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public Funcionario getFuncionarioFacet() {
            return getParentFuncionario();
    }

    /**
     * Returns The Facet <code>Admin</code> of this instance in an inheritance net.
     * @return the Facet of <code>Admin</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public Admin getAdminFacet() {
            return getParentFuncionario().getChildAdmin();
    }

    /**
     * Returns The Facet <code>SuperAdmin</code> of this instance in an inheritance net.
     * @return the Facet of <code>SuperAdmin</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public SuperAdmin getSuperAdminFacet() {
            return getParentFuncionario().getChildSuperAdmin();
    }

    /**
     * Returns The Facet <code>Asesor</code> of this instance in an inheritance net.
     * @return the Facet of <code>Asesor</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public Asesor getAsesorFacet() {
            return getParentFuncionario().getChildAsesor();
    }

    /**
     * Returns The Facet <code>AreaMedica</code> of this instance in an inheritance net.
     * @return the Facet of <code>AreaMedica</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public AreaMedica getAreaMedicaFacet() {
            return getParentFuncionario().getChildAreaMedica();
    }

    /**
     * Returns The Facet <code>RespRegional</code> of this instance in an inheritance net.
     * @return the Facet of <code>RespRegional</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public RespRegional getRespRegionalFacet() {
            return getParentFuncionario().getChildRespRegional();
    }

    /**
     * Returns The Facet <code>Gestor</code> of this instance in an inheritance net.
     * @return the Facet of <code>Gestor</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public Gestor getGestorFacet() {
            return getParentFuncionario().getChildGestor();
    }

    /**
     * Returns The Facet <code>MesaDeApoyo</code> of this instance in an inheritance net.
     * @return the Facet of <code>MesaDeApoyo</code> of this instance in an inheritance net.
     */
    @JsonIgnore
    public MesaDeApoyo getMesaDeApoyoFacet() {
            return getParentFuncionario().getChildMesaDeApoyo();
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
     * Computes the value of the <code>funcionariodrvNombreCompleto</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>funcionariodrvNombreCompleto</code> derived attribute.
     */
    public String funcionariodrvNombreCompletoDerivations() {

        getParentFuncionario().funcionariodrvNombreCompleto = null;
        return getParentFuncionario().funcionariodrvNombreCompleto;
    }

    /**
     * Computes the value of the <code>funcionariodrvNomJefe</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>funcionariodrvNomJefe</code> derived attribute.
     */
    public String funcionariodrvNomJefeDerivations() {

        getParentFuncionario().funcionariodrvNomJefe = null;
        return getParentFuncionario().funcionariodrvNomJefe;
    }

    /**
     * Computes the value of the <code>funcionariodrvNomAgencia</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>funcionariodrvNomAgencia</code> derived attribute.
     */
    public String funcionariodrvNomAgenciaDerivations() {

        getParentFuncionario().funcionariodrvNomAgencia = null;
        return getParentFuncionario().funcionariodrvNomAgencia;
    }

    /**
     * Computes the value of the <code>funcionariodrvEsAsesorIntegral</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>funcionariodrvEsAsesorIntegral</code> derived attribute.
     */
    public Boolean funcionariodrvEsAsesorIntegralDerivations() {

        getParentFuncionario().funcionariodrvEsAsesorIntegral = null;
        return getParentFuncionario().funcionariodrvEsAsesorIntegral;
    }

    /**
     * Computes the value of the <code>funcionariodrvEsAfiliacion</code> attribute according to its
     * derivations.
     *
     * @return Computed value of the <code>funcionariodrvEsAfiliacion</code> derived attribute.
     */
    public Boolean funcionariodrvEsAfiliacionDerivations() {

        getParentFuncionario().funcionariodrvEsAfiliacion = null;
        return getParentFuncionario().funcionariodrvEsAfiliacion;
    }
    /**
     * This method initializes the properties of the entity and its relations.
     */
    private void initAttributes() {
        planes = null;
        parentFuncionario = null;
        values = new HashMap<>();
        afiliacionesRepository = Arc.container().select(AfiliacionesJpaRepository.class).get();
        planesRepository = Arc.container().select(PlanesJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Afiliaciones.class.getMethods();
    }


    /**
     * Provides the getter method name of the <code>inheritance</code> inheritance relationship.
     * @param inheritance the relationship name which getter method must be returned
     * @return the getter Method name for the given relationship or "" if the relationship does not exist
     */
    protected String getMethodNameInheritance(String inheritance) {
    	String getMethodName = "";
            if (inheritance.equalsIgnoreCase("parentFuncionario")) {
                getMethodName = "getParentFuncionario";
            }
            if (inheritance.equalsIgnoreCase("funcionariofacet")) {
                getMethodName = "getFuncionarioFacet";
            }
            if (inheritance.equalsIgnoreCase("adminfacet")) {
                getMethodName = "getAdminFacet";
            }
            if (inheritance.equalsIgnoreCase("superadminfacet")) {
                getMethodName = "getSuperAdminFacet";
            }
            if (inheritance.equalsIgnoreCase("asesorfacet")) {
                getMethodName = "getAsesorFacet";
            }
            if (inheritance.equalsIgnoreCase("areamedicafacet")) {
                getMethodName = "getAreaMedicaFacet";
            }
            if (inheritance.equalsIgnoreCase("respregionalfacet")) {
                getMethodName = "getRespRegionalFacet";
            }
            if (inheritance.equalsIgnoreCase("gestorfacet")) {
                getMethodName = "getGestorFacet";
            }
            if (inheritance.equalsIgnoreCase("mesadeapoyofacet")) {
                getMethodName = "getMesaDeApoyoFacet";
            }
        return getMethodName; 
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return AfiliacionesConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedPlanes = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {





        getFuncionarioFacet().cleanDerivations();
    }

    /**
     * Returns the <code>AfiliacionesOid</code> object that identifies this instance of <code>Afiliaciones</code>.
     * @return <code>AfiliacionesOid </code> object that identifies this instance of <code>Afiliaciones</code>
     */
    public AfiliacionesOid getOid() {
        return new AfiliacionesOid(getFuncionarioId());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(AfiliacionesConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
    }


    @Override
    protected boolean isRelatedItemVerticallyVisible(String item) {
        return getSerCtx().getAgent().isAnyFacetActive(AfiliacionesConstants.ROLE_AGENTS.get(item.toUpperCase()));
    }

    /**
     * Gets the list of active facets.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getActiveFacets() {
        return this.getFuncionarioFacet().getFacets();
    }

     /**
     * Gets the list of active facets recursively from the root of the inheritance net.
     * @return the list of active facets.
     */
    @JsonIgnore
    public List<String> getFacets() {
        List<String> activeFacets = new ArrayList<>();

        if (!activeFacets.contains(Constants.AFILIACIONES)) {
            // Add this class
            activeFacets.add(Constants.AFILIACIONES);
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


        // Check inherited Horizontal Visibility Constraints
        if (!getParentFuncionario().checkHorizontalVisibility(agent)) {
            returnValue = false;
        }
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

    public String buildSIAfiliaciones() {
        try {
            return getFuncionarioUsuarioLDAP();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSAfiliaciones() {
        try {
            return getFuncionarioUsuario() + " " + getFuncionarioPrimerNombre() + " " + getFuncionarioSegundoNombre() + " " + getFuncionarioPrimerApellido() + " " + getFuncionarioSegundoApellido();
        } catch(Exception e) {
            return "";
        }
    }

    public String buildDSAfiliacionesMPlanes() {
        try {
            return getFuncionarioUsuarioLDAP() + " " + getFuncionarioPrimerNombre() + " " + getFuncionarioSegundoNombre() + " " + getFuncionarioPrimerApellido() + " " + getFuncionarioSegundoApellido();
        } catch(Exception e) {
            return "";
        }
    }
}
