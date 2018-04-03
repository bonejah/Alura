
public class Banheiro {
	public void fazendoNumero1() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " = entrando no banheiro");
			System.out.println(nome + " = fazendo coisa rapida");
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(nome + " = dando descarga");
			System.out.println(nome + " = lavando a mao");
			System.out.println(nome + " = saindo do banheiro");
		}
	}

	public void fazendoNumero2() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " = entrando no banheiro");
			System.out.println(nome + " = fazendo coisa demorada");
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println(nome + " = dando descarga");
			System.out.println(nome + " = lavando a mao");
			System.out.println(nome + " = saindo do banheiro");
		}
	}

}
