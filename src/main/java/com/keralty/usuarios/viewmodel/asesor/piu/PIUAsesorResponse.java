package com.keralty.usuarios.viewmodel.asesor.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.asesor.ds.DSAsesorPIU;

public class PIUAsesorResponse extends QueryResponse {

    private List<DSAsesorPIU> results;

    public PIUAsesorResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAsesorResponse(List<DSAsesorPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAsesorPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAsesorPIU> results) {
        this.results = results;
    }
}