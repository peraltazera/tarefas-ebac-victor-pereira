package br.com.vpereira;

import java.util.Arrays;

import javax.swing.*;

import br.com.vpereira.dao.ClienteMapDao;
import br.com.vpereira.dao.IClienteDAO;
import br.com.vpereira.domain.Cliente;

public class App {
	
	private static IClienteDAO iClienteDAO;

	public static void main(String[] args) 
	{
		System.out.println("null");
		iClienteDAO = new ClienteMapDao();
		String opcao = JOptionPane.showInputDialog(
				null,
				"Digite um numero: 1-Cadastrar / 2-Alterar / 3-Pesquisar / 4-Listar / 5-Excluir / 6-Sair","Menu",
				JOptionPane.INFORMATION_MESSAGE
				);
		while(!sair(opcao)) 
		{
			if(verificarNumero(opcao)) 
			{
				if(opcao.equals("1")) 
				{
					System.out.println(args);
					String resposta = JOptionPane.showInputDialog(
							null, 
							"Escreve as seguintes informações separadas por (,) Ex: nome,cpf,telefone,endereco,numero,cidade,estado",
							"Cadastrar", 
							JOptionPane.INFORMATION_MESSAGE
							);
					cadastrar(resposta);
				}
				else if(opcao.equals("2")) 
				{
					String resposta = JOptionPane.showInputDialog(
							null, 
							"Escreve cpf do cliente",
							"Alterar", JOptionPane.INFORMATION_MESSAGE
							);
					alterar(resposta);
				}
				else if(opcao.equals("3")) 
				{
					String resposta = JOptionPane.showInputDialog(
							null, 
							"Escreve cpf do cliente",
							"Pesquisar", 
							JOptionPane.INFORMATION_MESSAGE
							);
					pesquisar(resposta);
				}
				else if(opcao.equals("4")) 
				{
					listarClientes();
				}
				else if(opcao.equals("5")) 
				{
					String resposta = JOptionPane.showInputDialog(
							null, 
							"Escreve cpf do cliente",
							"Excluir", JOptionPane.INFORMATION_MESSAGE
							);
					excluir(resposta);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Escreve um numero de 1 a 6","Aviso", 0);
			}
			opcao = JOptionPane.showInputDialog(
					null,
					"Digite um numero: 1-Cadastrar / 2-Alterar / 3-Pesquisar / 4-Listar / 5-Excluir / 6-Sair",
					"Menu",
					JOptionPane.INFORMATION_MESSAGE
					);
		}
		
		JOptionPane.showMessageDialog(null, "Sair","Sair", 0);
		System.exit(0);
	}
	
	private static void excluir(String resposta) 
	{
		try
		{
			boolean excluir = iClienteDAO.excluir(Long.parseLong(resposta));
			if(excluir)
			{
				JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso","Excluir", 0);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Não existe nenhum cliente com esse cpf","Excluir", 0);
			}
		}
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(null, "Cliente não encontrado: Informações erradas","Pesquisar", 0);
		}
	}

	private static void listarClientes() 
	{
		if(iClienteDAO.buscarTodos().size() > 0) 
		{
			JOptionPane.showMessageDialog(null, iClienteDAO.buscarTodos(),"Listar", JOptionPane.INFORMATION_MESSAGE);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Não existe nenhum cliente cadastrado","Listar", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void pesquisar(String resposta) 
	{
		try
		{
			Cliente cliente = iClienteDAO.consultar(Long.parseLong(resposta));
			if(cliente != null)
			{
				JOptionPane.showMessageDialog(null, cliente,"Pesquisar", JOptionPane.INFORMATION_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Não existe nenhum cliente com esse cpf","Pesquisar", 0);
			}
		}
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(null, "Cliente não encontrado: Informações erradas","Pesquisar", 0);
		}
	}

	private static void alterar(String resposta) 
	{
		try 
		{
			Cliente cliente = iClienteDAO.consultar(Long.parseLong(resposta));
			if(cliente != null)
			{
				String resposta2 = JOptionPane.showInputDialog(
						null, 
						"Escreve as seguintes informações separadas por (,) Ex: nome,cpf,telefone,endereco,numero,cidade,estado", 
						cliente.getNome()+","+
						cliente.getCpf()+","+
						cliente.getTelefone()+","+
						cliente.getEndereco()+","+
						cliente.getNumero()+","+
						cliente.getCidade()+","+
						cliente.getEstado()
						);
				String[] infosCliente = resposta2.split(",");
			
				if(infosCliente.length == 7)
				{
					    Cliente clienteAlterado = new Cliente(infosCliente[0],Long.parseLong(infosCliente[1]),Long.parseLong(infosCliente[2]),infosCliente[3],Integer.parseInt(infosCliente[4]),infosCliente[5],infosCliente[6]);
						boolean cadastro = iClienteDAO.alterar(clienteAlterado);
						if(cadastro) 
						{
							JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso","Alterar", 0);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "Não existe nenhum cliente com esse cpf","Alterar", 0);
						}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado: Informações incompletas","Cadastrar", 0);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Não existe nenhum cliente com esse cpf","Pesquisar", 0);
			}
		}
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(null, "Cliente não alterado: Informações erradas","Alterar", 0);
		}
	}

	private static void cadastrar(String resposta) 
	{
		try 
		{
			String[] infosCliente = resposta.split(",");
			if(infosCliente.length == 7)
			{
				Cliente cliente = new Cliente(infosCliente[0],Long.parseLong(infosCliente[1]),Long.parseLong(infosCliente[2]),infosCliente[3],Integer.parseInt(infosCliente[4]),infosCliente[5],infosCliente[6]);
				boolean cadastro = iClienteDAO.cadastrar(cliente);
				if(cadastro) 
				{
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso","Cadastrar", JOptionPane.INFORMATION_MESSAGE);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Cliente ja estava cadastrado","Cadastrar", JOptionPane.INFORMATION_MESSAGE);
				}
			} 
			else
			{
				JOptionPane.showMessageDialog(null, "Cliente não cadastrado: Informações incompletas","Cadastrar", 0);
			}
		}
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(null, "Cliente não cadastrado: Informações erradas","Cadastrar", 0);
		}
	}

	public static boolean sair (String opcao) 
	{
		if(opcao != null) 
		{
			if(opcao.equals("6"))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean verificarNumero(String opcao) 
	{
		String[] opcoes = {"1","2","3","4","5"};
		if(Arrays.asList(opcoes).contains(opcao))
		{
			return true;
		}
		return false;
	}

}
