package com.algaworks.veiculos.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class TesteConsultaVeiculos {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		List<Veiculo> veiculos = manager
				.createQuery("from Veiculo", Veiculo.class).getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
