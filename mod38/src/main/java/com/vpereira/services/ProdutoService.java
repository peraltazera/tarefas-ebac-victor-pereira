package com.vpereira.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.vpereira.dao.IProdutoDAO;
import com.vpereira.domain.Produto;
import com.vpereira.services.generic.GenericService;

@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
