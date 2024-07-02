package com.keralty.usuarios.repository;

import com.keralty.usuarios.persistence.Funcionario;
import com.keralty.usuarios.persistence.LogFuncionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogFuncionarioJpaRepository extends JpaRepository<LogFuncionario, Long>, LogFuncionarioJpaRepositoryCustom {

    List<LogFuncionario> findByFuncionario(Funcionario funcionario);
}
