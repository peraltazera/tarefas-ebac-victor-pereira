package com.vpereira;

import com.vpereira.dao.*;
import com.vpereira.domain.Acessorio;
import com.vpereira.domain.Carro;
import com.vpereira.domain.Marca;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AcessorioTest {

    private IAcessorioDao acessorioDao;
    private ICarroDao carroDao;
    private IMarcaDao marcaDao;

    public AcessorioTest(){
        acessorioDao = new AcessorioDao();
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
    }

    @Test
    public void cadastrar(){
        Marca marca = new Marca("A1", "Ford");
        marca = marcaDao.cadastrar(marca);

        Carro carro = new Carro("A2", "HB20", 2018, marca);
        carro = carroDao.cadastrar(carro);

        List<Acessorio> acessorios = new ArrayList<>();

        acessorios.add(new Acessorio("A3", "Volante", 200D, carro));
        acessorios.add(new Acessorio("A4", "Rodas", 500D, carro));

        List<Acessorio> acessoriosCadastrados = new ArrayList<>();

        for (Acessorio acessorio : acessorios){
            acessoriosCadastrados.add(acessorioDao.cadastrar(acessorio));
        }

        for (int i = 1; i < acessoriosCadastrados.size(); i++){
            assertNotNull(acessoriosCadastrados.get(i));
            assertEquals(acessoriosCadastrados.get(i).getCodigo(), acessorios.get(i).getCodigo());
        }
    }
}
