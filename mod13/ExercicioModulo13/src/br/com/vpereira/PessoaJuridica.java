package br.com.vpereira;

public class PessoaJuridica extends Pessoa {
	
	private long cnpj;

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Pessoa Juridica [nome = " + super.getNome() + "] [cnpj = " + cnpj + "]";
	}
	
}

