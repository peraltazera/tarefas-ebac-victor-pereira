package com.vpereira.dao.jpa;

import com.vpereira.dao.generic.jpa.GenericJpaDAO;
import com.vpereira.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
