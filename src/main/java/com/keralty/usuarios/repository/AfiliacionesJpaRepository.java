package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Afiliaciones;
import com.keralty.usuarios.persistence.Planes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfiliacionesJpaRepository extends JpaRepository<Afiliaciones, Long>, AfiliacionesJpaRepositoryCustom {

    List<Afiliaciones> findByPlanes(Planes planes);
}
