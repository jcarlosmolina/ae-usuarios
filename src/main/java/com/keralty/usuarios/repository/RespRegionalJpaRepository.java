package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Firma;
import com.keralty.usuarios.persistence.Regional;
import com.keralty.usuarios.persistence.RespRegional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespRegionalJpaRepository extends JpaRepository<RespRegional, Long>, RespRegionalJpaRepositoryCustom {

    List<RespRegional> findByFirma(Firma firma);

    List<RespRegional> findByRegional(Regional regional);
}
