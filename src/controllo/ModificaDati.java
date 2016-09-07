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
import persistenza.dao.DAOCitta;
import persistenza.dao.DAOPaziente;
import utilita.Verifica;

/**
 * Servlet implementation class ModificaPaziente
 */
@WebServlet("/ModificaDati")
public class ModificaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaDati() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("id") == null) {

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("listaCitta", DAOCitta.getAll());

			Paziente paziente = DAOPaziente
					.getPazienteById(Integer.parseInt(request.getSession().getAttribute("id").toString()));
			paziente.setPassword(null);

			System.out.println(paziente);

			request.setAttribute("paziente", paziente);
			RequestDispatcher rd = request.getRequestDispatcher("modificaDati.jsp");
			rd.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int check = 0;

		if (request.getSession().getAttribute("id") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}

		int idPaziente=Integer.parseInt(request.getSession().getAttribute("id").toString());
		Paziente paziente = new Paziente();
		paziente.setIdPaziente(idPaziente);
		paziente.setNome(request.getParameter("nome"));
		paziente.setCognome(request.getParameter("cognome"));
		paziente.setDataNas(request.getParameter("dataNascita"));
		paziente.setIdCitta(Integer.parseInt(request.getParameter("idCitta")));
		paziente.setSesso((request.getParameter("sesso")));
		paziente.setCf(request.getParameter("cf"));
		paziente.setIndirizzo(request.getParameter("indirizzo"));
		boolean[] errore = Verifica.verificaPaziente(paziente, false);

		request.getSession().setAttribute("paziente", paziente);

		if (errore[0] == true) {	//Errore inserimento dati
			request.setAttribute("listaCitta", DAOCitta.getAll());
			request.setAttribute("errore", errore);
			RequestDispatcher rd = request.getRequestDispatcher("modificaDati.jsp");
			rd.forward(request, response);
			return;
		}
		
		try {	//Aggiorna database
			System.out.println("dati inviati a ModificaDati.java");
			System.out.println(paziente);
			check = DAOPaziente.cambiaDati(paziente);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (check == 0) {	//Fallito update database
			request.setAttribute("listaCitta", DAOCitta.getAll());
			RequestDispatcher rd = request.getRequestDispatcher("modificaDati.jsp");
			rd.forward(request, response);
		} else {	//Dati aggiornati, torno alla HP
			request.setAttribute("nome", paziente.getNome() + " " + paziente.getCognome());
			RequestDispatcher rd = request.getRequestDispatcher("homePageUtente.jsp");
			rd.forward(request, response);
		}

	}

}
