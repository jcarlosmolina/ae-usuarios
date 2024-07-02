package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoIdentificacionJpaRepository extends JpaRepository<TipoIdentificacion, Long>, TipoIdentificacionJpaRepositoryCustom {

    List<TipoIdentificacion> findByAsesores(Asesor asesores);

    List<TipoIdentificacion> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
