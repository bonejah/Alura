package br.com.algoritmosII.alura;

public class TestaMerge {
	public TestaMerge() {
	}

	public static void main(String args[]) {
		Nota notasDoMauricio[] = { 
				new Nota("Andre", 4D), 
				new Nota("Mariana", 5D), 
				new Nota("Carlos", 8.5D),
				new Nota("Paulo", 9D) };
		
		Nota notasDoAlberto[] = { 
				new Nota("Jonas", 3D), 
				new Nota("Juliana", 6.7000000000000002D),
				new Nota("Guilherme", 7D), 
				new Nota("Lucia", 9.3000000000000007D), 
				new Nota("Ana", 10D) };
		Nota rank[] = intercala(notasDoMauricio, notasDoAlberto);
		Nota anota[];
		int j = (anota = rank).length;
		for (int i = 0; i < j; i++) {
			Nota nota = anota[i];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}

		System.out.println("===========================================");
		Nota rank2[] = intercala(notasDoAlberto, notasDoMauricio);
		Nota anota1[];
		int l = (anota1 = rank2).length;
		for (int k = 0; k < l; k++) {
			Nota nota = anota1[k];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}
	}

	private static Nota[] intercala(Nota notas1[], Nota notas2[]) {
		int total = notas1.length + notas2.length;
		Nota resultado[] = new Nota[total];
		int atual1 = 0;
		int atual2 = 0;
		int atual;
		for (atual = 0; atual1 < notas1.length && atual2 < notas2.length; atual++) {
			Nota nota1 = notas1[atual1];
			Nota nota2 = notas2[atual2];
			if (nota1.getValor() < nota2.getValor()) {
				resultado[atual] = nota1;
				atual1++;
			} else {
				resultado[atual] = nota2;
				atual2++;
			}
		}

		for (; atual1 < notas1.length; atual1++) {
			resultado[atual] = notas1[atual1];
			atual++;
		}

		for (; atual2 < notas2.length; atual2++) {
			resultado[atual] = notas2[atual2];
			atual++;
		}

		return resultado;
	}
}
