package br.com.caelum.auron.modelo;

import java.util.Collections;
import java.util.List;

public class Sorteador {
	private List<Participante> participantes;
	private int totalDeParticipantes;
	private Sorteio sorteio;

	public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteioException {
		if (participantes == null) {
			throw new SorteioException("Lista não pode ser nula!");
		}

		this.participantes = participantes;
		this.sorteio = sorteio;
		this.totalDeParticipantes = participantes.size();
	}

	public void sortear() throws SorteioException {
		verificaTamanhoDaListaDeParticipantes();
		embaralhaParticipante();

		for (int indiceAtual = 0; indiceAtual < totalDeParticipantes; indiceAtual++) {
			if (participanteAtualEhOUltimoDaLista(indiceAtual)) {
				criaEAdicionaParNoSorteio(sorteio, indiceAtual, 0);
				break;
			}

			criaEAdicionaParNoSorteio(sorteio, indiceAtual, indiceAtual + 1);
		}
	}

	private void embaralhaParticipante() {
		Collections.shuffle(participantes);
	}

	private void verificaTamanhoDaListaDeParticipantes() throws SorteioException {
		if (this.totalDeParticipantes < 2) {
			throw new SorteioException("Por favor insira dois ou mais participantes na lista!");
		}
	}

	private boolean participanteAtualEhOUltimoDaLista(int indiceAtual) {
		return indiceAtual == totalDeParticipantes - 1;
	}

	private void criaEAdicionaParNoSorteio(Sorteio sorteio, int indiceAtual, int indiceFinal) {
		Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceFinal), sorteio);
		sorteio.adicionaPar(par);
	}
}
