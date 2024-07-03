package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.oid.PaisOid;
import com.keralty.aeusuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>Pais</code> external model class.
 * <p>
 * External Model Class: <code>Pais</code><br>
 */
public class Pais extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="codigo")
    private String paisCodigo;

    @JsonProperty(value="descripcion")
    private String paisDescripcion;

    private Collection <Direccion> direcciones;

    private Collection <NovedadCT> novedadCT;

    /**
     * Gets the value of attribute Codigo
     */
    public String getPaisCodigo() {
        return paisCodigo;
    }
    
    /**
     * Sets the value of attribute Codigo
     */
    public void setPaisCodigo(String paisCodigo) {
        this.paisCodigo = paisCodigo;
    }

    /**
     * Gets the value of attribute Descripcion
     */
    public String getPaisDescripcion() {
        return paisDescripcion;
    }
    
    /**
     * Sets the value of attribute Descripcion
     */
    public void setPaisDescripcion(String paisDescripcion) {
        this.paisDescripcion = paisDescripcion;
    }

    /**
     * Gets the value of relation through role Direcciones
     */
    @JsonIgnore
    public Collection <Direccion> getDirecciones() {
        return direcciones;
    }

    /**
     * Gets the value of relation through role NovedadCT
     */
    @JsonIgnore
    public Collection <NovedadCT> getNovedadCT() {
        return novedadCT;
    }

    /**
     * Default constructor
     */
    public Pais() {
        paisCodigo = null;
    }

    /**
     * Constructor used to create instances of <code>Pais</code>.
     * @param oid Object Identifier of the instance of <code>Pais</code> to be created.
     * @throws SystemException
     */
    public Pais(PaisOid oid) {
        if (oid != null && !oid.isNull()) {
            paisCodigo = oid.getPaisCodigo();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return Pais.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Pais other = (Pais)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getPaisCodigo(), other.getPaisCodigo());
        result &= Utilities.isEqual(this.getPaisDescripcion(), other.getPaisDescripcion());
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
     * Returns the <code>PaisOid</code> object that identifies this instance of <code>Pais</code>.
     * @return <code>PaisOid</code> object that identifies this instance of <code>Pais</code>
     */
    public PaisOid getOid() {
        return new PaisOid(getPaisCodigo());
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
        if (!activeFacets.contains(Constants.PAIS)) {
            activeFacets.add(Constants.PAIS);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
