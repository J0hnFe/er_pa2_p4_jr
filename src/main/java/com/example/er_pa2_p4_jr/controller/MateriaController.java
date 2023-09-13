package com.example.er_pa2_p4_jr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.er_pa2_p4_jr.repo.modelo.Materia;
import com.example.er_pa2_p4_jr.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
    
    @Autowired
    private IMateriaService materiaService;

    @GetMapping("/nuevaMateria")
    private String nuevaMateria(Materia materia){
        return "vistaNuevaMateria";
    }

    @PostMapping("/ingresarMateria")
    private String ingresarMateria(Materia materia){
        materia.setNEstudiantes(0);
        this.materiaService.guardar(materia);
        // return "vistaListaMaterias";
        return "redirect:/materias/listaMaterias";
    }

    @GetMapping("/listaMaterias")
    private String listaMaterias(Model model){

        List<Materia> materias = this.materiaService.buscarTodos();
        model.addAttribute("materias", materias);
        return "vistaListaMaterias";
    }

    @GetMapping("/visualizarIndividual/{idMateria}")
    private String visualizarIndividual(Model model, @PathVariable("idMateria")Integer id){
        List<Materia> materiaAux = this.materiaService.buscarPorId(id);
        System.out.println(id);
        model.addAttribute("materiaAux", materiaAux);
        return "vistaMateriaIndividual";

    }

}
