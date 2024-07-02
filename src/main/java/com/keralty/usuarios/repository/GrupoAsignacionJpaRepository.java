package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoAsignacionJpaRepository extends JpaRepository<GrupoAsignacion, Long>, GrupoAsignacionJpaRepositoryCustom {

    List<GrupoAsignacion> findByDominioAsesores(Dominio dominioAsesores);

    List<GrupoAsignacion> findByDominioAreaMedica(Dominio dominioAreaMedica);

    List<GrupoAsignacion> findByFuncionario(Funcionario funcionario);
}
