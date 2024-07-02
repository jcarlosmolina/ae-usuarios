package com.keralty.usuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.oid.PlanesOid;
import com.keralty.usuarios.persistence.oid.ProductosOid;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Productos;
public class FugetDominioProdPlanRequest {

    @JsonProperty("pfu_producto")
    private ProductosOid pfuProducto;

    @JsonIgnore
    private Productos pfuProductoInstance;

    @JsonProperty("pfu_plan")
    private PlanesOid pfuPlan;

    @JsonIgnore
    private Planes pfuPlanInstance;

    public FugetDominioProdPlanRequest() {
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
}
