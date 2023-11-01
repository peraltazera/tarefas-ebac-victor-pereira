package com.vpereira.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.vpereira.dao.IClienteDAO;
import com.vpereira.domain.Cliente;
import com.vpereira.exceptions.DAOException;
import com.vpereira.exceptions.MaisDeUmRegistroException;
import com.vpereira.exceptions.TableException;
import com.vpereira.services.generic.GenericService;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
