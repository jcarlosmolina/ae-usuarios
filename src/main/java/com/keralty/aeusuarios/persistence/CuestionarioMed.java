package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.oid.CuestionarioMedOid;
import com.keralty.aeusuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>CuestionarioMed</code> external model class.
 * <p>
 * External Model Class: <code>CuestionarioMed</code><br>
 */
public class CuestionarioMed extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="numero")
    private Long cuestionarioMedNumero;

    @JsonProperty(value="nombre")
    private String cuestionarioMedNombre;

    /**
     * Gets the value of attribute Numero
     */
    public Long getCuestionarioMedNumero() {
        return cuestionarioMedNumero;
    }
    
    /**
     * Sets the value of attribute Numero
     */
    public void setCuestionarioMedNumero(Long cuestionarioMedNumero) {
        this.cuestionarioMedNumero = cuestionarioMedNumero;
    }

    /**
     * Gets the value of attribute Nombre
     */
    public String getCuestionarioMedNombre() {
        return cuestionarioMedNombre;
    }
    
    /**
     * Sets the value of attribute Nombre
     */
    public void setCuestionarioMedNombre(String cuestionarioMedNombre) {
        this.cuestionarioMedNombre = cuestionarioMedNombre;
    }

    /**
     * Default constructor
     */
    public CuestionarioMed() {
        cuestionarioMedNumero = null;
    }

    /**
     * Constructor used to create instances of <code>CuestionarioMed</code>.
     * @param oid Object Identifier of the instance of <code>CuestionarioMed</code> to be created.
     * @throws SystemException
     */
    public CuestionarioMed(CuestionarioMedOid oid) {
        if (oid != null && !oid.isNull()) {
            cuestionarioMedNumero = oid.getCuestionarioMedNumero();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return CuestionarioMed.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        CuestionarioMed other = (CuestionarioMed)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getCuestionarioMedNumero(), other.getCuestionarioMedNumero());
        result &= Utilities.isEqual(this.getCuestionarioMedNombre(), other.getCuestionarioMedNombre());
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
     * Returns the <code>CuestionarioMedOid</code> object that identifies this instance of <code>CuestionarioMed</code>.
     * @return <code>CuestionarioMedOid</code> object that identifies this instance of <code>CuestionarioMed</code>
     */
    public CuestionarioMedOid getOid() {
        return new CuestionarioMedOid(getCuestionarioMedNumero());
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
        if (!activeFacets.contains(Constants.CUESTIONARIOMED)) {
            activeFacets.add(Constants.CUESTIONARIOMED);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
