package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.oid.EstadoCivilOid;
import com.keralty.aeusuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>EstadoCivil</code> external model class.
 * <p>
 * External Model Class: <code>EstadoCivil</code><br>
 */
public class EstadoCivil extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="codigo")
    private Long estadoCivilCodigo;

    @JsonProperty(value="descripcion")
    private String estadoCivilDescripcion;

    @JsonProperty(value="nombrecorto")
    private String estadoCivilNombreCorto;

    private Collection <Persona> personas;

    private Collection <PersonaC> personasC;

    /**
     * Gets the value of attribute Codigo
     */
    public Long getEstadoCivilCodigo() {
        return estadoCivilCodigo;
    }
    
    /**
     * Sets the value of attribute Codigo
     */
    public void setEstadoCivilCodigo(Long estadoCivilCodigo) {
        this.estadoCivilCodigo = estadoCivilCodigo;
    }

    /**
     * Gets the value of attribute Descripcion
     */
    public String getEstadoCivilDescripcion() {
        return estadoCivilDescripcion;
    }
    
    /**
     * Sets the value of attribute Descripcion
     */
    public void setEstadoCivilDescripcion(String estadoCivilDescripcion) {
        this.estadoCivilDescripcion = estadoCivilDescripcion;
    }

    /**
     * Gets the value of attribute NombreCorto
     */
    public String getEstadoCivilNombreCorto() {
        return estadoCivilNombreCorto;
    }
    
    /**
     * Sets the value of attribute NombreCorto
     */
    public void setEstadoCivilNombreCorto(String estadoCivilNombreCorto) {
        this.estadoCivilNombreCorto = estadoCivilNombreCorto;
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
    public EstadoCivil() {
        estadoCivilCodigo = null;
    }

    /**
     * Constructor used to create instances of <code>EstadoCivil</code>.
     * @param oid Object Identifier of the instance of <code>EstadoCivil</code> to be created.
     * @throws SystemException
     */
    public EstadoCivil(EstadoCivilOid oid) {
        if (oid != null && !oid.isNull()) {
            estadoCivilCodigo = oid.getEstadoCivilCodigo();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return EstadoCivil.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        EstadoCivil other = (EstadoCivil)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getEstadoCivilCodigo(), other.getEstadoCivilCodigo());
        result &= Utilities.isEqual(this.getEstadoCivilDescripcion(), other.getEstadoCivilDescripcion());
        result &= Utilities.isEqual(this.getEstadoCivilNombreCorto(), other.getEstadoCivilNombreCorto());
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
     * Returns the <code>EstadoCivilOid</code> object that identifies this instance of <code>EstadoCivil</code>.
     * @return <code>EstadoCivilOid</code> object that identifies this instance of <code>EstadoCivil</code>
     */
    public EstadoCivilOid getOid() {
        return new EstadoCivilOid(getEstadoCivilCodigo());
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
        if (!activeFacets.contains(Constants.ESTADOCIVIL)) {
            activeFacets.add(Constants.ESTADOCIVIL);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
