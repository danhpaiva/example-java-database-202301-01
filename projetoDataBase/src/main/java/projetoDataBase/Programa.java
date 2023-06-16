package projetoDataBase;

import java.sql.*;

public class Programa {
	// Configurações do banco de dados
	private static final String URL = "jdbc:mysql://localhost:3306/dbempresa";
	private static final String USERNAME = "user";
	private static final String PASSWORD = "12345";

	public static void main(String[] args) throws SQLException {

		System.out.println("Programa com Acesso ao Banco de Dados");

		Connection conn = null;

		try {
			// Carregar o driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Conectar ao banco de dados
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Executar uma consulta
			String sql = "SELECT * FROM emp";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			// Processar os resultados
			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				System.out.println("Nome: " + nome);
			}

			// Fechar as conexões
			resultSet.close();
			statement.close();

		} catch (Exception e) {
			System.out.println("Erro ao tentar acessar o banco!");
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
			System.out.println("Operação concluída!");
		}
	}
}
