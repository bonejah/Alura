package com.algaworks.veiculos.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.dominio.TipoCombustivel;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.dominio.VeiculoId;
import com.algaworks.veiculos.util.JpaUtil;

public class PersistindoProprietarioEmDoisVeiculos {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Bruno Paulo Costa Lima");
		proprietario.setTelefone("123456564");
		
		manager.persist(proprietario);
		
		VeiculoId veiculoId1 = new VeiculoId("EUF3552", "SAO PAULO");
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("GM");
		veiculo1.setModelo("Celta");
		veiculo1.setAnoFabricacao(2006);
		veiculo1.setAnoModelo(2006);
		veiculo1.setValor(new BigDecimal(11_000));
		veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setProprietario(proprietario);
		veiculo1.setId(veiculoId1);
		manager.persist(veiculo1);
		
		VeiculoId veiculoId2 = new VeiculoId("EUF3553", "SAO PAULO");
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("VW");
		veiculo2.setModelo("Gol");
		veiculo2.setAnoFabricacao(2010);
		veiculo2.setAnoModelo(2010);
		veiculo2.setValor(new BigDecimal(17_200));
		veiculo2.setTipoCombustivel(TipoCombustivel.BIOCOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.setProprietario(proprietario);
		veiculo2.setId(veiculoId2);
		manager.persist(veiculo2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
		
	}
}
