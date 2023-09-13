package com.example.er_pa2_p4_jr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.er_pa2_p4_jr.repo.IMateriaRepo;
import com.example.er_pa2_p4_jr.repo.modelo.Materia;

import jakarta.transaction.Transactional;

@Service
public class MateriaServiceImpl implements IMateriaService{
    
    @Autowired
    private IMateriaRepo materiaRepo;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void guardar(Materia materia) {
        this.materiaRepo.insertar(materia);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<Materia> buscarTodos() {
        return this.materiaRepo.encontrarTodos();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<Materia> buscarPorId(Integer id) {
        return this.materiaRepo.encontrarPorId(id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Materia buscarPorCodigo(String codigo) {
        return this.materiaRepo.encontrarPorCodigo(codigo);
    }

}
