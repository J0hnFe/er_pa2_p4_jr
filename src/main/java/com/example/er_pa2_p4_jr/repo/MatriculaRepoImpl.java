package com.example.er_pa2_p4_jr.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.er_pa2_p4_jr.repo.modelo.Matricula;
import com.example.er_pa2_p4_jr.repo.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public void insertar(Matricula m) {
        this.em.persist(m);
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<MatriculaDTO> encontrarListaDto() {
        String jpql = "SELECT new com.example.er_pa2_p4_jr.repo.modelo.dto.MatriculaDTO(m.estudiante.cedula , m.estudiante.apellido, m.materia.nombre, m.materia.codigo, m.fecha) FROM Matricula m";
        TypedQuery<MatriculaDTO> query = this.em.createQuery(jpql, MatriculaDTO.class);
        return query.getResultList();
    }
    
}
