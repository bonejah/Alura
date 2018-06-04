package com.algaworks.veiculos.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class SincronizacaoDados {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		
		System.out.println("Valor atual: " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
		
		manager.flush(); // força o update antes
		
		System.out.println("Novo valor: " + veiculo.getValor());
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
