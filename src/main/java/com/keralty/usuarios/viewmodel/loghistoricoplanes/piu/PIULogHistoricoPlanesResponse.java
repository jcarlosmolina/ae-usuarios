package com.keralty.usuarios.viewmodel.loghistoricoplanes.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.loghistoricoplanes.ds.DSLogHistoricoPlanes;

public class PIULogHistoricoPlanesResponse extends QueryResponse {

    private List<DSLogHistoricoPlanes> results;

    public PIULogHistoricoPlanesResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIULogHistoricoPlanesResponse(List<DSLogHistoricoPlanes> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSLogHistoricoPlanes> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSLogHistoricoPlanes> results) {
        this.results = results;
    }
}
