package com.keralty.usuarios.viewmodel.mesadeapoyo.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.mesadeapoyo.filter.FMesaDeApoyo;

public class PIUMesaDeApoyoRequest extends PopulationRequestViewModel{

    private FMesaDeApoyo fMesaDeApoyo;
    
    public void setFMesaDeApoyo(FMesaDeApoyo fMesaDeApoyo) {
        this.fMesaDeApoyo = fMesaDeApoyo;
    }
    
    public FMesaDeApoyo getFMesaDeApoyo() {
        return fMesaDeApoyo;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fMesaDeApoyo != null)
            queryRequest.addFilterRequest(fMesaDeApoyo.buildFilterRequest());
        return queryRequest;
    }
}
