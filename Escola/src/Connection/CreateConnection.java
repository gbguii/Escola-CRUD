package Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateConnection {
	/**
	 * Retorna a conexão com o banco de dados.
	 * @return a conexão com o banco de dados.
	 */
	public static Connection getConection() {
		try {
			// Recupera o arquivo propeties.
			Properties prop = getProperties();
			// Recupera o valor da url para conexão com o banco.
			String url =  prop.getProperty("bank.url");
			// Recupera o valor do login para conexão com o banco.
			String user = prop.getProperty("bank.login");
			// Recupera o valor da senha para conexão com o banco.
			String password = prop.getProperty("bank.password");
			// Retorna a conexão com o banco de dados.
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Localiza o arquivo properties.
	 * @return o arquivo properties
	 * @throws IOException em caso de erro.
	 */
	private static Properties getProperties() throws IOException {
		// Cria um objeto de properties.
		Properties prop = new Properties();
		// Localiza o caminho do arquivo properties
		String path = "/Properties/connection.properties";
		// Carrega o arquivo para ser usado na coneção.
		prop.load(CreateConnection.class.getResourceAsStream(path));
		return prop;
	}
}
