package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class IDbConnecteble {
	public static Connection Connect() throws SQLException {
		// SQLite connection string
		String url = "jdbc:sqlite:C:/Users/Itai Ofir/eclipse-workspace/AIES Cinema/src/Model/CinemaDB.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			throw e;
		}
		return conn;
	}
}
