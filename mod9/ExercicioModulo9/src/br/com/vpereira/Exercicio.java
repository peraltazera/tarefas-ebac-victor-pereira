package br.com.vpereira;

import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {
		System.out.println("Digite um numero:");
		Scanner s = new Scanner(System.in);
		int numero1 = s.nextInt();
		System.out.println("Variavel Primitiva: " + numero1);
		Integer numero2 = numero1;
		System.out.println("Variavel Wrapper: " + numero2);
	}

}
