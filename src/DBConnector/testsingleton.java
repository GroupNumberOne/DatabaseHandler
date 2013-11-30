package DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testsingleton {
	public static void main(String args[]) throws SQLException{
		DBConnectorSingleton dbcs = DBConnectorSingleton.getInstance("145.24.222.158", "21", "INFPRJ01-56", "postgres", "GroeP1");
		
		Statement st = dbcs.getDBConn().createStatement();
		ResultSet rs = st.executeQuery("SELECT voornaam, achternaam FROM cv");
	      while (rs.next())
	      {
	        String s = rs.getString("voornaam");
	        String n = rs.getString("achternaam");
	        System.out.println(s + "   " + n);
	      }
		rs.close();
		st.close();
		
		DBConnectorSingleton dbcs1 = DBConnectorSingleton.getInstance("145.24.222.158", "21", "INFPRJ01-56", "postgres", "GroeP1");
	}
}