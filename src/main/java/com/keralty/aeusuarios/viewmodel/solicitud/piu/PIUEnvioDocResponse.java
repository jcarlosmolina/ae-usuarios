package com.keralty.aeusuarios.viewmodel.solicitud.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.solicitud.ds.DSSolicitudPIUEnvioDoc;

public class PIUEnvioDocResponse extends QueryResponse {

    private List<DSSolicitudPIUEnvioDoc> results;

    public PIUEnvioDocResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEnvioDocResponse(List<DSSolicitudPIUEnvioDoc> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolicitudPIUEnvioDoc> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolicitudPIUEnvioDoc> results) {
        this.results = results;
    }
}
