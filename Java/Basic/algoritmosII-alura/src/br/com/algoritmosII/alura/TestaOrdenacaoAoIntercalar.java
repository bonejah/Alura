package br.com.algoritmosII.alura;

public class TestaOrdenacaoAoIntercalar {
	public TestaOrdenacaoAoIntercalar() {
	}

	public static void main(String args[]) {
		Nota notas[] = { 
				new Nota("Andre", 4D), 
				new Nota("Carlos", 8.5D), 
				new Nota("Ana", 10D), 
				new Nota("Jonas", 3D),
				new Nota("Juliana", 6.7), 
				new Nota("Guilherme", 7D), 
				new Nota("Paulo", 9D),
				new Nota("Mariana", 5D), 
				new Nota("Lucia", 9.3D) };
		
		intercala(notas, 0, 1, 2);
		intercala(notas, 2, 3, 4);
		intercala(notas, 0, 2, 4);
		intercala(notas, 4, 5, 6);
		intercala(notas, 6, 7, 8);
		intercala(notas, 4, 6, 8);
		intercala(notas, 0, 4, 8);
		intercala(notas, 0, 8, 9);
		
		ordena(notas, 0, notas.length);
		
		Nota anota[];
		int j = (anota = notas).length;
		for (int i = 0; i < j; i++) {
			Nota nota = anota[i];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}

	}

	private static void ordena(Nota notas[], int inicial, int termino) {
		int quantidade = termino - inicial;
		if (quantidade > 1) {
			int meio = (inicial + termino) / 2;
			ordena(notas, inicial, meio);
			ordena(notas, meio, termino);
			intercala(notas, inicial, meio, termino);
		}
	}

	private static void intercala(Nota notas[], int inicial, int miolo, int termino) {
		Nota resultado[] = new Nota[termino - inicial];
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
		for (int contador = 0; contador < atual; contador++)
			notas[inicial + contador] = resultado[contador];

	}
}
