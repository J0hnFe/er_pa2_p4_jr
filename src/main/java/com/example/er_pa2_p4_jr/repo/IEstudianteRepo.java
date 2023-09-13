package com.example.er_pa2_p4_jr.repo;

import com.example.er_pa2_p4_jr.repo.modelo.Estudiante;

public interface IEstudianteRepo {

    public void insertar(Estudiante e);
    public Estudiante encontrarPorCedula(String cedula);
}
