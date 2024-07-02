package com.keralty.usuarios.viewmodel.solicitudnovedad.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.solicitudnovedad.filter.FSolicitudNovedadNumFechEsta;

public class PIUEstatusSolNovRequest extends PopulationRequestViewModel{

    private FSolicitudNovedadNumFechEsta fSolicitudNovedadNumFechEsta;
    
    public void setFSolicitudNovedadNumFechEsta(FSolicitudNovedadNumFechEsta fSolicitudNovedadNumFechEsta) {
        this.fSolicitudNovedadNumFechEsta = fSolicitudNovedadNumFechEsta;
    }
    
    public FSolicitudNovedadNumFechEsta getFSolicitudNovedadNumFechEsta() {
        return fSolicitudNovedadNumFechEsta;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fSolicitudNovedadNumFechEsta != null)
            queryRequest.addFilterRequest(fSolicitudNovedadNumFechEsta.buildFilterRequest());
        return queryRequest;
    }
}
