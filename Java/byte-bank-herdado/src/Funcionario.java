// Classe não pode ser instanciada porque é abstrata
public abstract class Funcionario {
	private String nome;
	private String cpf;
	protected double salario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// metodos sem corpo, não há implementação, somente nas classes Filhas
	public abstract double getBonificacao();
}
