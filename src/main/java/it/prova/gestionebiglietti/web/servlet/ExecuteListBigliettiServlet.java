package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebiglietti.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteListArticoliServlet
 */
@WebServlet("/ExecuteListBigliettiServlet")
public class ExecuteListBigliettiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteListBigliettiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//torniamo la lista di Biglietti a result.jsp
		//Quindi settiamo come attributo La lista
		try {
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listaTutti());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);

	}



}
