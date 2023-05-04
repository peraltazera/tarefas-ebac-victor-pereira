package br.com.vpereira;

public class VolkswagenPolo extends Carro {
	
	private static String marca = "Volkswagen";
	private static String modelo = "Polo";

	public VolkswagenPolo(int ano) {
		super(marca, modelo, ano);
	}

	@Override
	public void ligar() {
		System.out.println("Gira a chave.");
	}

	@Override
	public void abastecer() {
		System.out.println("Coloca disel.");
	}

}
