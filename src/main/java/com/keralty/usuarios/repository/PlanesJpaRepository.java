package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Afiliaciones;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Dominio;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanesJpaRepository extends JpaRepository<Planes, Long>, PlanesJpaRepositoryCustom {

    List<Planes> findByDominios(Dominio dominios);

    List<Planes> findByContratosC(ContratoC contratosC);

    List<Planes> findByAfiliaciones(Afiliaciones afiliaciones);

    List<Planes> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Planes> findByProductoT(Productos productoT);
}
