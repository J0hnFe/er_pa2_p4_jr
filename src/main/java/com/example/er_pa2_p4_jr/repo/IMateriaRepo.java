package com.example.er_pa2_p4_jr.repo;

import java.util.List;

import com.example.er_pa2_p4_jr.repo.modelo.Materia;

public interface IMateriaRepo {
    
    public void insertar(Materia materia);
    public List<Materia> encontrarTodos();
    public List<Materia> encontrarPorId(Integer id);
    public Materia encontrarPorCodigo(String codigo);
    public void actualizar(Materia materia);
}
