package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.oid.AgentexProductoOid;
import com.keralty.usuarios.persistence.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentexProductoJpaRepository extends JpaRepository<AgentexProducto, AgentexProductoOid>, AgentexProductoJpaRepositoryCustom {

    List<AgentexProducto> findByProductoT(Productos productoT);

    List<AgentexProducto> findByAsesor(Asesor asesor);

    List<AgentexProducto> findByDominios(Dominio dominios);
}
