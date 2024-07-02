package com.keralty.usuarios.viewmodel.productos.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Productos;
public class AutoDS {

    @JsonProperty("producto")
    private Long _Auto_Producto;

    @JsonProperty("descripcion")
    private String _Auto_Descripcion;

    @JsonProperty("codanexomat")
    private Long _Auto_CodAnexoMat;

    @JsonProperty("codanexoneo")
    private Long _Auto_CodAnexoNeo;

    @JsonProperty("nit")
    private String _Auto_NIT;

    @JsonProperty("codigolegal")
    private String _Auto_CodigoLegal;

    @JsonProperty("fechadocsolicitud")
    private Date _Auto_FechaDocSolicitud;

    public AutoDS() {
    
    }

    public AutoDS(Productos instance) {
        if (instance != null) {
            this._Auto_Producto = instance.getProductosProducto();
            this._Auto_Descripcion = instance.getProductosDescripcion();
            this._Auto_CodAnexoMat = instance.getProductosCodAnexoMat();
            this._Auto_CodAnexoNeo = instance.getProductosCodAnexoNeo();
            this._Auto_NIT = instance.getProductosNIT();
            this._Auto_CodigoLegal = instance.getProductosCodigoLegal();
            this._Auto_FechaDocSolicitud = instance.getProductosFechaDocSolicitud();
        }
    }

    @JsonIgnore
    public Long get_Auto_Producto() {
        return this._Auto_Producto;
    }
    
    public void set_Auto_Producto(Long _Auto_Producto) {
        this._Auto_Producto = _Auto_Producto;
    }

    @JsonIgnore
    public String get_Auto_Descripcion() {
        return this._Auto_Descripcion;
    }
    
    public void set_Auto_Descripcion(String _Auto_Descripcion) {
        this._Auto_Descripcion = _Auto_Descripcion;
    }

    @JsonIgnore
    public Long get_Auto_CodAnexoMat() {
        return this._Auto_CodAnexoMat;
    }
    
    public void set_Auto_CodAnexoMat(Long _Auto_CodAnexoMat) {
        this._Auto_CodAnexoMat = _Auto_CodAnexoMat;
    }

    @JsonIgnore
    public Long get_Auto_CodAnexoNeo() {
        return this._Auto_CodAnexoNeo;
    }
    
    public void set_Auto_CodAnexoNeo(Long _Auto_CodAnexoNeo) {
        this._Auto_CodAnexoNeo = _Auto_CodAnexoNeo;
    }

    @JsonIgnore
    public String get_Auto_NIT() {
        return this._Auto_NIT;
    }
    
    public void set_Auto_NIT(String _Auto_NIT) {
        this._Auto_NIT = _Auto_NIT;
    }

    @JsonIgnore
    public String get_Auto_CodigoLegal() {
        return this._Auto_CodigoLegal;
    }
    
    public void set_Auto_CodigoLegal(String _Auto_CodigoLegal) {
        this._Auto_CodigoLegal = _Auto_CodigoLegal;
    }

    @JsonIgnore
    public Date get_Auto_FechaDocSolicitud() {
        return this._Auto_FechaDocSolicitud;
    }
    
    public void set_Auto_FechaDocSolicitud(Date _Auto_FechaDocSolicitud) {
        this._Auto_FechaDocSolicitud = _Auto_FechaDocSolicitud;
    }
}
