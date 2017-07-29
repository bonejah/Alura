package br.com.algoritmosII.alura;

public class TestaPivota {
	public TestaPivota() {
	}

	public static void main(String args[]) {
		Nota guilherme = new Nota("Guilherme", 7D);
		Nota notas[] = { 
				new Nota("Andre", 4D), 
				new Nota("Carlos", 8.5D), 
				new Nota("Ana", 10D), 
				new Nota("Jonas", 3D),
				new Nota("Juliana", 6.7), 
				new Nota("Lucia", 9.3), 
				new Nota("Paulo", 9D),
				new Nota("Mariana", 5D), 
				guilherme };
		int posicaoPivo = particiona(notas, 0, notas.length);
		
		System.out.println((new StringBuilder("O pivo foi parar na posicao: ")).append(posicaoPivo).toString());
		for (int atual = 0; atual < notas.length; atual++) {
			Nota nota = notas[atual];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}

	}

	private static int particiona(Nota notas[], int inicio, int termino) {
		Nota pivo = notas[termino - 1];
		int menoresEncontrados = 0;
		for (int analisando = 0; analisando < termino - 1; analisando++) {
			Nota atual = notas[analisando];
			if (atual.getValor() <= pivo.getValor()) {
				trocaDePosicao(notas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}

		trocaDePosicao(notas, termino - 1, menoresEncontrados);
		return menoresEncontrados;
	}

	private static void trocaDePosicao(Nota notas[], int de, int para) {
		Nota nota1 = notas[de];
		Nota nota2 = notas[para];
		notas[para] = nota1;
		notas[de] = nota2;
	}

}
