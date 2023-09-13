package com.example.er_pa2_p4_jr.repo;

import org.springframework.stereotype.Repository;

import com.example.er_pa2_p4_jr.repo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public void insertar(Estudiante e) {
        this.em.persist(e);
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Estudiante encontrarPorCedula(String cedula) {
        String jpql = "SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula";
        TypedQuery<Estudiante> query = this.em.createQuery(jpql, Estudiante.class);
        query.setParameter("datoCedula", cedula);
        return query.getSingleResult();
    }
    
}
