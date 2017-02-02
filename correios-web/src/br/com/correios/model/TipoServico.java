package br.com.correios.model;

import java.io.Serializable;

public class TipoServico implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long cdServico;
	private String nmServico;

	public TipoServico() {
	}

	public TipoServico(Long cdServico, String nmServico) {
		this.cdServico = cdServico;
		this.nmServico = nmServico;
	}

	public Long getCdServico() {
		return cdServico;
	}
	
	public String getNmServico() {
		return nmServico;
	}
}
