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

/**
 * Servlet implementation class listaAziende
 */
@WebServlet("/ListaAziende")
public class ListaAziende extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaAziende() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("id")!= null){
			System.out.println(Integer.parseInt(request.getParameter("citta")));
			request.setAttribute("listaAziende", DAOAzienda.getAziendaByCitta(Integer.parseInt(request.getParameter("citta"))));
			System.out.println( DAOCitta.getCittaById(Integer.parseInt(request.getParameter("citta"))).getNome());
			request.setAttribute("cit", DAOCitta.getCittaById(Integer.parseInt(request.getParameter("citta"))).getNome());
			RequestDispatcher rd = request.getRequestDispatcher("scegliAzienda.jsp");
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
