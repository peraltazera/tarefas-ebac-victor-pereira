package br.com.vpereira;

public class PessoaFisica extends Pessoa {
	
	private long cpf;

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa Fisica [nome = " + super.getNome() + "] [cpf = " + cpf + "]";
	}
}
