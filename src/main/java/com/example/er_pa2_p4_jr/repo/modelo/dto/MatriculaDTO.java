package com.example.er_pa2_p4_jr.repo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MatriculaDTO {

    private String cedula;
    private String apellido;
    private String nombre; //de la materia
    private String codigo; 
    private String fecha; //de la matricula

}
