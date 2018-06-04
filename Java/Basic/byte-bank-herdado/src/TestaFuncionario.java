public class TestaFuncionario {
	public static void main(String[] args) {
		EditorVideo bruno = new EditorVideo();
		bruno.setNome("Bruno");
		bruno.setCpf("123457890-00");
		bruno.setSalario(7000.00);
		
		System.out.println(bruno.getNome());
		System.out.println(bruno.getBonificacao());
	}
}
