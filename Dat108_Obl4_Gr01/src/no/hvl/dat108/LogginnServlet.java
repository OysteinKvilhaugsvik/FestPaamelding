package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Test.Validator;

/**
 * Servlet implementation class logginnServlet
 */
@WebServlet("/LogginnServlet")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private Validator validator = new Validator();
	
	@EJB
	private DeltagerDAO deltagerDAO;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String feil = (String)request.getSession().getAttribute("logginnfeil");
		
		if(feil != null) {
			
			request.getSession().invalidate();
			request.setAttribute("logginnfeil", "Ugyldig brukernavn og/eller passord");
		}
		
		request.getRequestDispatcher("/WEB-INF/logginn.jsp").forward(request, response);
	} 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		boolean logginn = false;
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		Deltager deltager = null;
		
		if(validator.mobilSjekk(mobil) && validator.passordSjekk(passord)) {
			
			deltager = deltagerDAO.hentDeltager(Integer.parseInt(mobil));
		}
		
		if(deltager != null) {

			logginn = BCrypt.checkpw(passord, deltager.getPassord());
		}
		
		if(logginn) {
			
			Cookie innlogget = new Cookie("brukernavn", mobil);
			innlogget.setMaxAge(30);
			response.addCookie(innlogget);
			response.sendRedirect("DeltagerlisteServlet");
		}
		
		else {
			
			request.getSession().setAttribute("logginnfeil", "true");
			response.sendRedirect("LogginnServlet");

		}
			
	}

}
