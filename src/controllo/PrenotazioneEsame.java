package controllo;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modello.Paziente;
import modello.Azienda;
import modello.Citta;
import modello.Esame;
import modello.EsameAzienda;
import modello.Prenotazione;
import modello.Regione;
import persistenza.dao.DAOAzienda;
import persistenza.dao.DAOCitta;
import persistenza.dao.DAOEsame;
import persistenza.dao.DAOEsameAzienda;
import persistenza.dao.DAOPrenotazione;
import persistenza.dao.DAORegione;
import sun.awt.AWTAccessor.SystemColorAccessor;

/**
 * Servlet implementation class PrenotazioneEsame
 */
@WebServlet("/PrenotazioneEsame")
public class PrenotazioneEsame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneEsame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Azienda azienda = DAOAzienda.getAziendaById(Integer.parseInt(request.getParameter("idAzienda")));
		Esame esame = DAOEsame.getEsameById(Integer.parseInt(request.getParameter("idEsame")));
		double costoEsame= DAOEsameAzienda.getCosto(esame.getIdEsame(),azienda.getIdAzienda());
		Citta citta = DAOCitta.getCittaById(azienda.getIdCitta());
		Regione regione = DAORegione.getRegioneById(citta.getIdRegione());
		
		request.setAttribute("azienda", azienda);
		request.setAttribute("esame", esame);
		request.setAttribute("citta", citta);
		request.setAttribute("regione", regione);
		request.setAttribute("costo", costoEsame);
		
		RequestDispatcher rd = request.getRequestDispatcher("confermaPrenotazione.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("id") != null) {
			
			int idEsame = Integer.parseInt(request.getParameter("idEsame"));
			int idAzienda = Integer.parseInt(request.getParameter("idAzienda"));
			int idPaziente = Integer.parseInt(request.getSession().getAttribute("id").toString());
			
			Calendar dataPrenotazione = Calendar.getInstance();		
			Prenotazione prenotazione = new Prenotazione(0,idAzienda,idEsame,null,idPaziente,dataPrenotazione,0,null);	
			String[] a = request.getParameter("dataEsame").split("-");
			Calendar c = new GregorianCalendar(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
			prenotazione.setDataEsame(c);
			
				
			try {
				DAOPrenotazione.prenotaEsame(prenotazione);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("homePageUtente.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
	}

}
