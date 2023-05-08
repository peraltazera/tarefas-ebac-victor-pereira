package br.com.vpereira.cadastro;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCarros<T> {

    List<T> carros;

    public ListaDeCarros() {
        this.carros = new ArrayList<T>();
    }

    public void addCarro(T dado) {
        this.carros.add(dado);
    }

    public void listarCarros() {
        System.out.println(carros);
    }
}
