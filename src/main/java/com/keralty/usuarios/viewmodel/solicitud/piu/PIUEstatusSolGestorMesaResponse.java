package com.keralty.usuarios.viewmodel.solicitud.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.solicitud.ds.DSSolicitudPIUStatusGestMesa;

public class PIUEstatusSolGestorMesaResponse extends QueryResponse {

    private List<DSSolicitudPIUStatusGestMesa> results;

    public PIUEstatusSolGestorMesaResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstatusSolGestorMesaResponse(List<DSSolicitudPIUStatusGestMesa> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolicitudPIUStatusGestMesa> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolicitudPIUStatusGestMesa> results) {
        this.results = results;
    }
}
