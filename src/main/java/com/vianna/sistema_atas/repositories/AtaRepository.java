package com.vianna.sistema_atas.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vianna.sistema_atas.models.Ata;

public interface AtaRepository extends JpaRepository<Ata, Long> {
    List<Ata> findByTituloContainingIgnoreCase(String titulo);

    List<Ata> findByDataEmissao(LocalDate dataEmissao);

    List<Ata> findByPalavrasChaveContainingIgnoreCase(String palavraChave);
}
