package br.com.vpereira;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrupoPessoas {

    List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public GrupoPessoas() {

    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Pessoa> getHomens() {
        return getPessoas().stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("M"))
                .collect(Collectors.toList());
    }

    public List<Pessoa> getMulheres() {
        return getPessoas().stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());
    }

    public void stringParaPessoas(String str){
        List<String> listStr = Arrays.asList(str.split(","));
        listStr.forEach(pessoa -> {
            String[] result = pessoa.split("-");
            getPessoas().add(new Pessoa(result[0], result[1]));
        });
    }

}
