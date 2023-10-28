package com.vpereira.services;

import com.vpereira.dao.IProdutoDAO;
import com.vpereira.domain.Produto;
import com.vpereira.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
