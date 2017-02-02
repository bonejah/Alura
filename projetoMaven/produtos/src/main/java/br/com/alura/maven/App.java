package br.com.alura.maven;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Produto produto = new Produto("Bala Juquinha sabor tangerina", 0.15);
		System.out.println("Hello World!");
		System.out.println("Nome da bala: " + produto.getNome() + " e custa: " + produto.getPreco());
		System.out.println("Categoria: " + produto.getCategoria());
	}
}
