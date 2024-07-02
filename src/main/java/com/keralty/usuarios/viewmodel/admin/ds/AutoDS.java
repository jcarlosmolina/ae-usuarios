package com.keralty.usuarios.viewmodel.admin.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.usuarios.persistence.Admin;
public class AutoDS {

    @JsonProperty("usuario")
    private String _Auto_Usuario;

    @JsonProperty("primernombre")
    private String _Auto_PrimerNombre;

    @JsonProperty("segundonombre")
    private String _Auto_SegundoNombre;

    @JsonProperty("primerapellido")
    private String _Auto_PrimerApellido;

    @JsonProperty("segundoapellido")
    private String _Auto_SegundoApellido;

    @JsonProperty("drvnombrecompleto")
    private String _Auto_DrvNombreCompleto;

    @JsonProperty("usuarioldap")
    private String _Auto_UsuarioLDAP;

    @JsonProperty("email")
    private String _Auto_Email;

    @JsonProperty("codjefe")
    private String _Auto_CodJefe;

    @JsonProperty("id")
    private Long _Auto_Id;

    @JsonProperty("manual")
    private Boolean _Auto_Manual;

    @JsonProperty("drvnomjefe")
    private String _Auto_DrvNomJefe;

    @JsonProperty("drvnomagencia")
    private String _Auto_DrvNomAgencia;

    @JsonProperty("disponible")
    private Boolean _Auto_Disponible;

    @JsonProperty("numsolnoterminadas")
    private Long _Auto_NumSolNoTerminadas;

    @JsonProperty("drvesasesorintegral")
    private Boolean _Auto_DrvEsAsesorIntegral;

    @JsonProperty("drvesafiliacion")
    private Boolean _Auto_DrvEsAfiliacion;

    public AutoDS() {
    
    }

