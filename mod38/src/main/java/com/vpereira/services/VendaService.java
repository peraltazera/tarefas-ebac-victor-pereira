package com.vpereira.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.vpereira.dao.IVendaDAO;
import com.vpereira.domain.Venda;
import com.vpereira.domain.Venda.Status;
import com.vpereira.exceptions.DAOException;
import com.vpereira.exceptions.TipoChaveNaoEncontradaException;
import com.vpereira.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

	IVendaDAO dao;
	
	@Inject
	public VendaService(IVendaDAO dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CONCLUIDA);
		dao.finalizarVenda(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CANCELADA);
		dao.cancelarVenda(venda);
	}

	@Override
	public Venda consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity.setStatus(Status.INICIADA);
		return super.cadastrar(entity);
	}
	
	

}
