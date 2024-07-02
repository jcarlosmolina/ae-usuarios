package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.LogInformacionAsesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInformacionAsesorJpaRepository extends JpaRepository<LogInformacionAsesor, Long>, LogInformacionAsesorJpaRepositoryCustom {

    List<LogInformacionAsesor> findByAsesor(Asesor asesor);
}
