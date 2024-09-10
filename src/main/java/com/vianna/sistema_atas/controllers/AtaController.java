package com.vianna.sistema_atas.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.vianna.sistema_atas.models.Ata;
import com.vianna.sistema_atas.services.AtaService;

@Controller
@RequestMapping("/atas")
public class AtaController {

    private final AtaService ataService;

    public AtaController(AtaService ataService) {
        this.ataService = ataService;
    }

    @GetMapping
    public String listarAtas(Model model) {
        model.addAttribute("atas", ataService.listarAtas());
        return "atas/listar";
    }

    @GetMapping("/nova")
    public String novaAta(Model model) {
        model.addAttribute("ata", new Ata());
        return "atas/form";
    }

    @PostMapping
    public String salvarAta(@ModelAttribute Ata ata) {
        ataService.salvarAta(ata);
        return "redirect:/atas";
    }

    @GetMapping("/editar/{id}")
    public String editarAta(@PathVariable Long id, Model model) {
        model.addAttribute("ata", ataService.buscarPorId(id));
        return "atas/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAta(@PathVariable Long id) {
        ataService.deletarAta(id);
        return "redirect:/atas";
    }
    
    @GetMapping("/buscar")
    public String buscarAtas(
        @RequestParam(value = "titulo", required = false) String titulo,
        @RequestParam(value = "dataEmissao", required = false) String dataEmissaoStr,
        @RequestParam(value = "palavraChave", required = false) String palavraChave,
        Model model) {

        LocalDate dataEmissao = null;

        if (dataEmissaoStr != null && !dataEmissaoStr.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dataEmissao = LocalDate.parse(dataEmissaoStr, formatter);
        }

        List<Ata> atas = ataService.buscarAtas(titulo, dataEmissao, palavraChave);
        System.out.println(atas.toString());
        model.addAttribute("atas", atas);
        return "atas/listar";
    }
}
