package com.keralty.usuarios.viewmodel.mesadeapoyo.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.mesadeapoyo.ds.DSMesaDeApoyo;

public class PIUMesaDeApoyoResponse extends QueryResponse {

    private List<DSMesaDeApoyo> results;

    public PIUMesaDeApoyoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUMesaDeApoyoResponse(List<DSMesaDeApoyo> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSMesaDeApoyo> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSMesaDeApoyo> results) {
        this.results = results;
    }
}
