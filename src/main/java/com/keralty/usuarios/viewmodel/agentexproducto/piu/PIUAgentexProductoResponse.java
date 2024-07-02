package com.keralty.usuarios.viewmodel.agentexproducto.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.agentexproducto.ds.DSAgentexProductoPIU;

public class PIUAgentexProductoResponse extends QueryResponse {

    private List<DSAgentexProductoPIU> results;

    public PIUAgentexProductoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAgentexProductoResponse(List<DSAgentexProductoPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAgentexProductoPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAgentexProductoPIU> results) {
        this.results = results;
    }
}
