package com.keralty.aeusuarios.viewmodel.funcionario.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU;

public class PIUFuncionarioGrupoUsuariosResponse extends QueryResponse {

    private List<DSAgentePIU> results;

    public PIUFuncionarioGrupoUsuariosResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFuncionarioGrupoUsuariosResponse(List<DSAgentePIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAgentePIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAgentePIU> results) {
        this.results = results;
    }
}
