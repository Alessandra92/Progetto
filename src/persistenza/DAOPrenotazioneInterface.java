package persistenza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import modello.Prenotazione;

public interface DAOPrenotazioneInterface {
	
//	IDPRENOTAZIONE
//	IDAZIENDA
//	IDESAME
//	DATAESAME
//	IDPAZIENTE
//	DATAPRENOTAZIONE
//	VOTO
//	COMMENTO
	
	public static ArrayList<Prenotazione> getPrenotazioniAttive(int idPaziente) {return null;};
	public static ArrayList<Prenotazione> getStoricoPaziente(int idPaziente) {return null;};
	public static ArrayList<Prenotazione> getPrenotazioniGiorno(int idAzienda, Calendar dataEsame) {return null;};
	public static ArrayList<Prenotazione> getStoricoAzienda(int idAzienda) {return null;};
	public static int lasciaFeedback(int idPrenotazione, int voto, String commento) throws SQLException {return 0;};
	public static int prenotaEsame(Prenotazione prenotazione) throws SQLException {return 0;};
	public static int eliminaPrenotazione(int idPrenotazione) throws SQLException {return 0;};
	public static int rimandaEsame(int idPrenotazione , Calendar nuovaDataEsame) throws SQLException {return 0;};
	public static int eDisponibile(int idAzienda, int idEsame, Calendar dataEsameDaPrenotare) {return 0;};
	public static Prenotazione getPrenotazioneById(int idPrenotazione){return null;};
	
}
