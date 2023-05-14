package br.com.vpereira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
            //System.out.println("Escreva uma lista de Nome-Sexo separado por ',' Ex: Victor-M,Cecilia-F,Leo-M,Bianca-F");
            //Scanner s = new Scanner(System.in);
            //<String> res = Arrays.asList(s.next().split(","));
            //System.out.println(res);
            //System.out.println("****** Pessoas ******");
            //List<Pessoa> pessoas = new ArrayList<Pessoa>();
            //res.forEach(str -> {
                //String[] result = str.split("-");
                //pessoas.add(new Pessoa(result[0], result[1]));
            //});
            //System.out.println(pessoas.toString());
            //System.out.println("****** Homens ******");
            //List<Pessoa> homens2 = pessoas.stream().map(p -> new Pessoa(p.getNome(), p.getSexo().equalsIgnoreCase("M") ? "Masculino" : "Feminino")).collect(Collectors.toList());
            //List<Pessoa> homens = pessoas.stream().filter(p -> p.getSexo().equalsIgnoreCase("M")).map(p -> new Pessoa(p.getNome() + " Hetero Top", p.getSexo())).collect(Collectors.toList());
            //System.out.println(homens2.toString());
            //System.out.println("****** Mulheres ******");
            //List<Pessoa> mulheres = pessoas.stream().filter(p -> p.getSexo().equalsIgnoreCase("F")).collect(Collectors.toList());
            //System.out.println(mulheres.toString());

            System.out.println("Escreva uma lista de Nome-Sexo separado por ',' Ex: Victor-M,Cecilia-F,Leo-M,Bianca-F");
            Scanner s = new Scanner(System.in);
            GrupoPessoas pessoas = new GrupoPessoas();
            pessoas.stringParaPessoas(s.next());
            System.out.println("****** Pessoas ******");
            System.out.println(pessoas.getPessoas());
            System.out.println("****** Homens ******");
            System.out.println(pessoas.getHomens().toString());
            System.out.println("****** Mulheres ******");
            System.out.println(pessoas.getMulheres().toString());
    }
}