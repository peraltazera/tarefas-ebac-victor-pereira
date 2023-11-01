package com.vpereira.services;

import java.util.List;

import com.vpereira.domain.Produto;
import com.vpereira.services.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
