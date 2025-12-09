package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

public class EnhancedGenerationStrategy implements GenerationStrategy {
	/*
	 * @param length : length of password
	 * @return uses default makePassword method from GenerationStrategy
	 * 
	 * note the use of SecureRandom
	 */
	@Override
	public String generatePassword(int length) {
		String allowed =
			    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
			    "abcdefghijklmnopqrstuvwxyz" +
			    "0123456789";
		SecureRandom s = new SecureRandom();
		
		return makePassword(length, allowed, s);
	}
	
}
