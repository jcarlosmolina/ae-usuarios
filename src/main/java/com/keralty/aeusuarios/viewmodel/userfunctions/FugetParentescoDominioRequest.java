package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.ParentescoOid;
import com.keralty.aeusuarios.persistence.Parentesco;
public class FugetParentescoDominioRequest {

    @JsonProperty("pfu_dominio")
    private DominioOid pfuDominio;

    @JsonIgnore
    private Dominio pfuDominioInstance;

    @JsonProperty("pfu_parentesco")
    private ParentescoOid pfuParentesco;

    @JsonIgnore
    private Parentesco pfuParentescoInstance;

    public FugetParentescoDominioRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public DominioOid getPfuDominio() {
        return this.pfuDominio;
    }
    
    public void setPfuDominio(DominioOid pfuDominio) {
        this.pfuDominio = pfuDominio;
    }

    @JsonIgnore
    public Dominio getPfuDominioInstance() {
        if (this.pfuDominioInstance == null)
            this.pfuDominioInstance = new Dominio();
        return this.pfuDominioInstance;
    }
    
    public void setPfuDominioInstance(Dominio pfuDominio) {
        this.pfuDominioInstance = pfuDominio;
    }
    @JsonIgnore
    public ParentescoOid getPfuParentesco() {
        return this.pfuParentesco;
    }
    
    public void setPfuParentesco(ParentescoOid pfuParentesco) {
        this.pfuParentesco = pfuParentesco;
    }

    @JsonIgnore
    public Parentesco getPfuParentescoInstance() {
        if (this.pfuParentescoInstance == null)
            this.pfuParentescoInstance = new Parentesco();
        return this.pfuParentescoInstance;
    }
    
    public void setPfuParentescoInstance(Parentesco pfuParentesco) {
        this.pfuParentescoInstance = pfuParentesco;
    }
}
