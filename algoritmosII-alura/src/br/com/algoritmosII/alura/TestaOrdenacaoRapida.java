package br.com.algoritmosII.alura;

public class TestaOrdenacaoRapida {
	public TestaOrdenacaoRapida() {
	}
 
	public static void main(String args[]) {
		Nota guilherme = new Nota("Guilherme", 7D);
		Nota notas[] = { 
				new Nota("Andre", 4D), 
				new Nota("Carlos", 8.5D), 
				new Nota("Ana", 10D), 
				new Nota("Jonas", 3D),
				new Nota("Juliana", 6.7D), 
				new Nota("Lucia", 9.3), 
				new Nota("Paulo", 9D),
				new Nota("Mariana", 5D), 
				guilherme };
		ordena(notas, 0, notas.length);
		
		int encontrei = busca(notas, 0, notas.length,7);
		if (encontrei > 0)
			System.out.println((new StringBuilder("Encontrei a nota em: ")).append(encontrei).toString());
		else
			System.out.println("N\343o encontrei a nota");
		for (int atual = 0; atual < notas.length; atual++) {
			Nota nota = notas[atual];
			System.out.println((new StringBuilder(String.valueOf(nota.getAluno()))).append(" ").append(nota.getValor())
					.toString());
		}

	}

	private static int busca(Nota notas[], int de, int ate, double buscando) {
		System.out.println((new StringBuilder("Buscando ")).append(buscando).append(" entre ").append(de).append(" e ")
				.append(ate).toString());
		if (de > ate)
			return -1;
		int meio = (de + ate) / 2;
		Nota nota = notas[meio];
		if (buscando == nota.getValor())
			return meio;
		if (buscando < nota.getValor())
			return busca(notas, de, meio - 1, buscando);
		else
			return busca(notas, meio + 1, ate, buscando);
	}

	private static void ordena(Nota notas[], int de, int ate) {
		int elementos = ate - de;
		if (elementos > 1) {
			int posicaoDoPivo = particiona(notas, de, ate);
			ordena(notas, de, posicaoDoPivo);
			ordena(notas, posicaoDoPivo + 1, ate);
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
