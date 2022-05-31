package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietti.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteArticoloServlet
 */
@WebServlet("/ExecuteDeleteArticoloServlet")
public class ExecuteDeleteArticoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteDeleteArticoloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idBigliettoParam = request.getParameter("idBiglietto");
		if (!NumberUtils.isCreatable(idBigliettoParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getBigliettoServiceInstance().rimuovi(MyServiceFactory.getBigliettoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idBigliettoParam)));

			// setto come parametro la lista con i dati aggiornati
			request.setAttribute("listaBigliettiAttribute",
					MyServiceFactory.getBigliettoServiceInstance().listaTutti());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}

}
