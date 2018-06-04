package com.algaworks.veiculos.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.dominio.Proprietario;
import com.algaworks.veiculos.dominio.TipoCombustivel;
import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.dominio.VeiculoId;
import com.algaworks.veiculos.util.JpaUtil;

public class PersistindoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		byte[] foto = null;
		
		/*
		Path path = FileSystems.getDefault().getPath("/home/bruno/Alura/EstudoJPA/src/bob_esponja.jpg");
		try {
			foto = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Proprietario proprietario = new Proprietario();
		proprietario.setEmail("dadivajah@gmail.com");
		proprietario.setNome("Bruno Paulo Costa Lima");
		proprietario.setTelefone("99770-3205");
		
		manager.persist(proprietario);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(new VeiculoId("EUF-3558", "Sao Paulo"));
		veiculo.setAnoFabricacao(2011);
		veiculo.setAnoModelo(2011);
		veiculo.setFabricante("VW");
		veiculo.setModelo("GOL");
		veiculo.setValor(new BigDecimal(35000));
		veiculo.setTipoCombustivel(TipoCombustivel.ALCOOL);
		veiculo.setDataCadastro(new Date());
		//veiculo.setEspecificacoes(especificacoes.toString());
		//veiculo.setFoto(foto);
		veiculo.setProprietario(proprietario);
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
