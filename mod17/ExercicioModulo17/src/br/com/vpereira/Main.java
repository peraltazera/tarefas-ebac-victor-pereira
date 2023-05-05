package br.com.vpereira;

import br.com.vpereira.cadastro.ListaDeDados;
import br.com.vpereira.carros.Volkswagen;
import br.com.vpereira.carros.Hyundai;

public class Main {

    public static void main(String[] args) {
        ListaDeDados<Volkswagen> cadastroVolkswagen = new ListaDeDados<Volkswagen>();
        cadastroVolkswagen.addDado(new Volkswagen("Volkswagen","Jett"));
        cadastroVolkswagen.addDado(new Volkswagen("Volkswagen","Teste"));
        cadastroVolkswagen.printDados();

        ListaDeDados<Hyundai> cadastroHyundai = new ListaDeDados<Hyundai>();
        cadastroHyundai.addDado(new Hyundai("Hyundai","Jett"));
        cadastroHyundai.addDado(new Hyundai("Hyundai","Teste"));
        cadastroHyundai.printDados();

        ListaDeDados<String> Nomes = new ListaDeDados<String>();
        Nomes.addDado("Victor");
        Nomes.addDado("Leonardo");
        Nomes.printDados();
    }
}