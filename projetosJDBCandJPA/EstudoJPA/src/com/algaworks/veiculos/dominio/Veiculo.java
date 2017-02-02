package com.algaworks.veiculos.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "tbVeiculo")
public class Veiculo {
	// private Long codigo;
	private VeiculoId id;
	private String fabricante;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private BigDecimal valor;
	private TipoCombustivel tipoCombustivel;
	private Date dataCadastro;
	private String especificacoes;
	private byte[] foto;
	private Proprietario proprietario;

	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "inc")
	 * 
	 * @GenericGenerator(name = "inc", strategy = "increment")
	 * 
	 * @Column(name = "cod_veiculo") public Long getCodigo() { return codigo; }
	 * 
	 * public void setCodigo(Long codigo) { this.codigo = codigo; }
	 */

	@EmbeddedId
	public VeiculoId getId() {
		return id;
	}

	public void setId(VeiculoId id) {
		this.id = id;
	}

	@Column(length = 60, nullable = false)
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Column(length = 60, nullable = false)
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "ano_fabricacao", nullable = false)
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	@Column(name = "ano_modelo", nullable = false)
	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	@Column(precision = 10, scale = 2, nullable = true)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Transient
	public String getDescricao() {
		return this.getFabricante() + " " + this.getModelo() + " "
				+ this.getAnoFabricacao() + " " + "/" + this.getAnoModelo()
				+ " por apenas " + this.getValor();
	}

	@Lob
	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	@Lob
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	// @Embedded
	// @OneToOne(optional = false)
	@ManyToOne
	@JoinColumn(name = "cod_proprietario")
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
		result = prime * result
				+ ((anoModelo == null) ? 0 : anoModelo.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result
				+ ((tipoCombustivel == null) ? 0 : tipoCombustivel.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (anoModelo == null) {
			if (other.anoModelo != null)
				return false;
		} else if (!anoModelo.equals(other.anoModelo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (tipoCombustivel != other.tipoCombustivel)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
