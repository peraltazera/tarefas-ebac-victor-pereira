package com.vpereira;

import com.vpereira.dao.CursoDao;
import com.vpereira.dao.ICursoDao;
import com.vpereira.domain.Curso;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest(){
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar(){
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso Teste");
        curso.setNome("Curso Teste");
        curso = cursoDao.cadastrar(curso);
        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}
