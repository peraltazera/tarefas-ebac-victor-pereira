package br.com.vpereira;

import br.com.vpereira.TabelaComAnnotation;
import br.com.vpereira.Tabela;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Class<?> tabelaComAnnotation = TabelaComAnnotation.class;
        Tabela annotations = tabelaComAnnotation.getAnnotation(Tabela.class);
        System.out.println(annotations.value());
        System.out.println(TabelaComAnnotation.class.getAnnotation(Tabela.class).value());
    }
}