package com.example.er_pa2_p4_jr.service;

import java.util.List;

import com.example.er_pa2_p4_jr.repo.modelo.dto.MatriculaDTO;

public interface IMatriculaService {
    public void guardar(String cedula, String codigoMateria);
    public List<MatriculaDTO> buscarListaDto();
}
