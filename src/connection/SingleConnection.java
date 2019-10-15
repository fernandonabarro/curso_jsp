package connection;

import java.sql.Connection;
import java.sql.DriverManager;


/*
 * Respons�vel por fazer conex�o com o bando de dados
 * 
 */
public class SingleConnection {
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp";
	private static String user="postgres";
	private static String password ="admin";
	private static Connection connection = null;
	
	static{
		conectar();
	}
	
	public SingleConnection(){
		conectar();
	}
	
	public static void conectar(){
		
		if(connection == null){
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);	
			} catch (Exception e) {
				 System.out.println("Erro ao conectar com o banco de dados");
			}

		}
	}
	
	public static Connection getConnection(){
		return connection;
		
	}
}
