package com.keralty.aeusuarios.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.IntegrityConstraintException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.repository.AgentexProductoJpaRepository;
import com.keralty.aeusuarios.repository.ContratoCJpaRepository;
import com.keralty.aeusuarios.repository.DominioJpaRepository;
import com.keralty.aeusuarios.repository.PlanesJpaRepository;
import io.quarkus.arc.Arc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Persistent representation of the <code>Productos</code> model class.
 * <p>
 * Model Class: <code>Productos</code><br>
 */
@Entity(name = ProductosConstants.CLASS_NAME)
@Table(name = ProductosConstants.TBL_NAME)
public class Productos extends AbstractAppEntity {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private transient PlanesJpaRepository planesRepository;

    @JsonIgnore
    private transient DominioJpaRepository dominioRepository;

    @JsonIgnore
    private transient ContratoCJpaRepository contratoCRepository;

    @JsonIgnore
    private transient AgentexProductoJpaRepository agentexProductoRepository;

    /** Class identification function. */
    @Id
    @Column(name = ProductosConstants.FLD_PRODUCTOSPRODUCTO )
    @JsonProperty(value="producto")
    private Long productosProducto;

    /** Class member attribute. */
    @Column(name = ProductosConstants.FLD_PRODUCTOSDESCRIPCION )
    @JsonProperty(value="descripcion")
    private String productosDescripcion;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductosDescripcion;

    /** Class member attribute. */
    @Column(name = ProductosConstants.FLD_PRODUCTOSCODANEXOMAT )
    @JsonProperty(value="codanexomat")
    private Long productosCodAnexoMat;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductosCodAnexoMat;

    /** Class member attribute. */
    @Column(name = ProductosConstants.FLD_PRODUCTOSCODANEXONEO )
    @JsonProperty(value="codanexoneo")
    private Long productosCodAnexoNeo;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductosCodAnexoNeo;

    /** Class member attribute. */
    @Column(name = ProductosConstants.FLD_PRODUCTOSNIT )
    @JsonProperty(value="nit")
    private String productosNIT;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductosNIT;

    /** Class member attribute. */
    @Column(name = ProductosConstants.FLD_PRODUCTOSCODIGOLEGAL )
    @JsonProperty(value="codigolegal")
    private String productosCodigoLegal;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductosCodigoLegal;

    /** Class member attribute. */
    @Column(name = ProductosConstants.FLD_PRODUCTOSFECHADOCSOLICITUD )
    @JsonProperty(value="fechadocsolicitud")
    private Date productosFechaDocSolicitud;

    /** Class member attribute modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedProductosFechaDocSolicitud;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_PLANES)
    @JsonIgnore
    private Collection <Planes> planes;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedPlanes;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_DOMINIOS)
    @JsonIgnore
    private Collection <Dominio> dominios;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedDominios;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_TARIFAS)
    @JsonIgnore
    private Collection <Tarifa> tarifas;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTarifas;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_GRUPOSASOCIADOS)
    @JsonIgnore
    private Collection <GrupoAsociado> gruposAsociados;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedGruposAsociados;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_TIPOSIVA)
    @JsonIgnore
    private Collection <TipoIVA> tiposIVA;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedTiposIVA;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_AESOLICITUDES)
    @JsonIgnore
    private Collection <AESOLICITUDES> aESOLICITUDES;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAESOLICITUDES;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_CONTRATOSC)
    @JsonIgnore
    private Collection <ContratoC> contratosC;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedContratosC;

    /** Related Class. */
    @OneToMany(mappedBy = ProductosConstants.ROLE_INVNAME_AGENTEXPRODUCTO)
    @JsonIgnore
    private Collection <AgentexProducto> agentexProducto;
    /** Related Class modified. */
    @Transient
    @JsonIgnore
    private boolean modifiedAgentexProducto;

    /** Class related values.*/
    @Transient
    @JsonIgnore
    private transient Map<String, Object> values;

