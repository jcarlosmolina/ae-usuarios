package com.keralty.usuarios.viewmodel.dominio.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.dominio.filter.FDominioVarios;

public class PIUDominioRequest extends PopulationRequestViewModel{

    private FDominioVarios fDominioVarios;
    
    public void setFDominioVarios(FDominioVarios fDominioVarios) {
        this.fDominioVarios = fDominioVarios;
    }
    
    public FDominioVarios getFDominioVarios() {
        return fDominioVarios;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fDominioVarios != null)
            queryRequest.addFilterRequest(fDominioVarios.buildFilterRequest());
        return queryRequest;
    }
}
