package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modello.Regione;
import persistenza.DAORegioneInterface;
import persistenza.DataSource;

public class DAORegione implements DAORegioneInterface {

	
	public static ArrayList<Regione> getAll() {
		ArrayList<Regione> elencoRegione = new ArrayList<Regione>();
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from regione order by 2";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				int idRegione = result.getInt(1);
				String nome = result.getString(2);
				Regione regione = new Regione(idRegione, nome);
				elencoRegione.add(regione);
			}

			DataSource.close(connection);
			DataSource.close(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elencoRegione;
		
	}

	
	public static Regione getRegioneById(int idRegione) {
		Regione regione = null;
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from regione where idregione=?";

			PreparedStatement psp = connection.prepareStatement(query);

			psp.setInt(1, idRegione);
			ResultSet result = psp.executeQuery();

			if (result.next()) {
				String nome = result.getString(2);
				regione = new Regione(idRegione, nome);
			}
			DataSource.close(connection);
			DataSource.close(result);
			psp.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regione;
		
	}

	
	public static Regione getRegioneByName(String nome) {
		// TODO Auto-generated method stub
		Regione regione = null;
		try {
			Connection connection = DataSource.getConnection();
			String query = "select * from regione where nome=?";

			PreparedStatement psp = connection.prepareStatement(query);

			psp.setString(1, nome);
			ResultSet result = psp.executeQuery();

			if (result.next()) {
				int idRegione = result.getInt(1);
				regione = new Regione(idRegione, nome);
			}
			DataSource.close(connection);
			DataSource.close(result);
			psp.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regione;
	}

}
