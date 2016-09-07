package controllo;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenza.dao.DAOPrenotazione;

/**
 * Servlet implementation class HomePageUtente
 */
@WebServlet("/HomePageUtente")
public class HomePageUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("id")!= null){
			int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
			Calendar data = new GregorianCalendar();
			int number = DAOPrenotazione.getPrenotazioniGiornoPaziente(id, data).size();
			request.setAttribute("esami", number);
			RequestDispatcher rd = request.getRequestDispatcher("homePageUtente.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}


}
