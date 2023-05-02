package br.com.vpereira;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Victor");
		pf.setCpf(123456789);
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome("Victor´s");
		pj.setCnpj(987654321);
		System.out.println(pf);
		System.out.println(pj);
	}

}
