package br.com.bonejah.threads.lista;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		Lista lista = new Lista();
//		List<String> lista = new ArrayList<String>();
//		List<String> lista = Collections.synchronizedList(new ArrayList<String>());
//		List<String> lista = new Vector<String>();

		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}

		Thread.sleep(2000);
		
		new Thread(new TarefaImprimir(lista)).start();
	}
}
