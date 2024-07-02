package com.keralty.usuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.NotNullArgumentException;
import com.keralty.usuarios.global.FuncionarioConstants;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.oid.FuncionarioOid;

public class DeshacerAfiliacionesRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariodeshacerAfiliacionespthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerAfiliacionespthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerAfiliacionespthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerAfiliacionespthisAgente() {
        return this.funcionariodeshacerAfiliacionespthisAgente;
    }
    
    public void setFuncionariodeshacerAfiliacionespthisAgente(FuncionarioOid funcionariodeshacerAfiliacionespthisAgente) {
        this.funcionariodeshacerAfiliacionespthisAgente = funcionariodeshacerAfiliacionespthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerAfiliacionespthisAgenteInstance() {
        return this.funcionariodeshacerAfiliacionespthisAgenteInstance;
    }
    
    public void setFuncionariodeshacerAfiliacionespthisAgenteInstance(Funcionario funcionariodeshacerAfiliacionespthisAgente) {
        this.funcionariodeshacerAfiliacionespthisAgenteInstance = funcionariodeshacerAfiliacionespthisAgente;
        this.funcionariodeshacerAfiliacionespthisAgente = funcionariodeshacerAfiliacionespthisAgente != null ? funcionariodeshacerAfiliacionespthisAgente.getOid() : null;
    }

    private void checkFuncionariodeshacerAfiliacionespthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerAfiliacionespthisAgenteInstance() == null || this.getFuncionariodeshacerAfiliacionespthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERAFILIACIONES, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERAFILIACIONES_FUNCIONARIODESHACERAFILIACIONESPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_DESHACERAFILIACIONES, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERAFILIACIONES_FUNCIONARIODESHACERAFILIACIONESPTHISAGENTE);
        }
    }
}
