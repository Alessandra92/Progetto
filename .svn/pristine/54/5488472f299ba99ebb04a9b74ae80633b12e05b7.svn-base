package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modello.Azienda;
import persistenza.DAOAziendaInterface;
import persistenza.DataSource;

public class DAOAzienda implements DAOAziendaInterface {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet result;
	private static PreparedStatement pr; 
	
	public static Azienda getAziendaById(int idAzienda) {
		// TODO Auto-generated method stub
		Azienda az = null;
		int idCitta;
		String nome,partitaIva,email,password,indirizzo;
		try {
			connection = DataSource.getConnection();
			String query = "select * from Azienda where idAzienda = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1,idAzienda);
			result = pr.executeQuery();
			if(result.next()){
				nome = result.getString("nome");
				partitaIva = result.getString("partitaIva");
				email = result.getString("email");
				password = result.getString("password");
				idCitta = result.getInt("idCitta");
				indirizzo = result.getString("indirizzo");
				az = new Azienda(idAzienda, nome, partitaIva, email, password, idCitta, indirizzo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return az;
	}

	
	public static ArrayList<Azienda> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Azienda> lista = new ArrayList<>();
		int idAzienda,idCitta;
		String nome,partitaIva,email,password,indirizzo;
		try{
			connection = DataSource.getConnection();
			statement = connection.createStatement();
			String query = "select * from Azienda";
			result = statement.executeQuery(query);
			while(result.next()){
				idAzienda = result.getInt("idAzienda");
				nome = result.getString("nome");
				partitaIva = result.getString("partitaIva");
				email = result.getString("email");
				password = result.getString("password");
				idCitta = result.getInt("idCitta");
				indirizzo = result.getString("indirizzo");
				lista.add(new Azienda(idAzienda, nome, partitaIva, email, password, idCitta, indirizzo));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	
	public static int eliminaAzienda(int idAzienda) throws SQLException {
		// TODO Auto-generated method stub
		int numeroRighe = -1;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "delete from Azienda where idAzienda = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idAzienda);
			numeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			if(numeroRighe > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return numeroRighe;
	}

	
	public static int update(Azienda azienda) throws SQLException {
		// TODO Auto-generated method stub
		int numeroRighe = -1;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
//			idAzienda, nome, partitaIva, email, password, idCitta, indirizzo)
			String query = "update Azienda set nome=?,partitaIva=?,email=?password=?,idCitta=?,indirizzo=? where idAzienda=?";
			pr = connection.prepareStatement(query);
			pr.setString(1, azienda.getNome());
			pr.setString(2, azienda.getPartitaIva());
			pr.setString(3, azienda.getEmail());
			pr.setString(4, azienda.getPassword());
			pr.setInt(5, azienda.getIdCitta());
			pr.setString(6, azienda.getIndirizzo());
			pr.setInt(7, azienda.getIdAzienda());
			numeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			if(numeroRighe > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return numeroRighe;
	}

	
	public static String getPassword(String email) {
		// TODO Auto0 generated method stub
		String pass = null;
		try{
			connection = DataSource.getConnection();
			String query ="select password from Azienda where email = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			result = pr.executeQuery();
			if(result.next()){
				pass = result.getString("password");
			}
		}catch(SQLException e){
			System.out.println(e);
		}
		return pass;
	}

	
	public static ArrayList<Azienda> getAziendaByCitta(int idCitta) {
		// TODO Auto-generated method stub
		ArrayList<Azienda> lista = new ArrayList<>();
		int idAzienda;
		String nome,partitaIva,email,password,indirizzo;
		try{
			connection = DataSource.getConnection();
			String query = "select * from Azienda where idCitta = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idCitta);
			result = pr.executeQuery();
			while(result.next()){
				idAzienda = result.getInt("idAzienda");
				nome = result.getString("nome");
				partitaIva = result.getString("partitaIva");
				email = result.getString("email");
				password = result.getString("password");
				idCitta = result.getInt("idCitta");
				indirizzo = result.getString("indirizzo");
				lista.add(new Azienda(idAzienda, nome, partitaIva, email, password, idCitta, indirizzo));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	
	public static boolean verificaCredenziali(String email, String password) {
		// TODO Auto-generated method stub
		boolean credenzialiOk = false;
		try{
			connection = DataSource.getConnection();
			String query = "select password from azienda where email = ? and password = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			pr.setString(2, password);
			result = pr.executeQuery();
			if(result.next()){
				credenzialiOk = true;
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return credenzialiOk;
	}
	
	public static int getIdAzienda(String email){
		int trovato = -1;
		try{
			connection = DataSource.getConnection();
			String query = "select idAzienda from Azienda where email = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			result = pr.executeQuery();
			if(result.next()){
				trovato = result.getInt("idAzienda");
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return trovato;
	}
	
	public static Azienda getAziendaByMail(String email){
		Azienda az = null;
		int idAzienda,idCitta;
		String nome,partitaIva,password,indirizzo;
		try{
			connection = DataSource.getConnection();
			String query = "select * from Azienda where email = ?";
			pr = connection.prepareStatement(query);
			pr.setString(1, email);
			result = pr.executeQuery();
			if(result.next()){
				idAzienda = result.getInt("idAzienda");
				nome = result.getString("nome");
				partitaIva = result.getString("partitaIva");
				email = result.getString("email");
				password = result.getString("password");
				idCitta = result.getInt("idCitta");
				indirizzo = result.getString("indirizzo");				
				az = new Azienda(idAzienda, nome, partitaIva, email, password, idCitta, indirizzo);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return az;
	}

}
