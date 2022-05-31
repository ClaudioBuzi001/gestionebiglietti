package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietti.model.Biglietto;
import it.prova.gestionebiglietti.service.MyServiceFactory;
import it.prova.gestionebiglietti.web.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteUpdateBigliettoServlet
 */
@WebServlet("/ExecuteUpdateBigliettoServlet")
public class ExecuteUpdateBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteUpdateBigliettoServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String provenienzaInput = request.getParameter("provenienza");
		String destinazioneInput = request.getParameter("destinazione");
		String prezzoInput = request.getParameter("prezzo");
		String dataInput = request.getParameter("data");

		// metto id
		String idInput = request.getParameter("idBiglietto");

		// Mi creo un bean per verificare la validita dei dati
		Biglietto bigliettoInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaInput,
				destinazioneInput, prezzoInput, dataInput);

		// Valida id
		if (!NumberUtils.isCreatable(idInput)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// set id
		bigliettoInstance.setId(Long.parseLong(idInput));

		// valida se crearte bigliettto

		if (!UtilityBigliettoForm.validateBigliettoBean(bigliettoInstance)) {
			request.setAttribute("biglietto_modificare", bigliettoInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/biglietto/edit.jsp").forward(request, response);
			return;

		}
		/// aggiorna e lista
		try {
			MyServiceFactory.getBigliettoServiceInstance().aggiorna(bigliettoInstance);

			request.setAttribute("listaBigliettiAttribute",
					MyServiceFactory.getBigliettoServiceInstance().listaTutti());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// forward
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);

	}

}
