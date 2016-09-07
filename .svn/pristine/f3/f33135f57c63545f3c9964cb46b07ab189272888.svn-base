package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modello.Esame;
import persistenza.DAOEsameInterface;
import persistenza.DataSource;

public class DAOEsame implements DAOEsameInterface {

	
	public static ArrayList<Esame> getAll() {
		// Questo metodo restituisce tutti gli esami del DB
		ArrayList<Esame> elencoEsami = new ArrayList<Esame>();
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from esame order by 2";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				int idEsame = result.getInt(1);
				String nome = result.getString(2);
				String note = result.getString(3);

				Esame esame = new Esame(idEsame, nome, note);
				elencoEsami.add(esame);
			}

			DataSource.close(connection);
			DataSource.close(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elencoEsami;
	}

	
	public static Esame getEsameByNome(String nome) {
		// Questo metodo restituisce l'esame quando si cerca per nome
		Esame esame = null;
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from esame where nome=?";

			PreparedStatement psp = connection.prepareStatement(query);

			psp.setString(1, nome);
			ResultSet result = psp.executeQuery();

			if (result.next()) {
				int idEsame = result.getInt(1);
				String note = result.getString(3);
				esame = new Esame(idEsame, nome, note);

			}
			DataSource.close(connection);
			DataSource.close(result);
			psp.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return esame;

	}

	
	public static Esame getEsameById(int idEsame) {
		// Questo metodo restituisce l'esame quando si cerca per id
		Esame esame = null;
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from esame where idesame=?";

			PreparedStatement psp = connection.prepareStatement(query);

			psp.setInt(1, idEsame);
			ResultSet result = psp.executeQuery();

			if (result.next()) {
				String nome = result.getString(2);
				String note = result.getString(3);
				esame = new Esame(idEsame, nome, note);

			}
			DataSource.close(connection);
			DataSource.close(result);
			psp.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esame;
	}

	
	public static int aggiungiEsame(Esame esame) throws SQLException {
		Connection connection = null;
		PreparedStatement psp = null;
		int p = -1;
		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String sql = "insert into esame (nome,note) values (?,?)";

			psp = connection.prepareStatement(sql);

			psp.setString(1, esame.getNome());
			psp.setString(2, esame.getNote());

			p = psp.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection.rollback();
			e.printStackTrace();
		} finally {
			if (p > 0) {
				connection.commit();
			}
			DataSource.close(connection);
			psp.close();
		}
		return p;
	}

	
	public static int eliminaEsame(int idEsame) throws SQLException {

		Connection connection = null;
		PreparedStatement psp = null;
		int p = -1;

		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "delete from esame where id=?";
			psp = connection.prepareStatement(query);

			psp.setInt(1, idEsame);
			p = psp.executeUpdate();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			if (p > 0) {
				connection.commit();
			}
			DataSource.close(connection);
			psp.close();
		}
		return p;

	}

	
	public static int updateNote(String note, int idEsame) throws SQLException {
		// Questo metodo modifica la descrizione dell'esame
		Connection connection = null;
		PreparedStatement psp = null;
		int p = -1;

		try {
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String sql = "update esame SET note=? where id=?";

			psp = connection.prepareStatement(sql);
			psp.setInt(1, idEsame);

			p = psp.executeUpdate();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		finally {
			if (p > 0) {
				connection.commit();
			}
			DataSource.close(connection);
			psp.close();
		}
		return p;
	}

}
