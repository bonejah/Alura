package com.algaworks.veiculos.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.algaworks.veiculos.dominio.Veiculo;
import com.algaworks.veiculos.dominio.VeiculoId;
import com.algaworks.veiculos.util.JpaUtil;

public class ExibindoImagem {
	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		VeiculoId veiculoId = new VeiculoId("EUF-3558", "Sao Paulo");
		Veiculo veiculo = manager.find(Veiculo.class, veiculoId);
		if (veiculo.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculo
					.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		} else {
			System.out.println("Veículo não possui foto.");
		}
		manager.close();
		JpaUtil.close();
	}
}
