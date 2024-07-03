package com.keralty.aeusuarios.viewmodel.sucursal.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.sucursal.ds.DSSucursalPIU;

public class PIUSucursalObsResponse extends QueryResponse {

    private List<DSSucursalPIU> results;

    public PIUSucursalObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUSucursalObsResponse(List<DSSucursalPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSucursalPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSucursalPIU> results) {
        this.results = results;
    }
}
