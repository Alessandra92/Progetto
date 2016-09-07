package persistenza;


import java.sql.SQLException;
import java.util.ArrayList;

import modello.Azienda;

public interface DAOAziendaInterface {
	
//	IDAZIENDA
//	NOME
//	PARTITAIVA
//	EMAIL
//	PASSWORD
//	IDCITTA
//	INDIRIZZO

	public static Azienda getAziendaById(int idAzienda){return null;};
	public static ArrayList<Azienda> getAll(){return null;};
//	public static boolean registrazioneAzienda(Azienda azienda);
	public static int eliminaAzienda(int idAzienda) throws SQLException {return 0;};
	public static int update(Azienda azienda) throws SQLException {return 0;};
	public static String getPassword(String email){return null;};
	public static ArrayList<Azienda> getAziendaByCitta(int idCitta){return null;};
	public static int verificaCredenziali(String email,String password){return 0;};
	public static Azienda getAziendaByMail(String email){return null;};
	public static int getIdAzienda(String email){return 0;};
	
}
