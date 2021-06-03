package Test;

public class Validator {
	
	//Skal begynne med stor bokstav, godtar alle bokstaver, bindestrek og mellomrom
	//Skal ha lengde på 2-20
	public boolean fornavnSjekk(String s) {
		
		return s != null && s.matches("^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ_ ]{2,20}$");
	}
	
	//Samme som fornavn, men ingen mellomrom
	public boolean etternavnSjekk(String s) {
		
		return s != null && s.matches("^[A-ZÆØÅ][-a-zA-ZæøåÆØÅ]{2,20}$");
	}
	
	//godtar bare siffer, skal ha lengde på 8
	public boolean mobilSjekk(String s) {
		
		return s != null && s.matches("^[0-9]{8}$");
	}
	
	//Godtar alt, minimumlengde på 8
	public boolean passordSjekk(String s) {
		
		return s != null && s.matches("^.{8,}$");
	}
}
