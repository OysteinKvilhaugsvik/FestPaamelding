package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import no.hvl.dat108.ValidatorSimple;

public class ValidatorTest {


	private ValidatorSimple validator = new ValidatorSimple();
	
	@Test
	public void nullStringIsInvalidStudentId() {
		assertFalse(validator.isValidTemperature(null));
	}
	
	@Test
	public void emptyStringIsInvalidStudentId() {
		assertFalse(validator.isValidTemperature(""));
	}
	
	@Test
	public void sixNumbersIsInvalidStudentId() {
		assertFalse(validator.isValidTemperature("123456"));
	}

	@Test
	public void hPlusSixNumbersIsValidStudentId() {
		assertTrue(validator.isValidTemperature("34.45"));
	}
	
	@Test
	public void NumbersIsInvalidStudentId() {
		assertFalse(validator.isValidTemperature("   "));
	}
		
	@Test
	public void ayyIsInvalidStudentId() {
		assertFalse(validator.isValidTemperature("45. "));
	}
	
	}
	
	

