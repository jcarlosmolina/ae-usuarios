package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import com.keralty.usuarios.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudNovedadJpaRepository extends JpaRepository<SolicitudNovedad, Long>, SolicitudNovedadJpaRepositoryCustom {

    List<SolicitudNovedad> findByPlanT(Planes planT);

    List<SolicitudNovedad> findByTipoIdentContratante(TipoIdentificacion tipoIdentContratante);

    List<SolicitudNovedad> findByAgente(Funcionario agente);

    List<SolicitudNovedad> findByUsrAfiliacion(Funcionario usrAfiliacion);

    List<SolicitudNovedad> findByFirma(Firma firma);
}
