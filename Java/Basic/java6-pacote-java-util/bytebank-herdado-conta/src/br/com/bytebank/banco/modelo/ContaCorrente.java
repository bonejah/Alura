package br.com.bytebank.banco.modelo;
//new ContaCorrente()
public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	public void saca(double valor) throws SaldoInsuficienteException{
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	public void deposita(double valor) {
        super.saldo += valor;
    }

	public double getValorImposto() {	
		return super.saldo * 0.01;
	}
	

	
}
