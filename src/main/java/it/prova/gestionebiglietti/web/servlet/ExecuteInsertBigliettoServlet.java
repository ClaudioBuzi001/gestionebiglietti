package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebiglietti.model.Biglietto;
import it.prova.gestionebiglietti.service.MyServiceFactory;
import it.prova.gestionebiglietti.web.utility.UtilityBigliettoForm;

/**
 * Servlet implementation class ExecuteInsertBigliettoServlet
 */
@WebServlet("/ExecuteInsertBigliettoServlet")
public class ExecuteInsertBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteInsertBigliettoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//binding dati
		String provenienzaInput = request.getParameter("provenienza");
		String destinazioneInput = request.getParameter("destinazione");
		String prezzoInput = request.getParameter("prezzo");
		String dataInput= request.getParameter("data");
		
		//Mi creo un bean per verificare la validita dei dati
		Biglietto bigliettoInstance = UtilityBigliettoForm.createBigliettoFromParams(provenienzaInput, destinazioneInput, prezzoInput, dataInput);
		
		//verifico che la validazione sia OK
		if(!UtilityBigliettoForm.validateBigliettoBean(bigliettoInstance)) {
			request.setAttribute("insert_biglietto_attr", bigliettoInstance);
			request.setAttribute("errorMessage", "Attenzione, sono presenti errori di validazione");
			request.getRequestDispatcher("/biglietto/insert.jsp").forward(request, response);
			return;
		}
		
		//Se sono qui vuol dire che la validazione è andata ok
		
		try {
			MyServiceFactory.getBigliettoServiceInstance().inserisciNuovo(bigliettoInstance);
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listaTutti());
			request.setAttribute("successMessage", "Operazione Effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);

	}

}
