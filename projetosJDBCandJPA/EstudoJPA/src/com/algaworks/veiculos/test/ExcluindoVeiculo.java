package com.algaworks.veiculos.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class ExcluindoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		manager.remove(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
