package no.hvl.dat108;

import java.io.IOException;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Test.Validator;

@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
	private DeltagerDAO deltagerDAO;
    
    Validator validator = new Validator();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		
		boolean feil = true;
		Cookie innlogget = null;
		
		try {
			innlogget = Arrays.stream(request.getCookies()).filter(c -> c.getName()
						.equalsIgnoreCase("brukernavn")).findAny().get();
		} catch(Throwable e) {}
			
		
		feil = (boolean) request.getSession().getAttribute("feil");
		
		
		if(feil || innlogget == null) {
			request.getRequestDispatcher("/WEB-INF/paameldingsskjema.jsp").forward(request, response);			
		}
		else {
			request.getRequestDispatcher("PaameldingsBekreftelseServlet").forward(request, response);			

		}
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");
	
		request.getSession().invalidate();
		
		
		Boolean feil = false;
		
		
		if(!validator.fornavnSjekk(fornavn)) {
			
			request.getSession().setAttribute("fornavnFeilmelding", "Ugyldig fornavn");
			feil = true;
		} else {
			request.getSession().setAttribute("fornavn", fornavn);
		}
		
		if(!validator.etternavnSjekk(etternavn)) {
			
			request.getSession().setAttribute("etternavnFeilmelding", "Ugyldig etternavn");
			feil = true;
		} else {
			request.getSession().setAttribute("etternavn", etternavn);
		}
		
		if(!validator.mobilSjekk(mobil)) {
			
			request.getSession().setAttribute("mobilFeilmelding", "Ugyldig mobilnummer");
			feil = true;
		} else {
			request.getSession().setAttribute("mobil", mobil);
		}
		
		if(!validator.passordSjekk(passord)) {
			
			request.getSession().setAttribute("passordFeilmelding", "Ugyldig passord");
			feil = true;
		} else {
			request.getSession().setAttribute("passord", passord);
		}
		
		if(!(passordRepetert.equals(passord))) {
			
			request.getSession().setAttribute("passordRepetertFeilmelding", "Passord må være like");
			feil = true;
		} else {
			request.getSession().setAttribute("passordRepetert", passordRepetert);
		}
		
		if(!(kjonn != null)) {
				
			request.getSession().setAttribute("kjonnFeilmelding", "Du må velge kjønn");
			feil = true;		
		} 	
		
		if(!feil) {
		Deltager nyDeltager = new Deltager(fornavn, etternavn, Integer.parseInt(mobil), passord, kjonn);
		
		try {
			
		deltagerDAO.lagreNyDeltager(nyDeltager);
		Cookie innlogget = new Cookie("brukernavn", mobil);
		innlogget.setMaxAge(30);
		response.addCookie(innlogget);

		} catch (Throwable e){
			
			feil = true;
			request.getSession().setAttribute("mobilFeilmelding", "Deltager med dette nummeret finnes allerede");
		}
	}	
		
		request.getSession().setAttribute("feil", feil);
		response.sendRedirect("PaameldingServlet");

	}

}
