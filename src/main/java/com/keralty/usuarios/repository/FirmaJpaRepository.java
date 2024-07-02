package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.persistence.Solicitud;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmaJpaRepository extends JpaRepository<Firma, Long>, FirmaJpaRepositoryCustom {

    List<Firma> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);

    List<Firma> findBySolicitud(Solicitud solicitud);

    List<Firma> findBySolicitudSegunda(Solicitud solicitudSegunda);

    List<Firma> findByRespRegional(RespRegional respRegional);

    List<Firma> findBySolicitudContratante(Solicitud solicitudContratante);
}
