package com.keralty.usuarios.viewmodel.solicitudnovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatus;

public class PIUEstatusSolNovResponse extends QueryResponse {

    private List<DSSolNovEstatus> results;

    public PIUEstatusSolNovResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstatusSolNovResponse(List<DSSolNovEstatus> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolNovEstatus> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolNovEstatus> results) {
        this.results = results;
    }
}
