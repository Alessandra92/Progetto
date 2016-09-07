package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modello.Azienda;
import modello.Esame;
import modello.EsameAzienda;
import persistenza.DAOEsameAziendaInterface;
import persistenza.DataSource;

public class DAOEsameAzienda implements DAOEsameAziendaInterface {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet result;
	private static PreparedStatement pr;

	
	public static ArrayList<EsameAzienda> getAll(){
		// TODO Auto-generated method stub
		ArrayList<EsameAzienda> lista = new ArrayList<>();
		int idAzienda,idEsame,maxPersone;
		double costo;
		try{
			connection = DataSource.getConnection();
			statement = connection.createStatement();
			String query = "select * from EsameAzienda";
			result = statement.executeQuery(query);
			while(result.next()){
				idAzienda = result.getInt("idAzienda");
				idEsame = result.getInt("idEsame");
				maxPersone = result.getInt("maxPersone");
				costo = result.getDouble("costo");
				lista.add(new EsameAzienda(idAzienda, idEsame, maxPersone, costo,null,null));
			}
		} catch (SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return lista;
	}

	
	public static ArrayList<Azienda> getListaAziende(int idEsame){
		// TODO Auto-generated method stub
		ArrayList<Azienda> lista = new ArrayList<>();
		int idAzienda,idCitta;
		String nome,partitaIva,email,password,indirizzo;
		try{
			connection = DataSource.getConnection();
			String query = "select * from azienda where idAzienda in "
						+ "(select idAzienda from EsameAzienda where idEsame = ?)";
			pr = connection.prepareStatement(query);
			pr.setInt(1,idEsame);
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
			DataSource.closeAll(connection, statement, result,pr);
		}
		return lista;
	}

	
	public static ArrayList<Esame> getListaEsame(int idAzienda){
		// TODO Auto-generated method stub
		ArrayList<Esame> lista = new ArrayList<>();
		int idEsame;
		String nome,note;
		try{
			connection = DataSource.getConnection();
			String query = "select * from esame where idEsame in "
						+ "(select idEsame from EsameAzienda where idAzienda = ?)";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idAzienda);
			result = pr.executeQuery();
			while(result.next()){
				idEsame = result.getInt("idEsame");
				nome = result.getString("nome");
				note = result.getString("note");
				lista.add(new Esame(idEsame, nome, note));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result,pr);
		}
		return lista;
	}

	
	public static int getMaxPersone(int idEsame, int idAzienda){
		// TODO Auto-generated method stub
		int num = -1;
		try {
			connection = DataSource.getConnection();
			String query = "select maxPersone from EsameAzienda where idEsame = ? and idAzienda = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idEsame);
			pr.setInt(2, idAzienda);
			result = pr.executeQuery();
			if (result.next()){
				num = result.getInt("maxPersone");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result,pr);
		}
		return num;
	}

	
	public static double getCosto(int idEsame, int idAzienda){
		// TODO Auto-generated method stub
		double costo = -1;
		try {
			connection = DataSource.getConnection();
			String query = "select costo from EsameAzienda where idEsame = ? and idAzienda = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idEsame);
			pr.setInt(2, idAzienda);
			result = pr.executeQuery();
			if(result.next()){
				costo = result.getDouble("costo");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result,pr);
		}
		return costo;
	}

	
	public static int aggiungiEsameAllAzienda(int idEsame, int idAzienda, int maxPersone, int costo) throws SQLException {
		// TODO Auto-generated method stub
		int righeInserite = -1;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "insert into EsameAzienda (idEsame,idAzienda,maxPersone,costo) values (?,?,?,?)";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idEsame);
			pr.setInt(2, idAzienda);
			pr.setInt(3, maxPersone);
			pr.setInt(4, costo);
			righeInserite = pr.executeUpdate(query);
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		} finally{
			if(righeInserite > 0){
				connection.commit();
			}
			DataSource.closeAll(connection, statement, result, pr);
		}
		return righeInserite;
	}

	
	public static int rimuoviEsameDallAzienda(int idEsame, int idAzienda) throws SQLException{
		// TODO Auto-generated method stub
		int numeroRighe = -1;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "delete from EsameAzienda where idEsame = ? and idAzienda = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idEsame);
			pr.setInt(2, idAzienda);
			numeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			connection.commit();
			DataSource.closeAll(connection, statement, result, pr);
		}
		return numeroRighe;
	}

	
	public static int update(int idEsame, int idAzienda, double costo, int maxPersone) throws SQLException{
		// TODO Auto-generated method stub
		int numeroRighe = -1;
		try{
			connection = DataSource.getConnection();
			connection.setAutoCommit(false);
			String query = "update EsameAzienda set costo = ?, maxPersone = ? where idEsame = ? and idAzienda = ?";
			pr = connection.prepareStatement(query);
			pr.setDouble(1, costo);
			pr.setInt(2, maxPersone);
			pr.setInt(3, idEsame);
			pr.setInt(4, idAzienda);
			numeroRighe = pr.executeUpdate();
		}catch(SQLException e){
			connection.rollback();
			System.out.println(e);
		}finally{
			connection.commit();
			DataSource.closeAll(connection, statement, result, pr);
		}
		return numeroRighe;
	}
	
	public static ArrayList<EsameAzienda> esameAziendabyIdEsame(int idEsame){
		ArrayList<EsameAzienda> listaEsamiAzienda = new ArrayList<EsameAzienda>();
		int idAzienda,maxPersone;
		String nomeCitta;
		String nomeAzienda;
		double costo;
		
		try{
			connection = DataSource.getConnection();
			String query = "select e.*, a.nome nomeazienda, c.nome nomecitta from EsameAzienda e "
					+ "join azienda a on a.IDAZIENDA=e.IDAZIENDA "
					+ "join citta c on a.IDCITTA=c.IDCITTA"
					+ " where e.idesame = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, idEsame);
			System.out.println(query);
			result = pr.executeQuery();
			while(result.next()){
				idAzienda = result.getInt("idAzienda");
				idEsame = result.getInt("idEsame");
				maxPersone = result.getInt("maxPersone");
				costo = result.getDouble("costo");
				nomeAzienda=result.getString("nomeazienda");
				nomeCitta=result.getString("nomecitta");
				listaEsamiAzienda.add(new EsameAzienda(idAzienda, idEsame, maxPersone, costo,nomeAzienda,nomeCitta));
			}
		} catch (SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return listaEsamiAzienda;
		
	}

}
