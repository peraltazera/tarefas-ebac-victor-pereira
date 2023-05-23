package br.com.vpereira.dao;

import java.util.Collection;

import main.java.br.com.vpereira.dao.IClienteDAO;
import main.java.br.com.vpereira.domain.Cliente;
import main.java.br.com.vpereira.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		return true;
	}

	@Override
	public void excluir(Long valor) {

	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return null;
	}


}
