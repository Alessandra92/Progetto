package persistenza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import modello.Pdf;
import modello.Prenotazione;
import persistenza.DAOPdfInterface;
import persistenza.DataSource;

public class DAOPdf implements DAOPdfInterface {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet result;
	private static PreparedStatement pr;

	
	public static Pdf getPdfByIdPaziente(int idPrenotazione){
		Pdf pdf = null;
		try{
			connection = DataSource.getConnection();
			Prenotazione prenotazione = DAOPrenotazione.getPrenotazioneById(idPrenotazione);
			System.out.println(prenotazione.getIdPaziente());
			String query = "select * from pdf where "
						 + "idPaziente = ? and "
						 + "idPrenotazione = ? and "
						 + "idAzienda = ? and "
						 + "idEsame = ?";
			pr = connection.prepareStatement(query);
			pr.setInt(1, prenotazione.getIdPaziente());
			pr.setInt(2, prenotazione.getIdPrenotazione());
			pr.setInt(3, prenotazione.getIdAzienda());
			pr.setInt(4, prenotazione.getIdEsame());
			result = pr.executeQuery();
			if(result.next()){
				String nomePaziente = result.getString("nomePaziente");
				String cognomePaziente = result.getString("cognomePaziente");
				String cf = result.getString("cf");
				Calendar dataNas = Pdf.dateToCalendar(result.getDate("dataNas"));
				String nomeAzienda = result.getString("nomeAzienda");
				String indirizzoAzienda = result.getString("indirizzoAzienda");
				String esame = result.getString("esame");
				String note = result.getString("note");
				double costo = result.getDouble("costo");
				Calendar dataprenotazione = Pdf.dateToCalendar(result.getDate("dataprenotazione"));
				Calendar dataEsame = Pdf.dateToCalendar(result.getDate("dataEsame"));
				String citta = result.getString("citta");
				int idPaziente = result.getInt("idPaziente");
				int idAzienda = result.getInt("idAzienda");
				int idCitta = result.getInt("idCitta");
				int idEsame = result.getInt("idEsame");
				pdf= new Pdf(nomePaziente, cognomePaziente, cf, dataNas, nomeAzienda, indirizzoAzienda, esame, note, costo, dataprenotazione, dataEsame, citta, idPaziente, idPrenotazione, idAzienda, idCitta, idEsame);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			DataSource.closeAll(connection, statement, result, pr);
		}
		return pdf;
	}
	
}
