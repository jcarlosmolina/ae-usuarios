package com.keralty.usuarios.viewmodel.reportesprocalm.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportesProcAlmPostViewModel {

    @JsonProperty(value="Descripcion")
    private String reportesProcAlmDescripcion;

    @JsonProperty(value="NombreProc")
    private String reportesProcAlmNombreProc;

    @JsonProperty(value="NombreFichero")
    private String reportesProcAlmNombreFichero;

    public String getReportesProcAlmDescripcion() {
        return reportesProcAlmDescripcion;
    }
    
    public void setReportesProcAlmDescripcion(String reportesProcAlmDescripcion) {
        this.reportesProcAlmDescripcion = reportesProcAlmDescripcion;
    }

    public String getReportesProcAlmNombreProc() {
        return reportesProcAlmNombreProc;
    }
    
    public void setReportesProcAlmNombreProc(String reportesProcAlmNombreProc) {
        this.reportesProcAlmNombreProc = reportesProcAlmNombreProc;
    }

    public String getReportesProcAlmNombreFichero() {
        return reportesProcAlmNombreFichero;
    }
    
    public void setReportesProcAlmNombreFichero(String reportesProcAlmNombreFichero) {
        this.reportesProcAlmNombreFichero = reportesProcAlmNombreFichero;
    }
}
