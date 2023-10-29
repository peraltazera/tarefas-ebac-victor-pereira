package com.vpereira.dao;

import com.vpereira.dao.generic.jpa.GenericJpaDB1DAO;
import com.vpereira.dao.jpa.IVendaJpaDAO;
import com.vpereira.domain.jpa.VendaJpa;
import com.vpereira.exceptions.DAOException;
import com.vpereira.exceptions.TipoChaveNaoEncontradaException;

//Classe utilizada somente no teste para fazer a exclusão das vendas
public class VendaExclusaoJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
