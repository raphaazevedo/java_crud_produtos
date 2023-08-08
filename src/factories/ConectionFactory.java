package factories;

import java.sql.Connection;
import java.sql.DriverManager;

// responsável por gerar as conexões com banco de dados

public class ConectionFactory {

	// atributos
	// informações necessárias para conectaro banco

	private String driver = "org.postgresql.Driver";
	private String host = "jdbc:postgresql://localhost:5433/bd_java_projeto04";
	private String user = "postgres";
	private String password = "coti";

	public Connection getConection() throws Exception {

		// carregando o driver para conecção com banco
		Class.forName(driver);
		// abrindo e retornando conexão com o postgre
		return DriverManager.getConnection(host, user, password);

		
	}

}
