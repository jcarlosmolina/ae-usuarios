package com.keralty.aeusuarios.viewmodel.productos.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductosPostViewModel {

    @JsonProperty(value="Producto")
    private Long productosProducto;

    @JsonProperty(value="Descripcion")
    private String productosDescripcion;

    @JsonProperty(value="CodAnexoMat")
    private Long productosCodAnexoMat;

    @JsonProperty(value="CodAnexoNeo")
    private Long productosCodAnexoNeo;

    @JsonProperty(value="NIT")
    private String productosNIT;

    @JsonProperty(value="CodigoLegal")
    private String productosCodigoLegal;

    public Long getProductosProducto() {
        return productosProducto;
    }
    
    public void setProductosProducto(Long productosProducto) {
        this.productosProducto = productosProducto;
    }

    public String getProductosDescripcion() {
        return productosDescripcion;
    }
    
    public void setProductosDescripcion(String productosDescripcion) {
        this.productosDescripcion = productosDescripcion;
    }

    public Long getProductosCodAnexoMat() {
        return productosCodAnexoMat;
    }
    
    public void setProductosCodAnexoMat(Long productosCodAnexoMat) {
        this.productosCodAnexoMat = productosCodAnexoMat;
    }

    public Long getProductosCodAnexoNeo() {
        return productosCodAnexoNeo;
    }
    
    public void setProductosCodAnexoNeo(Long productosCodAnexoNeo) {
        this.productosCodAnexoNeo = productosCodAnexoNeo;
    }

    public String getProductosNIT() {
        return productosNIT;
    }
    
    public void setProductosNIT(String productosNIT) {
        this.productosNIT = productosNIT;
    }

    public String getProductosCodigoLegal() {
        return productosCodigoLegal;
    }
    
    public void setProductosCodigoLegal(String productosCodigoLegal) {
        this.productosCodigoLegal = productosCodigoLegal;
    }
}
