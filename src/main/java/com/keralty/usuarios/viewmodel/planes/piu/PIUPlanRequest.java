package com.keralty.usuarios.viewmodel.planes.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.planes.filter.FPlanVarios;

public class PIUPlanRequest extends PopulationRequestViewModel{

    private FPlanVarios fPlanVarios;
    
    public void setFPlanVarios(FPlanVarios fPlanVarios) {
        this.fPlanVarios = fPlanVarios;
    }
    
    public FPlanVarios getFPlanVarios() {
        return fPlanVarios;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fPlanVarios != null)
            queryRequest.addFilterRequest(fPlanVarios.buildFilterRequest());
        return queryRequest;
    }
}
