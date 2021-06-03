package Test;

public class Validator {
	
	//Skal begynne med stor bokstav, godtar alle bokstaver, bindestrek og mellomrom
	//Skal ha lengde p� 2-20
	public boolean fornavnSjekk(String s) {
		
		return s != null && s.matches("^[A-Z���][-a-zA-Z������_ ]{2,20}$");
	}
	
	//Samme som fornavn, men ingen mellomrom
	public boolean etternavnSjekk(String s) {
		
		return s != null && s.matches("^[A-Z���][-a-zA-Z������]{2,20}$");
	}
	
	//godtar bare siffer, skal ha lengde p� 8
	public boolean mobilSjekk(String s) {
		
		return s != null && s.matches("^[0-9]{8}$");
	}
	
	//Godtar alt, minimumlengde p� 8
	public boolean passordSjekk(String s) {
		
		return s != null && s.matches("^.{8,}$");
	}
}
