package main.java.br.com.vpereira.services;

import main.java.br.com.vpereira.dao.IProdutoDAO;
import main.java.br.com.vpereira.domain.Produto;
import main.java.br.com.vpereira.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
