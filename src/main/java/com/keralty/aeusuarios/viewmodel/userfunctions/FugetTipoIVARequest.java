package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import java.sql.Date;
public class FugetTipoIVARequest {

    @JsonProperty("pfu_producto")
    private ProductosOid pfuProducto;

    @JsonIgnore
    private Productos pfuProductoInstance;

    @JsonProperty("pfu_plan")
    private PlanesOid pfuPlan;

    @JsonIgnore
    private Planes pfuPlanInstance;

    @JsonProperty("pfu_fecha")
    private Date pfuFecha;

    public FugetTipoIVARequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public ProductosOid getPfuProducto() {
        return this.pfuProducto;
    }
    
    public void setPfuProducto(ProductosOid pfuProducto) {
        this.pfuProducto = pfuProducto;
    }

    @JsonIgnore
    public Productos getPfuProductoInstance() {
        if (this.pfuProductoInstance == null)
            this.pfuProductoInstance = new Productos();
        return this.pfuProductoInstance;
    }
    
    public void setPfuProductoInstance(Productos pfuProducto) {
        this.pfuProductoInstance = pfuProducto;
    }
    @JsonIgnore
    public PlanesOid getPfuPlan() {
        return this.pfuPlan;
    }
    
    public void setPfuPlan(PlanesOid pfuPlan) {
        this.pfuPlan = pfuPlan;
    }

    @JsonIgnore
    public Planes getPfuPlanInstance() {
        if (this.pfuPlanInstance == null)
            this.pfuPlanInstance = new Planes();
        return this.pfuPlanInstance;
    }
    
    public void setPfuPlanInstance(Planes pfuPlan) {
        this.pfuPlanInstance = pfuPlan;
    }
    @JsonIgnore
    public Date getPfuFecha() {
        return this.pfuFecha;
    }
    
    public void setPfuFecha(Date pfuFecha) {
        this.pfuFecha = pfuFecha;
    }
}
