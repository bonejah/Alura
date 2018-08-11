package br.com.alura.algoritmosI;

public class BuscaMenorPreco {
	public static void main(String[] args) {
		/*
		 * double precos[] = new double[5]; precos[0] = 100000; precos[1] =
		 * 46000; precos[2] = 16000; precos[3] = 46000; precos[4] = 17000;
		 */

		Produto produtos[] = { 
				new Produto("Lamborghini", 1000000), 
				new Produto("Jipe", 46000),
				new Produto("Peugeot", 7000),
				new Produto("Brasília", 16000), 
				new Produto("Smart", 46000), 
				new Produto("Fusca", 17000)
				};
		
		int maisBarato = buscaMenor(produtos);
		System.out.println(maisBarato);
		System.out.println("O carro mais barato é o de preco: " + produtos[maisBarato]);
		
		/*maisBarato = buscaMenorComRangeDeTermino(produtos, 1);
		System.out.println(maisBarato);
		System.out.println("O carro mais barato é o de preco: " + produtos[maisBarato]);
		
		maisBarato = buscaMenorComRangeDeInicioETermino(produtos, 0, 0);
		System.out.println(maisBarato);
		System.out.println("O carro mais barato é o de preco: " + produtos[maisBarato]);*/
	}

	private static int buscaMenor(Produto[] produtos) {
		int maisBarato = 0;
		int termino = produtos.length -1;
		
		for (int atual = 0; atual <= termino; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
				maisBarato = atual;
			}
		}
		
		return maisBarato;
	}
	
	private static int buscaMenorComRangeDeInicioETermino(Produto[] produtos, int inicio, int termino) {
		int maisBarato = 0;		
		
		for (int atual = inicio; atual <= termino; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
				maisBarato = atual;
			}
		}
		
		return maisBarato;
	}

	private static int buscaMenorComRangeDeTermino(Produto[] produtos, int termino) {
		int maisBarato = 0;		
		
		for (int atual = 0; atual <= termino; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
				maisBarato = atual;
			}
		}
		
		return maisBarato;
	}
}
