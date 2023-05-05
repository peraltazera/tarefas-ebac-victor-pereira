package br.com.vpereira.cadastro;

import java.util.ArrayList;
import java.util.List;

public class ListaDeDados<T> {

    List<T> dados;

    public ListaDeDados() {
        this.dados = new ArrayList<T>();
    }

    public List<T> getDados() {
        return dados;
    }

    public void addDado(T dado) {
        this.dados.add(dado);
    }

    public void printDados() {
        System.out.println(dados);
    }
}
