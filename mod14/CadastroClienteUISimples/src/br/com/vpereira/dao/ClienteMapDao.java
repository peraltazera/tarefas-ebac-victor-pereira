package br.com.vpereira.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.vpereira.domain.Cliente;

public class ClienteMapDao implements  IClienteDAO{
	
	private Map<Long, Cliente> map;

	public ClienteMapDao() {
		this.map = new HashMap<>();
	}

	@Override
	public boolean cadastrar(Cliente cliente) {
		if(this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		this.map.put(cliente.getCpf(), cliente);
		return true;
	}

	@Override
	public boolean excluir(Long cpf) {
		if(this.map.containsKey(cpf)) {
			this.map.remove(cpf);
			return true;
		}
		return false;
	}

	@Override
	public boolean alterar(Cliente cliente) {
		Long cpf = cliente.getCpf();
		if(this.map.containsKey(cpf)) {
			Cliente novoCliente = this.map.get(cpf);
			novoCliente.setNome(cliente.getNome());	
			novoCliente.setTelefone(cliente.getTelefone());
			novoCliente.setEndereco(cliente.getEndereco());
			novoCliente.setNumero(cliente.getNumero());
			novoCliente.setCidade(cliente.getCidade());
			novoCliente.setEstado(cliente.getEstado());
			return true;
		}
		return false;
	}

	@Override
	public Cliente consultar(Long cpf) {
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return this.map.values();
	}

	

}
