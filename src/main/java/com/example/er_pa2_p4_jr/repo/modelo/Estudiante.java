package com.example.er_pa2_p4_jr.repo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
    @GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
    @Column(name = "estu_id")
    private Integer id;
    @Column(name = "estu_nombre")
    private String nombre;
    @Column(name = "estu_apellido")
    private String apellido;
    @Column(name = "estu_cedula")
    private String cedula;
    @Column(name = "estu_fecha_nacimiento")
    private String fechaNacimiento;

    //Relaciones
    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    private List<Matricula> matriculas;
}
