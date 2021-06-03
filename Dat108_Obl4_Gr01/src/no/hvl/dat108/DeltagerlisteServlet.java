package no.hvl.dat108;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeltagerlisteServlet")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DeltagerDAO deltagerDAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		
			
		List<Deltager> deltagere = deltagerDAO.hentAlleDeltagere();
		
		Cookie innlogget = null;
		
		try {
			innlogget = Arrays.stream(request.getCookies()).filter(c -> c.getName().equalsIgnoreCase("brukernavn")).findAny().get();
		}
		catch(NoSuchElementException e) {}
		
		if(innlogget == null) {
			
			response.sendRedirect("PaameldingServlet");
		}
		
		else {
			
			request.setAttribute("brukernavn", innlogget.getValue());
			request.setAttribute("deltagere", deltagere);
			request.getRequestDispatcher("/WEB-INF/deltagerliste.jsp").forward(request, response);
		}	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("DeltagerlisteServlet");
	}

}
