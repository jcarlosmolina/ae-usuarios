package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.oid.DocumentoGOid;
import com.keralty.aeusuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>DocumentoG</code> external model class.
 * <p>
 * External Model Class: <code>DocumentoG</code><br>
 */
public class DocumentoG extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="identificador")
    private Long documentoGIdentificador;

    @JsonProperty(value="descripcion")
    private String documentoGDescripcion;

    @JsonProperty(value="tipo")
    private Long documentoGTipo;

    @JsonProperty(value="estado")
    private Long documentoGEstado;

    @JsonProperty(value="fechasubida")
    private Timestamp documentoGFechaSubida;

    @JsonProperty(value="pathcompleto")
    private String documentoGPathCompleto;

    @JsonProperty(value="extension")
    private String documentoGExtension;

    @JsonProperty(value="numdescargas")
    private Long documentoGNumDescargas;

    @JsonProperty(value="emailenviodevuelto")
    private String documentoGEmailEnvioDevuelto;

    @JsonProperty(value="resultadosubida")
    private String documentoGResultadoSubida;

    @JsonProperty(value="iddocengestor")
    private String documentoGIdDocEnGestor;

    @JsonProperty(value="nombre")
    private String documentoGNombre;

    @JsonProperty(value="drvnumcontrato")
    private String documentoGDrvNumContrato;

    @JsonProperty(value="usuariocreador")
    private String documentoGUsuarioCreador;

    private Solicitud solicitud;

    private Persona persona;

    /**
     * Gets the value of attribute Identificador
     */
    public Long getDocumentoGIdentificador() {
        return documentoGIdentificador;
    }
    
    /**
     * Sets the value of attribute Identificador
     */
    public void setDocumentoGIdentificador(Long documentoGIdentificador) {
        this.documentoGIdentificador = documentoGIdentificador;
    }

    /**
     * Gets the value of attribute Descripcion
     */
    public String getDocumentoGDescripcion() {
        return documentoGDescripcion;
    }
    
    /**
     * Sets the value of attribute Descripcion
     */
    public void setDocumentoGDescripcion(String documentoGDescripcion) {
        this.documentoGDescripcion = documentoGDescripcion;
    }

    /**
     * Gets the value of attribute Tipo
     */
    public Long getDocumentoGTipo() {
        return documentoGTipo;
    }
    
    /**
     * Sets the value of attribute Tipo
     */
    public void setDocumentoGTipo(Long documentoGTipo) {
        this.documentoGTipo = documentoGTipo;
    }

    /**
     * Gets the value of attribute Estado
     */
    public Long getDocumentoGEstado() {
        return documentoGEstado;
    }
    
    /**
     * Sets the value of attribute Estado
     */
    public void setDocumentoGEstado(Long documentoGEstado) {
        this.documentoGEstado = documentoGEstado;
    }

    /**
     * Gets the value of attribute FechaSubida
     */
    public Timestamp getDocumentoGFechaSubida() {
        return documentoGFechaSubida;
    }
    
    /**
     * Sets the value of attribute FechaSubida
     */
    public void setDocumentoGFechaSubida(Timestamp documentoGFechaSubida) {
        this.documentoGFechaSubida = documentoGFechaSubida;
    }

    /**
     * Gets the value of attribute PathCompleto
     */
    public String getDocumentoGPathCompleto() {
        return documentoGPathCompleto;
    }
    
    /**
     * Sets the value of attribute PathCompleto
     */
    public void setDocumentoGPathCompleto(String documentoGPathCompleto) {
        this.documentoGPathCompleto = documentoGPathCompleto;
    }

    /**
     * Gets the value of attribute Extension
     */
    public String getDocumentoGExtension() {
        return documentoGExtension;
    }
    
    /**
     * Sets the value of attribute Extension
     */
    public void setDocumentoGExtension(String documentoGExtension) {
        this.documentoGExtension = documentoGExtension;
    }

    /**
     * Gets the value of attribute NumDescargas
     */
    public Long getDocumentoGNumDescargas() {
        return documentoGNumDescargas;
    }
    
    /**
     * Sets the value of attribute NumDescargas
     */
    public void setDocumentoGNumDescargas(Long documentoGNumDescargas) {
        this.documentoGNumDescargas = documentoGNumDescargas;
    }

    /**
     * Gets the value of attribute EmailEnvioDevuelto
     */
    public String getDocumentoGEmailEnvioDevuelto() {
        return documentoGEmailEnvioDevuelto;
    }
    
    /**
     * Sets the value of attribute EmailEnvioDevuelto
     */
    public void setDocumentoGEmailEnvioDevuelto(String documentoGEmailEnvioDevuelto) {
        this.documentoGEmailEnvioDevuelto = documentoGEmailEnvioDevuelto;
    }

    /**
     * Gets the value of attribute ResultadoSubida
     */
    public String getDocumentoGResultadoSubida() {
        return documentoGResultadoSubida;
    }
    
    /**
     * Sets the value of attribute ResultadoSubida
     */
    public void setDocumentoGResultadoSubida(String documentoGResultadoSubida) {
        this.documentoGResultadoSubida = documentoGResultadoSubida;
    }

    /**
     * Gets the value of attribute IdDocEnGestor
     */
    public String getDocumentoGIdDocEnGestor() {
        return documentoGIdDocEnGestor;
    }
    
    /**
     * Sets the value of attribute IdDocEnGestor
     */
    public void setDocumentoGIdDocEnGestor(String documentoGIdDocEnGestor) {
        this.documentoGIdDocEnGestor = documentoGIdDocEnGestor;
    }

    /**
     * Gets the value of attribute Nombre
     */
    public String getDocumentoGNombre() {
        return documentoGNombre;
    }
    
    /**
     * Sets the value of attribute Nombre
     */
    public void setDocumentoGNombre(String documentoGNombre) {
        this.documentoGNombre = documentoGNombre;
    }

    /**
     * Gets the value of attribute DrvNumContrato
     */
    public String getDocumentoGDrvNumContrato() {
        return documentoGDrvNumContrato;
    }
    
    /**
     * Sets the value of attribute DrvNumContrato
     */
    public void setDocumentoGDrvNumContrato(String documentoGDrvNumContrato) {
        this.documentoGDrvNumContrato = documentoGDrvNumContrato;
    }

    /**
     * Gets the value of attribute UsuarioCreador
     */
    public String getDocumentoGUsuarioCreador() {
        return documentoGUsuarioCreador;
    }
    
    /**
     * Sets the value of attribute UsuarioCreador
     */
    public void setDocumentoGUsuarioCreador(String documentoGUsuarioCreador) {
        this.documentoGUsuarioCreador = documentoGUsuarioCreador;
    }

    /**
     * Gets the value of relation through role Solicitud
     */
    @JsonIgnore
    public Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * Gets the value of relation through role Persona
     */
    @JsonIgnore
    public Persona getPersona() {
        return persona;
    }

    /**
     * Default constructor
     */
    public DocumentoG() {
        documentoGIdentificador = null;
    }

    /**
     * Constructor used to create instances of <code>DocumentoG</code>.
     * @param oid Object Identifier of the instance of <code>DocumentoG</code> to be created.
     * @throws SystemException
     */
    public DocumentoG(DocumentoGOid oid) {
        if (oid != null && !oid.isNull()) {
            documentoGIdentificador = oid.getDocumentoGIdentificador();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return DocumentoG.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        DocumentoG other = (DocumentoG)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getDocumentoGIdentificador(), other.getDocumentoGIdentificador());
        result &= Utilities.isEqual(this.getDocumentoGDescripcion(), other.getDocumentoGDescripcion());
        result &= Utilities.isEqual(this.getDocumentoGTipo(), other.getDocumentoGTipo());
        result &= Utilities.isEqual(this.getDocumentoGEstado(), other.getDocumentoGEstado());
        result &= Utilities.isEqual(this.getDocumentoGFechaSubida(), other.getDocumentoGFechaSubida());
        result &= Utilities.isEqual(this.getDocumentoGPathCompleto(), other.getDocumentoGPathCompleto());
        result &= Utilities.isEqual(this.getDocumentoGExtension(), other.getDocumentoGExtension());
        result &= Utilities.isEqual(this.getDocumentoGNumDescargas(), other.getDocumentoGNumDescargas());
        result &= Utilities.isEqual(this.getDocumentoGEmailEnvioDevuelto(), other.getDocumentoGEmailEnvioDevuelto());
        result &= Utilities.isEqual(this.getDocumentoGResultadoSubida(), other.getDocumentoGResultadoSubida());
        result &= Utilities.isEqual(this.getDocumentoGIdDocEnGestor(), other.getDocumentoGIdDocEnGestor());
        result &= Utilities.isEqual(this.getDocumentoGNombre(), other.getDocumentoGNombre());
        result &= Utilities.isEqual(this.getDocumentoGDrvNumContrato(), other.getDocumentoGDrvNumContrato());
        result &= Utilities.isEqual(this.getDocumentoGUsuarioCreador(), other.getDocumentoGUsuarioCreador());
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
     * Returns the <code>DocumentoGOid</code> object that identifies this instance of <code>DocumentoG</code>.
     * @return <code>DocumentoGOid</code> object that identifies this instance of <code>DocumentoG</code>
     */
    public DocumentoGOid getOid() {
        return new DocumentoGOid(getDocumentoGIdentificador());
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
        if (!activeFacets.contains(Constants.DOCUMENTOG)) {
            activeFacets.add(Constants.DOCUMENTOG);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
