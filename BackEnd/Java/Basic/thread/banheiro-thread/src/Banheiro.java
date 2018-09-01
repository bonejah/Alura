
public class Banheiro {
	private boolean ehSujo = true;
	
	public void fazendoNumero1(){
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " = entrando no banheiro");
			
			while(ehSujo) {
				System.out.println(nome + " eca, banheiro ta sujo");
				esperaLaFora();
			}
			
			System.out.println(nome + " = fazendo coisa rapida");
			
			dormeUmPouco(5000);
			
			this.ehSujo = true;
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
			
			while(ehSujo) {
				System.out.println(nome + " eca, banheiro ta sujo");
				esperaLaFora();
			}
			
			System.out.println(nome + " = fazendo coisa demorada");
			
			dormeUmPouco(10000);
			
			this.ehSujo = true;
			System.out.println(nome + " = dando descarga");
			System.out.println(nome + " = lavando a mao");
			System.out.println(nome + " = saindo do banheiro");
		}
	}

	private void esperaLaFora() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void dormeUmPouco(long milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void limpa(){
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " limpando o banheiro");
			
			if(!ehSujo) {
				System.out.println(nome + " nao está sujo, vou sair");
				return;
			}
			
			this.ehSujo = false;
			
			dormeUmPouco(13000);
			
			this.notifyAll();
			System.out.println(nome + " saindo do banheiro");
		}
	}

}
