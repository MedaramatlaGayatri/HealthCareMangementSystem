package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationTest {

	@Test
	void testCheckPassword() {
		Validation validation  = new Validation();
		assertEquals(true, validation.checkPassword("John@123", "John@123"));
	}

}
