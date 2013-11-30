package DBConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
	private String databaseUrl;
	private Properties props;
	private Connection databaseConn;
	
	DBConnector(String host, String port, String dbname, String user, String pw) throws SQLException {
		databaseUrl = "jdbc:postgresql://"+host+":"+port+"/"+dbname;
		props = new Properties();
		props.setProperty("user",user);
		props.setProperty("password",pw);
		//props.setProperty("ssl","true");
			
		databaseConn = DriverManager.getConnection(databaseUrl, props);
		
		if(databaseConn != null) {
			System.out.println("Verbinding gemaakt.");
		}
		else {
			System.out.println("Geen verbinding.");
		}
	}
	
	public Connection getDBConn() {
		return databaseConn;
	}
}
