package com.vpereira.dao;

import com.vpereira.dao.generic.IGenericDAO;
import com.vpereira.domain.Venda;
import com.vpereira.exceptions.DAOException;
import com.vpereira.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
