package br.com.vpereira;

public abstract class Carro {
	
	private String marca;
	private String modelo;
	private int ano;
	
	public Carro(String marca, String modelo, int ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void limpar() {
		System.out.println("Limpar carro.");
	}
	
	public abstract void ligar();
	
	public abstract void abastecer();
}
