package com.keralty.aeusuarios.viewmodel.loghistoricoplanes.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogHistoricoPlanesPostViewModel {

    @JsonProperty(value="LoginFuncionario")
    private String logHistoricoPlanesLoginFuncionario;

    @JsonProperty(value="Producto")
    private String logHistoricoPlanesProducto;

    @JsonProperty(value="Plan")
    private String logHistoricoPlanesPlan;

    @JsonProperty(value="Accion")
    private String logHistoricoPlanesAccion;

    public String getLogHistoricoPlanesLoginFuncionario() {
        return logHistoricoPlanesLoginFuncionario;
    }
    
    public void setLogHistoricoPlanesLoginFuncionario(String logHistoricoPlanesLoginFuncionario) {
        this.logHistoricoPlanesLoginFuncionario = logHistoricoPlanesLoginFuncionario;
    }

    public String getLogHistoricoPlanesProducto() {
        return logHistoricoPlanesProducto;
    }
    
    public void setLogHistoricoPlanesProducto(String logHistoricoPlanesProducto) {
        this.logHistoricoPlanesProducto = logHistoricoPlanesProducto;
    }

    public String getLogHistoricoPlanesPlan() {
        return logHistoricoPlanesPlan;
    }
    
    public void setLogHistoricoPlanesPlan(String logHistoricoPlanesPlan) {
        this.logHistoricoPlanesPlan = logHistoricoPlanesPlan;
    }

    public String getLogHistoricoPlanesAccion() {
        return logHistoricoPlanesAccion;
    }
    
    public void setLogHistoricoPlanesAccion(String logHistoricoPlanesAccion) {
        this.logHistoricoPlanesAccion = logHistoricoPlanesAccion;
    }
}
