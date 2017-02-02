import java.text.NumberFormat;
import java.util.Locale;

class TestaRelatorioDeDivida {
	public static void main(String[] args) {
		Divida divida = new Divida();
		divida.setCredor("Credor 1");
		divida.setCnpjCredor(new Cnpj("00.000.000/0001-01"));
		divida.setTotal(3000);

		Pagamento pagamento1 = new Pagamento();
		pagamento1.setValor(100);
		divida.registra(pagamento1);

		// temos uma formatação que usa os padrões brasileiros
		NumberFormat formatadorBrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		// temos agora uma formatação que usa os padrões dos Estados Unidos
		NumberFormat formatadorAmericano = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

		RelatorioDeDivida relatorio = new RelatorioDeDivida(divida);

		// geramos o relatório com o formatador brasileiro
		relatorio.geraRelatorio(formatadorBrasileiro);

		// e agora com o formatador americano na mesma instância de
		// RelatorioDeDivida
		relatorio.geraRelatorio(formatadorAmericano);
	}
}
