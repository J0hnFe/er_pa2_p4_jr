package com.example.er_pa2_p4_jr.service;

import java.util.List;

import com.example.er_pa2_p4_jr.repo.modelo.Materia;

public interface IMateriaService {

    public void guardar(Materia materia);
    public List<Materia> buscarTodos();
    public List<Materia> buscarPorId(Integer id);
    public Materia buscarPorCodigo(String codigo);
}
