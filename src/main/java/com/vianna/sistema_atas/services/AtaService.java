package com.vianna.sistema_atas.services;

import org.springframework.stereotype.Service;

import com.vianna.sistema_atas.models.Ata;
import com.vianna.sistema_atas.repositories.AtaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtaService {

    private final AtaRepository ataRepository;

    public AtaService(AtaRepository ataRepository) {
        this.ataRepository = ataRepository;
    }

    public List<Ata> listarAtas() {
        return ataRepository.findAll();
    }

    public Ata salvarAta(Ata ata) {
        return ataRepository.save(ata);
    }

    public Ata buscarPorId(Long id) {
        return ataRepository.findById(id).orElse(null);
    }

    public void deletarAta(Long id) {
        ataRepository.deleteById(id);
    }
    
    public List<Ata> buscarAtas(String titulo, LocalDate dataEmissao, String palavraChave) {
        if (titulo != null && !titulo.isEmpty()) {
            return ataRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (dataEmissao != null) {
            return ataRepository.findByDataEmissao(dataEmissao);
        } else if (palavraChave != null && !palavraChave.isEmpty()) {
            return ataRepository.findByPalavrasChaveContainingIgnoreCase(palavraChave);
        } else {
            return listarAtas();
        }
    }
}
