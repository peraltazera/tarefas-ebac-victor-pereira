package com.vpereira.dao.jpa;

import com.vpereira.dao.generic.jpa.GenericJpaDAO;
import com.vpereira.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
