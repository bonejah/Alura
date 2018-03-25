package br.com.javaI.primeiros.passos;
public class TestaWhile {
	public static void main(String[] args) {
		int contador = 0;
		
		while(contador <= 10){
			System.out.println(contador);
			//contador = contador + 1;
			contador++;
		}
		
		System.out.println("Valor contador: " + contador);
	}
}
