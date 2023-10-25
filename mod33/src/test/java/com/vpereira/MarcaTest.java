package com.vpereira;

import com.vpereira.dao.IMarcaDao;
import com.vpereira.dao.MarcaDao;
import com.vpereira.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MarcaTest {

    private IMarcaDao marcaDao;

    public MarcaTest(){
        marcaDao = new MarcaDao();
    }

    @Test
    public void cadastrar(){
        Marca marca = new Marca("A1", "Ford");
        marca = marcaDao.cadastrar(marca);
        assertNotNull(marca);
    }
}
