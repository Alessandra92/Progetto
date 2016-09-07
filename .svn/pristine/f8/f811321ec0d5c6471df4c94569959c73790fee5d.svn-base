package persistenza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException ex) {
			System.out.println("classe non trovata");
			System.out.println(ex);

		}
	}

	private DataSource() {
	}

	private static final String DBURI = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "sanitaria";
	private static final String PW = "sanitaria";

	public static Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURI, USER, PW);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return connection;
	}

	public static void closeAll(Connection connection, Statement statement, ResultSet result, PreparedStatement pr) {
		/*
		 * close(connection); close(statement); close(result);
		 */
		try {
			if (result != null)
				result.close();
			if (statement != null)
				statement.close();
			if (pr != null)
				pr.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(PreparedStatement pr) {
		try {
			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection link) {
		try {
			if (link != null)
				link.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet res) {
		try {
			if (res != null)
				res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
