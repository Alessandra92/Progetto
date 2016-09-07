package persistenza;

import java.sql.SQLException;
import java.util.ArrayList;

import modello.Paziente;

public interface DAOPazienteInterface {
	
	public static Paziente getPazienteById(int idPaziente) {return null;};
	public static ArrayList<Paziente> getAll() {return null;};
	public static int registrazionePaziente(Paziente paziente) throws SQLException {return 0;};
	public static int eliminaPaziente(int idPaziente) throws SQLException {return 0;};
	public static int update(Paziente paziente) throws SQLException {return 0;};
	public static String getPassword(String email) throws SQLException {return null;};
	public static int verificaCredenziali(String email, String password) throws SQLException {return 0;};
	public static Paziente getPazienteByEmail(String email) {return null;};
	public static int getPazienteId(String email){return 0;};
	
}
