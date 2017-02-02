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

		// temos uma formata��o que usa os padr�es brasileiros
		NumberFormat formatadorBrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		// temos agora uma formata��o que usa os padr�es dos Estados Unidos
		NumberFormat formatadorAmericano = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

		RelatorioDeDivida relatorio = new RelatorioDeDivida(divida);

		// geramos o relat�rio com o formatador brasileiro
		relatorio.geraRelatorio(formatadorBrasileiro);

		// e agora com o formatador americano na mesma inst�ncia de
		// RelatorioDeDivida
		relatorio.geraRelatorio(formatadorAmericano);
	}
}
