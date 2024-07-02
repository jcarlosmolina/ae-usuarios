package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalJpaRepository extends JpaRepository<Sucursal, Long>, SucursalJpaRepositoryCustom {

    List<Sucursal> findByAgentes(Funcionario agentes);

    List<Sucursal> findByContratosC(ContratoC contratosC);

    List<Sucursal> findByRegional(Regional regional);
}
