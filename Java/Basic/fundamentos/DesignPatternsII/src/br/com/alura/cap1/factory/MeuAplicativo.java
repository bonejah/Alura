package br.com.alura.cap1.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MeuAplicativo {
	public static void main(String[] args) throws Exception {
		Connection conexao = new ConnectionFactory().getConnection();
		PreparedStatement ps = conexao.prepareStatement("select * from ..");
	}
}
