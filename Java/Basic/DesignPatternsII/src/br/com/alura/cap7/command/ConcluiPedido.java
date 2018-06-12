package br.com.alura.cap7.command;

public class ConcluiPedido implements Comando {

	private Pedido pedido;

	public ConcluiPedido(Pedido pedido) {
		super();
		this.pedido = pedido;
	}

	@Override
	public void executa() {
		pedido.finaliza();
	}

}
