package com.vpereira.dao;

import java.util.List;

import com.vpereira.dao.generic.IGenericDAO;
import com.vpereira.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}
