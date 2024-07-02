package com.keralty.usuarios.viewmodel.firma.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.firma.filter.FFirmasResponsables;

public class PIUFirmasRespRegionalRequest extends PopulationRequestViewModel{

    private FFirmasResponsables fFirmasResponsables;
    
    public void setFFirmasResponsables(FFirmasResponsables fFirmasResponsables) {
        this.fFirmasResponsables = fFirmasResponsables;
    }
    
    public FFirmasResponsables getFFirmasResponsables() {
        return fFirmasResponsables;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fFirmasResponsables != null)
            queryRequest.addFilterRequest(fFirmasResponsables.buildFilterRequest());
        return queryRequest;
    }
}
