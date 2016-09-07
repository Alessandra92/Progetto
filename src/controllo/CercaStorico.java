package controllo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modello.Paziente;
import persistenza.DAOTabellaPrenotazioniInterface;
import persistenza.dao.DAOCitta;
import persistenza.dao.DAOPaziente;
import persistenza.dao.DAOTabellaPrenotazioni;

/**
 * Servlet implementation class CercaStorico
 */
@WebServlet("/CercaStorico")
public class CercaStorico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaStorico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getSession().getAttribute("id") == null)
	{
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			}
		else {
			
			ArrayList<modello.TabellaPrenotazioni> storicoPrenotazione = DAOTabellaPrenotazioni.getStoricoPaziente(Integer.parseInt(request.getSession().getAttribute("id").toString()));
			request.getSession().setAttribute("storico", storicoPrenotazione);
			RequestDispatcher rd = request.getRequestDispatcher("storicoPrenotazioni.jsp");
			rd.forward(request, response);
		   
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
