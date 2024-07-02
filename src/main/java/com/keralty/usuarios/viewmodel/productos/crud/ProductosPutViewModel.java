package com.keralty.usuarios.viewmodel.productos.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class ProductosPutViewModel {

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

    @JsonProperty(value="FechaDocSolicitud")
    private Date productosFechaDocSolicitud;

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

    public Date getProductosFechaDocSolicitud() {
        return productosFechaDocSolicitud;
    }
    
    public void setProductosFechaDocSolicitud(Date productosFechaDocSolicitud) {
        this.productosFechaDocSolicitud = productosFechaDocSolicitud;
    }
}
