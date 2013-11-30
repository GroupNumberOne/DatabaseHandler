package DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class queryHandler {
	
	private Connection databaseConnection;
	
	queryHandler(Connection conn) {
		databaseConnection = conn;
	}
	
	public void doInsert(String table, String columns, String values) {
	    System.out.print("\n[INSERT WORDT UITGEVOERD]");
	    try
	    {
	      Statement st = databaseConnection.createStatement();
	      st.executeUpdate("INSERT INTO "+table+" ("+columns+") " +
	                       "VALUES ("+values+")");
	    }
	    catch (SQLException ex)
	    {
	      System.err.println(ex.getMessage());
	    }
	}
	
	public void doSelect(String columns, String tabel) {
		System.out.println("\n[SELECT WORDT UITGEVOERD]");
	    String query = "SELECT "+columns+" FROM "+tabel;
	    try
	    {
	    	Statement st = databaseConnection.createStatement();
	    	ResultSet rs = st.executeQuery(query);
	    	while (rs.next())
	    	{
	    		String vo = rs.getString("voornaam");
	    		String ac = rs.getString("achternaam");
	    		String tu = rs.getString("tussenvoegsels");
	    		String op = rs.getString("opleiding");
	    		String ja = rs.getString("jaren_werkervaring");
	    		String wo = rs.getString("woonplaats");
	    		String cu = rs.getString("cursussen");
	    		String it = rs.getString("it_kennis");
	    		String ta = rs.getString("taalid");
	    		String ri = rs.getString("rijbewijs");
	    		
	    		System.out.println(vo+ac+tu+op+ja+wo+cu+it+ta+ri);
	    	}
	    }
	    catch (SQLException ex){
	    	System.err.println(ex.getMessage());
	    }
	}
}
