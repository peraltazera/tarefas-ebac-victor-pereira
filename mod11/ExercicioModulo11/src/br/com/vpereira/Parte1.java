package br.com.vpereira;

import java.util.Scanner;
import java.util.*;

public class Parte1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Digite varios nomes separados por (,) e sem espaços, Ex (Victor,Leonardo,Cecilia,Amanda) :");
		Scanner s = new Scanner(System.in);
		List<String> nomes = Arrays.asList(s.next().split(","));
		Collections.sort(nomes);
		System.out.println(""); 
		System.out.println("Nomes em ordem alfabetica:"); 
		for(String nome : nomes) {
			System.out.println(nome); 
		}
	}

}
