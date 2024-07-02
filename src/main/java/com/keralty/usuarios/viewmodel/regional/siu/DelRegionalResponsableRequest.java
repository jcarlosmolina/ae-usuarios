package com.keralty.usuarios.viewmodel.regional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.exception.NotNullArgumentException;
import com.keralty.usuarios.global.RegionalConstants;
import com.keralty.usuarios.persistence.oid.RegionalOid;
import com.keralty.usuarios.persistence.oid.RespRegionalOid;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.RespRegional;

public class DelRegionalResponsableRequest {

    @JsonProperty("p_thisregional_oid")
    private RegionalOid regionalDelRegionalResponsablepthisRegional;
    
    @JsonIgnore
    private Regional regionalDelRegionalResponsablepthisRegionalInstance;

    @JsonProperty("p_evcrespregional_oid")
    private RespRegionalOid regionalDelRegionalResponsablepevcRespRegional;
    
    @JsonIgnore
    private RespRegional regionalDelRegionalResponsablepevcRespRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRegionalDelRegionalResponsablepthisRegional();
        checkRegionalDelRegionalResponsablepevcRespRegional();
    }

    @JsonIgnore
    public RegionalOid getRegionalDelRegionalResponsablepthisRegional() {
        return this.regionalDelRegionalResponsablepthisRegional;
    }
    
    public void setRegionalDelRegionalResponsablepthisRegional(RegionalOid regionalDelRegionalResponsablepthisRegional) {
        this.regionalDelRegionalResponsablepthisRegional = regionalDelRegionalResponsablepthisRegional;
    }

    @JsonIgnore
    public Regional getRegionalDelRegionalResponsablepthisRegionalInstance() {
        return this.regionalDelRegionalResponsablepthisRegionalInstance;
    }
    
    public void setRegionalDelRegionalResponsablepthisRegionalInstance(Regional regionalDelRegionalResponsablepthisRegional) {
        this.regionalDelRegionalResponsablepthisRegionalInstance = regionalDelRegionalResponsablepthisRegional;
        this.regionalDelRegionalResponsablepthisRegional = regionalDelRegionalResponsablepthisRegional != null ? regionalDelRegionalResponsablepthisRegional.getOid() : null;
    }

    private void checkRegionalDelRegionalResponsablepthisRegional() throws NotNullArgumentException {
        if(this.getRegionalDelRegionalResponsablepthisRegionalInstance() == null || this.getRegionalDelRegionalResponsablepthisRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_DELREGIONALRESPONSABLE, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_DELREGIONALRESPONSABLE_REGIONALDELREGIONALRESPONSABLEPTHISREGIONAL, RegionalConstants.SERV_ALIAS_DELREGIONALRESPONSABLE, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_DELREGIONALRESPONSABLE_REGIONALDELREGIONALRESPONSABLEPTHISREGIONAL);
        }
    }

    @JsonIgnore
    public RespRegionalOid getRegionalDelRegionalResponsablepevcRespRegional() {
        return this.regionalDelRegionalResponsablepevcRespRegional;
    }
    
    public void setRegionalDelRegionalResponsablepevcRespRegional(RespRegionalOid regionalDelRegionalResponsablepevcRespRegional) {
        this.regionalDelRegionalResponsablepevcRespRegional = regionalDelRegionalResponsablepevcRespRegional;
    }

    @JsonIgnore
    public RespRegional getRegionalDelRegionalResponsablepevcRespRegionalInstance() {
        return this.regionalDelRegionalResponsablepevcRespRegionalInstance;
    }
    
    public void setRegionalDelRegionalResponsablepevcRespRegionalInstance(RespRegional regionalDelRegionalResponsablepevcRespRegional) {
        this.regionalDelRegionalResponsablepevcRespRegionalInstance = regionalDelRegionalResponsablepevcRespRegional;
        this.regionalDelRegionalResponsablepevcRespRegional = regionalDelRegionalResponsablepevcRespRegional != null ? regionalDelRegionalResponsablepevcRespRegional.getOid() : null;
    }

    private void checkRegionalDelRegionalResponsablepevcRespRegional() throws NotNullArgumentException {
        if(this.getRegionalDelRegionalResponsablepevcRespRegionalInstance() == null || this.getRegionalDelRegionalResponsablepevcRespRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_DELREGIONALRESPONSABLE, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_DELREGIONALRESPONSABLE_REGIONALDELREGIONALRESPONSABLEPEVCRESPREGIONAL, RegionalConstants.SERV_ALIAS_DELREGIONALRESPONSABLE, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_DELREGIONALRESPONSABLE_REGIONALDELREGIONALRESPONSABLEPEVCRESPREGIONAL);
        }
    }
}
