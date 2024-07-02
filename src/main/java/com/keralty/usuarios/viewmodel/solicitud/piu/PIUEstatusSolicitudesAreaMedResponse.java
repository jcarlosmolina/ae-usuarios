package com.keralty.usuarios.viewmodel.solicitud.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.solicitud.ds.DSSolicitudPIUStatusAreaMe;

public class PIUEstatusSolicitudesAreaMedResponse extends QueryResponse {

    private List<DSSolicitudPIUStatusAreaMe> results;

    public PIUEstatusSolicitudesAreaMedResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstatusSolicitudesAreaMedResponse(List<DSSolicitudPIUStatusAreaMe> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolicitudPIUStatusAreaMe> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolicitudPIUStatusAreaMe> results) {
        this.results = results;
    }
}