   /**
    * Default constructor
    */
    public Productos() {
        productosProducto = null;
        initAttributes();
    }

    /**
     * Constructor used to create instances of <code>Productos</code>.
     * @param oid Object Identifier of the instance of <code>Productos</code> to be created.
     * @throws SystemException
     */
    public Productos(ProductosOid oid) {
        if (oid == null || oid.isNull()) {
            initAttributes();
        } else {
            productosProducto = oid.getProductosProducto();
            initAttributes();
        }
    }

    /**
     * Returns the value of the <code>productosProducto</code> attribute<br>in class <code>Productos</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Productos</code>
     * @return The value of the <code>productosProducto</code> attribute<br>in class <code>Productos</code>.
     */
    public Long getProductosProducto() {
        return productosProducto;
    }

    /**
     * Sets the value of the <code>productosProducto</code> attribute<br>in class <code>Productos</code>.
     * This is part of the identification for this class, which depends on the identification of <code>Productos</code>
     * @param productosProducto The new value of the <code>productosProducto</code> attribute<br>in class <code>Productos</code>.
     */
    public void setProductosProducto(Long productosProducto) {
        this.productosProducto = productosProducto;
    }

   /**
    * Returns the value of the <code>productosDescripcion</code> attribute.<br>
    * Model Attribute: <code>productosDescripcion</code>. Variable String Size=100<br>
    * Comments: <br>
    * @return The value of the <code>productosDescripcion</code> attribute.
    */

