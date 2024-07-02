package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepository extends JpaRepository<Rol, Long>, RolJpaRepositoryCustom {

    List<Rol> findByAgentes(Funcionario agentes);

    List<Rol> findByDominios(Dominio dominios);
}
