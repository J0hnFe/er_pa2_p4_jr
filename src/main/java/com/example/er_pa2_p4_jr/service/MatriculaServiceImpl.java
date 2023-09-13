package com.example.er_pa2_p4_jr.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.er_pa2_p4_jr.repo.IEstudianteRepo;
import com.example.er_pa2_p4_jr.repo.IMateriaRepo;
import com.example.er_pa2_p4_jr.repo.IMatriculaRepo;
import com.example.er_pa2_p4_jr.repo.modelo.Estudiante;
import com.example.er_pa2_p4_jr.repo.modelo.Materia;
import com.example.er_pa2_p4_jr.repo.modelo.Matricula;
import com.example.er_pa2_p4_jr.repo.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

    @Autowired
    private IMatriculaRepo matriculaRepo;
    @Autowired
    private IMateriaRepo materiaRepo;
    @Autowired
    private IEstudianteRepo estudianteRepo;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void guardar(String cedula, String codigoMateria) {
        Estudiante estudianteAux = this.estudianteRepo.encontrarPorCedula(cedula);
        Materia materiaAux = this.materiaRepo.encontrarPorCodigo(codigoMateria);
        String fecha = LocalDate.now().toString();
        materiaAux.setNEstudiantes(materiaAux.getNEstudiantes()+1);
        Matricula matricula = Matricula.builder()
                .estudiante(estudianteAux)
                .materia(materiaAux)
                .fecha(fecha)
                .build();
        this.materiaRepo.actualizar(materiaAux);
        this.matriculaRepo.insertar(matricula);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<MatriculaDTO> buscarListaDto() {
        return this.matriculaRepo.encontrarListaDto();
    }
    
}
