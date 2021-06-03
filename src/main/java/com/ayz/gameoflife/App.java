package com.ayz.gameoflife;

import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) {   
    	
    	LOGGER.info("App started...");  
    	
    	// declare variables
    	
    	SecureRandom secureRandom = new SecureRandom();
    	
    	int testCases = secureRandom.nextInt(1000);
    	   	
    	LOGGER.info("Test cases : {}", testCases);
    	    	    	
    	for (int i = 0; i < testCases; i++) {
    		
    		int n = secureRandom.nextInt(15);
    		
    		int m = secureRandom.nextInt(5);
    		
    		LOGGER.info("n : {} - m: {}", n, m);
    		
    		String life = genData(secureRandom, n);
    	    		
    		LOGGER.info("Data : {}", life);
    		    		    		
    		for (int j = 0; j < m; j++) {
    			
    			int k = 0;
    			
    			StringBuilder output = new StringBuilder(n);
    			
    			while(k < life.length()) {
    				
    				LOGGER.debug("k = {} - Char = {}", k, life.charAt(k));
    				
    				if (k == 0) {
    					if (life.charAt(k) == '0' && life.charAt(k + 1) == '1') {
    						output.append('1');
    					} else {
    						output.append(life.charAt(k));
    					}
    				} else if (k == life.length() - 1) {
    					if (life.charAt(k) == '0' && life.charAt(k - 1) == '1') {
    						output.append('1');
    					} else {
    						output.append(life.charAt(k));
    					}
    				} else {
    					if (life.charAt(k) == '0' && (life.charAt(k + 1) == '1' || life.charAt(k - 1) == '1')) {
    						output.append('1');
    					} else {
    						output.append(life.charAt(k));
    					}
    				}
    				    				    				
    				k++;    				
    			}
    			
    			life = output.toString();
    			
    			LOGGER.debug("Iteration {} - Output : {}", j+1, output);    		    			
    		}
    		
    		LOGGER.info("Life : {}", life); 
    		
    	}
    	
    }
    
    /**
     * generate a string of 0 or 1.
     * @param secureRandom
     * @param length
     * @return
     */
    public static String genData(SecureRandom secureRandom, int length) {    	
    	
    	String characters = "01";
    	
    	StringBuilder builder = new StringBuilder(length);
    	    	
    	for (int i = 0; i < length; i++)
    		builder.append(characters.charAt(secureRandom.nextInt(characters.length())));
    	
    	return builder.toString();
    }
        
}
