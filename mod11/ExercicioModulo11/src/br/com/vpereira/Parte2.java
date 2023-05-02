package br.com.vpereira;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parte2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Digite varios nomes-sexo separados por (,) e sem espaços, Ex (Victor-m,Leonardo-m,Cecilia-f,Amanda-f) :");
		Scanner s = new Scanner(System.in);
		List<String> nomes = Arrays.asList(s.next().split(","));
		System.out.println(""); 
		System.out.println("Homens:"); 
		for(String nome : nomes) {
			if(nome.split("-")[1].equals("m"))
			{
				System.out.println(nome.split("-")[0]); 
			}
		}
		System.out.println(""); 
		System.out.println("Mulheres:"); 
		for(String nome : nomes) {
			if(nome.split("-")[1].equals("f"))
			{
				System.out.println(nome.split("-")[0]); 
			}
		}
	}

}
