package br.com.vpereira;

import br.com.vpereira.cadastro.ListaDeCarros;
import br.com.vpereira.carros.Volkswagen;
import br.com.vpereira.carros.Hyundai;
import br.com.vpereira.carros.Carro;

public class Main {

    public static void main(String[] args) {
        ListaDeCarros<Carro> carros = new ListaDeCarros<Carro>();
        carros.addCarro(new Volkswagen("Volkswagen","Jett"));
        carros.addCarro(new Volkswagen("Volkswagen","Teste"));
        carros.addCarro(new Hyundai("Hyundai","Jett"));
        carros.addCarro(new Hyundai("Hyundai","Teste"));
        carros.listarCarros();
    }
}