package com.example.er_pa2_p4_jr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.er_pa2_p4_jr.repo.modelo.Estudiante;
import com.example.er_pa2_p4_jr.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
    
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/nuevoEstudiante")
    private String nuevoEstudiante(Estudiante estudiante){
        return "vistaNuevoEstudiante";
    }

    @PostMapping("/ingresarEstudiante")
    private String ingresarEstudiante(Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
        return "redirect:/estudiantes/nuevoEstudiante";
    }
}
