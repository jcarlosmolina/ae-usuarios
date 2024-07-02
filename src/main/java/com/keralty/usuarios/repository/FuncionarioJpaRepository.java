package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.persistence.LogFuncionario;
import com.keralty.usuarios.persistence.ReportesProcAlm;
import com.keralty.usuarios.persistence.Rol;
import com.keralty.usuarios.persistence.Solicitud;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioJpaRepository extends JpaRepository<Funcionario, Long>, FuncionarioJpaRepositoryCustom {

    List<Funcionario> findBySolicitudes(Solicitud solicitudes);

    List<Funcionario> findBySolicitudesAfiliacion(Solicitud solicitudesAfiliacion);

    List<Funcionario> findByReportes(ReportesProcAlm reportes);

    List<Funcionario> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Funcionario> findBySolNovAifliaciones(SolicitudNovedad solNovAifliaciones);

    List<Funcionario> findByGrupoAsignacion(GrupoAsignacion grupoAsignacion);

    List<Funcionario> findByLogFuncionario(LogFuncionario logFuncionario);

    List<Funcionario> findByRol(Rol rol);

    List<Funcionario> findBySucursal(Sucursal sucursal);
}
