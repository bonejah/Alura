
public class TesteRunnable {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Executando o Runnable");
			}
		}).start();

		new Thread(() -> System.out.println("Executando Runnable via lambda!")).start();
		;
	}
}
