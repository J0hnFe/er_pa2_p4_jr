package com.example.er_pa2_p4_jr.repo.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "matricula")
public class Matricula {

    @Id
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
    @GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
    @Column(name = "matr_id")
    private Integer id;
    @Column(name = "matr_fecha")
    private String fecha;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "matr_id_materia")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "matr_id_estudiante")
    private Estudiante estudiante;
}
