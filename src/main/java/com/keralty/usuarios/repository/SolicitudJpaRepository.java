package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.AreaMedica;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudJpaRepository extends JpaRepository<Solicitud, Long>, SolicitudJpaRepositoryCustom {

    List<Solicitud> findByFirma(Firma firma);

    List<Solicitud> findBySegundaFirma(Firma segundaFirma);

    List<Solicitud> findByFirmaContratanteIncl(Firma firmaContratanteIncl);

    List<Solicitud> findByAgente(Funcionario agente);

    List<Solicitud> findByContratoC(ContratoC contratoC);

    List<Solicitud> findByUsrAreaMedica(AreaMedica usrAreaMedica);

    List<Solicitud> findByUsrAfiliacion(Funcionario usrAfiliacion);
}
