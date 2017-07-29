public class Divida {
	private double total;
	private String credor;
	private Cnpj cnpj;
	private Pagamentos pagamentos = new Pagamentos();

	public double valorAPagar() {
		return this.total - this.pagamentos.getValorPago();
	}

	public Cnpj getCnpj() {
		return cnpj;
	}

	public String getCredor() {
		return this.credor;
	}

	public double getTotal() {
		return this.total;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}

	public void setCnpjCredor(Cnpj cnpj2) {
		this.setCnpjCredor(cnpj2);

	}
}