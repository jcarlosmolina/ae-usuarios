package com.keralty.usuarios.viewmodel.productos.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.productos.ds.AutoDS;

public class PIUProductoResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUProductoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUProductoResponse(List<AutoDS> results) {
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
