package br.com.vpereira;

import java.util.Scanner;

public class ExercicioMediaNota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a Nota 1:");
		double nota1 = s.nextInt();
		System.out.println("Digite a Nota 2:");
		double nota2 = s.nextInt();
		System.out.println("Digite a Nota 3:");
		double nota3 = s.nextInt();
		System.out.println("Digite a Nota 4:");
		double nota4 = s.nextInt();
		double media = (nota1 + nota2 + nota3 + nota4) / 4;
		System.out.println("Sua media foi " + media);
		if(media >= 7) {
			System.out.println("você está aprovado!");
		}else if(media >= 5) {
			System.out.println("você está de recuperação!");
		}else {
			System.out.println("você está reprovado!");
		}
	}

}
