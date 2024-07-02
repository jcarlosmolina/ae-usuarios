package com.keralty.usuarios.viewmodel.afiliaciones.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.afiliaciones.filter.FAfiliacionesPorNombre;

public class PIUAfiliacionesRequest extends PopulationRequestViewModel{

    private FAfiliacionesPorNombre fAfiliacionesPorNombre;
    
    public void setFAfiliacionesPorNombre(FAfiliacionesPorNombre fAfiliacionesPorNombre) {
        this.fAfiliacionesPorNombre = fAfiliacionesPorNombre;
    }
    
    public FAfiliacionesPorNombre getFAfiliacionesPorNombre() {
        return fAfiliacionesPorNombre;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fAfiliacionesPorNombre != null)
            queryRequest.addFilterRequest(fAfiliacionesPorNombre.buildFilterRequest());
        return queryRequest;
    }
}
