package com.algaworks.veiculos.test;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.dominio.VeiculoId;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo1 {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		VeiculoId veiculoId = new VeiculoId("ABC-9876", "Sao Paulo");
		Veiculo veiculo = manager.find(Veiculo.class, veiculoId);
		System.out.println("Veículo de código " + veiculo.getId() + " é um " + veiculo.getModelo());
		System.out.println(veiculo.getDescricao());
		manager.close();
		JpaUtil.close();
	}
}
