package persistenza;

import java.util.ArrayList;

import modello.Citta;

public interface DAOCittaInterface {
	
//	IDCITTA
//	NOME
//	IDREGIONE
	
	public static ArrayList<Citta> getAll(){return null;};
	public static Citta getCittaById(int idCitta){return null;};
	public static ArrayList<Citta> getCittaByRegione(int idRegione){return null;};

}
