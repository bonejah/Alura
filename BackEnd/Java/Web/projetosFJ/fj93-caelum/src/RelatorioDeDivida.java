import java.text.NumberFormat;

public class RelatorioDeDivida {
	Divida divida = new Divida();

	public RelatorioDeDivida(Divida divida) {
		this.divida = divida;
	}

	public void geraRelatorio(NumberFormat formatadorBrasileiro) {
		System.out.println("Credor: " + divida.getCredor());
		System.out.println("Cnpj credor: " + divida.getCnpj().getValor());

		NumberFormat formatadorDeNumero = null;
		// agora utilizamos o formatadorDeNumero recebido como parâmetro do
		// método
		System.out.println("Valor a pagar: " + formatadorDeNumero.format(divida.getTotal()));
		System.out.println("Valor total: " + formatadorDeNumero.format(divida.getTotal()));
	}
}
