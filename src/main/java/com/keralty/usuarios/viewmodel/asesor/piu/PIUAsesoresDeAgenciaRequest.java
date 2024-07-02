package com.keralty.usuarios.viewmodel.asesor.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.asesor.filter.FAsesoresAgencia;

public class PIUAsesoresDeAgenciaRequest extends PopulationRequestViewModel{

    private FAsesoresAgencia fAsesoresAgencia;
    
    public void setFAsesoresAgencia(FAsesoresAgencia fAsesoresAgencia) {
        this.fAsesoresAgencia = fAsesoresAgencia;
    }
    
    public FAsesoresAgencia getFAsesoresAgencia() {
        return fAsesoresAgencia;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fAsesoresAgencia != null)
            queryRequest.addFilterRequest(fAsesoresAgencia.buildFilterRequest());
        return queryRequest;
    }
}
