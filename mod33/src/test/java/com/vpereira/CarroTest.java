package com.vpereira;

import com.vpereira.dao.CarroDao;
import com.vpereira.dao.ICarroDao;
import com.vpereira.dao.IMarcaDao;
import com.vpereira.dao.MarcaDao;
import com.vpereira.domain.Carro;
import com.vpereira.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarroTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;

    public CarroTest(){
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
    }

    @Test
    public void cadastrar(){
        Marca marca = new Marca("A1", "Ford");
        marca = marcaDao.cadastrar(marca);

        Carro carro = new Carro("A1", "HB20", 2018, marca);
        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertEquals(carro.getCodigo(), "A1");
    }
}
