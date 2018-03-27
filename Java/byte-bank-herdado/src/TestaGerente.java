
public class TestaGerente {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		gerente.setNome("Luiz");
		gerente.setCpf("123456789-00");
		gerente.setSalario(5000.0);
		
		System.out.println(gerente.getNome());
		
		gerente.setSenha(2222);
		boolean autenticou = gerente.autentica(2222);
		System.out.println(autenticou);
		System.out.println(gerente.getSalario());
		System.out.println(gerente.getBonificacao());
	}
}
