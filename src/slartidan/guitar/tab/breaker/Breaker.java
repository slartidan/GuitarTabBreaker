package slartidan.guitar.tab.breaker;

import java.util.logging.Logger;

/**
 * Starting class for line breaker tool
 */
public class Breaker {
	
	public static final Logger LOG = Logger.getLogger(Breaker.class.getName());
	
	private Breaker() {
		
	}
	
	/**
	 * starter
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		new Song();
	}

}
