public class TestaContaSemCliente {
	public static void main(String[] args) {
		Conta contaLeticia = new Conta();
		System.out.println(contaLeticia.getSaldo());
		
		contaLeticia.titular = new Cliente();
		System.out.println(contaLeticia.titular);
		
		contaLeticia.titular.nome = "Leticia";
		System.out.println(contaLeticia.titular.nome);
	}
}
