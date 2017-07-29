package com.algaworks.veiculos.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class BuscaListaVeiculoDoProprietario {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Proprietario proprietario = manager.find(Proprietario.class, 2L);
		System.out.println("Proprietário: " + proprietario.getNome());
		for (Veiculo veiculo : proprietario.getVeiculos()) {
			System.out.println("Veículo: " + veiculo.getModelo());

		}
		manager.close();
		JpaUtil.close();

	}
}
