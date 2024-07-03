package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import java.sql.Date;
public class FugetValorTarifaSegunEdadRequest {

    @JsonProperty("pfu_producto")
    private ProductosOid pfuProducto;

    @JsonIgnore
    private Productos pfuProductoInstance;

    @JsonProperty("pfu_plan")
    private PlanesOid pfuPlan;

    @JsonIgnore
    private Planes pfuPlanInstance;

    @JsonProperty("pfu_edad")
    private Long pfuEdad;

    @JsonProperty("pfu_tipocontrato")
    private Long pfuTipoContrato;

    @JsonProperty("pfu_vienetraslado")
    private Boolean pfuVieneTraslado;

    @JsonProperty("pfu_fechacontratacion")
    private Date pfuFechaContratacion;

    public FugetValorTarifaSegunEdadRequest() {
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
    public Long getPfuEdad() {
        return this.pfuEdad;
    }
    
    public void setPfuEdad(Long pfuEdad) {
        this.pfuEdad = pfuEdad;
    }
    @JsonIgnore
    public Long getPfuTipoContrato() {
        return this.pfuTipoContrato;
    }
    
    public void setPfuTipoContrato(Long pfuTipoContrato) {
        this.pfuTipoContrato = pfuTipoContrato;
    }
    @JsonIgnore
    public Boolean getPfuVieneTraslado() {
        return this.pfuVieneTraslado;
    }
    
    public void setPfuVieneTraslado(Boolean pfuVieneTraslado) {
        this.pfuVieneTraslado = pfuVieneTraslado;
    }
    @JsonIgnore
    public Date getPfuFechaContratacion() {
        return this.pfuFechaContratacion;
    }
    
    public void setPfuFechaContratacion(Date pfuFechaContratacion) {
        this.pfuFechaContratacion = pfuFechaContratacion;
    }
}
