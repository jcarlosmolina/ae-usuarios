package com.keralty.usuarios.viewmodel.sucursal.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.usuarios.viewmodel.QueryResponse;
import com.keralty.usuarios.viewmodel.sucursal.ds.DSSucursalPIU;

public class PIUSucursalResponse extends QueryResponse {

    private List<DSSucursalPIU> results;

    public PIUSucursalResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUSucursalResponse(List<DSSucursalPIU> results) {
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
