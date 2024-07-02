package com.keralty.usuarios.viewmodel.rol.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.rol.ds.AutoDS;

public class PIURolResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIURolResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIURolResponse(List<AutoDS> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<AutoDS> getResults() {
        return this.results;
    }
    
    public void setResults(List<AutoDS> results) {
        this.results = results;
    }
}
