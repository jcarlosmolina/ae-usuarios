package com.keralty.usuarios.viewmodel.solicitud.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.solicitud.filter.FSolicitudStatusEstHomo;

public class PIUEstatusSolGestorMesaRequest extends PopulationRequestViewModel{

    private FSolicitudStatusEstHomo fSolicitudStatusEstHomo;
    
    public void setFSolicitudStatusEstHomo(FSolicitudStatusEstHomo fSolicitudStatusEstHomo) {
        this.fSolicitudStatusEstHomo = fSolicitudStatusEstHomo;
    }
    
    public FSolicitudStatusEstHomo getFSolicitudStatusEstHomo() {
        return fSolicitudStatusEstHomo;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fSolicitudStatusEstHomo != null)
            queryRequest.addFilterRequest(fSolicitudStatusEstHomo.buildFilterRequest());
        return queryRequest;
    }
}
