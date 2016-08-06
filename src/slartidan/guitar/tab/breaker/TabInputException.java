package slartidan.guitar.tab.breaker;

/**
 * If the input cannot be read
 */
public class TabInputException extends RuntimeException {

	/**
	 * @param message the reason text
	 */
	public TabInputException(String message) {
		super(message);
	}

}
