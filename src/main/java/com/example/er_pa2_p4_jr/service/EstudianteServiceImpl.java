package com.example.er_pa2_p4_jr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.er_pa2_p4_jr.repo.IEstudianteRepo;
import com.example.er_pa2_p4_jr.repo.modelo.Estudiante;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepo estudianteRepo;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void guardar(Estudiante e) {
        this.estudianteRepo.insertar(e);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Estudiante buscarPorCedula(String cedula) {
        return this.estudianteRepo.encontrarPorCedula(cedula);
    }
    
}
