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
 * Servlet implementation class PrepareModificaBigliettoServlet
 */
@WebServlet("/PrepareModificaBigliettoServlet")
public class PrepareModificaBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrepareModificaBigliettoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// prendo l Id,
		String idBigliettoParam = request.getParameter("idBiglietto");
		// vedo se è creabile
		if (!NumberUtils.isCreatable(idBigliettoParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// Carico come attributo il singolo elemento
		try {
			request.setAttribute("biglietto_modificare", MyServiceFactory.getBigliettoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idBigliettoParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// foward
		request.getRequestDispatcher("/biglietto/edit.jsp").forward(request, response);
	}

}