    public String getProductosDescripcion()  {
    	String value;
        value =  productosDescripcion;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>productosDescripcion</code> attribute.<br>
    * Model Attribute: <code>productosDescripcion</code>. Variable String Size=100<br>
    * Comments: <br>
    * @param productosDescripcion The new value of the <code>productosDescripcion</code> attribute.
    */
    public void setProductosDescripcion (String productosDescripcion) {
        modifiedProductosDescripcion = true;
        this.productosDescripcion = productosDescripcion;
    }

   /**
    * Returns the value of the <code>modifiedProductosDescripcion</code> class property.<br>
    *
    * @return The value of the <code>modifiedProductosDescripcion</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedProductosDescripcion() {
        return modifiedProductosDescripcion;
    }

   /**
    * Sets the value of the <code>modifiedProductosDescripcion</code> class property.<br>
    * @param modified The new value of the <code>modifiedProductosDescripcion</code>.
    */
    public void setModifiedProductosDescripcion(boolean modified) {
        this.modifiedProductosDescripcion = modified;
    }

   /**
    * Returns the value of the <code>productosCodAnexoMat</code> attribute.<br>
    * Model Attribute: <code>productosCodAnexoMat</code>. Variable Int<br>
    * Comments: Es el código correspondiente con el anexo de maternidad para este producto (Por ejemplo, para ColSanitas, sería el 30)<br>
    * @return The value of the <code>productosCodAnexoMat</code> attribute.
    */

    public Long getProductosCodAnexoMat()  {
    	Long value;
        value =  productosCodAnexoMat;
        return value;
    }

   /**
    * Sets the value of the <code>productosCodAnexoMat</code> attribute.<br>
    * Model Attribute: <code>productosCodAnexoMat</code>. Variable Int<br>
    * Comments: Es el código correspondiente con el anexo de maternidad para este producto (Por ejemplo, para ColSanitas, sería el 30)<br>
    * @param productosCodAnexoMat The new value of the <code>productosCodAnexoMat</code> attribute.
    */
    public void setProductosCodAnexoMat (Long productosCodAnexoMat) {
        modifiedProductosCodAnexoMat = true;
        this.productosCodAnexoMat = productosCodAnexoMat;
    }

   /**
    * Returns the value of the <code>modifiedProductosCodAnexoMat</code> class property.<br>
    *
    * @return The value of the <code>modifiedProductosCodAnexoMat</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedProductosCodAnexoMat() {
        return modifiedProductosCodAnexoMat;
    }

   /**
    * Sets the value of the <code>modifiedProductosCodAnexoMat</code> class property.<br>
    * @param modified The new value of the <code>modifiedProductosCodAnexoMat</code>.
    */
    public void setModifiedProductosCodAnexoMat(boolean modified) {
        this.modifiedProductosCodAnexoMat = modified;
    }

   /**
    * Returns the value of the <code>productosCodAnexoNeo</code> attribute.<br>
    * Model Attribute: <code>productosCodAnexoNeo</code>. Variable Int<br>
    * Comments: Es el código correspondiente con el anexo neonatal para este producto (Por ejemplo, para ColSanitas, sería el 31)<br>
    * @return The value of the <code>productosCodAnexoNeo</code> attribute.
    */

    public Long getProductosCodAnexoNeo()  {
    	Long value;
        value =  productosCodAnexoNeo;
        return value;
    }

   /**
    * Sets the value of the <code>productosCodAnexoNeo</code> attribute.<br>
    * Model Attribute: <code>productosCodAnexoNeo</code>. Variable Int<br>
    * Comments: Es el código correspondiente con el anexo neonatal para este producto (Por ejemplo, para ColSanitas, sería el 31)<br>
    * @param productosCodAnexoNeo The new value of the <code>productosCodAnexoNeo</code> attribute.
    */
    public void setProductosCodAnexoNeo (Long productosCodAnexoNeo) {
        modifiedProductosCodAnexoNeo = true;
        this.productosCodAnexoNeo = productosCodAnexoNeo;
    }

   /**
    * Returns the value of the <code>modifiedProductosCodAnexoNeo</code> class property.<br>
    *
    * @return The value of the <code>modifiedProductosCodAnexoNeo</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedProductosCodAnexoNeo() {
        return modifiedProductosCodAnexoNeo;
    }

   /**
    * Sets the value of the <code>modifiedProductosCodAnexoNeo</code> class property.<br>
    * @param modified The new value of the <code>modifiedProductosCodAnexoNeo</code>.
    */
    public void setModifiedProductosCodAnexoNeo(boolean modified) {
        this.modifiedProductosCodAnexoNeo = modified;
    }

   /**
    * Returns the value of the <code>productosNIT</code> attribute.<br>
    * Model Attribute: <code>productosNIT</code>. Variable String Size=60<br>
    * Comments: Con este nit se buscarían las sucursales ya que para obtener las sucursales se debe utilizar la capacidad consultar del servicio persona enviando el tipo y núumero de identificación. Las sucursales las devuelve en la sección de sucursales.<br>
    * @return The value of the <code>productosNIT</code> attribute.
    */

    public String getProductosNIT()  {
    	String value;
        value =  productosNIT;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>productosNIT</code> attribute.<br>
    * Model Attribute: <code>productosNIT</code>. Variable String Size=60<br>
    * Comments: Con este nit se buscarían las sucursales ya que para obtener las sucursales se debe utilizar la capacidad consultar del servicio persona enviando el tipo y núumero de identificación. Las sucursales las devuelve en la sección de sucursales.<br>
    * @param productosNIT The new value of the <code>productosNIT</code> attribute.
    */
    public void setProductosNIT (String productosNIT) {
        modifiedProductosNIT = true;
        this.productosNIT = productosNIT;
    }

   /**
    * Returns the value of the <code>modifiedProductosNIT</code> class property.<br>
    *
    * @return The value of the <code>modifiedProductosNIT</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedProductosNIT() {
        return modifiedProductosNIT;
    }

   /**
    * Sets the value of the <code>modifiedProductosNIT</code> class property.<br>
    * @param modified The new value of the <code>modifiedProductosNIT</code>.
    */
    public void setModifiedProductosNIT(boolean modified) {
        this.modifiedProductosNIT = modified;
    }

   /**
    * Returns the value of the <code>productosCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>productosCodigoLegal</code>. Variable String Size=10<br>
    * Comments: <br>
    * @return The value of the <code>productosCodigoLegal</code> attribute.
    */

    public String getProductosCodigoLegal()  {
    	String value;
        value =  productosCodigoLegal;
        return (value == null ? null : value.trim());
    }

   /**
    * Sets the value of the <code>productosCodigoLegal</code> attribute.<br>
    * Model Attribute: <code>productosCodigoLegal</code>. Variable String Size=10<br>
    * Comments: <br>
    * @param productosCodigoLegal The new value of the <code>productosCodigoLegal</code> attribute.
    */
    public void setProductosCodigoLegal (String productosCodigoLegal) {
        modifiedProductosCodigoLegal = true;
        this.productosCodigoLegal = productosCodigoLegal;
    }

   /**
    * Returns the value of the <code>modifiedProductosCodigoLegal</code> class property.<br>
    *
    * @return The value of the <code>modifiedProductosCodigoLegal</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedProductosCodigoLegal() {
        return modifiedProductosCodigoLegal;
    }

   /**
    * Sets the value of the <code>modifiedProductosCodigoLegal</code> class property.<br>
    * @param modified The new value of the <code>modifiedProductosCodigoLegal</code>.
    */
    public void setModifiedProductosCodigoLegal(boolean modified) {
        this.modifiedProductosCodigoLegal = modified;
    }

   /**
    * Returns the value of the <code>productosFechaDocSolicitud</code> attribute.<br>
    * Model Attribute: <code>productosFechaDocSolicitud</code>. Variable Date<br>
    * Comments: GC3: Si para un producto a esta nueva fecha no se le asigna valor, eso significa que no es necesario incluir los documentos de solicitud. Pero si toma valor (01/01/2003, por ejemplo) significa que si la fecha de inicio del contrato es anterior a 01/01/2003, es imprescindible adjuntar los documentos de solicitud de todos los usuarios (a excepción de los menores sin identificar)<br>
    * @return The value of the <code>productosFechaDocSolicitud</code> attribute.
    */

    public Date getProductosFechaDocSolicitud()  {
    	Date value;
        value =  productosFechaDocSolicitud;
        return value;
    }

   /**
    * Sets the value of the <code>productosFechaDocSolicitud</code> attribute.<br>
    * Model Attribute: <code>productosFechaDocSolicitud</code>. Variable Date<br>
    * Comments: GC3: Si para un producto a esta nueva fecha no se le asigna valor, eso significa que no es necesario incluir los documentos de solicitud. Pero si toma valor (01/01/2003, por ejemplo) significa que si la fecha de inicio del contrato es anterior a 01/01/2003, es imprescindible adjuntar los documentos de solicitud de todos los usuarios (a excepción de los menores sin identificar)<br>
    * @param productosFechaDocSolicitud The new value of the <code>productosFechaDocSolicitud</code> attribute.
    */
    public void setProductosFechaDocSolicitud (Date productosFechaDocSolicitud) {
        modifiedProductosFechaDocSolicitud = true;
        this.productosFechaDocSolicitud = productosFechaDocSolicitud;
    }

   /**
    * Returns the value of the <code>modifiedProductosFechaDocSolicitud</code> class property.<br>
    *
    * @return The value of the <code>modifiedProductosFechaDocSolicitud</code> class property.
    */
    @JsonIgnore
    public boolean isModifiedProductosFechaDocSolicitud() {
        return modifiedProductosFechaDocSolicitud;
    }

   /**
    * Sets the value of the <code>modifiedProductosFechaDocSolicitud</code> class property.<br>
    * @param modified The new value of the <code>modifiedProductosFechaDocSolicitud</code>.
    */
    public void setModifiedProductosFechaDocSolicitud(boolean modified) {
        this.modifiedProductosFechaDocSolicitud = modified;
    }

    /**
     * Returns the instance of <code>Planes</code> related through the <code>Planes</code> role.
     * Model Relationship:
     * <code>[Planes] Planes 0:M  ------ 1:1  ProductoT [Productos]</code>
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
     * Returns the instance of <code>Dominio</code> related through the <code>Dominios</code> role.
     * Model Relationship:
     * <code>[Dominio] Dominios 0:M  ------ 1:1  ProductoT [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Dominio</code> related through the <code>Dominios</code> role.
     */
    @JsonIgnore
    public Collection <Dominio> getDominios() {
        return dominios;
    }

   /**
    * Adds an instance of <code>Dominio</code> related through the <code>Dominios</code> role.
    * @param dominios The instance to add to the <code>Dominios</code> role.
    */
    public void add2Dominios(Dominio dominios) {
        this.getDominios().add(dominios);
    }
    /**
     * Sets instances of <code>Dominio</code> related through the <code>Dominios</code> role.
     * @param dominios The new value for the <code>Dominios</code> role.
     */
    public void setDominios(Collection < Dominio > dominios) {
        this.dominios = dominios;
    }

   /**
    * This method gets the attribute value <code>modifiedDominios</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedDominios</code> has been modified.
    */
    public boolean isModifiedDominios(){
        return modifiedDominios;
    }

    /**
     * Returns the instance of <code>Tarifa</code> related through the <code>Tarifas</code> role.
     * Model Relationship:
     * <code>[Tarifa] Tarifas 0:M  ------ 1:1  ProductoT [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>Tarifa</code> related through the <code>Tarifas</code> role.
     */
    @JsonIgnore
    public Collection <Tarifa> getTarifas() {
        return tarifas;
    }

   /**
    * Adds an instance of <code>Tarifa</code> related through the <code>Tarifas</code> role.
    * @param tarifas The instance to add to the <code>Tarifas</code> role.
    */
    public void add2Tarifas(Tarifa tarifas) {
        this.getTarifas().add(tarifas);
    }
    /**
     * Sets instances of <code>Tarifa</code> related through the <code>Tarifas</code> role.
     * @param tarifas The new value for the <code>Tarifas</code> role.
     */
    public void setTarifas(Collection < Tarifa > tarifas) {
        this.tarifas = tarifas;
    }

   /**
    * This method gets the attribute value <code>modifiedTarifas</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTarifas</code> has been modified.
    */
    public boolean isModifiedTarifas(){
        return modifiedTarifas;
    }

    /**
     * Returns the instance of <code>GrupoAsociado</code> related through the <code>GruposAsociados</code> role.
     * Model Relationship:
     * <code>[GrupoAsociado] GruposAsociados 0:M  ------ 1:1  ProductoT [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>GrupoAsociado</code> related through the <code>GruposAsociados</code> role.
     */
    @JsonIgnore
    public Collection <GrupoAsociado> getGruposAsociados() {
        return gruposAsociados;
    }

   /**
    * Adds an instance of <code>GrupoAsociado</code> related through the <code>GruposAsociados</code> role.
    * @param gruposAsociados The instance to add to the <code>GruposAsociados</code> role.
    */
    public void add2GruposAsociados(GrupoAsociado gruposAsociados) {
        this.getGruposAsociados().add(gruposAsociados);
    }
    /**
     * Sets instances of <code>GrupoAsociado</code> related through the <code>GruposAsociados</code> role.
     * @param gruposAsociados The new value for the <code>GruposAsociados</code> role.
     */
    public void setGruposAsociados(Collection < GrupoAsociado > gruposAsociados) {
        this.gruposAsociados = gruposAsociados;
    }

   /**
    * This method gets the attribute value <code>modifiedGruposAsociados</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedGruposAsociados</code> has been modified.
    */
    public boolean isModifiedGruposAsociados(){
        return modifiedGruposAsociados;
    }

    /**
     * Returns the instance of <code>TipoIVA</code> related through the <code>TiposIVA</code> role.
     * Model Relationship:
     * <code>[TipoIVA] TiposIVA 0:M  ------ 1:1  ProductoT [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>TipoIVA</code> related through the <code>TiposIVA</code> role.
     */
    @JsonIgnore
    public Collection <TipoIVA> getTiposIVA() {
        return tiposIVA;
    }

   /**
    * Adds an instance of <code>TipoIVA</code> related through the <code>TiposIVA</code> role.
    * @param tiposIVA The instance to add to the <code>TiposIVA</code> role.
    */
    public void add2TiposIVA(TipoIVA tiposIVA) {
        this.getTiposIVA().add(tiposIVA);
    }
    /**
     * Sets instances of <code>TipoIVA</code> related through the <code>TiposIVA</code> role.
     * @param tiposIVA The new value for the <code>TiposIVA</code> role.
     */
    public void setTiposIVA(Collection < TipoIVA > tiposIVA) {
        this.tiposIVA = tiposIVA;
    }

   /**
    * This method gets the attribute value <code>modifiedTiposIVA</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedTiposIVA</code> has been modified.
    */
    public boolean isModifiedTiposIVA(){
        return modifiedTiposIVA;
    }

    /**
     * Returns the instance of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
     * Model Relationship:
     * <code>[AESOLICITUDES] AESOLICITUDES 0:M  ------ 1:1  ProductoT [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
     */
    @JsonIgnore
    public Collection <AESOLICITUDES> getAESOLICITUDES() {
        return aESOLICITUDES;
    }

   /**
    * Adds an instance of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
    * @param aESOLICITUDES The instance to add to the <code>AESOLICITUDES</code> role.
    */
    public void add2AESOLICITUDES(AESOLICITUDES aESOLICITUDES) {
        this.getAESOLICITUDES().add(aESOLICITUDES);
    }
    /**
     * Sets instances of <code>AESOLICITUDES</code> related through the <code>AESOLICITUDES</code> role.
     * @param aESOLICITUDES The new value for the <code>AESOLICITUDES</code> role.
     */
    public void setAESOLICITUDES(Collection < AESOLICITUDES > aESOLICITUDES) {
        this.aESOLICITUDES = aESOLICITUDES;
    }

   /**
    * This method gets the attribute value <code>modifiedAESOLICITUDES</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAESOLICITUDES</code> has been modified.
    */
    public boolean isModifiedAESOLICITUDES(){
        return modifiedAESOLICITUDES;
    }

    /**
     * Returns the instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * Model Relationship:
     * <code>[ContratoC] ContratosC 0:M  ------ 1:1  ProductoC [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     */
    @JsonIgnore
    public Collection <ContratoC> getContratosC() {
        return contratosC;
    }

   /**
    * Adds an instance of <code>ContratoC</code> related through the <code>ContratosC</code> role.
    * @param contratosC The instance to add to the <code>ContratosC</code> role.
    */
    public void add2ContratosC(ContratoC contratosC) {
        this.getContratosC().add(contratosC);
    }
    /**
     * Sets instances of <code>ContratoC</code> related through the <code>ContratosC</code> role.
     * @param contratosC The new value for the <code>ContratosC</code> role.
     */
    public void setContratosC(Collection < ContratoC > contratosC) {
        this.contratosC = contratosC;
    }

   /**
    * This method gets the attribute value <code>modifiedContratosC</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedContratosC</code> has been modified.
    */
    public boolean isModifiedContratosC(){
        return modifiedContratosC;
    }

    /**
     * Returns the instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     * Model Relationship:
     * <code>[AgentexProducto] AgentexProducto 0:M  ------ 1:1  ProductoT [Productos]</code>
     *
     * @throws SystemException if there is any error on having gotten a related instance.
     * @return The instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     */
    @JsonIgnore
    public Collection <AgentexProducto> getAgentexProducto() {
        return agentexProducto;
    }

   /**
    * Adds an instance of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
    * @param agentexProducto The instance to add to the <code>AgentexProducto</code> role.
    */
    public void add2AgentexProducto(AgentexProducto agentexProducto) {
        this.getAgentexProducto().add(agentexProducto);
    }
    /**
     * Sets instances of <code>AgentexProducto</code> related through the <code>AgentexProducto</code> role.
     * @param agentexProducto The new value for the <code>AgentexProducto</code> role.
     */
    public void setAgentexProducto(Collection < AgentexProducto > agentexProducto) {
        this.agentexProducto = agentexProducto;
    }

   /**
    * This method gets the attribute value <code>modifiedAgentexProducto</code> has been modified.
    * @return a boolean value that indicates if the attribute <code>modifiedAgentexProducto</code> has been modified.
    */
    public boolean isModifiedAgentexProducto(){
        return modifiedAgentexProducto;
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
        productosDescripcion = "";
        productosCodAnexoMat = null;
        productosCodAnexoNeo = null;
        productosNIT = null;
        productosCodigoLegal = "";
        productosFechaDocSolicitud = null;
        planes = null;
        dominios = null;
        tarifas = null;
        gruposAsociados = null;
        tiposIVA = null;
        aESOLICITUDES = null;
        contratosC = null;
        agentexProducto = null;
        values = new HashMap<>();
        planesRepository = Arc.container().select(PlanesJpaRepository.class).get();
        dominioRepository = Arc.container().select(DominioJpaRepository.class).get();
        contratoCRepository = Arc.container().select(ContratoCJpaRepository.class).get();
        agentexProductoRepository = Arc.container().select(AgentexProductoJpaRepository.class).get();

        clearModifiedFlags();
    }

    @Override
    protected Method[] getMethods() {
    	return Productos.class.getMethods();
    }

    
    @Override
    protected String getClassAttributeType(String attribute) {
    	return ProductosConstants.ATTRIBUTE_TYPES.get(attribute.toUpperCase());
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
    	modifiedProductosDescripcion = false;
    	values.put("productosDescripcion", getProductosDescripcion());
    	modifiedProductosCodAnexoMat = false;
    	values.put("productosCodAnexoMat", getProductosCodAnexoMat());
    	modifiedProductosCodAnexoNeo = false;
    	values.put("productosCodAnexoNeo", getProductosCodAnexoNeo());
    	modifiedProductosNIT = false;
    	values.put("productosNIT", getProductosNIT());
    	modifiedProductosCodigoLegal = false;
    	values.put("productosCodigoLegal", getProductosCodigoLegal());
    	modifiedProductosFechaDocSolicitud = false;
    	values.put("productosFechaDocSolicitud", getProductosFechaDocSolicitud());
    	modifiedPlanes = false;
    	modifiedDominios = false;
    	modifiedTarifas = false;
    	modifiedGruposAsociados = false;
    	modifiedTiposIVA = false;
    	modifiedAESOLICITUDES = false;
    	modifiedContratosC = false;
    	modifiedAgentexProducto = false;
    }

    /**
     * This method sets all the derived attributes with null value.
     */
    public void cleanDerivations() {
        // There are no derivations defined in this class
    }

    /**
     * Returns the <code>ProductosOid</code> object that identifies this instance of <code>Productos</code>.
     * @return <code>ProductosOid </code> object that identifies this instance of <code>Productos</code>
     */
    public ProductosOid getOid() {
        return new ProductosOid(getProductosProducto());
    }

    
    @Override
    protected boolean isAttributeVisible(String item) {
        return getAgent().isAnyFacetActive(ProductosConstants.ATTRIBUTE_AGENTS.get(item.toUpperCase()));
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

        if (!activeFacets.contains(Constants.PRODUCTOS)) {
            // Add this class
            activeFacets.add(Constants.PRODUCTOS);
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


        if (getAgent().isFacetActive(Constants.ADMIN) || getAgent().isFacetActive(Constants.SUPERADMIN) || getAgent().isFacetActive(Constants.ASESOR) || getAgent().isFacetActive(Constants.AREAMEDICA) || getAgent().isFacetActive(Constants.AFILIACIONES) || getAgent().isFacetActive(Constants.GESTOR) || getAgent().isFacetActive(Constants.MESADEAPOYO)) {
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

    public String buildICProducto() {
        try {
            return getProductosDescripcion();
        } catch(Exception e) {
            return "";
        }
    }
}
