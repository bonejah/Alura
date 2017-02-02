package com.algaworks.veiculos.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class TesteMerge {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);

		tx.commit();
		manager.close();
		
		veiculo.setValor(new BigDecimal(500));
		
		manager = JpaUtil.getEntityManager();
		tx = manager.getTransaction();
		tx.begin();
		
		veiculo = manager.merge(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
