package controllo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modello.Azienda;
import modello.Paziente;
import persistenza.dao.DAOAzienda;
import persistenza.dao.DAOPaziente;

/**
 * Servlet implementation class ModificaPassword
 */
@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sessione = request.getSession();
		if (sessione.getAttribute("id") != null) { // sessione aperta
			RequestDispatcher rd = request.getRequestDispatcher("cambiaPwd.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessione = request.getSession();
		if (sessione.getAttribute("id") != null) { // sessione aperta
			System.out.println("Sessione valida");
			if (sessione.getAttribute("tipo").equals("p")) { // tipo paziente
				String vecchia = request.getParameter("vecchiaPassword");
				String nuova = request.getParameter("password");
				String nuovaConf = request.getParameter("confirmPassword");
				
				int id = (Integer) sessione.getAttribute("id");
				Paziente paz = DAOPaziente.getPazienteById(id);
				
				if(nuova==null||nuovaConf==null||(!nuova.equals(nuovaConf))){ //pass nuove non corrispondono o campi non settati
					request.setAttribute("erroreDiverse", "erroreDiverse");
					RequestDispatcher rd = request.getRequestDispatcher("cambiaPwd.jsp");
					rd.forward(request, response);
					return;
				}
				if (paz.getPassword().equals(vecchia)) { // le pass vecchie corrispondono
					paz.setPassword(nuova);
					try {
						int controllo = DAOPaziente.update(paz); // aggiorno
																	// paziente
						if (controllo < 1) {
							request.setAttribute("erroreDB", "erroreDB");   //errore del DB
							RequestDispatcher rd = request.getRequestDispatcher("cambiaPwd.jsp");
							rd.forward(request, response);
							return;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RequestDispatcher rd = request.getRequestDispatcher("homePageUtente.jsp");
					rd.forward(request, response);
				} else { // vecchie password non corrispondono
					request.setAttribute("errore", "errore");
					RequestDispatcher rd = request.getRequestDispatcher("cambiaPwd.jsp");
					rd.forward(request, response);
				}
			return;}
			if (sessione.getAttribute("tipo").equals("a")) { // tipo azienda
				String vecchia = request.getParameter("vecchiaPassword");
				String nuova = request.getParameter("password");
				int id = (Integer) sessione.getAttribute("id");
				Azienda azi = DAOAzienda.getAziendaById(id);
				if (azi.getPassword().equals(vecchia)) { // le pass vecchie
															// corrispondono
					azi.setPassword(nuova);
					try {
						DAOAzienda.update(azi); // aggiorno azienda
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RequestDispatcher rd = request.getRequestDispatcher("HomePageAzienda.jsp");
					rd.forward(request, response);
				} else { // vecchie password non corrispondono
					request.setAttribute("errore", "errore");
					RequestDispatcher rd = request.getRequestDispatcher("cambiaPwd.jsp");
					rd.forward(request, response);
				}
			return;}
		} else {// sessione non valida
			System.out.println("sessione non valida");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}
}