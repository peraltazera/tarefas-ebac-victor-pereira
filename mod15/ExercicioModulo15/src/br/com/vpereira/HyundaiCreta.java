package br.com.vpereira;

public class HyundaiCreta extends Carro {
	
	private static String marca = "Hyundai";
	private static String modelo = "Creta";

	public HyundaiCreta(int ano) {
		super(marca, modelo, ano);
	}

	@Override
	public void ligar() {
		System.out.println("Clique no botão ao lado do volate com a chave na engrenagem.");
	}

	@Override
	public void abastecer() {
		System.out.println("Recaregar energia.");
	}
	
}