    public AutoDS(Admin instance) {
        if (instance != null) {
            try {
                this._Auto_Usuario = instance.getFuncionarioUsuario();
                this._Auto_PrimerNombre = instance.getFuncionarioPrimerNombre();
                this._Auto_SegundoNombre = instance.getFuncionarioSegundoNombre();
                this._Auto_PrimerApellido = instance.getFuncionarioPrimerApellido();
                this._Auto_SegundoApellido = instance.getFuncionarioSegundoApellido();
                this._Auto_DrvNombreCompleto = instance.getFuncionariodrvNombreCompleto();
                this._Auto_UsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
                this._Auto_Email = instance.getFuncionarioEmail();
                this._Auto_CodJefe = instance.getFuncionarioCodJefe();
                this._Auto_Id = instance.getFuncionarioId();
                this._Auto_Manual = instance.getFuncionarioManual();
                this._Auto_DrvNomJefe = instance.getFuncionariodrvNomJefe();
                this._Auto_DrvNomAgencia = instance.getFuncionariodrvNomAgencia();
                this._Auto_Disponible = instance.getFuncionarioDisponible();
                this._Auto_NumSolNoTerminadas = instance.getFuncionarioNumSolNoTerminadas();
                this._Auto_DrvEsAsesorIntegral = instance.getFuncionariodrvEsAsesorIntegral();
                this._Auto_DrvEsAfiliacion = instance.getFuncionariodrvEsAfiliacion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String get_Auto_Usuario() {
        return this._Auto_Usuario;
    }
    
    public void set_Auto_Usuario(String _Auto_Usuario) {
        this._Auto_Usuario = _Auto_Usuario;
    }

    @JsonIgnore
    public String get_Auto_PrimerNombre() {
        return this._Auto_PrimerNombre;
    }
    
    public void set_Auto_PrimerNombre(String _Auto_PrimerNombre) {
        this._Auto_PrimerNombre = _Auto_PrimerNombre;
    }

    @JsonIgnore
    public String get_Auto_SegundoNombre() {
        return this._Auto_SegundoNombre;
    }
    
    public void set_Auto_SegundoNombre(String _Auto_SegundoNombre) {
        this._Auto_SegundoNombre = _Auto_SegundoNombre;
    }

    @JsonIgnore
    public String get_Auto_PrimerApellido() {
        return this._Auto_PrimerApellido;
    }
    
    public void set_Auto_PrimerApellido(String _Auto_PrimerApellido) {
        this._Auto_PrimerApellido = _Auto_PrimerApellido;
    }

    @JsonIgnore
    public String get_Auto_SegundoApellido() {
        return this._Auto_SegundoApellido;
    }
    
    public void set_Auto_SegundoApellido(String _Auto_SegundoApellido) {
        this._Auto_SegundoApellido = _Auto_SegundoApellido;
    }

    @JsonIgnore
    public String get_Auto_DrvNombreCompleto() {
        return this._Auto_DrvNombreCompleto;
    }
    
    public void set_Auto_DrvNombreCompleto(String _Auto_DrvNombreCompleto) {
        this._Auto_DrvNombreCompleto = _Auto_DrvNombreCompleto;
    }

    @JsonIgnore
    public String get_Auto_UsuarioLDAP() {
        return this._Auto_UsuarioLDAP;
    }
    
    public void set_Auto_UsuarioLDAP(String _Auto_UsuarioLDAP) {
        this._Auto_UsuarioLDAP = _Auto_UsuarioLDAP;
    }

    @JsonIgnore
    public String get_Auto_Email() {
        return this._Auto_Email;
    }
    
    public void set_Auto_Email(String _Auto_Email) {
        this._Auto_Email = _Auto_Email;
    }

    @JsonIgnore
    public String get_Auto_CodJefe() {
        return this._Auto_CodJefe;
    }
    
    public void set_Auto_CodJefe(String _Auto_CodJefe) {
        this._Auto_CodJefe = _Auto_CodJefe;
    }

    @JsonIgnore
    public Long get_Auto_Id() {
        return this._Auto_Id;
    }
    
    public void set_Auto_Id(Long _Auto_Id) {
        this._Auto_Id = _Auto_Id;
    }

    @JsonIgnore
    public Boolean get_Auto_Manual() {
        return this._Auto_Manual;
    }
    
    public void set_Auto_Manual(Boolean _Auto_Manual) {
        this._Auto_Manual = _Auto_Manual;
    }

    @JsonIgnore
    public String get_Auto_DrvNomJefe() {
        return this._Auto_DrvNomJefe;
    }
    
    public void set_Auto_DrvNomJefe(String _Auto_DrvNomJefe) {
        this._Auto_DrvNomJefe = _Auto_DrvNomJefe;
    }

    @JsonIgnore
    public String get_Auto_DrvNomAgencia() {
        return this._Auto_DrvNomAgencia;
    }
    
    public void set_Auto_DrvNomAgencia(String _Auto_DrvNomAgencia) {
        this._Auto_DrvNomAgencia = _Auto_DrvNomAgencia;
    }

    @JsonIgnore
    public Boolean get_Auto_Disponible() {
        return this._Auto_Disponible;
    }
    
    public void set_Auto_Disponible(Boolean _Auto_Disponible) {
        this._Auto_Disponible = _Auto_Disponible;
    }

    @JsonIgnore
    public Long get_Auto_NumSolNoTerminadas() {
        return this._Auto_NumSolNoTerminadas;
    }
    
    public void set_Auto_NumSolNoTerminadas(Long _Auto_NumSolNoTerminadas) {
        this._Auto_NumSolNoTerminadas = _Auto_NumSolNoTerminadas;
    }

    @JsonIgnore
    public Boolean get_Auto_DrvEsAsesorIntegral() {
        return this._Auto_DrvEsAsesorIntegral;
    }
    
    public void set_Auto_DrvEsAsesorIntegral(Boolean _Auto_DrvEsAsesorIntegral) {
        this._Auto_DrvEsAsesorIntegral = _Auto_DrvEsAsesorIntegral;
    }

    @JsonIgnore
    public Boolean get_Auto_DrvEsAfiliacion() {
        return this._Auto_DrvEsAfiliacion;
    }
    
    public void set_Auto_DrvEsAfiliacion(Boolean _Auto_DrvEsAfiliacion) {
        this._Auto_DrvEsAfiliacion = _Auto_DrvEsAfiliacion;
    }
}
