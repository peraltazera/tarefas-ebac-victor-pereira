/**
 * 
 */
package br.com.vpereira;

/**
 * Classe de Produto
 * @author Victor Pereira
 * @version 1.0
 */
public class Produto {
	
	private String nome;
	private String descricao;
	private int preco;
	
	/**
	 * @return nome do produto
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * define nome do produto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return descrição do produto
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * define descrição do produto
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * @return preço do produto
	 */
	public int getPreco() {
		return preco;
	}
	
	/**
	 * define preço do produto
	 */
	public void setPreco(int preco) {
		this.preco = preco;
	}
}
