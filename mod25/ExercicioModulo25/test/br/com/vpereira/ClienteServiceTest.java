package br.com.vpereira;

import br.com.vpereira.dao.ClienteDaoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.vpereira.dao.IClienteDAO;
import main.java.br.com.vpereira.domain.Cliente;
import main.java.br.com.vpereira.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.vpereira.services.ClienteService;
import main.java.br.com.vpereira.services.IClienteService;

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
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Rodrigo Pires");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Rodrigo Pires", cliente.getNome());
	}
}
