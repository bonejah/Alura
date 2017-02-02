package br.com.caelum.livraria.webservice;

public class TestRequestSoapComJava {

	public static void main(String[] args) throws Exception {
		LivrariaWs ws = new LivrariaWsProxy();
		Livro[] livrosPeloNome = ws.geTLivrosPeloNome("Arquitetura");

		for (Livro livro : livrosPeloNome) {
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAutor());
		}
	}
}
