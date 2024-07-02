package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.AgentexProducto;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosJpaRepository extends JpaRepository<Productos, Long>, ProductosJpaRepositoryCustom {

    List<Productos> findByPlanes(Planes planes);

    List<Productos> findByDominios(Dominio dominios);

    List<Productos> findByContratosC(ContratoC contratosC);

    List<Productos> findByAgentexProducto(AgentexProducto agentexProducto);
}
