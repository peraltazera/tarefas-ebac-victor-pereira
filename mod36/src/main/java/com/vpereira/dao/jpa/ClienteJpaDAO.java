package com.vpereira.dao.jpa;

import com.vpereira.dao.generic.jpa.GenericJpaDB1DAO;
import com.vpereira.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
