package com.keralty.usuarios.viewmodel.planes.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.planes.ds.DSPlanPIU;

public class PIUPlanResponse extends QueryResponse {

    private List<DSPlanPIU> results;

    public PIUPlanResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPlanResponse(List<DSPlanPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSPlanPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSPlanPIU> results) {
        this.results = results;
    }
}
