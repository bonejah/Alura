public class TestaBanco {
	public static void main(String[] args) {
		Cliente bruno = new Cliente();
		bruno.nome = "Bruno Lima";
		bruno.cpf = "123.345.666-88";
		bruno.profissao = "developer";
		
		Conta contaBruno = new Conta();
		contaBruno.deposita(100);
		contaBruno.titular = bruno;
		System.out.println(contaBruno.titular.nome);
		System.out.println(contaBruno.titular);
	}
}
