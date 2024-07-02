package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.RespRegional;
import com.keralty.usuarios.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionalJpaRepository extends JpaRepository<Regional, Long>, RegionalJpaRepositoryCustom {

    List<Regional> findByRespRegional(RespRegional respRegional);

    List<Regional> findBySucursales(Sucursal sucursales);
}
