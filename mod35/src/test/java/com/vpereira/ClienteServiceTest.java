package com.vpereira;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vpereira.dao.ClienteDaoMock;
import com.vpereira.dao.IClienteDAO;
import com.vpereira.domain.Cliente;
import com.vpereira.exceptions.DAOException;
import com.vpereira.exceptions.TipoChaveNaoEncontradaException;
import com.vpereira.services.ClienteService;
import com.vpereira.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Victor");
		cliente.setCidade("Brasilia");
		cliente.setEnd("End");
		cliente.setEstado("DF");
		cliente.setNumero(27);
		cliente.setTel(5561978542563L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Victor Pereira");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Victor Pereira", cliente.getNome());
	}
}
