package com.keralty.aeusuarios.viewmodel.funcionario.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDReportes;

public class PIUDFuncionariosReporteResponse extends QueryResponse {

    private List<DSFuncionarioDReportes> results;

    public PIUDFuncionariosReporteResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDFuncionariosReporteResponse(List<DSFuncionarioDReportes> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFuncionarioDReportes> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFuncionarioDReportes> results) {
        this.results = results;
    }
}
