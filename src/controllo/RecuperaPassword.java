package controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenza.dao.DAOAzienda;
import persistenza.dao.DAOPaziente;
import utilita.SendMail;
import utilita.Verifica;

/**
 * Servlet implementation class RecuperaPassword
 */
@WebServlet("/RecuperaPassword")
public class RecuperaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int s=0;
		if (request.getParameter("email").equals(""))
		{
			System.out.println("vuota");
			request.setAttribute("vuota", true);
			RequestDispatcher rd = request.getRequestDispatcher("recuperaPwd.jsp");
			rd.forward(request, response);
			
			
		}
		else if (!Verifica.ValiditaEmail(request.getParameter("email"))){
			
			System.out.println("errata");
			request.setAttribute("errata", true);
			RequestDispatcher rd = request.getRequestDispatcher("recuperaPwd.jsp");
			rd.forward(request, response);
		}
		else{
			String risA=DAOAzienda.getPassword(request.getParameter("email"));
			String risP=DAOPaziente.getPassword(request.getParameter("email"));
			if(risA!=null){
				s=2;
				String [] to = new String[]{request.getParameter("email")};
				SendMail.sendFromGMail(to, "Recupero Password", "La tua password è: "+risA, request, response);
				System.out.println("Inviata");
				RequestDispatcher rd = request.getRequestDispatcher("recuperaPwd.jsp");
				rd.forward(request, response);
			}
			else if(risP!=null){
				s=2;
				String [] to = new String[]{request.getParameter("email")};
				SendMail.sendFromGMail(to, "Recupero Password", "La tua password è: "+risP, request, response);
				System.out.println("Inviata");
				RequestDispatcher rd = request.getRequestDispatcher("recuperaPwd.jsp");
				rd.forward(request, response);
				}
			else{
				System.out.println("utente inesistente");
			}
		}		
	}

}
