package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modello.Citta;

import persistenza.DAOCittaInterface;
import persistenza.DataSource;

public class DAOCitta implements DAOCittaInterface{

	public static ArrayList<Citta> getAll() {
		ArrayList<Citta> elencoCitta = new ArrayList<Citta>();
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from citta order by 2";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				int idCitta = result.getInt(1);
				String nome = result.getString(2);
				int idRegione = result.getInt(3);

				Citta citta = new Citta(idCitta, nome, idRegione);
				elencoCitta.add(citta);
			}

			DataSource.close(connection);
			DataSource.close(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elencoCitta;
	}

	
	public static Citta getCittaById(int idCitta) {
		Citta citta = null;
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from citta where idcitta=?";

			PreparedStatement psp = connection.prepareStatement(query);

			psp.setInt(1, idCitta);
			ResultSet result = psp.executeQuery();

			if (result.next()) {
				String nome = result.getString(2);
				int idRegione = result.getInt(3);
				citta = new Citta(idCitta, nome, idRegione);
			}
			DataSource.close(connection);
			DataSource.close(result);
			psp.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return citta;
	}

	
	public static ArrayList<Citta> getCittaByRegione(int idRegione) {
		
		ArrayList<Citta> elencoCittaNellaRegione = new ArrayList<Citta>();
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from citta where idregione=?";
			PreparedStatement psp = connection.prepareStatement(query);

			psp.setInt(1, idRegione);
			ResultSet result = psp.executeQuery();

			while (result.next()) {
				int idCitta = result.getInt(1);
				String nome = result.getString(2);
				Citta citta = new Citta(idCitta, nome, idRegione);
				elencoCittaNellaRegione.add(citta);
			}

			DataSource.close(connection);
			DataSource.close(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elencoCittaNellaRegione;
		
		
	}

}
