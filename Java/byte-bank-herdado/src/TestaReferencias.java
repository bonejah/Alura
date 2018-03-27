
public class TestaReferencias {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		gerente.setNome("Marcos");
		gerente.setSalario(5000.0);
				
		EditorVideo ed = new EditorVideo();
		ed.setSalario(2000.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(gerente);
		controle.registra(ed);
		
		System.out.println(controle.getSoma());
	}
}
