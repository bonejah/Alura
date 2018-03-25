
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta(561, 1337);
		System.out.println(conta.getNumero());
		
		Cliente bruno = new Cliente();
		bruno.setNome("Bruno Lima");
		conta.setTitular(bruno); 
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("developer");
		Cliente titularDaConta = conta.getTitular();
		System.out.println(conta.getTitular().getProfissao());
		titularDaConta.setProfissao("programador");
		System.out.println(conta.getTitular().getProfissao());
	}
}
