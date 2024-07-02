package com.keralty.usuarios.viewmodel.grupoasignacion.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion;

public class PIUGrupoAsignacionResponse extends QueryResponse {

    private List<DSGrupoAsignacion> results;

    public PIUGrupoAsignacionResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUGrupoAsignacionResponse(List<DSGrupoAsignacion> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSGrupoAsignacion> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSGrupoAsignacion> results) {
        this.results = results;
    }
}
