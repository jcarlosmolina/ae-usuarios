package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.ReportesProcAlm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportesProcAlmJpaRepository extends JpaRepository<ReportesProcAlm, Long>, ReportesProcAlmJpaRepositoryCustom {

    List<ReportesProcAlm> findByFuncionarios(Funcionario funcionarios);
}
