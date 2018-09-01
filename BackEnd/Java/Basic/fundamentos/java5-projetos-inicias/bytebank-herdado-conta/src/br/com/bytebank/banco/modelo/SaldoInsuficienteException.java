package br.com.bytebank.banco.modelo;


/**
 * Classe que representa uma exceção no Bytebank
 * 
 * @author bplima
 * @version 0.1
 */
public class SaldoInsuficienteException extends Exception{
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
