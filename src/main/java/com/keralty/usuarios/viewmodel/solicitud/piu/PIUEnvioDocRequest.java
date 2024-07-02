package com.keralty.usuarios.viewmodel.solicitud.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.solicitud.filter.FSolicitudContratanteTitular;
import com.keralty.usuarios.viewmodel.solicitud.filter.FSolicitudSolicitud;

public class PIUEnvioDocRequest extends PopulationRequestViewModel{

    private FSolicitudContratanteTitular fSolicitudContratanteTitular;

    private FSolicitudSolicitud fSolicitudSolicitud;
    
    public void setFSolicitudContratanteTitular(FSolicitudContratanteTitular fSolicitudContratanteTitular) {
        this.fSolicitudContratanteTitular = fSolicitudContratanteTitular;
    }
    
    public FSolicitudContratanteTitular getFSolicitudContratanteTitular() {
        return fSolicitudContratanteTitular;
    }
    
    public void setFSolicitudSolicitud(FSolicitudSolicitud fSolicitudSolicitud) {
        this.fSolicitudSolicitud = fSolicitudSolicitud;
    }
    
    public FSolicitudSolicitud getFSolicitudSolicitud() {
        return fSolicitudSolicitud;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fSolicitudContratanteTitular != null)
            queryRequest.addFilterRequest(fSolicitudContratanteTitular.buildFilterRequest());

        if (fSolicitudSolicitud != null)
            queryRequest.addFilterRequest(fSolicitudSolicitud.buildFilterRequest());
        return queryRequest;
    }
}
