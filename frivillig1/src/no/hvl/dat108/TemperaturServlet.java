package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Temperaturomregning")
public class TemperaturServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ValidatorSimple validator = new ValidatorSimple();

		String temperatur = request.getParameter("temperatur");

		String legend = "Temperaturomregning Feilmelding";
		String ledge = "Temperaturomregning resultat";
		

		String feilmelding = "Ugjyldig brukerinput. Temperaturen må være et tall(lik eller over"
				+ " det absolutte nullpunkt). Pass også på at du har valgt en av omregningene"
				+ "før du trykker regn om";
		String responsmelding = feilmelding;
		
		
		if (!validator.isValidTemperature(temperatur)) {

			responsmelding = feilmelding;

		} else {

			String valg = request.getParameter("temp");
			double tempDouble = Double.parseDouble(temperatur);

			if (valg.equals("celsius")) {

				if (validator.erCelsius(tempDouble)) {

					double fahrenheit = (9.0 / 5.0) * tempDouble + 32;
					legend = ledge;
					responsmelding = "Temperaturen din i Fahrenheit er: " + fahrenheit;
				}
			} else if (valg.equals("fahrenheit")) {

				if (validator.erFahrenheit(tempDouble)) {

					double celsius = (5.0 / 9.0) * (tempDouble - 32);
					legend = ledge;
					responsmelding = "Temperaturen din i Celsius er: " + celsius;
				}
			} else {
				responsmelding = feilmelding;
			}
		}

		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Kvittering</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<legend>" + legend + "<legend>");
		out.println("<p>" + responsmelding + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
