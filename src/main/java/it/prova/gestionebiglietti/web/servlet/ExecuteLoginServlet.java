package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebiglietti.model.Utente;



/**
 * Servlet implementation class ExecuteLoginServlet
 */
@WebServlet("/ExecuteLoginServlet")
public class ExecuteLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteLoginServlet() {
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

		String loginInput = request.getParameter("inputUsername");
		String passwordInput = request.getParameter("inputPassword");
		
	
		if(loginInput.equals("user") && passwordInput.equals("user")) {
			request.getSession().setAttribute("userInfo", new Utente(loginInput, passwordInput, "Classic", "User"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		request.setAttribute("messaggio", "Credenziali errate");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	

}
