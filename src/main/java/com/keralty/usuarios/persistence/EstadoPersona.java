package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.persistence.oid.EstadoPersonaOid;
import com.keralty.usuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>EstadoPersona</code> external model class.
 * <p>
 * External Model Class: <code>EstadoPersona</code><br>
 */
public class EstadoPersona extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="codigo")
    private Long estadoPersonaCodigo;

    @JsonProperty(value="descripcion")
    private String estadoPersonaDescripcion;

    @JsonProperty(value="unbeneficiariodistino")
    private Boolean estadoPersonaUnBeneficiarioDistino;

    @JsonProperty(value="prohibidobeneficiarios")
    private Boolean estadoPersonaProhibidoBeneficiarios;

    @JsonProperty(value="prohibidocontratante")
    private Boolean estadoPersonaProhibidoContratante;

    @JsonProperty(value="prohibidotitular")
    private Boolean estadoPersonaProhibidoTitular;

    private Collection <Persona> personas;

    private Collection <PersonaC> personasC;

    /**
     * Gets the value of attribute Codigo
     */
    public Long getEstadoPersonaCodigo() {
        return estadoPersonaCodigo;
    }
    
    /**
     * Sets the value of attribute Codigo
     */
    public void setEstadoPersonaCodigo(Long estadoPersonaCodigo) {
        this.estadoPersonaCodigo = estadoPersonaCodigo;
    }

    /**
     * Gets the value of attribute Descripcion
     */
    public String getEstadoPersonaDescripcion() {
        return estadoPersonaDescripcion;
    }
    
    /**
     * Sets the value of attribute Descripcion
     */
    public void setEstadoPersonaDescripcion(String estadoPersonaDescripcion) {
        this.estadoPersonaDescripcion = estadoPersonaDescripcion;
    }

    /**
     * Gets the value of attribute UnBeneficiarioDistino
     */
    public Boolean getEstadoPersonaUnBeneficiarioDistino() {
        return estadoPersonaUnBeneficiarioDistino;
    }
    
    /**
     * Sets the value of attribute UnBeneficiarioDistino
     */
    public void setEstadoPersonaUnBeneficiarioDistino(Boolean estadoPersonaUnBeneficiarioDistino) {
        this.estadoPersonaUnBeneficiarioDistino = estadoPersonaUnBeneficiarioDistino;
    }

    /**
     * Gets the value of attribute ProhibidoBeneficiarios
     */
    public Boolean getEstadoPersonaProhibidoBeneficiarios() {
        return estadoPersonaProhibidoBeneficiarios;
    }
    
    /**
     * Sets the value of attribute ProhibidoBeneficiarios
     */
    public void setEstadoPersonaProhibidoBeneficiarios(Boolean estadoPersonaProhibidoBeneficiarios) {
        this.estadoPersonaProhibidoBeneficiarios = estadoPersonaProhibidoBeneficiarios;
    }

    /**
     * Gets the value of attribute ProhibidoContratante
     */
    public Boolean getEstadoPersonaProhibidoContratante() {
        return estadoPersonaProhibidoContratante;
    }
    
    /**
     * Sets the value of attribute ProhibidoContratante
     */
    public void setEstadoPersonaProhibidoContratante(Boolean estadoPersonaProhibidoContratante) {
        this.estadoPersonaProhibidoContratante = estadoPersonaProhibidoContratante;
    }

    /**
     * Gets the value of attribute ProhibidoTitular
     */
    public Boolean getEstadoPersonaProhibidoTitular() {
        return estadoPersonaProhibidoTitular;
    }
    
    /**
     * Sets the value of attribute ProhibidoTitular
     */
    public void setEstadoPersonaProhibidoTitular(Boolean estadoPersonaProhibidoTitular) {
        this.estadoPersonaProhibidoTitular = estadoPersonaProhibidoTitular;
    }

    /**
     * Gets the value of relation through role Personas
     */
    @JsonIgnore
    public Collection <Persona> getPersonas() {
        return personas;
    }

    /**
     * Gets the value of relation through role PersonasC
     */
    @JsonIgnore
    public Collection <PersonaC> getPersonasC() {
        return personasC;
    }

    /**
     * Default constructor
     */
    public EstadoPersona() {
        estadoPersonaCodigo = null;
    }

    /**
     * Constructor used to create instances of <code>EstadoPersona</code>.
     * @param oid Object Identifier of the instance of <code>EstadoPersona</code> to be created.
     * @throws SystemException
     */
    public EstadoPersona(EstadoPersonaOid oid) {
        if (oid != null && !oid.isNull()) {
            estadoPersonaCodigo = oid.getEstadoPersonaCodigo();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return EstadoPersona.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        EstadoPersona other = (EstadoPersona)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getEstadoPersonaCodigo(), other.getEstadoPersonaCodigo());
        result &= Utilities.isEqual(this.getEstadoPersonaDescripcion(), other.getEstadoPersonaDescripcion());
        result &= Utilities.isEqual(this.getEstadoPersonaUnBeneficiarioDistino(), other.getEstadoPersonaUnBeneficiarioDistino());
        result &= Utilities.isEqual(this.getEstadoPersonaProhibidoBeneficiarios(), other.getEstadoPersonaProhibidoBeneficiarios());
        result &= Utilities.isEqual(this.getEstadoPersonaProhibidoContratante(), other.getEstadoPersonaProhibidoContratante());
        result &= Utilities.isEqual(this.getEstadoPersonaProhibidoTitular(), other.getEstadoPersonaProhibidoTitular());
        return result;
    }

    @Override
    @JsonIgnore
    public int hashCode() {
        return 0;
    }

    @JsonIgnore
    public boolean isNull() {
        return false;
    }

    /**
     * Returns the <code>EstadoPersonaOid</code> object that identifies this instance of <code>EstadoPersona</code>.
     * @return <code>EstadoPersonaOid</code> object that identifies this instance of <code>EstadoPersona</code>
     */
    public EstadoPersonaOid getOid() {
        return new EstadoPersonaOid(getEstadoPersonaCodigo());
    }

    @Override
    public boolean checkHorizontalVisibility(IEntity agent) {
        return true;
    }

    @Override
    public void checkIntegrityConstraints() throws ModelException, SystemException {
    }

    @JsonIgnore
    @Override
    public Map<String, Object> getValues() {
        return null;
    }

    @Override
    public void cleanDerivations() throws SystemException {

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

        // Add this class
        if (!activeFacets.contains(Constants.ESTADOPERSONA)) {
            activeFacets.add(Constants.ESTADOPERSONA);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
