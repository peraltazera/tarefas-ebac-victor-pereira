package br.com.vpereira;

public class Volkswagen extends Fabricante {
	
	private static String marca = "Volkswagen";
	private static String[] modelos = {"Jetta", "Polo"};
	
	public Volkswagen() {
		super(marca, modelos);
	}

	@Override
	public Carro criarCarro(String modelo, int ano) {
		if(modelo.equals(modelos[0]))
		{
			return new VolkswagenJetta(ano);
		}else if (modelo.equals(modelos[1])) {
			return new VolkswagenPolo(ano);
		}
		return null;
	}
	
}
