package com.keralty.usuarios.viewmodel.solicitud.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.solicitud.filter.FSolicitudStatusAdmin;

public class PIUEstatusSolicitudesAdminRequest extends PopulationRequestViewModel{

    private FSolicitudStatusAdmin fSolicitudStatusAdmin;
    
    public void setFSolicitudStatusAdmin(FSolicitudStatusAdmin fSolicitudStatusAdmin) {
        this.fSolicitudStatusAdmin = fSolicitudStatusAdmin;
    }
    
    public FSolicitudStatusAdmin getFSolicitudStatusAdmin() {
        return fSolicitudStatusAdmin;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fSolicitudStatusAdmin != null)
            queryRequest.addFilterRequest(fSolicitudStatusAdmin.buildFilterRequest());
        return queryRequest;
    }
}
