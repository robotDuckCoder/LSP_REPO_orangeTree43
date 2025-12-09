package org.howard.edu.lsp.finale.question1;

import java.util.Random;

public class BasicGenerationStrategy implements GenerationStrategy {
	/*
	 * @param length : length of password
	 * @return uses default makePassword method from GenerationStrategy
	 */
	@Override
	public String generatePassword(int length) {
		String digits = "0123456789";
		Random r = new Random();
		
		return makePassword(length, digits, r);
	}
	
}
