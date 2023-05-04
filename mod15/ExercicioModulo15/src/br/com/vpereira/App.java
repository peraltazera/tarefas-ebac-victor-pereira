package br.com.vpereira;

public class App {

	public static void main(String[] args) {
		
		Fabricante volkswagen = new Volkswagen();
		
		Carro carro = volkswagen.criarCarro(volkswagen.getModelos()[1], 1965);
		System.out.println(carro.getMarca());
		System.out.println(carro.getModelo());
		System.out.println(carro.getAno());
		carro.ligar();
		carro.abastecer();
		carro.limpar();
		
		System.out.println("");
		
		Fabricante hyundai = new Hyundai();
		
		Carro carro2 = hyundai.criarCarro(hyundai.getModelos()[0], 2001);
		System.out.println(carro2.getMarca());
		System.out.println(carro2.getModelo());
		System.out.println(carro2.getAno());
		carro2.ligar();
		carro2.abastecer();
		carro2.limpar();
	}
}
