package com.keralty.usuarios.viewmodel.funcionario.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.funcionario.ds.DSAgentePIU;

public class PIUAgenteResponse extends QueryResponse {

    private List<DSAgentePIU> results;

    public PIUAgenteResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAgenteResponse(List<DSAgentePIU> results) {
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
