package controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenza.dao.DAOAzienda;
import persistenza.dao.DAOCitta;
import persistenza.dao.DAOTabellaPrenotazioni;

/**
 * Servlet implementation class PrenotazioniAttive
 */
@WebServlet("/PrenotazioniAttive")
public class PrenotazioniAttive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioniAttive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getSession().getAttribute("id")!= null){
		
			request.setAttribute("listaPrenotazioniAttive", DAOTabellaPrenotazioni.getPrenotazioniAttive(Integer.parseInt(request.getSession().getAttribute("id").toString())));
			
//			request.setAttribute("listaAziende", DAOAzienda.getAziendaByCitta(Integer.parseInt(request.getParameter("citta"))));

			
			RequestDispatcher rd = request.getRequestDispatcher("prenotazioniAttive.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
