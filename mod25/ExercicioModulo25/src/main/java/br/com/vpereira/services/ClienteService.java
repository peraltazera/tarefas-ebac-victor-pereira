package main.java.br.com.vpereira.services;

import main.java.br.com.vpereira.dao.IClienteDAO;
import main.java.br.com.vpereira.domain.Cliente;
import main.java.br.com.vpereira.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.vpereira.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}

}
