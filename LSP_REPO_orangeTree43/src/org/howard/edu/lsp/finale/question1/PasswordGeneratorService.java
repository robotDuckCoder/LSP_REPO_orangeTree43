package org.howard.edu.lsp.finale.question1;

/*
 * PART C ANSWER:
 * 
 * I used the strategy and singleton design patterns.
 * 
 * The strategy design pattern was appropriate because it allows for a stored object to represent the current algorithm in use.
 * Additionally it also allows for the algorithm used to generate a password to be swapped at runtime, which were both design specifications for this project.
 * It also allows for algorithm expansion in the future, where the client code will not need to be modified. To do so one would just have to add a new class that implements GenerationStrategy and add a new else if checking for the new name in setAlgorithm.
 * 
 * The singleton design pattern was appropriate because it allows for only one instance of the PasswordGeneratorService to exist. This exactly follows the design specification "Only one instance of the service may exist."
 */

public class PasswordGeneratorService {
	static PasswordGeneratorService instance = null;
	GenerationStrategy currentStrategy = null;
	
	//singleton structure which means that constructor should be private
	private PasswordGeneratorService() {
		
	}
	
	/*
	 * @return returns singleton instance of PasswordGeneratorService
	 */
	public static PasswordGeneratorService getInstance() {
		if(instance == null) {
			instance = new PasswordGeneratorService();	
		}
		return instance;
	}
	
	/*
	 * @param name : name of a specific password generation strategy
	 */
	public void setAlgorithm(String name) {
		if(name == "basic") {
			currentStrategy = new BasicGenerationStrategy();
		}
		else if(name == "enhanced") {
			currentStrategy = new EnhancedGenerationStrategy();
		}
		else if(name == "letters") {
			currentStrategy = new LettersGenerationStrategy();
		}
		else {
			currentStrategy = null;
		}
	}
	
	/*
	 * @param length : length of password
	 * @return returns password generated with current password generation strategy
	 */
	public String generatePassword(int length) {
		if(currentStrategy == null) {
			throw new IllegalStateException("Error, strategy not set.");
		}
		return currentStrategy.generatePassword(length);
	}
}
