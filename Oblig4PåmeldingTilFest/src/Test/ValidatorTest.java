package Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class ValidatorTest {

	
	public Validator validator = new Validator();
	
	@Test
	public void fornavn() {
		assertFalse(validator.fornavnSjekk("E"));
	}
	
	@Test
	public void fornavn2() {
		assertTrue(validator.fornavnSjekk("Ø ys-tein "));
	}
	
	@Test
	public void fornavn3() {
		assertFalse(validator.fornavnSjekk("øystein"));
	}
	
	@Test
	public void etternavn() {
		assertFalse(validator.etternavnSjekk("Ø ystein"));
	}
	
	@Test
	public void mobil() {
		assertFalse(validator.mobilSjekk("45"));
	}
	
	@Test
	public void mobil2() {
		assertTrue(validator.mobilSjekk("45459856"));
	}
	
	@Test
	public void passord() {
		assertFalse(validator.passordSjekk("ayy"));
	}
	
	@Test
	public void passord2() {
		assertTrue(validator.passordSjekk("ayylmao23-?=[]56"));
	}
}
