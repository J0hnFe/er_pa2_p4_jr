package com.example.er_pa2_p4_jr.repo;

import java.util.List;

import com.example.er_pa2_p4_jr.repo.modelo.Matricula;
import com.example.er_pa2_p4_jr.repo.modelo.dto.MatriculaDTO;

public interface IMatriculaRepo {
    public void insertar(Matricula m);
    public List<MatriculaDTO> encontrarListaDto();
}
