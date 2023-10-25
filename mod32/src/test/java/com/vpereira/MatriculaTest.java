package com.vpereira;

import com.vpereira.dao.IMatriculaDao;
import com.vpereira.dao.MatriculaDao;
import com.vpereira.domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    public MatriculaTest(){
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void cadastrar(){
        Matricula matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(200D);
        matricula = matriculaDao.cadastrar(matricula);
        assertNotNull(matricula);
        assertNotNull(matricula.getId());
    }
}
