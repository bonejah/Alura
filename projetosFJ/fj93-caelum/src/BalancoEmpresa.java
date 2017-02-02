import java.util.HashMap;

public class BalancoEmpresa {
	private HashMap<String, Divida> dividas = new HashMap<String, Divida>();

	public void registraDivida(Divida divida) {
		dividas.put(divida.getCnpj().getValor(), divida);
	}

	public void pagaDivida(String cnpjCredor, Pagamento pagamento) {
		Divida divida = dividas.get(cnpjCredor);
		if (divida != null) {
			divida.registra(pagamento);
		}
	}
}