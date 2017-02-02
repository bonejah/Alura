package br.com.algoritmosII.alura;

public class TesteMergeEmUmUnicoArray {
	public TesteMergeEmUmUnicoArray() {
	}

	public static void main(String args[]) {
		Nota notas[] = { 
				new Nota("Andre", 4D), 
				new Nota("Mariana", 5D), 
				new Nota("Carlos", 8.5D),
				new Nota("Paulo", 9D), 
				new Nota("Jonas", 3D), 
				new Nota("Juliana", 6.7000000000000002D),
				new Nota("Guilherme", 7D), 
				new Nota("Lucia", 9.3000000000000007D), 
				new Nota("Ana", 10D) };
		Nota rank[] = intercala(notas, 0, 4, notas.length);
		Nota anota[];
		int j = (anota = rank).length;
		for (int i = 0; i < j; i++) {
			Nota nota = anota[i];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}

		/*Nota notas2[] = { new Nota("Andre", 4D) };
		Nota rank2[] = intercala(notas, 0, 0, 1);
		Nota anota1[];
		int l = (anota1 = rank2).length;
		for (int k = 0; k < l; k++) {
			Nota nota = anota1[k];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}*/

	}

	private static Nota[] intercala(Nota notas[], int inicial, int miolo, int termino) {
		Nota resultado[] = new Nota[notas.length];
		int atual = 0;
		int atual1 = inicial;
		int atual2;
		for (atual2 = miolo; atual1 < miolo && atual2 < termino;) {
			Nota nota1 = notas[atual1];
			Nota nota2 = notas[atual2];
			if (nota1.getValor() < nota2.getValor()) {
				resultado[atual] = nota1;
				atual1++;
			} else {
				resultado[atual] = nota2;
				atual2++;
			}
			atual++;
		}

		while (atual1 < miolo) {
			resultado[atual] = notas[atual1];
			atual1++;
			atual++;
		}
		while (atual2 < termino) {
			resultado[atual] = notas[atual2];
			atual2++;
			atual++;
		}
		return resultado;
	}

}
