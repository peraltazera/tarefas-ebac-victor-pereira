package br.com.vpereira;

public class Hyundai extends Fabricante {
	
	private static String marca = "Hyundai";
	private static String[] modelos = {"Creta", "Tucson"};
	
	public Hyundai() {
		super(marca, modelos);
	}

	@Override
	public Carro criarCarro(String modelo, int ano) {
		if(modelo.equals(modelos[0]))
		{
			return new HyundaiCreta(ano);
		}else if (modelo.equals(modelos[1])) {
			return new HyundaiTucson(ano);
		}
		return null;
	}

}
