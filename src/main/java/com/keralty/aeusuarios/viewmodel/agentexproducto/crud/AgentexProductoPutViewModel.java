package com.keralty.aeusuarios.viewmodel.agentexproducto.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

public class AgentexProductoPutViewModel {

    @JsonProperty(value="FechaInicio")
    private Timestamp agentexProductoFechaInicio;

    @JsonProperty(value="FechaFin")
    private Timestamp agentexProductoFechaFin;

    @JsonProperty(value="TodosDominios")
    private Boolean agentexProductoTodosDominios;

    public Timestamp getAgentexProductoFechaInicio() {
        return agentexProductoFechaInicio;
    }
    
    public void setAgentexProductoFechaInicio(Timestamp agentexProductoFechaInicio) {
        this.agentexProductoFechaInicio = agentexProductoFechaInicio;
    }

    public Timestamp getAgentexProductoFechaFin() {
        return agentexProductoFechaFin;
    }
    
    public void setAgentexProductoFechaFin(Timestamp agentexProductoFechaFin) {
        this.agentexProductoFechaFin = agentexProductoFechaFin;
    }

    public Boolean getAgentexProductoTodosDominios() {
        return agentexProductoTodosDominios;
    }
    
    public void setAgentexProductoTodosDominios(Boolean agentexProductoTodosDominios) {
        this.agentexProductoTodosDominios = agentexProductoTodosDominios;
    }
}
