package persistenza;

import java.sql.SQLException;
import java.util.ArrayList;

import modello.Esame;

public interface DAOEsameInterface {
	
//	IDESAME
//	NOME
//	NOTE
	
	public static ArrayList<Esame> getAll(){return null;};
	public static Esame getEsameByNome(String nome){return null;};
	public static Esame getEsameById(int idEsame){return null;};
	public static int aggiungiEsame(Esame esame) throws SQLException {return 0;};
	public static int eliminaEsame(int idEsame)throws SQLException  {return 0;};
	public static int updateNote(String note, int idEsame)throws SQLException {return 0;};
//	public static static ArrayList<Esame> getEsamiByIdList(ArrayList<Integer> idEsami){return null;};
	

}
