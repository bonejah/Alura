package br.com.algoritmosII.alura;

public class TestaEncontraMenores {
	public TestaEncontraMenores() {
	}

	public static void main(String args[]) {
		Nota guilherme = new Nota("Guilherme", 7D);
		Nota notas[] = { new Nota("Andre", 4D), new Nota("Carlos", 8.5D), new Nota("Ana", 10D), new Nota("Jonas", 3D),
				new Nota("Juliana", 6.7000000000000002D), guilherme, new Nota("Paulo", 9D), new Nota("Mariana", 5D),
				new Nota("Lucia", 9.3000000000000007D) };
		int totalNotasMenores = encontraMenores(guilherme, notas);
		System.out.println((new StringBuilder("N\372mero de menores: ")).append(totalNotasMenores).toString());
	}

	private static int encontraMenores(Nota busca, Nota notas[]) {
		int menores = 0;
		for (int atual = 0; atual < notas.length; atual++) {
			Nota nota = notas[atual];
			if (nota.getValor() < busca.getValor())
				menores++;
		}

		return menores;
	}

}
