package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.oid.ParentescoDomOid;
import com.keralty.aeusuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>ParentescoDom</code> external model class.
 * <p>
 * External Model Class: <code>ParentescoDom</code><br>
 */
public class ParentescoDom extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="numero")
    private Long dominioNumero;

    @JsonProperty(value="identificador")
    private Long parentescoDomIdentificador;

    @JsonProperty(value="edadminimaa")
    private Long parentescoDomEdadMinimaA;

    @JsonProperty(value="edadmaximaa")
    private Long parentescoDomEdadMaximaA;

    @JsonProperty(value="edadminimad")
    private Long parentescoDomEdadMinimaD;

    @JsonProperty(value="edadmaximap")
    private Long parentescoDomEdadMaximaP;

    private Dominio dominio;

    private Parentesco parentesco;

    /**
     * Gets the value of attribute Numero
     */
    public Long getDominioNumero() {
        return dominioNumero;
    }
    
    /**
     * Sets the value of attribute Numero
     */
    public void setDominioNumero(Long dominioNumero) {
        this.dominioNumero = dominioNumero;
    }

    /**
     * Gets the value of attribute Identificador
     */
    public Long getParentescoDomIdentificador() {
        return parentescoDomIdentificador;
    }
    
    /**
     * Sets the value of attribute Identificador
     */
    public void setParentescoDomIdentificador(Long parentescoDomIdentificador) {
        this.parentescoDomIdentificador = parentescoDomIdentificador;
    }

    /**
     * Gets the value of attribute EdadMinimaA
     */
    public Long getParentescoDomEdadMinimaA() {
        return parentescoDomEdadMinimaA;
    }
    
    /**
     * Sets the value of attribute EdadMinimaA
     */
    public void setParentescoDomEdadMinimaA(Long parentescoDomEdadMinimaA) {
        this.parentescoDomEdadMinimaA = parentescoDomEdadMinimaA;
    }

    /**
     * Gets the value of attribute EdadMaximaA
     */
    public Long getParentescoDomEdadMaximaA() {
        return parentescoDomEdadMaximaA;
    }
    
    /**
     * Sets the value of attribute EdadMaximaA
     */
    public void setParentescoDomEdadMaximaA(Long parentescoDomEdadMaximaA) {
        this.parentescoDomEdadMaximaA = parentescoDomEdadMaximaA;
    }

    /**
     * Gets the value of attribute EdadMinimaD
     */
    public Long getParentescoDomEdadMinimaD() {
        return parentescoDomEdadMinimaD;
    }
    
    /**
     * Sets the value of attribute EdadMinimaD
     */
    public void setParentescoDomEdadMinimaD(Long parentescoDomEdadMinimaD) {
        this.parentescoDomEdadMinimaD = parentescoDomEdadMinimaD;
    }

    /**
     * Gets the value of attribute EdadMaximaP
     */
    public Long getParentescoDomEdadMaximaP() {
        return parentescoDomEdadMaximaP;
    }
    
    /**
     * Sets the value of attribute EdadMaximaP
     */
    public void setParentescoDomEdadMaximaP(Long parentescoDomEdadMaximaP) {
        this.parentescoDomEdadMaximaP = parentescoDomEdadMaximaP;
    }

    /**
     * Gets the value of relation through role Dominio
     */
    @JsonIgnore
    public Dominio getDominio() {
        return dominio;
    }

    /**
     * Gets the value of relation through role Parentesco
     */
    @JsonIgnore
    public Parentesco getParentesco() {
        return parentesco;
    }

    /**
     * Default constructor
     */
    public ParentescoDom() {
        dominioNumero = null;
        parentescoDomIdentificador = null;
    }

    /**
     * Constructor used to create instances of <code>ParentescoDom</code>.
     * @param oid Object Identifier of the instance of <code>ParentescoDom</code> to be created.
     * @throws SystemException
     */
    public ParentescoDom(ParentescoDomOid oid) {
        if (oid != null && !oid.isNull()) {
            dominioNumero = oid.getDominioNumero();
            parentescoDomIdentificador = oid.getParentescoDomIdentificador();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return ParentescoDom.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        ParentescoDom other = (ParentescoDom)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getParentescoDomIdentificador(), other.getParentescoDomIdentificador());
        result &= Utilities.isEqual(this.getParentescoDomEdadMinimaA(), other.getParentescoDomEdadMinimaA());
        result &= Utilities.isEqual(this.getParentescoDomEdadMaximaA(), other.getParentescoDomEdadMaximaA());
        result &= Utilities.isEqual(this.getParentescoDomEdadMinimaD(), other.getParentescoDomEdadMinimaD());
        result &= Utilities.isEqual(this.getParentescoDomEdadMaximaP(), other.getParentescoDomEdadMaximaP());
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
     * Returns the <code>ParentescoDomOid</code> object that identifies this instance of <code>ParentescoDom</code>.
     * @return <code>ParentescoDomOid</code> object that identifies this instance of <code>ParentescoDom</code>
     */
    public ParentescoDomOid getOid() {
        return new ParentescoDomOid(getDominioNumero(), getParentescoDomIdentificador());
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
        if (!activeFacets.contains(Constants.PARENTESCODOM)) {
            activeFacets.add(Constants.PARENTESCODOM);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
