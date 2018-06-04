package br.com.alura.servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

	private ServerSocket servidor;
	private ExecutorService threadPool;
	//private volatile boolean estaRodando;
	private AtomicBoolean estaRodando;
	private BlockingQueue<String> filaComandos; 

	public ServidorTarefas() throws IOException {
		System.out.println("---- Iniciando Servidor ----");
		this.servidor = new ServerSocket(12345);
		//this.threadPool = Executors.newCachedThreadPool();
		this.threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads());
		this.estaRodando = new AtomicBoolean(true);
		this.filaComandos = new ArrayBlockingQueue<>(2); //crianda a fila com capacidade de 2 elementos
		iniciarConsumidores();
	}

	public void rodar() throws IOException {
		while (this.estaRodando.get()) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta " + socket.getPort());
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, filaComandos, socket, this);
			threadPool.execute(distribuirTarefas);
		}
	}

	public void parar() throws IOException {
		this.estaRodando.set(false);
		this.threadPool.shutdown();
		this.servidor.close();
	}
	
	private void iniciarConsumidores() {
	    int qtdCondumidores = 2;
	    for (int i = 0; i < qtdCondumidores; i++) {
	        TarefaConsumir tarefa = new TarefaConsumir(filaComandos);
	        this.threadPool.execute(tarefa);
	    }
	}

	public static void main(String[] args) throws Exception {
		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
	}
}
