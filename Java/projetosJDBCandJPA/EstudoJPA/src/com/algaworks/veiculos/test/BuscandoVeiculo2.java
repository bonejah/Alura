package com.algaworks.veiculos.test;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo2 {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		System.out.println("Veículo de código " + veiculo.getId()
				+ " é um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}
}
