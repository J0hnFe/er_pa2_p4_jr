package com.example.er_pa2_p4_jr.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.er_pa2_p4_jr.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Materia> encontrarTodos() {
        String jpql = "SELECT m FROM Materia m";
        TypedQuery<Materia> query = this.entityManager.createQuery(jpql, Materia.class);
        return query.getResultList();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public List<Materia> encontrarPorId(Integer id){
        String jpql = "SELECT m FROM Materia m WHERE m.id = :datoId";
        TypedQuery<Materia> query = this.entityManager.createQuery(jpql, Materia.class);
        query.setParameter("datoId", id);
        return query.getResultList();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Materia encontrarPorCodigo(String codigo) {
        String jpql = "SELECT m FROM Materia m WHERE m.codigo = :datoCodigo";
        TypedQuery<Materia> query = this.entityManager.createQuery(jpql, Materia.class);
        query.setParameter("datoCodigo", codigo);
        return query.getSingleResult();
    }

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public void actualizar(Materia materia) {
        this.entityManager.merge(materia);
    }


}
