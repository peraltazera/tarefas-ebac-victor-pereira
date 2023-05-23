package main.java.br.com.vpereira.services;

import main.java.br.com.vpereira.domain.Cliente;
import main.java.br.com.vpereira.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
