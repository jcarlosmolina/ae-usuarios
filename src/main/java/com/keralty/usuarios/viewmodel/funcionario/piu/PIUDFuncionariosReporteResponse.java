package com.keralty.usuarios.viewmodel.funcionario.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.funcionario.ds.DSFuncionarioDReportes;

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
