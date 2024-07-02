package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.MesaDeApoyo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDeApoyoJpaRepository extends JpaRepository<MesaDeApoyo, Long>, MesaDeApoyoJpaRepositoryCustom {
}
