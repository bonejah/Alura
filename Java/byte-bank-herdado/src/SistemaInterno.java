
public class SistemaInterno {

	private int senha = 222;

	public void autentica(Autenticavel f) {
		boolean autenticou = f.autentica(senha);
		if(autenticou) {
			System.out.println("Você pode entrar no sistema");
		} else {
			System.out.println("Você não pode entrar no sistema");
		}
	}

}
