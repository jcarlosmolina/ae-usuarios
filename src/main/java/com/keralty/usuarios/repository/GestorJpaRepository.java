package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorJpaRepository extends JpaRepository<Gestor, Long>, GestorJpaRepositoryCustom {
}
