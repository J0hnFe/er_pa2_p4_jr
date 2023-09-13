package com.example.er_pa2_p4_jr.repo.modelo;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @Column(name = "mate_id")
    private Integer id;
    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_codigo")
    private String codigo;
    @Column(name = "mate_creditos")
    private String creditos;
    @Column(name = "mate_descripcion")
    private String descripcion;
    @Column(name = "mate_numero_estudiantes")
    private Integer nEstudiantes;

    //Relaciones
    @OneToMany(mappedBy = "materia")
    private List<Matricula> matriculas;
}
