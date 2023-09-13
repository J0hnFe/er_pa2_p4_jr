package com.example.er_pa2_p4_jr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.er_pa2_p4_jr.repo.modelo.Matricula;
import com.example.er_pa2_p4_jr.repo.modelo.dto.MatriculaDTO;
import com.example.er_pa2_p4_jr.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private IMatriculaService matriculaService;

    @GetMapping("/nuevaMatricula")
    private String nuevaMatricula(Matricula matricula){
        return "vistaNuevaMatricula";
    }

    @PostMapping("/ingresarMatricula")
    private String ingresarMatricula(Matricula matricula){
        String cedula = matricula.getEstudiante().getCedula();
        String codigo = matricula.getMateria().getCodigo();

        this.matriculaService.guardar(cedula, codigo);
        return "redirect:/matriculas/listaMatriculas";
    }

    @GetMapping("/listaMatriculas")
    private String listaMatriculas(Model model){
        List<MatriculaDTO> lista = this.matriculaService.buscarListaDto();
        model.addAttribute("lista", lista);
        return "vistaListaMatriculas";
    }
    
}
