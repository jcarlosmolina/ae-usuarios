package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.FrecuenciaAct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrecuenciaActJpaRepository extends JpaRepository<FrecuenciaAct, Long>, FrecuenciaActJpaRepositoryCustom {
}
