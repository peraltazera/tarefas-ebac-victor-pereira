package br.com.vpereira;

public class HyundaiTucson extends Carro {
	
	private static String marca = "Hyundai";
	private static String modelo = "Tucson";
	
	public HyundaiTucson(int ano) {
		super(marca, modelo, ano);
	}

	@Override
	public void ligar() {
		System.out.println("Clique no botão ao lado do volate.");
	}

	@Override
	public void abastecer() {
		System.out.println("Recaregar energia.");
	}
	
}
