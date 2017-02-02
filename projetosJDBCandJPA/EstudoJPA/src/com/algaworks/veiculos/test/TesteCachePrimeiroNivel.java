package com.algaworks.veiculos.test;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.util.JpaUtil;

public class TesteCachePrimeiroNivel {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela primeira vez...");
		
		System.out.println("Gerenciado? " + manager.contains(veiculo));
		manager.detach(veiculo);
		System.out.println("E agora? " + manager.contains(veiculo));
		
		Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou veiculo pela segunda vez...");
		
		System.out.println("Mesmo veiculo: " + (veiculo == veiculo2));
		
		manager.close();
		JpaUtil.close();
	}
}
