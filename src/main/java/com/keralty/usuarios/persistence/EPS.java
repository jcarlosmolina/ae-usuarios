package com.keralty.usuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.ModelException;
import com.keralty.usuarios.exception.SystemException;
import com.keralty.usuarios.global.Constants;
import com.keralty.usuarios.persistence.oid.EPSOid;
import com.keralty.usuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>EPS</code> external model class.
 * <p>
 * External Model Class: <code>EPS</code><br>
 */
public class EPS extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="codigo")
    private Long ePSCodigo;

    @JsonProperty(value="descripcion")
    private String ePSDescripcion;

    @JsonProperty(value="epssanitas")
    private Boolean ePSEPSSanitas;

    private Collection <Usuario> atributosUsuario;

    private Collection <BeneficiarioC> beneficiariosC;

    /**
     * Gets the value of attribute Codigo
     */
    public Long getEPSCodigo() {
        return ePSCodigo;
    }
    
    /**
     * Sets the value of attribute Codigo
     */
    public void setEPSCodigo(Long ePSCodigo) {
        this.ePSCodigo = ePSCodigo;
    }

    /**
     * Gets the value of attribute Descripcion
     */
    public String getEPSDescripcion() {
        return ePSDescripcion;
    }
    
    /**
     * Sets the value of attribute Descripcion
     */
    public void setEPSDescripcion(String ePSDescripcion) {
        this.ePSDescripcion = ePSDescripcion;
    }

    /**
     * Gets the value of attribute EPSSanitas
     */
    public Boolean getEPSEPSSanitas() {
        return ePSEPSSanitas;
    }
    
    /**
     * Sets the value of attribute EPSSanitas
     */
    public void setEPSEPSSanitas(Boolean ePSEPSSanitas) {
        this.ePSEPSSanitas = ePSEPSSanitas;
    }

    /**
     * Gets the value of relation through role AtributosUsuario
     */
    @JsonIgnore
    public Collection <Usuario> getAtributosUsuario() {
        return atributosUsuario;
    }

    /**
     * Gets the value of relation through role BeneficiariosC
     */
    @JsonIgnore
    public Collection <BeneficiarioC> getBeneficiariosC() {
        return beneficiariosC;
    }

    /**
     * Default constructor
     */
    public EPS() {
        ePSCodigo = null;
    }

    /**
     * Constructor used to create instances of <code>EPS</code>.
     * @param oid Object Identifier of the instance of <code>EPS</code> to be created.
     * @throws SystemException
     */
    public EPS(EPSOid oid) {
        if (oid != null && !oid.isNull()) {
            ePSCodigo = oid.getEPSCodigo();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return EPS.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        EPS other = (EPS)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getEPSCodigo(), other.getEPSCodigo());
        result &= Utilities.isEqual(this.getEPSDescripcion(), other.getEPSDescripcion());
        result &= Utilities.isEqual(this.getEPSEPSSanitas(), other.getEPSEPSSanitas());
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
     * Returns the <code>EPSOid</code> object that identifies this instance of <code>EPS</code>.
     * @return <code>EPSOid</code> object that identifies this instance of <code>EPS</code>
     */
    public EPSOid getOid() {
        return new EPSOid(getEPSCodigo());
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
        if (!activeFacets.contains(Constants.EPS)) {
            activeFacets.add(Constants.EPS);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
