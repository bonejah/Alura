
public class Cnpj implements Documento {
	private String valor;

	public Cnpj(String novoValor) {
		this.valor = novoValor;
	}

	public boolean cnpjValido() {
		return primeiroDigitoVerificadorDoCnpj() == primeiroDigitoCorretoParaCnpj()
				&& segundoDigitoVerificadorDoCnpj() == segundoDigitoCorretoParaCnpj();
	}

	private int primeiroDigitoCorretoParaCnpj() {
		// Calcula o primeiro d�gito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int primeiroDigitoVerificadorDoCnpj() {
		// Extrai o primeiro d�gito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	private int segundoDigitoCorretoParaCnpj() {
		// Calcula o segundo d�gito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int segundoDigitoVerificadorDoCnpj() {
		// Extrai o segundo d�gito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cnpj other = (Cnpj) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public boolean ehValido() {
		return false;
	}

}
