package com.keralty.usuarios.viewmodel.admin.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.admin.ds.AutoDS;

public class PIUAdminResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUAdminResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAdminResponse(List<AutoDS> results) {
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
