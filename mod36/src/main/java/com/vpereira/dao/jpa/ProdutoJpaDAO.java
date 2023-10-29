package com.vpereira.dao.jpa;

import com.vpereira.dao.generic.jpa.GenericJpaDB1DAO;
import com.vpereira.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
