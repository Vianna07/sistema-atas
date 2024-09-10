package com.vianna.sistema_atas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vianna.sistema_atas.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
