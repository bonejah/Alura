package br.com.alura.cap3.memento;

import java.util.Calendar;

public class Contrato {
	
	private Calendar data;
	private String cliente;
	private TipoContrato tipo;
	
	public Contrato(Calendar data, String cliente, TipoContrato tipo) {
		super();
		this.data = data;
		this.cliente = cliente;
		this.tipo = tipo;
		
		System.out.println("Gerando o contrato: " + this);
	}
	
	public void avanca() {
		if (tipo == TipoContrato.NOVO) tipo = TipoContrato.EM_ANDAMENTO;
		else if (tipo == TipoContrato.EM_ANDAMENTO) tipo = TipoContrato.ACERTADO;
		else if (tipo == TipoContrato.ACERTADO) tipo = TipoContrato.CONCLUIDO;
 	}
	
	public Estado salvaEstado() {
		return new Estado(new Contrato(data, cliente, tipo));
	}
	
	public void restaura(Estado estado) {
		this.data = estado.getContrato().getData();
		this.cliente = estado.getContrato().getCliente();
		this.tipo = estado.getContrato().getTipo();
	}
	
	public Calendar getData() {
		return data;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public TipoContrato getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Contrato [data=" + data.getTime() + ", cliente=" + cliente + ", tipo=" + tipo + "]";
	}
}
