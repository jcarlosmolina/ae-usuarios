package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.GrupoAsignacion;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.persistence.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DominioJpaRepository extends JpaRepository<Dominio, Long>, DominioJpaRepositoryCustom {

    List<Dominio> findByDominiosConIncompatibilidad(Dominio dominiosConIncompatibilidad);

    List<Dominio> findByAgentexProducto(AgentexProducto agentexProducto);

    List<Dominio> findByPlanT(Planes planT);

    List<Dominio> findByProductoT(Productos productoT);

    List<Dominio> findByRoles(Rol roles);

    List<Dominio> findByGrupoAsesores(GrupoAsignacion grupoAsesores);

    List<Dominio> findByGrupoAreaMedica(GrupoAsignacion grupoAreaMedica);

    List<Dominio> findByDominiosIncompatibles(Dominio dominiosIncompatibles);
}
