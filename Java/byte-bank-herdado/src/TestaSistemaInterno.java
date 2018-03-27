public class TestaSistemaInterno {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		gerente.setSenha(222);
		
		Administrador administrador = new Administrador();
		administrador.setSenha(222);
		
		Cliente cliente = new Cliente();
		cliente.setSenha(222);
		
		SistemaInterno sistemaInterno = new SistemaInterno();
		sistemaInterno.autentica(gerente);
		sistemaInterno.autentica(administrador);
		sistemaInterno.autentica(cliente);
	}
}
