package com.keralty.usuarios.viewmodel.solicitud.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Solicitud;
public class DSSolicitudIIUInfoContratNAT {

    @JsonProperty("contratante_titularconbeneficios")
    private Boolean dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios;

    @JsonProperty("contratante_diplomatico")
    private Boolean dSSolicitudIIUInfoContratNATContratanteDotDiplomatico;

    @JsonProperty("contratante_primernombre")
    private String dSSolicitudIIUInfoContratNATContratanteDotPrimerNombre;

    @JsonProperty("contratante_segundonombre")
    private String dSSolicitudIIUInfoContratNATContratanteDotSegundoNombre;

    @JsonProperty("contratante_primerapellido")
    private String dSSolicitudIIUInfoContratNATContratanteDotPrimerApellido;

    @JsonProperty("contratante_segundoapellido")
    private String dSSolicitudIIUInfoContratNATContratanteDotSegundoApellido;

    @JsonProperty("contratante_fechanacimiento")
    private Date dSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento;

    @JsonProperty("contratante_genero")
    private String dSSolicitudIIUInfoContratNATContratanteDotGenero;

    @JsonProperty("contratante_indicadorextranjero")
    private Boolean dSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero;

    @JsonProperty("contratante_departamentonac_descripcion")
    private String dSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion;

    @JsonProperty("contratante_municipionac_descripcion")
    private String dSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion;

    @JsonProperty("contratante_titularconbeneficioscore")
    private Boolean dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE;

    public DSSolicitudIIUInfoContratNAT() {
    
    }

    public DSSolicitudIIUInfoContratNAT(Solicitud instance) {
        if (instance != null) {
            try {
                this.dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios = instance.getContratante().getContratanteTitularConBeneficios();
                this.dSSolicitudIIUInfoContratNATContratanteDotDiplomatico = instance.getContratante().getContratanteDiplomatico();
                this.dSSolicitudIIUInfoContratNATContratanteDotPrimerNombre = instance.getContratante().getContratantePrimerNombre();
                this.dSSolicitudIIUInfoContratNATContratanteDotSegundoNombre = instance.getContratante().getContratanteSegundoNombre();
                this.dSSolicitudIIUInfoContratNATContratanteDotPrimerApellido = instance.getContratante().getContratantePrimerApellido();
                this.dSSolicitudIIUInfoContratNATContratanteDotSegundoApellido = instance.getContratante().getContratanteSegundoApellido();
                this.dSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento = instance.getContratante().getContratanteFechaNacimiento();
                this.dSSolicitudIIUInfoContratNATContratanteDotGenero = instance.getContratante().getContratanteGenero();
                this.dSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero = instance.getContratante().getContratanteIndicadorExtranjero();
                this.dSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion = instance.getContratante().getDepartamentoNac().getDepartamentoDescripcion();
                this.dSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion = instance.getContratante().getMunicipioNac().getMunicipioDescripcion();
                this.dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE = instance.getContratante().getContratanteTitularConBeneficiosCORE();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Boolean getDSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios(Boolean dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios) {
        this.dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios = dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficios;
    }

    @JsonIgnore
    public Boolean getDSSolicitudIIUInfoContratNATContratanteDotDiplomatico() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotDiplomatico;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotDiplomatico(Boolean dSSolicitudIIUInfoContratNATContratanteDotDiplomatico) {
        this.dSSolicitudIIUInfoContratNATContratanteDotDiplomatico = dSSolicitudIIUInfoContratNATContratanteDotDiplomatico;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotPrimerNombre() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotPrimerNombre;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotPrimerNombre(String dSSolicitudIIUInfoContratNATContratanteDotPrimerNombre) {
        this.dSSolicitudIIUInfoContratNATContratanteDotPrimerNombre = dSSolicitudIIUInfoContratNATContratanteDotPrimerNombre;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotSegundoNombre() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotSegundoNombre;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotSegundoNombre(String dSSolicitudIIUInfoContratNATContratanteDotSegundoNombre) {
        this.dSSolicitudIIUInfoContratNATContratanteDotSegundoNombre = dSSolicitudIIUInfoContratNATContratanteDotSegundoNombre;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotPrimerApellido() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotPrimerApellido;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotPrimerApellido(String dSSolicitudIIUInfoContratNATContratanteDotPrimerApellido) {
        this.dSSolicitudIIUInfoContratNATContratanteDotPrimerApellido = dSSolicitudIIUInfoContratNATContratanteDotPrimerApellido;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotSegundoApellido() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotSegundoApellido;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotSegundoApellido(String dSSolicitudIIUInfoContratNATContratanteDotSegundoApellido) {
        this.dSSolicitudIIUInfoContratNATContratanteDotSegundoApellido = dSSolicitudIIUInfoContratNATContratanteDotSegundoApellido;
    }

    @JsonIgnore
    public Date getDSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento(Date dSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento) {
        this.dSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento = dSSolicitudIIUInfoContratNATContratanteDotFechaNacimiento;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotGenero() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotGenero;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotGenero(String dSSolicitudIIUInfoContratNATContratanteDotGenero) {
        this.dSSolicitudIIUInfoContratNATContratanteDotGenero = dSSolicitudIIUInfoContratNATContratanteDotGenero;
    }

    @JsonIgnore
    public Boolean getDSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero(Boolean dSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero) {
        this.dSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero = dSSolicitudIIUInfoContratNATContratanteDotIndicadorExtranjero;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion(String dSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion) {
        this.dSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion = dSSolicitudIIUInfoContratNATContratanteDotDepartamentoNacDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion(String dSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion) {
        this.dSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion = dSSolicitudIIUInfoContratNATContratanteDotMunicipioNacDotDescripcion;
    }

    @JsonIgnore
    public Boolean getDSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE() {
        return this.dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE;
    }
    
    public void setDSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE(Boolean dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE) {
        this.dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE = dSSolicitudIIUInfoContratNATContratanteDotTitularConBeneficiosCORE;
    }
}
