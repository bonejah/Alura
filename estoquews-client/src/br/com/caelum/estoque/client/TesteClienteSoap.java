package br.com.caelum.estoque.client;

public class TesteClienteSoap {
	public static void main(String[] args) {
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSImplPort();

		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo("Celular");;

		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);

		ListaItens lista = cliente.todosOsItens(filtros);

		System.out.println("Resposta do serviço: " + lista);
	}
}
