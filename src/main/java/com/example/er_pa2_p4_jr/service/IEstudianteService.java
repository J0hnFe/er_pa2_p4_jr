package com.example.er_pa2_p4_jr.service;

import com.example.er_pa2_p4_jr.repo.modelo.Estudiante;

public interface IEstudianteService {

    public void guardar(Estudiante e);
    public Estudiante buscarPorCedula(String cedula);
}
