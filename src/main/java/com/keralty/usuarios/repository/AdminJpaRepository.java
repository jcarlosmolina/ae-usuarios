package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpaRepository extends JpaRepository<Admin, Long>, AdminJpaRepositoryCustom {
}
