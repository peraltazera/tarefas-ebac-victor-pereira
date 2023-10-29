package com.vpereira.dao.jpa;

import com.vpereira.dao.generic.jpa.GenericJpaDB2DAO;
import com.vpereira.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
