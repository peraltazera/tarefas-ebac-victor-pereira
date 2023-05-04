package br.com.vpereira.dao;

import java.util.Collection;

import br.com.vpereira.domain.Cliente;

public interface IClienteDAO {
	
	public boolean cadastrar(Cliente cliente);
	public boolean excluir(Long cpf);
	public boolean alterar(Cliente cliente);
	public Cliente consultar(Long cpf);
	public Collection<Cliente> buscarTodos();
}
