package com.keralty.usuarios.viewmodel.agentexproducto.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

public class AgentexProductoPostViewModel {

    @JsonProperty(value="Codigo")
    private Long agentexProductoCodigo;

    @JsonProperty(value="FechaInicio")
    private Timestamp agentexProductoFechaInicio;

    @JsonProperty(value="FechaFin")
    private Timestamp agentexProductoFechaFin;

    public Long getAgentexProductoCodigo() {
        return agentexProductoCodigo;
    }
    
    public void setAgentexProductoCodigo(Long agentexProductoCodigo) {
        this.agentexProductoCodigo = agentexProductoCodigo;
    }

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
}
