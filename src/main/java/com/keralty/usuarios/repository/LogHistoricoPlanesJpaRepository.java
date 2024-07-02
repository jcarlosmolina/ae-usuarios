package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.LogHistoricoPlanes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogHistoricoPlanesJpaRepository extends JpaRepository<LogHistoricoPlanes, Long>, LogHistoricoPlanesJpaRepositoryCustom {

    List<LogHistoricoPlanes> findByAsesor(Asesor asesor);
}
