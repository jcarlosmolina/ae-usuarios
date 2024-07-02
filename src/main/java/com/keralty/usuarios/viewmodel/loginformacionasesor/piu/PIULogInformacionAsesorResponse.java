package com.keralty.usuarios.viewmodel.loginformacionasesor.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.loginformacionasesor.ds.DSLogInformacionAsesor;

public class PIULogInformacionAsesorResponse extends QueryResponse {

    private List<DSLogInformacionAsesor> results;

    public PIULogInformacionAsesorResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIULogInformacionAsesorResponse(List<DSLogInformacionAsesor> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSLogInformacionAsesor> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSLogInformacionAsesor> results) {
        this.results = results;
    }
}
