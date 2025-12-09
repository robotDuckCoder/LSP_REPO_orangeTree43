package org.howard.edu.lsp.finale.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * @link{PasswordGeneratorService}
 * test cases for PasswordGeneratorService
 */
public class PasswordGeneratorServiceTest {

    private PasswordGeneratorService service;

    @BeforeEach
    public void setup() {
        service = PasswordGeneratorService.getInstance();
    }

    // verify that service is not null
    @Test
    public void checkInstanceNotNull() {
    	assertTrue(service != null);
    }

    //verifies that singleton behavior is being followed, i.e. there is only one instance
    @Test
public void checkSingleInstanceBehavior() {
PasswordGeneratorService second = PasswordGeneratorService.getInstance();
		assertTrue(service == second);
    }

    // verify correct exception behavior
    @Test
    public void generateWithoutSettingAlgorithmThrowsException() {
        PasswordGeneratorService s = PasswordGeneratorService.getInstance();
        assertThrows(IllegalStateException.class, ()->{
        	s.generatePassword(10);
        });
    }

    // makes sure that basic passwords generate properly
    @Test
    public void basicAlgorithmGeneratesCorrectLengthAndDigitsOnly() {
        service.setAlgorithm("basic");
        String p = service.generatePassword(10);
        assertTrue(p.length() == 10);
        String allowed = "0123456789";
        for(int i = 0; i < p.length(); i++) {
        	assertTrue(allowed.indexOf(p.charAt(i)) != -1);
        }
    }

    // makes sure that enhanced passwords generate properly
    @Test
    public void enhancedAlgorithmGeneratesCorrectCharactersAndLength()     {
        service.setAlgorithm("enhanced");
        String p = service.generatePassword(12);
        assertTrue(p.length() == 12);
        String allowed = "abcdefghijklmnopqrstuvwxyz"
        		+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        		+ "0123456789";
        for(int i = 0; i < p.length(); i++) {
        	assertTrue(allowed.indexOf(p.charAt(i)) != -1);
        }
    }

    // makes sure that letter passwords generate properly
    @Test
    public void lettersAlgorithmGeneratesLettersOnly() {
        service.setAlgorithm("letters");
        String p = service.generatePassword(8);
        assertTrue(p.length() == 8);
        String allowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < p.length(); i++) {
        	assertTrue(allowed.indexOf(p.charAt(i)) != -1);
        }
    }

    // makes sure that all passwords generate properly and that we can properly switch between them
    @Test
    public void switchingAlgorithmsChangesBehavior() {
        service.setAlgorithm("basic");
        String p1 = service.generatePassword(10);

        service.setAlgorithm("letters");
        String p2 = service.generatePassword(10);

        service.setAlgorithm("enhanced");
        String p3 = service.generatePassword(10);

        // verify correct behavior characteristics of each algorithm
        assertTrue(p1.length() == 10);
        String allowed = "0123456789";
        for(int i = 0; i < p1.length(); i++) {
        	assertTrue(allowed.indexOf(p1.charAt(i)) != -1);
        }
        
        assertTrue(p2.length() == 10);
        allowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < p2.length(); i++) {
        	assertTrue(allowed.indexOf(p2.charAt(i)) != -1);
        }
        
        assertTrue(p3.length() == 10);
        allowed = "abcdefghijklmnopqrstuvwxyz"
        		+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        		+ "0123456789";
        for(int i = 0; i < p3.length(); i++) {
        	assertTrue(allowed.indexOf(p3.charAt(i)) != -1);
        }
    }
}
