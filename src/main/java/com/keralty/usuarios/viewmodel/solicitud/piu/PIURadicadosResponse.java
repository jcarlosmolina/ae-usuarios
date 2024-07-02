package com.keralty.usuarios.viewmodel.solicitud.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.solicitud.ds.DSSolicitudPIURadicado;

public class PIURadicadosResponse extends QueryResponse {

    private List<DSSolicitudPIURadicado> results;

    public PIURadicadosResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIURadicadosResponse(List<DSSolicitudPIURadicado> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolicitudPIURadicado> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolicitudPIURadicado> results) {
        this.results = results;
    }
}
