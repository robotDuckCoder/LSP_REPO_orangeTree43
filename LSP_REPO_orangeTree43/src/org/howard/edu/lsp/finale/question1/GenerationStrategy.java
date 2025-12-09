package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/*
 * Strategy interface to make sure that all strategies have the same method signature
 * Additionally implements reused code from across strategies
 */
public interface GenerationStrategy {
	abstract public String generatePassword(int length); 
	
	/*
	 * @param length : length of password
	 * @param allowed : characters allowed in password
	 * @param r : random number generator
	 * @return password
	 */
	default String makePassword(int length, String allowed, Random r) {
		String returnStr = "";
		for(int i = 0; i < length; i++) {
			int index = r.nextInt(allowed.length());
			char c = allowed.charAt(index);
			returnStr += c;
		}
		return returnStr;
	}
}