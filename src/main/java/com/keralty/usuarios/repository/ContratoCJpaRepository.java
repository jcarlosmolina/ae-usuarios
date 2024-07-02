package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Asesor;
import com.keralty.usuarios.persistence.ContratoC;
import com.keralty.usuarios.persistence.Planes;
import com.keralty.usuarios.persistence.Productos;
import com.keralty.usuarios.persistence.Solicitud;
import com.keralty.usuarios.persistence.Sucursal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoCJpaRepository extends JpaRepository<ContratoC, Long>, ContratoCJpaRepositoryCustom {

    List<ContratoC> findBySolicitud(Solicitud solicitud);

    List<ContratoC> findByProductoC(Productos productoC);

    List<ContratoC> findByPlanC(Planes planC);

    List<ContratoC> findBySucursalC(Sucursal sucursalC);

    List<ContratoC> findByAsesorC(Asesor asesorC);
}
