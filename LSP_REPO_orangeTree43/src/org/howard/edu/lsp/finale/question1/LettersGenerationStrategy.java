package org.howard.edu.lsp.finale.question1;

import java.util.Random;

public class LettersGenerationStrategy implements GenerationStrategy{
	/*
	 * @param length : length of password
	 * @return uses default makePassword method from GenerationStrategy
	 */
	@Override
	public String generatePassword(int length) {
		String allowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		
		return makePassword(length, allowed, r);
	}}
