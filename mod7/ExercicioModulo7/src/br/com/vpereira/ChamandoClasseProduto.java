/**
 * 
 */
package br.com.vpereira;

/**
 * @author Victor Pereira
 * @version 1.0
 */
public class ChamandoClasseProduto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto produto = new Produto();
		produto.setNome("Monitor");
		produto.setDescricao("Monitor Led 32 Polegadas");
		produto.setPreco(400);
		System.out.println("Produto");
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Preço: " + produto.getPreco() + "$");
	}

}
