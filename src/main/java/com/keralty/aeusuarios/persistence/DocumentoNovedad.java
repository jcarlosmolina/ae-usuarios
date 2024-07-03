package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.oid.DocumentoNovedadOid;
import com.keralty.aeusuarios.utils.Utilities;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representation of the <code>DocumentoNovedad</code> external model class.
 * <p>
 * External Model Class: <code>DocumentoNovedad</code><br>
 */
public class DocumentoNovedad extends AbstractAppEntity {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="iddocumento")
    private Long documentoNovedadIdDocumento;

    @JsonProperty(value="tipo")
    private Long documentoNovedadTipo;

    @JsonProperty(value="fechasubida")
    private Timestamp documentoNovedadFechaSubida;

    @JsonProperty(value="descripcion")
    private String documentoNovedadDescripcion;

    @JsonProperty(value="estado")
    private Long documentoNovedadEstado;

    @JsonProperty(value="pathcompleto")
    private String documentoNovedadPathCompleto;

    @JsonProperty(value="extension")
    private String documentoNovedadExtension;

    @JsonProperty(value="resultadosubida")
    private String documentoNovedadResultadoSubida;

    @JsonProperty(value="iddocengestor")
    private String documentoNovedadIdDocEnGestor;

    @JsonProperty(value="nombre")
    private String documentoNovedadNombre;

    @JsonProperty(value="usuariocreador")
    private String documentoNovedadUsuarioCreador;

    private SolicitudNovedad solicitud;

    private UsuarioNovedad usuario;

    /**
     * Gets the value of attribute IdDocumento
     */
    public Long getDocumentoNovedadIdDocumento() {
        return documentoNovedadIdDocumento;
    }
    
    /**
     * Sets the value of attribute IdDocumento
     */
    public void setDocumentoNovedadIdDocumento(Long documentoNovedadIdDocumento) {
        this.documentoNovedadIdDocumento = documentoNovedadIdDocumento;
    }

    /**
     * Gets the value of attribute Tipo
     */
    public Long getDocumentoNovedadTipo() {
        return documentoNovedadTipo;
    }
    
    /**
     * Sets the value of attribute Tipo
     */
    public void setDocumentoNovedadTipo(Long documentoNovedadTipo) {
        this.documentoNovedadTipo = documentoNovedadTipo;
    }

    /**
     * Gets the value of attribute FechaSubida
     */
    public Timestamp getDocumentoNovedadFechaSubida() {
        return documentoNovedadFechaSubida;
    }
    
    /**
     * Sets the value of attribute FechaSubida
     */
    public void setDocumentoNovedadFechaSubida(Timestamp documentoNovedadFechaSubida) {
        this.documentoNovedadFechaSubida = documentoNovedadFechaSubida;
    }

    /**
     * Gets the value of attribute Descripcion
     */
    public String getDocumentoNovedadDescripcion() {
        return documentoNovedadDescripcion;
    }
    
    /**
     * Sets the value of attribute Descripcion
     */
    public void setDocumentoNovedadDescripcion(String documentoNovedadDescripcion) {
        this.documentoNovedadDescripcion = documentoNovedadDescripcion;
    }

    /**
     * Gets the value of attribute Estado
     */
    public Long getDocumentoNovedadEstado() {
        return documentoNovedadEstado;
    }
    
    /**
     * Sets the value of attribute Estado
     */
    public void setDocumentoNovedadEstado(Long documentoNovedadEstado) {
        this.documentoNovedadEstado = documentoNovedadEstado;
    }

    /**
     * Gets the value of attribute PathCompleto
     */
    public String getDocumentoNovedadPathCompleto() {
        return documentoNovedadPathCompleto;
    }
    
    /**
     * Sets the value of attribute PathCompleto
     */
    public void setDocumentoNovedadPathCompleto(String documentoNovedadPathCompleto) {
        this.documentoNovedadPathCompleto = documentoNovedadPathCompleto;
    }

    /**
     * Gets the value of attribute Extension
     */
    public String getDocumentoNovedadExtension() {
        return documentoNovedadExtension;
    }
    
    /**
     * Sets the value of attribute Extension
     */
    public void setDocumentoNovedadExtension(String documentoNovedadExtension) {
        this.documentoNovedadExtension = documentoNovedadExtension;
    }

    /**
     * Gets the value of attribute ResultadoSubida
     */
    public String getDocumentoNovedadResultadoSubida() {
        return documentoNovedadResultadoSubida;
    }
    
    /**
     * Sets the value of attribute ResultadoSubida
     */
    public void setDocumentoNovedadResultadoSubida(String documentoNovedadResultadoSubida) {
        this.documentoNovedadResultadoSubida = documentoNovedadResultadoSubida;
    }

    /**
     * Gets the value of attribute IdDocEnGestor
     */
    public String getDocumentoNovedadIdDocEnGestor() {
        return documentoNovedadIdDocEnGestor;
    }
    
    /**
     * Sets the value of attribute IdDocEnGestor
     */
    public void setDocumentoNovedadIdDocEnGestor(String documentoNovedadIdDocEnGestor) {
        this.documentoNovedadIdDocEnGestor = documentoNovedadIdDocEnGestor;
    }

    /**
     * Gets the value of attribute Nombre
     */
    public String getDocumentoNovedadNombre() {
        return documentoNovedadNombre;
    }
    
    /**
     * Sets the value of attribute Nombre
     */
    public void setDocumentoNovedadNombre(String documentoNovedadNombre) {
        this.documentoNovedadNombre = documentoNovedadNombre;
    }

    /**
     * Gets the value of attribute UsuarioCreador
     */
    public String getDocumentoNovedadUsuarioCreador() {
        return documentoNovedadUsuarioCreador;
    }
    
    /**
     * Sets the value of attribute UsuarioCreador
     */
    public void setDocumentoNovedadUsuarioCreador(String documentoNovedadUsuarioCreador) {
        this.documentoNovedadUsuarioCreador = documentoNovedadUsuarioCreador;
    }

    /**
     * Gets the value of relation through role Solicitud
     */
    @JsonIgnore
    public SolicitudNovedad getSolicitud() {
        return solicitud;
    }

    /**
     * Gets the value of relation through role Usuario
     */
    @JsonIgnore
    public UsuarioNovedad getUsuario() {
        return usuario;
    }

    /**
     * Default constructor
     */
    public DocumentoNovedad() {
        documentoNovedadIdDocumento = null;
    }

    /**
     * Constructor used to create instances of <code>DocumentoNovedad</code>.
     * @param oid Object Identifier of the instance of <code>DocumentoNovedad</code> to be created.
     * @throws SystemException
     */
    public DocumentoNovedad(DocumentoNovedadOid oid) {
        if (oid != null && !oid.isNull()) {
            documentoNovedadIdDocumento = oid.getDocumentoNovedadIdDocumento();
        }
    }

    @Override
    protected Method[] getMethods() {
    	return DocumentoNovedad.class.getMethods();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        DocumentoNovedad other = (DocumentoNovedad)obj;
        boolean result = true;
        result &= Utilities.isEqual(this.getDocumentoNovedadIdDocumento(), other.getDocumentoNovedadIdDocumento());
        result &= Utilities.isEqual(this.getDocumentoNovedadTipo(), other.getDocumentoNovedadTipo());
        result &= Utilities.isEqual(this.getDocumentoNovedadFechaSubida(), other.getDocumentoNovedadFechaSubida());
        result &= Utilities.isEqual(this.getDocumentoNovedadDescripcion(), other.getDocumentoNovedadDescripcion());
        result &= Utilities.isEqual(this.getDocumentoNovedadEstado(), other.getDocumentoNovedadEstado());
        result &= Utilities.isEqual(this.getDocumentoNovedadPathCompleto(), other.getDocumentoNovedadPathCompleto());
        result &= Utilities.isEqual(this.getDocumentoNovedadExtension(), other.getDocumentoNovedadExtension());
        result &= Utilities.isEqual(this.getDocumentoNovedadResultadoSubida(), other.getDocumentoNovedadResultadoSubida());
        result &= Utilities.isEqual(this.getDocumentoNovedadIdDocEnGestor(), other.getDocumentoNovedadIdDocEnGestor());
        result &= Utilities.isEqual(this.getDocumentoNovedadNombre(), other.getDocumentoNovedadNombre());
        result &= Utilities.isEqual(this.getDocumentoNovedadUsuarioCreador(), other.getDocumentoNovedadUsuarioCreador());
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
     * Returns the <code>DocumentoNovedadOid</code> object that identifies this instance of <code>DocumentoNovedad</code>.
     * @return <code>DocumentoNovedadOid</code> object that identifies this instance of <code>DocumentoNovedad</code>
     */
    public DocumentoNovedadOid getOid() {
        return new DocumentoNovedadOid(getDocumentoNovedadIdDocumento());
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
        if (!activeFacets.contains(Constants.DOCUMENTONOVEDAD)) {
            activeFacets.add(Constants.DOCUMENTONOVEDAD);
        }

        return activeFacets;
    }

    @Override
    public void clearModifiedFlags() throws SystemException {

    }
}
