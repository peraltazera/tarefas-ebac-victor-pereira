package main.java.br.com.vpereira.dao;

import main.java.br.com.vpereira.dao.generic.IGenericDAO;
import main.java.br.com.vpereira.domain.Venda;
import main.java.br.com.vpereira.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
