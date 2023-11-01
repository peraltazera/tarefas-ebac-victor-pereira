package com.vpereira.dao;

import java.util.List;

import com.vpereira.dao.generic.IGenericDAO;
import com.vpereira.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
