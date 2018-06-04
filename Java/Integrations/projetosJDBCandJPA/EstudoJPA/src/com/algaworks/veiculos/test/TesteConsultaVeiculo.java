package com.algaworks.veiculos.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.dominio.VeiculoId;
import com.algaworks.veiculos.util.JpaUtil;

public class TesteConsultaVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		VeiculoId id = new VeiculoId("EUF-3558", "Sao Paulo");
		Veiculo veiculo = manager.find(Veiculo.class, id);

		System.out.println(veiculo.getModelo() + " - "
				+ veiculo.getProprietario().getNome());

		manager.close();
		JpaUtil.close();
	}
}
