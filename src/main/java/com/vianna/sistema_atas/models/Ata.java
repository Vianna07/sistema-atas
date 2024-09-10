package com.vianna.sistema_atas.models;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import com.vianna.sistema_atas.enums.StatusAta;
import com.vianna.sistema_atas.enums.TipoAta;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Data
public class Ata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private LocalDate dataEmissao;
    private LocalDate inicio;
    private LocalDate termino;

    @Column(length = 500)
    private String pauta;

    @Column(length = 3000)
    private String descricao;

    @ElementCollection
    private List<String> palavrasChave;

    @Enumerated(EnumType.STRING)
    private TipoAta tipo;

    @Enumerated(EnumType.STRING)
    private StatusAta status;

    @ManyToMany
    private List<Funcionario> participantes;
}
