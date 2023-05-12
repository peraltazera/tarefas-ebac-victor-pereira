package br.com.vpereira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
            System.out.println("Escreva uma lista de Nome-Sexo separado por ',' Ex: Victor-M,Cecilia-F,Leo-M,Bianca-F");
            Scanner s = new Scanner(System.in);
            List<String> res = Arrays.asList(s.next().split("\\s*,\\s*"));
            System.out.println("****** Pessoas ******");
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            res.forEach(str -> {
                String[] result = str.split("\\s*-\\s*");
                pessoas.add(new Pessoa(result[0], result[1]));
            });
            System.out.println(pessoas.toString());
            System.out.println("****** Homens ******");
            List<Pessoa> homens = pessoas.stream().filter(p -> p.getSexo().equalsIgnoreCase("M")).collect(Collectors.toList());
            System.out.println(homens.toString());
            System.out.println("****** Mulheres ******");
            List<Pessoa> mulheres = pessoas.stream().filter(p -> p.getSexo().equalsIgnoreCase("F")).collect(Collectors.toList());
            System.out.println(mulheres.toString());
    }
}