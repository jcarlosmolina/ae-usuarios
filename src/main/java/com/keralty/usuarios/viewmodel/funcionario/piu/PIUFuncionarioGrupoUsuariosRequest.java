package com.keralty.usuarios.viewmodel.funcionario.piu;

import com.keralty.usuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.usuarios.viewmodel.QueryRequest;
import com.keralty.usuarios.viewmodel.funcionario.filter.FFuncionarioPorNombre;

public class PIUFuncionarioGrupoUsuariosRequest extends PopulationRequestViewModel{

    private FFuncionarioPorNombre fFuncionarioPorNombre;
    
    public void setFFuncionarioPorNombre(FFuncionarioPorNombre fFuncionarioPorNombre) {
        this.fFuncionarioPorNombre = fFuncionarioPorNombre;
    }
    
    public FFuncionarioPorNombre getFFuncionarioPorNombre() {
        return fFuncionarioPorNombre;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fFuncionarioPorNombre != null)
            queryRequest.addFilterRequest(fFuncionarioPorNombre.buildFilterRequest());
        return queryRequest;
    }
}
