package com.vpereira.services;

import java.util.List;

import com.vpereira.domain.Cliente;
import com.vpereira.exceptions.DAOException;
import com.vpereira.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
