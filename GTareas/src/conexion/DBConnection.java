package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection instance = null;

	private DBConnection() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			if (instance == null) {
				Class.forName("com.mysql.jdbc.Driver");
				instance = (Connection) DriverManager.getConnection("jdbc:mysql://halifaxtraining.es:3306/ciberkaos000", "uss000", "perrito2019");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return instance;
	}

}
