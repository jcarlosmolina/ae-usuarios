package com.keralty.usuarios.viewmodel.solicitudnovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadCon;

public class PIUConsultaSolicitudNovedadResponse extends QueryResponse {

    private List<DSSolicitudNovedadCon> results;

    public PIUConsultaSolicitudNovedadResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUConsultaSolicitudNovedadResponse(List<DSSolicitudNovedadCon> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolicitudNovedadCon> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolicitudNovedadCon> results) {
        this.results = results;
    }
}
