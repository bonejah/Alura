package br.com.alura.cap1.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		Connection conexao;
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306", "usuario", "senha");
			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
