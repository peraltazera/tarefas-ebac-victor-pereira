package br.com.vpereira;

public class VolkswagenJetta extends Carro {
	
	private static String marca = "Volkswagen";
	private static String modelo = "Jetta";

	public VolkswagenJetta(int ano) {
		super(marca, modelo, ano);
	}

	@Override
	public void ligar() {
		System.out.println("Clique no botão ao lado do volate.");
	}

	@Override
	public void abastecer() {
		System.out.println("Coloca gasolina.");
	}

}
