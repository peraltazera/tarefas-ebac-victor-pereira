package com.vpereira.dao;

import com.vpereira.domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MatriculaDao implements IMatriculaDao{

    @Override
    public Matricula cadastrar(Matricula matricula) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ((EntityManager) entityManager).getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }
}
