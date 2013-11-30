package DBConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class tester {
	public static void main(String args[]) throws SQLException{
		DBConnector dbc = new DBConnector("145.24.222.158", "21", "INFPRJ01-56", "postgres", "GroeP1");
		Connection connection = dbc.getDBConn();
		
		queryHandler QH = new queryHandler(connection);
		
		// INSERT INTO "TABEL", "COLUMNS", "VALUES"
		QH.doInsert("cv",
					"voornaam, achternaam, tussenvoegsels, opleiding, jaren_werkervaring, woonplaats, cursussen, it_kennis, taalid, rijbewijs",
					"'NEE', 'ZAK', 'JA', 'JA', 14241, 'JA', 'J', 'J', 1, TRUE");
		
		// SELECT "COLUMNS" FROM "TABEL"
		QH.doSelect("*","cv");
	}
}