package br.com.caelum.auron.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.auron.dao.ParticipanteDao;
import br.com.caelum.auron.dao.SorteioDao;
import br.com.caelum.auron.modelo.Par;
import br.com.caelum.auron.modelo.Participante;
import br.com.caelum.auron.modelo.Sorteador;
import br.com.caelum.auron.modelo.Sorteio;
import br.com.caelum.auron.modelo.SorteioException;

@Named
@RequestScoped
public class SorteioBean {
	private Sorteio sorteio = new Sorteio();

	@Inject
	private ParticipanteDao participanteDao;

	@Inject
	private SorteioDao sorteioDao;

	public Sorteio getSorteio() {
		return sorteio;
	}

	public void sortear() {
		List<Participante> participantes = participanteDao.getParticipantes();

		try {
			Sorteador sorteador = new Sorteador(sorteio, participantes);
			sorteador.sortear();
			sorteioDao.inserir(sorteio);
		} catch (SorteioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
	}

	public List<Par> getPares() {
		return sorteioDao.getPares();
	}
}
